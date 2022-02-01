package dov.com.qq.im.cropvideo;

import acfp;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqep;
import axyd;
import axye;
import axyf;
import axyg;
import axyh;
import axyj;
import axyk;
import azck;
import azck.a;
import azck.b;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import ipl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import pog.e;
import ram;
import rom;
import rqa;

public class CropVideoActivity
  extends BaseActivity
  implements SurfaceTexture.OnFrameAvailableListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener, GLSurfaceView.Renderer, View.OnClickListener
{
  private GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private axyk jdField_a_of_type_Axyk;
  private RegionView jdField_a_of_type_DovComQqImCropvideoRegionView;
  private ipl b;
  private int crop_width;
  ProgressDialog d;
  private boolean dxo;
  private boolean dxp;
  private int eIL;
  private int eIM;
  private int eIN;
  private int eIO;
  private int eIP;
  private int eIQ;
  private String inputFilePath;
  private long mEndTime;
  private GestureDetector mGestureDetector;
  public Handler mHandler = new axyh(this);
  private float[] mSTMatrix = new float[16];
  private ScaleGestureDetector mScaleGestureDetector;
  private long mStartTime;
  private MediaPlayer mediaPlayer;
  private String outputFilePath;
  private int progress;
  private ProgressBar progressBar;
  private int rotation;
  public Runnable runnable = new CropVideoActivity.6(this);
  private boolean surfaceCreated;
  private SurfaceTexture surfaceTexture;
  protected int textureId = -1;
  
  public static void a(Activity paramActivity, long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "jumpToCropVideoActivity videoPath: " + paramString + ", startTime: " + paramLong1 + ", endTime: " + paramLong2);
    }
    Intent localIntent = new Intent(paramActivity, CropVideoActivity.class);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 750);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 520);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 750);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 520);
    int i = aqep.x(paramActivity);
    int j = i * 520 / 750;
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", j);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 750);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 520);
    localIntent.putExtra("video_start_time", paramLong1);
    localIntent.putExtra("video_end_time", paramLong2);
    localIntent.putExtra("video_local_path", paramString);
    localIntent.addFlags(603979776);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    rqa localrqa = rqa.a(getApplicationContext());
    if (localrqa.LT())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CropVideoActivity", 2, "ffmpeg is running!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-vf");
    localArrayList.add("crop=" + paramInt3 + ":" + paramInt4 + ":" + paramInt1 + ":" + paramInt2);
    localArrayList.add("-preset");
    localArrayList.add("ultrafast");
    localArrayList.add("-tune");
    localArrayList.add("zerolatency");
    localArrayList.add("-vcodec");
    localArrayList.add("libx264");
    localArrayList.add("-acodec");
    localArrayList.add("aac");
    localArrayList.add(paramString2);
    try
    {
      localrqa.a((String[])localArrayList.toArray(new String[0]), new axyj(this));
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CropVideoActivity", 2, "ffmpeg Exception", paramString1);
      }
      paramString1.printStackTrace();
      this.mHandler.sendEmptyMessage(4);
    }
  }
  
  private int go(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    label778:
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString);
        str1 = localMediaMetadataRetriever.extractMetadata(18);
        str2 = localMediaMetadataRetriever.extractMetadata(19);
        paramString = localMediaMetadataRetriever.extractMetadata(24);
        localMediaMetadataRetriever.release();
        if ((paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString))) {
          break label778;
        }
        paramString = "0";
        if ((str1 == null) || (str2 == null))
        {
          if (QLog.isColorLevel()) {
            QLog.e("CropVideoActivity", 2, "extractMetadata width: " + str1 + ", height: " + str2);
          }
          return -2;
        }
      }
      catch (IllegalArgumentException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CropVideoActivity", 2, "getCropRegion setDataSource", paramString);
        }
        return -1;
      }
      for (;;)
      {
        int i;
        int j;
        int n;
        int k;
        int m;
        int i1;
        int i2;
        try
        {
          i = Integer.parseInt(str1);
          j = Integer.parseInt(str2);
          n = Integer.parseInt(paramString);
          paramString = this.jdField_a_of_type_Axyk.w();
          k = this.jdField_a_of_type_Axyk.Rz();
          m = this.jdField_a_of_type_Axyk.RA();
          i1 = this.jdField_a_of_type_DovComQqImCropvideoRegionView.yD();
          i2 = this.jdField_a_of_type_DovComQqImCropvideoRegionView.MO();
          if (Build.VERSION.SDK_INT >= 21)
          {
            this.eIM = paramString.left;
            this.eIN = paramString.top;
            this.crop_width = k;
            this.eIO = m;
            this.eIP = i1;
            this.eIQ = i2;
            if (n != 90)
            {
              m = j;
              k = i;
              if (n != 270) {}
            }
            else
            {
              k = j;
              m = i;
            }
            this.rotation = n;
            if (QLog.isColorLevel()) {
              QLog.d("CropVideoActivity", 2, "startCropVideo width: " + k + ", height: " + m + ", crop_x: " + this.eIM + ", crop_y: " + this.eIN + ", crop_width: " + this.crop_width + ", crop_height: " + this.eIO + ", target_width: " + this.eIP + ", target_height: " + this.eIQ);
            }
            if ((this.eIM >= 0) && (this.eIM <= k) && (this.eIN >= 0) && (this.eIN <= m) && (this.crop_width > 0) && (this.crop_width <= k) && (this.eIO > 0) && (this.eIO <= m) && (this.eIM + this.crop_width <= k) && (this.eIN + this.eIO <= m)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e("CropVideoActivity", 2, "startCropVideo crop region illegal");
            }
            return -4;
          }
        }
        catch (NumberFormatException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("CropVideoActivity", 2, "getCropRegion parseInt", paramString);
          }
          return -3;
        }
        switch (n)
        {
        default: 
          this.eIM = paramString.left;
          this.eIN = paramString.top;
          this.crop_width = k;
          this.eIO = m;
          this.eIP = i1;
          this.eIQ = i2;
          m = j;
          k = i;
          break;
        case 90: 
          this.eIM = paramString.top;
          this.eIN = paramString.right;
          this.crop_width = m;
          this.eIO = k;
          this.eIP = i2;
          this.eIQ = i1;
          m = j;
          k = i;
          break;
        case 180: 
          this.eIM = paramString.right;
          this.eIN = paramString.bottom;
          this.crop_width = k;
          this.eIO = m;
          this.eIP = i1;
          this.eIQ = i2;
          m = j;
          k = i;
          break;
        case 270: 
          this.eIM = paramString.bottom;
          this.eIN = paramString.left;
          this.crop_width = m;
          this.eIO = k;
          this.eIP = i2;
          this.eIQ = i1;
          m = j;
          k = i;
        }
      }
      return 0;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.setContentView(2131561093);
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("CropVideoActivity", 2, "doOnCreate");
    }
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(0);
      this.mSystemBarComp.setStatusBarColor(0);
      this.mSystemBarComp.setStatusDrawable(null);
      i = ImmersiveUtils.getStatusBarHeight(this);
      paramBundle = findViewById(2131364118);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      localLayoutParams.topMargin = (i + localLayoutParams.topMargin);
      paramBundle.setLayoutParams(localLayoutParams);
    }
    paramBundle = getIntent();
    this.mStartTime = paramBundle.getLongExtra("video_start_time", 0L);
    this.mEndTime = paramBundle.getLongExtra("video_end_time", 9223372036854775807L);
    this.inputFilePath = paramBundle.getStringExtra("video_local_path");
    this.outputFilePath = paramBundle.getStringExtra("PhotoConst.TARGET_PATH");
    int i = paramBundle.getIntExtra("PhotoConst.CLIP_WIDTH", 750);
    int j = paramBundle.getIntExtra("PhotoConst.CLIP_HEIGHT", 520);
    int k = paramBundle.getIntExtra("PhotoConst.TARGET_WIDTH", 750);
    int m = paramBundle.getIntExtra("PhotoConst.TARGET_HEIGHT", 520);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = ((GLSurfaceView)findViewById(2131368067));
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setEGLContextClientVersion(2);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setRenderer(this);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setRenderMode(0);
    this.progressBar = ((ProgressBar)findViewById(2131373660));
    this.progressBar.setProgress(0);
    this.progressBar.setMax(100);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView = ((RegionView)findViewById(2131377047));
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setMaskColor(-2147483648);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setUsedARGB(true);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setMaskShapeType(1);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setTargetWidth(k);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setTargetHeight(m);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setClipWidth(i);
    this.jdField_a_of_type_DovComQqImCropvideoRegionView.setClipHeight(j);
    findViewById(2131364221).setOnClickListener(this);
    findViewById(2131365529).setOnClickListener(this);
    this.mGestureDetector = new GestureDetector(this, new axyd(this));
    this.b = new ipl(this, new axye(this));
    this.mScaleGestureDetector = new ScaleGestureDetector(this, new axyf(this));
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setOnTouchListener(new axyg(this));
    this.mediaPlayer = new MediaPlayer();
    try
    {
      this.mediaPlayer.setDataSource(this, Uri.parse(this.inputFilePath));
      this.mediaPlayer.setAudioStreamType(3);
      this.mediaPlayer.setLooping(true);
      this.mediaPlayer.setOnVideoSizeChangedListener(this);
      this.mediaPlayer.setOnCompletionListener(this);
      return true;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("CropVideoActivity", 2, "setDataSource", paramBundle);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.mediaPlayer != null)
    {
      this.mediaPlayer.stop();
      this.mediaPlayer.release();
    }
    go();
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    if (this.mediaPlayer != null)
    {
      this.mediaPlayer.pause();
      this.eIL = this.mediaPlayer.getCurrentPosition();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.surfaceCreated) && (this.mediaPlayer != null))
    {
      this.mediaPlayer.seekTo(this.eIL);
      this.mediaPlayer.start();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772002, 2130772013);
  }
  
  public void go()
  {
    if ((this.d != null) && (this.d.isShowing())) {}
    try
    {
      this.d.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CropVideoActivity", 2, "cancelProgressDialog", localException);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.mHandler.sendEmptyMessage(2);
      continue;
      finish();
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "onCompletion");
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      if (this.dxo)
      {
        this.surfaceTexture.updateTexImage();
        this.surfaceTexture.getTransformMatrix(this.mSTMatrix);
        this.jdField_a_of_type_Axyk.h(this.mSTMatrix);
        this.dxo = false;
      }
      this.jdField_a_of_type_Axyk.onDrawFrame(this.textureId);
      return;
    }
    finally {}
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.dxo = true;
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.requestRender();
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "onSurfaceChanged width: " + paramInt1 + ", height: " + paramInt2);
    }
    this.jdField_a_of_type_Axyk.ly(paramInt1, paramInt2);
    int k = this.jdField_a_of_type_DovComQqImCropvideoRegionView.getClipWidth();
    int j = this.jdField_a_of_type_DovComQqImCropvideoRegionView.getClipHeight();
    int i = (paramInt1 - k) / 2;
    paramInt1 = (k + paramInt1) / 2;
    k = (paramInt2 - j) / 2;
    paramInt2 = (j + paramInt2) / 2;
    this.jdField_a_of_type_Axyk.aa(i, k, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "onSurfaceCreated");
    }
    if (this.jdField_a_of_type_Axyk == null)
    {
      this.jdField_a_of_type_Axyk = new axyk();
      this.jdField_a_of_type_Axyk.initGL();
      this.jdField_a_of_type_Axyk.bA(4.0F);
      this.jdField_a_of_type_Axyk.bz(1.0F);
    }
    if (this.textureId == -1)
    {
      paramGL10 = new int[1];
      GLES20.glGenTextures(1, paramGL10, 0);
      GLES20.glBindTexture(36197, paramGL10[0]);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameteri(36197, 10242, 33071);
      GLES20.glTexParameteri(36197, 10243, 33071);
      this.textureId = paramGL10[0];
      this.surfaceTexture = new SurfaceTexture(this.textureId);
      this.surfaceTexture.setOnFrameAvailableListener(this);
      paramGL10 = new Surface(this.surfaceTexture);
      this.mediaPlayer.setSurface(paramGL10);
      paramGL10.release();
      if (this.dxp) {}
    }
    try
    {
      this.mediaPlayer.prepare();
      this.dxp = true;
      this.dxp = true;
      if (isResume())
      {
        this.mediaPlayer.seekTo(this.eIL);
        this.mediaPlayer.start();
      }
      this.surfaceCreated = true;
      return;
    }
    catch (IOException paramGL10)
    {
      for (;;)
      {
        paramGL10.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("CropVideoActivity", 2, "media player prepare failed", paramGL10);
        }
      }
    }
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "onVideoSizeChanged: " + paramInt1 + " " + paramInt2);
    }
    this.jdField_a_of_type_Axyk.jo(paramInt1, paramInt2);
  }
  
  public void showProgressDialog()
  {
    if (this.d == null)
    {
      this.d = new ReportProgressDialog(this, 2131756467);
      this.d.setCanceledOnTouchOutside(false);
      this.d.show();
      this.d.setContentView(2131559761);
    }
    ((TextView)this.d.findViewById(2131373180)).setText(acfp.m(2131704527));
    if ((!this.d.isShowing()) && (!isFinishing())) {
      this.d.show();
    }
  }
  
  public static class a
  {
    private static int a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2)
    {
      ram.d("CropVideoActivity", "startCropVideo cropX: " + paramInt1 + ", cropY: " + paramInt2 + ", cropWidth: " + paramInt3 + ", cropHeight: " + paramInt4 + ", targetWidth: " + paramInt5 + ", targetHeight: " + paramInt6 + ", startTime: " + paramLong1 + ", endTime: " + paramLong2);
      int i = paramInt5;
      if (paramInt5 == -1) {
        i = paramInt3;
      }
      paramInt5 = paramInt6;
      if (paramInt6 == -1) {
        paramInt5 = paramInt4;
      }
      if (paramLong1 < 0L)
      {
        ram.e("CropVideoActivity", "startCropVideo illegal start time!");
        return -1;
      }
      if ((paramLong1 >= paramLong2) && (paramLong2 >= 0L))
      {
        ram.e("CropVideoActivity", "startCropVideo illegal time!");
        return -2;
      }
      paramInt6 = paramInt1;
      if (paramInt1 % 2 != 0) {
        paramInt6 = (paramInt1 + 1) / 2 * 2;
      }
      paramInt1 = paramInt2;
      if (paramInt2 % 2 != 0) {
        paramInt1 = (paramInt2 + 1) / 2 * 2;
      }
      paramInt2 = paramInt3;
      if (paramInt3 % 16 != 0) {
        paramInt2 = paramInt3 / 16 * 16;
      }
      paramInt3 = paramInt4;
      if (paramInt4 % 16 != 0) {
        paramInt3 = paramInt4 / 16 * 16;
      }
      if (i % 16 != 0) {
        paramInt4 = i / 16;
      }
      if (paramInt5 % 16 != 0) {
        paramInt4 = paramInt5 / 16;
      }
      paramString1 = new File(paramString1);
      paramString2 = new CropVideoActivity.b(paramString2, 2048000, paramLong1, paramLong2, false, true);
      paramString2.Z(paramInt6, paramInt1, paramInt2, paramInt3);
      if ((new azck().a(paramString1, paramString2, true)) && (paramString2.e == null)) {
        return 0;
      }
      return -3;
    }
    
    public static void a(@NonNull String paramString1, @NonNull String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, @NonNull pog.e parame)
    {
      rom.checkNotNull(paramString1);
      rom.checkNotNull(paramString2);
      rom.checkNotNull(parame);
      ThreadManager.newFreeThread(new CropVideoActivity.CropUtils.1(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong1, paramLong2, parame), "VideoCrop", 5).start();
    }
  }
  
  public static class b
    implements azck.a
  {
    final String JV;
    boolean aAY;
    int bjA = 1024000;
    int bjB = 25;
    int bjC;
    int bjD;
    int bjE;
    int bjF;
    public Throwable e;
    boolean isCanceled;
    final long mEndTime;
    boolean mIsMute;
    final long mStartTime;
    
    public b(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.JV = paramString;
      this.bjA = paramInt;
      this.mStartTime = paramLong1;
      this.mEndTime = paramLong2;
      this.mIsMute = paramBoolean1;
      this.aAY = paramBoolean2;
    }
    
    public void Z(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.bjC = paramInt1;
      this.bjD = paramInt2;
      this.bjE = paramInt3;
      this.bjF = paramInt4;
    }
    
    public azck.b a(int paramInt1, int paramInt2)
    {
      azck.b localb = new azck.b();
      if (paramInt1 <= paramInt2) {}
      for (;;)
      {
        File localFile = new File(this.JV);
        if (localFile.exists()) {
          localFile.delete();
        }
        localb.as = localFile;
        localb.videoBitRate = this.bjA;
        localb.scaleRate = (960.0F / paramInt2);
        localb.videoFrameRate = this.bjB;
        localb.cHX = rk();
        localb.beginTime = this.mStartTime;
        localb.endTime = this.mEndTime;
        localb.isMute = this.mIsMute;
        localb.cHY = this.aAY;
        localb.bjC = this.bjC;
        localb.bjD = this.bjD;
        localb.bjE = this.bjE;
        localb.bjF = this.bjF;
        ram.b("CropVideoActivity", "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localb.cHX + ", scaleRate=" + localb.scaleRate + ", videoBitRate=" + localb.videoBitRate + ", videoFrameRate=" + localb.videoFrameRate + ", beginTime=" + localb.beginTime + ", endTime=" + localb.endTime, ", isMute=" + this.mIsMute, ", accurateSeek=" + this.aAY + ", cropX=" + this.bjC + ", cropY=" + this.bjD + ", cropWidth=" + this.bjE + ", cropHeight=" + this.bjF);
        return localb;
        paramInt2 = paramInt1;
      }
    }
    
    public void ahK()
    {
      ram.e("CropVideoActivity", "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
    }
    
    public void f(Throwable paramThrowable)
    {
      ram.e("CropVideoActivity", "HWCompressProcessor, step: HWCompressProcessor onFailed");
      this.e = paramThrowable;
    }
    
    public void onCanceled()
    {
      ram.i("CropVideoActivity", "HWCompressProcessor, step: HWCompressProcessor onCanceled");
      this.isCanceled = true;
    }
    
    public void onProgress(int paramInt)
    {
      ram.d("CropVideoActivity", "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
    }
    
    public boolean rk()
    {
      boolean bool = false;
      if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
        bool = true;
      }
      while (Build.VERSION.SDK_INT <= 19) {
        return bool;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.CropVideoActivity
 * JD-Core Version:    0.7.0.1
 */