package wf7;

import android.content.Intent;

class cs$1$1$1
  implements Runnable
{
  cs$1$1$1(cs.1.1 param1, Intent paramIntent, long paramLong) {}
  
  public void run()
  {
    String str = this.jdField_if.getAction();
    if ("android.net.wifi.supplicant.STATE_CHANGE".equals(str))
    {
      cs.a(this.ih.ie.ic, this.jdField_if);
      return;
    }
    if ("android.net.wifi.STATE_CHANGE".equals(str))
    {
      cs.b(this.ih.ie.ic, this.jdField_if);
      return;
    }
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
      cs.c(this.ih.ie.ic, this.jdField_if);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cs.1.1.1
 * JD-Core Version:    0.7.0.1
 */