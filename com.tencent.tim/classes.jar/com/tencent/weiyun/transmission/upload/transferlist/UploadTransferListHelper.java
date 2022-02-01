package com.tencent.weiyun.transmission.upload.transferlist;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.utils.TsLog;

public class UploadTransferListHelper
{
  private static final String TAG = "UploadTransferListHelper";
  
  public static int deleteAllSuccessTask(String paramString)
  {
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null)
    {
      TsLog.e("UploadTransferListHelper", "deleteAllSuccessTask: Job db is null.");
      return 0;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("valid_flag", Integer.valueOf(0));
    int i = localJobDbWrapper.update("upload", localContentValues, "uid=? AND state = 5", new String[] { paramString });
    JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
    return i;
  }
  
  /* Error */
  public static String getLocalFilePath(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 24	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   5: iconst_1
    //   6: invokevirtual 28	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull +12 -> 23
    //   14: ldc 11
    //   16: ldc 73
    //   18: invokestatic 36	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 75	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   30: ldc 78
    //   32: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 84
    //   37: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 86
    //   42: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 88
    //   47: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 84
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 4
    //   60: aload_3
    //   61: ldc 53
    //   63: iconst_1
    //   64: anewarray 57	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc 94
    //   71: aastore
    //   72: aload 4
    //   74: iconst_2
    //   75: anewarray 57	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload_1
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokevirtual 98	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +30 -> 124
    //   97: aload_1
    //   98: astore_0
    //   99: aload_1
    //   100: invokeinterface 104 1 0
    //   105: ifeq +19 -> 124
    //   108: aload_1
    //   109: astore_0
    //   110: aload_1
    //   111: iconst_0
    //   112: invokeinterface 108 2 0
    //   117: astore_2
    //   118: aload_1
    //   119: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   122: aload_2
    //   123: areturn
    //   124: aload_1
    //   125: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   128: invokestatic 24	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   131: aload_3
    //   132: invokevirtual 67	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   135: goto -114 -> 21
    //   138: astore_2
    //   139: aconst_null
    //   140: astore_1
    //   141: aload_1
    //   142: astore_0
    //   143: ldc 11
    //   145: aload_2
    //   146: invokestatic 117	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_1
    //   150: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   153: goto -25 -> 128
    //   156: astore_0
    //   157: aload_2
    //   158: astore_1
    //   159: aload_1
    //   160: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   163: aload_0
    //   164: athrow
    //   165: astore_2
    //   166: aload_0
    //   167: astore_1
    //   168: aload_2
    //   169: astore_0
    //   170: goto -11 -> 159
    //   173: astore_2
    //   174: goto -33 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString1	String
    //   0	177	1	paramString2	String
    //   1	122	2	str1	String
    //   138	20	2	localThrowable1	java.lang.Throwable
    //   165	4	2	localObject	Object
    //   173	1	2	localThrowable2	java.lang.Throwable
    //   9	123	3	localJobDbWrapper	JobDbWrapper
    //   58	15	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   23	93	138	java/lang/Throwable
    //   23	93	156	finally
    //   99	108	165	finally
    //   110	118	165	finally
    //   143	149	165	finally
    //   99	108	173	java/lang/Throwable
    //   110	118	173	java/lang/Throwable
  }
  
