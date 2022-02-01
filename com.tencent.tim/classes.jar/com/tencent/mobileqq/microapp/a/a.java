package com.tencent.mobileqq.microapp.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;

public class a
{
  private static volatile a b;
  private a a;
  private final BroadcastReceiver c = new b(this);
  
  public static a a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a();
      }
      return b;
    }
    finally {}
  }
  
  public void a(a parama)
  {
    this.a = parama;
    parama = new IntentFilter();
    parama.addAction("android.intent.action.SCREEN_ON");
    parama.addAction("android.intent.action.SCREEN_OFF");
    BaseApplication.getContext().registerReceiver(this.c, parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(Context paramContext, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.a
 * JD-Core Version:    0.7.0.1
 */