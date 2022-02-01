package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class ContactBaseView
  extends FrameLayout
{
  public a a;
  public QQAppInterface app;
  public Activity mContext;
  
  public ContactBaseView(a parama)
  {
    super(parama.getActivity());
    this.a = parama;
    this.mContext = this.a.getActivity();
    this.app = parama.getApp();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public int xg()
  {
    return getResources().getDimensionPixelSize(2131298554);
  }
  
  public static abstract interface a
  {
    public abstract void cjO();
    
    public abstract void cjP();
    
    public abstract Activity getActivity();
    
    public abstract QQAppInterface getApp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
 * JD-Core Version:    0.7.0.1
 */