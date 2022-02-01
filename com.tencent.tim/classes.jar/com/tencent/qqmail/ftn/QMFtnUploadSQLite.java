package com.tencent.qqmail.ftn;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QMFtnUploadSQLite
{
  private static final String TAG = "QMFtnUploadSQLite";
  private static final String sqlQueryUploadInfo = "SELECT * FROM QMFtnUpload";
  private QMFtnSQLiteHelper ftnSQLiteHelper = null;
  private SQLiteDatabase readableDb = null;
  
  public QMFtnUploadSQLite(QMFtnSQLiteHelper paramQMFtnSQLiteHelper)
  {
    this.ftnSQLiteHelper = paramQMFtnSQLiteHelper;
    this.readableDb = this.ftnSQLiteHelper.getReadableDatabase();
    if (this.readableDb == null) {
      throw new DevRuntimeException("data base connection is null");
    }
  }
  
  private ContentValues convertUploadInfo(FtnUploadInfo paramFtnUploadInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("rid", paramFtnUploadInfo.getRid());
    localContentValues.put("fid", paramFtnUploadInfo.getFid());
    localContentValues.put("md5", paramFtnUploadInfo.getMd5());
    localContentValues.put("sha", paramFtnUploadInfo.getSha());
    localContentValues.put("key", paramFtnUploadInfo.getKey());
    localContentValues.put("ip", paramFtnUploadInfo.getIp());
    localContentValues.put("port", Integer.valueOf(paramFtnUploadInfo.getPort()));
    localContentValues.put("shakey", paramFtnUploadInfo.getShakey());
    localContentValues.put("stage", Integer.valueOf(paramFtnUploadInfo.getStage()));
    localContentValues.put("progress", Integer.valueOf(paramFtnUploadInfo.getProgress()));
    localContentValues.put("schedule", Integer.valueOf(paramFtnUploadInfo.getSchedule()));
    localContentValues.put("createtime", Long.valueOf(paramFtnUploadInfo.getCreateTime()));
    localContentValues.put("name", paramFtnUploadInfo.getName());
    localContentValues.put("absolutepath", paramFtnUploadInfo.getAbsolutePath());
    localContentValues.put("filesize", Long.valueOf(paramFtnUploadInfo.getFileSize()));
    localContentValues.put("uploadedsize", Long.valueOf(paramFtnUploadInfo.getUploadedSize()));
    return localContentValues;
  }
  
  private FtnUploadInfo fillUploadInfo(Cursor paramCursor)
  {
    FtnUploadInfo localFtnUploadInfo = new FtnUploadInfo();
    localFtnUploadInfo.setRid(QMFtnSQLiteHelper.getString(paramCursor, "rid"));
    localFtnUploadInfo.setFid(QMFtnSQLiteHelper.getString(paramCursor, "fid"));
    localFtnUploadInfo.setMd5(QMFtnSQLiteHelper.getString(paramCursor, "md5"));
    localFtnUploadInfo.setSha(QMFtnSQLiteHelper.getString(paramCursor, "sha"));
    localFtnUploadInfo.setKey(QMFtnSQLiteHelper.getString(paramCursor, "key"));
    localFtnUploadInfo.setIp(QMFtnSQLiteHelper.getString(paramCursor, "ip"));
    localFtnUploadInfo.setPort(Integer.parseInt(QMFtnSQLiteHelper.getString(paramCursor, "port")));
    localFtnUploadInfo.setShakey(QMFtnSQLiteHelper.getString(paramCursor, "shakey"));
    localFtnUploadInfo.setStage(QMFtnSQLiteHelper.getInt(paramCursor, "stage"));
    localFtnUploadInfo.setProgress(QMFtnSQLiteHelper.getInt(paramCursor, "progress"));
    localFtnUploadInfo.setSchedule(QMFtnSQLiteHelper.getInt(paramCursor, "schedule"));
    localFtnUploadInfo.setCreateTime(QMFtnSQLiteHelper.getLong(paramCursor, "createtime"));
    localFtnUploadInfo.setName(QMFtnSQLiteHelper.getString(paramCursor, "name"));
    localFtnUploadInfo.setAbsolutePath(QMFtnSQLiteHelper.getString(paramCursor, "absolutepath"));
    localFtnUploadInfo.setFileSize(QMFtnSQLiteHelper.getLong(paramCursor, "filesize"));
    localFtnUploadInfo.setUploadedSize(QMFtnSQLiteHelper.getLong(paramCursor, "uploadedsize"));
    return localFtnUploadInfo;
  }
  
  public void closeDatabase()
  {
    QMLog.log(4, "QMFtnUploadSQLite", "close database");
    this.ftnSQLiteHelper.close();
  }
  
  public boolean deleteUploadInfoByFid(String paramString)
  {
    return getWritableDatabase().delete("QMFtnUpload", "fid=?", new String[] { paramString }) == 1;
  }
  
  public boolean deleteUploadInfoByRid(String paramString)
  {
    return getWritableDatabase().delete("QMFtnUpload", "rid=?", new String[] { paramString }) == 1;
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    return this.ftnSQLiteHelper.getWritableDatabase();
  }
  
  public boolean insertFtnUploadInfo(FtnUploadInfo paramFtnUploadInfo)
  {
    paramFtnUploadInfo = convertUploadInfo(paramFtnUploadInfo);
    return getWritableDatabase().replace("QMFtnUpload", null, paramFtnUploadInfo) != -1L;
  }
  
  public List<FtnUploadInfo> queryUploadInfo()
  {
    Cursor localCursor = this.readableDb.rawQuery("SELECT * FROM QMFtnUpload", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        do
        {
          localArrayList.add(fillUploadInfo(localCursor));
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public Map<String, FtnUploadInfo> queryUploadInfoByFids(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localHashMap;
    }
    paramList = this.readableDb.rawQuery("SELECT * FROM QMFtnUpload WHERE fid IN " + QMFtnSQLiteHelper.getInClause(paramList.size()), (String[])paramList.toArray(new String[paramList.size()]));
    if (paramList != null)
    {
      if (paramList.moveToFirst()) {
        do
        {
          FtnUploadInfo localFtnUploadInfo = fillUploadInfo(paramList);
          localHashMap.put(localFtnUploadInfo.getFid(), localFtnUploadInfo);
        } while (paramList.moveToNext());
      }
      paramList.close();
    }
    return localHashMap;
  }
  
  public void updateUploadInfoProgress(String paramString, int paramInt)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("progress", Integer.valueOf(paramInt));
      getWritableDatabase().update("QMFtnUpload", localContentValues, "fid=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "QMFtnUploadSQLite", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.QMFtnUploadSQLite
 * JD-Core Version:    0.7.0.1
 */