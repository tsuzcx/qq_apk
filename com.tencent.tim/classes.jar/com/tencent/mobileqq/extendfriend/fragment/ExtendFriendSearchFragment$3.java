package com.tencent.mobileqq.extendfriend.fragment;

import afsi;
import afvv;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendMultiLinesTagsView;
import java.util.ArrayList;
import java.util.List;

class ExtendFriendSearchFragment$3
  implements Runnable
{
  ExtendFriendSearchFragment$3(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void run()
  {
    ExtendFriendSearchFragment localExtendFriendSearchFragment;
    if ((this.this$0.mActivity != null) && (!this.this$0.mActivity.isFinishing()) && (this.this$0.isAdded()) && (this.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView != null))
    {
      List localList = this.this$0.jdField_a_of_type_Afsi.a().eP();
      this.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setSearchTags((ArrayList)localList);
      localExtendFriendSearchFragment = this.this$0;
      if (localList.size() <= 0) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      ExtendFriendSearchFragment.a(localExtendFriendSearchFragment, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment.3
 * JD-Core Version:    0.7.0.1
 */