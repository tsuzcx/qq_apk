package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import dbu;
import dbv;
import dbw;
import dbx;
import dby;
import dbz;
import dca;
import dcb;
import dcc;
import dcd;
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
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new dca(this);
  public Handler a;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new dcd(this);
  ConditionSearchManager.ISearchListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener = new dcc(this);
  public ConditionSearchManager a;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new dbv(this);
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new dbz(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new dby(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new dcb(this);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_ArrayOfJavaLangString = null;
  }
  
  private void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624120));
    DispatchActionMoveScrollView localDispatchActionMoveScrollView = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296502);
    localDispatchActionMoveScrollView.a = true;
    localDispatchActionMoveScrollView.setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130903500, null));
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
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(49));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296512));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    Object localObject = getResources().getDrawable(2130839376);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new dbu(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298170));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298171));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298172));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298173));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298174));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131364396));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int]);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("性别" + jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int]);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131364397));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(jdField_b_of_type_ArrayOfJavaLangString[this.jdField_b_of_type_Int]);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("年龄" + jdField_b_of_type_ArrayOfJavaLangString[this.jdField_b_of_type_Int]);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131364398));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("所在地" + (String)localObject);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131364399));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("故乡" + (String)localObject);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("查找");
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (this.jdField_c_of_type_Boolean)
    {
      if ((!this.app.n()) || (!NetworkUtil.e(this))) {
        break label600;
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((LBSHandler)this.app.a(3)).c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      return;
      label600:
      this.jdField_c_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
      c();
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
        QQToast.a(this, 2131363527, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131364404));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(paramInt, getString(2131364404));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    Intent localIntent = new Intent(this, LocationSelectActivity.class);
    String[] arrayOfString;
    label180:
    Object localObject;
    if (paramInt == 2)
    {
      i1 = 1;
      localIntent.putExtra("param_req_type", i1);
      if (paramInt != 2) {
        break label304;
      }
      arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
      localIntent.putExtra("param_location", arrayOfString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
      if (paramInt != 2) {
        break label316;
      }
    }
    label304:
    label316:
    for (i1 = 1;; i1 = 0)
    {
      localIntent.putExtra("param_location_param", ((ConditionSearchManager)localObject).a(i1));
      localIntent.putExtra("param_is_popup", true);
      if (!QLog.isColorLevel()) {
        break label356;
      }
      localObject = new StringBuilder("startLocationSelectActivity ");
      if ((arrayOfString == null) || (arrayOfString.length != 4)) {
        break label321;
      }
      i1 = i2;
      while (i1 < 4)
      {
        ((StringBuilder)localObject).append(" | ").append(i1).append(" = ").append(arrayOfString[i1]);
        i1 += 1;
      }
      i1 = 0;
      break;
      arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
      break label180;
    }
    label321:
    StringBuilder localStringBuilder = ((StringBuilder)localObject).append("codes is null = ");
    if (arrayOfString != null)
    {
      localStringBuilder.append(bool);
      QLog.d(jdField_d_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
      label356:
      if (paramInt != 2) {
        break label389;
      }
    }
    label389:
    for (paramInt = 1001;; paramInt = 1000)
    {
      startActivityForResult(localIntent, paramInt);
      overridePendingTransition(2130968585, 2130968589);
      return;
      bool = false;
      break;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    this.h = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void c()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      String str = jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("fillLocationData | autoReqLocation = ").append(this.jdField_c_of_type_Boolean).append(" | isConfigReady = ").append(this.jdField_d_of_type_Boolean).append(" | locationCodes = ").append(this.jdField_c_of_type_ArrayOfJavaLangString).append(" | code one = ");
      if ((this.jdField_c_of_type_ArrayOfJavaLangString != null) && (this.jdField_c_of_type_ArrayOfJavaLangString.length == 4))
      {
        localObject = this.jdField_c_of_type_ArrayOfJavaLangString[0];
        QLog.d(str, 2, localObject);
      }
    }
    else
    {
      if (this.jdField_c_of_type_Boolean) {
        break label117;
      }
    }
    label117:
    while ((!this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_ArrayOfJavaLangString == null))
    {
      return;
      localObject = Integer.valueOf(-1000);
      break;
    }
    if ("-1".equals(this.jdField_c_of_type_ArrayOfJavaLangString[0]))
    {
      this.app.a(new dbw(this));
      return;
    }
    this.app.a(new dbx(this));
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.h = 0;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
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
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("所在地" + paramIntent);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(arrayOfString);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1, paramIntent);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("故乡" + paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903477);
    d(2130837660);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(49));
    setTitle(2131364393);
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    e();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    }
  }
  
  void e()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004241", "0X8004241", 0, 0, "", "", "", "");
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    e();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298174: 
      ReportController.b(this.app, "CliOper", "", "", "0X800424B", "0X800424B", 0, 0, "", "", "", "");
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, 2131363527, 0).b(getTitleBarHeight());
        return;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
      String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramView, arrayOfString);
      a(3, getString(2131364406));
      return;
    case 2131298171: 
      b(0);
      return;
    case 2131298170: 
      b(1);
      return;
    case 2131298173: 
      ReportController.b(this.app, "CliOper", "", "", "0X8004245", "0X8004245", 0, 0, "", "", "", "");
      a(2);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    ReportController.b(this.app, "CliOper", "", "", "0X8004244", "0X8004244", 0, 0, "", "", "", "");
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity
 * JD-Core Version:    0.7.0.1
 */