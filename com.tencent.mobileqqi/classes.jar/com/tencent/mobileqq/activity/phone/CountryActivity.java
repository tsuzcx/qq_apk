package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.FakeTextView;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import ekz;
import ela;
import elb;
import elc;
import eld;
import elf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class CountryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "k_name";
  public static final String b = "k_code";
  View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private elb jdField_a_of_type_Elb;
  public elf a;
  public ArrayList a;
  public LinkedHashMap a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  View b;
  private View c;
  
  public CountryActivity()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  public static void a(View paramView, elc paramelc)
  {
    paramView = (eld)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramelc.b);
    paramView.b.setText("+" + paramelc.c);
    paramView.jdField_a_of_type_Elc = paramelc;
  }
  
  private static View b(LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903308, null);
    if (paramBoolean) {
      paramLayoutInflater.setPadding(paramLayoutInflater.getPaddingLeft(), paramLayoutInflater.getPaddingTop(), (int)DisplayUtils.a(BaseApplicationImpl.a, 40.0F), paramLayoutInflater.getPaddingBottom());
    }
    eld localeld = new eld(null);
    localeld.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131232036));
    localeld.b = ((TextView)paramLayoutInflater.findViewById(2131232015));
    paramLayoutInflater.setTag(localeld);
    return paramLayoutInflater;
  }
  
  private void d()
  {
    this.jdField_a_of_type_Elf = new elf(this, this);
    this.jdField_a_of_type_Elf.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_Elf.show();
    this.jdField_a_of_type_Elf.setOnDismissListener(new ela(this));
  }
  
  public void a(View paramView)
  {
    paramView = (eld)paramView.getTag();
    if (paramView.jdField_a_of_type_Elc != null)
    {
      if ((this.jdField_a_of_type_Elf != null) && (this.jdField_a_of_type_Elf.isShowing())) {
        this.jdField_a_of_type_Elf.dismiss();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.jdField_a_of_type_Elc.b);
      localIntent.putExtra("k_code", paramView.jdField_a_of_type_Elc.c);
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
    setContentView(2130903306);
    this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131689519);
    paramBundle = this.jdField_a_of_type_ArrayOfJavaLangString;
    Object localObject1 = getResources().getStringArray(2131689518);
    String[] arrayOfString = getResources().getStringArray(2131689517);
    Object localObject2 = getResources().getStringArray(2131689516);
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
    elc localelc;
    if (i < j)
    {
      localelc = new elc(arrayOfString[i]);
      localObject1 = localelc.a;
      if (paramBundle.equals(localObject1)) {
        break label630;
      }
      ((ArrayList)localObject2).add(new elc((String)localObject1));
      paramBundle = (Bundle)localObject1;
    }
    label625:
    label630:
    for (;;)
    {
      ((ArrayList)localObject2).add(localelc);
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
          break label625;
        }
      }
      for (j = j + i + 1;; j = i)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(i));
        i = j;
        break;
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        setTitle(getResources().getString(2131558970));
        this.k.setText(2131561692);
        this.jdField_a_of_type_AndroidViewView = new FakeTextView(this);
        this.b = new FakeTextView(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131232035));
        this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903944, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        this.c.setPadding(0, 0, 40, 0);
        this.c.findViewById(2131233085).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131233086));
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
        this.jdField_a_of_type_Elb = new elb(this, null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Elb);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131232029));
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(this.jdField_a_of_type_ArrayOfJavaLangString, true);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230734));
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setTextView(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
        ChnToSpell.a(this);
        return true;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      this.jdField_a_of_type_Elf = new elf(this, this);
      this.jdField_a_of_type_Elf.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_Elf.show();
      this.jdField_a_of_type_Elf.setOnDismissListener(new ekz(this));
      return;
    }
    a(paramView);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      d();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    MenuItem localMenuItem = paramMenu.add(0, 0, 0, getString(2131562830));
    localMenuItem.setIcon(2130839698);
    MenuItemCompat.setShowAsAction(localMenuItem, 1);
    return super.onPrepareOptionsMenu(paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity
 * JD-Core Version:    0.7.0.1
 */