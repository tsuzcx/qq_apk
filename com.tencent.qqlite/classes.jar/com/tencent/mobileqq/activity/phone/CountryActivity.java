package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import chd;
import che;
import chf;
import chg;
import chh;
import chi;
import chk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class CountryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  public static final String a = "k_name";
  public static final String b = "k_code";
  public View a;
  private chg jdField_a_of_type_Chg;
  public chk a;
  public IndexView a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList a;
  public LinkedHashMap a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public View b;
  
  public CountryActivity()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  public static void a(View paramView, chh paramchh)
  {
    paramView = (chi)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramchh.b);
    paramView.b.setText("+" + paramchh.c);
    paramView.jdField_a_of_type_Chh = paramchh;
  }
  
  private static View b(LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903260, null);
    if (paramBoolean) {
      paramLayoutInflater.setPadding(paramLayoutInflater.getPaddingLeft(), paramLayoutInflater.getPaddingTop(), (int)DisplayUtils.a(BaseApplicationImpl.a, 40.0F), paramLayoutInflater.getPaddingBottom());
    }
    chi localchi = new chi(null);
    localchi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131297404));
    localchi.b = ((TextView)paramLayoutInflater.findViewById(2131297381));
    paramLayoutInflater.setTag(localchi);
    return paramLayoutInflater;
  }
  
  public void a(View paramView)
  {
    paramView = (chi)paramView.getTag();
    if (paramView.jdField_a_of_type_Chh != null)
    {
      if ((this.jdField_a_of_type_Chk != null) && (this.jdField_a_of_type_Chk.isShowing())) {
        this.jdField_a_of_type_Chk.dismiss();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.jdField_a_of_type_Chh.b);
      localIntent.putExtra("k_code", paramView.jdField_a_of_type_Chh.c);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    PinnedDividerListView localPinnedDividerListView = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k();
    localPinnedDividerListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString)).intValue() + i);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903258);
    this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131230751);
    paramBundle = this.jdField_a_of_type_ArrayOfJavaLangString;
    Object localObject1 = getResources().getStringArray(2131230750);
    String[] arrayOfString = getResources().getStringArray(2131230749);
    Object localObject2 = getResources().getStringArray(2131230748);
    paramBundle = new String[this.jdField_a_of_type_ArrayOfJavaLangString.length + arrayOfString.length];
    System.arraycopy(arrayOfString, 0, paramBundle, 0, arrayOfString.length);
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangString, 0, paramBundle, arrayOfString.length, this.jdField_a_of_type_ArrayOfJavaLangString.length);
    arrayOfString = new String[localObject1.length + localObject2.length];
    System.arraycopy(localObject2, 0, arrayOfString, 0, localObject2.length);
    System.arraycopy(localObject1, 0, arrayOfString, localObject2.length, localObject1.length);
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = paramBundle[i];
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(0));
      i += 1;
    }
    localObject2 = new ArrayList(paramBundle.length);
    paramBundle = "#";
    j = arrayOfString.length;
    i = 0;
    chh localchh;
    if (i < j)
    {
      localchh = new chh(arrayOfString[i]);
      localObject1 = localchh.a;
      if (paramBundle.equals(localObject1)) {
        break label537;
      }
      ((ArrayList)localObject2).add(new chh((String)localObject1));
      paramBundle = (Bundle)localObject1;
    }
    label532:
    label537:
    for (;;)
    {
      ((ArrayList)localObject2).add(localchh);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).intValue() + 1));
      i += 1;
      break;
      paramBundle = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      i = 0;
      if (paramBundle.hasNext())
      {
        localObject1 = (String)paramBundle.next();
        j = ((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).intValue();
        if (j == 0) {
          break label532;
        }
      }
      for (j = j + i + 1;; j = i)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(i));
        i = j;
        break;
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        setTitle("选择国家和地区");
        this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131296890).getParent());
        this.b = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131297403));
        this.p.setImageResource(2130838043);
        this.p.setContentDescription("搜索");
        this.p.setVisibility(0);
        this.p.setOnClickListener(this);
        this.jdField_a_of_type_Chg = new chg(this, null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Chg);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131297395));
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(this.jdField_a_of_type_ArrayOfJavaLangString, true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
        ChnToSpell.a(this);
        return true;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.p)
    {
      this.jdField_a_of_type_Chk = new chk(this, this);
      this.jdField_a_of_type_Chk.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      paramView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
      paramView.setDuration(300L);
      paramView.setFillAfter(true);
      paramView.setAnimationListener(new chd(this));
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new che(this, i));
      this.jdField_a_of_type_Chk.setOnDismissListener(new chf(this, i, localTranslateAnimation));
      this.b.startAnimation(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity
 * JD-Core Version:    0.7.0.1
 */