package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ih
  extends Handler
{
  ih(do paramdo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    eh.e("HeartBeatPlot", "[h_b]handleMessage(), nodifyOnHeartBeat()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ih
 * JD-Core Version:    0.7.0.1
 */