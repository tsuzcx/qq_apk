package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;

class QfileLocalFileAppTabView$4
  implements Runnable
{
  QfileLocalFileAppTabView$4(QfileLocalFileAppTabView paramQfileLocalFileAppTabView, boolean paramBoolean) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.this$0.a.getSharedPreferences("qfile_permission", 0).edit();
    localEditor.putBoolean("qfile_permission_access_apps", this.cdm);
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.4
 * JD-Core Version:    0.7.0.1
 */