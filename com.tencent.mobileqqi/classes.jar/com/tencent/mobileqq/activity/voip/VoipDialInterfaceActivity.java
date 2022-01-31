package com.tencent.mobileqq.activity.voip;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.MediaStore.Images.Media;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.text.Selection;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.voip.VoipHistoryData;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import etv;
import etx;
import ety;
import etz;
import eua;
import eub;
import euc;
import eud;
import eue;
import euf;
import eug;
import euh;
import eui;
import euj;
import euk;
import eul;
import eum;
import eun;
import euo;
import eup;
import euq;
import eur;
import eus;
import eut;
import euv;
import euw;
import euy;
import euz;
import evb;
import evc;
import eve;
import evf;
import evh;
import evi;
import evj;
import evl;
import evm;
import evo;
import evp;
import evr;
import evs;
import evu;
import evv;
import evx;
import evy;
import evz;
import ewb;
import ewc;
import ewe;
import ewf;
import ewg;
import ewh;
import ewi;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(11)
public class VoipDialInterfaceActivity
  extends BaseActivity
  implements SensorEventListener
{
  public static final int b = 1;
  private static final String jdField_c_of_type_JavaLangString = "VoipDialInterfaceActivity";
  private ImageButton A;
  private ImageButton B;
  private ImageButton C;
  private ImageButton D;
  private ImageButton E;
  private ImageButton F;
  private float jdField_a_of_type_Float = -1.0F;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private NotificationManager jdField_a_of_type_AndroidAppNotificationManager;
  private PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ewi(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  public Handler a;
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  PowerManager jdField_a_of_type_AndroidOsPowerManager;
  ActionBar jdField_a_of_type_AndroidSupportV7AppActionBar;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private EditTextAutoResizeFont jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont;
  public VoipDialInterface a;
  public PhoneContact a;
  private PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  Runnable jdField_a_of_type_JavaLangRunnable = new ewg(this);
  protected String a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private long jdField_b_of_type_Long = 0L;
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private EditTextAutoResizeFont jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long = -1L;
  View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  public ImageButton c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = 0L;
  View jdField_d_of_type_AndroidViewView;
  private FrameLayout jdField_d_of_type_AndroidWidgetFrameLayout;
  ImageButton jdField_d_of_type_AndroidWidgetImageButton;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private FrameLayout jdField_e_of_type_AndroidWidgetFrameLayout;
  public ImageButton e;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private FrameLayout jdField_f_of_type_AndroidWidgetFrameLayout;
  public ImageButton f;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString = new String();
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  private FrameLayout jdField_g_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_g_of_type_AndroidWidgetImageButton;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int;
  private FrameLayout jdField_h_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_h_of_type_AndroidWidgetImageButton;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int;
  private FrameLayout jdField_i_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_i_of_type_AndroidWidgetImageButton;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private FrameLayout jdField_j_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_j_of_type_AndroidWidgetImageButton;
  private boolean jdField_j_of_type_Boolean = true;
  private int jdField_k_of_type_Int;
  private FrameLayout jdField_k_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_k_of_type_AndroidWidgetImageButton;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int;
  private FrameLayout jdField_l_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_l_of_type_AndroidWidgetImageButton;
  private boolean jdField_l_of_type_Boolean = true;
  private int jdField_m_of_type_Int;
  private FrameLayout jdField_m_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_m_of_type_AndroidWidgetImageButton;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int;
  private FrameLayout jdField_n_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_n_of_type_AndroidWidgetImageButton;
  private int jdField_o_of_type_Int;
  private FrameLayout jdField_o_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_o_of_type_AndroidWidgetImageButton;
  private int jdField_p_of_type_Int;
  private FrameLayout jdField_p_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_p_of_type_AndroidWidgetImageButton;
  private int jdField_q_of_type_Int;
  private FrameLayout jdField_q_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_q_of_type_AndroidWidgetImageButton;
  private int jdField_r_of_type_Int = 0;
  private FrameLayout jdField_r_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_r_of_type_AndroidWidgetImageButton;
  private FrameLayout jdField_s_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_s_of_type_AndroidWidgetImageButton;
  private FrameLayout jdField_t_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_t_of_type_AndroidWidgetImageButton;
  private FrameLayout jdField_u_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_u_of_type_AndroidWidgetImageButton;
  private FrameLayout jdField_v_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_v_of_type_AndroidWidgetImageButton;
  private FrameLayout jdField_w_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_w_of_type_AndroidWidgetImageButton;
  private FrameLayout jdField_x_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_x_of_type_AndroidWidgetImageButton;
  private FrameLayout jdField_y_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_y_of_type_AndroidWidgetImageButton;
  private FrameLayout jdField_z_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_z_of_type_AndroidWidgetImageButton;
  
  public VoipDialInterfaceActivity()
  {
    this.jdField_a_of_type_Int = 49;
    this.jdField_a_of_type_JavaLangString = "86";
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(char paramChar)
  {
    TextView localTextView;
    if (this.jdField_f_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_f_of_type_JavaLangString = localTextView.getText().toString();
        localTextView.setText("");
        this.jdField_l_of_type_Boolean = false;
      }
      if (localTextView.length() < this.jdField_a_of_type_Int) {}
    }
    else
    {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer(localTextView.getText().toString().trim());
    int i1;
    String str;
    if (this.jdField_m_of_type_Boolean == true)
    {
      i1 = localTextView.getSelectionStart();
      str = new String();
      if (i1 >= 0)
      {
        localStringBuffer.insert(i1, paramChar);
        str = localStringBuffer.toString();
      }
      if (i1 <= 13) {
        break label153;
      }
      str = localStringBuffer.substring(1, i1 + 1);
    }
    label153:
    for (;;)
    {
      localTextView.setText(str);
      return;
      i1 = localTextView.length();
      break;
    }
  }
  
  public static void a(ActionBar paramActionBar)
  {
    try
    {
      paramActionBar.getClass().getDeclaredMethod("setShowHideAnimationEnabled", new Class[] { Boolean.TYPE }).invoke(paramActionBar, new Object[] { Boolean.valueOf(false) });
      return;
    }
    catch (Exception localException)
    {
      try
      {
        Field localField = paramActionBar.getClass().getSuperclass().getDeclaredField("mActionBar");
        localField.setAccessible(true);
        paramActionBar = localField.get(paramActionBar);
        localField = paramActionBar.getClass().getDeclaredField("mShowHideAnimationEnabled");
        localField.setAccessible(true);
        localField.set(paramActionBar, Boolean.valueOf(false));
        localField = paramActionBar.getClass().getDeclaredField("mCurrentShowAnim");
        localField.setAccessible(true);
        localField.set(paramActionBar, null);
        return;
      }
      catch (Exception paramActionBar) {}
    }
  }
  
  private boolean c()
  {
    Object localObject = (ConnectivityManager)getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
      if (localObject != null)
      {
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          if (localObject[i1].isConnected()) {
            return true;
          }
          i1 += 1;
        }
      }
    }
    return false;
  }
  
  private boolean d()
  {
    Object localObject = (ConnectivityManager)getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean e()
  {
    Object localObject = (ConnectivityManager)getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new etv(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new euh(this);
  }
  
  private void t()
  {
    super.onBackPressed();
  }
  
  public String a(long paramLong)
  {
    if (paramLong >= 360000000L)
    {
      this.jdField_c_of_type_Long = 0L;
      return "00:00:00";
    }
    if (paramLong < 0L) {
      return "00:00";
    }
    long l1 = paramLong / 3600000L;
    String str1 = "0" + l1;
    str1 = str1.substring(str1.length() - 2, str1.length());
    long l2 = (paramLong - 3600000L * l1) / 60000L;
    String str2 = "0" + l2;
    str2 = str2.substring(str2.length() - 2, str2.length());
    paramLong = (paramLong - 3600000L * l1 - l2 * 60000L) / 1000L;
    String str3 = "0" + paramLong;
    str3 = str3.substring(str3.length() - 2, str3.length());
    if (l1 > 0L) {
      return str1 + ":" + str2 + ":" + str3;
    }
    return str2 + ":" + str3;
  }
  
  public void a(View paramView)
  {
    QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity Hangup...");
    if (QLog.isColorLevel()) {
      QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity onSensorChanged...");
    }
    h();
    QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity Hangup... End");
    if (QLog.isColorLevel()) {
      QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity Hangup... End");
    }
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface = VoipDialInterface.a();
    }
    int i1;
    String str;
    if (this.jdField_d_of_type_Int != 3)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      break label580;
      break label580;
      QLog.d("script", 2, "VOIP_ doDialOut() >> m_ldialStartTime:" + this.jdField_a_of_type_Long);
      QLog.d("script", 2, "VOIP_  >> m_ldialEndTime:" + this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      }
      QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber()...");
      if (QLog.isColorLevel()) {
        QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber()...");
      }
      new String();
      new String();
      if (paramString.length() <= 2) {
        break label750;
      }
      i1 = paramString.indexOf("+");
      if (i1 < 0) {
        break label602;
      }
      str = paramString.substring(i1, paramString.length());
      paramString = paramString.substring(i1 + 1, paramString.length());
    }
    for (;;)
    {
      label194:
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = null;
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.c(str);
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null) {}
      for (this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;; this.jdField_b_of_type_JavaLangString = "")
      {
        QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber()... End");
        if (QLog.isColorLevel())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null)
          {
            QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber() >> UIN:" + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin);
            QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber() >> countryCode:" + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nationCode);
            QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber() >> nickName:" + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName);
            QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber() >> phoneNumberWithoutCountry:" + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileCode);
            QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber() >> strContactName:" + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name);
            QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber() >> contactId:" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.contactID));
          }
          QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber() >> this_countryCode:" + this.jdField_a_of_type_JavaLangString);
          QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber() >> this_phoneNumberWithoutCountry:" + this.jdField_d_of_type_JavaLangString);
          QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity getMergedContactByPhoneNumber()... End");
        }
        n();
        this.jdField_e_of_type_JavaLangString = paramString;
        if (this.jdField_d_of_type_Int != 3) {
          break label635;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface = VoipDialInterface.a();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a() != 0)) {
          setContentView(this.jdField_e_of_type_AndroidViewView);
        }
        label580:
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
          break;
        }
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.b();
        break;
        label602:
        str = "+" + paramString;
        break label194;
      }
      label635:
      this.jdField_k_of_type_Boolean = true;
      if ((!this.jdField_k_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null)) {
        break;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a();
      if ((i1 != -1) && (i1 != 1)) {
        break;
      }
      QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ m_calling_waitinganim_onesec...");
      if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface != null))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131559883));
        QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ MakeCall...");
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(this.jdField_e_of_type_JavaLangString);
      }
      this.jdField_k_of_type_Boolean = false;
      return;
      label750:
      str = paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    new Thread(new ewh(this, paramBoolean)).start();
  }
  
  public void b(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this, VoipHistoryActivity.class);
    startActivity(paramView);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((isResume()) && (this.jdField_g_of_type_Boolean))
    {
      if (paramBoolean) {
        f();
      }
    }
    else {
      return;
    }
    g();
  }
  
  public void c(View paramView)
  {
    paramView = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramView != null)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Dialpad", 0, 1, 0, "1", "", "", "");
      startActivityForResult(new Intent(this, VoipAddressBookActivity.class), 1);
      paramView.k();
      finish();
    }
  }
  
  public void d()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage(2131559889);
    localBuilder.setTitle(2131559890);
    new String();
    localBuilder.setPositiveButton(getString(2131559891), new eus(this));
    localBuilder.setNegativeButton(getString(2131559892), new evi(this));
    localBuilder.create().show();
  }
  
  public void d(View paramView)
  {
    int i1 = VoipHistoryActivity.a(getApplicationContext());
    paramView = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "qqout_start", 4, 1, 0, String.valueOf(i1), paramView.nationCode, this.jdField_a_of_type_JavaLangString, "");
    i();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setText("+" + this.jdField_a_of_type_JavaLangString);
      j();
      this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.a(this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getText().toString());
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getText().toString());
    }
  }
  
  protected void e()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage(2131559893);
    localBuilder.setTitle(2131559894);
    new String();
    localBuilder.setPositiveButton(getString(2131559895), new evy(this));
    localBuilder.setNegativeButton(getString(2131559896), new ewf(this));
    localBuilder.create().show();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624453);
      ImageView localImageView = new ImageView(this);
      localImageView.setBackgroundResource(2130840370);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface = VoipDialInterface.a();
    }
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a() != 0) {
        break label82;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a();
    }
    for (;;)
    {
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131559888));
      }
      this.jdField_e_of_type_Boolean = true;
      o();
      return;
      label82:
      this.jdField_h_of_type_Boolean = true;
    }
  }
  
  protected void i()
  {
    if (!c()) {
      e();
    }
    do
    {
      return;
      new String();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getText().toString();
      this.jdField_d_of_type_JavaLangString = ((String)localObject2);
    } while (((String)localObject2).isEmpty());
    StringBuffer localStringBuffer = new StringBuffer(this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getText().toString().trim());
    Object localObject1 = localObject2;
    if (localStringBuffer.length() > 1)
    {
      localObject1 = localObject2;
      if ('0' == localStringBuffer.charAt(0)) {
        localObject1 = localStringBuffer.substring(1, localStringBuffer.length());
      }
    }
    this.jdField_a_of_type_AndroidSupportV7AppActionBar.hide();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface = VoipDialInterface.a();
    }
    new String();
    Object localObject2 = localObject1;
    if (this.jdField_a_of_type_JavaLangString != null) {
      localObject2 = this.jdField_a_of_type_JavaLangString + (String)localObject1;
    }
    a((String)localObject2);
  }
  
  public void j()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont == null) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer(this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getText().toString().trim());
    if (this.jdField_m_of_type_Boolean == true) {}
    for (int i1 = this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getSelectionStart();; i1 = this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.length())
    {
      if (i1 >= 0) {
        localStringBuffer.insert(i1, ' ');
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setText(localStringBuffer.toString());
      if (i1 < 0) {
        break;
      }
      Selection.setSelection(this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getText(), i1 + 1);
      return;
    }
  }
  
  public void k()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Dialpad", 0, 1, 0, "", "1", "", "");
    startActivityForResult(new Intent(this, CountryActivity.class), 1);
  }
  
  protected void l()
  {
    QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity init_voipdialinterface() run");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface = VoipDialInterface.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a();; i1 = -1)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234831));
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234757));
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234761));
      this.jdField_d_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234765));
      this.jdField_e_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234769));
      this.jdField_f_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_g_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234773));
      this.jdField_g_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_h_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234777));
      this.jdField_h_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_i_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234781));
      this.jdField_i_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_j_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234785));
      this.jdField_j_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_k_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234789));
      this.jdField_k_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_l_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234793));
      this.jdField_l_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_m_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234797));
      this.jdField_m_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234801));
      if (this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont = ((EditTextAutoResizeFont)findViewById(2131234811));
        this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setInputType(0);
        this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setOnClickListener(new etx(this));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont = ((EditTextAutoResizeFont)findViewById(2131234812));
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setInputType(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setOnClickListener(new ety(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setFocusable(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setOtherCtrl(this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont);
        this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setOtherCtrl(this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont);
      }
      Object localObject;
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131234815));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232997));
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label1946;
        }
        if (this.jdField_a_of_type_JavaLangString.compareTo("86") == 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561809));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new etz(this));
        }
      }
      else
      {
        new String();
        localObject = (VoipDialData)getIntent().getSerializableExtra("dialData");
        this.jdField_d_of_type_Int = getIntent().getIntExtra("callNow", -1);
        if ((i1 != 0) || (this.jdField_d_of_type_Int == 3)) {
          break label1958;
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_d_of_type_Int = 3;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
          break label1963;
        }
        localObject = new VoipDialData(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.b());
        label624:
        if (localObject == null) {
          break label1989;
        }
        this.jdField_a_of_type_JavaLangString = "86";
        if ((((VoipDialData)localObject).countryCode != null) && (((VoipDialData)localObject).countryCode.length() > 0))
        {
          if (((VoipDialData)localObject).countryCode.indexOf("+") <= -1) {
            break label1966;
          }
          this.jdField_a_of_type_JavaLangString = ((VoipDialData)localObject).countryCode.substring(1, ((VoipDialData)localObject).countryCode.length());
        }
        label684:
        String str2 = ((VoipDialData)localObject).phoneNumberWithoutContry;
        String str1 = str2;
        if (((VoipDialData)localObject).phoneNumberWithoutContry != null)
        {
          str1 = str2;
          if (((VoipDialData)localObject).phoneNumberWithoutContry.length() > 0)
          {
            str1 = str2;
            if (((VoipDialData)localObject).phoneNumberWithoutContry.indexOf("+") > -1)
            {
              this.jdField_a_of_type_JavaLangString = null;
              localObject = new VoipPhoneNumber(((VoipDialData)localObject).phoneNumberWithoutContry, this);
              this.jdField_a_of_type_JavaLangString = ((VoipPhoneNumber)localObject).jdField_b_of_type_JavaLangString;
              i1 = ((VoipPhoneNumber)localObject).jdField_a_of_type_JavaLangString.indexOf(this.jdField_a_of_type_JavaLangString);
              str1 = ((VoipPhoneNumber)localObject).jdField_a_of_type_JavaLangString.substring(i1 + this.jdField_a_of_type_JavaLangString.length(), ((VoipPhoneNumber)localObject).jdField_a_of_type_JavaLangString.length());
              this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setText("+" + this.jdField_a_of_type_JavaLangString);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(((VoipPhoneNumber)localObject).jdField_d_of_type_JavaLangString);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setText(str1);
      }
      label1946:
      label1958:
      label1963:
      label1966:
      label1989:
      for (i1 = 1;; i1 = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.addTextChangedListener(new eua(this));
        if (this.jdField_a_of_type_JavaLangString != null) {
          this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setText("+" + this.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          j();
          localObject = (InputMethodManager)getSystemService("input_method");
          ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getWindowToken(), 0);
          ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getWindowToken(), 0);
          if (this.jdField_g_of_type_AndroidViewView == null)
          {
            this.jdField_g_of_type_AndroidViewView = findViewById(2131234804);
            this.jdField_g_of_type_AndroidViewView.setOnClickListener(new eub(this));
          }
          if (this.jdField_b_of_type_AndroidWidgetImageView == null)
          {
            this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234807));
            this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new euc(this));
          }
          if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
          {
            this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131234815));
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new eud(this));
          }
          if (this.jdField_t_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_t_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234830));
            this.jdField_t_of_type_AndroidWidgetImageButton.setOnClickListener(new eue(this));
          }
          if (this.jdField_h_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_h_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234817));
            this.jdField_h_of_type_AndroidWidgetImageButton.setTag("1");
            this.jdField_h_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_h_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_i_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_i_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234818));
            this.jdField_i_of_type_AndroidWidgetImageButton.setTag("2");
            this.jdField_i_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_i_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_j_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_j_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234819));
            this.jdField_j_of_type_AndroidWidgetImageButton.setTag("3");
            this.jdField_j_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_j_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_k_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_k_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234820));
            this.jdField_k_of_type_AndroidWidgetImageButton.setTag("4");
            this.jdField_k_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_k_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_l_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_l_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234821));
            this.jdField_l_of_type_AndroidWidgetImageButton.setTag("5");
            this.jdField_l_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_l_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_m_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_m_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234822));
            this.jdField_m_of_type_AndroidWidgetImageButton.setTag("6");
            this.jdField_m_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_m_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_n_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_n_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234823));
            this.jdField_n_of_type_AndroidWidgetImageButton.setTag("7");
            this.jdField_n_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_n_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_o_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_o_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234824));
            this.jdField_o_of_type_AndroidWidgetImageButton.setTag("8");
            this.jdField_o_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_o_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_p_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_p_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234825));
            this.jdField_p_of_type_AndroidWidgetImageButton.setTag("9");
            this.jdField_p_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_p_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_r_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_r_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234827));
            this.jdField_r_of_type_AndroidWidgetImageButton.setTag("0");
            this.jdField_r_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_r_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_q_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_q_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234826));
            this.jdField_q_of_type_AndroidWidgetImageButton.setTag("*");
            this.jdField_q_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_q_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_s_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_s_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234828));
            this.jdField_s_of_type_AndroidWidgetImageButton.setTag("#");
            this.jdField_s_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_s_of_type_AndroidWidgetImageButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_g_of_type_AndroidWidgetImageButton == null)
          {
            this.jdField_g_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234814));
            this.jdField_g_of_type_AndroidWidgetImageButton.setOnLongClickListener(new euf(this));
            this.jdField_g_of_type_AndroidWidgetImageButton.setOnClickListener(new eug(this));
          }
          if (this.jdField_a_of_type_AndroidWidgetButton == null)
          {
            this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131234808));
            this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new eui(this));
          }
          if (this.jdField_b_of_type_AndroidWidgetButton == null)
          {
            this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131234829));
            this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new euj(this));
          }
          if (this.jdField_c_of_type_AndroidWidgetButton == null)
          {
            this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131234810));
            this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new euk(this));
          }
          if ((i1 != 0) && ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3))) {
            i();
          }
          this.jdField_a_of_type_AndroidSupportV7AppActionBar.show();
          QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity init_voipdialinterface() End");
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.jdField_a_of_type_JavaLangString);
          break;
          this.jdField_a_of_type_AndroidWidgetTextView.setText("");
          break;
          this.jdField_a_of_type_Boolean = false;
          break label624;
          this.jdField_a_of_type_JavaLangString = ((VoipDialData)localObject).countryCode;
          break label684;
          this.jdField_b_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setText("");
        }
      }
    }
  }
  
  protected void m()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV7AppActionBar.hide();
    this.jdField_o_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234753));
    this.jdField_o_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_p_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234757));
    this.jdField_p_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_q_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234761));
    this.jdField_q_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_r_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234765));
    this.jdField_r_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_s_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234769));
    this.jdField_s_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_t_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234773));
    this.jdField_t_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_u_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234777));
    this.jdField_u_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_v_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234781));
    this.jdField_v_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_w_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234785));
    this.jdField_w_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_x_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234789));
    this.jdField_x_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_y_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234793));
    this.jdField_y_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_z_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234797));
    this.jdField_z_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_n_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131234713));
    if (this.jdField_d_of_type_Int != 3) {
      a(false);
    }
    this.jdField_j_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_e_of_type_AndroidWidgetTextView == null) {
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234751));
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText("");
    label554:
    label608:
    boolean bool;
    if (this.jdField_b_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234752));
      if (this.jdField_a_of_type_AndroidContentSharedPreferences == null)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("voip_show_tips_in_callingui", 1);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      }
      int i1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("show_tips_in_callingui", 0);
      int i2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("show_tips_in_callingui_times", 0);
      if ((i1 != 9999) && (i2 != 0))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("show_tips_in_callingui_times", i2 - 1);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_b_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234719));
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(new eul(this));
      }
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
        break label2232;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234724));
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new eum(this));
      if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
        break label2243;
      }
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234717));
      this.jdField_c_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(new eun(this));
      this.jdField_c_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840380);
      if (this.jdField_f_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_f_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234715));
        this.jdField_f_of_type_AndroidWidgetImageButton.setOnClickListener(new euo(this));
        this.jdField_f_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840389);
      }
      if (this.jdField_d_of_type_Int == 3)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label2269;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.b()) {
            break label2264;
          }
          bool = true;
          label688:
          this.jdField_c_of_type_Boolean = bool;
          this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.c();
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.b();
          QLog.d("script", 2, "VOIP_ getldialStartTime() >> m_ldialStartTime:" + this.jdField_a_of_type_Long);
        }
        ((AudioManager)getSystemService("audio")).setMicrophoneMute(this.jdField_c_of_type_Boolean);
        if (this.jdField_c_of_type_Boolean) {
          break label2313;
        }
        bool = true;
        label771:
        this.jdField_c_of_type_Boolean = bool;
        if (!this.jdField_c_of_type_Boolean) {
          break label2318;
        }
        this.jdField_c_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840380);
        label793:
        if (!this.jdField_d_of_type_Boolean) {
          break label2331;
        }
        this.jdField_f_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840387);
      }
      label810:
      if (this.jdField_d_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234716));
        this.jdField_d_of_type_AndroidWidgetImageButton.setEnabled(false);
        this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(new eup(this));
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Call_Interface", 0, 1, 0, "1", "", "", "");
      }
      if (this.jdField_e_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_e_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234742));
        this.jdField_e_of_type_AndroidWidgetImageButton.setOnClickListener(new euq(this));
        this.jdField_e_of_type_AndroidWidgetImageButton.setOnTouchListener(new eur(this));
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break label2344;
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131234743);
      this.jdField_d_of_type_AndroidWidgetImageButton.setEnabled(false);
      label963:
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = findViewById(2131234723);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_Long = 0L;
      this.jdField_i_of_type_Boolean = false;
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = findViewById(2131234714);
      }
      if (this.jdField_d_of_type_AndroidViewView == null) {
        this.jdField_d_of_type_AndroidViewView = findViewById(2131234729);
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234749));
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234750));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView == null) {
        this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234725));
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234726));
      }
      if (this.jdField_h_of_type_AndroidWidgetTextView == null) {
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234727));
      }
      if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234728));
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView == null) {
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234745));
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView == null) {
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234748));
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidContentContext = this;
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidContentContext);
        }
      }
      this.jdField_e_of_type_Int = getResources().getDisplayMetrics().widthPixels;
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null) {
        break label2578;
      }
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label2363;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("+" + this.jdField_a_of_type_JavaLangString + " " + this.jdField_d_of_type_JavaLangString);
      this.jdField_g_of_type_AndroidWidgetTextView.setText("");
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_b_of_type_Float != 0.0F) && (this.jdField_c_of_type_Float != 0.0F) && (this.jdField_d_of_type_Float != 0.0F))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(this.jdField_b_of_type_Float);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(this.jdField_c_of_type_Float);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(this.jdField_d_of_type_Float);
      }
      if (this.jdField_e_of_type_Int <= 480)
      {
        this.jdField_b_of_type_Float = this.jdField_f_of_type_AndroidWidgetTextView.getTextSize();
        this.jdField_c_of_type_Float = this.jdField_h_of_type_AndroidWidgetTextView.getTextSize();
        this.jdField_d_of_type_Float = this.jdField_g_of_type_AndroidWidgetTextView.getTextSize();
        this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(17.0F);
        this.jdField_f_of_type_AndroidWidgetTextView.invalidate();
        this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(17.0F);
        this.jdField_h_of_type_AndroidWidgetTextView.invalidate();
        this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(17.0F);
        this.jdField_g_of_type_AndroidWidgetTextView.invalidate();
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText("+" + this.jdField_a_of_type_JavaLangString + " " + this.jdField_d_of_type_JavaLangString);
      label1551:
      if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
        this.jdField_f_of_type_JavaLangString = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840369);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840369);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234747));
      if (this.jdField_u_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_u_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234730));
        this.jdField_u_of_type_AndroidWidgetImageButton.setOnClickListener(new eut(this));
        this.jdField_u_of_type_AndroidWidgetImageButton.setOnTouchListener(new euv(this));
      }
      if (this.jdField_v_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_v_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234731));
        this.jdField_v_of_type_AndroidWidgetImageButton.setOnClickListener(new euw(this));
        this.jdField_v_of_type_AndroidWidgetImageButton.setOnTouchListener(new euy(this));
      }
      if (this.jdField_w_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_w_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234732));
        this.jdField_w_of_type_AndroidWidgetImageButton.setOnClickListener(new euz(this));
        this.jdField_w_of_type_AndroidWidgetImageButton.setOnTouchListener(new evb(this));
      }
      if (this.jdField_x_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_x_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234733));
        this.jdField_x_of_type_AndroidWidgetImageButton.setOnClickListener(new evc(this));
        this.jdField_x_of_type_AndroidWidgetImageButton.setOnTouchListener(new eve(this));
      }
      if (this.jdField_y_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_y_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234734));
        this.jdField_y_of_type_AndroidWidgetImageButton.setOnClickListener(new evf(this));
        this.jdField_y_of_type_AndroidWidgetImageButton.setOnTouchListener(new evh(this));
      }
      if (this.jdField_z_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_z_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131234735));
        this.jdField_z_of_type_AndroidWidgetImageButton.setOnClickListener(new evj(this));
        this.jdField_z_of_type_AndroidWidgetImageButton.setOnTouchListener(new evl(this));
      }
      if (this.A == null)
      {
        this.A = ((ImageButton)findViewById(2131234736));
        this.A.setOnClickListener(new evm(this));
        this.A.setOnTouchListener(new evo(this));
      }
      if (this.B == null)
      {
        this.B = ((ImageButton)findViewById(2131234737));
        this.B.setOnClickListener(new evp(this));
        this.B.setOnTouchListener(new evr(this));
      }
      if (this.C == null)
      {
        this.C = ((ImageButton)findViewById(2131234738));
        this.C.setOnClickListener(new evs(this));
        this.C.setOnTouchListener(new evu(this));
      }
      if (this.D == null)
      {
        this.D = ((ImageButton)findViewById(2131234739));
        this.D.setOnClickListener(new evv(this));
        this.D.setOnTouchListener(new evx(this));
      }
      if (this.E == null)
      {
        this.E = ((ImageButton)findViewById(2131234740));
        this.E.setOnClickListener(new evz(this));
        this.E.setOnTouchListener(new ewb(this));
      }
      if (this.F == null)
      {
        this.F = ((ImageButton)findViewById(2131234741));
        this.F.setOnClickListener(new ewc(this));
        this.F.setOnTouchListener(new ewe(this));
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      label2232:
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      break label554;
      label2243:
      this.jdField_c_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840380);
      this.jdField_c_of_type_AndroidWidgetImageButton.setEnabled(false);
      break label608;
      label2264:
      bool = false;
      break label688;
      label2269:
      if (!getIntent().getBooleanExtra("voip_mbMicIsMute", true)) {}
      for (bool = true;; bool = false)
      {
        this.jdField_c_of_type_Boolean = bool;
        this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("voip_mbSoundIsOut", false);
        break;
      }
      label2313:
      bool = false;
      break label771;
      label2318:
      this.jdField_c_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840384);
      break label793;
      label2331:
      this.jdField_f_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840389);
      break label810;
      label2344:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageButton.setEnabled(false);
      break label963;
      label2363:
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_g_of_type_AndroidWidgetTextView.setText("");
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_b_of_type_Float != 0.0F) && (this.jdField_c_of_type_Float != 0.0F) && (this.jdField_d_of_type_Float != 0.0F))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(this.jdField_b_of_type_Float);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(this.jdField_c_of_type_Float);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(this.jdField_d_of_type_Float);
      }
      if (this.jdField_e_of_type_Int <= 480)
      {
        this.jdField_b_of_type_Float = this.jdField_f_of_type_AndroidWidgetTextView.getTextSize();
        this.jdField_c_of_type_Float = this.jdField_h_of_type_AndroidWidgetTextView.getTextSize();
        this.jdField_d_of_type_Float = this.jdField_g_of_type_AndroidWidgetTextView.getTextSize();
        this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(17.0F);
        this.jdField_f_of_type_AndroidWidgetTextView.invalidate();
        this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(17.0F);
        this.jdField_h_of_type_AndroidWidgetTextView.invalidate();
        this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(17.0F);
        this.jdField_g_of_type_AndroidWidgetTextView.invalidate();
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      break label1551;
      label2578:
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name);
        this.jdField_d_of_type_AndroidWidgetTextView.setText("+" + this.jdField_a_of_type_JavaLangString + " " + this.jdField_d_of_type_JavaLangString);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name);
        if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name.isEmpty()) {
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        for (;;)
        {
          for (;;)
          {
            this.jdField_g_of_type_AndroidWidgetTextView.setText("+" + this.jdField_a_of_type_JavaLangString + " " + this.jdField_d_of_type_JavaLangString);
            if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
              this.jdField_f_of_type_JavaLangString = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.photoUri == null) {
              break label2952;
            }
            try
            {
              Bitmap localBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.photoUri);
              localBitmap = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
              this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
              this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
            }
            catch (IOException localIOException)
            {
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840369);
              this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840369);
            }
          }
          break;
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name);
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name.isEmpty()) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
        break;
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      label2952:
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin != null)
      {
        Drawable localDrawable = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840369);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840369);
      }
    }
  }
  
  protected void n()
  {
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    setContentView(this.jdField_f_of_type_AndroidViewView);
    this.jdField_g_of_type_Boolean = true;
    m();
    if (this.jdField_d_of_type_Int == 3) {}
  }
  
  public void o()
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      ((AudioManager)getSystemService("audio")).setMicrophoneMute(this.jdField_c_of_type_Boolean);
      if (this.jdField_c_of_type_Boolean) {
        break label415;
      }
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
        this.jdField_c_of_type_AndroidWidgetImageButton.setEnabled(false);
      }
    }
    if (!this.jdField_j_of_type_Boolean)
    {
      bool1 = bool2;
      label96:
      a(bool1);
      if (this.jdField_f_of_type_AndroidWidgetImageButton != null)
      {
        if ((!this.jdField_j_of_type_Boolean) || (this.jdField_f_of_type_AndroidWidgetImageButton == null)) {
          break label425;
        }
        this.jdField_f_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840389);
      }
      label132:
      ((AudioManager)getSystemService("audio")).setMode(0);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
        break label604;
      }
    }
    label324:
    label589:
    label597:
    label604:
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.d();; bool1 = false)
    {
      VoipHistoryData localVoipHistoryData;
      VoipHistoryInterface localVoipHistoryInterface;
      if ((this.jdField_b_of_type_Long > this.jdField_a_of_type_Long) && (!this.jdField_h_of_type_Boolean) && (!bool1))
      {
        QLog.d("script", 2, "VOIP_ goToLayoutMain() >> m_ldialStartTime:" + this.jdField_a_of_type_Long);
        QLog.d("script", 2, "VOIP_  >> m_ldialEndTime:" + this.jdField_b_of_type_Long);
        if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null) {
          break label446;
        }
        localVoipHistoryData = new VoipHistoryData();
        localVoipHistoryData.uin = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
        localVoipHistoryData.type = 2;
        localVoipHistoryData.countryCode = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nationCode;
        localVoipHistoryData.nickName = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
        localVoipHistoryData.phoneNumberWithoutCountry = this.jdField_d_of_type_JavaLangString;
        if (this.jdField_i_of_type_Boolean)
        {
          localVoipHistoryData.status = 2;
          localVoipHistoryData.strContactName = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
          localVoipHistoryData.endTime = this.jdField_b_of_type_Long;
          localVoipHistoryData.startTime = this.jdField_a_of_type_Long;
          localVoipHistoryData.contactLookupId = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.lookupID;
          localVoipHistoryInterface = VoipHistoryInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          localVoipHistoryInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          localVoipHistoryInterface.a(localVoipHistoryData);
        }
      }
      else
      {
        if (this.jdField_d_of_type_Int != -1) {
          break label597;
        }
        setContentView(this.jdField_e_of_type_AndroidViewView);
        this.jdField_a_of_type_AndroidSupportV7AppActionBar.show();
      }
      for (;;)
      {
        this.jdField_g_of_type_Boolean = false;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label96;
        this.jdField_f_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840387);
        break label132;
        localVoipHistoryData.status = 3;
        break label324;
        localVoipHistoryData = new VoipHistoryData();
        localVoipHistoryData.uin = this.jdField_b_of_type_JavaLangString;
        localVoipHistoryData.type = 2;
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          localVoipHistoryData.countryCode = ("+" + this.jdField_a_of_type_JavaLangString);
          label501:
          localVoipHistoryData.nickName = "";
          localVoipHistoryData.phoneNumberWithoutCountry = this.jdField_d_of_type_JavaLangString;
          if (!this.jdField_i_of_type_Boolean) {
            break label589;
          }
        }
        for (localVoipHistoryData.status = 2;; localVoipHistoryData.status = 3)
        {
          localVoipHistoryData.strContactName = "";
          localVoipHistoryData.endTime = this.jdField_b_of_type_Long;
          localVoipHistoryData.startTime = this.jdField_a_of_type_Long;
          localVoipHistoryData.contactLookupId = null;
          localVoipHistoryInterface = VoipHistoryInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          localVoipHistoryInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          localVoipHistoryInterface.a(localVoipHistoryData);
          break;
          localVoipHistoryData.countryCode = null;
          break label501;
        }
        super.onBackPressed();
      }
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity onCreate() run");
    if (QLog.isColorLevel()) {
      QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity onCreate() run");
    }
    this.jdField_a_of_type_AndroidOsPowerManager = ((PowerManager)getSystemService("power"));
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = this.jdField_a_of_type_AndroidOsPowerManager.newWakeLock(26, "Dial Screen Lock");
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904065, null);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904064, null);
    this.jdField_a_of_type_AndroidSupportV7AppActionBar = getSupportActionBar();
    this.jdField_a_of_type_AndroidSupportV7AppActionBar.show();
    a(this.jdField_a_of_type_AndroidSupportV7AppActionBar);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    setContentView(this.jdField_e_of_type_AndroidViewView);
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    this.jdField_b_of_type_JavaLangString = new String();
    setVolumeControlStream(3);
    this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 5);
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165186, 1);
    this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165187, 1);
    this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165188, 1);
    this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165189, 1);
    this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165190, 1);
    this.jdField_k_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165191, 1);
    this.jdField_l_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165192, 1);
    this.jdField_m_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165193, 1);
    this.jdField_n_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165194, 1);
    this.jdField_o_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165196, 1);
    this.jdField_p_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165185, 1);
    this.jdField_q_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(this, 2131165195, 1);
    paramBundle = new IntentFilter();
    paramBundle.addAction(VoipDialInterface.jdField_b_of_type_JavaLangString);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_d_of_type_JavaLangString = new String();
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("voip_show_tips_in_callingui", 1);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    setTitle(getString(2131559903));
    s();
    l();
    int i1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("show_tips_in_callingui", -1);
    int i2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("show_tips_in_callingui_times", -1);
    if (i1 != 9999)
    {
      if (i2 != 0) {
        break label823;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("show_tips_in_callingui", 9999);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      this.jdField_a_of_type_AndroidContentContext = this;
      this.jdField_a_of_type_AndroidAppNotificationManager = ((NotificationManager)getSystemService("notification"));
      this.jdField_a_of_type_AndroidAppPendingIntent = null;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidContentContext);
      QLog.d("VoipDialInterfaceActivity", 2, "onCreate...");
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getSystemService("sensor"));
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
      paramBundle = getResources().getDisplayMetrics();
      this.jdField_e_of_type_Int = paramBundle.widthPixels;
      i1 = paramBundle.heightPixels;
      QLog.d("script", 2, "VOIP_ 屏幕尺寸2：宽度 = " + this.jdField_e_of_type_Int + "高度 = " + i1 + "密度 = " + paramBundle.densityDpi);
      QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ 屏幕尺寸2：宽度 = " + this.jdField_e_of_type_Int + "高度 = " + i1 + "密度 = " + paramBundle.densityDpi);
      QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity onCreate() End");
      if (QLog.isColorLevel()) {
        QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity onCreate() End");
      }
      paramBundle = (ImageView)findViewById(2131234755);
      try
      {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        paramBundle.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), 2130840372), 300 * this.jdField_e_of_type_Int / 1080, 300 * this.jdField_e_of_type_Int / 1080, false));
        return;
      }
      catch (Exception localException)
      {
        label823:
        paramBundle.setImageResource(2130840372);
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("show_tips_in_callingui_times", 1);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.jdField_d_of_type_Int == -1)
    {
      MenuItem localMenuItem = paramMenu.add(0, 2131234807, 0, "");
      localMenuItem.setIcon(2130840482);
      localMenuItem.setTitle(getString(2131559881));
      MenuItemCompat.setShowAsAction(localMenuItem, 1);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if ((this.jdField_c_of_type_Int > 0) && (this.jdField_c_of_type_Int != 9)) {
      a(null);
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setContentView(this.jdField_e_of_type_AndroidViewView);
    l();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      c(null);
    }
  }
  
  public void onPause()
  {
    QLog.d("VoipDialInterfaceActivity", 2, "unregisterListener...");
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this, this.jdField_a_of_type_AndroidHardwareSensor);
    super.onPause();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onRestart()
  {
    super.onRestart();
  }
  
  public void onResume()
  {
    QLog.d("VoipDialInterfaceActivity", 2, "registerListener...");
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 3);
    super.onResume();
    this.jdField_h_of_type_AndroidWidgetImageButton.requestFocus();
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_AndroidSupportV7AppActionBar.hide();
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity onSensorChanged...");
    if (QLog.isColorLevel()) {
      QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity onSensorChanged...");
    }
    float f1 = paramSensorEvent.values[0];
    if (this.jdField_a_of_type_Float == -1.0F)
    {
      this.jdField_a_of_type_Float = f1;
      paramSensorEvent = "Current val: " + this.jdField_a_of_type_Float;
      QLog.d("VoipDialInterfaceActivity", 2, paramSensorEvent);
      QLog.d("VoipDialInterfaceActivity", 2, "VOIP_ VoipDialInterfaceActivity onSensorChanged... End");
      if (QLog.isColorLevel())
      {
        QLog.d("script", 2, paramSensorEvent);
        QLog.d("script", 2, "VOIP_ VoipDialInterfaceActivity onSensorChanged... End");
      }
      return;
    }
    if (f1 < this.jdField_a_of_type_Float) {
      b(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = f1;
      break;
      b(false);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface = VoipDialInterface.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(false, 0, null, null);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a();
    }
  }
  
  public void onStop()
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidAppPendingIntent == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont != null))
    {
      this.jdField_a_of_type_AndroidContentContext = this;
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, VoipDialInterfaceActivity.class);
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).putExtra("dialData", new VoipDialData(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getText().toString()));
      ((Intent)localObject).putExtra("callNow", 3);
      ((Intent)localObject).putExtra("voip_mbMicIsMute", this.jdField_c_of_type_Boolean);
      ((Intent)localObject).putExtra("voip_mbSoundIsOut", this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_AndroidAppPendingIntent = PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, (Intent)localObject, 134217728);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface = VoipDialInterface.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface != null) && (this.jdField_a_of_type_AndroidAppPendingIntent != null) && (this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_g_of_type_Boolean))
    {
      if (!this.jdField_c_of_type_AndroidWidgetTextView.getText().toString().isEmpty()) {
        break label441;
      }
      localObject = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(true, 2130838018, (String)localObject, this.jdField_a_of_type_AndroidAppPendingIntent);
      localObject = new VoipHistoryData();
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null) {
        break label465;
      }
      ((VoipHistoryData)localObject).uin = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
      ((VoipHistoryData)localObject).type = 2;
      ((VoipHistoryData)localObject).countryCode = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nationCode;
      ((VoipHistoryData)localObject).nickName = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
      ((VoipHistoryData)localObject).phoneNumberWithoutCountry = this.jdField_d_of_type_JavaLangString;
      if (!this.jdField_i_of_type_Boolean) {
        break label457;
      }
    }
    label441:
    label457:
    for (((VoipHistoryData)localObject).status = 2;; ((VoipHistoryData)localObject).status = 3)
    {
      ((VoipHistoryData)localObject).strContactName = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
      ((VoipHistoryData)localObject).endTime = this.jdField_b_of_type_Long;
      ((VoipHistoryData)localObject).startTime = this.jdField_a_of_type_Long;
      ((VoipHistoryData)localObject).contactLookupId = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.lookupID;
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a((VoipHistoryData)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getText().toString(), this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      QLog.d("script", 2, "VOIP_ onStop() >> m_ldialStartTime:" + this.jdField_a_of_type_Long);
      QLog.d("script", 2, "VOIP_  >> m_ldialEndTime:" + this.jdField_b_of_type_Long);
      finish();
      super.onStop();
      return;
      localObject = this.jdField_c_of_type_AndroidWidgetTextView.getText().toString();
      break;
    }
    label465:
    ((VoipHistoryData)localObject).uin = this.jdField_b_of_type_JavaLangString;
    ((VoipHistoryData)localObject).type = 2;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      ((VoipHistoryData)localObject).countryCode = ("+" + this.jdField_a_of_type_JavaLangString);
      label512:
      ((VoipHistoryData)localObject).nickName = "";
      ((VoipHistoryData)localObject).phoneNumberWithoutCountry = this.jdField_d_of_type_JavaLangString;
      if (!this.jdField_i_of_type_Boolean) {
        break label576;
      }
    }
    label576:
    for (((VoipHistoryData)localObject).status = 2;; ((VoipHistoryData)localObject).status = 3)
    {
      ((VoipHistoryData)localObject).strContactName = "";
      ((VoipHistoryData)localObject).endTime = this.jdField_b_of_type_Long;
      ((VoipHistoryData)localObject).startTime = this.jdField_a_of_type_Long;
      ((VoipHistoryData)localObject).contactLookupId = null;
      break;
      ((VoipHistoryData)localObject).countryCode = null;
      break label512;
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_h_of_type_AndroidWidgetTextView.setText("00:00");
    this.jdField_i_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidWidgetImageButton.setEnabled(true);
    this.jdField_l_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidWidgetImageButton.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void q()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void r()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
    this.jdField_l_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity
 * JD-Core Version:    0.7.0.1
 */