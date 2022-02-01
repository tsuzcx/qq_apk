package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import aifl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

class BridgeModule$10
  implements Runnable
{
  BridgeModule$10(BridgeModule paramBridgeModule) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((aifl)((QQAppInterface)localAppRuntime).getManager(306)).preload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.10
 * JD-Core Version:    0.7.0.1
 */