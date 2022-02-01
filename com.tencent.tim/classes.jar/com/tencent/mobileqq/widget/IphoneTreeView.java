package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import argd;
import java.lang.reflect.Field;

public class IphoneTreeView
  extends ExpandableListView
{
  public View IS;
  private View IT;
  private final Rect bF = new Rect();
  private View bu;
  private boolean cSA;
  private boolean cSB;
  public int dXa = -1;
  private Drawable fH;
  private Drawable fI;
  private View.OnTouchListener y = new argd(this);
  
  public IphoneTreeView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public IphoneTreeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public IphoneTreeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void g(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2, 0);
      paramView.setLayoutParams(localLayoutParams1);
    }
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, getPaddingLeft() + getPaddingRight(), paramInt3);
    paramInt1 = localLayoutParams1.height;
    if (paramInt1 > 0) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt2, paramInt1);
      return;
    }
  }
  
  private Object getField(String paramString)
  {
    try
    {
      paramString = ExpandableListView.class.getDeclaredField(paramString);
      if (!paramString.isAccessible()) {
        paramString.setAccessible(true);
      }
      paramString = paramString.get(this);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void init()
  {
    this.fH = ((Drawable)getField("mGroupIndicator"));
    setGroupIndicator(this.fH);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (getExpandableListAdapter() == null)
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    int m = getChildCount();
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    int k;
    label88:
    Object localObject4;
    Object localObject3;
    switch (m)
    {
    default: 
      localObject2 = getChildAt(0);
      localObject1 = getChildAt(1);
      this.cSA = true;
      j = getFirstVisiblePosition();
      i = j;
      if (Build.VERSION.SDK_INT < 8) {
        i = j - getHeaderViewsCount();
      }
      k = 0;
      localObject4 = localObject1;
      localObject3 = localObject2;
      j = i;
      if (k < m)
      {
        localObject3 = getChildAt(k);
        if ((((View)localObject3).getBottom() > 0) && (k + 1 < m))
        {
          localObject4 = getChildAt(k + 1);
          j = i + k;
        }
      }
      else
      {
        long l = getExpandableListPosition(j);
        i = getPackedPositionGroup(l);
        getPackedPositionType(l);
        this.IT = null;
        if ((i == -1) || (!isGroupExpanded(i))) {
          break label722;
        }
        if ((this.IS == null) || (this.cSB) || (this.dXa != i))
        {
          this.dXa = i;
          this.IS = getExpandableListAdapter().getGroupView(i, true, this.bu, this);
          this.IS.setSelected(((View)localObject3).isSelected());
          this.IS.setOnTouchListener(this.y);
        }
        if (this.IS != this.bu) {
          this.bu = this.IS;
        }
        if (getPackedPositionType(l) == 0) {
          this.IT = ((View)localObject3);
        }
        g(this.IS, i, 0, ((View)localObject3).getWidth());
        this.IS.layout(0, 0, this.IS.getMeasuredWidth(), this.IS.getMeasuredHeight());
        label323:
        super.dispatchDraw(paramCanvas);
        if (this.IS != null)
        {
          if ((getPackedPositionType(getExpandableListPosition(j + 1)) != 0) || (localObject4 == null)) {
            break label749;
          }
          i = ((View)localObject4).getTop();
          j = this.IS.getBottom();
          if (i >= j) {
            break label749;
          }
          localObject1 = getDivider();
          i -= j;
        }
      }
      break;
    }
    for (;;)
    {
      paramCanvas.translate(0.0F, i);
      if (this.IS.isPressed())
      {
        localObject2 = getSelector();
        ((Drawable)localObject2).setBounds(new Rect(((Drawable)localObject2).getBounds().left, this.IS.getTop(), ((Drawable)localObject2).getBounds().right, this.IS.getBottom()));
        getSelector().draw(paramCanvas);
      }
      paramCanvas.translate(getPaddingLeft(), 0.0F);
      this.IS.draw(paramCanvas);
      paramCanvas.translate(-getPaddingLeft(), 0.0F);
      if (this.fI.isStateful()) {
        this.fI.setState(new int[] { 16842920 });
      }
      localObject2 = (Integer)getField("mIndicatorLeft");
      localObject3 = (Integer)getField("mIndicatorRight");
      localObject4 = this.fI;
      if (localObject2 == null)
      {
        j = 0;
        label548:
        m = this.IS.getTop();
        if (localObject3 != null) {
          break label739;
        }
      }
      label722:
      label739:
      for (k = 0;; k = ((Integer)localObject3).intValue())
      {
        ((Drawable)localObject4).setBounds(j, m, k, this.IS.getBottom());
        this.fI.draw(paramCanvas);
        if (localObject1 != null)
        {
          ((Drawable)localObject1).setBounds(this.IS.getLeft(), this.IS.getBottom() - getDividerHeight(), this.IS.getRight(), this.IS.getBottom());
          paramCanvas.clipRect(this.IS.getLeft(), this.IS.getBottom() - getDividerHeight() + i, this.IS.getRight(), this.IS.getBottom() + i);
        }
        paramCanvas.translate(0.0F, -i);
        this.cSB = false;
        this.cSA = false;
        return;
        super.dispatchDraw(paramCanvas);
        return;
        localObject2 = getChildAt(0);
        localObject1 = null;
        break;
        k += 1;
        break label88;
        this.IS = null;
        break label323;
        j = ((Integer)localObject2).intValue();
        break label548;
      }
      label749:
      localObject1 = null;
      i = 0;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (this.IS != null)
    {
      this.IS.getGlobalVisibleRect(this.bF);
      if (this.bF.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        bool = this.IS.dispatchTouchEvent(paramMotionEvent);
        if (bool) {
          return bool;
        }
      }
      else
      {
        this.IS.setPressed(false);
        invalidate();
      }
    }
    try
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = true;
    if (paramView != this.IT) {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
    return bool;
  }
  
  public View getChildAt(int paramInt)
  {
    View localView = super.getChildAt(paramInt);
    if (this.cSA)
    {
      if ((this.IS != null) && (localView == this.IT)) {
        super.setGroupIndicator(null);
      }
    }
    else {
      return localView;
    }
    super.setGroupIndicator(this.fH);
    return localView;
  }
  
  protected boolean isInFilterMode()
  {
    return true;
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.cSB = true;
  }
  
  public void setGroupIndicator(Drawable paramDrawable)
  {
    super.setGroupIndicator(paramDrawable);
    this.fH = paramDrawable;
    if ((paramDrawable != null) && (paramDrawable != this.fI)) {
      this.fI = paramDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IphoneTreeView
 * JD-Core Version:    0.7.0.1
 */