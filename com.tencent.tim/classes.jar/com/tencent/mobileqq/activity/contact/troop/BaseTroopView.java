package com.tencent.mobileqq.activity.contact.troop;

import acci;
import ahgq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import aurf;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseTroopView
  extends FrameLayout
{
  public a a;
  public QQAppInterface app;
  protected int cbx;
  public boolean isChecked;
  protected boolean isFinishing = true;
  View rootView;
  View yg;
  View yh;
  View yi;
  
  public BaseTroopView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(Intent paramIntent, a parama)
  {
    this.a = parama;
    this.app = this.a.getApp();
    this.yg = this.a.aT();
    this.yh = this.a.aU();
    this.rootView = this.a.getRootView();
    this.yi = this.a.aV();
  }
  
  public void aJ(int paramInt, boolean paramBoolean)
  {
    this.a.aJ(paramInt, paramBoolean);
  }
  
  public void addObserver(acci paramacci)
  {
    if (this.app != null) {
      this.app.addObserver(paramacci);
    }
  }
  
  public void cml()
  {
    this.isChecked = true;
  }
  
  public void cmm()
  {
    this.isChecked = false;
  }
  
  public void cmn() {}
  
  public Activity getActivity()
  {
    return this.a.getActivity();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final boolean isFinishing()
  {
    return this.isFinishing;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void onDestroy() {}
  
  protected void onPause() {}
  
  protected void onResume() {}
  
  protected void onStart()
  {
    this.isFinishing = false;
  }
  
  protected void onStop()
  {
    this.isFinishing = true;
  }
  
  public void removeObserver(acci paramacci)
  {
    if (this.app != null) {
      this.app.removeObserver(paramacci);
    }
  }
  
  public void sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    this.a.c().sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
    setBackgroundDrawable(null);
  }
  
  protected final void showToast(int paramInt)
  {
    showToast(getResources().getString(paramInt));
  }
  
  protected final void showToast(String paramString)
  {
    if (!isFinishing()) {
      this.a.showToast(paramString);
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivityForResult(paramIntent, 0);
  }
  
  protected final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.a.getActivity().startActivityForResult(paramIntent, paramInt);
  }
  
  public static abstract interface a
  {
    public abstract TextView K();
    
    public abstract boolean UG();
    
    public abstract boolean UH();
    
    public abstract ahgq a();
    
    public abstract void aJ(int paramInt, boolean paramBoolean);
    
    public abstract View aT();
    
    public abstract View aU();
    
    public abstract View aV();
    
    public abstract aurf c();
    
    public abstract Activity getActivity();
    
    public abstract QQAppInterface getApp();
    
    public abstract View getRootView();
    
    public abstract void runOnUiThread(Runnable paramRunnable);
    
    public abstract void showToast(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.BaseTroopView
 * JD-Core Version:    0.7.0.1
 */