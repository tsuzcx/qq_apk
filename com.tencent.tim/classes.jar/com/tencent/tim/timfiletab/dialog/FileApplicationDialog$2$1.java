package com.tencent.tim.timfiletab.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import aunn;
import com.tencent.mobileqq.filemanager.activity.FMActivity;

public class FileApplicationDialog$2$1
  implements Runnable
{
  public FileApplicationDialog$2$1(aunn paramaunn, boolean paramBoolean, Activity paramActivity) {}
  
  public void run()
  {
    if (!this.aUH) {
      try
      {
        Intent localIntent1 = new Intent(this.val$activity, FMActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putLong("category", 14L);
        localIntent1.putExtra("bundle", localBundle);
        localIntent1.putExtra("tab_tab_type", 3);
        localIntent1.putExtra("from", "CloudFileTab");
        localIntent1.putExtra("qfile_selecter_entrance_type", -1);
        this.val$activity.startActivityForResult(localIntent1, 101);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Intent localIntent2 = new Intent(this.val$activity, FMActivity.class);
    localIntent2.putExtra("tab_tab_type", 3);
    localIntent2.putExtra("from", "CloudFileTab");
    localIntent2.putExtra("qfile_selecter_entrance_type", -1);
    this.val$activity.startActivityForResult(localIntent2, 101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.timfiletab.dialog.FileApplicationDialog.2.1
 * JD-Core Version:    0.7.0.1
 */