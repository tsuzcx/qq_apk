package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class bt
  extends Handler
{
  private static String gt = null;
  
  public bt() {}
  
  public bt(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    ar localar = bz.av().u().z();
    String str;
    StringBuilder localStringBuilder;
    if ((localar != null) && (localar.B()) && (paramMessage != null))
    {
      localObject = new StringBuilder(String.valueOf(paramMessage.what));
      ((StringBuilder)localObject).append("_").append(getLooper().getThread().getName()).append("_");
      if (paramMessage.getCallback() == null) {
        break label151;
      }
      ((StringBuilder)localObject).append(paramMessage.getCallback().getClass().getName());
      str = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder().append(str).append("|last|");
      if (gt != null) {
        break label166;
      }
    }
    label151:
    label166:
    for (Object localObject = "";; localObject = gt)
    {
      localar.a("dmsg", (String)localObject);
      gt = str;
      super.dispatchMessage(paramMessage);
      return;
      ((StringBuilder)localObject).append(getClass().getName());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.bt
 * JD-Core Version:    0.7.0.1
 */