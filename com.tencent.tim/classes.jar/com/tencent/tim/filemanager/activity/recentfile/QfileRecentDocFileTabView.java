package com.tencent.tim.filemanager.activity.recentfile;

import android.content.Context;
import atpo;
import atsd;
import atse;
import aueh;
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
import java.util.Set;

public class QfileRecentDocFileTabView
  extends QfileBaseRecentFileTabView
{
  private auei b;
  
  public QfileRecentDocFileTabView(Context paramContext)
  {
    super(paramContext);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentDocFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void Nx()
  {
    if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akI()) {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlD();
    }
    while (this.jdField_b_of_type_Auei != null)
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
      return;
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlI();
    }
    this.jdField_b_of_type_Auei = new atsd(this);
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
  }
  
  private String kO(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return null;
        paramString = aueh.getExtension(paramString).toLowerCase();
      } while ((paramString == null) || (paramString.length() == 0));
      if (".doc|.docx|.wps|.pages|".indexOf(paramString) >= 0) {
        return "WORD";
      }
      if (".ppt|.pptx.|.dps|.keynote|".indexOf(paramString) >= 0) {
        return "PPT";
      }
      if (".xls|.xlsx|.et|.numbers|".indexOf(paramString) >= 0) {
        return "EXCEL";
      }
    } while (".pdf|".indexOf(paramString) < 0);
    return "PDF";
  }
  
  protected atpo a()
  {
    return new atse(a(), this.R, a(), this.m, this.n, this.g, this.eX);
  }
  
  protected void dfD()
  {
    this.R.clear();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("WORD", new ArrayList());
    localLinkedHashMap.put("PPT", new ArrayList());
    localLinkedHashMap.put("PDF", new ArrayList());
    localLinkedHashMap.put("EXCEL", new ArrayList());
    Iterator localIterator = this.AT.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.bDelInFM) && (!mX(localFileManagerEntity.cloudType)))
      {
        String str = kO(localFileManagerEntity.fileName);
        if (str != null) {
          ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
        }
      }
    }
    localIterator = localLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (((List)localLinkedHashMap.get((String)localIterator.next())).size() == 0) {
        localIterator.remove();
      }
    }
    this.R.putAll(localLinkedHashMap);
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
  
  public void g(FileManagerEntity paramFileManagerEntity)
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
    runOnUiThread(new QfileRecentDocFileTabView.2(this, str, paramFileManagerEntity));
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(false, true, true, true, true);
    Nx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.recentfile.QfileRecentDocFileTabView
 * JD-Core Version:    0.7.0.1
 */