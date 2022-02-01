package com.tencent.mobileqq.activity.selectmember;

import aawz;
import aaxa;
import aaxb;
import aayg;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;

public class FriendTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener
{
  private aayg a;
  private PinnedFooterExpandableListView b;
  public boolean bAG = false;
  boolean bAH = false;
  
  public FriendTabView(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = paramSelectMemberActivity;
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    notifyDataSetChanged();
  }
  
  public void notifyDataSetChanged()
  {
    if (this.jdField_a_of_type_Aayg != null) {
      this.jdField_a_of_type_Aayg.cnv();
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131560608);
    this.b = ((PinnedFooterExpandableListView)findViewById(2131366559));
    this.bAG = false;
    if (QLog.isColorLevel()) {
      QLog.d("FriendTabView", 2, "firstUserClicked is " + this.bAG);
    }
    if (!this.bAG) {
      this.b.setFooterEnable(true);
    }
    for (;;)
    {
      this.b.setListener(new aawz(this));
      paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131563251, null);
      this.b.addHeaderView(paramBundle);
      paramBundle.findViewById(2131364028).setOnClickListener(new aaxa(this));
      QLog.d("FriendTabView", 2, "----->onCreate");
      this.jdField_a_of_type_Aayg = new aayg(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.e, this.b, new aaxb(this), true);
      this.b.setAdapter(this.jdField_a_of_type_Aayg);
      this.b.setSelector(2131167595);
      this.b.setGroupIndicator(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getDrawable(2130839740));
      this.b.setOnScrollListener(this.jdField_a_of_type_Aayg);
      paramBundle = (PhoneContactManagerImp)this.e.getManager(11);
      if ((paramBundle != null) && (!paramBundle.Ur()) && (paramBundle.xy() == 8)) {}
      return;
      this.b.setFooterEnable(false);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aayg != null) {
      this.jdField_a_of_type_Aayg.destroy();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.bAH) && (this.e != null))
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.e.getManager(11);
      if (localPhoneContactManagerImp != null)
      {
        int i = localPhoneContactManagerImp.xy();
        if ((i != 8) && (i != 9)) {}
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(0);
      return;
    }
    finally
    {
      this.bAH = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTabView
 * JD-Core Version:    0.7.0.1
 */