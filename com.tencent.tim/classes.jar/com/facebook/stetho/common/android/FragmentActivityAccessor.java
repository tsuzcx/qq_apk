package com.facebook.stetho.common.android;

import android.app.Activity;
import javax.annotation.Nullable;

public abstract interface FragmentActivityAccessor<FRAGMENT_ACTIVITY extends Activity, FRAGMENT_MANAGER>
{
  @Nullable
  public abstract FRAGMENT_MANAGER getFragmentManager(FRAGMENT_ACTIVITY paramFRAGMENT_ACTIVITY);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.FragmentActivityAccessor
 * JD-Core Version:    0.7.0.1
 */