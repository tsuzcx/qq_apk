package com.tencent.mobileqq.conditionsearch;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;
import fqf;
import fqg;
import fqh;
import fqi;
import fqj;
import fqk;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LocationSelectActivity
  extends LbsBaseActivity
  implements View.OnClickListener, ActionSheet.OnDismissListener
{
  public static final String a = "param_req_type";
  static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 0;
  static final long jdField_b_of_type_Long = 1200L;
  public static final String b = "param_location";
  public static final int c = 1;
  public static final String c = "param_location_param";
  public static final int d = 1000;
  public static final int e = 0;
  private static final String e = LocationSelectActivity.class.getSimpleName();
  public static final int f = 1;
  public static final int g = 2;
  public long a;
  public Handler a;
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new fqk(this);
  private BaseAddress jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new fqi(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new fqh(this);
  public IphonePickerView a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public ActionSheet a;
  public int[] a;
  public BaseAddress[] a;
  public Object[] a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_b_of_type_Boolean;
  private FormSimpleItem c;
  String d = "1";
  private String f;
  public int h = 0;
  final int i = 1000;
  private int j;
  
  public LocationSelectActivity()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new fqj(this);
  }
  
  private int a(ArrayList paramArrayList, String paramString)
  {
    int m = paramArrayList.size();
    int k = 0;
    while (k < m)
    {
      if (((BaseAddress)paramArrayList.get(k)).b.equals(paramString)) {
        return k;
      }
      k += 1;
    }
    return 0;
  }
  
  private void a(FormSimpleItem paramFormSimpleItem, boolean paramBoolean)
  {
    if (paramFormSimpleItem != null)
    {
      this.c.setEnabled(paramBoolean);
      paramFormSimpleItem = this.c;
      if (paramBoolean) {
        break label42;
      }
    }
    label42:
    for (int k = 2;; k = 0)
    {
      paramFormSimpleItem.setLeftTextColor(k);
      if (!paramBoolean) {
        this.c.setContentDescription("省市 不限");
      }
      return;
    }
  }
  
  private String[] a()
  {
    int k = 0;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
      int m = arrayOfBaseAddress.length;
      while (k < m)
      {
        BaseAddress localBaseAddress = arrayOfBaseAddress[k];
        if (localBaseAddress == null) {
          break;
        }
        arrayOfString[(localBaseAddress.e - 1)] = String.valueOf(ConditionSearchManager.a(localBaseAddress.b));
        k += 1;
      }
    }
    return arrayOfString;
  }
  
  private String c()
  {
    Object localObject = new StringBuilder();
    int k = 0;
    while (k < this.h)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[k] != null) && (!"0".equals(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[k].b))) {
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[k].jdField_a_of_type_JavaLangString).append("-");
      }
      k += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "不限";
    }
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  private String d()
  {
    String str = c();
    if (!"不限".equals(str)) {
      return str;
    }
    return "";
  }
  
  private void e()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = null;
  }
  
  private void f()
  {
    String[] arrayOfString = getIntent().getStringArrayExtra("param_location");
    if (arrayOfString != null)
    {
      e();
      if ((this.j != 0) || (!this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b())) {
        break label36;
      }
    }
    for (;;)
    {
      return;
      label36:
      this.d = arrayOfString[0];
      int k = 1;
      int m = arrayOfString.length;
      while (k < m)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[(k - 1)] = arrayOfString[k];
        k += 1;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.d);
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {}
    label22:
    int k;
    label108:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null);
      this.h = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.a();
      if (this.c != null)
      {
        if (this.h == 0)
        {
          a(this.c, false);
          return;
        }
        a(this.c, true);
      }
      this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.h];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = new BaseAddress[this.h];
      this.jdField_a_of_type_ArrayOfInt = new int[this.h];
      k = 0;
      if (k >= this.h) {
        break;
      }
      if (k != 0) {
        break label216;
      }
      this.jdField_a_of_type_ArrayOfJavaLangObject[0] = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0] = ((BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[0]));
    } while ((this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0] == null) || ("0".equals(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0].b)));
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfInt[k] = a((ArrayList)this.jdField_a_of_type_ArrayOfJavaLangObject[k], this.jdField_a_of_type_ArrayOfJavaLangString[k]);
      k += 1;
      break label108;
      break label22;
      label216:
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[(k - 1)] == null) {
        break;
      }
      this.jdField_a_of_type_ArrayOfJavaLangObject[k] = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[(k - 1)].a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[k] = ((BaseAddress)this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[(k - 1)].jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[k]));
    }
  }
  
  private void h()
  {
    b(2131561977, new fqf(this));
    d(true);
    this.k.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232991));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232992));
    this.c = ((FormSimpleItem)findViewById(2131232993));
    Object localObject;
    if (this.j == 0)
    {
      setTitle(2131562306);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131563151));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("使用当前位置，触摸两次开始定位");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131561886));
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label447;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label307;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("国家 " + (String)localObject + ",触摸两次开始定位");
      this.c.setLeftIcon(null);
      this.c.setLeftText(getResources().getString(2131562671));
      this.c.setOnClickListener(this);
      if (this.h == 0)
      {
        a(this.c, false);
        return;
        setTitle(2131562220);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        break;
        label307:
        localObject = getString(2131559225);
        continue;
      }
      a(this.c, true);
      if (this.j == 0)
      {
        this.f = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.f);
        if (!localObject[0].equals(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString)) {
          break label438;
        }
      }
      label438:
      for (this.f = localObject[1];; this.f = "不限")
      {
        this.c.setRightText(this.f);
        this.c.setContentDescription(this.f + "，触摸两次选择");
        return;
        this.f = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
        break;
      }
      label447:
      localObject = null;
    }
  }
  
  private void i()
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, 2131562449, 0).b(d());
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    ((LBSHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(3)).d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(2);
    Drawable localDrawable = getResources().getDrawable(2130837860);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localDrawable);
    ((Animatable)localDrawable).start();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.b(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130903581, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    int k = 0;
    while (k < this.h)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(k, this.jdField_a_of_type_ArrayOfInt[k]);
      k += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
    try
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      this.c.setRightTextColor(1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(e, 2, localThrowable.getMessage());
        }
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  protected int a()
  {
    return 2131561647;
  }
  
  public void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    Object localObject = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length == 4))
    {
      if (this.jdField_b_of_type_Boolean)
      {
        if (!TextUtils.isEmpty(paramArrayOfString[0])) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramArrayOfString[0]);
        }
        if (localObject == null) {
          break label189;
        }
        this.d = paramArrayOfString[0];
        e();
        i1 = paramArrayOfString.length;
        m = 0;
        k = 1;
        while (k < i1)
        {
          n = m;
          if (!TextUtils.isEmpty(paramArrayOfString[k]))
          {
            this.jdField_a_of_type_ArrayOfJavaLangString[m] = paramArrayOfString[k];
            n = m + 1;
          }
          k += 1;
          m = n;
        }
        g();
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
        localObject = this.c;
        if (this.h != 0) {
          break label181;
        }
        paramArrayOfString = "";
        ((FormSimpleItem)localObject).setRightText(paramArrayOfString);
      }
      label181:
      label189:
      while (!QLog.isColorLevel()) {
        for (;;)
        {
          int i1;
          int m;
          int k;
          int n;
          return;
          paramArrayOfString = c();
        }
      }
      QLog.d(e, 2, "invalid country code!! | cournty code is :" + paramArrayOfString[0]);
      return;
    }
    QQToast.a(this, 2131562303, 0).b(d());
  }
  
  public boolean b()
  {
    Intent localIntent = new Intent();
    Object localObject = new String[4];
    localObject[0] = this.d;
    localObject[1] = "0";
    localObject[2] = "0";
    localObject[3] = "0";
    int k;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      int m = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress.length;
      k = 0;
      if ((k < m) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[k] != null)) {}
    }
    else
    {
      localIntent.putExtra("param_location", (String[])localObject);
      localObject = d();
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label194;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label158;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString;
      label101:
      localIntent.putExtra("param_location_param", (String)localObject);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      finish();
      overridePendingTransition(0, 2130968590);
      return false;
      localObject[this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[k].e] = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[k].b;
      k += 1;
      break;
      label158:
      localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString + "-" + c();
      break label101;
      label194:
      localIntent.putExtra("param_location_param", "不限");
    }
  }
  
  protected void d() {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_country_code");
      if ((!TextUtils.isEmpty(paramIntent)) && (!this.d.equals(paramIntent)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent) != null) {
          break label83;
        }
        if (QLog.isColorLevel()) {
          QLog.d(e, 2, "doOnActivityResult | should not be here, can not get country by code ! result code = " + paramIntent);
        }
      }
    }
    return;
    label83:
    this.d = paramIntent;
    e();
    g();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
    if (this.h == 0) {}
    for (paramIntent = "";; paramIntent = "不限")
    {
      this.c.setRightText(paramIntent);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("国家 " + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString + ",触摸两次开始定位");
      this.c.setContentDescription(paramIntent + ",触摸两次开始定位");
      if (this.j != 0) {
        break;
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004247", "0X8004247", 0, 0, ConditionSearchManager.a(this.d) + "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004249", "0X8004249", 0, 0, ConditionSearchManager.a(this.d) + "", "", "", "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.j = getIntent().getIntExtra("param_req_type", 0);
    j(2130837729);
    setContentView(2130903586);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    f();
    g();
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232991: 
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004246", "0X8004246", 0, 0, "", "", "", "");
      this.jdField_b_of_type_Boolean = true;
      b(new fqg(this));
      return;
    case 2131232992: 
      paramView = new Intent(this, CountrySelectActivity.class);
      paramView.putExtra("key_country_code", this.d);
      startActivityForResult(paramView, 1000);
      return;
    }
    j();
  }
  
  public void onDismiss()
  {
    this.c.setRightTextColor(2);
    String[] arrayOfString = a();
    if (this.j == 0)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004248", "0X8004248", 0, 0, arrayOfString[0], arrayOfString[1], arrayOfString[2], "");
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800424A", "0X800424A", 0, 0, arrayOfString[0], arrayOfString[1], arrayOfString[2], "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */