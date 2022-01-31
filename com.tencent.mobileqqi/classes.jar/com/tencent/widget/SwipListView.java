package com.tencent.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentAdapter;

public class SwipListView
  extends XListView
  implements Handler.Callback
{
  private static final byte jdField_a_of_type_Byte = 0;
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "SwipListView";
  private static final byte jdField_b_of_type_Byte = 1;
  private static final int jdField_b_of_type_Int = 1;
  private static final byte jdField_c_of_type_Byte = 2;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 300;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private byte jdField_d_of_type_Byte;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private final int k;
  
  public SwipListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new SwipListView.SmoothInterpolator());
    paramContext = ViewConfiguration.get(getContext());
    this.k = paramContext.getScaledTouchSlop();
    this.i = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.e = -1;
    this.g = -1;
    this.f = -1;
    this.h = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.g;
    paramInt1 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      paramView.scrollTo(paramInt3, 0);
      return;
      if (paramInt1 < 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = paramInt1;
      }
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private boolean a(float paramFloat)
  {
    return paramFloat < getWidth() - this.j;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.k) || (paramFloat2 > this.k))
    {
      if ((paramFloat1 > this.k) && (paramFloat2 / paramFloat1 < 0.6F))
      {
        this.d = 1;
        return true;
      }
      this.d = 2;
      return true;
    }
    return false;
  }
  
  private int b()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    return (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int m = 300;
    if (paramInt1 > 0) {
      m = (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return m;
  }
  
  private void c()
  {
    int m = b();
    int n = this.jdField_b_of_type_AndroidViewView.getScrollX();
    if (m > this.i)
    {
      c(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (m < -this.i)
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((m > 0) && (n < this.j * 0.7F))
    {
      c(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((m < 0) && (n > this.j * 0.3F))
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((this.jdField_b_of_type_Boolean) && (n < this.j * 0.7F))
    {
      c(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (n > this.j * 0.3F)
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    c(this.jdField_b_of_type_AndroidViewView);
  }
  
  private void c(View paramView)
  {
    if (paramView != null) {}
    for (int m = paramView.getScrollX();; m = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c = -1;
      }
      if (m != 0) {
        if (!(paramView.getTag(-3) instanceof Integer)) {
          break label119;
        }
      }
      label119:
      for (int n = ((Integer)paramView.getTag(-3)).intValue();; n = 0)
      {
        if ((this.c != paramView) && (this.c != null)) {
          this.c.scrollTo(0, 0);
        }
        d();
        this.c = paramView;
        int i1 = -m;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(m, 0, i1, 0, b(n, i1));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
    }
  }
  
  private boolean c(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.k);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.c = null;
  }
  
  private void d(View paramView)
  {
    int n;
    if (paramView != null)
    {
      n = paramView.getScrollX();
      Object localObject = paramView.getTag(-1);
      m = n;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        m = n;
        if ((localObject instanceof Integer)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c = ((Integer)localObject).intValue();
        }
      }
    }
    for (int m = n;; m = 0)
    {
      n = this.j;
      if ((n == 0) && ((paramView.getTag(-3) instanceof Integer))) {
        n = ((Integer)paramView.getTag(-3)).intValue();
      }
      for (;;)
      {
        if (m != n)
        {
          if ((this.c != paramView) && (this.c != null)) {
            this.c.scrollTo(0, 0);
          }
          d();
          this.c = paramView;
          int i1 = n - m;
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(m, 0, i1, 0, b(n, i1));
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        }
        return;
      }
    }
  }
  
  public void b()
  {
    int m;
    int n;
    if (!c(this.jdField_b_of_type_AndroidViewView))
    {
      m = q() - k();
      n = r();
    }
    for (;;)
    {
      if (m <= n)
      {
        View localView = getChildAt(m);
        if (c(localView)) {
          this.jdField_b_of_type_AndroidViewView = localView;
        }
      }
      else
      {
        c(this.jdField_b_of_type_AndroidViewView);
        return;
      }
      m += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      float f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.c != null)
      {
        this.c.scrollTo((int)f1, 0);
        invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return true;
      }
      this.c = null;
      return true;
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.c != null)
      {
        this.c.scrollTo((int)f1, 0);
        invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return true;
      }
      this.c = null;
      return true;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a();
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool2;
    }
    int n = (int)(paramMotionEvent.getX() + 0.5F);
    int m = (int)(paramMotionEvent.getY() + 0.5F);
    int i1 = paramMotionEvent.getAction();
    label72:
    boolean bool1;
    switch (i1)
    {
    default: 
      bool1 = false;
      label75:
      if ((i1 == 0) && (this.jdField_b_of_type_Boolean))
      {
        Conversation.d(false);
        d();
      }
      break;
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.d = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c = -1;
      }
      this.e = n;
      this.g = n;
      this.f = m;
      this.h = m;
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      this.jdField_b_of_type_Boolean = c(this.jdField_a_of_type_AndroidViewView);
      int i2;
      int i3;
      if (!this.jdField_b_of_type_Boolean)
      {
        i2 = q();
        i3 = k();
        m = r();
      }
      for (;;)
      {
        if (m >= i2 - i3)
        {
          View localView = getChildAt(m);
          this.jdField_b_of_type_Boolean = c(localView);
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_AndroidViewView = localView;
          }
        }
        else
        {
          this.j = 0;
          this.jdField_b_of_type_AndroidViewView = null;
          m = a(this.e, this.f);
          if (m >= 0)
          {
            this.jdField_b_of_type_AndroidViewView = getChildAt(m - q());
            if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView.getTag(-3) instanceof Integer))) {
              this.j = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(-3)).intValue();
            }
          }
          if ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView) && (!a(n)))) {
            break label355;
          }
          bool1 = true;
          break;
        }
        m -= 1;
      }
      label355:
      bool1 = false;
      break label75;
      if (this.j <= 0) {
        break label72;
      }
      if (this.d == 0) {
        a(Math.abs(n - this.e), Math.abs(m - this.f));
      }
      if (this.d != 1) {
        break label72;
      }
      if (n < this.e) {}
      for (bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        bool1 = bool2;
        break;
      }
      if (this.jdField_b_of_type_Boolean) {
        c(this.jdField_a_of_type_AndroidViewView);
      }
      this.e = -1;
      this.g = -1;
      this.f = -1;
      this.h = -1;
      break label72;
      if ((i1 == 1) || (i1 == 3)) {
        Conversation.d(true);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool2 = super.onTouchEvent(paramMotionEvent);
      return bool2;
    }
    a(paramMotionEvent);
    int m = (int)(paramMotionEvent.getX() + 0.5F);
    int n = (int)(paramMotionEvent.getY() + 0.5F);
    int i1 = paramMotionEvent.getAction();
    boolean bool1;
    switch (i1)
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((i1 == 0) && (this.jdField_b_of_type_Boolean))
        {
          Conversation.d(false);
          label99:
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return super.onTouchEvent(paramMotionEvent);
          if ((this.jdField_b_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(m)))) {}
          for (bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!this.jdField_b_of_type_Boolean) {
              break;
            }
            bool1 = bool2;
            if (this.jdField_a_of_type_AndroidViewView == this.jdField_b_of_type_AndroidViewView) {
              break;
            }
            c(this.jdField_a_of_type_AndroidViewView);
            bool1 = bool2;
            break;
          }
          if (this.jdField_b_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(m)))
            {
              bool2 = true;
              label221:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.d == 0)
                {
                  bool1 = bool2;
                  if (!a(Math.abs(m - this.e), Math.abs(n - this.f))) {
                    continue;
                  }
                }
                bool1 = bool2;
                if (this.d == 1)
                {
                  a(m, n, this.jdField_b_of_type_AndroidViewView, this.j);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.g = m;
      this.h = n;
      break;
      bool2 = false;
      break label221;
      if (this.j == 0)
      {
        bool1 = false;
      }
      else
      {
        if ((this.d == 0) && (!a(Math.abs(m - this.e), Math.abs(n - this.f))))
        {
          bool1 = false;
          break;
        }
        if (this.d == 1)
        {
          a(m, n, this.jdField_b_of_type_AndroidViewView, this.j);
          bool1 = true;
          continue;
          if (this.jdField_b_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(m)))
            {
              bool2 = true;
              label433:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.d != 1) {
                  break label496;
                }
                c();
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            F();
            this.e = -1;
            this.g = -1;
            this.f = -1;
            this.h = -1;
            break;
            bool2 = false;
            break label433;
            label496:
            c(this.jdField_b_of_type_AndroidViewView);
            bool1 = bool2;
            continue;
            if (this.j == 0)
            {
              bool1 = false;
            }
            else
            {
              if (this.d == 1)
              {
                c();
                bool1 = true;
                continue;
                if ((i1 != 1) && (i1 != 3)) {
                  break label99;
                }
                Conversation.d(true);
                break label99;
              }
              bool1 = false;
            }
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter instanceof RecentAdapter))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = ((RecentAdapter)paramListAdapter);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
  }
  
  public void setDragEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.SwipListView
 * JD-Core Version:    0.7.0.1
 */