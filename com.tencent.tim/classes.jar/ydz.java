import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;

public class ydz
  extends BaseChatPie
{
  protected achq a;
  asgx jdField_a_of_type_Asgx;
  private ashx jdField_a_of_type_Ashx = new yef(this);
  private aclp b;
  private boolean bkI;
  private boolean bkJ;
  boolean blQ = false;
  private boolean blR;
  private String extStr;
  
  public ydz(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_Aclp = new yed(this);
    this.jdField_a_of_type_Achq = new yee(this);
  }
  
  private void DI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ujt.d(this.app, this.sessionInfo);
  }
  
  private void DJ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1600: 
      QQToast.a(this.mActivity, this.mActivity.getString(2131693275), 0).show(this.mActivity.getTitleBarHeight());
      return;
    case 1601: 
      QQToast.a(this.mActivity, this.mActivity.getString(2131693275), 0).show(this.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.mActivity, this.mActivity.getString(2131693274), 0).show(this.mActivity.getTitleBarHeight());
  }
  
  private void DK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Object localObject = (HotChatManager)this.app.getManager(60);
    localObject = this.mActivity.getString(2131699960);
    QQToast.a(this.mActivity, (CharSequence)localObject, 0).show(this.mActivity.getTitleBarHeight());
  }
  
  private void DL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str = String.format(this.mActivity.getString(2131692833), new Object[] { this.sessionInfo.aTn });
    QQToast.a(this.mActivity, str, 0).show(this.mActivity.getTitleBarHeight());
  }
  
  private void DM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QQToast.a(this.mActivity, this.mActivity.getString(2131721917), 0).show(this.mActivity.getTitleBarHeight());
    case 55: 
      return;
    }
    QQToast.a(this.mActivity, this.mActivity.getString(2131721916), 0).show(this.mActivity.getTitleBarHeight());
  }
  
  private void H(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = String.format(this.mActivity.getString(2131694536), new Object[] { this.sessionInfo.aTn });
    }
    switch (paramInt)
    {
    default: 
      if (paramInt > 100) {
        QQToast.a(this.mActivity, str, 0).show(this.mActivity.getTitleBarHeight());
      }
      return;
    case 102: 
    case 103: 
      QQToast.a(this.mActivity, str, 0).show(this.mActivity.getTitleBarHeight());
      anot.a(this.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_temp", 0, 0, paramString1, "", "", "");
      return;
    }
    QQToast.a(this.mActivity, str, 0).show(this.mActivity.getTitleBarHeight());
  }
  
  public static Serializable a(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerChatPie", 2, String.format(Locale.getDefault(), "hasWzryInfo [%d, %b, %b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getIntent();
      localObject1 = localObject2;
      if (paramContext != null)
      {
        localObject1 = localObject2;
        if (!paramBoolean1)
        {
          localObject1 = localObject2;
          if (!paramBoolean2)
          {
            localObject1 = localObject2;
            if (paramInt == 1022)
            {
              localObject1 = localObject2;
              if (paramContext.hasExtra("param_wzry_data")) {
                localObject1 = paramContext.getSerializableExtra("param_wzry_data");
              }
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  private void a(syw paramsyw)
  {
    l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.sessionInfo.aTl);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if ((this.sessionInfo.cZ == 9501) && (paramsyw != null) && (paramsyw.bn(l1)))
        {
          wmj.c(this.app, a(), this.sessionInfo);
        }
        else
        {
          xro.i(this.app, "0X800407C", this.sessionInfo.cZ);
          paramsyw = new ahau.a();
          paramsyw.bJE = "send_file";
          paramsyw.cYX = 1;
          ahau.a(this.app.getCurrentAccountUin(), paramsyw);
          auel.d(this.app, a(), this.sessionInfo);
        }
      }
    }
    if (this.sessionInfo.cZ == 1)
    {
      anot.a(this.app, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
      auel.d(this.app, a(), this.sessionInfo);
      a().setCanLock(false);
      return;
    }
  }
  
  private void bq(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "" + paramInt;
      }
      QQToast.a(this.mActivity, str, 0).show(this.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.mActivity, acfp.m(2131714986), 0).show(this.mActivity.getTitleBarHeight());
  }
  
  private void chn()
  {
    Object localObject = this.mActivity.getIntent();
    if (localObject == null) {}
    do
    {
      String str;
      do
      {
        return;
        str = ((Intent)localObject).getStringExtra("gid");
      } while (!ChatActivityUtils.i(this.app.getCurrentAccountUin(), this.sessionInfo.aTl, str));
      localObject = anre.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
    } while (localObject == null);
    aqmf.a(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, (AbsStructMsg)localObject, null);
    if (((acff)this.app.getManager(51)).isFriend(this.sessionInfo.aTl))
    {
      anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.aTl, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "1", "", "", "");
      return;
    }
    anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.aTl, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "", "1", "", "");
  }
  
  private void cho()
  {
    syw localsyw = (syw)this.app.getBusinessHandler(51);
    if (!CheckPermission.isHasStoragePermission(a()))
    {
      CheckPermission.requestSDCardPermission(a(), new yec(this, localsyw));
      return;
    }
    a(localsyw);
  }
  
  public void Ib()
  {
    this.TAG = "StrangerChatPie";
  }
  
  public boolean OI()
  {
    boolean bool = false;
    if ((this.aey) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean OL()
  {
    if (isFullScreenMode()) {
      return false;
    }
    if (this.aSN) {
      return false;
    }
    if (this.sessionInfo.cZ == 1006)
    {
      PhoneContact localPhoneContact = ((ajdo)this.app.getManager(11)).c(this.sessionInfo.aTl);
      String str2;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str2 = this.TAG;
        localStringBuilder = new StringBuilder().append("StrangerChatPie.showorhideAddFriend curFriendUin=").append(this.sessionInfo.aTl).append(" contact=");
        if (localPhoneContact != null) {
          break label126;
        }
      }
      label126:
      for (String str1 = "null";; str1 = "real")
      {
        QLog.d(str2, 2, str1);
        if (localPhoneContact == null) {
          break;
        }
        return false;
      }
    }
    if (this.sessionInfo.cZ == 10004) {
      return false;
    }
    return !((acff)this.app.getManager(51)).isFriend(this.sessionInfo.aTl);
  }
  
  public boolean ON()
  {
    return (this.sessionInfo.cZ != 1006) && (this.sessionInfo.cZ != 1000) && (this.sessionInfo.cZ != 10004) && (this.sessionInfo.cZ != 1004) && (this.sessionInfo.cZ != 10008);
  }
  
  public asgx a()
  {
    if (this.jdField_a_of_type_Asgx == null) {
      this.jdField_a_of_type_Asgx = ((asgx)this.app.getManager(165));
    }
    return this.jdField_a_of_type_Asgx;
  }
  
  public void bFq()
  {
    if ((this.aSd) && ((this.sessionInfo.cZ != 1025) || (!a().sH(this.sessionInfo.aTl))) && (this.sessionInfo.cZ == 1006))
    {
      Object localObject = ((ajdo)this.app.getManager(11)).c(this.sessionInfo.aTl);
      if ((localObject == null) || (aqgv.aU(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) {
        break label126;
      }
      localObject = aqgv.a((PhoneContact)localObject);
      vU(true);
      this.Cu.setText((CharSequence)localObject);
      if (aTl) {
        this.Cu.setContentDescription((CharSequence)localObject);
      }
    }
    label126:
    do
    {
      do
      {
        return;
      } while (this.Cu.getVisibility() != 0);
      vU(false);
    } while (this.jdField_a_of_type_Yjh.wN() != 5);
    yih.u(this.app, this.sessionInfo.aTl);
    this.jdField_a_of_type_Yjh.ciA();
  }
  
  public void bGR()
  {
    if (this.aSd) {
      bFq();
    }
  }
  
  public void bGS()
  {
    super.bGS();
    if (this.sessionInfo.cZ == 1003) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(8, 8);
    }
  }
  
  public void bGT()
  {
    this.ps.setOnClickListener(new yeb(this));
    if ((ChatActivityUtils.f(this.app, this.sessionInfo)) || (jqs.c(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ)) || (this.sessionInfo.cZ == 1)) {
      if (ixa.a().cD(this.app.getCurrentAccountUin()))
      {
        this.ps.setVisibility(0);
        this.ps.setContentDescription(this.mActivity.getResources().getString(2131700698));
      }
    }
    for (;;)
    {
      if ((this.sessionInfo.cZ != 0) && (this.sessionInfo.cZ != 1025)) {
        this.ps.setVisibility(8);
      }
      return;
      this.ps.setVisibility(8);
      continue;
      if ((this.mTitleText.getText() != null) && (this.mTitleText.getText().length() < 6)) {
        this.ps.setVisibility(4);
      } else {
        this.ps.setVisibility(8);
      }
    }
  }
  
  public void bGY()
  {
    if ((aqft.rj(this.sessionInfo.aTl)) && (aqft.bK(this.mContext))) {
      return;
    }
    Intent localIntent = new Intent(this.mActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.aTl);
    localIntent.putExtra("uinname", this.sessionInfo.aTn);
    localIntent.putExtra("uintype", this.sessionInfo.cZ);
    boolean bool;
    Object localObject;
    if (this.sessionInfo.cZ == 1006)
    {
      if ((this.sessionInfo.aTo == null) || (this.sessionInfo.aTo.equals("")))
      {
        bool = true;
        localIntent.putExtra("isShieldMsgSwitchUnClickable", bool);
      }
    }
    else
    {
      if ((1000 == this.sessionInfo.cZ) || (1004 == this.sessionInfo.cZ)) {
        localIntent.putExtra("troop_uin", this.sessionInfo.troopUin);
      }
      localIntent.putExtra("add_friend_source_id", this.sessionInfo.bPt);
      localIntent.putExtra("real_troop_uin", this.sessionInfo.aTm);
      localObject = a(this.mContext, this.sessionInfo.cZ, false, false);
      if (localObject == null) {
        break label265;
      }
      localIntent.putExtra("param_wzry_data", (Serializable)localObject);
      localIntent.putExtra("uinname", ((KplRoleInfo.WZRYUIinfo)localObject).nick);
    }
    for (;;)
    {
      this.mActivity.startActivityForResult(localIntent, 2000);
      return;
      bool = false;
      break;
      label265:
      if (KplRoleInfo.isKplPie(this))
      {
        localObject = this.sessionInfo.aTl;
        String str = KplRoleInfo.WZRYUIinfo.buildNickName(this.sessionInfo.aTn, KplRoleInfo.getGameNickByUin(this.app, (String)localObject));
        localIntent.putExtra("param_wzry_data", KplRoleInfo.WZRYUIinfo.createInfo((String)localObject, str, KplRoleInfo.getKplVerifyMsg(this.app), 0, 0));
        localIntent.putExtra("uinname", str);
      }
    }
  }
  
  public void bHP()
  {
    if ((this.sessionInfo.cZ == 1006) && (!this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.ZY()) && (!this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.ZZ())) {
      this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.bE(this.sessionInfo.aTl, true);
    }
    if (this.sessionInfo.cZ == 10004)
    {
      if (!TextUtils.isEmpty(this.extStr)) {
        break label132;
      }
      this.extStr = zyn.getString("", "strangerchat_ext", "");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.extStr))
      {
        yiw localyiw = new yiw(this.mContext);
        this.jdField_a_of_type_Yjh.a(localyiw, new Object[] { this.extStr });
      }
      super.bHP();
      return;
      label132:
      zyn.putString("", "strangerchat_ext", this.extStr);
    }
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addObserver(this.jdField_a_of_type_Achq);
    this.app.addObserver(this.jdField_b_of_type_Aclp);
    this.app.addObserver(this.jdField_a_of_type_Ashx);
  }
  
  public void bHa()
  {
    Object localObject;
    if ((this.sessionInfo.cZ == 1000) || (this.sessionInfo.cZ == 1020) || (this.sessionInfo.cZ == 1004)) {
      localObject = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.aTm, aqgv.jZ(this.sessionInfo.cZ), 3);
    }
    for (;;)
    {
      this.sessionInfo.aTn = ((String)localObject);
      return;
      if (this.sessionInfo.cZ == 1006)
      {
        localObject = ((ajdo)this.app.getManager(11)).c(this.sessionInfo.aTl);
        if (localObject != null) {
          localObject = ((PhoneContact)localObject).name;
        } else if (this.sessionInfo.aTo != null) {
          localObject = aqgv.a(this.app, this.sessionInfo.aTo, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
        } else {
          localObject = this.sessionInfo.aTl;
        }
      }
      else
      {
        String str = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
        localObject = str;
        if (this.sessionInfo.cZ == 1005) {
          if (str != null)
          {
            localObject = str;
            if (!str.equals(this.sessionInfo.aTl)) {}
          }
          else
          {
            this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.DG(this.sessionInfo.aTl);
            localObject = str;
          }
        }
      }
    }
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
    this.app.removeObserver(this.jdField_b_of_type_Aclp);
    this.app.removeObserver(this.jdField_a_of_type_Ashx);
  }
  
  public void bJf()
  {
    super.bJf();
    this.jdField_a_of_type_Wvm.a(this);
  }
  
  public void bo(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if ((this.sessionInfo.cZ != 1000) && (this.sessionInfo.cZ != 1020) && (this.sessionInfo.cZ != 1004)) {
        break label124;
      }
      paramIntent = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.aTm, aqgv.jZ(this.sessionInfo.cZ), 3);
    }
    for (;;)
    {
      this.sessionInfo.aTn = paramIntent;
      this.mTitleText.setText(this.sessionInfo.aTn);
      this.mTitleText.setOnClickListener(new yea(this));
      return;
      label124:
      if (this.sessionInfo.cZ == 1006)
      {
        paramIntent = ((ajdo)this.app.getManager(11)).c(this.sessionInfo.aTl);
        if (paramIntent != null) {
          paramIntent = paramIntent.name;
        } else if (this.sessionInfo.aTo != null) {
          paramIntent = aqgv.a(this.app, this.sessionInfo.aTo, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
        } else {
          paramIntent = this.sessionInfo.aTl;
        }
      }
      else
      {
        str = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
        if (str != null)
        {
          paramIntent = str;
          if (!str.equals(this.sessionInfo.aTl)) {}
        }
        else if ((this.sessionInfo.cZ != 1005) && (this.sessionInfo.cZ != 1025))
        {
          paramIntent = str;
          if (this.sessionInfo.cZ != 10004) {}
        }
        else
        {
          this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.DG(this.sessionInfo.aTl);
          paramIntent = str;
        }
      }
    }
  }
  
  public void br(Intent paramIntent)
  {
    super.br(paramIntent);
    if (this.sessionInfo.cZ == 1025)
    {
      paramIntent = paramIntent.getByteArrayExtra("sigt");
      if (paramIntent != null)
      {
        this.app.a().o(this.sessionInfo.aTl, paramIntent);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.TAG, 4, "updateSession()--AIO 已保存 sigt");
        }
      }
      if (a().oU.containsKey(this.sessionInfo.aTl)) {
        a().dI(this.sessionInfo.aTl, true);
      }
      if (a().sH(this.sessionInfo.aTl)) {
        ((FriendListHandler)this.app.getBusinessHandler(1)).DG(this.sessionInfo.aTl);
      }
    }
    if ((this.sessionInfo.cZ == 1004) && (QLog.isColorLevel())) {
      QLog.i("addFriendTag", 4, String.format(Locale.getDefault(), "BaseChatPie addFriend uin: %s troopuin: %s sourceId: %d", new Object[] { this.sessionInfo.aTl, this.sessionInfo.troopUin, Integer.valueOf(this.sessionInfo.bPt) }));
    }
  }
  
  public void bs(Intent paramIntent)
  {
    super.bs(paramIntent);
    aqmq.track(null, "AIO_updateSession_business");
    Object localObject;
    if ((this.sessionInfo.cZ == 1000) || (this.sessionInfo.cZ == 1020))
    {
      this.sessionInfo.aTm = paramIntent.getStringExtra("troop_code");
      if ((this.sessionInfo.aTm == null) || (this.sessionInfo.aTm.trim().length() == 0))
      {
        localObject = (TroopManager)this.app.getManager(52);
        this.sessionInfo.aTm = ((TroopManager)localObject).jp(this.sessionInfo.troopUin);
        if (this.sessionInfo.aTm == null)
        {
          localObject = (HotChatManager)this.app.getManager(60);
          this.sessionInfo.aTm = ((HotChatManager)localObject).jk(this.sessionInfo.troopUin);
        }
      }
    }
    for (;;)
    {
      this.blQ = paramIntent.getBooleanExtra("fromSencondhandCommunity", false);
      this.bkJ = paramIntent.getBooleanExtra("from3rdApp", false);
      this.blR = paramIntent.getBooleanExtra("from_wpa_for_crm", false);
      this.bkI = yfn.a(this.app, this.sessionInfo, paramIntent);
      aqmq.track("AIO_updateSession_business", null);
      return;
      if (this.sessionInfo.cZ == 1004)
      {
        this.sessionInfo.aTm = this.sessionInfo.troopUin;
      }
      else if (this.sessionInfo.cZ == 1006)
      {
        localObject = ((ajdo)this.app.getManager(11)).a();
        if (localObject != null) {
          this.sessionInfo.phoneNum = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
        }
        this.sessionInfo.aTo = aqgv.x(this.app, this.sessionInfo.aTl);
        if ((this.sessionInfo.aTo == null) && (QLog.isColorLevel())) {
          QLog.e(this.TAG, 2, "contactUin == null");
        }
        this.aSc = false;
        this.aSd = true;
      }
      else if (this.sessionInfo.cZ == 1003)
      {
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
        {
          ujt.h(this.app, this.sessionInfo);
        }
        else
        {
          localObject = ((acff)this.app.getManager(51)).b(this.sessionInfo.aTl);
          if (localObject == null)
          {
            if (aqmr.verifyUin(this.sessionInfo.aTl)) {
              ((CardHandler)this.app.getBusinessHandler(2)).a(this.app.getCurrentAccountUin(), this.sessionInfo.aTl, (byte)1, 0);
            }
          }
          else if ((localObject != null) && (((Card)localObject).strCertificationInfo != null) && (!((Card)localObject).strCertificationInfo.equals(""))) {
            ujt.h(this.app, this.sessionInfo);
          }
        }
      }
      else if (this.sessionInfo.cZ == 1009)
      {
        localObject = paramIntent.getByteArrayExtra("rich_status_sig");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "From chatActivity : sameState Sig--->" + aqhs.bytes2HexStr((byte[])localObject));
        }
        if (localObject != null) {
          this.app.a().r(this.sessionInfo.aTl, (byte[])localObject);
        }
      }
      else if ((this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002))
      {
        localObject = paramIntent.getByteArrayExtra("rich_accost_sig");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "From chatActivity : accost Sig--->" + aqhs.bytes2HexStr((byte[])localObject));
        }
        if (localObject != null) {
          this.app.a().s(this.sessionInfo.aTl, (byte[])localObject);
        }
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
        {
          ujt.h(this.app, this.sessionInfo);
        }
        else
        {
          localObject = ((acff)this.app.getManager(51)).b(this.sessionInfo.aTl);
          if (localObject == null)
          {
            if (aqmr.verifyUin(this.sessionInfo.aTl)) {
              ((CardHandler)this.app.getBusinessHandler(2)).a(this.app.getCurrentAccountUin(), this.sessionInfo.aTl, (byte)1, 0);
            }
          }
          else if ((localObject != null) && (((Card)localObject).strCertificationInfo != null) && (!((Card)localObject).strCertificationInfo.equals(""))) {
            ujt.h(this.app, this.sessionInfo);
          }
        }
      }
      else if (this.sessionInfo.cZ == 10004)
      {
        localObject = paramIntent.getByteArrayExtra("rich_movie_sig");
        if (localObject != null) {
          this.app.a().u(this.sessionInfo.aTl, (byte[])localObject);
        }
        this.extStr = paramIntent.getStringExtra("strangerchat_ext");
      }
      else if (this.sessionInfo.cZ == 1010)
      {
        localObject = paramIntent.getByteArrayExtra("rich_date_sig");
        if (localObject != null) {
          this.app.a().w(this.sessionInfo.aTl, (byte[])localObject);
        }
      }
      else if (this.sessionInfo.cZ == 10008)
      {
        localObject = paramIntent.getByteArrayExtra("rich_date_sig");
        if (localObject != null) {
          this.app.a().j(this.sessionInfo.aTl, this.app.getCurrentUin(), (byte[])localObject);
        }
      }
    }
  }
  
  public void bt(Intent paramIntent)
  {
    super.bt(paramIntent);
    if ((paramIntent.hasExtra("key_sub_title_from")) && ((this.sessionInfo.cZ != 1025) || (!a().sH(this.sessionInfo.aTl))))
    {
      paramIntent = paramIntent.getStringExtra("key_sub_title_from");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (this.Cu.getVisibility() == 8) {
          vU(true);
        }
        this.Cu.setText(paramIntent);
        this.aSc = false;
      }
    }
  }
  
  public void chp()
  {
    if (this.sessionInfo.cZ == 1006)
    {
      Intent localIntent = AddFriendLogicActivity.a(this.mActivity, 2, this.sessionInfo.aTl, null, 3006, 12, this.sessionInfo.aTn, null, null, null, null);
      this.mActivity.startActivity(localIntent);
    }
  }
  
  public void doOnDestroy()
  {
    if (this.ps != null) {
      this.ps.setOnClickListener(null);
    }
    if ((this.jdField_a_of_type_Asgx != null) && (this.sessionInfo.cZ == 1025)) {
      this.jdField_a_of_type_Asgx.gC(this.sessionInfo.aTl, this.sessionInfo.cZ);
    }
    if ((this.jdField_a_of_type_Asgx != null) && (this.jdField_a_of_type_Asgx.sH(this.sessionInfo.aTl))) {
      ((ashy)this.app.getBusinessHandler(85)).ab(null, this.sessionInfo.aTl, false);
    }
    if (jou.df(this.sessionInfo.aTl)) {
      if (this.jdField_a_of_type_Asgx != null) {
        break label210;
      }
    }
    label210:
    for (String str = "";; str = this.jdField_a_of_type_Asgx.qW(this.sessionInfo.aTl))
    {
      anot.a(this.app, "dc00899", "Qidian", this.sessionInfo.aTl, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "3.4.4", "");
      if (KplRoleInfo.isKplPie(this))
      {
        ((acff)this.app.getManager(51)).bHx = false;
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "kpl global has been remove, because StrangerChatPie close");
        }
      }
      super.doOnDestroy();
      return;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    acff localacff = (acff)this.app.getManager(51);
    if (KplRoleInfo.isKplPie(this))
    {
      localacff.bHx = true;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "open kpl session, mark global flag");
      }
    }
    do
    {
      return;
      localacff.bHx = false;
    } while (!QLog.isColorLevel());
    QLog.d("KplMessage", 2, "not open kpl session, reset global flag");
  }
  
  public void k(Object paramObject)
  {
    super.k(paramObject);
    if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 16)) {
      cho();
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.bkJ) && (this.mActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (yfn.a(this.app, this.mActivity, this.sessionInfo))) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void send()
  {
    super.send();
    if (this.blQ)
    {
      this.blQ = false;
      chn();
    }
    if (this.bkI)
    {
      yfn.a(this.app, this.mActivity, this.sessionInfo, this.bkI);
      this.bkI = false;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (this.sessionInfo.aTl.equals(paramObservable.frienduin)) && ((this.sessionInfo.cZ == paramObservable.istroop) || ((top.fv(this.sessionInfo.cZ)) && (top.fv(paramObservable.istroop)))) && ((this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.app.b().a();
        if ((paramObservable != null) && ((paramObservable.istroop == 1001) || (paramObservable.istroop == 10002)) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.da(this.mActivity.getApplicationContext(), paramObservable.action);
        }
      }
    }
  }
  
  public void vW(boolean paramBoolean)
  {
    if ((this.bkJ) && (this.mActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (yfn.a(this.app, this.mActivity, this.sessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    super.vW(paramBoolean);
  }
  
  public boolean z(MessageRecord paramMessageRecord)
  {
    return (this.sessionInfo.aTl.equals(paramMessageRecord.frienduin)) && ((top.fN(this.sessionInfo.cZ)) || (this.sessionInfo.cZ == paramMessageRecord.istroop) || ((top.fv(this.sessionInfo.cZ)) && (top.fv(paramMessageRecord.istroop))));
  }
  
  public void zZ(int paramInt)
  {
    super.zZ(paramInt);
    if (jou.df(this.sessionInfo.aTl))
    {
      bIr();
      if (this.jdField_a_of_type_Asgx != null) {
        break label93;
      }
    }
    label93:
    for (String str = "";; str = this.jdField_a_of_type_Asgx.qW(this.sessionInfo.aTl))
    {
      anot.a(this.app, "dc00899", "Qidian", this.sessionInfo.aTl, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "3.4.4", "");
      ((aizh)this.app.getManager(303)).a(this.sessionInfo, this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydz
 * JD-Core Version:    0.7.0.1
 */