import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.i;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie.7;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class xyi
  extends BaseChatPie
{
  private TextView Ct;
  public ausj Z;
  private acdv jdField_a_of_type_Acdv = new xyl(this);
  protected achq a;
  yij jdField_a_of_type_Yij;
  private Dialog ae;
  accd jdField_b_of_type_Accd = new xym(this);
  private Observer jdField_b_of_type_JavaUtilObserver = new xyo(this);
  
  public xyi(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Achq = new xyp(this);
  }
  
  private void cfW()
  {
    acdu localacdu = (acdu)this.app.getManager(53);
    DiscussionInfo localDiscussionInfo = localacdu.a(this.sessionInfo.aTl);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.sessionInfo.aTn = localDiscussionInfo.discussionName;
      b(this.sessionInfo.aTn, localDiscussionInfo.uin, this.mTitleText);
    }
    if (localacdu.jj.containsKey(this.sessionInfo.aTl)) {
      cfX();
    }
  }
  
  private void cfX()
  {
    if ((this.ae != null) && (this.ae.isShowing())) {}
    acdu localacdu;
    Object localObject1;
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          return;
          localacdu = (acdu)this.app.getManager(53);
          if (localacdu.jj.containsKey(this.sessionInfo.aTl)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.TAG, 2, "DiscussionManager's discToTroopCache doesn't contain discussionUIN :" + this.sessionInfo.aTl);
        return;
        localObject1 = (String[])localacdu.jj.get(this.sessionInfo.aTl);
      } while ((localObject1 == null) || (localObject1.length < 2));
      str1 = localObject1[0];
      str2 = localObject1[1];
    } while (this.mActivity.isFinishing());
    for (;;)
    {
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130843306);
        localObject2 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = aqhu.c((Bitmap)localObject1, 10.0F, 140, 140);
          this.ae = aqha.a(this.mContext, (Bitmap)localObject2, aqgv.k(this.app, this.sessionInfo.aTl, str2) + acfp.m(2131705130), acfp.m(2131705129) + str1, this.mContext.getString(2131720227), null, new xyk(this, str1), null);
          if ((this.ae != null) && (!this.mActivity.isFinishing())) {
            this.ae.show();
          }
          localacdu.jj.remove(this.sessionInfo.aTl);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject2;
          break label308;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject1 = null;
      }
      label308:
      if (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 2, QLog.getStackTraceString(localOutOfMemoryError1));
        localObject2 = localObject1;
      }
    }
  }
  
  private void cfY()
  {
    Intent localIntent = new Intent(this.mActivity, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.aTl);
    localIntent.putExtra("uinname", this.sessionInfo.aTn);
    localIntent.putExtra("uintype", this.sessionInfo.cZ);
    if ((1000 == this.sessionInfo.cZ) || (1004 == this.sessionInfo.cZ)) {
      localIntent.putExtra("troop_uin", this.sessionInfo.troopUin);
    }
    this.mActivity.startActivityForResult(localIntent, 2000);
  }
  
  private void cfZ()
  {
    Intent localIntent = TroopMemberListActivity.c(this.mActivity, this.sessionInfo.aTl, 11);
    localIntent.putExtra("param_is_pop_up_style", true);
    localIntent.setFlags(603979776);
    this.mActivity.startActivityForResult(localIntent, 6001);
    if (super.vm() == 21) {
      localIntent.putExtra("param_troop_send_apollo_msg", true);
    }
  }
  
  private void yr(String paramString)
  {
    Intent localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("input_text", this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString());
    localIntent.putExtra("input_panel_status", this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm());
    this.mActivity.startActivity(localIntent);
  }
  
  public void Ib()
  {
    this.TAG = "DiscussChatPie";
  }
  
  public boolean OI()
  {
    boolean bool = false;
    if ((this.aey) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.Pc();
    return aqlv.a(this.app, bool);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_Wki.getCount() > 0)
    {
      this.Fp = SystemClock.uptimeMillis();
      ((wkk)this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.context).fU(this.Fp);
      if (this.jdField_a_of_type_Apat != null)
      {
        if (this.jdField_a_of_type_Apat.valid)
        {
          this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = true;
          this.app.b().a().a(this.sessionInfo.aTl, this.sessionInfo.cZ, this.jdField_a_of_type_Apat.aqG, this.jdField_a_of_type_Apat.aqH, this.jdField_a_of_type_Apat.aPY, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
          this.jdField_a_of_type_Apat.dYv();
          return true;
        }
        this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = false;
        this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQj = true;
        this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, 20, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
        return true;
      }
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = false;
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQj = true;
      this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, 20, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
      return true;
    }
    vY(false);
    return true;
  }
  
  public void b(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "genDiscussTitle, name == null");
      }
    }
    int i;
    do
    {
      return;
      i = ((acdu)this.app.getManager(53)).cn(this.sessionInfo.aTl);
      paramString1 = new aofk(paramString1, 1);
      if (i > 0) {
        break;
      }
      paramTextView.setText(paramString1);
    } while (!AppSetting.enableTalkBack);
    paramTextView.setContentDescription(paramTextView.getText().toString());
    a().setTitle(paramTextView.getText());
    return;
    if (this.Ct == null) {
      this.Ct = ((TextView)this.cJ.findViewById(2131365958));
    }
    this.Ct.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    if (this.Ct.getVisibility() != 0)
    {
      this.Ct.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (this.du) {
          break label235;
        }
      }
    }
    label235:
    for (boolean bool = true;; bool = false)
    {
      paramString2.bN(bool, this.sessionInfo.cZ);
      paramTextView.setText(paramString1);
      if (!AppSetting.enableTalkBack) {
        break;
      }
      paramTextView.setContentDescription(paramTextView.getText().toString());
      a().setTitle(paramTextView.getText());
      return;
    }
  }
  
  public void bGK()
  {
    super.bGK();
    yic localyic = new yic(this.app, this.jdField_a_of_type_Yjh, this.mActivity, this.sessionInfo, this.jdField_a_of_type_Wki);
    yie localyie = new yie(this.app, this.jdField_a_of_type_Yjh, this.mActivity, this.sessionInfo, this.jdField_a_of_type_Wki);
    this.jdField_a_of_type_Yij = new yij(this.app, this.jdField_a_of_type_Yjh, this.mActivity, this.sessionInfo);
    this.jdField_a_of_type_Yjh.a(localyic);
    this.jdField_a_of_type_Yjh.a(localyie);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yij);
  }
  
  public void bGT()
  {
    this.ps.setOnClickListener(new xyj(this));
    if (ixa.a().cD(this.app.getCurrentAccountUin()))
    {
      this.ps.setVisibility(0);
      this.ps.setContentDescription(this.mActivity.getResources().getString(2131700701));
    }
    for (;;)
    {
      bIL();
      return;
      this.ps.setVisibility(8);
    }
  }
  
  public void bGW()
  {
    bIY();
  }
  
  public void bGY()
  {
    cfY();
  }
  
  public void bGZ()
  {
    a(this.pp, 2130851139, 2130851140);
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addDefaultObservers(this.jdField_a_of_type_Achq);
    this.app.addObserver(this.jdField_a_of_type_Acdv);
    this.app.addObserver(this.jdField_b_of_type_Accd);
    ((ahvn)this.app.getManager(156)).a().addObserver(this.jdField_b_of_type_JavaUtilObserver);
  }
  
  public void bIL()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.ejD();
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
    this.app.removeObserver(this.jdField_a_of_type_Acdv);
    this.app.removeObserver(this.jdField_b_of_type_Accd);
    ((ahvn)this.app.getManager(156)).a().deleteObserver(this.jdField_b_of_type_JavaUtilObserver);
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
    if (str == null) {
      paramIntent = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
    }
    this.sessionInfo.aTn = paramIntent;
    b(this.sessionInfo.aTn, this.sessionInfo.aTl, this.mTitleText);
    this.cJ.setOnClickListener(this);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    bIL();
  }
  
  protected void cfv()
  {
    if (this.jdField_a_of_type_Apat == null) {
      this.jdField_a_of_type_Apat = new apat();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(this.jdField_a_of_type_Apat);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "Dis#onShow_troopType#setTroopTips");
      }
    }
    this.jdField_a_of_type_Apat.onResume();
    this.jdField_a_of_type_Apat.a(this.app, this.mActivity, this, this.sessionInfo, this.fs, this.jdField_a_of_type_Wki, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_Apat != null) && (this.jdField_a_of_type_Yjh.wN() != 9)) {
      this.jdField_a_of_type_Apat.dYs();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    String str1;
    Object localObject;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
      case 6001: 
        do
        {
          return;
          str1 = paramIntent.getExtras().getString("member_uin");
          localObject = paramIntent.getExtras().getString("member_display_name");
          if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.jdField_a_of_type_Abzy == null)) {
            break;
          }
        } while ("0".equals(str1));
        paramIntent = aqgv.o(this.app, this.sessionInfo.aTl, str1);
        if (TextUtils.isEmpty(paramIntent)) {
          paramIntent = (Intent)localObject;
        }
        break;
      }
    }
    for (;;)
    {
      paramIntent = new StringBuilder("@").append(paramIntent);
      this.jdField_a_of_type_Abzy.c.peerUin = str1;
      this.jdField_a_of_type_Abzy.c.atNickName = paramIntent.toString();
      this.jdField_a_of_type_Abzy.c.inputText = aofy.iF(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      a(this.jdField_a_of_type_Abzy);
      paramInt1 = 0;
      String str2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Abzy.c.inputText))
      {
        paramInt2 = 2;
        paramInt1 = paramInt2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Abzy.bkj))
        {
          if (this.jdField_a_of_type_Abzy.cue == 0) {
            paramInt1 = 6;
          }
        }
        else
        {
          localObject = this.app;
          str1 = this.sessionInfo.aTl;
          paramInt2 = ApolloUtil.gi(this.sessionInfo.cZ);
          str2 = "" + this.jdField_a_of_type_Abzy.c.actionId;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Abzy.bkj)) {
            break label463;
          }
        }
      }
      label463:
      for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_Abzy.bkj)
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, paramInt1, paramInt2, new String[] { str2, paramIntent, this.jdField_a_of_type_Abzy.c.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Abzy.cue != 1) {
          break;
        }
        paramInt1 = 7;
        break;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Abzy.bkj))
        {
          paramInt1 = 3;
          break;
        }
        if (this.jdField_a_of_type_Abzy.cue == 0)
        {
          paramInt1 = 4;
          break;
        }
        if (this.jdField_a_of_type_Abzy.cue != 1) {
          break;
        }
        paramInt1 = 5;
        break;
      }
      s(str1, (String)localObject, true);
      return;
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getStringExtra("result"); (paramIntent != null) && (!paramIntent.equals("")); paramIntent = "")
      {
        if (aqiw.isNetSupport(a()))
        {
          ((acdt)this.app.getBusinessHandler(6)).ad(Long.valueOf(this.sessionInfo.aTl).longValue(), paramIntent);
          return;
        }
        QQToast.a(this.mContext, this.mContext.getString(2131696348), 0).show(getTitleBarHeight());
        return;
        if (this.jdField_a_of_type_Smx == null) {
          break;
        }
        localObject = this.jdField_a_of_type_Smx.a();
        if (localObject == null) {
          break;
        }
        ((TroopGiftPanel)localObject).cP(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
        return;
        if (paramInt2 != 0) {
          break;
        }
        switch (paramInt1)
        {
        default: 
          return;
        }
        if (!this.sessionInfo.beA) {
          break;
        }
        BaseChatpieHelper.a(this.sessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_b_of_type_ComTencentWidgetPatchedButton, false);
        return;
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.sessionInfo.aTn != null) {
      b(this.sessionInfo.aTn, this.sessionInfo.aTl, this.mTitleText);
    }
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  public void doOnDestroy()
  {
    if ((this.Z != null) && (this.Z.isShowing())) {
      this.Z.dismiss();
    }
    this.Z = null;
    if (this.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_Apat.uninit();
    }
    if (!TextUtils.isEmpty(this.sessionInfo.aTl)) {
      top.b(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, -4021);
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    cfW();
  }
  
  public void doOnStop()
  {
    if (!this.aSY)
    {
      apnu localapnu = (apnu)this.app.getManager(363);
      if (localapnu != null) {
        localapnu.gl(this.sessionInfo.aTl + "&" + 3000, 0);
      }
    }
    super.doOnStop();
  }
  
  public void ex(View paramView)
  {
    cfY();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Apat != null) && (this.jdField_a_of_type_Apat.aAN()) && (this.jdField_a_of_type_Wki != null)) {
      this.jdField_a_of_type_Apat.Wx(0);
    }
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onShow()
  {
    cfv();
    super.onShow();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (BaseChatpieHelper.a(this.jdField_b_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.sessionInfo.cZ))
    {
      this.sessionInfo.beA = true;
      cfZ();
    }
    boolean bool;
    do
    {
      return;
      DiscussionInfo localDiscussionInfo = ((acdu)this.app.getManager(53)).a(this.sessionInfo.aTl);
      bool = false;
      if (localDiscussionInfo != null) {
        bool = localDiscussionInfo.isDiscussHrMeeting();
      }
    } while ((bool) || (this.sessionInfo.cZ != 3000) || (this.sessionInfo.aTl == null) || (this.sessionInfo.aTl.length() == 0) || (paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '@') && (paramCharSequence.charAt(paramInt1) != 65312)) || (this.aSr) || (((wwn)a(27)).bgi));
    cfZ();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131370537) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void s(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (this.sessionInfo.beA) {
        BaseChatpieHelper.a(this.sessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_b_of_type_ComTencentWidgetPatchedButton, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_At_Me_DISC", 2, "memUin:" + paramString1 + " displayName:" + aqft.pk(paramString2) + " isRemoveOldAtFlag:" + paramBoolean);
    }
    if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 2) && (this.app.getApplication().getResources().getConfiguration().orientation == 2)) {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
    }
    if (this.sessionInfo.beA)
    {
      if ("0".equals(paramString1))
      {
        BaseChatpieHelper.a(this.sessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_b_of_type_ComTencentWidgetPatchedButton, false);
        return;
      }
      this.sessionInfo.aTq = paramString1;
      this.bEk = 131077;
      refresh(this.bEk);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(acfp.m(2131705126));
      this.uiHandler.postDelayed(new DiscussChatPie.6(this), 200L);
      return;
    }
    this.uiHandler.postDelayed(new DiscussChatPie.7(this, paramBoolean, paramString1, paramString2), 300L);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {}
    label173:
    for (;;)
    {
      return;
      if ((paramObject instanceof apab.a))
      {
        paramObservable = (apab.a)paramObject;
        if (paramObservable != null)
        {
          if (paramObservable.type != apab.dSq) {
            break label127;
          }
          a(paramObservable.dSt, paramObservable.hp(), paramObservable.dSu, null);
        }
      }
      for (;;)
      {
        if (!(paramObject instanceof MessageForText)) {
          break label173;
        }
        paramObservable = (MessageForText)paramObject;
        if (!paramObservable.frienduin.equals(this.sessionInfo.aTl)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in DiscussChatPie.update()");
        }
        aquv.a().a(this.app, this.sessionInfo, paramObservable, paramObservable.msg, this.mContext, paramObservable.isSend());
        return;
        label127:
        if ((paramObservable.type == apab.dSr) && (this.rE != null))
        {
          ((RelativeLayout.LayoutParams)this.rE.getLayoutParams()).addRule(2, paramObservable.id);
          continue;
          if (!(paramObject instanceof Integer)) {}
        }
      }
    }
  }
  
  public void zZ(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "disscuss Uin : " + this.sessionInfo.aTl);
    }
    AVNotifyCenter.i locali = this.app.a().a(Long.valueOf(this.sessionInfo.aTl).longValue(), 2);
    if (locali != null)
    {
      if (!locali.isOffLine) {
        break label139;
      }
      anot.a(null, "CliOper", "", "", "0X80066C0", "0X80066C0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.app.a().x(Long.valueOf(this.sessionInfo.aTl).longValue(), 2);
      super.zZ(paramInt);
      return;
      label139:
      anot.a(null, "CliOper", "", "", "0X80066BD", "0X80066BD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyi
 * JD-Core Version:    0.7.0.1
 */