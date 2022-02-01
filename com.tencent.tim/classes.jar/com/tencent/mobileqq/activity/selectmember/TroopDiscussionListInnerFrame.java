package com.tencent.mobileqq.activity.selectmember;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;

public class TroopDiscussionListInnerFrame
  extends SelectMemberInnerFrame
  implements TabBarView.a
{
  private TroopDiscussionBaseV a;
  private FrameLayout bg;
  private TroopDiscussionBaseV d;
  private TroopDiscussionBaseV jdField_e_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV;
  private TabBarView jdField_e_of_type_ComTencentMobileqqWidgetTabBarView;
  
  public TroopDiscussionListInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TroopDiscussionListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopDiscussionListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  public ContactSearchFragment a()
  {
    int i = 1;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAN)
    {
      i = 4194309;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAK) {
        i = 4194565;
      }
    }
    return ContactSearchFragment.a(-1, i | 0x8 | 0x200000 | 0x10, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAR) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719436), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719465));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.QG())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.bVm();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bNU();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(true, "", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719465));
    }
  }
  
  public void cAo()
  {
    if (this.d == null)
    {
      this.d = new TroopDiscussionTroop(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      this.d.onCreate(null);
    }
    a(this.d);
  }
  
  public void cAp()
  {
    if (this.jdField_e_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV == null)
    {
      this.jdField_e_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV = new TroopDiscussionDiscussion(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      this.jdField_e_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.onCreate(null);
    }
    a(this.jdField_e_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV);
  }
  
  public void notifyDataSetChanged() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    setContentView(2131560611);
    this.jdField_e_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131379139));
    this.jdField_e_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetTabBarView.a(0, paramBundle.getString(2131692098));
    this.jdField_e_of_type_ComTencentMobileqqWidgetTabBarView.b(0).setContentDescription(acfp.m(2131715643) + paramBundle.getString(2131692098));
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAM)
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetTabBarView.a(1, paramBundle.getString(2131692095));
      this.jdField_e_of_type_ComTencentMobileqqWidgetTabBarView.b(1).setContentDescription(paramBundle.getString(2131692095));
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
    this.bg = ((FrameLayout)findViewById(2131369269));
    this.jdField_e_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
  }
  
  public void onDestroy()
  {
    if (this.d != null) {
      this.d.onDestroy();
    }
    if (this.jdField_e_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV != null) {
      this.jdField_e_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      cAo();
      return;
    }
    cAp();
  }
  
  public String qN()
  {
    return "-1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionListInnerFrame
 * JD-Core Version:    0.7.0.1
 */