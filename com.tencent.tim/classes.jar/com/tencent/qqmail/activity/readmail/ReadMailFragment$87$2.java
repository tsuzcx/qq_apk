package com.tencent.qqmail.activity.readmail;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;

class ReadMailFragment$87$2
  implements Runnable
{
  ReadMailFragment$87$2(ReadMailFragment.87 param87, String paramString) {}
  
  public void run()
  {
    if (this.val$msg != null)
    {
      if (this.val$msg.equals(QMApplicationContext.sharedInstance().getString(2131696755)))
      {
        Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131696753), 0).show();
        return;
      }
      Toast.makeText(QMApplicationContext.sharedInstance(), this.val$msg, 0).show();
      return;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131696751), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.87.2
 * JD-Core Version:    0.7.0.1
 */