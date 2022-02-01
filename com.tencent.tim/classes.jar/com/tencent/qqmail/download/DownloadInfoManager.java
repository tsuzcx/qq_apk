package com.tencent.qqmail.download;

import android.content.Context;
import android.database.Cursor;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.download.cursor.DownloadInfoCursor;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DownloadInfoManager
{
  private static final String TAG = "DownloadInfoManager";
  private DownloadInfoSQLiteHelper sqLiteHelper;
  
  private DownloadInfoManager(Context paramContext)
  {
    this.sqLiteHelper = new DownloadInfoSQLiteHelper(paramContext);
  }
  
  public static DownloadInfoManager shareInstance()
  {
    return SingleTon.instance;
  }
  
  public void clearAttachDisk(long paramLong, int paramInt)
  {
    int i = 1;
    QMAttachManager localQMAttachManager = QMAttachManager.sharedInstance();
    if (paramInt == 1) {}
    for (paramInt = i;; paramInt = 0)
    {
      localQMAttachManager.updateAttachDisk(paramLong, "", "", "", paramInt);
      return;
    }
  }
  
  public void clearFtnDisk(String paramString)
  {
    FtnManager.sharedInstance().deleteDownloadInfoByFid(paramString);
  }
  
  public void clearInvalidDownloadInfoData()
  {
    Cursor localCursor = getDownloadRawCursor();
    ArrayList localArrayList = Lists.newArrayList();
    int[] arrayOfInt = new int[100];
    Arrays.fill(arrayOfInt, -2147483648);
    while (localCursor.moveToNext())
    {
      DownloadInfo localDownloadInfo = DownloadInfoSQLiteHelper.fillDownloadInfo(localCursor, arrayOfInt);
      if ((localDownloadInfo.getStatus() == 4) && (!FileUtil.isFileExist(localDownloadInfo.getFilePath()))) {
        localArrayList.add(Integer.valueOf(localDownloadInfo.getId()));
      }
    }
    localCursor.close();
    shareInstance().deleteDownloadInfos(localArrayList);
  }
  
  public void deleteDownloadFile(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.getStatus() == 4)
    {
      paramDownloadInfo.setOfflineType(2);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramDownloadInfo.getFilePath());
      deleteDownloadInfoOfflineByPaths(localArrayList);
      if (paramDownloadInfo.getAttachType() == 2) {
        clearFtnDisk(paramDownloadInfo.getFid());
      }
      for (;;)
      {
        Threads.runInBackground(new DownloadInfoManager.1(this, paramDownloadInfo));
        return;
        clearAttachDisk(paramDownloadInfo.getAttachId(), paramDownloadInfo.getAttachType());
      }
    }
    deleteDownloadInfoById(paramDownloadInfo.getId());
  }
  
  public void deleteDownloadFile(ArrayList<DownloadInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      deleteDownloadFile((DownloadInfo)paramArrayList.next());
    }
  }
  
  public void deleteDownloadInfoBeforeTime(long paramLong)
  {
    this.sqLiteHelper.deleteDownloadInfoBeforeTime(this.sqLiteHelper.getWritableDatabase(), paramLong);
  }
  
  public void deleteDownloadInfoByAccountId(int paramInt)
  {
    this.sqLiteHelper.deleteDownloadInfoByAccountId(this.sqLiteHelper.getWritableDatabase(), paramInt);
  }
  
  public void deleteDownloadInfoById(int paramInt)
  {
    this.sqLiteHelper.deleteDownloadInfoById(this.sqLiteHelper.getWritableDatabase(), paramInt);
  }
  
  public void deleteDownloadInfoByPaths(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    QMLog.log(4, "DownloadInfoManager", "delete attach:" + paramArrayList.toString());
    FtnManager localFtnManager = FtnManager.sharedInstance();
    if ((localFtnManager != null) && (paramBoolean)) {
      localFtnManager.deleteSavePathByPath(paramArrayList);
    }
    QMAttachManager.sharedInstance().deleteAttachDisk(paramArrayList, paramBoolean);
    this.sqLiteHelper.deleteDownloadInfoByPaths(this.sqLiteHelper.getWritableDatabase(), paramArrayList);
  }
  
  public void deleteDownloadInfoOfflineByPaths(ArrayList<String> paramArrayList)
  {
    this.sqLiteHelper.updateDownloadInfoOfflineByPaths(this.sqLiteHelper.getWritableDatabase(), 2, paramArrayList);
  }
  
  public void deleteDownloadInfos(ArrayList<Integer> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      deleteDownloadInfoById(((Integer)paramArrayList.next()).intValue());
    }
  }
  
  public int getAllDownloadInfoCount()
  {
    return this.sqLiteHelper.getAllDownloadInfoCount(this.sqLiteHelper.getReadableDatabase());
  }
  
  public DownloadInfoCursor getDownloadCursor()
  {
    return new DownloadInfoCursor(this.sqLiteHelper);
  }
  
  public DownloadInfo getDownloadInfoById(int paramInt)
  {
    return this.sqLiteHelper.queryDownloadInfoById(this.sqLiteHelper.getReadableDatabase(), paramInt);
  }
  
  public DownloadInfo getDownloadInfoByKey(String paramString)
  {
    if (!StringExtention.isNullOrEmpty(paramString)) {
      return this.sqLiteHelper.queryDownloadInfoByKey(paramString, this.sqLiteHelper.getReadableDatabase());
    }
    return null;
  }
  
  public Cursor getDownloadRawCursor()
  {
    return this.sqLiteHelper.queryDownloadInfo(this.sqLiteHelper.getReadableDatabase());
  }
  
  public ArrayList<String> getPathsInAttachDownloadDir(boolean paramBoolean)
  {
    ArrayList localArrayList1 = this.sqLiteHelper.queryDownloadPaths(this.sqLiteHelper.getReadableDatabase(), paramBoolean);
    Object localObject = FileUtil.getAttachDownloadDir();
    if (localObject == null) {
      return Lists.newArrayList();
    }
    ArrayList localArrayList2 = Lists.newArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if ((str1 != null) && (str1.lastIndexOf(File.separator) != -1))
      {
        String str2 = new File(str1).getParent();
        if (!("" + str2 + File.separator).equals(localObject)) {
          localArrayList2.add(str1);
        }
      }
    }
    localObject = localArrayList2.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList1.remove((String)((Iterator)localObject).next());
    }
    return localArrayList1;
  }
  
  public int getUnCompletedCnt()
  {
    return this.sqLiteHelper.getUnCompletedCnt(this.sqLiteHelper.getReadableDatabase());
  }
  
  public void insertDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    this.sqLiteHelper.insertDownloadInfo(this.sqLiteHelper.getWritableDatabase(), paramDownloadInfo);
  }
  
  public void moveDownloadFile(DownloadInfo paramDownloadInfo, String paramString)
  {
    File localFile = new File(paramDownloadInfo.getFilePath());
    if (localFile.exists())
    {
      paramString = paramString + FileUtil.rename(paramString, paramDownloadInfo.getFileName());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramDownloadInfo.getFilePath());
      deleteDownloadInfoOfflineByPaths(localArrayList);
      paramDownloadInfo.setFilePath(paramString);
      if (paramDownloadInfo.getAttachType() != 2) {
        break label110;
      }
      updateFtnDisk(paramDownloadInfo.getFid(), paramDownloadInfo.getFilePath());
    }
    for (;;)
    {
      Threads.runInBackground(new DownloadInfoManager.2(this, localFile, paramString, paramDownloadInfo));
      return;
      label110:
      updateAttachDisk(paramDownloadInfo.getAttachId(), paramDownloadInfo.getAttachType(), paramDownloadInfo.getDisplayName(), paramDownloadInfo.getFilePath());
    }
  }
  
  public void moveDownloadFile(ArrayList<DownloadInfo> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      moveDownloadFile((DownloadInfo)paramArrayList.next(), paramString);
    }
  }
  
  public void updateAttachDisk(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    int i = 1;
    QMAttachManager localQMAttachManager = QMAttachManager.sharedInstance();
    if (paramInt == 1) {}
    for (paramInt = i;; paramInt = 0)
    {
      localQMAttachManager.updateAttachDisk(paramLong, paramString1, paramString2, paramString2, paramInt);
      return;
    }
  }
  
  public void updateDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    this.sqLiteHelper.updateDownloadInfo(this.sqLiteHelper.getWritableDatabase(), paramDownloadInfo);
  }
  
  public void updateDownloadInfoCookie(DownloadInfo paramDownloadInfo)
  {
    this.sqLiteHelper.updateDownloadInfoCookie(this.sqLiteHelper.getWritableDatabase(), paramDownloadInfo);
  }
  
  public void updateDownloadInfoPathByAttachId(long paramLong, String paramString)
  {
    this.sqLiteHelper.updateDownloadInfoPathByAttachId(this.sqLiteHelper.getWritableDatabase(), paramLong, paramString);
  }
  
  public void updateDownloadInfoPathByFid(String paramString1, String paramString2)
  {
    this.sqLiteHelper.updateDownloadInfoPathByFid(this.sqLiteHelper.getWritableDatabase(), paramString1, paramString2);
  }
  
  public void updateDownloadInfoPathByUrl(String paramString1, String paramString2)
  {
    this.sqLiteHelper.updateDownloadInfoPathByUrl(this.sqLiteHelper.getWritableDatabase(), paramString1, paramString2);
  }
  
  public void updateDownloadInfoStatus(DownloadInfo paramDownloadInfo)
  {
    this.sqLiteHelper.updateDownloadInfoStatus(this.sqLiteHelper.getWritableDatabase(), paramDownloadInfo);
  }
  
  public void updateFtnDisk(String paramString1, String paramString2)
  {
    FtnManager.sharedInstance().updateDownloadInfoById(paramString1, paramString2);
  }
  
  static class SingleTon
  {
    private static DownloadInfoManager instance = new DownloadInfoManager(QMApplicationContext.sharedInstance(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.DownloadInfoManager
 * JD-Core Version:    0.7.0.1
 */