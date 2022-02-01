package com.tencent.qqmail.permission;

import rx.Observable;
import rx.functions.Func1;

class RxPermissions$3
  implements Func1<Object, Observable<Permission>>
{
  RxPermissions$3(RxPermissions paramRxPermissions, String[] paramArrayOfString) {}
  
  public Observable<Permission> call(Object paramObject)
  {
    return RxPermissions.access$100(this.this$0, this.val$permissions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.RxPermissions.3
 * JD-Core Version:    0.7.0.1
 */