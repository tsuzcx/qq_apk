package com.tencent.mobileqq.filemanager.activity.recentfile;

import agdq;
import aggw;
import aghe;
import ahbk;
import ahbo;
import ahcb;
import android.content.Context;
import aobw;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentTencentDocFileTabView
  extends QfileBaseRecentFileTabView
{
  private ahbk b;
  
  public QfileRecentTencentDocFileTabView(Context paramContext)
  {
    super(paramContext);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentTencentDocFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void Nx()
  {
    if (this.a.akI()) {
      this.a.a().dlD();
    }
    while (this.b != null)
    {
      this.a.a(this.b);
      return;
      this.a.a().dlI();
    }
    this.b = new aghe(this);
    this.a.a(this.b);
  }
  
  protected agdq a()
  {
    return new aggw(a(), this.R, a(), this.m, this.n, this.g, this.eX);
  }
  
  protected void dfD()
  {
    this.R.clear();
    Iterator localIterator = this.AT.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 13))
      {
        String str = ahcb.bt(localFileManagerEntity.srvTime);
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
    Object localObject = ahcb.bt(paramFileManagerEntity.srvTime);
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
    if (!this.AT.contains(paramFileManagerEntity))
    {
      if ((this.mUin != null) && (this.mUin.trim().length() != 0) && (!this.mUin.equals(paramFileManagerEntity.peerUin))) {
        return;
      }
      this.AT.add(paramFileManagerEntity);
      Collections.sort(this.AT, this.comparator);
    }
    runOnUiThread(new QfileRecentTencentDocFileTabView.2(this, paramFileManagerEntity));
  }
  
  protected void h(FileManagerEntity paramFileManagerEntity)
  {
    aobw.a(this.a, paramFileManagerEntity);
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(false, true, true, true, true);
    Nx();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.setDocsCheck(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTencentDocFileTabView
 * JD-Core Version:    0.7.0.1
 */