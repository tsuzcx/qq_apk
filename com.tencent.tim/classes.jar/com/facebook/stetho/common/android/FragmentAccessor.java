package com.facebook.stetho.common.android;

import android.content.res.Resources;
import android.view.View;
import javax.annotation.Nullable;

public abstract interface FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER>
{
  public static final int NO_ID = 0;
  
  @Nullable
  public abstract FRAGMENT_MANAGER getChildFragmentManager(FRAGMENT paramFRAGMENT);
  
  @Nullable
  public abstract FRAGMENT_MANAGER getFragmentManager(FRAGMENT paramFRAGMENT);
  
  public abstract int getId(FRAGMENT paramFRAGMENT);
  
  public abstract Resources getResources(FRAGMENT paramFRAGMENT);
  
  @Nullable
  public abstract String getTag(FRAGMENT paramFRAGMENT);
  
  @Nullable
  public abstract View getView(FRAGMENT paramFRAGMENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.FragmentAccessor
 * JD-Core Version:    0.7.0.1
 */