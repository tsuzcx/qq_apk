package com.tencent.mobileqq.filemanager.data.search;

import agnz;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.Iterator;
import java.util.List;

public class SearchTypeFragment
  extends ReportV4Fragment
  implements View.OnClickListener
{
  private SparseIntArray T = new SparseIntArray();
  private SparseIntArray U = new SparseIntArray();
  private agnz jdField_a_of_type_Agnz;
  private SearchFileFlowLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout;
  public int cYk;
  public List<Integer> mTypes;
  public String mUin;
  private View mView;
  
  public void U(List<Integer> paramList, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout != null) && (paramList != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.setMaxNumInLineAndAlignMode(0, paramInt);
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.getMeasuredWidth();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FrameLayout localFrameLayout = (FrameLayout)b(((Integer)paramList.next()).intValue(), i, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.addView(localFrameLayout);
      }
    }
  }
  
  public void a(agnz paramagnz)
  {
    this.jdField_a_of_type_Agnz = paramagnz;
  }
  
  public View b(int paramInt1, int paramInt2, int paramInt3)
  {
    FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(getActivity()).inflate(2131561037, (ViewGroup)this.mView, false);
    LinearLayout localLinearLayout = (LinearLayout)localFrameLayout.findViewById(2131370729);
    TextView localTextView = (TextView)localFrameLayout.findViewById(2131380920);
    ((ImageView)localFrameLayout.findViewById(2131369889)).setImageDrawable(getResources().getDrawable(this.T.get(paramInt1)));
    localTextView.setText(this.U.get(paramInt1));
    localLinearLayout.setTag(Integer.valueOf(paramInt1));
    localLinearLayout.setOnClickListener(this);
    ((FrameLayout.LayoutParams)localFrameLayout.getLayoutParams()).width = (paramInt2 / paramInt3);
    return localFrameLayout;
  }
  
  public void onClick(View paramView)
  {
    Integer localInteger = (Integer)paramView.getTag();
    if (this.jdField_a_of_type_Agnz != null) {
      this.jdField_a_of_type_Agnz.Ok(localInteger.intValue());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.T.put(13, 2130844644);
    this.T.put(3, 2130845234);
    this.T.put(2, 2130845238);
    this.T.put(0, 2130845237);
    this.T.put(1, 2130845235);
    this.T.put(11, 2130845236);
    this.U.put(13, 2131699574);
    this.U.put(3, 2131699572);
    this.U.put(2, 2131699577);
    this.U.put(0, 2131699573);
    this.U.put(1, 2131699575);
    this.U.put(11, 2131699576);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mView = paramLayoutInflater.inflate(2131561035, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout = ((SearchFileFlowLayout)this.mView.findViewById(2131367195));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.post(new SearchTypeFragment.1(this));
    paramLayoutInflater = this.mView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.SearchTypeFragment
 * JD-Core Version:    0.7.0.1
 */