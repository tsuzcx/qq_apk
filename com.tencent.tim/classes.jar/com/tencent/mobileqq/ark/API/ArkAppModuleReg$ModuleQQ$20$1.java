package com.tencent.mobileqq.ark.API;

import adnq.c;
import adnu;
import adst;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;

public class ArkAppModuleReg$ModuleQQ$20$1
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$20$1(adnu paramadnu, String paramString) {}
  
  public void run()
  {
    ark.VariantWrapper localVariantWrapper1 = this.a.this$0.a(this.a.Vc);
    if (localVariantWrapper1 == null)
    {
      adst.a().a(null);
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetNull();
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    localVariantWrapper2.SetTableAsJsonString(this.val$info);
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
    localVariantWrapper3.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
    QLog.i("ArkApp", 1, "QQ.ChooseImage callback : " + this.val$info);
    adst.a().a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.20.1
 * JD-Core Version:    0.7.0.1
 */