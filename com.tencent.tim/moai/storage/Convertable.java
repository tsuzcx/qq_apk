package moai.storage;

import android.database.Cursor;

public interface Convertable {
    /**
     * <p>从 cursor 中根据列名和字段名进行匹配，构造出相应的对象。</p>
     *
     * <p>注意，必须符合 {@code SELECT 表名.字段名 AS 表名_字段名 FROM 表名} 的约定，否则不能正确构造。</p>
     *
     * <p>这样的约定，一方面是为了约束使用 {@code *} 来查找无用的字段，增加构造 {@link Cursor} 的开销。</p>
     *
     * <p>增加表名做前缀，是为了能够支持 {@code JOIN} 表，多表同名字段的时候能够根据表名区分。</p>
     *
     * <p>具体的查询语句，可通过各个 Domain 的 {@code getQueryFields} 方法辅助构造，如：</p>
     *
     * <pre>
     *     Book.getQueryFields(id); // => Book.id AS Book_id;
     * </pre>
     */
    void convertFrom(Cursor cursor);
}
