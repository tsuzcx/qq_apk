import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.12;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.17;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.25;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.26;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.31;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.32;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.33;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.44;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.45;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.46;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.50;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.52;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.57;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.58;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.8;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.9;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.a;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.PublicMenuBar;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView.a;
import com.tencent.widget.XPanelContainer;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ycd
  extends BaseChatPie
{
  long JJ = -1L;
  long JK = 0L;
  private long JL;
  private TextView KJ;
  private aqju U;
  private acfd jdField_a_of_type_Acfd;
  protected achq a;
  public apbk a;
  public asgx a;
  public CustomMenuBar a;
  public PublicAccountHandler a;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private PublicMenuBar jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  private XListView.a jdField_a_of_type_ComTencentWidgetXListView$a = new ydp(this);
  kdq jdField_a_of_type_Kdq = new ydm(this);
  private ycd.a jdField_a_of_type_Ycd$a;
  private int aDG;
  public String aXi;
  public String aXj;
  public String aXk;
  public String aXl;
  public String aXm;
  public String aXn;
  public boolean aca;
  boolean ach = false;
  boolean aex = false;
  public boolean afs;
  public boolean aft;
  Dialog ai;
  private Dialog aj;
  public acje b;
  public ahyj b;
  public PublicAccountInfo b;
  PublicMenuBar b;
  protected PatchedButton b;
  public kaw b;
  public kcy b;
  private AtomicBoolean bK = new AtomicBoolean(false);
  private AtomicBoolean bL = new AtomicBoolean(false);
  private int bYA;
  private int bYB = -1;
  private int bYC = -1;
  private int bYD;
  private int bYE;
  int bYr = 0;
  int bYs = 3;
  private int bYt;
  protected int bYu = 2130838058;
  protected int bYv = 2130838057;
  public int bYw;
  public int bYx;
  public int bYy;
  public int bYz;
  public boolean blA = false;
  private boolean blB;
  boolean blC = false;
  boolean blD = false;
  boolean blE = false;
  private boolean blF;
  public boolean blG;
  boolean blH = false;
  boolean blI = false;
  boolean blJ = false;
  public boolean blK = false;
  boolean blL = false;
  boolean blM = false;
  boolean blN = false;
  public boolean blO;
  boolean blm = false;
  public boolean bln = false;
  public boolean blo;
  boolean blp = false;
  boolean blq = false;
  private boolean blr;
  private boolean bls;
  private boolean blt;
  boolean blu = false;
  private boolean blv;
  private boolean blw;
  public boolean blx;
  private boolean bly;
  private boolean blz;
  public ashx c;
  private BusinessObserver c;
  long createTime = -1L;
  private adai jdField_e_of_type_Adai;
  ausj jdField_e_of_type_Ausj;
  private NewIntent jdField_e_of_type_MqqAppNewIntent;
  public View.OnClickListener eh = new ydt(this);
  private long enterTime;
  private adai f;
  protected SpannableString g;
  MessageForStructing jdField_g_of_type_ComTencentMobileqqDataMessageForStructing = null;
  private BusinessObserver jdField_g_of_type_MqqObserverBusinessObserver = new ycq(this);
  protected SpannableString h;
  private LinearLayout hl;
  public int[] iF;
  long initTime = -1L;
  protected LinearLayout j;
  private NewIntent j;
  private NewIntent k;
  private int mCoverHeight;
  public Handler mHandler = new yce(this);
  arhz mProgress;
  private ProgressBar mProgressBar;
  public int mPromotionMenuDestructiveIndex = -1;
  public String mPromotionMenus = "";
  public String mPromotionMsg = "";
  public int mPromotionType;
  public View mQ;
  private int mScrollY;
  private long mStartTime;
  private TextView mTimeText;
  public boolean ob;
  private long og = 9223372036854775807L;
  List<String> ss = new ArrayList();
  List<String> st = new ArrayList();
  private long startTime;
  AbsStructMsg structingMsg;
  private ImageView tT;
  protected ImageView tV;
  protected ImageView tW;
  private String templateId = "";
  public ImageView ue;
  private ImageView uf;
  private int unreadCount;
  private View xi;
  public View xt = null;
  private View xu;
  private View xv;
  private View xw;
  View xx;
  View xy;
  View xz;
  
  public ycd(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar = null;
    this.jdField_b_of_type_Ahyj = new ahyj("web_public_account", "com.tencent.mobileqq:tool");
    this.jdField_a_of_type_Achq = new ycg(this);
    this.jdField_b_of_type_Acje = new ydl(this);
    this.jdField_c_of_type_Ashx = new ydq(this);
  }
  
  private boolean Tn()
  {
    return (this.sessionInfo != null) && (this.sessionInfo.aTl != null) && ("2747277822".equals(this.sessionInfo.aTl));
  }
  
  private boolean To()
  {
    return (this.sessionInfo != null) && (this.sessionInfo.aTl != null) && ("3046055438".equals(this.sessionInfo.aTl));
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.addUpdateListener(new ych(this, paramView, paramInt1, paramInt2));
    localValueAnimator.addListener(paramAnimatorListener);
    localValueAnimator.setDuration(500L).start();
  }
  
  private void b(String paramString, int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("need_report", false))
    {
      PublicAccountHandler.a(this.app, this.sessionInfo.aTl, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
      long l1 = paramIntent.getLongExtra("incoming_msguid", 0L);
      long l2 = paramIntent.getLongExtra("incoming_shmsgseq", 0L);
      if (l1 > 0L) {
        ThreadManager.post(new PublicAccountChatPie.33(this, paramString, paramInt, l1, l2), 5, null, true);
      }
    }
    if (paramIntent.hasExtra("need_report")) {
      paramIntent.removeExtra("need_report");
    }
  }
  
  private void c(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.app.a().createEntityManager();
    localEntityManager.remove(paramAccountDetail);
    localEntityManager.close();
  }
  
  private void cfE()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    if (!this.mActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (acja)this.app.getManager(56);
      if (localObject != null) {
        this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo = ((acja)localObject).c(this.sessionInfo.aTl);
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      a(this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo);
      return;
    }
    Object localObject = new NewIntent(this.mActivity.getApplicationContext(), kbs.class);
    ((NewIntent)localObject).putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("3.4.4,3,3058");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.sessionInfo.aTl));
      label163:
      ((NewIntent)localObject).putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new yda(this));
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  private void cgK()
  {
    ThreadManager.postImmediately(new PublicAccountChatPie.8(this), null, true);
  }
  
  private void cgM()
  {
    if (this.mActivity.getIntent().getExtras() == null) {
      finish();
    }
  }
  
  private void cgR()
  {
    String str = this.app.getCurrentUin();
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("op", "0");
      localBundle.putString("puin", "" + this.sessionInfo.aTl);
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      localBundle.putString("Referer", "https://buluo.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.app.getApp().getApplicationContext());
      new aprc("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new yct(this), 1000, null).J(localHashMap);
      cgN();
      return;
    }
  }
  
  private void cgT()
  {
    SharedPreferences localSharedPreferences = this.mActivity.getSharedPreferences("public_aio_setting", 0);
    String str = "firstOpen_" + this.sessionInfo.aTl;
    if (localSharedPreferences.getBoolean(str, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = ((acja)this.app.getManager(56)).b(this.sessionInfo.aTl);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_b_of_type_Kaw.a(this.mActivity, this.app, this.sessionInfo.aTl, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.31(this, localSharedPreferences, str));
  }
  
  private void cgU()
  {
    if (this.enterTime == 0L) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
    } while (this.app == null);
    Object localObject = this.app.getCurrentAccountUin();
    if (localObject != null) {
      localHashMap.put("uin", localObject);
    }
    if ((this.sessionInfo != null) && (this.sessionInfo.aTl != null)) {
      localHashMap.put("puin", this.sessionInfo.aTl);
    }
    localHashMap.put("menu_click", "" + this.bYw);
    localHashMap.put("menu_to_webview", "" + this.bYy);
    localHashMap.put("article_click", "" + this.bYx);
    localHashMap.put("article_to_webview", "" + this.bYz);
    localHashMap.put("net_type", "" + aomi.a().getNetType());
    localHashMap.put("unread_count", "" + this.bYA);
    long l = System.currentTimeMillis() - this.enterTime;
    if ((this.bYz != 0) || (this.bYy != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("public account webview preload data: ");
        ((StringBuilder)localObject).append("duration: ");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(", entered: ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", exinfo: ");
        ((StringBuilder)localObject).append(localHashMap.toString());
        QLog.d(this.TAG, 2, ((StringBuilder)localObject).toString());
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPublicAccountWebviewPreload", bool, l, 0L, localHashMap, "");
      this.enterTime = 0L;
      this.bYA = 0;
      this.bYy = 0;
      this.bYw = 0;
      this.bYx = 0;
      this.bYz = 0;
      return;
    }
  }
  
  private void cgW()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      acja localacja = (acja)this.app.getManager(56);
      if (localacja != null) {
        this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo = localacja.c(this.sessionInfo.aTl);
      }
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_b_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      cgX();
    }
  }
  
  private void cgX()
  {
    if (this.bK.get()) {
      return;
    }
    this.bK.set(true);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.mActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        this.mActivity.requestPermissions(new ydi(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      cgY();
      return;
    }
    cgY();
  }
  
  private void cgY()
  {
    SosoInterface.a(new ydj(this, 1, true, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void cha()
  {
    s((RelativeLayout)this.jdField_b_of_type_ComTencentWidgetXPanelContainer.getParent());
  }
  
  private void chj()
  {
    Object localObject = (acja)this.app.getManager(56);
    if (localObject != null)
    {
      localObject = ((acja)localObject).b(this.sessionInfo.aTl);
      if ((localObject != null) && (ocp.F(((PublicAccountInfo)localObject).accountFlag2) == -10L))
      {
        this.blB = true;
        localObject = aqdj.a(this.app, 115, this.sessionInfo.aTl);
        if (localObject != null)
        {
          if (this.pp != null) {
            this.pp.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon((Drawable)localObject);
        }
      }
    }
  }
  
  private void chk()
  {
    if (this.JL == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.JL;
    PublicAccountInfo localPublicAccountInfo = ((acja)this.app.getManager(56)).b(this.sessionInfo.aTl);
    if (localPublicAccountInfo != null) {
      aakp.a(this.app, localPublicAccountInfo.uin + "", l1 - l2, localPublicAccountInfo.name + "");
    }
    this.JL = 0L;
  }
  
  private void d(AccountDetail paramAccountDetail)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountChatPie.26(this, paramAccountDetail), 10L);
  }
  
  private void d(MessageForStructing paramMessageForStructing)
  {
    int i = 0;
    if (paramMessageForStructing.structingMsg == null) {}
    for (;;)
    {
      return;
      this.structingMsg = paramMessageForStructing.structingMsg;
      this.templateId = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
      this.mPromotionType = paramMessageForStructing.structingMsg.mPromotionType;
      this.mPromotionMsg = paramMessageForStructing.structingMsg.mPromotionMsg;
      this.mPromotionMenus = paramMessageForStructing.structingMsg.mPromotionMenus;
      this.mPromotionMenuDestructiveIndex = paramMessageForStructing.structingMsg.mPromotionMenuDestructiveIndex;
      try
      {
        if (this.mPromotionMenus == null) {
          continue;
        }
        this.blF = false;
        paramMessageForStructing = this.mPromotionMenus.split(",");
        if (paramMessageForStructing == null) {
          continue;
        }
        int m = paramMessageForStructing.length;
        this.iF = new int[m];
        while (i < m)
        {
          paramMessageForStructing[i] = paramMessageForStructing[i].trim();
          this.iF[i] = Integer.parseInt(paramMessageForStructing[i]);
          i += 1;
        }
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        this.blF = true;
      }
    }
  }
  
  public static boolean d(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (acja)paramQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((acja)localObject).b(paramString);; localObject = null)
    {
      if (localObject == null)
      {
        paramQQAppInterface = paramQQAppInterface.b();
        if (paramQQAppInterface != null)
        {
          paramString = paramQQAppInterface.a(paramString, 1008);
          if ((paramString != null) && (paramString.msgtype == -2011))
          {
            paramQQAppInterface = new MessageForStructing();
            MessageForStructing.copyMessageRecordBaseField(paramQQAppInterface, paramString);
            paramQQAppInterface.parse();
            if ((paramQQAppInterface.structingMsg != null) && ((paramQQAppInterface.structingMsg.mPromotionType == 1) || (paramQQAppInterface.structingMsg.mPromotionType == 2))) {
              return true;
            }
          }
        }
      }
      return false;
    }
  }
  
  private void e(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1)) {
      setGravity(80);
    }
    while (!CustomMenuBar.isDefaultTheme()) {
      return;
    }
    setGravity(16);
  }
  
  private void e(AccountDetail paramAccountDetail)
  {
    if (this.xt == null) {
      return;
    }
    Object localObject1 = (TextView)this.xt.findViewById(2131381220);
    Object localObject2 = (TextView)this.xt.findViewById(2131381219);
    ImageView localImageView = (ImageView)this.xt.findViewById(2131368698);
    if (this.bly) {
      if ((this.jdField_a_of_type_Apbk != null) && (this.jdField_a_of_type_Apbk.dSY > 0) && (this.jdField_a_of_type_Apbk.HE.size() > 0))
      {
        TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_Apbk.HE.get(0);
        ((TextView)localObject1).setText(localTroopInfo.troopname);
        ((TextView)localObject2).setText(String.format(this.mContext.getString(2131697408), new Object[] { paramAccountDetail.name }));
        localImageView.setImageDrawable(aqdj.a(this.app, 4, localTroopInfo.troopuin));
        localObject1 = "";
        if (this.jdField_a_of_type_Apbk.HE.size() > 0) {
          localObject1 = ((TroopInfo)this.jdField_a_of_type_Apbk.HE.get(0)).troopuin;
        }
        if (this.sessionInfo != null) {
          break label318;
        }
        localObject2 = "";
        anot.a(this.app, "dc00899", "Grp_public", "", "oper", "exp_temp", 0, 0, (String)localObject1, "" + (String)localObject2, "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Acfd == null)
      {
        this.jdField_a_of_type_Acfd = new yde(this, localImageView);
        this.mActivity.addObserver(this.jdField_a_of_type_Acfd);
      }
      localObject1 = (ImageView)this.xt.findViewById(2131364412);
      if (paramAccountDetail.certifiedGrade != 0) {
        break label375;
      }
      ((ImageView)localObject1).setVisibility(8);
      return;
      label318:
      localObject2 = this.sessionInfo.aTl;
      break;
      ((TextView)localObject1).setText(paramAccountDetail.name);
      if (this.mPromotionMsg != null) {
        ((TextView)localObject2).setText(this.mPromotionMsg);
      }
      localImageView.setImageDrawable(aqdj.a(this.app, a().aTl, (byte)1));
    }
    label375:
    ((ImageView)localObject1).setVisibility(0);
  }
  
  private void l(AbsListView paramAbsListView)
  {
    if ((this.sessionInfo != null) && ("3046055438".equals(this.sessionInfo.aTl)))
    {
      int m = paramAbsListView.getChildCount();
      int i = 0;
      while (i < m)
      {
        View localView = paramAbsListView.getChildAt(i);
        if (localView != null) {
          tld.a().g(localView);
        }
        i += 1;
      }
    }
  }
  
  private void oq(int paramInt)
  {
    this.uiHandler.postDelayed(new PublicAccountChatPie.25(this, paramInt), 500L);
  }
  
  private void s(RelativeLayout paramRelativeLayout)
  {
    SharedPreferences localSharedPreferences = this.mActivity.getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("firstIntoAIO", true))
    {
      LinearLayout localLinearLayout = new LinearLayout(this.mActivity);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.parseColor("#B3000000"));
      localLinearLayout.setVisibility(0);
      localLinearLayout.setClickable(true);
      localLinearLayout.setOnClickListener(new ydk(this, paramRelativeLayout, localLinearLayout));
      Object localObject = new ImageView(this.mActivity);
      ((ImageView)localObject).setImageResource(2130842483);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      Resources localResources = this.mActivity.getResources();
      localLayoutParams.width = wja.dp2px(73.0F, localResources);
      localLayoutParams.height = wja.dp2px(73.0F, localResources);
      localLayoutParams.topMargin = wja.dp2px(100.0F, localResources);
      localLayoutParams.gravity = 17;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      localObject = new TextView(this.mActivity);
      ((TextView)localObject).setText(acfp.m(2131710234));
      ((TextView)localObject).setTextSize(2, 18.0F);
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = wja.dp2px(28.0F, localResources);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      paramRelativeLayout.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
      localSharedPreferences.edit().putBoolean("firstIntoAIO", false).commit();
    }
  }
  
  private void setGravity(int paramInt)
  {
    if (this.hl == null) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (LinearLayout.LayoutParams)this.hl.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams.gravity != paramInt)
      {
        localLayoutParams.gravity = paramInt;
        this.hl.setLayoutParams(localLayoutParams);
      }
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_j_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    } while (localLayoutParams.gravity == paramInt);
    localLayoutParams.gravity = paramInt;
    this.jdField_j_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  private void yw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "unfollow");
    }
    oq(2131697481);
    Object localObject = (acja)this.app.getManager(56);
    if (localObject != null)
    {
      localObject = ((acja)localObject).a(this.sessionInfo.aTl);
      if ((localObject != null) && (ocp.getAccountType(((AccountDetail)localObject).accountFlag) != -4)) {
        break label191;
      }
      localObject = new NewIntent(BaseApplicationImpl.getContext(), kbs.class);
      ((NewIntent)localObject).putExtra("cmd", "unfollow");
      mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
      localUnFollowRequest.uin.set((int)Long.parseLong(paramString));
      ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
      this.jdField_c_of_type_MqqObserverBusinessObserver = new ycu(this, paramString);
      ((NewIntent)localObject).setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
      this.app.startServlet((NewIntent)localObject);
    }
    for (;;)
    {
      this.aDG += 1;
      ocp.n(this.app, paramString);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "unfollow exit");
      }
      return;
      label191:
      this.app.removeObserver(this.f);
      this.f = new adai(new ycv(this, paramString));
      this.app.addObserver(this.f);
      adam.a(this.app, false, this.sessionInfo.aTl, 0);
    }
  }
  
  @TargetApi(11)
  public void Aa(int paramInt)
  {
    super.Aa(paramInt);
    ImageSpan localImageSpan;
    SpannableString localSpannableString;
    if (paramInt != this.bEl)
    {
      if (paramInt != 1) {
        break label87;
      }
      if (this.jdField_g_of_type_AndroidTextSpannableString == null)
      {
        localImageSpan = new ImageSpan(this.mContext, 2130838169);
        localSpannableString = new SpannableString(acfp.m(2131710239));
        localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
        this.jdField_g_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_g_of_type_AndroidTextSpannableString);
    }
    label332:
    for (;;)
    {
      cfC();
      return;
      label87:
      if (paramInt == 2)
      {
        if (this.h == null)
        {
          localImageSpan = new ImageSpan(this.mContext, 2130838463);
          localSpannableString = new SpannableString(acfp.m(2131710202));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.h = localSpannableString;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.h);
        if (VersionUtils.isHoneycomb())
        {
          if (this.tW != null) {
            this.tW.setAlpha(0.6F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
        }
      }
      else
      {
        if (this.h == null)
        {
          localImageSpan = new ImageSpan(this.mContext, 2130838463);
          localSpannableString = new SpannableString(acfp.m(2131710224));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.h = localSpannableString;
        }
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131691441);
        }
        for (;;)
        {
          if (!VersionUtils.isHoneycomb()) {
            break label332;
          }
          if (this.tW != null) {
            this.tW.setAlpha(1.0F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
          break;
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.h);
        }
      }
    }
  }
  
  public void DF(int paramInt)
  {
    try
    {
      this.KJ.setText(paramInt);
      this.KJ.setVisibility(0);
      this.uf.setVisibility(8);
      this.mProgressBar.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void DG(int paramInt)
  {
    if (this.aj == null)
    {
      this.aj = new ReportDialog(a(), 2131756467);
      this.aj.setContentView(2131561091);
    }
    TextView localTextView1 = (TextView)this.aj.findViewById(2131379769);
    TextView localTextView2 = (TextView)this.aj.findViewById(2131361959);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.aj.setOnCancelListener(new ydr(this));
      this.aj.show();
      return;
      localTextView1.setText(2131700367);
      localTextView2.setText(2131700373);
      continue;
      localTextView1.setText(2131700368);
      localTextView2.setText(2131700369);
      continue;
      localTextView1.setText(2131700371);
      localTextView2.setText(2131700369);
    }
  }
  
  public void Ib()
  {
    this.TAG = "PublicAccountChatPie";
  }
  
  public void K(ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_Wki.b(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i);
    }
    if (i < 0) {
      return;
    }
    int m = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int n = i - m;
    this.mQ = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(n);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + n + ",firstPos is:" + m + ",pos is:" + i);
    }
    this.jdField_a_of_type_Wki.q(paramChatMessage);
  }
  
  public boolean ON()
  {
    PublicAccountInfo localPublicAccountInfo = ((acja)this.app.getManager(56)).b(this.sessionInfo.aTl);
    return (localPublicAccountInfo == null) || ((localPublicAccountInfo.accountFlag & 0x10000000) == 0);
  }
  
  public boolean OO()
  {
    return false;
  }
  
  public boolean Pe()
  {
    if ((!this.blH) && (this.blx))
    {
      this.blH = true;
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_Wki.getCount() - 1);
    }
    while ((this.blI) || (!this.blx)) {
      return true;
    }
    this.blI = true;
    return false;
  }
  
  public void S(long paramLong)
  {
    try
    {
      this.KJ.setVisibility(8);
      this.uf.setVisibility(8);
      this.mProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean Tj()
  {
    Object localObject = (acja)this.app.getManager(56);
    if (localObject != null) {}
    for (localObject = ((acja)localObject).b(this.sessionInfo.aTl);; localObject = null)
    {
      if ((localObject == null) && (ocp.a(this.app, this.sessionInfo.aTl) == null))
      {
        ocp.bdB();
        ocp.a(this.app, BaseApplication.getContext(), this.uiHandler, this.sessionInfo.aTl);
        return true;
      }
      return false;
    }
  }
  
  public boolean Tk()
  {
    Object localObject = this.app.b();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).a(this.sessionInfo.aTl, 1008);
      if (localObject != null) {
        if (((QQMessageFacade.Message)localObject).msgtype == -2011)
        {
          localMessageForStructing = new MessageForStructing();
          MessageForStructing.copyMessageRecordBaseField(localMessageForStructing, (MessageRecord)localObject);
          localMessageForStructing.parse();
          if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mPromotionType == 1) || (localMessageForStructing.structingMsg.mPromotionType == 2))) {
            d(localMessageForStructing);
          }
        }
        else
        {
          while ((((QQMessageFacade.Message)localObject).msgtype == -2009) && (((QQMessageFacade.Message)localObject).isSend()))
          {
            MessageForStructing localMessageForStructing;
            return true;
          }
          if ((((QQMessageFacade.Message)localObject).msgtype == -5008) && (!((QQMessageFacade.Message)localObject).isSend()))
          {
            this.mPromotionType = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean Tl()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 8);
  }
  
  public boolean Tm()
  {
    return (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) || (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getVisibility() == 8);
  }
  
  public void U(Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "qidianWpaClick ... mQidianKefu = " + this.blL);
    }
    showLoading(2131697483);
    Object localObject;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localObject = (String)paramMap.get("AssignType");
      String str = (String)paramMap.get("AssignID");
      paramMap = (Map<String, String>)localObject;
      localObject = str;
    }
    for (;;)
    {
      this.jdField_b_of_type_Kaw.a(this.mActivity, this.sessionInfo.aTl, paramMap, (String)localObject, null, new yds(this));
      return;
      localObject = null;
      paramMap = null;
    }
  }
  
  public void W(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  public Map<String, String> a(AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg != null) {
      try
      {
        if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
        {
          paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).mMsgActionData;
          if ((paramAbsStructMsg != null) && (!TextUtils.isEmpty(paramAbsStructMsg)))
          {
            paramAbsStructMsg = aurr.getArguments(paramAbsStructMsg.substring(paramAbsStructMsg.indexOf("?") + 1));
            return paramAbsStructMsg;
          }
        }
      }
      catch (Exception paramAbsStructMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, paramAbsStructMsg.getMessage());
        }
      }
    }
    return null;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.blx) {
      DF(2131697439);
    }
  }
  
  void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    aceb localaceb = (aceb)this.app.getBusinessHandler(21);
    if (localaceb != null) {
      localaceb.a(this.sessionInfo.aTl, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Apbk != null)
      {
        Iterator localIterator = this.jdField_a_of_type_Apbk.HE.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((TroopInfo)localIterator.next()).troopuin.equals(paramMessage.frienduin));
      }
      for (int i = 1; (paramMessage.istroop != 1) || (i == 0); i = 0)
      {
        super.a(paramMessage);
        return;
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    super.a(paramChatMessage);
    Object localObject = paramChatMessage.frienduin;
    int i = paramChatMessage.istroop;
    if (oan.a().e(this.app, (String)localObject, i))
    {
      paramChatMessage = this.app.a().a();
      localObject = paramChatMessage.a((String)localObject, i);
      if (localObject != null) {
        paramChatMessage.f((RecentUser)localObject);
      }
    }
  }
  
  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    acja localacja;
    if (paramPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + paramPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + paramPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + paramPublicAccountInfo.mIsAgreeSyncLbs);
      }
      localacja = (acja)this.app.getManager(56);
      if (localacja == null) {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "showEqqLbsEnableDialog(): pam is null");
        }
      }
    }
    for (;;)
    {
      return;
      if ((paramPublicAccountInfo.isSyncLbs) && (!paramPublicAccountInfo.mIsSyncLbsSelected) && (!paramPublicAccountInfo.mIsAgreeSyncLbs) && (!this.blv))
      {
        String str1 = this.mActivity.getString(2131693263);
        String str2 = String.format(this.mActivity.getString(2131693261), new Object[] { this.sessionInfo.aTn });
        this.ai = aqha.a(this.mActivity, 230, str1, str2, 2131693260, 2131693262, new ydb(this, paramPublicAccountInfo, localacja), new ydc(this, paramPublicAccountInfo, localacja));
        this.ai.setOnDismissListener(new ydd(this));
        this.ai.setCanceledOnTouchOutside(true);
        if (!this.mActivity.isFinishing()) {
          this.ai.show();
        }
        this.blv = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 2, "showEqqLbsEnableDialog(): END");
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.sessionInfo.aTl);
        }
      }
    }
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    this.aft = true;
    super.a(paramList, paramCharSequence);
    int i;
    long l;
    if (this.aSD)
    {
      if (paramList.size() <= 0) {
        break label177;
      }
      paramList = (ChatMessage)paramList.get(paramList.size() - 1);
      i = paramList.msgtype;
      l = paramList.msgseq;
      if (!(paramList instanceof MessageForStructing)) {
        break label174;
      }
      paramList = (MessageForStructing)paramList;
      if (paramList.structingMsg == null) {
        break label174;
      }
      l = paramList.structingMsg.msgId;
    }
    for (;;)
    {
      anot.a(this.app, "dc00899", "Pb_account_lifeservice", "" + this.sessionInfo.aTl, "0X80064D4", "0X80064D4", 0, 0, "", "" + i, "" + l, "");
      return;
      label174:
      continue;
      label177:
      l = 0L;
      i = -1;
    }
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    try
    {
      Iterator localIterator;
      if ((To()) && (keo.za()) && (paramList.size() > 0)) {
        localIterator = paramList.iterator();
      }
      for (;;)
      {
        Object localObject;
        if (localIterator.hasNext())
        {
          localObject = (ChatMessage)localIterator.next();
          anqu localanqu = kee.a((MessageRecord)localObject);
          if ((localanqu == null) || (localanqu.dMc != 1)) {
            break label133;
          }
          localIterator.remove();
          continue;
        }
        try
        {
          ((zyd)this.app.getManager(341)).hs(paramList);
          super.a(paramList, paramCharSequence, paramInt);
          return;
          localObject = kee.a((MessageRecord)localObject);
          if ((localObject == null) || (((JSONObject)localObject).optInt("is_hidden") != 1)) {
            continue;
          }
          localThrowable1.remove();
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            QLog.e(this.TAG, 1, localThrowable2, new Object[0]);
          }
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e(this.TAG, 1, QLog.getStackTraceString(localThrowable1));
      if (!ocp.a(this.sessionInfo)) {}
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!Tm()) {
        this.bYB = 2;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        super.a(paramBoolean1, paramChatMessage, paramBoolean2);
        return;
        if (!Tl()) {
          this.bYB = 1;
        } else {
          this.bYB = 0;
        }
      }
    }
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    switch (this.bYB)
    {
    }
    for (;;)
    {
      this.bYB = -1;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "listView onViewCompleteVisableAndReleased");
    }
    if (!this.blx) {
      return super.a(paramInt, paramView, paramListView);
    }
    if ((this.jdField_a_of_type_Wki != null) && (this.jdField_a_of_type_Wki.getCount() > 0))
    {
      this.ob = true;
      S(System.currentTimeMillis());
      this.Fp = SystemClock.uptimeMillis();
      ((wkk)this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.context).fU(this.Fp);
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = false;
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQj = true;
      this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, 21, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
    }
    return true;
  }
  
  public void aAt()
  {
    if ((!this.mActivity.isFinishing()) && (this.mProgress != null) && (this.mProgress.isShowing())) {
      this.mProgress.dismiss();
    }
  }
  
  void aC(boolean paramBoolean, int paramInt)
  {
    anot.a(this.app, "CliOper", "", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.k != null)
    {
      kaw.a().b(this.k);
      this.k = null;
    }
    this.k = kaw.a().a(this.sessionInfo.aTl, paramInt, paramBoolean, BaseApplication.getContext(), this.app, new ydf(this));
  }
  
  public void aI(QQAppInterface paramQQAppInterface)
  {
    super.aI(paramQQAppInterface);
    if ((this.sessionInfo.cZ == 1008) && (nyn.f(paramQQAppInterface, this.sessionInfo.aTl)) && (nyn.a().eo(this.sessionInfo.aTl))) {
      nyn.a().k(paramQQAppInterface, this.sessionInfo.aTl);
    }
  }
  
  public boolean af(boolean paramBoolean)
  {
    this.app.setHandler(getClass(), this.uiHandler);
    this.jdField_a_of_type_Ycd$a = new ycd.a(null);
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
    this.mContext.registerReceiver(this.jdField_a_of_type_Ycd$a, (IntentFilter)localObject1);
    this.aSY = false;
    this.aSJ = false;
    cgM();
    this.jdField_b_of_type_Kaw = kaw.a();
    chc();
    super.af(paramBoolean);
    if (this.blJ) {
      che();
    }
    if (this.app.a().A(this.sessionInfo.aTl, this.sessionInfo.cZ) > 0) {
      this.blG = true;
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$a);
    this.jdField_a_of_type_Apbk = new apbk();
    this.jdField_a_of_type_Apbk.a(this.app, a(), this, this.sessionInfo, this.fs, this.jdField_a_of_type_Wki, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_Apbk.addObserver(this);
    localObject1 = this.mActivity.getIntent();
    this.startTime = System.currentTimeMillis();
    this.unreadCount = ((Intent)localObject1).getIntExtra("red_hot_count", 0);
    Object localObject2 = ((Intent)localObject1).getStringExtra("from");
    this.blC = ((Intent)localObject1).getBooleanExtra("shouldreport", false);
    this.enterTime = System.currentTimeMillis();
    this.bYx = 0;
    this.bYz = 0;
    this.bYw = 0;
    this.bYy = 0;
    this.bYA = this.unreadCount;
    ocp.awm = ((Intent)localObject1).getBooleanExtra("is_come_from_readinjoy", false);
    this.bYC = ((Intent)localObject1).getIntExtra("INTENT_KEY_FROM", 1);
    if (!this.mActivity.isFinishing())
    {
      PublicAccountInfo localPublicAccountInfo = ((acja)this.app.getManager(56)).b(this.sessionInfo.aTl);
      if ((localPublicAccountInfo == null) || (ocp.getAccountType(localPublicAccountInfo.accountFlag) != -2)) {
        break label601;
      }
      this.blw = true;
      cgP();
      this.jdField_a_of_type_Apbk.dYD();
      if (this.jdField_a_of_type_Apbk.dSY > 0) {
        break label483;
      }
      this.jdField_a_of_type_Apbk.aU(Long.valueOf(this.sessionInfo.aTl).longValue(), 1);
    }
    for (;;)
    {
      PublicAccountHandler.bov = null;
      this.aex = this.mActivity.getIntent().getBooleanExtra("has_unread_msg", false);
      if ((localObject2 == null) || (!((String)localObject2).equals("starShortcut"))) {
        break;
      }
      kaw.a(this.mActivity, this.app, ((Intent)localObject1).getStringExtra("starhomeurl"), ((Intent)localObject1).getStringExtra("uin"), (String)localObject2);
      return true;
      label483:
      int m = ((apsa)this.app.getManager(132)).eT(this.sessionInfo.aTl);
      if (m == -1)
      {
        this.jdField_a_of_type_Apbk.aU(Long.valueOf(this.sessionInfo.aTl).longValue(), 2);
      }
      else
      {
        int i;
        if ((m & 0xF) == 0)
        {
          i = 1;
          label545:
          if (m >> 4 != 1) {
            break label579;
          }
          m = 1;
          label554:
          if ((i == 0) || (m == 0)) {
            break label584;
          }
          this.bly = true;
        }
        for (;;)
        {
          cgK();
          break;
          i = 0;
          break label545;
          label579:
          m = 0;
          break label554;
          label584:
          this.jdField_a_of_type_Apbk.dYC();
          this.jdField_a_of_type_Apbk.dYz();
        }
        label601:
        cgK();
      }
    }
    if ((aqiw.getNetworkType(this.mActivity.getApplicationContext()) == 1) && (this.sessionInfo.aTl != null) && (this.sessionInfo.aTl.equals("2632129500"))) {
      jpa.b("108", this.app, true, new ydn(this));
    }
    if ("3105932915".equals(this.sessionInfo.aTl))
    {
      localObject1 = (avcq)this.app.getManager(142);
      if (localObject1 != null) {
        avco.a(((avcq)localObject1).a(5));
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    this.blx = ocp.m(this.app, this.sessionInfo.aTl);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnCreate, isMediaAndOtherSubscript = " + this.blx);
    }
    this.createTime = (NetConnInfoCenter.getServerTime() * 1000L);
    if (ocp.ex(this.sessionInfo.aTl))
    {
      localObject1 = (WebProcessManager)this.app.getManager(13);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "doOnCreate, preload web process");
        }
        ((WebProcessManager)localObject1).egu();
      }
    }
    if (this.blx)
    {
      cha();
      cgZ();
      chb();
    }
    if (this.blx) {
      if (this.aca) {
        kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.sessionInfo.aTl, "new", "", "", false);
      }
    }
    for (;;)
    {
      lcm.a().mZ(this.sessionInfo.aTl);
      if (((acja)this.app.getManager(56)).kn(this.sessionInfo.aTl)) {
        this.blo = true;
      }
      if ((Tn()) && (this.bYA > 0)) {
        ThreadManagerV2.excute(new PublicAccountChatPie.6(this), 16, null, false);
      }
      if (To())
      {
        ArkAppNotifyCenter.setNotify("com.tencent.gouwu.video", new WeakReference(new ArkAppNotifyCenter.a()));
        ArkAppNotifyCenter.registVolumnReceiver();
      }
      try
      {
        if (To())
        {
          localObject1 = ken.a();
          if ((keo.za()) && (keo.a((kem)localObject1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "initPublicAccountMenu new qqshop pubaccount return");
            }
            localObject2 = new CustomTabView(this.mContext);
            if (((CustomTabView)localObject2).b((kem)localObject1))
            {
              bIh();
              bIi();
              if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
                this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
              }
              ((CustomTabView)localObject2).setTag("echopCustomTabView");
              ((CustomTabView)localObject2).oz(1);
              this.fs.addView((View)localObject2);
              localObject1 = (RelativeLayout.LayoutParams)((CustomTabView)localObject2).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).width = -1;
              ((RelativeLayout.LayoutParams)localObject1).height = -2;
              ((RelativeLayout.LayoutParams)localObject1).addRule(12);
              this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.post(new PublicAccountChatPie.7(this));
            }
          }
          localObject1 = (kds)this.app.getBusinessHandler(139);
          if (localObject1 != null) {
            ((kds)localObject1).a(null, null, false, null);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e(this.TAG, 1, QLog.getStackTraceString(localThrowable));
        }
      }
      if (xki.hN(this.sessionInfo.aTl)) {
        abcx.a().E(this.app, "aio_page_arrive");
      }
      return true;
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.sessionInfo.aTl, "old", "", "", false);
      continue;
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.sessionInfo.aTl, "", "", "", false);
      if ("2290230341".equals(this.sessionInfo.aTl))
      {
        anot.a(this.app, "CliOper", "", "", "0X80090E2", "0X80090E2", 0, 0, "", "", "", "");
        anor.Vk(2);
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    super.afterTextChanged(paramEditable);
    e(paramEditable);
    PatchedButton localPatchedButton;
    if (this.bEl == 0)
    {
      if (!this.aSh) {
        break label75;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131691441);
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() <= 0) {
        break label70;
      }
      bool1 = bool2;
      localPatchedButton.setEnabled(bool1);
    }
    label70:
    label75:
    do
    {
      do
      {
        return;
        bool1 = false;
        break;
      } while ((this.ue != null) && (this.ue.getVisibility() == 0));
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() > 0) {
        bool1 = true;
      }
      localPatchedButton.setEnabled(bool1);
    } while (paramEditable.length() <= 0);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131691441);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
  }
  
  public boolean az(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = ((acja)this.app.getManager(56)).b(this.sessionInfo.aTl);
      if (localObject != null) {
        return (((PublicAccountInfo)localObject).accountFlag & 0x40000000) == 1073741824;
      }
      return false;
    }
    Object localObject = (acja)this.app.getManager(56);
    if (localObject != null)
    {
      localObject = ((acja)localObject).a(this.sessionInfo.aTl);
      if (localObject == null) {
        return false;
      }
      return (((AccountDetail)localObject).accountFlag & 0x40000000) == 1073741824;
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.blx) {
      DF(2131697450);
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_Wki.b(paramChatMessage) + 1;
    if ((i >= 0) && (i <= this.jdField_a_of_type_Wki.getCount() - 1))
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_Wki.getItem(i);
      if ((localChatMessage != null) && (localChatMessage.msgtype == -1048))
      {
        super.b(paramChatMessage);
        K(localChatMessage);
        return;
      }
    }
    super.b(paramChatMessage);
  }
  
  public void bGE()
  {
    super.bGE();
    this.jdField_b_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.mAIORootView.findViewById(2131367817));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setContentDescription(acfp.m(2131710237));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.tT = ((ImageView)this.mAIORootView.findViewById(2131366615));
    if (this.tT != null) {
      this.tT.setVisibility(8);
    }
    this.hl = ((LinearLayout)this.mAIORootView.findViewById(2131373772));
    this.hl.setVisibility(0);
    Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 0;
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_j_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mAIORootView.findViewById(2131367818));
    localObject = (LinearLayout.LayoutParams)this.jdField_j_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_j_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (CustomMenuBar.isDefaultTheme()) {
      this.hl.setBackgroundColor(-1);
    }
    for (;;)
    {
      this.ue = ((ImageView)this.hl.findViewById(2131363082));
      this.ue.setOnClickListener(this);
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
        int i = wja.dp2px(3.0F, this.mActivity.getResources());
        if (CustomMenuBar.isDefaultTheme())
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130850984);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.mActivity.getResources().getColor(2131167447));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, i, 0, i);
      }
      return;
      setGravity(80);
    }
  }
  
  public void bGK()
  {
    yiz localyiz = new yiz(this.app, this.sessionInfo, this.jdField_a_of_type_Yjh, this, this.uiHandler);
    this.jdField_a_of_type_Yjh.a(localyiz);
  }
  
  public void bGO()
  {
    if (!this.blx) {
      super.bGO();
    }
  }
  
  public void bGT()
  {
    super.bGT();
    cgV();
  }
  
  public void bGY()
  {
    if (this.blB)
    {
      "https://h5.qzone.qq.com/subscription/homepage/{userId}?_proxy=1&_wv=16777217&_wwv=4".replace("{userId}", this.sessionInfo.aTl);
      rzd.bf(a(), this.sessionInfo.aTl);
      anot.a(null, "dc00898", "", this.sessionInfo.aTl, "auth_aio", "clk_head", 0, 0, "", "", this.sessionInfo.aTn, "");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.sessionInfo.aTl);
    localIntent.putExtra("uinname", this.sessionInfo.aTn);
    localIntent.putExtra("uintype", this.sessionInfo.cZ);
    if (this.blJ) {
      localIntent.putExtra("qidian_chat", true);
    }
    if (this.structingMsg != null) {
      localIntent.putExtra("public_account_msg_id", this.structingMsg.msgId);
    }
    if ((1 == this.sessionInfo.cZ) || (1000 == this.sessionInfo.cZ) || (1020 == this.sessionInfo.cZ) || (1004 == this.sessionInfo.cZ)) {
      localIntent.putExtra("troop_uin", this.sessionInfo.troopUin);
    }
    ocp.a(localIntent, this.app, this.mActivity.getActivity(), this.sessionInfo.aTl, -1, 2000, 1, ocp.awm);
  }
  
  public void bGZ()
  {
    if (this.pp != null)
    {
      if ("2277373213".equals(this.sessionInfo.aTl)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130848210);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130851145, 2130851146);
    this.pp.setContentDescription(this.mActivity.getText(2131698657));
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addObserver(this.jdField_a_of_type_Achq);
    this.app.b().addObserver(this);
    this.app.addObserver(this.jdField_b_of_type_Acje);
    kdm localkdm = (kdm)this.app.getManager(88);
    if (nyn.i(this.app, this.sessionInfo.aTl)) {
      this.app.addObserver(this.jdField_a_of_type_Kdq);
    }
    this.app.addObserver(this.jdField_c_of_type_Ashx);
  }
  
  public void bHt()
  {
    super.bHt();
    this.uiHandler.sendEmptyMessageDelayed(37, 500L);
    if (this.jdField_a_of_type_Apbk.cPI)
    {
      this.jdField_a_of_type_Apbk.em(this.app);
      this.jdField_a_of_type_Apbk.dYA();
    }
    if ((xki.hN(this.sessionInfo.aTl)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(acfp.m(2131710207));
    }
    if ((!this.bls) && (this.blt))
    {
      this.blt = false;
      ThreadManager.postImmediately(new PublicAccountChatPie.4(this), null, true);
    }
    this.JJ = (NetConnInfoCenter.getServerTime() * 1000L);
    if (ChatActivityUtils.f(this.app, this.sessionInfo)) {
      if (ixa.a().cD(this.app.getCurrentAccountUin()))
      {
        this.ps.setVisibility(0);
        this.ps.setOnClickListener(this);
      }
    }
    for (;;)
    {
      kdp localkdp = (kdp)this.app.getBusinessHandler(68);
      if (nyn.i(this.app, this.sessionInfo.aTl))
      {
        long l = 0L;
        if (kdm.db.get(this.sessionInfo.aTl) != null) {
          l = ((Long)kdm.db.get(this.sessionInfo.aTl)).longValue();
        }
        if ((!TextUtils.isEmpty((String)kdm.da.get(this.sessionInfo.aTl))) && (System.currentTimeMillis() - l <= kdm.aHY)) {
          break;
        }
        kdm.db.put(this.sessionInfo.aTl, Long.valueOf(System.currentTimeMillis()));
        localkdp.lV(this.sessionInfo.aTl);
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
    if (ixa.a().cD(this.app.getCurrentAccountUin()))
    {
      this.ps.setVisibility(0);
      this.ps.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130847958);
      return;
    }
    this.ps.setVisibility(8);
  }
  
  public void bHy()
  {
    super.bHy();
    this.bls = false;
    this.blt = false;
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
    if (this.app.b() != null) {
      this.app.b().deleteObserver(this);
    }
    this.app.removeObserver(this.jdField_b_of_type_Acje);
    this.app.removeObserver(this.jdField_a_of_type_Kdq);
    this.app.removeObserver(this.jdField_c_of_type_Ashx);
    this.app.removeObserver(this.jdField_e_of_type_Adai);
    this.app.removeObserver(this.f);
  }
  
  public void bIi()
  {
    super.bIi();
    if (this.iX != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.iX.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (!Tm())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getId());
            return;
          }
          if (!Tl())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getId());
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void bn(Intent paramIntent)
  {
    super.bn(paramIntent);
    if (this.blJ) {
      chg();
    }
    if (xki.hN(this.sessionInfo.aTl))
    {
      this.tV.setVisibility(8);
      this.tW.setVisibility(8);
    }
  }
  
  public void bo(Intent paramIntent)
  {
    super.bo(paramIntent);
    if (ocp.s(this.app)) {
      this.mTitleText.setText(this.sessionInfo.aTl);
    }
  }
  
  public void br(Intent paramIntent)
  {
    super.br(paramIntent);
    b(this.sessionInfo.aTl, this.sessionInfo.cZ, paramIntent);
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.post(new PublicAccountChatPie.32(this));
    cgW();
    chi();
    chj();
  }
  
  public void bt(Intent paramIntent)
  {
    super.bt(paramIntent);
    if (this.pq != null) {
      this.pq.setContentDescription(this.app.getApplication().getString(2131690700));
    }
    if (this.Cr != null) {
      this.Cr.setText("");
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
  
  public void cgL()
  {
    ChatMessage localChatMessage;
    String str1;
    if (this.jdField_a_of_type_Wki.getCount() >= 1)
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_Wki.getList().get(this.jdField_a_of_type_Wki.getCount() - 1);
      str1 = "0";
      if (localChatMessage != null)
      {
        localObject = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("ad_id")) {
        str1 = ((JSONObject)localObject).getString("ad_id");
      }
    }
    catch (Exception localException)
    {
      long l;
      for (;;)
      {
        String str2 = "0";
      }
      anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X8005D17", "0X8005D17", 0, 1, 0, "old", String.valueOf(l - this.createTime), "", "");
    }
    Object localObject = localChatMessage.getExtInfoFromExtStr("pa_msgId");
    anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", "" + localChatMessage.frienduin, "0X8005C38", "0X8005C38", 0, 1, 0, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
    if (this.blx)
    {
      l = NetConnInfoCenter.getServerTime() * 1000L;
      if (this.aca) {
        anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X8005D17", "0X8005D17", 0, 1, 0, "new", String.valueOf(l - this.createTime), "", "");
      }
    }
    else
    {
      return;
    }
  }
  
  @TargetApi(11)
  void cgN()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.fs.post(new PublicAccountChatPie.12(this));
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.xu);
      this.blr = true;
      this.mHandler.sendEmptyMessage(1);
      return;
    }
    a(this.xu, this.xu.getHeight(), 0, new yci(this));
    this.xt.setTranslationY(0.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.xt.getHeight());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new ycj(this));
    this.xt.startAnimation(localTranslateAnimation);
  }
  
  void cgO()
  {
    if ((this.fs == null) || (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        this.xt = LayoutInflater.from(this.mActivity.getBaseContext()).inflate(2131558683, this.fs, false);
      } while (this.xt == null);
      this.xt.setClickable(true);
      this.xt.findViewById(2131368698).setOnClickListener(new ycm(this));
      if (this.mPromotionType != 2) {
        break;
      }
      this.xt.findViewById(2131373769).setVisibility(8);
      this.xt.findViewById(2131373755).setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.mContext.getResources().getDimensionPixelSize(2131299627);
      this.fs.addView(this.xt, (ViewGroup.LayoutParams)localObject);
      this.xu = LayoutInflater.from(this.mActivity.getBaseContext()).inflate(2131558682, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, false);
    } while (this.xu == null);
    label218:
    int i;
    label268:
    label380:
    soo localsoo1;
    if (this.mPromotionType == 2)
    {
      this.xu.getLayoutParams().height = ((int)this.mActivity.getResources().getDimension(2131297996));
      if ((!this.blJ) && (!this.blO)) {
        break label568;
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.mContext.getResources().getDimensionPixelSize(2131299627);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (acja)this.app.getManager(56);
      if (localObject != null)
      {
        localObject = ((acja)localObject).a(this.sessionInfo.aTl);
        if ((localObject != null) && (this.bln))
        {
          e((AccountDetail)localObject);
          this.bln = false;
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar = ((PublicMenuBar)this.xt.findViewById(2131373752));
      this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.setOnMenuItemClickListener(new ycn(this));
      this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.SY();
      if (this.blJ) {
        break label613;
      }
      localObject = this.mActivity;
      if (!this.bly) {
        break label606;
      }
      i = 2131692914;
      localObject = new soo("DO_NOT_FOLLOW", ((FragmentActivity)localObject).getString(i), a().getResources().getDrawable(2130842574), 0);
      localsoo1 = new soo("DO_FOLLOW", this.mActivity.getString(2131692911), a().getResources().getDrawable(2130842476), 1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((soo)localObject, 2131560186);
      this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localsoo1, 2131560186);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.setSwitchButtonVisibility(false);
      if (!this.blB) {
        break label768;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(8);
      return;
      if (!this.blJ) {
        break;
      }
      this.xt.findViewById(2131373769).setVisibility(8);
      this.xt.findViewById(2131373755).setVisibility(8);
      break;
      if (!this.blJ) {
        break label218;
      }
      this.xu.getLayoutParams().height = ((int)this.mActivity.getResources().getDimension(2131297996));
      break label218;
      label568:
      localObject = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter();
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.xu);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter((ListAdapter)localObject);
      break label268;
      label606:
      i = 2131692913;
      break label380;
      label613:
      localObject = new soo("DO_CANCEL", this.mActivity.getString(2131691254), a().getResources().getDrawable(2130842574), 0);
      localsoo1 = new soo("DO_FOLLOW", this.mActivity.getString(2131692911), a().getResources().getDrawable(2130842476), 1);
      soo localsoo2 = new soo("DO_NOT_FOLLOW", this.mActivity.getString(2131692914), a().getResources().getDrawable(2130842574), 0);
      this.xy = this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((soo)localObject, 2131560186);
      this.xx = this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localsoo2, 2131560186);
      this.xz = this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localsoo1, 2131560186);
    }
    label768:
    this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(0);
  }
  
  void cgP()
  {
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    if (this.rG != null) {
      this.rG.setVisibility(8);
    }
    if (this.rH != null) {
      this.rH.setVisibility(8);
    }
  }
  
  void cgQ()
  {
    if (this.jdField_e_of_type_Ausj == null)
    {
      this.jdField_e_of_type_Ausj = ((ausj)auss.a(this.mActivity, null));
      this.jdField_e_of_type_Ausj.setMainTitle(acfp.m(2131710227));
      this.jdField_e_of_type_Ausj.addButton(acfp.m(2131710225), 3);
      this.jdField_e_of_type_Ausj.addCancelButton(2131721058);
      this.jdField_e_of_type_Ausj.setOnDismissListener(new ycr(this));
      this.jdField_e_of_type_Ausj.a(new ycs(this));
    }
    if (!this.jdField_e_of_type_Ausj.isShowing())
    {
      this.ach = false;
      this.jdField_e_of_type_Ausj.show();
    }
  }
  
  void cgS()
  {
    if (this.bls) {
      break label7;
    }
    label7:
    label816:
    for (;;)
    {
      return;
      if (this.fs != null)
      {
        Object localObject1 = this.mActivity.getResources();
        this.tT = ((ImageView)this.mAIORootView.findViewById(2131366615));
        if (this.tT != null) {
          this.tT.setContentDescription(this.mActivity.getText(2131698665));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) {
          this.fs.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar);
        }
        if (this.xt != null)
        {
          this.fs.removeView(this.xt);
          this.xt = null;
        }
        if (this.xu != null) {
          this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.xu);
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.fs.findViewById(2131366614));
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null)
        {
          this.mActivity.getLayoutInflater().inflate(2131558684, this.fs);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.fs.findViewById(2131366614));
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) {
            break label816;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_b_of_type_Kaw.aI(oL()));
          if (CustomMenuBar.isDefaultTheme())
          {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.mActivity.getResources().getColor(2131167447));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(wja.dp2px(48.0F, this.mActivity.getResources()));
          }
          if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null)
          {
            Object localObject3 = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
            Object localObject2 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getLayoutParams();
            if ((localObject3 != null) && (localObject2 != null) && ((localObject3 instanceof RelativeLayout.LayoutParams)) && ((localObject2 instanceof RelativeLayout.LayoutParams)))
            {
              localObject3 = (RelativeLayout.LayoutParams)localObject3;
              int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject3).getRules();
              if ((arrayOfInt.length > 2) && (arrayOfInt[2] == 2131369277))
              {
                ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131366614);
                this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131369277);
                this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          if (this.blu)
          {
            localObject1 = new TranslateAnimation(0.0F, 0.0F, wja.dp2px(34.0F, (Resources)localObject1), 0.0F);
            ((TranslateAnimation)localObject1).setDuration(250L);
            ((TranslateAnimation)localObject1).setFillAfter(true);
            ((TranslateAnimation)localObject1).setAnimationListener(new ycw(this));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.startAnimation((Animation)localObject1);
          }
          localObject1 = this.fs.findViewById(2131366613);
          ((View)localObject1).setOnClickListener(new ycx(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject1);
          this.xi = this.fs.findViewById(2131372786);
          cgT();
          localObject1 = this.mActivity.getSharedPreferences("menuEventSharePre", 0);
          if (!((SharedPreferences)localObject1).contains(this.sessionInfo.aTl))
          {
            localObject1 = ((SharedPreferences)localObject1).edit();
            ((SharedPreferences.Editor)localObject1).putInt(this.sessionInfo.aTl, 0);
            ((SharedPreferences.Editor)localObject1).commit();
          }
          this.tT.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new ycy(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new ycz(this));
          localObject1 = this.jdField_b_of_type_Kaw.a(this.app, oL());
          gw((List)localObject1);
          this.jdField_j_of_type_MqqAppNewIntent = this.jdField_b_of_type_Kaw.a(this.mActivity, this.app, oL(), this.jdField_g_of_type_MqqObserverBusinessObserver, false);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            zP(true);
          }
          this.bls = true;
          if (this.jdField_b_of_type_Kcy == null) {
            this.jdField_b_of_type_Kcy = new kcy(this.mContext);
          }
          localObject1 = this.mActivity.getIntent();
          if ((((Intent)localObject1).hasExtra("pub_account_type")) && ("type_ecshop_account".equals(((Intent)localObject1).getStringExtra("pub_account_type"))))
          {
            localObject1 = ((Intent)localObject1).getStringExtra("ecshop_distance_tip");
            localObject1 = this.jdField_b_of_type_Kcy.a((String)localObject1, this);
            this.jdField_b_of_type_Kcy.a(this.fs, (View)localObject1);
            anot.a(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconPv", "Pv_shopnearbyicon", 0, 0, "", "", "", "");
          }
          if ((!Tn()) || (!ahty.anY())) {
            break;
          }
          bIh();
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(this.TAG, 2, "initPublicAccountMenu new qqgame pubaccount return");
          return;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
      }
    }
  }
  
  public void cgV()
  {
    if (this.sessionInfo.cZ == 1008)
    {
      if ((this.mTitleText.getText() != null) && (this.mTitleText.getText().length() < 6)) {
        this.ps.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.ps.setVisibility(8);
  }
  
  public void cgZ()
  {
    ThreadManager.post(new PublicAccountChatPie.46(this), 8, null, true);
  }
  
  public void chb()
  {
    this.xv = LayoutInflater.from(this.mContext).inflate(2131559834, null);
    this.mTimeText = ((TextView)this.xv.findViewById(2131377043));
    if (!this.aca) {
      this.mTimeText.setVisibility(8);
    }
    this.KJ = ((TextView)this.xv.findViewById(2131377036));
    this.uf = ((ImageView)this.xv.findViewById(2131377034));
    this.mProgressBar = ((ProgressBar)this.xv.findViewById(2131377037));
  }
  
  void chc()
  {
    chi();
    this.jdField_a_of_type_Asgx = ((asgx)this.app.getManager(165));
    String str = this.mActivity.getIntent().getStringExtra("uin");
    this.aXi = this.mActivity.getIntent().getStringExtra("qd_wpa_key");
    if (!TextUtils.isEmpty(this.aXi))
    {
      this.aXj = this.mActivity.getIntent().getStringExtra("qd_kfuin");
      this.aXk = this.mActivity.getIntent().getStringExtra("assign_type");
      this.aXl = this.mActivity.getIntent().getStringExtra("assign_key");
      this.aXm = this.mActivity.getIntent().getStringExtra("assign_ext");
      this.aXn = this.mActivity.getIntent().getStringExtra("rkey");
      this.blJ = true;
      this.blK = false;
      this.blL = false;
      this.blM = false;
      this.blN = false;
      this.jdField_g_of_type_ComTencentMobileqqDataMessageForStructing = null;
      this.jdField_a_of_type_Asgx.iM(str, this.aXj);
      return;
    }
    this.aXj = this.jdField_a_of_type_Asgx.qX(str);
    if (!TextUtils.isEmpty(this.aXj))
    {
      this.blJ = true;
      this.blK = true;
      this.aXk = null;
      this.aXl = null;
      this.aXm = null;
      this.aXn = null;
      this.blL = true;
      this.blM = false;
      this.blN = false;
      this.jdField_g_of_type_ComTencentMobileqqDataMessageForStructing = null;
      return;
    }
    this.blJ = false;
    this.blK = false;
    this.aXk = null;
    this.aXl = null;
    this.aXm = null;
    this.aXn = null;
    this.blL = false;
    this.blM = false;
    this.blN = false;
    this.jdField_g_of_type_ComTencentMobileqqDataMessageForStructing = null;
  }
  
  protected void chd()
  {
    this.blJ = false;
    this.blK = false;
    this.aXk = null;
    this.aXl = null;
    this.aXm = null;
    this.aXn = null;
    this.blL = false;
    this.blM = false;
    this.blN = false;
    this.jdField_g_of_type_ComTencentMobileqqDataMessageForStructing = null;
    this.blO = false;
  }
  
  public void che()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "checkQDAccountValid ...");
    }
    ThreadManager.post(new PublicAccountChatPie.52(this), 8, null, false);
  }
  
  public void chf()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder().append("updateHeader ... ");
      if (this.xt == null) {
        break label71;
      }
    }
    label71:
    for (Object localObject = Integer.valueOf(this.xt.getVisibility());; localObject = "")
    {
      QLog.d(str, 2, localObject);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) && (this.blK)) {
        break;
      }
      return;
    }
    if (this.blM)
    {
      this.xy.setVisibility(0);
      this.xx.setVisibility(8);
      return;
    }
    this.xy.setVisibility(8);
    this.xx.setVisibility(0);
  }
  
  public void chg()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "updateWpaUiForQidian: mQidianAccountValid = " + this.blK + ", mQidianKefu = " + this.blL + ", mQidianShield: " + this.blM);
    }
    if (this.blK) {
      if (((acja)this.app.getManager(56)).c(this.sessionInfo.aTl) == null) {
        break label292;
      }
    }
    label292:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.mTitleText.setVisibility(0);
        this.pp.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        cgS();
        return;
      }
      this.mTitleText.setVisibility(0);
      this.pp.setVisibility(0);
      InputLinearLayout localInputLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
      if (this.blM) {
        i = 8;
      }
      for (;;)
      {
        localInputLinearLayout.setVisibility(i);
        if (this.tT == null) {
          this.tT = ((ImageView)this.mAIORootView.findViewById(2131366615));
        }
        this.tT.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        if (this.xt == null)
        {
          if (QLog.isColorLevel()) {
            QZLog.d(this.TAG, 2, "setInitHeader in updateWpaUiForQidian");
          }
          cgO();
        }
        chf();
        return;
        if (this.blL) {
          i = 0;
        } else {
          i = 8;
        }
      }
      this.mTitleText.setVisibility(4);
      this.pp.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void chh()
  {
    if ((!this.blK) || (!this.blN)) {}
    int i;
    do
    {
      return;
      if (((acja)this.app.getManager(56)).c(this.sessionInfo.aTl) != null) {}
      for (i = 1; (this.blM) && (i == 0); i = 0)
      {
        acqn.a(this.app, this.sessionInfo.aTl, this.app.getApp().getResources().getString(2131700370), this.sessionInfo.cZ, false, true);
        return;
      }
      if (this.jdField_g_of_type_ComTencentMobileqqDataMessageForStructing != null)
      {
        this.app.b().b(this.jdField_g_of_type_ComTencentMobileqqDataMessageForStructing, this.app.getCurrentAccountUin());
        this.jdField_g_of_type_ComTencentMobileqqDataMessageForStructing = null;
        return;
      }
    } while ((this.blM) || (i != 0));
  }
  
  public void chi()
  {
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.58(this));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.blt = true;
  }
  
  public void doOnDestroy()
  {
    lcm.a().a(this.sessionInfo.aTl, this.startTime, this.aex, this.jdField_a_of_type_Wki.getList());
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(null);
    }
    if (this.aSY) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "hasDestory = true return");
      }
    }
    for (;;)
    {
      return;
      ocp.bdB();
      if (this.jdField_a_of_type_Ycd$a != null) {}
      try
      {
        this.mContext.unregisterReceiver(this.jdField_a_of_type_Ycd$a);
        label89:
        this.jdField_a_of_type_Ycd$a = null;
        if (this.k != null) {
          kaw.a().b(this.k);
        }
        if (this.jdField_e_of_type_MqqAppNewIntent != null) {
          this.jdField_e_of_type_MqqAppNewIntent.setObserver(null);
        }
        if (this.jdField_a_of_type_Acfd != null)
        {
          this.mActivity.removeObserver(this.jdField_a_of_type_Acfd);
          this.jdField_a_of_type_Acfd = null;
        }
        super.doOnDestroy();
        if (this.jdField_b_of_type_Kaw != null)
        {
          this.jdField_b_of_type_Kaw.lN(oL());
          this.jdField_b_of_type_Kaw.bL(this.mContext);
        }
        Iterator localIterator = this.jdField_a_of_type_Wki.getList().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ChatMessage)localIterator.next();
          if (MessageForStructing.class.isInstance(localObject))
          {
            localObject = ((MessageForStructing)localObject).structingMsg;
            if (StructMsgForGeneralShare.class.isInstance(localObject)) {
              ((StructMsgForGeneralShare)localObject).unInitPay();
            }
          }
        }
        if ((this.mProgress != null) && (this.mProgress.isShowing()))
        {
          this.mProgress.dismiss();
          this.mProgress = null;
        }
        if ((this.aj != null) && (this.aj.isShowing()))
        {
          this.aj.dismiss();
          this.aj = null;
        }
        if (this.mHandler.hasMessages(10)) {
          this.mHandler.removeMessages(10);
        }
        if ((this.U != null) && (this.U.isShowing()))
        {
          this.U.dismiss();
          this.U = null;
        }
        if (this.jdField_a_of_type_Apbk != null) {
          this.jdField_a_of_type_Apbk.unInit();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.cLj();
        }
        cgL();
        cgU();
        if (this.startTime != 0L)
        {
          this.startTime = (System.currentTimeMillis() - this.startTime);
          anot.a(this.app, "dc00899", "Pb_account_lifeservice", "" + this.sessionInfo.aTl, "0X80064D5", "0X80064D5", 0, 0, "", "" + this.startTime, "" + this.bYE, "");
          this.startTime = 0L;
          this.unreadCount = 0;
        }
        if (this.blG) {
          ThreadManager.executeOnSubThread(new PublicAccountChatPie.9(this));
        }
        chd();
        ocp.awm = false;
        try
        {
          if (!To()) {
            continue;
          }
          ArkAppNotifyCenter.unRegistVolumnReceiver();
          ArkAppNotifyCenter.setNotify("com.tencent.gouwu.video", null);
          return;
        }
        catch (Throwable localThrowable) {}
      }
      catch (Exception localException)
      {
        break label89;
      }
    }
  }
  
  public void doOnPause()
  {
    if ((this.app != null) && (this.sessionInfo != null)) {
      ((kdm)this.app.getManager(88)).Yt = this.sessionInfo.aTl;
    }
    super.doOnPause();
    this.jdField_b_of_type_Ahyj.end();
    PublicAccountInfo localPublicAccountInfo = ((acja)this.app.getManager(56)).b(this.sessionInfo.aTl);
    if (localPublicAccountInfo != null) {
      switch (ocp.getAccountType(localPublicAccountInfo.accountFlag))
      {
      }
    }
    for (;;)
    {
      if (To())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "report stay page time tabid is1");
        }
        kee.a(this.app, "gouwu.aio.stay", "1", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.mStartTime + "");
      }
      return;
      adak.a(this.app, this.sessionInfo.aTl, this.bYC, 2, System.currentTimeMillis() - this.mStartTime);
      continue;
      adak.a(this.app, this.sessionInfo.aTl, this.bYC, 3, System.currentTimeMillis() - this.mStartTime);
      continue;
      adak.a(this.app, this.sessionInfo.aTl, this.bYC, 4, System.currentTimeMillis() - this.mStartTime);
    }
  }
  
  public void doOnResume()
  {
    if ((this.bly) && (this.blz)) {
      return;
    }
    this.JL = System.currentTimeMillis();
    try
    {
      ark.arkNotify("com.tencent.weather", "pubaccountPendantRefresh", "", "json");
      super.doOnResume();
      if (!this.blz) {
        ThreadManager.post(new PublicAccountChatPie.50(this), 5, null, false);
      }
      this.blz = true;
      this.mStartTime = System.currentTimeMillis();
      anot.a(null, "dc00898", "", this.sessionInfo.aTl, "auth_aio", "exp", 0, 0, "", "", this.sessionInfo.aTn, "");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        QLog.e(this.TAG, 1, "ark.arkNotify exception:", localUnsatisfiedLinkError);
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    chk();
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    if (!this.ss.isEmpty())
    {
      int i = this.ss.size() - 1;
      anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X8005C35", "0X8005C35", 0, 1, 0, (String)this.ss.get(i), String.valueOf(this.initTime), String.valueOf(l), (String)this.st.get(i));
    }
    if (this.blx)
    {
      if (this.aca) {
        kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X8005D16", "0X8005D16", 0, 0, "new", String.valueOf(l - this.JJ), "", "", false);
      }
    }
    else {
      return;
    }
    kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X8005D16", "0X8005D16", 0, 0, "old", String.valueOf(l - this.JJ), "", "", false);
  }
  
  public void ey(View paramView)
  {
    super.ey(paramView);
    paramView = wja.a(paramView);
    ((wxq)this.jdField_a_of_type_Wvm.a(22)).aC(paramView);
  }
  
  public void fB(View paramView)
  {
    paramView.getLayoutParams().height = 0;
    paramView.requestLayout();
  }
  
  void followPublicAccount()
  {
    QLog.d(this.TAG, 2, "follow");
    Object localObject = (acja)this.app.getManager(56);
    if (localObject != null)
    {
      localObject = ((acja)localObject).a(this.sessionInfo.aTl);
      if ((localObject != null) && (ocp.getAccountType(((AccountDetail)localObject).accountFlag) != -4)) {
        break label212;
      }
      if (this.jdField_e_of_type_MqqAppNewIntent != null) {
        this.jdField_e_of_type_MqqAppNewIntent.setObserver(null);
      }
      this.jdField_e_of_type_MqqAppNewIntent = new NewIntent(this.mActivity.getApplicationContext(), kbs.class);
      this.jdField_e_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
      localObject = new mobileqq_mp.FollowRequest();
      ((mobileqq_mp.FollowRequest)localObject).ext.set("4");
      ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.sessionInfo.aTl));
      this.jdField_e_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
      localObject = new ydg(this);
      this.jdField_e_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
      this.app.startServlet(this.jdField_e_of_type_MqqAppNewIntent);
    }
    for (;;)
    {
      kbp.g(this.app, this.sessionInfo.aTl, 4);
      QLog.d(this.TAG, 2, "follow exit");
      return;
      label212:
      this.app.removeObserver(this.jdField_e_of_type_Adai);
      this.jdField_e_of_type_Adai = new adai(new ydh(this));
      this.app.addObserver(this.jdField_e_of_type_Adai);
      adam.a(this.app, true, this.sessionInfo.aTl, 0);
    }
  }
  
  void gv(List<ChatMessage> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "saveReadedToDB");
    }
    ThreadManager.postImmediately(new PublicAccountChatPie.17(this, paramList), null, false);
  }
  
  void gw(List<mobileqq_mp.ButtonInfo> paramList)
  {
    if ((Tn()) && (ahty.anY())) {
      QLog.d(this.TAG, 2, "updatePublicAccountMenu new qqgame pubaccount return");
    }
    for (;;)
    {
      return;
      if ((To()) && (keo.za()))
      {
        QLog.d(this.TAG, 2, "updatePublicAccountMenu new qqshop pubaccount return");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.SY();
        if (this.sessionInfo != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_b_of_type_Kaw.aI(oL()));
        }
        if ((paramList == null) || (paramList.isEmpty()))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
          }
          if (this.rG != null) {
            this.rG.setVisibility(0);
          }
          if (this.rH != null) {
            this.rH.setVisibility(0);
          }
          if (this.tT != null) {
            this.tT.setVisibility(8);
          }
        }
        else
        {
          if (this.tT != null) {
            this.tT.setVisibility(0);
          }
          Object localObject1;
          if ((paramList != null) && (xki.hN(this.sessionInfo.aTl)))
          {
            localObject1 = new mobileqq_mp.ButtonInfo();
            ((mobileqq_mp.ButtonInfo)localObject1).id.set(0);
            ((mobileqq_mp.ButtonInfo)localObject1).name.set(acfp.m(2131714311));
            ((mobileqq_mp.ButtonInfo)localObject1).event_id.set(1000002);
            ((mobileqq_mp.ButtonInfo)localObject1).type.set(3);
            paramList.add(0, localObject1);
          }
          int n = paramList.size();
          int i = 0;
          while ((i < n) && (i <= 2))
          {
            Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i);
            String str;
            label332:
            label352:
            soo localsoo;
            label395:
            label419:
            mobileqq_mp.ButtonInfo localButtonInfo;
            if (((mobileqq_mp.ButtonInfo)localObject2).key.has())
            {
              localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
              if (!((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
                break label542;
              }
              str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
              if (!((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
                break label549;
              }
              m = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
              localsoo = new soo((String)localObject1, str, null, m);
              localsoo.b((mobileqq_mp.ButtonInfo)localObject2);
              if (!((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
                break label554;
              }
              localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
              if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
                break label579;
              }
              localObject2 = ((List)localObject1).iterator();
              if (!((Iterator)localObject2).hasNext()) {
                break label579;
              }
              localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
              if (!localButtonInfo.key.has()) {
                break label560;
              }
              localObject1 = localButtonInfo.key.get();
              label462:
              if (!localButtonInfo.name.has()) {
                break label567;
              }
              str = localButtonInfo.name.get();
              label483:
              if (!localButtonInfo.id.has()) {
                break label574;
              }
            }
            label542:
            label549:
            label554:
            label560:
            label567:
            label574:
            for (int m = localButtonInfo.id.get();; m = 0)
            {
              localObject1 = new soo((String)localObject1, str, null, m);
              ((soo)localObject1).b(localButtonInfo);
              localsoo.b((soo)localObject1);
              break label419;
              localObject1 = "";
              break;
              str = "";
              break label332;
              m = 0;
              break label352;
              localObject1 = null;
              break label395;
              localObject1 = "";
              break label462;
              str = "";
              break label483;
            }
            label579:
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localsoo, oL());
            i += 1;
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.jdField_a_of_type_Yjh.h(1000, new Object[0]);
      continue;
      if (this.xi != null)
      {
        this.xi.setVisibility(0);
        this.uiHandler.removeMessages(20);
        this.uiHandler.sendEmptyMessageDelayed(20, 10000L);
        continue;
        this.uiHandler.removeMessages(20);
        if ((this.xi != null) && (this.xi.getVisibility() == 0))
        {
          this.xi.setVisibility(8);
          continue;
          k(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
          }
          Object localObject = (acja)this.app.getManager(56);
          if (localObject != null)
          {
            localObject = ((acja)localObject).a(this.sessionInfo.aTl);
            if (localObject != null)
            {
              this.mTitleText.setText(((AccountDetail)localObject).name);
              if (this.bln)
              {
                e((AccountDetail)localObject);
                this.bln = false;
              }
              if (this.ai == null) {}
              cgV();
            }
          }
          if (this.blm)
          {
            this.blm = false;
            if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
              this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.app.getBusinessHandler(11));
            }
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.bb(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            aAt();
            continue;
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.SX();
          }
        }
      }
    }
  }
  
  void k(AbsListView paramAbsListView)
  {
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    int i = paramAbsListView.getFirstVisiblePosition();
    ChatMessage localChatMessage;
    if (i <= paramAbsListView.getLastVisiblePosition())
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_Wki.getItem(i);
      if (localChatMessage != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      String str3;
      long l1;
      try
      {
        String str1;
        if ((!localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("")) && (!localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("true")))
        {
          localArrayList5.add(localChatMessage);
          str3 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
          str1 = str3;
          if (TextUtils.isEmpty(str3)) {
            str1 = "0";
          }
          l1 = Long.parseLong(str1);
          if (localChatMessage.getExtInfoFromExtStr("pa_should_report").equals("true"))
          {
            localArrayList4.add(Long.valueOf(l1));
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "Report message at index: " + String.valueOf(i) + ". MessageId is " + l1);
            }
          }
          localChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
          str3 = localChatMessage.getExtInfoFromExtStr("msg_template_id");
          str1 = str3;
          if (str3 == null) {
            str1 = "";
          }
          kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X80057C4", "0X80057C4", 0, 0, this.sessionInfo.aTl, String.valueOf(l1), str1, "", false);
        }
        if (!localChatMessage.getExtInfoFromExtStr("ad_msgHasRead").equals("false")) {
          continue;
        }
        localChatMessage.saveExtInfoToExtStr("ad_msgHasRead", "true");
        String str4 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
        String str5 = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        str3 = "0";
        String str6 = localChatMessage.getExtInfoFromExtStr("gdt_view_id");
        try
        {
          JSONObject localJSONObject = new JSONObject(str5);
          str1 = str3;
          if (localJSONObject.has("ad_id")) {
            str1 = localJSONObject.getString("ad_id");
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            String str2 = str3;
            if (QLog.isColorLevel())
            {
              QLog.d(this.TAG, 2, " parse ad_id error");
              str2 = str3;
            }
          }
        }
        localArrayList1.add(str4);
        this.st.add(str1);
        localArrayList2.add(str5);
        localArrayList3.add(str6);
        if (localArrayList5.contains(localChatMessage)) {
          continue;
        }
        localArrayList5.add(localChatMessage);
      }
      catch (Exception localException2) {}
      gv(localArrayList5);
      if (!localArrayList4.isEmpty()) {}
      try
      {
        l1 = Long.parseLong(this.sessionInfo.aTl);
        long l2 = Long.parseLong(this.app.getCurrentAccountUin());
        this.jdField_b_of_type_Kaw.a(BaseApplication.getContext(), this.app, 0L, 0L, l1, l2, 2, localArrayList4);
        paramAbsListView = localArrayList5.iterator();
        while (paramAbsListView.hasNext()) {
          if ("1".equals(((ChatMessage)paramAbsListView.next()).getExtInfoFromExtStr("is_AdArrive_Msg")))
          {
            if (this.initTime == -1L) {
              this.initTime = (NetConnInfoCenter.getServerTime() * 1000L);
            }
            this.ss = localArrayList1;
            obl.a(this.app, "", "", this.sessionInfo.aTl, localArrayList2, localArrayList1, localArrayList3);
          }
        }
        return;
      }
      catch (Exception paramAbsListView)
      {
        return;
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
          break label295;
        }
        this.tW.setImageResource(2130850930);
      }
    }
    for (;;)
    {
      if (!this.aSh)
      {
        SpannableString localSpannableString;
        if (this.jdField_g_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.mContext, 2130838169);
          localSpannableString = new SpannableString(acfp.m(2131710233));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_g_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.h == null)
        {
          localObject = new ImageSpan(this.mContext, 2130838463);
          localSpannableString = new SpannableString(acfp.m(2131710229));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.h = localSpannableString;
        }
        if ((QLog.isColorLevel()) && (this.ue != null)) {
          QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.ue.getVisibility());
        }
        if (paramInt2 != 2) {
          break;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (wir.w(this.app))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.yI(false);
        }
      }
      return;
      label295:
      this.tW.setImageResource(2130850852);
      continue;
      if (this.tW != null) {
        if (CustomMenuBar.isDefaultTheme()) {
          this.tW.setImageResource(2130850929);
        } else {
          this.tW.setImageResource(2130850851);
        }
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject).setSelected(bool);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
        break;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131691441);
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
  }
  
  public void oh(int paramInt)
  {
    Toast.makeText(this.mActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  public boolean onBackEvent()
  {
    try
    {
      if ((To()) && (a() != null)) {
        a().sendBroadcast(new Intent("com.tencent.biz.pubaccount.ecshop.tabpage.finish"));
      }
      label31:
      return super.onBackEvent();
    }
    catch (Throwable localThrowable)
    {
      break label31;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366615) {
      zP(true);
    }
    if (2131369594 == paramView.getId())
    {
      anot.a(this.app, "CliOper", "", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
      anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
      aqiy.bk(null, "pubAcc_profile_display", "");
    }
    if (paramView.getId() == 2131367817)
    {
      long l1 = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.ue != null)) {
        QLog.d(this.TAG, 2, " onClick fun_btn start mInputStat = " + this.bEl + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.ue.getVisibility() + " currentPanel:" + this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() + " currenttime:" + System.currentTimeMillis());
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 2) && (this.ue != null) && (this.ue.getVisibility() != 0))
      {
        send();
        if (xki.hN(this.sessionInfo.aTl))
        {
          if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 1) && (((InputMethodManager)this.mContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))) {
            this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
          }
          abcx.a().E(this.app, "aio_search_push");
        }
      }
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, " onClick fun_btn end mInputStat = " + this.bEl + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
        }
        kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800584F", "0X800584F", 0, 0, "", "", "", "", false);
      }
    }
    if ((paramView.getId() == 2131366307) && (this.bEl != 1))
    {
      if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 3) {
        break label899;
      }
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
      anot.a(this.app, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      if (this.tW != null) {
        this.tW.setContentDescription(this.app.getApplication().getString(2131690205));
      }
    }
    if (paramView.getId() == 2131373427)
    {
      ShortVideoUtils.B(this.app);
      if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 8)
      {
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
    }
    else
    {
      label643:
      if (paramView.getId() == 2131363082)
      {
        if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 2) {
          break label1032;
        }
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
        if (this.ue != null)
        {
          this.ue.setImageResource(this.bYu);
          this.ue.setContentDescription(this.app.getApp().getString(2131690224));
        }
      }
      label710:
      if (paramView.getId() == 2131372043) {
        hideSoftInput();
      }
      if (this.blB) {}
      switch (paramView.getId())
      {
      default: 
        label776:
        if ((this.blx) && (paramView.getId() == 2131367817)) {
          anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X8005C9C", "0X8005C9C", 0, 1, 0, "", "", "", "");
        }
        if (((paramView.getTag() instanceof String)) && (kcy.Ya.equals((String)paramView.getTag())) && (this.mContext != null) && (!TextUtils.isEmpty(this.sessionInfo.aTl))) {
          if (System.currentTimeMillis() - this.JK >= 1000L) {
            break;
          }
        }
        break;
      }
    }
    label899:
    label1032:
    Object localObject1;
    Object localObject2;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(3);
      if ((this.ue != null) && (this.ue.getVisibility() == 0)) {
        zQ(false);
      }
      anot.a(this.app, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      bHS();
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(8);
      if ((this.ue != null) && (this.ue.getVisibility() == 0)) {
        zQ(false);
      }
      if (this.tW != null) {
        this.tW.setContentDescription(this.app.getApplication().getString(2131690110));
      }
      Aa(0);
      break label643;
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(2);
      if (this.ue == null) {
        break label710;
      }
      this.ue.setImageResource(this.bYv);
      this.ue.setContentDescription(this.app.getApp().getString(2131690223));
      break label710;
      anot.a(null, "dc00898", "", this.sessionInfo.aTl, "auth_aio", "clk_return", 0, 0, "", "", this.sessionInfo.aTn, "");
      break label776;
      this.JK = System.currentTimeMillis();
      localObject1 = new StringBuilder("https://gouwu.qq.com/m/html/shop_map.html?_wv=1027&shop_uin=");
      ((StringBuilder)localObject1).append(this.sessionInfo.aTl);
      localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", ((StringBuilder)localObject1).toString());
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
      this.mContext.startActivity((Intent)localObject2);
      anot.a(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconClk", "Clk_shopnearbyicon", 0, 0, "", "", "", "");
      if (paramView.getId() != 2131369588) {
        break label1416;
      }
      localObject1 = (acff)this.app.getManager(51);
      if (!nyn.i(this.app, this.sessionInfo.aTl)) {
        break label1416;
      }
      localObject2 = (String)kdm.da.get(this.sessionInfo.aTl);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Intent localIntent = new Intent(this.mContext, SplashActivity.class);
    localIntent.putExtra("uin", (String)localObject2);
    localIntent = wja.a(localIntent, null);
    if (((acff)localObject1).isFriend((String)localObject2)) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      this.mContext.startActivity(localIntent);
      anot.a(this.app, "CliOper", "", "", "Shop_customservice", "Clk_shopcustomservice", 0, 0, "", "", this.sessionInfo.aTl, this.app.getCurrentAccountUin());
      label1416:
      super.onClick(paramView);
      break;
      localIntent.putExtra("uintype", 1005);
      localIntent.putExtra("uinname", this.sessionInfo.aTn + acfp.m(2131710222));
      localIntent.putExtra("key_sub_title_from", "来自\"QQ咨询\"");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    ((wxq)this.jdField_a_of_type_Wvm.a(22)).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    l(paramAbsListView);
    if ((this.blJ) || (this.blO)) {}
    label273:
    label275:
    int i;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((this.xt != null) && (this.xu != null) && (this.bYs != 5))
          {
            if (this.bYt > paramInt3)
            {
              this.bYs = 4;
              this.bYt = paramInt3;
              switch (this.bYs)
              {
              }
            }
            for (;;)
            {
              if ((!this.blr) && (!this.blq)) {
                break label273;
              }
              if ((!this.blE) || (this.blq)) {
                break label275;
              }
              this.blE = false;
              return;
              if (this.bYt >= paramInt3) {
                break;
              }
              this.bYs = 3;
              break;
              if ((paramInt3 > paramInt2) && (!this.blr))
              {
                this.mCoverHeight = this.xu.getLayoutParams().height;
                fB(this.xu);
                this.blr = true;
              }
              this.bYs = 2;
              this.blE = true;
              continue;
              if ((paramInt3 == paramInt2) && (this.blr))
              {
                if (this.mCoverHeight != 0) {
                  W(this.xu, this.mCoverHeight);
                }
                this.blr = false;
                this.blq = true;
              }
              this.bYs = 2;
              this.blE = true;
            }
          }
        }
        if (this.xt.getHeight() != 0) {
          this.mCoverHeight = this.xt.getHeight();
        }
        i = this.mScrollY - wF();
        this.mScrollY = wF();
        if (this.bYD * i < 0)
        {
          this.bYD = i;
          return;
        }
        this.bYD = i;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "Move = " + String.valueOf(i));
        }
        switch (this.bYr)
        {
        default: 
          return;
        }
      } while (((i <= 5) || (!this.blD)) && ((paramInt1 != this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()) || (i <= 0) || (!this.blD) || (this.blp)));
      this.blp = true;
      paramAbsListView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.mCoverHeight);
      paramAbsListView.setFillAfter(true);
      paramAbsListView.setDuration(250L);
      paramAbsListView.setAnimationListener(new yck(this));
      this.xt.startAnimation(paramAbsListView);
      return;
    } while (((i >= -5) || (!this.blD)) && (((!this.blq) && ((paramInt1 + paramInt2 != paramInt3) || (i >= 0) || (!this.blD))) || (this.blp)));
    this.blp = true;
    paramAbsListView = new TranslateAnimation(0.0F, 0.0F, -this.mCoverHeight, 0.0F);
    paramAbsListView.setFillAfter(true);
    paramAbsListView.setDuration(250L);
    paramAbsListView.setAnimationListener(new ycl(this));
    this.xt.startAnimation(paramAbsListView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      this.uiHandler.sendEmptyMessage(37);
      jss.a().eg(500L);
    }
    ((wxq)this.jdField_a_of_type_Wvm.a(22)).onScrollStateChanged(paramAbsListView, paramInt);
  }
  
  public void onShow()
  {
    if ((this.blw) && (oan.a().c(this.app, this.sessionInfo.aTl) > 0)) {
      oan.a().l(this.app, this.sessionInfo.aTl);
    }
    super.onShow();
    if (xki.hN(this.sessionInfo.aTl))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.app.getBusinessHandler(11));
      }
      if (!this.bL.get())
      {
        this.bL.set(true);
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.mActivity, 2, null);
      }
    }
    for (;;)
    {
      kdm localkdm = (kdm)this.app.getManager(88);
      if ((localkdm != null) && (localkdm.dr(this.sessionInfo.aTl))) {
        ThreadManager.post(new PublicAccountChatPie.3(this), 5, null, true);
      }
      l(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      jss.a().eg(1000L);
      return;
      if (("3026775809".equals(this.sessionInfo.aTl)) && (Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.app.getApplication().getApplicationContext().getSystemService("sensor")).getDefaultSensor(19) != null)) {
        ((aqtz)this.app.getManager(260)).VI("public account");
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.blD = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void refresh(int paramInt)
  {
    int i = 0xFFFF0000 & paramInt;
    super.refresh(paramInt);
    if ((this.sessionInfo == null) || (this.sessionInfo.aTl == null)) {
      return;
    }
    List localList = this.app.b().f(this.sessionInfo.aTl, this.sessionInfo.cZ);
    if (((i == 196608) || (i == 131072)) && (localList.size() > 0))
    {
      i = 0;
      int n = localList.size() - 1;
      if (n >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(n);
        int m = i;
        if (i == 0)
        {
          if ((this.og == 9223372036854775807L) || (localChatMessage.uniseq == this.og)) {
            i = 1;
          }
          m = i;
          if (this.og == 9223372036854775807L) {}
        }
        for (;;)
        {
          n -= 1;
          break;
          if (m != 0) {
            break label174;
          }
          i = m;
        }
        label174:
        if (((localChatMessage instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.aZ(localChatMessage)) || (StructLongMessageDownloadProcessor.bb(localChatMessage))))
        {
          String str = localChatMessage.getExtInfoFromExtStr("longMsg_State");
          if ((str == null) || (!String.valueOf(3).equals(str))) {
            break label239;
          }
        }
        for (;;)
        {
          this.og = localChatMessage.uniseq;
          i = m;
          break;
          label239:
          localChatMessage.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
          StructLongMessageDownloadProcessor.m(this.app, (MessageForStructing)localChatMessage);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "REFRESH_FLAG_RELOAD  to load long message");
      }
    }
    if (paramInt != 131072) {
      this.uiHandler.sendEmptyMessage(20);
    }
    this.uiHandler.sendEmptyMessage(37);
  }
  
  public void showLoading(int paramInt)
  {
    if (this.mProgress == null) {
      this.mProgress = new arhz(this.fs.getContext(), this.mActivity.getTitleBarHeight());
    }
    if ((!this.mActivity.isFinishing()) && (this.mProgress != null))
    {
      this.mProgress.setMessage(paramInt);
      if (!this.mProgress.isShowing()) {
        this.mProgress.show();
      }
    }
  }
  
  public void tT(int paramInt)
  {
    try
    {
      this.uf.setVisibility(0);
      this.KJ.setVisibility(0);
      this.mProgressBar.setVisibility(8);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.mHandler.sendEmptyMessage(7);
        return;
        this.KJ.setText(2131720486);
        continue;
        this.KJ.setText(2131720480);
        continue;
        this.KJ.setText(2131697434);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageRecord))
    {
      localObject = ((MessageRecord)paramObject).getExtInfoFromExtStr("welcome_msg");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("true"))) {
        ThreadManager.post(new PublicAccountChatPie.44(this), 8, null, false);
      }
      this.blG = true;
    }
    if ((awit.cA(this.app)) && ((paramObject instanceof MessageRecord))) {
      ((KandianMergeManager)this.app.getManager(162)).mN(this.sessionInfo.aTl);
    }
    super.update(paramObservable, paramObject);
    int i;
    if ((paramObservable instanceof apbk)) {
      if ((paramObject instanceof Integer))
      {
        i = ((Integer)paramObject).intValue();
        if (i != 0) {
          break label153;
        }
        this.jdField_a_of_type_Apbk.em(this.app);
        this.jdField_a_of_type_Apbk.dYz();
      }
    }
    label148:
    label152:
    label153:
    do
    {
      break label152;
      break label152;
      break label152;
      break label152;
      cgK();
      for (;;)
      {
        return;
        if (i != 1) {
          break label148;
        }
        this.bly = true;
        break label148;
        if ((paramObservable instanceof QQMessageFacade))
        {
          if (this.jdField_a_of_type_Apbk == null) {
            break;
          }
          paramObject = (TroopManager)this.mActivity.app.getManager(52);
          paramObservable = ((QQMessageFacade)paramObservable).a();
          if (paramObservable == null) {
            break;
          }
          paramObservable = paramObject.c(paramObservable.frienduin);
          if (paramObservable == null) {
            break;
          }
          try
          {
            if (paramObservable.associatePubAccount == Long.valueOf(this.sessionInfo.aTl).longValue())
            {
              paramObject = Message.obtain();
              paramObject.what = 9;
              localObject = new Bundle();
              ((Bundle)localObject).putString("troopUin", paramObservable.troopuin);
              paramObject.setData((Bundle)localObject);
              this.mHandler.sendMessage(paramObject);
              return;
            }
          }
          catch (NumberFormatException paramObservable)
          {
            QLog.d(this.TAG, 2, "exception: sessionInfo curFriendUin is not a long type.");
            return;
          }
        }
      }
    } while (!this.blx);
    ThreadManager.post(new PublicAccountChatPie.45(this), 5, null, false);
  }
  
  public void vW(boolean paramBoolean)
  {
    try
    {
      if ((To()) && (a() != null)) {
        a().sendBroadcast(new Intent("com.tencent.biz.pubaccount.ecshop.tabpage.finish"));
      }
      label31:
      super.vW(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label31;
    }
  }
  
  public void vY(boolean paramBoolean)
  {
    if (this.blx)
    {
      if (paramBoolean)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
        {
          if (this.xv == null) {
            chb();
          }
          this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.xv);
        }
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
      return;
    }
    super.vY(paramBoolean);
  }
  
  public int wF()
  {
    int i = 0;
    View localView = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((this.xw != null) && (localView != this.xw))
    {
      this.mScrollY = 0;
      this.xw = localView;
      return 0;
    }
    if (localView != null) {
      i = -localView.getTop();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "ScrollY: " + String.valueOf(i) + "  OldScrollY: " + String.valueOf(this.mScrollY));
    }
    this.xw = localView;
    return i;
  }
  
  public void yx(String paramString)
  {
    boolean bool = true;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_b_of_type_Kcy != null) && (this.mActivity != null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppSchemeCenter", 2, "args:" + paramString);
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.getJSONObject("bidInfo");
      if (((JSONObject)localObject).optInt("isshow", 0) == 1) {}
      for (;;)
      {
        String str = ((JSONObject)localObject).getString("icon");
        localObject = ((JSONObject)localObject).getString("url");
        int i = paramString.getInt("bid");
        int m = paramString.getInt("cid");
        int n = paramString.getInt("web");
        this.mActivity.runOnUiThread(new PublicAccountChatPie.57(this, bool, str, (String)localObject, i, m, n));
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void zP(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(4);
      }
      if (this.rG != null) {
        this.rG.setVisibility(4);
      }
      if (this.rH != null) {
        this.rH.setVisibility(4);
      }
      bIi();
    }
  }
  
  protected void zQ(boolean paramBoolean)
  {
    int m = 8;
    if (this.ue == null) {
      return;
    }
    this.ue.clearAnimation();
    Object localObject = this.ue;
    if (paramBoolean)
    {
      i = 0;
      label30:
      ((ImageView)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      i = m;
      if (!paramBoolean) {
        i = 0;
      }
      ((XEditTextEx)localObject).setVisibility(i);
      if (this.aSi)
      {
        localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
        if (!paramBoolean) {
          break label162;
        }
      }
    }
    label162:
    for (int i = 4;; i = 0)
    {
      ((PatchedButton)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      if (this.jdField_g_of_type_AndroidTextSpannableString == null)
      {
        localObject = new ImageSpan(this.mContext, 2130838169);
        SpannableString localSpannableString = new SpannableString(acfp.m(2131710218));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_g_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_g_of_type_AndroidTextSpannableString);
      return;
      i = 8;
      break label30;
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
        ycd.a(ycd.this, 1);
      }
      while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
        return;
      }
      ycd.a(ycd.this, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycd
 * JD-Core Version:    0.7.0.1
 */