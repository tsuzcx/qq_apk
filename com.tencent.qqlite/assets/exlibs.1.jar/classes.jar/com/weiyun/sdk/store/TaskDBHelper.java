package com.weiyun.sdk.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.util.Utils;

public class TaskDBHelper
  extends LibFileDatabaseHelper.NativeDBHelper
{
  protected static final String FILE_ID_SELECTION = "task_file_id=? AND task_uin=? AND task_type=?";
  protected static final String[] ID_PROJECTION = { "_id" };
  protected static final String PATH_SELECTION = "task_file_path=? AND task_uin=? AND task_type=?";
  public static final int TASK_TYPE_DOWNLOAD = 2;
  public static final int TASK_TYPE_UPLOAD = 1;
  
  public TaskDBHelper(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    super("lib_task", paramSQLiteOpenHelper);
  }
  
  public static TaskDBHelper newDBHelper()
  {
    return new TaskDBHelper(LibFileDatabaseHelper.getInstance(SdkContext.getInstance().getContext()));
  }
  
  public DownloadJobContext getDownloadJobContext(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = Integer.toString(2);
    paramString1 = query(new String[] { "_id", "task_cur_size", "task_total_size", "task_file_modify_time", "task_file_id", "task_file_name", "task_local_name", "task_file_md5" }, "task_file_id=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, str });
    if (paramString1 == null) {
      return null;
    }
    try
    {
      if (paramString1.moveToNext())
      {
        long l = paramString1.getLong(0);
        paramString2 = new DownloadJobContext(Long.parseLong(paramString2), l, paramString3, paramString4);
        paramString2.setCurSize(paramString1.getLong(1));
        paramString2.setTotalSize(paramString1.getLong(2));
        paramString2.setModifyTime(paramString1.getLong(3));
        paramString2.setFileId(paramString1.getString(4));
        paramString2.setFileName(paramString1.getString(5));
        paramString2.setDestFileName(paramString1.getString(6));
        paramString2.setMd5(paramString1.getString(7));
        return paramString2;
      }
    }
    finally
    {
      paramString1.close();
    }
    paramString1.close();
    return null;
  }
  
  /* Error */
  public String getDownloadNewFileName(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: bipush 47
    //   3: invokevirtual 139	java/lang/String:lastIndexOf	(I)I
    //   6: istore_2
    //   7: aload_1
    //   8: astore 5
    //   10: iload_2
    //   11: iflt +12 -> 23
    //   14: aload_1
    //   15: iload_2
    //   16: iconst_1
    //   17: iadd
    //   18: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   21: astore 5
    //   23: aload 5
    //   25: astore 6
    //   27: ldc 144
    //   29: astore_1
    //   30: aload 5
    //   32: bipush 46
    //   34: invokevirtual 139	java/lang/String:lastIndexOf	(I)I
    //   37: istore_2
    //   38: iload_2
    //   39: iflt +20 -> 59
    //   42: aload 5
    //   44: iload_2
    //   45: iconst_1
    //   46: iadd
    //   47: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   50: astore 6
    //   52: aload 5
    //   54: iload_2
    //   55: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   58: astore_1
    //   59: new 146	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   66: astore 7
    //   68: aload 7
    //   70: ldc 73
    //   72: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 154
    //   77: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 7
    //   83: aload 6
    //   85: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 156
    //   90: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 158
    //   99: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 7
    //   105: ldc 160
    //   107: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 73
    //   112: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 162
    //   117: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 7
    //   123: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_1
    //   127: aload_0
    //   128: iconst_1
    //   129: anewarray 22	java/lang/String
    //   132: dup
    //   133: iconst_0
    //   134: ldc 73
    //   136: aastore
    //   137: aload_1
    //   138: iconst_1
    //   139: anewarray 22	java/lang/String
    //   142: dup
    //   143: iconst_0
    //   144: aload 5
    //   146: aastore
    //   147: ldc 167
    //   149: aconst_null
    //   150: invokevirtual 170	com/weiyun/sdk/store/TaskDBHelper:query	([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   153: astore_1
    //   154: aload_1
    //   155: ifnonnull +6 -> 161
    //   158: aload 5
    //   160: areturn
    //   161: iconst_m1
    //   162: istore_2
    //   163: aload_1
    //   164: invokeinterface 85 1 0
    //   169: ifne +26 -> 195
    //   172: iload_2
    //   173: iflt +135 -> 308
    //   176: aload 5
    //   178: iload_2
    //   179: iconst_1
    //   180: iadd
    //   181: invokestatic 176	com/weiyun/sdk/util/Utils:fileRename	(Ljava/lang/String;I)Ljava/lang/String;
    //   184: astore 5
    //   186: aload_1
    //   187: invokeinterface 129 1 0
    //   192: aload 5
    //   194: areturn
    //   195: aload_1
    //   196: iconst_0
    //   197: invokeinterface 113 2 0
    //   202: astore 6
    //   204: aload 6
    //   206: aload 5
    //   208: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: istore 4
    //   213: iload 4
    //   215: ifeq +15 -> 230
    //   218: iload_2
    //   219: ifle +6 -> 225
    //   222: goto -59 -> 163
    //   225: iconst_0
    //   226: istore_2
    //   227: goto -5 -> 222
    //   230: aload 6
    //   232: aload 6
    //   234: ldc 182
    //   236: invokevirtual 185	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   239: iconst_1
    //   240: iadd
    //   241: aload 6
    //   243: ldc 187
    //   245: invokevirtual 185	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   248: invokevirtual 190	java/lang/String:substring	(II)Ljava/lang/String;
    //   251: invokestatic 194	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   254: invokevirtual 198	java/lang/Integer:intValue	()I
    //   257: istore_3
    //   258: iload_2
    //   259: iload_3
    //   260: if_icmple +6 -> 266
    //   263: goto -100 -> 163
    //   266: iload_3
    //   267: istore_2
    //   268: goto -5 -> 263
    //   271: astore 6
    //   273: ldc 200
    //   275: aload 6
    //   277: invokestatic 206	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   280: pop
    //   281: goto -118 -> 163
    //   284: astore 5
    //   286: aload_1
    //   287: invokeinterface 129 1 0
    //   292: aload 5
    //   294: athrow
    //   295: astore 6
    //   297: ldc 200
    //   299: aload 6
    //   301: invokestatic 206	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   304: pop
    //   305: goto -142 -> 163
    //   308: aload_1
    //   309: invokeinterface 129 1 0
    //   314: aload 5
    //   316: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	TaskDBHelper
    //   0	317	1	paramString	String
    //   6	262	2	i	int
    //   257	10	3	j	int
    //   211	3	4	bool	boolean
    //   8	199	5	str1	String
    //   284	31	5	str2	String
    //   25	217	6	str3	String
    //   271	5	6	localNumberFormatException	java.lang.NumberFormatException
    //   295	5	6	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   66	56	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   230	258	271	java/lang/NumberFormatException
    //   163	172	284	finally
    //   176	186	284	finally
    //   195	213	284	finally
    //   230	258	284	finally
    //   273	281	284	finally
    //   297	305	284	finally
    //   230	258	295	java/lang/IndexOutOfBoundsException
  }
  
  public long getDownloadTaskId(String paramString1, String paramString2)
  {
    return getId(query(ID_PROJECTION, "task_file_id=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(2) }));
  }
  
  protected long getId(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return 0L;
    }
    int i = paramCursor.getColumnIndex("_id");
    try
    {
      if (paramCursor.moveToNext())
      {
        long l = paramCursor.getLong(i);
        return l;
      }
    }
    finally
    {
      paramCursor.close();
    }
    paramCursor.close();
    return 0L;
  }
  
  public UploadJobContext getUploadJobContext(String paramString1, String paramString2)
  {
    Object localObject = Integer.toString(1);
    localObject = query(new String[] { "_id", "task_cur_size", "task_total_size", "task_file_modify_time", "task_file_md5", "task_file_sha", "task_file_id" }, "task_file_path=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, localObject });
    if (localObject == null) {
      return null;
    }
    try
    {
      if (((Cursor)localObject).moveToNext())
      {
        long l = ((Cursor)localObject).getLong(0);
        paramString2 = new UploadJobContext(Long.parseLong(paramString2), l, paramString1);
        paramString2.setCurSize(((Cursor)localObject).getLong(1));
        paramString2.setTotalSize(((Cursor)localObject).getLong(2));
        paramString2.setModifyTime(((Cursor)localObject).getLong(3));
        paramString2.setMd5(((Cursor)localObject).getString(4));
        paramString2.setSha(((Cursor)localObject).getString(5));
        paramString2.setFileId(((Cursor)localObject).getString(6));
        paramString2.setFileName(Utils.getFileNameFromPath(paramString1));
        return paramString2;
      }
    }
    finally
    {
      ((Cursor)localObject).close();
    }
    ((Cursor)localObject).close();
    return null;
  }
  
  public long getUploadTaskId(String paramString1, String paramString2)
  {
    return getId(query(ID_PROJECTION, "task_file_path=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(1) }));
  }
  
  public long initDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_type", Integer.valueOf(2));
    localContentValues.put("task_uin", paramString2);
    localContentValues.put("task_cur_size", Integer.valueOf(0));
    localContentValues.put("task_total_size", Long.valueOf(paramLong1));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong2));
    localContentValues.put("task_file_id", paramString1);
    localContentValues.put("task_file_name", paramString3);
    localContentValues.put("task_local_name", paramString3);
    return insertItem(localContentValues);
  }
  
  public long initUploadTask(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_type", Integer.valueOf(1));
    localContentValues.put("task_uin", paramString2);
    localContentValues.put("task_cur_size", Integer.valueOf(0));
    localContentValues.put("task_total_size", Long.valueOf(paramLong1));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong2));
    localContentValues.put("task_file_path", paramString1);
    return insertItem(localContentValues);
  }
  
  public boolean isFileDownloading(String paramString1, String paramString2)
  {
    return getCount("task_file_id=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(2) }) == 1;
  }
  
  public boolean isFileUplading(String paramString1, String paramString2)
  {
    return getCount("task_file_path=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(1) }) == 1;
  }
  
  public boolean updateDownloadContext(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_cur_size", Long.valueOf(paramLong2));
    localContentValues.put("task_total_size", Long.valueOf(paramLong3));
    localContentValues.put("task_local_name", paramString1);
    localContentValues.put("task_file_md5", paramString2);
    return updateItem(localContentValues, paramLong1);
  }
  
  public boolean updateDownloadFileSizeAndModifyTime(long paramLong1, long paramLong2, long paramLong3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_cur_size", Integer.valueOf(0));
    localContentValues.put("task_total_size", Long.valueOf(paramLong2));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong3));
    return updateItem(localContentValues, paramLong1);
  }
  
  public boolean updateUploadContext(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_cur_size", Long.valueOf(paramLong2));
    localContentValues.put("task_total_size", Long.valueOf(paramLong3));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong4));
    localContentValues.put("task_file_id", paramString);
    return updateItem(localContentValues, paramLong1);
  }
  
  public boolean updateUploadFileMd5(long paramLong, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_file_md5", paramString1);
    localContentValues.put("task_file_sha", paramString2);
    return updateItem(localContentValues, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.store.TaskDBHelper
 * JD-Core Version:    0.7.0.1
 */