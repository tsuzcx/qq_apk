package com.tencent.qqmail.permission;

import rx.Observable;
import rx.Observable.Transformer;

class RxPermissions$1
  implements Observable.Transformer<Object, Boolean>
{
  RxPermissions$1(RxPermissions paramRxPermissions, String[] paramArrayOfString) {}
  
  public Observable<Boolean> call(Observable<Object> paramObservable)
  {
    return RxPermissions.access$000(this.this$0, paramObservable, this.val$permissions).buffer(this.val$permissions.length).flatMap(new RxPermissions.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.RxPermissions.1
 * JD-Core Version:    0.7.0.1
 */