package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import aqiw;
import avno;
import avoc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import cooperation.qqreader.host.ReaderHost;
import jpa;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  private static boolean dnx;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    avoc.u("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess onReceive");
    super.onReceive(paramContext, paramIntent);
    paramContext = paramIntent.getStringExtra("params_uin_for_reader");
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!TextUtils.isEmpty(str)) {
      ReaderHost.setAccount(str);
    }
    for (;;)
    {
      if (!paramIntent.getBooleanExtra("is_preload_reader_plugin", false)) {
        avno.S(BaseApplicationImpl.getApplication(), false);
      }
      if (!dnx)
      {
        dnx = true;
        avmj.exv = 2;
        avoc.i("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess isPreloadProcess=true");
        if (aqiw.isWifiConnected(MobileQQ.sMobileQQ))
        {
          jpa.init();
          ThreadManager.post(new VipProxyRreLoadReaderProcess.1(this), 5, null, true);
        }
      }
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        ReaderHost.setAccount(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.VipProxyRreLoadReaderProcess
 * JD-Core Version:    0.7.0.1
 */