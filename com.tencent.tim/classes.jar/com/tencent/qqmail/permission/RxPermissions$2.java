package com.tencent.qqmail.permission;

import rx.Observable;
import rx.Observable.Transformer;

class RxPermissions$2
  implements Observable.Transformer<Object, Permission>
{
  RxPermissions$2(RxPermissions paramRxPermissions, String[] paramArrayOfString) {}
  
  public Observable<Permission> call(Observable<Object> paramObservable)
  {
    return RxPermissions.access$000(this.this$0, paramObservable, this.val$permissions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.RxPermissions.2
 * JD-Core Version:    0.7.0.1
 */