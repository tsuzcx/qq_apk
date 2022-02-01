package com.tencent.mobileqq.activity.aio.audiopanel;

import acfp;
import aeif;
import aemf;
import aibl;
import alic;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.support.v4.view.ViewCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import aomq;
import aqcl;
import aurs;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import jqc;
import kbp;
import wja;
import wpi;
import wpx;
import wpy;
import wpz;
import ycd;

public class PressToSpeakPanel
  extends RelativeLayout
  implements View.OnTouchListener, QQRecorder.a, wpi
{
  private static boolean bfh;
  private TextView Io;
  private alic jdField_a_of_type_Alic;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private MoveDistIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private PttTipSwitchView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView;
  private VolumeChangeView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private QQAppInterface app;
  private AudioPanel jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private MoveDistIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private VolumeChangeView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private double bA;
  private double bB;
  private double bC;
  private double bD;
  private int bQp = -1;
  private int bQq = 0;
  private int bQr;
  private int bQs;
  private final int bQt = 80;
  private final int bQu = 42;
  private int bQv;
  private int bQw = 100;
  private int bQx;
  private ViewGroup ba;
  private boolean beP;
  private boolean bfe;
  private boolean bfi;
  private boolean bfj = true;
  private boolean bfk = true;
  private boolean bfl = true;
  private ViewGroup dc;
  private ViewGroup df;
  protected ViewGroup dg;
  private ViewGroup di;
  private ViewGroup dj;
  private ViewGroup dk;
  private PopupWindow e;
  private SharedPreferences pref;
  private double recordTime;
  private ImageView sw;
  private Handler uiHandler;
  private View ws;
  
  public PressToSpeakPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public PressToSpeakPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private boolean RE()
  {
    return false;
  }
  
  private int a(int paramInt, boolean paramBoolean, View paramView, double paramDouble1, double paramDouble2)
  {
    int i = this.bQx;
    if (paramView.getVisibility() != 0) {
      paramInt = i;
    }
    do
    {
      return paramInt;
      if ((paramDouble1 == 0.0D) || (paramDouble2 == 0.0D)) {
        cay();
      }
      if (paramBoolean)
      {
        if (paramInt <= paramDouble1) {
          return this.bQw;
        }
        if (paramInt > this.bQv) {
          return this.bQx;
        }
      }
      else
      {
        if (paramInt >= paramDouble1) {
          return this.bQw;
        }
        if (paramInt < this.bQv) {
          return this.bQx;
        }
      }
      paramDouble1 = Math.abs(paramInt - paramDouble1);
      i = (int)(this.bQw - (paramDouble1 * 1.3D - paramDouble2) / this.bQp * 100.0D);
      paramInt = i;
    } while (i >= this.bQx);
    return this.bQx;
  }
  
  private void caA()
  {
    this.bfj = true;
    this.bfk = true;
    this.bfl = true;
  }
  
  private void caB()
  {
    ((Vibrator)this.app.getApp().getSystemService("vibrator")).vibrate(50L);
  }
  
  private void caC()
  {
    if (XPanelContainer.aLe != (int)(196.0F * getContext().getResources().getDisplayMetrics().density))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.dk.getLayoutParams();
      localLayoutParams.topMargin = ankt.dip2px(30.0F);
      this.dk.setLayoutParams(localLayoutParams);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.dk.getLayoutParams();
    localLayoutParams.topMargin = ankt.dip2px(42.0F);
    this.dk.setLayoutParams(localLayoutParams);
  }
  
  private void cax()
  {
    TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(2131561187, null);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      localTextView.setTextColor(Color.parseColor("#FF737373"));
    }
    Object localObject1;
    Object localObject2;
    if ((VipUtils.cf(this.app)) && (RE()))
    {
      localObject1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131561188, null);
      if (VipUtils.ce(this.app))
      {
        localObject2 = a(new SpannableString(getContext().getString(2131701776, new Object[] { "5分钟" })), "5分钟");
        ((TextView)((LinearLayout)localObject1).findViewById(2131373748)).setText((CharSequence)localObject2);
        ((ImageView)((LinearLayout)localObject1).findViewById(2131373747)).setImageResource(2130844116);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView((View)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView(localTextView);
        aurs.runOnUiThread(new PressToSpeakPanel.2(this), 2000L);
        this.app.getApp().getSharedPreferences("pref_ppt_hint" + this.app.getCurrentAccountUin(), 0).edit().putLong("key_last_show_vip_tips", System.currentTimeMillis()).apply();
        localObject2 = this.app.getCurrentAccountUin();
        String str = jqc.hS();
        if (!VipUtils.ce(this.app)) {
          break label360;
        }
        localObject1 = "svip";
        label264:
        VasWebviewUtil.reportCommercialDrainage((String)localObject2, "PanelPrivilegeView", "TailView", "0", 1, 0, 0, str, "", (String)localObject1);
      }
    }
    for (;;)
    {
      aqcl.Q(localTextView, false);
      return;
      localObject2 = a(new SpannableString(getContext().getString(2131701861, new Object[] { "3分钟" })), "3分钟");
      ((TextView)((LinearLayout)localObject1).findViewById(2131373748)).setText((CharSequence)localObject2);
      ((ImageView)((LinearLayout)localObject1).findViewById(2131373747)).setImageResource(2130844729);
      break;
      label360:
      localObject1 = "vip";
      break label264;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView(localTextView);
    }
  }
  
  private void cay()
  {
    this.bQv = (ankt.aE(getContext()) / 2);
    double d1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth();
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen(arrayOfInt);
    double d2 = d1 / 2.0D;
    this.bA = (arrayOfInt[0] + d2);
    if (AppSetting.enableTalkBack)
    {
      d1 *= 0.8D;
      this.bB = d1;
      d1 = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth();
      arrayOfInt = new int[2];
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen(arrayOfInt);
      d2 = d1 / 2.0D;
      this.bC = (arrayOfInt[0] + d2);
      if (!AppSetting.enableTalkBack) {
        break label137;
      }
    }
    label137:
    for (d1 *= 0.8D;; d1 /= 2.0D)
    {
      this.bD = d1;
      return;
      d1 /= 2.0D;
      break;
    }
  }
  
  public boolean R(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    int i = (int)paramMotionEvent.getRawY();
    int m = (int)paramMotionEvent.getRawX();
    int j;
    if ((k == 0) || (k == 2))
    {
      this.bQq = 3;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        j = a(m, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView, this.bA, this.bB);
        if (j <= 80) {
          break label206;
        }
        this.bQq = 1;
        if (this.bfk)
        {
          this.bfk = false;
          caB();
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
        i = j;
        if (j > this.bQw) {
          i = this.bQw;
        }
        paramMotionEvent.setLevel(i);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        j = a(m, false, this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView, this.bC, this.bD);
        if (j <= 80) {
          break label243;
        }
        this.bQq = 2;
        if (this.bfl)
        {
          this.bfl = false;
          caB();
        }
        label174:
        paramMotionEvent = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
        i = j;
        if (j > this.bQw) {
          i = this.bQw;
        }
        paramMotionEvent.setLevel(i);
      }
    }
    if (k == 0) {}
    label206:
    label243:
    while ((k == 2) || ((k != 1) && (k != 3)))
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      if ((j >= 42) || (this.bfk)) {
        break;
      }
      this.bfk = true;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      if ((j >= 42) || (this.bfl)) {
        break label174;
      }
      this.bfl = true;
      break label174;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    i = 0;
    if (this.bQq == 1) {
      i = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(i);
      break;
      if (this.bQq == 2)
      {
        anot.a(null, "dc00898", "", "", "0X800A1D5", "0X800A1D5", 1, 0, "", "", "", "");
        if (AppSetting.enableTalkBack)
        {
          aqcl.speak(this.ba, getContext().getString(2131692109));
          i = 1;
        }
      }
      else
      {
        if (this.bQq != 3) {
          continue;
        }
        i = 0;
        continue;
      }
      i = 1;
    }
  }
  
  public boolean RF()
  {
    QQRecorder.RecorderParam localRecorderParam = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    return (((aemf)aeif.a().o(488)).isOpen()) && (localRecorderParam.mAudioType == 1) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aSM);
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.vl();
  }
  
  public SpannableString a(SpannableString paramSpannableString, String paramString)
  {
    int i = paramSpannableString.toString().indexOf(paramString);
    if (i < 0) {
      return paramSpannableString;
    }
    paramSpannableString.setSpan(new ForegroundColorSpan(-1145334), i, paramString.length() + i, 33);
    return paramSpannableString;
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.ba = paramViewGroup1;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    paramAudioPanel.setSpeakPanel(this);
    this.dc = paramViewGroup2;
    this.df = paramViewGroup3;
    this.dg = paramViewGroup4;
    this.uiHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView = ((PttTipSwitchView)findViewById(2131373745));
    this.di = ((ViewGroup)findViewById(2131378702));
    this.dj = ((ViewGroup)findViewById(2131369145));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369147));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369148));
    this.Io = ((TextView)findViewById(2131378610));
    this.sw = ((ImageView)findViewById(2131373562));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131366472));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setType(1);
    if (RF())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setImageResource(2130845672);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(acfp.m(2131709873));
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131378609));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setType(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(acfp.m(2131709870));
      this.dk = ((ViewGroup)findViewById(2131369144));
      this.sw.setOnTouchListener(this);
      paramBaseChatPie = paramBaseChatPie.a().getResources();
      if (paramViewGroup2.getVisibility() == 4) {
        setPadding(getPaddingLeft(), getPaddingTop() + wja.dp2px(12.5F, paramBaseChatPie), getPaddingRight(), getPaddingBottom());
      }
      if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
      {
        this.Io.setTextColor(Color.parseColor("#FF4A4A4A"));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167295));
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167295));
      }
      cax();
      this.jdField_a_of_type_Alic = new alic();
      if (this.bQp == -1)
      {
        paramViewGroup1 = new Rect();
        getWindowVisibleDisplayFrame(paramViewGroup1);
        int i = paramViewGroup1.right / 2;
        int j = wja.dp2px(75.0F, paramBaseChatPie);
        this.bQp = (i - j);
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "rect is:" + paramViewGroup1 + "entirePanelWidth is:" + i + ",listenRight is:" + j + ",mBasicDistance is:" + this.bQp);
        }
      }
      if (AppSetting.enableTalkBack)
      {
        this.pref = paramQQAppInterface.getApp().getSharedPreferences("pref_ppt_hint" + paramQQAppInterface.getCurrentAccountUin(), 0);
        this.bQr = this.pref.getInt("key_ppt_hint", 3);
        this.bfi = false;
        setFocusable(false);
        ViewCompat.setImportantForAccessibility(this, 2);
        ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView, 2);
        this.sw.setContentDescription(getContext().getString(2131690220));
        ViewCompat.setAccessibilityDelegate(this.sw, new wpx(this));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setImageResource(2130845664);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(acfp.m(2131709871));
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderPrepare() is called,path is:" + paramString);
    }
    this.uiHandler.post(new PressToSpeakPanel.4(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, paramRecorderParam);
    if (paramRecorderParam.mUserData == null) {}
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    aibl localaibl = (aibl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(16);
    if (localaibl != null) {
      localaibl.drR();
    }
    if (this.recordTime < 500.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.vd(paramString);
      this.uiHandler.post(new PressToSpeakPanel.10(this, paramString, paramRecorderParam));
      anot.a(this.app, "CliOper", "", "", "0X8005A17", "0X8005A17", 11, 0, String.valueOf((int)this.recordTime), "", "", "3.4.4");
    }
    do
    {
      return;
      aomq.jK(1, (int)this.recordTime);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getFateOfRecorder();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "time is:" + this.recordTime + ",fateOfRecorder is:" + i);
      }
      if (i == 2)
      {
        if (RF())
        {
          this.uiHandler.post(new PressToSpeakPanel.11(this, paramString, paramRecorderParam, paramDouble));
          return;
        }
        anot.a(null, "dc00898", "", "", "0X800A1D6", "0X800A1D6", 1, 0, "", "", "", "");
        this.uiHandler.post(new PressToSpeakPanel.12(this, paramString, paramRecorderParam));
        return;
      }
      if (i != 0) {
        break;
      }
      anot.a(null, "dc00898", "", "", "0X800A1D4", "0X800A1D4", 1, 0, "", "", "", "");
      this.bQs += 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, 1, (int)paramDouble, paramRecorderParam, 0, true, 0);
      this.uiHandler.post(new PressToSpeakPanel.13(this, paramString));
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ycd));
    kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005853", "0X8005853", 0, 0, "", "", Double.toString(this.recordTime), "", false);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString, 1, paramRecorderParam);
    this.uiHandler.post(new PressToSpeakPanel.14(this, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderError() is called,path is:" + paramString1 + ",errorCode is:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString1, false, true, paramRecorderParam);
    this.uiHandler.post(new PressToSpeakPanel.9(this));
    anot.a(this.app, "CliOper", "", "", "0X8005A17", "0X8005A17", 12, 0, "", "", "", "3.4.4");
    paramString1 = (aibl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(16);
    if (paramString1 != null) {
      paramString1.drR();
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, (int)paramDouble, paramRecorderParam);
    this.uiHandler.post(new PressToSpeakPanel.7(this, paramInt2, paramDouble));
    this.recordTime = paramDouble;
  }
  
  public void afr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.prepareRecord() is called,time is:" + System.currentTimeMillis());
    }
    wja.bcO = true;
    this.dk.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.setVisibility(8);
    this.di.setVisibility(0);
    this.dj.setVisibility(8);
    this.sw.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.dc.setVisibility(4);
  }
  
  public void as(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zY(paramInt);
    if (paramInt == 1) {
      anot.a(this.app, "CliOper", "", "", "0X800484C", "0X800484C", 0, 0, "", "", "", "");
    }
  }
  
  public void at(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, true, paramRecorderParam);
    this.uiHandler.post(new PressToSpeakPanel.8(this));
    anot.a(this.app, "CliOper", "", "", "0X8005A17", "0X8005A17", 14, 0, "", "", "", "3.4.4");
    paramString = (aibl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(16);
    if (paramString != null) {
      paramString.drR();
    }
  }
  
  public int bz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    if (this.bfj)
    {
      caB();
      this.bfj = false;
    }
    this.uiHandler.post(new PressToSpeakPanel.5(this));
    aomq.VW(1);
    this.recordTime = 0.0D;
    aibl localaibl = (aibl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(16);
    if (localaibl != null) {
      localaibl.aqG();
    }
    return 250;
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, true, paramRecorderParam);
    this.uiHandler.post(new PressToSpeakPanel.6(this));
    anot.a(this.app, "CliOper", "", "", "0X8005A17", "0X8005A17", 13, 0, "", "", "", "3.4.4");
  }
  
  void cav()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(0L);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localScaleAnimation = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(200L);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new wpy(this));
    this.sw.startAnimation(localAnimationSet);
  }
  
  public void caz()
  {
    if ((this.e != null) && (this.e.isShowing()))
    {
      this.e.dismiss();
      this.e = null;
    }
  }
  
  public void hB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitSuccess() is called");
    }
  }
  
  public void jd(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Alic.iI(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.CB(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.CB(paramInt);
  }
  
  public boolean onBackEvent()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) && (this.e != null) && (this.e.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.vm() != 36)) {
      this.e.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.setFateOfRecorder(1);
    }
    if ((AppSetting.enableTalkBack) && (this.bfi)) {
      this.pref.edit().putInt("key_ppt_hint", this.bQr).commit();
    }
  }
  
  public void onPause()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onTouch() is called,action is:" + i);
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.caf();
    if (paramView.getId() == 2131373562)
    {
      if (i == 0)
      {
        caC();
        anot.a(null, "dc00898", "", "", "0X800A1D3", "0X800A1D3", 1, 0, "", "", "", "");
        this.sw.setPressed(true);
        caA();
        cay();
        paramView = new PressToSpeakPanel.15(this, paramMotionEvent);
        paramView = Message.obtain(this.uiHandler, paramView);
        paramView.what = 1;
        this.uiHandler.sendMessageDelayed(paramView, 150L);
      }
      do
      {
        do
        {
          do
          {
            return true;
            if (i != 2) {
              break;
            }
          } while ((!this.bfe) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording()));
          R(paramMotionEvent);
          return true;
        } while ((i != 3) && (i != 1));
        this.sw.setPressed(false);
        if (!this.bfe) {
          break;
        }
        this.bfe = false;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording());
      R(paramMotionEvent);
      return true;
      this.uiHandler.removeMessages(1);
      return true;
    }
    return false;
  }
  
  public ImageView q()
  {
    return this.sw;
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) {}
    for (;;)
    {
      return;
      this.dk.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.setVisibility(0);
      this.di.setVisibility(8);
      this.dj.setVisibility(8);
      this.sw.setVisibility(0);
      this.Io.setText(AudioPanel.a(0.0D));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aSM) {
        this.dc.setVisibility(0);
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
      if (((RF()) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getFateOfRecorder() == 2)) || ((this.e == null) || (this.e.isShowing()))) {}
      try
      {
        this.e.dismiss();
        this.e = null;
        if (this.ws != null)
        {
          if (this.ws.getParent() != null) {
            ((ViewGroup)this.ws.getParent()).removeView(this.ws);
          }
          this.ws = null;
        }
        Object localObject = (PanelIconLinearLayout)this.dg;
        if (localObject != null)
        {
          ((PanelIconLinearLayout)localObject).setAllAlpha(1.0F);
          ((PanelIconLinearLayout)localObject).setAllEnable(true);
        }
        int j = this.df.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject = this.df.getChildAt(i);
          if (((View)localObject).getVisibility() != 8) {
            break label297;
          }
          i += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
            continue;
            label297:
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
            localAlphaAnimation.setDuration(0L);
            localAlphaAnimation.setInterpolator(new LinearInterpolator());
            localException.startAnimation(localAlphaAnimation);
          }
        }
      }
    }
  }
  
  public void setUseOnce(boolean paramBoolean)
  {
    this.beP = paramBoolean;
  }
  
  public void startRecord()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, " PressToSpeakPanel.startRecord() is called, time is " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.reset();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.reset();
    this.dk.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.setVisibility(8);
    this.di.setVisibility(8);
    this.dj.setVisibility(0);
    this.sw.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
    this.dc.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(150L);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.86F, 1.0F, 0.86F, 1.0F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setAnimationListener(new wpz(this));
    this.dk.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel
 * JD-Core Version:    0.7.0.1
 */