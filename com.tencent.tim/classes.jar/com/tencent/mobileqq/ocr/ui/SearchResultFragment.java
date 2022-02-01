package com.tencent.mobileqq.ocr.ui;

import akoj;
import akok;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anot;
import com.tencent.biz.lebasearch.widget.ScrolledTabHost;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.c;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;

public class SearchResultFragment
  extends BaseOCRTextSearchFragment
{
  public SearchResultViewPagerAdapter a;
  public ScrolledTabHost b;
  public int dnX;
  public ViewPager mViewPager;
  
  public void a(String paramString, int paramInt, OCRTextSearchInfo.c paramc)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter.a(paramString, paramInt, paramc);
    this.b.clearAllTabs();
    paramInt = 0;
    while (paramInt < paramString.size())
    {
      paramc = (SearchResultViewPagerAdapter.a)paramString.get(paramInt);
      this.b.ll(paramc.groupName);
      paramInt += 1;
    }
    if (paramString.size() == 1) {
      this.b.setVisibility(8);
    }
    for (;;)
    {
      this.b.setCurrentTab(0);
      return;
      this.b.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    anot.a(null, "dc00898", "", "", "0X80082E6", "0X80082E6", 0, 0, "", "", "", "");
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560012, null);
    this.mViewPager = ((ViewPager)paramLayoutInflater.findViewById(2131381985));
    this.b = ((ScrolledTabHost)paramLayoutInflater.findViewById(2131379166));
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a, this, this.mViewPager);
    this.mViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter);
    this.b.setOnTabSelectedListener(new akoj(this));
    this.mViewPager.setOnPageChangeListener(new akok(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void reset()
  {
    if (this.b != null) {
      this.b.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultFragment
 * JD-Core Version:    0.7.0.1
 */