package com.tencent.mobileqq.apollo.view;

import aboy;
import abzx.a;
import android.app.Activity;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, abzx.a parama) {}
  
  public void run()
  {
    aboy localaboy = aboy.a(this.bki);
    if ((localaboy == null) || (localaboy.mContextRef == null) || (localaboy.mContextRef.get() != this.val$activity))
    {
      this.a.a(false, localaboy);
      return;
    }
    this.a.a(true, localaboy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */