package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import dqs;
import dqt;
import dqv;
import dqz;
import drc;
import drd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SubAccountBindActivity
  extends SubAccountBaseActivity
{
  public static final int a = 1981;
  private static final String jdField_a_of_type_JavaLangString = "Q.subaccount.SubAccountBindActivity";
  public static final int b = 1990;
  public static final int c = 2001;
  Handler jdField_a_of_type_AndroidOsHandler = new dqs(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dqz(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new drd(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new dqt(this);
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new dqv(this);
  private List jdField_a_of_type_JavaUtilList;
  View.OnClickListener b;
  private boolean c = false;
  
  public SubAccountBindActivity()
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new drc(this);
  }
  
  private void h()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  private void i()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  private void j()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject = getAppRuntime().getApplication().getAllAccounts();
      if (localObject == null) {
        break label120;
      }
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject = null;
      label56:
      if (!localIterator.hasNext()) {
        break label109;
      }
      SimpleAccount localSimpleAccount = (SimpleAccount)localIterator.next();
      if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(localSimpleAccount.getUin())) {
        break label143;
      }
      localObject = localSimpleAccount;
    }
    label143:
    for (;;)
    {
      break label56;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label109:
      this.jdField_a_of_type_JavaUtilList.remove(localObject);
      label120:
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.add(null);
      }
      k();
      return;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      View localView;
      if (this.jdField_a_of_type_JavaUtilList.get(i) == null)
      {
        localView = getLayoutInflater().inflate(2130903067, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        ((TextView)localView.findViewById(2131230996)).setText(2131561708);
        localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        localView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
      for (;;)
      {
        i += 1;
        break;
        localView = getLayoutInflater().inflate(2130903068, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        if (i == 0) {
          localView.setBackgroundResource(2130837880);
        }
        localView.setTag(Integer.valueOf(i));
        ((ImageView)localView.findViewById(2131230940)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
    }
    l();
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int i;
    label28:
    Object localObject2;
    SimpleAccount localSimpleAccount;
    do
    {
      do
      {
        return;
        int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        i = 0;
        if (i >= j) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((View)localObject1).getTag();
      } while (localObject2 == null);
      int k = ((Integer)localObject2).intValue();
      localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
    } while (localSimpleAccount == null);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131230940);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131231000);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131231001);
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131231002);
    if (localSimpleAccount.getUin().equals(SubAccountAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface))) {
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      localObject2 = ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localSimpleAccount.getUin());
      localObject1 = localObject2;
      if (localSimpleAccount.isLogined()) {
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals(localSimpleAccount.getUin())) {}
        }
        else
        {
          localObject1 = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(localSimpleAccount.getUin());
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = localSimpleAccount.getUin();
      }
      localTextView1.setText((CharSequence)localObject2);
      localTextView2.setText(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(localSimpleAccount.getUin()));
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(localSimpleAccount.getUin());
      if (localObject1 != null) {
        localImageView.setBackgroundDrawable((Drawable)localObject1);
      }
      i += 1;
      break label28;
      break;
      ((ImageView)localObject1).setVisibility(8);
    }
  }
  
  public void finish()
  {
    e();
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903999);
    setTitle(2131561706);
    j(2130837729);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231007));
    j();
    h();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
  }
  
  protected void onDestroy()
  {
    i();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity
 * JD-Core Version:    0.7.0.1
 */