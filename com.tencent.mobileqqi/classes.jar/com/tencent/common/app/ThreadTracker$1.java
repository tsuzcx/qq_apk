package com.tencent.common.app;

import android.os.SystemClock;
import bpw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

final class ThreadTracker$1
  extends ArrayList
{
  ThreadTracker$1(Collection paramCollection)
  {
    super(paramCollection);
  }
  
  public boolean add(WeakReference paramWeakReference)
  {
    boolean bool = super.add(paramWeakReference);
    if (ThreadTracker.a())
    {
      paramWeakReference = (Thread)paramWeakReference.get();
      ThreadTracker.a.add(new bpw(paramWeakReference.getId(), paramWeakReference.getName(), SystemClock.uptimeMillis() - ThreadTracker.a(), new Exception()));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.app.ThreadTracker.1
 * JD-Core Version:    0.7.0.1
 */