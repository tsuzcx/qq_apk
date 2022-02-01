package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.token.ew;
import com.tencent.token.go.f;
import com.tencent.token.go.j;
import com.tencent.token.ib;
import com.tencent.token.ic;
import com.tencent.token.iy;

public class ActionBarContainer
  extends FrameLayout
{
  public Drawable a;
  public Drawable b;
  public Drawable c;
  public boolean d;
  public boolean e;
  private boolean f;
  private View g;
  private View h;
  private View i;
  private int j;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = new ic(this);
    } else {
      localObject = new ib(this);
    }
    ew.a(this, (Drawable)localObject);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, go.j.ActionBar);
    this.a = paramContext.getDrawable(go.j.ActionBar_background);
    this.b = paramContext.getDrawable(go.j.ActionBar_backgroundStacked);
    this.j = paramContext.getDimensionPixelSize(go.j.ActionBar_height, -1);
    if (getId() == go.f.split_action_bar)
    {
      this.d = true;
      this.c = paramContext.getDrawable(go.j.ActionBar_backgroundSplit);
    }
    paramContext.recycle();
    boolean bool1 = this.d;
    boolean bool2 = false;
    if (bool1)
    {
      bool1 = bool2;
      if (this.c != null) {}
    }
    else
    {
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (this.a != null) {
          break;
        }
        bool1 = bool2;
      } while (this.b == null);
    }
    setWillNotDraw(bool1);
  }
  
  private static boolean a(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  private static int b(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.a;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.a.setState(getDrawableState());
    }
    localDrawable = this.b;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.b.setState(getDrawableState());
    }
    localDrawable = this.c;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.c.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.g;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.h = findViewById(go.f.action_bar);
    this.i = findViewById(go.f.action_context_bar);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.f) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = this.g;
    paramInt2 = 1;
    paramInt4 = 0;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    Object localObject2;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8))
    {
      int k = getMeasuredHeight();
      localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((View)localObject1).layout(paramInt1, k - ((View)localObject1).getMeasuredHeight() - ((FrameLayout.LayoutParams)localObject2).bottomMargin, paramInt3, k - ((FrameLayout.LayoutParams)localObject2).bottomMargin);
    }
    if (this.d)
    {
      localObject1 = this.c;
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = 0;
      }
    }
    else
    {
      paramInt1 = paramInt4;
      if (this.a != null)
      {
        if (this.h.getVisibility() == 0)
        {
          this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
        }
        else
        {
          localObject2 = this.i;
          if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0)) {
            this.a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
          } else {
            this.a.setBounds(0, 0, 0, 0);
          }
        }
        paramInt1 = 1;
      }
      this.e = paramBoolean;
      if (paramBoolean)
      {
        localObject2 = this.b;
        if (localObject2 != null)
        {
          ((Drawable)localObject2).setBounds(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom());
          paramInt1 = paramInt2;
        }
      }
    }
    if (paramInt1 != 0) {
      invalidate();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = paramInt2;
    if (this.h == null)
    {
      k = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == -2147483648)
      {
        int m = this.j;
        k = paramInt2;
        if (m >= 0) {
          k = View.MeasureSpec.makeMeasureSpec(Math.min(m, View.MeasureSpec.getSize(paramInt2)), -2147483648);
        }
      }
    }
    super.onMeasure(paramInt1, k);
    if (this.h == null) {
      return;
    }
    paramInt2 = View.MeasureSpec.getMode(k);
    View localView = this.g;
    if ((localView != null) && (localView.getVisibility() != 8) && (paramInt2 != 1073741824))
    {
      if (!a(this.h)) {
        paramInt1 = b(this.h);
      } else if (!a(this.i)) {
        paramInt1 = b(this.i);
      } else {
        paramInt1 = 0;
      }
      if (paramInt2 == -2147483648) {
        paramInt2 = View.MeasureSpec.getSize(k);
      } else {
        paramInt2 = 2147483647;
      }
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + b(this.g), paramInt2));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.a);
    }
    this.a = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      paramDrawable = this.h;
      if (paramDrawable != null) {
        this.a.setBounds(paramDrawable.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
      }
    }
    boolean bool2 = this.d;
    boolean bool1 = true;
    if (bool2 ? this.c == null : (this.a != null) || (this.b != null)) {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    invalidate();
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = this.c;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.c);
    }
    this.c = paramDrawable;
    boolean bool2 = false;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.d)
      {
        paramDrawable = this.c;
        if (paramDrawable != null) {
          paramDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
      }
    }
    boolean bool1;
    if (this.d)
    {
      bool1 = bool2;
      if (this.c != null) {}
    }
    else
    {
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (this.a != null) {
          break;
        }
        bool1 = bool2;
      } while (this.b == null);
    }
    setWillNotDraw(bool1);
    invalidate();
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.b);
    }
    this.b = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.e)
      {
        paramDrawable = this.b;
        if (paramDrawable != null) {
          paramDrawable.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
        }
      }
    }
    boolean bool2 = this.d;
    boolean bool1 = true;
    if (bool2 ? this.c == null : (this.a != null) || (this.b != null)) {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    invalidate();
  }
  
  public void setTabContainer(iy paramiy)
  {
    Object localObject = this.g;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.g = paramiy;
    if (paramiy != null)
    {
      addView(paramiy);
      localObject = paramiy.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -1;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      paramiy.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.f = paramBoolean;
    int k;
    if (paramBoolean) {
      k = 393216;
    } else {
      k = 262144;
    }
    setDescendantFocusability(k);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
    localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
    localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    if (paramInt != 0) {
      return super.startActionModeForChild(paramView, paramCallback, paramInt);
    }
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == this.a) && (!this.d)) || ((paramDrawable == this.b) && (this.e)) || ((paramDrawable == this.c) && (this.d)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */