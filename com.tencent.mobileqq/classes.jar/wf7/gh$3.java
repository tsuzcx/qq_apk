package wf7;

import Protocol.MConch.ConchPushInfo;
import Protocol.MConch.c;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.wifisdk.services.common.api.a;
import com.tencent.wifisdk.services.common.api.e;

class gh$3
  extends Handler
{
  gh$3(gh paramgh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = -1;
    if (j != 1)
    {
      if (j != 2) {
        return;
      }
      paramMessage = (ConchPushInfo)paramMessage.obj;
      j = i;
      if (paramMessage != null)
      {
        j = i;
        if (paramMessage.bs != null) {
          j = paramMessage.bs.bi;
        }
      }
      if (j <= 0) {
        return;
      }
      paramMessage = ConchPushInfo.a(paramMessage);
      if (!TextUtils.isEmpty(paramMessage))
      {
        e locale = gh.d(this.sj);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("id_");
        localStringBuilder.append(j);
        locale.b(localStringBuilder.toString(), paramMessage);
      }
    }
    else
    {
      paramMessage = (ConchPushInfo)paramMessage.obj;
      j = i;
      if (paramMessage != null)
      {
        j = i;
        if (paramMessage.bs != null) {
          j = paramMessage.bs.bi;
        }
      }
      if (j <= 0) {
        return;
      }
      paramMessage = (a)gh.b(this.sj).get(j);
      if (paramMessage == null) {}
    }
    try
    {
      paramMessage.update(j);
      return;
    }
    catch (Throwable paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.gh.3
 * JD-Core Version:    0.7.0.1
 */