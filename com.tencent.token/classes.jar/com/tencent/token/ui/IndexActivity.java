package com.tencent.token.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.TabActivity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
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
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.tencent.token.cj;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cy;
import com.tencent.token.dm;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.du;
import com.tencent.token.er;
import com.tencent.token.fk;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.ui.base.GameLoginSndConfirmDialog;
import com.tencent.token.ui.base.ProDialog;
import com.tencent.token.ui.base.ProDialogWithShutDown;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.SlidingMenuView;
import com.tencent.token.upload.useraction.a;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;
import com.tencent.token.utils.u;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class IndexActivity
  extends TabActivity
  implements aax
{
  public static final String ACTION_OPEN_MENU = "com.tencent.token.open_menu";
  public static final String ACTION_REFRESH_MENU = "com.tencent.token.refresh_menu";
  public static final String ACTION_REFRESH_STATUSBAR = "com.tencent.token.refresh_statusbar";
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
  public static final int K_FROM_UTILS_TO_VERIFY = 32;
  public static final int K_FROM_WIDGET = 18;
  private static final int MAX_TAB_SIZE = 2;
  private static final String PREFER_INDEX_INFO = "token_index_info";
  public static float S_DENSITY;
  public static boolean S_INIT = false;
  public static int S_RES_HEIGHT;
  public static int S_RES_WIDTH;
  public static int S_STATUS_HEIGHT;
  public static int S_TAB_HEIGHT;
  public static int S_TITLE_HEIGHT;
  public static boolean isShowAccountTip = false;
  public static boolean isShowUtilsTip = false;
  public static boolean need_query_dual_msg = false;
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
  private final int TOKEN_PAGE_INDEX = 1;
  private boolean autoStartModPwdActivity = false;
  private Handler.Callback callback = new ld(this);
  RelativeLayout center;
  QQUser curruser;
  private boolean hasReadUtils = false;
  private ImageView img_head_border_center;
  private ImageView img_head_border_left;
  private ImageView img_head_border_right;
  RelativeLayout left;
  private View.OnClickListener listener = new mq(this);
  private ImageView mAccountTipImage;
  private byte[] mAqSig;
  private UserTask mAutoGetDualMsgTask;
  private int mColor = 2131492909;
  private Toast mDefaultToast;
  private Dialog mDialog;
  private DialogInterface.OnCancelListener mDialogCancelListener = new ms(this);
  private DialogInterface.OnClickListener mDialogFinishListener = new mt(this);
  private DualMsgShowDialog mDualMsgShowDialog = null;
  private long mDualVerifyUin;
  private boolean mFirstOpenApp = true;
  private Handler mHandler = new lp(this);
  private int mIndex = 1;
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
  private BroadcastReceiver mReceiver = new mo(this);
  private TabHost mTabHost;
  private ImageView[] mTabIcon = new ImageView[2];
  private TabHost.OnTabChangeListener mTabSelectionListener = new ln(this);
  private TabWidget mTabWidget;
  private int mTabWidth;
  private Toast mToast;
  private int mType = 1;
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
  boolean snap;
  private float startY;
  TextView tip;
  RelativeLayout unbind;
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
      this.mAutoGetDualMsgTask = new ll(this);
      this.mAutoGetDualMsgTask.c(new String[] { "" });
    } while (!s_FromOtherApp);
    showUserDialog(5);
  }
  
  private void cancelAutoTask()
  {
    if ((this.mAutoGetDualMsgTask != null) && (this.mAutoGetDualMsgTask.b() != UserTask.Status.FINISHED))
    {
      this.mAutoGetDualMsgTask.a(true);
      this.mAutoGetDualMsgTask = null;
    }
  }
  
  private void computeTabLayout()
  {
    this.mTabWidth = (getWindowManager().getDefaultDisplay().getWidth() / 2);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    S_DENSITY = localDisplayMetrics.density;
    S_RES_WIDTH = localDisplayMetrics.widthPixels;
    S_RES_HEIGHT = localDisplayMetrics.heightPixels;
    S_TAB_HEIGHT = S_RES_HEIGHT / 10;
    S_TITLE_HEIGHT = S_RES_HEIGHT / 12;
    if (com.tencent.token.global.c.i()) {
      S_TAB_HEIGHT = S_RES_HEIGHT / 8;
    }
    for (;;)
    {
      try
      {
        i = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i <= 0) {
          continue;
        }
        S_STATUS_HEIGHT = getResources().getDimensionPixelSize(i);
      }
      catch (Exception localException)
      {
        int i;
        Class localClass;
        Object localObject;
        localException.printStackTrace();
        S_STATUS_HEIGHT = (int)getResources().getDimension(2131296371);
        continue;
      }
      h.a("screen para:  height=" + getWindowManager().getDefaultDisplay().getHeight() + ", width=" + getWindowManager().getDefaultDisplay().getWidth() + ", density=" + S_DENSITY + ", densitydpi=" + localDisplayMetrics.densityDpi + ", statusbar=" + S_STATUS_HEIGHT + ", tabbar=" + S_TAB_HEIGHT);
      return;
      localClass = Class.forName("com.android.internal.R$dimen");
      localObject = localClass.newInstance();
      i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      S_STATUS_HEIGHT = getResources().getDimensionPixelSize(i);
    }
  }
  
  private void deleteUser(QQUser paramQQUser)
  {
    try
    {
      cp.a(RqdApplication.l()).a(paramQQUser.mRealUin + "", 523005419L);
      h.a("user.mRealUin" + paramQQUser.mRealUin);
      cw.a().h(paramQQUser.mRealUin, this.mHandler);
      do.a().b(paramQQUser);
      du.a().f.a(w.f(paramQQUser.mUin));
      ds.a().f.a(w.f(paramQQUser.mUin));
      du.a().f.a(w.f(paramQQUser.mRealUin));
      ds.a().f.a(w.f(paramQQUser.mRealUin));
      AccountPageActivity.mNeedRefreshEval = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.c("clearUserLoginDataSync exception: " + localException.getMessage());
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
      paramQQUser = new Intent(this, WtLoginAccountInput.class);
      paramQQUser.putExtra("page_id", 4);
      startActivity(paramQQUser);
    }
    do
    {
      return;
      if (paramQQUser.equals(this.curruser)) {
        break;
      }
    } while (paramQQUser == null);
    do.a().a(paramQQUser.mUin);
    AccountPageActivity.mNeedRefreshEval = true;
    this.slidingMenuView.a(1);
    paramQQUser = new Intent(this, IndexActivity.class);
    paramQQUser.putExtra("index_from", 16);
    startActivity(paramQQUser);
    remsumeMenu();
    return;
    this.slidingMenuView.a(1);
  }
  
  private View getTabView(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      return null;
    }
    Object localObject2 = getResources();
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    Object localObject1 = new StateListDrawable();
    int i = -16842913;
    Drawable localDrawable = ((Resources)localObject2).getDrawable(new int[] { 2130838003, 2130838007, 2130838005 }[paramInt]);
    ((StateListDrawable)localObject1).addState(new int[] { i }, localDrawable);
    localObject2 = ((Resources)localObject2).getDrawable(new int[] { 2130838004, 2130838008, 2130838006 }[paramInt]);
    ((StateListDrawable)localObject1).addState(new int[] { 16842913 }, (Drawable)localObject2);
    this.mTabIcon[paramInt] = new ImageView(this);
    this.mTabIcon[paramInt].setImageDrawable((Drawable)localObject1);
    i = (int)(S_TAB_HEIGHT * 0.5D);
    localObject1 = new LinearLayout.LayoutParams(i, i);
    localLinearLayout.addView(this.mTabIcon[paramInt], (ViewGroup.LayoutParams)localObject1);
    return localLinearLayout;
  }
  
  private void goToRemoveProtectH5(Message paramMessage, int paramInt)
  {
    if (paramMessage == null) {
      return;
    }
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
    {
      showUserDialog(getString(2131230843), paramMessage.getData().getString("loginerror"), 2131230886, 2131230897, new mm(this), new mn(this, paramInt, paramMessage));
      return;
    }
    showUserDialog(2131230843, getResources().getString(2131231411), 2131230897, null);
  }
  
  private void goToWtLoginAccountInput()
  {
    if (do.a().e() == null) {
      return;
    }
    gotoQuickLoginWb();
  }
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void gotoVerify()
  {
    String str = "" + this.curruser.mRealUin;
    cp localcp = cp.a(RqdApplication.l());
    if (!localcp.b(str, 523005419L))
    {
      localcp.a(str, this.mHandler, 523005419L);
      showProDialog(this, 2131230843, 2131231298, null);
      this.mType = 1;
      return;
    }
    showUserDialog(2131231654, getResources().getString(2131231653), 2131230897, new mp(this));
  }
  
  private void gotologobyprotect()
  {
    if (do.a().e() == null) {
      return;
    }
    gotoQuickLoginWb();
  }
  
  private void initFaceCenter()
  {
    if (this.curruser != null)
    {
      this.mQQFaceCenter.setImageDrawable(com.tencent.token.utils.k.a(this.curruser.b() + "", this.curruser.mUin + ""));
      if (this.curruser.mIsBinded)
      {
        this.qqface_not_verify_center.setVisibility(4);
        if (!this.curruser.mIsZzb) {
          break label142;
        }
        this.img_head_border_center.setImageDrawable(getResources().getDrawable(2130838076));
        this.mQQFace_zzbCenter.setVisibility(0);
      }
      for (;;)
      {
        this.img_head_border_center.setVisibility(0);
        return;
        this.qqface_not_verify_center.setVisibility(0);
        break;
        label142:
        this.img_head_border_center.setImageDrawable(getResources().getDrawable(2130837599));
        this.mQQFace_zzbCenter.setVisibility(4);
      }
    }
    this.mQQFaceCenter.setImageResource(2130837811);
    this.img_head_border_center.setVisibility(8);
    this.mQQFace_zzbCenter.setVisibility(8);
    this.qqface_not_verify_center.setVisibility(8);
  }
  
  private void initFaceLeft(QQUser paramQQUser)
  {
    if (paramQQUser != null)
    {
      this.mQQFaceLeft.setVisibility(0);
      this.mQQFaceLeft.setImageDrawable(com.tencent.token.utils.k.a(paramQQUser.b() + "", paramQQUser.mUin + ""));
      if (paramQQUser.mIsBinded) {
        this.qqface_not_verify_left.setVisibility(4);
      }
      while (paramQQUser.mIsZzb)
      {
        this.img_head_border_left.setImageDrawable(getResources().getDrawable(2130838076));
        this.img_head_border_left.setVisibility(0);
        this.mQQFace_zzbLeft.setVisibility(0);
        return;
        this.qqface_not_verify_left.setVisibility(0);
      }
      this.img_head_border_left.setImageDrawable(getResources().getDrawable(2130837599));
      this.mQQFace_zzbLeft.setVisibility(4);
      return;
    }
    this.mQQFaceLeft.setImageResource(2130837609);
    this.img_head_border_left.setVisibility(8);
    this.mQQFace_zzbLeft.setVisibility(8);
    this.qqface_not_verify_left.setVisibility(8);
  }
  
  private void initFaceRight(QQUser paramQQUser)
  {
    if (paramQQUser != null)
    {
      this.mQQFaceRight.setVisibility(0);
      this.mQQFaceRight.setImageDrawable(com.tencent.token.utils.k.a(paramQQUser.b() + "", paramQQUser.mUin + ""));
      if (paramQQUser.mIsBinded)
      {
        this.qqface_not_verify_right.setVisibility(4);
        if (!paramQQUser.mIsZzb) {
          break label135;
        }
        this.img_head_border_right.setImageDrawable(getResources().getDrawable(2130838076));
        this.mQQFace_zzbRight.setVisibility(0);
      }
      for (;;)
      {
        this.img_head_border_right.setVisibility(0);
        return;
        this.qqface_not_verify_right.setVisibility(0);
        break;
        label135:
        this.img_head_border_right.setImageDrawable(getResources().getDrawable(2130837599));
        this.mQQFace_zzbRight.setVisibility(4);
      }
    }
    this.img_head_border_right.setVisibility(8);
    this.mQQFaceRight.setImageResource(2130837609);
    this.mQQFace_zzbRight.setVisibility(8);
    this.qqface_not_verify_right.setVisibility(8);
  }
  
  private void initMenu()
  {
    ((RelativeLayout)this.slidingMenuView.findViewById(2131558583)).setOnClickListener(this.listener);
    ((RelativeLayout)this.slidingMenuView.findViewById(2131558582)).setOnClickListener(this.listener);
    ((RelativeLayout)this.slidingMenuView.findViewById(2131558580)).setOnClickListener(this.listener);
    ((RelativeLayout)this.slidingMenuView.findViewById(2131558579)).setOnClickListener(this.listener);
    ((RelativeLayout)this.slidingMenuView.findViewById(2131558576)).setOnClickListener(this.listener);
    this.unbind = ((RelativeLayout)this.slidingMenuView.findViewById(2131558584));
    this.unbind.setOnClickListener(this.listener);
    this.setpasstext = ((TextView)this.slidingMenuView.findViewById(2131558578));
    TextView localTextView = (TextView)this.slidingMenuView.findViewById(2131558581);
    Object localObject = u.b;
    try
    {
      String str = getPackageManager().getPackageInfo(getPackageName(), 16384).versionName;
      localObject = str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        h.c(localNameNotFoundException.getMessage());
      }
    }
    localTextView.setText("V" + (String)localObject);
    this.tip = ((TextView)this.slidingMenuView.findViewById(2131558574));
    this.nickname = ((TextView)this.slidingMenuView.findViewById(2131558571));
    this.qqnum = ((TextView)this.slidingMenuView.findViewById(2131558572));
    this.center = ((RelativeLayout)this.slidingMenuView.findViewById(2131558561));
    this.left = ((RelativeLayout)this.slidingMenuView.findViewById(2131558556));
    this.right = ((RelativeLayout)this.slidingMenuView.findViewById(2131558566));
    this.mQQFaceCenter = ((RoundImageView)this.slidingMenuView.findViewById(2131558562));
    this.mQQFaceLeft = ((RoundImageView)this.slidingMenuView.findViewById(2131558557));
    this.mQQFaceRight = ((RoundImageView)this.slidingMenuView.findViewById(2131558567));
    this.mQQFace_zzbCenter = ((ImageView)this.slidingMenuView.findViewById(2131558564));
    this.mQQFace_zzbLeft = ((ImageView)this.slidingMenuView.findViewById(2131558559));
    this.mQQFace_zzbRight = ((ImageView)this.slidingMenuView.findViewById(2131558569));
    this.img_head_border_center = ((ImageView)this.slidingMenuView.findViewById(2131558563));
    this.img_head_border_left = ((ImageView)this.slidingMenuView.findViewById(2131558558));
    this.img_head_border_right = ((ImageView)this.slidingMenuView.findViewById(2131558568));
    this.qqface_not_verify_right = ((TextView)this.slidingMenuView.findViewById(2131558570));
    this.qqface_not_verify_center = ((TextView)this.slidingMenuView.findViewById(2131558565));
    this.qqface_not_verify_left = ((TextView)this.slidingMenuView.findViewById(2131558560));
    this.verify = ((Button)this.slidingMenuView.findViewById(2131558575));
  }
  
  private boolean isNeedReportDnsInfo()
  {
    long l1 = x.d() * 1000L;
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
      h.a("report dns info need, time=" + l1 + ", current=" + l2);
      return true;
    }
    h.a("report dns info needn't, time=" + l1 + ", current=" + l2);
    return false;
  }
  
  private void judgeNextStep()
  {
    com.tencent.token.core.protocolcenter.c.a = 1;
  }
  
  private void queryUpdateInfo()
  {
    showUpdateInfo();
  }
  
  private void refreshTab(int paramInt)
  {
    this.mIndex = paramInt;
    int i = 0;
    while (i < 2)
    {
      this.mTabIcon[i].setSelected(false);
      i += 1;
    }
    this.mTabIcon[paramInt].setSelected(true);
    if (paramInt == 1)
    {
      this.hasReadUtils = true;
      com.tencent.token.global.j.a(false);
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
    if (paramInt >= 2) {
      paramInt = 1;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.mTabHost.setCurrentTab(i);
      refreshTab(i);
      return;
    }
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
    Object localObject2 = (ViewGroup)this.mTabWidget.getChildAt(0);
    localObject1 = (ViewGroup)this.mTabWidget.getChildAt(1);
    ((ViewGroup)localObject2).setBackgroundResource(2130837738);
    ((ViewGroup)localObject2).removeAllViews();
    ((ViewGroup)localObject2).addView(getTabView(0), new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).setBackgroundResource(2130837740);
    ((ViewGroup)localObject1).removeAllViews();
    ((ViewGroup)localObject1).addView(getTabView(1), new RelativeLayout.LayoutParams(-1, -1));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)findViewById(2131558953).getLayoutParams();
    localMarginLayoutParams.height = S_TAB_HEIGHT;
    localMarginLayoutParams.width = -1;
    localObject2 = (ViewGroup.MarginLayoutParams)((ViewGroup)localObject2).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).height = S_TAB_HEIGHT;
    ((ViewGroup.MarginLayoutParams)localObject2).width = (i / 2);
    ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = 0;
    ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
    localObject1 = (ViewGroup.MarginLayoutParams)((ViewGroup)localObject1).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).height = S_TAB_HEIGHT;
    ((ViewGroup.MarginLayoutParams)localObject1).width = (i / 2);
    ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = 0;
    ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = 0;
    localObject1 = (ViewGroup.MarginLayoutParams)this.mTabWidget.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).height = S_TAB_HEIGHT;
    ((ViewGroup.MarginLayoutParams)localObject1).width = i;
    this.mTabHost.setOnTabChangedListener(this.mTabSelectionListener);
    this.mAccountTipImage = ((ImageView)findViewById(2131558955));
    localObject1 = (RelativeLayout.LayoutParams)this.mAccountTipImage.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (S_TAB_HEIGHT / 5);
    ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = (this.mTabWidth / 2 * 1 + (int)(S_DENSITY * 10.0F));
    this.mUtilTipImage = ((ImageView)findViewById(2131558956));
    localObject1 = (RelativeLayout.LayoutParams)this.mUtilTipImage.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (S_TAB_HEIGHT / 5);
    ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = (this.mTabWidth / 2 * 3 + (int)(S_DENSITY * 10.0F));
    try
    {
      localObject1 = this.mTabWidget.getClass().getDeclaredField("mBottomLeftStrip");
      localObject2 = this.mTabWidget.getClass().getDeclaredField("mBottomRightStrip");
      ((Field)localObject1).setAccessible(true);
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject1).set(this.mTabWidget, getResources().getDrawable(2130837741));
      ((Field)localObject2).set(this.mTabWidget, getResources().getDrawable(2130837741));
      return;
    }
    catch (Exception localException1)
    {
      h.c(localException1.toString());
      try
      {
        this.mTabWidget.getClass().getDeclaredMethod("setStripEnabled", new Class[] { Boolean.TYPE }).invoke(this.mTabWidget, new Object[] { Boolean.valueOf(false) });
        return;
      }
      catch (Exception localException2)
      {
        h.c("exception: " + localException2.toString() + ":" + localException1.getMessage());
      }
    }
  }
  
  private void setUtilsUnread()
  {
    if (com.tencent.token.global.j.d()) {
      isShowUtilsTip = true;
    }
    if (this.mTabHost.getCurrentTab() == 1) {
      isShowUtilsTip = false;
    }
    if ((isShowUtilsTip) && (this.mTabHost.getCurrentTab() != 1) && (!this.hasReadUtils))
    {
      this.mUtilTipImage.setVisibility(0);
      return;
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
    this.mDialog = new Dialog(this, 2131362155);
    TextView localTextView2;
    TextView localTextView1;
    TextView localTextView3;
    TextView localTextView4;
    if (paramInt1 == 1)
    {
      this.mDialog.setContentView(2130968637);
      localTextView2 = (TextView)this.mDialog.findViewById(2131558797);
      localTextView1 = null;
      localTextView3 = (TextView)this.mDialog.findViewById(2131558419);
      localTextView4 = (TextView)this.mDialog.findViewById(2131558795);
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
      localTextView2.setOnClickListener(new lz(this, paramOnClickListener1));
      label131:
      if (localTextView1 != null)
      {
        if (paramOnClickListener2 == null) {
          break label276;
        }
        if (paramString3 != null) {
          localTextView1.setText(paramString3);
        }
        localTextView1.setOnClickListener(new mb(this, paramOnClickListener2));
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
      this.mDialog.setContentView(2130968638);
      localTextView2 = (TextView)this.mDialog.findViewById(2131558799);
      localTextView1 = (TextView)this.mDialog.findViewById(2131558797);
      break;
      label241:
      localTextView3.setText(paramInt2);
      break label89;
      label250:
      localTextView4.setVisibility(8);
      break label99;
      label260:
      localTextView2.setOnClickListener(new ma(this));
      break label131;
      label276:
      localTextView1.setOnClickListener(new mc(this));
    }
  }
  
  private void showBaseUserDialogBtn(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    String str1 = null;
    if (paramInt2 != 0) {
      str1 = getResources().getString(paramInt2);
    }
    String str2 = null;
    if (paramInt3 != 0) {
      str2 = getResources().getString(paramInt3);
    }
    showBaseUserDialogBtn(paramInt1, paramString1, paramString2, str1, str2, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener);
  }
  
  private void showBaseUserDialogBtn(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.mDialog = new Dialog(this, 2131362155);
    TextView localTextView2;
    TextView localTextView1;
    TextView localTextView3;
    TextView localTextView4;
    if (paramInt == 1)
    {
      this.mDialog.setContentView(2130968637);
      localTextView2 = (TextView)this.mDialog.findViewById(2131558797);
      localTextView1 = null;
      localTextView3 = (TextView)this.mDialog.findViewById(2131558419);
      localTextView4 = (TextView)this.mDialog.findViewById(2131558795);
      if (paramString1 != null) {
        break label241;
      }
      localTextView3.setVisibility(8);
      label89:
      if (paramString2 == null) {
        break label250;
      }
      localTextView4.setText(paramString2);
      label99:
      if (paramString3 != null) {
        localTextView2.setText(paramString3);
      }
      if (paramOnClickListener1 == null) {
        break label260;
      }
      localTextView2.setOnClickListener(new lo(this, paramOnClickListener1));
      label131:
      if (localTextView1 != null)
      {
        if (paramOnClickListener2 == null) {
          break label276;
        }
        if (paramString4 != null) {
          localTextView1.setText(paramString4);
        }
        localTextView1.setOnClickListener(new lx(this, paramOnClickListener2));
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
      this.mDialog.setContentView(2130968638);
      localTextView2 = (TextView)this.mDialog.findViewById(2131558799);
      localTextView1 = (TextView)this.mDialog.findViewById(2131558797);
      break;
      label241:
      localTextView3.setText(paramString1);
      break label89;
      label250:
      localTextView4.setVisibility(8);
      break label99;
      label260:
      localTextView2.setOnClickListener(new lw(this));
      break label131;
      label276:
      localTextView1.setOnClickListener(new ly(this));
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
    this.mDualMsgShowDialog = new DualMsgShowDialog(this, 2131362156, 0, paramBoolean, this.mDualVerifyUin);
    this.mDualMsgShowDialog.show();
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131231509, paramString, 2131230897, new mg(this));
  }
  
  private void showUpdateInfo()
  {
    if (com.tencent.token.core.bean.j.b().a()) {
      showUserDialog(3);
    }
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
      this.mDialog = new AlertDialog.Builder(this).setTitle(2131230843).setMessage(getString(2131231284)).setPositiveButton(2131231658, new mh(this)).setNegativeButton(2131231388, new mf(this)).create();
      this.mDialog.show();
      return;
    case 5: 
      this.mProDialog = new ProDialog(this, 2131362182, getString(2131231298));
      this.mProDialog.show();
      return;
    case 4: 
      this.mDialog = new AlertDialog.Builder(this).setTitle(2131230843).setMessage(getString(2131231282)).setPositiveButton(2131230881, new me(this)).setNegativeButton(2131231388, new md(this)).create();
      this.mDialog.show();
      return;
    case 2: 
      this.mDialog = new AlertDialog.Builder(this).setTitle(2131230843).setMessage(getString(2131231283)).setPositiveButton(2131230778, new mj(this)).setNegativeButton(2131231388, new mi(this)).create();
      this.mDialog.show();
      return;
    }
    com.tencent.token.core.bean.j localj = com.tencent.token.core.bean.j.b();
    String str1 = com.tencent.token.core.bean.j.b().e;
    String str2 = com.tencent.token.core.bean.j.b().d;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(2131231521);
    localBuilder.setMessage(localj.f);
    localBuilder.setPositiveButton(2131231520, new mk(this, str1, localj));
    if (3 == localj.a) {
      localBuilder.setCancelable(false);
    }
    localBuilder.setNeutralButton(2131231523, new ml(this, str2, localj));
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
        h.b(localException.toString());
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    a.a().a(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.startY = paramMotionEvent.getRawY();
      continue;
      if (paramMotionEvent.getRawY() - this.startY > 5.0F) {
        a.a().a(a.f);
      } else {
        a.a().a(a.b);
      }
    }
  }
  
  public void hideLockVerifyView() {}
  
  public boolean loadLastIndex()
  {
    Context localContext = RqdApplication.l();
    try
    {
      this.mIndex = localContext.getSharedPreferences("token_index_info", 0).getInt("index", 1);
      if (this.mIndex >= 2) {}
      for (int i = 1;; i = this.mIndex)
      {
        this.mIndex = i;
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    BaseActivity.clearAllActivities();
    requestWindowFeature(1);
    setContentView(2130968675);
    this.slidingMenuView = ((SlidingMenuView)findViewById(2131558949));
    this.slidingMenuView.setStateChangeListener(new mu(this));
    initMenu();
    computeTabLayout();
    this.mDualVerifyUin = getIntent().getLongExtra("intent.qquser", 0L);
    int i;
    if (getIntent() != null)
    {
      i = getIntent().getIntExtra("index_from", 0);
      if (i != 16) {
        break label328;
      }
      this.mIndex = 0;
      if (i == 25) {
        this.autoStartModPwdActivity = true;
      }
    }
    setTabLayoutAndContent();
    isShowAccountTip = w.e();
    if (isShowAccountTip) {
      AccountPageActivity.mNeedRefreshEval = true;
    }
    h.c("AccountPageActivity.mNeedRefreshEval =" + AccountPageActivity.mNeedRefreshEval);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.token.push_ipc_msg");
    paramBundle.addAction("com.tencent.token.push_opr_msg");
    paramBundle.addAction("com.tencent.token.open_menu");
    paramBundle.addAction("com.tencent.token.refresh_menu");
    paramBundle.addAction("com.tencent.token.refresh_statusbar");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.mReceiver, paramBundle);
    queryUpdateInfo();
    this.mHandler.postDelayed(new le(this), 3000L);
    this.mHandler.postDelayed(new lf(this), 6000L);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (paramBundle.mIsZzb)) {
      x.a(this, findViewById(2131558691), 2131492882);
    }
    for (;;)
    {
      this.mHandler.postDelayed(new lg(this), 1000L);
      com.tencent.service.update.k.a().a(this);
      com.tencent.service.update.k.a().b();
      com.tencent.service.update.k.a().k();
      fk.a();
      return;
      label328:
      if ((i == 17) || (i == 22) || (i == 25) || (i == 32))
      {
        this.mIndex = 1;
        break;
      }
      if (i == 23)
      {
        this.mIndex = 1;
        s_FromOtherApp = true;
        break;
      }
      if (i == 24)
      {
        this.mIndex = 1;
        s_ShowGameLoginPushInfo = true;
        break;
      }
      if (s_FromPushOrWidget == 18)
      {
        this.mIndex = 1;
        break;
      }
      loadLastIndex();
      break;
      x.a(this, findViewById(2131558691), 2131492875);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.service.update.k.a().c();
    com.tencent.service.update.k.a().a(null);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mReceiver);
    if (this.mDualMsgShowDialog != null) {
      this.mDualMsgShowDialog.b();
    }
    if (this.mUpdateDialog != null) {
      this.mUpdateDialog.dismiss();
    }
    abi.c();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.snap = paramIntent.getBooleanExtra("snap", false);
    boolean bool1 = paramIntent.getBooleanExtra("ish5zzb", false);
    SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("sp_name_global", 0);
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
    
    if (s_FromPushOrWidget == 19) {
      s_FromPush = true;
    }
    for (;;)
    {
      if ((this.mIndex >= 0) && (this.mIndex < 2)) {
        setCurrentTab(this.mIndex);
      }
      if (!w.b()) {
        RqdApplication.e();
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
        s_FromPush = false;
      }
      else if (s_ShowGameLoginPushInfo)
      {
        this.mIndex = 1;
      }
      else
      {
        s_FromPush = false;
      }
    }
    Object localObject = do.a().e();
    int i;
    if ((s_FromPush) || (s_FromOtherApp)) {
      i = 1;
    }
    for (;;)
    {
      if ((!RqdApplication.b) && (i != 0))
      {
        autoQueryDualMsg();
        s_FromPushOrWidget = 20;
      }
      if ((this.mFirstOpenApp) || (BaseActivity.getGotoBackground()))
      {
        if ((do.a().k() == null) && (localObject != null)) {
          cw.a().c(((QQUser)localObject).mUin, com.tencent.token.core.protocolcenter.c.a, this.mHandler);
        }
        this.mHandler.postDelayed(new lh(this), 4000L);
        if (this.mFirstOpenApp) {
          this.mHandler.postDelayed(new li(this), 6000L);
        }
      }
      try
      {
        if ((x.m()) && (do.a().e() != null))
        {
          localObject = new HandlerThread("deviceinfouploader", 1);
          ((HandlerThread)localObject).start();
          new Handler(((HandlerThread)localObject).getLooper()).postDelayed(new lj(this), 20000L);
        }
        if (this.mFirstOpenApp) {
          this.mFirstOpenApp = false;
        }
        setAccountUnread();
        this.mHandler.postDelayed(new lk(this), 1000L);
        if ((!RqdApplication.b) && (s_ShowGameLoginPushInfo))
        {
          s_ShowGameLoginPushInfo = false;
          ((NotificationManager)getSystemService("notification")).cancel(3);
          localObject = cj.a(RqdApplication.l());
          if ((((cj)localObject).d() != null) && (!((cj)localObject).b())) {
            new GameLoginSndConfirmDialog(this, 2131362156).show();
          }
        }
        else
        {
          h.a("facepwd index face=" + RqdApplication.h() + ", gesture=" + RqdApplication.g());
          if (!RqdApplication.h()) {
            break label734;
          }
          localObject = new Intent(this, FaceStartVryCameraActivity.class);
          ((Intent)localObject).putExtra("flag", 2);
          ((Intent)localObject).putExtra("istry", 0);
          ((Intent)localObject).putExtra("scene", 5);
          startActivity((Intent)localObject);
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
            this.mDialog = new AlertDialog.Builder(this).setTitle(2131230843).setMessage(getResources().getString(2131231281)).setPositiveButton(2131230897, null).create();
            this.mDialog.show();
          }
          remsumeMenu();
          if (this.snap)
          {
            if (this.slidingMenuView != null) {
              this.slidingMenuView.a(1, true);
            }
            this.snap = false;
          }
          h.c("====need_query_dual_msg====" + need_query_dual_msg);
          if (need_query_dual_msg)
          {
            need_query_dual_msg = false;
            if (do.a().e() != null)
            {
              h.c("====获取push消息====");
              cw.a().a(0L, dm.a, this.mHandler);
            }
          }
          super.onResume();
          return;
          i = 0;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          Toast.makeText(this, 2131231084, 0).show();
          continue;
          label734:
          if (RqdApplication.g()) {
            showLockVerifyView();
          } else {
            hideLockVerifyView();
          }
        }
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
    Object localObject = x.f();
    if ((cy.a().c()) || ((do.a().h()) && (localObject != null) && (((QQUser)localObject).mIsRegisterFacePwd))) {
      this.setpasstext.setText(2131231443);
    }
    int i;
    for (;;)
    {
      i = do.a().d();
      this.curruser = do.a().e();
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
      this.nickname.setText(2131231195);
      this.nickname.setEnabled(true);
      this.nickname.setOnClickListener(this.listener);
      this.qqnum.setVisibility(4);
      this.verify.setVisibility(8);
      initFaceCenter();
      return;
      this.setpasstext.setText(2131231442);
    }
    this.nickname.setEnabled(false);
    initFaceCenter();
    this.right.setVisibility(0);
    if (i == 1)
    {
      this.left.setVisibility(8);
      initFaceRight(null);
      this.nickname.setText(this.curruser.mNickName);
      if (!this.curruser.mIsBinded) {
        break label472;
      }
      localObject = this.curruser.mUinMask;
      label279:
      this.qqnum.setText(String.format(RqdApplication.l().getString(2131231207), new Object[] { localObject }));
      this.unbind.setVisibility(0);
      this.unbind.setOnClickListener(this.listener);
      if (!this.curruser.mIsBinded) {
        break label532;
      }
      if (RqdApplication.e == null) {
        break label520;
      }
      this.tip.setVisibility(0);
      this.tip.setText(RqdApplication.e);
      label359:
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
        localObject = do.a().b(1);
        this.left.setVisibility(0);
        initFaceLeft((QQUser)localObject);
        initFaceRight(null);
        break;
      }
      if (i < 3) {
        break;
      }
      localObject = do.a().b(1);
      QQUser localQQUser = do.a().b(2);
      this.left.setVisibility(0);
      initFaceLeft((QQUser)localObject);
      initFaceRight(localQQUser);
      break;
      label472:
      if ((this.curruser.mUinMask != null) && (this.curruser.mUinMask.length() > 0))
      {
        localObject = this.curruser.mUinMask;
        break label279;
      }
      localObject = w.e(this.curruser.mRealUin);
      break label279;
      label520:
      this.tip.setVisibility(8);
      break label359;
      label532:
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
    this.mProDialogWithShutDown = new ProDialogWithShutDown(paramActivity, 2131362182, paramOnClickListener, getResources().getString(paramInt2));
    this.mProDialogWithShutDown.show();
  }
  
  public void showProDialog(Activity paramActivity, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialogWithShutDown = new ProDialogWithShutDown(paramActivity, 2131362182, paramOnClickListener, null);
    this.mProDialogWithShutDown.show();
  }
  
  public void showTipDialog(int paramInt, String paramString)
  {
    showUserDialog(paramInt, paramString, 2131230897, null);
  }
  
  public void showToast(int paramInt)
  {
    if (this.mToast == null)
    {
      this.mToast = new Toast(this);
      localObject1 = getLayoutInflater().inflate(2130968780, null);
      this.mToast.setView((View)localObject1);
      this.mToast.setDuration(0);
      this.mToast.setGravity(55, 0, S_TAB_HEIGHT);
    }
    Object localObject2 = this.mToast.getView();
    Object localObject1 = (TextView)((View)localObject2).findViewById(2131558987);
    localObject2 = (ImageView)((View)localObject2).findViewById(2131558986);
    ((TextView)localObject1).setText(getResources().getString(paramInt));
    ((ImageView)localObject2).setBackgroundResource(2130837591);
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
  
  public void showUserDialog(int paramInt1, String paramString, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    showBaseUserDialogBtn(1, paramInt1, paramString, paramInt2, 0, paramOnClickListener, null, null);
  }
  
  public void showUserDialog(int paramInt1, String paramString, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    showBaseUserDialogBtn(1, paramInt1, paramString, paramInt2, 0, paramOnClickListener, null, paramOnCancelListener);
  }
  
  public void showUserDialog(String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    showBaseUserDialogBtn(2, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      MotionEvent localMotionEvent = a.a().b();
      if (localMotionEvent != null)
      {
        h.c("getRawX:" + localMotionEvent.getRawX());
        h.c("getRawY:" + localMotionEvent.getRawY());
        String str = "";
        if (paramIntent.getComponent() != null) {
          str = paramIntent.getComponent().getClassName();
        }
        long l = System.currentTimeMillis() - (SystemClock.uptimeMillis() - localMotionEvent.getDownTime());
        h.c("eventStartTime:" + l);
        a.a().a(a.e, "", "", "", "", str, (int)localMotionEvent.getRawX(), (int)localMotionEvent.getRawY(), l);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.startActivity(paramIntent);
  }
  
  public void storeLastIndex()
  {
    Object localObject = RqdApplication.l();
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("token_index_info", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("index", this.mTabHost.getCurrentTab());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.IndexActivity
 * JD-Core Version:    0.7.0.1
 */