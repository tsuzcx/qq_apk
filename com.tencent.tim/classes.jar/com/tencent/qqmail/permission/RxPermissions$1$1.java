package com.tencent.qqmail.permission;

import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

class RxPermissions$1$1
  implements Func1<List<Permission>, Observable<Boolean>>
{
  RxPermissions$1$1(RxPermissions.1 param1) {}
  
  public Observable<Boolean> call(List<Permission> paramList)
  {
    if (paramList.isEmpty()) {
      return Observable.empty();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!((Permission)paramList.next()).granted) {
        return Observable.just(Boolean.valueOf(false));
      }
    }
    return Observable.just(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.RxPermissions.1.1
 * JD-Core Version:    0.7.0.1
 */