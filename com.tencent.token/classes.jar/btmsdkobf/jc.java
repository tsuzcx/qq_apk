package btmsdkobf;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class jc
  extends Handler
{
  jc(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    if (???.what == 11)
    {
      int i = ???.getData().getInt("type");
      ??? = ???.getData().getString("appid");
      try
      {
        i.d(i.i().a(i, ???));
        Log.e("VMS_IDLG_SDK_Client", "message type valid");
      }
      catch (Exception ???)
      {
        synchronized (i.j())
        {
          i.j().notify();
          return;
          ??? = ???;
          Log.e("VMS_IDLG_SDK_Client", "readException:" + ???.toString());
          ???.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.jc
 * JD-Core Version:    0.7.0.1
 */