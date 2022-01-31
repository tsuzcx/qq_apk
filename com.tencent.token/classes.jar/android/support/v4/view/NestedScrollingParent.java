package android.support.v4.view;

import android.support.annotation.NonNull;
import android.view.View;

public abstract interface NestedScrollingParent
{
  public abstract int getNestedScrollAxes();
  
  public abstract boolean onNestedFling(@NonNull View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract boolean onNestedPreFling(@NonNull View paramView, float paramFloat1, float paramFloat2);
  
  public abstract void onNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt);
  
  public abstract void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt);
  
  public abstract boolean onStartNestedScroll(@NonNull View paramView1, @NonNull View paramView2, int paramInt);
  
  public abstract void onStopNestedScroll(@NonNull View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.NestedScrollingParent
 * JD-Core Version:    0.7.0.1
 */