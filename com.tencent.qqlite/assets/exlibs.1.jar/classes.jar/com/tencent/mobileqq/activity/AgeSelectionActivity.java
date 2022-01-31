package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import xw;
import xx;

public class AgeSelectionActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "param_age";
  public static final String b = "param_constellation_id";
  public static final String c = "param_constellation";
  static final int d = 1895;
  public static final String d = "param_year";
  static final int e = 1990;
  public static final String e = "param_month";
  public static final String f = "param_day";
  public static final String g = "param_birthday";
  byte jdField_a_of_type_Byte;
  public int a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new xw(this);
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private xx jdField_a_of_type_Xx;
  int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  int c;
  public int f;
  public int g;
  public int h;
  String h;
  int i;
  
  public AgeSelectionActivity()
  {
    this.jdField_a_of_type_Int = 2014;
  }
  
  public static int a(String paramString)
  {
    return Arrays.asList(NearbyProfileUtil.c).indexOf(paramString);
  }
  
  private void c()
  {
    this.i = (this.jdField_a_of_type_Int - (this.f + 1895));
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, this.g + 1, this.jdField_h_of_type_Int + 1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, this.jdField_b_of_type_Int, this.c);
    if (!localCalendar1.before(localCalendar2)) {
      this.i -= 1;
    }
    if (this.i < 0) {
      this.i = 0;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.i + "岁");
    this.jdField_h_of_type_JavaLangString = Utils.a(this.g + 1, this.jdField_h_of_type_Int + 1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
  }
  
  protected boolean a()
  {
    this.f = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    this.g = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
    this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
    c();
    Intent localIntent = new Intent();
    localIntent.putExtra("param_age", this.i);
    localIntent.putExtra("param_constellation_id", a(this.jdField_h_of_type_JavaLangString));
    localIntent.putExtra("param_constellation", this.jdField_h_of_type_JavaLangString);
    localIntent.putExtra("param_year", (short)(this.f + 1895));
    localIntent.putExtra("param_month", (byte)(this.g + 1));
    localIntent.putExtra("param_day", (byte)(this.jdField_h_of_type_Int + 1));
    setResult(-1, localIntent);
    return super.a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903460);
    setTitle("选择出生日期");
    setLeftViewName(2131364492);
    paramBundle = Calendar.getInstance();
    paramBundle.setTimeInMillis(System.currentTimeMillis());
    this.jdField_a_of_type_Int = paramBundle.get(1);
    this.jdField_b_of_type_Int = (paramBundle.get(2) + 1);
    this.c = paramBundle.get(5);
    int j = getIntent().getIntExtra("param_birthday", 0);
    if (j == 0)
    {
      this.f = 95;
      this.g = 0;
    }
    for (this.jdField_h_of_type_Int = 0;; this.jdField_h_of_type_Int = ((j & 0xFF) - 1))
    {
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      j = getResources().getColor(2131427505);
      findViewById(2131298102).setBackgroundColor(j);
      j = getResources().getColor(2131427504);
      findViewById(2131297573).setBackgroundColor(j);
      findViewById(2131297574).setBackgroundColor(j);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298100));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298101));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)findViewById(2131298103));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(getResources().getColor(2131427486));
      this.jdField_a_of_type_Xx = new xx(this, null);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Xx);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.f);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.g);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.jdField_h_of_type_Int);
      c();
      return true;
      this.f = ((j >>> 16) - 1895);
      this.g = (((0xFF00 & j) >>> 8) - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity
 * JD-Core Version:    0.7.0.1
 */