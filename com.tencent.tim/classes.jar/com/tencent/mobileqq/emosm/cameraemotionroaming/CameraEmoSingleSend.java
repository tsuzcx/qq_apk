package com.tencent.mobileqq.emosm.cameraemotionroaming;

import accj;
import afgw;
import afgw.a;
import afha;
import afhb;
import afhc;
import ajdg;
import android.text.TextUtils;
import anpc;
import aqiw;
import axfn;
import axol;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;

public class CameraEmoSingleSend
  extends AsyncStep
{
  private afgw a;
  private accj b;
  private boolean bYa;
  private afhc jdField_c_of_type_Afhc;
  private CameraEmotionData jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData;
  private final Object dA = new Object();
  private boolean isResend;
  public boolean isTestMode;
  private Timer timer;
  
  public CameraEmoSingleSend(CameraEmotionData paramCameraEmotionData, boolean paramBoolean)
  {
    this.isResend = paramBoolean;
    this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData = paramCameraEmotionData;
    initManager();
  }
  
  private void aA(boolean paramBoolean, String paramString)
  {
    if (this.bYa)
    {
      QLog.d("CameraEmoSingleSend", 1, new Object[] { "upload return, timer canceled, emoPath:", this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
      return;
    }
    if (paramBoolean)
    {
      String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath = paramString;
      this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.md5 = str;
      this.jdField_c_of_type_Afhc.b(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData);
      paramString = new afhb(this);
      if (!isNetSupport())
      {
        QLog.d("CameraEmoSingleSend", 1, "uploadCameraEmo, net not support");
        paramString.c(12, this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData);
        return;
      }
      this.a.a(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData, paramString);
      return;
    }
    bh(false, 14);
  }
  
  private void bh(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData;
    if (paramBoolean) {
      ??? = "normal";
    }
    for (;;)
    {
      ((CameraEmotionData)localObject2).RomaingType = ((String)???);
      this.jdField_c_of_type_Afhc.b(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData);
      this.jdField_c_of_type_Afhc.trimCache();
      this.b.f(5, paramBoolean, 14);
      localObject2 = new HashMap();
      if (paramBoolean)
      {
        ??? = "1";
        ((HashMap)localObject2).put("sucFlag", ???);
        ((HashMap)localObject2).put("retCode", String.valueOf(paramInt));
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "CamEmoUpload", paramBoolean, 0L, 0L, (HashMap)localObject2, null);
      }
      synchronized (this.dA)
      {
        this.dA.notify();
        return;
        ??? = "failed";
        continue;
        ??? = "0";
      }
    }
  }
  
  public axfn a(String paramString)
  {
    return new axfn(paramString);
  }
  
  public void ew(String paramString, int paramInt)
  {
    ajdg.ew(paramString, paramInt);
  }
  
  public QQAppInterface getApp()
  {
    return (QQAppInterface)axol.getAppInterface();
  }
  
  public void initManager()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface != null)
    {
      this.jdField_c_of_type_Afhc = ((afhc)localQQAppInterface.getManager(333));
      this.b = ((accj)localQQAppInterface.getBusinessHandler(160));
      this.a = ((afgw)localQQAppInterface.getManager(334));
    }
  }
  
  public boolean isNetSupport()
  {
    return aqiw.isNetSupport(BaseApplication.getContext());
  }
  
  public int od()
  {
    this.timer = new Timer();
    this.timer.schedule(new CameraEmoSingleSend.1(this), 90000L);
    boolean bool1;
    if (this.isResend)
    {
      boolean bool2;
      if ((this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath != null) && (new File(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath).exists()))
      {
        bool2 = true;
        if ((this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath == null) || (!new File(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath).exists())) {
          break label239;
        }
      }
      label239:
      for (bool1 = true;; bool1 = false)
      {
        QLog.d("CameraEmoSingleSend", 1, new Object[] { "resend, hasOriginalFile:", Boolean.valueOf(bool2), " hasMergedFile:", Boolean.valueOf(bool1) });
        if ((bool2) || (bool1)) {
          break label244;
        }
        QLog.d("CameraEmoSingleSend", 1, new Object[] { "resend, emoOriginalPath:", this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath, " emoPath:", this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath, " emoId:", Integer.valueOf(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoId) });
        this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.RomaingType = "failed";
        this.jdField_c_of_type_Afhc.b(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData);
        this.b.notifyUI(4, true, null);
        return 7;
        bool2 = false;
        break;
      }
      label244:
      this.jdField_c_of_type_Afhc.b(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData);
    }
    for (;;)
    {
      if ((this.isResend) && (bool1)) {
        aA(true, this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath);
      }
      for (;;)
      {
        if ((!this.bYa) && (!this.isTestMode)) {}
        try
        {
          synchronized (this.dA)
          {
            this.dA.wait(120000L);
            label311:
            this.timer.cancel();
            return 7;
            if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath))
            {
              if (new File(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath).exists())
              {
                aA(true, this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath);
                continue;
              }
              QLog.d("CameraEmoSingleSend", 1, new Object[] { "GIF save AIO fail, emoPath not exist, emoPath:", this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
              return 7;
            }
            long l = System.currentTimeMillis();
            ??? = a(this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath);
            ((axfn)???).a(new afha(this, (axfn)???, l));
          }
          QLog.d("CameraEmoSingleSend", 1, new Object[] { "upload no need wait, timer canceled, emoPath:", this.jdField_c_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
          return 7;
        }
        catch (Exception localException)
        {
          break label311;
        }
      }
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */