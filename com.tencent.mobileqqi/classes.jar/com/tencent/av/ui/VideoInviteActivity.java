package com.tencent.av.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import bla;
import blb;
import blc;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoWifiLock;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import mqq.app.BaseActivity;

public class VideoInviteActivity
  extends BaseActivity
{
  public static int a;
  public static String a;
  static final long[] jdField_a_of_type_ArrayOfLong;
  public static int b;
  public static int c;
  public static String f;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public VideoController a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new blb(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  VideoWifiLock jdField_a_of_type_ComTencentAvUtilsVideoWifiLock;
  Runnable jdField_a_of_type_JavaLangRunnable = new bla(this);
  public boolean a;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  public String c;
  boolean c;
  public int d;
  String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  final int g = 0;
  final int h = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VideoInviteActivity";
    jdField_a_of_type_Int = 60000;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 1;
    jdField_a_of_type_ArrayOfLong = new long[] { 100L, 200L, 200L, 100L };
    jdField_f_of_type_JavaLangString = "video wifi lock";
  }
  
  public VideoInviteActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_f_of_type_Int = 0;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  protected void a() {}
  
  boolean a()
  {
    Intent localIntent = super.getIntent();
    if (localIntent != null)
    {
      this.jdField_e_of_type_Int = localIntent.getIntExtra("uinType", 0);
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("peerUin");
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("extraUin");
      this.jdField_d_of_type_Int = localIntent.getIntExtra("curUserStatus", 0);
      this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("isAudioMode", false);
      this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("powerKey", false);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label100;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "initVideoParam uin is empty!");
      }
    }
    return false;
    label100:
    return true;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 1);
  }
  
  boolean b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.g();
      }
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(this, 1, jdField_f_of_type_JavaLangString);
        return bool;
      }
    }
    return false;
  }
  
  public void c()
  {
    if (!c()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.f)
    {
      h();
      return;
    }
    d();
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock == null) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(this, 1, jdField_f_of_type_JavaLangString);
    }
    if ((PhoneStatusTools.f(this)) && (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock.a();
    }
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvVideoController.l) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.putExtra("uinType", this.jdField_e_of_type_Int);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("name", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("extraUin", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("receive", true);
    localIntent.putExtra("isAudioMode", this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean) {
      localIntent.putExtra("sessionType", 1);
    }
    for (;;)
    {
      localIntent.putExtra("shutCamera", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("isSender", false);
      super.startActivity(localIntent);
      this.jdField_e_of_type_Boolean = false;
      super.finish();
      super.overridePendingTransition(2130968641, 2130968640);
      return;
      localIntent.putExtra("sessionType", 2);
    }
  }
  
  void e()
  {
    new AlertDialog.Builder(this).setTitle(2131560123).setMessage(getString(2131560124)).setNegativeButton(2131562539, null).create().show();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onVideoRequestTimeout");
    }
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
      this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 0);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, true, true);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    }
  }
  
  void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showGAudioDialog");
    }
    blc localblc1 = new blc(this, 0);
    blc localblc2 = new blc(this, 1);
    DialogUtil.a(this, 230, null, super.getString(2131560198), 2131560061, 2131560230, localblc1, localblc2).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate");
    }
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    if ((!b()) || (!a()))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "init param failure.");
      }
      this.jdField_e_of_type_Boolean = true;
      super.finish();
      return;
    }
    int i = LocaleUtil.b(getApplicationContext());
    LocaleUtil.a(getBaseContext(), i);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().c())
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "session state error! " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
      this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 2);
      this.jdField_e_of_type_Boolean = true;
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentAvVideoController.g() > 0) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(203, 2, this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_f_of_type_Int = PhoneStatusTools.a(this);
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(202, 2, this.jdField_c_of_type_JavaLangString);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock.a();
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
      this.jdField_a_of_type_ComTencentAvVideoController = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      if (paramInt == 4) {
        b();
      }
      for (;;)
      {
        return super.onKeyDown(paramInt, paramKeyEvent);
        if ((paramInt == 26) || (paramInt == 25))
        {
          UITools.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
      }
    }
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause");
    }
    if (PhoneStatusTools.c(this))
    {
      UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      TraeAudioSession localTraeAudioSession = new TraeAudioSession(this, null);
      localTraeAudioSession.a();
      localTraeAudioSession.a();
    }
    UITools.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResume");
    }
    TraeAudioSession localTraeAudioSession;
    if (PhoneStatusTools.c(this)) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.f != true)
      {
        localTraeAudioSession = new TraeAudioSession(this, null);
        if (this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothA2dpOn())
        {
          localTraeAudioSession.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
          localTraeAudioSession.b("DEVICE_BLUETOOTHHEADSET");
          localTraeAudioSession.a();
        }
      }
      else
      {
        UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165205, -1, null);
        UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.c();
      }
      return;
      if (this.jdField_a_of_type_AndroidMediaAudioManager.isWiredHeadsetOn())
      {
        localTraeAudioSession.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        localTraeAudioSession.b("DEVICE_WIREDHEADSET");
        break;
      }
      localTraeAudioSession.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      localTraeAudioSession.b("DEVICE_SPEAKERPHONE");
      break;
      if (PhoneStatusTools.b(this)) {
        UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onStop");
    }
    Bitmap localBitmap;
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c()))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this);
      }
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, true, true);
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_d_of_type_JavaLangString, localBitmap, null, 45);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_d_of_type_JavaLangString, localBitmap, null, 40);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity
 * JD-Core Version:    0.7.0.1
 */