package com.tencent.mobileqq.apollo.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class ApolloUtil$9
  implements Runnable
{
  ApolloUtil$9(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), this.val$msg, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.9
 * JD-Core Version:    0.7.0.1
 */