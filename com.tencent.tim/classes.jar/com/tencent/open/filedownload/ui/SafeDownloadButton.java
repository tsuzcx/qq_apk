package com.tencent.open.filedownload.ui;

import acfp;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import anot;
import arwk;
import arwm;
import arwn;
import arwt;
import aryr;
import asan;
import asap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class SafeDownloadButton
  extends ApkFileDownloadButton
{
  private static final String cDX = acfp.m(2131713983);
  private static final String cDY = acfp.m(2131713986);
  private long awS;
  private asap d;
  private boolean ddJ;
  private boolean ddK;
  
  public SafeDownloadButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SafeDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SafeDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String DF()
  {
    try
    {
      String str = "tmast://download?downl_url=" + URLEncoder.encode(this.d.url, "UTF-8") + "&down_ticket=" + URLEncoder.encode(this.d.url, "UTF-8") + "&oplist=1;2&via=" + this.d.via;
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return "";
  }
  
  private void ecV()
  {
    String str = DF();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", str);
    aryr.dJ(localBundle);
    aryr.dK(localBundle);
    arwt.i("SafeDownloadButton_", "writeTmastCmd success! jumpUrl=" + str);
  }
  
  private void emw()
  {
    if ((this.d == null) || (TextUtils.isEmpty(this.d.url))) {
      return;
    }
    arwk.b(arwm.a().a("200").k(this.d.pageId).j(this.d.kx).l(this.d.cDH).m(this.d.via).a(this.d.name).b(this.d.packageName).g(this.d.url));
    QQAppInterface localQQAppInterface = ((BaseActivity)getContext()).app;
    if (this.c.name == null) {}
    for (String str = "";; str = this.c.name)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "1", "", str, "");
      emx();
      return;
    }
  }
  
  private void emx()
  {
    String str = DF();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    try
    {
      BaseApplication.getContext().startActivity(localIntent);
      arwt.i("SafeDownloadButton_", "goToYYBByTmast success! jumpUrl=" + str);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      arwt.e("SafeDownloadButton_", "ActivityNotFoundException e=" + localActivityNotFoundException.getMessage());
    }
  }
  
  protected void D(DownloadInfo paramDownloadInfo)
  {
    this.ddJ = true;
    ecV();
    super.D(paramDownloadInfo);
  }
  
  protected String DD()
  {
    return acfp.m(2131713988);
  }
  
  protected void Us(boolean paramBoolean)
  {
    if (asan.akW())
    {
      this.c.state = 1;
      updateUI();
      emw();
      return;
    }
    super.Us(paramBoolean);
  }
  
  protected void Xw(String paramString)
  {
    if (TextUtils.equals(paramString, "com.tencent.android.qqdownloader"))
    {
      arwt.i("SafeDownloadButton_", acfp.m(2131713985) + this.ddJ);
      if (this.ddJ)
      {
        this.ddK = true;
        this.awS = System.currentTimeMillis();
        ThreadManager.getUIHandler().post(new SafeDownloadButton.1(this));
      }
    }
  }
  
  protected void dC(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (("900".equals(paramString)) || ("400".equals(paramString))))
    {
      localQQAppInterface = ((BaseActivity)getContext()).app;
      if (this.c.name != null) {
        break label73;
      }
    }
    label73:
    for (paramString = "";; paramString = this.c.name)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "2", "", paramString, "");
      return;
    }
  }
  
  protected String gw(int paramInt)
  {
    if (paramInt == 1) {
      return cDX;
    }
    return cDY;
  }
  
  protected String gx(int paramInt)
  {
    if (paramInt == 4) {
      return acfp.m(2131713987);
    }
    return acfp.m(2131713984);
  }
  
  public void onResume()
  {
    long l = System.currentTimeMillis();
    arwt.i("SafeDownloadButton_", "onResume " + this.ddK + ",currentTimestamp=" + l + ",mYYBInstallSuccessTimestamp= " + this.awS);
    if (this.ddK)
    {
      if (l - this.awS < 5000L) {
        emx();
      }
      this.ddK = false;
    }
  }
  
  public void setOriApkInfo(asap paramasap)
  {
    this.d = asap.a(paramasap);
  }
  
  protected void vG()
  {
    this.ddJ = true;
    ecV();
    super.vG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.SafeDownloadButton
 * JD-Core Version:    0.7.0.1
 */