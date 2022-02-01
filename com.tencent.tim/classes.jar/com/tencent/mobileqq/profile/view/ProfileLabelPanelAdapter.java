package com.tencent.mobileqq.profile.view;

import afpt;
import algr;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ToggleButton;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ProfileLabelPanelAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  protected algr a;
  protected ProfileLabelPanel.a a;
  protected a a;
  protected Context context;
  protected float density;
  protected SparseArray<a> dk;
  protected int dtm;
  protected afpt e = new afpt();
  protected List<ProfileLabelTypeInfo> typeList;
  
  public ProfileLabelPanelAdapter(Context paramContext, List<ProfileLabelTypeInfo> paramList)
  {
    this.context = paramContext;
    this.typeList = paramList;
    this.density = paramContext.getResources().getDisplayMetrics().density;
    this.dtm = this.typeList.size();
  }
  
  protected GridView a()
  {
    GridView localGridView = new GridView(this.context);
    localGridView.setPadding((int)(this.density * 10.0F), 0, (int)(this.density * 10.0F), 0);
    localGridView.setNumColumns(4);
    localGridView.setHorizontalSpacing((int)(this.density * 4.0F));
    localGridView.setVerticalSpacing((int)(this.density * 4.0F));
    return localGridView;
  }
  
  public void a(algr paramalgr)
  {
    this.jdField_a_of_type_Algr = paramalgr;
  }
  
  public void a(ProfileLabelPanel.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$a = parama;
  }
  
  protected void ai(View paramView, int paramInt)
  {
    if (this.dk == null) {
      this.dk = new SparseArray();
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$a = ((a)this.dk.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$a = new a(null);
      this.dk.put(paramInt, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$a);
    }
    paramView = (GridView)paramView;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$a.lP(((ProfileLabelTypeInfo)this.typeList.get(paramInt)).labels);
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$a);
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    GridView localGridView = (GridView)paramObject;
    ((ViewGroup)paramView).removeView(localGridView);
    this.e.gx((View)paramObject);
  }
  
  public int getCount()
  {
    return this.dtm;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    GridView localGridView2 = (GridView)this.e.bW();
    GridView localGridView1 = localGridView2;
    if (localGridView2 == null) {
      localGridView1 = a();
    }
    ai(localGridView1, paramInt);
    if ((localGridView1.getParent() != paramView) && (paramInt < getCount())) {
      ((ViewGroup)paramView).addView(localGridView1);
    }
    return localGridView1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    ToggleButton localToggleButton = (ToggleButton)paramView;
    localToggleButton.toggle();
    ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)paramView.getTag();
    algr localalgr;
    if (localProfileLabelInfo != null)
    {
      localalgr = this.jdField_a_of_type_Algr;
      if (localProfileLabelInfo.labelStatus != ProfileLabelInfo.STATUS_CHECKED) {
        break label64;
      }
    }
    label64:
    for (boolean bool = false;; bool = true)
    {
      localalgr.a(localProfileLabelInfo, localToggleButton, Boolean.valueOf(bool));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
  
  class a
    extends BaseAdapter
  {
    List<ProfileLabelInfo> labelList;
    
    private a() {}
    
    public int getCount()
    {
      return this.labelList.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.labelList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      Object localObject2;
      boolean bool;
      if (paramView == null)
      {
        localObject1 = new ToggleButton(ProfileLabelPanelAdapter.this.context);
        ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(28.0F * ProfileLabelPanelAdapter.this.density)));
        ((View)localObject1).setBackgroundResource(2130851555);
        paramView = (ToggleButton)localObject1;
        paramView.setGravity(17);
        paramView.setTextSize(ProfileLabelPanelAdapter.this.context.getResources().getInteger(2131427341));
        paramView.setTextColor(Color.parseColor("#777777"));
        paramView.setOnClickListener(ProfileLabelPanelAdapter.this);
        localObject2 = (ProfileLabelInfo)getItem(paramInt);
        if (localObject2 == null) {
          break label231;
        }
        paramView.setTag(localObject2);
        if (((ProfileLabelInfo)localObject2).labelStatus != ProfileLabelInfo.STATUS_CHECKED) {
          break label225;
        }
        bool = true;
        label135:
        paramView.setChecked(bool);
        paramView.setText(((ProfileLabelInfo)localObject2).labelName);
        paramView.setTextOn(((ProfileLabelInfo)localObject2).labelName);
        paramView.setTextOff(((ProfileLabelInfo)localObject2).labelName);
        if (((ProfileLabelInfo)localObject2).labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
          ProfileLabelPanelAdapter.this.a.a((ProfileLabelInfo)localObject2, paramView);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject2 = (ToggleButton)paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
        break;
        label225:
        bool = false;
        break label135;
        label231:
        paramView.setVisibility(8);
      }
    }
    
    public void lP(List<ProfileLabelInfo> paramList)
    {
      this.labelList = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanelAdapter
 * JD-Core Version:    0.7.0.1
 */