package tmsdkdual;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Handler;
import com.tmsdk.dual.TMSDualSDKContext;

public class c
{
  private static BroadcastReceiver q = new BroadcastReceiver()
  {
    public void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent == null) {}
      for (;;)
      {
        return;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymousIntent.getAction()))
        {
          paramAnonymousContext = (NetworkInfo)paramAnonymousIntent.getParcelableExtra("networkInfo");
          if ((paramAnonymousContext != null) && (paramAnonymousContext.isConnected())) {
            new Handler(com.tmsdk.dual.a.a()).postDelayed(new Runnable()
            {
              public void run()
              {
                try
                {
                  com.tmsdk.dual.a.a(false);
                  com.tmsdk.dual.sharkcpp.a.o().p();
                  if ((paramAnonymousContext.getType() == 0) && (a.b().g.getBoolean("IS_CLEAR_CTR_N", true)))
                  {
                    long l1 = a.b().g.getLong("ctr_l_t", 0L);
                    long l2 = a.b().g.getLong("ctr_l_t", 0L);
                    if (System.currentTimeMillis() - l2 < l1) {
                      return;
                    }
                    a.b().beginTransaction();
                    a.b().a("PN_LAST_FETCH_TIME", 0L);
                    a.b().a("PN_LAST_FATCH_RESULT", -1);
                    a.b().a("NET_GET_NUMBER_CACHE", null);
                    a.b().a("KC_CTR_LAST_FETCH_TIME", 0L);
                    a.b().a("KC_CTR_RESULT_CACHE", -1);
                    a.b().a("KC_CTR_LAST_PHONE_NUMBER", null);
                    a.b().a("KC_CTR_CODE_CACHE", -1);
                    a.b().a("ctr_l_t", System.currentTimeMillis());
                    a.b().c();
                    return;
                  }
                }
                catch (Throwable localThrowable) {}
              }
            }, 2000L);
          }
        }
        else if ("android.intent.action.SIM_STATE_CHANGED".equals(paramAnonymousIntent.getAction()))
        {
          try
          {
            if (a.b().g.getBoolean("IS_CLEAR_CTR", true))
            {
              final int i = paramAnonymousIntent.getIntExtra("slot", -1);
              final int j = a.b().g.getInt("LAST_SIM_CARD_RECEIVED", -1);
              new Handler(com.tmsdk.dual.a.a()).post(new Runnable()
              {
                public void run()
                {
                  try
                  {
                    a.b().beginTransaction();
                    if (i != j)
                    {
                      a.b().a("PN_LAST_FETCH_TIME", 0L);
                      a.b().a("PN_LAST_FATCH_RESULT", -1);
                      a.b().a("NET_GET_NUMBER_CACHE", null);
                      a.b().a("KC_CTR_LAST_FETCH_TIME", 0L);
                      a.b().a("KC_CTR_RESULT_CACHE", -1);
                      a.b().a("KC_CTR_LAST_PHONE_NUMBER", null);
                      a.b().a("KC_CTR_CODE_CACHE", -1);
                      a.b().a("LAST_SIM_CARD_RECEIVED", i);
                    }
                    a.b().c();
                    return;
                  }
                  catch (Throwable localThrowable) {}
                }
              });
              return;
            }
          }
          catch (Throwable paramAnonymousContext) {}
        }
      }
    }
  };
  
  public static void start()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      if (a.b().g.getBoolean("IS_CLEAR_CTR", true)) {
        localIntentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
      }
      TMSDualSDKContext.getApplicaionContext().registerReceiver(q, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.c
 * JD-Core Version:    0.7.0.1
 */