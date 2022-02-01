package com.tencent.qqmail.download;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DownloadInfoSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  protected static final String FIELD_DOWNLOAD_INFO_ACCOUNT_ID = "accountId";
  protected static final String FIELD_DOWNLOAD_INFO_ATTACH_ID = "attachId";
  protected static final String FIELD_DOWNLOAD_INFO_ATTACH_TYPE = "attachType";
  protected static final String FIELD_DOWNLOAD_INFO_COOKIES = "cookies";
  protected static final String FIELD_DOWNLOAD_INFO_CREATE_TIME = "createTime";
  protected static final String FIELD_DOWNLOAD_INFO_DOWNLOAD_SIZE = "downloadSize";
  protected static final String FIELD_DOWNLOAD_INFO_DOWNLOAD_TYPE = "downloadType";
  protected static final String FIELD_DOWNLOAD_INFO_FID = "fid";
  protected static final String FIELD_DOWNLOAD_INFO_FILE_NAME = "fileName";
  protected static final String FIELD_DOWNLOAD_INFO_FILE_PATH = "filePath";
  protected static final String FIELD_DOWNLOAD_INFO_FILE_SIZE = "fileSize";
  protected static final String FIELD_DOWNLOAD_INFO_FTN_BYTES = "ftnBytes";
  protected static final String FIELD_DOWNLOAD_INFO_FTN_CODE = "ftnCode";
  protected static final String FIELD_DOWNLOAD_INFO_FTN_KEY = "ftnKey";
  protected static final String FIELD_DOWNLOAD_INFO_ID = "id";
  protected static final String FIELD_DOWNLOAD_INFO_KEY = "key";
  protected static final String FIELD_DOWNLOAD_INFO_OFFLINE_TYPE = "offline";
  protected static final String FIELD_DOWNLOAD_INFO_SAVE_PATH = "savePath";
  protected static final String FIELD_DOWNLOAD_INFO_SESSION_TYPE = "sessionType";
  protected static final String FIELD_DOWNLOAD_INFO_STATUS = "status";
  protected static final String FIELD_DOWNLOAD_INFO_URL = "url";
  protected static final String FIELD_DOWNLOAD_INFP_MAIL_ID = "mailId";
  private static final String FILENAME = "QMDownloadInfo";
  protected static final String TABLE_DOWNLOAD_INFO = "QM_DOWNLOAD_INFO";
  private static final String TAG = "DownloadInfoSQLite";
  private static final String sqlCreateDownloadInfo = "CREATE TABLE IF NOT EXISTS QM_DOWNLOAD_INFO(id integer primary key, accountId integer, mailId integer, attachId integer, fid varchar, ftnKey varchar, ftnCode varchar, ftnBytes integer, key varchar, url varchar, cookies varchar, fileName varchar, filePath varchar, savePath varchar, fileSize integer, downloadSize integer, createTime integer, downloadType integer, sessionType integer, attachType integer, status integer, offline integer )";
  private static final String sqlDeleteDownloadInfoBeforeTime = "DELETE FROM QM_DOWNLOAD_INFO WHERE status != 4 AND createTime < ?";
  private static final String sqlDeleteDownloadInfoByAccountId = "DELETE FROM QM_DOWNLOAD_INFO WHERE accountId = ?";
  private static final String sqlDeleteDownloadInfoById = "DELETE FROM QM_DOWNLOAD_INFO WHERE id = ?";
  private static final String sqlDeleteDownloadInfoByPath = "DELETE FROM QM_DOWNLOAD_INFO WHERE filePath = ?";
  private static final String sqlDropDownloadInfo = " DROP TABLE IF EXISTS QM_DOWNLOAD_INFO";
  private static final String sqlInsertDownloadInfo = "REPLACE INTO QM_DOWNLOAD_INFO (id , accountId , mailId , attachId , fid , ftnKey , ftnCode , ftnBytes , key , url , cookies , fileName , filePath , savePath , fileSize , downloadSize , createTime , downloadType , sessionType , attachType , status, offline  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlSelectAttachIdAndTypeByPath = "SELECT attachId,fid,attachType FROM QM_DOWNLOAD_INFO WHERE filePath = ? ";
  private static final String sqlSelectDownloadInfo = "SELECT * FROM QM_DOWNLOAD_INFO WHERE offline = 0 ORDER BY (CASE WHEN status = 4 THEN 1 ELSE 0 END), createTime desc";
  private static final String sqlSelectDownloadInfoById = "SELECT * FROM QM_DOWNLOAD_INFO WHERE id = ?";
  private static final String sqlSelectDownloadInfoByKey = "SELECT * FROM QM_DOWNLOAD_INFO WHERE key = ?";
  private static final String sqlSelectDownloadInfoCount = "SELECT COUNT(*) FROM QM_DOWNLOAD_INFO";
  private static final String sqlSelectDownloadInfoPaths = "SELECT filePath FROM QM_DOWNLOAD_INFO";
  private static final String sqlSelectDownloadInfoPathsExcludeFtn = "SELECT filePath FROM QM_DOWNLOAD_INFO WHERE attachType NOT IN (2,1) ";
  private static final String sqlSelectUnCompletedDownloadInfo = "SELECT COUNT(*) FROM QM_DOWNLOAD_INFO WHERE status != 4 AND offline = 0";
  private static final DownloadInfoSQLiteUpgradeManager upgradeManager = new DownloadInfoSQLiteUpgradeManager();
  
  public DownloadInfoSQLiteHelper(Context paramContext)
  {
    super(paramContext, "QMDownloadInfo", null, upgradeManager.getVersion());
  }
  
  private static void beginColumnIndex(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = 0;
    }
  }
  
  public static DownloadInfo fillDownloadInfo(Cursor paramCursor, int[] paramArrayOfInt)
  {
    beginColumnIndex(paramArrayOfInt);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "id")));
    localDownloadInfo.setAccountId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "accountId")));
    localDownloadInfo.setMailId(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "mailId")));
    localDownloadInfo.setAttachId(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "attachId")));
    localDownloadInfo.setFid(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "fid")));
    localDownloadInfo.setFtnKey(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "ftnKey")));
    localDownloadInfo.setFtnCode(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "ftnCode")));
    localDownloadInfo.setFtnBytes(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "ftnBytes")));
    localDownloadInfo.setKey(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "key")));
    localDownloadInfo.setUrl(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "url")));
    localDownloadInfo.setCookies(DownloadUtil.formatCookie(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "cookies"))));
    localDownloadInfo.setFileName(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "fileName")));
    localDownloadInfo.setFilePath(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "filePath")));
    localDownloadInfo.setSaveAsPath(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "savePath")));
    localDownloadInfo.setFileSize(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "fileSize")));
    localDownloadInfo.setDownloadSize(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "downloadSize")));
    localDownloadInfo.setCreateTime(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "createTime")));
    localDownloadInfo.setSessionType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "sessionType")));
    localDownloadInfo.setDownloadType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "downloadType")));
    localDownloadInfo.setAttachType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "attachType")));
    localDownloadInfo.setStatus(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "status")));
    localDownloadInfo.setOfflineType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "offline")));
    return localDownloadInfo;
  }
  
  private static int getColumnIndex(int[] paramArrayOfInt, Cursor paramCursor, String paramString)
  {
    if (paramArrayOfInt == null) {
      return paramCursor.getColumnIndex(paramString);
    }
    int i = paramArrayOfInt[0] + 1;
    paramArrayOfInt[0] = i;
    if ((paramArrayOfInt[i] > -2147483648) && (paramArrayOfInt[i] != -1)) {
      return paramArrayOfInt[i];
    }
    paramArrayOfInt[i] = paramCursor.getColumnIndex(paramString);
    return paramArrayOfInt[i];
  }
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_DOWNLOAD_INFO(id integer primary key, accountId integer, mailId integer, attachId integer, fid varchar, ftnKey varchar, ftnCode varchar, ftnBytes integer, key varchar, url varchar, cookies varchar, fileName varchar, filePath varchar, savePath varchar, fileSize integer, downloadSize integer, createTime integer, downloadType integer, sessionType integer, attachType integer, status integer, offline integer )");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "DownloadInfoSQLite", paramSQLiteDatabase.getMessage());
    }
  }
  
  public void deleteDownloadInfoBeforeTime(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_DOWNLOAD_INFO WHERE status != 4 AND createTime < ?", new String[] { String.valueOf(paramLong) });
  }
  
  public void deleteDownloadInfoByAccountId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_DOWNLOAD_INFO WHERE accountId = ?", new String[] { String.valueOf(paramInt) });
  }
  
  public void deleteDownloadInfoById(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_DOWNLOAD_INFO WHERE id = ?", new String[] { String.valueOf(paramInt) });
  }
  
  public void deleteDownloadInfoByPaths(SQLiteDatabase paramSQLiteDatabase, ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_DOWNLOAD_INFO WHERE filePath = ?", new String[] { (String)paramArrayList.next() });
    }
  }
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL(" DROP TABLE IF EXISTS QM_DOWNLOAD_INFO");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "DownloadInfoSQLite", paramSQLiteDatabase.getMessage());
    }
  }
  
  public int getAllDownloadInfoCount(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    int j = 0;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM QM_DOWNLOAD_INFO", null);
    if (paramSQLiteDatabase != null)
    {
      i = j;
      if (paramSQLiteDatabase.moveToFirst()) {
        i = paramSQLiteDatabase.getInt(0);
      }
      paramSQLiteDatabase.close();
    }
    return i;
  }
  
  public int getUnCompletedCnt(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    int j = 0;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM QM_DOWNLOAD_INFO WHERE status != 4 AND offline = 0", null);
    if (paramSQLiteDatabase != null)
    {
      i = j;
      if (paramSQLiteDatabase.moveToFirst()) {
        i = paramSQLiteDatabase.getInt(0);
      }
      paramSQLiteDatabase.close();
    }
    return i;
  }
  
  public void insertDownloadInfo(SQLiteDatabase paramSQLiteDatabase, DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_DOWNLOAD_INFO (id , accountId , mailId , attachId , fid , ftnKey , ftnCode , ftnBytes , key , url , cookies , fileName , filePath , savePath , fileSize , downloadSize , createTime , downloadType , sessionType , attachType , status, offline  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(paramDownloadInfo.getId()), Integer.valueOf(paramDownloadInfo.getAccountId()), Long.valueOf(paramDownloadInfo.getMailId()), Long.valueOf(paramDownloadInfo.getAttachId()), paramDownloadInfo.getFid(), paramDownloadInfo.getFtnKey(), paramDownloadInfo.getFtnCode(), Long.valueOf(paramDownloadInfo.getFtnBytes()), paramDownloadInfo.getKey(), paramDownloadInfo.getUrl(), DownloadUtil.formatCookie(paramDownloadInfo.getCookies()), paramDownloadInfo.getFileName(), paramDownloadInfo.getFilePath(), paramDownloadInfo.getSaveAsPath(), Long.valueOf(paramDownloadInfo.getFileSize()), Long.valueOf(paramDownloadInfo.getDownloadSize()), Long.valueOf(paramDownloadInfo.getCreateTime()), Integer.valueOf(paramDownloadInfo.getSessionType()), Integer.valueOf(paramDownloadInfo.getDownloadType()), Integer.valueOf(paramDownloadInfo.getAttachType()), Integer.valueOf(paramDownloadInfo.getStatus()), Integer.valueOf(paramDownloadInfo.getOfflineType()) });
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createTable(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "DownloadInfoSQLite", "Try Upgrade: from " + paramInt1 + " to " + paramInt2 + ", minVer:" + upgradeManager.getMinSupportVersion());
    if (paramInt1 < upgradeManager.getMinSupportVersion())
    {
      dropTable(paramSQLiteDatabase);
      createTable(paramSQLiteDatabase);
      return;
    }
    if (upgradeManager.upgrade(this, paramSQLiteDatabase, paramInt1))
    {
      QMLog.log(4, "DownloadInfoSQLite", "Upgraded from " + paramInt1 + " to " + paramInt2);
      return;
    }
    QMLog.log(4, "DownloadInfoSQLite", "No need upgrade from " + paramInt1 + " to " + paramInt2);
  }
  
  public ArrayList<DownloadInfo> queryAttachIdAndTypeByDeletePaths(SQLiteDatabase paramSQLiteDatabase, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT attachId,fid,attachType FROM QM_DOWNLOAD_INFO WHERE filePath = ? ", new String[] { (String)paramArrayList.next() });
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          DownloadInfo localDownloadInfo = new DownloadInfo();
          localDownloadInfo.setAttachId(localCursor.getLong(localCursor.getColumnIndex("attachId")));
          localDownloadInfo.setFid(localCursor.getString(localCursor.getColumnIndex("fid")));
          localDownloadInfo.setAttachType(localCursor.getInt(localCursor.getColumnIndex("attachType")));
          localArrayList.add(localDownloadInfo);
        }
        localCursor.close();
      }
    }
    return localArrayList;
  }
  
  public Cursor queryDownloadInfo(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.rawQuery("SELECT * FROM QM_DOWNLOAD_INFO WHERE offline = 0 ORDER BY (CASE WHEN status = 4 THEN 1 ELSE 0 END), createTime desc", null);
  }
  
  public DownloadInfo queryDownloadInfoById(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int[] arrayOfInt = new int[100];
    Arrays.fill(arrayOfInt, -2147483648);
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_DOWNLOAD_INFO WHERE id = ?", new String[] { String.valueOf(paramInt) });
    paramSQLiteDatabase = localObject2;
    if (localCursor != null)
    {
      paramSQLiteDatabase = localObject1;
      if (localCursor.moveToFirst()) {
        paramSQLiteDatabase = fillDownloadInfo(localCursor, arrayOfInt);
      }
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  public DownloadInfo queryDownloadInfoByKey(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_DOWNLOAD_INFO WHERE key = ?", new String[] { paramString });
    paramString = localObject2;
    if (paramSQLiteDatabase != null)
    {
      paramString = localObject1;
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramString = new int[100];
        Arrays.fill(paramString, -2147483648);
        paramString = fillDownloadInfo(paramSQLiteDatabase, paramString);
      }
      paramSQLiteDatabase.close();
    }
    return paramString;
  }
  
  public ArrayList<String> queryDownloadPaths(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "SELECT filePath FROM QM_DOWNLOAD_INFO";; str = "SELECT filePath FROM QM_DOWNLOAD_INFO WHERE attachType NOT IN (2,1) ")
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(str, null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("filePath")));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
  }
  
  public void updateDownloadInfo(SQLiteDatabase paramSQLiteDatabase, DownloadInfo paramDownloadInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fileName", paramDownloadInfo.getFileName());
    localContentValues.put("filePath", paramDownloadInfo.getFilePath());
    localContentValues.put("downloadSize", Long.valueOf(paramDownloadInfo.getDownloadSize()));
    localContentValues.put("fileSize", Long.valueOf(paramDownloadInfo.getFileSize()));
    localContentValues.put("status", Integer.valueOf(paramDownloadInfo.getStatus()));
    localContentValues.put("offline", Integer.valueOf(paramDownloadInfo.getOfflineType()));
    paramSQLiteDatabase.update("QM_DOWNLOAD_INFO", localContentValues, "id = ?", new String[] { String.valueOf(paramDownloadInfo.getId()) });
  }
  
  public void updateDownloadInfoCookie(SQLiteDatabase paramSQLiteDatabase, DownloadInfo paramDownloadInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("cookies", DownloadUtil.formatCookie(paramDownloadInfo.getCookies()));
    paramSQLiteDatabase.update("QM_DOWNLOAD_INFO", localContentValues, "id = ?", new String[] { String.valueOf(paramDownloadInfo.getId()) });
  }
  
  public void updateDownloadInfoOfflineByPaths(SQLiteDatabase paramSQLiteDatabase, int paramInt, ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("offline", String.valueOf(paramInt));
      paramSQLiteDatabase.update("QM_DOWNLOAD_INFO", localContentValues, "filePath = ?", new String[] { str });
    }
  }
  
  public void updateDownloadInfoPathByAttachId(SQLiteDatabase paramSQLiteDatabase, long paramLong, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("filePath", paramString);
    paramSQLiteDatabase.update("QM_DOWNLOAD_INFO", localContentValues, "attachId = ?", new String[] { String.valueOf(paramLong) });
  }
  
  public void updateDownloadInfoPathByFid(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("filePath", paramString2);
    paramSQLiteDatabase.update("QM_DOWNLOAD_INFO", localContentValues, "fid = ?", new String[] { paramString1 });
  }
  
  public void updateDownloadInfoPathByUrl(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("filePath", paramString2);
    paramSQLiteDatabase.update("QM_DOWNLOAD_INFO", localContentValues, "url = ?", new String[] { paramString1 });
  }
  
  public void updateDownloadInfoStatus(SQLiteDatabase paramSQLiteDatabase, DownloadInfo paramDownloadInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(paramDownloadInfo.getStatus()));
    paramSQLiteDatabase.update("QM_DOWNLOAD_INFO", localContentValues, "id = ?", new String[] { String.valueOf(paramDownloadInfo.getId()) });
  }
  
  public void upgradeTableFor5103(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_DOWNLOAD_INFO ADD COLUMN fid VARCHAR NULL");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_DOWNLOAD_INFO ADD COLUMN ftnKey VARCHAR NULL");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_DOWNLOAD_INFO ADD COLUMN ftnCode VARCHAR NULL");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_DOWNLOAD_INFO ADD COLUMN ftnBytes INTEGER DEFAULT 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.DownloadInfoSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */