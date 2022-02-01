package com.tencent.qqmail.model.qmnote.storage;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.MergeCursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteStatement;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.model.qmdomain.QMNNoteStatus;
import com.tencent.qqmail.model.qmdomain.QMNoteAttachList;
import com.tencent.qqmail.model.uidomain.NoteUI;
import com.tencent.qqmail.monitor.DatabaseMonitor;
import com.tencent.qqmail.trd.guava.Joiner;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class QMNoteSQLite
{
  public static final String CREATE_TIME_DESC_ORDER = "createTime";
  static final String NOTE_TABLE_FIELDS = "id, subject, abstract, catId, createTime, updateTime, starred, content, read, sequence, status, thumbUrl, attachType, attachList,audio";
  static final String NOTE_TABLE_FIELD_AMOUNT = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
  public static final String UPDATE_TIME_DESC_ORDER = "updateTime";
  private final String TAG = "QMNoteSQLite";
  private HashMap<String, String> categoryCache = null;
  private final QMNoteBaseSqlite mQMNoteSqlite;
  
  public QMNoteSQLite(Context paramContext, String paramString)
  {
    this.mQMNoteSqlite = new QMNoteBaseSqlite(paramContext, paramString);
  }
  
  private void _clearCategoryCache()
  {
    this.categoryCache = null;
  }
  
  private boolean _execSQL(String paramString, Object[] paramArrayOfObject)
  {
    SQLiteDatabase localSQLiteDatabase = this.mQMNoteSqlite.getWritableDatabase();
    Log.w("SQL LOG :", paramString);
    if (localSQLiteDatabase == null) {
      return false;
    }
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      localSQLiteDatabase.execSQL(paramString);
    }
    for (;;)
    {
      return true;
      localSQLiteDatabase.execSQL(paramString, paramArrayOfObject);
    }
  }
  
  private String _getColumnAsString(String paramString, Cursor paramCursor)
  {
    if (paramCursor == null) {}
    int i;
    do
    {
      return null;
      i = paramCursor.getColumnIndex(paramString);
    } while (i == -1);
    return paramCursor.getString(i);
  }
  
  private QMNNote _getItem(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("id"));
    String str2 = paramCursor.getString(paramCursor.getColumnIndex("subject"));
    String str3 = paramCursor.getString(paramCursor.getColumnIndex("abstract"));
    String str4 = paramCursor.getString(paramCursor.getColumnIndex("catId"));
    double d1 = paramCursor.getDouble(paramCursor.getColumnIndex("createTime"));
    double d2 = paramCursor.getDouble(paramCursor.getColumnIndex("updateTime"));
    boolean bool1;
    String str5;
    if (paramCursor.getInt(paramCursor.getColumnIndex("starred")) == 1)
    {
      bool1 = true;
      str5 = paramCursor.getString(paramCursor.getColumnIndex("content"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("read")) != 1) {
        break label467;
      }
    }
    label467:
    for (boolean bool2 = true;; bool2 = false)
    {
      double d3 = paramCursor.getDouble(paramCursor.getColumnIndex("sequence"));
      int i = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      String str6 = paramCursor.getString(paramCursor.getColumnIndex("thumbUrl"));
      String str7 = paramCursor.getString(paramCursor.getColumnIndex("attachType"));
      String str8 = paramCursor.getString(paramCursor.getColumnIndex("audio"));
      Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("attachList"));
      paramCursor = new QMNoteAttachList();
      localObject = new String((byte[])localObject).trim();
      Log.d("ayangxu", (String)localObject);
      localObject = (JSONObject)JSONReader.parse((String)localObject);
      if (localObject != null) {
        paramCursor.parseWithDictionary((JSONObject)localObject);
      }
      localObject = new QMNNote();
      ((QMNNote)localObject).attachList = paramCursor;
      ((QMNNote)localObject).information.noteId = str1;
      ((QMNNote)localObject).information.subject = str2;
      ((QMNNote)localObject).information.abs = str3;
      ((QMNNote)localObject).information.category.setCatalogId(str4);
      ((QMNNote)localObject).information.audio = str8;
      ((QMNNote)localObject).information.thumbURL = str6;
      ((QMNNote)localObject).information.attachType = str7;
      ((QMNNote)localObject).status.createUTC = d1;
      ((QMNNote)localObject).status.updateUTC = d2;
      ((QMNNote)localObject).status.starred = bool1;
      ((QMNNote)localObject).status.status = i;
      ((QMNNote)localObject).status.sequence = d3;
      ((QMNNote)localObject).content = str5;
      ((QMNNote)localObject).read = bool2;
      return localObject;
      bool1 = false;
      break;
    }
  }
  
  private QMComposeNote _getUnsendItem(Cursor paramCursor)
  {
    QMComposeNote localQMComposeNote = new QMComposeNote();
    if ((paramCursor != null) && (paramCursor.getColumnCount() > paramCursor.getColumnIndex("domain"))) {
      try
      {
        paramCursor = (JSONObject)JSONReader.parse(new String(paramCursor.getBlob(paramCursor.getColumnIndex("domain"))));
        if (paramCursor == null) {
          return null;
        }
        localQMComposeNote.parseWithDictionary(paramCursor);
        return localQMComposeNote;
      }
      catch (Exception paramCursor) {}
    }
    return null;
  }
  
  /* Error */
  private ArrayList<String> _readStringListWithSQL(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 40	com/tencent/qqmail/model/qmnote/storage/QMNoteSQLite:mQMNoteSqlite	Lcom/tencent/qqmail/model/qmnote/storage/QMNoteBaseSqlite;
    //   6: invokevirtual 225	com/tencent/qqmail/model/qmnote/storage/QMNoteBaseSqlite:getReadableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   9: astore 4
    //   11: aload 4
    //   13: ifnonnull +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 227	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 228	java/util/ArrayList:<init>	()V
    //   25: astore_3
    //   26: aload 4
    //   28: aload_1
    //   29: aconst_null
    //   30: invokevirtual 232	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +55 -> 90
    //   38: aload_1
    //   39: astore_2
    //   40: aload_1
    //   41: invokeinterface 236 1 0
    //   46: ifeq +44 -> 90
    //   49: aload_1
    //   50: astore_2
    //   51: aload_0
    //   52: ldc 81
    //   54: aload_1
    //   55: invokespecial 238	com/tencent/qqmail/model/qmnote/storage/QMNoteSQLite:_getColumnAsString	(Ljava/lang/String;Landroid/database/Cursor;)Ljava/lang/String;
    //   58: astore 4
    //   60: aload 4
    //   62: ifnull -24 -> 38
    //   65: aload_1
    //   66: astore_2
    //   67: aload_3
    //   68: aload 4
    //   70: invokevirtual 242	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto -36 -> 38
    //   77: astore_1
    //   78: aload_2
    //   79: ifnull +9 -> 88
    //   82: aload_2
    //   83: invokeinterface 245 1 0
    //   88: aload_3
    //   89: areturn
    //   90: aload_1
    //   91: ifnull -3 -> 88
    //   94: aload_1
    //   95: invokeinterface 245 1 0
    //   100: goto -12 -> 88
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_1
    //   107: astore_2
    //   108: aload_3
    //   109: ifnull +9 -> 118
    //   112: aload_3
    //   113: invokeinterface 245 1 0
    //   118: aload_2
    //   119: athrow
    //   120: astore_2
    //   121: aload_1
    //   122: astore_3
    //   123: goto -15 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	QMNoteSQLite
    //   0	126	1	paramString	String
    //   1	118	2	str	String
    //   120	1	2	localObject1	Object
    //   25	98	3	localObject2	Object
    //   9	60	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   26	34	77	java/lang/Exception
    //   40	49	77	java/lang/Exception
    //   51	60	77	java/lang/Exception
    //   67	74	77	java/lang/Exception
    //   26	34	103	finally
    //   40	49	120	finally
    //   51	60	120	finally
    //   67	74	120	finally
  }
  
  protected static String getDoubleListInClause(List<Double> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append("'").append(paramList.get(i)).append("'");
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private boolean getFixDataIds(ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 40	com/tencent/qqmail/model/qmnote/storage/QMNoteSQLite:mQMNoteSqlite	Lcom/tencent/qqmail/model/qmnote/storage/QMNoteBaseSqlite;
    //   6: invokevirtual 225	com/tencent/qqmail/model/qmnote/storage/QMNoteBaseSqlite:getReadableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +5 -> 16
    //   14: iconst_1
    //   15: ireturn
    //   16: aload_2
    //   17: ldc_w 284
    //   20: aconst_null
    //   21: invokevirtual 232	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +44 -> 70
    //   29: aload_2
    //   30: astore_3
    //   31: aload_2
    //   32: invokeinterface 236 1 0
    //   37: ifeq +33 -> 70
    //   40: aload_2
    //   41: astore_3
    //   42: aload_1
    //   43: aload_2
    //   44: iconst_0
    //   45: invokeinterface 77 2 0
    //   50: invokevirtual 242	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: goto -25 -> 29
    //   57: astore_1
    //   58: aload_2
    //   59: ifnull -45 -> 14
    //   62: aload_2
    //   63: invokeinterface 245 1 0
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_2
    //   71: ifnull +9 -> 80
    //   74: aload_2
    //   75: invokeinterface 245 1 0
    //   80: iconst_0
    //   81: ireturn
    //   82: astore_1
    //   83: aload_3
    //   84: ifnull +9 -> 93
    //   87: aload_3
    //   88: invokeinterface 245 1 0
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_2
    //   98: goto -40 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	QMNoteSQLite
    //   0	101	1	paramArrayList	ArrayList<String>
    //   9	89	2	localObject1	Object
    //   1	87	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	40	57	java/lang/Exception
    //   42	54	57	java/lang/Exception
    //   16	25	82	finally
    //   31	40	82	finally
    //   42	54	82	finally
    //   16	25	95	java/lang/Exception
  }
  
  protected static String getInClause(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append("'").append((String)paramList.get(i)).append("'");
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private Cursor getSearchCursor(String paramString1, String paramString2)
  {
    if (StringUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("cannot be empty");
    }
    paramString1 = "%" + paramString1 + "%";
    return this.mQMNoteSqlite.getReadableDatabase().rawQuery(String.format("select * from %s where (%s like ? or %s like ? or %s like ?) and %s != ? order by %s desc", new Object[] { "QMNote", "content", "subject", "abstract", "status", paramString2 }), new String[] { paramString1, paramString1, paramString1, String.valueOf(9) });
  }
  
  public static void upgradeTableFor5210(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QMNoteCategory ADD COLUMN catPos INTEGER DEFAULT 0");
  }
  
  public HashMap<String, String> cloneCategory()
  {
    if (this.categoryCache == null) {
      readAllCategory();
    }
    if (this.categoryCache == null) {
      return new HashMap();
    }
    return (HashMap)this.categoryCache.clone();
  }
  
  public void closeDatabase()
  {
    if (this.mQMNoteSqlite == null) {
      return;
    }
    this.mQMNoteSqlite.close();
  }
  
  public boolean deleteCategoryWithItem(QMNNoteCategory paramQMNNoteCategory)
  {
    if (paramQMNNoteCategory == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    return _execSQL("DELETE FROM QMNoteCategory WHERE catId = ?", new Object[] { paramQMNNoteCategory.getCatalogId() });
  }
  
  public boolean deleteDataWithId(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    return _execSQL("DELETE FROM QMNote WHERE id='" + paramString + "'", null);
  }
  
  public boolean deleteDatabase()
  {
    String str = "QMNoteDB" + NoteManager.getSharedInstance().mCurrentNoteUin;
    this.mQMNoteSqlite.getWritableDatabase().close();
    return QMApplicationContext.sharedInstance().deleteDatabase(str);
  }
  
  public boolean deleteOneItemByCreateTime(double paramDouble)
  {
    return _execSQL("DELETE FROM QMNote WHERE createTime=?", new Object[] { Double.valueOf(paramDouble) });
  }
  
  public boolean deleteUnsendNoteById(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    return _execSQL("DELETE FROM QMUnsendNoteData WHERE id=?", new Object[] { paramString });
  }
  
  public void dropTable()
  {
    SQLiteDatabase localSQLiteDatabase = this.mQMNoteSqlite.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    _clearCategoryCache();
    localSQLiteDatabase.delete("QMNote", null, null);
    localSQLiteDatabase.delete("QMNoteCategory", null, null);
    localSQLiteDatabase.delete("QMUnsendNoteData", null, null);
  }
  
  public boolean fixNoteData()
  {
    boolean bool2 = true;
    Object localObject = new ArrayList();
    if (getFixDataIds((ArrayList)localObject)) {
      return false;
    }
    Iterator localIterator = ((ArrayList)localObject).iterator();
    boolean bool1 = true;
    while (localIterator.hasNext())
    {
      QMComposeNote localQMComposeNote = readUnsendNoteById((String)localIterator.next());
      if (localQMComposeNote != null)
      {
        localQMComposeNote.status.status = 1;
        QMNoteSQLiteItem localQMNoteSQLiteItem = new QMNoteSQLiteItem();
        localQMNoteSQLiteItem.itemId = localQMComposeNote.information.noteId;
        localQMNoteSQLiteItem.domain = localQMComposeNote.ConvertToByte();
        if ((bool1) && (insertUnsendNoteToBytes(localQMNoteSQLiteItem))) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
    }
    if (((ArrayList)localObject).size() > 0)
    {
      QMLog.log(4, "QMNoteSQLite", "fixNoteData size:" + ((ArrayList)localObject).size());
      localObject = "UPDATE QMNote SET status = '1' WHERE id IN " + getInClause((List)localObject);
      if ((bool1) && (_execSQL((String)localObject, null))) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public List<String> getPendingDeleteIds()
  {
    Cursor localCursor = this.mQMNoteSqlite.getReadableDatabase().rawQuery(String.format("select %s from %s where %s = ?", new Object[] { "id", "QMNote", "status" }), new String[] { "9" });
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          localArrayList.add(localCursor.getString(localCursor.getColumnIndex("id")));
          bool = localCursor.moveToNext();
        } while (bool);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public double getSeq(String paramString)
  {
    double d = 0.0D;
    String str = String.format("select %s from %s where %s = ?", new Object[] { "sequence", "QMNote", "id" });
    SQLiteDatabase localSQLiteDatabase = this.mQMNoteSqlite.getReadableDatabase();
    if (localSQLiteDatabase == null) {}
    do
    {
      return 0.0D;
      paramString = localSQLiteDatabase.rawQuery(str, new String[] { paramString });
    } while (paramString == null);
    if (paramString.moveToFirst()) {
      d = paramString.getDouble(0);
    }
    paramString.close();
    return d;
  }
  
  public boolean insertCategoryWithItem(QMNNoteCategory paramQMNNoteCategory)
  {
    if (paramQMNNoteCategory == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    _clearCategoryCache();
    return _execSQL("REPLACE INTO QMNoteCategory (catId, catName, catPos) VALUES (?, ?, ?)", new Object[] { paramQMNNoteCategory.getCatalogId(), paramQMNNoteCategory.getCatalogName(), Integer.valueOf(paramQMNNoteCategory.getCatalogPos()) });
  }
  
  public boolean insertDataWithItem(QMNNote paramQMNNote)
  {
    if (paramQMNNote == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    String str = paramQMNNote.information.category.getCatalogId();
    return _execSQL("REPLACE INTO QMNote (id, subject, abstract, catId, createTime, updateTime, starred, content, read, sequence, status, thumbUrl, attachType, attachList,audio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[] { paramQMNNote.information.noteId, paramQMNNote.information.subject, paramQMNNote.information.abs, str, Double.valueOf(paramQMNNote.status.createUTC), Double.valueOf(paramQMNNote.status.updateUTC), Boolean.valueOf(paramQMNNote.status.starred), paramQMNNote.content, Boolean.valueOf(paramQMNNote.read), Double.valueOf(paramQMNNote.status.sequence), Integer.valueOf(paramQMNNote.status.status), paramQMNNote.information.thumbURL, paramQMNNote.information.attachType, paramQMNNote.attachList.toString(), paramQMNNote.information.audio });
  }
  
  public boolean insertNoteWithItem(List<QMNNote> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    SQLiteDatabase localSQLiteDatabase = this.mQMNoteSqlite.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return false;
    }
    SQLiteStatement localSQLiteStatement = localSQLiteDatabase.compileStatement("REPLACE INTO QMNote (id, subject, abstract, catId, createTime, updateTime, starred, content, read, sequence, status, thumbUrl, attachType, attachList,audio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    localSQLiteDatabase.beginTransactionNonExclusive();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      QMNNote localQMNNote = (QMNNote)localIterator.next();
      String str = localQMNNote.information.category.getCatalogId();
      label104:
      label126:
      long l;
      if (localQMNNote.information.noteId == null)
      {
        paramList = "";
        localSQLiteStatement.bindString(1, paramList);
        if (localQMNNote.information.subject != null) {
          break label405;
        }
        paramList = "";
        localSQLiteStatement.bindString(2, paramList);
        if (localQMNNote.information.abs != null) {
          break label417;
        }
        paramList = "";
        label148:
        localSQLiteStatement.bindString(3, paramList);
        if (str != null) {
          break label429;
        }
        paramList = "";
        label164:
        localSQLiteStatement.bindString(4, paramList);
        localSQLiteStatement.bindDouble(5, localQMNNote.status.createUTC);
        localSQLiteStatement.bindDouble(6, localQMNNote.status.updateUTC);
        if (!localQMNNote.status.starred) {
          break label435;
        }
        l = 1L;
        label213:
        localSQLiteStatement.bindLong(7, l);
        if (localQMNNote.content != null) {
          break label440;
        }
        paramList = "";
        label233:
        localSQLiteStatement.bindString(8, paramList);
        if (!localQMNNote.read) {
          break label449;
        }
        l = 1L;
        label251:
        localSQLiteStatement.bindLong(9, l);
        localSQLiteStatement.bindDouble(10, localQMNNote.status.sequence);
        localSQLiteStatement.bindLong(11, localQMNNote.status.status);
        if (localQMNNote.information.thumbURL != null) {
          break label454;
        }
        paramList = "";
        label305:
        localSQLiteStatement.bindString(12, paramList);
        if (localQMNNote.information.attachType != null) {
          break label466;
        }
        paramList = "";
        label328:
        localSQLiteStatement.bindString(13, paramList);
        if (localQMNNote.attachList != null) {
          localSQLiteStatement.bindBlob(14, localQMNNote.attachList.toString().getBytes());
        }
        if (localQMNNote.information.audio != null) {
          break label478;
        }
      }
      label405:
      label417:
      label429:
      label435:
      label440:
      label449:
      label454:
      label466:
      label478:
      for (paramList = "";; paramList = localQMNNote.information.audio)
      {
        localSQLiteStatement.bindString(15, paramList);
        localSQLiteStatement.execute();
        break;
        paramList = localQMNNote.information.noteId;
        break label104;
        paramList = localQMNNote.information.subject;
        break label126;
        paramList = localQMNNote.information.abs;
        break label148;
        paramList = str;
        break label164;
        l = 0L;
        break label213;
        paramList = localQMNNote.content;
        break label233;
        l = 0L;
        break label251;
        paramList = localQMNNote.information.thumbURL;
        break label305;
        paramList = localQMNNote.information.attachType;
        break label328;
      }
    }
    localSQLiteStatement.close();
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
    return true;
  }
  
  public boolean insertUnsendNoteToBytes(QMNoteSQLiteItem paramQMNoteSQLiteItem)
  {
    if (paramQMNoteSQLiteItem == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    return _execSQL("REPLACE INTO QMUnsendNoteData (id, domain) VALUES (?, ?)", new Object[] { paramQMNoteSQLiteItem.itemId, paramQMNoteSQLiteItem.domain });
  }
  
  public boolean isNoteDatabaseEmpty()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    Object localObject = String.format("SELECT COUNT(*) FROM %s WHERE %s != %s", new Object[] { "QMNote", "status", Integer.valueOf(9) });
    localObject = this.mQMNoteSqlite.getReadableDatabase().rawQuery((String)localObject, null);
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Cursor)localObject).moveToFirst()) {
        if (((Cursor)localObject).getLong(0) != 0L) {
          break label84;
        }
      }
    }
    label84:
    for (bool1 = bool2;; bool1 = false)
    {
      ((Cursor)localObject).close();
      return bool1;
    }
  }
  
  public boolean moveNote(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    return _execSQL("UPDATE QMNote SET catId=? WHERE id=?", new Object[] { paramString1, paramString2 });
  }
  
  public ArrayList<QMComposeNote> newAddedAllUnsendNotes()
  {
    Object localObject3 = this.mQMNoteSqlite.getReadableDatabase();
    if (localObject3 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      localObject3 = ((SQLiteDatabase)localObject3).rawQuery("select * from QMUnsendNoteData where id not in (select id from QMNote where status=9)", null);
      int j;
      int i;
      QMComposeNote localQMComposeNote;
      String str;
      if ((localObject3 == null) || (localObject3 != null)) {
        ((Cursor)localObject3).close();
      }
    }
    finally
    {
      try
      {
        j = ((Cursor)localObject3).getCount();
        i = 0;
        while (i < j)
        {
          if (((Cursor)localObject3).moveToPosition(i))
          {
            localQMComposeNote = _getUnsendItem((Cursor)localObject3);
            if (localQMComposeNote != null)
            {
              str = localQMComposeNote.getId();
              if ((!TextUtils.isEmpty(str)) && (str.contains("composemail_")) && (localQMComposeNote.status.status == 2))
              {
                localQMComposeNote.status.status = 1;
                localArrayList.add(localQMComposeNote);
              }
            }
          }
          i += 1;
        }
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
        return localArrayList;
      }
      finally
      {
        break label158;
      }
      localObject1 = finally;
      localObject3 = null;
    }
    label158:
    throw localObject1;
  }
  
  /* Error */
  public ArrayList<QMNNoteCategory> readAllCategory()
  {
    // Byte code:
    //   0: new 227	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 228	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 40	com/tencent/qqmail/model/qmnote/storage/QMNoteSQLite:mQMNoteSqlite	Lcom/tencent/qqmail/model/qmnote/storage/QMNoteBaseSqlite;
    //   12: invokevirtual 225	com/tencent/qqmail/model/qmnote/storage/QMNoteBaseSqlite:getReadableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_1
    //   23: ldc_w 567
    //   26: aconst_null
    //   27: invokevirtual 232	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +113 -> 145
    //   35: aload_1
    //   36: invokeinterface 236 1 0
    //   41: ifeq +104 -> 145
    //   44: aload_2
    //   45: new 172	com/tencent/qqmail/model/qmdomain/QMNNoteCategory
    //   48: dup
    //   49: aload_1
    //   50: iconst_0
    //   51: invokeinterface 77 2 0
    //   56: aload_1
    //   57: iconst_1
    //   58: invokeinterface 77 2 0
    //   63: invokespecial 570	com/tencent/qqmail/model/qmdomain/QMNNoteCategory:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokevirtual 242	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: goto -35 -> 35
    //   73: astore_2
    //   74: aload_1
    //   75: ifnull +116 -> 191
    //   78: aload_1
    //   79: invokeinterface 245 1 0
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +90 -> 177
    //   90: aload_0
    //   91: new 326	java/util/HashMap
    //   94: dup
    //   95: iconst_4
    //   96: invokespecial 573	java/util/HashMap:<init>	(I)V
    //   99: putfield 34	com/tencent/qqmail/model/qmnote/storage/QMNoteSQLite:categoryCache	Ljava/util/HashMap;
    //   102: aload_1
    //   103: invokevirtual 400	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   106: astore_2
    //   107: aload_2
    //   108: invokeinterface 405 1 0
    //   113: ifeq +64 -> 177
    //   116: aload_2
    //   117: invokeinterface 408 1 0
    //   122: checkcast 172	com/tencent/qqmail/model/qmdomain/QMNNoteCategory
    //   125: astore_3
    //   126: aload_0
    //   127: getfield 34	com/tencent/qqmail/model/qmnote/storage/QMNoteSQLite:categoryCache	Ljava/util/HashMap;
    //   130: aload_3
    //   131: invokevirtual 343	com/tencent/qqmail/model/qmdomain/QMNNoteCategory:getCatalogId	()Ljava/lang/String;
    //   134: aload_3
    //   135: invokevirtual 466	com/tencent/qqmail/model/qmdomain/QMNNoteCategory:getCatalogName	()Ljava/lang/String;
    //   138: invokevirtual 577	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: pop
    //   142: goto -35 -> 107
    //   145: aload_1
    //   146: ifnull +50 -> 196
    //   149: aload_1
    //   150: invokeinterface 245 1 0
    //   155: aload_2
    //   156: astore_1
    //   157: goto -71 -> 86
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_3
    //   163: aload_1
    //   164: astore_2
    //   165: aload_3
    //   166: ifnull +9 -> 175
    //   169: aload_3
    //   170: invokeinterface 245 1 0
    //   175: aload_2
    //   176: athrow
    //   177: aload_1
    //   178: areturn
    //   179: astore_2
    //   180: aload_1
    //   181: astore_3
    //   182: goto -17 -> 165
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -114 -> 74
    //   191: aconst_null
    //   192: astore_1
    //   193: goto -107 -> 86
    //   196: aload_2
    //   197: astore_1
    //   198: goto -112 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	QMNoteSQLite
    //   15	142	1	localObject1	Object
    //   160	21	1	localArrayList	ArrayList<QMNNoteCategory>
    //   185	1	1	localException1	Exception
    //   187	11	1	localObject2	Object
    //   7	38	2	localArrayList1	ArrayList
    //   73	1	2	localException2	Exception
    //   106	70	2	localObject3	Object
    //   179	18	2	localObject4	Object
    //   125	57	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   35	70	73	java/lang/Exception
    //   22	31	160	finally
    //   35	70	179	finally
    //   22	31	185	java/lang/Exception
  }
  
  /* Error */
  public ArrayList<String> readAllUnsendNotes()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/qqmail/model/qmnote/storage/QMNoteSQLite:mQMNoteSqlite	Lcom/tencent/qqmail/model/qmnote/storage/QMNoteBaseSqlite;
    //   4: invokevirtual 225	com/tencent/qqmail/model/qmnote/storage/QMNoteBaseSqlite:getReadableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 227	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 228	java/util/ArrayList:<init>	()V
    //   21: astore_2
    //   22: aload_1
    //   23: ldc_w 581
    //   26: aconst_null
    //   27: invokevirtual 232	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +40 -> 72
    //   35: aload_1
    //   36: invokeinterface 236 1 0
    //   41: ifeq +31 -> 72
    //   44: aload_2
    //   45: aload_1
    //   46: iconst_0
    //   47: invokeinterface 77 2 0
    //   52: invokevirtual 242	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   55: pop
    //   56: goto -21 -> 35
    //   59: astore_2
    //   60: aload_1
    //   61: ifnull -49 -> 12
    //   64: aload_1
    //   65: invokeinterface 245 1 0
    //   70: aconst_null
    //   71: areturn
    //   72: aload_1
    //   73: ifnull +9 -> 82
    //   76: aload_1
    //   77: invokeinterface 245 1 0
    //   82: aload_2
    //   83: areturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_3
    //   87: aload_1
    //   88: astore_2
    //   89: aload_3
    //   90: ifnull +9 -> 99
    //   93: aload_3
    //   94: invokeinterface 245 1 0
    //   99: aload_2
    //   100: athrow
    //   101: astore_2
    //   102: aload_1
    //   103: astore_3
    //   104: goto -15 -> 89
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_1
    //   110: goto -50 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	QMNoteSQLite
    //   7	70	1	localObject1	Object
    //   84	19	1	localObject2	Object
    //   107	1	1	localException1	Exception
    //   109	1	1	localObject3	Object
    //   21	24	2	localArrayList	ArrayList
    //   59	24	2	localException2	Exception
    //   88	12	2	localObject4	Object
    //   101	1	2	localObject5	Object
    //   86	18	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   35	56	59	java/lang/Exception
    //   22	31	84	finally
    //   35	56	101	finally
    //   22	31	107	java/lang/Exception
  }
  
  public String readCategoryByCid(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    if (this.categoryCache == null) {
      readAllCategory();
    }
    if (this.categoryCache == null) {
      return null;
    }
    return (String)this.categoryCache.get(paramString);
  }
  
  public ArrayList<Double> readCreateUTC(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    localObject = this.mQMNoteSqlite.getReadableDatabase();
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    for (;;)
    {
      try
      {
        localObject = ((SQLiteDatabase)localObject).rawQuery("SELECT createTime FROM QMNote WHERE status = 0 or status = 2 order by createTime desc", null);
        if (localObject == null) {}
      }
      finally
      {
        localObject = null;
        continue;
      }
      try
      {
        if (((Cursor)localObject).moveToNext()) {}
        return paramString;
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
  }
  
  public QMNNote readDataById(String paramString)
  {
    Object localObject1 = null;
    if (paramString == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    Object localObject2 = this.mQMNoteSqlite.getReadableDatabase();
    if (localObject2 == null) {}
    do
    {
      return null;
      localObject2 = ((SQLiteDatabase)localObject2).rawQuery(String.format("select * from %s where id = '%s' and %s != %s ", new Object[] { "QMNote", paramString, "status", Integer.valueOf(9) }), null);
    } while (localObject2 == null);
    paramString = localObject1;
    if (((Cursor)localObject2).moveToFirst()) {
      paramString = _getItem((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    return paramString;
  }
  
  public double readLastUpdateUTC()
  {
    double d = 0.0D;
    Object localObject = this.mQMNoteSqlite.getReadableDatabase();
    if (localObject == null) {}
    do
    {
      return 0.0D;
      new String();
      localObject = ((SQLiteDatabase)localObject).rawQuery("SELECT sequence FROM QMNote WHERE status = 0 or status = 2 order by sequence desc limit 1", null);
    } while (localObject == null);
    if (((Cursor)localObject).moveToFirst()) {
      d = Double.valueOf(((Cursor)localObject).getDouble(0)).doubleValue();
    }
    ((Cursor)localObject).close();
    return d;
  }
  
  public Cursor readNoteCursorByIds(List<String> paramList, String paramString)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    if (paramString == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    SQLiteDatabase localSQLiteDatabase = this.mQMNoteSqlite.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      int j = paramList.size() - 1;
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append('\'');
        localStringBuilder.append((String)paramList.get(i));
        localStringBuilder.append("',");
        i += 1;
      }
      if (j >= 0)
      {
        localStringBuilder.append('\'');
        localStringBuilder.append((String)paramList.get(j));
        localStringBuilder.append("'");
      }
      paramList = String.format("SELECT * FROM QMNote WHERE id IN (" + localStringBuilder.toString() + ") and %s != %s order by " + paramString + " desc", new Object[] { "status", Integer.valueOf(9) });
      QMLog.log(4, "QMNoteSQLite", paramList);
      try
      {
        paramString = localSQLiteDatabase.rawQuery(paramList, null);
        DatabaseMonitor.shareInstance().markCursor(paramList, paramString);
        paramList = paramString;
        if (paramString != null) {}
      }
      catch (Exception paramList)
      {
        label244:
        break label244;
      }
    }
    return null;
  }
  
  public NoteUI readNoteUIByCategoryId(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    Object localObject1 = " where 1 = 1 ";
    if (paramString1.equals("star")) {
      localObject1 = " where 1 = 1 " + " and starred = 1 ";
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = (String)localObject1 + String.format(" and %s != %s ", new Object[] { "status", Integer.valueOf(9) });
      localObject2 = "SELECT " + Joiner.on(",").join(new String[] { "id", "subject", "abstract", "catId", "createTime", "updateTime", "starred", "read", "sequence", "status", "thumbUrl", "audio", "attachType" }) + " FROM ";
      paramString2 = (String)localObject2 + "QMNote" + (String)localObject1 + " order by " + paramString2 + " desc";
      QMLog.log(4, "QMNoteSQLite", paramString2);
      localObject2 = this.mQMNoteSqlite.getReadableDatabase();
      if (localObject2 != null) {
        break;
      }
      throw new RuntimeException("database unavalilable");
      if (!paramString1.equals("all")) {
        localObject1 = " where 1 = 1 " + String.format(" and catId = '%s' ", new Object[] { paramString1 });
      }
    }
    localObject1 = cloneCategory();
    try
    {
      localObject2 = ((SQLiteDatabase)localObject2).rawQuery(paramString2, null);
      DatabaseMonitor.shareInstance().markCursor(paramString2, (Cursor)localObject2);
      if (localObject2 != null)
      {
        paramString2 = new NoteUI((Cursor)localObject2, (HashMap)localObject1);
        QMLog.log(4, "QMNoteSQLite", "noteSize: " + paramString2.size() + " byCategoryId: " + paramString1);
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      throw new DevRuntimeException(paramString1);
    }
    return null;
  }
  
  public NoteUI readNoteUIByMergeIds(String paramString, List<String> paramList1, List<String> paramList2)
  {
    paramList1 = readNoteCursorByIds(paramList1, paramString);
    paramString = readNoteCursorByIds(paramList2, paramString);
    paramList2 = cloneCategory();
    if ((paramList1 == null) || (paramList1.getCount() == 0)) {
      return new NoteUI(paramString, paramList2);
    }
    if ((paramString == null) || (paramString.getCount() == 0)) {
      return new NoteUI(paramList1, paramList2);
    }
    return new NoteUI(new MergeCursor(new Cursor[] { paramList1, paramString }), paramList2);
  }
  
  public NoteUI readNoteUIByNoteids(List<String> paramList, String paramString)
  {
    paramList = readNoteCursorByIds(paramList, paramString);
    if (paramList != null)
    {
      paramString = cloneCategory();
      try
      {
        paramList = new NoteUI(paramList, paramString);
        return paramList;
      }
      catch (Exception paramList) {}
    }
    return null;
  }
  
  public List<QMNNote> readNotesByCreateTime(List<Double> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.mQMNoteSqlite.getReadableDatabase();
    if ((localObject == null) || (paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return localArrayList;
      paramList = ((SQLiteDatabase)localObject).rawQuery("SELECT id,status FROM QMNote WHERE createTime IN " + getDoubleListInClause(paramList), null);
    } while (paramList == null);
    while (paramList.moveToNext())
    {
      localObject = paramList.getString(paramList.getColumnIndex("id"));
      int i = paramList.getInt(paramList.getColumnIndex("status"));
      QMNNote localQMNNote = new QMNNote();
      localQMNNote.information.noteId = ((String)localObject);
      localQMNNote.status.status = i;
      localArrayList.add(localQMNNote);
    }
    paramList.close();
    return localArrayList;
  }
  
  public QMComposeNote readUnsendNoteById(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramString == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    SQLiteDatabase localSQLiteDatabase = this.mQMNoteSqlite.getReadableDatabase();
    if (localSQLiteDatabase == null)
    {
      localObject2 = localObject1;
      label35:
      return localObject2;
    }
    localObject1 = String.format("select * from %s as a inner join %s as b on a.id = b.id where a.id = ? and a.status != %s", new Object[] { "QMNote", "QMUnsendNoteData", Integer.valueOf(9) });
    try
    {
      localObject1 = localSQLiteDatabase.rawQuery((String)localObject1, new String[] { paramString });
      paramString = (String)localObject2;
      if (localObject1 != null) {
        paramString = (String)localObject2;
      }
    }
    finally
    {
      try
      {
        if (((Cursor)localObject1).moveToFirst()) {
          paramString = _getUnsendItem((Cursor)localObject1);
        }
        localObject2 = paramString;
        if (localObject1 == null) {
          break label35;
        }
        ((Cursor)localObject1).close();
        return paramString;
      }
      finally {}
      paramString = finally;
      localObject1 = null;
    }
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    throw paramString;
  }
  
  public boolean saveNoteStatus(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    return _execSQL("UPDATE QMNote SET status=? WHERE id=?", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public boolean saveStarStatus(boolean paramBoolean, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return _execSQL("UPDATE QMNote SET starred=? WHERE id=?", new Object[] { Integer.valueOf(i), paramString });
    }
  }
  
  public ArrayList<String> searchItemIdByStatus(int paramInt)
  {
    return _readStringListWithSQL("SELECT id FROM QMNote WHERE status = " + paramInt);
  }
  
  public NoteUI searchNote(String paramString1, String paramString2)
  {
    return new NoteUI(getSearchCursor(paramString1, paramString2), cloneCategory());
  }
  
  public List<String> searchNoteWithKey(String paramString1, String paramString2)
  {
    paramString1 = getSearchCursor(paramString1, paramString2);
    paramString2 = Lists.newArrayList();
    if ((paramString1 != null) && (paramString1.moveToFirst()))
    {
      while (paramString1.moveToNext()) {
        paramString2.add(paramString1.getString(paramString1.getColumnIndex("id")));
      }
      paramString1.close();
    }
    return paramString2;
  }
  
  public boolean setSeq(String paramString, double paramDouble)
  {
    return _execSQL("UPDATE QMNote SET sequence=? WHERE id=?", new Object[] { Double.valueOf(paramDouble), paramString });
  }
  
  public void transactionCommit()
  {
    SQLiteDatabase localSQLiteDatabase = this.mQMNoteSqlite.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  public void transactionStart()
  {
    SQLiteDatabase localSQLiteDatabase = this.mQMNoteSqlite.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.beginTransactionNonExclusive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmnote.storage.QMNoteSQLite
 * JD-Core Version:    0.7.0.1
 */