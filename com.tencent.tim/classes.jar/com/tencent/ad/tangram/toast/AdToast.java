package com.tencent.ad.tangram.toast;

import android.content.Context;
import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdToast
{
  INSTANCE;
  
  public static final int ICON_DEFAULT = 0;
  public static final int ICON_ERROR = 1;
  public static final int ICON_SUCCESS = 2;
  private WeakReference<AdToastAdapter> adapter;
  
  private AdToast() {}
  
  private static AdToastAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdToastAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdToastAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static void show(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    AdToastAdapter localAdToastAdapter = getAdapter();
    if (localAdToastAdapter != null) {
      localAdToastAdapter.show(paramContext, paramInt1, paramCharSequence, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.toast.AdToast
 * JD-Core Version:    0.7.0.1
 */