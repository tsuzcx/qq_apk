import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class acgg
  extends acgf
{
  private final yam a;
  
  public acgg(yam paramyam)
  {
    this.a = paramyam;
  }
  
  public void a(String paramString, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      ajrk.m(this.a.TAG, new Object[] { "onPushExitHotChat", paramString, paramHotChatStateWrapper });
    }
    if (!aqft.equalsWithNullCheck(this.a.sessionInfo.aTl, paramString)) {
      return;
    }
    int i = paramHotChatStateWrapper.targetState;
    acgh.o(this.a.app, this.a.sessionInfo.aTl, i);
    acgh.cr(this.a.app);
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      ajrk.m(this.a.TAG, new Object[] { "onQuickJoinHotChat", Boolean.valueOf(paramBoolean), paramString, paramHotChatInfo });
    }
    if (!paramBoolean) {
      if ((aqft.equalsWithNullCheck(this.a.aWZ, paramString)) || ((this.a.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (aqft.equalsWithNullCheck(this.a.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.uuid, paramString))))
      {
        paramHotChatInfo = ajpd.eC(paramInt);
        QQToast.a(this.a.mActivity, 1, paramHotChatInfo, 1).show();
      }
    }
    while ((!aqft.equalsWithNullCheck(this.a.aWZ, paramString)) || (paramHotChatInfo == null) || (aqft.equalsWithNullCheck(paramHotChatInfo.troopUin, this.a.sessionInfo.aTl))) {
      return;
    }
    if (QLog.isColorLevel()) {
      ajrk.m(this.a.TAG, new Object[] { "onQuickJoinHotChat_not_same_aio", String.format("uuid:%s, new:%s, old:%s", new Object[] { paramString, paramHotChatInfo.troopUin, this.a.sessionInfo.aTl }) });
    }
    MediaPlayerManager.a(this.a.app).stop(false);
    paramWifiPOIInfo = new Intent(this.a.mActivity, SplashActivity.class);
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
      paramHotChatInfo = wja.a(paramWifiPOIInfo, new int[] { 2 });
      paramHotChatInfo.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      this.a.mActivity.startActivity(paramHotChatInfo);
      if (!(this.a.mActivity instanceof ChatActivity)) {
        break;
      }
      this.a.mActivity.finish();
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "onGetUserCreateHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", troopOwner=" + paramLong);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.k(paramString1, paramString2, null)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_b_of_type_Acgk != null) {
      this.a.jdField_b_of_type_Acgk.hy(l1);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_admin");
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "onGetHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", jumpurl=" + paramString3);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.k(paramString1, paramString2, paramString3)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_b_of_type_Acgk != null) {
      this.a.jdField_b_of_type_Acgk.hy(l1);
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_global_admin");
  }
  
  public void f(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.TAG, 2, "TroopChatPie.onExitHotChat  troopUin=" + paramString1);
    }
    if ((paramBoolean) && (this.a.sessionInfo.aTl.equals(paramString1)))
    {
      if (this.a.a().getIntent().getBooleanExtra("is_from_web", false)) {
        this.a.a().sendBroadcast(new Intent("com.tencent.mobileqq.refresh_hot_chat_list"));
      }
      acgh.o(this.a.app, this.a.sessionInfo.aTl, 4);
      acgh.cr(this.a.app);
      paramString1 = this.a.a.a(this.a.sessionInfo.aTl);
      this.a.a.b(paramString1, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
      this.a.fV(1);
    }
  }
  
  public void g(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.sessionInfo.aTl))) {
      this.a.b(paramString2, paramString3, true, 4);
    }
  }
  
  public void r(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString = this.a.app.a(true);
      this.a.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo = paramString.a(this.a.sessionInfo.aTl);
    }
  }
  
  public void x(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.sessionInfo.aTl)))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.a.a().cP(paramString2, paramString2);
        return;
      }
      paramString2 = this.a.sessionInfo.aTl;
      if ((this.a.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
      for (paramString1 = "507";; paramString1 = "503")
      {
        acie.i("gift_store", "cancel_list", paramString2, paramString1, "", "");
        return;
      }
    }
    paramString2 = this.a.sessionInfo.aTl;
    if ((this.a.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
    for (paramString1 = "507";; paramString1 = "503")
    {
      acie.i("gift_store", "cancel_list", paramString2, paramString1, "", "");
      return;
    }
  }
  
  public void y(boolean paramBoolean, String paramString1, String paramString2)
  {
    ajpd.a(this.a.a(), this.a.app, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgg
 * JD-Core Version:    0.7.0.1
 */