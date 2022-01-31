package com.tencent.token.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.tencent.token.ch;
import com.tencent.token.cn;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.j;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.dm;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ProDialog;
import com.tencent.token.ui.base.ProDialogWithShutDown;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.WtloginCaptchaDialog;
import com.tencent.token.upload.useraction.a;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import com.tmsdk.TMSDKContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oicq.wlogin_sdk.tools.ErrMsg;

public class BaseActivity
  extends Activity
  implements aax
{
  public static final int ADD_ACCOUNT_TIP_ACCOUNT_LOCK = 11;
  public static final int ADD_ACCOUNT_TIP_FACE = 20;
  public static final int ADD_ACCOUNT_TIP_FACE_CHANGEPSW = 24;
  public static final int ADD_ACCOUNT_TIP_FACE_FREEZE = 25;
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
  private static final Class[] mNoBackActivity = { AccountPageActivity.class, UtilsActivity.class };
  public static Activity sTopActivity;
  protected RelativeLayout animLayout;
  protected ImageView arcImg;
  private Handler.Callback callback = new be(this);
  protected final Handler fHandler = new bp(this);
  protected ImageView lineImg;
  protected byte[] mAqSig;
  protected View mBackArrow;
  protected ImageView mBackArrowImg;
  private RelativeLayout mContent;
  private Toast mDefaultToast;
  private Dialog mDialog;
  private TitleOptionMenu mDialogMenu;
  private long mExitTime = 0L;
  private boolean mNeverShowLockVerifyView = false;
  private Toast mOrangeToast;
  private dy mPermissonListener;
  private ProDialogWithShutDown mProDialog;
  private ProDialog mProDialogWithoutShutDown;
  private Resources mRes;
  private Button mRightOptionButton;
  public ImageView mRightOptionImage;
  protected View mRightOptionLayout;
  private boolean mShowLockVerifyViewOnce = false;
  private int mSourceScene;
  protected View mTitleBar;
  protected View mTitleDivider;
  protected TextView mTitleText;
  private int mType = 1;
  protected long mUin;
  private BaseActivity mmContext;
  private float startY;
  
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
        h.c("remove activity list err=" + localException.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  private void doLockVerify()
  {
    if (RqdApplication.h())
    {
      localIntent = new Intent(this, FaceStartVryCameraActivity.class);
      localIntent.putExtra("flag", 2);
      localIntent.putExtra("istry", 0);
      localIntent.putExtra("scene", 5);
      startActivity(localIntent);
    }
    while (!RqdApplication.g())
    {
      Intent localIntent;
      return;
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
    cp.a(getApplicationContext()).a(this.mmContext, 523005419L, this.fHandler, "" + localQQUser.b());
  }
  
  private void initControllers()
  {
    this.mTitleBar = findViewById(2131558691);
    this.mTitleText = ((TextView)findViewById(2131558692));
    this.mTitleDivider = findViewById(2131558697);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTitleBar.getLayoutParams();
    if (IndexActivity.S_RES_HEIGHT > 0) {
      localMarginLayoutParams.height = IndexActivity.S_TITLE_HEIGHT;
    }
    this.mBackArrow = findViewById(2131558693);
    this.mBackArrowImg = ((ImageView)findViewById(2131558694));
    this.mRightOptionButton = ((Button)findViewById(2131559307));
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
  
  private void showBaseUserDialogBtn(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    String str1 = null;
    if (paramInt3 != 0) {}
    try
    {
      str1 = getResources().getString(paramInt3);
      String str2 = null;
      if (paramInt4 != 0) {
        str2 = getResources().getString(paramInt4);
      }
      showBaseUserDialogBtn(paramInt1, paramInt2, paramString, str1, str2, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void showBaseUserDialogBtn(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    for (;;)
    {
      TextView localTextView3;
      TextView localTextView4;
      try
      {
        if (isFinishing()) {
          return;
        }
        this.mDialog = new Dialog(this, 2131362155);
        if (paramInt1 == 1)
        {
          this.mDialog.setContentView(2130968637);
          localTextView2 = (TextView)this.mDialog.findViewById(2131558797);
          localTextView1 = null;
          localTextView3 = (TextView)this.mDialog.findViewById(2131558419);
          localTextView4 = (TextView)this.mDialog.findViewById(2131558795);
          if (paramInt2 != 0) {
            break label255;
          }
          localTextView3.setVisibility(8);
          if (paramString1 == null) {
            break label264;
          }
          localTextView4.setText(paramString1);
          if (paramString2 != null) {
            localTextView2.setText(paramString2);
          }
          if (paramOnClickListener1 == null) {
            break label274;
          }
          localTextView2.setOnClickListener(new bg(this, paramOnClickListener1));
          if (localTextView1 != null)
          {
            if (paramOnClickListener2 == null) {
              break label290;
            }
            if (paramString3 != null) {
              localTextView1.setText(paramString3);
            }
            localTextView1.setOnClickListener(new bi(this, paramOnClickListener2));
          }
          if (paramOnCancelListener != null) {
            this.mDialog.setOnCancelListener(paramOnCancelListener);
          }
          this.mDialog.setCanceledOnTouchOutside(true);
          this.mDialog.show();
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      this.mDialog.setContentView(2130968638);
      TextView localTextView2 = (TextView)this.mDialog.findViewById(2131558799);
      TextView localTextView1 = (TextView)this.mDialog.findViewById(2131558797);
      continue;
      label255:
      localTextView3.setText(paramInt2);
      continue;
      label264:
      localTextView4.setVisibility(8);
      continue;
      label274:
      localTextView2.setOnClickListener(new bh(this));
      continue;
      label290:
      localTextView1.setOnClickListener(new bj(this));
    }
  }
  
  private void showUserDialogHasCancel(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    showUserDialog(2131230843, paramString, paramInt, 2131230886, paramOnClickListener, null);
  }
  
  private void showUserDialogNoCancel(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    showUserDialog(2131230843, paramString, paramInt, paramOnClickListener);
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
  
  protected void exit()
  {
    Iterator localIterator = mActivityList.iterator();
    while (localIterator.hasNext()) {
      ((Activity)localIterator.next()).finish();
    }
  }
  
  protected void exitToken()
  {
    if (System.currentTimeMillis() - this.mExitTime > Long.parseLong(getResources().getString(2131231502)))
    {
      Toast.makeText(RqdApplication.l(), 2131231501, 0).show();
      this.mExitTime = System.currentTimeMillis();
      return;
    }
    ch.a().a(true);
    cn.a().a(true);
    exit();
  }
  
  public void getA2Fail(Message paramMessage, int paramInt)
  {
    if (paramInt == 2)
    {
      if (isFinishing()) {
        return;
      }
      new WtloginCaptchaDialog(this.mmContext, 2131362182, this.fHandler, Long.toString(this.mUin)).show();
      return;
    }
    if (paramInt == -1000)
    {
      this.mmContext.dismissDialog();
      this.mmContext.showToast(2131230960);
      return;
    }
    if (paramInt == 8192)
    {
      this.mmContext.dismissDialog();
      this.mmContext.showToast(2131231407);
      return;
    }
    if ((paramInt == 1) || (paramInt == 15) || (paramInt == 16))
    {
      this.mmContext.dismissDialog();
      this.mmContext.showUserDialog(2131231654, getResources().getString(2131231653), 2131230897, new bn(this));
      return;
    }
    if ((paramInt == 40) || (paramInt == 42) || (paramInt == 64))
    {
      this.mmContext.dismissDialog();
      goToRemoveProtectH5(this.mmContext, paramMessage, paramInt);
      return;
    }
    this.mmContext.dismissDialog();
    this.mmContext.showToast(2131231411);
  }
  
  public void getA2Succ()
  {
    cw.a().a(this.mUin, this.mAqSig, this.fHandler, this.mType);
  }
  
  public TitleOptionMenu getDialogMenu()
  {
    return this.mDialogMenu;
  }
  
  public Button getRightTitleButton()
  {
    return this.mRightOptionButton;
  }
  
  public void goToRemoveProtectH5(Context paramContext, Message paramMessage, int paramInt)
  {
    if (paramMessage == null) {
      return;
    }
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
    {
      showUserDialog(2131230843, paramMessage.getData().getString("loginerror"), 2131230886, 2131230897, new bo(this), new br(this, paramInt, paramMessage, paramContext));
      return;
    }
    showUserDialog(2131230843, getResources().getString(2131231411), 2131230897, null);
  }
  
  public void goToRemoveProtectH5WithLoginTask(Context paramContext, String paramString, ErrMsg paramErrMsg, int paramInt)
  {
    showUserDialog(2131230843, paramString, 2131230886, 2131230897, new bs(this), new bt(this, paramInt, paramErrMsg, paramContext));
  }
  
  public void gotoVerify(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {}
    do
    {
      return;
      this.mmContext = paramBaseActivity;
      paramBaseActivity = do.a().e();
    } while (paramBaseActivity == null);
    this.mUin = paramBaseActivity.mRealUin;
    paramBaseActivity = "" + paramBaseActivity.mRealUin;
    cp localcp = cp.a(RqdApplication.l());
    if (!localcp.b(paramBaseActivity, 523005419L))
    {
      localcp.a(paramBaseActivity, this.fHandler, 523005419L);
      showProDialog(this, 2131230843, 2131231298, null);
      this.mType = 1;
      return;
    }
    showUserDialog(2131231654, getResources().getString(2131231653), 2131230897, new bm(this));
  }
  
  public void hideLockVerifyView() {}
  
  public void hideTitle()
  {
    if (this.mTitleBar == null) {
      return;
    }
    this.mTitleBar.setVisibility(8);
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
      dismissDialog();
      mActivityList.remove(this);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.c("remove activity list err=" + localException.getMessage());
      }
    }
  }
  
  protected void onPause()
  {
    if ((this.mDialogMenu != null) && (this.mDialogMenu.getVisibility() == 0)) {
      this.mDialogMenu.b();
    }
    cancelRequest();
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        if (paramArrayOfInt.length > 0)
        {
          localArrayList = new ArrayList();
          paramInt = 0;
          if (paramInt >= paramArrayOfInt.length) {
            break label58;
          }
          if (paramArrayOfInt[paramInt] == 0) {
            break label104;
          }
          localArrayList.add(paramArrayOfString[paramInt]);
        }
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
      }
      label58:
      do
      {
        do
        {
          return;
          if (localArrayList.isEmpty()) {
            break;
          }
        } while (this.mPermissonListener == null);
        this.mPermissonListener.a(localArrayList);
        return;
      } while (this.mPermissonListener == null);
      this.mPermissonListener.a();
      return;
      label104:
      paramInt += 1;
    }
  }
  
  protected void onResume()
  {
    sTopActivity = this;
    h.c("dualmsg:isForegrounde" + isForeground);
    if ((!isForeground) && (!IndexActivity.s_FromPush) && (!IndexActivity.s_FromOtherApp))
    {
      h.c("dualmsg:" + getClass().getName() + ":onresume: query=true");
      if (do.a().e() != null) {
        cw.a().a(0L, dm.a, this.fHandler);
      }
      isForeground = true;
      if (!w.b())
      {
        h.b("resetShouldShowLockPatternVerifyView");
        RqdApplication.e();
      }
      h.a("facepwd " + getClass() + ", face=" + RqdApplication.h() + ", gesture=" + RqdApplication.g());
      h.b("facepwd " + getClass() + ", nevershow=" + this.mNeverShowLockVerifyView + ", showonce=" + this.mShowLockVerifyViewOnce);
      if ((this.mNeverShowLockVerifyView) || (!RqdApplication.f())) {
        break label287;
      }
      doLockVerify();
    }
    for (;;)
    {
      super.onResume();
      return;
      h.c("dualmsg:" + getClass().getName() + ":onresume: query=false");
      break;
      label287:
      if ((this.mShowLockVerifyViewOnce) && (RqdApplication.f()))
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
    if (!w.c())
    {
      gotobackground = true;
      isForeground = false;
      ch.a().b();
    }
    h.c("onStop:isForeground" + isForeground);
    super.onStop();
  }
  
  public void requestRuntimePermissions(String[] paramArrayOfString, dy paramdy)
  {
    if ((Build.VERSION.SDK_INT < 23) && (paramdy != null))
    {
      paramdy.a();
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        this.mPermissonListener = paramdy;
        paramdy = new ArrayList();
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = paramArrayOfString[i];
          if (ContextCompat.checkSelfPermission(this, str) == 0) {
            break label126;
          }
          paramdy.add(str);
          break label126;
        }
        if (!paramdy.isEmpty())
        {
          ActivityCompat.requestPermissions(this, (String[])paramdy.toArray(new String[paramdy.size()]), 1);
          return;
        }
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
      if (this.mPermissonListener == null) {
        break;
      }
      this.mPermissonListener.a();
      return;
      label126:
      i += 1;
    }
  }
  
  public void setBackArrowHide()
  {
    if (this.mBackArrow != null) {
      this.mBackArrow.setVisibility(8);
    }
  }
  
  public void setContentView(int paramInt)
  {
    int i = 0;
    super.setContentView(2130968782);
    Object localObject1 = getLayoutInflater().inflate(paramInt, null);
    this.mContent = ((RelativeLayout)findViewById(2131559316));
    this.mContent.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, -1));
    getContentView().setBackgroundDrawable(((View)localObject1).getBackground());
    this.animLayout = ((RelativeLayout)findViewById(2131559319));
    this.lineImg = ((ImageView)findViewById(2131559320));
    this.arcImg = ((ImageView)findViewById(2131559321));
    initControllers();
    localObject1 = mNoBackActivity;
    int k = localObject1.length;
    int j = 0;
    paramInt = i;
    i = j;
    while (paramInt < k)
    {
      Object localObject2 = localObject1[paramInt];
      if (getClass().equals(localObject2)) {
        i = 1;
      }
      paramInt += 1;
    }
    if (i == 0)
    {
      if ((getClass().toString().contains("StartPwd")) && (!getClass().toString().contains("StartPwdGestureIndex"))) {
        x.a(this, this.mTitleBar, 2131493039);
      }
    }
    else {
      return;
    }
    x.a(this, this.mTitleBar, 2131492909);
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(2130968782);
    if (paramView != null)
    {
      this.mContent = ((RelativeLayout)findViewById(2131559316));
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
        this.mBackArrow.setOnClickListener(new bu(this));
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
        h.c(localNameNotFoundException.toString());
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
      ((ViewStub)findViewById(2131559317)).inflate();
      this.mDialogMenu = ((TitleOptionMenu)findViewById(2131559461));
      this.mRightOptionLayout = findViewById(2131558695);
      this.mRightOptionImage = ((ImageView)findViewById(2131558696));
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
    this.mSourceScene = paramInt1;
    View localView = View.inflate(paramBaseActivity, 2130968620, null);
    Object localObject = (ImageView)localView.findViewById(2131558716);
    TextView localTextView1 = (TextView)localView.findViewById(2131558718);
    TextView localTextView2 = (TextView)localView.findViewById(2131558722);
    ImageView localImageView = (ImageView)localView.findViewById(2131558721);
    if (paramInt2 == 1)
    {
      this.mmContext = paramBaseActivity;
      ((ImageView)localObject).setImageResource(2130837606);
      localTextView1.setText(2131231612);
      localImageView.setVisibility(8);
      localTextView2.setVisibility(0);
      TMSDKContext.SaveStringData(1150088, paramInt1 + "");
      localObject = (TextView)localView.findViewById(2131558719);
      switch (paramInt1)
      {
      case 18: 
      case 19: 
      default: 
        ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230812));
      }
    }
    for (;;)
    {
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131231611));
      ((ImageView)localView.findViewById(2131558723)).setOnClickListener(new bk(this));
      localView.findViewById(2131558720).setOnClickListener(new bl(this, paramInt2, paramBaseActivity));
      this.mDialog = new Dialog(this, 2131362064);
      this.mDialog.setContentView(localView);
      this.mDialog.setOnCancelListener(null);
      this.mDialog.show();
      return;
      paramBaseActivity = new Intent(paramBaseActivity, WtLoginAccountInput.class);
      paramBaseActivity.putExtra("page_id", 4);
      startActivity(paramBaseActivity);
      return;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230823));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230819));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230830));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230825));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230827));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230821));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230828));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230822));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230811));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230824));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230813));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230820));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230817));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230816));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230815));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230818));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230826));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230812));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230812));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230812));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230812));
      continue;
      ((TextView)localObject).setText(paramBaseActivity.getResources().getString(2131230814));
    }
  }
  
  public void showOrangeToast(int paramInt1, int paramInt2)
  {
    if (isFinishing()) {
      return;
    }
    showOrangeToast(getResources().getString(paramInt1), paramInt2);
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
      localObject1 = getLayoutInflater().inflate(2130968780, null);
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
      localObject1 = (TextView)((View)localObject2).findViewById(2131558987);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131558986);
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
    this.mProDialog = new ProDialogWithShutDown(paramActivity, 2131362182, paramOnClickListener, getResources().getString(paramInt2));
    this.mProDialog.show();
  }
  
  public void showProDialog(Activity paramActivity, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialog = new ProDialogWithShutDown(paramActivity, 2131362182, paramOnClickListener, null);
    this.mProDialog.show();
  }
  
  protected void showProDialog(Activity paramActivity, int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialog = new ProDialogWithShutDown(paramActivity, 2131362182, paramOnClickListener, paramString);
    this.mProDialog.show();
  }
  
  protected void showProDialogWithoutShutDown(Activity paramActivity, String paramString)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialogWithoutShutDown = new ProDialog(paramActivity, 2131362182, paramString);
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
      showUserDialogHasCancel(this.mRes.getString(2131231535), 2131230778, new bv(this));
      return;
    case 5: 
      showUserDialogNoCancel(this.mRes.getString(2131231203), 2131230897, new bw(this));
      return;
    case 1: 
      j localj = j.b();
      if (3 == localj.a)
      {
        showUserDialog(2131231521, localj.f, 2131231520, new bx(this));
        return;
      }
      showUserDialog(2131231521, localj.f, 2131231520, 2131231523, new by(this), new bz(this));
      return;
    case 3: 
      showUserDialogNoCancel(this.mRes.getString(2131231432), 2131230897, null);
      return;
    case 4: 
      showUserDialogHasCancel(this.mRes.getString(2131230940), 2131230897, new ca(this));
      return;
    case 2: 
      showProDialog(this, 2131231429, 2131231430, null);
      return;
    case 8: 
      showUserDialogNoCancel(this.mRes.getString(2131230960), 2131230897, new bf(this));
      return;
    case 6: 
      showProDialog(this, 2131230919, 2131230915, null);
      return;
    case 7: 
      showProDialog(this, 2131231455, 2131231392, null);
      return;
    case 11: 
      showProDialog(this, 2131231423, 2131231424, null);
      return;
    }
    showProDialog(this, 2131230843, 2131231299, null);
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
    showBaseUserDialogBtn(1, 2131230843, paramString, 2131230897, 0, null, null, null);
  }
  
  public void showUserDialogWithCancel(int paramInt, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mDialog = new Dialog(this, 2131362064);
    this.mDialog.setContentView(paramInt);
    Button localButton = (Button)this.mDialog.findViewById(2131558797);
    if (localButton != null)
    {
      localButton.setOnClickListener(paramOnClickListener1);
      localButton.setText(paramString);
    }
    ((TextView)this.mDialog.findViewById(2131559154)).setText(x.a(getResources().getString(2131231481), getResources().getDimension(2131296401), (int)(245.0F * IndexActivity.S_DENSITY)));
    this.mDialog.findViewById(2131559314).setOnClickListener(paramOnClickListener2);
    this.mDialog.setOnCancelListener(paramOnCancelListener);
    this.mDialog.setCanceledOnTouchOutside(true);
    this.mDialog.show();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */