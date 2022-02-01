package com.tencent.qqmail.ftn;

import android.content.Context;
import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager;
import java.util.List;

public class QMFtnSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  private static final String CREATE_TABLE_COMPRESSPREV = "CREATE TABLE IF NOT EXISTS QMFtnCompressPrev(id varchar primary key, prevtree blob, vkey varchar, downhost varchar )";
  private static final String CREATE_TABLE_DOWNLOAD_INFO = "CREATE TABLE IF NOT EXISTS QMFtnDownloadInfo(fid varchar primary key, savename varchar, createtime integer, size integer )";
  private static final String CREATE_TABLE_EXPIREINFO = "CREATE TABLE IF NOT EXISTS QMFtnExpireInfo(accountid varchar primary key, expirecnt integer, totalcnt integer, updatetime integer, extrainfo varchar )";
  private static final String CREATE_TABLE_EXTRAINFO = "CREATE TABLE IF NOT EXISTS QMFtnExtraInfo(extrakey varchar primary key, extravalue varchar )";
  private static final String CREATE_TABLE_FTN = "CREATE TABLE IF NOT EXISTS QMFtn(fid varchar primary key, sha varchar ,md5 varchar ,key varchar ,filename varchar ,aliasname varchar ,createtime integer ,expiretime integer ,filesize integer ,uploadsize integer ,downloadtimes integer ,code varchar,viewtype integer,filetype integer,extname varchar,isfav integer default 0,isdir integer default 0,favdir varchar,namesortidx varchar)";
  private static final String CREATE_TABLE_UPLOAD = "CREATE TABLE IF NOT EXISTS QMFtnUpload(rid varchar primary key, fid varchar ,md5 varchar ,sha varchar ,key varchar ,ip varchar ,port varchar ,shakey varchar ,stage integer ,progress integer ,schedule integer ,createtime integer ,name varchar , absolutepath varchar, filesize integer, uploadedsize integer default 0)";
  private static final String CREATE_TABLE_USERPROF = "CREATE TABLE IF NOT EXISTS QMFtnUserProf(uin varchar primary key, renewday integer, preserverday integer, singlemaxsize integer, usage integer, storage integer )";
  private static final String DB_NAME = "QMFtnDB";
  public static final String FIELD_COMPRESS_PREVIEW_DOWNLOAD_HOST = "downhost";
  public static final String FIELD_COMPRESS_PREVIEW_ID = "id";
  public static final String FIELD_COMPRESS_PREVIEW_PREVTREE = "prevtree";
  public static final String FIELD_COMPRESS_PREVIEW_VKEY = "vkey";
  public static final String FIELD_DOWNLOAD_INFO_CREATE_TIME = "createtime";
  public static final String FIELD_DOWNLOAD_INFO_FID = "fid";
  public static final String FIELD_DOWNLOAD_INFO_SAVE_NAME = "savename";
  public static final String FIELD_DOWNLOAD_INFO_SIZE = "size";
  public static final String FIELD_EXPIRE_INFO_ACCOUNT_ID = "accountid";
  public static final String FIELD_EXPIRE_INFO_EXPIRE_CNT = "expirecnt";
  public static final String FIELD_EXPIRE_INFO_EXTRA_INFO = "extrainfo";
  public static final String FIELD_EXPIRE_INFO_TOTAL_CNT = "totalcnt";
  public static final String FIELD_EXPIRE_INFO_UPDATE_TIME = "updatetime";
  public static final String FIELD_EXTRA_INFO_KEY = "extrakey";
  public static final String FIELD_EXTRA_INFO_VALUE = "extravalue";
  public static final String FIELD_FTN_ALIAS_NAME = "aliasname";
  public static final String FIELD_FTN_CODE = "code";
  public static final String FIELD_FTN_CREATE_TIME = "createtime";
  public static final String FIELD_FTN_DOWNLOAD_TIMES = "downloadtimes";
  public static final String FIELD_FTN_EXPIRE_TIME = "expiretime";
  public static final String FIELD_FTN_EXT_NAME = "extname";
  public static final String FIELD_FTN_FAV_DIR = "favdir";
  public static final String FIELD_FTN_FID = "fid";
  public static final String FIELD_FTN_FILE_NAME = "filename";
  public static final String FIELD_FTN_FILE_SIZE = "filesize";
  public static final String FIELD_FTN_FILE_TYPE = "filetype";
  public static final String FIELD_FTN_IS_DIR = "isdir";
  public static final String FIELD_FTN_IS_FAV = "isfav";
  public static final String FIELD_FTN_KEY = "key";
  public static final String FIELD_FTN_MD5 = "md5";
  public static final String FIELD_FTN_NAME_SORT_IDX = "namesortidx";
  public static final String FIELD_FTN_SHA = "sha";
  public static final String FIELD_FTN_UPLOAD_SIZE = "uploadsize";
  public static final String FIELD_FTN_VIEW_TYPE = "viewtype";
  public static final String FIELD_UPLOAD_ABSOLUTE_PATH = "absolutepath";
  public static final String FIELD_UPLOAD_CREATE_TIME = "createtime";
  public static final String FIELD_UPLOAD_FID = "fid";
  public static final String FIELD_UPLOAD_FILE_SIZE = "filesize";
  public static final String FIELD_UPLOAD_IP = "ip";
  public static final String FIELD_UPLOAD_KEY = "key";
  public static final String FIELD_UPLOAD_MD5 = "md5";
  public static final String FIELD_UPLOAD_NAME = "name";
  public static final String FIELD_UPLOAD_PORT = "port";
  public static final String FIELD_UPLOAD_PROGRESS = "progress";
  public static final String FIELD_UPLOAD_RID = "rid";
  public static final String FIELD_UPLOAD_SCHEDULE = "schedule";
  public static final String FIELD_UPLOAD_SHA = "sha";
  public static final String FIELD_UPLOAD_SHA_KEY = "shakey";
  public static final String FIELD_UPLOAD_STAGE = "stage";
  public static final String FIELD_UPLOAD_UPLOADED_SIZE = "uploadedsize";
  public static final String FIELD_USER_PROFILE_PRESERVER_DAY = "preserverday";
  public static final String FIELD_USER_PROFILE_RENEW_DAY = "renewday";
  public static final String FIELD_USER_PROFILE_SINGLE_MAXSIZE = "singlemaxsize";
  public static final String FIELD_USER_PROFILE_STORAGE = "storage";
  public static final String FIELD_USER_PROFILE_UIN = "uin";
  public static final String FIELD_USER_PROFILE_USAGE = "usage";
  public static final String TABLE_COMPRESS_PREVIEW = "QMFtnCompressPrev";
  public static final String TABLE_DOWNLOAD_INFO = "QMFtnDownloadInfo";
  public static final String TABLE_EXPIRE_INFO = "QMFtnExpireInfo";
  public static final String TABLE_EXTRA_INFO = "QMFtnExtraInfo";
  public static final String TABLE_FTN = "QMFtn";
  public static final String TABLE_UPLOAD = "QMFtnUpload";
  public static final String TABLE_USER_PROFILE = "QMFtnUserProf";
  private static final String TAG = "QMFtnBaseSQLite";
  private static final SQLiteDatabase.CursorFactory cursorFactory = null;
  private static final QMSQLiteDatabaseUpgradeManager upgradeManager = new FtnDatabaseUpgradeManager(null);
  protected String mUin = "";
  
  public QMFtnSQLiteHelper(Context paramContext, String paramString)
  {
    super(paramContext, "QMFtnDB" + paramString, cursorFactory, upgradeManager.getVersion());
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException();
    }
    this.mUin = paramString;
  }
  
  public static byte[] getBlob(Cursor paramCursor, String paramString)
  {
    return paramCursor.getBlob(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  public static float getFloat(Cursor paramCursor, String paramString)
  {
    return paramCursor.getFloat(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  public static String getInClause(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      if (i != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("?");
      i += 1;
    }
    return "(" + localStringBuilder.toString() + ")";
  }
  
  @Deprecated
  public static String getInClause(List<String> paramList)
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
  
  public static int getInt(Cursor paramCursor, String paramString)
  {
    return paramCursor.getInt(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  public static boolean getIntAsBoolean(Cursor paramCursor, String paramString)
  {
    return getInt(paramCursor, paramString) != 0;
  }
  
  public static long getLong(Cursor paramCursor, String paramString)
  {
    return paramCursor.getLong(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  public static String getString(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  public String getDatabaseName()
  {
    return "QMFtnDB" + this.mUin;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMFtn(fid varchar primary key, sha varchar ,md5 varchar ,key varchar ,filename varchar ,aliasname varchar ,createtime integer ,expiretime integer ,filesize integer ,uploadsize integer ,downloadtimes integer ,code varchar,viewtype integer,filetype integer,extname varchar,isfav integer default 0,isdir integer default 0,favdir varchar,namesortidx varchar)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMFtnUpload(rid varchar primary key, fid varchar ,md5 varchar ,sha varchar ,key varchar ,ip varchar ,port varchar ,shakey varchar ,stage integer ,progress integer ,schedule integer ,createtime integer ,name varchar , absolutepath varchar, filesize integer, uploadedsize integer default 0)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMFtnCompressPrev(id varchar primary key, prevtree blob, vkey varchar, downhost varchar )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMFtnDownloadInfo(fid varchar primary key, savename varchar, createtime integer, size integer )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMFtnUserProf(uin varchar primary key, renewday integer, preserverday integer, singlemaxsize integer, usage integer, storage integer )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMFtnExtraInfo(extrakey varchar primary key, extravalue varchar )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QMFtnExpireInfo(accountid varchar primary key, expirecnt integer, totalcnt integer, updatetime integer, extrainfo varchar )");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    upgradeManager.upgrade(null, paramSQLiteDatabase, paramInt1);
  }
  
  static final class FtnDatabaseUpgradeManager
    extends QMSQLiteDatabaseUpgradeManager
  {
    private final int MIN_VERSION = 0;
    private final int VERSION = 4;
    
    public SparseArray<ISQLIteDatabaseUpgrade> addVersions()
    {
      SparseArray localSparseArray = new SparseArray();
      addVersion(localSparseArray, new QMFtnSQLiteHelper.FtnDatabaseUpgradeManager.1(this, this));
      addVersion(localSparseArray, new QMFtnSQLiteHelper.FtnDatabaseUpgradeManager.2(this, this));
      addVersion(localSparseArray, new QMFtnSQLiteHelper.FtnDatabaseUpgradeManager.3(this, this));
      return localSparseArray;
    }
    
    public int getMinVersion()
    {
      return 0;
    }
    
    public int getVersion()
    {
      return 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.QMFtnSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */