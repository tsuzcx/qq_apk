package com.tencent.mobileqq.troop.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.widget.QQToast;
import hcv;
import hcw;
import hcx;
import hcy;
import hcz;
import hda;
import hdb;
import hdc;
import hdd;
import hde;
import hdf;
import java.lang.reflect.Method;
import java.util.Formatter;
import java.util.Locale;

public class MediaControllerX
  extends FrameLayout
{
  static final float jdField_a_of_type_Float = 7.8F;
  public static final int a = -1;
  static final float jdField_b_of_type_Float = 2.2F;
  public static final int b = 0;
  public static final int c = 1;
  private static final int jdField_f_of_type_Int = 5000;
  private static final int jdField_g_of_type_Int = 1;
  private static final int jdField_h_of_type_Int = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  public final SensorEventListener a;
  private Handler jdField_a_of_type_AndroidOsHandler = new hdc(this);
  public View.OnClickListener a;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new hcv(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new hcy(this);
  private View jdField_a_of_type_AndroidViewView;
  private Window jdField_a_of_type_AndroidViewWindow;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new hde(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private MediaControllerX.MediaControllerListener jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener = null;
  private MediaControllerX.MediaPlayerControlX jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX;
  private String jdField_a_of_type_JavaLangString;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  Formatter jdField_a_of_type_JavaUtilFormatter;
  public boolean a;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new hda(this);
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public View.OnClickListener c;
  private View jdField_c_of_type_AndroidViewView;
  private ImageButton jdField_c_of_type_AndroidWidgetImageButton;
  public boolean c;
  public int d;
  View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new hdb(this);
  private ImageButton jdField_d_of_type_AndroidWidgetImageButton;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener;
  private ImageButton jdField_e_of_type_AndroidWidgetImageButton;
  private boolean jdField_e_of_type_Boolean;
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener;
  private ImageButton jdField_f_of_type_AndroidWidgetImageButton;
  private boolean jdField_f_of_type_Boolean;
  private View.OnClickListener jdField_g_of_type_AndroidViewView$OnClickListener = new hdd(this);
  private ImageButton jdField_g_of_type_AndroidWidgetImageButton;
  private boolean jdField_g_of_type_Boolean;
  private View.OnClickListener jdField_h_of_type_AndroidViewView$OnClickListener = new hdf(this);
  private ImageButton jdField_h_of_type_AndroidWidgetImageButton;
  private boolean jdField_h_of_type_Boolean;
  private View.OnClickListener jdField_i_of_type_AndroidViewView$OnClickListener = new hcw(this);
  private boolean jdField_i_of_type_Boolean = false;
  private boolean j = false;
  private boolean k = false;
  
  public MediaControllerX(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = new hcx(this);
    this.jdField_b_of_type_AndroidViewView = this;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
  }
  
  public MediaControllerX(Context paramContext, BaseActivity paramBaseActivity, String paramString)
  {
    this(paramContext, paramBaseActivity, paramString, true);
  }
  
  public MediaControllerX(Context paramContext, BaseActivity paramBaseActivity, String paramString, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = new hcx(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_f_of_type_Boolean = paramBoolean;
    h();
    g();
  }
  
  private int a()
  {
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX == null) || (this.jdField_e_of_type_Boolean))
    {
      m = 0;
      return m;
    }
    int n = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.b();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a();
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      if (i1 <= 0) {
        break label139;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      long l = 1000L * n / i1;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)l);
    }
    for (;;)
    {
      m = n;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break;
      }
      if (i1 <= 0) {
        break label150;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(a(i1));
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(a(n));
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return n;
      label139:
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
    label150:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    return n;
  }
  
  private String a(int paramInt)
  {
    int n = paramInt / 1000;
    paramInt = n % 60;
    int m = n / 60 % 60;
    n /= 3600;
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    if (n > 0) {
      return this.jdField_a_of_type_JavaUtilFormatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(paramInt) }).toString();
    }
    return this.jdField_a_of_type_JavaUtilFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramInt) }).toString();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131232649));
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131558471));
        this.jdField_a_of_type_AndroidWidgetImageButton.requestFocus();
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
      }
    }
    else
    {
      this.jdField_f_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131232658));
      if ((this.jdField_f_of_type_AndroidWidgetImageButton != null) && (!this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
      {
        this.jdField_f_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        if (!c()) {
          break label438;
        }
        this.jdField_f_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131558473));
      }
      label138:
      this.jdField_g_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131232656));
      if (this.jdField_g_of_type_AndroidWidgetImageButton != null)
      {
        this.jdField_g_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
        if (!c()) {
          break label458;
        }
        this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.j) {
        this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      this.jdField_h_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131232657));
      if (this.jdField_h_of_type_AndroidWidgetImageButton != null)
      {
        this.jdField_h_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131558478));
        this.jdField_h_of_type_AndroidWidgetImageButton.setOnClickListener(new hcz(this));
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131232650));
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(getResources().getString(2131558475));
        if ((this.jdField_a_of_type_AndroidWidgetProgressBar instanceof SeekBar)) {
          ((SeekBar)this.jdField_a_of_type_AndroidWidgetProgressBar).setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1000);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131232652));
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232655));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232653));
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      this.jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder, Locale.getDefault());
      l();
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131558470));
      break;
      label438:
      this.jdField_f_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131558472));
      break label138;
      label458:
      this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  private void g()
  {
    int m = 0;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    for (;;)
    {
      try
      {
        Method[] arrayOfMethod = Class.forName("com.android.internal.policy.PolicyManager").getMethods();
        Method localMethod = null;
        if (m < arrayOfMethod.length)
        {
          if (arrayOfMethod[m].getName().endsWith("makeNewWindow")) {
            localMethod = arrayOfMethod[m];
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewWindow = ((Window)localMethod.invoke(null, new Object[] { this.jdField_a_of_type_AndroidContentContext }));
          this.jdField_a_of_type_AndroidViewWindow.setWindowManager(this.jdField_a_of_type_AndroidViewWindowManager, null, null);
          this.jdField_a_of_type_AndroidViewWindow.requestFeature(1);
          this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewWindow.getDecorView();
          this.jdField_c_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          this.jdField_a_of_type_AndroidViewWindow.setContentView(this);
          this.jdField_a_of_type_AndroidViewWindow.setBackgroundDrawableResource(17170445);
          this.jdField_a_of_type_AndroidViewWindow.setVolumeControlStream(3);
          setFocusable(true);
          setFocusableInTouchMode(true);
          setDescendantFocusability(262144);
          requestFocus();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      m += 1;
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.gravity = 48;
    localLayoutParams.height = -2;
    localLayoutParams.x = 0;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.flags |= 0x820020;
    localLayoutParams.token = null;
    localLayoutParams.windowAnimations = 0;
  }
  
  private void i()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.width = this.jdField_a_of_type_AndroidViewView.getWidth();
    localLayoutParams.y = (arrayOfInt[1] + this.jdField_a_of_type_AndroidViewView.getHeight());
    if (this.jdField_c_of_type_AndroidViewView != null) {
      localLayoutParams.y -= this.jdField_c_of_type_AndroidViewView.getHeight();
    }
  }
  
  private void j()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidWidgetImageButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.b())) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      }
      if ((this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.b())) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setEnabled(false);
      }
      if ((this.jdField_c_of_type_AndroidWidgetImageButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.c())) {
        this.jdField_c_of_type_AndroidWidgetImageButton.setEnabled(false);
      }
      if ((this.jdField_b_of_type_AndroidWidgetImageButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.d())) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
      }
      return;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError) {}
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, "P_CliOper", "Grp_AIO", "", "video", "Clk_stop", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.b();
    }
    for (;;)
    {
      d();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, "P_CliOper", "Grp_AIO", "", "video", "Clk_play", 0, 0, this.jdField_a_of_type_JavaLangString, "0", "", "");
      if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) == 0)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560679), 1).a();
      }
      else
      {
        int m = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.d();
        if ((m == -1) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.e()))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.c();
        }
        else if (m == 5)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a();
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a(1);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a();
        }
      }
    }
  }
  
  private void l()
  {
    boolean bool2 = true;
    ImageButton localImageButton;
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
      localImageButton = this.jdField_d_of_type_AndroidWidgetImageButton;
      if (this.jdField_e_of_type_AndroidViewView$OnClickListener != null)
      {
        bool1 = true;
        localImageButton.setEnabled(bool1);
      }
    }
    else if (this.jdField_e_of_type_AndroidWidgetImageButton != null)
    {
      this.jdField_e_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
      localImageButton = this.jdField_e_of_type_AndroidWidgetImageButton;
      if (this.jdField_f_of_type_AndroidViewView$OnClickListener == null) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localImageButton.setEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected View a()
  {
    this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903459, null);
    a(this.jdField_b_of_type_AndroidViewView);
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.j = true;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    Message localMessage;
    do
    {
      return;
      if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        a();
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
          this.jdField_a_of_type_AndroidWidgetImageButton.requestFocus();
        }
        j();
        i();
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_c_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        }
        this.jdField_d_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener.f();
        }
      }
      d();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    } while (paramInt == 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation == 2)
    {
      if (this.jdField_g_of_type_AndroidWidgetImageButton != null) {
        this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      if (this.jdField_f_of_type_AndroidWidgetImageButton != null) {
        this.jdField_f_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838545);
      }
    }
    for (;;)
    {
      if (this.j) {
        this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      return;
      if (paramConfiguration.orientation == 1)
      {
        if (this.jdField_g_of_type_AndroidWidgetImageButton != null) {
          this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(8);
        }
        if (this.jdField_f_of_type_AndroidWidgetImageButton != null) {
          this.jdField_f_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838546);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    a(5000);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_g_of_type_AndroidWidgetImageButton != null) {
        this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      this.jdField_e_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(1024);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(0);
      if (this.jdField_f_of_type_AndroidWidgetImageButton != null) {
        this.jdField_f_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838545);
      }
    }
    for (;;)
    {
      e();
      if (this.j) {
        this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      return;
      if (paramInt == 0)
      {
        if (this.jdField_g_of_type_AndroidWidgetImageButton != null) {
          this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(8);
        }
        this.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(1024);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(1);
        if (this.jdField_f_of_type_AndroidWidgetImageButton != null) {
          this.jdField_f_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838546);
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    for (;;)
    {
      return;
      if (!this.jdField_d_of_type_Boolean) {
        continue;
      }
      try
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_c_of_type_AndroidViewView);
        label36:
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener.g();
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label36;
      }
    }
  }
  
  @TargetApi(8)
  public boolean c()
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getRotation();
    return (m == 1) || (m == 3);
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetImageButton == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a())
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838548);
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131558471));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838549);
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131558470));
  }
  
  public boolean d()
  {
    return this.k;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int n = paramKeyEvent.getKeyCode();
    int m;
    if ((paramKeyEvent.getRepeatCount() == 0) && (paramKeyEvent.getAction() == 0))
    {
      m = 1;
      if ((n != 79) && (n != 85) && (n != 62)) {
        break label76;
      }
      if (m != 0)
      {
        k();
        a(5000);
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
          this.jdField_a_of_type_AndroidWidgetImageButton.requestFocus();
        }
      }
    }
    label76:
    label120:
    do
    {
      do
      {
        do
        {
          return true;
          m = 0;
          break;
          if (n != 126) {
            break label120;
          }
        } while ((m == 0) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a()));
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a();
        d();
        a(5000);
        return true;
        if ((n != 86) && (n != 127)) {
          break label170;
        }
      } while ((m == 0) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.a()));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX.b();
      d();
      a(5000);
      return true;
      if ((n == 25) || (n == 24) || (n == 164)) {
        return super.dispatchKeyEvent(paramKeyEvent);
      }
      if ((n != 4) && (n != 82)) {
        break label216;
      }
    } while (m == 0);
    label170:
    c();
    return true;
    label216:
    a(5000);
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  void e()
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
    SensorManager localSensorManager = (SensorManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("sensor");
    Sensor localSensor = localSensorManager.getDefaultSensor(1);
    localSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
    localSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, localSensor, 2);
  }
  
  public void f()
  {
    this.k = false;
  }
  
  public void onFinishInflate()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      a(this.jdField_b_of_type_AndroidViewView);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(MediaControllerX.class.getName());
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(MediaControllerX.class.getName());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a(5000);
    return true;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    a(5000);
    return false;
  }
  
  @TargetApi(11)
  public void setAnchorView(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
    paramView = new FrameLayout.LayoutParams(-1, -1);
    removeAllViews();
    addView(a(), paramView);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
      this.jdField_c_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
    ImageButton localImageButton;
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null)
    {
      localImageButton = this.jdField_d_of_type_AndroidWidgetImageButton;
      if ((paramBoolean) && (this.jdField_e_of_type_AndroidViewView$OnClickListener != null))
      {
        bool1 = true;
        localImageButton.setEnabled(bool1);
      }
    }
    else if (this.jdField_e_of_type_AndroidWidgetImageButton != null)
    {
      localImageButton = this.jdField_e_of_type_AndroidWidgetImageButton;
      if ((!paramBoolean) || (this.jdField_f_of_type_AndroidViewView$OnClickListener == null)) {
        break label156;
      }
    }
    label156:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localImageButton.setEnabled(bool1);
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setEnabled(paramBoolean);
      }
      if (this.jdField_f_of_type_AndroidWidgetImageButton != null) {
        this.jdField_f_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
      }
      j();
      super.setEnabled(paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void setMediaControllerListener(MediaControllerX.MediaControllerListener paramMediaControllerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener = paramMediaControllerListener;
  }
  
  public void setMediaPlayer(MediaControllerX.MediaPlayerControlX paramMediaPlayerControlX)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaPlayerControlX = paramMediaPlayerControlX;
    d();
  }
  
  public void setOnSwitchSubTitleBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setPrevNextListeners(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    this.jdField_e_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_f_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      l();
      if ((this.jdField_d_of_type_AndroidWidgetImageButton != null) && (!this.jdField_g_of_type_Boolean)) {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      if ((this.jdField_e_of_type_AndroidWidgetImageButton != null) && (!this.jdField_g_of_type_Boolean)) {
        this.jdField_e_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
  }
  
  public void setProgressVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(paramInt);
    }
  }
  
  public void setonOutLinkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MediaControllerX
 * JD-Core Version:    0.7.0.1
 */