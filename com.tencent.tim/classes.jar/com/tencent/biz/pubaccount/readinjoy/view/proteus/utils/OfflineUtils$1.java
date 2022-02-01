package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import npi;
import npl;

public final class OfflineUtils$1
  implements Runnable
{
  public OfflineUtils$1(boolean paramBoolean) {}
  
  public void run()
  {
    if (this.atO) {
      return;
    }
    npi.reset();
    npi.a("default_feeds", true);
    new npl().aZV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils.1
 * JD-Core Version:    0.7.0.1
 */