package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.widget.XListView;
import euw;
import eux;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentMemberInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, View.OnTouchListener
{
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FriendsManagerImp jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private euw jdField_a_of_type_Euw;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public RecentMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localObject1 != null)
    {
      Object localObject2 = ((RecentUserProxy)localObject1).a();
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if ((localRecentUser != null) && (localRecentUser.type == 0) && (Long.parseLong(localRecentUser.uin) >= 10000L) && (!localRecentUser.uin.equals(localObject1)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(localRecentUser.uin)))
          {
            Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a(localRecentUser.uin);
            if ((localFriends != null) && (localFriends.isFriend())) {
              this.jdField_a_of_type_JavaUtilList.add(localRecentUser);
            }
          }
        }
      }
    }
  }
  
  public String a()
  {
    return "-1";
  }
  
  public List a()
  {
    return ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1)).a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903973);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232609));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131361815);
    paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130903942, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131233085));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)paramBundle.findViewById(2131233084)).setVisibility(8);
    g();
    this.jdField_a_of_type_Euw = new euw(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Euw);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131561693), getResources().getString(2131559022));
    if (this.jdField_a_of_type_Euw != null) {
      this.jdField_a_of_type_Euw.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Euw != null) {
      this.jdField_a_of_type_Euw.b();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Euw.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    eux localeux = (eux)paramView.getTag();
    if ((localeux != null) && (localeux.jdField_a_of_type_JavaLangString != null) && (localeux.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localeux.jdField_a_of_type_AndroidWidgetTextView != null) && (localeux.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localeux.jdField_a_of_type_JavaLangString, localeux.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), 0, "-1");
      localeux.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (localeux.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        paramView.setContentDescription(localeux.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + "已选中,双击取消");
      }
    }
    else
    {
      return;
    }
    paramView.setContentDescription(localeux.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + "未选中,双击选中");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */