package com.tencent.smtt.sdk.a;

import android.os.Handler;
import com.tencent.smtt.utils.TbsLog;

class e$1
  implements Runnable
{
  e$1(e parame, e.a parama) {}
  
  public void run()
  {
    String str = this.b.a(e.a(this.b));
    if (str != null)
    {
      e.b(this.b).post(new e.1.1(this, str));
      return;
    }
    TbsLog.e(e.a(), "Unexpected result for an empty http response: " + e.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.e.1
 * JD-Core Version:    0.7.0.1
 */