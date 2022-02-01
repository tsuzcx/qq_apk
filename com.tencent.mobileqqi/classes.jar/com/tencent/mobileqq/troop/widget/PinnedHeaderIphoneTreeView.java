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
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView;
import gzg;
import java.lang.reflect.Field;

public class PinnedHeaderIphoneTreeView
  extends PinnedHeaderExpandableListView
{
  public static final String a = "PinnedHeaderIphoneTreeView";
  public static final boolean b = false;
  public final Rect a;
  public Drawable a;
  public View.OnTouchListener a;
  public int b;
  public Drawable b;
  public View b;
  public View c;
  public boolean c;
  public View d;
  public boolean d;
  
  public PinnedHeaderIphoneTreeView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new gzg(this);
    b();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new gzg(this);
    b();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new gzg(this);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)a("mGroupIndicator"));
    setGroupIndicator(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public Object a(String paramString)
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
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
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
  
  protected boolean a()
  {
    return true;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (a() == null)
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
      this.jdField_c_of_type_Boolean = true;
      j = q();
      i = j;
      if (Build.VERSION.SDK_INT < 8) {
        i = j - k();
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
        long l = b(j);
        i = c(l);
        b(l);
        this.jdField_c_of_type_AndroidViewView = null;
        if ((i == -1) || (!e(i))) {
          break label728;
        }
        if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_d_of_type_Boolean) || (this.jdField_b_of_type_Int != i))
        {
          this.jdField_b_of_type_Int = i;
          this.jdField_b_of_type_AndroidViewView = a().getGroupView(i, true, this.jdField_d_of_type_AndroidViewView, this);
          this.jdField_b_of_type_AndroidViewView.setSelected(((View)localObject3).isSelected());
          this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        }
        if (this.jdField_b_of_type_AndroidViewView != this.jdField_d_of_type_AndroidViewView) {
          this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
        }
        if (b(l) == 0) {
          this.jdField_c_of_type_AndroidViewView = ((View)localObject3);
        }
        a(this.jdField_b_of_type_AndroidViewView, i, 0, ((View)localObject3).getWidth());
        this.jdField_b_of_type_AndroidViewView.layout(0, 0, this.jdField_b_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_b_of_type_AndroidViewView.getMeasuredHeight());
        label323:
        super.dispatchDraw(paramCanvas);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          if ((b(b(j + 1)) != 0) || (localObject4 == null)) {
            break label755;
          }
          i = ((View)localObject4).getTop();
          j = this.jdField_b_of_type_AndroidViewView.getBottom();
          if (i >= j) {
            break label755;
          }
          localObject1 = b();
          i -= j;
        }
      }
      break;
    }
    for (;;)
    {
      paramCanvas.translate(0.0F, i);
      if (this.jdField_b_of_type_AndroidViewView.isPressed())
      {
        localObject2 = a();
        ((Drawable)localObject2).setBounds(new Rect(((Drawable)localObject2).getBounds().left, this.jdField_b_of_type_AndroidViewView.getTop(), ((Drawable)localObject2).getBounds().right, this.jdField_b_of_type_AndroidViewView.getBottom()));
        a().draw(paramCanvas);
      }
      paramCanvas.translate(getPaddingLeft(), 0.0F);
      this.jdField_b_of_type_AndroidViewView.draw(paramCanvas);
      paramCanvas.translate(-getPaddingLeft(), 0.0F);
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.isStateful()) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(new int[] { 16842920 });
        }
        localObject2 = (Integer)a("mIndicatorLeft");
        localObject3 = (Integer)a("mIndicatorRight");
        localObject4 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (localObject2 != null) {
          break label736;
        }
        j = 0;
        label554:
        m = this.jdField_b_of_type_AndroidViewView.getTop();
        if (localObject3 != null) {
          break label745;
        }
      }
      label728:
      label736:
      label745:
      for (k = 0;; k = ((Integer)localObject3).intValue())
      {
        ((Drawable)localObject4).setBounds(j, m, k, this.jdField_b_of_type_AndroidViewView.getBottom());
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        if (localObject1 != null)
        {
          ((Drawable)localObject1).setBounds(this.jdField_b_of_type_AndroidViewView.getLeft(), this.jdField_b_of_type_AndroidViewView.getBottom() - v(), this.jdField_b_of_type_AndroidViewView.getRight(), this.jdField_b_of_type_AndroidViewView.getBottom());
          paramCanvas.clipRect(this.jdField_b_of_type_AndroidViewView.getLeft(), this.jdField_b_of_type_AndroidViewView.getBottom() - v() + i, this.jdField_b_of_type_AndroidViewView.getRight(), this.jdField_b_of_type_AndroidViewView.getBottom() + i);
        }
        paramCanvas.translate(0.0F, -i);
        this.jdField_d_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        return;
        super.dispatchDraw(paramCanvas);
        return;
        localObject2 = getChildAt(0);
        localObject1 = null;
        break;
        k += 1;
        break label88;
        this.jdField_b_of_type_AndroidViewView = null;
        break label323;
        j = ((Integer)localObject2).intValue();
        break label554;
      }
      label755:
      localObject1 = null;
      i = 0;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      if (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        bool = this.jdField_b_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent);
        if (bool) {
          return bool;
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidViewView.setPressed(false);
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
    if (paramView != this.jdField_c_of_type_AndroidViewView) {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
    return bool;
  }
  
  public View getChildAt(int paramInt)
  {
    View localView = super.getChildAt(paramInt);
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_AndroidViewView != null) && (localView == this.jdField_c_of_type_AndroidViewView)) {
        super.setGroupIndicator(null);
      }
    }
    else {
      return localView;
    }
    super.setGroupIndicator(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return localView;
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void setGroupIndicator(Drawable paramDrawable)
  {
    super.setGroupIndicator(paramDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if ((paramDrawable != null) && (paramDrawable != this.jdField_b_of_type_AndroidGraphicsDrawableDrawable)) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView
 * JD-Core Version:    0.7.0.1
 */