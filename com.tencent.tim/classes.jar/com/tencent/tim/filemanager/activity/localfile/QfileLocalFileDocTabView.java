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

public class QfileLocalFileDocTabView
  extends QfileBaseLocalFileTabView
{
  public QfileLocalFileDocTabView(Context paramContext)
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
    this.runnable = new QfileLocalFileDocTabView.1(this);
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
  
  String getFileType(String paramString)
  {
    paramString = aueh.getExtension(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return "其他";
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
    return "其他";
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(false, false, false, true, true);
    if (this.b.akI()) {
      this.b.a().dlM();
    }
    for (;;)
    {
      Nx();
      return;
      this.b.a().dlR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileDocTabView
 * JD-Core Version:    0.7.0.1
 */