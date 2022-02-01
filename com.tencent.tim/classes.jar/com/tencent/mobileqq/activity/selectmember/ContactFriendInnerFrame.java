package com.tencent.mobileqq.activity.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;

public class ContactFriendInnerFrame
  extends SelectMemberInnerFrame
  implements TabBarView.a
{
  public TroopDiscussionBaseV a;
  private TroopDiscussionBaseV b;
  private FrameLayout bg;
  private TroopDiscussionBaseV c;
  private TabBarView e;
  
  public ContactFriendInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ContactFriendInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContactFriendInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(TroopDiscussionBaseV paramTroopDiscussionBaseV)
  {
    BaseActivity localBaseActivity = (BaseActivity)getActivity();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV != paramTroopDiscussionBaseV)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV != null)
      {
        if (localBaseActivity.isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.onPause();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.onStop();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV = paramTroopDiscussionBaseV;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.be(null);
        if (localBaseActivity.isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.onResume();
        }
        this.bg.removeAllViews();
        this.bg.addView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV);
      }
    }
  }
  
  private void czP()
  {
    if (this.b == null)
    {
      this.b = new PhoneContactTabView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this);
      this.b.onCreate(null);
    }
    a(this.b);
  }
  
  private void czQ()
  {
    if (this.c == null)
    {
      this.c = new FriendTabView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      this.c.onCreate(null);
    }
    a(this.c);
  }
  
  public ContactSearchFragment a()
  {
    return null;
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719436), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mTitleString);
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV instanceof FriendTabView)) {
      ((FriendTabView)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV).notifyDataSetChanged();
    }
    while (!(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV instanceof PhoneContactTabView)) {
      return;
    }
    ((PhoneContactTabView)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV).notifyDataSetChanged();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramInt2 == -1)) {
      ((PhoneContactTabView)this.b).showListView();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    setContentView(2131560611);
    this.e = ((TabBarView)findViewById(2131379139));
    this.e.setOnTabChangeListener(this);
    this.e.a(0, paramBundle.getString(2131692079));
    this.e.b(0).setContentDescription("已选定" + paramBundle.getString(2131692079));
    this.e.a(1, paramBundle.getString(2131692080));
    this.e.b(1).setContentDescription(paramBundle.getString(2131692080));
    this.bg = ((FrameLayout)findViewById(2131369269));
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.onDestroy();
    }
    if (this.b != null) {
      this.b.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      czP();
      return;
    }
    czQ();
  }
  
  public String qN()
  {
    return "-1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ContactFriendInnerFrame
 * JD-Core Version:    0.7.0.1
 */