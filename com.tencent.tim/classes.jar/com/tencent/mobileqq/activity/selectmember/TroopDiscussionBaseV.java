package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class TroopDiscussionBaseV
  extends FrameLayout
{
  public InnerFrameManager a;
  public SelectMemberActivity a;
  protected Context context;
  public QQAppInterface e;
  protected LayoutInflater mLayoutInflater;
  
  public TroopDiscussionBaseV(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    this.e = paramSelectMemberActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = paramSelectMemberActivity;
    this.context = paramSelectMemberActivity;
    this.mLayoutInflater = paramSelectMemberActivity.getLayoutInflater();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = paramSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager;
  }
  
  public void be(Bundle paramBundle) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  protected void onDestroy() {}
  
  protected void onPause() {}
  
  protected void onResume() {}
  
  protected void onStop() {}
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionBaseV
 * JD-Core Version:    0.7.0.1
 */