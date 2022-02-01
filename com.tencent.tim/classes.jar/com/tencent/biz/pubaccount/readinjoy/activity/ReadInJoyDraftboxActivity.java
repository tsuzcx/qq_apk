package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import kxm;
import msg;

public class ReadInJoyDraftboxActivity
  extends IphoneTitleBarActivity
{
  protected ReadInJoyDraftboxFragment a;
  protected QQAppInterface mApp;
  
  private void initUI()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    msg.a().nR(this.mApp.getCurrentAccountUin());
    setContentView(2131558505);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(new TopEdgeGestureLayout(this));
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.a = new ReadInJoyDraftboxFragment();
    localFragmentTransaction.add(2131367554, this.a);
    localFragmentTransaction.show(this.a);
    localFragmentTransaction.commit();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
    initUI();
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyDraftboxActivity
 * JD-Core Version:    0.7.0.1
 */