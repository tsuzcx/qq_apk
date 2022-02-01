package com.tencent.tim.filemanager.activity.delDownloadFile;

import android.content.Context;
import aueh;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.localfile.QfileLocalFilePicTabView;

public class QfileLocalFileDelPicTabView
  extends QfileLocalFilePicTabView
{
  public QfileLocalFileDelPicTabView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void dfD()
  {
    setEditbarButton(false, false, false, false, true);
    this.b.a(this);
    this.runnable = new QfileLocalFileDelPicTabView.1(this);
    ThreadManager.executeOnFileThread(this.runnable);
  }
  
  String getFileType(String paramString)
  {
    paramString = aueh.getExtension(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return "其他";
    }
    if (".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString.toLowerCase())) {
      return "图片";
    }
    return "其他";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView
 * JD-Core Version:    0.7.0.1
 */