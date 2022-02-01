package com.tencent.mobileqq.ark.API;

import acfp;
import adnq.c;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ArkAppModuleReg$ModuleQQ$1
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$1(adnq.c paramc) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication == null) {
      return;
    }
    QQToast.a(localBaseApplication, acfp.m(2131700838), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.1
 * JD-Core Version:    0.7.0.1
 */