  /* Error */
  public static UploadBean getTransferItemByFileId(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 24	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   5: iconst_1
    //   6: invokevirtual 28	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull +12 -> 23
    //   14: ldc 11
    //   16: ldc 73
    //   18: invokestatic 36	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 75	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   30: ldc 78
    //   32: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 84
    //   37: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: astore_2
    //   41: aload_3
    //   42: ldc 53
    //   44: getstatic 123	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper$TransferQuery:PROJECTION	[Ljava/lang/String;
    //   47: aload_2
    //   48: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: iconst_1
    //   52: anewarray 57	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: aload_0
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 98	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore_0
    //   66: aload_0
    //   67: ifnull +71 -> 138
    //   70: aload_0
    //   71: astore_1
    //   72: aload_0
    //   73: invokeinterface 104 1 0
    //   78: ifeq +60 -> 138
    //   81: aload_0
    //   82: astore_1
    //   83: aload_0
    //   84: invokestatic 127	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper:readFromCursor	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/transferlist/UploadBean;
    //   87: astore_2
    //   88: aload_2
    //   89: astore_1
    //   90: aload_0
    //   91: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   94: invokestatic 24	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   97: aload_3
    //   98: invokevirtual 67	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   101: aload_1
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_0
    //   107: astore_1
    //   108: ldc 11
    //   110: aload_2
    //   111: invokestatic 117	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_0
    //   115: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   118: aconst_null
    //   119: astore_1
    //   120: goto -26 -> 94
    //   123: astore_0
    //   124: aload_1
    //   125: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: goto -7 -> 124
    //   134: astore_2
    //   135: goto -29 -> 106
    //   138: aconst_null
    //   139: astore_1
    //   140: goto -50 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   1	139	1	localObject1	Object
    //   40	49	2	localObject2	Object
    //   103	8	2	localThrowable1	java.lang.Throwable
    //   134	1	2	localThrowable2	java.lang.Throwable
    //   9	89	3	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   23	66	103	java/lang/Throwable
    //   23	66	123	finally
    //   72	81	130	finally
    //   83	88	130	finally
    //   108	114	130	finally
    //   72	81	134	java/lang/Throwable
    //   83	88	134	java/lang/Throwable
  }
  
  /* Error */
  public static java.util.ArrayList<UploadBean> getTransferList(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 131	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 132	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: invokestatic 24	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   13: iconst_1
    //   14: invokevirtual 28	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnonnull +12 -> 33
    //   24: ldc 11
    //   26: ldc 134
    //   28: invokestatic 36	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_3
    //   32: areturn
    //   33: new 75	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   40: ldc 136
    //   42: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 138
    //   47: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 41
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 140
    //   57: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 142
    //   62: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 144
    //   67: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: astore_2
    //   71: aload 4
    //   73: ldc 53
    //   75: getstatic 123	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper$TransferQuery:PROJECTION	[Ljava/lang/String;
    //   78: aload_2
    //   79: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: iconst_1
    //   83: anewarray 57	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: aload_0
    //   89: aastore
    //   90: aconst_null
    //   91: aconst_null
    //   92: ldc 146
    //   94: invokevirtual 98	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   97: astore_0
    //   98: aload_0
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +51 -> 152
    //   104: aload_1
    //   105: astore_0
    //   106: aload_1
    //   107: invokeinterface 104 1 0
    //   112: ifeq +40 -> 152
    //   115: aload_1
    //   116: astore_0
    //   117: aload_3
    //   118: aload_1
    //   119: invokestatic 127	com/tencent/weiyun/transmission/upload/transferlist/UploadTransferListHelper:readFromCursor	(Landroid/database/Cursor;)Lcom/tencent/weiyun/transmission/upload/transferlist/UploadBean;
    //   122: invokevirtual 150	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: goto -22 -> 104
    //   129: astore_2
    //   130: aload_1
    //   131: astore_0
    //   132: ldc 11
    //   134: aload_2
    //   135: invokestatic 117	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: aload_1
    //   139: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   142: invokestatic 24	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   145: aload 4
    //   147: invokevirtual 67	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   150: aload_3
    //   151: areturn
    //   152: aload_1
    //   153: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   156: goto -14 -> 142
    //   159: astore_0
    //   160: aload_1
    //   161: invokestatic 114	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   164: aload_0
    //   165: athrow
    //   166: astore_2
    //   167: aload_0
    //   168: astore_1
    //   169: aload_2
    //   170: astore_0
    //   171: goto -11 -> 160
    //   174: astore_2
    //   175: aconst_null
    //   176: astore_1
    //   177: goto -47 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString	String
    //   1	176	1	str	String
    //   70	9	2	localStringBuilder	java.lang.StringBuilder
    //   129	6	2	localThrowable1	java.lang.Throwable
    //   166	4	2	localObject	Object
    //   174	1	2	localThrowable2	java.lang.Throwable
    //   9	142	3	localArrayList	java.util.ArrayList
    //   17	129	4	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   106	115	129	java/lang/Throwable
    //   117	126	129	java/lang/Throwable
    //   33	98	159	finally
    //   106	115	166	finally
    //   117	126	166	finally
    //   132	138	166	finally
    //   33	98	174	java/lang/Throwable
  }
  
