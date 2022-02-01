package com.tencent.mobileqq.activity;

import acmf;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import anxk;
import anxr;
import aqcl;
import ausj;
import auss;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;
import mqq.os.MqqHandler;
import vwi;
import vwj;
import vwk;
import vwl;
import vwm;
import vwn;
import vwo;
import vwp;
import vwq;
import vwr;

public class SubLoginActivity
  extends SubAccountBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private static final boolean aTl = AppSetting.enableTalkBack;
  private AutoCompleteTextView jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  private DropdownView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView;
  private InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  private SubAccountObserver jdField_a_of_type_MqqObserverSubAccountObserver = new vwr(this);
  private String aKD;
  private String aQf;
  private boolean aRb;
  public boolean ach = false;
  public BroadcastReceiver at = new vwp(this);
  public acmf b;
  MqqHandler b;
  private boolean baB;
  private boolean baC;
  public boolean baD = false;
  private InputMethodManager jdField_c_of_type_AndroidViewInputmethodInputMethodManager;
  private SimpleAccount jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private Button cO;
  private Button cQ;
  private ClearableEditText i;
  public ausj mActionSheet = null;
  private ImageView pj;
  private List<SimpleAccount> qh;
  private View ro;
  TextWatcher u = new vwj(this);
  
  public SubLoginActivity()
  {
    this.jdField_b_of_type_MqqOsMqqHandler = new vwl(this);
    this.jdField_b_of_type_Acmf = new vwq(this);
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.i.removeTextChangedListener(this);
        this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.i.setText("");
          this.i.addTextChangedListener(this);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.jm(paramSimpleAccount.getUin()));
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.i.setText("!@#ewaGbhkc$!!=");
        }
        else
        {
          this.i.setText("");
        }
      }
      finally {}
    }
  }
  
  protected void Qq()
  {
    if (this.mActionSheet == null)
    {
      this.mActionSheet = ((ausj)auss.a(this, null));
      this.mActionSheet.addButton(2131693739);
      this.mActionSheet.addButton(2131720366);
      this.mActionSheet.addCancelButton(2131721058);
      this.mActionSheet.setOnDismissListener(new vwi(this));
      this.mActionSheet.a(new vwk(this));
    }
    if (!this.mActionSheet.isShowing())
    {
      this.ach = false;
      this.mActionSheet.show();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.aKD = null;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.aKD = paramCharSequence.toString();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563130);
    this.app.registObserver(this.jdField_a_of_type_MqqObserverSubAccountObserver);
    this.aQf = getIntent().getStringExtra("subuin");
    this.baB = getIntent().getBooleanExtra("is_need_bind", true);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = ((DropdownView)findViewById(2131366145)).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundResource(2130841404);
    this.i = ((ClearableEditText)findViewById(2131372885));
    this.cO = ((Button)findViewById(2131370875));
    this.cO.setOnClickListener(this);
    if (this.at != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
      registerReceiver(this.at, paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131370898));
    this.ro = findViewById(2131377754);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null))
    {
      paramBundle = findViewById(2131370461);
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(-15724528);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(new vwm(this));
    if (AppSetting.enableTalkBack) {
      aqcl.Q(this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout, false);
    }
    this.cQ = ((Button)findViewById(2131367099));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131366145));
    this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.pj = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.B();
    this.pj.setOnClickListener(this);
    this.qh = getAppRuntime().getApplication().getAllAccounts();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.u);
    this.i.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.C().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(new vwn(this));
    this.i.setOnFocusChangeListener(new vwo(this));
    this.i.setLongClickable(false);
    this.cQ.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.i.clearFocus();
    this.i.setClearButtonVisible(false);
    if (aTl)
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131720762));
      this.i.setContentDescription(getString(2131720781));
      this.cO.setContentDescription(getString(2131720570));
    }
    if (!TextUtils.isEmpty(this.aQf))
    {
      this.baC = true;
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.aQf);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setEnabled(false);
      if (this.baB)
      {
        setTitle(2131720542);
        this.cO.setText(2131720571);
      }
    }
    for (;;)
    {
      this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
      addObserver(this.jdField_b_of_type_Acmf);
      return true;
      setTitle(2131720573);
      this.cO.setText(2131721090);
      continue;
      setTitle(2131720542);
      this.cO.setText(2131720571);
    }
  }
  
  public void doOnDestroy()
  {
    ath();
    aff();
    super.doOnDestroy();
    this.app.removeHandler(getClass());
    removeObserver(this.jdField_b_of_type_Acmf);
    this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverSubAccountObserver);
    if (this.at != null) {
      unregisterReceiver(this.at);
    }
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onPause:....loginActivity..................");
    }
    super.doOnPause();
    this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  public void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.pj.setVisibility(8);
    if (this.baC)
    {
      this.i.requestFocus();
      this.i.performClick();
    }
    for (;;)
    {
      this.i.setClearButtonVisible(false);
      if (this.aRb)
      {
        QLog.d("Q.subaccount.SubLoginActivity", 1, "mShouldAutoLogin: true, then login");
        this.aRb = false;
        if (this.cO != null) {
          this.cO.performClick();
        }
      }
      return;
      this.i.clearFocus();
    }
  }
  
  public boolean onBackEvent()
  {
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    if (paramView == this.pj)
    {
      if ((this.pj != null) && (this.pj.isShown())) {
        this.pj.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
      this.i.setText("");
    }
    String str1;
    String str2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131367099: 
        Qq();
        break;
      case 2131370875: 
        this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        str1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        if ((str1 == null) || (str1.length() == 0) || (str1.trim().length() == 0))
        {
          QQToast.a(this, 2131696496, 0).show(getTitleBarHeight());
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
          this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
        }
        else
        {
          str2 = this.i.getText().toString();
          if ((str2 == null) || (str2.length() < 1))
          {
            wz(getString(2131696732));
            this.i.requestFocus();
            this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.i, 2);
          }
          else
          {
            if ((!str1.equals(this.app.jm(this.app.getAccount()))) && (!str1.equals(this.app.getAccount()))) {
              break label303;
            }
            wz(getString(2131720568));
          }
        }
        break;
      }
    }
    label303:
    Object localObject;
    if (this.baB)
    {
      localObject = (anxr)this.app.getManager(61);
      if (localObject == null) {
        break label653;
      }
    }
    label653:
    for (boolean bool = ((anxr)localObject).pJ(str1);; bool = false)
    {
      if (bool)
      {
        wz(getString(2131720569));
        break;
      }
      if ((localObject != null) && (((anxr)localObject).Kx() >= 2))
      {
        anxk.a(this.app, this);
        break;
      }
      if ((this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (str2.equals("!@#ewaGbhkc$!!=")))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        if (j < this.qh.size())
        {
          if ((this.qh.get(j) == null) || (((SimpleAccount)this.qh.get(j)).getUin() == null)) {}
          while (!((SimpleAccount)this.qh.get(j)).getUin().equals(localObject))
          {
            j += 1;
            break;
          }
          this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.qh.get(j));
        }
      }
      if (!QN()) {
        break;
      }
      if ((this.cO != null) && (getString(2131721090).equals(this.cO.getText()))) {
        yC(2131720617);
      }
      for (;;)
      {
        if ((this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) || (!this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount.isLogined())) {
          break label611;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: mCurrentAccount and islogin so get subaccount key start");
        }
        getAppRuntime().getSubAccountKey(this.app.getAccount(), this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), null);
        break;
        yC(2131720545);
      }
      label611:
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: no login so go to loginSubAccount");
      }
      AuthDevUgActivity.zK(2);
      getAppRuntime().loginSubAccount(this.app.getAccount(), str1, str2, null);
      break;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_c_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      a(null);
      if ((this.aKD == null) || (this.aKD.length() == 0)) {}
      do
      {
        do
        {
          return;
          paramCharSequence = paramCharSequence.toString();
        } while ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != this.aKD.length() + 1));
        if (!paramCharSequence.substring(0, this.aKD.length()).equals(this.aKD)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(this.aKD.length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.i.setText(paramCharSequence);
      this.i.setSelection(1);
    }
    this.aKD = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager != null)) {
      this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity
 * JD-Core Version:    0.7.0.1
 */