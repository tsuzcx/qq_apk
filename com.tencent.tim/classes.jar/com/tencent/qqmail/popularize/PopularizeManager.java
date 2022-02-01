package com.tencent.qqmail.popularize;

import androidx.annotation.NonNull;
import com.lolita.annotations.TimingDebug;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.popularize.businessfilter.PopularizeFilter;
import com.tencent.qqmail.popularize.businessfilter.PopularizeSubItemFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.Future;

public class PopularizeManager
{
  private static final String TAG = "PopularizeManager";
  private static PopularizeManager _instance = new PopularizeManager(new PopularizeSQLiteHelper(QMApplicationContext.sharedInstance()));
  private static Future<Void> instanceWithCached = Threads.submitTask(new PopularizeManager.1());
  private PopularizeSQLiteHelper sqliteHelper = null;
  
  private PopularizeManager(PopularizeSQLiteHelper paramPopularizeSQLiteHelper)
  {
    this.sqliteHelper = paramPopularizeSQLiteHelper;
  }
  
  private void initData()
  {
    this.sqliteHelper.initCache(this.sqliteHelper.getReadableDatabase());
  }
  
  public static PopularizeManager sharedInstance()
  {
    try
    {
      instanceWithCached.get();
      return _instance;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "PopularizeManager", localException.getMessage());
      }
    }
  }
  
  public void deleteAllPopularize()
  {
    this.sqliteHelper.deleteAllPopularize(this.sqliteHelper.getWritableDatabase());
    QMLog.log(4, "PopularizeManager", "delete all popularize");
  }
  
  public QMFolder generatePopularizeFolder(Popularize paramPopularize)
  {
    QMFolder localQMFolder = new QMFolder();
    if (paramPopularize != null)
    {
      localQMFolder.setId(paramPopularize.getId());
      localQMFolder.setName(paramPopularize.getSubject());
      localQMFolder.setRemoteId("REMOTE_" + paramPopularize.getServerId());
      localQMFolder.setType(130);
    }
    return localQMFolder;
  }
  
  public ArrayList<Popularize> getAllPopularize()
  {
    return this.sqliteHelper.queryPopularizeList();
  }
  
  @NonNull
  @TimingDebug
  public ArrayList<Popularize> getPopularize(@NonNull PopularizeFilter paramPopularizeFilter)
  {
    ArrayList localArrayList = this.sqliteHelper.queryPopularizeList();
    Collections.sort(localArrayList);
    return paramPopularizeFilter.filter(localArrayList);
  }
  
  public Popularize getPopularizeById(int paramInt)
  {
    return this.sqliteHelper.queryPopularizeById(paramInt);
  }
  
  public ArrayList<Popularize> getPopularizeByPage(int paramInt)
  {
    return this.sqliteHelper.queryPopularizeList(paramInt);
  }
  
  public Popularize getPopularizeBySvrId(int paramInt)
  {
    return this.sqliteHelper.queryPopularizeBySvrId(paramInt);
  }
  
  @NonNull
  public ArrayList<Popularize> getPopularizeByType(int paramInt)
  {
    return this.sqliteHelper.queryPopularizeListByType(paramInt);
  }
  
  @NonNull
  public HashMap<Popularize, ArrayList<PopularizeSubItem>> getPopularizeSubItem(@NonNull PopularizeSubItemFilter paramPopularizeSubItemFilter)
  {
    ArrayList localArrayList = this.sqliteHelper.queryPopularizeList();
    Collections.sort(localArrayList);
    return paramPopularizeSubItemFilter.filter(localArrayList);
  }
  
  public PopularizeSubItem getPopularizeSubItemById(int paramInt1, int paramInt2)
  {
    return this.sqliteHelper.queryPopularizeSubItemById(paramInt1, paramInt2);
  }
  
  public void insertPopularize(ArrayList<Popularize> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      QMLog.log(4, "PopularizeManager", "insertPopularize" + paramArrayList.size());
      this.sqliteHelper.insertPopularize(this.sqliteHelper.getWritableDatabase(), paramArrayList);
      return;
    }
    QMLog.log(4, "PopularizeManager", "insertPopularize null");
  }
  
  public void updatePopularizeCancel(int paramInt, boolean paramBoolean)
  {
    this.sqliteHelper.updateIsCancel(this.sqliteHelper.getWritableDatabase(), paramInt, paramBoolean);
    QMLog.log(4, "PopularizeManager", "update popularize cancel " + paramInt + " : " + paramBoolean);
  }
  
  public void updatePopularizeClick(int paramInt, boolean paramBoolean)
  {
    this.sqliteHelper.updateIsClick(this.sqliteHelper.getWritableDatabase(), paramInt, paramBoolean);
    QMLog.log(4, "PopularizeManager", "update popularize click " + paramInt + " : " + paramBoolean);
  }
  
  public void updatePopularizeIsRead(boolean paramBoolean, Popularize paramPopularize)
  {
    this.sqliteHelper.updatePopularizeIsRead(this.sqliteHelper.getWritableDatabase(), paramBoolean, paramPopularize.getId());
  }
  
  public void updatePopularizeListIsRender(ArrayList<Popularize> paramArrayList, boolean paramBoolean)
  {
    this.sqliteHelper.updatePopularizeListIsRender(this.sqliteHelper.getWritableDatabase(), paramArrayList, paramBoolean);
  }
  
  public void updatePopularizeListRenderTime(ArrayList<Popularize> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      this.sqliteHelper.updatePopularizeListRenderTime(this.sqliteHelper.getWritableDatabase(), paramArrayList, l);
      return;
    }
  }
  
  public void updatePopularizeMoved(int paramInt1, int paramInt2)
  {
    this.sqliteHelper.updateMove(this.sqliteHelper.getWritableDatabase(), paramInt1, paramInt2);
    QMLog.log(4, "PopularizeManager", "update popularize move " + paramInt1 + " : " + paramInt2);
  }
  
  public void updatePopularizeOpen(int paramInt, boolean paramBoolean)
  {
    this.sqliteHelper.updateIsOpen(this.sqliteHelper.getWritableDatabase(), paramInt, paramBoolean);
    QMLog.log(4, "PopularizeManager", "update popularize open " + paramInt + " : " + paramBoolean);
  }
  
  public void updatePopularizePop(int paramInt, boolean paramBoolean)
  {
    this.sqliteHelper.updateIsPopByNewMail(this.sqliteHelper.getWritableDatabase(), paramInt, paramBoolean);
    QMLog.log(4, "PopularizeManager", "update popularize isPop " + paramInt + " : " + paramBoolean);
  }
  
  public void updatePopularizeSubInformationData(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.sqliteHelper.updateSubInfomationData(this.sqliteHelper.getWritableDatabase(), paramString1, paramString2);
      QMLog.log(4, "PopularizeManager", "update popularize subinfo " + paramString1 + " : " + paramString2);
    }
  }
  
  public void updatePopularizeSubItemCancel(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.sqliteHelper.updateSubItemIsCancel(this.sqliteHelper.getWritableDatabase(), paramInt1, paramInt2, paramBoolean);
    QMLog.log(4, "PopularizeManager", "update popularize subitem cancel.popularizeID:" + paramInt1 + ",subitemID:" + paramInt2 + " : " + paramBoolean);
  }
  
  public void updatePopularizeSubItemClick(ArrayList<PopularizeSubItem> paramArrayList, boolean paramBoolean)
  {
    this.sqliteHelper.updateSubItemIsClick(this.sqliteHelper.getWritableDatabase(), paramArrayList, paramBoolean);
  }
  
  public void updatePopularizeSubItemClickMyApp(ArrayList<PopularizeSubItem> paramArrayList, boolean paramBoolean)
  {
    this.sqliteHelper.updateSubItemIsClickMyApp(this.sqliteHelper.getWritableDatabase(), paramArrayList, paramBoolean);
  }
  
  public void updatePopularizeSubItemRender(ArrayList<PopularizeSubItem> paramArrayList, boolean paramBoolean)
  {
    this.sqliteHelper.updateSubItemIsRender(this.sqliteHelper.getWritableDatabase(), paramArrayList, paramBoolean);
    if (paramBoolean)
    {
      this.sqliteHelper.updateSubItemLastRenderTime(this.sqliteHelper.getWritableDatabase(), paramArrayList, System.currentTimeMillis());
      return;
    }
    this.sqliteHelper.updateSubItemLastRenderTime(this.sqliteHelper.getWritableDatabase(), paramArrayList, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeManager
 * JD-Core Version:    0.7.0.1
 */