package com.tencent.mobileqq.avatar.dynamicavatar;

import aaqh;
import aaqi;
import aasx;
import aate;
import aate.a;
import aatf;
import acfp;
import advu;
import advw;
import advy;
import advz;
import adwa;
import adwc;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anih;
import anii;
import anil;
import anil.a;
import anim;
import aniq;
import aniv;
import aniw;
import anot;
import aqiw;
import aqju;
import ausj;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.FlowActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.VersionUtils;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class DynamicAvatarRecordActivity
  extends FlowActivity
  implements aatf, View.OnClickListener
{
  public TextView OU;
  public TextView QO;
  public TextView QP;
  public TextView QQ;
  public TextView QR;
  anil.a jdField_a_of_type_Anil$a = new adwa(this);
  anim jdField_a_of_type_Anim;
  public CameraGLSurfaceView a;
  public aqju ad;
  public CameraCover b;
  ImageViewVideoPlayer b;
  private boolean bRq;
  boolean bRr = true;
  private int baS;
  public boolean bwW;
  boolean bwX = true;
  boolean bxa = false;
  public RMVideoStateMgr c = RMVideoStateMgr.a();
  volatile AtomicBoolean cN = new AtomicBoolean(false);
  volatile AtomicBoolean cO = new AtomicBoolean(false);
  int ciP;
  ausj e;
  ProgressDialog f;
  public Button fN;
  public Button fO;
  public CircleProgress h;
  int mPreviewHeight = -1;
  int mPreviewWidth = -1;
  private BroadcastReceiver mReceiver = new advu(this);
  int mScreenHeight = 0;
  int mScreenWidth = 0;
  public int mSource;
  Handler mUIHandler = new Handler();
  String mVideoPath;
  View.OnTouchListener w = new advz(this);
  public ImageView yn;
  public ImageView yo;
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    anhz.cGj = paramBundle.getBoolean("key_video_hard_encode_enable", false);
    float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
    if (f1 > 0.0F) {
      anhz.dGl = (int)(f1 * 1000.0F);
    }
    if (RMVideoStateMgr.aH(paramBoolean))
    {
      this.bxa = this.c.hA(16);
      return;
    }
    this.c.hA(4);
  }
  
  private boolean afF()
  {
    this.fO.setEnabled(false);
    this.c.stopWatching();
    Ge(104);
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
    if (aaqh.cix == 1)
    {
      aaqh.cix = 2;
      if (aaqh.cix != 1) {
        break label119;
      }
    }
    label119:
    for (String str = acfp.m(2131705335);; str = acfp.m(2131705342))
    {
      this.fO.setContentDescription(acfp.m(2131705345) + str + acfp.m(2131705346));
      CG(false);
      this.fO.setEnabled(true);
      this.c.startWatching();
      return true;
      aaqh.cix = 1;
      break;
    }
  }
  
  public static void c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Object localObject = DynamicAvatarRecordActivity.class;
    if (anii.isFoundProduct(anii.KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL)) {
      localObject = MX3DynamicAvatarRecordActivity.class;
    }
    localObject = new Intent(paramActivity, (Class)localObject);
    ((Intent)localObject).putExtra("param_source", paramInt1);
    paramActivity.startActivityForResult((Intent)localObject, paramInt2);
  }
  
  private void cUI()
  {
    runOnUiThread(new DynamicAvatarRecordActivity.5(this));
  }
  
  private void cUJ()
  {
    cUI();
    rp();
    ThreadManager.postImmediately(new DynamicAvatarRecordActivity.6(this), null, true);
  }
  
  private void cUK()
  {
    runOnUiThread(new DynamicAvatarRecordActivity.8(this));
  }
  
  /* Error */
  private void cUL()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:c	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   4: getfield 281	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 99	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:cN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: iconst_1
    //   16: invokevirtual 284	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   19: pop
    //   20: invokestatic 290	java/lang/System:currentTimeMillis	()J
    //   23: lstore 9
    //   25: invokestatic 71	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   28: astore 12
    //   30: invokestatic 295	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
    //   33: ifeq +483 -> 516
    //   36: ldc_w 297
    //   39: iconst_0
    //   40: invokestatic 303	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   43: new 305	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity$9
    //   46: dup
    //   47: aload_0
    //   48: aload 12
    //   50: invokespecial 308	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity$9:<init>	(Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   53: invokevirtual 313	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   56: invokestatic 295	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
    //   59: ifeq +224 -> 283
    //   62: lconst_0
    //   63: lstore 7
    //   65: aload 12
    //   67: getfield 316	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   70: astore 13
    //   72: aload 13
    //   74: monitorenter
    //   75: aload 12
    //   77: getfield 316	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   80: invokevirtual 319	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   83: istore 11
    //   85: lload 7
    //   87: lstore 5
    //   89: iload 11
    //   91: ifne +106 -> 197
    //   94: lload 7
    //   96: lstore_3
    //   97: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +16 -> 116
    //   103: lload 7
    //   105: lstore_3
    //   106: ldc_w 326
    //   109: iconst_2
    //   110: ldc_w 328
    //   113: invokestatic 332	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: lload 7
    //   118: lstore_3
    //   119: invokestatic 337	android/os/SystemClock:elapsedRealtime	()J
    //   122: lstore 5
    //   124: lload 7
    //   126: lstore_3
    //   127: aload 12
    //   129: getfield 316	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   132: ldc2_w 338
    //   135: invokevirtual 345	java/lang/Object:wait	(J)V
    //   138: lload 7
    //   140: lstore_3
    //   141: invokestatic 337	android/os/SystemClock:elapsedRealtime	()J
    //   144: lload 5
    //   146: lsub
    //   147: lstore 7
    //   149: lload 7
    //   151: lstore 5
    //   153: lload 7
    //   155: lstore_3
    //   156: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +38 -> 197
    //   162: lload 7
    //   164: lstore_3
    //   165: ldc_w 326
    //   168: iconst_2
    //   169: new 192	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 347
    //   179: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload 7
    //   184: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 332	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: lload 7
    //   195: lstore 5
    //   197: aload 13
    //   199: monitorexit
    //   200: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +13 -> 216
    //   206: ldc_w 326
    //   209: iconst_2
    //   210: ldc_w 352
    //   213: invokestatic 332	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: lload 5
    //   218: ldc2_w 353
    //   221: lcmp
    //   222: ifge +61 -> 283
    //   225: bipush 30
    //   227: lload 5
    //   229: l2i
    //   230: isub
    //   231: istore_2
    //   232: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +30 -> 265
    //   238: ldc_w 326
    //   241: iconst_2
    //   242: new 192	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 356
    //   252: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: iload_2
    //   256: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: iload_2
    //   266: istore_1
    //   267: iload_2
    //   268: bipush 10
    //   270: if_icmpge +6 -> 276
    //   273: bipush 10
    //   275: istore_1
    //   276: iload_1
    //   277: i2l
    //   278: lstore_3
    //   279: lload_3
    //   280: invokestatic 367	java/lang/Thread:sleep	(J)V
    //   283: aload 12
    //   285: getfield 281	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   288: ifnull -278 -> 10
    //   291: aload 12
    //   293: getfield 371	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:bL	D
    //   296: d2i
    //   297: putstatic 376	aniq:bQi	I
    //   300: aload 12
    //   302: getfield 281	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   305: invokevirtual 382	com/tencent/mobileqq/shortvideo/mediadevice/PreviewContext:getFrameIndex	()I
    //   308: putstatic 385	aniq:dHk	I
    //   311: getstatic 388	aniq:dHl	I
    //   314: istore_1
    //   315: iconst_m1
    //   316: putstatic 388	aniq:dHl	I
    //   319: new 390	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   322: dup
    //   323: aconst_null
    //   324: aconst_null
    //   325: aload 12
    //   327: getfield 393	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:bdG	Ljava/lang/String;
    //   330: aconst_null
    //   331: aconst_null
    //   332: invokespecial 396	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   335: astore 12
    //   337: aload 12
    //   339: iconst_1
    //   340: invokevirtual 399	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:PW	(Z)V
    //   343: aload 12
    //   345: iconst_0
    //   346: invokevirtual 402	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:CN	(Z)V
    //   349: aload 12
    //   351: iconst_1
    //   352: invokevirtual 405	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:PX	(Z)V
    //   355: aload 12
    //   357: invokevirtual 408	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   360: iload_1
    //   361: putstatic 388	aniq:dHl	I
    //   364: aload_0
    //   365: aload 12
    //   367: getfield 411	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:cdZ	Ljava/lang/String;
    //   370: putfield 413	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:mVideoPath	Ljava/lang/String;
    //   373: aload_0
    //   374: getfield 413	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:mVideoPath	Ljava/lang/String;
    //   377: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   380: ifne +57 -> 437
    //   383: new 421	java/io/File
    //   386: dup
    //   387: aload_0
    //   388: getfield 413	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:mVideoPath	Ljava/lang/String;
    //   391: invokespecial 424	java/io/File:<init>	(Ljava/lang/String;)V
    //   394: astore 12
    //   396: aload 12
    //   398: invokevirtual 427	java/io/File:exists	()Z
    //   401: ifeq +36 -> 437
    //   404: new 192	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   411: aload 12
    //   413: invokevirtual 430	java/io/File:getParent	()Ljava/lang/String;
    //   416: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: getstatic 433	java/io/File:separator	Ljava/lang/String;
    //   422: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 435
    //   428: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 440	aqhq:UD	(Ljava/lang/String;)V
    //   437: aload_0
    //   438: getfield 99	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:cN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   441: iconst_0
    //   442: invokevirtual 284	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   445: pop
    //   446: aload_0
    //   447: getfield 101	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:cO	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   450: invokevirtual 319	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   453: ifeq +11 -> 464
    //   456: aload_0
    //   457: invokevirtual 443	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:dismissProgressDialog	()V
    //   460: aload_0
    //   461: invokespecial 446	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:cUM	()V
    //   464: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq -457 -> 10
    //   470: ldc_w 326
    //   473: iconst_2
    //   474: new 192	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 448
    //   484: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload_0
    //   488: getfield 413	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:mVideoPath	Ljava/lang/String;
    //   491: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 450
    //   497: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokestatic 290	java/lang/System:currentTimeMillis	()J
    //   503: lload 9
    //   505: lsub
    //   506: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   509: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 332	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: return
    //   516: invokestatic 455	aniu:a	()Laniu;
    //   519: invokevirtual 458	aniu:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   522: invokevirtual 463	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   525: pop
    //   526: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq -473 -> 56
    //   532: ldc_w 326
    //   535: iconst_2
    //   536: ldc_w 465
    //   539: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: goto -486 -> 56
    //   545: astore 13
    //   547: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +13 -> 563
    //   553: ldc_w 326
    //   556: iconst_2
    //   557: ldc_w 467
    //   560: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aload 13
    //   565: invokevirtual 470	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   568: goto -512 -> 56
    //   571: astore 14
    //   573: lload_3
    //   574: lstore 5
    //   576: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   579: ifeq -382 -> 197
    //   582: ldc_w 326
    //   585: iconst_2
    //   586: new 192	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   593: ldc_w 472
    //   596: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload 14
    //   601: invokevirtual 475	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   604: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 332	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: lload_3
    //   614: lstore 5
    //   616: goto -419 -> 197
    //   619: astore 12
    //   621: aload 13
    //   623: monitorexit
    //   624: aload 12
    //   626: athrow
    //   627: astore 13
    //   629: goto -346 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	this	DynamicAvatarRecordActivity
    //   266	95	1	i	int
    //   231	40	2	j	int
    //   96	518	3	l1	long
    //   87	528	5	l2	long
    //   63	131	7	l3	long
    //   23	481	9	l4	long
    //   83	7	11	bool	boolean
    //   28	384	12	localObject1	Object
    //   619	6	12	localObject2	Object
    //   70	128	13	localAtomicBoolean	AtomicBoolean
    //   545	77	13	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   627	1	13	localInterruptedException1	java.lang.InterruptedException
    //   571	29	14	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   516	542	545	java/lang/UnsatisfiedLinkError
    //   97	103	571	java/lang/InterruptedException
    //   106	116	571	java/lang/InterruptedException
    //   119	124	571	java/lang/InterruptedException
    //   127	138	571	java/lang/InterruptedException
    //   141	149	571	java/lang/InterruptedException
    //   156	162	571	java/lang/InterruptedException
    //   165	193	571	java/lang/InterruptedException
    //   75	85	619	finally
    //   97	103	619	finally
    //   106	116	619	finally
    //   119	124	619	finally
    //   127	138	619	finally
    //   141	149	619	finally
    //   156	162	619	finally
    //   165	193	619	finally
    //   197	200	619	finally
    //   576	613	619	finally
    //   621	624	619	finally
    //   279	283	627	java/lang/InterruptedException
  }
  
  private void cUM()
  {
    this.cO.set(false);
    Intent localIntent = new Intent(this, SelectCoverActivity.class);
    localIntent.putExtra("param_source", this.mSource);
    localIntent.putExtra("param_from_newer_guide", this.bRq);
    localIntent.putExtra("key_video_file_path", this.mVideoPath);
    localIntent.putExtra("key_video_duration", this.ciP);
    if (((Boolean)this.fN.getTag()).booleanValue())
    {
      str = "1";
      localIntent.putExtra("key_video_has_voice", str);
      if (aaqh.cix != 1) {
        break label130;
      }
    }
    label130:
    for (String str = "0";; str = "1")
    {
      localIntent.putExtra("key_camera_id", str);
      startActivityForResult(localIntent, 1);
      return;
      str = "0";
      break;
    }
  }
  
  private void cjC()
  {
    if (this.baS == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      registerReceiver(this.mReceiver, localIntentFilter);
      this.baS = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void sq(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.f == null)
      {
        this.f = new ReportProgressDialog(this, 2131756467);
        this.f.setCancelable(false);
        this.f.show();
        this.f.setContentView(2131559761);
      }
      ((TextView)this.f.findViewById(2131373180)).setText(paramString);
      if (!this.f.isShowing()) {
        this.f.show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("DynamicAvatarRecordActivity", 2, "showProgressDialog", paramString);
    }
  }
  
  public void CG(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ($(this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    if (VersionUtils.isIceScreamSandwich())
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof aniw)))
      {
        ((CameraTextureView)localObject2).a = ((aniw)localObject1);
        this.c.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, -1);
        this.bwX = false;
        ConfigurationInfo localConfigurationInfo = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
        paramBoolean = VideoEnvironment.isBeautySupported();
        if ((localConfigurationInfo == null) || (localConfigurationInfo.reqGlEsVersion < 131072) || (!paramBoolean)) {
          break label315;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)$(2131367282));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVideoContext(this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
        }
        ((FrameLayout.LayoutParams)localObject1).height = 1;
        ((FrameLayout.LayoutParams)localObject1).width = 1;
      }
    }
    for (;;)
    {
      ((View)localObject2).setId(2131367243);
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
      this.bwW = true;
      return;
      ((CameraTextureView)localObject2).a = new aniw(this.jdField_a_of_type_Anim, this.mScreenWidth, this.mScreenHeight);
      break;
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof aniv))) {}
      for (((CameraPreview)localObject2).a = ((aniv)localObject1);; ((CameraPreview)localObject2).a = new aniv(this.jdField_a_of_type_Anim, this.mScreenWidth, this.mScreenHeight))
      {
        this.c.a(((CameraPreview)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, -1);
        this.bwX = true;
        break;
      }
      label315:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)$(2131367282));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = null;
    }
  }
  
  public void CL(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "deleteLastVideoSegment(), deleteNative = " + paramBoolean);
    }
  }
  
  public void Ge(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "realDeleteVideoSegment(), delReason = " + paramInt);
    }
  }
  
  public void K(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2131561299, paramViewGroup);
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)$(2131367262));
    paramViewGroup = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getLayoutParams();
    paramViewGroup.height = this.mScreenWidth;
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setLayoutParams(paramViewGroup);
    this.fN = ((Button)$(2131382057));
    this.fN.setEnabled(false);
    this.fN.setTag(Boolean.valueOf(true));
    this.fN.setContentDescription(acfp.m(2131705336));
    this.fO = ((Button)$(2131364203));
    this.fO.setEnabled(false);
    ImageView localImageView;
    if (aaqh.cix == 1)
    {
      paramViewGroup = acfp.m(2131705332);
      this.fO.setContentDescription(acfp.m(2131705348) + paramViewGroup + acfp.m(2131705349));
      this.QO = ((TextView)$(2131376976));
      this.QP = ((TextView)$(2131373561));
      this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)$(2131367267));
      this.OU = ((TextView)$(2131365408));
      this.QQ = ((TextView)$(2131365412));
      this.QR = ((TextView)$(2131365409));
      this.yn = ((ImageView)$(2131365410));
      this.yn.setEnabled(false);
      this.yn.setOnTouchListener(this.w);
      this.yo = ((ImageView)$(2131365411));
      this.h = ((CircleProgress)$(2131376964));
      this.h.setBgAndProgressColor(100, getResources().getColor(2131167654), 100, getResources().getColor(2131165409));
      this.h.setStrokeWidth(6.0F);
      this.QR = ((TextView)$(2131365409));
      this.fN.setOnClickListener(this);
      this.fO.setOnClickListener(this);
      this.OU.setOnClickListener(this);
      this.QQ.setOnClickListener(this);
      this.QR.setOnClickListener(this);
      localImageView = new ImageView(this);
      if (this.mScreenWidth <= 0) {
        break label485;
      }
      localImageView.setImageBitmap(adwc.c(this.mScreenWidth, this.mScreenWidth, this.mScreenWidth / 2 - 8));
    }
    for (paramViewGroup = new FrameLayout.LayoutParams(-1, -1);; paramViewGroup = new FrameLayout.LayoutParams(1, 1))
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView(localImageView, -1, paramViewGroup);
      return;
      paramViewGroup = acfp.m(2131705351);
      break;
      label485:
      localImageView.setImageBitmap(adwc.c(5, 5, 2));
    }
  }
  
  int a(int paramInt1, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int k = this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getMeasuredHeight();
    int m = (int)(paramInt2 * aaqh.rw);
    int j;
    int i;
    if (k <= this.mScreenWidth)
    {
      j = (k - (int)(k * 0.83F)) / 2;
      paramInt1 = this.mScreenWidth;
      i = this.mScreenWidth;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = m;
    }
    for (;;)
    {
      if (paramBoolean) {
        i = paramInt1;
      }
      k = paramInt1;
      if (paramInt1 % 2 != 0) {
        k = paramInt1 - 1;
      }
      paramInt1 = i;
      if (i % 2 != 0) {
        paramInt1 = i - 1;
      }
      paramArrayOfInt[2] = k;
      paramArrayOfInt[3] = paramInt1;
      paramArrayOfInt[4] = paramInt2;
      paramArrayOfInt[5] = m;
      return j;
      j = this.mScreenWidth;
      i = this.mScreenWidth * paramInt1 / paramInt2;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = (k * paramInt2 / this.mScreenWidth);
      k = (k - j) / 2;
      paramInt1 = j;
      j = k;
    }
  }
  
  public void as(int paramInt, boolean paramBoolean)
  {
    this.ciP = paramInt;
    RMVideoStateMgr localRMVideoStateMgr = this.c;
    localRMVideoStateMgr.timerCount += 1;
    if (paramBoolean)
    {
      cUI();
      return;
    }
    ThreadManager.getUIHandler().post(new DynamicAvatarRecordActivity.10(this, paramInt));
  }
  
  public void cwA()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "getFirstFrame()");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(0);
    }
  }
  
  public void cwB()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "addOneSegment_RecordState()");
    }
  }
  
  public void cwD()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "notifyAvcodecOK()");
    }
  }
  
  public void cwF()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "onViewDestroy()");
    }
  }
  
  public void cwG()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "enterViewVideoMode()");
    }
  }
  
  public void cwH()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "exitViewVideoMode()");
    }
  }
  
  public void cwI()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "recordVideoFinish()");
    }
    this.c.Xf();
    this.c.stopWatching();
    cUJ();
  }
  
  public void cwJ()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "finishUI()");
    }
  }
  
  public void cwu()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_InitState()");
    }
  }
  
  public void cwv()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_RecordState()");
    }
  }
  
  public void cww()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_IdleState()");
    }
  }
  
  public void cwx()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_previewState()");
    }
    int i = this.ciP;
    int j = this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(aniq.dGY, i, j, this.c.bdG);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
    Object localObject2 = this.c.jdField_a_of_type_Aate.a();
    BitmapFactory.Options localOptions;
    Object localObject1;
    if ((localObject2 != null) && (((aate.a)localObject2).thumbPath != null) && (((aate.a)localObject2).state.get() == 3) && (this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.i == null))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeFile(((aate.a)localObject2).thumbPath, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label147:
      break label147;
    }
    if (localObject1 != null) {
      this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.i = new BitmapDrawable(super.getResources(), localObject1);
    }
    this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
  }
  
  public void cwz()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initRecordEngineOK()");
    }
  }
  
  public void cxk()
  {
    if (this.c != null)
    {
      this.c.CY(false);
      this.c.cyf();
      this.QO.setText("0\"");
      this.QO.setVisibility(4);
    }
  }
  
  protected void dismissProgressDialog()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "dismissProgressDialog");
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
  
  public void gs(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "previewSizeAdjustUI(), width = " + paramInt1 + ", height = " + paramInt2);
    }
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DynamicAvatarRecordActivity", 2, "[previewSizeAdjustUI]rmStateMgr == null");
      }
      return;
    }
    this.mPreviewWidth = paramInt1;
    this.mPreviewHeight = paramInt2;
    int[] arrayOfInt = new int[6];
    aasx localaasx = this.c.b;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
      label105:
      if (localObject != this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView) {
        break label242;
      }
    }
    label242:
    for (boolean bool = true;; bool = false)
    {
      a(paramInt1, paramInt2, arrayOfInt, bool);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)$lp((View)localObject);
      localLayoutParams.width = arrayOfInt[2];
      localLayoutParams.height = arrayOfInt[3];
      ((View)localObject).setLayoutParams(localLayoutParams);
      localaasx.cjG = arrayOfInt[0];
      localaasx.cjH = arrayOfInt[1];
      localaasx.cjI = 480;
      localaasx.cjJ = 480;
      this.c.a(localaasx, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight, localaasx);
      return;
      localObject = $(2131367243);
      break label105;
    }
  }
  
  public void initData(Bundle paramBundle)
  {
    super.initData(paramBundle);
    this.mSource = paramBundle.getInt("param_source", 0);
    this.bRq = paramBundle.getBoolean("param_from_newer_guide", false);
    if (this.mSource == 0) {
      throw new IllegalArgumentException("source must not be null");
    }
    aaqh.cix = 1;
    if (!anih.agb()) {
      aaqh.cix = 2;
    }
    aaqh.rw = 1.0F;
    a(paramBundle, false);
    paramBundle = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.SV658Cfg.name(), null);
    int i = aqiw.getSystemNetwork(this);
    this.c.a((AppInterface)getAppRuntime(), 4, paramBundle, false, 0, i, 8);
    boolean bool = this.c.a(this, aaqi.a(this), this);
    this.c.Db(false);
    if (!bool)
    {
      super.finish();
      return;
    }
    paramBundle = getResources().getDisplayMetrics();
    this.mScreenWidth = paramBundle.widthPixels;
    this.mScreenHeight = paramBundle.heightPixels;
    if (this.mScreenWidth <= 0)
    {
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      this.mScreenWidth = paramBundle.widthPixels;
      this.mScreenHeight = paramBundle.heightPixels;
    }
    this.jdField_a_of_type_Anim = new anim(this, this.mUIHandler);
    this.c.a(this.jdField_a_of_type_Anim);
    this.jdField_a_of_type_Anim.a(new anil(this.mUIHandler, this.jdField_a_of_type_Anil$a));
  }
  
  public void k(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "errorOcured(), errCode = " + paramInt + ", errMsg = " + paramString + ", isReport = " + paramBoolean);
    }
    runOnUiThread(new DynamicAvatarRecordActivity.11(this, paramString, paramInt));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      if (paramInt1 == 1)
      {
        if (this.mSource != 1) {
          break label87;
        }
        if (!this.bRq) {
          break label79;
        }
        setResult(-1, paramIntent);
        finish();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAvatarRecordActivity", 2, "onActivityResult，requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
      }
      return;
      label79:
      setResult(-1);
      break;
      label87:
      if ((this.mSource == 2) && (paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getStringExtra("key_photo_file_path"))))
      {
        setResult(-1, paramIntent);
        finish();
        continue;
        if (paramInt2 == 0) {
          this.c.CY(false);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.c.bL == 0.0D)
    {
      finish();
      return;
    }
    if (this.e == null) {
      this.e = ausj.a(this, false);
    }
    this.e.setMainTitle(acfp.m(2131705350));
    this.e.addButton(acfp.m(2131705343), 3);
    this.e.addCancelButton(acfp.m(2131705337));
    this.e.a(new advy(this));
    this.e.show();
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int n = 1;
    int i = 1;
    if (paramView == this.fN) {
      if (((Boolean)this.fN.getTag()).booleanValue())
      {
        this.c.Da(false);
        this.fN.setTag(Boolean.valueOf(false));
        this.fN.setBackgroundResource(2130845974);
        this.fN.setContentDescription(acfp.m(2131705339));
        if (this.mSource == 1) {
          i = 0;
        }
        anot.a(null, "dc00898", "", "", "0X8007104", "0X8007104", i, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.c.Da(true);
      this.fN.setTag(Boolean.valueOf(true));
      this.fN.setBackgroundResource(2130845977);
      this.fN.setContentDescription(acfp.m(2131705344));
      break;
      if (paramView == this.fO)
      {
        afF();
        i = j;
        if (this.mSource == 1) {
          i = 0;
        }
        anot.a(null, "dc00898", "", "", "0X8007105", "0X8007105", i, 0, "", "", "", "");
      }
      else
      {
        if (paramView == this.QR)
        {
          this.cO.set(true);
          if (this.cN.get()) {
            sq(acfp.m(2131705334));
          }
          for (;;)
          {
            i = k;
            if (this.mSource == 1) {
              i = 0;
            }
            anot.a(null, "dc00898", "", "", "0X8007109", "0X8007109", i, 0, "", "", "", "");
            break;
            if ((!TextUtils.isEmpty(this.mVideoPath)) && (new File(this.mVideoPath).exists()))
            {
              cUM();
            }
            else
            {
              this.cO.set(false);
              QQToast.a(this, acfp.m(2131705333), 0).show();
            }
          }
        }
        if (paramView == this.OU)
        {
          i = m;
          if (this.mSource == 1) {
            i = 0;
          }
          anot.a(null, "dc00898", "", "", "0X8007107", "0X8007107", i, 0, "", "", "", "");
          finish();
        }
        else if (paramView == this.QQ)
        {
          EncodeThread.cancelCurrentEncoder();
          this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.bsT();
          this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
          CG(true);
          this.c.CY(false);
          this.c.cyf();
          cUK();
          this.mVideoPath = null;
          i = n;
          if (this.mSource == 1) {
            i = 0;
          }
          anot.a(null, "dc00898", "", "", "0X8007108", "0X8007108", i, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
      localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
      localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
      localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
      localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
      localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
      localStringBuilder.append("ID=").append(Build.ID).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("DynamicAvatarRecordActivity", 2, localStringBuilder.toString());
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    if (("Meizu".equals(Build.MANUFACTURER)) && ("M032".equals(Build.MODEL))) {
      this.bRr = false;
    }
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, acfp.m(2131705340), 0).show();
      finish();
      return;
    }
    if (AudioHelper.aCm())
    {
      QQToast.a(this, acfp.m(2131705338), 0).show();
      finish();
      return;
    }
    PerfTracer.traceEnd("Video_component_onCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.c.onDestroy();
    if (this.ad != null)
    {
      this.ad.dismiss();
      this.ad = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.c.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onPause();
    }
    View localView = $(this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
    if (localView != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.bwW) {
      this.c.onResume();
    }
    if (($(this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243) == null) && (this.c.aL.get() != 4)) {
      Looper.myQueue().addIdleHandler(new advw(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    cjC();
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
        this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.bsT();
      }
      this.c.cyf();
      if (this.baS == 1)
      {
        unregisterReceiver(this.mReceiver);
        this.baS = 0;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("DynamicAvatarRecordActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
    }
  }
  
  public void rp()
  {
    int i = this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.em(this.c.bdG);
    boolean bool = this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(this.c);
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "playVideo getVFileAndAFile=" + this.c.bdG + ", errcode=" + i + ", hasFrame=" + bool);
    }
    if ((i != 0) || (!bool))
    {
      this.c.l(0, acfp.m(2131705341), false);
      cxk();
    }
    do
    {
      do
      {
        return;
        if (!this.c.Xb()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("DynamicAvatarRecordActivity", 2, "playVideo isCurrentPreviewState= true......");
      return;
      this.jdField_b_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.cIc = true;
      View localView = $(this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
      if (localView != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
      }
      this.c.tl(4);
    } while (!QLog.isColorLevel());
    QLog.i("DynamicAvatarRecordActivity", 2, "replay totaltime = " + (int)this.c.bL);
  }
  
  public int yQ()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "getCurrentBlockTimeLength()");
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity
 * JD-Core Version:    0.7.0.1
 */