package com.tencent.token.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.bean.h;
import com.tencent.token.core.push.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.ui.base.ProDialog;
import com.tencent.token.ui.base.ProDialogWithShutDown;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.WtloginCaptchaDialog;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import com.tencent.token.v;
import com.tencent.token.x;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseActivity
  extends Activity
  implements acn
{
  public static final int ADD_ACCOUNT_TIP_ACCOUNT = 0;
  public static final int ADD_ACCOUNT_TIP_ACCOUNT_LOCK = 11;
  public static final int ADD_ACCOUNT_TIP_FACE = 20;
  public static final int ADD_ACCOUNT_TIP_FACE_CHANGEPSW = 24;
  public static final int ADD_ACCOUNT_TIP_GAME_LOCK = 15;
  public static final int ADD_ACCOUNT_TIP_GAME_PROTECT = 14;
  public static final int ADD_ACCOUNT_TIP_GET_VERIFY_MSG = 13;
  public static final int ADD_ACCOUNT_TIP_JL_SAFETY = 16;
  public static final int ADD_ACCOUNT_TIP_LIBRARY = 2;
  public static final int ADD_ACCOUNT_TIP_LOGIN_PROTECT = 12;
  public static final int ADD_ACCOUNT_TIP_LOGIN_RECORD = 6;
  public static final int ADD_ACCOUNT_TIP_MAIL_LOCK = 8;
  public static final int ADD_ACCOUNT_TIP_MB_MOBLIE = 1;
  public static final int ADD_ACCOUNT_TIP_MB_QUESTION = 23;
  public static final int ADD_ACCOUNT_TIP_MODIFY_PWD = 10;
  public static final int ADD_ACCOUNT_TIP_MY_MB = 19;
  public static final int ADD_ACCOUNT_TIP_MY_PROTEC = 18;
  public static final int ADD_ACCOUNT_TIP_PHYSICAL_EXAM = 4;
  public static final int ADD_ACCOUNT_TIP_QB = 9;
  public static final int ADD_ACCOUNT_TIP_QQ_TOKEN = 22;
  public static final int ADD_ACCOUNT_TIP_REALNAME = 21;
  public static final int ADD_ACCOUNT_TIP_RECOVER_FRIENDS = 17;
  public static final int ADD_ACCOUNT_TIP_SAFE_NOTIFY = 5;
  public static final int ADD_ACCOUNT_TIP_SAFE_REPORTER = 7;
  public static final int ADD_ACCOUNT_TIP_ZZB = 3;
  private static final int BUTTON_NUM_ONE = 1;
  private static final int BUTTON_NUM_TWO = 2;
  public static final int K_DELETE2VERIFY_REQUEST = 32;
  public static final int K_DELETEORMODIFY2VERIFY_SUC_RESPONSE = 35;
  public static final int K_DLG_CORRECTING_TIME = 6;
  public static final int K_DLG_EXIT = 4;
  public static final int K_DLG_MARKET_ERR = 5;
  public static final int K_DLG_NETWORK_ERR = 8;
  public static final int K_DLG_NORMAL_PROGRESS = 12;
  public static final int K_DLG_NOT_BIND_UIN = 9;
  public static final int K_DLG_NO_UPDATE = 3;
  public static final int K_DLG_QUERY_DUAL_MSG = 10;
  public static final int K_DLG_QUERY_UPDATE = 2;
  public static final int K_DLG_REPORT_LOCATION_DOING = 7;
  public static final int K_DLG_SCANLOGINING = 11;
  public static final int K_DLG_UPDATE_REMIND = 1;
  public static final int K_MODIFY2VERIFY_REQUEST = 34;
  public static final int SCENE_ADD_ACCOUNT = 0;
  public static final int SCENE_VERIFY_ACCOUNT = 1;
  private static boolean gotobackground;
  private static boolean isForeground = false;
  private static ArrayList mActivityList = new ArrayList();
  private static final Class[] mNoBackActivity = { AccountPageActivity.class, UtilsActivity.class, SettingPageActivity.class };
  public static Activity sTopActivity;
  protected RelativeLayout animLayout;
  protected ImageView arcImg;
  private Handler.Callback callback = new as(this);
  protected final Handler fHandler = new bd(this);
  protected ImageView lineImg;
  private final long mAppid = 523005425L;
  protected byte[] mAqSig;
  protected View mBackArrow;
  protected ImageView mBackArrowImg;
  private View.OnClickListener mCompleteButtonListener = new bg(this);
  private RelativeLayout mContent;
  private Toast mDefaultToast;
  private Dialog mDialog;
  private TitleOptionMenu mDialogMenu;
  private long mExitTime = 0L;
  private boolean mIsActiveSuccess = false;
  private boolean mNeverShowLockVerifyView = false;
  private Toast mOrangeToast;
  private ProDialogWithShutDown mProDialog;
  private ProDialog mProDialogWithoutShutDown;
  private Resources mRes;
  private Button mRightOptionButton;
  public ImageView mRightOptionImage;
  protected View mRightOptionLayout;
  private boolean mShowLockVerifyViewOnce = false;
  protected View mTitleBar;
  protected View mTitleDivider;
  protected TextView mTitleText;
  private final int mType = 2;
  protected long mUin;
  private UpgradeDeterminResult mUpDetermin;
  private BaseActivity mmContext;
  
  public static void addActivitToList(Activity paramActivity)
  {
    mActivityList.add(paramActivity);
  }
  
  public static void clearAllActivities()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < mActivityList.size())
        {
          Activity localActivity = (Activity)mActivityList.get(i);
          if ((localActivity != null) && (!localActivity.isFinishing())) {
            localActivity.finish();
          }
        }
        else
        {
          mActivityList.clear();
          return;
        }
      }
      catch (Exception localException)
      {
        e.c("remove activity list err=" + localException.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  private void doLockVerify()
  {
    if (RqdApplication.e()) {
      if (t.l() == 0)
      {
        localIntent = new Intent(this, FaceRecognitionCameraActivityOld.class);
        localIntent.putExtra("flag", 2);
        localIntent.putExtra("istry", 0);
        localIntent.putExtra("scene", 5);
        startActivity(localIntent);
      }
    }
    while (!RqdApplication.d()) {
      for (;;)
      {
        return;
        Intent localIntent = new Intent(this, FaceStartVryCameraActivity.class);
      }
    }
    showLockVerifyView();
  }
  
  private View getContentView()
  {
    return ((ViewGroup)getWindow().getDecorView()).getChildAt(0);
  }
  
  public static boolean getGotoBackground()
  {
    return gotobackground;
  }
  
  public static boolean getIsAppForeground()
  {
    return isForeground;
  }
  
  private void goToWtLoginAccountInput()
  {
    QQUser localQQUser = com.tencent.token.ax.a().e();
    if (localQQUser == null) {
      return;
    }
    Intent localIntent = new Intent(this, WtLoginAccountInput.class);
    localIntent.putExtra("page_id", 7);
    localIntent.putExtra("intent.uin", localQQUser.mRealUin);
    startActivity(localIntent);
  }
  
  private void initControllers()
  {
    this.mTitleBar = findViewById(2131296418);
    this.mTitleText = ((TextView)findViewById(2131296419));
    this.mTitleDivider = findViewById(2131296424);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTitleBar.getLayoutParams();
    if (IndexActivity.S_RES_HEIGHT > 0) {
      localMarginLayoutParams.height = IndexActivity.S_TITLE_HEIGHT;
    }
    this.mBackArrow = findViewById(2131296420);
    this.mBackArrowImg = ((ImageView)findViewById(2131296421));
    this.mRightOptionButton = ((Button)findViewById(2131297148));
    setDefaultTitle();
    setDefaultBackArrow();
  }
  
  public static boolean isAppOpen()
  {
    return (mActivityList != null) && (mActivityList.size() > 0) && (((Activity)mActivityList.get(0)).getClass().getName().indexOf("LogoActivity") != -1);
  }
  
  public static void removeActivityFromList(Activity paramActivity)
  {
    mActivityList.remove(paramActivity);
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    ag localag = ag.c();
    localag.i();
    localag.n();
    this.mIsActiveSuccess = true;
    this.mmContext.setContentView(2130903050);
    this.mmContext.setBackArrowHide();
    this.mmContext.setTitle(2131361842);
    com.tencent.token.ax.a().f(this.mUin);
    ((Button)this.mmContext.findViewById(2131296398)).setOnClickListener(this.mCompleteButtonListener);
    ((ImageView)this.mmContext.findViewById(2131296395)).setImageDrawable(k.a(this.mUin + "", s.f(this.mUin) + " "));
    a.a().a(8);
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
      localTextView2.setOnClickListener(new ax(this, paramOnClickListener1));
      label131:
      if (localTextView1 != null)
      {
        if (paramOnClickListener2 == null) {
          break label276;
        }
        if (paramString3 != null) {
          localTextView1.setText(paramString3);
        }
        localTextView1.setOnClickListener(new az(this, paramOnClickListener2));
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
      localTextView2.setOnClickListener(new ay(this));
      break label131;
      label276:
      localTextView1.setOnClickListener(new ba(this));
    }
  }
  
  private void showShensuDialog()
  {
    Intent localIntent = new Intent(this.mmContext, WtloginFinishNoMibaoActivity.class);
    localIntent.putExtra("uin", com.tencent.token.ax.a().e().mRealUin);
    this.mmContext.startActivity(localIntent);
  }
  
  private void showUpgradeDeterminResult(UpgradeDeterminResult paramUpgradeDeterminResult)
  {
    int j = 1;
    if (this.mmContext.isFinishing()) {}
    QQUser localQQUser;
    do
    {
      return;
      localQQUser = com.tencent.token.ax.a().e();
    } while (localQQUser == null);
    Intent localIntent;
    if (paramUpgradeDeterminResult.a() == 1)
    {
      if (paramUpgradeDeterminResult.mMobileAppear == 1) {}
      for (int i = 1; i != 0; i = 0)
      {
        localIntent = new Intent(this.mmContext, NetActiveVryMobileNoSmsActivity.class);
        localIntent.putExtra("intent.qquser", localQQUser);
        localIntent.putExtra("page_id", 7);
        localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
        this.mmContext.startActivity(localIntent);
        return;
      }
      if (paramUpgradeDeterminResult.mQqtokenAppear == 1)
      {
        i = 1;
        if (i == 0)
        {
          if (paramUpgradeDeterminResult.mQuesAppear != 1) {
            break label216;
          }
          i = 1;
          label135:
          if (i == 0) {
            if (paramUpgradeDeterminResult.mHaveMobile != 1) {
              break label221;
            }
          }
        }
      }
      label216:
      label221:
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label226;
        }
        localIntent = new Intent(this.mmContext, NetActiveVryOtherListActivity.class);
        localIntent.putExtra("intent.qquser", localQQUser);
        localIntent.putExtra("page_id", 7);
        localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
        this.mmContext.startActivity(localIntent);
        return;
        i = 0;
        break;
        i = 0;
        break label135;
      }
      label226:
      showShensuDialog();
      return;
    }
    if ((paramUpgradeDeterminResult.a() == 2) || (paramUpgradeDeterminResult.a() == 3))
    {
      localIntent = new Intent(this.mmContext, NetActiveSetDirBySeqActivity.class);
      localIntent.putExtra("intent.qquser", localQQUser);
      localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
      localIntent.putExtra("bindType", paramUpgradeDeterminResult.a());
      this.mmContext.startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 4)
    {
      localIntent = new Intent(this.mmContext, NoCheckWithAuthActivity.class);
      localIntent.putExtra("intent.qquser", localQQUser);
      localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
      this.mmContext.startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 5)
    {
      af.a().c(localQQUser.mRealUin, 5, "", "", this.fHandler);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 6)
    {
      localIntent = new Intent(this.mmContext, VerifyMobilePhoneActivity.class);
      localIntent.putExtra("intent.qquser", localQQUser);
      localIntent.putExtra("intent.upgradedetermin", paramUpgradeDeterminResult);
      this.mmContext.startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 8)
    {
      localIntent = new Intent(this.mmContext, RealNameStep0VerifyMobileActivity.class);
      localIntent.putExtra("source_id", 3);
      localIntent.putExtra("real_uin", localQQUser.mRealUin);
      localIntent.putExtra("realname_mobile", paramUpgradeDeterminResult.mMobileMask);
      localIntent.putExtra("scene_id", 1002);
      this.mmContext.startActivity(localIntent);
      return;
    }
    if (paramUpgradeDeterminResult.a() == 9)
    {
      localIntent = new Intent(this.mmContext, RealNameStep0VerifyMobileActivity.class);
      localIntent.putExtra("source_id", 3);
      localIntent.putExtra("ish5zzb", true);
      localIntent.putExtra("real_uin", localQQUser.mRealUin);
      localIntent.putExtra("realname_mobile", paramUpgradeDeterminResult.mMobileMask);
      localIntent.putExtra("scene_id", 1002);
      this.mmContext.startActivity(localIntent);
      return;
    }
    showShensuDialog();
  }
  
  private void showUserDialogHasCancel(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    showUserDialog(2131361808, paramString, paramInt, 2131361804, paramOnClickListener, null);
  }
  
  private void showUserDialogNoCancel(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    showUserDialog(2131361808, paramString, paramInt, paramOnClickListener);
  }
  
  public void addContentView(View paramView)
  {
    if (this.mContent != null) {
      this.mContent.addView(paramView, 1, new RelativeLayout.LayoutParams(-1, -1));
    }
  }
  
  public void bringChildToFront(View paramView)
  {
    this.mContent.bringChildToFront(paramView);
  }
  
  protected void cancelRequest() {}
  
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
        if (this.mProDialogWithoutShutDown != null)
        {
          this.mProDialogWithoutShutDown.dismiss();
          this.mProDialogWithoutShutDown = null;
          return;
        }
      }
      catch (Exception localException)
      {
        e.b(localException.toString());
      }
    }
  }
  
  protected void exit()
  {
    Iterator localIterator = mActivityList.iterator();
    while (localIterator.hasNext()) {
      ((Activity)localIterator.next()).finish();
    }
  }
  
  protected void exitToken()
  {
    if (System.currentTimeMillis() - this.mExitTime > Long.parseLong(getResources().getString(2131361965)))
    {
      Toast.makeText(RqdApplication.i(), 2131361964, 0).show();
      this.mExitTime = System.currentTimeMillis();
      return;
    }
    p.a().a(true);
    v.a().a(true);
    exit();
  }
  
  public void getA2Fail(int paramInt)
  {
    if (paramInt == 2)
    {
      if (isFinishing()) {
        return;
      }
      new WtloginCaptchaDialog(this.mmContext, this.fHandler, Long.toString(this.mUin)).show();
      return;
    }
    if (paramInt == -1000)
    {
      this.mmContext.dismissDialog();
      this.mmContext.showToast(2131361943);
      return;
    }
    if (paramInt == 8192)
    {
      this.mmContext.dismissDialog();
      this.mmContext.showToast(2131362089);
      return;
    }
    if ((paramInt == 1) || (paramInt == 15) || (paramInt == 16))
    {
      this.mmContext.dismissDialog();
      this.mmContext.showUserDialog(2131362364, getResources().getString(2131362365), 2131361800, new bf(this));
      return;
    }
    this.mmContext.dismissDialog();
    this.mmContext.showToast(2131362091);
  }
  
  public void getA2Succ()
  {
    af.a().a(this.mUin, this.mAqSig, this.fHandler, 2);
  }
  
  public TitleOptionMenu getDialogMenu()
  {
    return this.mDialogMenu;
  }
  
  public Button getRightTitleButton()
  {
    return this.mRightOptionButton;
  }
  
  public void gotoVerify(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {}
    do
    {
      return;
      this.mmContext = paramBaseActivity;
      paramBaseActivity = com.tencent.token.ax.a().e();
    } while (paramBaseActivity == null);
    this.mUin = paramBaseActivity.mRealUin;
    paramBaseActivity = "" + paramBaseActivity.mRealUin;
    x localx = x.a(RqdApplication.i());
    if (!localx.b(paramBaseActivity, 523005425L))
    {
      localx.a(paramBaseActivity, this.fHandler, 523005425L);
      showProDialog(this, 2131361808, 2131361817, null);
      return;
    }
    showUserDialog(2131362364, getResources().getString(2131362365), 2131361800, new be(this));
  }
  
  public void hideLockVerifyView() {}
  
  public void hideTitle()
  {
    if (this.mTitleBar == null) {
      return;
    }
    this.mTitleBar.setVisibility(8);
  }
  
  protected void hideToast()
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.mOrangeToast != null) {
        this.mOrangeToast.cancel();
      }
    } while (this.mDefaultToast == null);
    this.mDefaultToast.cancel();
  }
  
  protected boolean isProDialogShow()
  {
    return ((this.mProDialog != null) && (this.mProDialog.isShowing())) || ((this.mProDialogWithoutShutDown != null) && (this.mProDialogWithoutShutDown.isShowing()));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramInt1 == 32) || (paramInt1 == 34)) && (paramInt2 == 0)) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRes = getResources();
    mActivityList.add(this);
  }
  
  protected void onDestroy()
  {
    try
    {
      mActivityList.remove(this);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        e.c("remove activity list err=" + localException.getMessage());
      }
    }
  }
  
  protected void onPause()
  {
    if ((this.mDialogMenu != null) && (this.mDialogMenu.getVisibility() == 0)) {
      this.mDialogMenu.a();
    }
    cancelRequest();
    super.onPause();
  }
  
  protected void onResume()
  {
    sTopActivity = this;
    e.c("dualmsg:isForegrounde" + isForeground);
    if ((!isForeground) && (!IndexActivity.s_FromPush) && (!IndexActivity.s_FromOtherApp))
    {
      e.c("dualmsg:" + getClass().getName() + ":onresume: query=true");
      if (com.tencent.token.ax.a().e() != null) {
        af.a().a(com.tencent.token.av.a, this.fHandler);
      }
      isForeground = true;
      if (!s.b())
      {
        e.b("resetShouldShowLockPatternVerifyView");
        RqdApplication.b();
      }
      e.a("facepwd " + getClass() + ", face=" + RqdApplication.e() + ", gesture=" + RqdApplication.d());
      e.b("facepwd " + getClass() + ", nevershow=" + this.mNeverShowLockVerifyView + ", showonce=" + this.mShowLockVerifyViewOnce);
      if ((this.mNeverShowLockVerifyView) || (!RqdApplication.c())) {
        break label286;
      }
      doLockVerify();
    }
    for (;;)
    {
      super.onResume();
      return;
      e.c("dualmsg:" + getClass().getName() + ":onresume: query=false");
      break;
      label286:
      if ((this.mShowLockVerifyViewOnce) && (RqdApplication.c()))
      {
        doLockVerify();
        this.mShowLockVerifyViewOnce = false;
      }
      else
      {
        hideLockVerifyView();
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  protected void onStart()
  {
    super.onStart();
    gotobackground = false;
  }
  
  protected void onStop()
  {
    if (!s.c())
    {
      gotobackground = true;
      isForeground = false;
      p.a().b();
    }
    e.c("onStop:isForeground" + isForeground);
    super.onStop();
  }
  
  public void setBackArrowHide()
  {
    if (this.mBackArrow != null) {
      this.mBackArrow.setVisibility(8);
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2130903220);
    View localView = getLayoutInflater().inflate(paramInt, null);
    this.mContent = ((RelativeLayout)findViewById(2131297155));
    this.mContent.addView(localView, new RelativeLayout.LayoutParams(-1, -1));
    getContentView().setBackgroundDrawable(localView.getBackground());
    this.animLayout = ((RelativeLayout)findViewById(2131297158));
    this.lineImg = ((ImageView)findViewById(2131297159));
    this.arcImg = ((ImageView)findViewById(2131297160));
    initControllers();
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(2130903220);
    if (paramView != null)
    {
      this.mContent = ((RelativeLayout)findViewById(2131297155));
      this.mContent.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
      getContentView().setBackgroundDrawable(paramView.getBackground());
    }
    initControllers();
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      Class[] arrayOfClass = mNoBackActivity;
      int j = arrayOfClass.length;
      i = 0;
      if (i >= j) {
        break label85;
      }
      Class localClass = arrayOfClass[i];
      if (!getClass().equals(localClass)) {
        break label78;
      }
    }
    label78:
    label85:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.mBackArrow.setVisibility(0);
        this.mBackArrow.setOnClickListener(new bh(this));
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void setDefaultTitle()
  {
    try
    {
      ActivityInfo localActivityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
      if ((localActivityInfo == null) || (localActivityInfo.labelRes == 0))
      {
        hideTitle();
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject;
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        e.c(localNameNotFoundException.toString());
        localObject = null;
      }
      setTitle(localObject.labelRes);
    }
  }
  
  public void setNeverShowLockVerifyView()
  {
    this.mNeverShowLockVerifyView = true;
  }
  
  public void setRightTitleImage(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (this.mRightOptionImage == null)
    {
      ((ViewStub)findViewById(2131297156)).inflate();
      this.mDialogMenu = ((TitleOptionMenu)findViewById(2131297300));
      this.mRightOptionLayout = findViewById(2131296422);
      this.mRightOptionImage = ((ImageView)findViewById(2131296423));
    }
    this.mRightOptionLayout.setVisibility(0);
    this.mRightOptionImage.setImageResource(paramInt);
    this.mRightOptionLayout.setTag(this.mRightOptionImage);
    this.mRightOptionLayout.setOnClickListener(paramOnClickListener);
  }
  
  public void setRightTitleImageHide()
  {
    if (this.mRightOptionImage == null) {
      return;
    }
    this.mRightOptionLayout.setVisibility(8);
  }
  
  public void setShowLockVerifyViewOnce()
  {
    this.mShowLockVerifyViewOnce = true;
  }
  
  public void setTitle(int paramInt)
  {
    if ((this.mTitleBar == null) || (this.mTitleText == null)) {
      return;
    }
    this.mTitleBar.setVisibility(0);
    this.mTitleText.setText(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mTitleBar == null) || (this.mTitleText == null)) {
      return;
    }
    this.mTitleBar.setVisibility(0);
    this.mTitleText.setText(paramCharSequence);
  }
  
  public void showLockVerifyView()
  {
    Intent localIntent = new Intent(this, StartPwdGestureVerifyActivity.class);
    if ((this instanceof StartPwdGestureDeleteActivity))
    {
      localIntent.putExtra("startpwd_verify_source", 1);
      startActivityForResult(localIntent, 32);
      return;
    }
    if ((this instanceof StartPwdGestureModifyActivity))
    {
      localIntent.putExtra("startpwd_verify_source", 2);
      startActivityForResult(localIntent, 34);
      return;
    }
    localIntent.putExtra("startpwd_verify_source", 0);
    startActivity(localIntent);
  }
  
  public void showNoAccountTipDialog(BaseActivity paramBaseActivity, int paramInt1, int paramInt2)
  {
    dismissDialog();
    this.mmContext = paramBaseActivity;
    View localView = View.inflate(paramBaseActivity, 2130903055, null);
    Object localObject = (ImageView)localView.findViewById(2131296426);
    TextView localTextView1 = (TextView)localView.findViewById(2131296428);
    TextView localTextView2 = (TextView)localView.findViewById(2131296432);
    ImageView localImageView = (ImageView)localView.findViewById(2131296431);
    if (paramInt2 == 1)
    {
      ((ImageView)localObject).setImageResource(2130837529);
      localTextView1.setText(2131362698);
      localImageView.setVisibility(8);
      localTextView2.setVisibility(0);
    }
    for (int i = 1;; i = 0)
    {
      localObject = (TextView)localView.findViewById(2131296429);
      switch (paramInt1)
      {
      case 18: 
      case 19: 
      default: 
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362675));
      }
      for (;;)
      {
        if (i != 0) {
          ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362699));
        }
        ((ImageView)localView.findViewById(2131296433)).setOnClickListener(new bb(this));
        localView.findViewById(2131296430).setOnClickListener(new bc(this, paramInt2, paramBaseActivity));
        this.mDialog = new Dialog(this, 2131427443);
        this.mDialog.setContentView(localView);
        this.mDialog.setOnCancelListener(null);
        this.mDialog.show();
        return;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362674));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362676));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362677));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362678));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362679));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362680));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362681));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362682));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362683));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362684));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362685));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362686));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362687));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362688));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362689));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362690));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362691));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362675));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362675));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362675));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362675));
        continue;
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131362673));
      }
    }
  }
  
  public void showOrangeToast(int paramInt)
  {
    if (isFinishing()) {
      return;
    }
    showOrangeToast(getResources().getString(paramInt), 2130837961);
  }
  
  public void showOrangeToast(int paramInt1, int paramInt2)
  {
    if (isFinishing()) {
      return;
    }
    showOrangeToast(getResources().getString(paramInt1), paramInt2);
  }
  
  public void showOrangeToast(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    showOrangeToast(paramString, 2130837961);
  }
  
  protected void showOrangeToast(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (isFinishing())) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.mOrangeToast == null)
    {
      this.mOrangeToast = new Toast(this);
      localObject1 = getLayoutInflater().inflate(2130903218, null);
      this.mOrangeToast.setView((View)localObject1);
      this.mOrangeToast.setDuration(0);
      if (IndexActivity.S_TITLE_HEIGHT <= 0)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.mOrangeToast.setGravity(55, 0, ((DisplayMetrics)localObject1).heightPixels / 12);
      }
    }
    else
    {
      localObject2 = this.mOrangeToast.getView();
      localObject1 = (TextView)((View)localObject2).findViewById(2131296784);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131296783);
      if (localObject1 != null) {
        ((TextView)localObject1).setText(paramString);
      }
      if (localObject2 != null)
      {
        if (paramInt == 0) {
          break label198;
        }
        ((ImageView)localObject2).setBackgroundResource(paramInt);
        ((ImageView)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      this.mOrangeToast.show();
      return;
      this.mOrangeToast.setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
      break;
      label198:
      ((ImageView)localObject2).setVisibility(8);
    }
  }
  
  public void showProDialog(Activity paramActivity, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialog = new ProDialogWithShutDown(paramActivity, paramOnClickListener, getResources().getString(paramInt2));
    this.mProDialog.show();
  }
  
  public void showProDialog(Activity paramActivity, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialog = new ProDialogWithShutDown(paramActivity, paramOnClickListener, getResources().getString(paramInt2), paramBoolean);
    this.mProDialog.show();
  }
  
  public void showProDialog(Activity paramActivity, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialog = new ProDialogWithShutDown(paramActivity, paramOnClickListener, null);
    this.mProDialog.show();
  }
  
  protected void showProDialog(Activity paramActivity, int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialog = new ProDialogWithShutDown(paramActivity, paramOnClickListener, paramString);
    this.mProDialog.show();
  }
  
  protected void showProDialogWithoutShutDown(Activity paramActivity, String paramString)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialogWithoutShutDown = new ProDialog(paramActivity, paramString);
    this.mProDialogWithoutShutDown.show();
  }
  
  public void showToast(int paramInt)
  {
    if (isFinishing()) {
      return;
    }
    showToast(getResources().getString(paramInt));
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
      this.mDefaultToast.setGravity(48, 0, IndexActivity.S_TITLE_HEIGHT + 5);
      this.mDefaultToast.show();
      return;
      this.mDefaultToast.setText(paramString);
    }
  }
  
  protected void showUserDialog(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    default: 
      return;
    case 9: 
      showUserDialog(2131361808, this.mRes.getString(2131362193), 2131362297, 2131361804, new bi(this), null);
      return;
    case 5: 
      showUserDialog(2131361808, this.mRes.getString(2131361971), 2131361800, new bj(this));
      return;
    case 1: 
      h localh = h.b();
      if (3 == localh.a)
      {
        showUserDialog(2131361961, localh.f, 2131361962, new bk(this));
        return;
      }
      showUserDialog(2131361961, localh.f, 2131361962, 2131361963, new bl(this), new bm(this));
      return;
    case 3: 
      showUserDialog(2131361808, this.mRes.getString(2131361969), 2131361800, null);
      return;
    case 4: 
      showUserDialog(2131361808, this.mRes.getString(2131361818), 2131361800, 2131361804, new bn(this), null);
      return;
    case 2: 
      showProDialog(this, 2131361967, 2131361968, null);
      return;
    case 8: 
      showUserDialog(2131361808, this.mRes.getString(2131361943), 2131361800, new at(this));
      return;
    case 6: 
      showProDialog(this, 2131361896, 2131361897, null);
      return;
    case 7: 
      showProDialog(this, 2131361999, 2131361918, null);
      return;
    case 11: 
      showProDialog(this, 2131362070, 2131362069, null);
      return;
    }
    showProDialog(this, 2131361808, 2131361816, null);
  }
  
  public void showUserDialog(int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mDialog = new Dialog(this, 2131427445);
    this.mDialog.setContentView(2130903073);
    TextView localTextView1 = (TextView)this.mDialog.findViewById(2131296514);
    localTextView1.setText(paramInt3);
    TextView localTextView2 = (TextView)this.mDialog.findViewById(2131296404);
    if (paramInt1 == 0)
    {
      localTextView2.setVisibility(8);
      ((TextView)this.mDialog.findViewById(2131296512)).setText(paramInt2);
      if (paramOnClickListener == null) {
        break label152;
      }
      localTextView1.setOnClickListener(paramOnClickListener);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.mDialog.setOnCancelListener(new aw(this, localTextView1));
      }
      this.mDialog.show();
      return;
      localTextView2.setText(paramInt1);
      break;
      label152:
      localTextView1.setOnClickListener(new av(this));
    }
  }
  
  public void showUserDialog(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mDialog = new Dialog(this, 2131427445);
    this.mDialog.setContentView(paramInt);
    Button localButton = (Button)this.mDialog.findViewById(2131296514);
    if (localButton != null) {
      localButton.setOnClickListener(paramOnClickListener);
    }
    this.mDialog.setOnCancelListener(new au(this, localButton));
    this.mDialog.show();
  }
  
  public void showUserDialog(int paramInt1, String paramString, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    showBaseUserDialogBtn(2, paramInt1, paramString, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public void showUserDialog(int paramInt1, String paramString, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    showBaseUserDialogBtn(2, paramInt1, paramString, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener);
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
  
  protected void showUserDialog(int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    showBaseUserDialogBtn(2, paramInt, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  protected void showUserDialog(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    showBaseUserDialogBtn(1, 2131361808, paramString, 2131361800, 0, null, null, null);
  }
  
  public void showUserDialogWithCancel(int paramInt, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mDialog = new Dialog(this, 2131427443);
    this.mDialog.setContentView(paramInt);
    Button localButton = (Button)this.mDialog.findViewById(2131296514);
    if (localButton != null) {
      localButton.setOnClickListener(paramOnClickListener);
    }
    this.mDialog.setOnCancelListener(paramOnCancelListener);
    this.mDialog.setCanceledOnTouchOutside(true);
    this.mDialog.show();
  }
  
  public void showUserDialogWithCancel(View paramView, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mDialog = new Dialog(this, 2131427443);
    this.mDialog.setContentView(paramView);
    paramView = (Button)this.mDialog.findViewById(2131296514);
    if (paramView != null) {
      paramView.setOnClickListener(paramOnClickListener);
    }
    this.mDialog.setOnCancelListener(paramOnCancelListener);
    this.mDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */