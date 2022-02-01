package com.facebook.stetho.common.android;

import java.util.List;
import javax.annotation.Nullable;

public abstract interface FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT>
{
  @Nullable
  public abstract List<FRAGMENT> getAddedFragments(FRAGMENT_MANAGER paramFRAGMENT_MANAGER);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.FragmentManagerAccessor
 * JD-Core Version:    0.7.0.1
 */