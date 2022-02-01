package com.tencent.mobileqq.mini.fake;

import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.IAppUIProxy;

public class FakeInternalBrandUI
  extends FakeBrandUI
{
  public IAppUIProxy getAppUIProxy()
  {
    if (this.mAppUIProxy == null) {
      this.mAppUIProxy = AppLoaderFactory.createInternalAppUIProxy();
    }
    return this.mAppUIProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.fake.FakeInternalBrandUI
 * JD-Core Version:    0.7.0.1
 */