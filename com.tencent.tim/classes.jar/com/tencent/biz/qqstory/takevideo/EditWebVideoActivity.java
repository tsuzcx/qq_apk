package com.tencent.biz.qqstory.takevideo;

import aaza.c;
import acfp;
import alwx;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import anij;
import anpc;
import aomt;
import aomt.a;
import aqhq;
import aqmr;
import aurf;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import rem;
import ren;

public class EditWebVideoActivity
  extends EditVideoActivity
  implements Handler.Callback, aomt.a
{
  private aaza.c a;
  private String azT;
  private String azU;
  private aurf b;
  private byte[] bH;
  private byte[] bK;
  private String bN;
  private int bqB;
  private String callback;
  private ProgressDialog f;
  private int gP;
  private int mThumbWidth;
  private String mUuid;
  
  public EditWebVideoActivity()
  {
    this.jdField_a_of_type_Aaza$c = new rem(this);
  }
  
  private void bty()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "jumpToH5Activity, uid:" + this.mUuid + ", md5:" + this.azU + ", callback:" + this.callback);
    }
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", 2);
    sendBroadcast(localIntent);
    go();
    if (!TextUtils.isEmpty(this.callback))
    {
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.shortVideoJsApiPulgin");
      localIntent.putExtra("uuid", this.mUuid);
      localIntent.putExtra("md5", this.azU);
      localIntent.putExtra("callback", this.callback);
      localIntent.putExtra("mediaType", "video");
      finish();
      sendBroadcast(localIntent);
      return;
    }
    QQToast.a(this, acfp.m(2131705745), 0).show();
    finish();
  }
  
  protected void bsv()
  {
    if (this.jdField_a_of_type_Rdc == null) {
      this.jdField_a_of_type_Rdc = new ren();
    }
    ((ren)this.jdField_a_of_type_Rdc).a(this.jdField_a_of_type_Aaza$c);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = new aurf(this);
    this.callback = getIntent().getStringExtra("edit_video_call_back");
    anpc.report("exposure_old_editWebVideo");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (!TextUtils.isEmpty(this.azT)) {
      aqhq.deleteFile(this.azT);
    }
  }
  
  void go()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.f != null) {
        this.f.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1003: 
      go();
      QQToast.a(this, 1, 2131720152, 0).show();
      finish();
      return true;
    case 1001: 
      alwx.dB(anij.a().dGP, "");
      bty();
      return true;
    }
    go();
    sq(acfp.m(2131705740));
    startUpload();
    return true;
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.b.hasMessages(1003)) {
      this.b.removeMessages(1003);
    }
    this.b.sendEmptyMessage(1003);
  }
  
  public void onSuccess(String paramString)
  {
    this.mUuid = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadSuccess! " + this.mUuid);
    }
    if (this.b.hasMessages(1003)) {
      this.b.removeMessages(1003);
    }
    this.b.sendEmptyMessage(1001);
  }
  
  public void sq(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "showProgressDialog " + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.f == null) {
          continue;
        }
        go();
        localTextView = (TextView)this.f.findViewById(2131373180);
        if (!aqmr.isEmpty(paramString)) {
          continue;
        }
        localTextView.setText(2131717151);
      }
      catch (Throwable paramString)
      {
        TextView localTextView;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("EditWebVideoActivity", 2, "showProgressDialog", paramString);
        return;
        localTextView.setText(paramString);
        continue;
      }
      if (this.f.isShowing()) {
        return;
      }
      this.f.show();
      return;
      this.f = new ReportProgressDialog(this, 2131756467);
      this.f.setCancelable(false);
      this.f.show();
      this.f.setContentView(2131559761);
    }
  }
  
  void startUpload()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "onShareClick " + this.azT + " mthumbPath" + this.bN);
    }
    if ((aqmr.isEmpty(this.azT)) || (aqmr.isEmpty(this.bN)))
    {
      finish();
      return;
    }
    if ((this.bN == null) || (this.azT == null))
    {
      QQToast.a(this, 2131693681, 0).show();
      go();
      return;
    }
    File localFile1 = new File(this.bN);
    File localFile2 = new File(this.azT);
    if ((!localFile1.exists()) || (!localFile2.exists()))
    {
      QQToast.a(this, 2131693681, 0).show();
      go();
      return;
    }
    if ((!localFile1.isFile()) || (!localFile2.isFile()))
    {
      QQToast.a(this, 2131693683, 0).show();
      go();
      return;
    }
    if (new aomt(this.mApp, this, this.azT, this.bH, this.bN, this.bK, this.mThumbWidth, this.gP, this.bqB).aAg())
    {
      this.b.sendEmptyMessageDelayed(1003, 60000L);
      return;
    }
    go();
    QQToast.a(this, 1, 2131720153, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoActivity
 * JD-Core Version:    0.7.0.1
 */