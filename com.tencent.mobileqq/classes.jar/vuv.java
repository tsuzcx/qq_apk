import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class vuv
  extends HotChatObserver
{
  public vuv(HotChatPie paramHotChatPie) {}
  
  public void a(String paramString, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("Q.aio.BaseTroopChatPie", new Object[] { "onPushExitHotChat", paramString, paramHotChatStateWrapper });
    }
    if (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramString)) {
      return;
    }
    int i = paramHotChatStateWrapper.targetState;
    HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i);
    HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.BaseTroopChatPie", 2, "TroopChatPie.onExitHotChat  troopUin=" + paramString1);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString1)))
    {
      if (this.a.a().getIntent().getBooleanExtra("is_from_web", false)) {
        this.a.a().sendBroadcast(new Intent("com.tencent.mobileqq.refresh_hot_chat_list"));
      }
      HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 4);
      HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
      this.a.b(1);
    }
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("Q.aio.BaseTroopChatPie", new Object[] { "onQuickJoinHotChat", Boolean.valueOf(paramBoolean), paramString, paramHotChatInfo });
    }
    if (!paramBoolean) {
      if ((Utils.a(this.a.i, paramString)) || ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid, paramString))))
      {
        paramHotChatInfo = HotChatUtil.a(paramInt);
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramHotChatInfo, 1).a();
      }
    }
    while ((!Utils.a(this.a.i, paramString)) || (paramHotChatInfo == null) || (Utils.a(paramHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
      return;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("Q.aio.BaseTroopChatPie", new Object[] { "onQuickJoinHotChat_not_same_aio", String.format("uuid:%s, new:%s, old:%s", new Object[] { paramString, paramHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a }) });
    }
    MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    paramWifiPOIInfo = new Intent(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class);
    paramWifiPOIInfo.putExtra("uin", paramHotChatInfo.troopUin);
    paramWifiPOIInfo.putExtra("uintype", 1);
    paramWifiPOIInfo.putExtra("troop_uin", paramHotChatInfo.troopCode);
    paramWifiPOIInfo.putExtra("uinname", paramHotChatInfo.name);
    paramWifiPOIInfo.addFlags(67108864);
    paramWifiPOIInfo.putExtra("hotnamecode", paramHotChatInfo.uuid);
    if (paramHotChatInfo.supportDemo) {}
    for (paramInt = 2;; paramInt = 0)
    {
      paramWifiPOIInfo.putExtra("HOTCHAT_EXTRA_FLAG", paramInt);
      paramHotChatInfo = AIOUtils.a(paramWifiPOIInfo, new int[] { 2 });
      paramHotChatInfo.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramHotChatInfo);
      if (!(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)) {
        break;
      }
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramString.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "onGetUserCreateHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", troopOwner=" + paramLong);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, null)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b(l1);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_global_admin");
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.b(paramString2);
        return;
      }
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
      for (paramString1 = "507";; paramString1 = "503")
      {
        NearbyFlowerManager.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
        return;
      }
    }
    paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
    for (paramString1 = "507";; paramString1 = "503")
    {
      NearbyFlowerManager.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
      this.a.a(paramString2, paramString3, true, 4);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "onGetHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", jumpurl=" + paramString3);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, paramString3)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b(l1);
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_admin");
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    HotChatUtil.a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuv
 * JD-Core Version:    0.7.0.1
 */