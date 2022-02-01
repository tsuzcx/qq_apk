import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.11;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.13;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.14;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.15;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.21;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.8;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SegmentedControlView;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;
import java.util.Observable;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class yam
  extends xwn
  implements RadioGroup.OnCheckedChangeListener
{
  static long JG;
  protected static final String[] cL = { "@all", acfp.m(2131707237) };
  public TextView KH;
  public abep a;
  acgf jdField_a_of_type_Acgf = new acgg(this);
  acgi jdField_a_of_type_Acgi;
  protected ajtx a;
  protected apwk a;
  public HotChatManager a;
  protected TroopGiftPanelForNearby a;
  SegmentedControlView jdField_a_of_type_ComTencentWidgetSegmentedControlView;
  ssj jdField_a_of_type_Ssj = null;
  private xwn.a jdField_a_of_type_Xwn$a;
  public String aWZ;
  public boolean aWh;
  Dialog af;
  public Dialog ah;
  public acgk b;
  acnd b;
  public HotChatInfo b;
  public RedDotRadioButton b;
  public int bYg;
  public int bYh = 0;
  protected int bYi = -1;
  public boolean bkW;
  boolean bkX = false;
  boolean bkY;
  RedDotRadioButton c;
  private PullRefreshHeader g;
  boolean isStopped = false;
  public int userCreate;
  View xq = null;
  View xr;
  public XListView z;
  long zn = 0L;
  
  public yam(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_Acnd = new yan(this);
  }
  
  private void aR(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramInt == 1)
    {
      if (this.xr != null) {
        this.fs.removeView(this.xr);
      }
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      }
      this.bYi = 1;
      if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.ds()))
      {
        refresh(131072);
        this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.showRedDot(false);
      }
      if ((this.jdField_a_of_type_Apat != null) && (this.jdField_a_of_type_Apat.Le() > 0)) {
        this.jdField_a_of_type_Apat.Wy(0);
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (paramBoolean))
      {
        QQAppInterface localQQAppInterface = this.app;
        if (!this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) {
          break label201;
        }
        str = "2";
        anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, str, "", "", "");
      }
    }
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", "", "hot_room", "exp_visit_post", 0, 0, "", "", "", "");
      return;
      label201:
      str = "1";
      break;
      if (paramInt == 2)
      {
        if ((this.c != null) && (this.c.ds()))
        {
          this.c.showRedDot(false);
          if (this.jdField_a_of_type_Abep != null) {
            fM(0, this.jdField_a_of_type_Abep.getCount());
          }
        }
        this.jdField_a_of_type_Apat.Wy(4);
        cgu();
        hidePanel();
        if (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) {
          this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.clearRedPoint();
        }
        this.bYi = 2;
        if (this.jdField_a_of_type_Wki != null) {
          this.bYh = this.jdField_a_of_type_Wki.getCount();
        }
      }
    }
  }
  
  private void cgu()
  {
    if (this.xr == null) {
      this.xr = LayoutInflater.from(this.mContext).inflate(2131559430, null);
    }
    if (this.z == null)
    {
      this.z = ((XListView)this.xr.findViewById(2131380183));
      this.KH = ((TextView)this.xr.findViewById(2131366438));
      this.g = ((PullRefreshHeader)LayoutInflater.from(this.mContext).inflate(2131559847, this.z, false));
      this.g.setHeaderBgColor(-16777216);
      this.g.setTextColor(-1, -1, -1, -1, -1);
      this.g.setArrowColor(-1);
      this.z.setOverScrollHeader(this.g);
      this.z.setOverScrollHeight(10);
      this.z.setOverscrollHeader(this.mContext.getResources().getDrawable(2130839645));
      this.z.setDividerHeight(30);
      this.z.setOnScrollListener(new yaw(this));
      this.z.setOverScrollListener(new yax(this));
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
    }
    if (this.fs.indexOfChild(this.xr) == -1)
    {
      localLayoutParams.addRule(6, 2131370537);
      this.fs.addView(this.xr, localLayoutParams);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(8);
    }
    int i;
    if (aqmj.aD(this.mContext, this.app.getCurrentUin()) == 1)
    {
      i = 1;
      if (i == 0) {
        break label399;
      }
      if (this.jdField_a_of_type_Ssj == null)
      {
        this.jdField_a_of_type_Ssj = new ssj(this.mActivity, "QQ_Hotchat_post_list.apk", "2586", "/hotchatPostListPlugin/opt");
        this.jdField_a_of_type_Ssj.a(new yay(this), false);
      }
    }
    for (;;)
    {
      if ((this.z.getVisibility() == 8) || ((this.jdField_a_of_type_Abep != null) && (this.jdField_a_of_type_Abep.getCount() == 0))) {
        fM(0, 10);
      }
      return;
      i = 0;
      break;
      label399:
      if (this.jdField_a_of_type_Abep == null)
      {
        this.jdField_a_of_type_Abep = new abep(this.mContext, null, null);
        this.z.setAdapter(this.jdField_a_of_type_Abep);
      }
    }
  }
  
  private void fM(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotChatPie.21(this, paramInt2, paramInt1), 8, null, true);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + "Q.hotchat.aio_post_list_req", 2, "getPostListFromServer start: " + paramInt1 + "|num:" + paramInt2);
    }
  }
  
  private void zN(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.cJ.setVisibility(8);
      this.cK.setVisibility(8);
      if (this.xq == null) {
        this.xq = LayoutInflater.from(this.mContext).inflate(2131560134, null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(14);
        localLayoutParams.topMargin = 32;
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.xq, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.bIL();
        this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = ((SegmentedControlView)this.xq.findViewById(2131368655));
      }
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.xq.findViewById(2131368653));
      if (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(true);
        this.bYi = 1;
      }
      this.c = ((RedDotRadioButton)this.xq.findViewById(2131368654));
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setOnCheckedChangeListener(this);
      return;
    }
    if ((this.xq != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.xq) != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.xq);
    }
    this.cJ.setVisibility(0);
    this.cK.setVisibility(0);
  }
  
  private void zO(boolean paramBoolean)
  {
    this.uiHandler.post(new HotChatPie.3(this, paramBoolean));
  }
  
  public void Ib()
  {
    this.TAG = "HotChatPie";
  }
  
  public boolean Pd()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.aar();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.aar())
    {
      cgw();
      anot.a(this.app, "CliOper", "", "", "0X8005DD2", "0X8005DD2", 0, 0, "", "", "", "");
    }
    return bool;
  }
  
  public boolean SV()
  {
    return true;
  }
  
  public TroopGiftPanelForNearby a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby;
  }
  
  public void a(QQMessageFacade.Message paramMessage) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.isStopped) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG + paramString4, 2, "onKickHotChatMember.isSuccess=" + paramBoolean + ",groupuin=" + paramString1 + ",result=" + paramInt + ",memberuin=" + paramString2 + ",strError=" + paramString3);
    }
    if ((this.ah != null) && (this.ah.isShowing())) {
      this.ah.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      QQToast.a(a(), acfp.m(2131707226), 0).show(a().getTitleBarHeight());
      return;
    }
    QQToast.a(a(), acfp.m(2131707228), 0).show(a().getTitleBarHeight());
  }
  
  public boolean af(boolean paramBoolean)
  {
    this.aSJ = false;
    this.aSk = false;
    this.jdField_a_of_type_Xwn$a = new xwn.a(this);
    this.jdField_a_of_type_Acgi = new acgi(this.mActivity, this.app, null);
    this.jdField_a_of_type_Apwk = new apwk(this.app, this.sessionInfo.aTl, "Grp_time", "Grp_AIO", "visit_time");
    return super.af(paramBoolean);
  }
  
  public void aj(boolean paramBoolean, int paramInt)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)a().getSystemService("input_method");
    View localView = a().getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_Ajtx == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby(this.app, a(), new yav(this), false, false, false, this);
      this.jdField_a_of_type_Ajtx = new ajtx(this.app, a(), this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.mAIORootView, true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.setIsPttRoom(false);
    this.jdField_a_of_type_Ajtx.m(paramBoolean, false, 4);
    hidePanel();
  }
  
  public void bGR()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      return;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum > 0)) {}
    for (int i = 1;; i = 0)
    {
      vU(true);
      if (i == 0) {
        break;
      }
      this.Cu.setVisibility(0);
      this.Cu.setText(String.format(this.mActivity.getString(2131694674), new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum) }));
      this.Cu.setTextSize(1, 12.0F);
      return;
    }
    this.Cu.setVisibility(8);
  }
  
  public void bGT()
  {
    this.ps.setVisibility(4);
  }
  
  public void bGY()
  {
    Object localObject = this.sessionInfo.aTl;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.ki((String)localObject)) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.uuid)))
    {
      localObject = new Intent(this.mActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter("https://nearby.qq.com/hot_chat/room_info.html", "_wv", "3"), "_bid", "2581"), "gc", this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.troopUin), "rid", this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.uuid), "rname", this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.name), "rtype", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.hotChatType)), "rnum", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.memberCount)));
      a().startActivity((Intent)localObject);
      anot.a(this.app, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isGameRoom) {
        anot.a(this.app, "dc00899", "Grp_wolf", "", "in_game", "clk_grp_card", 0, 0, "", "", "", "");
      }
      return;
    }
    QQToast.a(this.app.getApp(), acfp.m(2131707245), 0).show(this.mActivity.getTitleBarHeight());
  }
  
  public void bHA()
  {
    super.bHA();
  }
  
  public void bHE()
  {
    super.bHE();
    if (this.bYi == 2) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    }
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addObserver(this.jdField_a_of_type_Acgf);
    this.app.addDefaultObservers(this.jdField_a_of_type_Xwn$a);
    if (this.app.a() != null) {
      this.app.a().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void bHa()
  {
    String str = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
    if (!TextUtils.equals(str, this.sessionInfo.aTl)) {
      this.sessionInfo.aTn = str;
    }
  }
  
  public void bHy()
  {
    super.bHy();
    Intent localIntent = this.mActivity.getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      return;
      String str = localIntent.getStringExtra("uin");
      int i = localIntent.getIntExtra("uintype", -1);
      if ((this.sessionInfo.aTl != null) && ((!this.sessionInfo.aTl.equals(str)) || (this.sessionInfo.cZ != i))) {}
      for (i = 1; (i != 0) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()); i = 0)
      {
        this.xr = null;
        this.z = null;
        return;
      }
    }
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Xwn$a);
    if (this.app.a() != null) {
      this.app.a().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.removeObserver(this.jdField_a_of_type_Acgf);
  }
  
  public void bo(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      jpa.a("2586", this.app, new yaz(this), true, 0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.xq);
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
    }
    this.cJ.setVisibility(0);
    this.cK.setVisibility(0);
    super.bo(paramIntent);
  }
  
  public void bs(Intent paramIntent)
  {
    super.bs(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = this.app.a(true);
    this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.sessionInfo.aTl);
    if (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo == null)
    {
      if (QLog.isColorLevel()) {
        ajrk.m("PttShow", new Object[] { "HotChatPie_updateSession_business HotChatInfo is null", this.sessionInfo.aTl });
      }
      fV(0);
    }
    do
    {
      do
      {
        do
        {
          return;
          this.userCreate = this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.userCreate;
          if ((paramIntent != null) && (paramIntent.getIntExtra("hot_chat_from", 1) == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.aaq())) {
            acfx.a(this.app, this.mActivity);
          }
        } while (!this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isRobotHotChat);
        this.aWO = ("" + this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.robotUin);
        this.aWP = aqgv.A(this.app, this.aWO);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(this.sessionInfo.aTl, this.aWO, this.aWP, this, new yau(this));
        paramIntent = (aptw)this.app.getManager(203);
        paramIntent.be(this.sessionInfo.aTl, this.aWO, this.aWP);
        paramIntent = paramIntent.i(this.sessionInfo.aTl, this.aWO);
      } while (paramIntent == null);
      try
      {
        new cmd0x934.RspBody().mergeFrom(paramIntent);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntent) {}
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, paramIntent.getMessage());
  }
  
  public void bt(Intent paramIntent)
  {
    this.bkW = paramIntent.getBooleanExtra("abp_flag", false);
    this.aWh = paramIntent.getBooleanExtra("is_from_web", false);
    if ((this.aWh) && (!this.bkW))
    {
      this.Cr.setText(2131690700);
      this.Cr.setContentDescription(acfp.m(2131707235));
      return;
    }
    if (this.bkW)
    {
      this.Cr.setText(acfp.m(2131707247));
      this.Cr.setContentDescription(acfp.m(2131707233));
      return;
    }
    super.bt(paramIntent);
  }
  
  public void bzx()
  {
    if (this.jdField_a_of_type_Ajtx != null) {
      this.jdField_a_of_type_Ajtx.hide();
    }
  }
  
  void cfu()
  {
    super.cfu();
    this.pp.setContentDescription(this.mActivity.getString(2131694656));
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.state != 0)) {
      ThreadManager.post(new HotChatPie.8(this), 5, null, false);
    }
  }
  
  public void cgv()
  {
    this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.sessionInfo.aTl);
    HotChatInfo localHotChatInfo = this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo;
    if (localHotChatInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.cJm();
      if (!this.mActivity.getIntent().getBooleanExtra("param_newly_created_hot_chat", false)) {
        ThreadManager.post(new HotChatPie.16(this, localHotChatInfo), 8, null, true);
      }
    }
  }
  
  public void cgw()
  {
    aqju localaqju = aqha.a(this.mContext, 230);
    localaqju.setMessage(String.format("需要等级LV%d才能使用闪照功能哦", new Object[] { Integer.valueOf(HotChatManager.A(this.app)) }));
    localaqju.setNegativeButton(acfp.m(2131707236), new yas(this, localaqju));
    localaqju.setPositiveButton(acfp.m(2131707229), new yat(this));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.show();
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    super.d(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      Intent localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      this.mActivity.startActivity(localIntent);
      continue;
      if ((paramInt2 == 8001) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null)) {
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_b_of_type_Acgk != null)
    {
      this.jdField_b_of_type_Acgk.destroy();
      this.jdField_b_of_type_Acgk = null;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      this.app.removeObserver(this.jdField_b_of_type_Acnd);
      aR(1, false);
      if ((this.xq != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.xq) != -1)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.xq);
      }
      this.xq = null;
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
      this.xr = null;
      this.z = null;
      this.jdField_a_of_type_Abep = null;
      this.jdField_a_of_type_Ssj = null;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.zn;
    anot.a(this.app, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l1 - l2), String.valueOf(this.userCreate), "", "");
    if (((this.mActivity.getIntent() == null) || (this.mActivity.getIntent().getBooleanExtra("open_chatfragment_fromphoto", false))) || (this.ah != null))
    {
      this.ah.dismiss();
      this.ah = null;
    }
    if (this.af != null)
    {
      this.af.dismiss();
      this.af = null;
    }
    if (this.jdField_a_of_type_Acgi != null) {
      this.jdField_a_of_type_Acgi.onDestroy();
    }
    if (this.jdField_a_of_type_Abep != null) {
      this.jdField_a_of_type_Abep.destroy();
    }
    ((aptw)this.app.getManager(203)).ebO();
    if (this.jdField_a_of_type_Apwk != null) {
      this.jdField_a_of_type_Apwk.stop();
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_b_of_type_Acgk != null) {
      this.jdField_b_of_type_Acgk.stopCheck();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.isStopped = false;
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) && (this.bYi == 2) && (this.jdField_a_of_type_Apat != null)) {
      this.jdField_a_of_type_Apat.Wy(4);
    }
    this.jdField_a_of_type_Apwk.start();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.isStopped = true;
  }
  
  public void ex(View paramView) {}
  
  public void h(ChatMessage paramChatMessage, String paramString)
  {
    ausj localausj = ausj.b(a());
    String str3 = acfp.m(2131707246);
    String str4 = paramChatMessage.getExtInfoFromExtStr("hotchat_gender");
    String str1 = str3;
    try
    {
      if (Integer.parseInt(str4) == 1) {
        str1 = acfp.m(2131707243);
      }
      localausj.addButton(str1);
      localausj.addButton(acfp.m(2131707240), 3);
      localausj.addCancelButton(2131721058);
      localausj.a(new yap(this, localausj, paramChatMessage, paramString));
      localausj.show();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str2 = str3;
        if (QLog.isColorLevel())
        {
          QLog.e(this.TAG, 2, "showHeadLongClickActionSheet, NumberFormatException, genderStr:" + str4);
          str2 = str3;
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = super.handleMessage(paramMessage);
    }
    return bool;
  }
  
  public void k(Object paramObject)
  {
    super.k(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    }
    wh(true);
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
    for (paramObject = "507";; paramObject = "503")
    {
      acie.i("gift_aio", "clk_icon", oN(), paramObject, "", "");
      return;
    }
  }
  
  public boolean k(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.equals(paramString1, this.sessionInfo.aTl)) {}
    while (this.isStopped) {
      return false;
    }
    this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1);
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (!this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed))
    {
      this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed = true;
      ThreadManager.post(new HotChatPie.15(this), 8, null, true);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_Apmp == null) {
          this.jdField_a_of_type_Apmp = new apmp(this.app, this.mActivity, this.sessionInfo, this.fs, this.ps, this.jdField_a_of_type_Apat, this.aaR, null);
        }
        paramString1 = paramString3;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = paramString3;
          if (!paramString3.startsWith("mqqapi"))
          {
            paramString1 = paramString3;
            if (!paramString3.startsWith("http://"))
            {
              paramString1 = paramString3;
              if (!paramString3.startsWith("https://")) {
                paramString1 = "https://" + paramString3;
              }
            }
          }
        }
        this.jdField_a_of_type_Apmp.f(this.app, this.mContext, paramString2, paramString1);
        if (this.jdField_b_of_type_Acgk != null) {
          this.jdField_b_of_type_Acgk.bHQ = false;
        }
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void o(int paramInt1, int paramInt2)
  {
    super.o(paramInt1, paramInt2);
    this.bYg = paramInt2;
  }
  
  public boolean onBackEvent()
  {
    boolean bool1;
    if ((this.jdField_a_of_type_Ajtx != null) && (this.jdField_a_of_type_Ajtx.isShow()))
    {
      this.jdField_a_of_type_Ajtx.hide();
      bool1 = true;
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return bool1;
          bool2 = super.onBackEvent();
          bool1 = bool2;
        } while (this.aL);
        bool1 = bool2;
      } while (!this.bkW);
      bool1 = bool2;
    } while (bool2);
    HotChatManager.w(this.mContext, this.bkW);
    return bool2;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i;
    QQAppInterface localQQAppInterface;
    if (paramInt == 2131368653)
    {
      i = 1;
      aR(i, true);
      localQQAppInterface = this.app;
      if (paramInt != 2131368653) {
        break label72;
      }
    }
    label72:
    for (String str = "clk_hot_room";; str = "clk_see_post")
    {
      anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", str, 0, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      i = 2;
      break;
    }
  }
  
  public void onShow()
  {
    cgv();
    cfv();
    super.onShow();
    this.zn = SystemClock.elapsedRealtime();
    NearbyTransitActivity.ev("AIOShow", 2);
    Object localObject4 = this.mActivity.getIntent();
    Object localObject1 = ((Intent)localObject4).getStringExtra("uin");
    Object localObject2 = ((Intent)localObject4).getStringExtra("uinname");
    Object localObject3 = ((Intent)localObject4).getStringExtra("hotnamecode");
    boolean bool = ((Intent)localObject4).getBooleanExtra("param_newly_created_hot_chat", false);
    if ((!this.bkY) && (bool) && (((Intent)localObject4).getBooleanExtra("param_newly_created_hot_chat", false)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
    {
      localObject4 = acfx.ad((String)localObject3, 1);
      localObject2 = ShareHotChatGrayTips.makeShareGrayTip(ShareHotChatGrayTips.SHARE_GRAY_TIP_CONTENT, acfp.m(2131707241), (String)localObject1, (String)localObject2, (String)localObject4, (String)localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.bkY = true;
        localObject3 = anbi.d(-2033);
        long l = anaz.gQ();
        localObject4 = this.app.getCurrentAccountUin();
        ((MessageRecord)localObject3).init((String)localObject4, this.sessionInfo.aTl, (String)localObject4, (String)localObject2, l, -2033, this.sessionInfo.cZ, l);
        ((MessageRecord)localObject3).isread = true;
        if (!achp.a(this.app, (MessageRecord)localObject3, false)) {
          this.app.b().b((MessageRecord)localObject3, (String)localObject4);
        }
      }
      this.af = acfx.a(this.mActivity, new yba(this, (String)localObject1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.aao()) {
      ThreadManager.post(new HotChatPie.10(this), 8, null, true);
    }
    this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.sessionInfo.aTl);
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      this.app.addObserver(this.jdField_b_of_type_Acnd);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.pkFlag != 0))
    {
      if (this.jdField_b_of_type_Acgk == null)
      {
        ThreadManager.post(new HotChatPie.11(this), 5, null, true);
        localObject1 = new yao(this);
        this.jdField_b_of_type_Acgk = new acgk(this.app, (acgk.a)localObject1, this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
      }
      this.jdField_b_of_type_Acgk.hx(10000L);
    }
    int i;
    if ((this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      if (this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo.need2ReqRedPoint()) {
        ThreadManager.post(new HotChatPie.13(this), 8, null, true);
      }
      i = 1;
      localObject2 = this.app;
      if (i == 0) {
        break label518;
      }
    }
    label518:
    for (localObject1 = "2";; localObject1 = "1")
    {
      anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject1, "", "", "");
      return;
      aR(1, false);
      i = 0;
      break;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!this.aSr))
    {
      paramCharSequence = (HotChatManager)this.app.getManager(60);
      if (paramCharSequence != null) {}
      for (paramCharSequence = paramCharSequence.a(this.sessionInfo.aTl);; paramCharSequence = null)
      {
        if (paramCharSequence != null)
        {
          Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter("https://nearby.qq.com/hot_chat/member_list.html", "_wv", "3"), "_bid", "2581"), "gc", paramCharSequence.troopUin), "rid", paramCharSequence.uuid), "from", String.valueOf(1)));
          paramCharSequence = new Bundle();
          paramCharSequence.putBoolean("hide_left_button", true);
          localIntent.putExtras(paramCharSequence);
          a().startActivity(localIntent);
        }
        return;
      }
    }
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((this.mActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
      wi(false);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (!this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.ds()) && (paramObject != null) && ((paramObject instanceof MessageRecord)) && (this.bYi == 2)) {
      this.uiHandler.post(new HotChatPie.14(this));
    }
  }
  
  public void vW(boolean paramBoolean)
  {
    if (this.bkW)
    {
      if (this.jdField_a_of_type_Apat != null) {
        this.jdField_a_of_type_Apat.uninit();
      }
      HotChatManager.w(this.mContext, this.bkW);
      return;
    }
    super.vW(paramBoolean);
  }
  
  public int wD()
  {
    return this.bYi;
  }
  
  public void wh(boolean paramBoolean)
  {
    aj(paramBoolean, TroopGiftPanel.byn);
  }
  
  public void zZ(int paramInt)
  {
    super.zZ(paramInt);
  }
  
  public static class a
    implements arxh.a
  {
    WeakReference<Context> es;
    WeakReference<abep> et;
    WeakReference<XListView> eu;
    WeakReference<PullRefreshHeader> ev;
    WeakReference<TextView> ew;
    int mPullType = 1;
    
    public a(Context paramContext, XListView paramXListView, abep paramabep, PullRefreshHeader paramPullRefreshHeader, TextView paramTextView, int paramInt)
    {
      this.es = new WeakReference(paramContext);
      this.eu = new WeakReference(paramXListView);
      this.et = new WeakReference(paramabep);
      this.ev = new WeakReference(paramPullRefreshHeader);
      this.ew = new WeakReference(paramTextView);
      this.mPullType = paramInt;
    }
    
    public void ai(JSONObject paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat.aio_post_list_req", 2, "result " + paramJSONObject);
      }
      XListView localXListView = (XListView)this.eu.get();
      if (localXListView == null) {}
      abep localabep;
      do
      {
        do
        {
          do
          {
            return;
            localObject = (TextView)this.ew.get();
          } while (localObject == null);
          localabep = (abep)this.et.get();
        } while (localabep == null);
        if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode") == 0)) {
          break;
        }
        if (localXListView.getVisibility() == 8) {
          ((TextView)localObject).setText(acfp.m(2131707242));
        }
        paramJSONObject = (Context)this.es.get();
      } while (paramJSONObject == null);
      QQToast.a(paramJSONObject, 1, acfp.m(2131707244), 0).show();
      localabep.cBj();
      return;
      ((TextView)localObject).setVisibility(8);
      localXListView.setVisibility(0);
      Object localObject = paramJSONObject.optJSONObject("result");
      label193:
      int j;
      if (this.mPullType == 1)
      {
        localabep.o(((JSONObject)localObject).optJSONArray("posts"));
        j = paramJSONObject.optInt("retcode");
        paramJSONObject = (PullRefreshHeader)this.ev.get();
        if ((paramJSONObject != null) && (paramJSONObject.getVisibility() == 0)) {
          if (j != 0) {
            break label315;
          }
        }
      }
      label315:
      for (int i = 0;; i = 1)
      {
        paramJSONObject.tT(i);
        localXListView.springBackOverScrollHeaderView();
        if (j != 0) {
          break;
        }
        yam.JG = System.currentTimeMillis();
        return;
        if (((JSONObject)localObject).optInt("isend") == 0)
        {
          localabep.n(((JSONObject)localObject).optJSONArray("posts"));
          localabep.cBj();
          break label193;
        }
        paramJSONObject = (Context)this.es.get();
        if (paramJSONObject != null) {
          QQToast.a(paramJSONObject, 2, acfp.m(2131707234), 0).show();
        }
        localabep.cBj();
        return;
      }
    }
    
    public void onException(Exception paramException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat.aio_post_list_req", 2, paramException.getMessage());
      }
      paramException = (PullRefreshHeader)this.ev.get();
      if ((paramException != null) && (paramException.getVisibility() == 0)) {
        paramException.tT(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yam
 * JD-Core Version:    0.7.0.1
 */