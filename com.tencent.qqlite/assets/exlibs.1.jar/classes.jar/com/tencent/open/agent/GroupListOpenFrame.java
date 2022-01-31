package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.base.LogUtility;
import com.tencent.widget.XListView;
import fbo;

public class GroupListOpenFrame
  extends OpenFrame
{
  protected static final String a = "GroupListOpenFrame";
  protected EditText a;
  protected TextView a;
  protected GroupListOpenFrame.GroupListAdapter a;
  protected RecommendListManager a;
  protected XListView a;
  protected TextView b;
  
  public GroupListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.b();
    LogUtility.c("GroupListOpenFrame", "-->onResume()");
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    LogUtility.c("GroupListOpenFrame", "-->onCreate()");
    super.setContentView(2130903631);
    this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter = new GroupListOpenFrame.GroupListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131297772));
    paramBundle = (LinearLayout)super.a().getLayoutInflater().inflate(2130903287, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131297521));
    this.b = ((TextView)paramBundle.findViewById(2131297528));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager = ((RecommendListManager)paramBundle.findViewById(2131297522));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setActivity(this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser);
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131427345);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131297957));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new fbo(this));
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    LogUtility.c("GroupListOpenFrame", "-->onStart()");
    this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.a(false, true, "", this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.getString(2131362122));
  }
  
  public void f()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame
 * JD-Core Version:    0.7.0.1
 */