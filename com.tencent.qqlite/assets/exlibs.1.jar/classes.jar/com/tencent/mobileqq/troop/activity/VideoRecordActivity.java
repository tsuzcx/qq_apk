package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.widget.QQToast;
import enk;
import enl;
import enm;
import enn;
import eno;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class VideoRecordActivity
  extends BaseActivity
  implements SurfaceHolder.Callback, View.OnClickListener, Comparator
{
  public static final int a = -1;
  public static final String a = "VideoRecordActivity";
  public static final int b = 0;
  public static final String b = "output_path";
  public static final int c = 1;
  public static final String c = "duration_limit";
  public static final int d = 0;
  public static final String d = "size_limit";
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 4;
  public static final int n = 480;
  public static final int o = 640;
  public static final int p = 2000000;
  static final int q = 76800;
  static final int r = 921600;
  private int A = 90;
  private long jdField_a_of_type_Long;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private Chronometer jdField_a_of_type_AndroidWidgetChronometer;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView c;
  private ImageView d;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private String jdField_e_of_type_JavaLangString;
  private int s = -1;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 640;
  private int x = 480;
  private int y;
  private int z = 2000000;
  
  @TargetApi(9)
  public static int a(Activity paramActivity, int paramInt)
  {
    int i1 = 0;
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    paramInt = i1;
    switch (paramActivity.getWindowManager().getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = i1;
    }
    while (localCameraInfo.facing == 1)
    {
      return (360 - (paramInt + localCameraInfo.orientation) % 360) % 360;
      paramInt = 90;
      continue;
      paramInt = 180;
      continue;
      paramInt = 270;
    }
    return (localCameraInfo.orientation - paramInt + 360) % 360;
  }
  
  @TargetApi(11)
  private Point a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    paramCamera = paramCamera.getParameters();
    Camera.Size localSize1 = paramCamera.getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
    {
      localObject = new Point(localSize1.width, localSize1.height);
      return localObject;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramCamera = paramCamera.getSupportedVideoSizes(); paramCamera == null; paramCamera = paramCamera.getSupportedPreviewSizes()) {
      return new Point(localSize1.width, localSize1.height);
    }
    Object localObject = new ArrayList(paramCamera);
    Collections.sort((List)localObject, this);
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    label136:
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize2 = (Camera.Size)((Iterator)localObject).next();
      int i1 = localSize2.width;
      int i2 = localSize2.height;
      int i3 = i1 * i2;
      if ((i3 >= 76800) && (i3 <= 921600) && ((i1 != 900) || (i2 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((i1 == 1184) && (i2 == 666)) || ((i1 != 704) || (i2 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        if (paramInt1 > paramInt2)
        {
          i3 = 1;
          if (i1 >= i2) {
            break label359;
          }
          i4 = 1;
          label314:
          if (i3 != i4) {
            break label365;
          }
          i3 = i1;
        }
        for (int i4 = i2;; i4 = i1)
        {
          if ((i4 != paramInt1) || (i3 != paramInt2)) {
            break label376;
          }
          return new Point(i1, i2);
          i3 = 0;
          break;
          label359:
          i4 = 0;
          break label314;
          label365:
          i3 = i2;
        }
        label376:
        if ((i4 >= paramInt1 >> 1) && (i4 >> 1 <= paramInt1) && (i3 >= paramInt2 >> 1) && (i3 >> 1 <= paramInt2))
        {
          float f2 = Math.abs(i4 / i3 - f3);
          if (f2 >= f1) {
            break label475;
          }
          paramCamera = new Point(i1, i2);
          f1 = f2;
        }
      }
    }
    label475:
    for (;;)
    {
      break label136;
      localObject = paramCamera;
      if (paramCamera != null) {
        break;
      }
      return new Point(localSize1.width, localSize1.height);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT <= 8)
    {
      QQToast.a(this, 1, "系统版本过低，请用系统自带照相机应用拍摄", 0).a();
      super.finish();
      return;
    }
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      QQToast.a(this, 1, "无法读写SD卡", 0).a();
      super.finish();
      return;
    }
    this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("output_path");
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      QQToast.a(this, 1, "无法创建视频文件", 0).a();
      super.finish();
      return;
    }
    this.y = paramIntent.getIntExtra("duration_limit", 2147483647);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("size_limit", 9223372036854775807L);
  }
  
  private void d()
  {
    super.requestWindowFeature(1);
    super.setContentView(2130903371);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297857));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297858));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297859));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297446));
    this.c = ((ImageView)findViewById(2131297856));
    this.jdField_a_of_type_AndroidWidgetChronometer = ((Chronometer)findViewById(2131297853));
    this.d = ((ImageView)findViewById(2131297852));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297851));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = ((SurfaceView)findViewById(2131297855)).getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setKeepScreenOn(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    if (Build.VERSION.SDK_INT < 11) {
      this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      if (this.u == 1) {
        n();
      }
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.reset();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
      this.jdField_a_of_type_AndroidHardwareCamera.lock();
    }
  }
  
  @TargetApi(9)
  private void g()
  {
    this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
    this.jdField_a_of_type_AndroidMediaMediaRecorder.reset();
    this.jdField_a_of_type_AndroidHardwareCamera.unlock();
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setCamera(this.jdField_a_of_type_AndroidHardwareCamera);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(5);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSource(1);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(2);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(0);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncoder(3);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncodingBitRate(this.z);
    if (this.s == 1) {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(this.A + 180);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSize(this.w, this.x);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxFileSize(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxDuration(this.y);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnInfoListener(new enm(this));
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface());
      return;
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(this.A);
    }
  }
  
  @TargetApi(9)
  private void h()
  {
    this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
    CamcorderProfile localCamcorderProfile = CamcorderProfile.get(1);
    localCamcorderProfile.videoFrameWidth = this.w;
    localCamcorderProfile.videoFrameHeight = this.x;
    localCamcorderProfile.videoBitRate = this.z;
    localParameters.setPreviewSize(localCamcorderProfile.videoFrameWidth, localCamcorderProfile.videoFrameHeight);
    this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
      label75:
      this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
      this.jdField_a_of_type_AndroidHardwareCamera.unlock();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setCamera(this.jdField_a_of_type_AndroidHardwareCamera);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(0);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSource(1);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setProfile(localCamcorderProfile);
      if (this.s == 1) {
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(this.A + 180);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(this.jdField_e_of_type_JavaLangString);
        return;
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(this.A);
      }
    }
    catch (IOException localIOException)
    {
      break label75;
    }
  }
  
  private void i()
  {
    if (this.t == 0) {
      try
      {
        if (("Samsung".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.MODEL.toUpperCase().startsWith("GT-N710")) && (Build.VERSION.SDK_INT == 19)) {
          h();
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
          this.jdField_a_of_type_AndroidMediaMediaRecorder.start();
          if ((Build.VERSION.SDK_INT <= 10) && (!KapalaiAdapterUtil.a().a(this.jdField_a_of_type_AndroidHardwareCamera.getParameters(), this))) {
            this.d.setVisibility(4);
          }
          this.v = 0;
          this.t = 1;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageLevel(this.t);
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetChronometer.setBase(SystemClock.elapsedRealtime());
          this.jdField_a_of_type_AndroidWidgetChronometer.start();
          return;
          g();
        }
        QQToast.a(this, 1, "正在录制，请先停止录制视频！", 0).a();
      }
      catch (Exception localException)
      {
        QQToast.a(this, 1, "视频录制失败！", 0).a();
        f();
        return;
      }
    }
  }
  
  private void j()
  {
    if (this.t == 1)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
      f();
      e();
      this.jdField_a_of_type_AndroidWidgetChronometer.stop();
      this.t = 2;
      this.v = 1;
      if (new File(this.jdField_e_of_type_JavaLangString).length() == 0L) {
        a("zero_file_size", "troop_bar_video_shoot", "API version:" + Build.VERSION.SDK_INT, Build.MANUFACTURER, Build.MODEL, null);
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageLevel(this.t);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.d.setVisibility(4);
      this.c.setVisibility(8);
      this.c.setVisibility(0);
      this.c.bringToFront();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void k()
  {
    m();
    this.c.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetChronometer.setBase(SystemClock.elapsedRealtime());
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.t = 0;
    this.v = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageLevel(this.t);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_a_of_type_AndroidHardwareCamera == null)
    {
      this.jdField_a_of_type_AndroidHardwareCamera = a(this.s);
      c();
      Display localDisplay = ((WindowManager)getSystemService("window")).getDefaultDisplay();
      int i1 = localDisplay.getWidth();
      localDisplay.getHeight();
      int i2 = this.w * i1 / this.x;
      this.jdField_a_of_type_AndroidViewSurfaceHolder.setFixedSize(i1, i2);
    }
  }
  
  private void l()
  {
    if (this.app.d()) {}
    do
    {
      QQToast.a(this, 0, 2131364435, 0).a();
      do
      {
        return;
      } while (this.v != 1);
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new enn(this));
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new eno(this));
        return;
      }
      catch (Exception localException) {}
    } while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    this.v = 1;
    this.c.setVisibility(8);
    this.c.setVisibility(0);
    this.c.bringToFront();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    if (this.v == 2)
    {
      this.v = 1;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.c.setVisibility(8);
        this.c.setVisibility(0);
        this.c.bringToFront();
      }
    }
  }
  
  private void n()
  {
    Camera.Parameters localParameters;
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      if (KapalaiAdapterUtil.a().a(localParameters, this)) {}
    }
    else
    {
      return;
    }
    if ("off".equals(localParameters.getFlashMode())) {
      localParameters.setFlashMode(KapalaiAdapterUtil.a().a(localParameters));
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
        if (this.u != 1) {
          break label111;
        }
        i1 = 0;
        this.u = i1;
        this.d.setImageLevel(this.u);
        return;
      }
      catch (Exception localException)
      {
        QQToast.a(this, 1, "操作闪光灯失败", 0).a();
        return;
      }
      localException.setFlashMode("off");
      continue;
      label111:
      int i1 = 1;
    }
  }
  
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i1 = paramSize1.height * paramSize1.width;
    int i2 = paramSize2.height * paramSize2.width;
    if (i2 < i1) {
      return 1;
    }
    if (i2 > i1) {
      return -1;
    }
    return 0;
  }
  
  @TargetApi(9)
  public Camera a(int paramInt)
  {
    Object localObject2 = null;
    Camera localCamera = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        switch (Camera.getNumberOfCameras())
        {
        case 0: 
          localObject1 = localObject2;
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
          switch (paramInt)
          {
          case -1: 
            localObject1 = localObject2;
            if (this.s == 1)
            {
              localObject1 = localObject2;
              localCamera = KapalaiAdapterUtil.a().a();
              if (localCamera != null) {
                return localCamera;
              }
            }
            localObject1 = localCamera;
            return Camera.open(this.s);
          }
          break;
        }
      }
      catch (Exception localException)
      {
        QQToast.a(this, 1, "摄像头开启失败", 0).a();
        super.finish();
        return localObject1;
      }
      localObject1 = localObject2;
      throw new RuntimeException();
      localObject1 = localObject2;
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      localObject1 = localObject2;
      this.s = 0;
      localObject1 = localObject2;
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      localObject1 = localObject2;
      Camera.getCameraInfo(0, localCameraInfo);
      localObject1 = localObject2;
      if (localCameraInfo.facing == 1)
      {
        localObject1 = localObject2;
        this.s = 1;
        continue;
        localObject1 = localObject2;
        this.s = 0;
        continue;
        localObject1 = localObject2;
        this.s = 1;
        continue;
      }
    }
    return localException;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.a(null, "P_CliOper", "BizTechReport", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  @TargetApi(14)
  public void c()
  {
    Point localPoint;
    Camera.Parameters localParameters;
    if (("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.MODEL.toUpperCase().startsWith("MI 2")))
    {
      localPoint = a(this.jdField_a_of_type_AndroidHardwareCamera, 800, 480);
      localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      if (Build.VERSION.SDK_INT >= 14) {
        localParameters.setRecordingHint(true);
      }
      this.w = localPoint.x;
      this.x = localPoint.y;
      localParameters.setPreviewSize(this.w, this.x);
      this.A = a(this, this.s);
      this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(this.A);
      if (!KapalaiAdapterUtil.a().a(localParameters, this)) {
        break label178;
      }
      this.d.setVisibility(0);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
        this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
        return;
      }
      catch (IOException localIOException)
      {
        label178:
        e();
        QQToast.a(this, 1, "摄像头开启失败", 0).a();
        super.finish();
      }
      localPoint = a(this.jdField_a_of_type_AndroidHardwareCamera, 640, 480);
      break;
      this.d.setVisibility(4);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a(getIntent());
    d();
    k();
    return true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.t == 1) {
      j();
    }
    e();
    m();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.t == 2)
    {
      this.v = 1;
      this.c.setVisibility(8);
      this.c.setVisibility(0);
      this.c.bringToFront();
      return;
    }
    k();
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_Boolean = true;
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    int i1 = 1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297857: 
      switch (this.t)
      {
      default: 
        return;
      case 0: 
        i();
        return;
      }
      j();
      return;
    case 2131297858: 
      new File(this.jdField_e_of_type_JavaLangString).delete();
      k();
      return;
    case 2131297859: 
      DialogUtil.a(this, 232, null, getString(2131362641, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(new File(this.jdField_e_of_type_JavaLangString).length() / 1024.0D / 1024.0D) }) }), new enk(this), new enl(this)).show();
      return;
    case 2131297446: 
      this.jdField_a_of_type_Boolean = true;
      super.finish();
      return;
    case 2131297852: 
      n();
      return;
    case 2131297851: 
      e();
      if (this.s == 0) {}
      for (;;)
      {
        this.s = i1;
        k();
        return;
        i1 = 0;
      }
    }
    l();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Boolean) {
      new File(this.jdField_e_of_type_JavaLangString).delete();
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramSurfaceHolder.getSurface() == null) || (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    this.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceHolder;
    c();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.VideoRecordActivity
 * JD-Core Version:    0.7.0.1
 */