package com.tencent.mobileqq.activity.photo;

import acfp;
import akyj;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import aojg;
import aooi;
import aook;
import aool;
import aqiw;
import aqmr;
import aurf;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import zsy;

public class SendWebPicActivity
  extends BaseActivity
  implements Handler.Callback
{
  private long BD;
  private long BE;
  private boolean aGn;
  private String ajB;
  private aurf b;
  private String baP;
  private int ceS;
  aook d = new zsy(this);
  private ProgressDialog f;
  private String mCallback;
  private String mImagePath;
  private String mImageUrl;
  
  private void bty()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendWebPicActivity", 2, "jumpToH5Activity, uuid:" + this.baP + ", md5:" + this.ajB + ", callback:" + this.mCallback);
    }
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", 3);
    sendBroadcast(localIntent);
    go();
    if (!TextUtils.isEmpty(this.mCallback))
    {
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.shortVideoJsApiPulgin");
      localIntent.putExtra("uuid", this.baP);
      localIntent.putExtra("md5", this.ajB);
      localIntent.putExtra("imgurl", this.mImageUrl);
      localIntent.putExtra("callback", this.mCallback);
      localIntent.putExtra("mediaType", "image");
      sendBroadcast(localIntent);
    }
    for (;;)
    {
      setResult(-1);
      finish();
      return;
      QQToast.a(this, acfp.m(2131714305), 0).show();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = new aurf(this);
    this.mCallback = getIntent().getStringExtra("edit_video_call_back");
    paramBundle = getIntent().getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    this.ceS = getIntent().getIntExtra("shareto_web_mode", -1);
    if (this.ceS == 0)
    {
      this.aGn = false;
      zH(paramBundle);
    }
    while (this.ceS != 1) {
      return true;
    }
    zI(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a().b(this.d);
  }
  
  void go()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendWebPicActivity", 2, "cancelProgressDialog");
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
      QLog.d("SendWebPicActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
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
      bty();
      return true;
    case 1002: 
      go();
      sq(acfp.m(2131714306));
      return true;
    }
    go();
    QQToast.a(this, 1, 2131696664, 0).show();
    finish();
    return true;
  }
  
  public void mw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendWebPicActivity", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.b.sendEmptyMessage(1003);
      if (QLog.isColorLevel()) {
        QLog.d("SendWebPicActivity", 2, "startUploadPic empty path!");
      }
    }
    do
    {
      return;
      localObject = new File(paramString);
      if (((File)localObject).exists()) {
        break;
      }
      this.b.sendEmptyMessage(1003);
    } while (!QLog.isColorLevel());
    QLog.d("SendWebPicActivity", 2, "startUploadPic file not exist, path=" + paramString);
    return;
    this.BD = ((File)localObject).length();
    if (!aqiw.isNetworkAvailable(this))
    {
      this.b.sendEmptyMessage(1004);
      return;
    }
    this.mImagePath = "";
    this.ajB = "";
    this.mImageUrl = "";
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.picType = 0;
    if (!akyj.b(localCompressInfo)) {
      QLog.d("SendWebPicActivity", 1, "CompressOperator failed");
    }
    if (TextUtils.isEmpty(localCompressInfo.destPath)) {}
    for (Object localObject = paramString;; localObject = localCompressInfo.destPath)
    {
      this.mImagePath = ((String)localObject);
      this.BE = new File(this.mImagePath).length();
      if (QLog.isColorLevel()) {
        QLog.d("SendWebPicActivity", 2, String.format("startUploadPic outWidth[%s], outHeight[%s], sizeBefore[%s], sizeAfter[%s], compressPath=[%s], originPath[%s]", new Object[] { Integer.valueOf(localCompressInfo.dpx), Integer.valueOf(localCompressInfo.dpy), Long.valueOf(this.BD), Long.valueOf(this.BE), localCompressInfo.destPath, paramString }));
      }
      paramString = this.app.a();
      this.d.addFilter(new Class[] { aojg.class });
      paramString.a(this.d);
      localObject = new aool();
      ((aool)localObject).cNy = true;
      ((aool)localObject).dOM = 51;
      ((aool)localObject).dQ = this.mImagePath;
      ((aool)localObject).mUniseq = ((Math.random() * 1000000.0D));
      ((aool)localObject).mPeerUin = "0";
      ((aool)localObject).mFileType = 24;
      ((aool)localObject).ckW = "h5UploadPicHit";
      paramString.a((aool)localObject);
      return;
    }
  }
  
  void sq(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendWebPicActivity", 2, "showProgressDialog " + paramString);
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
        QLog.e("SendWebPicActivity", 2, "showProgressDialog", paramString);
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
  
  public void zH(String paramString)
  {
    ThreadManager.executeOnSubThread(new SendWebPicActivity.1(this, paramString));
  }
  
  public void zI(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, BlessSelectMemberActivity.class);
    localIntent.putExtra("param_type", 9003);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", getString(2131690914));
    localIntent.putExtra("param_done_button_wording", getString(2131691970));
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_entrance", 32);
    localIntent.putExtra("param_blesstype", 3);
    localIntent.putExtra("thumbfile_send_path", paramString);
    startActivity(localIntent);
    setResult(-1);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendWebPicActivity
 * JD-Core Version:    0.7.0.1
 */