package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders;

import com.tencent.qphone.base.util.QLog;
import npm.a;
import npx;

public class StyleLoaderHelper$DummyCallback$1
  implements Runnable
{
  public StyleLoaderHelper$DummyCallback$1(npm.a parama, String paramString, int paramInt) {}
  
  public void run()
  {
    QLog.d("TemplateFactory", 1, "check style config param: " + this.val$param + " code: " + this.val$code);
    if (this.val$code == 0) {
      this.a.aS(this.val$param, this.val$code);
    }
    npx.n(npm.a.a(this.a), this.val$param, this.val$code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.DummyCallback.1
 * JD-Core Version:    0.7.0.1
 */