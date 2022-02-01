package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import java.util.ArrayList;

class e$3
  implements Runnable
{
  e$3(e parame) {}
  
  public void run()
  {
    if ((e.a(this.a) != null) && (!i.b(e.a(this.a).getPackageName())))
    {
      ArrayList localArrayList = MessageManager.getInstance().getNewCachedMsgIntentList(e.a(this.a));
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        if (XGPushConfig.enableDebug) {
          TLogger.d("PushMessageHandler", "Action -> trySendCachedMsg with CachedMsgList size = " + localArrayList.size());
        }
        int i = 0;
        for (;;)
        {
          if (i < localArrayList.size()) {
            try
            {
              Intent localIntent = (Intent)localArrayList.get(i);
              e.a(this.a, localIntent);
              i += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                TLogger.e("PushMessageHandler", "", localThrowable);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.e.3
 * JD-Core Version:    0.7.0.1
 */