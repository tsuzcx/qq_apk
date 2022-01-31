package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.view.View;

public abstract interface DrawerLayout$DrawerListener
{
  public abstract void onDrawerClosed(@NonNull View paramView);
  
  public abstract void onDrawerOpened(@NonNull View paramView);
  
  public abstract void onDrawerSlide(@NonNull View paramView, float paramFloat);
  
  public abstract void onDrawerStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout.DrawerListener
 * JD-Core Version:    0.7.0.1
 */