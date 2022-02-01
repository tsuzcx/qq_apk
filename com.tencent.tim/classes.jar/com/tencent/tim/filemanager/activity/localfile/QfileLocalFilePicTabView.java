package com.tencent.tim.filemanager.activity.localfile;

import android.content.Context;
import atgc;
import atpo;
import atpq;
import atrk;
import atwb;
import auej;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  atpq jdField_a_of_type_Atpq;
  QfilePinnedHeaderExpandableListView.a jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView$a = new atrk(this);
  
  public QfileLocalFilePicTabView(Context paramContext)
  {
    super(paramContext);
    setEditbarButton(true, false, false, true, true);
    this.runnable = new QfileLocalFilePicTabView.1(this, paramContext);
    ThreadManager.executeOnFileThread(this.runnable);
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((paramFileInfo.getType() != 0) || ((akL()) && (((atwb.d(paramFileInfo)) && (paramBoolean)) || ((!atwb.d(paramFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (akL())
    {
      if (!paramBoolean) {
        break label106;
      }
      if (!this.b.dit) {
        break label99;
      }
      atgc localatgc = (atgc)this.app.getManager(373);
      if ((localatgc != null) && (localatgc.iu() > paramFileInfo.getSize())) {
        atwb.d(paramFileInfo);
      }
    }
    for (;;)
    {
      return true;
      label99:
      atwb.d(paramFileInfo);
      continue;
      label106:
      atwb.e(paramFileInfo);
    }
  }
  
  protected atpo a()
  {
    this.jdField_a_of_type_Atpq = new atpq(a(), this.R, this.m, this.n, this.g, this.eX);
    return this.jdField_a_of_type_Atpq;
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.wB.contains(paramFileInfo)) {
      this.wB.add(paramFileInfo);
    }
    runOnUiThread(new QfileLocalFilePicTabView.3(this, paramFileInfo));
  }
  
  protected boolean c(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.getGroupName();
    this.wB.remove(paramFileInfo);
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
    ThreadManager.executeOnFileThread(new QfileLocalFilePicTabView.2(this));
  }
  
  public void dfI()
  {
    this.b.runOnUiThread(new QfileLocalFilePicTabView.4(this));
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
    setEditbarButton(true, false, false, true, true);
    if (this.b.akI()) {
      this.b.a().dlP();
    }
    for (;;)
    {
      Nx();
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView$a);
      return;
      this.b.a().dlU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */