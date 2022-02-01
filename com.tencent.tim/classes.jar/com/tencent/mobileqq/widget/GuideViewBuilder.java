package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import arfw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class GuideViewBuilder
{
  GuideView a;
  private SparseArray<b> dP = new SparseArray();
  public PopupWindow m;
  Context mContext;
  
  public GuideViewBuilder(Context paramContext)
  {
    this.mContext = paramContext;
    this.a = new GuideView(paramContext);
    this.m = new PopupWindow(this.mContext);
    this.m.setWindowLayoutMode(-1, -1);
    this.m.setFocusable(true);
    this.m.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(2131165640)));
  }
  
  public GuideViewBuilder a(int paramInt, View paramView, a parama)
  {
    b localb = (b)this.dP.get(paramInt);
    if (localb != null) {
      localb.Dl.add(new Pair(paramView, parama));
    }
    return this;
  }
  
  public GuideViewBuilder a(View paramView, int paramInt)
  {
    if (this.dP.get(paramInt) == null)
    {
      b localb = new b(null);
      localb.mTargetView = paramView;
      if (paramView.isShown())
      {
        localb.ds = new int[2];
        paramView.getLocationOnScreen(localb.ds);
      }
      this.dP.put(paramInt, localb);
    }
    return this;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.m.setContentView(this.a);
    this.m.showAtLocation(new View(this.mContext), 0, 0, 0);
    this.m.setOnDismissListener(paramOnDismissListener);
    this.a.setOnClickListener(new arfw(this, paramBoolean));
  }
  
  public void b(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  class GuideView
    extends FrameLayout
  {
    RectF mRect = new RectF();
    int[] pj = new int[2];
    
    public GuideView(Context paramContext)
    {
      super();
      setWillNotDraw(false);
    }
    
    private FrameLayout.LayoutParams a(GuideViewBuilder.b paramb, GuideViewBuilder.a parama)
    {
      if (parama.width == -9) {
        parama.width = (paramb.mTargetView.getMeasuredWidth() + -parama.egm * 2);
      }
      if (parama.height == -9) {
        parama.height = (paramb.mTargetView.getMeasuredHeight() + -parama.egn * 2);
      }
      if (parama.egm != 2147483647)
      {
        parama.gravity |= 0x3;
        parama.leftMargin = (paramb.ds[0] + parama.egm - this.pj[0]);
      }
      if (parama.egn != 2147483647)
      {
        parama.gravity |= 0x30;
        parama.topMargin = (paramb.ds[1] + parama.egn - this.pj[1]);
      }
      return parama;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      try
      {
        getLocationOnScreen(this.pj);
        int i = 0;
        while (i < GuideViewBuilder.a(GuideViewBuilder.this).size())
        {
          GuideViewBuilder.b localb = (GuideViewBuilder.b)GuideViewBuilder.a(GuideViewBuilder.this).valueAt(i);
          if (localb.ds == null)
          {
            localb.ds = new int[2];
            localb.mTargetView.getLocationOnScreen(localb.ds);
          }
          i += 1;
        }
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GuideView", 2, "getLocationOnScreen Null Pointer");
        }
      }
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      int i = 0;
      while (i < GuideViewBuilder.a(GuideViewBuilder.this).size())
      {
        GuideViewBuilder.b localb = (GuideViewBuilder.b)GuideViewBuilder.a(GuideViewBuilder.this).valueAt(i);
        int j = paramCanvas.save();
        this.mRect.set(localb.ds[0], localb.ds[1], localb.ds[0] + localb.mTargetView.getMeasuredWidth(), localb.ds[1] + localb.mTargetView.getMeasuredHeight());
        this.mRect.offset(-this.pj[0], -this.pj[1]);
        paramCanvas.clipRect(this.mRect);
        localb.mTargetView.getRootView().draw(paramCanvas);
        paramCanvas.restoreToCount(j);
        i += 1;
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      paramInt1 = 0;
      while (paramInt1 < GuideViewBuilder.a(GuideViewBuilder.this).size())
      {
        GuideViewBuilder.b localb = (GuideViewBuilder.b)GuideViewBuilder.a(GuideViewBuilder.this).valueAt(paramInt1);
        Iterator localIterator = localb.Dl.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          if (indexOfChild((View)localPair.first) == -1)
          {
            Object localObject = ((View)localPair.first).getLayoutParams();
            if (localPair.second != null) {
              localObject = a(localb, (GuideViewBuilder.a)localPair.second);
            }
            if (localObject != null) {
              addViewInLayout((View)localPair.first, -1, (ViewGroup.LayoutParams)localObject);
            }
          }
        }
        paramInt1 += 1;
      }
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        int i = 0;
        while (i < GuideViewBuilder.a(GuideViewBuilder.this).size())
        {
          GuideViewBuilder.b localb = (GuideViewBuilder.b)GuideViewBuilder.a(GuideViewBuilder.this).valueAt(i);
          if ((paramMotionEvent.getX() > localb.ds[0]) && (paramMotionEvent.getX() < localb.ds[0] + localb.mTargetView.getMeasuredWidth()) && (paramMotionEvent.getY() > localb.ds[1]) && (paramMotionEvent.getY() < localb.ds[1] + localb.mTargetView.getMeasuredHeight()) && (localb.onClickListener != null))
          {
            GuideViewBuilder.this.m.dismiss();
            localb.onClickListener.onClick(localb.mTargetView);
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static class a
    extends FrameLayout.LayoutParams
  {
    public int egm;
    public int egn;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }
  }
  
  class b
  {
    ArrayList<Pair<View, GuideViewBuilder.a>> Dl = new ArrayList();
    int[] ds;
    View mTargetView;
    View.OnClickListener onClickListener = null;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuideViewBuilder
 * JD-Core Version:    0.7.0.1
 */