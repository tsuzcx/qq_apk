package com.tencent.mobileqq.apollo.utils;

import abhh;
import abxf;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ApolloConfigDataReport$1
  implements Runnable
{
  public ApolloConfigDataReport$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.val$app == null) {
      return;
    }
    ((abhh)this.val$app.getManager(153)).a("https://cmshow.gtimg.cn/xydata/cmshow/app/terminalCmConfig/xydata.json", ApolloUtil.bkc, new abxf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.1
 * JD-Core Version:    0.7.0.1
 */