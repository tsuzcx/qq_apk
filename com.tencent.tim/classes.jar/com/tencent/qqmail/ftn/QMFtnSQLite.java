package com.tencent.qqmail.ftn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.callback.FtnQueryExpireCallback;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.model.FtnUserProfile;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class QMFtnSQLite
{
  public static String COUNT = "cnt";
  public static String LABEL;
  public static String TAG = "SQL_LOG";
  private static final String queryExpireInfo = "SELECT * FROM QMFtnExpireInfo WHERE accountid = ?";
  private static final String sqlDeleteDownloadInfoByFid = "DELETE FROM QMFtnDownloadInfo WHERE fid=?";
  private static final String sqlDeleteSavePathByPath = "UPDATE QMFtnDownloadInfo SET savename ='' WHERE savename = ?";
  private static final String sqlQueryCompressPreview = "SELECT * FROM QMFtnCompressPrev WHERE id=?";
  private static final String sqlQueryDownloadInfo = "SELECT * FROM QMFtnDownloadInfo WHERE fid=?";
  private static final String sqlQueryExistByFids = "SELECT fid from QMFtn WHERE fid IN $fids$";
  private static final String sqlQueryExpireTimes = "SELECT expiretime, fid FROM QMFtn";
  private static final String sqlQueryExtName = "SELECT extname FROM QMFtn WHERE fid = ?";
  private static final String sqlQueryExtraInfo = "SELECT extravalue FROM QMFtnExtraInfo WHERE extrakey=?";
  private static final String sqlQueryFidByFileType = "SELECT fid FROM QMFtn WHERE filetype =? ORDER BY createtime DESC";
  private static final String sqlQueryFidByFileTypeAndName = "SELECT fid FROM QMFtn WHERE filetype =? AND filename LIKE ? ORDER BY createtime DESC";
  private static final String sqlQueryFtnByFids = "SELECT * FROM QMFtn WHERE fid";
  private static final String sqlQueryFtnByFileType = "SELECT * FROM QMFtn WHERE filetype =? ORDER BY createtime DESC";
  private static final String sqlQueryFtnByFileTypeAndName = "SELECT * FROM QMFtn WHERE filetype =? AND filename LIKE ? ORDER BY createtime DESC";
  private static final String sqlQueryFtnByFtnType = "SELECT * FROM QMFtn WHERE isfav =? ORDER BY createtime DESC";
  private static final String sqlQueryFtnByFtnTypeAndName = "SELECT * FROM QMFtn WHERE isfav =? AND filename LIKE ? ORDER BY createtime DESC";
  private static final String sqlQueryUserProfile = "SELECT * FROM QMFtnUserProf WHERE uin=?";
  private QMFtnSQLiteHelper ftnSQLiteHelper = null;
  private SQLiteDatabase readableDb = null;
  
  static
  {
    LABEL = "labelvalue";
  }
  
  public QMFtnSQLite(Context paramContext, String paramString)
  {
    this.ftnSQLiteHelper = new QMFtnSQLiteHelper(paramContext, paramString);
    this.readableDb = this.ftnSQLiteHelper.getReadableDatabase();
    if (this.readableDb == null) {
      throw new DevRuntimeException("database connection is null");
    }
  }
  
  private static ContentValues convertExpireInfo(FtnExpireInfo paramFtnExpireInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("accountid", Long.valueOf(paramFtnExpireInfo.getAccountId()));
    localContentValues.put("expirecnt", Integer.valueOf(paramFtnExpireInfo.getLstExpireCnt()));
    localContentValues.put("totalcnt", Integer.valueOf(paramFtnExpireInfo.getLstTotalCnt()));
    localContentValues.put("updatetime", Long.valueOf(paramFtnExpireInfo.getLstUpdateTime()));
    localContentValues.put("extrainfo", paramFtnExpireInfo.getLstExpHashId());
    return localContentValues;
  }
  
  private static ContentValues convertFileInfo(FileInfo paramFileInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fid", paramFileInfo.fid);
    localContentValues.put("sha", paramFileInfo.sha);
    localContentValues.put("md5", paramFileInfo.md5);
    localContentValues.put("key", paramFileInfo.key);
    localContentValues.put("filename", paramFileInfo.filename);
    localContentValues.put("aliasname", paramFileInfo.aliasname);
    localContentValues.put("createtime", Integer.valueOf(paramFileInfo.createtime));
    localContentValues.put("expiretime", Integer.valueOf(paramFileInfo.expiretime));
    localContentValues.put("filesize", Long.valueOf(paramFileInfo.filesize));
    localContentValues.put("uploadsize", Long.valueOf(paramFileInfo.uploadsize));
    localContentValues.put("downloadtimes", Integer.valueOf(paramFileInfo.downloadtimes));
    localContentValues.put("code", paramFileInfo.code);
    localContentValues.put("viewtype", Integer.valueOf(paramFileInfo.viewtype));
    localContentValues.put("filetype", Integer.valueOf(paramFileInfo.filetype));
    localContentValues.put("isfav", Boolean.valueOf(paramFileInfo.isfav));
    localContentValues.put("isdir", Boolean.valueOf(paramFileInfo.isdir));
    localContentValues.put("favdir", paramFileInfo.favdir);
    return localContentValues;
  }
  
  public static FileInfo fillFileInfo(Cursor paramCursor)
  {
    boolean bool2 = true;
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.fid = QMFtnSQLiteHelper.getString(paramCursor, "fid");
    localFileInfo.sha = QMFtnSQLiteHelper.getString(paramCursor, "sha");
    localFileInfo.md5 = QMFtnSQLiteHelper.getString(paramCursor, "key");
    localFileInfo.key = QMFtnSQLiteHelper.getString(paramCursor, "key");
    localFileInfo.filename = QMFtnSQLiteHelper.getString(paramCursor, "filename");
    localFileInfo.aliasname = QMFtnSQLiteHelper.getString(paramCursor, "aliasname");
    localFileInfo.createtime = QMFtnSQLiteHelper.getInt(paramCursor, "createtime");
    localFileInfo.expiretime = QMFtnSQLiteHelper.getInt(paramCursor, "expiretime");
    localFileInfo.filesize = QMFtnSQLiteHelper.getInt(paramCursor, "filesize");
    localFileInfo.uploadsize = QMFtnSQLiteHelper.getInt(paramCursor, "uploadsize");
    localFileInfo.downloadtimes = QMFtnSQLiteHelper.getInt(paramCursor, "downloadtimes");
    localFileInfo.code = QMFtnSQLiteHelper.getString(paramCursor, "code");
    localFileInfo.viewtype = QMFtnSQLiteHelper.getInt(paramCursor, "viewtype");
    localFileInfo.filetype = QMFtnSQLiteHelper.getInt(paramCursor, "filetype");
    if (QMFtnSQLiteHelper.getInt(paramCursor, "isfav") == 1)
    {
      bool1 = true;
      localFileInfo.isfav = bool1;
      if (QMFtnSQLiteHelper.getInt(paramCursor, "isdir") != 1) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localFileInfo.isdir = bool1;
      localFileInfo.favdir = QMFtnSQLiteHelper.getString(paramCursor, "favdir");
      return localFileInfo;
      bool1 = false;
      break;
    }
  }
  
  private void resetUnknowFileType(ContentValues paramContentValues)
  {
    if (((Integer)paramContentValues.get("filetype")).intValue() == 0) {
      paramContentValues.put("filetype", Integer.valueOf(99));
    }
  }
  
  private void setFileNameSortIdx(ContentValues paramContentValues)
  {
    String str2 = ((String)paramContentValues.get("aliasname")).substring(0, 1);
    String str1 = str2;
    if (Character.isDigit(str2.charAt(0)) == true) {
      str1 = "#";
    }
    paramContentValues.put("namesortidx", str1);
  }
  
  public void closeDatabase()
  {
    QMLog.log(4, TAG, "close database");
    this.ftnSQLiteHelper.close();
  }
  
  public boolean deleteDatabase()
  {
    QMLog.log(4, TAG, "delete database");
    String str = this.ftnSQLiteHelper.getDatabaseName();
    this.ftnSQLiteHelper.close();
    return QMApplicationContext.sharedInstance().deleteDatabase(str);
  }
  
  public void deleteDownloadInfoByFid(String paramString)
  {
    getWritableDatabase().execSQL("DELETE FROM QMFtnDownloadInfo WHERE fid=?", new String[] { paramString });
  }
  
  public boolean deleteFtn()
  {
    return getWritableDatabase().delete("QMFtn", null, null) > 0;
  }
  
  public boolean deleteFtn(List<String> paramList)
  {
    boolean bool = true;
    if (paramList.size() == 1)
    {
      paramList = (String)paramList.get(0);
      return getWritableDatabase().delete("QMFtn", "fid=?", new String[] { paramList }) > 0;
    }
    if (getWritableDatabase().delete("QMFtn", "fid IN " + QMFtnSQLiteHelper.getInClause(paramList.size()), (String[])paramList.toArray(new String[paramList.size()])) > 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void deleteSavePathByPath(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      getWritableDatabase().execSQL("UPDATE QMFtnDownloadInfo SET savename ='' WHERE savename = ?", new String[] { str });
    }
  }
  
  public FtnDownloadInfo getDownloadInfo(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = this.readableDb.rawQuery("SELECT * FROM QMFtnDownloadInfo WHERE fid=?", new String[] { paramString });
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = new FtnDownloadInfo(paramString, QMFtnSQLiteHelper.getString(localCursor, "savename"), QMFtnSQLiteHelper.getLong(localCursor, "createtime"), QMFtnSQLiteHelper.getLong(localCursor, "size"));
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public String getExtraInfo(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = this.readableDb.rawQuery("SELECT extravalue FROM QMFtnExtraInfo WHERE extrakey=?", new String[] { paramString });
    paramString = localObject2;
    if (localCursor != null)
    {
      paramString = localObject1;
      if (localCursor.moveToFirst()) {
        paramString = localCursor.getString(0);
      }
      localCursor.close();
    }
    return paramString;
  }
  
  public HashMap<String, Integer> getFidByFileType(int paramInt)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    Cursor localCursor = this.readableDb.rawQuery("SELECT fid FROM QMFtn WHERE filetype =? ORDER BY createtime DESC", new String[] { String.valueOf(paramInt) });
    if (localCursor != null)
    {
      paramInt = i;
      while (localCursor.moveToNext())
      {
        localHashMap.put(QMFtnSQLiteHelper.getString(localCursor, "fid"), Integer.valueOf(paramInt));
        paramInt += 1;
      }
      localCursor.close();
    }
    return localHashMap;
  }
  
  public HashMap<String, Integer> getFidByFileTypeAndName(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "";
    if (!StringExtention.isNullOrEmpty(paramString)) {
      str = "%" + paramString + "%";
    }
    paramString = this.readableDb.rawQuery("SELECT fid FROM QMFtn WHERE filetype =? AND filename LIKE ? ORDER BY createtime DESC", new String[] { String.valueOf(paramInt), String.valueOf(str) });
    if (paramString != null)
    {
      paramInt = 0;
      while (paramString.moveToNext())
      {
        localHashMap.put(QMFtnSQLiteHelper.getString(paramString, "fid"), Integer.valueOf(paramInt));
        paramInt += 1;
      }
      paramString.close();
    }
    return localHashMap;
  }
  
  public Set<String> getFidsByFids(List<String> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = StringExtention.replace("SELECT fid from QMFtn WHERE fid IN $fids$", "fids", QMFtnSQLiteHelper.getInClause(paramList));
    paramList = this.readableDb.rawQuery(paramList, null);
    if ((paramList != null) && (paramList.moveToFirst())) {
      do
      {
        localHashSet.add(QMFtnSQLiteHelper.getString(paramList, "fid"));
      } while (paramList.moveToNext());
    }
    return localHashSet;
  }
  
  public FtnUI getFtnByFtnType(int paramInt)
  {
    return new FtnUI(null, this.readableDb.rawQuery("SELECT * FROM QMFtn WHERE isfav =? ORDER BY createtime DESC", new String[] { String.valueOf(paramInt) }));
  }
  
  public void getFtnExpireTimesAsync(long paramLong, FtnQueryExpireCallback paramFtnQueryExpireCallback)
  {
    int i = 0;
    int j = 0;
    Object localObject = "";
    Cursor localCursor = this.readableDb.rawQuery("SELECT expiretime, fid FROM QMFtn", null);
    if (localCursor != null)
    {
      int k = localCursor.getCount();
      if (localCursor.moveToFirst())
      {
        localObject = new StringBuilder();
        do
        {
          i = j;
          if (FtnCommonUtils.isAbortExpire(localCursor.getInt(localCursor.getColumnIndex("expiretime"))))
          {
            i = j + 1;
            ((StringBuilder)localObject).append(localCursor.getString(localCursor.getColumnIndex("fid")));
          }
          j = i;
        } while (localCursor.moveToNext());
        localObject = QMMath.hashPositivetInt(((StringBuilder)localObject).toString()) + "";
        updateFtnExpireInfoHashId(paramLong, (String)localObject);
      }
      localCursor.close();
      j = k;
    }
    for (;;)
    {
      if (paramFtnQueryExpireCallback != null) {
        paramFtnQueryExpireCallback.onComplete(paramLong, i, j, (String)localObject);
      }
      return;
      localObject = "";
      j = 0;
      i = 0;
    }
  }
  
  public long getFtnRefMailId(String paramString)
  {
    long l2 = 0L;
    paramString = this.readableDb.rawQuery("SELECT extname FROM QMFtn WHERE fid = ?", new String[] { paramString });
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.moveToFirst())
      {
        String str = QMMailSQLite.getString(paramString, "extname");
        l1 = l2;
        if (str != null)
        {
          l1 = l2;
          if (!str.equals("")) {
            l1 = Long.parseLong(str);
          }
        }
      }
      paramString.close();
    }
    return l1;
  }
  
  public FtnUI getFtnUI(int paramInt1, int paramInt2)
  {
    Cursor localCursor2;
    Cursor localCursor1;
    if (paramInt2 == 3)
    {
      localCursor2 = this.readableDb.rawQuery(String.format("select count(*) as %s,((%s - %d) / %d) > 0 as %s from %s where %s = ? group by %s order by %s desc ", new Object[] { COUNT, "expiretime", Long.valueOf(DateExtension.getCurrentTimeSecondsFrom_1970_1_1()), Long.valueOf(DateExtension.getSecsOfDays(3)), LABEL, "QMFtn", "isfav", LABEL, LABEL }), new String[] { "" + paramInt1 });
      localCursor1 = this.readableDb.rawQuery(String.format("select * from %s where %s = ? order by %s asc", new Object[] { "QMFtn", "isfav", "expiretime" }), new String[] { "" + paramInt1 });
    }
    for (;;)
    {
      return new FtnUI(localCursor2, localCursor1);
      if (paramInt2 == 1)
      {
        localCursor2 = this.readableDb.rawQuery(String.format("select count(*) as %s,(%s + %d) > %d as %s from %s where %s = ? group by %s order by %s desc ", new Object[] { COUNT, "createtime", Long.valueOf(DateExtension.getSecsOfDays(7)), Long.valueOf(DateExtension.getCurrentTimeSecondsFrom_1970_1_1()), LABEL, "QMFtn", "isfav", LABEL, LABEL }), new String[] { "" + paramInt1 });
        localCursor1 = this.readableDb.rawQuery(String.format("select * from %s where %s = ? order by %s desc", new Object[] { "QMFtn", "isfav", "createtime" }), new String[] { "" + paramInt1 });
      }
      else if (paramInt2 == 2)
      {
        localCursor2 = this.readableDb.rawQuery(String.format("select count(*) as %s, %s from %s where %s = ? group by %s order by %s asc", new Object[] { COUNT, "namesortidx", "QMFtn", "isfav", "namesortidx", "namesortidx" }), new String[] { "" + paramInt1 });
        localCursor1 = this.readableDb.rawQuery(String.format("select * from %s where %s = ? order by %s asc", new Object[] { "QMFtn", "isfav", "aliasname" }), new String[] { "" + paramInt1 });
      }
      else
      {
        if (paramInt2 != 4) {
          break;
        }
        localCursor2 = this.readableDb.rawQuery(String.format("select count(*) as %s, %s from %s where %s = ? group by %s order by %s asc", new Object[] { COUNT, "filetype", "QMFtn", "isfav", "filetype", "filetype" }), new String[] { "" + paramInt1 });
        localCursor1 = this.readableDb.rawQuery(String.format("select * from %s where %s = ? order by %s asc", new Object[] { "QMFtn", "isfav", "filetype" }), new String[] { "" + paramInt1 });
      }
    }
    throw new IllegalArgumentException("sort type error");
  }
  
  public FtnUI getFtnUIByFids(List<String> paramList)
  {
    return new FtnUI(null, this.readableDb.rawQuery("SELECT * FROM QMFtn WHERE fid IN " + QMFtnSQLiteHelper.getInClause(paramList.size()), (String[])paramList.toArray(new String[paramList.size()])));
  }
  
  public FtnUI getFtnUIByFileType(int paramInt)
  {
    return new FtnUI(null, this.readableDb.rawQuery("SELECT * FROM QMFtn WHERE filetype =? ORDER BY createtime DESC", new String[] { String.valueOf(paramInt) }));
  }
  
  public FtnUI getFtnUIByFileTypeAndName(int paramInt, String paramString)
  {
    String str = "";
    if (!StringExtention.isNullOrEmpty(paramString)) {
      str = "%" + paramString + "%";
    }
    return new FtnUI(null, this.readableDb.rawQuery("SELECT * FROM QMFtn WHERE filetype =? AND filename LIKE ? ORDER BY createtime DESC", new String[] { String.valueOf(paramInt), String.valueOf(str) }));
  }
  
  public FtnUI getFtnUIByFtnTypeAndName(int paramInt, String paramString)
  {
    String str = "";
    if (!StringExtention.isNullOrEmpty(paramString)) {
      str = "%" + paramString + "%";
    }
    return new FtnUI(null, this.readableDb.rawQuery("SELECT * FROM QMFtn WHERE isfav =? AND filename LIKE ? ORDER BY createtime DESC", new String[] { String.valueOf(paramInt), String.valueOf(str) }));
  }
  
  public QMFtnSQLiteHelper getSqliteHeler()
  {
    return this.ftnSQLiteHelper;
  }
  
  protected String getStringInClause(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayList.size();
    int i = 0;
    if (i < j)
    {
      String str = (String)paramArrayList.get(i);
      if ((str == null) || (str.equals(""))) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("'" + str + "'");
        if (i != j - 1) {
          localStringBuilder.append(",");
        }
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public FtnUserProfile getUserProfile(String paramString)
  {
    Cursor localCursor = this.readableDb.rawQuery("SELECT * FROM QMFtnUserProf WHERE uin=?", new String[] { paramString });
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      localCursor.moveToFirst();
      label113:
      for (;;)
      {
        try
        {
          paramString = new FtnUserProfile(paramString);
          localException1.printStackTrace();
        }
        catch (Exception localException1)
        {
          try
          {
            paramString.setRenewDay(QMFtnSQLiteHelper.getInt(localCursor, "renewday"));
            paramString.setPreserverDay(QMFtnSQLiteHelper.getLong(localCursor, "preserverday"));
            paramString.setSingleMaxSize(QMFtnSQLiteHelper.getLong(localCursor, "singlemaxsize"));
            paramString.setUsage(QMFtnSQLiteHelper.getFloat(localCursor, "usage"));
            paramString.setStorage(QMFtnSQLiteHelper.getFloat(localCursor, "storage"));
            localCursor.close();
            return paramString;
          }
          catch (Exception localException2)
          {
            break label113;
          }
          localException1 = localException1;
          paramString = null;
        }
      }
    }
    return null;
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    return this.ftnSQLiteHelper.getWritableDatabase();
  }
  
  public boolean insertCompressPreview(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", paramString1);
    localContentValues.put("prevtree", paramArrayOfByte);
    localContentValues.put("vkey", paramString2);
    localContentValues.put("downhost", paramString3);
    return getWritableDatabase().insert("QMFtnCompressPrev", null, localContentValues) != -1L;
  }
  
  public boolean insertDownloadInfo(FtnDownloadInfo paramFtnDownloadInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fid", paramFtnDownloadInfo.getFid());
    localContentValues.put("savename", paramFtnDownloadInfo.getSavePath());
    localContentValues.put("createtime", Long.valueOf(paramFtnDownloadInfo.getCreateTime()));
    localContentValues.put("size", Long.valueOf(paramFtnDownloadInfo.getSize()));
    return getWritableDatabase().replace("QMFtnDownloadInfo", null, localContentValues) != -1L;
  }
  
  public boolean insertFtn(List<FileInfo> paramList)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    boolean bool;
    try
    {
      localSQLiteDatabase.beginTransactionNonExclusive();
      paramList = paramList.iterator();
      bool = true;
      ContentValues localContentValues;
      for (;;) {}
    }
    catch (Exception paramList)
    {
      paramList = paramList;
      bool = true;
      QMLog.log(6, TAG, Log.getStackTraceString(paramList));
      return bool;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    for (;;)
    {
      bool = false;
    }
  }
  
  public boolean insertFtnExpireInfo(FtnExpireInfo paramFtnExpireInfo)
  {
    paramFtnExpireInfo = convertExpireInfo(paramFtnExpireInfo);
    return getWritableDatabase().replace("QMFtnExpireInfo", null, paramFtnExpireInfo) != -1L;
  }
  
  public boolean isFtnExsit(String paramString)
  {
    paramString = this.readableDb.rawQuery("select count(*) from QMFtn where fid=?", new String[] { paramString });
    int i;
    if ((paramString != null) && (paramString.moveToNext()))
    {
      i = paramString.getInt(0);
      paramString.close();
    }
    for (;;)
    {
      return i > 0;
      i = 0;
    }
  }
  
  public FtnExpireInfo readFtnExpireInfo(long paramLong)
  {
    FtnExpireInfo localFtnExpireInfo = new FtnExpireInfo();
    Object localObject = null;
    try
    {
      Cursor localCursor = this.readableDb.rawQuery("SELECT * FROM QMFtnExpireInfo WHERE accountid = ?", new String[] { paramLong + "" });
      localObject = localCursor;
    }
    catch (Exception localException)
    {
      label52:
      break label52;
    }
    if (localObject != null)
    {
      if (localObject.moveToFirst())
      {
        localFtnExpireInfo.setAccountId(paramLong);
        localFtnExpireInfo.setLstExpireCnt(QMMailSQLite.getInt(localObject, "expirecnt"));
        localFtnExpireInfo.setLstTotalCnt(QMMailSQLite.getInt(localObject, "totalcnt"));
        localFtnExpireInfo.setLstUpdateTime(QMMailSQLite.getLong(localObject, "updatetime"));
        localFtnExpireInfo.setLstExpHashId(QMMailSQLite.getString(localObject, "extrainfo"));
      }
      localObject.close();
      return localFtnExpireInfo;
    }
    localFtnExpireInfo.setAccountId(-2L);
    return localFtnExpireInfo;
  }
  
  public boolean setExtraInfo(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extrakey", paramString1);
    localContentValues.put("extravalue", paramString2);
    return getWritableDatabase().replace("QMFtnExtraInfo", null, localContentValues) > 0L;
  }
  
  public boolean updateDownloadInfoById(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("savename", paramString2);
    return getWritableDatabase().update("QMFtnDownloadInfo", localContentValues, "fid=?", new String[] { paramString1 }) != -1;
  }
  
  public boolean updateFtn(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put(paramString2, paramString3);
    localHashMap1.put(paramString1, localHashMap2);
    return updateFtn(localHashMap1);
  }
  
  public boolean updateFtn(HashMap<String, HashMap<String, String>> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    boolean bool2 = true;
    if (paramHashMap.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)paramHashMap.next();
      ContentValues localContentValues = new ContentValues();
      Iterator localIterator = ((HashMap)localEntry1.getValue()).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator.next();
        localContentValues.put((String)localEntry2.getKey(), (String)localEntry2.getValue());
      }
      if (getWritableDatabase().update("QMFtn", localContentValues, "fid=?", new String[] { (String)localEntry1.getKey() }) > 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1 & bool2;
        break;
      }
    }
    return bool2;
  }
  
  public boolean updateFtnExpireInfoHashId(long paramLong, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extrainfo", paramString);
    return getWritableDatabase().update("QMFtnExpireInfo", localContentValues, "accountid=?", new String[] { String.valueOf(paramLong) }) != -1;
  }
  
  public boolean updateFtnExpireInfoUpdateTime(long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("updatetime", Long.valueOf(paramLong2));
    return getWritableDatabase().update("QMFtnExpireInfo", localContentValues, "accountid=?", new String[] { String.valueOf(paramLong1) }) != -1;
  }
  
  public boolean updateFtnRefMailId(String paramString, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extname", Long.valueOf(paramLong));
    return getWritableDatabase().update("QMFtn", localContentValues, "fid=?", new String[] { paramString }) != -1;
  }
  
  public boolean updateUserProfile(FtnUserProfile paramFtnUserProfile)
  {
    bool1 = true;
    bool2 = true;
    if (paramFtnUserProfile == null) {
      return false;
    }
    localCursor = this.readableDb.rawQuery("SELECT * FROM QMFtnUserProf WHERE uin=?", new String[] { paramFtnUserProfile.getUin() });
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.getCount() > 0) {
          continue;
        }
        localContentValues = new ContentValues();
        localContentValues.put("uin", paramFtnUserProfile.getUin());
        localContentValues.put("renewday", Integer.valueOf(paramFtnUserProfile.getRenewDay()));
        localContentValues.put("preserverday", Long.valueOf(paramFtnUserProfile.getPreserverDay()));
        localContentValues.put("singlemaxsize", Long.valueOf(paramFtnUserProfile.getSingleMaxSize()));
        localContentValues.put("usage", Float.valueOf(paramFtnUserProfile.getUsage()));
        localContentValues.put("storage", Float.valueOf(paramFtnUserProfile.getStorage()));
        long l = getWritableDatabase().insert("QMFtnUserProf", null, localContentValues);
        if (l == -1L) {
          continue;
        }
        bool1 = bool2;
        bool2 = bool1;
        if (localCursor != null)
        {
          localCursor.close();
          bool2 = bool1;
        }
      }
      catch (Exception paramFtnUserProfile)
      {
        ContentValues localContentValues;
        int i;
        paramFtnUserProfile.printStackTrace();
        bool2 = bool1;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        bool2 = bool1;
        continue;
      }
      finally
      {
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      return bool2;
      bool1 = false;
      continue;
      localContentValues = new ContentValues();
      localContentValues.put("uin", paramFtnUserProfile.getUin());
      localContentValues.put("renewday", Integer.valueOf(paramFtnUserProfile.getRenewDay()));
      localContentValues.put("preserverday", Long.valueOf(paramFtnUserProfile.getPreserverDay()));
      localContentValues.put("singlemaxsize", Long.valueOf(paramFtnUserProfile.getSingleMaxSize()));
      localContentValues.put("usage", Float.valueOf(paramFtnUserProfile.getUsage()));
      localContentValues.put("storage", Float.valueOf(paramFtnUserProfile.getStorage()));
      i = getWritableDatabase().update("QMFtnUserProf", localContentValues, "uin=?", new String[] { paramFtnUserProfile.getUin() });
      bool1 = bool2;
      if (i <= 0) {
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.QMFtnSQLite
 * JD-Core Version:    0.7.0.1
 */