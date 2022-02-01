package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import urh;

public class CloudFileActivity$17$1
  implements Runnable
{
  public CloudFileActivity$17$1(urh paramurh, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.aUH) {
      try
      {
        Intent localIntent1 = new Intent(this.a.this$0.getActivity(), FMActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putLong("category", 14L);
        localIntent1.putExtra("bundle", localBundle);
        localIntent1.putExtra("tab_tab_type", 3);
        localIntent1.putExtra("from", "CloudFileTab");
        localIntent1.putExtra("qfile_selecter_entrance_type", -1);
        this.a.this$0.startActivityForResult(localIntent1, 101);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Intent localIntent2 = new Intent(this.a.this$0.getActivity(), FMActivity.class);
    localIntent2.putExtra("tab_tab_type", 3);
    localIntent2.putExtra("from", "CloudFileTab");
    localIntent2.putExtra("qfile_selecter_entrance_type", -1);
    this.a.this$0.startActivityForResult(localIntent2, 101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.CloudFileActivity.17.1
 * JD-Core Version:    0.7.0.1
 */