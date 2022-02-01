package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class cr<E>
  extends cp
{
  public final Activity b;
  public final Context c;
  public final Handler d;
  final int e;
  public final ct f = new ct();
  
  private cr(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    this.b = paramActivity;
    this.c = paramContext;
    this.d = paramHandler;
    this.e = 0;
  }
  
  protected cr(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, paramFragmentActivity.mHandler);
  }
  
  public View a(int paramInt)
  {
    return null;
  }
  
  protected void a(Fragment paramFragment) {}
  
  public void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public LayoutInflater c()
  {
    return LayoutInflater.from(this.c);
  }
  
  public void d() {}
  
  public boolean e()
  {
    return true;
  }
  
  public int f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cr
 * JD-Core Version:    0.7.0.1
 */