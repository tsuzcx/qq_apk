package com.tencent.token.ui;

import android.os.Handler;
import com.tencent.token.fk;

class aca
  implements Runnable
{
  aca(UtilsActivity paramUtilsActivity) {}
  
  public void run()
  {
    if (fk.a("guide_qqpimsecure_tips_utils_last_show_time"))
    {
      this.a.mHandler.post(new acb(this));
      fk.a("guide_qqpimsecure_tips_utils_last_show_time", System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aca
 * JD-Core Version:    0.7.0.1
 */