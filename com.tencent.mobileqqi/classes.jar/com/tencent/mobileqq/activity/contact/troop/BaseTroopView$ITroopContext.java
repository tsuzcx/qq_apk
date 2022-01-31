package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.WeakReferenceHandler;

public abstract interface BaseTroopView$ITroopContext
{
  public static final int a = 0;
  public static final int b = 1;
  
  public abstract Activity a();
  
  public abstract View a();
  
  public abstract ForwardOperations a();
  
  public abstract QQAppInterface a();
  
  public abstract WeakReferenceHandler a();
  
  public abstract void a(int paramInt, View.OnClickListener paramOnClickListener);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(String paramString);
  
  public abstract boolean a();
  
  public abstract View b();
  
  public abstract View c();
  
  public abstract View d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext
 * JD-Core Version:    0.7.0.1
 */