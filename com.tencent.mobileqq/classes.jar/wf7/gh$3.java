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
    int i = -1;
    switch (paramMessage.what)
    {
    }
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramMessage = (ConchPushInfo)paramMessage.obj;
            j = i;
            if (paramMessage != null)
            {
              j = i;
              if (paramMessage.bs != null) {
                j = paramMessage.bs.bi;
              }
            }
          } while (j <= 0);
          paramMessage = (a)gh.b(this.sj).get(j);
        } while (paramMessage == null);
        try
        {
          paramMessage.update(j);
          return;
        }
        catch (Throwable paramMessage)
        {
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
      } while (j <= 0);
      paramMessage = ConchPushInfo.a(paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    gh.d(this.sj).b("id_" + j, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gh.3
 * JD-Core Version:    0.7.0.1
 */