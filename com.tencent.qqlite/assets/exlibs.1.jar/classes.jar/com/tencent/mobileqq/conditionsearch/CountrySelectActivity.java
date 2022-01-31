package com.tencent.mobileqq.conditionsearch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import dax;
import day;
import daz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class CountrySelectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  public static final String a = "key_country_code";
  static final boolean jdField_a_of_type_Boolean = true;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  public static final String b = "0";
  public static final String c = "key_no_limit_allow";
  private static final String e = "CountrySelectActivity";
  private static final String f = "0";
  private static final String g = "不限";
  private static final String h = "1";
  private static final String i = "中国";
  private static final String j = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  dax jdField_a_of_type_Dax;
  LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  public List a;
  boolean b = true;
  public String d;
  
  public void a(String paramString)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CountrySelectActivity", 2, "onIndexChanged | c = " + paramString + " | i = " + localInteger);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(localInteger.intValue());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903258);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131297407));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131297399));
    setTitle("国家");
    Object localObject1 = ((ConditionSearchManager)this.app.getManager(49)).a();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(((List)localObject1).size() + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length());
    this.d = getIntent().getStringExtra("key_country_code");
    if (TextUtils.isEmpty(this.d)) {
      this.d = "0";
    }
    this.b = getIntent().getBooleanExtra("key_no_limit_allow", false);
    Object localObject2;
    Object localObject3;
    int k;
    if (this.b)
    {
      paramBundle = getLayoutInflater().inflate(2130903260, null);
      localObject2 = new daz(null);
      ((TextView)paramBundle.findViewById(2131297408)).setText("不限");
      localObject3 = paramBundle.findViewById(2131297409);
      if (this.d.equals("0"))
      {
        k = 0;
        ((View)localObject3).setVisibility(k);
        paramBundle.findViewById(2131297385).setVisibility(8);
        ((daz)localObject2).a = "0";
        paramBundle.setTag(localObject2);
        paramBundle.setOnClickListener(this);
        paramBundle.setContentDescription("不限");
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(paramBundle);
      }
    }
    else
    {
      paramBundle = getLayoutInflater().inflate(2130903260, null);
      localObject2 = new daz(null);
      ((TextView)paramBundle.findViewById(2131297408)).setText("中国");
      localObject3 = paramBundle.findViewById(2131297409);
      if (!this.d.equals("1")) {
        break label527;
      }
      k = 0;
      label312:
      ((View)localObject3).setVisibility(k);
      paramBundle.findViewById(2131297385).setVisibility(8);
      ((daz)localObject2).a = "1";
      paramBundle.setTag(localObject2);
      paramBundle.setOnClickListener(this);
      paramBundle.setContentDescription("中国");
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(paramBundle);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", Integer.valueOf(0));
      paramBundle = "#";
      localObject2 = ((List)localObject1).iterator();
      k = 0;
    }
    int m;
    for (;;)
    {
      m = k;
      if (!((Iterator)localObject2).hasNext()) {
        break label611;
      }
      localObject3 = (BaseAddress)((Iterator)localObject2).next();
      if ((!((BaseAddress)localObject3).b.equals("0")) && (!((BaseAddress)localObject3).b.equals("1")))
      {
        m = k;
        localObject1 = paramBundle;
        if (!((BaseAddress)localObject3).d.equals(paramBundle))
        {
          localObject1 = ((BaseAddress)localObject3).d;
          m = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf((String)localObject1);
          for (;;)
          {
            if (k <= m)
            {
              this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(k, k + 1), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()));
              k += 1;
              continue;
              k = 8;
              break;
              label527:
              k = 8;
              break label312;
            }
          }
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()));
          paramBundle = new day(null);
          paramBundle.a = ((String)localObject1);
          this.jdField_a_of_type_JavaUtilList.add(paramBundle);
          m = k;
        }
        this.jdField_a_of_type_JavaUtilList.add(localObject3);
        k = m;
        paramBundle = (Bundle)localObject1;
      }
    }
    label611:
    while (m < "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length())
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(m, m + 1), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()));
      m += 1;
    }
    this.jdField_a_of_type_Dax = new dax(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Dax);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof daz))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_country_code", ((daz)paramView).a);
      setResult(-1, localIntent);
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.CountrySelectActivity
 * JD-Core Version:    0.7.0.1
 */