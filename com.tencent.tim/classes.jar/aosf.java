import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.activity.JoinTroopUtil.4;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;

public class aosf
  extends arhz
{
  private String So;
  private aosf.a jdField_a_of_type_Aosf$a;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  private acnd jdField_b_of_type_Acnd;
  private TroopManager jdField_b_of_type_ComTencentMobileqqAppTroopManager;
  private String bOx;
  private acms c;
  private volatile boolean cOw;
  private QQAppInterface mApp;
  private Context mContext;
  private Handler mMainHandler;
  private BroadcastReceiver mReceiver;
  
  private aosf(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2, int paramInt, String paramString3, String paramString4, aosf.a parama)
  {
    super(paramContext);
    a(paramContext, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, paramString1, paramString2, paramInt, paramString3, paramString4, parama);
  }
  
  private int KY()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "doJoinTroop");
    }
    if (!aqiw.isNetSupport(this.mContext))
    {
      cf(2131696270, 1);
      i = 2;
    }
    do
    {
      return i;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 34) && (afsi.me(this.mApp.getCurrentAccountUin())))
      {
        afyk.b(this.mContext).show();
        return 1;
      }
      if (QSecFramework.a().c(1001).booleanValue()) {
        QSecFramework.a().sendCmdToLib(5, 0, 2, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6), "joingroup", null }, null);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.So)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop())
        {
          dWL();
          return 1;
        }
        bLs();
        return 0;
      }
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.c.aA(l, 8390785);
        return 0;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("AddTroopUtil", 2, localException.toString());
    return 0;
  }
  
  private void Rh(boolean paramBoolean)
  {
    this.cOw = paramBoolean;
  }
  
  private void Sg(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "jumpJoinTroopVerify");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      paramString = AddFriendLogicActivity.a(this.mContext, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, "", this.So, this.bOx, paramString);
      this.mContext.startActivity(paramString);
      this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
      return;
    }
    cf(2131721390, 0);
    gh(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
  }
  
  private void Sh(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "gotoWebInfo, url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(this.mContext, 2, 2131718833, 1).show(getTitleBarHeight());
    }
    for (;;)
    {
      gh(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 3);
      return;
      paramString = paramString + "?_wv=1031&troopUin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&isVerify=" + 0;
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("finish_animation_up_down", true);
      this.mContext.startActivity(localIntent);
      if ((this.mContext instanceof Activity)) {
        ((Activity)this.mContext).overridePendingTransition(2130772009, 2130772002);
      }
    }
  }
  
  private void a(@NonNull Context paramContext, @NonNull TroopInfoData paramTroopInfoData, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, aosf.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "init");
    }
    this.mContext = paramContext;
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Aosf$a = parama;
    this.mApp = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_b_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.mApp.getManager(52));
    this.c = ((acms)this.mApp.getBusinessHandler(20));
    paramTroopInfoData.troopUin = (paramString1 + "");
    paramTroopInfoData.pa = paramInt;
    paramTroopInfoData.troopName = (paramString2 + "");
    if (TextUtils.isEmpty(paramTroopInfoData.newTroopName)) {
      paramTroopInfoData.newTroopName = paramTroopInfoData.troopName;
    }
    this.So = (paramString3 + "");
    this.bOx = (paramString4 + "");
    this.cOw = false;
    this.jdField_b_of_type_Acnd = new aosg(this);
    this.mReceiver = new aosh(this);
    registerObserver();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, boolean paramBoolean, aosf.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinTroop by uin");
    }
    paramContext = new aosf(paramContext, paramString1, paramString2, paramInt, paramString3, paramString4, parama);
    paramContext.Rh(paramBoolean);
    a(paramContext);
  }
  
  private static void a(@NonNull aosf paramaosf)
  {
    paramaosf.setCancelable(false);
    paramaosf.setCanceledOnTouchOutside(false);
    paramaosf.setMessage(2131696693);
    if (paramaosf.KY() == 0)
    {
      paramaosf.show();
      return;
    }
    paramaosf.unRegisterObserver();
    paramaosf.gh(paramaosf.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
  }
  
  private void a(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, String.format("handle0x88d isSuccess = %s, troopUin = %s, troopInfo = %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramTroopInfo }));
    }
    String str = String.valueOf(paramLong);
    if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "handle0x88d return due to different uin");
      }
      gh(str, 2);
      return;
    }
    if (paramTroopInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "handle0x88d return due to empty troopInfo");
      }
      gh(str, 2);
      return;
    }
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramTroopInfo.troopname)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramTroopInfo.troopname;
      }
      if (!TextUtils.isEmpty(paramTroopInfo.newTroopName)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = paramTroopInfo.newTroopName;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "troop.isOnlyTroopMemberInviteOption() true");
        }
        paramTroopInfo.setOnlyTroopMemberInviteOption(false);
        paramTroopInfo.cGroupOption = 2;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOnlyTroopMemberInvite = false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "handle0x88d return due to HomeworkGroup");
        }
        dWL();
        gh(str, 4);
        return;
      }
      paramBoolean = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128);
      boolean bool = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512);
      if ((paramBoolean) && (bool))
      {
        dWM();
        gh(str, 4);
        return;
      }
      qn(null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "handle0x88d return due rsp failed");
    }
    cf(2131719483, 1);
    gh(str, 2);
  }
  
  private void bLs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinGroup");
    }
    this.c.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.So, this.bOx, null, null);
  }
  
  private void cf(int paramInt1, int paramInt2)
  {
    new arie(this.mContext).V(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  private void dWL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinHomeworkGroup");
    }
    apqz.p(this.mContext, this.mApp.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  private void dWM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinPayGroup");
    }
    yxe.bm(this.mContext, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  private void dWN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "go2AIO");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(this.mContext, ChatActivity.class);; localIntent = new Intent(this.mContext, SplashActivity.class))
    {
      localIntent = wja.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      this.mContext.startActivity(localIntent);
      return;
    }
  }
  
  private void e(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, String.format("onJoinTroopRsp isSuccess = %s, reqtype = %s, result = %s, troopUin = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    if (paramBoolean) {
      if (1 == paramInt1) {
        switch (paramInt2)
        {
        case -1: 
        default: 
          if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "onJoinTroopRsp failed");
          }
          cf(2131695144, 1);
          gh(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
        }
      }
    }
    for (;;)
    {
      dismiss();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoWebInfo");
      }
      this.c.ad(Long.parseLong(paramString), Long.parseLong(this.mApp.getAccount()));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoAIO = " + this.cOw);
      }
      if (this.cOw) {
        dWN();
      }
      TroopInfo localTroopInfo = this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.c(paramString);
      localTroopInfo.troopuin = paramString;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {}
      for (localTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;; localTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)
      {
        this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.h(localTroopInfo);
        this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.l(localTroopInfo);
        gh(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp join forbidden");
      }
      cf(2131721390, 1);
      gh(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      continue;
      if (1 == paramInt1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "onJoinTroopRsp rsp failed");
        }
        apuh.t((Activity)this.mContext, paramInt2);
        gh(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      }
    }
  }
  
  private void gh(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "onJoinTroopDone: troopUin = " + paramString + ", ret = " + paramInt + ", trace = " + Log.getStackTraceString(new RuntimeException()));
    }
    if (this.jdField_a_of_type_Aosf$a != null) {
      this.jdField_a_of_type_Aosf$a.fQ(paramString, paramInt);
    }
    dismiss();
  }
  
  private boolean qn(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "realJoinGroup");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)
    {
      bLs();
      return false;
    }
    Sg(paramString);
    return true;
  }
  
  private void registerObserver()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "registerObserver");
    }
    this.mApp.addObserver(this.jdField_b_of_type_Acnd);
    this.mContext.registerReceiver(this.mReceiver, new IntentFilter("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION"));
    setOnDismissListener(new aosi(this));
    this.mMainHandler.postDelayed(new JoinTroopUtil.4(this), 15000L);
  }
  
  private void unRegisterObserver()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "unRegisterObserver");
    }
    this.mMainHandler.removeCallbacksAndMessages(null);
    this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
    try
    {
      this.mContext.unregisterReceiver(this.mReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AddTroopUtil", 2, "unRegisterObserver error", localException);
    }
  }
  
  public int getTitleBarHeight()
  {
    return this.mContext.getResources().getDimensionPixelSize(2131299627);
  }
  
  public static abstract interface a
  {
    public abstract void fQ(String paramString, @IntRange(from=1L, to=4L) int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosf
 * JD-Core Version:    0.7.0.1
 */