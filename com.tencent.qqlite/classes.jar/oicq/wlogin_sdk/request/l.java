package oicq.wlogin_sdk.request;

import android.content.Context;
import oicq.wlogin_sdk.tools.util;

public class l
  extends Thread
{
  private Context a;
  
  public l(Context paramContext)
  {
    this.a = paramContext;
    setName("WtCleanThread");
  }
  
  public void run()
  {
    util.deleteExpireLog(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.l
 * JD-Core Version:    0.7.0.1
 */