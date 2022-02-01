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
      return null;
    }
    finally
    {
      paramString1.close();
    }
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
    //   23: ldc 144
    //   25: astore_1
    //   26: aload 5
    //   28: bipush 46
    //   30: invokevirtual 139	java/lang/String:lastIndexOf	(I)I
    //   33: istore_2
    //   34: iload_2
    //   35: iflt +272 -> 307
    //   38: aload 5
    //   40: iload_2
    //   41: iconst_1
    //   42: iadd
    //   43: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   46: astore 6
    //   48: aload 5
    //   50: iload_2
    //   51: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   54: astore_1
    //   55: new 146	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   62: astore 7
    //   64: aload 7
    //   66: ldc 73
    //   68: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 154
    //   73: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 7
    //   79: aload 6
    //   81: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 156
    //   86: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 158
    //   95: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 7
    //   101: ldc 160
    //   103: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 73
    //   108: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 162
    //   113: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 7
    //   119: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore_1
    //   123: aload_0
    //   124: iconst_1
    //   125: anewarray 22	java/lang/String
    //   128: dup
    //   129: iconst_0
    //   130: ldc 73
    //   132: aastore
    //   133: aload_1
    //   134: iconst_1
    //   135: anewarray 22	java/lang/String
    //   138: dup
    //   139: iconst_0
    //   140: aload 5
    //   142: aastore
    //   143: ldc 167
    //   145: aconst_null
    //   146: invokevirtual 170	com/weiyun/sdk/store/TaskDBHelper:query	([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   149: astore_1
    //   150: aload_1
    //   151: ifnonnull +6 -> 157
    //   154: aload 5
    //   156: areturn
    //   157: iconst_m1
    //   158: istore_2
    //   159: aload_1
    //   160: invokeinterface 85 1 0
    //   165: ifeq +110 -> 275
    //   168: aload_1
    //   169: iconst_0
    //   170: invokeinterface 113 2 0
    //   175: astore 6
    //   177: aload 6
    //   179: aload 5
    //   181: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   184: istore 4
    //   186: iload 4
    //   188: ifeq +12 -> 200
    //   191: iload_2
    //   192: ifgt -33 -> 159
    //   195: iconst_0
    //   196: istore_2
    //   197: goto -38 -> 159
    //   200: aload 6
    //   202: aload 6
    //   204: ldc 176
    //   206: invokevirtual 179	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   209: iconst_1
    //   210: iadd
    //   211: aload 6
    //   213: ldc 181
    //   215: invokevirtual 179	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   218: invokevirtual 184	java/lang/String:substring	(II)Ljava/lang/String;
    //   221: invokestatic 188	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   224: invokevirtual 192	java/lang/Integer:intValue	()I
    //   227: istore_3
    //   228: iload_2
    //   229: iload_3
    //   230: if_icmpgt -71 -> 159
    //   233: iload_3
    //   234: istore_2
    //   235: goto -76 -> 159
    //   238: astore 6
    //   240: ldc 194
    //   242: aload 6
    //   244: invokestatic 200	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   247: pop
    //   248: goto -89 -> 159
    //   251: astore 5
    //   253: aload_1
    //   254: invokeinterface 129 1 0
    //   259: aload 5
    //   261: athrow
    //   262: astore 6
    //   264: ldc 194
    //   266: aload 6
    //   268: invokestatic 200	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   271: pop
    //   272: goto -113 -> 159
    //   275: iload_2
    //   276: iflt +22 -> 298
    //   279: aload 5
    //   281: iload_2
    //   282: iconst_1
    //   283: iadd
    //   284: invokestatic 206	com/weiyun/sdk/util/Utils:fileRename	(Ljava/lang/String;I)Ljava/lang/String;
    //   287: astore 5
    //   289: aload_1
    //   290: invokeinterface 129 1 0
    //   295: aload 5
    //   297: areturn
    //   298: aload_1
    //   299: invokeinterface 129 1 0
    //   304: aload 5
    //   306: areturn
    //   307: aload 5
    //   309: astore 6
    //   311: goto -256 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	TaskDBHelper
    //   0	314	1	paramString	String
    //   6	278	2	i	int
    //   227	7	3	j	int
    //   184	3	4	bool	boolean
    //   8	172	5	str1	String
    //   251	29	5	str2	String
    //   287	21	5	str3	String
    //   46	166	6	str4	String
    //   238	5	6	localNumberFormatException	java.lang.NumberFormatException
    //   262	5	6	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   309	1	6	str5	String
    //   62	56	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   200	228	238	java/lang/NumberFormatException
    //   159	186	251	finally
    //   200	228	251	finally
    //   240	248	251	finally
    //   264	272	251	finally
    //   279	289	251	finally
    //   200	228	262	java/lang/IndexOutOfBoundsException
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
      return 0L;
    }
    finally
    {
      paramCursor.close();
    }
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
      return null;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.store.TaskDBHelper
 * JD-Core Version:    0.7.0.1
 */