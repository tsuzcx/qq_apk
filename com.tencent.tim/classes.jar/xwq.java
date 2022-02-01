import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class xwq
  extends xys
{
  long Gh = 0L;
  protected TextView Kw;
  protected TextView Kx;
  public final String TAG = "BusinessChatPie";
  public acec a;
  protected achq a;
  asgx a;
  protected CustomMenuBar a;
  private aclp b;
  public PublicAccountInfo b;
  public Handler bV = new xwr(this);
  private boolean bki;
  private boolean bkj;
  private boolean bkk;
  acff c;
  public ashx c;
  private accn cardObserver = new xwx(this);
  private acje d = new xxc(this);
  protected LinearLayout dL;
  protected NewIntent e;
  protected achq h = new xww(this);
  protected LinearLayout hl;
  List<StructMsg.ButtonInfo> sp = null;
  protected ImageView tT;
  protected ImageView tU;
  protected ImageView tV;
  protected ImageView tW;
  private int unReadCount;
  protected View xh;
  public View xi;
  
  public xwq(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_Aclp = new xxd(this);
    this.jdField_a_of_type_Achq = new xxf(this);
    this.jdField_a_of_type_Acec = new xwu(this);
    this.jdField_c_of_type_Ashx = new xwy(this);
  }
  
  private void DA(int paramInt)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)anbi.d(2024);
    Object localObject2 = BaseApplicationImpl.getApplication().getResources();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 26);
    ((Bundle)localObject1).putString("key_action_DATA", "" + paramInt);
    String str = ((Resources)localObject2).getString(2131695673);
    localObject2 = ((Resources)localObject2).getString(2131695674);
    localMessageForGrayTips.init(this.app.getCurrentAccountUin(), this.sessionInfo.aTl, this.app.getCurrentAccountUin(), str, NetConnInfoCenter.getServerTime(), -2064, 0, 0L);
    paramInt = str.indexOf((String)localObject2);
    localMessageForGrayTips.addHightlightItem(paramInt, ((String)localObject2).length() + paramInt, (Bundle)localObject1);
    localObject1 = new ArrayList();
    ((List)localObject1).add(localMessageForGrayTips);
    this.app.b().t((List)localObject1, this.app.getCurrentAccountUin());
  }
  
  private void cfH()
  {
    if (ChatActivityUtils.a(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl, this.sessionInfo.phoneNum)) {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "checkNavigationMenuUpdate msg shielded");
      }
    }
    while (this.bkj) {
      return;
    }
    this.bkj = true;
    long l1 = Long.parseLong(this.sessionInfo.aTl);
    PubAccountNavigationMenu localPubAccountNavigationMenu = ((ashz)this.app.getBusinessHandler(105)).a(this.sessionInfo.aTl);
    ashy localashy = (ashy)this.app.getBusinessHandler(85);
    long l2 = this.app.getLongAccountUin();
    if (localPubAccountNavigationMenu != null) {}
    for (int i = localPubAccountNavigationMenu.version;; i = 0)
    {
      localashy.c(l1, l2, i, this.unReadCount, false);
      return;
    }
  }
  
  private void cfy()
  {
    int i = 0;
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getVisibility() != 0) || (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.mViewHeight <= 0)) {
      i = wja.dp2px(8.0F, this.mActivity.getResources());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom() != i) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), i);
    }
  }
  
  private void e(EqqDetail paramEqqDetail)
  {
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1)) {
      cfB();
    }
  }
  
  private void initUI()
  {
    this.mActivity.getLayoutInflater().inflate(2131558684, this.fs);
    this.xi = this.fs.findViewById(2131372786);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.fs.findViewById(2131366614));
    Object localObject = this.fs.findViewById(2131366613);
    ((View)localObject).setOnClickListener(new xxg(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new xws(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new xwt(this));
    if (this.mActivity.getIntent().getBooleanExtra("crm_ivr_aio_video_action_sheet", false)) {
      jqs.a(this.app, this.mActivity, this.sessionInfo);
    }
    for (;;)
    {
      this.hl = ((LinearLayout)this.mAIORootView.findViewById(2131373772));
      localObject = (LinearLayout.LayoutParams)this.hl.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.hl.setVisibility(0);
      this.hl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getParent();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.topMargin = 1;
      localLayoutParams.gravity = 16;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      ((FrameLayout.LayoutParams)localObject).topMargin = 1;
      ((FrameLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.tT = ((ImageView)this.hl.findViewById(2131366615));
      this.tT.setOnClickListener(this);
      if (CustomMenuBar.isDefaultTheme())
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.mActivity.getResources().getColor(2131167447));
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(wja.dp2px(48.0F, this.mActivity.getResources()));
      }
      this.tW = ((ImageView)this.hl.findViewById(2131373427));
      this.tW.setOnClickListener(this);
      this.tV = ((ImageView)this.hl.findViewById(2131366307));
      this.tV.setOnClickListener(this);
      if (!CustomMenuBar.isDefaultTheme())
      {
        this.tV.setImageResource(2130848765);
        this.tW.setImageResource(2130838115);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        wja.S(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130850984);
        if (CustomMenuBar.isDefaultTheme()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.mActivity.getResources().getColor(2131167447));
        }
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "We needn't show video action sheet, because isShowVideoActionSheet is false");
      }
    }
  }
  
  private void xP()
  {
    if (this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl))
    {
      this.hl.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        wja.S(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130850843);
        aG();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.bWD);
        cfy();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
      }
      localObject = this.mActivity.getResources();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        localLayoutParams.topMargin = 1;
        localLayoutParams.leftMargin = wja.dp2px(8.0F, (Resources)localObject);
        localLayoutParams.gravity = 80;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
      }
    }
    do
    {
      return;
      this.hl.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        wja.S(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130850984);
        if (CustomMenuBar.isDefaultTheme()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.mActivity.getResources().getColor(2131167447));
        }
        cfD();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        cfy();
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
    Object localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 1;
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public boolean ON()
  {
    return true;
  }
  
  protected boolean SX()
  {
    acja localacja;
    long l1;
    if ((this.sessionInfo.cZ == 1024) && (!jou.A(this.mContext, this.sessionInfo.aTl)))
    {
      boolean bool = this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "showOrHideFollow isQidianMasterInCache: " + bool);
      }
      if (bool) {
        return !this.jdField_c_of_type_Acff.isFriend(this.sessionInfo.aTl);
      }
      localacja = (acja)this.app.getManager(56);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.sessionInfo.aTl);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label134:
      break label134;
    }
    if (!localacja.f(Long.valueOf(l1))) {
      return true;
    }
    return false;
  }
  
  public StructMsg.ButtonInfo a(int paramInt)
  {
    Object localObject;
    if ((this.sp == null) || (this.sp.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.sp.size()) {
        break label156;
      }
      StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)this.sp.get(i);
      localObject = localButtonInfo;
      if (localButtonInfo.id.get() == paramInt) {
        break;
      }
      localObject = localButtonInfo.sub_button.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int j = 0;
        while (j < ((List)localObject).size())
        {
          if (((StructMsg.ButtonInfo)((List)localObject).get(j)).id.get() == paramInt) {
            return (StructMsg.ButtonInfo)((List)localObject).get(j);
          }
          j += 1;
        }
      }
      i += 1;
    }
    label156:
    return null;
  }
  
  public void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if ((paramPubAccountNavigationMenu != null) && (paramPubAccountNavigationMenu.xml != null) && (paramPubAccountNavigationMenu.xml.length() > 0) && (this.sessionInfo != null) && (this.sessionInfo.aTl != null) && (this.sessionInfo.aTl.equals(String.valueOf(paramPubAccountNavigationMenu.puin)))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QQMessageFacade localQQMessageFacade = this.app.b();
        paramPubAccountNavigationMenu = anre.a(this.app, this.sessionInfo.cZ, Long.parseLong(this.sessionInfo.aTl), paramPubAccountNavigationMenu.xml.getBytes(), 0);
        if (paramPubAccountNavigationMenu != null)
        {
          long l = amzo.seq;
          paramPubAccountNavigationMenu = anbi.a(this.app, this.sessionInfo.aTl, this.sessionInfo.aTl, this.sessionInfo.aTl, this.sessionInfo.cZ, l, paramPubAccountNavigationMenu);
          if (paramPubAccountNavigationMenu != null)
          {
            paramPubAccountNavigationMenu.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
            localQQMessageFacade.b(paramPubAccountNavigationMenu, this.app.getCurrentAccountUin());
          }
        }
        return;
      }
      catch (Exception paramPubAccountNavigationMenu)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("BusinessChatPie", 2, "Add message error: " + paramPubAccountNavigationMenu.getMessage());
        return;
      }
    }
    QLog.d("BusinessChatPie", 2, "showNavigationMenu not current uin or xml is null");
  }
  
  public boolean af(boolean paramBoolean)
  {
    this.aSJ = false;
    this.jdField_a_of_type_Asgx = ((asgx)this.app.getManager(165));
    this.jdField_c_of_type_Acff = ((acff)this.app.getManager(51));
    super.af(paramBoolean);
    if (!this.mActivity.isFinishing())
    {
      initUI();
      if (!this.jdField_a_of_type_Asgx.sM(oL()))
      {
        cfD();
        afrx.a(this.app).i(this.app, oL(), false);
      }
    }
    this.bki = this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl);
    cfF();
    Object localObject;
    if (!this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl))
    {
      this.mActivity.sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
      localObject = new xwz(this);
      jqs.a(this.app, this.mActivity, this.sessionInfo.aTl, this.sessionInfo.cZ, (BusinessObserver)localObject);
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        cfy();
      }
    }
    for (;;)
    {
      xP();
      cfG();
      return true;
      localObject = new BmqqAccountType(this.sessionInfo.aTl, 6);
      this.jdField_a_of_type_Asgx.a(this.mActivity, (BmqqAccountType)localObject);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (!asgx.ag(this.app, this.sessionInfo.aTl)) {
      e(paramEditable);
    }
  }
  
  public void bGO()
  {
    super.bGO();
    if (this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl)) {
      cfB();
    }
  }
  
  public void bGP()
  {
    if (this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl)) {
      cfz();
    }
  }
  
  public void bGT()
  {
    if (this.jdField_a_of_type_Asgx.sJ(this.sessionInfo.aTl))
    {
      this.ps.setOnClickListener(new xxe(this));
      if (ixa.a().cD(this.app.getCurrentAccountUin()))
      {
        this.ps.setVisibility(0);
        this.ps.setContentDescription(this.mActivity.getResources().getString(2131700698));
        return;
      }
      this.ps.setVisibility(8);
      return;
    }
    this.ps.setVisibility(8);
  }
  
  public void bGY()
  {
    int i = 0;
    if (this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl))
    {
      Intent localIntent = new Intent(this.mContext, ChatSettingActivity.class);
      localIntent.putExtra("uin", this.sessionInfo.aTl);
      localIntent.putExtra("uinname", this.sessionInfo.aTn);
      if (this.jdField_c_of_type_Acff.isFriend(this.sessionInfo.aTl)) {}
      for (;;)
      {
        localIntent.putExtra("uintype", i);
        this.mActivity.startActivityForResult(localIntent, 2000);
        return;
        i = this.sessionInfo.cZ;
      }
    }
    anot.a(this.app, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.sessionInfo.aTl, "", "", "");
    jqs.a(this.mActivity, null, this.sessionInfo.aTl, true, -1, true, 2000);
  }
  
  public void bGZ()
  {
    a(this.pp, 2130851145, 2130851146);
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addObserver(this.jdField_a_of_type_Achq);
    this.app.addObserver(this.jdField_a_of_type_Acec);
    this.app.addObserver(this.h);
    this.app.addObserver(this.d);
    this.app.addObserver(this.jdField_b_of_type_Aclp);
    this.app.addObserver(this.jdField_c_of_type_Ashx);
    this.app.addObserver(this.cardObserver);
  }
  
  public void bHt()
  {
    super.bHt();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rz.getLayoutParams();
    int j = (int)this.mActivity.getResources().getDimension(2131299627);
    int i = j;
    if (this.dL != null)
    {
      i = j;
      if (this.dL.getVisibility() == 0) {
        i = j + (int)this.mActivity.getResources().getDimension(2131297318);
      }
    }
    j = i;
    if (this.aey) {
      j = i - wja.dp2px(3.0F, this.app.getApplication().getResources());
    }
    localLayoutParams.topMargin = j;
    this.rz.setLayoutParams(localLayoutParams);
  }
  
  public void bHy()
  {
    super.bHy();
    if ((this.tU != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.tU);
      this.tU = null;
    }
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.SY();
    }
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
    this.app.removeObserver(this.jdField_a_of_type_Acec);
    this.app.removeObserver(this.h);
    this.app.removeObserver(this.d);
    this.app.removeObserver(this.jdField_b_of_type_Aclp);
    this.app.removeObserver(this.jdField_c_of_type_Ashx);
    this.app.removeObserver(this.cardObserver);
  }
  
  public void bn(Intent paramIntent)
  {
    super.bn(paramIntent);
    cfz();
  }
  
  public void bo(Intent paramIntent)
  {
    super.bo(paramIntent);
    this.aSc = true;
    paramIntent = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
    if ((this.sessionInfo.cZ == 1024) && ((paramIntent == null) || (paramIntent.equals(this.sessionInfo.aTl)))) {
      this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler.DG(this.sessionInfo.aTl);
    }
  }
  
  public void br(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.br(paramIntent);
    if (!this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl))
    {
      cfE();
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        cfy();
      }
    }
  }
  
  public void bs(Intent paramIntent)
  {
    aqmq.track(null, "AIO_updateSession_business");
    paramIntent = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "From chatActivity : buinessCrm Sigt--->" + aqhs.bytes2HexStr(paramIntent));
    }
    if (paramIntent != null)
    {
      this.app.a().o(this.sessionInfo.aTl, paramIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("BusinessChatPie", 4, "updateSession()--AIO 已保存 sigt");
      }
    }
    aqmq.track("AIO_updateSession_business", null);
  }
  
  protected void cfA()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showFollowAndShield() ==== called.");
    }
    Object localObject = this.sessionInfo.aTl;
    if (this.dL == null)
    {
      xxa localxxa = new xxa(this);
      this.dL = new LinearLayout(this.mContext);
      this.dL.setId(2131362563);
      this.dL.setVisibility(8);
      this.dL.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.app.getApplication().getResources().getDimension(2131297318));
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131299627);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      this.xh = this.mActivity.getLayoutInflater().inflate(2131560186, null);
      this.xh.setBackgroundDrawable(this.app.getApplication().getResources().getDrawable(2130838373));
      this.xh.findViewById(2131371298).setVisibility(8);
      this.Kw = ((TextView)this.xh.findViewById(2131371301));
      this.Kw.setTextColor(this.app.getApplication().getResources().getColorStateList(2131167375));
      ((ImageView)this.xh.findViewById(2131371289)).setImageResource(2130842574);
      this.xh.setOnClickListener(localxxa);
      this.dL.addView(this.xh, localLayoutParams1);
      View localView = this.mActivity.getLayoutInflater().inflate(2131560186, null);
      localView.setBackgroundDrawable(this.app.getApplication().getResources().getDrawable(2130838373));
      this.Kx = ((TextView)localView.findViewById(2131371301));
      this.Kx.setTextColor(this.app.getApplication().getResources().getColorStateList(2131167375));
      this.Kx.setText(this.mContext.getString(2131692911));
      ((ImageView)localView.findViewById(2131371289)).setImageResource(2130842476);
      localView.setTag(Integer.valueOf(3));
      localView.setOnClickListener(localxxa);
      this.dL.addView(localView, localLayoutParams1);
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131362563);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131299627);
      this.cL.addView(this.dL, localLayoutParams);
    }
    if (ChatActivityUtils.a(this.app, this.sessionInfo.cZ, (String)localObject, this.sessionInfo.phoneNum))
    {
      this.Kw.setText(this.mContext.getString(2131690242));
      this.xh.setTag(Integer.valueOf(1));
    }
    for (;;)
    {
      if ((this.Kx != null) && (this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl))) {
        this.Kx.setText(this.mContext.getString(2131690100));
      }
      this.dL.setVisibility(0);
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.rM);
        if (this.rz != null)
        {
          localObject = (RelativeLayout.LayoutParams)this.rz.getLayoutParams();
          int j = (int)this.mActivity.getResources().getDimension(2131297318) + (int)this.mActivity.getResources().getDimension(2131299627);
          int i = j;
          if (this.aey) {
            i = j - wja.dp2px(3.0F, this.app.getApplication().getResources());
          }
          ((RelativeLayout.LayoutParams)localObject).topMargin = i;
          this.rz.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        return;
        this.Kw.setText(this.mContext.getString(2131692914));
        this.xh.setTag(Integer.valueOf(2));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "removeHeaderView err");
          }
        }
      }
    }
  }
  
  protected void cfB()
  {
    if (this.dL != null) {
      this.dL.setVisibility(8);
    }
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() == 0) {
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.rM);
      }
      if (this.rz != null)
      {
        int i = (int)this.mActivity.getResources().getDimension(2131299627);
        if (this.aey)
        {
          i -= wja.dp2px(3.0F, this.app.getApplication().getResources());
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rz.getLayoutParams();
          localLayoutParams.topMargin = i;
          this.rz.setLayoutParams(localLayoutParams);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "addHeaderView err");
        }
      }
    }
  }
  
  @TargetApi(11)
  protected void cfC()
  {
    if (this.tV == null) {}
    do
    {
      return;
      if (this.bEl != 1) {
        break;
      }
      this.tV.setImageResource(2130845736);
      this.tV.setVisibility(0);
      this.tV.setEnabled(true);
    } while (!VersionUtils.isHoneycomb());
    this.tV.setAlpha(1.0F);
    return;
    if (this.bEl == 2)
    {
      this.tV.setEnabled(false);
      if (VersionUtils.isHoneycomb()) {
        this.tV.setAlpha(0.6F);
      }
      if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 3)
      {
        if (CustomMenuBar.isDefaultTheme()) {
          this.tV.setImageResource(2130850881);
        }
        for (;;)
        {
          this.tV.setContentDescription(this.mContext.getString(2131700596));
          return;
          this.tV.setImageResource(2130851314);
        }
      }
      if (CustomMenuBar.isDefaultTheme()) {
        this.tV.setImageResource(2130850880);
      }
      for (;;)
      {
        this.tV.setContentDescription(this.mContext.getString(2131700595));
        return;
        this.tV.setImageResource(2130851315);
      }
    }
    this.tV.setEnabled(true);
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 3)
    {
      if (CustomMenuBar.isDefaultTheme()) {
        this.tV.setImageResource(2130850881);
      }
      for (;;)
      {
        this.tV.setContentDescription(this.mContext.getString(2131700596));
        label246:
        if (!VersionUtils.isHoneycomb()) {
          break;
        }
        this.tV.setAlpha(1.0F);
        return;
        this.tV.setImageResource(2130851314);
      }
    }
    if (CustomMenuBar.isDefaultTheme()) {
      this.tV.setImageResource(2130850880);
    }
    for (;;)
    {
      this.tV.setContentDescription(this.mContext.getString(2131700595));
      break label246;
      break;
      this.tV.setImageResource(2130851315);
    }
  }
  
  public void cfD()
  {
    if (this.sp == null) {
      this.sp = new ArrayList();
    }
    this.sp.clear();
    List localList = afrx.a(this.app).d(this.app, oL());
    if ((localList != null) && (localList.size() > 0)) {
      this.sp.addAll(localList);
    }
    if ((this.sp != null) && (!this.sp.isEmpty())) {
      zE(true);
    }
    for (;;)
    {
      gr(this.sp);
      return;
      zE(false);
    }
  }
  
  public void cfE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    Object localObject;
    if (!this.mActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (acja)this.app.getManager(56);
      if (localObject != null) {
        this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo = ((acja)localObject).c(this.sessionInfo.aTl);
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
      localObject = new NewIntent(this.mActivity.getApplicationContext(), jnl.class);
      ((NewIntent)localObject).putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(1);
      localGetEqqDetailInfoRequest.seqno.set(0);
      try
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.sessionInfo.aTl));
        label158:
        ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new xwv(this));
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail");
        }
        this.app.startServlet((NewIntent)localObject);
      }
      catch (Exception localException)
      {
        break label158;
      }
    }
  }
  
  public void cfF()
  {
    try
    {
      String str = this.sessionInfo.aTl;
      Object localObject = this.app.b().k(str, 0);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.msgtype == -1013) || (localMessageRecord.msgtype == -1019) || (localMessageRecord.msgtype == -1018) || (localMessageRecord.msgtype == -2019) || (localMessageRecord.msgtype == -7006)) {
            this.app.b().t(str, 0, localMessageRecord.uniseq);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void cfG()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessChatPie", 2, "checkNavigationMenuUpdate");
    }
    this.unReadCount = vk();
    if (TextUtils.isEmpty(this.sessionInfo.aTl)) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (Math.abs(l - this.Gh) < 1000L);
      this.Gh = l;
      this.bkj = false;
    } while (!this.jdField_a_of_type_Asgx.R(this.sessionInfo.aTl, false));
    cfH();
  }
  
  protected void cfz()
  {
    if (!this.jdField_a_of_type_Asgx.sN(this.sessionInfo.aTl))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView don't request qidian master, so wait request show");
      }
      return;
    }
    if (SX())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView true");
      }
      cfA();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateFollowAndShieldView false");
    }
    cfB();
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.tU != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.tU);
      this.tU = null;
    }
    if ((this.jdField_a_of_type_Asgx != null) && (this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl))) {
      ((ashy)this.app.getBusinessHandler(85)).ab(this.sessionInfo.aTl, null, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), 0);
    }
  }
  
  void e(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1))
    {
      setGravity(80);
      return;
    }
    setGravity(16);
  }
  
  public void eS(int paramInt1, int paramInt2)
  {
    super.eS(paramInt1, paramInt2);
    xro.a(this.app, "0X8008AAA", "C_Master_PTT", this.sessionInfo, eK(paramInt1), paramInt2);
  }
  
  void followPublicAccount()
  {
    ChatActivityUtils.bs(this.mActivity);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow");
    }
    ((FriendListHandler)this.app.getBusinessHandler(1)).DG(this.sessionInfo.aTl);
    if (this.e != null) {
      this.e.setObserver(null);
    }
    this.e = new NewIntent(this.mActivity.getApplicationContext(), kbs.class);
    this.e.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).account_type.set(2);
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.sessionInfo.aTl));
    this.e.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new xxb(this);
    this.e.setObserver((BusinessObserver)localObject);
    this.app.startServlet(this.e);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow exit");
    }
  }
  
  public void gr(List<StructMsg.ButtonInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.SY();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      this.tT.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.tT.setVisibility(0);
      int j = paramList.size();
      int i = 0;
      while ((i < j) && (i <= 2))
      {
        Object localObject = (StructMsg.ButtonInfo)paramList.get(i);
        soo localsoo = new soo(((StructMsg.ButtonInfo)localObject).key.get(), ((StructMsg.ButtonInfo)localObject).name.get(), null, ((StructMsg.ButtonInfo)localObject).id.get());
        if (((StructMsg.ButtonInfo)localObject).sub_button.get().size() > 0)
        {
          localObject = ((StructMsg.ButtonInfo)localObject).sub_button.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)((Iterator)localObject).next();
            localsoo.b(new soo(localButtonInfo.key.get(), localButtonInfo.name.get(), null, localButtonInfo.id.get()));
          }
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localsoo, oL());
        i += 1;
      }
    }
  }
  
  public void o(int paramInt1, int paramInt2)
  {
    super.o(paramInt1, paramInt2);
    cfC();
    if (paramInt2 == 8) {
      if (this.tW != null)
      {
        if (!CustomMenuBar.isDefaultTheme()) {
          break label40;
        }
        this.tW.setImageResource(2130850930);
      }
    }
    label40:
    while (this.tW == null)
    {
      return;
      this.tW.setImageResource(2130850852);
      return;
    }
    if (CustomMenuBar.isDefaultTheme())
    {
      this.tW.setImageResource(2130850929);
      return;
    }
    this.tW.setImageResource(2130850851);
  }
  
  public void oh(int paramInt)
  {
    Toast.makeText(this.mActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.SX();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366615) {
      zE(true);
    }
    if ((paramView.getId() == 2131366307) && (this.bEl != 1))
    {
      if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 3)
      {
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
        anot.a(this.app, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      }
    }
    else if (paramView.getId() == 2131373427)
    {
      ShortVideoUtils.B(this.app);
      if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 8) {
        break label238;
      }
      if (this.tW != null) {
        this.tW.setContentDescription(this.app.getApplication().getString(2131690205));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "BaseCHatPie onClick keybordicon removeFastImage");
        }
        vT(true);
      }
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(3);
      anot.a(this.app, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      label238:
      bHS();
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(8);
      if (this.tW != null) {
        this.tW.setContentDescription(this.app.getApplication().getString(2131690109));
      }
      Aa(0);
    }
  }
  
  void setGravity(int paramInt)
  {
    if (this.hl == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      localObject1 = (LinearLayout.LayoutParams)this.hl.getLayoutParams();
      localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (((LinearLayout.LayoutParams)localObject1).gravity != paramInt)
      {
        ((LinearLayout.LayoutParams)localObject1).gravity = paramInt;
        this.hl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (((FrameLayout.LayoutParams)localObject2).gravity != paramInt)
      {
        ((FrameLayout.LayoutParams)localObject2).gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject1 = (RelativeLayout)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getParent();
      localObject2 = (LinearLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    } while (((LinearLayout.LayoutParams)localObject2).gravity == paramInt);
    ((LinearLayout.LayoutParams)localObject2).gravity = paramInt;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
  }
  
  public void yi(String paramString)
  {
    PubAccountNavigationMenu localPubAccountNavigationMenu;
    if ((this.app != null) && (this.sessionInfo != null))
    {
      localPubAccountNavigationMenu = ((ashz)this.app.getBusinessHandler(105)).a(this.sessionInfo.aTl);
      if (!"1".equals(paramString)) {
        break label108;
      }
      l1 = Long.parseLong(this.sessionInfo.aTl);
      paramString = (ashy)this.app.getBusinessHandler(85);
      l2 = this.app.getLongAccountUin();
      if (localPubAccountNavigationMenu == null) {
        break label103;
      }
      i = localPubAccountNavigationMenu.version;
      paramString.c(l1, l2, i, 0, true);
    }
    label103:
    label108:
    while (localPubAccountNavigationMenu == null) {
      for (;;)
      {
        long l1;
        long l2;
        return;
        int i = 0;
      }
    }
    a(localPubAccountNavigationMenu);
  }
  
  public void zE(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Asgx.sM(this.sessionInfo.aTl))
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.tT.setVisibility(0);
  }
  
  public void zZ(int paramInt)
  {
    super.zZ(paramInt);
    cfy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwq
 * JD-Core Version:    0.7.0.1
 */