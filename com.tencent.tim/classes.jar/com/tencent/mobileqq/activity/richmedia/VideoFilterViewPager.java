package com.tencent.mobileqq.activity.richmedia;

import aaqh;
import aaqi;
import aasr;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import aqcu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import mqq.app.AppRuntime;

public class VideoFilterViewPager
  extends ViewPager
{
  private c jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$c;
  private d jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d;
  private b b;
  private boolean byM = true;
  private boolean byN = true;
  private Runnable fj = new VideoFilterViewPager.1(this);
  private int mLastPosition;
  
  public VideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void e(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, String.format("onPageSelect position:%s, instantiate:%s, mShowGuideWording:%s, mShowNewGuide:%s, camera:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.byM), Boolean.valueOf(this.byN), Integer.valueOf(aaqh.cix) }));
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.a(paramInt);
    if (!paramBoolean) {
      aasr.a().setCurrentId((FilterDesc)localObject2);
    }
    paramView = (TextView)paramView.findViewById(2131374884);
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("VideoFilterViewPager_video_filter", 0);
    int i = ((SharedPreferences)localObject1).getInt("wordingShowTimes", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    boolean bool = ((SharedPreferences)localObject1).getBoolean("showSvafGuideWording_" + str, true);
    if ((this.byM) && (i < 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.ef(paramInt) == 0))
    {
      if (!paramBoolean) {
        ((SharedPreferences)localObject1).edit().putInt("wordingShowTimes", i + 1).commit();
      }
      localObject2 = aqcu.decodeResource(getResources(), 2130846906);
      if (localObject2 != null)
      {
        paramInt = ((Bitmap)localObject2).getWidth();
        i = ((Bitmap)localObject2).getHeight();
        localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);
        ((Drawable)localObject2).setBounds(0, 0, paramInt, i);
        paramView.setCompoundDrawables(null, (Drawable)localObject2, null, null);
        paramView.setText("");
        ((SharedPreferences)localObject1).edit().putBoolean("showSvafGuideWording_" + str, false).commit();
      }
    }
    for (;;)
    {
      this.byM = false;
      this.byN = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterViewPager", 2, "decode arrow bitmap failed! position: " + paramInt);
      }
      paramView.setCompoundDrawables(null, null, null, null);
      paramView.setText("");
      continue;
      if ((this.byN) && (bool) && (aaqh.cix == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.ef(paramInt) == 0) && (QmcfManager.getInstance().hasQmcfEntrance(1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "mShowSvafGuideWording!");
        }
        ((SharedPreferences)localObject1).edit().putBoolean("showSvafGuideWording_" + str, false).commit();
        localObject1 = aqcu.decodeResource(getResources(), 2130846905);
        if (localObject1 != null)
        {
          paramInt = ((Bitmap)localObject1).getWidth();
          i = ((Bitmap)localObject1).getHeight();
          localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
          ((Drawable)localObject1).setBounds(0, 0, paramInt, i);
          paramView.setCompoundDrawables(null, (Drawable)localObject1, null, null);
          paramView.setText("");
        }
      }
      else if (localObject2 != null)
      {
        localObject1 = aqcu.decodeFile(((FilterDesc)localObject2).getIconFile(aasr.bej));
        if (localObject1 != null)
        {
          paramInt = ((Bitmap)localObject1).getWidth();
          i = ((Bitmap)localObject1).getHeight();
          localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
          ((Drawable)localObject1).setBounds(0, 0, paramInt, i);
          paramView.setCompoundDrawables(null, (Drawable)localObject1, null, null);
          paramView.setText("");
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoFilterViewPager", 2, "decode filter bitmap failed! position: " + paramInt);
          }
          paramView.setCompoundDrawables(null, null, null, null);
          paramView.setText("");
        }
      }
    }
  }
  
  private void init()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d = new d();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$c = new c();
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d);
    setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$c);
  }
  
  public FilterDesc a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.a(paramInt);
  }
  
  public FilterDesc b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.a(getCurrentItem());
  }
  
  public void bD(List<FilterDesc> paramList)
  {
    int i = 1;
    setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.bD(paramList);
    setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.te() * 50, false);
    paramList = BaseApplicationImpl.getApplication().getSharedPreferences("VideoFilterViewPager_video_filter", 0);
    int j = paramList.getInt("wordingShowTimes", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((aaqh.cix == 2) && (paramList.getBoolean("showSvafGuideWording_" + str, true))) {}
    for (;;)
    {
      int k = getCurrentItem();
      if (((j < 3) || (i != 0)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.ef(k) == 0)) {
        postDelayed(this.fj, 2000L);
      }
      return;
      i = 0;
    }
  }
  
  public void cxT()
  {
    int i = getCurrentItem();
    if ((this.byN) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.ef(i) == 0) && (aaqh.cix == 2) && (QmcfManager.getInstance().hasQmcfEntrance(1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onCameraChange back!");
      }
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("VideoFilterViewPager_video_filter", 0);
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (localSharedPreferences.getBoolean("showSvafGuideWording_" + str, true)) {
        postDelayed(this.fj, 1000L);
      }
    }
  }
  
  public void cxU()
  {
    this.byM = false;
    this.byN = false;
    removeCallbacks(this.fj);
  }
  
  public void cxV()
  {
    if (isShown())
    {
      int i = getCurrentItem();
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.F(i);
      if (localView != null)
      {
        localView.removeCallbacks((Runnable)localView.getTag());
        localView.clearAnimation();
        localView.setVisibility(4);
        if (this.b != null)
        {
          this.b.Go(1);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener hideWordingIfNeed state: 1");
          }
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setViewPagerItemVisiableChangeListener(b paramb)
  {
    this.b = paramb;
    this.mLastPosition = 0;
  }
  
  public class a
    implements Animation.AnimationListener
  {
    private VideoFilterViewPager.b c;
    private int mCurrentPosition;
    
    public a(VideoFilterViewPager.b paramb, int paramInt)
    {
      this.c = paramb;
      this.mCurrentPosition = paramInt;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if ((this.c != null) && (VideoFilterViewPager.this.getCurrentItem() == this.mCurrentPosition))
      {
        this.c.Go(1);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener animation dismiss state: 1");
        }
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  public static abstract interface b
  {
    public abstract void Go(int paramInt);
  }
  
  class c
    implements ViewPager.OnPageChangeListener
  {
    c() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageScrollStateChanged state: " + paramInt);
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageScrolled position: " + paramInt1 + ", positionOffset: " + paramFloat + ", positionOffsetPixels: " + paramInt2);
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageSelected position: " + paramInt);
      }
      int i = VideoFilterViewPager.a(VideoFilterViewPager.this).ef(paramInt);
      if ((VideoFilterViewPager.a(VideoFilterViewPager.this) != null) && (i != 0))
      {
        VideoFilterViewPager.a(VideoFilterViewPager.this).Go(0);
        VideoFilterViewPager.a(VideoFilterViewPager.this, i);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener state: 0");
        }
      }
      for (;;)
      {
        aaqi.h("", "0X8007804", "", "", "", "");
        Object localObject1 = VideoFilterViewPager.a(VideoFilterViewPager.this).a(paramInt);
        aasr.a().setCurrentId((FilterDesc)localObject1);
        localObject1 = VideoFilterViewPager.a(VideoFilterViewPager.this).F(paramInt);
        if (localObject1 != null)
        {
          localObject2 = new VideoFilterViewPager.VideoFilterPageChangeListener.1(this, paramInt, (View)localObject1);
          ((View)localObject1).setVisibility(0);
          ((View)localObject1).postDelayed((Runnable)localObject2, 1800L);
          ((View)localObject1).setTag(localObject2);
          VideoFilterViewPager.a(VideoFilterViewPager.this, (View)localObject1, paramInt, false);
        }
        localObject1 = VideoFilterViewPager.a(VideoFilterViewPager.this).F(paramInt - 1);
        Object localObject2 = VideoFilterViewPager.a(VideoFilterViewPager.this).F(paramInt + 1);
        if (localObject1 != null)
        {
          ((View)localObject1).removeCallbacks((Runnable)((View)localObject1).getTag());
          ((View)localObject1).clearAnimation();
        }
        if (localObject2 != null)
        {
          ((View)localObject2).removeCallbacks((Runnable)((View)localObject2).getTag());
          ((View)localObject2).clearAnimation();
        }
        return;
        if ((VideoFilterViewPager.a(VideoFilterViewPager.this) != null) && (VideoFilterViewPager.a(VideoFilterViewPager.this).ef(paramInt) == 0) && (VideoFilterViewPager.a(VideoFilterViewPager.this) != 0))
        {
          VideoFilterViewPager.a(VideoFilterViewPager.this).Go(0);
          VideoFilterViewPager.a(VideoFilterViewPager.this, 0);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener state-check: 0");
          }
        }
      }
    }
  }
  
  class d
    extends PagerAdapter
  {
    private final SparseArray<View> aU = new SparseArray();
    private final Map<Class<? extends View>, Queue<View>> ge = new HashMap();
    private ArrayList<FilterDesc> sd = new ArrayList();
    
    public d() {}
    
    @Nullable
    public View F(int paramInt)
    {
      return (View)this.aU.get(paramInt);
    }
    
    public FilterDesc a(int paramInt)
    {
      paramInt = ef(paramInt);
      if ((paramInt >= 0) && (paramInt < this.sd.size())) {
        return (FilterDesc)this.sd.get(paramInt);
      }
      return null;
    }
    
    public void bD(List<FilterDesc> paramList)
    {
      this.sd.clear();
      this.sd.addAll(paramList);
      this.aU.clear();
      notifyDataSetChanged();
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "destroyItem position: " + paramInt);
      }
      View localView = (View)paramObject;
      localView.removeCallbacks((Runnable)localView.getTag());
      localView.clearAnimation();
      paramViewGroup.removeView(localView);
      paramObject = (Queue)this.ge.get(localView.getClass());
      paramViewGroup = paramObject;
      if (paramObject == null)
      {
        paramViewGroup = new LinkedList();
        this.ge.put(localView.getClass(), paramViewGroup);
      }
      paramViewGroup.offer(localView);
      this.aU.remove(paramInt);
    }
    
    public int ef(int paramInt)
    {
      int i = this.sd.size();
      if (i > 0) {
        return paramInt % i;
      }
      return -1;
    }
    
    public int getCount()
    {
      return this.sd.size() * 100;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "instantiateItem position: " + paramInt);
      }
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("VideoFilterViewPager", 2, "instantiateItem find data is null!");
        }
        return null;
      }
      localObject1 = (Queue)this.ge.get(localObject1.getClass());
      if (localObject1 != null) {}
      for (localObject1 = (View)((Queue)localObject1).poll();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ((LayoutInflater)VideoFilterViewPager.this.getContext().getSystemService("layout_inflater")).inflate(2131561363, null);
        }
        paramViewGroup.addView((View)localObject2);
        this.aU.put(paramInt, localObject2);
        return localObject2;
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return ((paramObject instanceof View)) && (paramObject == paramView);
    }
    
    public int te()
    {
      return this.sd.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */