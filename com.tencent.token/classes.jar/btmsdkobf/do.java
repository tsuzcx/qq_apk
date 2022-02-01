package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class do
{
  private Context mContext = null;
  private Handler mHandler = new Handler(cx.getLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      eh.e("HeartBeatPlot", "[h_b]handleMessage(), nodifyOnHeartBeat()");
    }
  };
  private boolean na = false;
  private a nb = null;
  private long nc = 0L;
  private c nd = null;
  private b ne = null;
  
  public do(Context paramContext, c paramc, b paramb)
  {
    this.mContext = paramContext;
    this.nd = paramc;
    this.ne = paramb;
  }
  
  public void reset()
  {
    try
    {
      eh.e("HeartBeatPlot", "[h_b]reset()");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void start() {}
  
  public void stop()
  {
    try
    {
      eh.e("HeartBeatPlot", "[h_b]stop()");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent) {}
  }
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.do
 * JD-Core Version:    0.7.0.1
 */