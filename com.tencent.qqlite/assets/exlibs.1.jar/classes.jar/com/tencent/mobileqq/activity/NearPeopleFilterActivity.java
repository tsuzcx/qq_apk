package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import awe;
import awf;
import awg;
import awh;
import awi;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class NearPeopleFilterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final long a = 20000L;
  static final String jdField_a_of_type_JavaLangString = "NearPeopleFilterActivity";
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 1000;
  private static final int j = 0;
  private static final int k = 1;
  int jdField_a_of_type_Int = 0;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new awi(this);
  Handler jdField_a_of_type_AndroidOsHandler = new awe(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new awf(this);
  private ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new awh(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new awg(this);
  public IphonePickerView a;
  public FormSimpleItem a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public ActionSheet a;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "0", "0", "0", "0" };
  int jdField_b_of_type_Int = 4;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSimpleItem b;
  String jdField_b_of_type_JavaLangString = "不限";
  public int c;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public int d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  int jdField_e_of_type_Int = 0;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  public int i;
  
  public NearPeopleFilterActivity()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    this.i = paramInt;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624119));
    ((DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296499)).a = true;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130903492, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
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
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_d_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("NearPeopleFilterActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  short a()
  {
    Object localObject = (FriendManager)this.app.getManager(8);
    if (localObject == null) {
      return -1;
    }
    localObject = ((FriendManager)localObject).a(this.app.a());
    if (localObject == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearPeopleFilterActivity", 2, "getMyGender.gender=" + ((Card)localObject).shGender);
    }
    return ((Card)localObject).shGender;
  }
  
  protected boolean a()
  {
    super.finish();
    overridePendingTransition(0, 2130968593);
    return false;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
      this.jdField_c_of_type_AndroidViewView.setSelected(false);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
      this.jdField_a_of_type_AndroidViewView.setContentDescription("已选中" + getString(2131362873));
      this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131363200));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131363199));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427469));
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427345));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427345));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838081, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838079, 0, 0, 0);
      if (this.jdField_b_of_type_Int != 1) {
        break label848;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setSelected(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
      this.jdField_e_of_type_AndroidWidgetTextView.setSelected(false);
      this.f.setSelected(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("已选中" + getString(2131364427));
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364428));
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364429));
      this.f.setContentDescription(getString(2131362873));
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427469));
      this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427345));
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427345));
      this.f.setBackgroundColor(getResources().getColor(2131427345));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(NearPeopleFilterActivity.NearPeopleFilters.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(NearPeopleFilterActivity.NearPeopleFilters.b[this.jdField_d_of_type_Int]);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(com.tencent.mobileqq.util.NearbyProfileUtil.d[this.jdField_e_of_type_Int]);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(Integer.valueOf(this.jdField_e_of_type_Int));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_b_of_type_JavaLangString);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(this.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("年龄" + NearPeopleFilterActivity.NearPeopleFilters.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("星座" + NearPeopleFilterActivity.NearPeopleFilters.b[this.jdField_d_of_type_Int]);
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidViewView.setSelected(false);
        this.jdField_c_of_type_AndroidViewView.setSelected(false);
        this.jdField_b_of_type_AndroidViewView.setSelected(true);
        this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131362873));
        this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131363200));
        this.jdField_b_of_type_AndroidViewView.setContentDescription("已选中" + getString(2131363199));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838082, 0, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838079, 0, 0, 0);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427345));
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427345));
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427469));
        break;
      }
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setSelected(false);
      this.jdField_c_of_type_AndroidViewView.setSelected(true);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131362873));
      this.jdField_c_of_type_AndroidViewView.setContentDescription("已选中" + getString(2131363200));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131363199));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838081, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838080, 0, 0, 0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427345));
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427469));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427345));
      break;
      label848:
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setSelected(true);
        this.jdField_e_of_type_AndroidWidgetTextView.setSelected(false);
        this.f.setSelected(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364427));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription("已选中" + getString(2131364428));
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364429));
        this.f.setContentDescription(getString(2131362873));
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427345));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427469));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427345));
        this.f.setBackgroundColor(getResources().getColor(2131427345));
      }
      else if (this.jdField_b_of_type_Int == 3)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setSelected(true);
        this.f.setSelected(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364427));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364428));
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription("已选中" + getString(2131364429));
        this.f.setContentDescription(getString(2131362873));
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427345));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427345));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427469));
        this.f.setBackgroundColor(getResources().getColor(2131427345));
      }
      else if ((this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 0))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setSelected(false);
        this.f.setSelected(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364427));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364428));
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364429));
        this.f.setContentDescription("已选中" + getString(2131362873));
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427345));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427345));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427345));
        this.f.setBackgroundColor(getResources().getColor(2131427469));
      }
    }
  }
  
  public void d()
  {
    Intent localIntent = new Intent(this, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 1);
    int m = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (m != 0)
    {
      m = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(m);
      if (QLog.isColorLevel()) {
        QLog.d("NearPeopleFilterActivity", 2, "startLocationSelectActivity | update result = " + m);
      }
      if (m == 2)
      {
        QQToast.a(this, 2131363516, 0).b(getTitleBarHeight());
        return;
      }
      if (m == 0)
      {
        a(getString(2131364393));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(getString(2131364393));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    String[] arrayOfString2 = (String[])this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag();
    String[] arrayOfString1;
    if (arrayOfString2 != null)
    {
      arrayOfString1 = arrayOfString2;
      if (arrayOfString2.length == 4) {}
    }
    else
    {
      arrayOfString1 = new String[4];
      arrayOfString1[0] = "0";
      arrayOfString1[1] = "0";
      arrayOfString1[2] = "0";
      arrayOfString1[3] = "0";
    }
    localIntent.putExtra("param_location", arrayOfString1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(arrayOfString1));
    startActivityForResult(localIntent, 1);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      localObject = paramIntent.getStringExtra("param_name");
      paramInt1 = paramIntent.getIntExtra("param_id", -1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      this.jdField_e_of_type_Int = paramInt1;
      return;
    } while (paramInt2 != -1);
    Object localObject = paramIntent.getStringArrayExtra("param_location");
    paramIntent = paramIntent.getStringExtra("param_location_param");
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(localObject);
    this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
    this.jdField_b_of_type_JavaLangString = paramIntent;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.setTheme(2131624267);
    super.doOnCreate(paramBundle);
    super.setContentView(2130903508);
    super.setTitle(2131364469);
    super.setRightButton(2131363433, this);
    findViewById(2131296897).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298317);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298315);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131298313);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298316));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298314));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298319));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298320));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298321));
    this.f = ((TextView)findViewById(2131298322));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298100));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131297252));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131297354));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298311));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(49));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    paramBundle = NearPeopleFilterActivity.NearPeopleFilters.a(this, this.app.a());
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.i;
      this.jdField_b_of_type_Int = paramBundle.j;
      this.jdField_c_of_type_Int = paramBundle.k;
      this.jdField_d_of_type_Int = paramBundle.l;
      this.jdField_e_of_type_Int = paramBundle.m;
      this.jdField_a_of_type_ArrayOfJavaLangString = paramBundle.c;
      this.jdField_b_of_type_JavaLangString = paramBundle.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      c();
      return true;
      if (a() == 0) {
        this.jdField_a_of_type_Int = 2;
      } else {
        this.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298100: 
      this.i = 0;
      a(this.i);
      return;
    case 2131297252: 
      this.i = 1;
      a(this.i);
      return;
    case 2131296901: 
      paramView = new Intent();
      paramView.putExtra("gender", this.jdField_a_of_type_Int);
      paramView.putExtra("time", this.jdField_b_of_type_Int);
      paramView.putExtra("age", this.jdField_c_of_type_Int);
      paramView.putExtra("xingzuo", this.jdField_d_of_type_Int);
      paramView.putExtra("key_career", this.jdField_e_of_type_Int);
      paramView.putExtra("key_hometown_country", this.jdField_a_of_type_ArrayOfJavaLangString[0]);
      paramView.putExtra("key_hometown_province", this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      paramView.putExtra("key_hometown_city", this.jdField_a_of_type_ArrayOfJavaLangString[2]);
      paramView.putExtra("key_hometown_string", this.jdField_b_of_type_JavaLangString);
      setResult(-1, paramView);
      super.finish();
      overridePendingTransition(0, 2130968593);
      paramView = new NearPeopleFilterActivity.NearPeopleFilters();
      paramView.i = this.jdField_a_of_type_Int;
      paramView.j = this.jdField_b_of_type_Int;
      paramView.k = this.jdField_c_of_type_Int;
      paramView.l = this.jdField_d_of_type_Int;
      paramView.m = this.jdField_e_of_type_Int;
      paramView.c = this.jdField_a_of_type_ArrayOfJavaLangString;
      paramView.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      NearPeopleFilterActivity.NearPeopleFilters.a(this, this.app.a(), paramView);
      return;
    case 2131298317: 
      this.jdField_a_of_type_Int = 0;
      c();
      return;
    case 2131298315: 
      this.jdField_a_of_type_Int = 1;
      c();
      return;
    case 2131298313: 
      this.jdField_a_of_type_Int = 2;
      c();
      return;
    case 2131298319: 
      this.jdField_b_of_type_Int = 1;
      c();
      return;
    case 2131298320: 
      this.jdField_b_of_type_Int = 2;
      c();
      return;
    case 2131298321: 
      this.jdField_b_of_type_Int = 3;
      c();
      return;
    case 2131298322: 
      this.jdField_b_of_type_Int = 4;
      c();
      return;
    case 2131297354: 
      paramView = new Intent(this, JobSelectionActivity.class);
      if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag() instanceof Integer))) {
        paramView.putExtra("param_id", (Integer)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag());
      }
      paramView.putExtra("param_need_no_limit", true);
      startActivityForResult(paramView, 2);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearPeopleFilterActivity
 * JD-Core Version:    0.7.0.1
 */