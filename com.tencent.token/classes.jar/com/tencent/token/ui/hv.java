package com.tencent.token.ui;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.tencent.jni.Face;
import com.tencent.jni.Face.ALG_MODE;
import com.tencent.jni.Face.ImgData;
import com.tencent.token.cv;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.concurrent.ExecutorService;

final class hv
  implements Runnable
{
  hv(hu paramhu, Camera.Parameters paramParameters, Camera.Size paramSize, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    boolean bool = false;
    if (FaceRecognitionCameraPreviewOld.d(this.d.c) == 0L)
    {
      FaceRecognitionCameraPreviewOld.a(this.d.c, System.currentTimeMillis());
      return;
    }
    synchronized (this.d.c.j)
    {
      if (FaceRecognitionCameraPreviewOld.a(this.d.c)) {
        return;
      }
    }
    long l1;
    Object localObject4;
    String str1;
    String str2;
    if (this.d.c.b == null)
    {
      this.d.c.b = new Face();
      FaceRecognitionCameraPreviewOld.a(this.d.c, true);
      e.c("face_algorithm" + t.l());
      e.c("IsSupportNeon" + Face.IsSupportNeon());
      l1 = System.currentTimeMillis();
      if ((t.l() == 0) || (!Face.IsSupportNeon().booleanValue())) {
        break label1365;
      }
      cv.o = bool;
      localObject4 = this.d.c.b;
      str1 = s.c(RqdApplication.i(), "haarcascade_frontalface_alt.xml");
      str2 = s.c(RqdApplication.i(), "haarcascade_frontalface_alt.xml");
      if (!cv.o) {
        break label305;
      }
    }
    label305:
    for (Object localObject2 = Face.ALG_MODE.V1;; localObject2 = Face.ALG_MODE.V2)
    {
      ((Face)localObject4).Initial(str1, str2, (Face.ALG_MODE)localObject2);
      cv.f = (int)(System.currentTimeMillis() - l1);
      e.c("initTime" + cv.f);
      FaceRecognitionCameraPreviewOld.a(this.d.c, false);
      if (!FaceRecognitionCameraPreviewOld.b(this.d.c)) {
        break;
      }
      return;
    }
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
        long l2 = FaceRecognitionCameraPreviewOld.d(this.d.c);
        long l3 = FaceRecognitionCameraPreviewOld.e(this.d.c);
        if (l1 - l2 < l3) {
          return;
        }
        if (this.d.a == null)
        {
          this.d.b = System.currentTimeMillis();
          e.c("scanCostTime begin=" + this.d.b);
          localObject2 = this.d.c.d;
          if (localObject2 == null) {
            return;
          }
          this.d.a = this.d.c.d.obtainMessage(0);
          this.d.a.what = 10;
          this.d.a.sendToTarget();
        }
        bool = FaceRecognitionCameraPreviewOld.a(this.d.c);
        if (bool) {
          return;
        }
        localObject4 = this.a.get("rotation");
        localObject2 = Build.MODEL;
        if ((((String)localObject2).startsWith("8150")) || (FaceRecognitionCameraPreviewOld.f(this.d.c) == 0)) {
          break label1370;
        }
        if (((String)localObject2).equals("Nexus 6"))
        {
          break label1370;
          int i = t.p();
          if (i == 0) {
            break label1362;
          }
          localObject2 = i + "";
          cv.g += 1;
          bool = FaceRecognitionCameraPreviewOld.b(this.d.c);
          if (!bool) {}
        }
        else
        {
          if (((String)localObject2).contains("MI 5")) {
            break label1378;
          }
          localObject2 = localObject4;
          if (this.b.width <= this.b.height) {
            continue;
          }
          localObject2 = localObject4;
          if (Integer.valueOf((String)localObject4).intValue() >= 90) {
            continue;
          }
          break label1378;
        }
        if (FaceRecognitionCameraPreviewOld.g(this.d.c) == null)
        {
          FaceRecognitionCameraPreviewOld.a(this.d.c, new int[4]);
          FaceRecognitionCameraPreviewOld.g(this.d.c)[0] = (FaceRecognitionCameraPreviewOld.h(this.d.c) * 60 / 480);
          FaceRecognitionCameraPreviewOld.g(this.d.c)[1] = (FaceRecognitionCameraPreviewOld.i(this.d.c) * 140 / 720);
          FaceRecognitionCameraPreviewOld.g(this.d.c)[2] = (FaceRecognitionCameraPreviewOld.h(this.d.c) * 360 / 480);
          FaceRecognitionCameraPreviewOld.g(this.d.c)[3] = (FaceRecognitionCameraPreviewOld.i(this.d.c) * 460 / 720);
        }
        bool = FaceRecognitionCameraPreviewOld.i;
        if (bool) {
          return;
        }
        FaceRecognitionCameraPreviewOld.b(this.d.c, true);
        bool = FaceRecognitionCameraPreviewOld.a(this.d.c);
        if (bool) {
          return;
        }
        FaceRecognitionCameraPreviewOld.c(this.d.c, false);
        if (FaceRecognitionCameraPreviewOld.j(this.d.c) != 3) {
          continue;
        }
        e.a("flag is realname reg");
        localObject2 = this.d.c.b.FaceDetect_register(this.c, this.b.width, this.b.height, Integer.valueOf((String)localObject2).intValue(), FaceRecognitionCameraPreviewOld.g(this.d.c), this.d.c.h);
      }
      catch (Exception localException)
      {
        localObject3 = null;
        continue;
        FaceRecognitionCameraPreviewOld.b(this.d.c, false);
        if ((this.d.c.d == null) || (localObject3 == null)) {
          continue;
        }
        if (((Face.ImgData)localObject3).isdark_flag != 1) {
          break label1105;
        }
        e.a("too dark!");
        localObject3 = this.d.c.d.obtainMessage(0);
        ((Message)localObject3).what = 12;
        ((Message)localObject3).sendToTarget();
        return;
      }
      FaceRecognitionCameraPreviewOld.c(this.d.c, true);
      if (FaceRecognitionCameraPreviewOld.a(this.d.c))
      {
        return;
        localObject2 = this.d.c.b.FaceDetect_validate(this.c, this.b.width, this.b.height, Integer.valueOf((String)localObject2).intValue(), FaceRecognitionCameraPreviewOld.g(this.d.c), this.d.c.h);
      }
      else
      {
        Object localObject3;
        label1105:
        if (((Face.ImgData)localObject3).img_data != null) {
          e.a("temp length=" + ((Face.ImgData)localObject3).img_data.length);
        }
        if ((localObject3 != null) && (((Face.ImgData)localObject3).img_data != null) && (((Face.ImgData)localObject3).img_data.length > 0))
        {
          e.a("temp img_data=" + ((Face.ImgData)localObject3).img_data.length);
          if (this.d.c.d != null)
          {
            FaceRecognitionCameraPreviewOld.k(this.d.c).shutdown();
            this.d.a = null;
            e.c("scanCostTime1 = " + cv.e);
            cv.e = (int)(cv.e + (System.currentTimeMillis() - this.d.b));
            e.c("scanCostTime2 = " + cv.e);
            FaceRecognitionCameraPreviewOld.l(this.d.c);
            localObject4 = this.d.c.d.obtainMessage(0);
            ((Message)localObject4).what = 11;
            ((Message)localObject4).obj = localObject3;
            ((Message)localObject4).sendToTarget();
            FaceRecognitionCameraPreviewOld.k(this.d.c).shutdownNow();
            continue;
            label1362:
            continue;
            label1365:
            bool = true;
            break;
            label1370:
            localObject3 = "270";
            continue;
            label1378:
            localObject3 = "90";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hv
 * JD-Core Version:    0.7.0.1
 */