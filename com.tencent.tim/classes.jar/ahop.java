import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1.1;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicEngine;
import cooperation.qqreader.QRBridgeUtil;

public class ahop
  implements ausj.a
{
  public ahop(QQSettingMsgClearFragment paramQQSettingMsgClearFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!this.a.getActivity().isFinishing())
    {
      this.ai.cancel();
      QQSettingMsgClearFragment.a(this.a, true);
    }
    anot.a(null, "dc00898", "", "", "0X800A0C5", "0X800A0C5", 0, 0, "", "", "", "");
    try
    {
      avpw.nH(QQSettingMsgClearFragment.a(this.a).getLongAccountUin());
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actCleanCacheData", true, 0L, 0L, null, null);
      if (WebProcessManager.aFS())
      {
        paramView = new Intent(this.a.getActivity(), WebProcessReceiver.class);
        paramView.setAction("action_clear_cache");
        this.a.getActivity().sendBroadcast(paramView, "com.tencent.tim.msg.permission.pushnotify");
        QRBridgeUtil.clearReaderBookCache();
        aqhq.delete(BaseApplication.getContext().getCacheDir() + "/mini", false);
        ApolloUtil.En(false);
        aqhq.delete(acbn.bmB, false);
        ThreadManagerV2.excute(new QQSettingMsgClearFragment.1.1(this), 64, null, true);
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        QLog.w("QQSettingMsgClearFragment", 1, "onQQClearLocalCache error.", paramView);
        continue;
        paramView = WebAccelerateHelper.getSonicEngine();
        if (paramView != null) {
          paramView.cleanCache();
        }
        ardk.ehx();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahop
 * JD-Core Version:    0.7.0.1
 */