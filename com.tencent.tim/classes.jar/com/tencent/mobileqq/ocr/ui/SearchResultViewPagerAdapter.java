package com.tencent.mobileqq.ocr.ui;

import acfp;
import akom;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.a;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  public BaseOCRTextSearchFragment.a a;
  SearchResultFragment a;
  public List<a> items = new ArrayList();
  ViewPager mViewPager;
  Map<String, akom> mn = new HashMap();
  List<OCRTextSearchInfo.a> rc;
  
  public SearchResultViewPagerAdapter(BaseOCRTextSearchFragment.a parama, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a = parama;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.mViewPager = paramViewPager;
  }
  
  public List<a> a(String paramString, int paramInt, OCRTextSearchInfo.c paramc)
  {
    if (paramc != null) {}
    for (this.rc = paramc.qT;; this.rc = null)
    {
      this.items.clear();
      if ((paramc != null) && (paramc.Eg != null)) {
        this.items = paramc.Eg;
      }
      if ((paramInt != 0) || (paramc == null) || (paramc.Eg == null) || (paramc.Eg.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.groupType == 0)
        {
          locala.cB = paramc.qT;
          locala.hasMore = paramc.hasMore;
        }
      }
    }
    if (this.items.size() == 0)
    {
      paramc = new a();
      paramc.groupName = acfp.m(2131714129);
      paramc.groupType = 0;
      paramc.cB = this.rc;
      if ((paramc.cB == null) || (paramc.cB.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramc.errorCode = paramInt;; paramc.errorCode = -1)
    {
      paramc.bUd = paramString;
      this.items.add(0, paramc);
      initViews(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a.getActivity());
      super.notifyDataSetChanged();
      return this.items;
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public void eY(int paramInt)
  {
    a locala = (a)this.items.get(paramInt);
    ((akom)this.mn.get(locala.groupName)).onShow();
  }
  
  public int getCount()
  {
    if (this.items == null) {
      return 0;
    }
    return this.items.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  void initViews(Context paramContext)
  {
    int i = 0;
    if (i < this.items.size())
    {
      a locala = (a)this.items.get(i);
      akom localakom;
      if (this.mn.containsKey(locala.groupName)) {
        localakom = (akom)this.mn.get(locala.groupName);
      }
      for (;;)
      {
        localakom.init(locala.hasMore);
        localakom.a(paramContext, locala);
        i += 1;
        break;
        localakom = new akom(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.mn.put(locala.groupName, localakom);
      }
    }
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = (a)this.items.get(paramInt);
    localObject = ((akom)this.mn.get(((a)localObject).groupName)).a(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a.getActivity(), (a)localObject);
    paramViewGroup.removeView((View)localObject);
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public static class a
  {
    public String bUd;
    public List<OCRTextSearchInfo.a> cB;
    public int errorCode;
    public String groupName;
    public int groupType;
    public boolean hasMore;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */