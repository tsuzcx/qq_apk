package com.tencent.mobileqq.activity.registerGuideLogin;

import aamt;
import aamu;
import aamv;
import aamw;
import aamx;
import aamy;
import aamz;
import aana;
import aanb;
import aanc;
import aand;
import aane;
import aanf;
import aang;
import aanj;
import aank;
import aanm;
import aann;
import aano;
import aanp;
import aanq;
import aanr;
import aans;
import acfp;
import aciu;
import acxu;
import aiza;
import akwp;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqft;
import aqfy;
import aqha;
import aqht;
import aqiw;
import aqju;
import aqmj;
import aqnm;
import aqqv;
import arhz;
import arod;
import ausj;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.widget.ConfigClearableEditText.c;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.a;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.a;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jll.a;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import vgy;
import wja;

public class LoginView
  extends GuideBaseFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, View.OnTouchListener, ConfigClearableEditText.c, InputMethodRelativeLayout.a, NewStyleDropdownView.a
{
  private RelativeLayout.LayoutParams A;
  private RelativeLayout.LayoutParams B;
  private RelativeLayout.LayoutParams C;
  private boolean MW;
  public AutoCompleteTextView a;
  public LoginAnimBtnView a;
  public CustomSafeEditText a;
  public InputMethodRelativeLayout a;
  public NewStyleDropdownView a;
  PadQQCheckBox a;
  private String aKD;
  private boolean aRa = true;
  private boolean aRb;
  private boolean aYc;
  private boolean aYd;
  private boolean aYe;
  private boolean aZX = true;
  private boolean ach;
  private ValueAnimator al;
  public BroadcastReceiver at = new aank(this);
  private boolean azN;
  private View.OnFocusChangeListener b = new aanf(this);
  private boolean bwp = true;
  private boolean bwq = true;
  private boolean bwr;
  private boolean bws;
  private boolean bwt;
  private boolean bwu;
  private boolean bwv;
  private boolean bww;
  private boolean bwx;
  private boolean bwy = true;
  private boolean bwz;
  private InputMethodManager jdField_c_of_type_AndroidViewInputmethodInputMethodManager;
  public SimpleAccount c;
  private AccountObserver jdField_c_of_type_MqqObserverAccountObserver = new aang(this);
  private Button cP;
  private Button cQ;
  private View.OnClickListener cY = new aanb(this);
  private int chR;
  private int chS;
  private int chT;
  private int chU;
  private int chV;
  private int chW;
  private int chX;
  private int chY;
  private int chZ;
  private int cia;
  private float density = 1.0F;
  private Button eZ;
  View fP;
  private Runnable fc = new LoginView.16(this);
  private Runnable fd = new LoginView.17(this);
  private View hY;
  private boolean isDestroyed;
  public TextWatcher j = new aand(this);
  private ausj mActionSheet;
  private aqju mDialog;
  public int mPosition = -1;
  public ImageView pj;
  public ImageView qX;
  public List<SimpleAccount> qh;
  public TextWatcher r = new aane(this);
  View rm;
  public View rn;
  View ro;
  public TextWatcher u = new aanc(this);
  ImageView wn;
  View zE;
  View zF;
  View zG;
  View zH;
  
  public LoginView() {}
  
  @SuppressLint({"ValidFragment"})
  public LoginView(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void Cu(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "checkMultiWindowDisplay isInMultiWindowMode:" + paramBoolean);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (paramBoolean)
    {
      this.wn.setVisibility(8);
      localLayoutParams.addRule(10);
      localLayoutParams.topMargin = ((int)(25.0F * this.density));
      this.ro.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.zG.getLayoutParams();
      localLayoutParams.bottomMargin = wja.dp2px(15.0F, getResources());
      this.zG.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams();
      localLayoutParams.topMargin = wja.dp2px(24.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setLayoutParams(localLayoutParams);
      return;
    }
    this.wn.setVisibility(0);
    this.wn.setAlpha(1.0F);
    localLayoutParams.addRule(3, 2131370886);
    localLayoutParams.topMargin = ((int)(32.0F * this.density));
    this.ro.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.zG.getLayoutParams();
    localLayoutParams.bottomMargin = wja.dp2px(35.0F, getResources());
    this.zG.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams();
    localLayoutParams.topMargin = wja.dp2px(57.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setLayoutParams(localLayoutParams);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    if (this.A.topMargin != paramInt4)
    {
      this.A.topMargin = paramInt4;
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.requestLayout();
    }
    if (this.B.topMargin != paramInt3)
    {
      this.B.topMargin = paramInt3;
      this.ro.requestLayout();
    }
    if (this.C.topMargin != paramInt2)
    {
      this.C.topMargin = paramInt2;
      this.wn.requestLayout();
    }
    try
    {
      this.zF.scrollTo(0, paramInt1);
      label89:
      if (this.bwz) {
        if (this.bwy) {
          if (paramFloat < 0.99F)
          {
            this.wn.setVisibility(0);
            if (this.wn.getAlpha() > 1.0F - paramFloat) {
              this.wn.setAlpha(1.0F - paramFloat);
            }
          }
        }
      }
      while (this.m.isInMultiWindow())
      {
        do
        {
          return;
          this.wn.setVisibility(4);
          this.wn.setAlpha(0.0F);
          return;
          if (paramFloat >= 0.99F) {
            break;
          }
          this.wn.setVisibility(0);
        } while (this.wn.getAlpha() >= paramFloat);
        this.wn.setAlpha(paramFloat);
        return;
        this.wn.setVisibility(0);
        this.wn.setAlpha(1.0F);
        return;
      }
      this.wn.setVisibility(0);
      this.wn.setAlpha(1.0F);
      return;
    }
    catch (Exception localException)
    {
      break label89;
    }
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this.j);
        this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
          cvv();
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.j);
          return;
        }
        AppRuntime localAppRuntime = this.m.getAppRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
          this.mAppInterface = ((QQAppInterface)localAppRuntime);
        }
        if (this.mAppInterface != null)
        {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.mAppInterface.jm(paramSimpleAccount.getUin()));
          if (!TextUtils.isEmpty(paramSimpleAccount.getUin())) {
            Ay(paramSimpleAccount.getUin());
          }
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("!@#ewaGbhkc$!!=");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
        }
      }
      finally {}
    }
  }
  
  private void a(String paramString1, CharSequence paramCharSequence, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    aff();
    this.mDialog = aqha.a(this.m, 230).setTitle(paramString1).setMessage(paramCharSequence);
    this.mDialog.setPositiveButton(paramString2, (DialogInterface.OnClickListener)localObject);
    this.mDialog.setCancelable(false);
    this.mDialog.show();
  }
  
  private void aff()
  {
    if ((this.mDialog != null) && (this.mDialog.isShowing()))
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
  }
  
  private void br(String paramString, boolean paramBoolean)
  {
    try
    {
      if ((this.m != null) && (this.m.getAppRuntime() != null))
      {
        localObject = this.m.getAppRuntime();
        ((AppRuntime)localObject).stopPCActivePolling("deleteAccount");
        ((AccountManager)((AppRuntime)localObject).getManager(0)).deleteAccount(paramString, paramString, null);
        aqht.UE(paramString);
        if ((paramBoolean) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox.isChecked())))
        {
          if ((localObject instanceof QQAppInterface)) {
            acxu.f((QQAppInterface)localObject, paramString, true);
          }
          new aiza().Mf(paramString);
          uO(paramString);
        }
      }
      arod.a().WF(paramString);
      Object localObject = BaseApplicationImpl.getApplication();
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i = 4;; i = 0)
      {
        localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("Last_Login", i);
        if ((localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(paramString)))
        {
          ((SharedPreferences)localObject).edit().remove("uin").commit();
          if (QLog.isColorLevel()) {
            QLog.d("login", 2, "delete Last_Login, isRelease:" + paramBoolean);
          }
        }
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void cG(View paramView)
  {
    this.hY = paramView.findViewById(2131377084);
    paramView.findViewById(2131377074).setVisibility(8);
    this.fP = paramView.findViewById(2131363411);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView = ((NewStyleDropdownView)paramView.findViewById(2131371107));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.setHeadBorder(2130841392);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a = this;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(this.m.getString(2131720762));
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject1 != null) {
      ((Bundle)localObject1).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText = ((CustomSafeEditText)paramView.findViewById(2131372885));
    localObject1 = (ImageView)paramView.findViewById(2131372886);
    int i = (int)(43.0F * this.density + 0.5F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setCustomClearButtonCallback(new aamt(this, (ImageView)localObject1, i));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setContentDescription(this.m.getString(2131720781));
    localObject1 = new SpannableString(acfp.m(2131707950));
    ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(17, true), 0, ((SpannableString)localObject1).length(), 33);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHint((CharSequence)localObject1);
    if (Build.VERSION.SDK_INT >= 26) {}
    Object localObject2;
    try
    {
      View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, new Object[] { Integer.valueOf(8) });
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView = ((LoginAnimBtnView)paramView.findViewById(2131370875));
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.m.getString(2131720776));
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.init();
      cvz();
      this.cP = ((Button)paramView.findViewById(2131377048));
      this.cP.setContentDescription(this.m.getString(2131720785));
      this.cP.setOnClickListener(this);
      this.eZ = ((Button)paramView.findViewById(2131372576));
      this.eZ.setContentDescription(this.m.getString(2131720365));
      this.eZ.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131370898));
      this.zG = paramView.findViewById(2131370175);
      this.ro = paramView.findViewById(2131377754);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnTouchListener(this);
      this.zF = paramView.findViewById(2131377765);
      this.zF.setOnTouchListener(new aamu(this));
      this.wn = ((ImageView)paramView.findViewById(2131370886));
      if (this.bwr) {
        this.wn.setVisibility(4);
      }
      this.rm = paramView.findViewById(2131370214);
      this.cQ = ((Button)paramView.findViewById(2131367099));
      this.cQ.setContentDescription(this.m.getString(2131695525));
      paramView.findViewById(2131364121).setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.m.getSystemService("input_method"));
      this.pj = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.B();
      this.pj.setOnClickListener(this.cY);
      if (this.qh == null)
      {
        this.qh = new ArrayList();
        localObject1 = BaseApplicationImpl.sApplication.getAllAccounts();
        if (localObject1 != null) {
          this.qh.addAll((Collection)localObject1);
        }
        if ((this.qh == null) || (this.qh.size() <= 0)) {
          break label1798;
        }
        while (this.qh.size() > 8) {
          this.qh.remove(this.qh.size() - 1);
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.w("LoginActivity.LoginView", 2, "disable auto fill error", localException1);
        continue;
        try
        {
          this.qh.clear();
        }
        catch (Exception localException2)
        {
          QLog.d("LoginActivity.LoginView", 1, "initViews crash: ", localException2);
          this.qh = new ArrayList();
        }
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setAdapter(new a(this.m));
      if (((!this.aYc) || (this.azN)) && (!this.aYe) && (!this.bws))
      {
        localObject2 = this.m.getIntent().getStringExtra("uin");
        String str = this.m.getIntent().getStringExtra("befault_uin");
        if ((!this.azN) || (localObject2 == null) || (((String)localObject2).length() <= 0)) {
          break label1773;
        }
        i = 0;
        int k = -1;
        if (i < this.qh.size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)this.qh.get(i);
          int n = k;
          if (localSimpleAccount != null)
          {
            if (localSimpleAccount.getUin() != null) {
              break label926;
            }
            n = k;
          }
          for (;;)
          {
            i += 1;
            k = n;
            break;
            label926:
            int m = k;
            if (str != null)
            {
              m = k;
              if (str.equals(localSimpleAccount.getUin())) {
                m = i;
              }
            }
            n = m;
            if (((String)localObject2).equals(localSimpleAccount.getUin()))
            {
              a(localSimpleAccount);
              this.mPosition = i;
              n = m;
            }
          }
        }
        if (k != -1) {
          this.qh.remove(k);
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.u);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.j);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(this.b);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setOnFocusChangeListener(this.b);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setLongClickable(false);
    this.qX = ((ImageView)paramView.findViewById(2131372890));
    this.qX.setOnClickListener(this);
    if (this.aZX)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localObject2 = this.qX;
      if ((this.aYc) || (this.azN) || (this.aYe))
      {
        i = 2130847848;
        label1126:
        ((ImageView)localObject2).setImageResource(i);
        this.qX.setContentDescription(acfp.m(2131707947));
        this.qX.setVisibility(8);
        this.cQ.setOnClickListener(this);
        if ((this.m.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
          this.m.mSystemBarComp.init();
        }
        this.rn = paramView.findViewById(2131370877);
        this.zE = paramView.findViewById(2131369286);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextClearedListener(this);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.r);
        ge(paramView);
        if (this.m.getIntent().getBooleanExtra("reason_for_upgrade", false)) {
          this.m.showDialog(2);
        }
        if ((this.m.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) && (this.m.getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)))
        {
          paramView = this.m.getIntent().getStringExtra("key_uin_to_login");
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(paramView);
          if (!TextUtils.isEmpty(paramView)) {
            Ay(paramView);
          }
        }
        this.fP.setVisibility(0);
        this.hY.setVisibility(8);
        this.zG.setVisibility(0);
        this.rm.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.bE(false, null);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextColor(-16578534);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHintTextColor(-5196865);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextColor(-16578534);
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHintTextColor(-5196865);
        this.cP.setVisibility(0);
        this.rm.findViewById(2131366003).setVisibility(0);
        this.cP.setVisibility(0);
        this.cQ.setVisibility(0);
        Cu(this.m.isInMultiWindow());
        if ((!this.aYc) && (!this.azN) && (!this.aYe)) {
          break label1984;
        }
        this.rn.setVisibility(0);
        this.fP.setVisibility(8);
        this.hY.setVisibility(0);
        this.hY.setOnClickListener(this);
        if (!this.aYe) {
          break label1956;
        }
        paramView = this.m.getIntent().getStringExtra("uin");
        if (!TextUtils.isEmpty(paramView))
        {
          i = paramView.length();
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(paramView.substring(0, 2) + "****" + paramView.substring(i - 2, i));
          Ay(paramView);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(false);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.C().setVisibility(8);
        }
        if (!this.bwu) {
          break label1890;
        }
        this.rm.findViewById(2131366003).setVisibility(8);
        this.cP.setVisibility(8);
        paramView = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addRule(13);
        this.cQ.setLayoutParams(paramView);
        this.eZ.setVisibility(8);
      }
    }
    for (;;)
    {
      this.A = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams());
      this.B = ((RelativeLayout.LayoutParams)this.ro.getLayoutParams());
      this.C = ((RelativeLayout.LayoutParams)this.wn.getLayoutParams());
      cvv();
      return;
      label1773:
      a((SimpleAccount)this.qh.get(0));
      this.mPosition = 0;
      break;
      label1798:
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.C().setVisibility(8);
      break;
      i = 2130845569;
      break label1126;
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      localObject2 = this.qX;
      if ((this.aYc) || (this.azN) || (this.aYe)) {}
      for (i = 2130847849;; i = 2130845572)
      {
        ((ImageView)localObject2).setImageResource(i);
        this.qX.setContentDescription(acfp.m(2131707956));
        break;
      }
      label1890:
      paramView = (RelativeLayout.LayoutParams)this.cQ.getLayoutParams();
      paramView.leftMargin = wja.dp2px(25.0F, getResources());
      this.cQ.setLayoutParams(paramView);
      this.rm.findViewById(2131366003).setVisibility(0);
      this.cP.setVisibility(8);
      this.eZ.setVisibility(0);
      continue;
      label1956:
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.bE(false, null);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(true);
      continue;
      label1984:
      if ((this.bwt) || (this.m.isInMultiWindow())) {
        this.rn.setVisibility(0);
      }
    }
  }
  
  private void cvA()
  {
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextColor(-16578534);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHintTextColor(-5196865);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextColor(-16578534);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHintTextColor(-5196865);
  }
  
  private void cvB()
  {
    String str1 = this.m.getIntent().getStringExtra("release_account_uin");
    Object localObject3 = this.m.getIntent().getStringExtra("release_bold_text");
    String str2 = this.m.getIntent().getStringExtra("release_success_text");
    Object localObject2;
    Object localObject1;
    if ((!TextUtils.isEmpty(str1)) && (!this.qh.isEmpty()))
    {
      localObject2 = this.qh.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (SimpleAccount)((Iterator)localObject2).next();
      } while (!str1.equals(((SimpleAccount)localObject1).getUin()));
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (this.mAppInterface != null)
        {
          localObject2 = this.mAppInterface.jm(str1);
          String str3 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
          a locala = (a)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
          if ((!TextUtils.isEmpty(str3)) && (str3.equals(localObject2)))
          {
            this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
            this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.bE(false, null);
            this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
          }
          cvv();
          this.qh.remove(localObject1);
          locala.notifyDataSetChanged();
          cvA();
          ThreadManager.postImmediately(new LoginView.28(this, str1), null, false);
        }
      }
      else
      {
        if (!TextUtils.isEmpty(str2)) {
          break label371;
        }
        localObject1 = getString(2131700561);
      }
      for (localObject2 = getString(2131700562);; localObject2 = localObject3)
      {
        localObject3 = new SpannableString((CharSequence)localObject1);
        if (((String)localObject1).contains((CharSequence)localObject2))
        {
          localObject3 = new SpannableString((CharSequence)localObject1);
          int i = ((String)localObject1).indexOf((String)localObject2);
          int k = ((String)localObject2).length();
          ((SpannableString)localObject3).setSpan(new StyleSpan(1), i, k + i, 33);
        }
        for (localObject1 = localObject3;; localObject1 = localObject3)
        {
          a(getString(2131700563), (CharSequence)localObject1, getString(2131700560), new aanj(this));
          return;
          localObject2 = str1;
          break;
        }
        label371:
        localObject1 = str2;
      }
      localObject1 = null;
    }
  }
  
  private void cvv()
  {
    if (this.m.getIntent().getBooleanExtra("from_register_choose", false)) {}
    for (int i = 6;; i = 1)
    {
      String str1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      String str2 = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str2.length() >= i))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setEnabled(true);
        if ((TextUtils.isEmpty(str2)) || (str2.length() < 12)) {
          break label153;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextSize(1, 17.0F);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str1)) {
          break label167;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setPadding((int)(this.density * 63.0F + 0.5F), 0, (int)(this.density * 63.0F + 0.5F), 0);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setEnabled(false);
        break;
        label153:
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextSize(1, 22.0F);
      }
      label167:
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setPadding((int)(this.density * 36.0F + 0.5F), 0, (int)(this.density * 36.0F + 0.5F), 0);
      return;
    }
  }
  
  private void cvy()
  {
    if (this.al != null) {
      return;
    }
    this.al = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.al.setDuration(200L);
    this.al.addUpdateListener(new aamv(this));
    this.al.addListener(new aamw(this));
  }
  
  private void cvz()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView == null) {
      return;
    }
    AppRuntime localAppRuntime = this.m.getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).abA()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.m.getString(2131719390));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.m.getString(2131721076));
  }
  
  private void ge(View paramView)
  {
    View localView = paramView.findViewById(2131377361);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = paramView.findViewById(2131377084);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    paramView = paramView.findViewById(2131369579);
    if (paramView != null) {
      IphoneTitleBarActivity.setLayerType(paramView);
    }
  }
  
  private void login()
  {
    String str;
    if (this.aYe)
    {
      str = this.m.getIntent().getStringExtra("uin");
      if (!this.m.getIntent().getBooleanExtra("hasPwd", true))
      {
        a(null, this.m.getString(2131717069), this.m.getString(2131720564), this);
        return;
      }
    }
    while ((str == null) || (str.length() == 0) || (str.trim().length() == 0))
    {
      QQToast.a(this.m, 2131696496, 0).show();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
      str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    }
    if (str.startsWith("0"))
    {
      QQToast.a(this.m, 2131695113, 0).show();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
    if ((localObject == null) || (((String)localObject).length() < 1))
    {
      QQToast.a(this.m, 2131696733, 0).show();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.requestFocus();
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, 2);
      return;
    }
    int k = this.qh.size();
    int i = 0;
    if (i < k)
    {
      localObject = (SimpleAccount)this.qh.get(i);
      if ((localObject == null) || (!str.equals(((SimpleAccount)localObject).getUin()))) {}
    }
    for (i = 0;; i = 1)
    {
      if (i != 0) {}
      for (i = k + 1;; i = k)
      {
        if (i <= 8) {
          break label340;
        }
        QQToast.a(this.m, 2131695539, 0).show();
        return;
        i += 1;
        break;
      }
      label340:
      if ((this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        i = 0;
        if (i < this.qh.size())
        {
          if ((this.qh.get(i) == null) || (((SimpleAccount)this.qh.get(i)).getUin() == null)) {}
          while (!((SimpleAccount)this.qh.get(i)).getUin().equals(localObject))
          {
            i += 1;
            break;
          }
          this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.qh.get(i));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("userguide", 2, "login");
      }
      AuthDevUgActivity.zK(1);
      if (this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
      {
        BaseApplicationImpl.isFirstLogin = false;
        this.m.showDialog(0);
        if (this.mAppInterface != null) {
          this.mAppInterface.login(this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
        }
      }
      for (;;)
      {
        aqfy.edD();
        return;
        BaseApplicationImpl.isFirstLogin = true;
        try
        {
          this.m.showDialog(0);
          localObject = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
          AppRuntime localAppRuntime = this.m.getAppRuntime();
          if (localAppRuntime != null) {
            localAppRuntime.login(str, (byte[])localObject, null);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          QLog.e("LoginActivity.LoginView", 1, "login() appRuntime is null");
        }
      }
    }
  }
  
  private boolean v(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        String str = paramIntent.getString("uin");
        if ((str != null) && (str.length() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(str);
          Ay(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramIntent);
            cvv();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public void Ay(String paramString)
  {
    ThreadManager.postImmediately(new LoginView.21(this, paramString), null, true);
  }
  
  public void Cv(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.bwq) && ((!this.aYc) || (!this.aYd)) && (!this.aYe) && (!this.bwt) && (!this.m.isInMultiWindow()) && (this.bwq))
    {
      this.bwq = false;
      if (this.bwv) {
        this.rn.setVisibility(0);
      }
    }
    while ((!paramBoolean) || (!this.bwr) || (this.m.isInMultiWindow()))
    {
      return;
      this.m.runOnUiThread(new LoginView.4(this));
    }
    this.m.getIntent().removeExtra("is_need_show_logo_animation");
    this.bwr = false;
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(1.429F, 1.0F, 1.429F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(500L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillAfter(true);
    float f = aqnm.getDensity();
    localObject = new TranslateAnimation(aqnm.getScreenWidth() / 2.0F - 65.5F * f, 0.0F, f * -8.0F, 0.0F);
    ((Animation)localObject).setDuration(500L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillBefore(true);
    this.wn.startAnimation(localAnimationSet);
    this.wn.setVisibility(0);
  }
  
  public void Cw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        Ay(str);
      }
    }
    this.bwp = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "arrowChangeCallback isArrowUP = " + this.bwp + " isScrolled = " + this.MW);
    }
  }
  
  protected void Qq()
  {
    if (this.mActionSheet == null)
    {
      this.mActionSheet = ((ausj)auss.a(this.m, null));
      this.mActionSheet.addButton(2131693744);
      if (this.eZ.getVisibility() != 0) {
        this.mActionSheet.addButton(2131720365);
      }
      this.mActionSheet.addCancelButton(2131693743);
      this.mActionSheet.setOnDismissListener(new aamx(this));
      this.mActionSheet.a(new aamy(this));
      this.mActionSheet.setOnBottomCancelListener(new aana(this));
    }
    if (!this.mActionSheet.isShowing())
    {
      this.ach = false;
      this.mActionSheet.show();
    }
  }
  
  Object a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (this.mAppInterface == null)
    {
      localObject = this.m.getAppRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        this.mAppInterface = ((QQAppInterface)localObject);
      }
    }
    if (this.mAppInterface != null)
    {
      Bitmap localBitmap = this.mAppInterface.a(paramString, (byte)4, false);
      QLog.d("Q.qqhead.freq", 1, "LoginView getHead bitmap: " + localBitmap);
      localObject = localBitmap;
      if (paramBoolean)
      {
        localObject = localBitmap;
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (aqqv.a().aF())
          {
            int i = this.m.getSharedPreferences(paramString, 0).getInt("my_store_face_id", 0);
            localObject = localBitmap;
            if (i > 0)
            {
              paramString = VasFaceManager.O(i, "small");
              localObject = localBitmap;
              if (new File(paramString).exists()) {
                localObject = new BitmapDrawable(localBitmap);
              }
            }
          }
        }
      }
      try
      {
        URL localURL = new URL("vasapngdownloader", paramString, "-login-face-");
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mUseMemoryCache = true;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mExtraInfo = VasFaceManager.t();
        localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("LoginActivity.LoginView", 1, "getApngDrawable ApngImage err, path:" + paramString, localException);
        return localBitmap;
      }
    }
    return null;
  }
  
  public void bFw()
  {
    
    if (this.mAppInterface != null) {
      this.mAppInterface.stopPCActivePolling("clearPassInput");
    }
    if ((this.qh != null) && (this.qh.size() > 0))
    {
      if ((this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText() == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() == null)) {
        return;
      }
      int i = 0;
      if (i < this.qh.size())
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        SimpleAccount localSimpleAccount = (SimpleAccount)this.qh.get(i);
        if (localSimpleAccount == null) {}
        while ((this.mAppInterface == null) || (!((String)localObject).equals(this.mAppInterface.jm(localSimpleAccount.getUin()))))
        {
          i += 1;
          break;
        }
        this.mAppInterface.updateSubAccountLogin(localSimpleAccount.getUin(), false);
        arod.a().WF((String)localObject);
        this.bdr = null;
        BaseApplicationImpl.sApplication.refreAccountList();
        localObject = BaseApplicationImpl.sApplication.getAllAccounts();
        if ((localObject != null) && (this.qh != null))
        {
          this.qh.clear();
          this.qh.addAll((Collection)localObject);
        }
      }
    }
    cvA();
  }
  
  public void cvw()
  {
    this.rm.setVisibility(8);
    this.zE.setVisibility(8);
    this.zG.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.bE(false, null);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.showDropDown();
    }
  }
  
  public void cvx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "hideDropdown isArrowUP = " + this.bwp + " isScrolled = " + this.MW);
    }
    if (this.MW == true)
    {
      this.zF.scrollTo(0, 0);
      this.MW = false;
    }
    this.bwp = true;
    this.zE.setVisibility(0);
    this.rm.setVisibility(0);
    this.zG.setVisibility(0);
    String str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    if (!TextUtils.isEmpty(str)) {
      Ay(str);
    }
  }
  
  public void l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onSizeChange isOpen:" + paramBoolean + " preH:" + paramInt1 + " curH:" + paramInt2 + "  isInMultiWindow:" + this.m.isInMultiWindow());
    }
    ThreadManager.getUIHandler().removeCallbacks(this.fd);
    ThreadManager.getUIHandler().removeCallbacks(this.fc);
    this.chS = paramInt2;
    if ((paramBoolean) && (getActivity() != null)) {
      if (!this.bwx)
      {
        this.bww = true;
        ThreadManager.getUIHandler().post(this.fc);
      }
    }
    do
    {
      return;
      this.bwx = false;
      this.bww = false;
      ThreadManager.getUIHandler().postDelayed(this.fd, 200L);
    } while (!this.m.isInMultiWindow());
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.rm.getLocationOnScreen(arrayOfInt1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLocationOnScreen(arrayOfInt2);
    if (arrayOfInt1[1] < arrayOfInt2[1] + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getHeight() + (int)(2.0F * this.density + 0.5F))
    {
      this.rm.setVisibility(4);
      this.zG.setVisibility(4);
      return;
    }
    this.rm.setVisibility(0);
    arrayOfInt2 = new int[2];
    this.zG.getLocationOnScreen(arrayOfInt2);
    if (arrayOfInt2[1] < arrayOfInt1[1] + this.rm.getHeight() + (int)(2.0F * this.density + 0.5F))
    {
      this.zG.setVisibility(4);
      return;
    }
    this.zG.setVisibility(0);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a locala;
    String str1;
    String str3;
    if (this.mPosition != -1)
    {
      paramDialogInterface = new arhz(this.m, this.m.getTitleBarHeight());
      paramDialogInterface.setBackAndSearchFilter(true);
      paramDialogInterface.setContentView(2131562991);
      paramDialogInterface.setMessage(2131692539);
      paramDialogInterface.show();
      locala = (a)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      str1 = locala.cV(this.mPosition);
      String str2 = locala.getItem(this.mPosition);
      this.qh.remove(this.mPosition);
      this.mPosition = -1;
      str3 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if ((!this.qh.isEmpty()) && (!str2.equals(str3))) {
        break label221;
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.bE(false, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    }
    for (;;)
    {
      cvv();
      locala.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.bdr)) && (this.bdr.equalsIgnoreCase(str1))) {
        this.bdr = null;
      }
      cvA();
      ThreadManager.post(new LoginView.13(this, str1, paramDialogInterface), 8, null, false);
      return;
      label221:
      if (!TextUtils.isEmpty(str3)) {
        Ay(str3);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onClick id=" + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.c(this.mAppInterface, "dc00898", "", "", "0X800AA28", "0X800AA28", 0, 0, "", "", "", "");
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      login();
      anot.c(this.mAppInterface, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
      anot.a(this.mAppInterface, "new_reg_805", "log_page", "log_clk", "", 1, "");
      continue;
      anot.c(this.mAppInterface, "dc00898", "", "", "0X800AA2A", "0X800AA2A", 0, 0, "", "", "", "");
      if (aqft.aCd())
      {
        QQToast.a(this.m, 2131695539, 0).show();
      }
      else if (this.aRa)
      {
        anot.c(this.mAppInterface, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
        if ((this.aYc) && (this.aYd))
        {
          anot.a(this.mAppInterface, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
          if (!aqiw.isNetSupport(BaseApplicationImpl.sApplication))
          {
            QQToast.a(this.m, 2131693404, 0).show();
            continue;
          }
        }
        Object localObject;
        for (;;)
        {
          try
          {
            ((AccountManager)this.mAppInterface.getManager(0)).checkQuickRegisterAccount(this.mAppInterface.getAccount(), this.mAppInterface.getAppid(), "3.4.4", null);
            this.m.showDialog(4);
            this.aRa = false;
            new Handler().postDelayed(new LoginView.12(this), 1000L);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            continue;
          }
          anot.a(this.mAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
          localObject = new Intent(this.m, RegisterPhoneNumActivity.class);
          ((Intent)localObject).putExtra("key_register_from", 3);
          ((Intent)localObject).putExtra("key_report_extra_from", 2);
          this.m.startActivity((Intent)localObject);
        }
        if (!this.bww)
        {
          anot.c(this.mAppInterface, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
          anot.a(this.mAppInterface, "new_reg_805", "log_page", "forge_clk", "", 1, "");
          anot.c(this.mAppInterface, "dc00898", "", "", "0X800AA29", "0X800AA29", 0, 0, "", "", "", "");
          if ((this.aYc) && (this.aYd)) {
            anot.a(this.mAppInterface, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
          }
          Qq();
          this.bwx = true;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$a != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$a.bQW();
            continue;
            anot.c(this.mAppInterface, "dc00898", "", "", "0X80072E8", "0X80072E8", 0, 0, "", "", "", "");
            anot.c(this.mAppInterface, "dc00898", "", "", "0X800AA2B", "0X800AA2B", 0, 0, "", "", "", "");
            localObject = new Intent(this.m, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("uin", this.mAppInterface.getCurrentAccountUin());
            ((Intent)localObject).putExtra("ba_is_login", false);
            ((Intent)localObject).putExtra("url", "https://ti.qq.com/tim/serverinfo.html");
            ((Intent)localObject).putExtra("hide_more_button", true);
            this.m.startActivity((Intent)localObject);
            continue;
            localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
            if (!this.aZX)
            {
              bool = true;
              label925:
              this.aZX = bool;
              if (!this.aZX) {
                break label1034;
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
              localImageView = this.qX;
              if ((!this.aYc) && (!this.azN) && (!this.aYe)) {
                break label1027;
              }
            }
            label1027:
            for (i = 2130847848;; i = 2130845569)
            {
              localImageView.setImageResource(i);
              this.qX.setContentDescription(acfp.m(2131707948));
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.length());
              break;
              bool = false;
              break label925;
            }
            label1034:
            this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ImageView localImageView = this.qX;
            if ((this.aYc) || (this.azN) || (this.aYe)) {}
            for (i = 2130847849;; i = 2130845572)
            {
              localImageView.setImageResource(i);
              this.qX.setContentDescription(acfp.m(2131707953));
              break;
            }
            anot.c(this.mAppInterface, "dc00898", "", "", "0X8007354", "0X8007354", 0, 0, "", "", "", "");
            anot.c(this.mAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
            anot.c(this.mAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 2, 0, "", "", "", "");
            anot.a(this.mAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
            anot.a(this.mAppInterface, "new_reg_805", "log_page", "log_msg_clk", "", 1, "");
            boolean bool = this.m.getIntent().getBooleanExtra("login_from_account_change", false);
            localObject = new Intent(this.m, LoginPhoneNumActivity.class);
            ((Intent)localObject).putExtra("login_from_account_change", bool);
            this.m.startActivity((Intent)localObject);
          }
        }
      }
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    String str1;
    switch (paramInt)
    {
    default: 
    case 0: 
    case 4: 
    case 1: 
      do
      {
        return null;
        localObject1 = new arhz(this.m, this.m.getTitleBarHeight());
        ((arhz)localObject1).setMessage(this.m.getString(2131695551));
        return localObject1;
        localObject1 = new arhz(this.m, this.m.getTitleBarHeight());
        ((arhz)localObject1).setMessage(acfp.m(2131707954));
        ((arhz)localObject1).setCancelable(false);
        return localObject1;
      } while (!this.m.isResume());
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
      }
      localObject1 = this.m.getLayoutInflater().inflate(2131559226, null);
      return aqha.a(this.m, 230).setPositiveButton(2131691519, this).setNegativeButton(2131691518, new aanm(this)).addView((View)localObject1);
    case 2: 
      localObject1 = this.m.getIntent();
      localObject2 = ((Intent)localObject1).getStringExtra("StrTitle");
      str1 = ((Intent)localObject1).getStringExtra("StrUpgradeDesc");
      ((Intent)localObject1).getStringExtra("StrUrl");
      localObject1 = aqha.a(this.m, 230).setTitle((String)localObject2).setMessage(str1);
      ((aqju)localObject1).setPositiveButton(acfp.m(2131707944), new aann(this));
      ((aqju)localObject1).setPositiveButtonContentDescription(this.m.getString(2131721587));
      ((aqju)localObject1).setNegativeButton(acfp.m(2131707955), new aano(this));
      return localObject1;
    case 3: 
      Object localObject4 = this.m.getIntent();
      Object localObject3 = ((Intent)localObject4).getStringExtra("StrTitle");
      String str2 = ((Intent)localObject4).getStringExtra("StrUpgradeDesc");
      localObject1 = ((Intent)localObject4).getStringExtra("StrButton");
      localObject2 = ((Intent)localObject4).getStringExtra("StrClientUrl");
      str1 = ((Intent)localObject4).getStringExtra("StrH5Url");
      localObject4 = ((Intent)localObject4).getStringExtra("StrCode");
      localObject3 = aqha.a(this.m, 230).setTitle((String)localObject3).setMessage(str2);
      ((aqju)localObject3).setPositiveButton((String)localObject1, new aanp(this, (String)localObject2, str1, (String)localObject4));
      ((aqju)localObject3).setNegativeButton(acfp.m(2131707949), new aanq(this));
      anot.c(this.mAppInterface, "dc00898", "", "", "0X8006795", "0X8006795", 0, 0, "", "", "", "");
      return localObject3;
    }
    Object localObject2 = this.m;
    if (this.mAppInterface != null) {}
    for (Object localObject1 = this.mAppInterface.getCurrentAccountUin();; localObject1 = "") {
      return aciu.a((Context)localObject2, (String)localObject1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.density = getResources().getDisplayMetrics().density;
    paramLayoutInflater = paramLayoutInflater.inflate(2131559513, paramViewGroup, false);
    boolean bool;
    if (paramBundle != null)
    {
      bool = true;
      this.bwv = bool;
      this.azN = this.m.getIntent().getBooleanExtra("is_change_account", false);
      this.aYc = this.m.getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
      this.aYe = this.m.getIntent().getBooleanExtra("from_register_choose", false);
      this.aYd = this.m.getIntent().getBooleanExtra("login_from_account_change", false);
      this.bwr = false;
      this.bws = this.m.getIntent().getBooleanExtra("is_from_account_release", false);
      this.bwt = this.m.getIntent().getBooleanExtra("is_from_account_another_login_exit", false);
      this.bwu = this.m.getIntent().getBooleanExtra("hasPwd", true);
      cG(paramLayoutInflater);
      if ((this.m.getIntent().getBooleanExtra("logout_intent", false)) && (this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null))
      {
        aqmj.i(BaseApplicationImpl.sApplication, this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), false);
        this.bdr = this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin();
      }
      if (this.mAppInterface == null) {
        break label492;
      }
      this.mAppInterface.registObserver(this.jdField_c_of_type_MqqObserverAccountObserver);
    }
    for (;;)
    {
      if ((getActivity() != null) && (this.at != null))
      {
        paramViewGroup = new IntentFilter();
        paramViewGroup.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        getActivity().registerReceiver(this.at, paramViewGroup);
      }
      this.zH = paramLayoutInflater.findViewById(2131377026);
      this.zH.post(new LoginView.1(this));
      if (this.m.getIntent().getBooleanExtra("reason_for_checkAuth", false)) {
        getActivity().showDialog(3);
      }
      if (this.bws) {
        cvB();
      }
      if (this.jdField_a_of_type_Vgy != null)
      {
        paramViewGroup = new aamz(this);
        this.jdField_a_of_type_Vgy.a(paramViewGroup);
      }
      anot.a(this.mAppInterface, "new_reg_805", "log_page", "page_exp", "", 1, "");
      anot.c(this.mAppInterface, "dc00898", "", "", "0X8009E3D", "0X8009E3D", 0, 0, "", "", "", "");
      anot.c(this.mAppInterface, "dc00898", "", "", "0X800AA27", "0X800AA27", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onCreateView");
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      bool = false;
      break;
      label492:
      paramViewGroup = this.m.getAppRuntime();
      if ((paramViewGroup != null) && ((paramViewGroup instanceof QQAppInterface))) {
        this.mAppInterface = ((QQAppInterface)paramViewGroup);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.mAppInterface != null) {
      this.mAppInterface.unRegistObserver(this.jdField_c_of_type_MqqObserverAccountObserver);
    }
    if ((getActivity() != null) && (this.at != null))
    {
      getActivity().unregisterReceiver(this.at);
      this.at = null;
    }
    ThreadManager.getUIHandler().removeCallbacks(this.fd);
    ThreadManager.getUIHandler().removeCallbacks(this.fc);
    if (this.al != null)
    {
      if (this.al.isRunning()) {
        this.al.cancel();
      }
      this.al.removeAllUpdateListeners();
      this.al.removeAllListeners();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.onDestroy();
    }
    if (!this.m.isFinishing()) {}
    try
    {
      this.m.dismissDialog(5);
      this.isDestroyed = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if ((this.wn == null) || (this.ro == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onMultiWindowModeChanged isInMultiWindowMode:" + paramBoolean);
    }
    Cu(paramBoolean);
    this.bww = false;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    v(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onNewIntent");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseAll();
    this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.m.getWindow().getDecorView().getWindowToken(), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.onPause();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onPause");
    }
  }
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131379420);
      String str = this.m.getString(2131691520);
      a locala = (a)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      if (this.mPosition != -1) {
        localTextView.setText(str.replace("${account}", locala.getItem(this.mPosition)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox = ((PadQQCheckBox)paramDialog.findViewById(2131364573));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox.setText(getText(2131691529));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.bww = false;
    ApngImage.playByTag(11);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.pj.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
    if (NotificationActivity.a != null)
    {
      NotificationActivity.a.finish();
      NotificationActivity.a = null;
    }
    if (this.mAppInterface != null) {
      this.mAppInterface.hG(-1L);
    }
    akwp.a().Nq(false);
    Cv(true);
    if (this.aRb)
    {
      QLog.d("LoginActivity.LoginView", 1, "mShouldAutoLogin: true, then login()");
      this.aRb = false;
      login();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.onResume();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onResume");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle != null) {
      paramBundle.putInt("position", this.mPosition);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.isPopupShowing())
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.dismissDropDown();
      paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if (!TextUtils.isEmpty(paramView)) {
        Ay(paramView);
      }
    }
    return false;
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if (paramBundle != null) {
      this.mPosition = paramBundle.getInt("position", -1);
    }
  }
  
  void uO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = BaseApplicationImpl.sApplication.getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public class a
    extends ArrayAdapter
    implements View.OnClickListener
  {
    Filter a;
    
    public a(Context paramContext)
    {
      super(2131558441, 2131369535, LoginView.this.qh);
    }
    
    public String cV(int paramInt)
    {
      return ((SimpleAccount)LoginView.this.qh.get(paramInt)).getUin();
    }
    
    public int getCount()
    {
      if (LoginView.this.qh.size() == 0) {
        LoginView.this.a.C().setVisibility(8);
      }
      for (;;)
      {
        return super.getCount();
        LoginView.this.a.C().setVisibility(0);
      }
    }
    
    public Filter getFilter()
    {
      if (this.a == null) {
        this.a = new aanr(this);
      }
      return this.a;
    }
    
    public String getItem(int paramInt)
    {
      String str = ((SimpleAccount)LoginView.this.qh.get(paramInt)).getUin();
      if (LoginView.this.mAppInterface == null) {
        return str;
      }
      return LoginView.this.mAppInterface.jm(str);
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = super.getView(paramInt, paramView, paramViewGroup);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131363236);
      ImageView localImageView = (ImageView)localView.findViewById(2131369459);
      Object localObject = LoginView.this.a(((SimpleAccount)LoginView.this.qh.get(paramInt)).getUin(), false);
      if ((localObject instanceof Bitmap))
      {
        localImageView.setImageBitmap((Bitmap)localObject);
        localImageView = (ImageView)localView.findViewById(2131369426);
        localImageView.setTag(Integer.valueOf(paramInt));
        localImageView.setOnClickListener(this);
        localImageView.setContentDescription(LoginView.this.m.getString(2131720764));
        localView.setContentDescription(String.format(LoginView.this.m.getString(2131689606) + "%s", new Object[] { ((SimpleAccount)LoginView.this.qh.get(paramInt)).getUin() }));
        if (getCount() != 1) {
          break label280;
        }
        localLinearLayout.setPadding(0, wja.dp2px(7.5F, LoginView.this.getResources()), 0, wja.dp2px(7.5F, LoginView.this.getResources()));
      }
      for (;;)
      {
        localLinearLayout.setOnClickListener(new aans(this, paramInt));
        localView.setOnTouchListener(new jll.a());
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        localImageView.setImageResource(2130841398);
        break;
        label280:
        if (paramInt == 0) {
          localLinearLayout.setPadding(0, wja.dp2px(7.5F, LoginView.this.getResources()), 0, 0);
        } else if (paramInt == getCount() - 1) {
          localLinearLayout.setPadding(0, 0, 0, wja.dp2px(7.5F, LoginView.this.getResources()));
        } else {
          localLinearLayout.setPadding(0, 0, 0, 0);
        }
      }
    }
    
    public void onClick(View paramView)
    {
      LoginView.this.mPosition = ((Integer)paramView.getTag()).intValue();
      LoginView.this.m.showDialog(1);
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView
 * JD-Core Version:    0.7.0.1
 */