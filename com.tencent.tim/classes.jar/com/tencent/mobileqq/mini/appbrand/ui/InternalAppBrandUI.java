package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.fake.FakeInternalBrandUI;
import com.tencent.mobileqq.mini.fake.IFakeBrandUI;

public class InternalAppBrandUI
  extends AppBrandUI
{
  public IFakeBrandUI getFakeBrandUI()
  {
    if (this.mFakeBrandUI == null) {
      this.mFakeBrandUI = new FakeInternalBrandUI();
    }
    return this.mFakeBrandUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.InternalAppBrandUI
 * JD-Core Version:    0.7.0.1
 */