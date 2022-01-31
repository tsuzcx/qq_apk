package wf7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

final class fq$2
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {}
    label12:
    do
    {
      long l;
      do
      {
        do
        {
          break label12;
          do
          {
            return;
          } while ((!"android.intent.action.PACKAGE_ADDED".equals(paramContext)) || (paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false)));
          paramContext = paramIntent.getDataString();
        } while ((paramContext == null) || (!paramContext.startsWith("package:")) || (!TextUtils.equals(paramContext.substring(8), "com.tencent.wifimanager")));
        paramContext = fm.dL();
        l = paramContext.dP();
      } while ((l <= 0L) || (System.currentTimeMillis() - l > 3600000L));
      hk.az(500146);
      paramContext.dQ();
    } while (paramContext.dR() != 8);
    hk.az(500180);
    paramContext.dS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.fq.2
 * JD-Core Version:    0.7.0.1
 */