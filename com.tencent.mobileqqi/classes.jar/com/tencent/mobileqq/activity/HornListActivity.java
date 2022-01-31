package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import ccj;
import cck;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.NearHornObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import cwj;
import cwk;
import cwl;
import cwm;
import cwn;
import cwo;
import java.util.Iterator;
import java.util.List;

public class HornListActivity
  extends BaseHornListActivity
  implements AdapterView.OnItemClickListener
{
  protected LinearLayout a;
  public BaseHornListActivity a;
  NearHornObserver a;
  protected Boolean a;
  public long b;
  protected TextView b;
  private boolean b;
  
  public HornListActivity()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver = new cwj(this);
  }
  
  private void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.jdField_b_of_type_Boolean = this.jdField_a_of_type_JavaLangBoolean.booleanValue();
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_JavaUtilList.iterator();
        while (paramBoolean.hasNext())
        {
          localHornDetail = (HornDetail)paramBoolean.next();
          if ((this.jdField_a_of_type_ComTencentMobileqqDataHornDetail == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.hornKey.equals(localHornDetail.hornKey))) {
            this.jdField_a_of_type_JavaUtilList.add(localHornDetail);
          }
        }
        if (this.jdField_a_of_type_JavaUtilList.isEmpty())
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131562492);
          this.jdField_b_of_type_AndroidWidgetTextView.setGravity(1);
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130839179);
          this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, (int)(32.0F * this.jdField_a_of_type_Float), 0, 0);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.notifyDataSetChanged();
      }
      while (!QLog.isColorLevel())
      {
        HornDetail localHornDetail;
        return;
      }
      QLog.i("NearHornRelated", 2, "HornListActivity: hornDetails is empty");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.a = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.notifyDataSetChanged();
    if (NetworkUtil.e(this))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cwl(this, paramBoolean));
      return;
    }
    paramBoolean = this.jdField_a_of_type_Ccj.obtainMessage(2);
    this.jdField_a_of_type_Ccj.sendMessage(paramBoolean);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHornDetail = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_ComTencentMobileqqDataHornDetail;
    if (this.jdField_a_of_type_ComTencentMobileqqDataHornDetail != null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903673, null);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      cck localcck = new cck();
      localcck.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233358));
      localcck.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233361));
      localcck.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233362));
      localcck.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setSpannableFactory(QQText.a);
      localcck.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.content, TextView.BufferType.SPANNABLE);
      localcck.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233360));
      localcck.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233363));
      localcck.c.setContentDescription("查看该喇叭评论内容");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.distance + " ").append(this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.time);
      localcck.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
      localcck.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.nickName);
      localcck.c.setText("" + this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.commentCnt);
      this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidViewView, null, false);
      this.jdField_a_of_type_AndroidViewView.setTag(localcck);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.uin;
      super.a((String)localObject, 0, localcck.jdField_a_of_type_AndroidWidgetImageView);
      localcck.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new cwm(this, (String)localObject));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new cwn(this));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903672);
    super.setTitle(2131562437);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity = this;
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131233356));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    super.a();
    e();
    super.a(getResources().getString(2131562438));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230821));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131233357));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new cwk(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter = new cwo(this, null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter);
    this.jdField_b_of_type_JavaLangString = super.getIntent().getStringExtra("lastHornKey");
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("lastSvrBuff");
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(super.getIntent().getBooleanExtra("hornHasMore", false));
    super.a(this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver);
    a(Boolean.valueOf(true));
    super.b();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription("我要发喇叭");
    this.k.setContentDescription("返回");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.b(this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver);
    this.jdField_a_of_type_JavaUtilList = null;
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong == -1L) {}
    int i;
    do
    {
      return;
      paramInt = (int)paramLong;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.getItemViewType(paramInt);
      if (i == 1)
      {
        a(Boolean.valueOf(false));
        return;
      }
    } while ((i != 0) || (!this.jdField_b_of_type_Boolean));
    this.jdField_b_of_type_Boolean = false;
    paramAdapterView = (HornDetail)this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity$BaseHornAdapter.getItem(paramInt);
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramView.putExtra("isShowAd", false);
    paramView.putExtra("url", String.format("http://imgcache.qq.com/club/horn/rel/comment.html?hornKey=%1$s&_bid=179&uin=%2$s&pvsrc=nearby&_wv=5123", new Object[] { paramAdapterView.hornKey, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() }));
    paramView.putExtra("business", 2147549184L);
    startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HornListActivity
 * JD-Core Version:    0.7.0.1
 */