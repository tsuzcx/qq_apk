package com.tencent.tim.filemanager.activity.localfile;

import android.content.Context;
import atpo;
import atrj;
import auej;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFileMediaTabView
  extends QfileBaseLocalFileTabView
{
  private int cWS = 3;
  
  public QfileLocalFileMediaTabView(Context paramContext, int paramInt)
  {
    super(paramContext);
    setEditbarButton(false, false, false, true, true);
    this.cWS = paramInt;
    this.runnable = new QfileLocalFileMediaTabView.1(this, paramInt, paramContext);
    ThreadManager.executeOnFileThread(this.runnable);
  }
  
  protected atpo a()
  {
    return new atrj(a(), this.R, a(), this.m, this.n, this.g, this.eX, this.gt);
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.wB.contains(paramFileInfo)) {
      this.wB.add(paramFileInfo);
    }
    runOnUiThread(new QfileLocalFileMediaTabView.3(this, paramFileInfo));
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
    this.runnable = new QfileLocalFileMediaTabView.2(this);
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
      this.b.a().dlN();
    }
    for (;;)
    {
      Nx();
      return;
      this.b.a().dlS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileMediaTabView
 * JD-Core Version:    0.7.0.1
 */