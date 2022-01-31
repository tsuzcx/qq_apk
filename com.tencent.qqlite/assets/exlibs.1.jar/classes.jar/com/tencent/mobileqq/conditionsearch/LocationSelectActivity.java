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
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ActionSheetHelper;
import dci;
import dcj;
import dck;
import dcl;
import dcm;
import dcn;
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
  public static final int d = 2;
  public static final String d = "param_is_popup";
  public static final int e = 3;
  public static final String e = "----";
  public static final int f = 1000;
  public static final String f = "不限";
  public static final int g = 0;
  public static final int h = 1;
  private static final String h;
  public static final int i = 2;
  public long a;
  public Handler a;
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new dcn(this);
  private BaseAddress jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new dcl(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new dck(this);
  public IphonePickerView a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public ActionSheet a;
  public int[] a;
  public BaseAddress[] a;
  public Object[] a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_b_of_type_Boolean;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_c_of_type_Boolean;
  String g = "1";
  private String i;
  public int j = 0;
  final int k = 1000;
  private int l;
  
  static
  {
    jdField_h_of_type_JavaLangString = LocationSelectActivity.class.getSimpleName();
  }
  
  public LocationSelectActivity()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new dcm(this);
  }
  
  private int a(ArrayList paramArrayList, String paramString)
  {
    int n = paramArrayList.size();
    int m = 0;
    while (m < n)
    {
      if (((BaseAddress)paramArrayList.get(m)).b.equals(paramString)) {
        return m;
      }
      m += 1;
    }
    return 0;
  }
  
  private void a(FormSimpleItem paramFormSimpleItem, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.equals("不限")) {
        str = "";
      }
    }
    paramFormSimpleItem.setRightText(str);
    paramFormSimpleItem.setContentDescription(str);
  }
  
  private void a(FormSimpleItem paramFormSimpleItem, boolean paramBoolean)
  {
    if (paramFormSimpleItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(paramBoolean);
      paramFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (paramBoolean) {
        break label42;
      }
    }
    label42:
    for (int m = 2;; m = 0)
    {
      paramFormSimpleItem.setLeftTextColor(m);
      if (!paramBoolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("省市 不限");
      }
      return;
    }
  }
  
  private String[] a()
  {
    int m = 0;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
      int n = arrayOfBaseAddress.length;
      while (m < n)
      {
        BaseAddress localBaseAddress = arrayOfBaseAddress[m];
        if (localBaseAddress == null) {
          break;
        }
        arrayOfString[(localBaseAddress.e - 1)] = String.valueOf(ConditionSearchManager.a(localBaseAddress.b));
        m += 1;
      }
    }
    return arrayOfString;
  }
  
  private String d()
  {
    Object localObject = new StringBuilder();
    int m = 0;
    while (m < this.j)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m] != null) && (!"0".equals(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m].b))) {
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m].jdField_a_of_type_JavaLangString).append("-");
      }
      m += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "不限";
    }
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  private String e()
  {
    String str = d();
    if (!"不限".equals(str)) {
      return str;
    }
    return "";
  }
  
  private void f()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = null;
  }
  
  private void g()
  {
    String[] arrayOfString = getIntent().getStringArrayExtra("param_location");
    if (arrayOfString != null)
    {
      f();
      if ((this.l != 0) || (!this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c()) || ((arrayOfString != null) && (!arrayOfString[0].equals("0")))) {
        break label51;
      }
    }
    for (;;)
    {
      return;
      label51:
      this.g = arrayOfString[0];
      int m = 1;
      int n = arrayOfString.length;
      while (m < n)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[(m - 1)] = arrayOfString[m];
        m += 1;
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.g);
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {}
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null)
        {
          this.j = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.a();
          if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
          {
            if (this.j == 0)
            {
              a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, false);
              return;
            }
            a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, true);
          }
          this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.j];
          this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = new BaseAddress[this.j];
          this.jdField_a_of_type_ArrayOfInt = new int[this.j];
          if (this.j == 0) {
            break;
          }
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
          int i1 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
          int n = 0;
          int m = 0;
          if (n < i1)
          {
            if ("0".equals(this.jdField_a_of_type_ArrayOfJavaLangString[n])) {}
            BaseAddress localBaseAddress;
            do
            {
              n += 1;
              break;
              this.jdField_a_of_type_ArrayOfJavaLangObject[m] = ((BaseAddress)localObject).a();
              BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
              localBaseAddress = (BaseAddress)((BaseAddress)localObject).jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[n]);
              arrayOfBaseAddress[m] = localBaseAddress;
              this.jdField_a_of_type_ArrayOfInt[m] = a((ArrayList)this.jdField_a_of_type_ArrayOfJavaLangObject[m], this.jdField_a_of_type_ArrayOfJavaLangString[n]);
              m += 1;
              localObject = localBaseAddress;
            } while (localBaseAddress != null);
            return;
          }
          if (m == 0)
          {
            this.jdField_a_of_type_ArrayOfJavaLangObject[m] = ((BaseAddress)localObject).a();
            this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m] = ((BaseAddress)((BaseAddress)localObject).jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(0)));
            return;
          }
          try
          {
            if (m < this.j)
            {
              this.jdField_a_of_type_ArrayOfJavaLangObject[m] = ((BaseAddress)localObject).a();
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_h_of_type_JavaLangString, 2, "", localException);
  }
  
  private void i()
  {
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("param_is_popup", true);
    label165:
    Object localObject;
    if (this.jdField_c_of_type_Boolean)
    {
      a(2131363444, new dci(this));
      c(true);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298239));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298240));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298241));
      if ((this.l != 0) && (this.l != 2)) {
        break label316;
      }
      setTitle(2131364398);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131364400));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("使用当前位置");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131364401));
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label423;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label335;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, (String)localObject);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("国家 " + (String)localObject);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131364402));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (this.j == 0)
      {
        a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, false);
        return;
        setLeftViewName(2131364503);
        break;
        label316:
        setTitle(2131364399);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        break label165;
        label335:
        localObject = "中国";
        continue;
      }
      a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, true);
      this.i = getIntent().getStringExtra("param_location_param");
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.i);
      if (localObject[0].equals(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString)) {
        this.i = localObject[1];
      }
      a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.i);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(this.i);
      return;
      label423:
      localObject = null;
    }
  }
  
  private void j()
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, 2131363527, 0).b(getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    ((LBSHandler)this.app.a(3)).c();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(2);
    Drawable localDrawable = getResources().getDrawable(2130837928);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localDrawable);
    ((Animatable)localDrawable).start();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624120));
    DispatchActionMoveScrollView localDispatchActionMoveScrollView = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296502);
    localDispatchActionMoveScrollView.a = true;
    localDispatchActionMoveScrollView.setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130903500, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    int m = 0;
    while (m < this.j)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(m, this.jdField_a_of_type_ArrayOfInt[m]);
      m += 1;
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
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_h_of_type_JavaLangString, 2, localThrowable.getMessage());
        }
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  protected int a()
  {
    return 2131364410;
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
          break label191;
        }
        this.g = paramArrayOfString[0];
        f();
        i2 = paramArrayOfString.length;
        n = 0;
        m = 1;
        while (m < i2)
        {
          i1 = n;
          if (!TextUtils.isEmpty(paramArrayOfString[m]))
          {
            this.jdField_a_of_type_ArrayOfJavaLangString[n] = paramArrayOfString[m];
            i1 = n + 1;
          }
          m += 1;
          n = i1;
        }
        h();
        a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
        localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        if (this.j != 0) {
          break label183;
        }
        paramArrayOfString = "";
        a((FormSimpleItem)localObject, paramArrayOfString);
      }
      label183:
      label191:
      while (!QLog.isColorLevel()) {
        for (;;)
        {
          int i2;
          int n;
          int m;
          int i1;
          return;
          paramArrayOfString = d();
        }
      }
      QLog.d(jdField_h_of_type_JavaLangString, 2, "invalid country code!! | cournty code is :" + paramArrayOfString[0]);
      return;
    }
    QQToast.a(this, 2131364403, 0).b(getTitleBarHeight());
  }
  
  public boolean a()
  {
    Intent localIntent = new Intent();
    Object localObject = new String[4];
    localObject[0] = this.g;
    localObject[1] = "0";
    localObject[2] = "0";
    localObject[3] = "0";
    int m;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      int n = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress.length;
      m = 0;
      if ((m < n) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m] != null)) {}
    }
    else
    {
      localIntent.putExtra("param_location", (String[])localObject);
      localObject = e();
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label201;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label165;
      }
    }
    label165:
    for (localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString;; localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString + "-" + d())
    {
      localIntent.putExtra("param_location_param", (String)localObject);
      setResult(-1, localIntent);
      finish();
      if (this.jdField_c_of_type_Boolean) {
        overridePendingTransition(0, 2130968584);
      }
      return false;
      localObject[this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m].e] = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m].b;
      m += 1;
      break;
    }
    label201:
    if ((this.l == 2) || (this.l == 3)) {}
    for (localObject = "";; localObject = "不限")
    {
      localIntent.putExtra("param_location_param", (String)localObject);
      break;
    }
  }
  
  protected void d() {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_country_code");
      if ((!TextUtils.isEmpty(paramIntent)) && (!this.g.equals(paramIntent)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent) != null) {
          break label83;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_h_of_type_JavaLangString, 2, "doOnActivityResult | should not be here, can not get country by code ! result code = " + paramIntent);
        }
      }
    }
    return;
    label83:
    this.g = paramIntent;
    f();
    h();
    a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
    if (this.j == 0) {}
    for (paramIntent = "";; paramIntent = "不限")
    {
      a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramIntent);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("国家 " + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(paramIntent);
      if (this.l != 0) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004247", "0X8004247", 0, 0, ConditionSearchManager.a(this.g) + "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004249", "0X8004249", 0, 0, ConditionSearchManager.a(this.g) + "", "", "", "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.l = getIntent().getIntExtra("param_req_type", 0);
    d(2130837660);
    setContentView(2130903502);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(49));
    g();
    h();
    i();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    super.doOnDestroy();
  }
  
  public void e()
  {
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    String[] arrayOfString = a();
    if (this.l == 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004248", "0X8004248", 0, 0, arrayOfString[0], arrayOfString[1], arrayOfString[2], "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800424A", "0X800424A", 0, 0, arrayOfString[0], arrayOfString[1], arrayOfString[2], "");
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298239: 
      ReportController.b(this.app, "CliOper", "", "", "0X8004246", "0X8004246", 0, 0, "", "", "", "");
      this.jdField_b_of_type_Boolean = true;
      b(new dcj(this));
      return;
    case 2131298240: 
      paramView = new Intent(this, CountrySelectActivity.class);
      paramView.putExtra("key_country_code", this.g);
      if ((this.l == 1) || (this.l == 0)) {
        bool = true;
      }
      paramView.putExtra("key_no_limit_allow", bool);
      startActivityForResult(paramView, 1000);
      return;
    }
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */