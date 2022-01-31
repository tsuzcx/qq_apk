package com.tencent.token.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.TabActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.bb;
import com.tencent.token.bd;
import com.tencent.token.bj;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.bean.h;
import com.tencent.token.fo;
import com.tencent.token.fp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.r;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.ui.base.GameLoginSndConfirmDialog;
import com.tencent.token.ui.base.ProDialog;
import com.tencent.token.ui.base.ProDialogWithShutDown;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.SlidingMenuView;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;
import com.tencent.token.utils.k;
import com.tencent.token.utils.q;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import com.tencent.token.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class IndexActivity
  extends TabActivity
  implements acn
{
  public static final String ACTION_OPEN_MENU = "com.tencent.token.open_menu";
  public static final String ACTION_REFRESH_MENU = "com.tencent.token.refresh_menu";
  public static boolean CAM_ERR = false;
  private static final String KEY_INDEX = "index";
  public static final int K_FROM_ACCOUNTDETAIL_TO_ACCOUNT = 21;
  public static final int K_FROM_ACCOUNTDETAIL_TO_VERIFY = 22;
  public static final int K_FROM_ACCOUNTMANAGE = 16;
  public static final int K_FROM_COVER_INSTALL = 17;
  public static final int K_FROM_FINDPWD_TO_MODPWD = 25;
  public static final int K_FROM_NORMAL = 20;
  public static final int K_FROM_OTHER_APP_TO_VERIFY = 23;
  public static final int K_FROM_PUSH = 19;
  public static final int K_FROM_SND_CONFIRM_PUSH = 24;
  public static final int K_FROM_WIDGET = 18;
  private static final int MAX_TAB_SIZE = 3;
  private static final String PREFER_INDEX_INFO = "token_index_info";
  public static float S_DENSITY;
  public static boolean S_INIT = false;
  public static int S_RES_HEIGHT;
  public static int S_RES_WIDTH;
  public static int S_STATUS_HEIGHT;
  public static int S_TAB_HEIGHT;
  public static int S_TITLE_HEIGHT;
  public static boolean hasReadUtils = false;
  public static boolean isShowAccountTip = false;
  public static boolean isShowUtilsTip = false;
  public static boolean s_FromOtherApp;
  public static boolean s_FromPush;
  private static int s_FromPushOrWidget;
  public static boolean s_ShowGameLoginPushInfo;
  private final int ACCOUNT_PAGE_INDEX = 0;
  private final int DLG_BIND_UIN = 2;
  private final int DLG_NO_MSG = 4;
  private final int DLG_PROGRESS = 5;
  private final int DLG_TO_VERIFY = 1;
  private final int DLG_UNBIND = 6;
  private final int DLG_UPDATE_REMIND = 3;
  private final int MORE_PAGE_INDEX = 2;
  private final int TOKEN_PAGE_INDEX = 1;
  private boolean autoStartModPwdActivity = false;
  private Handler.Callback callback = new lp(this);
  RelativeLayout center;
  QQUser curruser;
  private ImageView img_head_border_center;
  private ImageView img_head_border_left;
  private ImageView img_head_border_right;
  RelativeLayout left;
  private View.OnClickListener listener = new mo(this);
  private ImageView mAccountTipImage;
  private byte[] mAqSig;
  private UserTask mAutoGetDualMsgTask;
  private Toast mDefaultToast;
  private Dialog mDialog;
  private DualMsgShowDialog mDualMsgShowDialog = null;
  private long mDualVerifyUin;
  private boolean mFirstOpenApp = true;
  private Handler mHandler = new mb(this);
  private int mIndex = 1;
  ConfigResult mLocalConfig = new ConfigResult();
  private ProDialog mProDialog;
  private ProDialogWithShutDown mProDialogWithShutDown;
  private RoundImageView mQQFaceCenter;
  private RoundImageView mQQFaceLeft;
  private RoundImageView mQQFaceRight;
  private ImageView mQQFace_zzbCenter;
  private ImageView mQQFace_zzbLeft;
  private ImageView mQQFace_zzbRight;
  private Dialog mQryBindNotifyMsgDialog;
  private boolean mQueryingDualMsg = false;
  private BroadcastReceiver mReceiver = new mm(this);
  private ImageView mSettingTipImage;
  private TabHost mTabHost;
  private ImageView[] mTabIcon = new ImageView[3];
  private TabHost.OnTabChangeListener mTabSelectionListener = new lt(this);
  private TabWidget mTabWidget;
  private int mTabWidth;
  private Toast mToast;
  private Dialog mUpdateDialog;
  private ImageView mUtilTipImage;
  private boolean needgotologobyprotect;
  TextView nickname;
  private TextView qqface_not_verify_center;
  private TextView qqface_not_verify_left;
  private TextView qqface_not_verify_right;
  TextView qqnum;
  RelativeLayout right;
  private TextView setpasstext;
  SlidingMenuView slidingMenuView;
  TextView tip;
  Button unbind;
  Button verify;
  
  static
  {
    CAM_ERR = false;
    s_FromPush = false;
    s_FromOtherApp = false;
    s_ShowGameLoginPushInfo = false;
    s_FromPushOrWidget = 20;
  }
  
  private void autoQueryDualMsg()
  {
    if (this.mQueryingDualMsg) {}
    do
    {
      return;
      this.mQueryingDualMsg = true;
      this.mAutoGetDualMsgTask = new lq(this);
      this.mAutoGetDualMsgTask.a(new String[] { "" });
    } while (!s_FromOtherApp);
    showUserDialog(5);
  }
  
  private void cancelAutoTask()
  {
    if ((this.mAutoGetDualMsgTask != null) && (this.mAutoGetDualMsgTask.c() != UserTask.Status.FINISHED))
    {
      this.mAutoGetDualMsgTask.d();
      this.mAutoGetDualMsgTask = null;
    }
  }
  
  private void computeTabLayout()
  {
    this.mTabWidth = (getWindowManager().getDefaultDisplay().getWidth() / 3);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    S_DENSITY = localDisplayMetrics.density;
    S_RES_WIDTH = localDisplayMetrics.widthPixels;
    int i = localDisplayMetrics.heightPixels;
    S_RES_HEIGHT = i;
    S_TAB_HEIGHT = i / 10;
    S_TITLE_HEIGHT = S_RES_HEIGHT / 12;
    if (b.h()) {
      S_TAB_HEIGHT = S_RES_HEIGHT / 8;
    }
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      S_STATUS_HEIGHT = getResources().getDimensionPixelSize(i);
      e.a("screen para:  height=" + getWindowManager().getDefaultDisplay().getHeight() + ", width=" + getWindowManager().getDefaultDisplay().getWidth() + ", density=" + S_DENSITY + ", densitydpi=" + localDisplayMetrics.densityDpi + ", statusbar=" + S_STATUS_HEIGHT + ", tabbar=" + S_TAB_HEIGHT);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        S_STATUS_HEIGHT = (int)getResources().getDimension(2131230743);
      }
    }
  }
  
  private void deleteUser(QQUser paramQQUser)
  {
    try
    {
      x.a(RqdApplication.i()).a(paramQQUser.mRealUin + "", 523005419L);
      x.a(RqdApplication.i()).a(paramQQUser.mRealUin + "", 523005425L);
      af.a().h(paramQQUser.mRealUin, this.mHandler);
      ax.a().b(paramQQUser);
      bd.a().f.a(s.f(paramQQUser.mUin));
      bb.a().f.a(s.f(paramQQUser.mUin));
      bd.a().f.a(s.f(paramQQUser.mRealUin));
      bb.a().f.a(s.f(paramQQUser.mRealUin));
      AccountPageActivity.mNeedRefreshEval = true;
      SettingPageActivity.mNeedRefreshMbInfo = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        e.c("clearUserLoginDataSync exception: " + localException.getMessage());
        localException.printStackTrace();
      }
    }
  }
  
  private void dismissDualDialog()
  {
    if (this.mDualMsgShowDialog != null)
    {
      if (this.mDualMsgShowDialog.isShowing()) {
        this.mDualMsgShowDialog.cancel();
      }
      this.mDualMsgShowDialog.b();
      this.mDualMsgShowDialog = null;
    }
  }
  
  private void doClickEvent(QQUser paramQQUser)
  {
    if (paramQQUser == null)
    {
      this.slidingMenuView.a(1);
      paramQQUser = new Intent(this, WtLoginAccountInput.class);
      paramQQUser.putExtra("page_id", 4);
      startActivity(paramQQUser);
    }
    while ((paramQQUser.equals(this.curruser)) || (paramQQUser == null)) {
      return;
    }
    ax.a().a(paramQQUser.mUin);
    AccountPageActivity.mNeedRefreshEval = true;
    SettingPageActivity.mNeedRefreshMbInfo = true;
    this.slidingMenuView.a(1);
    paramQQUser = new Intent(this, IndexActivity.class);
    paramQQUser.putExtra("index_from", 16);
    startActivity(paramQQUser);
    remsumeMenu();
  }
  
  private View getTabView(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      return null;
    }
    Object localObject2 = getResources();
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    Object localObject1 = new StateListDrawable();
    Drawable localDrawable = ((Resources)localObject2).getDrawable(new int[] { 2130837942, 2130837946, 2130837944 }[paramInt]);
    ((StateListDrawable)localObject1).addState(new int[] { -16842913 }, localDrawable);
    localObject2 = ((Resources)localObject2).getDrawable(new int[] { 2130837943, 2130837947, 2130837945 }[paramInt]);
    ((StateListDrawable)localObject1).addState(new int[] { 16842913 }, (Drawable)localObject2);
    this.mTabIcon[paramInt] = new ImageView(this);
    this.mTabIcon[paramInt].setImageDrawable((Drawable)localObject1);
    int i = (int)(S_TAB_HEIGHT * 0.5D);
    localObject1 = new LinearLayout.LayoutParams(i, i);
    localLinearLayout.addView(this.mTabIcon[paramInt], (ViewGroup.LayoutParams)localObject1);
    return localLinearLayout;
  }
  
  private void goToWtLoginAccountInput()
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {
      return;
    }
    Intent localIntent = new Intent(this, WtLoginAccountInput.class);
    localIntent.putExtra("page_id", 7);
    localIntent.putExtra("intent.uin", localQQUser.mRealUin);
    startActivity(localIntent);
  }
  
  private void gotoVerify()
  {
    String str = "" + this.curruser.mRealUin;
    x localx = x.a(RqdApplication.i());
    if (!localx.b(str, 523005425L))
    {
      localx.a(str, this.mHandler, 523005425L);
      showProDialog(this, 2131361808, 2131361817, null);
      return;
    }
    showUserDialog(2131362364, getResources().getString(2131362365), 2131361800, new mn(this));
  }
  
  private void gotologobyprotect()
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {
      return;
    }
    Intent localIntent = new Intent(this, WtLoginAccountInput.class);
    localIntent.putExtra("page_id", 9);
    localIntent.putExtra("intent.uin", localQQUser.mRealUin);
    startActivity(localIntent);
  }
  
  private void initFaceCenter()
  {
    if (this.curruser != null)
    {
      this.mQQFaceCenter.setImageDrawable(k.a(this.curruser.mRealUin + "", this.curruser.mUin + ""));
      if (this.curruser.mIsBinded) {
        this.qqface_not_verify_center.setVisibility(4);
      }
      while (this.curruser.mIsZzb)
      {
        this.img_head_border_center.setImageDrawable(getResources().getDrawable(2130838024));
        this.img_head_border_center.setVisibility(0);
        this.mQQFace_zzbCenter.setVisibility(0);
        return;
        this.qqface_not_verify_center.setVisibility(0);
      }
      this.img_head_border_center.setImageDrawable(getResources().getDrawable(2130837522));
      this.mQQFace_zzbCenter.setVisibility(4);
      return;
    }
    this.mQQFaceCenter.setImageResource(2130837530);
    this.img_head_border_center.setVisibility(8);
    this.mQQFace_zzbCenter.setVisibility(8);
    this.qqface_not_verify_center.setVisibility(8);
  }
  
  private void initFaceLeft(QQUser paramQQUser)
  {
    if (paramQQUser != null)
    {
      this.mQQFaceLeft.setVisibility(0);
      this.mQQFaceLeft.setImageDrawable(k.a(paramQQUser.mRealUin + "", paramQQUser.mUin + ""));
      if (paramQQUser.mIsBinded) {
        this.qqface_not_verify_left.setVisibility(4);
      }
      while (paramQQUser.mIsZzb)
      {
        this.img_head_border_left.setImageDrawable(getResources().getDrawable(2130838024));
        this.img_head_border_left.setVisibility(0);
        this.mQQFace_zzbLeft.setVisibility(0);
        return;
        this.qqface_not_verify_left.setVisibility(0);
      }
      this.img_head_border_left.setImageDrawable(getResources().getDrawable(2130837522));
      this.mQQFace_zzbLeft.setVisibility(4);
      return;
    }
    this.mQQFaceLeft.setImageResource(2130837530);
    this.img_head_border_left.setVisibility(8);
    this.mQQFace_zzbLeft.setVisibility(8);
    this.qqface_not_verify_left.setVisibility(8);
  }
  
  private void initFaceRight(QQUser paramQQUser)
  {
    if (paramQQUser != null)
    {
      this.mQQFaceRight.setVisibility(0);
      this.mQQFaceRight.setImageDrawable(k.a(paramQQUser.mRealUin + "", paramQQUser.mUin + ""));
      if (paramQQUser.mIsBinded) {
        this.qqface_not_verify_right.setVisibility(4);
      }
      while (paramQQUser.mIsZzb)
      {
        this.img_head_border_right.setImageDrawable(getResources().getDrawable(2130838024));
        this.img_head_border_right.setVisibility(0);
        this.mQQFace_zzbRight.setVisibility(0);
        return;
        this.qqface_not_verify_right.setVisibility(0);
      }
      this.img_head_border_right.setImageDrawable(getResources().getDrawable(2130837522));
      this.mQQFace_zzbRight.setVisibility(4);
      return;
    }
    this.img_head_border_right.setVisibility(8);
    this.mQQFaceRight.setImageResource(2130837530);
    this.mQQFace_zzbRight.setVisibility(8);
    this.qqface_not_verify_right.setVisibility(8);
  }
  
  private void initMenu()
  {
    ((RelativeLayout)this.slidingMenuView.findViewById(2131296342)).setOnClickListener(this.listener);
    ((RelativeLayout)this.slidingMenuView.findViewById(2131296341)).setOnClickListener(this.listener);
    ((RelativeLayout)this.slidingMenuView.findViewById(2131296339)).setOnClickListener(this.listener);
    ((RelativeLayout)this.slidingMenuView.findViewById(2131296338)).setOnClickListener(this.listener);
    ((RelativeLayout)this.slidingMenuView.findViewById(2131296335)).setOnClickListener(this.listener);
    this.setpasstext = ((TextView)this.slidingMenuView.findViewById(2131296337));
    TextView localTextView = (TextView)this.slidingMenuView.findViewById(2131296340);
    Object localObject = q.b;
    try
    {
      String str = getPackageManager().getPackageInfo(getPackageName(), 16384).versionName;
      localObject = str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        e.c(localNameNotFoundException.getMessage());
      }
    }
    localTextView.setText("V" + (String)localObject);
    this.tip = ((TextView)this.slidingMenuView.findViewById(2131296333));
    this.nickname = ((TextView)this.slidingMenuView.findViewById(2131296330));
    this.qqnum = ((TextView)this.slidingMenuView.findViewById(2131296331));
    this.unbind = ((Button)this.slidingMenuView.findViewById(2131296343));
    this.center = ((RelativeLayout)this.slidingMenuView.findViewById(2131296320));
    this.left = ((RelativeLayout)this.slidingMenuView.findViewById(2131296315));
    this.right = ((RelativeLayout)this.slidingMenuView.findViewById(2131296325));
    this.mQQFaceCenter = ((RoundImageView)this.slidingMenuView.findViewById(2131296321));
    this.mQQFaceLeft = ((RoundImageView)this.slidingMenuView.findViewById(2131296316));
    this.mQQFaceRight = ((RoundImageView)this.slidingMenuView.findViewById(2131296326));
    this.mQQFace_zzbCenter = ((ImageView)this.slidingMenuView.findViewById(2131296323));
    this.mQQFace_zzbLeft = ((ImageView)this.slidingMenuView.findViewById(2131296318));
    this.mQQFace_zzbRight = ((ImageView)this.slidingMenuView.findViewById(2131296328));
    this.img_head_border_center = ((ImageView)this.slidingMenuView.findViewById(2131296322));
    this.img_head_border_left = ((ImageView)this.slidingMenuView.findViewById(2131296317));
    this.img_head_border_right = ((ImageView)this.slidingMenuView.findViewById(2131296327));
    this.qqface_not_verify_right = ((TextView)this.slidingMenuView.findViewById(2131296329));
    this.qqface_not_verify_center = ((TextView)this.slidingMenuView.findViewById(2131296324));
    this.qqface_not_verify_left = ((TextView)this.slidingMenuView.findViewById(2131296319));
    this.verify = ((Button)this.slidingMenuView.findViewById(2131296334));
  }
  
  private boolean isNeedReportDnsInfo()
  {
    long l1 = t.d() * 1000L;
    long l2 = System.currentTimeMillis();
    Date localDate = new Date();
    Calendar localCalendar = Calendar.getInstance();
    localDate.setTime(l1);
    localCalendar.setTime(localDate);
    localCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    int i = localCalendar.get(1);
    int j = localCalendar.get(6);
    localDate.setTime(l2);
    localCalendar.setTime(localDate);
    localCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    int k = localCalendar.get(1);
    int m = localCalendar.get(6);
    if ((k > i) || ((k == i) && (m >= j + 1)))
    {
      e.a("report dns info need, time=" + l1 + ", current=" + l2);
      return true;
    }
    e.a("report dns info needn't, time=" + l1 + ", current=" + l2);
    return false;
  }
  
  private void queryUpdateInfo()
  {
    if (h.b().c()) {
      new ls(this).a(new String[] { "" });
    }
    while (!h.b().a()) {
      return;
    }
    showUserDialog(3);
  }
  
  private void refreshTab(int paramInt)
  {
    this.mIndex = paramInt;
    int i = 0;
    while (i < 3)
    {
      this.mTabIcon[i].setSelected(false);
      i += 1;
    }
    this.mTabIcon[paramInt].setSelected(true);
    if (paramInt == 1) {
      hasReadUtils = true;
    }
  }
  
  private void setAccountUnread()
  {
    if (this.mTabHost.getCurrentTab() == 0) {
      isShowAccountTip = false;
    }
    if ((isShowAccountTip) && (AccountPageActivity.mNeedShowIpcMsg) && (this.mTabHost.getCurrentTab() != 0))
    {
      this.mAccountTipImage.setVisibility(0);
      return;
    }
    this.mAccountTipImage.setVisibility(4);
  }
  
  private void setCurrentTab(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= 3) {
      i = 2;
    }
    this.mTabHost.setCurrentTab(i);
    refreshTab(i);
  }
  
  public static void setFromWhere(int paramInt)
  {
    s_FromPushOrWidget = paramInt;
  }
  
  private void setTabLayoutAndContent()
  {
    int i = getWindowManager().getDefaultDisplay().getWidth();
    this.mTabHost = getTabHost();
    this.mTabWidget = getTabWidget();
    Object localObject1 = this.mTabHost.newTabSpec("tkn");
    ((TabHost.TabSpec)localObject1).setIndicator(null, null);
    ((TabHost.TabSpec)localObject1).setContent(new Intent(this, AccountPageActivity.class));
    this.mTabHost.addTab((TabHost.TabSpec)localObject1);
    localObject1 = this.mTabHost.newTabSpec("utils");
    ((TabHost.TabSpec)localObject1).setIndicator(null, null);
    ((TabHost.TabSpec)localObject1).setContent(new Intent(this, UtilsActivity.class));
    this.mTabHost.addTab((TabHost.TabSpec)localObject1);
    localObject1 = this.mTabHost.newTabSpec("setting");
    ((TabHost.TabSpec)localObject1).setIndicator(null, null);
    ((TabHost.TabSpec)localObject1).setContent(new Intent(this, SettingPageActivity.class));
    this.mTabHost.addTab((TabHost.TabSpec)localObject1);
    Object localObject3 = (ViewGroup)this.mTabWidget.getChildAt(0);
    Object localObject2 = (ViewGroup)this.mTabWidget.getChildAt(1);
    localObject1 = (ViewGroup)this.mTabWidget.getChildAt(2);
    ((ViewGroup)localObject3).setBackgroundResource(2130837659);
    ((ViewGroup)localObject3).removeAllViews();
    ((ViewGroup)localObject3).addView(getTabView(0), new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject2).setBackgroundResource(2130837661);
    ((ViewGroup)localObject2).removeAllViews();
    ((ViewGroup)localObject2).addView(getTabView(1), new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).setBackgroundResource(2130837660);
    ((ViewGroup)localObject1).removeAllViews();
    ((ViewGroup)localObject1).addView(getTabView(2), new RelativeLayout.LayoutParams(-1, -1));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)findViewById(2131296644).getLayoutParams();
    localMarginLayoutParams.height = S_TAB_HEIGHT;
    localMarginLayoutParams.width = -1;
    localObject3 = (ViewGroup.MarginLayoutParams)((ViewGroup)localObject3).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject3).height = S_TAB_HEIGHT;
    ((ViewGroup.MarginLayoutParams)localObject3).width = (i / 3);
    ((ViewGroup.MarginLayoutParams)localObject3).leftMargin = 0;
    ((ViewGroup.MarginLayoutParams)localObject3).rightMargin = 0;
    localObject2 = (ViewGroup.MarginLayoutParams)((ViewGroup)localObject2).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).height = S_TAB_HEIGHT;
    ((ViewGroup.MarginLayoutParams)localObject2).width = (i / 3);
    ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = 0;
    ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
    localObject1 = (ViewGroup.MarginLayoutParams)((ViewGroup)localObject1).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).height = S_TAB_HEIGHT;
    ((ViewGroup.MarginLayoutParams)localObject1).width = (i / 3);
    ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = 0;
    ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = 0;
    localObject1 = (ViewGroup.MarginLayoutParams)this.mTabWidget.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).height = S_TAB_HEIGHT;
    ((ViewGroup.MarginLayoutParams)localObject1).width = i;
    this.mTabHost.setOnTabChangedListener(this.mTabSelectionListener);
    this.mAccountTipImage = ((ImageView)findViewById(2131296646));
    localObject1 = (RelativeLayout.LayoutParams)this.mAccountTipImage.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (S_TAB_HEIGHT / 5);
    ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = (this.mTabWidth / 2 * 1 + (int)(S_DENSITY * 10.0F));
    this.mUtilTipImage = ((ImageView)findViewById(2131296647));
    localObject1 = (RelativeLayout.LayoutParams)this.mUtilTipImage.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (S_TAB_HEIGHT / 5);
    ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = (this.mTabWidth / 2 * 3 + (int)(S_DENSITY * 10.0F));
    this.mSettingTipImage = ((ImageView)findViewById(2131296649));
    localObject1 = (RelativeLayout.LayoutParams)this.mSettingTipImage.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (S_TAB_HEIGHT / 5);
    ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = (this.mTabWidth / 2 * 5 + (int)(S_DENSITY * 10.0F));
    try
    {
      localObject1 = this.mTabWidget.getClass().getDeclaredField("mBottomLeftStrip");
      localObject2 = this.mTabWidget.getClass().getDeclaredField("mBottomRightStrip");
      ((Field)localObject1).setAccessible(true);
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject1).set(this.mTabWidget, getResources().getDrawable(2130837662));
      ((Field)localObject2).set(this.mTabWidget, getResources().getDrawable(2130837662));
      return;
    }
    catch (Exception localException1)
    {
      e.c(localException1.toString());
      try
      {
        this.mTabWidget.getClass().getDeclaredMethod("setStripEnabled", new Class[] { Boolean.TYPE }).invoke(this.mTabWidget, new Object[] { Boolean.valueOf(false) });
        return;
      }
      catch (Exception localException2)
      {
        e.c("exception: " + localException2.toString() + ":" + localException1.getMessage());
      }
    }
  }
  
  private void setUtilsUnread()
  {
    int i = 0;
    for (;;)
    {
      NewConfigureCacheItem localNewConfigureCacheItem;
      if (i < UtilsActivity.mIcons.length)
      {
        localNewConfigureCacheItem = ba.a().h.a(fp.a[i]);
        if (localNewConfigureCacheItem.mClickVersion < localNewConfigureCacheItem.mClientVersion) {
          isShowUtilsTip = true;
        }
      }
      else
      {
        localNewConfigureCacheItem = ba.a().h.a("real_name");
        if ((localNewConfigureCacheItem != null) && (localNewConfigureCacheItem.mClickVersion < localNewConfigureCacheItem.mClientVersion)) {
          isShowUtilsTip = true;
        }
        if (this.mTabHost.getCurrentTab() == 1) {
          isShowUtilsTip = false;
        }
        if ((!isShowUtilsTip) || (this.mTabHost.getCurrentTab() == 1) || (hasReadUtils)) {
          break;
        }
        this.mUtilTipImage.setVisibility(0);
        return;
      }
      isShowUtilsTip = false;
      i += 1;
    }
    this.mUtilTipImage.setVisibility(4);
  }
  
  private void showBaseUserDialogBtn(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    String str1 = null;
    if (paramInt3 != 0) {
      str1 = getResources().getString(paramInt3);
    }
    String str2 = null;
    if (paramInt4 != 0) {
      str2 = getResources().getString(paramInt4);
    }
    showBaseUserDialogBtn(paramInt1, paramInt2, paramString, str1, str2, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener);
  }
  
  private void showBaseUserDialogBtn(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.mDialog = new Dialog(this, 2131427445);
    TextView localTextView2;
    TextView localTextView1;
    TextView localTextView3;
    TextView localTextView4;
    if (paramInt1 == 1)
    {
      this.mDialog.setContentView(2130903073);
      localTextView2 = (TextView)this.mDialog.findViewById(2131296514);
      localTextView1 = null;
      localTextView3 = (TextView)this.mDialog.findViewById(2131296404);
      localTextView4 = (TextView)this.mDialog.findViewById(2131296512);
      if (paramInt2 != 0) {
        break label241;
      }
      localTextView3.setVisibility(8);
      label89:
      if (paramString1 == null) {
        break label250;
      }
      localTextView4.setText(paramString1);
      label99:
      if (paramString2 != null) {
        localTextView2.setText(paramString2);
      }
      if (paramOnClickListener1 == null) {
        break label260;
      }
      localTextView2.setOnClickListener(new lu(this, paramOnClickListener1));
      label131:
      if (localTextView1 != null)
      {
        if (paramOnClickListener2 == null) {
          break label276;
        }
        if (paramString3 != null) {
          localTextView1.setText(paramString3);
        }
        localTextView1.setOnClickListener(new lw(this, paramOnClickListener2));
      }
    }
    for (;;)
    {
      if (paramOnCancelListener != null) {
        this.mDialog.setOnCancelListener(paramOnCancelListener);
      }
      this.mDialog.setCanceledOnTouchOutside(true);
      this.mDialog.show();
      return;
      this.mDialog.setContentView(2130903074);
      localTextView2 = (TextView)this.mDialog.findViewById(2131296516);
      localTextView1 = (TextView)this.mDialog.findViewById(2131296514);
      break;
      label241:
      localTextView3.setText(paramInt2);
      break label89;
      label250:
      localTextView4.setVisibility(8);
      break label99;
      label260:
      localTextView2.setOnClickListener(new lv(this));
      break label131;
      label276:
      localTextView1.setOnClickListener(new lx(this));
    }
  }
  
  private void showDualDialog(boolean paramBoolean)
  {
    if (isFinishing()) {
      return;
    }
    if (this.mDualMsgShowDialog != null)
    {
      if (this.mDualMsgShowDialog.isShowing())
      {
        this.mDualMsgShowDialog.a();
        return;
      }
      this.mDualMsgShowDialog.b();
      this.mDualMsgShowDialog = null;
    }
    this.mDualMsgShowDialog = new DualMsgShowDialog(this, paramBoolean, this.mDualVerifyUin);
    this.mDualMsgShowDialog.show();
  }
  
  private void showShensuDialog()
  {
    Intent localIntent = new Intent(this, WtloginFinishNoMibaoActivity.class);
    localIntent.putExtra("uin", this.curruser.mRealUin);
    startActivity(localIntent);
  }
  
  private void showUpdateInfo()
  {
    if (h.b().a()) {
      showUserDialog(3);
    }
  }
  
  private void showUpgradeDeterminResult(UpgradeDeterminResult paramUpgradeDeterminResult)
  {
    int j = 1;
    if (isFinishing()) {}
    QQUser localQQUser;
    do
    {
      return;
      localQQUser = this.curruser;
    } while (localQQUser == null);
    Intent localIntent;
    if (paramUpgradeDeterminResult.a() == 1)
    {
      if (paramUpgradeDeterminResult.mMobileAppear == 1) {}
      for (int i = 1; i != 0; i = 0)
      {
        localIntent = new Intent(this, NetActiveVryMobileNoSmsActivity.class);
        localIntent.putExtra("intent.qquser", localQQUser);
        localIntent.putExtra("page_id", 7);
        localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
        startActivity(localIntent);
        return;
      }
      if (paramUpgradeDeterminResult.mQqtokenAppear == 1)
      {
        i = 1;
        if (i == 0)
        {
          if (paramUpgradeDeterminResult.mQuesAppear != 1) {
            break label199;
          }
          i = 1;
          label124:
          if (i == 0) {
            if (paramUpgradeDeterminResult.mHaveMobile != 1) {
              break label204;
            }
          }
        }
      }
      label199:
      label204:
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label209;
        }
        localIntent = new Intent(this, NetActiveVryOtherListActivity.class);
        localIntent.putExtra("intent.qquser", localQQUser);
        localIntent.putExtra("page_id", 7);
        localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
        startActivity(localIntent);
        return;
        i = 0;
        break;
        i = 0;
        break label124;
      }
      label209:
      showShensuDialog();
      return;
    }
    if ((paramUpgradeDeterminResult.a() == 2) || (paramUpgradeDeterminResult.a() == 3))
    {
      localIntent = new Intent(this, NetActiveSetDirBySeqActivity.class);
      localIntent.putExtra("intent.qquser", localQQUser);
      localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
      localIntent.putExtra("bindType", paramUpgradeDeterminResult.a());
      startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 4)
    {
      localIntent = new Intent(this, NoCheckWithAuthActivity.class);
      localIntent.putExtra("intent.qquser", localQQUser);
      localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
      startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 5)
    {
      af.a().c(localQQUser.mRealUin, 5, "", "", this.mHandler);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 6)
    {
      localIntent = new Intent(this, VerifyMobilePhoneActivity.class);
      localIntent.putExtra("intent.qquser", localQQUser);
      localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
      startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 8)
    {
      localIntent = new Intent(this, RealNameStep0VerifyMobileActivity.class);
      localIntent.putExtra("source_id", 3);
      localIntent.putExtra("real_uin", localQQUser.mRealUin);
      localIntent.putExtra("realname_mobile", paramUpgradeDeterminResult.mMobileMask);
      localIntent.putExtra("scene_id", 1002);
      startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 9)
    {
      localIntent = new Intent(this, RealNameStep0VerifyMobileActivity.class);
      localIntent.putExtra("source_id", 3);
      localIntent.putExtra("ish5zzb", true);
      localIntent.putExtra("real_uin", localQQUser.mRealUin);
      localIntent.putExtra("realname_mobile", paramUpgradeDeterminResult.mMobileMask);
      localIntent.putExtra("scene_id", 1002);
      startActivity(localIntent);
      return;
    }
    showShensuDialog();
  }
  
  private void showUserDialog(int paramInt)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    switch (paramInt)
    {
    case 6: 
    default: 
      return;
    case 1: 
      this.mDialog = new AlertDialog.Builder(this).setTitle(2131361808).setMessage(getString(2131362400)).setPositiveButton(2131362362, new mh(this)).setNegativeButton(2131361802, new ma(this)).create();
      this.mDialog.show();
      return;
    case 5: 
      this.mProDialog = new ProDialog(this, getString(2131361817));
      this.mProDialog.show();
      return;
    case 4: 
      this.mDialog = new AlertDialog.Builder(this).setTitle(2131361808).setMessage(getString(2131362401)).setPositiveButton(2131361914, new lz(this)).setNegativeButton(2131361802, new ly(this)).create();
      this.mDialog.show();
      return;
    case 2: 
      this.mDialog = new AlertDialog.Builder(this).setTitle(2131361808).setMessage(getString(2131362399)).setPositiveButton(2131362297, new mj(this)).setNegativeButton(2131361802, new mi(this)).create();
      this.mDialog.show();
      return;
    }
    h localh = h.b();
    String str1 = h.b().e;
    String str2 = h.b().d;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(2131361961);
    localBuilder.setMessage(localh.f);
    localBuilder.setPositiveButton(2131361962, new mk(this, str1));
    if (3 == localh.a) {
      localBuilder.setCancelable(false);
    }
    localBuilder.setNeutralButton(2131361963, new ml(this, str2));
    this.mUpdateDialog = localBuilder.create();
    this.mUpdateDialog.show();
  }
  
  public void dismissDialog()
  {
    if (isFinishing()) {}
    for (;;)
    {
      return;
      try
      {
        if (this.mDialog != null)
        {
          this.mDialog.cancel();
          this.mDialog = null;
        }
        if (this.mProDialog != null)
        {
          this.mProDialog.dismiss();
          this.mProDialog = null;
        }
        if (this.mProDialogWithShutDown != null)
        {
          this.mProDialogWithShutDown.dismiss();
          this.mProDialogWithShutDown = null;
          return;
        }
      }
      catch (Exception localException)
      {
        e.b(localException.toString());
      }
    }
  }
  
  public void hideLockVerifyView() {}
  
  public boolean loadLastIndex()
  {
    Context localContext = RqdApplication.i();
    try
    {
      this.mIndex = localContext.getSharedPreferences("token_index_info", 0).getInt("index", 1);
      if (this.mIndex >= 3) {}
      for (int i = 2;; i = this.mIndex)
      {
        this.mIndex = i;
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    BaseActivity.clearAllActivities();
    requestWindowFeature(1);
    setContentView(2130903104);
    this.slidingMenuView = ((SlidingMenuView)findViewById(2131296640));
    this.slidingMenuView.a(new mq(this));
    initMenu();
    computeTabLayout();
    this.mDualVerifyUin = getIntent().getLongExtra("intent.qquser", 0L);
    int i;
    if (getIntent() != null)
    {
      i = getIntent().getIntExtra("index_from", 0);
      if (i != 16) {
        break label243;
      }
      this.mIndex = 0;
    }
    for (;;)
    {
      if (i == 25) {
        this.autoStartModPwdActivity = true;
      }
      setTabLayoutAndContent();
      boolean bool = s.e();
      isShowAccountTip = bool;
      if (bool) {
        AccountPageActivity.mNeedRefreshEval = true;
      }
      e.c("AccountPageActivity.mNeedRefreshEval =" + AccountPageActivity.mNeedRefreshEval);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.token.push_ipc_msg");
      paramBundle.addAction("com.tencent.token.push_opr_msg");
      paramBundle.addAction("com.tencent.token.open_menu");
      paramBundle.addAction("com.tencent.token.refresh_menu");
      LocalBroadcastManager.getInstance(this).registerReceiver(this.mReceiver, paramBundle);
      queryUpdateInfo();
      t.b(this.mLocalConfig);
      if (isNeedReportDnsInfo()) {
        this.mHandler.postDelayed(new mr(this), 6000L);
      }
      return;
      label243:
      if ((i == 17) || (i == 22) || (i == 25))
      {
        this.mIndex = 1;
      }
      else if (i == 23)
      {
        this.mIndex = 1;
        s_FromOtherApp = true;
      }
      else if (i == 24)
      {
        this.mIndex = 1;
        s_ShowGameLoginPushInfo = true;
      }
      else if (s_FromPushOrWidget == 18)
      {
        this.mIndex = 1;
      }
      else
      {
        loadLastIndex();
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mReceiver);
    if (this.mDualMsgShowDialog != null) {
      this.mDualMsgShowDialog.b();
    }
    if (this.mUpdateDialog != null) {
      this.mUpdateDialog.dismiss();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    boolean bool1 = paramIntent.getBooleanExtra("ish5zzb", false);
    SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences("sp_name_global", 0);
    boolean bool2 = localSharedPreferences.getBoolean("key_realname_firsttime_h5", true);
    if ((bool1) && (bool2))
    {
      startActivity(new Intent(this, RealNameFirstJoinActivity.class));
      localSharedPreferences.edit().putBoolean("key_realname_firsttime_h5", false).commit();
      localSharedPreferences.edit().putBoolean("key_realname_firsttime", false).commit();
    }
    int i = paramIntent.getIntExtra("index_from", 0);
    if ((i == 16) || (i == 21)) {
      this.mIndex = 0;
    }
    for (;;)
    {
      if (i == 25) {
        this.autoStartModPwdActivity = true;
      }
      i = paramIntent.getIntExtra("intent.retcode", 0);
      if (i != 0)
      {
        setResult(i);
        finish();
      }
      return;
      if ((i == 17) || (i == 22) || (i == 25))
      {
        this.mIndex = 1;
      }
      else if (i == 23)
      {
        this.mIndex = 1;
        s_FromOtherApp = true;
      }
      else if (i == 24)
      {
        this.mIndex = 1;
        s_ShowGameLoginPushInfo = true;
      }
    }
  }
  
  protected void onPause()
  {
    storeLastIndex();
    super.onPause();
  }
  
  protected void onResume()
  {
    boolean bool2 = true;
    e.c("path other app: resume： " + s_FromOtherApp);
    s.g();
    if (s_FromPushOrWidget == 19) {
      s_FromPush = true;
    }
    for (;;)
    {
      if ((this.mIndex >= 0) && (this.mIndex < 3)) {
        setCurrentTab(this.mIndex);
      }
      if (!s.b()) {
        RqdApplication.b();
      }
      if ((this.mTabHost.getCurrentTab() != 1) || (RqdApplication.b) || (!this.needgotologobyprotect)) {
        break;
      }
      gotologobyprotect();
      this.needgotologobyprotect = false;
      super.onResume();
      return;
      if (s_FromPushOrWidget == 18)
      {
        this.mIndex = 1;
        s_FromPushOrWidget = 20;
      }
      while (!s_ShowGameLoginPushInfo)
      {
        s_FromPush = false;
        break;
      }
      this.mIndex = 1;
    }
    Object localObject = ax.a().e();
    boolean bool1 = bool2;
    if (!s_FromPush)
    {
      if (s_FromOtherApp) {
        bool1 = bool2;
      }
    }
    else
    {
      e.c("dualmsg:onresume:indexactivity: query=" + bool1);
      if ((!RqdApplication.b) && (bool1))
      {
        autoQueryDualMsg();
        s_FromPushOrWidget = 20;
      }
      if ((this.mFirstOpenApp) || (BaseActivity.getGotoBackground()))
      {
        if ((ax.a().k() == null) && (localObject != null)) {
          af.a().e(((QQUser)localObject).mUin, bj.a, this.mHandler);
        }
        this.mHandler.postDelayed(new ms(this), 4000L);
        this.mHandler.postDelayed(new mt(this), 6000L);
      }
      if (this.mFirstOpenApp) {
        this.mFirstOpenApp = false;
      }
      setAccountUnread();
      setUtilsUnread();
      if ((!RqdApplication.b) && (s_ShowGameLoginPushInfo))
      {
        s_ShowGameLoginPushInfo = false;
        ((NotificationManager)getSystemService("notification")).cancel(3);
        localObject = r.a(RqdApplication.i());
        if ((((r)localObject).d() == null) || (((r)localObject).b())) {
          break label588;
        }
        new GameLoginSndConfirmDialog(this).show();
      }
      label380:
      e.a("facepwd index face=" + RqdApplication.e() + ", gesture=" + RqdApplication.d());
      if (!RqdApplication.e()) {
        break label617;
      }
      if (t.l() != 0) {
        break label602;
      }
      localObject = new Intent(this, FaceRecognitionCameraActivityOld.class);
      label441:
      ((Intent)localObject).putExtra("flag", 2);
      ((Intent)localObject).putExtra("istry", 0);
      ((Intent)localObject).putExtra("scene", 5);
      startActivity((Intent)localObject);
    }
    for (;;)
    {
      if (this.autoStartModPwdActivity)
      {
        this.autoStartModPwdActivity = false;
        localObject = new Intent(this, ModifyQQPwdActivity.class);
        ((Intent)localObject).putExtra("index_from", 25);
        startActivity((Intent)localObject);
      }
      if (CAM_ERR)
      {
        CAM_ERR = false;
        dismissDialog();
        this.mDialog = new AlertDialog.Builder(this).setTitle(2131361808).setMessage(getResources().getString(2131362118)).setPositiveButton(2131361800, null).create();
        this.mDialog.show();
      }
      remsumeMenu();
      super.onResume();
      return;
      bool1 = false;
      break;
      label588:
      Toast.makeText(this, 2131362448, 0).show();
      break label380;
      label602:
      localObject = new Intent(this, FaceStartVryCameraActivity.class);
      break label441;
      label617:
      if (RqdApplication.d()) {
        showLockVerifyView();
      } else {
        hideLockVerifyView();
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  protected void onStop()
  {
    super.onStop();
    cancelAutoTask();
    dismissDualDialog();
  }
  
  void remsumeMenu()
  {
    Object localObject = t.f();
    if ((ah.a().c()) || ((ax.a().h()) && (localObject != null) && (((QQUser)localObject).mIsRegisterFacePwd))) {
      this.setpasstext.setText(2131362380);
    }
    int i;
    for (;;)
    {
      i = ax.a().d();
      this.curruser = ax.a().e();
      this.center.setOnClickListener(this.listener);
      this.right.setOnClickListener(this.listener);
      this.left.setOnClickListener(this.listener);
      if (this.curruser != null) {
        break;
      }
      this.unbind.setVisibility(8);
      this.tip.setVisibility(8);
      this.left.setVisibility(8);
      this.right.setVisibility(8);
      this.nickname.setVisibility(0);
      this.nickname.setText(2131361921);
      this.qqnum.setVisibility(0);
      this.qqnum.setText(2131362754);
      this.verify.setVisibility(8);
      initFaceCenter();
      return;
      this.setpasstext.setText(2131362381);
    }
    initFaceCenter();
    this.right.setVisibility(0);
    if (i == 1)
    {
      this.left.setVisibility(8);
      initFaceRight(null);
      this.nickname.setText(this.curruser.mNickName);
      if (!this.curruser.mIsBinded) {
        break label455;
      }
      localObject = this.curruser.mUinMask;
      label262:
      this.qqnum.setText(String.format(RqdApplication.i().getString(2131362753), new Object[] { localObject }));
      this.unbind.setVisibility(0);
      this.unbind.setOnClickListener(this.listener);
      if (!this.curruser.mIsBinded) {
        break label515;
      }
      if (RqdApplication.e == null) {
        break label503;
      }
      this.tip.setVisibility(0);
      this.tip.setText(RqdApplication.e);
      label342:
      this.verify.setVisibility(8);
    }
    for (;;)
    {
      this.verify.setOnClickListener(this.listener);
      this.nickname.setVisibility(0);
      this.qqnum.setVisibility(0);
      return;
      if (i == 2)
      {
        localObject = ax.a().b(1);
        this.left.setVisibility(0);
        initFaceLeft((QQUser)localObject);
        initFaceRight(null);
        break;
      }
      if (i < 3) {
        break;
      }
      localObject = ax.a().b(1);
      QQUser localQQUser = ax.a().b(2);
      this.left.setVisibility(0);
      initFaceLeft((QQUser)localObject);
      initFaceRight(localQQUser);
      break;
      label455:
      if ((this.curruser.mUinMask != null) && (this.curruser.mUinMask.length() > 0))
      {
        localObject = this.curruser.mUinMask;
        break label262;
      }
      localObject = s.e(this.curruser.mRealUin);
      break label262;
      label503:
      this.tip.setVisibility(8);
      break label342;
      label515:
      this.verify.setVisibility(0);
      this.tip.setVisibility(8);
    }
  }
  
  public void showLockVerifyView()
  {
    startActivity(new Intent(this, StartPwdGestureVerifyActivity.class));
  }
  
  public void showProDialog(Activity paramActivity, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialogWithShutDown = new ProDialogWithShutDown(paramActivity, paramOnClickListener, getResources().getString(paramInt2));
    this.mProDialogWithShutDown.show();
  }
  
  public void showProDialog(Activity paramActivity, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialogWithShutDown = new ProDialogWithShutDown(paramActivity, paramOnClickListener, null);
    this.mProDialogWithShutDown.show();
  }
  
  public void showTipDialog(int paramInt, String paramString)
  {
    showUserDialog(paramInt, paramString, 2131361800, null);
  }
  
  public void showToast(int paramInt)
  {
    if (this.mToast == null)
    {
      this.mToast = new Toast(this);
      localObject1 = getLayoutInflater().inflate(2130903218, null);
      this.mToast.setView((View)localObject1);
      this.mToast.setDuration(0);
      this.mToast.setGravity(55, 0, S_TAB_HEIGHT);
    }
    Object localObject2 = this.mToast.getView();
    Object localObject1 = (TextView)((View)localObject2).findViewById(2131296784);
    localObject2 = (ImageView)((View)localObject2).findViewById(2131296783);
    ((TextView)localObject1).setText(getResources().getString(paramInt));
    ((ImageView)localObject2).setBackgroundResource(2130837961);
    ((ImageView)localObject2).setVisibility(0);
    this.mToast.show();
  }
  
  public void showToast(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (isFinishing())) {
      return;
    }
    if (this.mDefaultToast == null) {
      this.mDefaultToast = Toast.makeText(this, paramString, 0);
    }
    for (;;)
    {
      this.mDefaultToast.setGravity(48, 0, S_TITLE_HEIGHT + 5);
      this.mDefaultToast.show();
      return;
      this.mDefaultToast.setText(paramString);
    }
  }
  
  public void showUserDialog(int paramInt1, String paramString, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    showBaseUserDialogBtn(2, paramInt1, paramString, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public void showUserDialog(int paramInt1, String paramString, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    showBaseUserDialogBtn(1, paramInt1, paramString, paramInt2, 0, paramOnClickListener, null, null);
  }
  
  public void storeLastIndex()
  {
    Object localObject = RqdApplication.i();
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("token_index_info", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("index", this.mTabHost.getCurrentTab());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.IndexActivity
 * JD-Core Version:    0.7.0.1
 */