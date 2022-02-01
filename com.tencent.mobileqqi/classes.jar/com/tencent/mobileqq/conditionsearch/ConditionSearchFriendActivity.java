package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import fld;
import fle;
import flf;
import flg;
import flh;
import fli;
import flj;
import flk;
import fll;
import flm;
import java.util.List;

public class ConditionSearchFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 20000L;
  static final boolean jdField_a_of_type_Boolean = true;
  public static final String[] a;
  public static final String[] b;
  static final int jdField_d_of_type_Int = 0;
  private static final String jdField_d_of_type_JavaLangString = ConditionSearchFriendActivity.class.getSimpleName();
  static final int e = 1;
  static final int f = 2;
  static final int g = 3;
  private static final int i = 1000;
  private static final int j = 1001;
  private static final int l = 0;
  private static final int m = 1;
  private static final int n = 1000;
  private static final int o = 1001;
  public int a;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new flj(this);
  public Handler a;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new flm(this);
  ConditionSearchManager.ISearchListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener = new fll(this);
  public ConditionSearchManager a;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new fle(this);
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new fli(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new flh(this);
  public IphonePickerView a;
  public FormSimpleItem a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public ActionSheet a;
  public String a;
  List jdField_a_of_type_JavaUtilList;
  public int b;
  public FormSimpleItem b;
  String b;
  public boolean b;
  public int c;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  public String[] c;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean d;
  public int h = 0;
  private final int k = 20;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = ConditionSearchManager.jdField_a_of_type_ArrayOfJavaLangString;
    jdField_b_of_type_ArrayOfJavaLangString = ConditionSearchManager.jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public ConditionSearchFriendActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new flk(this);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_ArrayOfJavaLangString = null;
  }
  
  private void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.b(this);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130903583, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_d_of_type_JavaLangString, 2, localThrowable.getMessage());
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231069));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new fld(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232913));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232914));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232915));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232916));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232917));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131562161));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int]);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("性别" + jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int] + ", 触摸两次选择");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131561630));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(jdField_b_of_type_ArrayOfJavaLangString[this.jdField_b_of_type_Int]);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("年龄" + jdField_b_of_type_ArrayOfJavaLangString[this.jdField_b_of_type_Int] + ", 触摸两次选择");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131562306));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(str);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("所在地" + str + ", 触摸两次选择");
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131562220));
    str = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(str);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("故乡" + str + ", 触摸两次选择");
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("查找 按钮，触摸两次查找");
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (this.jdField_c_of_type_Boolean)
    {
      if ((!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.n()) || (!NetworkUtil.e(this))) {
        break label585;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((LBSHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(3)).d();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      return;
      label585:
      this.jdField_c_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
      d();
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    int i2 = 0;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(i1);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "startLocationSelectActivity | update result = " + i1);
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131562449, 0).b(d());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131562167));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(paramInt, getString(2131562167));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    Intent localIntent = new Intent(this, LocationSelectActivity.class);
    if (paramInt == 2)
    {
      i1 = 1;
      localIntent.putExtra("param_req_type", i1);
      if (paramInt != 2) {
        break label266;
      }
    }
    StringBuilder localStringBuilder1;
    label266:
    for (String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();; arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a())
    {
      localIntent.putExtra("param_location", arrayOfString);
      if (!QLog.isColorLevel()) {
        break label313;
      }
      localStringBuilder1 = new StringBuilder("startLocationSelectActivity ");
      if ((arrayOfString == null) || (arrayOfString.length != 4)) {
        break label278;
      }
      i1 = i2;
      while (i1 < 4)
      {
        localStringBuilder1.append(" | ").append(i1).append(" = ").append(arrayOfString[i1]);
        i1 += 1;
      }
      i1 = 0;
      break;
    }
    label278:
    StringBuilder localStringBuilder2 = localStringBuilder1.append("codes is null = ");
    if (arrayOfString != null)
    {
      localStringBuilder2.append(bool);
      QLog.d(jdField_d_of_type_JavaLangString, 2, localStringBuilder1.toString());
      label313:
      if (paramInt != 2) {
        break label346;
      }
    }
    label346:
    for (paramInt = 1001;; paramInt = 1000)
    {
      startActivityForResult(localIntent, paramInt);
      overridePendingTransition(2130968591, 2130968595);
      return;
      bool = false;
      break;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    this.h = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "fillLocationData | autoReqLocation = " + this.jdField_c_of_type_Boolean + " | isConfigReady = " + this.jdField_d_of_type_Boolean + " | locationCodes = " + this.jdField_c_of_type_ArrayOfJavaLangString);
    }
    if (!this.jdField_c_of_type_Boolean) {}
    while ((!this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_ArrayOfJavaLangString == null)) {
      return;
    }
    if (this.jdField_c_of_type_ArrayOfJavaLangString[0] == "-1")
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new flf(this));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new flg(this));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String[] arrayOfString;
    if (paramInt2 == -1)
    {
      arrayOfString = paramIntent.getStringArrayExtra("param_location");
      paramIntent = paramIntent.getStringExtra("param_location_param");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if ((arrayOfString != null) && (arrayOfString.length == 4)) {
          paramInt2 = 0;
        }
        while (paramInt2 < 4)
        {
          localStringBuilder.append(" | ").append(paramInt2).append(" = ").append(arrayOfString[paramInt2]);
          paramInt2 += 1;
          continue;
          localStringBuilder.append("empty sb");
        }
        QLog.d(jdField_d_of_type_JavaLangString, 2, "doOnActivityResult | codes = " + localStringBuilder.toString() + " | desc = " + paramIntent);
      }
      if (paramInt1 == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(arrayOfString);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, paramIntent);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("所在地" + paramIntent + ", 触摸两次选择");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(arrayOfString);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1, paramIntent);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("故乡" + paramIntent + ", 触摸两次选择");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903557);
    j(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    setTitle(2131562329);
    g();
    return true;
  }
  
  protected void doOnDestroy()
  {
    f();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.h = 0;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  void f()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004241", "0X8004241", 0, 0, "", "", "", "");
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    f();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232917: 
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800424B", "0X800424B", 0, 0, "", "", "", "");
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, 2131562449, 0).b(d());
        return;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
      String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramView, arrayOfString);
      a(3, getString(2131562333));
      return;
    case 2131232914: 
      b(0);
      return;
    case 2131232913: 
      b(1);
      return;
    case 2131232916: 
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004245", "0X8004245", 0, 0, "", "", "", "");
      a(2);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004244", "0X8004244", 0, 0, "", "", "", "");
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity
 * JD-Core Version:    0.7.0.1
 */