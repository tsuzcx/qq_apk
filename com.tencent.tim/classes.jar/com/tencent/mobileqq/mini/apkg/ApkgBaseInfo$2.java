package com.tencent.mobileqq.mini.apkg;

import acfp;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;

class ApkgBaseInfo$2
  implements Runnable
{
  ApkgBaseInfo$2(ApkgBaseInfo paramApkgBaseInfo, int paramInt, DomainConfig paramDomainConfig) {}
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), ApkgBaseInfo.access$000()[this.val$domainType] + acfp.m(2131702427) + this.val$requestDomainConfig, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgBaseInfo.2
 * JD-Core Version:    0.7.0.1
 */