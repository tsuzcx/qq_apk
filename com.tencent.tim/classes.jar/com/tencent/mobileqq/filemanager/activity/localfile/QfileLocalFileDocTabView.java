package com.tencent.mobileqq.filemanager.activity.localfile;

import acfp;
import agdq;
import agga;
import ahbj;
import ahbo;
import android.content.Context;
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

public class QfileLocalFileDocTabView
  extends QfileBaseLocalFileTabView
{
  public QfileLocalFileDocTabView(Context paramContext, List<QfileTabBarView.a> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    setEditbarButton(false, false, true, true, true);
  }
  
  private String getFileType(String paramString)
  {
    paramString = ahbj.getExtension(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return acfp.m(2131711084);
    }
    paramString = paramString.toLowerCase();
    if (".doc|.docx|.wps|.pages|".indexOf(paramString) >= 0) {
      return "WORD";
    }
    if (".ppt|.pptx.|.dps|.keynote|".indexOf(paramString) >= 0) {
      return "PPT";
    }
    if (".xls|.xlsx|.et|.numbers|".indexOf(paramString) >= 0) {
      return "EXCEL";
    }
    if (".pdf|".indexOf(paramString) >= 0) {
      return "PDF";
    }
    return acfp.m(2131711100);
  }
  
  protected agdq a()
  {
    return new agga(a(), this.R, a(), this.m, this.n, this.g, this.eX);
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.wB.contains(paramFileInfo)) {
      this.wB.add(paramFileInfo);
    }
    runOnUiThread(new QfileLocalFileDocTabView.2(this, paramFileInfo));
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
    this.a.a(this);
    this.runnable = new QfileLocalFileDocTabView.1(this);
    ThreadManagerV2.excute(this.runnable, 64, null, true);
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
    if (this.a.akI())
    {
      if (!this.a.akQ()) {
        this.a.a().dlM();
      }
      this.a.setDocsCheck(true);
    }
    for (;;)
    {
      setEditbarButton(false, false, true, true, true);
      Nx();
      return;
      if (!this.a.akQ()) {
        this.a.a().dlR();
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.setDocsCheck(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView
 * JD-Core Version:    0.7.0.1
 */