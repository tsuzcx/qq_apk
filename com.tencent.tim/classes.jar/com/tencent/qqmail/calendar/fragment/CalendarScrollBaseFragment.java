package com.tencent.qqmail.calendar.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;

public class CalendarScrollBaseFragment
  extends CalendarBaseFragment
{
  protected LinearLayout mContainer;
  protected ScrollView scrollView;
  
  protected CalendarScrollBaseFragment()
  {
    super(false);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle) {}
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = (FrameLayout)super.initUI(paramViewHolder);
    this.scrollView = new ScrollView(getActivity());
    this.scrollView.setBackgroundColor(getResources().getColor(2131166570));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 48);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    this.scrollView.setLayoutParams(localLayoutParams);
    this.scrollView.setVerticalFadingEdgeEnabled(false);
    this.mContainer = new LinearLayout(getActivity());
    int i = getResources().getDimensionPixelSize(2131299398);
    this.mContainer.setPadding(0, i, 0, i);
    this.mContainer.setOrientation(1);
    this.mContainer.setFocusable(true);
    this.mContainer.setFocusableInTouchMode(true);
    this.scrollView.addView(this.mContainer, new FrameLayout.LayoutParams(-1, -2));
    paramViewHolder.addView(this.scrollView);
    return paramViewHolder;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarScrollBaseFragment
 * JD-Core Version:    0.7.0.1
 */