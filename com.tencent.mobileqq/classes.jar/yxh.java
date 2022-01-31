import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.apollo.view.ApolloGameHotChatController;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class yxh
  extends HotChatObserver
{
  public yxh(ApolloGameHotChatController paramApolloGameHotChatController) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    super.a(paramString1, paramBoolean, paramString2);
    if ((paramBoolean) && (ApolloGameHotChatController.a(this.a) != null))
    {
      paramString2 = (HotChatPie)ApolloGameHotChatController.a(this.a).get();
      if ((paramString2 != null) && (paramString2.a != null))
      {
        paramString2 = (HotChatManager)paramString2.a.getManager(59);
        if (paramString2 != null)
        {
          paramString1 = paramString2.a(paramString1);
          if ((paramString1 != null) && (paramString1.apolloGameId > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "delete_reliao_room", 0, 0, new String[] { String.valueOf(paramString1.apolloGameId) });
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    paramWifiPOIInfo = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramWifiPOIInfo = paramString;
      if (paramHotChatInfo != null) {
        paramWifiPOIInfo = paramHotChatInfo.name;
      }
    }
    if ((paramWifiPOIInfo == null) || (!paramWifiPOIInfo.equals(ApolloGameHotChatController.a(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameHotChatController", 2, "onQuickJoinHotChat, hotcode.equals(mCurrentHotChatCode)");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameHotChatController", 2, "onQuickJoinHotChat, hotcode:" + paramWifiPOIInfo);
    }
    paramWifiPOIInfo = Message.obtain();
    if (paramBoolean) {
      if ((paramHotChatInfo != null) && ((paramInt == 1) || (paramInt == 2)))
      {
        paramWifiPOIInfo.what = 3;
        paramWifiPOIInfo.obj = new Object[] { paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name };
        if (paramHotChatInfo.apolloGameId > 0) {
          VipUtils.a(null, "cmshow", "Apollo", "join_reliao", 0, 0, new String[] { String.valueOf(paramHotChatInfo.apolloGameId) });
        }
      }
    }
    for (;;)
    {
      ApolloGameHotChatController.a(this.a).sendMessage(paramWifiPOIInfo);
      return;
      paramWifiPOIInfo.what = 1;
      paramWifiPOIInfo.arg1 = 5;
      paramWifiPOIInfo.obj = "加入热聊失败，请稍后再试。";
      continue;
      paramWifiPOIInfo.what = 1;
      paramWifiPOIInfo.arg1 = (paramInt + 100);
      paramWifiPOIInfo.obj = HotChatUtil.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxh
 * JD-Core Version:    0.7.0.1
 */