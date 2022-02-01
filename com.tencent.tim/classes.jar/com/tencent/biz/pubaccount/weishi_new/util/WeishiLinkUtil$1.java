package com.tencent.biz.pubaccount.weishi_new.util;

import cooperation.qzone.LocalMultiProcConfig;
import opa;

public final class WeishiLinkUtil$1
  implements Runnable
{
  public WeishiLinkUtil$1(int paramInt) {}
  
  public void run()
  {
    LocalMultiProcConfig.putInt("weishi_usergrowth", opa.access$000(), this.bfA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil.1
 * JD-Core Version:    0.7.0.1
 */