package com.tencent.tim.filemanager.activity.localfile;

import android.content.Context;
import atpo;
import atrj;
import aueh;
import auej;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFileOtherTabView
  extends QfileBaseLocalFileTabView
{
  public QfileLocalFileOtherTabView(Context paramContext)
  {
    super(paramContext);
    setEditbarButton(false, false, false, true, true);
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
    this.runnable = new QfileLocalFileOtherTabView.1(this);
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
  
  String kN(String paramString)
  {
    paramString = aueh.getExtension(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return "更多";
    }
    paramString = paramString.toLowerCase();
    if (".rar|.zip|.7z|.iso|.tar|.gz|".indexOf(paramString) >= 0) {
      return "压缩文件";
    }
    if (".txt|.html|.lit|.wdl|.ceb|.pdg|.epub|.caj|.umd|.jar|.mobi|".indexOf(paramString) >= 0) {
      return "电子书";
    }
    return "更多";
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(false, false, false, true, true);
    if (this.b.akI()) {
      this.b.a().dlO();
    }
    for (;;)
    {
      Nx();
      return;
      this.b.a().dlT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileOtherTabView
 * JD-Core Version:    0.7.0.1
 */