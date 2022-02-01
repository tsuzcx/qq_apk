package com.tencent.tim.filemanager.activity.delDownloadFile;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.localfile.QfileLocalFileAppTabView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class QfileLocalFileDelAppTabView
  extends QfileLocalFileAppTabView
{
  public QfileLocalFileDelAppTabView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void dfD()
  {
    this.V.clear();
    this.V.put("未安装", new ArrayList());
    this.b.a(this);
    this.runnable = new QfileLocalFileDelAppTabView.1(this);
    ThreadManager.executeOnFileThread(this.runnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelAppTabView
 * JD-Core Version:    0.7.0.1
 */