package com.tencent.qqmini.sdk.utils;

import android.widget.Toast;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.DomainConfig;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

final class DomainUtil$1
  implements Runnable
{
  DomainUtil$1(int paramInt, DomainConfig paramDomainConfig) {}
  
  public void run()
  {
    Toast.makeText(AppLoaderFactory.g().getMiniAppEnv().getContext(), DomainUtil.access$000()[this.val$domainType] + "域名不合法，请配置：" + this.val$requestDomainConfig, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.DomainUtil.1
 * JD-Core Version:    0.7.0.1
 */