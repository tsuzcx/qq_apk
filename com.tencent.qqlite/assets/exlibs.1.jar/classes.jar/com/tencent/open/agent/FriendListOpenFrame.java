package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.CheckBox;
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
import fdt;

public class FriendListOpenFrame
  extends OpenFrame
  implements View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, ImageLoader.ImageLoadListener, AdapterView.OnItemClickListener
{
  protected static final int a = 1;
  protected static final String a = "FriendListOpenFrame";
  protected static final int b = 2;
  protected static final int c = 3;
  protected Handler a;
  protected IndexView a;
  public PinnedDividerListView a;
  protected FriendListOpenFrame.FriendListAdapter a;
  protected String b;
  protected int d;
  
  public FriendListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new fdt(this);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    super.setContentView(2130903617);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131298742));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131298743));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131427345);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
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
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramView.a))
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
    LogUtility.c("FriendListOpenFrame", "-->onImageLoaded() url = " + paramString);
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.obj = paramBitmap;
    localMessage.what = 3;
    localMessage.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Bundle paramBundle)
  {
    LogUtility.c("FriendListOpenFrame", "-->onStart()");
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    this.d = paramBundle.getInt("group_index");
    this.b = paramBundle.getString("group_name");
    this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.a(true, false, this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.getString(2131363994), this.b);
    if (this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter = new FriendListOpenFrame.FriendListAdapter(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter.b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter.notifyDataSetChanged();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.e();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.FriendListOpenFrame
 * JD-Core Version:    0.7.0.1
 */