package com.tencent.qqmini.proxyimpl;

import asvw;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class NavigationProxyImpl$1
  implements Runnable
{
  public NavigationProxyImpl$1(asvw paramasvw, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    MiniAppInfo.saveMiniAppShowInfoEntity(this.val$miniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */