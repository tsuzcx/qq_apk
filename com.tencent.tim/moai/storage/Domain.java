package moai.storage;

import android.content.ContentValues;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.FluentIterable;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import moai.io.Hashes;
import moai.proxy.JavaBeanProxy;

/**
 * <h3>存储模型基类，其子类自动生成。</h3>
 *
 * <p>建立这样一个模型的初衷是为了解决一些机械化的工作，比如保存的时候编写 {@code INSERT} 语句里大量的问号，
 * 比如查询的时候得到一个 {@link Cursor} 总需要一个字段一个字段抄写到对象里（参照以前 Mail 的 fillMail，
 * fillFolder）。</p>
 *
 * <p>另外一方面，规范存储模型和关联关系，有助于在存储层进行统一处理缓存和监控等细节。</p>
 *
 * <p>再者，这些对象都会生成符合 JavaBean 规范的 setter/getter ，直接接入我们网络层各种 Service，有助于形成
 * 一套良好的 网络=>存储/缓存=>查询 一体化的方案。</p>
 *
 * <p>这样做在项目初期经常变更的时候可以减少大量的机械劳动，后期也有助于批量整体调优。</p>
 *
 * <p>为了达到这样的目标，有一些特殊的约定，简单整理为以下几点：</p>
 *
 * <ol>
 * <li>表名/表结构 和 类名/类属性 一一对应</li>
 * <li>对于关联关系的处理：<ol>
 *     <li>1:1 采取直接存存储主键（一般都是 {@code getId()})。</li>
 *     <li>N:M 采取辅助建立关联关系表，在增删改的时候同步修改关系表。</li>
 * </ol></li>
 * <li>查询的时候，需要构造特殊的SQL语句才能正确转换，详见 {@link #convertFrom(Cursor)}</li>
 * <li>对于主键的约束，需要在协议约定由哪些字段Hash生成，如果没有主键会尝试自动生成。</li>
 * </ol>
 *
 * <p>每个类都由一些共用的静态属性/方法，不能放在基类，用于辅助构造对应的SQL：</p>
 *
 * <ol>
 * <li>所有的字段都符合 JavaBean 规范，通过 getter/setter 访问</li>
 * <li><code>createTable(SQLiteDatabase)</code> 创建表</li>
 * <li><code>dropTable(SQLiteDatabase)</code> 删除表</li>
 * <li><code>tableName</code> 表名</li>
 * <li><code>fieldNameBook</code> fieldName 开头的都是字段名</li>
 * <li><code>getAllQueryFields()</code> 生成查找整个表的语句</li>
 * <li><code>getQueryFields(String...)</code> 生成查找部分列的语句</li>
 * </ol>
 */
@SuppressWarnings("JavaDoc")
public abstract class Domain implements Convertable, Cloneable {
    public abstract <T extends Domain> void cloneFrom(T object);

    /**
     * <p>将当前的对象转换为 {@link ContentValues}，用于增删改操作。</p>
     *
     * <p>对于 {@code JOIN} 表字段，保留其主键，一般是 {@code getId()}。</p>
     *
     * <p>对于 1:M 的字段，不会放入 {@link ContentValues} 里。</p>
     *
     * <p>但是如果调用 {@link #updateAll(SQLiteDatabase)} 的话，能够正确保存到指定的表里，并保存对应关系表</p>
     */
    public abstract ContentValues convertTo();

    /**
     * 替换融合的attr，返回成功替换的attr数目
     */
    protected ContentValues addAttrContentValues(ContentValues c) {
        return c;
    }

    protected int getIntegratedAttrCount() {
        return 0;
    }
    /**
     * <p>执行 {@code REPLACE INTO} 操作，保存当前对象。</p>
     *
     * <p>如果当前对象的主键没有建立，检查用于生成主键的字段是否存在，如果存在的话，自动生成主键。</p>
     *
     * <p>主键都是由特定字段经过 {@link moai.io.Hashes#BKDRHashInt(String)} 生成。</p>
     */
    public int replace(SQLiteDatabase db) {
        generatePrimaryKeyOrThrow();
        ContentValues c = convertTo();
        c = addAttrContentValues(c);
        int ret = (int)db.replace(getTableName(), null, c);
        if (ret > 0) {
            int r = updateIntegratedAttr(db);
            if (r > 0) {
                ret += r;
            }
        }

        if (ret > 0) {
            onReplace(db);
        }
        return ret;
    }

    /**
     * <p>对于 1:M (M >= 1) 的关系，批量执行 {@link #replace(SQLiteDatabase)} 操作。</p>
     *
     * <p>对于相关的目标，在使用 {@link #convertTo()} 的时候，由关系的对象都会平行保存一份到临时列表，
     * 执行时循环调用该对象的 {@link #replaceAll(SQLiteDatabase)} 方法。依次类推保证所有关系都能够成功保存。
     * </p>
     */
    public final int replaceAll(SQLiteDatabase db) {
        Domain domain;
        int changeCount = 0;
        db.beginTransactionNonExclusive();
        try {
            changeCount += replace(db);
            while ((domain = flatDomainList.poll()) != null) {
                changeCount += domain.replaceAll(db);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return changeCount;
    }

    /**
     * <p>执行 {@code UPDATE INTO} 操作，更新当前对象。</p>
     *
     * <p>如果当前对象的主键没有建立，检查用于生成主键的字段是否存在，如果存在的话，自动生成主键。</p>
     *
     * <p>主键都是由特定字段经过 {@link moai.io.Hashes#BKDRHashInt(String)} 生成。</p>
     */
    public int update(SQLiteDatabase db) {
        generatePrimaryKeyOrThrow();
        int ret = db.update(getTableName(), convertTo(),
                getPrimaryKeyName() + " = ?",  new String[]{String.valueOf(getPrimaryKeyValue())});

        if (ret > 0) {
            int r = updateIntegratedAttr(db);
            if (r > 0) {
                ret += r;
            }
        }

        if (ret > 0) {
            onUpdate(db);
        }
        return ret;
    }

    /**
     * 更新融合的attr，返回更新的attr数目
     */
    protected int updateIntegratedAttr(SQLiteDatabase db) {
        return 0;
    }

    /**
     * 如果条目存在则更新，如果不存在则插入
     */
    public final int updateOrReplace(SQLiteDatabase db) {
        int ret = update(db);
        if (ret > 0) return ret;
        return replace(db);
    }

    /**
     * 对所有子依赖，批量执行 {@link #updateOrReplace(SQLiteDatabase)}
     */
    public final int updateOrReplaceAll(SQLiteDatabase db) {
        Domain domain;
        int changeCount = 0;
        db.beginTransactionNonExclusive();
        try {
            changeCount += updateOrReplace(db);
            while ((domain = flatDomainList.poll()) != null) {
                changeCount += domain.updateOrReplaceAll(db);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return changeCount;
    }

    /**
     * <p>对于 1:M (M >= 1) 的关系，批量执行 {@link #update(SQLiteDatabase)} 操作。</p>
     *
     * <p>对于相关的目标，在使用 {@link #convertTo()} 的时候，由关系的对象都会平行保存一份到临时列表，
     * 执行时循环调用该对象的 {@link #updateAll(SQLiteDatabase)} 方法。依次类推保证所有关系都能够成功保存。
     * </p>
     */
    @SuppressWarnings("unused")
    public final int updateAll(SQLiteDatabase db) {
        Domain domain;
        int changeCount = 0;
        db.beginTransactionNonExclusive();
        try {
            changeCount += update(db);
            while ((domain = flatDomainList.poll()) != null) {
                changeCount += domain.updateAll(db);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return changeCount;
    }

    /**
     * <p>执行 {@code DELETE} 操作，删除当前对象。</p>
     *
     * <p>如果当前对象的主键没有建立，检查用于生成主键的字段是否存在，如果存在的话，自动生成主键。</p>
     *
     * <p>主键都是由特定字段经过 {@link moai.io.Hashes#BKDRHashInt(String)} 生成。</p>
     */
    public final int delete(SQLiteDatabase db) {
        generatePrimaryKeyOrThrow();
        int ret = db.delete(getTableName(), String.format("%s = ?", getPrimaryKeyName()),
                new String[]{String.valueOf(getPrimaryKeyValue())});
        onDelete(db);
        return ret;
    }

    private static final Joiner joiner = Joiner.on("_").skipNulls();
    protected static int hashId(Object... value) {
        return Hashes.BKDRHashPositiveInt(joiner.join(value));
    }

    public static String generatePrefixedFields(String aliasPrefix, String[] fields) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            ret.append(aliasPrefix);
            ret.append(".");
            ret.append(fields[i]);
            ret.append(" AS ");
            ret.append(aliasPrefix);
            ret.append("_");
            ret.append(fields[i]);
            if (i + 1 < fields.length) {
                ret.append(",");
            }
        }
        return ret.toString();
    }

    private final BitSet bitSet = new BitSet();
    protected void setMask(int pos) {
        bitSet.set(pos, true);
    }
    protected void clearMask(int pos) {
        bitSet.set(pos, false);
    }
    protected boolean hasMask(int pos) {
        return bitSet.get(pos);
    }
    public int cardinality() {
        return bitSet.cardinality();
    }

    protected abstract String getTableName();
    public abstract String getPrimaryKeyName();
    public abstract int getPrimaryKeyValue();
    protected void generatePrimaryKeyOrThrow() {}

    protected abstract void onReplace(SQLiteDatabase db);
    protected abstract void onUpdate(SQLiteDatabase db);
    protected abstract void onDelete(SQLiteDatabase db);

    private ArrayDeque<Domain> flatDomainList = new ArrayDeque<>();
    protected void addFlatDomainForUpdate(Domain domain) {
        flatDomainList.add(domain);
    }
    protected void addFlatDomainForUpdate(List<? extends Domain> newItems) {
        try {
            flatDomainList.addAll(newItems);
        } catch (NullPointerException ignored) {
            newItems = FluentIterable.from(newItems).filter(nullPredicate).toList();
            flatDomainList.addAll(newItems);
        }
    }
    protected static final Predicate<Domain> nullPredicate = new Predicate<Domain>() {
        @Override
        public boolean apply(Domain input) {
            return input != null;
        }
    };

    protected static Joiner commaJoiner = Joiner.on(",").skipNulls();
    protected static <T extends Domain> Function<T, T> cloneFunc(
            @SuppressWarnings("UnusedParameters") Class<T> clz) {
        return new Function<T, T>() {
            @Override
            public T apply(T clone) {
                try {
                    //noinspection unchecked
                    return (T)clone.clone();
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static void createTable(SQLiteDatabase db, String tableName,
                                   Map<String, String> columns) {
        StringBuilder sql = new StringBuilder();
        sql.append("create table if not exists ").append(tableName).append(" (");
        Iterator<Map.Entry<String, String>> iterator = columns.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            sql.append(entry.getKey()).append(" ").append(entry.getValue());
            if (iterator.hasNext()) sql.append(", ");
        }
        sql.append(")");
        db.execSQL(sql.toString());
    }

    public static void dropTable(SQLiteDatabase db, String tableName) {
        db.execSQL("drop table if exists " + tableName);
    }

    public static List<String> getExistColumns(SQLiteDatabase db, String tableName) {
        List<String> existColumns = new ArrayList<>();
        Cursor cursor = db.rawQuery("PRAGMA table_info('" + tableName + "')", null);
        if (cursor != null) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                existColumns.add(cursor.getString(1));
            }
            cursor.close();
        }
        return existColumns;
    }

    public static String listToString(List<String> list) {
        if (list == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : list) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }

    public static LinkedHashMap<String, String> upgradeTable(SQLiteDatabase db, String tableName,
                                                             Map<String, String> columns) {
        LinkedHashMap<String, String> newColumns = new LinkedHashMap<>(columns);
        Cursor cursor = db.rawQuery("pragma table_info('" + tableName + "')", null);
        if (cursor != null) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                newColumns.remove(cursor.getString(1));
            }
            cursor.close();
        }
        if (newColumns.size() > 0) {
            try {
                for (Map.Entry<String, String> stringStringEntry : newColumns.entrySet()) {
                    db.execSQL("alter table " + tableName + " add column "
                            + stringStringEntry.getKey() + " " + stringStringEntry.getValue());
                }
            } catch (SQLiteException ex) {
                newColumns.clear();
                newColumns = new LinkedHashMap<>(columns);
                createTable(db, tableName, columns);
            }
        }
        return newColumns;
    }

    private boolean dirty;

    public boolean isDirty() {
        return dirty;
    }

    private static final LoadingCache<String, Set<Domain>> dirtyGuards = CacheBuilder.newBuilder()
            .build(new CacheLoader<String, Set<Domain>>() {
                @Override
                public Set<Domain> load(String key) throws Exception {
                    com.google.common.cache.Cache<Domain, Boolean> cache =
                            CacheBuilder.newBuilder().weakKeys().build();
                    return Collections.newSetFromMap(cache.asMap());
                }
            });

    protected static Set<Domain> dirtyGuard(SQLiteDatabase db, String tableName, int primaryKey) {
        String key = db.hashCode() + tableName + primaryKey;
        return dirtyGuards.getUnchecked(key);
    }

    public static void markDirty(SQLiteDatabase db, String tableName, int primaryKey) {
        for (Domain domain : dirtyGuard(db, tableName, primaryKey)) {
            domain.dirty = true;
        }
    }

    protected static String toJSONString(Object object) {
        return JSON.toJSONString(object, new PropertyPreFilter() {
            @Override
            public boolean apply(JSONSerializer serializer, Object object, String name) {
                return JavaBeanProxy.has(object, name);
            }
        });
    }
}
