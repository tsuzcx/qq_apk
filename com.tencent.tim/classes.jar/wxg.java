import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class wxg
  implements wvs
{
  private static int bSm = -1;
  public xrh a;
  private QQAppInterface app;
  private BaseChatPie c;
  private Activity mActivity;
  private Context mContext;
  private SessionInfo mSessionInfo;
  
  public wxg(BaseChatPie paramBaseChatPie)
  {
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.c = paramBaseChatPie;
    this.mSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private boolean So()
  {
    if (!Sp()) {}
    while (!Sq()) {
      return false;
    }
    return true;
  }
  
  public static boolean Sp()
  {
    if (bSm == -1) {
      bSm = wm();
    }
    return bSm != 0;
  }
  
  private wsr a()
  {
    if (!wsp.isSupport())
    {
      QLog.d("TroopAppShortcutHelper", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.mSessionInfo == null) || (TextUtils.isEmpty(this.mSessionInfo.aTl)) || (this.c == null))
    {
      QLog.d("TroopAppShortcutHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    return new wsx(this.c);
  }
  
  private static int wm()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutHelper", 2, "getLocalTroopAppShortcutSwitchStatus() called load from sp");
      }
      localObject = (QQAppInterface)localObject;
      return BaseApplicationImpl.getApplication().getSharedPreferences("troopapp_shortcut_switch_sp" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).getInt("key_troopapp_shortcut_switch", 1);
    }
    return -1;
  }
  
  public int[] C()
  {
    return new int[] { 3, 7, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      onCreate();
      return;
    case 7: 
      ccC();
      return;
    }
    onDestroy();
  }
  
  public boolean Sq()
  {
    boolean bool = ajkq.a(this.app).ns(this.c.sessionInfo.troopUin);
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutHelper", 2, String.format("canShowTroopAppShortcut: %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  public void ccC()
  {
    ccZ();
  }
  
  public void ccZ()
  {
    if (this.a == null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.c.mAIORootView.findViewById(2131364469);
      this.a = new xrh(this.c, this.app, this.mContext, this.mSessionInfo, localRelativeLayout);
    }
    this.a.Dq(3);
    this.a.setTopMargin(75);
    this.a.refresh();
  }
  
  public void cda()
  {
    if (this.a == null) {
      return;
    }
    this.a.gv(3);
  }
  
  public void onCreate()
  {
    if (((this.c instanceof TroopChatPie)) && (So())) {
      this.c.jdField_a_of_type_Wsr = a();
    }
    if ((this.c.jdField_a_of_type_Wsr != null) && ((this.c instanceof TroopChatPie)))
    {
      if (jof.a().dd(this.c.sessionInfo.aTl)) {
        break label145;
      }
      wja.S((InputLinearLayout)this.c.mAIORootView.findViewById(2131369277), 2130850842);
      if (ThemeUtil.isDefaultTheme()) {
        break label129;
      }
      this.c.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130851105);
    }
    for (;;)
    {
      this.c.cL.setBackgroundDrawable(this.c.sessionInfo.a.img);
      return;
      label129:
      this.c.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130851106);
    }
    label145:
    this.c.cL.setBackgroundResource(2130844446);
    this.c.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130844452);
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxg
 * JD-Core Version:    0.7.0.1
 */