package com.tencent.mobileqq.troop.widget;

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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import apvb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.lang.reflect.Field;

public class PinnedHeaderIphoneTreeView
  extends PinnedHeaderExpandableListView
{
  public View IS;
  public View IT;
  public final Rect bF = new Rect();
  public View bu;
  public boolean cSA;
  public boolean cSB;
  public int dXa = -1;
  public Drawable fH;
  public Drawable fI;
  public View.OnTouchListener y = new apvb(this);
  
  public PinnedHeaderIphoneTreeView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.fH = ((Drawable)getField("mGroupIndicator"));
    setGroupIndicator(this.fH);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (getExpandableListAdapter() == null) {}
    for (;;)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        return;
      }
      catch (NullPointerException paramCanvas)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PinnedHeaderIphoneTreeView", 2, paramCanvas.getMessage());
        return;
      }
      int m = getChildCount();
      Object localObject3;
      Object localObject1;
      label74:
      int j;
      int i;
      int k;
      label104:
      Object localObject4;
      Object localObject5;
      switch (m)
      {
      default: 
        localObject3 = getChildAt(0);
        localObject1 = getChildAt(1);
        this.cSA = true;
        j = getFirstVisiblePosition();
        i = j;
        if (Build.VERSION.SDK_INT < 8) {
          i = j - getHeaderViewsCount();
        }
        k = 0;
        localObject4 = localObject1;
        localObject5 = localObject3;
        j = i;
        if (k < m)
        {
          localObject5 = getChildAt(k);
          if ((((View)localObject5).getBottom() > 0) && (k + 1 < m))
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
            break label760;
          }
          if ((this.IS == null) || (this.cSB) || (this.dXa != i))
          {
            this.dXa = i;
            this.IS = getExpandableListAdapter().getGroupView(i, true, this.bu, this);
            this.IS.setSelected(((View)localObject5).isSelected());
            this.IS.setOnTouchListener(this.y);
          }
          if (this.IS != this.bu) {
            this.bu = this.IS;
          }
          if (getPackedPositionType(l) == 0) {
            this.IT = ((View)localObject5);
          }
          g(this.IS, i, 0, ((View)localObject5).getWidth());
          this.IS.layout(0, 0, this.IS.getMeasuredWidth(), this.IS.getMeasuredHeight());
        }
        break;
      }
      try
      {
        for (;;)
        {
          super.dispatchDraw(paramCanvas);
          if (this.IS != null)
          {
            if ((getPackedPositionType(getExpandableListPosition(j + 1)) != 0) || (localObject4 == null)) {
              break label809;
            }
            i = ((View)localObject4).getTop();
            j = this.IS.getBottom();
            if (i >= j) {
              break label809;
            }
            localObject1 = getDivider();
            i -= j;
            paramCanvas.translate(0.0F, i);
            if (this.IS.isPressed())
            {
              localObject3 = getSelector();
              ((Drawable)localObject3).setBounds(new Rect(((Drawable)localObject3).getBounds().left, this.IS.getTop(), ((Drawable)localObject3).getBounds().right, this.IS.getBottom()));
              getSelector().draw(paramCanvas);
            }
            paramCanvas.translate(getPaddingLeft(), 0.0F);
            this.IS.draw(paramCanvas);
            paramCanvas.translate(-getPaddingLeft(), 0.0F);
            if (this.fI != null)
            {
              if (this.fI.isStateful()) {
                this.fI.setState(new int[] { 16842920 });
              }
              localObject3 = (Integer)getField("mIndicatorLeft");
              localObject4 = (Integer)getField("mIndicatorRight");
              localObject5 = this.fI;
              if (localObject3 != null) {
                break label790;
              }
              j = 0;
              m = this.IS.getTop();
              if (localObject4 != null) {
                break label799;
              }
              k = 0;
              ((Drawable)localObject5).setBounds(j, m, k, this.IS.getBottom());
              this.fI.draw(paramCanvas);
            }
            if (localObject1 != null)
            {
              ((Drawable)localObject1).setBounds(this.IS.getLeft(), this.IS.getBottom() - getDividerHeight(), this.IS.getRight(), this.IS.getBottom());
              paramCanvas.clipRect(this.IS.getLeft(), this.IS.getBottom() - getDividerHeight() + i, this.IS.getRight(), this.IS.getBottom() + i);
            }
            paramCanvas.translate(0.0F, -i);
          }
          this.cSB = false;
          this.cSA = false;
          return;
          try
          {
            super.dispatchDraw(paramCanvas);
            return;
          }
          catch (NullPointerException paramCanvas) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PinnedHeaderIphoneTreeView", 2, paramCanvas.getMessage());
          return;
          localObject3 = getChildAt(0);
          localObject1 = null;
          break label74;
          k += 1;
          break label104;
          label760:
          this.IS = null;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("PinnedHeaderIphoneTreeView", 2, localNullPointerException.getMessage());
            continue;
            label790:
            j = ((Integer)localObject3).intValue();
            continue;
            label799:
            k = ((Integer)localObject4).intValue();
            continue;
            label809:
            Object localObject2 = null;
            i = 0;
          }
        }
      }
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
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = true;
    if (paramView != this.IT) {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
    return bool;
  }
  
  public void g(View paramView, int paramInt1, int paramInt2, int paramInt3)
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
  
  public Object getField(String paramString)
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
  
  public boolean isInFilterMode()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView
 * JD-Core Version:    0.7.0.1
 */