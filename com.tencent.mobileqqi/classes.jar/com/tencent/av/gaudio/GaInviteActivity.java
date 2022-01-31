package com.tencent.av.gaudio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import bhq;
import bhr;
import bhs;
import bht;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import java.util.Timer;
import mqq.app.BaseActivity;

public class GaInviteActivity
  extends BaseActivity
{
  public static String a;
  float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = 0;
  public long a;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  public Handler a;
  public ImageView a;
  public TextView a;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new bhq(this);
  public VideoAppInterface a;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  Timer jdField_a_of_type_JavaUtilTimer = null;
  public boolean a;
  long[] jdField_a_of_type_ArrayOfLong = null;
  int jdField_b_of_type_Int = 0;
  public long b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  boolean jdField_b_of_type_Boolean = false;
  TextView c;
  public boolean c;
  boolean d = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GaInviteActivity";
  }
  
  public GaInviteActivity()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new bhs(this);
  }
  
  protected void a() {}
  
  public void b()
  {
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.jdField_b_of_type_Long));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.jdField_a_of_type_ArrayOfLong);
    localIntent.putExtra("uin", String.valueOf(this.jdField_b_of_type_Long));
    localIntent.putExtra("uinType", 3000);
    super.startActivity(localIntent);
    super.finish();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Long);
    super.finish();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer(true);
    bht localbht = new bht(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(localbht, 30000L);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public void f()
  {
    long l = this.jdField_b_of_type_Long;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, String.valueOf(l), null, true, false);
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = "";
      str2 = Long.toString(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, str2, String.valueOf(this.jdField_b_of_type_Long));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      }
      if (localBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    } while ((localBitmap != null) && (!str1.equals(str2)));
    this.jdField_a_of_type_JavaLangRunnable = new bhr(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1500L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate");
    }
    super.onCreate(paramBundle);
    super.getWindow().addFlags(2097152);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 0) || (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 1)) {
      this.d = true;
    }
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    paramBundle = getIntent();
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("friendUin", 0L);
    this.jdField_b_of_type_Long = paramBundle.getLongExtra("discussId", 0L);
    this.jdField_a_of_type_ArrayOfLong = paramBundle.getLongArrayExtra("memberList");
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      super.finish();
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_b_of_type_Long == 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mInviterUin == 0 or mGroupID == 0");
        }
        super.finish();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)getAppRuntime());
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp is null!");
        }
        super.finish();
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mVideoController is null!");
        }
        super.finish();
        return;
      }
      if (this.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentAvVideoController.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "currnet invite has been canceled!");
        }
        c();
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      d();
      this.jdField_b_of_type_Boolean = true;
      if ((this instanceof GaInviteDialogActivity))
      {
        this.jdField_c_of_type_Boolean = false;
        return;
      }
    } while (!(this instanceof GaInviteLockActivity));
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.c();
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    }
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    UITools.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    e();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(null);
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      c();
    }
    for (;;)
    {
      return false;
      if ((paramInt == 26) || (paramInt == 25))
      {
        UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        UITools.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  protected void onPause()
  {
    if (!this.d) {
      UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    UITools.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_b_of_type_Boolean = false;
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.d)
    {
      TraeAudioSession localTraeAudioSession = new TraeAudioSession(super.getApplicationContext(), null);
      localTraeAudioSession.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      localTraeAudioSession.a();
      UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165205, -1, null);
      UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.c();
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label172;
        }
        ReportController.b(null, "CliOper", "", "", "Multi_call", "Lock_popup", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Long))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "GaInvite roomUserNum is 0");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.s();
        finish();
      }
      return;
      if (!PhoneStatusTools.b(this)) {
        break;
      }
      UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      break;
      label172:
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Popup_force", 0, 0, "", "", "", "");
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (!super.isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this);
      }
      String str1 = String.valueOf(this.jdField_b_of_type_Long);
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, str1, null, true, true);
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, Long.toString(this.jdField_a_of_type_Long), str1);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(str2, localBitmap, str1, 43);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    String str1;
    String str2;
    float f;
    String str3;
    if (paramBoolean) {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        str1 = String.valueOf(this.jdField_b_of_type_Long);
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, str1, null);
        f = super.getResources().getDimensionPixelSize(2131427662);
        str2 = UITools.a(super.getApplicationContext(), str2, this.jdField_b_of_type_AndroidWidgetTextView, f);
        str3 = super.getApplicationContext().getString(2131560190);
        int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str1);
        i = j;
        if (j == 0) {
          if (this.jdField_a_of_type_ArrayOfLong == null) {
            break label264;
          }
        }
      }
    }
    label264:
    for (int i = this.jdField_a_of_type_ArrayOfLong.length + 1;; i = 1)
    {
      str1 = String.format(str3, new Object[] { Integer.valueOf(i) });
      str1 = str2 + str1;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, Long.toString(this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Long));
        f = super.getResources().getDimensionPixelSize(2131427662);
        str1 = UITools.a(super.getApplicationContext(), str1, this.jdField_c_of_type_AndroidWidgetTextView, f);
        str1 = str1 + super.getApplicationContext().getString(2131560166);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity
 * JD-Core Version:    0.7.0.1
 */