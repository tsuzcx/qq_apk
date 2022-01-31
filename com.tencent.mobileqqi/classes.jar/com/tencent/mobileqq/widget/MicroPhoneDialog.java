package com.tencent.mobileqq.widget;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VoiceHelper;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.qphone.base.util.QLog;
import hgw;
import hgx;
import hgy;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MicroPhoneDialog
  extends Dialog
  implements View.OnClickListener, VoicePlayer.VoicePlayerListener, RotateAnimation.InterpolatedTimeListener
{
  public static final int a = 1;
  public static final long a = 1000L;
  public static final int b = 2;
  public static final long b = 60000L;
  public static final int c = 490;
  public static final long c = 5000L;
  public static final long d = 60L;
  private static final String d = "com.tencent.mobileqq:video";
  public static final int e = 100;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  public static final int k = 6;
  public static final int l = 7;
  public static final int m = 8;
  public static final int n = 9;
  public static final int o = 10;
  public static final int p = 11;
  public static final int q = 12;
  public Context a;
  public Handler a;
  protected PowerManager.WakeLock a;
  protected Button a;
  public ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  public QQRecorder a;
  protected VoiceHelper a;
  protected VoicePlayer a;
  public MicroPhoneClipImageView a;
  public OvalProgress a;
  protected QQToastNotifier a;
  public String a;
  protected AppRuntime a;
  public boolean a;
  protected Button b;
  protected ImageView b;
  protected RelativeLayout b;
  protected TextView b;
  protected String b;
  protected boolean b;
  protected Button c;
  public TextView c;
  protected String c;
  public boolean c;
  public final int d;
  protected TextView d;
  public long e = 9223372036854775807L;
  public long f = 9223372036854775807L;
  public long g;
  protected int r = 0;
  public int s = -1;
  protected int t;
  
  public MicroPhoneDialog(Context paramContext, AppRuntime paramAppRuntime, VoiceHelper paramVoiceHelper)
  {
    super(paramContext, 2131624452);
    this.jdField_d_of_type_Int = 1000;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new hgw(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoiceHelper = paramVoiceHelper;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    setContentView(2130903612);
    h();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376), 0, paramInt2);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.getVisibility() != 4) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setVisibility(4);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() != 4) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      }
    }
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).c();
    }
    Iterator localIterator = ((ActivityManager)this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext()) {
      if (((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.equals("com.tencent.mobileqq:video")) {
        return true;
      }
    }
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.getVisibility() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setBackgroundColor(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.getVisibility() != 4) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setVisibility(4);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 4) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    } while (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232664));
    View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131232672);
    localView.setOnClickListener(this);
    localView.setContentDescription(getContext().getString(2131561846));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233066));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView = ((MicroPhoneClipImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233067));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setSoundWave(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233070));
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new hgx(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233068));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233069));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress = ((OvalProgress)findViewById(2131232665));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232666));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131232667));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233071));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233072));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131233074));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131233075));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.r = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.MicroPhone", 2, "QLog.isColorLevel()=" + QLog.isColorLevel() + " density=" + this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density + " densityDpi=" + this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi);
    }
  }
  
  private void i()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      if (!FileUtil.a(this.jdField_b_of_type_JavaLangString)) {}
    }
    for (String str = this.jdField_b_of_type_JavaLangString; str == null; str = this.jdField_a_of_type_JavaLangString)
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_b_of_type_Boolean);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.MicroPhone", 2, "scaleType=" + this.jdField_a_of_type_AndroidWidgetImageView.getScaleType());
        }
        m();
        this.jdField_b_of_type_Boolean = true;
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsVoiceHelper == null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoiceHelper.a();
      return;
    }
    if (c())
    {
      a(2131561724, 1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(str, this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839033);
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a())
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839032);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839033);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
    }
    cancel();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext());
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = BuddyTransfileProcessor.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), null, 2, null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.MicroPhone", 2, "path: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(new hgy(this));
    AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.MicroPhone", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this.jdField_a_of_type_JavaLangString);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.getVisibility() != 4) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setVisibility(4);
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(Integer.toString(this.s));
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 4) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 4) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    Animatable localAnimatable = (Animatable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
    if ((localAnimatable != null) && (!localAnimatable.isRunning())) {
      localAnimatable.start();
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    Animatable localAnimatable = (Animatable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
    if ((localAnimatable != null) && (localAnimatable.isRunning())) {
      localAnimatable.stop();
    }
  }
  
  private void o()
  {
    int i3 = 0;
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839021);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setRecordState(true);
    this.f = System.currentTimeMillis();
    a(false);
    File localFile = Environment.getExternalStorageDirectory();
    int i1;
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      i1 = 1;
      int i2 = i3;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        i2 = i3;
        if (i1 != 0) {
          i2 = 1;
        }
      }
      if (i2 == 0) {
        break label275;
      }
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
        break label264;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a())) {
        break label169;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.MicroPhone", 2, "isRecording is true,time is:" + System.currentTimeMillis());
      }
    }
    label264:
    label275:
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131562743);
      return;
      i1 = 0;
      break;
      label169:
      if (c())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.MicroPhone", 2, "app$isVideoChatting is true, time is:" + System.currentTimeMillis());
        }
        a(2131561724, 1);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.MicroPhone", 2, "startAudioRecord() is called,time is:" + System.currentTimeMillis());
        }
        k();
        continue;
        a(2131561430, 1);
        continue;
        a(2131561429, 1);
      }
    }
  }
  
  public void a()
  {
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131562655);
    this.r = 1;
    this.jdField_a_of_type_Boolean = true;
    this.t = 1;
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    RotateAnimation localRotateAnimation = new RotateAnimation(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() / 2, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() / 2, false, i1);
    localRotateAnimation.a(this);
    localRotateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localRotateAnimation);
  }
  
  public void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (paramFloat < 0.5F) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.t == 1)
    {
      c(false);
      d(true);
    }
    for (;;)
    {
      this.t = 0;
      return;
      if (this.t == 2)
      {
        c(true);
        d(false);
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 == 8)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
      FileUtils.d(paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    this.g = paramInt;
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.g > 0L))
    {
      this.jdField_b_of_type_JavaLangString = ProfileCardUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), this.jdField_c_of_type_JavaLangString);
      c(false);
      d(true);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(Integer.toString((int)Math.round(this.g * 1.0D / 1000.0D)) + "\"");
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131561922);
      this.r = 2;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setProgressParams(paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.getVisibility() != 4) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.getVisibility() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setSoundWave(0);
      }
    } while (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setRecordState(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131562219);
    this.f = 9223372036854775807L;
    this.jdField_a_of_type_Boolean = true;
    this.t = 2;
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    RotateAnimation localRotateAnimation = new RotateAnimation(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() / 2, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() / 2, true, i1);
    localRotateAnimation.a(this);
    localRotateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localRotateAnimation);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
  }
  
  public boolean b()
  {
    return this.f != 9223372036854775807L;
  }
  
  public void c()
  {
    e();
    AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, false);
    if (System.currentTimeMillis() - this.f >= 1000L)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 490L);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 1000L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("power")).newWakeLock(6, "SoundRecorder");
    }
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      label4:
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      }
      return;
    }
    catch (Exception localException)
    {
      break label4;
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a() == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setRecordState(false);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b())) {
      c();
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131562219);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839020);
    this.f = 9223372036854775807L;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        switch (paramView.getId())
        {
        default: 
          return;
        case 2131232665: 
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.MicroPhone", 2, "click player button... for test time=" + System.currentTimeMillis());
          }
          i();
          return;
        case 2131232672: 
          j();
          ProfileCardUtil.d(this.jdField_a_of_type_JavaLangString);
          return;
        case 2131233074: 
          this.jdField_b_of_type_JavaLangString = null;
          if (!this.jdField_a_of_type_Boolean) {
            b();
          }
          ProfileCardUtil.d(this.jdField_a_of_type_JavaLangString);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      return;
      if (this.r == 2)
      {
        this.jdField_b_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoiceHelper != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoiceHelper.a();
        }
        j();
        return;
      }
    } while (this.r != 1);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoiceHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoiceHelper.a(this.jdField_a_of_type_JavaLangString, Math.min(this.g, 60000L));
    }
    this.jdField_a_of_type_JavaLangString = null;
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MicroPhoneDialog
 * JD-Core Version:    0.7.0.1
 */