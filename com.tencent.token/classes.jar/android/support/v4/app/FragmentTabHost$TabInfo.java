package android.support.v4.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

final class FragmentTabHost$TabInfo
{
  @Nullable
  final Bundle args;
  @NonNull
  final Class clss;
  Fragment fragment;
  @NonNull
  final String tag;
  
  FragmentTabHost$TabInfo(@NonNull String paramString, @NonNull Class paramClass, @Nullable Bundle paramBundle)
  {
    this.tag = paramString;
    this.clss = paramClass;
    this.args = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost.TabInfo
 * JD-Core Version:    0.7.0.1
 */