package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.base.LogUtility;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import hni;
import hnj;

public class FriendListOpenFrame
  extends OpenFrame
  implements View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, ImageLoader.ImageLoadListener, AdapterView.OnItemClickListener
{
  protected static final int a = 1;
  protected static final String a;
  protected static final int b = 2;
  protected static final int c = 3;
  protected Handler a;
  protected EditText a;
  public LinearLayout a;
  protected IndexView a;
  public PinnedDividerListView a;
  public FriendListOpenFrame.FriendListAdapter a;
  protected String b;
  protected int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = FriendListOpenFrame.class.getName();
  }
  
  public FriendListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new hni(this);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    super.setContentView(2130903951);
    f();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()))) && (!this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.a))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FriendListOpenFrame.ViewHolder)paramView.getTag();
    if ((paramAdapterView != null) && (paramAdapterView.a != null))
    {
      paramInt -= this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k();
      if (paramInt >= 0) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      paramView = (Friend)this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter.getItem(paramInt);
    } while (paramView == null);
    this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.a(paramView);
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramView.jdField_a_of_type_JavaLangString))
    {
      paramAdapterView.a.setChecked(true);
      return;
    }
    paramAdapterView.a.setChecked(false);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k());
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "-->onImageLoaded() url = " + paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new hnj(this, paramString, paramBitmap));
  }
  
  public void b(Bundle paramBundle)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "-->onStart()");
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    this.d = paramBundle.getInt("group_index");
    this.b = paramBundle.getString("group_name");
    this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.a(true, false, this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.getString(2131561693), this.b);
    if (this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter = new FriendListOpenFrame.FriendListAdapter(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter.b();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131234428));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131234429));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131361815);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.getLayoutInflater().inflate(2130903942, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233085));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233084)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter.notifyDataSetChanged();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.g();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.FriendListOpenFrame
 * JD-Core Version:    0.7.0.1
 */