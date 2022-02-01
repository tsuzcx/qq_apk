package com.tencent.qqmini.sdk.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;

class AddPhoneNumberFragment$9
  implements View.OnClickListener
{
  AddPhoneNumberFragment$9(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(AddPhoneNumberFragment.access$900(this.this$0)))
    {
      ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      localChannelProxy.sendVerifySmsCodeRequest(AddPhoneNumberFragment.access$900(this.this$0), AddPhoneNumberFragment.access$200(this.this$0), "+86", new AddPhoneNumberFragment.9.1(this, localChannelProxy));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.9
 * JD-Core Version:    0.7.0.1
 */