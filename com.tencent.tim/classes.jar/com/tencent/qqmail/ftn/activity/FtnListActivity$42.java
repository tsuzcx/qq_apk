package com.tencent.qqmail.ftn.activity;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;

class FtnListActivity$42
  implements Runnable
{
  FtnListActivity$42(FtnListActivity paramFtnListActivity, int paramInt) {}
  
  public void run()
  {
    String str = String.format(this.this$0.getString(2131694079), new Object[] { Integer.valueOf(this.val$excepCount) });
    Toast.makeText(QMApplicationContext.sharedInstance(), str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.42
 * JD-Core Version:    0.7.0.1
 */