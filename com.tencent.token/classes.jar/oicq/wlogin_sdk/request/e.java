package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import oicq.wlogin_sdk.tools.ErrMsg;

public class e
  extends Thread
{
  Runnable a = new f(this);
  private Context b;
  private ErrMsg c;
  
  public e(Context paramContext, ErrMsg paramErrMsg)
  {
    this.b = paramContext;
    a(paramErrMsg);
  }
  
  public void a(ErrMsg paramErrMsg)
  {
    if (paramErrMsg != null) {
      try
      {
        this.c = ((ErrMsg)paramErrMsg.clone());
        return;
      }
      catch (CloneNotSupportedException paramErrMsg)
      {
        paramErrMsg.printStackTrace();
        this.c = null;
        return;
      }
    }
    this.c = null;
  }
  
  public void run()
  {
    new Handler(Looper.getMainLooper()).post(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.e
 * JD-Core Version:    0.7.0.1
 */