package com.tencent.mobileqq.richmedia.capture.view;

import aaqi;
import acfp;
import alwh;
import alwh.b;
import alwx;
import alxs;
import alxt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import anij;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import mqq.os.MqqHandler;

public class CaptureVideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements alwh.b
{
  private b jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$b;
  private d jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$d;
  private int atZ = -1;
  private BroadcastReceiver by;
  List<FilterCategoryItem> datas = new ArrayList();
  private View mContainer;
  
  public CaptureVideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CaptureVideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void Ox(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$b.Oy(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "notifyVisiableChange " + paramBoolean);
    }
  }
  
  private void e(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageSelect position: " + paramInt + ", mCurPosition: " + this.atZ);
    }
    if (paramInt == this.atZ) {}
    FilterCategoryItem localFilterCategoryItem;
    do
    {
      return;
      this.mContainer = paramView;
      this.atZ = paramInt;
      paramView.setVisibility(0);
      localFilterCategoryItem = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$d.a(paramInt);
      if (localFilterCategoryItem != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
    return;
    alwh.a().a(localFilterCategoryItem);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$b.d(localFilterCategoryItem);
    }
    Object localObject2 = (TextView)paramView.findViewById(2131381706);
    TextView localTextView = (TextView)paramView.findViewById(2131381705);
    Object localObject1 = (TextView)paramView.findViewById(2131381707);
    if (localFilterCategoryItem.auG())
    {
      ((TextView)localObject2).setText(acfp.m(2131703495));
      paramView.setContentDescription("无滤镜No Filter");
      localTextView.setText(" - No Filter - ");
      ((TextView)localObject1).setText("");
      ((TextView)localObject1).setCompoundDrawables(null, null, null, null);
      localObject1 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject1).setDuration(500L);
      ((AlphaAnimation)localObject1).setStartOffset(500L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      paramView.startAnimation((Animation)localObject1);
      ((AlphaAnimation)localObject1).setAnimationListener(new alxs(this, paramView, paramInt));
      paramView.setVisibility(0);
      Ox(true);
      paramView.clearAnimation();
      paramView.startAnimation((Animation)localObject1);
      alwx.bZe = localFilterCategoryItem.categoryId + "";
      alwx.filterId = localFilterCategoryItem.id;
      if (anij.a().dGP != 1) {
        break label473;
      }
    }
    label473:
    for (paramInt = 1;; paramInt = 2)
    {
      alwx.TD(paramInt);
      return;
      ((TextView)localObject2).setText(localFilterCategoryItem.name);
      localTextView.setText(" - " + localFilterCategoryItem.bYY + " - ");
      ((TextView)localObject1).setText(localFilterCategoryItem.bYZ);
      paramView.setContentDescription(localFilterCategoryItem.name + "," + localFilterCategoryItem.bYZ + acfp.m(2131703494));
      localObject2 = getResources().getDrawable(2130846855);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth() / 3 * 2, ((Drawable)localObject2).getIntrinsicHeight() / 3 * 2);
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      break;
    }
  }
  
  private void init()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$d = new d();
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$d);
    setOnPageChangeListener(new c());
  }
  
  public void dKm()
  {
    ThreadManager.getUIHandler().post(new CaptureVideoFilterViewPager.2(this));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    alwh.a().a(this);
    this.by = new a(null);
    getContext().registerReceiver(this.by, new IntentFilter("action_brocassreceiver_for_filter"));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    alwh.a().dKl();
    try
    {
      if (this.by != null) {
        getContext().unregisterReceiver(this.by);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VideoFilterViewPager", 2, localException.getMessage());
    }
  }
  
  public void setCurrentItem(FilterCategoryItem paramFilterCategoryItem)
  {
    int i;
    if (paramFilterCategoryItem != null)
    {
      i = 0;
      if (i >= this.datas.size()) {
        break label67;
      }
      if (!paramFilterCategoryItem.id.equals(((FilterCategoryItem)this.datas.get(i)).id)) {
        break label60;
      }
    }
    for (;;)
    {
      setCurrentItem(te() * 20 + i, false);
      return;
      label60:
      i += 1;
      break;
      label67:
      i = 0;
    }
  }
  
  public int te()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$d != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$d.te();
    }
    return 0;
  }
  
  public void update()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$d != null) && (alwh.isSupport(getContext()))) {
      ThreadManager.getUIHandler().post(new CaptureVideoFilterViewPager.1(this));
    }
  }
  
  public final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("action_brocassreceiver_for_filter".equals(paramIntent.getAction()))
      {
        alwh.a().init();
        alwh.a().a(new alxt(this));
        CaptureVideoFilterViewPager.this.update();
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "CaptureVideoFilterViewPager FilterBroadcastReceiver size=" + CaptureVideoFilterViewPager.this.datas.size());
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void Oy(boolean paramBoolean);
    
    public abstract void d(FilterCategoryItem paramFilterCategoryItem);
  }
  
  class c
    implements ViewPager.OnPageChangeListener
  {
    public int AS;
    
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
      if (this.AS == paramInt) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "onPageSelected l " + this.AS + ",n " + paramInt);
        }
      }
      Object localObject;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "onPageSelected l " + this.AS + ",n" + paramInt);
        }
        aaqi.h("", "0X8007804", "", "", "", "");
        this.AS = paramInt;
        View localView = CaptureVideoFilterViewPager.a(CaptureVideoFilterViewPager.this).F(paramInt);
        if (localView != null)
        {
          localObject = (Runnable)localView.getTag();
          if (localObject != null)
          {
            localView.removeCallbacks((Runnable)localObject);
            localView.setTag(null);
          }
          CaptureVideoFilterViewPager.a(CaptureVideoFilterViewPager.this, localView, paramInt, false);
        }
        localView = CaptureVideoFilterViewPager.a(CaptureVideoFilterViewPager.this).F(paramInt - 1);
        localObject = CaptureVideoFilterViewPager.a(CaptureVideoFilterViewPager.this).F(paramInt + 1);
        if (localView != null)
        {
          localView.removeCallbacks((Runnable)localView.getTag());
          localView.clearAnimation();
        }
      } while (localObject == null);
      ((View)localObject).removeCallbacks((Runnable)((View)localObject).getTag());
      ((View)localObject).clearAnimation();
    }
  }
  
  class d
    extends PagerAdapter
  {
    public final SparseArray<View> aU = new SparseArray();
    public final Map<Class<? extends View>, Queue<View>> ge = new HashMap();
    public ArrayList<FilterCategoryItem> sd = new ArrayList();
    
    public d() {}
    
    @Nullable
    public View F(int paramInt)
    {
      return (View)this.aU.get(paramInt);
    }
    
    public FilterCategoryItem a(int paramInt)
    {
      paramInt = ef(paramInt);
      if ((paramInt >= 0) && (paramInt < this.sd.size())) {
        return (FilterCategoryItem)this.sd.get(paramInt);
      }
      return null;
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
      FilterCategoryItem localFilterCategoryItem = a(paramInt);
      if (localFilterCategoryItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("VideoFilterViewPager", 2, "instantiateItem find data is null!");
        }
        return null;
      }
      Object localObject1 = (Queue)this.ge.get(localFilterCategoryItem.getClass());
      if (localObject1 != null) {}
      for (localObject1 = (View)((Queue)localObject1).poll();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = ((LayoutInflater)CaptureVideoFilterViewPager.this.getContext().getSystemService("layout_inflater")).inflate(2131558817, null);
          ((View)localObject2).setVisibility(8);
        }
        ((View)localObject2).setContentDescription(localFilterCategoryItem.name + "," + localFilterCategoryItem.bYZ + acfp.m(2131703496));
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
    
    public void update()
    {
      this.sd.clear();
      this.sd.addAll(CaptureVideoFilterViewPager.this.datas);
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */