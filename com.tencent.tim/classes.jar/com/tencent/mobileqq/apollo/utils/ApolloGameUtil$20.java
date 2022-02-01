package com.tencent.mobileqq.apollo.utils;

import acfp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class ApolloGameUtil$20
  implements Runnable
{
  ApolloGameUtil$20(int paramInt) {}
  
  public void run()
  {
    switch (this.val$result)
    {
    default: 
      QQToast.a(BaseApplicationImpl.getApplication(), 1, acfp.m(2131702511), 0).show();
    case 1: 
      return;
    case 0: 
      QQToast.a(BaseApplicationImpl.getApplication(), 2, acfp.m(2131702487), 0).show();
      return;
    case 2: 
      QQToast.a(BaseApplicationImpl.getApplication(), 1, acfp.m(2131702499), 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2, acfp.m(2131702503), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.20
 * JD-Core Version:    0.7.0.1
 */