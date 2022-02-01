package com.tencent.mobileqq.activity.selectmember;

import abec;
import abec.a;
import android.os.Bundle;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.widget.XListView;

public class TroopDiscussionDiscussion
  extends TroopDiscussionBaseV
  implements abec.a
{
  private XListView J;
  private abec a;
  
  public TroopDiscussionDiscussion(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (paramDiscussionInfo != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("group_uin", paramDiscussionInfo.uin);
      localBundle.putString("group_name", paramDiscussionInfo.discussionName);
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(7, localBundle);
    }
  }
  
  public void be(Bundle paramBundle) {}
  
  public void onCreate(Bundle paramBundle)
  {
    setContentView(2131563073);
    this.J = ((XListView)findViewById(2131382384));
    this.J.setSelector(2131167595);
    this.jdField_a_of_type_Abec = new abec(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this, this.J, this.e, false);
    this.jdField_a_of_type_Abec.Dt(true);
    this.J.setAdapter(this.jdField_a_of_type_Abec);
    this.jdField_a_of_type_Abec.notifyDataSetChanged();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Abec.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionDiscussion
 * JD-Core Version:    0.7.0.1
 */