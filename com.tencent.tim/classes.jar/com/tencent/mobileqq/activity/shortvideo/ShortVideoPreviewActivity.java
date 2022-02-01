package com.tencent.mobileqq.activity.shortvideo;

import abab;
import abac;
import abad;
import abae;
import abaf;
import abag;
import abah;
import abai;
import abaj;
import abak;
import abal;
import abam;
import aban;
import abao;
import abap;
import abaq;
import abar;
import abas;
import abat;
import acfp;
import agmx;
import ahal;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import anfr;
import anig;
import anli;
import anli.a;
import anli.b;
import anot;
import aqft;
import aqha;
import aqhq;
import aqiw;
import aqju;
import aqup;
import aqup.a;
import aqup.b;
import aqup.c;
import aquq;
import arhz;
import armm;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ShortVideoPreviewActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  public static int cnx;
  public final MqqHandler B = new abal(this);
  TextView OU;
  public TextView OV;
  public TextView OW;
  public TextView OX;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new abao(this);
  private aqup.a jdField_a_of_type_Aqup$a = new abar(this);
  private aqup.b jdField_a_of_type_Aqup$b = new abas(this);
  private aqup.c jdField_a_of_type_Aqup$c = new abaq(this);
  public aqup a;
  boolean bBC;
  boolean bBD;
  boolean bBE = false;
  public String beK;
  int cnq;
  int cnr;
  public int cns;
  public int cnu;
  public int cnv;
  public int cnw;
  public int cny;
  public int duration = -1;
  public Runnable fo = new ShortVideoPreviewActivity.21(this);
  LinearLayout id;
  Bitmap mBitmap;
  public ImageView mCover;
  public long mDuration;
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new abam(this);
  BroadcastReceiver mScreenReceiver = new abab(this);
  public SurfaceView mSurfaceView;
  String mUin;
  int mUinType;
  public String mVideoPath;
  public long mVideoSize;
  public SeekBar p;
  ArrayList<String> sy;
  public ImageView wP;
  public ImageView wQ;
  
  public ShortVideoPreviewActivity()
  {
    this.jdField_a_of_type_Aqup = new aquq();
  }
  
  public static HashMap<String, String> a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str1 = ShortVideoUtils.by(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    Object localObject1 = ShortVideoTrimmer.a(paramString);
    int i;
    boolean bool;
    int j;
    if ((localObject1 != null) && (((ShortVideoTrimmer.a)localObject1).cHR)) {
      if (Build.VERSION.SDK_INT >= 18)
      {
        Object localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
        String str2 = ((MediaMetadataRetriever)localObject2).extractMetadata(9);
        ((MediaMetadataRetriever)localObject2).release();
        long l = Long.parseLong(str2);
        i = anig.az(paramContext);
        if (((i & 0x1) > 0) && ((i & 0x2) > 0))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: isHWCodecSupported = " + bool);
          }
          if (!bool) {
            break label342;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
          }
          localObject2 = new File(paramString);
          localObject1 = new a(str1, (int)(((ShortVideoTrimmer.a)localObject1).alX * 1024L), (int)((ShortVideoTrimmer.a)localObject1).alW, 0L, l);
          if ((!new anli().a((File)localObject2, (anli.a)localObject1, true)) || (((a)localObject1).e != null)) {
            break label327;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
          }
          j = 0;
          label243:
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
      label327:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodecr");
      }
      label342:
      j = -1;
      break label243;
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
    aqha.a(paramContext, 232, null, paramContext.getString(paramInt), new abaj(), null).show();
  }
  
  private void cAI()
  {
    this.mVideoSize = new File(this.mVideoPath).length();
    if ((aqiw.isNetworkAvailable(this)) && (!aqiw.isWifiConnected(this)) && (this.mVideoSize > agmx.fJ()))
    {
      ahal.a(this, 2131693826, 2131693832, new abai(this));
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
  
  /* Error */
  public static String f(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 4
    //   11: new 224	java/io/File
    //   14: dup
    //   15: new 202	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   22: getstatic 437	acbn:SDCARD_PATH	Ljava/lang/String;
    //   25: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 439
    //   31: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 444	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokespecial 226	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 5
    //   45: aload 5
    //   47: invokevirtual 447	java/io/File:exists	()Z
    //   50: ifne +9 -> 59
    //   53: aload 5
    //   55: invokevirtual 450	java/io/File:mkdirs	()Z
    //   58: pop
    //   59: invokestatic 455	java/lang/System:currentTimeMillis	()J
    //   62: lstore_1
    //   63: aload_0
    //   64: ifnull +93 -> 157
    //   67: new 224	java/io/File
    //   70: dup
    //   71: aload 5
    //   73: new 202	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   80: lload_1
    //   81: invokestatic 458	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   84: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 460
    //   90: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 463	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   99: astore 5
    //   101: aload 5
    //   103: invokevirtual 466	java/io/File:createNewFile	()Z
    //   106: ifeq +206 -> 312
    //   109: aload 5
    //   111: invokevirtual 469	java/io/File:getPath	()Ljava/lang/String;
    //   114: astore_3
    //   115: new 471	java/io/FileOutputStream
    //   118: dup
    //   119: aload 5
    //   121: invokevirtual 469	java/io/File:getPath	()Ljava/lang/String;
    //   124: invokespecial 472	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   127: astore 4
    //   129: aload_0
    //   130: getstatic 478	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   133: bipush 100
    //   135: aload 4
    //   137: invokevirtual 484	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   140: pop
    //   141: aload_3
    //   142: astore_0
    //   143: aload_0
    //   144: astore_3
    //   145: aload 4
    //   147: ifnull +10 -> 157
    //   150: aload 4
    //   152: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   155: aload_0
    //   156: astore_3
    //   157: aload_3
    //   158: areturn
    //   159: astore 5
    //   161: aconst_null
    //   162: astore 4
    //   164: aload 6
    //   166: astore_0
    //   167: aload 4
    //   169: astore_3
    //   170: aload 5
    //   172: invokevirtual 490	java/lang/OutOfMemoryError:printStackTrace	()V
    //   175: aload_0
    //   176: astore_3
    //   177: aload 4
    //   179: ifnull -22 -> 157
    //   182: aload 4
    //   184: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   187: aload_0
    //   188: areturn
    //   189: astore_3
    //   190: aload_0
    //   191: areturn
    //   192: astore 5
    //   194: aconst_null
    //   195: astore 4
    //   197: aload 7
    //   199: astore_0
    //   200: aload 4
    //   202: astore_3
    //   203: ldc 200
    //   205: iconst_1
    //   206: new 202	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 492
    //   216: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 5
    //   221: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 498	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload_0
    //   231: astore_3
    //   232: aload 4
    //   234: ifnull -77 -> 157
    //   237: aload 4
    //   239: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   242: aload_0
    //   243: areturn
    //   244: astore_3
    //   245: aload_0
    //   246: areturn
    //   247: astore_0
    //   248: aconst_null
    //   249: astore_3
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   258: aload_0
    //   259: athrow
    //   260: astore_3
    //   261: aload_0
    //   262: areturn
    //   263: astore_3
    //   264: goto -6 -> 258
    //   267: astore_0
    //   268: aload 4
    //   270: astore_3
    //   271: goto -21 -> 250
    //   274: astore_0
    //   275: goto -25 -> 250
    //   278: astore 5
    //   280: aload_3
    //   281: astore_0
    //   282: aconst_null
    //   283: astore 4
    //   285: goto -85 -> 200
    //   288: astore 5
    //   290: aload_3
    //   291: astore_0
    //   292: goto -92 -> 200
    //   295: astore 5
    //   297: aload_3
    //   298: astore_0
    //   299: aconst_null
    //   300: astore 4
    //   302: goto -135 -> 167
    //   305: astore 5
    //   307: aload_3
    //   308: astore_0
    //   309: goto -142 -> 167
    //   312: aconst_null
    //   313: astore_3
    //   314: aload 4
    //   316: astore_0
    //   317: aload_3
    //   318: astore 4
    //   320: goto -177 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramBitmap	Bitmap
    //   62	19	1	l	long
    //   1	176	3	localObject1	Object
    //   189	1	3	localException1	Exception
    //   202	30	3	localObject2	Object
    //   244	1	3	localException2	Exception
    //   249	6	3	localObject3	Object
    //   260	1	3	localException3	Exception
    //   263	1	3	localException4	Exception
    //   270	48	3	localObject4	Object
    //   9	310	4	localObject5	Object
    //   43	77	5	localFile	File
    //   159	12	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   192	28	5	localException5	Exception
    //   278	1	5	localException6	Exception
    //   288	1	5	localException7	Exception
    //   295	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   305	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   3	162	6	localObject6	Object
    //   6	192	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   101	115	159	java/lang/OutOfMemoryError
    //   182	187	189	java/lang/Exception
    //   101	115	192	java/lang/Exception
    //   237	242	244	java/lang/Exception
    //   101	115	247	finally
    //   115	129	247	finally
    //   150	155	260	java/lang/Exception
    //   254	258	263	java/lang/Exception
    //   129	141	267	finally
    //   170	175	274	finally
    //   203	230	274	finally
    //   115	129	278	java/lang/Exception
    //   129	141	288	java/lang/Exception
    //   115	129	295	java/lang/OutOfMemoryError
    //   129	141	305	java/lang/OutOfMemoryError
  }
  
  void azR()
  {
    if (this.jdField_a_of_type_Aqup != null) {
      this.jdField_a_of_type_Aqup.release();
    }
  }
  
  public String bA(int paramInt)
  {
    return aquq.gn(paramInt);
  }
  
  void cAG()
  {
    if (this.OV != null) {
      switch (this.cny)
      {
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
      StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131714520));
      if ((this.bBD) && (this.sy != null) && (this.sy.size() > 0)) {
        localStringBuilder.append("(").append(this.sy.size()).append(")");
      }
      this.OV.setText(localStringBuilder);
      continue;
      this.OV.setText(2131721079);
      continue;
      this.OV.setText(2131699492);
    }
  }
  
  void cAH()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label256;
      }
      i = 1;
      label38:
      this.mVideoSize = new File(this.mVideoPath).length();
      if (i == 0) {
        break label279;
      }
      if (aqft.hE() <= 512000L) {
        break label271;
      }
      if ((anfr.akV == 0L) || (System.currentTimeMillis() - anfr.akV >= 300000L)) {
        break label261;
      }
    }
    label256:
    label261:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + anfr.akV);
      }
      if ((!aqiw.isMobileNetWork(this)) || (bool) || (this.mVideoSize < 1048576L)) {
        break label266;
      }
      localObject = ShortVideoUtils.g(this, this.mVideoSize);
      localObject = String.format(getResources().getString(2131720250), new Object[] { localObject });
      ShortVideoPreviewActivity.13 local13 = new ShortVideoPreviewActivity.13(this);
      if (armm.a(this, 4, new abaf(this, local13))) {
        aqha.a(this, 232, null, (String)localObject, new abag(this, local13), new abah(this)).show();
      }
      return;
      i = 0;
      break;
      i = 0;
      break label38;
    }
    label266:
    cAJ();
    return;
    label271:
    ag(this, 2131720275);
    return;
    label279:
    QQToast.a(this, 1, 2131719242, 0).show(getTitleBarHeight());
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
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
    this.mSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    this.mSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new abak(this));
    this.mCover = ((ImageView)findViewById(2131365477));
    this.OU = ((TextView)findViewById(2131364222));
    this.OU.setOnClickListener(this);
    this.OV = ((TextView)findViewById(2131377981));
    this.OV.setOnClickListener(this);
    this.wP = ((ImageView)findViewById(2131372728));
    this.wP.setOnClickListener(this);
    this.id = ((LinearLayout)findViewById(2131372455));
    this.OW = ((TextView)findViewById(2131373667));
    this.OX = ((TextView)findViewById(2131380109));
    this.wQ = ((ImageView)findViewById(2131372729));
    this.wQ.setImageResource(2130847021);
    this.wQ.setOnClickListener(this);
    this.p = ((SeekBar)findViewById(2131377915));
    this.p.setVisibility(0);
    this.p.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mCover.getViewTreeObserver().addOnGlobalLayoutListener(new aban(this));
    cAG();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    registerReceiver(this.mScreenReceiver, localIntentFilter);
    if (this.cny == 10)
    {
      if (paramBundle != null) {
        break label427;
      }
      play(0);
    }
    label427:
    while (this.cnw != 1) {
      return true;
    }
    play(this.cnv);
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
  
  public int getPlayState()
  {
    return this.jdField_a_of_type_Aqup.getPlayState();
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
      if ((TextUtils.isEmpty(this.mVideoPath)) || ((this.cny != 2) && (this.cny != 6) && (this.cny != 10) && (!bool3) && (TextUtils.isEmpty(this.mUin))) || (!aqhq.fileExistsAndNotEmpty(this.mVideoPath)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPreviewActivity", 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
        }
        QQToast.a(this, 2131720257, 0).show();
        super.finish();
      }
      return;
      if ((paramIntent.contains("QZonePublishMoodTabActivity")) || (paramIntent.contains("QZonePublishMoodRealActivity"))) {
        this.cny = 1;
      } else if (paramIntent.contains("QZoneUploadPhotoRealActivity")) {
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
      } else if (paramIntent.contains("ReadInJoyDeliverVideoActivity")) {
        this.cny = 10;
      } else {
        this.cny = 0;
      }
    }
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.finish();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + bA(getPlayState()));
      }
      if ((this.cnw == 2) && (this.cnv > 0))
      {
        play(this.cnv);
        this.cnw = 0;
        this.cnv = 0;
      }
      else
      {
        switch (getPlayState())
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
            QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + bA(getPlayState()));
          }
          if ((this.cnw == 2) && (this.cnv > 0))
          {
            play(this.cnv);
            this.cnw = 0;
            this.cnv = 0;
          }
          else
          {
            switch (getPlayState())
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
              Intent localIntent;
              ArrayList localArrayList;
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
                localIntent = super.getIntent();
                localIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
                localIntent.putExtra("PhotoConst.VIDEO_SIZE", this.mVideoSize);
                localIntent.putExtra("file_send_duration", this.mDuration);
                localArrayList = new ArrayList();
                localArrayList.add(this.mVideoPath);
                PhotoUtils.a(this, localIntent, localArrayList, 2, false);
                break;
              case 5: 
                localIntent = super.getIntent();
                localIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
                localIntent.putExtra("PhotoConst.VIDEO_SIZE", this.mVideoSize);
                localIntent.putExtra("file_send_duration", this.mDuration);
                localArrayList = new ArrayList();
                localArrayList.add(this.mVideoPath);
                aqha.a(this, 232, null, getString(2131699957, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.mVideoSize / 1024.0D / 1024.0D) }) }), new abat(this, localIntent, localArrayList), new abac(this)).show();
                break;
              case 2: 
                aqha.a(this, 232, null, getString(2131699957, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.mVideoSize / 1024.0D / 1024.0D) }) }), new abad(this), new abae(this)).show();
                localIntent = new Intent("key_video_select_apply_click");
                localIntent.putExtra("className", super.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
                sendBroadcast(localIntent);
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
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((getPlayState() == 1) || (getPlayState() == 2)) {
      this.cnv = this.jdField_a_of_type_Aqup.getCurrentPosition();
    }
    this.cnw = getPlayState();
    paramBundle.putInt("state_play_state", getPlayState());
    paramBundle.putInt("state_play_position", this.cnv);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onSaveInstanceState: mSavedCurPosition: " + this.cnv + " ,playState = " + bA(getPlayState()));
    }
  }
  
  public void onStart()
  {
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
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    this.jdField_a_of_type_Aqup.pause();
  }
  
  public void play(int paramInt)
  {
    if (!aqhq.fileExistsAndNotEmpty(this.mVideoPath)) {
      QQToast.a(this, 2131720257, 0).show();
    }
    do
    {
      return;
      this.jdField_a_of_type_Aqup.a(this.jdField_a_of_type_Aqup$a);
      this.jdField_a_of_type_Aqup.a(this.jdField_a_of_type_Aqup$c);
      this.jdField_a_of_type_Aqup.a(this.jdField_a_of_type_Aqup$b);
      if (!this.jdField_a_of_type_Aqup.play(this.mVideoPath, paramInt)) {
        break;
      }
      if (VersionUtils.isrFroyo()) {
        ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    } while (this.cny == 10);
    try
    {
      this.jdField_a_of_type_Aqup.setDisplay(this.mSurfaceView.getHolder());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ShortVideoPreviewActivity", 1, "play exception:", localException);
      return;
    }
    aqha.a(this, 232, null, getString(2131720284), new abap(this), null).show();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#resume#");
    }
    this.jdField_a_of_type_Aqup.resume();
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  public void run()
  {
    this.mBitmap = ShortVideoUtils.getVideoThumbnail(this, this.mVideoPath);
    runOnUiThread(new ShortVideoPreviewActivity.19(this));
  }
  
  public static class a
    implements anli.a
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
    
    public anli.b a(int paramInt1, int paramInt2)
    {
      int j = 1280;
      int i = 30;
      anli.b localb = new anli.b();
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
      //   14: getfield 27	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:mContext	Landroid/app/Activity;
      //   17: ifnonnull +8 -> 25
      //   20: iconst_m1
      //   21: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   24: areturn
      //   25: aload_0
      //   26: aload 13
      //   28: putfield 53	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:Ka	Ljava/lang/String;
      //   31: new 55	java/io/File
      //   34: dup
      //   35: new 57	java/lang/StringBuilder
      //   38: dup
      //   39: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   42: getstatic 63	acbn:SDCARD_PATH	Ljava/lang/String;
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
      //   78: getfield 27	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:mContext	Landroid/app/Activity;
      //   81: iconst_0
      //   82: iconst_0
      //   83: invokestatic 94	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:b	(Landroid/content/Context;II)Z
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
      //   119: invokestatic 112	com/tencent/mobileqq/shortvideo/ShortVideoUtils:by	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   122: putfield 114	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
      //   125: iload 12
      //   127: ifeq +161 -> 288
      //   130: aload 13
      //   132: invokestatic 118	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a;
      //   135: pop
      //   136: getstatic 122	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:cnx	I
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
      //   159: getfield 53	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:Ka	Ljava/lang/String;
      //   162: putfield 114	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
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
      //   190: getfield 114	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
      //   193: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   196: ifne +19 -> 215
      //   199: new 55	java/io/File
      //   202: dup
      //   203: aload_0
      //   204: getfield 114	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
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
      //   289: getfield 27	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:mContext	Landroid/app/Activity;
      //   292: aload 13
      //   294: invokestatic 160	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
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
      //   348: putfield 176	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:thumbPath	Ljava/lang/String;
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
      //   406: getfield 27	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:mContext	Landroid/app/Activity;
      //   409: invokestatic 200	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:a	(Ljava/lang/String;Landroid/content/Context;)Ljava/util/HashMap;
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
      //   439: putfield 114	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
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
      //   474: getfield 114	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$b:outputPath	Ljava/lang/String;
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
        QQToast.a(this.mContext, acfp.m(2131714521), 0).show(ShortVideoPreviewActivity.this.getTitleBarHeight());
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
      this.progressDialog.setMessage(acfp.m(2131714492));
      this.progressDialog.setCancelable(false);
      this.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */