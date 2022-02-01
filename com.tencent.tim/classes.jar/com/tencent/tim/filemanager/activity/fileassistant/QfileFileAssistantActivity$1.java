package com.tencent.tim.filemanager.activity.fileassistant;

import android.content.SharedPreferences;

class QfileFileAssistantActivity$1
  implements Runnable
{
  QfileFileAssistantActivity$1(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  public void run()
  {
    this.this$0.getSharedPreferences("Offline_Flags", 0).getBoolean("TMPFLAG", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.fileassistant.QfileFileAssistantActivity.1
 * JD-Core Version:    0.7.0.1
 */