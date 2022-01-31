package com.tencent.token.ui;

import com.tencent.token.ui.base.GuideQQPimSecureTipsView;
import com.tmsdk.TMSDKContext;

class acb
  implements Runnable
{
  acb(aca paramaca) {}
  
  public void run()
  {
    UtilsActivity.access$2100(this.a.a).setDownloadUrl("http://qqwx.qq.com/s?aid=index&p=1&c=107015&vt=1&pf=0");
    UtilsActivity.access$2100(this.a.a).setVisibility(0);
    TMSDKContext.saveActionData(1150102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acb
 * JD-Core Version:    0.7.0.1
 */