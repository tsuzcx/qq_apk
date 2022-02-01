package com.tencent.mobileqq.colornote.list;

import aecv;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ColorNoteListLayout
  extends LinearLayout
{
  private int Hu;
  private aecv a;
  private int cMb;
  private View header;
  private int headerHeight = -1;
  private int[] kN = new int[2];
  private RecyclerView recyclerView;
  
  public ColorNoteListLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ColorNoteListLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ColorNoteListLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setOrientation(1);
    this.header = new View(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    addView(this.header, localLayoutParams);
    this.recyclerView = new RecyclerView(paramContext);
    this.recyclerView.setId(2131364914);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    addView(this.recyclerView, paramContext);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if ((paramKeyEvent.getAction() == 1) && (this.a != null)) {
        this.a.cVJ();
      }
      return true;
    }
    return false;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.recyclerView;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!paramBoolean) {
      return;
    }
    Object localObject;
    if (this.headerHeight < 0)
    {
      if (this.recyclerView.getChildCount() <= 0) {
        break label269;
      }
      paramInt1 = this.recyclerView.getChildAt(0).getMeasuredHeight();
      localObject = (RecyclerView.LayoutParams)this.recyclerView.getChildAt(0).getLayoutParams();
      paramInt3 = ((RecyclerView.LayoutParams)localObject).topMargin;
    }
    label269:
    for (paramInt3 = ((RecyclerView.LayoutParams)localObject).bottomMargin + (paramInt1 + paramInt3);; paramInt3 = 0)
    {
      paramInt1 = i;
      int j;
      if (this.recyclerView.getChildCount() <= 4)
      {
        getLocationOnScreen(this.kN);
        paramInt4 = paramInt3 * this.recyclerView.getChildCount();
        j = this.kN[1];
        if (((View)getParent()).getMeasuredHeight() - this.Hu - getPaddingBottom() + j < paramInt4) {
          break label202;
        }
        paramInt1 = this.Hu - j;
      }
      while (paramInt3 > 0)
      {
        this.headerHeight = paramInt1;
        localObject = (LinearLayout.LayoutParams)this.header.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).height = this.headerHeight;
        this.header.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        label202:
        paramInt1 = i;
        if (this.cMb - paramInt2 - getPaddingTop() + j >= paramInt4) {
          paramInt1 = this.cMb - paramInt4 - j;
        }
      }
      break;
      localObject = (LinearLayout.LayoutParams)this.header.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = this.headerHeight;
      this.header.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAnchor(int paramInt1, int paramInt2)
  {
    this.Hu = paramInt1;
    this.cMb = paramInt2;
  }
  
  public void setHideListener(aecv paramaecv)
  {
    this.a = paramaecv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListLayout
 * JD-Core Version:    0.7.0.1
 */