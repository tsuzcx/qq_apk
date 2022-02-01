package com.tencent.mobileqq.troop.createNewTroop;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class AbsNewTroopBaseView
  extends FrameLayout
{
  public NewTroopCreateActivity a;
  protected QQAppInterface app;
  
  public AbsNewTroopBaseView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AbsNewTroopBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsNewTroopBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void Rs(boolean paramBoolean) {}
  
  public void a(NewTroopCreateActivity paramNewTroopCreateActivity)
  {
    this.a = paramNewTroopCreateActivity;
    this.app = paramNewTroopCreateActivity.app;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected boolean onBackEvent()
  {
    return false;
  }
  
  protected void onDestroy() {}
  
  protected void onPause() {}
  
  protected void onResume() {}
  
  protected void onStart() {}
  
  protected void onStop() {}
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.AbsNewTroopBaseView
 * JD-Core Version:    0.7.0.1
 */