package com.tencent.mobileqq.filemanager.activity.recentfile;

import agdq;
import aggw;
import aghd;
import ahbk;
import ahbo;
import ahcb;
import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentTDocFileTabView
  extends QfileBaseRecentFileTabView
{
  private ahbk b;
  
  public QfileRecentTDocFileTabView(Context paramContext)
  {
    super(paramContext);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentTDocFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void Nx()
  {
    if (this.a.akI()) {
      this.a.a().dlC();
    }
    while (this.b != null)
    {
      this.a.a(this.b);
      return;
      this.a.a().dlH();
    }
    this.b = new aghd(this);
    this.a.a(this.b);
  }
  
  protected agdq a()
  {
    return new aggw(a(), this.R, a(), this.m, this.n, this.g, this.eX);
  }
  
  void dfD()
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
  
  void g(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.AT.contains(paramFileManagerEntity))
    {
      if ((this.mUin != null) && (this.mUin.trim().length() != 0) && (!this.mUin.equals(paramFileManagerEntity.peerUin))) {
        return;
      }
      this.AT.add(paramFileManagerEntity);
      Collections.sort(this.AT, this.comparator);
    }
    runOnUiThread(new QfileRecentTDocFileTabView.1(this, paramFileManagerEntity));
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.setDocsCheck(true);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView
 * JD-Core Version:    0.7.0.1
 */