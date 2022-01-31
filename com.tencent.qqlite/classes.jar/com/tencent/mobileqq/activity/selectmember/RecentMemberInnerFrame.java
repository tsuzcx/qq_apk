package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.CheckBox;
import android.widget.TextView;
import cmd;
import cme;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentMemberInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, View.OnTouchListener
{
  private cmd jdField_a_of_type_Cmd;
  private FriendsManagerImp jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
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
      Object localObject2 = ((RecentUserProxy)localObject1).b();
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if (localRecentUser != null) {
            try
            {
              if ((localRecentUser.type == 0) && (Long.parseLong(localRecentUser.uin) >= 10000L) && (!localRecentUser.uin.equals(localObject1)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(localRecentUser.uin)))
              {
                Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a(localRecentUser.uin);
                if ((localFriends != null) && (localFriends.isFriend())) {
                  this.jdField_a_of_type_JavaUtilList.add(localRecentUser);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
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
    setContentView(2130903631);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297772));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131427345);
    g();
    this.jdField_a_of_type_Cmd = new cmd(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Cmd);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363983), "最近联系人");
    if (this.jdField_a_of_type_Cmd != null) {
      this.jdField_a_of_type_Cmd.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Cmd != null) {
      this.jdField_a_of_type_Cmd.b();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Cmd.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    cme localcme = (cme)paramView.getTag();
    if ((localcme != null) && (localcme.jdField_a_of_type_JavaLangString != null) && (localcme.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localcme.jdField_a_of_type_AndroidWidgetTextView != null) && (localcme.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localcme.jdField_a_of_type_JavaLangString, localcme.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), 0, "-1");
      localcme.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (localcme.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        paramView.setContentDescription(localcme.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + "已选中");
      }
    }
    else
    {
      return;
    }
    paramView.setContentDescription(localcme.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */