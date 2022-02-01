package com.tencent.thumbplayer.utils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TPGlobalEventNofication
{
  public static final int EVENT_ID_APP_ENTER_BACKGROUND = 100001;
  public static final int EVENT_ID_APP_ENTER_FOREGROUND = 100002;
  public static final int EVENT_ID_GUID_CHANGED = 100004;
  public static final int EVENT_ID_UPC_CHANGED = 100003;
  private static final String TAG = "TPGlobalEventNofication";
  private static CopyOnWriteArrayList<OnGlobalEventChangeListener> mListeners = new CopyOnWriteArrayList();
  
  public static void addEventListener(OnGlobalEventChangeListener paramOnGlobalEventChangeListener)
  {
    try
    {
      if ((mListeners != null) && (!mListeners.contains(paramOnGlobalEventChangeListener)))
      {
        mListeners.add(paramOnGlobalEventChangeListener);
        TPLogUtil.i("TPGlobalEventNofication", "add onNetStatus change listener: " + paramOnGlobalEventChangeListener + ", mListeners: " + mListeners.size());
      }
      return;
    }
    finally
    {
      paramOnGlobalEventChangeListener = finally;
      throw paramOnGlobalEventChangeListener;
    }
  }
  
  public static void postGlobalEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((OnGlobalEventChangeListener)localIterator.next()).onEvent(paramInt1, paramInt2, paramInt3, paramObject);
      }
    }
    finally {}
  }
  
  public static void removeEventListener(OnGlobalEventChangeListener paramOnGlobalEventChangeListener)
  {
    try
    {
      if (mListeners != null)
      {
        mListeners.remove(paramOnGlobalEventChangeListener);
        TPLogUtil.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + paramOnGlobalEventChangeListener + ", mListeners: " + mListeners.size());
      }
      return;
    }
    finally
    {
      paramOnGlobalEventChangeListener = finally;
      throw paramOnGlobalEventChangeListener;
    }
  }
  
  public static abstract interface OnGlobalEventChangeListener
  {
    public abstract void onEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPGlobalEventNofication
 * JD-Core Version:    0.7.0.1
 */