  private static UploadBean readFromCursor(Cursor paramCursor)
  {
    UploadBean localUploadBean = new UploadBean();
    localUploadBean.id = paramCursor.getLong(0);
    localUploadBean.uid = paramCursor.getString(1);
    localUploadBean.localPath = paramCursor.getString(2);
    localUploadBean.localModified = paramCursor.getLong(3);
    localUploadBean.pDirKey = paramCursor.getString(4);
    localUploadBean.insertTime = paramCursor.getLong(5);
    localUploadBean.thumbUri = paramCursor.getString(6);
    localUploadBean.fileName = paramCursor.getString(7);
    localUploadBean.fileSize = paramCursor.getLong(8);
    localUploadBean.sha = paramCursor.getString(9);
    localUploadBean.longitude = paramCursor.getDouble(10);
    localUploadBean.latitude = paramCursor.getDouble(11);
    localUploadBean.takenTime = paramCursor.getLong(12);
    localUploadBean.width = paramCursor.getLong(13);
    localUploadBean.height = paramCursor.getLong(14);
    localUploadBean.duration = paramCursor.getLong(15);
    localUploadBean.batchId = paramCursor.getString(16);
    localUploadBean.batchTotal = paramCursor.getLong(17);
    localUploadBean.batchIndex = paramCursor.getLong(18);
    localUploadBean.batchDesc = paramCursor.getString(19);
    localUploadBean.state = paramCursor.getInt(20);
    localUploadBean.errorCode = paramCursor.getInt(21);
    localUploadBean.errorMsg = paramCursor.getString(22);
    localUploadBean.totalSize = paramCursor.getLong(23);
    localUploadBean.curSize = paramCursor.getLong(24);
    localUploadBean.fileId = paramCursor.getString(25);
    localUploadBean.fileVersion = paramCursor.getString(26);
    localUploadBean.cloudDirName = paramCursor.getString(27);
    localUploadBean.compressFlag = paramCursor.getInt(28);
    localUploadBean.groupUid = paramCursor.getString(29);
    localUploadBean.groupRootDirKey = paramCursor.getString(30);
    return localUploadBean;
  }
  
  static abstract interface TransferQuery
  {
    public static final int BATCH_DESC = 19;
    public static final int BATCH_ID = 16;
    public static final int BATCH_INDEX = 18;
    public static final int BATCH_TOTAL = 17;
    public static final int COMPRESS_FLAG = 28;
    public static final int CUR_SIZE = 24;
    public static final int DIR_NAME = 27;
    public static final int DURATION = 15;
    public static final int ERROR_CODE = 21;
    public static final int ERROR_MSG = 22;
    public static final int FILE_ID = 25;
    public static final int FILE_NAME = 7;
    public static final int FILE_SIZE = 8;
    public static final int FILE_VERSION = 26;
    public static final int GROUP_ROOT_DIR_KEY = 30;
    public static final int GROUP_UIN = 29;
    public static final int HEIGHT = 14;
    public static final int ID = 0;
    public static final int INSERT_TIME = 5;
    public static final int LATITUDE = 11;
    public static final int LOCAL_MODIFIED = 3;
    public static final int LOCAL_PATH = 2;
    public static final int LOCAL_SHA = 9;
    public static final int LONGITUDE = 10;
    public static final String[] PROJECTION = { "_id", "uid", "local_path", "local_modified", "p_dir_key", "insert_time", "thumb_uri", "file_name", "file_size", "local_sha", "longitude", "latitude", "taken_time", "width", "height", "duration", "batch_id", "batch_total", "batch_index", "batch_desc", "state", "error_code", "error_msg", "total_size", "cur_size", "file_id", "file_version", "p_dir_name", "compress_flag", "p_dir_uid", "group_root_dir_key" };
    public static final int P_DIR_KEY = 4;
    public static final int STATE = 20;
    public static final int TAKEN_TIME = 12;
    public static final int THUMB_URI = 6;
    public static final int TOTAL_SIZE = 23;
    public static final int UID = 1;
    public static final int WIDTH = 13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.transferlist.UploadTransferListHelper
 * JD-Core Version:    0.7.0.1
 */