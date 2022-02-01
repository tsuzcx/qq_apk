package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.LayoutParams;
import com.tencent.widget.VerticalGallery.a;
import com.tencent.widget.VerticalGallery.b;
import com.tencent.widget.VerticalGallery.c;
import java.util.ArrayList;
import java.util.List;

public class NumberWheelView
  extends WheelView
  implements AdapterView.e, VerticalGallery.a, VerticalGallery.b, VerticalGallery.c
{
  private final int DEFAULT = 0;
  private final int DEFAULT_GRAVITY = 5;
  private a jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$a;
  private b jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$b;
  public int cAT;
  private final int cAU = 36;
  private final int cAV = 18;
  private final int cAW = -7829368;
  private final int cAX = 1;
  private final int cAY = 19;
  private final int cAZ = -16777216;
  private int cBa;
  private Context mContext;
  private int mMax;
  
  public NumberWheelView(Context paramContext)
  {
    super(paramContext);
    initialize(paramContext);
  }
  
  public NumberWheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize(paramContext);
  }
  
  public NumberWheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize(paramContext);
  }
  
  private void ae(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt != 0) {
        break label30;
      }
      ((WheelTextView)paramView).setTextSize(18.0F);
      ((WheelTextView)paramView).setTextColor(-7829368);
    }
    label30:
    while (paramInt != 1) {
      return;
    }
    ((WheelTextView)paramView).setTextSize(19.0F);
    ((WheelTextView)paramView).setTextColor(-16777216);
  }
  
  private void initialize(Context paramContext)
  {
    this.mContext = paramContext;
    this.cAT = 1;
    this.cBa = 0;
    this.mMax = 0;
    setNeedTranslate(true);
    setScrollCycle(true);
    setOnEndFlingListener(this);
    setOnEndMovementListener(this);
    setOnItemSelectedListener(this);
    setOnSelectViewDataUpdateListener(this);
  }
  
  public int Bp()
  {
    int i = getSelectedItemPosition();
    if ((i < 0) || (i >= this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$a.list.size())) {
      return 0;
    }
    return ((Integer)this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$a.list.get(i)).intValue();
  }
  
  public void a(VerticalGallery paramVerticalGallery)
  {
    this.cAT = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$b.a(this, paramVerticalGallery);
    }
  }
  
  public void af(View paramView, int paramInt)
  {
    ae(paramView, 1);
  }
  
  public void b(VerticalGallery paramVerticalGallery)
  {
    this.cAT = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$b.a(this, paramVerticalGallery);
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (bool) {
      this.cAT = 0;
    }
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$a.getCount();
    paramInt = 0;
    while (paramInt < i)
    {
      ae(paramAdapterView.getChildAt(paramInt), 0);
      paramInt += 1;
    }
    ae(paramView, 1);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (bool) {
      this.cAT = 0;
    }
    return bool;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      this.cBa = paramInt2;
      this.mMax = paramInt1;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$a = new a(this.mContext, 36, this.cBa, this.mMax);
      setAdapter(this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$a);
      return;
      this.mMax = paramInt2;
      this.cBa = paramInt1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$a.setRange(paramInt1, paramInt2);
  }
  
  public void setScrollStateListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$b = paramb;
  }
  
  public void setValue(int paramInt)
  {
    if ((paramInt < this.cBa) || (paramInt > this.mMax)) {
      return;
    }
    setSelection(paramInt - this.cBa);
  }
  
  public class a
    extends BaseAdapter
  {
    public List<Integer> list;
    private Context mContext;
    private int mHeight = 36;
    
    public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    {
      this.mContext = paramContext;
      this.mHeight = ((int)TypedValue.applyDimension(1, paramInt1, this.mContext.getResources().getDisplayMetrics()));
      setRange(paramInt2, paramInt3);
    }
    
    public View H(int paramInt)
    {
      return getView(paramInt, null, null);
    }
    
    public int getCount()
    {
      return this.list.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2 = null;
      Object localObject1;
      if (paramView == null)
      {
        localObject1 = new WheelTextView(this.mContext);
        ((View)localObject1).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.mHeight));
      }
      for (paramView = (WheelTextView)localObject1;; paramView = (View)localObject2)
      {
        localObject2 = paramView;
        if (paramView == null) {
          localObject2 = (WheelTextView)localObject1;
        }
        paramView = String.format("%d", new Object[] { this.list.get(paramInt) });
        ((WheelTextView)localObject2).setTextSize(18.0F);
        ((WheelTextView)localObject2).setTextColor(-7829368);
        ((WheelTextView)localObject2).setGravity(5);
        ((WheelTextView)localObject2).setVisibility(0);
        ((WheelTextView)localObject2).setText(paramView);
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject1 = paramView;
      }
    }
    
    public void setRange(int paramInt1, int paramInt2)
    {
      this.list = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        this.list.add(Integer.valueOf(paramInt1));
        paramInt1 += 1;
      }
      notifyDataSetChanged();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.NumberWheelView
 * JD-Core Version:    0.7.0.1
 */