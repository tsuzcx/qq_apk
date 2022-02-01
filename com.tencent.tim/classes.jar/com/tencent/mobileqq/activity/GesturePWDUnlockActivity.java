package com.tencent.mobileqq.activity;

import acfd;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import anpc;
import aqha;
import aqhv;
import aqik;
import aqju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.DisplayMode;
import com.tencent.mobileqq.gesturelock.LockPatternView.a;
import com.tencent.mobileqq.gesturelock.LockPatternView.b;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import vcv;
import vcw;
import vcx;
import vcy;
import zym;

public class GesturePWDUnlockActivity
  extends BaseActivity
  implements View.OnClickListener, Animation.AnimationListener, LockPatternView.b
{
  public static boolean aXo;
  private TextView DF;
  LockPatternView a;
  private int[] aG;
  String aNt = "";
  String aNu = "";
  boolean aXk = false;
  private boolean aXl;
  boolean aXm = false;
  private boolean aXn = true;
  int bHH = 5;
  private View bl;
  acfd c = new vcx(this);
  public ImageView cY;
  public long createTime = 0L;
  private TextView dS;
  private TextView dT;
  private float density = 1.0F;
  private long[] e;
  private aqju g;
  private BroadcastReceiver mBroadcastReceiver = new vcy(this);
  private String nF = "";
  private int xq;
  private int xr = 5;
  private int xu;
  
  private void eM(View paramView)
  {
    this.xq = 0;
    this.xr = 5;
    this.e = new long[] { 50L, 100L, 100L, 100L, 100L };
    this.aG = new int[] { (int)(-20.0F * this.density), (int)(20.0F * this.density), (int)(-15.0F * this.density), (int)(15.0F * this.density), 0 };
    this.bl = paramView;
    qH();
  }
  
  private void initData()
  {
    this.nF = getString(2131694310);
    this.aXk = getIntent().getBooleanExtra("key_gesture_from_jumpactivity", false);
    this.aXl = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.aXm = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (this.aXk)
    {
      this.aNt = getIntent().getStringExtra("scheme_content");
      this.aNu = getIntent().getStringExtra("pkg_name");
    }
    addObserver(this.c);
    this.density = getResources().getDisplayMetrics().density;
    this.xu = GesturePWDUtils.getGestureUnlockFailedTime(getActivity(), this.app.getCurrentAccountUin());
  }
  
  private void initUI()
  {
    setTitle(2131694294);
    this.dS = ((TextView)findViewById(2131368001));
    this.DF = ((TextView)findViewById(2131367998));
    this.a = ((LockPatternView)findViewById(2131368000));
    this.a.setFillInGapCell(false);
    this.a.setTactileFeedbackEnabled(false);
    this.a.setOnPatternListener(this);
    this.cY = ((ImageView)findViewById(2131367997));
    Object localObject1;
    if ((this.app != null) && (this.app.getCurrentAccountUin() != null))
    {
      localObject1 = this.app.a(this.app.getCurrentAccountUin(), (byte)1, false);
      this.cY.setImageBitmap((Bitmap)localObject1);
    }
    this.dT = ((TextView)findViewById(2131367999));
    this.dT.setOnClickListener(this);
    this.dT.setEnabled(false);
    if (this.density <= 1.0D)
    {
      localObject1 = this.a.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(this.density * 240.0F));
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(this.density * 240.0F));
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if ((this.xu > 0) && (this.xu < 5))
    {
      this.bHH = (5 - this.xu);
      Object localObject2 = MessageFormat.format(this.nF, new Object[] { Integer.valueOf(this.bHH) });
      this.dS.setTextColor(getResources().getColor(2131167179));
      this.DF.setVisibility(0);
      localObject1 = this.bHH + "";
      int i = ((String)localObject2).indexOf((String)localObject1);
      localObject2 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject2).setSpan(new StyleSpan(1), i, ((String)localObject1).length() + i, 18);
      this.dS.setText((CharSequence)localObject2);
    }
    if (this.xu == 5)
    {
      this.bHH = 0;
      qT();
    }
  }
  
  public void Z(List<LockPatternView.a> paramList)
  {
    if (paramList != null)
    {
      String str1 = GesturePWDUtils.getGesturePWD(this, this.app.getCurrentAccountUin());
      String str2 = MD5.toMD5(GesturePWDUtils.patternToString(paramList));
      paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.app.getCurrentAccountUin());
      if ((str1 != null) && (((str2 != null) && (str2.equals(str1))) || ((paramList != null) && (paramList.equals(str1)))))
      {
        BaseActivity.isUnLockSuccess = true;
        if (this.aXm)
        {
          paramList = new Intent(this, ContactSyncJumpActivity.class);
          paramList.putExtra("key_req_from_lock_screen", true);
          paramList.putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
          startActivity(paramList);
          moveTaskToBack(true);
        }
        for (;;)
        {
          finish();
          GesturePWDUtils.setGestureLocking(this, false);
          if ((this.aXk) && (!TextUtils.isEmpty(this.aNt)))
          {
            paramList = aqik.c(this.app, getActivity(), this.aNt);
            paramList.setPkgName(this.aNu);
            paramList.ace();
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.gesturelock.unlock", 2, "unlock success.");
          }
          this.bHH = 5;
          zym.q(this.app, true);
          return;
          setResult(-1);
        }
      }
      this.a.setDisplayMode(LockPatternView.DisplayMode.Wrong);
      this.bHH -= 1;
      if (this.bHH > 0)
      {
        qS();
        return;
      }
      qT();
      return;
    }
    QQToast.a(this, 1, getString(2131694305), 0).show(getTitleBarHeight());
    this.a.setDisplayMode(LockPatternView.DisplayMode.Wrong);
    this.bHH -= 1;
    if (this.bHH > 0)
    {
      qS();
      return;
    }
    qT();
  }
  
  public void aa(List<LockPatternView.a> paramList) {}
  
  public void bPH()
  {
    this.bHH = 5;
    GesturePWDUtils.setGesturePWDState(this, this.app.getCurrentAccountUin(), 0);
    GesturePWDUtils.setGesturePWDMode(this, this.app.getCurrentAccountUin(), 21);
    GesturePWDUtils.setGestureUnlockFailed(this, this.app.getCurrentAccountUin());
    Object localObject = getAppRuntime().getApplication().getAllAccounts();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
          this.app.updateSubAccountLogin(localSimpleAccount.getUin(), false);
        }
      }
      getAppRuntime().getApplication().refreAccountList();
    }
    GesturePWDUtils.setGestureLocking(this, false);
    if (QQPlayerService.isPlaying())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      sendBroadcast((Intent)localObject);
    }
    this.app.logout(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, this.aXl + "," + this.aXm + "," + this.aXk + "," + this.aNt + "," + this.aNu);
    }
    localObject = new Intent(getApplicationContext(), LoginActivity.class);
    if (this.aXl)
    {
      ((Intent)localObject).putExtra("key_gesture_from_authority", true);
      GesturePWDUtils.setGestureLocking(this, false);
      startActivityForResult((Intent)localObject, 9999);
      return;
    }
    if (this.aXm)
    {
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("key_req_by_contact_sync", true);
      ((Intent)localObject).putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
      startActivity((Intent)localObject);
    }
    for (;;)
    {
      finish();
      return;
      if (!this.aXk)
      {
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("key_gesture_unlock_failed", true);
        ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
        startActivity((Intent)localObject);
      }
      else if ((!TextUtils.isEmpty(this.aNt)) && (!TextUtils.isEmpty(this.aNu)))
      {
        ((Intent)localObject).putExtra("scheme_content", this.aNt);
        ((Intent)localObject).putExtra("pkg_name", this.aNu);
        startActivity((Intent)localObject);
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 9999)
    {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    else {
      return;
    }
    setResult(0);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onCreate begin.");
    }
    Window localWindow = getWindow();
    if (Build.VERSION.SDK_INT >= 28)
    {
      View localView = localWindow.getDecorView();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      localWindow.setAttributes(localLayoutParams);
      int i = localView.getSystemUiVisibility();
      localWindow.getDecorView().setSystemUiVisibility(i | 0x400);
    }
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559409);
    initData();
    initUI();
    GesturePWDUtils.setGestureLocking(this, true);
    this.createTime = System.currentTimeMillis();
    paramBundle = new Intent();
    paramBundle.setAction("com.tencent.mobileqq.gestureunlock");
    paramBundle.putExtra("timeid", this.createTime);
    sendBroadcast(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.gestureunlock");
    registerReceiver(this.mBroadcastReceiver, paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.g != null)
    {
      this.aXn = false;
      this.g.dismiss();
    }
    removeObserver(this.c);
    try
    {
      unregisterReceiver(this.mBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    aXo = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.dT.postDelayed(new GesturePWDUnlockActivity.1(this), 500L);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.dT.setEnabled(false);
    GesturePWDUtils.setGestureUnlockFailedTime(getActivity(), this.app.getCurrentAccountUin(), 5 - this.bHH);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772002, 2130772079);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    qH();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public boolean onBackEvent()
  {
    if ((this.aXk) || (this.aXl))
    {
      setResult(0);
      return super.onBackEvent();
    }
    moveTaskToBack(true);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bPH();
      GesturePWDUtils.setGestureUnlockFailedType(this, 0);
      anpc.a(getBaseContext()).a(this.app, this.app.getCurrentAccountUin(), "Gesture_pwd", "click_forgive", 0, 1, "0", null, null, null, null);
    }
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  void qH()
  {
    int i = 0;
    if ((this.xq < this.xr) && (this.aG != null) && (this.aG.length >= this.xr) && (this.e != null) && (this.e.length >= this.xr))
    {
      if (this.xq > 0) {
        i = this.aG[(this.xq - 1)];
      }
      int j = this.aG[this.xq];
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(i, j, 0.0F, 0.0F);
      localTranslateAnimation.setAnimationListener(this);
      localTranslateAnimation.setDuration(this.e[this.xq]);
      this.bl.startAnimation(localTranslateAnimation);
      this.xq += 1;
      return;
    }
    this.xq = 0;
    this.bl = null;
  }
  
  public void qM() {}
  
  public void qN() {}
  
  void qS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedInRange");
    }
    Object localObject = MessageFormat.format(this.nF, new Object[] { Integer.valueOf(this.bHH) });
    this.dS.setTextColor(getResources().getColor(2131167179));
    this.DF.setVisibility(0);
    String str = this.bHH + "";
    int i = ((String)localObject).indexOf(str);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new StyleSpan(1), i, str.length() + i, 18);
    this.dS.setText((CharSequence)localObject);
    eM(this.dS);
    BaseApplicationImpl.sUiHandler.postDelayed(new GesturePWDUnlockActivity.2(this), 500L);
  }
  
  void qT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedOutRange");
    }
    BaseApplicationImpl.sUiHandler.postDelayed(new GesturePWDUnlockActivity.3(this), 500L);
    if ((this.g != null) && (this.g.isShowing())) {
      return;
    }
    this.g = aqha.a(this, 231, getString(2131694308), getString(2131694307), new vcv(this), null);
    this.g.setOnDismissListener(new vcw(this));
    this.g.show();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDUnlockActivity
 * JD-Core Version:    0.7.0.1
 */