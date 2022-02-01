package com.tencent.mobileqq.filemanager.activity;

import agcz;
import agda;
import agdb;
import agdc;
import aghq;
import agkh;
import agne;
import agxi.a;
import ahav;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import aprc;
import aqgz;
import aurr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import smq;
import smq.j;
import sms;

public class TroopFileZipPreviewActivity
  extends IphoneTitleBarActivity
{
  public short H = 0;
  public XListView N;
  ForwardFileInfo a;
  public String aEI;
  public String aEJ;
  public String aEK;
  public String aEL;
  public sms b;
  int busId;
  Context context;
  private aghq f = new agdc(this);
  public String filePath;
  int fileType;
  public boolean mIsHttps = false;
  public long nSessionId = 0L;
  public List<agxi.a> pw = new ArrayList();
  public String str_download_dns;
  long troopUin;
  
  private smq.j a(FileManagerEntity paramFileManagerEntity)
  {
    return new agda(this, paramFileManagerEntity);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, smq.j paramj)
  {
    String str;
    ArrayList localArrayList;
    boolean bool;
    if (paramBoolean)
    {
      str = "https://";
      str = str + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + aurr.encodeUrl(paramString4) + "&";
      localArrayList = new ArrayList();
      if (paramFileManagerEntity.getCloudType() != 2) {
        break label273;
      }
      bool = true;
      label97:
      if (!bool) {
        break label279;
      }
      paramString5 = "FTN5K=" + paramString5;
    }
    label273:
    label279:
    for (;;)
    {
      paramString1 = new aprc(str, "GET", new agdb(this, localArrayList, paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramj), 1000, null);
      paramString2 = new Bundle();
      paramString2.putString("version", aqgz.getQQVersion());
      paramString2.putString("Cookie", paramString5);
      if (paramBoolean) {
        paramString2.putString("Referer", "https://" + paramString6);
      }
      paramString3 = new HashMap();
      paramString3.put("BUNDLE", paramString2);
      paramString3.put("CONTEXT", this.app.getApp().getApplicationContext());
      paramString1.J(paramString3);
      return;
      str = "http://";
      break;
      bool = false;
      break label97;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 10099) && (paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false)))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("isNeedFinish", true);
      setResult(-1, paramIntent);
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.context = this;
    this.a = ((ForwardFileInfo)getIntent().getParcelableExtra("fileinfo"));
    this.busId = getIntent().getIntExtra("busId", 0);
    this.troopUin = getIntent().getLongExtra("troop_uin", 0L);
    this.str_download_dns = getIntent().getStringExtra("str_download_dns");
    this.aEI = getIntent().getStringExtra("int32_server_port");
    this.aEJ = getIntent().getStringExtra("string_download_url");
    this.aEK = getIntent().getStringExtra("str_cookie_val");
    this.filePath = getIntent().getStringExtra("filepath");
    paramBundle = getIntent().getStringExtra("filename");
    this.nSessionId = getIntent().getLongExtra("nSessionId", 0L);
    this.mIsHttps = getIntent().getBooleanExtra("isHttps", false);
    this.aEL = getIntent().getStringExtra("httpsDomain");
    this.H = getIntent().getShortExtra("httpsPort", (short)0);
    this.N = new XListView(this);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.N.setLayoutParams(localLayoutParams);
    this.N.setBackgroundResource(2130838900);
    this.N.setDivider(null);
    setContentView(this.N);
    setTitle(paramBundle);
    paramBundle = this.app.a().d(this.nSessionId);
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    this.fileType = ahav.c(paramBundle);
    if (this.troopUin != 0L) {
      smq.a(this.app, this.str_download_dns, this.aEI, this.aEJ, this.fileType, this.filePath, this.aEK, paramBundle, a(paramBundle));
    }
    for (;;)
    {
      startTitleProgress();
      super.setRightButton(2131721059, new agcz(this, paramBundle));
      return true;
      a(this.str_download_dns, this.aEI, this.aEJ, this.fileType, this.filePath, this.aEK, paramBundle, this.mIsHttps, this.aEL, this.H, a(paramBundle));
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.f != null) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().deleteObserver(this.f);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().addObserver(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity
 * JD-Core Version:    0.7.0.1
 */