package com.tencent.token.utils;

import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Environment;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import java.io.File;

public final class n
  implements MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener
{
  private static n c;
  File a;
  MediaRecorder b;
  private boolean d = false;
  
  public static n a()
  {
    if (c == null) {
      c = new n();
    }
    return c;
  }
  
  public final void a(SurfaceView paramSurfaceView, Camera paramCamera, Handler paramHandler)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.d;
        if (bool) {
          return;
        }
        this.d = true;
        try
        {
          Environment.getExternalStorageState();
          if (!"mounted".equals(Environment.getExternalStorageState())) {
            break label801;
          }
          Object localObject = new File(Environment.getExternalStorageDirectory() + File.separator + "video", "face.mp4");
          this.a = ((File)localObject);
          if (!this.a.exists()) {
            this.a.createNewFile();
          }
          if (this.b == null) {
            this.b = new MediaRecorder();
          }
          this.b.reset();
          this.b.setOrientationHint(270);
          paramCamera.unlock();
          this.b.setCamera(paramCamera);
          this.b.setAudioSource(1);
          this.b.setVideoSource(1);
          this.b.setOutputFormat(2);
          this.b.setAudioEncoder(1);
          this.b.setVideoEncoder(2);
          localObject = CamcorderProfile.get(1);
          e.c(((CamcorderProfile)localObject).videoFrameWidth + ".." + ((CamcorderProfile)localObject).videoFrameHeight + "..");
          this.b.setVideoSize(((CamcorderProfile)localObject).videoFrameWidth, ((CamcorderProfile)localObject).videoFrameHeight);
          this.b.setVideoFrameRate(((CamcorderProfile)localObject).videoFrameRate);
          if (((CamcorderProfile)localObject).videoBitRate <= 1048576) {
            break label845;
          }
          this.b.setVideoEncodingBitRate(1048576);
          this.b.setOutputFile(this.a.getAbsolutePath());
          this.b.setPreviewDisplay(paramSurfaceView.getHolder().getSurface());
          this.b.setOnInfoListener(this);
          this.b.setOnErrorListener(this);
          this.b.prepare();
          this.b.start();
          paramHandler.sendEmptyMessageDelayed(90, 5000L);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          try
          {
            this.b.reset();
            this.b.setOrientationHint(270);
            this.b.setCamera(paramCamera);
            this.b.setAudioSource(1);
            this.b.setVideoSource(1);
            this.b.setOutputFormat(2);
            this.b.setAudioEncoder(1);
            this.b.setVideoEncoder(2);
            CamcorderProfile localCamcorderProfile = CamcorderProfile.get(5);
            e.c(localCamcorderProfile.videoFrameWidth + ".." + localCamcorderProfile.videoFrameHeight + "..");
            this.b.setVideoSize(localCamcorderProfile.videoFrameWidth, localCamcorderProfile.videoFrameHeight);
            localCamcorderProfile = CamcorderProfile.get(7);
            this.b.setVideoFrameRate(localCamcorderProfile.videoFrameRate);
            this.b.setVideoEncodingBitRate(localCamcorderProfile.videoBitRate);
            this.b.setOutputFile(this.a.getAbsolutePath());
            this.b.setPreviewDisplay(paramSurfaceView.getHolder().getSurface());
            this.b.prepare();
            this.b.start();
            paramHandler.sendEmptyMessageDelayed(90, 5000L);
          }
          catch (Exception localException2)
          {
            try
            {
              this.b.reset();
              this.b.setOrientationHint(270);
              this.b.setCamera(paramCamera);
              this.b.setAudioSource(1);
              this.b.setVideoSource(1);
              this.b.setOutputFormat(2);
              this.b.setAudioEncoder(1);
              this.b.setVideoEncoder(2);
              paramCamera = CamcorderProfile.get(0);
              e.c(paramCamera.videoFrameWidth + ".." + paramCamera.videoFrameHeight + "..");
              this.b.setVideoSize(paramCamera.videoFrameWidth, paramCamera.videoFrameHeight);
              this.b.setVideoFrameRate(paramCamera.videoFrameRate);
              this.b.setVideoEncodingBitRate(paramCamera.videoBitRate);
              this.b.setOutputFile(this.a.getAbsolutePath());
              this.b.setPreviewDisplay(paramSurfaceView.getHolder().getSurface());
              this.b.prepare();
              this.b.start();
              paramHandler.sendEmptyMessageDelayed(90, 5000L);
            }
            catch (Exception paramSurfaceView)
            {
              paramSurfaceView.printStackTrace();
              paramHandler.sendEmptyMessage(100);
              this.d = false;
            }
          }
        }
        continue;
        localFile = new File(RqdApplication.i().getFilesDir() + File.separator + "video", "face.mp4");
      }
      finally {}
      label801:
      File localFile;
      continue;
      label845:
      this.b.setVideoEncodingBitRate(localFile.videoBitRate);
    }
  }
  
  public final String b()
  {
    if ((this.a == null) || (!this.a.exists())) {
      return null;
    }
    return this.a.getAbsolutePath();
  }
  
  public final boolean c()
  {
    boolean bool = false;
    if (this.d)
    {
      e.c("stopRecord");
      this.b.setOnErrorListener(null);
      this.b.setPreviewDisplay(null);
    }
    try
    {
      this.b.stop();
      this.b.reset();
      this.b.release();
      this.b = null;
      this.d = false;
      bool = true;
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public final void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2) {}
  
  public final void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.n
 * JD-Core Version:    0.7.0.1
 */