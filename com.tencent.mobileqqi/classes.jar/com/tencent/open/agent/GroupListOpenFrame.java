package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.base.LogUtility;
import com.tencent.widget.XListView;
import hjf;

public class GroupListOpenFrame
  extends OpenFrame
{
  protected static final String a;
  protected EditText a;
  protected TextView a;
  protected GroupListOpenFrame.GroupListAdapter a;
  protected RecommendListManager a;
  protected XListView a;
  protected TextView b;
  
  static
  {
    jdField_a_of_type_JavaLangString = GroupListOpenFrame.class.getName();
  }
  
  public GroupListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.b();
    LogUtility.c(jdField_a_of_type_JavaLangString, "-->onResume()");
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    LogUtility.c(jdField_a_of_type_JavaLangString, "-->onCreate()");
    super.setContentView(2130903975);
    this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter = new GroupListOpenFrame.GroupListAdapter(this);
    f();
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    LogUtility.c(jdField_a_of_type_JavaLangString, "-->onStart()");
    this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.a(false, true, "", this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.getString(2131560032));
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131232611));
    LinearLayout localLinearLayout = (LinearLayout)super.a().getLayoutInflater().inflate(2130903344, null);
    localLinearLayout.findViewById(2131233085).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localLinearLayout.findViewById(2131232170));
    this.b = ((TextView)localLinearLayout.findViewById(2131232177));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager = ((RecommendListManager)localLinearLayout.findViewById(2131232171));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setActivity(this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser);
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131361815);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localLinearLayout.findViewById(2131233086));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new hjf(this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame
 * JD-Core Version:    0.7.0.1
 */