package com.tencent.token;

import android.view.View;

public abstract interface fi
{
  public abstract boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2);
  
  public abstract void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  public abstract void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt);
  
  public abstract boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt);
  
  public abstract void onStopNestedScroll(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fi
 * JD-Core Version:    0.7.0.1
 */