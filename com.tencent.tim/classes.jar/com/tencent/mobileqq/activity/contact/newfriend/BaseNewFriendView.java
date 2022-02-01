package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseNewFriendView
  extends FrameLayout
{
  public a a;
  public QQAppInterface app;
  private boolean isFinishing;
  protected Intent mIntent;
  private boolean mIsLoading;
  
  public BaseNewFriendView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(Intent paramIntent, a parama)
  {
    this.mIntent = paramIntent;
    this.a = parama;
    this.app = this.a.getApp();
  }
  
  protected void finish()
  {
    this.isFinishing = true;
    this.a.getActivity().finish();
  }
  
  protected final void hg()
  {
    this.mIsLoading = false;
    if (!isFinishing()) {
      this.a.hg();
    }
  }
  
  protected final boolean isFinishing()
  {
    return this.isFinishing;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((20000 == paramInt1) && (paramInt2 != 0))
    {
      this.a.getActivity().setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  protected void onDestroy() {}
  
  protected void onPause() {}
  
  protected void onResume() {}
  
  protected void onStart()
  {
    this.isFinishing = false;
    if (this.mIsLoading)
    {
      this.a.hf();
      return;
    }
    this.a.hg();
  }
  
  protected void onStop()
  {
    hg();
    this.isFinishing = true;
  }
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.a.getActivity().startActivityForResult(paramIntent, paramInt);
  }
  
  public static abstract interface a
  {
    public abstract boolean Uj();
    
    public abstract void clf();
    
    public abstract Activity getActivity();
    
    public abstract QQAppInterface getApp();
    
    public abstract void hf();
    
    public abstract void hg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView
 * JD-Core Version:    0.7.0.1
 */