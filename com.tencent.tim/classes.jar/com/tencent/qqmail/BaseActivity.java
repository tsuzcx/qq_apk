package com.tencent.qqmail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.apache.commons.io.FileUtils;

public class BaseActivity
  extends AppCompatActivity
  implements BaseActivityImpl.PageProvider
{
  public static final String CONTROLLER_COMPOSE = "compose";
  public static final String CONTROLLER_CONTACT_DETAIL = "contactdetail";
  public static final String CONTROLLER_FOLDER = "folder";
  public static final String CONTROLLER_OTHERAPP = "otherapp";
  public static final String CONTROLLER_POPULARIZE = "popularize";
  public static final String CONTROLLER_READMAIL = "readmail";
  public static final String CONTROLLER_SCREENSHOT_REPLY = "CONTROLLER_SCREENSHOT_REPLY";
  public static final String CONTROLLER_SENDLIST = "sendlist";
  public static final String CONTROLLER_SETTING = "setting";
  public static final String FROM_ACTIVITY = "fromActivity";
  public static final String FROM_CONTROLLER = "fromController";
  public static final int RESULT_BACK = 2;
  private static final String TAG = "BaseActivity";
  public static final String TO_CONTROLLER = "toController";
  private static HashMap<Runnable, Runnable> mapToMainHandler = new HashMap();
  public static final int notification_id = 19831204;
  private int bgColor;
  private QMBaseView mBaseView;
  private BaseActivityImpl.PrivateAccess mPrivateAccess = new BaseActivity.5(this);
  private BaseActivityImpl mQMBaseActivityImpl;
  private QMTopBar mTopBar;
  
  private File extendFileByAccount(String paramString)
  {
    Log.i("BaseActivity", "Step 1");
    Object localObject = QMAppInterface.getRuntime();
    Log.i("BaseActivity", "Step 2");
    localObject = ((AppRuntime)localObject).getAccount();
    Log.i("BaseActivity", "Step 3");
    paramString = paramString + File.separator + (String)localObject;
    localObject = new File(paramString);
    try
    {
      FileUtils.forceMkdir((File)localObject);
      Log.i("BaseActivity", "Extended " + paramString);
      return localObject;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      QMLog.log(4, "BaseActivity", "extendFileByAccount fail " + paramString);
    }
    return null;
  }
  
  public static void removeCallbackOnMain(Runnable paramRunnable)
  {
    paramRunnable = (Runnable)mapToMainHandler.remove(paramRunnable);
    if (paramRunnable != null) {
      Threads.removeCallbackOnMain(paramRunnable);
    }
  }
  
  private void setWindowBackgroundColor()
  {
    ColorDrawable localColorDrawable = new ColorDrawable(this.bgColor);
    getWindow().setBackgroundDrawable(localColorDrawable);
  }
  
  protected void Notices(String paramString, Intent paramIntent, int paramInt)
  {
    QMUIHelper.qqmailNotice(this, paramString, paramInt, 19831204);
  }
  
  public boolean canEnterComposeMailActivity()
  {
    return this.mQMBaseActivityImpl.canEnterComposeMailActivity();
  }
  
  public boolean canEnterComposeNoteActivity()
  {
    return this.mQMBaseActivityImpl.canEnterComposeNoteActivity();
  }
  
  protected boolean canEnterOtherActivity()
  {
    return this.mQMBaseActivityImpl.canEnterOtherActivity();
  }
  
  protected boolean checkGesturePassword()
  {
    return true;
  }
  
  protected boolean checkWelcomePopularize()
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mQMBaseActivityImpl.dispatchTouchEvent(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void finish()
  {
    this.mQMBaseActivityImpl.finish();
  }
  
  public void finishActivity(int paramInt)
  {
    this.mQMBaseActivityImpl.finishActivity(paramInt);
  }
  
  public void finishWithNoCheck()
  {
    this.mQMBaseActivityImpl.finishWithNoCheck();
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  protected BaseActivityImpl getBaseActivityImpl()
  {
    return this.mQMBaseActivityImpl;
  }
  
  public File getCacheDir()
  {
    File localFile2 = extendFileByAccount(super.getCacheDir().getAbsolutePath());
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = super.getCacheDir();
    }
    return localFile1;
  }
  
  public File getDataDir()
  {
    Log.i("BaseActivity", "getDataDir");
    File localFile2 = extendFileByAccount(super.getDataDir().getAbsolutePath());
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = super.getDataDir();
    }
    return localFile1;
  }
  
  public File getDir(String paramString, int paramInt)
  {
    File localFile2 = extendFileByAccount(super.getDir(paramString, paramInt).getAbsolutePath());
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = super.getDir(paramString, paramInt);
    }
    return localFile1;
  }
  
  public File getFilesDir()
  {
    File localFile2 = extendFileByAccount(super.getFilesDir().getAbsolutePath());
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = super.getFilesDir();
    }
    return localFile1;
  }
  
  public Intent getIntent()
  {
    return SafeIntent.createSafeIntet(super.getIntent());
  }
  
  public QMTips getTips()
  {
    return this.mQMBaseActivityImpl.getTips();
  }
  
  public QMTopBar getTopBar()
  {
    ViewGroup localViewGroup;
    if (this.mTopBar == null) {
      if (this.mBaseView == null) {
        localViewGroup = (ViewGroup)getWindow().getDecorView().findViewById(16908290);
      }
    }
    try
    {
      this.mBaseView = ((QMBaseView)localViewGroup.getChildAt(0));
      this.mTopBar = this.mBaseView.addTopBar();
      this.mTopBar.setButtonLeftOnclickListener(new BaseActivity.1(this));
      this.mTopBar.setCenterOnclickListener(new BaseActivity.2(this));
      return this.mTopBar;
    }
    catch (ClassCastException localClassCastException)
    {
      QMLog.log(6, "BaseActivity", localClassCastException.getLocalizedMessage());
    }
    return null;
  }
  
  public boolean hideKeyBoard()
  {
    return this.mQMBaseActivityImpl.hideKeyBoard();
  }
  
  protected QMBaseView initBaseView(Context paramContext)
  {
    this.mBaseView = new QMBaseView(paramContext);
    setContentView(this.mBaseView);
    getTopBar();
    return this.mBaseView;
  }
  
  protected QMBaseView initBaseView(Context paramContext, int paramInt)
  {
    initBaseView(paramContext);
    LayoutInflater.from(this).inflate(paramInt, this.mBaseView);
    return this.mBaseView;
  }
  
  protected QMBaseView initScrollView(Context paramContext)
  {
    initBaseView(paramContext);
    this.mBaseView.initScrollView();
    if (this.mTopBar != null) {
      this.mTopBar.bringToFront();
    }
    this.mBaseView.setBackgroundColor(ActivityCompat.getColor(this, 2131167681));
    return this.mBaseView;
  }
  
  public void initTips(QMTips paramQMTips) {}
  
  protected boolean isActivityResumed()
  {
    return this.mQMBaseActivityImpl.isActivityResumed();
  }
  
  public boolean isDestroyed()
  {
    return this.mQMBaseActivityImpl.isDestroyed();
  }
  
  protected boolean isFadeBackground()
  {
    return this.mQMBaseActivityImpl.isFadeBackground();
  }
  
  protected boolean isMultiStartAllowed()
  {
    return false;
  }
  
  public boolean isPage(Class<?> paramClass)
  {
    return paramClass.isAssignableFrom(getClass());
  }
  
  public void myCalendarRemindDialog(int paramInt, String paramString)
  {
    this.mQMBaseActivityImpl.myCalendarRemindDialog(paramInt, paramString);
  }
  
  public void onBackPressed()
  {
    QMLog.log(4, "BaseActivity", "onBackPressed: " + toString());
    super.onBackPressed();
  }
  
  protected void onButtonBackClick()
  {
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (getResources().getConfiguration().orientation == 2) {}
    do
    {
      while (paramConfiguration.hardKeyboardHidden == 1)
      {
        return;
        if (getResources().getConfiguration().orientation != 1) {}
      }
    } while (paramConfiguration.hardKeyboardHidden != 2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QMLog.getTrace("t");
    this.mQMBaseActivityImpl = new BaseActivityImpl(this, this.mPrivateAccess);
    this.mQMBaseActivityImpl.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.mQMBaseActivityImpl.onDestroy();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onJustDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QMLog.log(4, "BaseActivity", "onNewIntent: " + toString());
  }
  
  public void onPause()
  {
    this.mQMBaseActivityImpl.onPause();
    registerNotification(false);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    QMLog.log(4, "BaseActivity", "onRestart: " + toString());
  }
  
  public void onResume()
  {
    registerNotification(true);
    this.mQMBaseActivityImpl.onResume();
  }
  
  public void onStart()
  {
    this.mQMBaseActivityImpl.onStart();
  }
  
  public void onStop()
  {
    this.mQMBaseActivityImpl.onStop();
  }
  
  protected void onTopBarCenterClick()
  {
    this.mBaseView.scrollToTop();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2) {}
  
  protected void registerNotification(boolean paramBoolean)
  {
    this.mQMBaseActivityImpl.registerNotification(paramBoolean);
  }
  
  public void runInBackground(Runnable paramRunnable)
  {
    Threads.runInBackground(paramRunnable);
  }
  
  public void runInBackground(Runnable paramRunnable, long paramLong)
  {
    Threads.runInBackground(paramRunnable, paramLong);
  }
  
  public void runOnMainThread(Runnable paramRunnable)
  {
    runOnMainThread(paramRunnable, 0L);
  }
  
  public void runOnMainThread(Runnable paramRunnable, long paramLong)
  {
    BaseActivity.4 local4 = new BaseActivity.4(this, paramRunnable);
    mapToMainHandler.put(paramRunnable, local4);
    Threads.runOnMainThread(local4, paramLong);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    StatusBarUtil.immerseWhite(this);
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    StatusBarUtil.immerseWhite(this);
  }
  
  public void setFadeBackground()
  {
    this.mQMBaseActivityImpl.setFadeBackground();
  }
  
  protected void setWindowBackgroundColor(int paramInt1, int paramInt2)
  {
    this.bgColor = paramInt1;
    if (paramInt2 > 0)
    {
      Threads.runOnMainThread(new BaseActivity.3(this), paramInt2);
      return;
    }
    setWindowBackgroundColor();
  }
  
  protected void setWindowBackgroundColor(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 500;; i = 0)
    {
      setWindowBackgroundColor(paramInt, i);
      return;
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.mQMBaseActivityImpl.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.mQMBaseActivityImpl.startActivityForResult(paramIntent, paramInt);
  }
  
  public void toast(int paramInt1, int paramInt2)
  {
    this.mQMBaseActivityImpl.toast(getString(paramInt1), paramInt2);
  }
  
  public void toast(String paramString, int paramInt)
  {
    this.mQMBaseActivityImpl.toast(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivity
 * JD-Core Version:    0.7.0.1
 */