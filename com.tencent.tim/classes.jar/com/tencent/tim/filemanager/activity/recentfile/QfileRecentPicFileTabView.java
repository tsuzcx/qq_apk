package com.tencent.tim.filemanager.activity.recentfile;

import android.content.Context;
import atpo;
import atps;
import atsg;
import atsh;
import atsi;
import atsn;
import atso;
import atti;
import atwb;
import aueh;
import auei;
import auej;
import auem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentPicFileTabView
  extends QfileBaseRecentFileTabView
{
  QfilePinnedHeaderExpandableListView.a a;
  private auei b;
  private atsn d;
  
  public QfileRecentPicFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView$a = new atsi(this);
    if (this.d == null) {
      bMC();
    }
    dgj();
    setEditbarButton(true, true, true, true, true);
  }
  
  public QfileRecentPicFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView$a = new atsi(this);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void Nx()
  {
    if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akI()) {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlF();
    }
    while (this.jdField_b_of_type_Auei != null)
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
      return;
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlK();
    }
    this.jdField_b_of_type_Auei = new atsh(this);
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 0) || ((akL()) && (((atwb.b(paramFileManagerEntity)) && (paramBoolean)) || ((!atwb.b(paramFileManagerEntity)) && (!paramBoolean))))) {
      return false;
    }
    if (akL())
    {
      if (!paramBoolean) {
        break label59;
      }
      atwb.a(paramFileManagerEntity);
    }
    for (;;)
    {
      return true;
      label59:
      atwb.b(paramFileManagerEntity);
    }
  }
  
  private void bMC()
  {
    this.d = new atsg(this);
  }
  
  protected atpo a()
  {
    return new atps(a(), this.R, this.m, this.n, this.g, this.eX);
  }
  
  protected void dfD()
  {
    if (this.AT == null) {
      return;
    }
    this.R.clear();
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId());
    }
    Iterator localIterator = this.AT.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 0) && (!mX(localFileManagerEntity.cloudType)))
      {
        if ((!aueh.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) && (!aueh.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath)))
        {
          if (localFileManagerEntity.getCloudType() != 1) {
            break label203;
          }
          this.app.a().a(localFileManagerEntity, 7);
        }
        for (;;)
        {
          String str = auem.cl(localFileManagerEntity.srvTime);
          if (!this.R.containsKey(str)) {
            this.R.put(str, new ArrayList());
          }
          ((List)this.R.get(str)).add(localFileManagerEntity);
          break;
          label203:
          if (localFileManagerEntity.getCloudType() == 2) {
            this.app.a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 4, localFileManagerEntity);
          }
        }
      }
    }
    refreshUI();
    setSelect(0);
    IU(true);
    this.cdo = false;
  }
  
  public void dfI()
  {
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.runOnUiThread(new QfileRecentPicFileTabView.5(this));
  }
  
  protected boolean e(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = auem.cl(paramFileManagerEntity.srvTime);
    if (!this.R.containsKey(localObject))
    {
      QLog.e(TAG, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    synchronized (this.R)
    {
      localObject = ((List)this.R.get(localObject)).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)((Iterator)localObject).next()) {
          ((Iterator)localObject).remove();
        }
      }
      refreshUI();
      return true;
    }
  }
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        e((FileManagerEntity)paramArrayList.next());
      }
    }
  }
  
  protected void g(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.AT.contains(paramFileManagerEntity)) {
      if ((this.mUin == null) || (this.mUin.trim().length() == 0) || (this.mUin.equals(paramFileManagerEntity.peerUin))) {}
    }
    while (paramFileManagerEntity.nFileType != 0)
    {
      return;
      this.AT.add(paramFileManagerEntity);
      Collections.sort(this.AT, this.comparator);
    }
    runOnUiThread(new QfileRecentPicFileTabView.3(this, paramFileManagerEntity));
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(true, true, true, true, true);
    Nx();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView$a);
  }
  
  public void onStop()
  {
    super.onStop();
    this.app.a().deleteObserver(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.recentfile.QfileRecentPicFileTabView
 * JD-Core Version:    0.7.0.1
 */