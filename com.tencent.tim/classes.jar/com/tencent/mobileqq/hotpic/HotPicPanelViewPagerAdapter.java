package com.tencent.mobileqq.hotpic;

import ahyx;
import ahzd;
import ahzw;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.widget.OneViewPagerAdapter;
import java.util.List;

public class HotPicPanelViewPagerAdapter
  extends OneViewPagerAdapter
{
  ahyx jdField_a_of_type_Ahyx;
  HotPicMainPanel jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
  protected HotPicPageView.e a;
  protected a a;
  SparseArray<HotPicPageView> cM = new SparseArray();
  Context mContext;
  
  public HotPicPanelViewPagerAdapter(HotPicMainPanel paramHotPicMainPanel, ViewPager paramViewPager)
  {
    super(paramViewPager);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = paramHotPicMainPanel;
    this.mContext = paramHotPicMainPanel.mContext;
    this.jdField_a_of_type_Ahyx = paramHotPicMainPanel.jdField_a_of_type_Ahyx;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter$a = paramHotPicMainPanel;
  }
  
  public void PG(int paramInt)
  {
    int i = 0;
    HotPicPageView localHotPicPageView;
    if (i < this.cM.size())
    {
      localHotPicPageView = (HotPicPageView)this.cM.valueAt(i);
      if (localHotPicPageView.jdField_a_of_type_Ahzw != null) {}
    }
    else
    {
      return;
    }
    if (localHotPicPageView.mPostion == paramInt)
    {
      localHotPicPageView.jdField_a_of_type_Ahzw.KN(true);
      localHotPicPageView.dro();
    }
    for (;;)
    {
      i += 1;
      break;
      localHotPicPageView.jdField_a_of_type_Ahzw.KN(false);
      localHotPicPageView.drl();
    }
  }
  
  public void PH(int paramInt)
  {
    if ((this.cM != null) && (this.cM.size() > paramInt) && (paramInt >= 0))
    {
      HotPicPageView localHotPicPageView = (HotPicPageView)this.cM.valueAt(paramInt);
      if (localHotPicPageView != null) {
        localHotPicPageView.onPause();
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    ((HotPicPageView)paramObject).reset();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Ahyx.size();
  }
  
  public View getView(int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_Ahyx.b(paramInt);
    HotPicPageView localHotPicPageView = (HotPicPageView)LayoutInflater.from(this.mContext).inflate(2131558666, null);
    localHotPicPageView.setOnHotPicItemClickListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$e);
    if (localHotPicTagInfo != null)
    {
      localHotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel, localHotPicTagInfo);
      this.cM.put(localHotPicTagInfo.tagId, localHotPicPageView);
    }
    return localHotPicPageView;
  }
  
  public void iq(int paramInt1, int paramInt2)
  {
    Object localObject2 = ahzd.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.mApp);
    HotPicPageView localHotPicPageView = (HotPicPageView)this.cM.get(paramInt1);
    if ((localHotPicPageView != null) && (localHotPicPageView.mHasInited)) {
      localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$b.setLoading(false);
    }
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 7: 
      localHotPicPageView.drm();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.dqZ();
      return;
    case 3: 
      try
      {
        localHotPicPageView.b.mClearSpanOnItemsChanged = false;
        paramInt2 = localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.mDatas.size();
        localObject2 = ((ahzd)localObject2).r(paramInt1);
        localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.setDatas((List)localObject2);
        int i = ((List)localObject2).size();
        paramInt1 = paramInt2;
        while (paramInt1 < i - paramInt2)
        {
          localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.notifyItemInserted(paramInt1);
          paramInt1 += 1;
        }
        localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.notifyItemRangeChanged(paramInt2, ((List)localObject2).size());
        localHotPicPageView.px();
        return;
      }
      finally {}
    case 6: 
      if (((ahzd)localObject2).kd(paramInt1)) {}
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        localObject1.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$b.setType(paramInt1);
        localObject1.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$b.setLoading(false);
        localObject1.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.notifyItemChanged(localObject1.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.getItemCount());
        return;
      }
    }
    localObject1.drm();
  }
  
  public void k(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof HotPicPageView))) {
      ((HotPicPageView)paramObject).initView();
    }
  }
  
  public void l(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof HotPicPageView))) {
      ((HotPicPageView)paramObject).clearView();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter$a.onPageSelected(paramInt);
    }
  }
  
  public void reset()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = null;
  }
  
  public void setOnHotPicItemClickListener(HotPicPageView.e parame)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$e = parame;
  }
  
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */