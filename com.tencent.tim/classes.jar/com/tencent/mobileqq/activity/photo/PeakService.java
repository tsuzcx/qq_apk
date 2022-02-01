package com.tencent.mobileqq.activity.photo;

import aeab;
import akyj;
import alwt;
import alwy;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import anfi;
import anim;
import ankq;
import anpc;
import aoop;
import aqhq;
import awsj;
import awtj;
import axis;
import axiy;
import axjk;
import axol;
import ayan;
import aywy;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.util.BinderWarpper;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ptv.PtvCameraCaptureActivity;
import java.util.Arrays;
import mqq.os.MqqHandler;
import xuj;
import xuj.a;

public class PeakService
  extends IntentService
{
  public static String baL = "StoryTrace_";
  
  public PeakService()
  {
    super("PeakService");
    axiy.i("PeakService", "[PeakService]");
  }
  
  public void a(CompressInfo paramCompressInfo, xuj paramxuj)
  {
    akyj.b(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramxuj != null)
    {
      if (!paramCompressInfo.isSuccess) {
        break label64;
      }
      paramxuj.a(paramCompressInfo);
    }
    for (;;)
    {
      paramxuj.c(paramCompressInfo);
      return;
      label64:
      paramxuj.b(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    axiy.i("PeakService", "[onDestroy]");
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PeakService", 2, "onHandleIntent: intent is null");
      }
    }
    int i;
    long l;
    do
    {
      return;
      i = paramIntent.getIntExtra("ServiceAction", -1);
      axiy.i("PeakService", "onHandleIntent, action = " + i);
      switch (i)
      {
      default: 
        paramIntent = ThreadManager.getFileThreadHandler();
        if (paramIntent != null)
        {
          paramIntent.removeCallbacks(aqhq.hQ);
          paramIntent.postDelayed(aqhq.hQ, 1000L);
        }
        ThreadManager.excute(new PeakService.1(this), 64, null, true);
        return;
      case 1: 
        Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
        paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
        if ((paramIntent != null) && (paramIntent.length >= 9))
        {
          akyl.dqc = paramIntent[0];
          akyl.dqd = paramIntent[1];
          akyl.dqe = paramIntent[2];
          akyl.dqf = paramIntent[3];
          akyl.dqg = paramIntent[4];
          akyl.dqh = paramIntent[5];
          akyl.dpY = paramIntent[6];
          akyl.dpZ = paramIntent[7];
          akyl.dqa = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = xuj.a.a(localBinderWarpper.binder);
          a((CompressInfo)localParcelable, paramIntent);
        }
        aoop.cdE();
        return;
      case 2: 
        bool = paramIntent.getBooleanExtra("key_alive", false);
        axjk.a().Yr(bool);
        try
        {
          l = System.currentTimeMillis();
          anpc.a(this);
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          new PtvCameraCaptureActivity();
          new QIMCameraCaptureActivity();
          new ayan();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          aeab.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          ankq.axZ();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.boP();
          if (anfi.awy()) {
            FeatureManager.loadBasicFeatures();
          }
          axol.getAppInterface();
          awsj.a(-1000, null, null);
          axis.a().t("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      case 3: 
        l = System.currentTimeMillis();
        i = alwt.Ip();
        aywy.a();
        CameraCaptureView.b.b(PeakAppInterface.a);
        CameraCaptureView.b.UW(i);
        awtj.init();
        bool = alwy.auK();
      }
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
    return;
    axiy.i("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
    paramIntent = paramIntent.getStringExtra("generate_mission");
    axjk.a().init();
    axjk.a().acZ(paramIntent);
    return;
    boolean bool = paramIntent.getBooleanExtra("key_alive", false);
    axjk.a().Yr(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */