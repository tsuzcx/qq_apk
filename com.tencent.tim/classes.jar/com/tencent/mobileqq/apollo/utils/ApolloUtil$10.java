package com.tencent.mobileqq.apollo.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class ApolloUtil$10
  implements Runnable
{
  public void run()
  {
    QQToast localQQToast = QQToast.a(BaseApplicationImpl.getApplication(), 1, this.bkd, 1);
    localQQToast.setAutoTextSize();
    localQQToast.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.10
 * JD-Core Version:    0.7.0.1
 */