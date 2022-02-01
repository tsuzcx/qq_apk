package com.tencent.tim.filemanager.activity.recentfile;

import android.content.Context;
import atpo;
import atse;
import atsf;
import audx;
import auei;
import auej;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentMediaFileTabView
  extends QfileBaseRecentFileTabView
{
  private auei b;
  
  public QfileRecentMediaFileTabView(Context paramContext)
  {
    super(paramContext);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentMediaFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void Nx()
  {
    if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akI()) {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlE();
    }
    while (this.jdField_b_of_type_Auei != null)
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
      return;
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlJ();
    }
    this.jdField_b_of_type_Auei = new atsf(this);
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
  }
  
  private String kO(String paramString)
  {
    switch (audx.fM(paramString))
    {
    default: 
      return null;
    case 2: 
      return "视频";
    }
    return "音乐";
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
      if ((!localFileManagerEntity.bDelInFM) && (!mX(localFileManagerEntity.cloudType)))
      {
        String str = kO(localFileManagerEntity.fileName);
        if (str != null)
        {
          if (!this.R.containsKey(str)) {
            this.R.put(str, new ArrayList());
          }
          ((List)this.R.get(str)).add(localFileManagerEntity);
        }
      }
    }
    refreshUI();
    setSelect(0);
    IU(true);
    this.cdo = false;
  }
  
  protected boolean e(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = kO(paramFileManagerEntity.fileName);
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
    String str;
    do
    {
      return;
      this.AT.add(paramFileManagerEntity);
      Collections.sort(this.AT, this.comparator);
      str = kO(paramFileManagerEntity.fileName);
    } while (str == null);
    runOnUiThread(new QfileRecentMediaFileTabView.2(this, str, paramFileManagerEntity));
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(false, true, true, true, true);
    Nx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.recentfile.QfileRecentMediaFileTabView
 * JD-Core Version:    0.7.0.1
 */