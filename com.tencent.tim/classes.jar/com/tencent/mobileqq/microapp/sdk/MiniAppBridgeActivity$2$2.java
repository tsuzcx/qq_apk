package com.tencent.mobileqq.microapp.sdk;

import android.support.v4.app.FragmentActivity;
import cooperation.qwallet.plugin.FakeUrl.FakeInfo;
import cooperation.qwallet.plugin.FakeUrl.FakeListener;

class MiniAppBridgeActivity$2$2
  implements FakeUrl.FakeListener
{
  MiniAppBridgeActivity$2$2(MiniAppBridgeActivity.2 param2) {}
  
  public boolean onBlHandleFakeurl(FakeUrl.FakeInfo paramFakeInfo, int paramInt)
  {
    this.this$1.this$0.getActivity().finish();
    return false;
  }
  
  public boolean onClickUrl(String paramString)
  {
    this.this$1.this$0.getActivity().finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.2.2
 * JD-Core Version:    0.7.0.1
 */