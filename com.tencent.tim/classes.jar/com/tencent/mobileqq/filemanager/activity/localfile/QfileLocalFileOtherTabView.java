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

public class QfileLocalFileOtherTabView
  extends QfileBaseLocalFileTabView
{
  public QfileLocalFileOtherTabView(Context paramContext, List<QfileTabBarView.a> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    setEditbarButton(false, false, true, true, true);
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
    runOnUiThread(new QfileLocalFileOtherTabView.2(this, paramFileInfo));
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
    this.runnable = new QfileLocalFileOtherTabView.1(this);
    ThreadManagerV2.excute(this.runnable, 64, null, true);
  }
  
  String kN(String paramString)
  {
    paramString = ahbj.getExtension(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return acfp.m(2131711104);
    }
    paramString = paramString.toLowerCase();
    if (".rar|.zip|.7z|.iso|.tar|.gz|".indexOf(paramString) >= 0) {
      return acfp.m(2131711081);
    }
    if (".txt|.html|.lit|.wdl|.ceb|.pdg|.epub|.caj|.umd|.jar|.mobi|".indexOf(paramString) >= 0) {
      return acfp.m(2131711098);
    }
    return acfp.m(2131711086);
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
    setEditbarButton(false, false, true, true, true);
    if (!this.a.akQ())
    {
      if (!this.a.akI()) {
        break label50;
      }
      this.a.a().dlO();
    }
    for (;;)
    {
      Nx();
      return;
      label50:
      this.a.a().dlT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView
 * JD-Core Version:    0.7.0.1
 */