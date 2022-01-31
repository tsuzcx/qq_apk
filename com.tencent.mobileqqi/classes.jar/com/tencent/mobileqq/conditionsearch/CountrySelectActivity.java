package com.tencent.mobileqq.conditionsearch;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import fqc;
import fqd;
import fqe;
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
  private static final String d = "CountrySelectActivity";
  private static final String e = "0";
  private static final String f = "不限";
  private static final String g = "1";
  private static final String h = "中国";
  private static final String i = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  fqc jdField_a_of_type_Fqc;
  LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  public List a;
  public String c;
  
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
    setContentView(2130903304);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131232033));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131232027));
    setTitle(getString(2131559224));
    Object localObject1 = ((ConditionSearchManager)this.b.getManager(52)).a();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(((List)localObject1).size() + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length());
    this.c = getIntent().getStringExtra("key_country_code");
    if (TextUtils.isEmpty(this.c)) {
      this.c = "0";
    }
    Object localObject2 = getLayoutInflater().inflate(2130903306, null);
    Object localObject3 = new fqe(null);
    ((TextView)((View)localObject2).findViewById(2131232034)).setText("不限");
    ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131232035);
    label329:
    int j;
    if (this.c.equals("0"))
    {
      paramBundle = getResources().getDrawable(2130840344);
      localImageView.setImageDrawable(paramBundle);
      ((View)localObject2).findViewById(2131232013).setVisibility(8);
      ((fqe)localObject3).a = "0";
      ((View)localObject2).setTag(localObject3);
      ((View)localObject2).setOnClickListener(this);
      ((View)localObject2).setContentDescription("不限，触摸两次选中");
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a((View)localObject2);
      localObject2 = getLayoutInflater().inflate(2130903306, null);
      localObject3 = new fqe(null);
      ((TextView)((View)localObject2).findViewById(2131232034)).setText("中国");
      localImageView = (ImageView)((View)localObject2).findViewById(2131232035);
      if (!this.c.equals("0")) {
        break label558;
      }
      paramBundle = getResources().getDrawable(2130840344);
      localImageView.setImageDrawable(paramBundle);
      ((View)localObject2).findViewById(2131232013).setVisibility(8);
      ((fqe)localObject3).a = "1";
      ((View)localObject2).setTag(localObject3);
      ((View)localObject2).setOnClickListener(this);
      ((View)localObject2).setContentDescription("中国，触摸两次选中");
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a((View)localObject2);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", Integer.valueOf(0));
      paramBundle = "#";
      localObject2 = ((List)localObject1).iterator();
      j = 0;
    }
    int k;
    for (;;)
    {
      k = j;
      if (!((Iterator)localObject2).hasNext()) {
        break label650;
      }
      localObject3 = (BaseAddress)((Iterator)localObject2).next();
      if ((!((BaseAddress)localObject3).b.equals("0")) && (!((BaseAddress)localObject3).b.equals("1")))
      {
        k = j;
        localObject1 = paramBundle;
        if (!((BaseAddress)localObject3).d.equals(paramBundle))
        {
          localObject1 = ((BaseAddress)localObject3).d;
          k = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf((String)localObject1);
          for (;;)
          {
            if (j <= k)
            {
              this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(j, j + 1), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()));
              j += 1;
              continue;
              paramBundle = getResources().getDrawable(2130840346);
              break;
              label558:
              paramBundle = getResources().getDrawable(2130840346);
              break label329;
            }
          }
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()));
          paramBundle = new fqd(null);
          paramBundle.a = ((String)localObject1);
          this.jdField_a_of_type_JavaUtilList.add(paramBundle);
          k = j;
        }
        this.jdField_a_of_type_JavaUtilList.add(localObject3);
        j = k;
        paramBundle = (Bundle)localObject1;
      }
    }
    label650:
    while (k < "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length())
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(k, k + 1), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()));
      k += 1;
    }
    this.jdField_a_of_type_Fqc = new fqc(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Fqc);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230734));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setTextView(this.jdField_a_of_type_AndroidWidgetTextView);
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
    if ((paramView instanceof fqe))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_country_code", ((fqe)paramView).a);
      setResult(-1, localIntent);
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.CountrySelectActivity
 * JD-Core Version:    0.7.0.1
 */