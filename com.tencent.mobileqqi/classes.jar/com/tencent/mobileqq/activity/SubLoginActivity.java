package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import dsk;
import dsl;
import dso;
import dsp;
import dsq;
import dsr;
import dss;
import dst;
import dsv;
import dsw;
import dsx;
import dsy;
import dsz;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;

public class SubLoginActivity
  extends SubAccountBaseActivity
  implements TextWatcher, View.OnClickListener
{
  public static final int a = 1982;
  private static final String jdField_a_of_type_JavaLangString = "Q.subaccount.SubLoginActivity";
  private static final String jdField_b_of_type_JavaLangString = "!@#ewaGbhkc$!!=";
  private static final boolean e = true;
  Handler jdField_a_of_type_AndroidOsHandler = new dss(this);
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new dso(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dsp(this);
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private AutoCompleteTextView jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new dst(this);
  public SubAccountBindObserver a;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private DropdownView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView;
  private InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  public ActionSheet a;
  private List jdField_a_of_type_JavaUtilList;
  private SubAccountObserver jdField_a_of_type_MqqObserverSubAccountObserver = new dsl(this);
  TextWatcher jdField_b_of_type_AndroidTextTextWatcher = new dsq(this);
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String c;
  public boolean c;
  private String d;
  public boolean d;
  private boolean f;
  private boolean g;
  private boolean h = false;
  
  public SubLoginActivity()
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new dsz(this);
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(paramSimpleAccount.getUin()));
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("!@#ewaGbhkc$!!=");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
        }
      }
      finally {}
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  protected boolean b()
  {
    finish();
    return true;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_JavaLangString = paramCharSequence.toString();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903998);
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("subuin");
    this.f = getIntent().getBooleanExtra("is_need_bind", true);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = ((DropdownView)findViewById(2131230735)).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundResource(2130838113);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131231905));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131231907));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131561703);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131231900));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231901);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(new dsv(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131231908));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131230735));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilList = getAppRuntime().getApplication().getAllAccounts();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(new dsw(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnFocusChangeListener(new dsx(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLongClickable(false);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new dsy(this));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131562626));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131562028));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562285));
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      this.g = true;
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setEnabled(false);
      if (!this.f) {
        setTitle(2131563164);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
      a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      SubAccountAssistantForward.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 0L);
      return true;
      setTitle(2131562836);
      continue;
      setTitle(2131562836);
    }
  }
  
  protected void doOnDestroy()
  {
    e();
    f();
    super.doOnDestroy();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onPause:....loginActivity..................");
    }
    super.doOnPause();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  protected void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.performClick();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131561791);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131562940);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131561746);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new dsk(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new dsr(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231907)
    {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if ((paramView != null) && (paramView.length() != 0) && (paramView.trim().length() != 0)) {
        break label92;
      }
      QQToast.a(this, 2131562628, 0).b(d());
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
    }
    label92:
    String str1;
    do
    {
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if ((str1 == null) || (str1.length() < 1))
      {
        a(getString(2131562033));
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
        return;
      }
      if ((paramView.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) || (paramView.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
      {
        a(getString(2131561657));
        return;
      }
      String str2 = SubAccountAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      if (((paramView.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(str2))) || (paramView.equals(str2))) && (this.f))
      {
        a(getString(2131563259));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (str1.equals("!@#ewaGbhkc$!!=")))
      {
        str2 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        int i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin() == null)) {}
          while (!((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin().equals(str2))
          {
            i += 1;
            break;
          }
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i));
        }
      }
    } while (!f());
    if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) && (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.isLogined()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: mCurrentAccount and islogin so get subaccount key start");
      }
      d();
      getAppRuntime().getSubAccountKey(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), this.jdField_a_of_type_MqqObserverSubAccountObserver);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: no login so go to loginSubAccount");
    }
    d();
    getAppRuntime().loginSubAccount(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView, str1, this.jdField_a_of_type_MqqObserverSubAccountObserver);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      a(null);
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.length() == 0)) {}
      do
      {
        do
        {
          return;
          paramCharSequence = paramCharSequence.toString();
        } while ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != this.jdField_c_of_type_JavaLangString.length() + 1));
        if ((!paramCharSequence.substring(0, this.jdField_c_of_type_JavaLangString.length()).equals(this.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(this.jdField_c_of_type_JavaLangString.length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(paramCharSequence);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(1);
    }
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity
 * JD-Core Version:    0.7.0.1
 */