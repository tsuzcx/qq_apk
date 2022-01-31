package android.support.v4.app;

import android.support.annotation.StringRes;

public abstract interface FragmentManager$BackStackEntry
{
  public abstract CharSequence getBreadCrumbShortTitle();
  
  @StringRes
  public abstract int getBreadCrumbShortTitleRes();
  
  public abstract CharSequence getBreadCrumbTitle();
  
  @StringRes
  public abstract int getBreadCrumbTitleRes();
  
  public abstract int getId();
  
  public abstract String getName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManager.BackStackEntry
 * JD-Core Version:    0.7.0.1
 */