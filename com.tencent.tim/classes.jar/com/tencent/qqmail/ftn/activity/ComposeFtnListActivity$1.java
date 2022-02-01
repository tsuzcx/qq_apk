package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.Observable;

class ComposeFtnListActivity$1
  extends IObserver
{
  ComposeFtnListActivity$1(ComposeFtnListActivity paramComposeFtnListActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    FtnManager.sharedInstance().getList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.ComposeFtnListActivity.1
 * JD-Core Version:    0.7.0.1
 */