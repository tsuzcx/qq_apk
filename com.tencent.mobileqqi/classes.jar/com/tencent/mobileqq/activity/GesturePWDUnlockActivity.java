package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import cpb;
import cpc;
import cpd;
import cpe;
import cpf;
import cpg;
import cph;
import cpi;
import cpj;
import cpk;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GesturePWDUnlockActivity
  extends BaseActivity
{
  public static final int a = 3;
  public static final String a = "key_gesture_unlock_failed";
  public static final String b = "key_gesture_from_splash";
  private static final int jdField_c_of_type_Int = 9999;
  public static final String c = "key_gesture_from_jumpactivity";
  private static final int jdField_d_of_type_Int = 5;
  public static final String d = "key_gesture_from_authority";
  public static final String e = "key_req_by_contact_sync";
  private static final String i = "com.tencent.mobileqq.gestureunlock";
  private static final String j = "Q.gesturelock.unlock";
  private float jdField_a_of_type_Float = 1.0F;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cpc(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new cpb(this);
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new cpk(this);
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cpj(this);
  public LockPatternView a;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt;
  private long[] jdField_a_of_type_ArrayOfLong;
  public int b;
  private TextView b;
  public boolean b;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  private boolean jdField_d_of_type_Boolean;
  private int e = 0;
  private int f;
  public String f;
  private int g;
  public String g;
  private String h = "";
  
  public GesturePWDUnlockActivity()
  {
    this.jdField_b_of_type_Int = 5;
    this.jdField_b_of_type_Boolean = false;
    this.d = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 5;
  }
  
  private Bitmap a(String paramString, boolean paramBoolean)
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, (byte)3, false);
  }
  
  private void a(View paramView)
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 5;
    this.jdField_a_of_type_ArrayOfLong = new long[] { 50L, 100L, 100L, 100L, 100L };
    this.jdField_a_of_type_ArrayOfInt = new int[] { (int)(-20.0F * this.jdField_a_of_type_Float), (int)(20.0F * this.jdField_a_of_type_Float), (int)(-15.0F * this.jdField_a_of_type_Float), (int)(15.0F * this.jdField_a_of_type_Float), 0 };
    this.jdField_a_of_type_AndroidViewView = paramView;
    d();
  }
  
  private void e()
  {
    this.h = getString(2131562234);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_gesture_from_splash", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_gesture_from_jumpactivity", false);
    this.d = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("scheme_content");
      this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("pkg_name");
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.e = GesturePWDUtils.getGestureUnlockFailedTime(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  private void f()
  {
    setTitle(2131562889);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231756));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231757));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView = ((LockPatternView)findViewById(2131231758));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setFillInGapCell(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setTactileFeedbackEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setOnPatternListener(new cpd(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231755));
    Object localObject1;
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      localObject1 = a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231760));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new cpe(this));
    if (this.jdField_a_of_type_Float <= 1.0D)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(this.jdField_a_of_type_Float * 240.0F));
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(this.jdField_a_of_type_Float * 240.0F));
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if ((this.e > 0) && (this.e < 5))
    {
      this.jdField_b_of_type_Int = (5 - this.e);
      Object localObject2 = MessageFormat.format(this.h, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131361947));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_b_of_type_Int + "";
      int k = ((String)localObject2).indexOf((String)localObject1);
      localObject2 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject2).setSpan(new StyleSpan(1), k, ((String)localObject1).length() + k, 18);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedInRange");
    }
    Object localObject = MessageFormat.format(this.h, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131361947));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = this.jdField_b_of_type_Int + "";
    int k = ((String)localObject).indexOf(str);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new StyleSpan(1), k, str.length() + k, 18);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new cpf(this), 500L);
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(d());
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedOutRange");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new cpg(this), 500L);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 231, getString(2131562095), getString(2131563129), new cph(this), null);
    localQQCustomDialog.setOnDismissListener(new cpi(this));
    localQQCustomDialog.show();
  }
  
  protected boolean b()
  {
    if ((this.jdField_b_of_type_Boolean) || (this.d))
    {
      setResult(0);
      return super.b();
    }
    moveTaskToBack(true);
    return true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 5;
    GesturePWDUtils.setGesturePWDState(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    GesturePWDUtils.setGesturePWDMode(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 21);
    GesturePWDUtils.setGestureUnlockFailed(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Object localObject = getAppRuntime().getApplication().getAllAccounts();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.updateSubAccountLogin(localSimpleAccount.getUin(), false);
        }
      }
      getAppRuntime().getApplication().refreAccountList();
    }
    localObject = new Intent(this, LoginActivity.class);
    if (this.d)
    {
      ((Intent)localObject).putExtra("key_gesture_from_authority", true);
      GesturePWDUtils.setGestureLocking(this, false);
      startActivityForResult((Intent)localObject, 9999);
      return;
    }
    if (this.jdField_c_of_type_Boolean) {}
    try
    {
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("key_req_by_contact_sync", true);
      ((Intent)localObject).putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
      startActivity((Intent)localObject);
      for (;;)
      {
        label206:
        finish();
        GesturePWDUtils.setGestureLocking(this, false);
        if (QQPlayerService.a())
        {
          localObject = new Intent();
          ((Intent)localObject).setAction("qqplayer_exit_action");
          sendBroadcast((Intent)localObject);
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
        return;
        if (!this.jdField_b_of_type_Boolean)
        {
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).putExtra("key_gesture_unlock_failed", true);
          ((Intent)localObject).putExtra("tab_index", 0);
          startActivity((Intent)localObject);
        }
        else if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)))
        {
          ((Intent)localObject).putExtra("scheme_content", this.jdField_f_of_type_JavaLangString);
          ((Intent)localObject).putExtra("pkg_name", this.jdField_g_of_type_JavaLangString);
          startActivity((Intent)localObject);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label206;
    }
  }
  
  public void d()
  {
    int k = 0;
    if ((this.jdField_f_of_type_Int < this.jdField_g_of_type_Int) && (this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length >= this.jdField_g_of_type_Int) && (this.jdField_a_of_type_ArrayOfLong != null) && (this.jdField_a_of_type_ArrayOfLong.length >= this.jdField_g_of_type_Int))
    {
      if (this.jdField_f_of_type_Int > 0) {
        k = this.jdField_a_of_type_ArrayOfInt[(this.jdField_f_of_type_Int - 1)];
      }
      int m = this.jdField_a_of_type_ArrayOfInt[this.jdField_f_of_type_Int];
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(k, m, 0.0F, 0.0F);
      localTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      localTranslateAnimation.setDuration(this.jdField_a_of_type_ArrayOfLong[this.jdField_f_of_type_Int]);
      this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
      this.jdField_f_of_type_Int += 1;
      return;
    }
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onCreate begin.");
    }
    getWindow().setFlags(1024, 1024);
    super.doOnCreate(paramBundle);
    setContentView(2130903245);
    e();
    f();
    GesturePWDUtils.setGestureLocking(this, true);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = new Intent();
    paramBundle.setAction("com.tencent.mobileqq.gestureunlock");
    paramBundle.putExtra("timeid", this.jdField_a_of_type_Long);
    sendBroadcast(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.gestureunlock");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    hideActionBar();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    GesturePWDUtils.setGestureUnlockFailedTime(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 5 - this.jdField_b_of_type_Int);
  }
  
  public void finish()
  {
    GesturePWDUtils.mEnterFromSplash = false;
    super.finish();
    overridePendingTransition(2130968595, 2130968608);
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (!this.d)
    {
      finish();
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDUnlockActivity
 * JD-Core Version:    0.7.0.1
 */