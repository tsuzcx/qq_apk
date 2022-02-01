package com.tencent.tim.filemanager.activity.localfile;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import atpo;
import atrj;
import audx;
import auej;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFileAppTabView
  extends QfileBaseLocalFileTabView
{
  public LinkedHashMap<String, List<FileInfo>> V = new LinkedHashMap();
  
  public QfileLocalFileAppTabView(Context paramContext)
  {
    super(paramContext);
    setEditbarButton(false, false, false, true, true);
  }
  
  private void c(FileInfo paramFileInfo)
  {
    if (!this.wB.contains(paramFileInfo)) {
      this.wB.add(paramFileInfo);
    }
    String str = paramFileInfo.getGroupName();
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      localObject = "未安装";
    }
    if (!this.V.containsKey(localObject)) {
      this.V.put(localObject, new ArrayList());
    }
    Object localObject = (List)this.V.get(localObject);
    if (((List)localObject).contains(paramFileInfo) == true) {
      return;
    }
    int j = audx.b((List)localObject, paramFileInfo.getDate());
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ((List)localObject).add(i, paramFileInfo);
  }
  
  protected atpo a()
  {
    return new atrj(a(), this.R, a(), this.m, this.n, this.g, this.eX, this.gt);
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    if (localLooper.getThread() != localThread)
    {
      new Handler(localLooper).post(new QfileLocalFileAppTabView.2(this, paramFileInfo));
      return;
    }
    c(paramFileInfo);
  }
  
  protected boolean c(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.getGroupName();
    if (!this.R.containsKey(str))
    {
      QLog.e(TAG, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.R.get(str)).remove(paramFileInfo);
    refreshUI();
    return true;
  }
  
  protected void dfD()
  {
    this.V.clear();
    this.V.put("已安装", new ArrayList());
    this.V.put("未安装", new ArrayList());
    this.runnable = new QfileLocalFileAppTabView.1(this);
    ThreadManager.executeOnFileThread(this.runnable);
  }
  
  public void fn(ArrayList<FileInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        c((FileInfo)paramArrayList.next());
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(false, false, false, true, true);
    if (this.b.akI()) {
      this.b.a().dlL();
    }
    for (;;)
    {
      Nx();
      return;
      this.b.a().dlQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileAppTabView
 * JD-Core Version:    0.7.0.1
 */