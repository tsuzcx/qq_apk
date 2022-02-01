package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class bt
  extends Handler
{
  private static String gt;
  
  public bt() {}
  
  public bt(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    ar localar = bz.av().u().z();
    if ((localar != null) && (localar.B()) && (paramMessage != null))
    {
      Object localObject = new StringBuilder(String.valueOf(paramMessage.what));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(getLooper().getThread().getName());
      ((StringBuilder)localObject).append("_");
      if (paramMessage.getCallback() != null) {
        ((StringBuilder)localObject).append(paramMessage.getCallback().getClass().getName());
      } else {
        ((StringBuilder)localObject).append(getClass().getName());
      }
      String str2 = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append("|last|");
      String str1 = gt;
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      localar.a("dmsg", localStringBuilder.toString());
      gt = str2;
    }
    super.dispatchMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.bt
 * JD-Core Version:    0.7.0.1
 */