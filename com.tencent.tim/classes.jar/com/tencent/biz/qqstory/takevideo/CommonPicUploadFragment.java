package com.tencent.biz.qqstory.takevideo;

import acfp;
import akyj;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import aojg;
import aooi;
import aook;
import aool;
import aqiw;
import aurf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;
import rat;
import rau;

public class CommonPicUploadFragment
  extends PublicBaseFragment
  implements Handler.Callback
{
  private long Aj = -1L;
  private long BD;
  private long BE;
  private long BF;
  private boolean aGn;
  QQAppInterface app;
  private String azo;
  private String azp;
  private String azq = "0";
  private aurf b;
  private int bpr;
  private int bpt;
  aook d = new rau(this);
  private String lS;
  public BaseActivity mActivity;
  private String mPicUrl;
  private boolean needCompress;
  private String peerUin = "0";
  protected Dialog v;
  
  private String ca(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "h5UploadPicHit";
    }
    return "DGPKSharePicHit";
  }
  
  private int eb(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 51;
    }
    return 58;
  }
  
  public void go()
  {
    try
    {
      if (this.v != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CommonPicUploadFragment", 2, "cancelProgressDialog");
        }
        this.v.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CommonPicUploadFragment", 2, "cancelProgressDialog excep!", localException);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonPicUploadFragment", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1001: 
      go();
      sq(acfp.m(2131704238));
      return true;
    case 1002: 
    case 1003: 
      go();
      this.Aj = -1L;
      this.mActivity.setResult(2);
      this.mActivity.finish();
      return true;
    case 1004: 
      go();
      this.mActivity.setResult(2);
      this.mActivity.finish();
      return true;
    }
    paramMessage = new Intent();
    paramMessage.putExtra("upload_result", true);
    paramMessage.putExtra("upload_pic_uuid", this.azp);
    paramMessage.putExtra("upload_pic_md5", this.azo);
    paramMessage.putExtra("share_method", this.bpt);
    paramMessage.putExtra("pk_rank", this.azq);
    paramMessage.putExtra("current_nickname", this.app.getCurrentNickname());
    if (this.Aj != -1L) {
      paramMessage.putExtra("upload_time_cost", SystemClock.elapsedRealtime() - this.Aj);
    }
    BaseActivity localBaseActivity1 = this.mActivity;
    BaseActivity localBaseActivity2 = this.mActivity;
    localBaseActivity1.setResult(-1, paramMessage);
    this.mActivity.finish();
    return true;
  }
  
  public void mw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonPicUploadFragment", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.b.sendEmptyMessage(1003);
      if (QLog.isColorLevel()) {
        QLog.d("CommonPicUploadFragment", 2, "startUploadPic empty path!");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = new File(paramString);
      if (((File)localObject).exists()) {
        break;
      }
      this.b.sendEmptyMessage(1003);
    } while (!QLog.isColorLevel());
    QLog.d("CommonPicUploadFragment", 2, "startUploadPic file not exist, path=" + paramString);
    return;
    this.BD = ((File)localObject).length();
    if (!aqiw.isNetworkAvailable(this.mActivity))
    {
      this.b.sendEmptyMessage(1004);
      return;
    }
    this.lS = "";
    this.azo = "";
    this.mPicUrl = "";
    CompressInfo localCompressInfo;
    if (this.needCompress)
    {
      localCompressInfo = new CompressInfo(paramString, 0);
      localCompressInfo.picType = 0;
      if (!akyj.b(localCompressInfo)) {
        QLog.d("CommonPicUploadFragment", 1, "CompressOperator failed");
      }
      if (TextUtils.isEmpty(localCompressInfo.destPath))
      {
        localObject = paramString;
        this.lS = ((String)localObject);
        this.BE = new File(paramString).length();
        if (QLog.isColorLevel()) {
          QLog.d("CommonPicUploadFragment", 2, String.format("startUploadPic outWidth[%s], outHeight[%s], sizeBefore[%s], sizeAfter[%s], compressPath=[%s], originPath[%s]", new Object[] { Integer.valueOf(localCompressInfo.dpx), Integer.valueOf(localCompressInfo.dpy), Long.valueOf(this.BD), Long.valueOf(this.BE), localCompressInfo.destPath, paramString }));
        }
      }
    }
    for (;;)
    {
      paramString = this.app.a();
      this.d.addFilter(new Class[] { aojg.class });
      paramString.a(this.d);
      localObject = new aool();
      ((aool)localObject).cNy = true;
      ((aool)localObject).dOM = eb(this.bpr);
      ((aool)localObject).dQ = this.lS;
      this.BF = ((Math.random() * 1000000.0D));
      ((aool)localObject).mUniseq = this.BF;
      ((aool)localObject).mPeerUin = this.peerUin;
      ((aool)localObject).mFileType = 24;
      ((aool)localObject).ckW = ca(this.bpr);
      paramString.a((aool)localObject);
      return;
      localObject = localCompressInfo.destPath;
      break;
      this.lS = paramString;
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.b = new aurf(this);
    paramBundle = this.mActivity.getIntent();
    this.lS = paramBundle.getExtras().getString("upload_pic_path");
    this.needCompress = paramBundle.getExtras().getBoolean("upload_pic_need_compress", false);
    paramBundle.getExtras().getString("dance_machine_rank", "0");
    paramBundle.getExtras().getString("dance_machine_score", "0");
    this.bpr = paramBundle.getExtras().getInt("upload_pic_busi_type", 0);
    this.bpt = paramBundle.getExtras().getInt("share_method", 0);
    this.azq = paramBundle.getExtras().getString("pk_rank", "0");
    ThreadManager.executeOnSubThread(new CommonPicUploadFragment.1(this));
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = getActivity();
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.app = ((QQAppInterface)getActivity().getAppInterface());
      this.mActivity.setTheme(16973841);
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
  }
  
  protected void sq(String paramString)
  {
    if (this.v == null)
    {
      this.v = new ReportDialog(this.mActivity, 2131756467);
      this.v.setContentView(2131559174);
      this.v.setOnKeyListener(new rat(this));
      localObject = this.mActivity.getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.v.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.v.getWindow().setAttributes(localLayoutParams);
      this.v.show();
    }
    Object localObject = (TextView)this.v.findViewById(2131373180);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131719518);
    }
    for (;;)
    {
      if (!this.v.isShowing())
      {
        if (QLog.isColorLevel()) {
          QLog.d("CommonPicUploadFragment", 2, "showProgressDialog");
        }
        this.v.show();
      }
      return;
      ((TextView)localObject).setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment
 * JD-Core Version:    0.7.0.1
 */