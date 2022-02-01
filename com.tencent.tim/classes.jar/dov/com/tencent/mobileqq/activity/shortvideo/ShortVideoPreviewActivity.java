package dov.com.tencent.mobileqq.activity.shortvideo;

import acfp;
import agmx;
import ahal;
import ahao;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import anot;
import aqft;
import aqha;
import aqhq;
import aqiw;
import aqju;
import arhz;
import aywc;
import aywd;
import aywe;
import aywf;
import aywg;
import aywh;
import aywi;
import aywj;
import aywk;
import aywl;
import aywm;
import aywn;
import aywo;
import aywp;
import aywq;
import aywr;
import azay;
import azck;
import azck.a;
import azck.b;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import dov.com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import dov.com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ShortVideoPreviewActivity
  extends BaseActivity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, View.OnClickListener, Runnable
{
  public static int cnx;
  public final MqqHandler B = new aywi(this);
  TextView OU;
  public TextView OV;
  public TextView OW;
  public TextView OX;
  SurfaceHolder.Callback a = new aywm(this);
  boolean bBC;
  boolean bBD;
  boolean bBE = false;
  public String beK;
  String cYa;
  int cnq;
  int cnr;
  public int cns;
  public int cnu;
  public int cnv;
  public int cnw;
  int cny;
  boolean dBm;
  public boolean dBn;
  public boolean dBo;
  public int duration = -1;
  public Runnable fo = new ShortVideoPreviewActivity.17(this);
  LinearLayout id;
  public Button ig;
  Bitmap mBitmap;
  public ImageView mCover;
  public long mDuration;
  public MediaPlayer mMediaPlayer;
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new aywj(this);
  public int mPlayState = 0;
  BroadcastReceiver mScreenReceiver = new aywc(this);
  public SurfaceView mSurfaceView;
  String mUin;
  int mUinType;
  public String mVideoPath;
  public long mVideoSize;
  public SeekBar p;
  ArrayList<String> sy;
  ImageView wP;
  public ImageView wQ;
  
  public static HashMap<String, String> a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str1 = ShortVideoUtils.by(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    Object localObject1 = ShortVideoTrimmer.a(paramString);
    Object localObject2;
    int i;
    boolean bool;
    int j;
    if ((localObject1 != null) && (((ShortVideoTrimmer.a)localObject1).cHR)) {
      if (Build.VERSION.SDK_INT >= 18)
      {
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
        String str2 = ((MediaMetadataRetriever)localObject2).extractMetadata(9);
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(str2);
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("ShortVideoPreviewActivity", 1, "duration is NaN", localException);
            ((MediaMetadataRetriever)localObject2).release();
          }
        }
        finally
        {
          ((MediaMetadataRetriever)localObject2).release();
        }
        i = azay.az(paramContext);
        if (((i & 0x1) > 0) && ((i & 0x2) > 0))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: isHWCodecSupported = " + bool);
          }
          if (!bool) {
            break label378;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
          }
          localObject2 = new File(paramString);
          localObject1 = new a(str1, (int)(((ShortVideoTrimmer.a)localObject1).alX * 1024L), (int)((ShortVideoTrimmer.a)localObject1).alW, 0L, l1);
          if ((!new azck().a((File)localObject2, (azck.a)localObject1, true)) || (((a)localObject1).e != null)) {
            break label363;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
          }
          j = 0;
          label250:
          i = j;
          localObject1 = str1;
          if (j != 0)
          {
            i = j;
            localObject1 = str1;
            if (!TextUtils.isEmpty(str1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
              }
              i = ShortVideoTrimmer.f(paramContext, paramString, str1);
              localObject1 = str1;
            }
          }
        }
      }
    }
    for (;;)
    {
      localHashMap.put("outputPath", localObject1);
      localHashMap.put("ret", String.valueOf(i));
      return localHashMap;
      bool = false;
      break;
      label363:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodecr");
      }
      label378:
      j = -1;
      break label250;
      if ((localObject1 != null) && (!((ShortVideoTrimmer.a)localObject1).cHR))
      {
        i = 0;
        localObject1 = paramString;
      }
      else
      {
        i = -1;
        localObject1 = str1;
      }
    }
  }
  
  public static void ag(Context paramContext, int paramInt)
  {
    aqha.a(paramContext, 232, null, paramContext.getString(paramInt), new aywh(), null).show();
  }
  
  private void cAI()
  {
    this.mVideoSize = new File(this.mVideoPath).length();
    if ((aqiw.isNetworkAvailable(this)) && (!aqiw.isWifiConnected(this)) && (this.mVideoSize > agmx.fJ()))
    {
      ahal.a(this, 2131693826, 2131693832, new aywg(this));
      return;
    }
    cAJ();
    setResult(-1);
  }
  
  private void cAJ()
  {
    Intent localIntent = getIntent();
    String str2 = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME");
    Object localObject = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = str2;
      if (str2 == null)
      {
        QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).show();
        return;
      }
    }
    localIntent.setClassName((String)localObject, str1);
    localIntent.putExtra("file_send_path", this.mVideoPath);
    localIntent.putExtra("file_send_duration", this.mDuration);
    localIntent.putExtra("file_send_size", this.mVideoSize);
    localIntent.putExtra("uin", this.mUin);
    localIntent.putExtra("uintype", this.mUinType);
    localIntent.putExtra("file_source", this.beK);
    localIntent.putExtra("start_init_activity_after_sended", true);
    if (!this.bBC) {
      anot.a(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
    }
    localObject = getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("custom_shortvideopreview_sendbtn_reportActionName")))
    {
      str2 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportActionName");
      str1 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportReverse2");
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      if (str2 != null) {
        anot.a(null, "CliOper", "", "", str2, str2, 0, 0, (String)localObject, "", "", "");
      }
    }
    startActivity(localIntent);
  }
  
  public void GR(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {}
    for (;;)
    {
      return;
      this.mPlayState = paramInt;
      if (paramInt == 1)
      {
        this.mCover.setVisibility(8);
        this.wP.setImageResource(2130847021);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPreviewActivity", 2, "changePlayState, playState => " + bA(paramInt));
        return;
        this.wP.setImageResource(2130847020);
      }
    }
  }
  
  public void azR()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
    }
    GR(0);
  }
  
  public String bA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    }
    return " error ";
  }
  
  void cAG()
  {
    if (this.OV != null) {
      switch (this.cny)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        this.OV.setText(2131721079);
      }
    }
    for (;;)
    {
      if (this.bBE)
      {
        this.OV.setVisibility(8);
        if (this.OU != null) {
          this.OU.setText(2131720024);
        }
      }
      return;
      StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131714481));
      if ((this.bBD) && (this.sy != null) && (this.sy.size() > 0)) {
        localStringBuilder.append("(").append(this.sy.size()).append(")");
      }
      this.OV.setText(localStringBuilder);
      continue;
      this.OV.setText(2131721079);
      continue;
      this.OV.setText(2131699492);
      continue;
      if ((this.dBo) && (this.dBm)) {
        this.OV.setText(2131719463);
      }
      if ((this.dBo) && (this.dBn))
      {
        this.OV.setText(2131693747);
        this.OV.setEnabled(false);
        this.OV.setTextColor(-2130706433);
        this.wP.setVisibility(8);
        this.ig.setVisibility(0);
        this.id.setVisibility(0);
      }
    }
  }
  
  void cAH()
  {
    if (aqft.hE() > 512000L)
    {
      if (aqiw.isMobileNetWork(this))
      {
        this.mVideoSize = new File(this.mVideoPath).length();
        String str = ShortVideoUtils.g(this, this.mVideoSize);
        aqha.a(this, 232, null, String.format(getResources().getString(2131720250), new Object[] { str }), new aywe(this), new aywf(this)).show();
        return;
      }
      cAJ();
      return;
    }
    ag(this, 2131720275);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    initData(super.getIntent());
    if (paramBundle != null)
    {
      this.cnw = paramBundle.getInt("state_play_state");
      this.cnv = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "onCreate(), mSavedCurPosition : " + this.cnv + ",mSavedPlayState : " + bA(this.cnw));
      }
    }
    super.setContentView(2131561702);
    this.mSurfaceView = ((SurfaceView)findViewById(2131379021));
    this.mSurfaceView.getHolder().setType(3);
    this.mSurfaceView.getHolder().addCallback(this.a);
    this.mSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new aywk(this));
    this.mCover = ((ImageView)findViewById(2131365477));
    this.OU = ((TextView)findViewById(2131364222));
    this.OU.setOnClickListener(this);
    this.OV = ((TextView)findViewById(2131377981));
    this.OV.setOnClickListener(this);
    this.wP = ((ImageView)findViewById(2131372728));
    this.wP.setOnClickListener(this);
    this.ig = ((Button)findViewById(2131365567));
    this.ig.setOnClickListener(this);
    this.id = ((LinearLayout)findViewById(2131372455));
    this.OW = ((TextView)findViewById(2131373667));
    this.OX = ((TextView)findViewById(2131380109));
    this.wQ = ((ImageView)findViewById(2131372729));
    this.wQ.setImageResource(2130847021);
    this.wQ.setOnClickListener(this);
    this.p = ((SeekBar)findViewById(2131377915));
    this.p.setVisibility(0);
    this.p.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.ig = ((Button)findViewById(2131365567));
    this.ig.setOnClickListener(this);
    this.mCover.getViewTreeObserver().addOnGlobalLayoutListener(new aywl(this));
    cAG();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.mScreenReceiver, paramBundle);
    if ((this.dBo) && (this.dBn))
    {
      play(0);
      if (this.B != null) {
        this.app.setHandler(ShortVideoPreviewActivity.class, this.B);
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.B != null) {
      this.B.removeCallbacks(this.fo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "doOnDestroy");
    }
    azR();
    if (this.mBitmap != null)
    {
      if (!this.mBitmap.isRecycled()) {
        this.mBitmap.recycle();
      }
      this.mBitmap = null;
    }
    unregisterReceiver(this.mScreenReceiver);
  }
  
  public void eTT()
  {
    int i = this.mMediaPlayer.getVideoWidth();
    int j = this.mMediaPlayer.getVideoHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "adjustVideoRatio, videoWith:" + i + ",videoHeight:" + j);
    }
    if ((this.cnu == 0) || (this.cns == 0) || (i == 0) || (j == 0)) {
      return;
    }
    if (this.cnu / this.cns > j / i)
    {
      f = this.cns;
      i = (int)(j * f / i);
      i = (int)((this.cnu - i) / 2.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(0, i, 0, i);
      this.mSurfaceView.setLayoutParams(localLayoutParams);
      return;
    }
    float f = this.cnu;
    i = (int)(i * f / j);
    i = (int)((this.cns - i) / 2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(i, 0, i, 0);
    this.mSurfaceView.setLayoutParams(localLayoutParams);
  }
  
  /* Error */
  public String f(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 5
    //   12: new 219	java/io/File
    //   15: dup
    //   16: new 197	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   23: getstatic 767	aasa:SDCARD_PATH	Ljava/lang/String;
    //   26: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 769
    //   32: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 221	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 6
    //   43: aload 6
    //   45: invokevirtual 772	java/io/File:exists	()Z
    //   48: ifne +9 -> 57
    //   51: aload 6
    //   53: invokevirtual 775	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: invokestatic 780	java/lang/System:currentTimeMillis	()J
    //   60: lstore_2
    //   61: aload_1
    //   62: ifnull +97 -> 159
    //   65: new 219	java/io/File
    //   68: dup
    //   69: aload 6
    //   71: new 197	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   78: lload_2
    //   79: invokestatic 783	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   82: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 785
    //   88: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 788	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   97: astore 6
    //   99: aload 6
    //   101: invokevirtual 791	java/io/File:createNewFile	()Z
    //   104: ifeq +227 -> 331
    //   107: aload 6
    //   109: invokevirtual 794	java/io/File:getPath	()Ljava/lang/String;
    //   112: astore 4
    //   114: new 796	java/io/FileOutputStream
    //   117: dup
    //   118: aload 6
    //   120: invokevirtual 794	java/io/File:getPath	()Ljava/lang/String;
    //   123: invokespecial 797	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   126: astore 5
    //   128: aload_1
    //   129: getstatic 803	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   132: bipush 100
    //   134: aload 5
    //   136: invokevirtual 807	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   139: pop
    //   140: aload 4
    //   142: astore_1
    //   143: aload_1
    //   144: astore 4
    //   146: aload 5
    //   148: ifnull +11 -> 159
    //   151: aload 5
    //   153: invokevirtual 810	java/io/FileOutputStream:close	()V
    //   156: aload_1
    //   157: astore 4
    //   159: aload 4
    //   161: areturn
    //   162: astore 6
    //   164: aconst_null
    //   165: astore 5
    //   167: aload 7
    //   169: astore_1
    //   170: aload 5
    //   172: astore 4
    //   174: aload 6
    //   176: invokevirtual 813	java/lang/OutOfMemoryError:printStackTrace	()V
    //   179: aload_1
    //   180: astore 4
    //   182: aload 5
    //   184: ifnull -25 -> 159
    //   187: aload 5
    //   189: invokevirtual 810	java/io/FileOutputStream:close	()V
    //   192: aload_1
    //   193: areturn
    //   194: astore 4
    //   196: aload_1
    //   197: areturn
    //   198: astore 6
    //   200: aconst_null
    //   201: astore 5
    //   203: aload 8
    //   205: astore_1
    //   206: aload 5
    //   208: astore 4
    //   210: ldc 195
    //   212: iconst_1
    //   213: new 197	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 815
    //   223: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 6
    //   228: invokevirtual 818	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 821	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_1
    //   238: astore 4
    //   240: aload 5
    //   242: ifnull -83 -> 159
    //   245: aload 5
    //   247: invokevirtual 810	java/io/FileOutputStream:close	()V
    //   250: aload_1
    //   251: areturn
    //   252: astore 4
    //   254: aload_1
    //   255: areturn
    //   256: astore_1
    //   257: aconst_null
    //   258: astore 4
    //   260: aload 4
    //   262: ifnull +8 -> 270
    //   265: aload 4
    //   267: invokevirtual 810	java/io/FileOutputStream:close	()V
    //   270: aload_1
    //   271: athrow
    //   272: astore 4
    //   274: aload_1
    //   275: areturn
    //   276: astore 4
    //   278: goto -8 -> 270
    //   281: astore_1
    //   282: aload 5
    //   284: astore 4
    //   286: goto -26 -> 260
    //   289: astore_1
    //   290: goto -30 -> 260
    //   293: astore 6
    //   295: aload 4
    //   297: astore_1
    //   298: aconst_null
    //   299: astore 5
    //   301: goto -95 -> 206
    //   304: astore 6
    //   306: aload 4
    //   308: astore_1
    //   309: goto -103 -> 206
    //   312: astore 6
    //   314: aload 4
    //   316: astore_1
    //   317: aconst_null
    //   318: astore 5
    //   320: goto -150 -> 170
    //   323: astore 6
    //   325: aload 4
    //   327: astore_1
    //   328: goto -158 -> 170
    //   331: aconst_null
    //   332: astore 4
    //   334: aload 5
    //   336: astore_1
    //   337: aload 4
    //   339: astore 5
    //   341: goto -198 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	ShortVideoPreviewActivity
    //   0	344	1	paramBitmap	Bitmap
    //   60	19	2	l	long
    //   1	180	4	localObject1	Object
    //   194	1	4	localException1	Exception
    //   208	31	4	localObject2	Object
    //   252	1	4	localException2	Exception
    //   258	8	4	localObject3	Object
    //   272	1	4	localException3	Exception
    //   276	1	4	localException4	Exception
    //   284	54	4	localObject4	Object
    //   10	330	5	localObject5	Object
    //   41	78	6	localFile	File
    //   162	13	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   198	29	6	localException5	Exception
    //   293	1	6	localException6	Exception
    //   304	1	6	localException7	Exception
    //   312	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   323	1	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4	164	7	localObject6	Object
    //   7	197	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   99	114	162	java/lang/OutOfMemoryError
    //   187	192	194	java/lang/Exception
    //   99	114	198	java/lang/Exception
    //   245	250	252	java/lang/Exception
    //   99	114	256	finally
    //   114	128	256	finally
    //   151	156	272	java/lang/Exception
    //   265	270	276	java/lang/Exception
    //   128	140	281	finally
    //   174	179	289	finally
    //   210	237	289	finally
    //   114	128	293	java/lang/Exception
    //   128	140	304	java/lang/Exception
    //   114	128	312	java/lang/OutOfMemoryError
    //   128	140	323	java/lang/OutOfMemoryError
  }
  
  void initData(Intent paramIntent)
  {
    this.mVideoPath = paramIntent.getExtras().getString("file_send_path");
    this.mDuration = paramIntent.getExtras().getLong("file_send_duration");
    this.mVideoSize = paramIntent.getExtras().getLong("file_send_size");
    this.cnq = paramIntent.getIntExtra("file_width", 0);
    this.cnr = paramIntent.getIntExtra("file_height", 0);
    paramIntent.removeExtra("file_width");
    paramIntent.removeExtra("file_height");
    this.mUin = paramIntent.getExtras().getString("uin");
    this.mUinType = paramIntent.getIntExtra("uintype", -1);
    this.beK = paramIntent.getStringExtra("file_source");
    this.bBE = paramIntent.getBooleanExtra("preview_only", false);
    this.dBo = paramIntent.getBooleanExtra("from_mobile_mp", false);
    this.dBm = paramIntent.getBooleanExtra("preview", false);
    this.dBn = paramIntent.getBooleanExtra("cutImage", false);
    this.bBC = paramIntent.getBooleanExtra("is_from_system_media", true);
    this.bBD = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.bBD) {
      this.sy = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    }
    boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_REWARD", false);
    boolean bool3 = paramIntent.getBooleanExtra("from_health", false);
    paramIntent = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if ((paramIntent.contains("SplashActivity")) || (paramIntent.contains("ChatActivity"))) {
      this.cny = 0;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(this.mVideoPath)) || ((this.cny != 2) && (this.cny != 6) && (!bool3) && (TextUtils.isEmpty(this.mUin))) || (!aqhq.fileExistsAndNotEmpty(this.mVideoPath)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPreviewActivity", 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
        }
        QQToast.a(this, 2131720257, 0).show();
        super.finish();
      }
      return;
      if (paramIntent.contains("QZonePublishMoodTabActivity")) {
        this.cny = 1;
      } else if (paramIntent.contains("QZoneUploadPhotoActivity")) {
        this.cny = 1;
      } else if (bool1) {
        this.cny = 2;
      } else if (bool2) {
        this.cny = 5;
      } else if (paramIntent.contains("TrimVideoActivity")) {
        this.cny = 3;
      } else if (paramIntent.contains("LiteActivity")) {
        this.cny = 4;
      } else if ((paramIntent.contains("QQBrowserActivity")) || (paramIntent.contains("PublicAccountBrowser"))) {
        this.cny = 6;
      } else if (bool3) {
        this.cny = 7;
      } else if (this.dBo) {
        this.cny = 8;
      } else {
        this.cny = 0;
      }
    }
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    switch (paramView.getId())
    {
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.dBo) && (this.dBn)) {
        this.B.removeCallbacks(this.fo);
      }
      super.finish();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + bA(this.mPlayState));
      }
      if ((this.cnw == 2) && (this.cnv > 0))
      {
        play(this.cnv);
        this.cnw = 0;
        this.cnv = 0;
      }
      else
      {
        switch (this.mPlayState)
        {
        default: 
          break;
        case 0: 
          if (this.app.bF()) {
            QQToast.a(this, 0, 2131720263, 0).show();
          } else {
            play(0);
          }
          break;
        case 1: 
          pause();
          break;
        case 2: 
          resume();
          break;
        case 3: 
          play(0);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + bA(this.mPlayState));
          }
          if ((this.cnw == 2) && (this.cnv > 0))
          {
            play(this.cnv);
            this.cnw = 0;
            this.cnv = 0;
          }
          else
          {
            switch (this.mPlayState)
            {
            default: 
              break;
            case 0: 
              if (this.app.bF()) {
                QQToast.a(this, 0, 2131720263, 0).show();
              } else {
                play(0);
              }
              break;
            case 1: 
              this.wQ.setImageResource(2130847020);
              pause();
              break;
            case 2: 
              this.wQ.setImageResource(2130847021);
              resume();
              break;
            case 3: 
              play(0);
              continue;
              this.cYa = sS(this.mVideoPath);
              continue;
              switch (this.cny)
              {
              case 6: 
              default: 
                break;
              case 0: 
                cAH();
                break;
              case 4: 
                cAI();
                break;
              case 1: 
              case 3: 
                localObject1 = super.getIntent();
                ((Intent)localObject1).putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
                ((Intent)localObject1).putExtra("PhotoConst.VIDEO_SIZE", this.mVideoSize);
                ((Intent)localObject1).putExtra("file_send_duration", this.mDuration);
                localObject2 = new ArrayList();
                ((ArrayList)localObject2).add(this.mVideoPath);
                PhotoUtils.a(this, (Intent)localObject1, (ArrayList)localObject2, 2, false);
                break;
              case 5: 
                localObject1 = super.getIntent();
                ((Intent)localObject1).putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
                ((Intent)localObject1).putExtra("PhotoConst.VIDEO_SIZE", this.mVideoSize);
                ((Intent)localObject1).putExtra("file_send_duration", this.mDuration);
                localObject2 = new ArrayList();
                ((ArrayList)localObject2).add(this.mVideoPath);
                aqha.a(this, 232, null, getString(2131699957, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.mVideoSize / 1024.0D / 1024.0D) }) }), new aywp(this, (Intent)localObject1, (ArrayList)localObject2), new aywq(this)).show();
                break;
              case 2: 
                aqha.a(this, 232, null, getString(2131699957, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.mVideoSize / 1024.0D / 1024.0D) }) }), new aywr(this), new aywd(this)).show();
                localObject1 = new Intent("key_video_select_apply_click");
                ((Intent)localObject1).putExtra("className", super.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
                sendBroadcast((Intent)localObject1);
                break;
              case 7: 
                if (QLog.isColorLevel()) {
                  QLog.d("ShortVideoPreviewActivity", 2, "ldStart Compress");
                }
                cnx = -1;
                new b(this).execute(new String[] { this.mVideoPath });
              }
              break;
            }
          }
          break;
        }
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("file_send_path", this.mVideoPath);
    localIntent.putExtra("file_send_duration", this.mDuration);
    localIntent.putExtra("file_send_size", this.mVideoSize);
    MediaMetadataRetriever localMediaMetadataRetriever;
    if ((this.dBo) && (this.dBm))
    {
      if (aqhq.fileExistsAndNotEmpty(this.mVideoPath))
      {
        this.cYa = f(ShortVideoUtils.getVideoThumbnail(this, this.mVideoPath));
        localMediaMetadataRetriever = new MediaMetadataRetriever();
      }
    }
    else
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(this.mVideoPath);
        localObject2 = localMediaMetadataRetriever.extractMetadata(18);
        String str = localMediaMetadataRetriever.extractMetadata(19);
        localMediaMetadataRetriever.release();
        localObject1 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label1115:
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreviewActivity", 2, "get height and width error");
          }
          localObject3 = null;
          continue;
          localIntent.putExtra("retCode", 1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "width is" + (String)localObject2 + "\n height is " + (String)localObject1);
      }
      if (this.cYa != null)
      {
        localIntent.putExtra("video_cover", this.cYa);
        localIntent.putExtra("file_width", (String)localObject2);
        localIntent.putExtra("file_height", (String)localObject1);
        localIntent.putExtra("retCode", 0);
        if ((this.dBo) && (this.dBn))
        {
          this.B.removeCallbacks(this.fo);
          if (this.cYa == null) {
            break label1271;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreviewActivity", 2, "输出的裁剪图位置为" + this.cYa);
          }
          localIntent.putExtra("video_cover", this.cYa);
          localIntent.putExtra("retCode", 0);
        }
      }
    }
    for (;;)
    {
      setResult(-1, localIntent);
      finish();
      break;
      Object localObject3;
      ahao.JD(acfp.m(2131714505));
      super.finish();
      break label1115;
      label1271:
      localIntent.putExtra("retCode", 1);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onCompletion");
    }
    if ((this.dBo) && (this.dBn))
    {
      if ((this.mPlayState == 1) || (this.mPlayState == 0))
      {
        this.p.setProgress(0);
        this.OW.setText(ShortVideoUtils.stringForTime(0L));
        play(0);
      }
      return;
    }
    GR(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPreviewActivity", 2, "mMediaPlayer onError what=" + paramInt1 + ",extra=" + paramInt2);
    }
    GR(3);
    reset();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared");
    }
    eTT();
    this.mMediaPlayer.start();
    GR(1);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (((this.mPlayState == 1) || (this.mPlayState == 2)) && (this.mMediaPlayer != null)) {
      this.cnv = this.mMediaPlayer.getCurrentPosition();
    }
    this.cnw = this.mPlayState;
    paramBundle.putInt("state_play_state", this.mPlayState);
    paramBundle.putInt("state_play_position", this.cnv);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onSaveInstanceState: mSavedCurPosition: " + this.cnv + " ,playState = " + bA(this.mPlayState));
    }
  }
  
  public void onStart()
  {
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.onStart();
  }
  
  public void onStop()
  {
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.onStop();
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#pause#");
    }
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()) && (this.mPlayState == 1))
    {
      this.mMediaPlayer.pause();
      GR(2);
    }
  }
  
  public void play(int paramInt)
  {
    if (!aqhq.fileExistsAndNotEmpty(this.mVideoPath))
    {
      QQToast.a(this, 2131720257, 0).show();
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt);
      }
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
      }
      this.mMediaPlayer = new MediaPlayer();
      this.mMediaPlayer.setAudioStreamType(3);
      if ((!this.dBo) || (this.dBm)) {
        this.mMediaPlayer.setDisplay(this.mSurfaceView.getHolder());
      }
      this.mMediaPlayer.setOnCompletionListener(this);
      this.mMediaPlayer.setOnErrorListener(this);
      this.mMediaPlayer.setDataSource(this.mVideoPath);
      this.mMediaPlayer.prepareAsync();
      this.mMediaPlayer.setOnPreparedListener(new aywn(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt, localException);
      }
      reset();
      aqha.a(this, 232, null, getString(2131720284), new aywo(this), null).show();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  void reset()
  {
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.reset();
    }
    GR(0);
  }
  
  public void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#resume#");
    }
    if ((this.mMediaPlayer != null) && (this.mPlayState == 2))
    {
      this.mMediaPlayer.start();
      GR(1);
      if ((this.dBo) && (this.dBn)) {
        this.B.post(this.fo);
      }
    }
  }
  
  public void run()
  {
    this.mBitmap = ShortVideoUtils.getVideoThumbnail(this, this.mVideoPath);
    runOnUiThread(new ShortVideoPreviewActivity.15(this));
  }
  
  @TargetApi(10)
  public String sS(String paramString)
  {
    if (this.ig.getText().toString().endsWith(getResources().getString(2131696009)))
    {
      this.ig.setText(2131696008);
      i = this.mMediaPlayer.getCurrentPosition();
      this.mMediaPlayer.start();
      this.mMediaPlayer.seekTo(i);
      this.B.post(this.fo);
      this.wQ.setImageResource(2130847021);
      GR(1);
      this.OV.setEnabled(false);
      this.OV.setTextColor(-2130706433);
      return null;
    }
    this.mMediaPlayer.pause();
    this.wQ.setImageResource(2130847020);
    this.ig.setText(2131696009);
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime(this.mMediaPlayer.getCurrentPosition() * 1000, 3);
    this.OV.setEnabled(true);
    this.OV.setTextColor(Color.parseColor("#ffffff"));
    int i = localBitmap.getWidth();
    int j = localBitmap.getHeight();
    int k = Math.max(i, j);
    paramString = localBitmap;
    if (k > 512)
    {
      float f = 512.0F / k;
      paramString = Bitmap.createScaledBitmap(localBitmap, Math.round(i * f), Math.round(j * f), true);
    }
    paramString = f(paramString);
    localMediaMetadataRetriever.release();
    return paramString;
  }
  
  public static class a
    implements azck.a
  {
    final String JV;
    final int agS;
    final int agT;
    Throwable e;
    final long mEndTime;
    final long mStartTime;
    
    a(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      this.JV = paramString;
      this.agS = paramInt1;
      this.mStartTime = paramLong1;
      this.mEndTime = paramLong2;
      if (paramInt2 > 0) {}
      for (this.agT = paramInt2;; this.agT = 30)
      {
        this.e = null;
        if (paramString == null) {}
        return;
      }
    }
    
    public azck.b a(int paramInt1, int paramInt2)
    {
      int j = 1280;
      int i = 30;
      azck.b localb = new azck.b();
      Object localObject;
      if (paramInt1 <= paramInt2)
      {
        localObject = new File(this.JV);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        localb.as = ((File)localObject);
        if (paramInt2 < 1280) {
          break label278;
        }
        localObject = "720p";
        paramInt1 = j;
        label70:
        if (paramInt2 >= paramInt1) {
          break label307;
        }
      }
      label278:
      label307:
      for (localb.videoBitRate = ((int)(819200 * 1.0D / paramInt1 * paramInt2));; localb.videoBitRate = 819200)
      {
        localb.scaleRate = (paramInt1 / paramInt2);
        paramInt2 = i;
        if (this.agT <= 30) {
          paramInt2 = this.agT;
        }
        localb.videoFrameRate = paramInt2;
        localb.cHX = rk();
        localb.beginTime = this.mStartTime;
        localb.endTime = this.mEndTime;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localb.cHX + ", scaleRate=" + localb.scaleRate + ", videoBitRate=" + localb.videoBitRate + ", videoFrameRate=" + localb.videoFrameRate + ", beginTime=" + localb.beginTime + ", endTime=" + localb.endTime + ",quality:" + (String)localObject + ",videoLongestEdge=" + paramInt1);
        }
        return localb;
        paramInt2 = paramInt1;
        break;
        if (paramInt2 >= 960)
        {
          localObject = "540p";
          paramInt1 = 960;
          break label70;
        }
        paramInt1 = 640;
        localObject = "480p";
        break label70;
      }
    }
    
    public void ahK() {}
    
    public void f(Throwable paramThrowable)
    {
      QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
      this.e = paramThrowable;
    }
    
    public void onCanceled() {}
    
    public void onProgress(int paramInt) {}
    
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
  
  class b
    extends AsyncTask<String, Void, Integer>
  {
    String Ka;
    Activity mContext;
    String outputPath;
    arhz progressDialog;
    String thumbPath;
    
    public b(Activity paramActivity)
    {
      this.mContext = paramActivity;
      this.progressDialog = new arhz(paramActivity);
    }
    
    /* Error */
    protected Integer doInBackground(String... paramVarArgs)
    {
      // Byte code:
      //   0: aload_1
      //   1: iconst_0
      //   2: aaload
      //   3: astore 13
      //   5: aload 13
      //   7: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   10: ifne +10 -> 20
      //   13: aload_0
      //   14: getfield 27	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:mContext	Landroid/app/Activity;
      //   17: ifnonnull +8 -> 25
      //   20: iconst_m1
      //   21: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   24: areturn
      //   25: aload_0
      //   26: aload 13
      //   28: putfield 53	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:Ka	Ljava/lang/String;
      //   31: new 55	java/io/File
      //   34: dup
      //   35: new 57	java/lang/StringBuilder
      //   38: dup
      //   39: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   42: getstatic 63	aasa:SDCARD_PATH	Ljava/lang/String;
      //   45: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: ldc 69
      //   50: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   53: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   56: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
      //   59: astore_1
      //   60: aload_1
      //   61: invokevirtual 80	java/io/File:exists	()Z
      //   64: ifne +8 -> 72
      //   67: aload_1
      //   68: invokevirtual 83	java/io/File:mkdirs	()Z
      //   71: pop
      //   72: invokestatic 89	java/lang/System:currentTimeMillis	()J
      //   75: lstore 6
      //   77: aload_0
      //   78: getfield 27	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:mContext	Landroid/app/Activity;
      //   81: iconst_0
      //   82: iconst_0
      //   83: invokestatic 94	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:b	(Landroid/content/Context;II)Z
      //   86: istore 12
      //   88: aload 13
      //   90: ldc 96
      //   92: invokevirtual 102	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   95: istore_2
      //   96: iload_2
      //   97: iconst_m1
      //   98: if_icmpne +8 -> 106
      //   101: iconst_m1
      //   102: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   105: areturn
      //   106: iconst_m1
      //   107: istore_3
      //   108: aload_0
      //   109: aload 13
      //   111: aload 13
      //   113: iload_2
      //   114: iconst_1
      //   115: iadd
      //   116: invokevirtual 106	java/lang/String:substring	(I)Ljava/lang/String;
      //   119: invokestatic 112	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:by	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   122: putfield 114	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
      //   125: iload 12
      //   127: ifeq +161 -> 288
      //   130: aload 13
      //   132: invokestatic 118	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Ldov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a;
      //   135: pop
      //   136: getstatic 122	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:cnx	I
      //   139: iconst_m1
      //   140: if_icmpne +255 -> 395
      //   143: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   146: ifeq +11 -> 157
      //   149: ldc 129
      //   151: iconst_2
      //   152: ldc 131
      //   154: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   157: aload_0
      //   158: aload_0
      //   159: getfield 53	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:Ka	Ljava/lang/String;
      //   162: putfield 114	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
      //   165: iconst_0
      //   166: istore_2
      //   167: invokestatic 89	java/lang/System:currentTimeMillis	()J
      //   170: lstore 8
      //   172: new 55	java/io/File
      //   175: dup
      //   176: aload 13
      //   178: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
      //   181: invokevirtual 138	java/io/File:length	()J
      //   184: lstore 10
      //   186: lconst_0
      //   187: lstore 4
      //   189: aload_0
      //   190: getfield 114	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
      //   193: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   196: ifne +19 -> 215
      //   199: new 55	java/io/File
      //   202: dup
      //   203: aload_0
      //   204: getfield 114	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
      //   207: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
      //   210: invokevirtual 138	java/io/File:length	()J
      //   213: lstore 4
      //   215: iload_2
      //   216: istore_3
      //   217: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   220: ifeq +68 -> 288
      //   223: ldc 140
      //   225: iconst_2
      //   226: new 57	java/lang/StringBuilder
      //   229: dup
      //   230: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   233: ldc 142
      //   235: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   238: iload_2
      //   239: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   242: ldc 147
      //   244: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   247: lload 8
      //   249: lload 6
      //   251: lsub
      //   252: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   255: ldc 152
      //   257: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   260: lload 10
      //   262: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   265: ldc 154
      //   267: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: lload 4
      //   272: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   275: ldc 156
      //   277: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   280: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   283: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   286: iload_2
      //   287: istore_3
      //   288: aload_0
      //   289: getfield 27	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:mContext	Landroid/app/Activity;
      //   292: aload 13
      //   294: invokestatic 160	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   297: astore 14
      //   299: aload 14
      //   301: ifnull +89 -> 390
      //   304: new 55	java/io/File
      //   307: dup
      //   308: aload_1
      //   309: new 57	java/lang/StringBuilder
      //   312: dup
      //   313: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   316: lload 6
      //   318: invokestatic 163	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   321: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   324: ldc 165
      //   326: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   329: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   332: invokespecial 168	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   335: astore_1
      //   336: aload_1
      //   337: invokevirtual 171	java/io/File:createNewFile	()Z
      //   340: ifeq +233 -> 573
      //   343: aload_0
      //   344: aload_1
      //   345: invokevirtual 174	java/io/File:getPath	()Ljava/lang/String;
      //   348: putfield 176	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:thumbPath	Ljava/lang/String;
      //   351: new 178	java/io/FileOutputStream
      //   354: dup
      //   355: aload_1
      //   356: invokevirtual 174	java/io/File:getPath	()Ljava/lang/String;
      //   359: invokespecial 179	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   362: astore 13
      //   364: aload 13
      //   366: astore_1
      //   367: aload 14
      //   369: getstatic 185	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   372: bipush 100
      //   374: aload 13
      //   376: invokevirtual 191	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   379: pop
      //   380: aload 13
      //   382: ifnull +8 -> 390
      //   385: aload 13
      //   387: invokevirtual 194	java/io/FileOutputStream:close	()V
      //   390: iload_3
      //   391: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   394: areturn
      //   395: new 196	java/util/HashMap
      //   398: dup
      //   399: invokespecial 197	java/util/HashMap:<init>	()V
      //   402: pop
      //   403: aload 13
      //   405: aload_0
      //   406: getfield 27	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:mContext	Landroid/app/Activity;
      //   409: invokestatic 200	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:a	(Ljava/lang/String;Landroid/content/Context;)Ljava/util/HashMap;
      //   412: astore 14
      //   414: aload 14
      //   416: ldc 202
      //   418: invokevirtual 206	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   421: checkcast 98	java/lang/String
      //   424: invokestatic 209	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   427: istore_2
      //   428: aload_0
      //   429: aload 14
      //   431: ldc 210
      //   433: invokevirtual 206	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   436: checkcast 98	java/lang/String
      //   439: putfield 114	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
      //   442: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   445: ifeq +41 -> 486
      //   448: ldc 129
      //   450: iconst_2
      //   451: new 57	java/lang/StringBuilder
      //   454: dup
      //   455: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   458: ldc 212
      //   460: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   463: aload 13
      //   465: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   468: ldc 214
      //   470: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   473: aload_0
      //   474: getfield 114	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
      //   477: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   480: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   483: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   486: goto -319 -> 167
      //   489: astore 14
      //   491: aconst_null
      //   492: astore 13
      //   494: aload 13
      //   496: astore_1
      //   497: ldc 140
      //   499: iconst_1
      //   500: new 57	java/lang/StringBuilder
      //   503: dup
      //   504: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   507: ldc 216
      //   509: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   512: aload 14
      //   514: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   517: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   520: invokestatic 222	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   523: aload 13
      //   525: ifnull -135 -> 390
      //   528: aload 13
      //   530: invokevirtual 194	java/io/FileOutputStream:close	()V
      //   533: goto -143 -> 390
      //   536: astore_1
      //   537: goto -147 -> 390
      //   540: astore 13
      //   542: aconst_null
      //   543: astore_1
      //   544: aload_1
      //   545: ifnull +7 -> 552
      //   548: aload_1
      //   549: invokevirtual 194	java/io/FileOutputStream:close	()V
      //   552: aload 13
      //   554: athrow
      //   555: astore_1
      //   556: goto -166 -> 390
      //   559: astore_1
      //   560: goto -8 -> 552
      //   563: astore 13
      //   565: goto -21 -> 544
      //   568: astore 14
      //   570: goto -76 -> 494
      //   573: aconst_null
      //   574: astore 13
      //   576: goto -196 -> 380
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	579	0	this	b
      //   0	579	1	paramVarArgs	String[]
      //   95	333	2	i	int
      //   107	284	3	j	int
      //   187	84	4	l1	long
      //   75	242	6	l2	long
      //   170	78	8	l3	long
      //   184	77	10	l4	long
      //   86	40	12	bool	boolean
      //   3	526	13	localObject1	Object
      //   540	13	13	localObject2	Object
      //   563	1	13	localObject3	Object
      //   574	1	13	localObject4	Object
      //   297	133	14	localObject5	Object
      //   489	24	14	localException1	Exception
      //   568	1	14	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   336	364	489	java/lang/Exception
      //   528	533	536	java/lang/Exception
      //   336	364	540	finally
      //   385	390	555	java/lang/Exception
      //   548	552	559	java/lang/Exception
      //   367	380	563	finally
      //   497	523	563	finally
      //   367	380	568	java/lang/Exception
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      int i = 10485760;
      super.onPostExecute(paramInteger);
      if ((this.progressDialog != null) && (this.progressDialog.isShowing())) {
        this.progressDialog.dismiss();
      }
      String str;
      if (TextUtils.isEmpty(this.outputPath))
      {
        str = this.Ka;
        long l = new File(str).length();
        if (this.mContext != null) {
          i = this.mContext.getIntent().getIntExtra("size_after_compress", 10485760);
        }
        if (l <= i) {
          break label144;
        }
        QQToast.a(this.mContext, acfp.m(2131714461), 0).show(ShortVideoPreviewActivity.this.getTitleBarHeight());
        this.mContext.setResult(0);
        this.mContext.finish();
        this.mContext = null;
      }
      label144:
      while ((this.mContext == null) || (paramInteger.intValue() != 0))
      {
        return;
        str = this.outputPath;
        break;
      }
      paramInteger = new Intent();
      paramInteger.putExtra("video_dir", str);
      paramInteger.putExtra("thumb_dir", this.thumbPath);
      this.mContext.setResult(-1, paramInteger);
      this.mContext.finish();
      this.mContext = null;
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      this.progressDialog.setMessage(acfp.m(2131714509));
      this.progressDialog.setCancelable(false);
      this.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */