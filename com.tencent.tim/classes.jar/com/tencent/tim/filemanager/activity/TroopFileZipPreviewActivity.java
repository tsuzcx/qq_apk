package com.tencent.tim.filemanager.activity;

import agne;
import agxi.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import aprc;
import aqgz;
import atpd;
import atpe;
import atpf;
import audx;
import aurr;
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

public class TroopFileZipPreviewActivity
  extends IphoneTitleBarActivity
{
  public XListView N;
  ForwardFileInfo a;
  public String aEI;
  public String aEJ;
  public String aEK;
  int busId;
  Context context;
  public String filePath;
  int fileType;
  public long nSessionId = 0L;
  public List<agxi.a> pw = new ArrayList();
  public String str_download_dns;
  long troopUin;
  
  private smq.j a(FileManagerEntity paramFileManagerEntity)
  {
    return new atpe(this, paramFileManagerEntity);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, smq.j paramj)
  {
    String str = "http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + aurr.encodeUrl(paramString4) + "&";
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    if (paramFileManagerEntity.getCloudType() == 2)
    {
      bool = true;
      if (!bool) {
        break label226;
      }
      paramString5 = "FTN5K=" + paramString5;
    }
    label226:
    for (;;)
    {
      paramString1 = new aprc(str, "GET", new atpf(this, localArrayList, paramString4, bool, paramString5, paramString1, paramString2, paramString3, paramInt, paramFileManagerEntity, paramj), 1000, null);
      paramString2 = new Bundle();
      paramString2.putString("version", aqgz.getQQVersion());
      paramString2.putString("Cookie", paramString5);
      paramString3 = new HashMap();
      paramString3.put("BUNDLE", paramString2);
      paramString3.put("CONTEXT", this.app.getApp().getApplicationContext());
      paramString1.J(paramString3);
      return;
      bool = false;
      break;
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
    this.fileType = audx.c(paramBundle);
    if (this.troopUin != 0L) {
      smq.a(this.app, this.str_download_dns, this.aEI, this.aEJ, this.fileType, this.filePath, this.aEK, paramBundle, a(paramBundle));
    }
    for (;;)
    {
      startTitleProgress();
      super.setRightButton(2131721059, new atpd(this, paramBundle));
      return true;
      a(this.str_download_dns, this.aEI, this.aEJ, this.fileType, this.filePath, this.aEK, paramBundle, a(paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.TroopFileZipPreviewActivity
 * JD-Core Version:    0.7.0.1
 */