package com.tencent.component.utils.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;

class OptimizedSharedPreferencesWrapper$2
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  OptimizedSharedPreferencesWrapper$2(OptimizedSharedPreferencesWrapper paramOptimizedSharedPreferencesWrapper) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = OptimizedSharedPreferencesWrapper.access$200(OptimizedSharedPreferencesWrapper.access$100(this.this$0), paramString);
    if ((paramSharedPreferences != null) || (TextUtils.isEmpty(OptimizedSharedPreferencesWrapper.access$100(this.this$0)))) {
      OptimizedSharedPreferencesWrapper.access$300(this.this$0, paramSharedPreferences);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.component.utils.preference.OptimizedSharedPreferencesWrapper.2
 * JD-Core Version:    0.7.0.1
 */