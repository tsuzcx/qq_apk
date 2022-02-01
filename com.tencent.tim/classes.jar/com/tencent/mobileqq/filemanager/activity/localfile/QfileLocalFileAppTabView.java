package com.tencent.mobileqq.filemanager.activity.localfile;

import acfp;
import agdq;
import agga;
import ahav;
import ahbo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileAppTabView
  extends QfileBaseLocalFileTabView
{
  protected LinkedHashMap<String, List<FileInfo>> V = new LinkedHashMap();
  private boolean cdk;
  private boolean cdl;
  
  public QfileLocalFileAppTabView(Context paramContext, List<QfileTabBarView.a> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    setEditbarButton(false, false, true, true, false);
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
      localObject = acfp.m(2131711092);
    }
    if (!this.V.containsKey(localObject)) {
      this.V.put(localObject, new ArrayList());
    }
    Object localObject = (List)this.V.get(localObject);
    if (((List)localObject).contains(paramFileInfo) == true) {
      return;
    }
    int j = ahav.b((List)localObject, paramFileInfo.getDate());
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ((List)localObject).add(i, paramFileInfo);
  }
  
  private void dgg()
  {
    this.V.clear();
    if (this.cdi) {
      this.V.put(acfp.m(2131711088), new ArrayList());
    }
    this.V.put(acfp.m(2131711101), new ArrayList());
    this.a.a(this);
    this.runnable = new QfileLocalFileAppTabView.2(this);
    ThreadManagerV2.excute(this.runnable, 64, null, true);
  }
  
  public void IX(boolean paramBoolean)
  {
    this.cdk = paramBoolean;
    this.cdl = true;
    ThreadManagerV2.executeOnSubThread(new QfileLocalFileAppTabView.4(this, paramBoolean));
  }
  
  protected agdq a()
  {
    return new agga(a(), this.R, a(), this.m, this.n, this.g, this.eX);
  }
  
  protected boolean ala()
  {
    if (this.cdl) {
      return this.cdk;
    }
    this.cdk = this.a.getSharedPreferences("qfile_permission", 0).getBoolean("qfile_permission_access_apps", false);
    this.cdl = true;
    return this.cdk;
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    if (localLooper.getThread() != localThread)
    {
      new Handler(localLooper).post(new QfileLocalFileAppTabView.3(this, paramFileInfo));
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
    ThreadManagerV2.executeOnSubThread(new QfileLocalFileAppTabView.1(this));
  }
  
  public void m(Set<FileInfo> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        c((FileInfo)paramSet.next());
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(false, false, true, true, false);
    if (!this.a.akQ())
    {
      if (!this.a.akI()) {
        break label50;
      }
      this.a.a().dlL();
    }
    for (;;)
    {
      Nx();
      return;
      label50:
      this.a.a().dlQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView
 * JD-Core Version:    0.7.0.1
 */