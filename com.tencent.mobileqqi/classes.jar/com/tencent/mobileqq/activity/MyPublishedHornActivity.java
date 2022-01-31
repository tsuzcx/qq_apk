package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bwo;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.NearHornObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.maproam.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import cwm;
import cwo;
import cwp;
import cwq;
import cwr;
import java.util.List;

public class MyPublishedHornActivity
  extends BaseHornListActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public Button a;
  public RelativeLayout a;
  public BaseHornListActivity a;
  NearHornObserver a;
  public cwr a;
  protected TextView b;
  public HornDetail b;
  public boolean b;
  public String e = "";
  
  public MyPublishedHornActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver = new cwm(this);
  }
  
  private void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.a(4);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.notifyDataSetChanged();
      }
    }
    while (NetworkUtil.e(this))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cwo(this, paramBoolean));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.a = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.notifyDataSetChanged();
    }
    paramBoolean = this.jdField_a_of_type_Bwo.obtainMessage(2);
    this.jdField_a_of_type_Bwo.sendMessage(paramBoolean);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903678);
    super.setTitle(2131562427);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity = this;
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231116));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131231690));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("删除该喇叭");
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = this.m;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131562000);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getResources().getString(2131562000));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131233358));
    super.a();
    this.jdField_a_of_type_Cwr = new cwr(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter = this.jdField_a_of_type_Cwr;
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Cwr);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    super.a(this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver);
    a(Boolean.valueOf(true));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.b(this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver);
    this.jdField_a_of_type_JavaUtilList = null;
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131561851);
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getResources().getString(2131561851));
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Cwr.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131562000);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getResources().getString(2131561851));
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Cwr.notifyDataSetChanged();
      this.jdField_a_of_type_Cwr.a();
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      paramView = this.jdField_a_of_type_Cwr.a();
    } while (paramView.size() <= 0);
    this.jdField_b_of_type_ComTencentMobileqqDataHornDetail = ((HornDetail)paramView.get(0));
    if (NetworkUtil.e(this))
    {
      if (super.a(1, this.jdField_b_of_type_ComTencentMobileqqDataHornDetail.hornKey).booleanValue()) {
        Utils.a(this.jdField_a_of_type_AndroidContentContext, 2131561923, getResources().getString(2131563024), new cwp(this), new cwq(this));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.b(this.jdField_b_of_type_ComTencentMobileqqDataHornDetail.hornKey, this.e);
      }
    }
    paramView = this.jdField_a_of_type_Bwo.obtainMessage(2);
    this.jdField_a_of_type_Bwo.sendMessage(paramView);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong == -1L) {}
    int i;
    do
    {
      return;
      paramInt = (int)paramLong;
      i = this.jdField_a_of_type_Cwr.getItemViewType(paramInt);
      if (i == 1)
      {
        a(Boolean.valueOf(false));
        return;
      }
    } while (i != 0);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Cwr.a(paramInt);
      this.jdField_a_of_type_Cwr.notifyDataSetChanged();
      paramAdapterView = this.jdField_a_of_type_Cwr.a();
      if ((paramAdapterView != null) && (paramAdapterView.size() > 0))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    paramAdapterView = (HornDetail)this.jdField_a_of_type_Cwr.getItem(paramInt);
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramView.putExtra("isShowAd", false);
    paramView.putExtra("url", String.format("http://imgcache.qq.com/club/horn/rel/comment.html?hornKey=%1$s&_bid=179&uin=%2$s&pvsrc=nearby&_wv=5123", new Object[] { paramAdapterView.hornKey, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() }));
    paramView.putExtra("business", 2147549184L);
    startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MyPublishedHornActivity
 * JD-Core Version:    0.7.0.1
 */