package com.tencent.token;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class iv
  extends ListView
{
  private final Rect a = new Rect();
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f;
  private Field g;
  private a h;
  private boolean i;
  private boolean j;
  private boolean k;
  private fd l;
  private fy m;
  private b n;
  
  public iv(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, gs.a.dropDownListViewStyle);
    this.j = paramBoolean;
    setCacheColorHint(0);
    try
    {
      this.g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.g.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (this.k) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    a locala = this.h;
    if (locala != null) {
      locala.b = paramBoolean;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt2 = getListPaddingTop();
    int i1 = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    paramInt3 = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null) {
      return paramInt2 + i1;
    }
    if ((paramInt3 <= 0) || (localObject == null)) {
      paramInt3 = 0;
    }
    int i6 = localListAdapter.getCount();
    paramInt2 += i1;
    localObject = null;
    i1 = 0;
    int i4 = 0;
    int i5;
    for (int i2 = 0; i1 < i6; i2 = i5)
    {
      i5 = localListAdapter.getItemViewType(i1);
      int i3 = i4;
      if (i5 != i4)
      {
        localObject = null;
        i3 = i5;
      }
      View localView = localListAdapter.getView(i1, (View)localObject, this);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = generateDefaultLayoutParams();
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (((ViewGroup.LayoutParams)localObject).height > 0) {
        i4 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);
      } else {
        i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
      localView.measure(paramInt1, i4);
      localView.forceLayout();
      i4 = paramInt2;
      if (i1 > 0) {
        i4 = paramInt2 + paramInt3;
      }
      paramInt2 = i4 + localView.getMeasuredHeight();
      if (paramInt2 >= paramInt4)
      {
        if ((paramInt5 >= 0) && (i1 > paramInt5) && (i2 > 0) && (paramInt2 != paramInt4)) {
          return i2;
        }
        return paramInt4;
      }
      i5 = i2;
      if (paramInt5 >= 0)
      {
        i5 = i2;
        if (i1 >= paramInt5) {
          i5 = paramInt2;
        }
      }
      i1 += 1;
      i4 = i3;
      localObject = localView;
    }
    return paramInt2;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i2 = paramMotionEvent.getActionMasked();
    int i1 = 1;
    boolean bool;
    switch (i2)
    {
    default: 
      bool = true;
      paramInt = 0;
      break;
    case 3: 
      bool = false;
      paramInt = 0;
      break;
    case 2: 
      bool = true;
      break;
    case 1: 
      bool = false;
    }
    int i3 = paramMotionEvent.findPointerIndex(paramInt);
    Object localObject1;
    float f1;
    float f2;
    Object localObject2;
    float f3;
    float f4;
    Object localObject3;
    if (i3 < 0)
    {
      bool = false;
      paramInt = 0;
    }
    else
    {
      paramInt = (int)paramMotionEvent.getX(i3);
      int i4 = (int)paramMotionEvent.getY(i3);
      i3 = pointToPosition(paramInt, i4);
      if (i3 == -1)
      {
        paramInt = i1;
      }
      else
      {
        localObject1 = getChildAt(i3 - getFirstVisiblePosition());
        f1 = paramInt;
        f2 = i4;
        this.k = true;
        if (Build.VERSION.SDK_INT >= 21) {
          drawableHotspotChanged(f1, f2);
        }
        if (!isPressed()) {
          setPressed(true);
        }
        layoutChildren();
        paramInt = this.f;
        if (paramInt != -1)
        {
          localObject2 = getChildAt(paramInt - getFirstVisiblePosition());
          if ((localObject2 != null) && (localObject2 != localObject1) && (((View)localObject2).isPressed())) {
            ((View)localObject2).setPressed(false);
          }
        }
        this.f = i3;
        f3 = ((View)localObject1).getLeft();
        f4 = ((View)localObject1).getTop();
        if (Build.VERSION.SDK_INT >= 21) {
          ((View)localObject1).drawableHotspotChanged(f1 - f3, f2 - f4);
        }
        if (!((View)localObject1).isPressed()) {
          ((View)localObject1).setPressed(true);
        }
        localObject2 = getSelector();
        if ((localObject2 != null) && (i3 != -1)) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0) {
          ((Drawable)localObject2).setVisible(false, false);
        }
        localObject3 = this.a;
        ((Rect)localObject3).set(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom());
        ((Rect)localObject3).left -= this.b;
        ((Rect)localObject3).top -= this.c;
        ((Rect)localObject3).right += this.d;
        ((Rect)localObject3).bottom += this.e;
      }
    }
    for (;;)
    {
      try
      {
        bool = this.g.getBoolean(this);
        if (((View)localObject1).isEnabled() != bool)
        {
          localObject3 = this.g;
          if (bool) {
            break label729;
          }
          bool = true;
          ((Field)localObject3).set(this, Boolean.valueOf(bool));
          if (i3 != -1) {
            refreshDrawableState();
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      if (paramInt != 0)
      {
        Rect localRect = this.a;
        f3 = localRect.exactCenterX();
        f4 = localRect.exactCenterY();
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((Drawable)localObject2).setVisible(bool, false);
        dk.a((Drawable)localObject2, f3, f4);
      }
      localObject2 = getSelector();
      if ((localObject2 != null) && (i3 != -1)) {
        dk.a((Drawable)localObject2, f1, f2);
      }
      setSelectorEnabled(false);
      refreshDrawableState();
      if (i2 == 1) {
        performItemClick((View)localObject1, i3, getItemIdAtPosition(i3));
      }
      bool = true;
      paramInt = 0;
      if ((!bool) || (paramInt != 0))
      {
        this.k = false;
        setPressed(false);
        drawableStateChanged();
        localObject1 = getChildAt(this.f - getFirstVisiblePosition());
        if (localObject1 != null) {
          ((View)localObject1).setPressed(false);
        }
        localObject1 = this.l;
        if (localObject1 != null)
        {
          ((fd)localObject1).b();
          this.l = null;
        }
      }
      if (bool)
      {
        if (this.m == null) {
          this.m = new fy(this);
        }
        this.m.a(true);
        this.m.onTouch(this, paramMotionEvent);
        return bool;
      }
      paramMotionEvent = this.m;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(false);
      }
      return bool;
      label729:
      bool = false;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.a.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.a);
        localDrawable.draw(paramCanvas);
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.n != null) {
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    a();
  }
  
  public boolean hasFocus()
  {
    return (this.j) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.j) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.j) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((this.j) && (this.i)) || (super.isInTouchMode());
  }
  
  protected void onDetachedFromWindow()
  {
    this.n = null;
    super.onDetachedFromWindow();
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return super.onHoverEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getActionMasked();
    if ((i1 == 10) && (this.n == null))
    {
      this.n = new b((byte)0);
      b localb = this.n;
      localb.a.post(localb);
    }
    boolean bool = super.onHoverEvent(paramMotionEvent);
    if ((i1 != 9) && (i1 != 7))
    {
      setSelection(-1);
      return bool;
    }
    i1 = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((i1 != -1) && (i1 != getSelectedItemPosition()))
    {
      paramMotionEvent = getChildAt(i1 - getFirstVisiblePosition());
      if (paramMotionEvent.isEnabled()) {
        setSelectionFromTop(i1, paramMotionEvent.getTop() - getTop());
      }
      a();
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.f = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    b localb = this.n;
    if (localb != null)
    {
      localb.a.n = null;
      localb.a.removeCallbacks(localb);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setListSelectionHidden(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      localObject = new a(paramDrawable);
    } else {
      localObject = null;
    }
    this.h = ((a)localObject);
    super.setSelector(this.h);
    Object localObject = new Rect();
    if (paramDrawable != null) {
      paramDrawable.getPadding((Rect)localObject);
    }
    this.b = ((Rect)localObject).left;
    this.c = ((Rect)localObject).top;
    this.d = ((Rect)localObject).right;
    this.e = ((Rect)localObject).bottom;
  }
  
  static final class a
    extends gw
  {
    boolean b = true;
    
    a(Drawable paramDrawable)
    {
      super();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (this.b) {
        super.draw(paramCanvas);
      }
    }
    
    public final void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (this.b) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
    }
    
    public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.b) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public final boolean setState(int[] paramArrayOfInt)
    {
      if (this.b) {
        return super.setState(paramArrayOfInt);
      }
      return false;
    }
    
    public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (this.b) {
        return super.setVisible(paramBoolean1, paramBoolean2);
      }
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      iv.a(iv.this);
      iv.this.drawableStateChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.iv
 * JD-Core Version:    0.7.0.1
 */