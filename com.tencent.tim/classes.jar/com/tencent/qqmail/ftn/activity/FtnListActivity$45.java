package com.tencent.qqmail.ftn.activity;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import java.util.Locale;

class FtnListActivity$45
  implements Runnable
{
  FtnListActivity$45(FtnListActivity paramFtnListActivity) {}
  
  public void run()
  {
    String str = String.format(Locale.getDefault(), "%dG", new Object[] { Long.valueOf(2L) });
    str = String.format(this.this$0.getString(2131694078), new Object[] { str });
    Toast.makeText(QMApplicationContext.sharedInstance(), str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.45
 * JD-Core Version:    0.7.0.1
 */