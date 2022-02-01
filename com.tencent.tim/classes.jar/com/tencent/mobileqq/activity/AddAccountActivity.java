package com.tencent.mobileqq.activity;

import acfp;
import aevn;
import akwp;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anol;
import anot;
import anpc;
import aqfy;
import aqiw;
import aqmj;
import arhz;
import arod;
import ausj;
import auss;
import auvy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.ConfigClearableEditText.c;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import udf;
import udg;
import udh;
import udi;
import udj;
import udk;
import udn;
import udo;
import udp;

public class AddAccountActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, ConfigClearableEditText.c
{
  private TextView BC;
  private long Fd;
  public AutoCompleteTextView a;
  public CustomSafeEditText a;
  DropdownView a;
  private String aKD;
  private boolean aRa = true;
  private boolean aRb;
  private boolean ach;
  public BroadcastReceiver at = new udj(this);
  private View.OnFocusChangeListener jdField_b_of_type_AndroidViewView$OnFocusChangeListener = new udf(this);
  MqqHandler jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(this);
  private InputMethodManager jdField_c_of_type_AndroidViewInputmethodInputMethodManager;
  public SimpleAccount c;
  private AccountObserver jdField_c_of_type_MqqObserverAccountObserver = new udk(this);
  Button cO;
  private Button cP;
  private Button cQ;
  private View.OnClickListener cY = new udp(this);
  RelativeLayout et;
  private View hY;
  TextWatcher j = new udn(this);
  private ausj mActionSheet;
  TextWatcher o = new udo(this);
  public ImageView pj;
  public List<SimpleAccount> qh;
  TextWatcher r = new udg(this);
  View rm;
  View rn;
  View ro;
  
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.j);
          return;
        }
        AppRuntime localAppRuntime = getAppRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
          this.app = ((QQAppInterface)localAppRuntime);
        }
        if (this.app != null) {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.jm(paramSimpleAccount.getUin()));
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
  
  private void bFx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "only kandian tab switch, addAccount login delayTime:" + (NetConnInfoCenter.getServerTimeMillis() - this.Fd));
    }
    if (akwp.a().asQ()) {
      return;
    }
    ThreadManager.postImmediately(new AddAccountActivity.6(this), null, false);
    uP(this.app.getAccount());
    if (!isFinishing()) {}
    try
    {
      dismissDialog(0);
      PatternLockUtils.setFirstEnterAfterLoginState(this, this.app.getAccount(), true);
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
  
  private void bcu()
  {
    View localView = findViewById(2131377361);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = findViewById(2131377498);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void et(View paramView)
  {
    if (paramView != null) {
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    if ((paramView == null) || (paramView.length() == 0) || (paramView.trim().length() == 0))
    {
      QQToast.a(this, 2131696496, 0).show();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
    if ((str == null) || (str.length() < 1))
    {
      QQToast.a(this, 2131696733, 0).show();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.requestFocus();
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, 2);
      return;
    }
    if ((this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
    {
      str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      int i = 0;
      if (i < this.qh.size())
      {
        if ((this.qh.get(i) == null) || (((SimpleAccount)this.qh.get(i)).getUin() == null)) {}
        while (!((SimpleAccount)this.qh.get(i)).getUin().equals(str))
        {
          i += 1;
          break;
        }
        this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.qh.get(i));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "login");
    }
    if (this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      BaseApplicationImpl.isFirstLogin = false;
      showDialog(0);
      this.app.login(this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
    }
    for (;;)
    {
      aqfy.edD();
      return;
      BaseApplicationImpl.isFirstLogin = true;
      try
      {
        showDialog(0);
        getAppRuntime().login(paramView, arrayOfByte, null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void f(Button paramButton)
  {
    if (paramButton == null) {
      return;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).abA()))
    {
      paramButton.setText(getString(2131719390));
      return;
    }
    paramButton.setText(getString(2131721076));
  }
  
  private void initViews()
  {
    this.hY = findViewById(2131377498);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131371107));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131720762));
    Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject != null) {
      ((Bundle)localObject).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText = ((CustomSafeEditText)findViewById(2131372885));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setContentDescription(getString(2131720781));
    this.cO = ((Button)findViewById(2131370875));
    this.cO.setContentDescription(getString(2131720776));
    this.cO.setOnClickListener(this);
    f(this.cO);
    this.cP = ((Button)findViewById(2131377048));
    this.cP.setContentDescription(getString(2131720785));
    this.cP.setOnClickListener(this);
    this.et = ((RelativeLayout)findViewById(2131362186));
    this.ro = findViewById(2131377754);
    this.rm = findViewById(2131370214);
    this.cQ = ((Button)findViewById(2131367099));
    this.cQ.setContentDescription(getString(2131693975));
    this.BC = ((TextView)findViewById(2131369579));
    this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.pj = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.B();
    this.pj.setOnClickListener(this.cY);
    if (this.qh == null) {
      this.qh = new ArrayList();
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getAllAccounts();
      if (localObject != null) {
        this.qh.addAll((Collection)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.o);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.j);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(this.jdField_b_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setOnFocusChangeListener(this.jdField_b_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setLongClickable(false);
      this.cQ.setOnClickListener(this);
      if ((this.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        this.mSystemBarComp.init();
      }
      this.rn = findViewById(2131370877);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextClearedListener(this);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.r);
      bcu();
      localObject = (RelativeLayout.LayoutParams)this.hY.getLayoutParams();
      this.hY.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(3, 2131377498);
      this.ro.setLayoutParams(localLayoutParams);
      ((LinearLayout)this.ro).setOrientation(1);
      this.rn.setVisibility(0);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        this.mSystemBarComp.setgetStatusBarVisible(true, 0);
      }
      this.BC.setVisibility(8);
      localObject = (TextView)findViewById(2131369612);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(acfp.m(2131702035));
      ((TextView)localObject).setOnClickListener(this);
      findViewById(2131369627).setVisibility(0);
      localObject = (TextView)findViewById(2131369627);
      ((TextView)localObject).setText(2131721054);
      ((TextView)localObject).setContentDescription(getString(2131721054));
      setTitle(getString(2131721054));
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.C().setVisibility(8);
      return;
      this.qh.clear();
    }
  }
  
  public static void o(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.post(new AddAccountActivity.5(paramQQAppInterface), 8, null, false);
    try
    {
      anpc.a(BaseApplicationImpl.sApplication).QZ(paramString);
      anol.a(BaseApplicationImpl.sApplication).setUin(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "loginSuccess set CURRENT_ACCOUNT: " + paramString);
      }
      aqmj.i(BaseApplicationImpl.sApplication, paramString, true);
      BaseApplicationImpl.sApplication.refreAccountList();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddAccountActivity", 2, "loginSuccess throwable: " + paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private void uP(String paramString)
  {
    arod.a().WE(paramString);
    setResult(-1);
    finish();
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
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0)) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  protected void Qq()
  {
    if (this.mActionSheet == null)
    {
      this.mActionSheet = ((ausj)auss.a(this, null));
      this.mActionSheet.addButton(2131693739);
      this.mActionSheet.addButton(2131720366);
      this.mActionSheet.addCancelButton(2131721058);
      this.mActionSheet.setOnDismissListener(new udh(this));
      this.mActionSheet.a(new udi(this));
    }
    if (!this.mActionSheet.isShowing())
    {
      this.ach = false;
      this.mActionSheet.show();
    }
  }
  
  public void bFw()
  {
    libsafeedit.clearPassBuffer();
    getAppRuntime().stopPCActivePolling("clearPassInput");
    if ((this.qh == null) || (this.qh.size() <= 0) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText() == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() == null)) {}
    label65:
    Object localObject;
    label114:
    do
    {
      return;
      int i = 0;
      SimpleAccount localSimpleAccount;
      if (i < this.qh.size())
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        localSimpleAccount = (SimpleAccount)this.qh.get(i);
        if (localSimpleAccount != null) {
          break label114;
        }
      }
      while (!((String)localObject).equals(this.app.jm(localSimpleAccount.getUin())))
      {
        i += 1;
        break label65;
        break;
      }
      this.app.updateSubAccountLogin(localSimpleAccount.getUin(), false);
      arod.a().WF((String)localObject);
      BaseApplicationImpl.sApplication.refreAccountList();
      localObject = BaseApplicationImpl.sApplication.getAllAccounts();
    } while ((localObject == null) || (this.qh == null));
    this.qh.clear();
    this.qh.addAll((Collection)localObject);
  }
  
  public void checkUnlockForSpecial()
  {
    if ((this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    try
    {
      getWindow().setBackgroundDrawableResource(2130838900);
      setTitle(getString(2131696659));
      super.setContentView(2131559461);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        auvy.bN(this);
      }
      if (this.app != null)
      {
        this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
        this.app.registObserver(this.jdField_c_of_type_MqqObserverAccountObserver);
        initViews();
        if (this.at != null)
        {
          paramBundle = new IntentFilter();
          paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
          registerReceiver(this.at, paramBundle);
        }
        anot.a(this.app, "CliOper", "", "", "0X800664D", "0X800664D", 0, 0, "", "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X800735D", "0X800735D", 0, 0, "", "", "", "");
        anot.c(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
        anot.c(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 3, 0, "", "", "", "");
        return true;
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        getWindow().setBackgroundDrawableResource(2131165235);
        continue;
        paramBundle = getAppRuntime();
        if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface)))
        {
          this.app = ((QQAppInterface)paramBundle);
          this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
          this.app.registObserver(this.jdField_c_of_type_MqqObserverAccountObserver);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.unRegistObserver(this.jdField_c_of_type_MqqObserverAccountObserver);
      this.app.removeHandler(getClass());
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(20140326);
    }
    if (this.at != null) {
      unregisterReceiver(this.at);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    v(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "doOnNewIntent");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  public void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.pj.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
    if (NotificationActivity.a != null)
    {
      NotificationActivity.a.finish();
      NotificationActivity.a = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "onResume in AddAccountActivity");
    }
    if (this.app != null) {
      this.app.hG(-1L);
    }
    akwp.a().Nq(false);
    if (this.aRb)
    {
      QLog.d("AddAccountActivity", 1, "mShouldAutoLogin: true, then login");
      this.aRb = false;
      et(this.cO);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!isFinishing())
      {
        try
        {
          dismissDialog(0);
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AddAccountActivity", 2, "recv message FINISH_ACTIVITY.. finish activity");
        }
        finish();
        continue;
        if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(20140326);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AddAccountActivity", 2, "handleMessage  LOGIN_DO_NEXT");
        }
        bFx();
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("AddAccountActivity", 1, "onAccountChanged");
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
    Message localMessage = Message.obtain();
    localMessage.what = 20140326;
    this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 800L);
    this.Fd = System.currentTimeMillis();
    if (!aevn.a(getAppRuntime(), getClass(), this.Fd))
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(20140326);
      bFx();
    }
    MiniAppSecurityUtil.doClearAfterLoginSuccess();
  }
  
  public void onAccoutChangeFailed()
  {
    QLog.d("AddAccountActivity", 1, "onAccoutChangeFailed");
  }
  
  public boolean onBackEvent()
  {
    MiniAppSecurityUtil.doClearAfterLoginSuccess();
    finish();
    overridePendingTransition(2130772002, 2130772013);
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
      et(paramView);
      AuthDevUgActivity.zK(3);
      anot.c(this.app, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
      continue;
      if (this.aRa)
      {
        anot.c(this.app, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
        anot.a(this.app, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
        if (!aqiw.isNetSupport(BaseApplicationImpl.sApplication))
        {
          QQToast.a(this, 2131693404, 0).show();
        }
        else
        {
          try
          {
            ((AccountManager)this.app.getManager(0)).checkQuickRegisterAccount(this.app.getAccount(), this.app.getAppid(), "3.4.4", null);
            showDialog(1);
            this.aRa = false;
            new Handler().postDelayed(new AddAccountActivity.3(this), 1000L);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          anot.c(this.app, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
          anot.a(this.app, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
          Qq();
          continue;
          onBackEvent();
        }
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      localarhz = new arhz(this, getTitleBarHeight());
      localarhz.setMessage(getString(2131695551));
      return localarhz;
    }
    arhz localarhz = new arhz(this, getTitleBarHeight());
    localarhz.setMessage(acfp.m(2131702036));
    localarhz.setCancelable(false);
    return localarhz;
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager != null)) {
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity
 * JD-Core Version:    0.7.0.1
 */