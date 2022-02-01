package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ProteusAnimationItemData
  extends ProteusItemData
{
  private int awd;
  @Deprecated
  private View mView;
  
  public void setView(View paramView)
  {
    this.mView = paramView;
    ThreadManager.getUIHandler().post(new ProteusAnimationItemData.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData
 * JD-Core Version:    0.7.0.1
 */