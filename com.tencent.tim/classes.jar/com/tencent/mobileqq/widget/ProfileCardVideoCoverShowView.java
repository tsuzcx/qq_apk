package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import arhn;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import wja;

public class ProfileCardVideoCoverShowView
  extends FrameLayout
  implements AdapterView.OnItemClickListener, OverScrollCallbackHorizontalListView.a
{
  private OverScrollCallbackHorizontalListView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  private a jdField_a_of_type_ComTencentMobileqqWidgetProfileCardVideoCoverShowView$a;
  private BaseAdapter mAdapter = new arhn(this);
  private ArrayList<b> mDataList = new ArrayList(10);
  
  public ProfileCardVideoCoverShowView(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ProfileCardVideoCoverShowView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ProfileCardVideoCoverShowView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(2131561554, this, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView = ((OverScrollCallbackHorizontalListView)findViewById(2131370573));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setDividerWidth(wja.dp2px(2.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setAdapter(this.mAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(1);
  }
  
  public void a(OverScrollCallbackHorizontalListView paramOverScrollCallbackHorizontalListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardMicroVideoContentView", 2, "onOverScrollRight");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardVideoCoverShowView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardVideoCoverShowView$a.a(this);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardMicroVideoContentView", 2, "onItemClick " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardVideoCoverShowView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardVideoCoverShowView$a.a(this, paramView, (b)this.mDataList.get(paramInt));
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void setCallback(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardVideoCoverShowView$a = parama;
  }
  
  public void setData(List<b> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("setData list=");
      if (paramList == null)
      {
        localObject = "null";
        QLog.i("ProfileCardMicroVideoContentView", 2, localObject);
      }
    }
    else
    {
      this.mDataList.clear();
      if ((paramList != null) && (paramList.size() > 0)) {
        this.mDataList.addAll(paramList);
      }
      if ((paramList != null) && (paramList.size() != 0)) {
        break label116;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(1);
    }
    for (;;)
    {
      this.mAdapter.notifyDataSetChanged();
      return;
      localObject = Integer.valueOf(paramList.size());
      break;
      label116:
      int i = getResources().getDisplayMetrics().widthPixels;
      int j = wja.dp2px(114.0F, getResources());
      if (paramList.size() > i * 1.0F / j) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(0);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(1);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ProfileCardVideoCoverShowView paramProfileCardVideoCoverShowView);
    
    public abstract void a(ProfileCardVideoCoverShowView paramProfileCardVideoCoverShowView, View paramView, ProfileCardVideoCoverShowView.b paramb);
  }
  
  public static class b
  {
    public String cAu;
    public String coverUrl;
    public String feedId;
    public String jumpUrl;
    public int position;
    public int type;
    public String vid;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("DataItem:position=").append(this.position);
      localStringBuilder.append(", type=").append(this.type);
      localStringBuilder.append(", coverUrl=").append(this.coverUrl);
      localStringBuilder.append(", feedId=").append(this.feedId);
      localStringBuilder.append(", vid=").append(this.vid);
      localStringBuilder.append(", jumpUrl=").append(this.jumpUrl);
      localStringBuilder.append(", spiritImageUrl=").append(this.cAu);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardVideoCoverShowView
 * JD-Core Version:    0.7.0.1
 */