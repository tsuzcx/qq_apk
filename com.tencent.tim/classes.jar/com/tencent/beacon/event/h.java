package com.tencent.beacon.event;

import android.support.annotation.NonNull;
import com.tencent.beacon.event.open.EventResult;

public abstract interface h
{
  public abstract EventResult a(String paramString, @NonNull EventBean paramEventBean);
  
  public abstract void a();
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a(Runnable paramRunnable);
  
  public abstract EventResult b(String paramString, @NonNull EventBean paramEventBean);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.h
 * JD-Core Version:    0.7.0.1
 */