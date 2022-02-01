package com.tencent.tim.filemanager.activity.recentfile;

import android.content.Context;
import atpo;
import atsc;
import atse;
import auei;
import auej;
import auem;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentAppFileTabView
  extends QfileBaseRecentFileTabView
{
  private auei b;
  
  public QfileRecentAppFileTabView(Context paramContext)
  {
    super(paramContext);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentAppFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void Nx()
  {
    if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akI()) {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlC();
    }
    while (this.jdField_b_of_type_Auei != null)
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
      return;
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlH();
    }
    this.jdField_b_of_type_Auei = new atsc(this);
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
  }
  
  protected atpo a()
  {
    return new atse(a(), this.R, a(), this.m, this.n, this.g, this.eX);
  }
  
  protected void dfD()
  {
    this.R.clear();
    Iterator localIterator = this.AT.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 5) && (!mX(localFileManagerEntity.cloudType)))
      {
        String str = auem.cl(localFileManagerEntity.srvTime);
        if (!this.R.containsKey(str)) {
          this.R.put(str, new ArrayList());
        }
        ((List)this.R.get(str)).add(localFileManagerEntity);
      }
    }
    refreshUI();
    setSelect(0);
    IU(true);
    this.cdo = false;
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
    while (paramFileManagerEntity.nFileType != 5)
    {
      return;
      this.AT.add(paramFileManagerEntity);
      Collections.sort(this.AT, this.comparator);
    }
    runOnUiThread(new QfileRecentAppFileTabView.2(this, paramFileManagerEntity));
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(false, true, true, true, true);
    Nx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.recentfile.QfileRecentAppFileTabView
 * JD-Core Version:    0.7.0.1
 */