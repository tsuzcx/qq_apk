package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import qlf;
import qlg;
import qlh;
import qli;
import qlj;
import qll;
import qmc;
import qmc.a;
import qmc.b;
import qmc.c;
import qmc.d;
import qmc.e;
import qmc.f;
import qmc.h;
import qmc.i;
import qmd;

@TargetApi(14)
public class TextureVideoView
  extends TextureView
  implements TextureView.SurfaceTextureListener, MediaController.MediaPlayerControl
{
  public String TAG = "Q.qqstory.player.TextureVideoView";
  public MediaController a;
  private qmc.a jdField_a_of_type_Qmc$a = new qll(this);
  public qmc.b a;
  public qmc.c a;
  public qmc.d a;
  public qmc.e a;
  protected qmc.f a;
  qmc.h jdField_a_of_type_Qmc$h = new qlf(this);
  protected qmc.i a;
  public qmc a;
  public boolean aDX;
  protected boolean aDY;
  private qmc.b jdField_b_of_type_Qmc$b = new qlh(this);
  private qmc.c jdField_b_of_type_Qmc$c = new qlj(this);
  private qmc.d jdField_b_of_type_Qmc$d = new qli(this);
  qmc.e jdField_b_of_type_Qmc$e = new qlg(this);
  public boolean ii;
  public boolean ij;
  public boolean ik;
  public int mCurrentState = 0;
  protected Map<String, String> mHeaders;
  protected boolean mIsLooping;
  protected Surface mSurface;
  public int mTargetState = 0;
  protected Uri mUri;
  public int mVideoHeight;
  public int mVideoWidth;
  protected int wc;
  public int wd;
  public int we;
  
  public TextureVideoView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initVideoView();
  }
  
  private Activity getActivity()
  {
    try
    {
      for (Context localContext = getContext(); (localContext instanceof ContextWrapper); localContext = ((ContextWrapper)localContext).getBaseContext()) {
        if ((localContext instanceof Activity)) {
          return (Activity)localContext;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void initVideoView()
  {
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    super.setSurfaceTextureListener(this);
    super.setFocusable(true);
    super.setFocusableInTouchMode(true);
    super.requestFocus();
    this.mCurrentState = 0;
    this.mTargetState = 0;
  }
  
  private boolean isInPlaybackState()
  {
    return (this.jdField_a_of_type_Qmc != null) && (this.mCurrentState != -1) && (this.mCurrentState != 0) && (this.mCurrentState != 1);
  }
  
  private void pc()
  {
    if (!this.aDX) {}
    for (boolean bool = true;; bool = false)
    {
      sI(bool);
      return;
    }
  }
  
  private void pd()
  {
    if ((this.jdField_a_of_type_Qmc != null) && (this.jdField_a_of_type_AndroidWidgetMediaController != null))
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.setMediaPlayer(this);
      if (!(getParent() instanceof View)) {
        break label60;
      }
    }
    label60:
    for (Object localObject = (View)getParent();; localObject = this)
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.setAnchorView((View)localObject);
      this.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(isInPlaybackState());
      return;
    }
  }
  
  private void pe()
  {
    if (this.jdField_a_of_type_AndroidWidgetMediaController.isShowing())
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetMediaController.show();
  }
  
  private void release(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qmc != null) {
      this.jdField_a_of_type_Qmc.stop();
    }
    try
    {
      this.jdField_a_of_type_Qmc.reset();
      this.jdField_a_of_type_Qmc.release();
      this.jdField_a_of_type_Qmc = null;
      this.mCurrentState = 0;
      if (paramBoolean) {
        this.mTargetState = 0;
      }
      ((AudioManager)super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      for (;;)
      {
        IllegalStateException localIllegalStateException2 = new IllegalStateException("CatchedException, caused by: ", localIllegalStateException1);
        QLog.e(this.TAG, 1, "mMediaPlayer.release() throw a exception!!", localIllegalStateException2);
      }
    }
  }
  
  /* Error */
  private void sI(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 232	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mUri	Landroid/net/Uri;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 234	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mSurface	Landroid/view/Surface;
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: iconst_0
    //   17: invokespecial 236	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:release	(Z)V
    //   20: iload_1
    //   21: ifeq +25 -> 46
    //   24: aload_0
    //   25: invokespecial 196	android/view/TextureView:getContext	()Landroid/content/Context;
    //   28: invokevirtual 201	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   31: ldc 203
    //   33: invokevirtual 207	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 209	android/media/AudioManager
    //   39: aconst_null
    //   40: iconst_3
    //   41: iconst_1
    //   42: invokevirtual 240	android/media/AudioManager:requestAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
    //   45: pop
    //   46: aload_0
    //   47: aload_0
    //   48: invokevirtual 243	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:a	()Lqmc;
    //   51: putfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   54: aload_0
    //   55: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   58: aload_0
    //   59: getfield 245	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mIsLooping	Z
    //   62: invokeinterface 248 2 0
    //   67: aload_0
    //   68: getfield 250	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:wc	I
    //   71: ifeq +302 -> 373
    //   74: aload_0
    //   75: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   78: aload_0
    //   79: getfield 250	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:wc	I
    //   82: invokeinterface 254 2 0
    //   87: aload_0
    //   88: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   91: aload_0
    //   92: getfield 75	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Qmc$e	Lqmc$e;
    //   95: invokeinterface 258 2 0
    //   100: aload_0
    //   101: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   104: aload_0
    //   105: getfield 70	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc$h	Lqmc$h;
    //   108: invokeinterface 261 2 0
    //   113: aload_0
    //   114: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   117: aload_0
    //   118: getfield 80	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Qmc$b	Lqmc$b;
    //   121: invokeinterface 265 2 0
    //   126: aload_0
    //   127: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   130: aload_0
    //   131: getfield 90	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Qmc$c	Lqmc$c;
    //   134: invokeinterface 269 2 0
    //   139: aload_0
    //   140: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   143: aload_0
    //   144: getfield 85	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Qmc$d	Lqmc$d;
    //   147: invokeinterface 273 2 0
    //   152: aload_0
    //   153: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   156: aload_0
    //   157: getfield 95	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc$a	Lqmc$a;
    //   160: invokeinterface 276 2 0
    //   165: aload_0
    //   166: getfield 278	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc$f	Lqmc$f;
    //   169: ifnull +16 -> 185
    //   172: aload_0
    //   173: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   176: aload_0
    //   177: getfield 278	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc$f	Lqmc$f;
    //   180: invokeinterface 282 2 0
    //   185: aload_0
    //   186: iconst_0
    //   187: putfield 284	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:wd	I
    //   190: aload_0
    //   191: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   194: aload_0
    //   195: invokevirtual 110	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:getContext	()Landroid/content/Context;
    //   198: invokevirtual 201	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   201: aload_0
    //   202: getfield 232	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mUri	Landroid/net/Uri;
    //   205: aload_0
    //   206: getfield 286	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mHeaders	Ljava/util/Map;
    //   209: invokeinterface 290 4 0
    //   214: aload_0
    //   215: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   218: aload_0
    //   219: getfield 234	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mSurface	Landroid/view/Surface;
    //   222: invokeinterface 294 2 0
    //   227: aload_0
    //   228: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   231: iconst_3
    //   232: invokeinterface 297 2 0
    //   237: aload_0
    //   238: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   241: iconst_1
    //   242: invokeinterface 300 2 0
    //   247: aload_0
    //   248: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   251: invokeinterface 303 1 0
    //   256: aload_0
    //   257: iconst_1
    //   258: putfield 61	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mCurrentState	I
    //   261: aload_0
    //   262: invokespecial 305	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:pd	()V
    //   265: return
    //   266: astore_2
    //   267: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +35 -> 305
    //   273: aload_0
    //   274: getfield 59	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:TAG	Ljava/lang/String;
    //   277: iconst_2
    //   278: new 310	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 314
    //   288: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_0
    //   292: getfield 232	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mUri	Landroid/net/Uri;
    //   295: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: aload_2
    //   302: invokestatic 328	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   305: aload_0
    //   306: iconst_m1
    //   307: putfield 61	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mCurrentState	I
    //   310: aload_0
    //   311: iconst_m1
    //   312: putfield 63	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mTargetState	I
    //   315: aload_0
    //   316: getfield 90	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Qmc$c	Lqmc$c;
    //   319: aload_0
    //   320: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   323: iconst_1
    //   324: iconst_0
    //   325: invokeinterface 333 4 0
    //   330: pop
    //   331: return
    //   332: astore_2
    //   333: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq -290 -> 46
    //   339: aload_0
    //   340: getfield 59	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:TAG	Ljava/lang/String;
    //   343: iconst_2
    //   344: new 310	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   351: ldc_w 335
    //   354: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_2
    //   358: invokestatic 339	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   361: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 342	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: goto -324 -> 46
    //   373: aload_0
    //   374: aload_0
    //   375: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   378: invokeinterface 346 1 0
    //   383: putfield 250	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:wc	I
    //   386: goto -299 -> 87
    //   389: astore_2
    //   390: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +35 -> 428
    //   396: aload_0
    //   397: getfield 59	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:TAG	Ljava/lang/String;
    //   400: iconst_2
    //   401: new 310	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 314
    //   411: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_0
    //   415: getfield 232	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mUri	Landroid/net/Uri;
    //   418: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: aload_2
    //   425: invokestatic 328	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   428: aload_0
    //   429: iconst_m1
    //   430: putfield 61	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mCurrentState	I
    //   433: aload_0
    //   434: iconst_m1
    //   435: putfield 63	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mTargetState	I
    //   438: aload_0
    //   439: getfield 90	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Qmc$c	Lqmc$c;
    //   442: aload_0
    //   443: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   446: iconst_1
    //   447: iconst_0
    //   448: invokeinterface 333 4 0
    //   453: pop
    //   454: return
    //   455: astore_2
    //   456: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +15 -> 474
    //   462: aload_0
    //   463: getfield 59	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:TAG	Ljava/lang/String;
    //   466: iconst_2
    //   467: ldc_w 348
    //   470: aload_2
    //   471: invokestatic 328	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   474: aload_0
    //   475: iconst_m1
    //   476: putfield 61	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mCurrentState	I
    //   479: aload_0
    //   480: iconst_m1
    //   481: putfield 63	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:mTargetState	I
    //   484: aload_0
    //   485: getfield 90	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_b_of_type_Qmc$c	Lqmc$c;
    //   488: aload_0
    //   489: getfield 142	com/tencent/biz/qqstory/playvideo/player/TextureVideoView:jdField_a_of_type_Qmc	Lqmc;
    //   492: iconst_1
    //   493: iconst_0
    //   494: invokeinterface 333 4 0
    //   499: pop
    //   500: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	TextureVideoView
    //   0	501	1	paramBoolean	boolean
    //   266	36	2	localIOException	java.io.IOException
    //   332	26	2	localException	Exception
    //   389	36	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   455	16	2	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   46	87	266	java/io/IOException
    //   87	185	266	java/io/IOException
    //   185	265	266	java/io/IOException
    //   373	386	266	java/io/IOException
    //   24	46	332	java/lang/Exception
    //   46	87	389	java/lang/IllegalArgumentException
    //   87	185	389	java/lang/IllegalArgumentException
    //   185	265	389	java/lang/IllegalArgumentException
    //   373	386	389	java/lang/IllegalArgumentException
    //   46	87	455	java/lang/IllegalStateException
    //   87	185	455	java/lang/IllegalStateException
    //   185	265	455	java/lang/IllegalStateException
    //   373	386	455	java/lang/IllegalStateException
  }
  
  protected qmc a()
  {
    return new qmd();
  }
  
  public boolean canPause()
  {
    return this.ii;
  }
  
  public boolean canSeekBackward()
  {
    return this.ij;
  }
  
  public boolean canSeekForward()
  {
    return this.ik;
  }
  
  public int getAudioSessionId()
  {
    if (this.wc == 0)
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      this.wc = localMediaPlayer.getAudioSessionId();
      localMediaPlayer.release();
    }
    return this.wc;
  }
  
  public int getBufferPercentage()
  {
    if (this.jdField_a_of_type_Qmc != null) {
      return this.wd;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (isInPlaybackState()) {
      return this.jdField_a_of_type_Qmc.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (isInPlaybackState()) {
      return this.jdField_a_of_type_Qmc.getDuration();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (isInPlaybackState()) && (this.jdField_a_of_type_Qmc.isPlaying());
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TextureVideoView.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i;
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 164) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6))
    {
      i = 1;
      if ((!isInPlaybackState()) || (i == 0) || (this.jdField_a_of_type_AndroidWidgetMediaController == null)) {
        break label188;
      }
      if ((paramInt != 79) && (paramInt != 85)) {
        break label116;
      }
      if (!this.jdField_a_of_type_Qmc.isPlaying()) {
        break label103;
      }
      pause();
      this.jdField_a_of_type_AndroidWidgetMediaController.show();
    }
    label103:
    label116:
    do
    {
      do
      {
        return true;
        i = 0;
        break;
        start();
        this.jdField_a_of_type_AndroidWidgetMediaController.hide();
        return true;
        if (paramInt != 126) {
          break label147;
        }
      } while (this.jdField_a_of_type_Qmc.isPlaying());
      start();
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
      return true;
      if ((paramInt != 86) && (paramInt != 127)) {
        break label184;
      }
    } while (!this.jdField_a_of_type_Qmc.isPlaying());
    label147:
    pause();
    this.jdField_a_of_type_AndroidWidgetMediaController.show();
    return true;
    label184:
    pe();
    label188:
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = TextureView.getDefaultSize(this.mVideoWidth, paramInt1);
    int m = TextureView.getDefaultSize(this.mVideoHeight, paramInt2);
    int j = m;
    int i = k;
    int n;
    if (this.mVideoWidth > 0)
    {
      j = m;
      i = k;
      if (this.mVideoHeight > 0)
      {
        m = View.MeasureSpec.getMode(paramInt1);
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        n = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if ((m != 1073741824) || (n != 1073741824)) {
          break label207;
        }
        if (this.mVideoWidth * paramInt2 >= this.mVideoHeight * paramInt1) {
          break label149;
        }
        if (!this.aDY) {
          break label131;
        }
        i = this.mVideoWidth * paramInt2 / this.mVideoHeight;
        j = paramInt2;
      }
    }
    for (;;)
    {
      super.setMeasuredDimension(i, j);
      return;
      label131:
      j = this.mVideoHeight * paramInt1 / this.mVideoWidth;
      i = paramInt1;
      continue;
      label149:
      if (this.mVideoWidth * paramInt2 > this.mVideoHeight * paramInt1)
      {
        if (this.aDY)
        {
          j = this.mVideoHeight * paramInt1 / this.mVideoWidth;
          i = paramInt1;
        }
        else
        {
          i = this.mVideoWidth * paramInt2 / this.mVideoHeight;
          j = paramInt2;
          continue;
          label207:
          if (m == 1073741824)
          {
            j = this.mVideoHeight * paramInt1 / this.mVideoWidth;
            if ((n == -2147483648) && (j > paramInt2))
            {
              j = paramInt2;
              i = paramInt1;
            }
          }
          else
          {
            if (n == 1073741824)
            {
              k = this.mVideoWidth * paramInt2 / this.mVideoHeight;
              j = paramInt2;
              i = k;
              if (m != -2147483648) {
                continue;
              }
              j = paramInt2;
              i = k;
              if (k <= paramInt1) {
                continue;
              }
              j = paramInt2;
              i = paramInt1;
              continue;
            }
            k = this.mVideoWidth;
            i = this.mVideoHeight;
            if ((n == -2147483648) && (i > paramInt2)) {
              k = this.mVideoWidth * paramInt2 / this.mVideoHeight;
            }
            for (;;)
            {
              j = paramInt2;
              i = k;
              if (m != -2147483648) {
                break;
              }
              j = paramInt2;
              i = k;
              if (k <= paramInt1) {
                break;
              }
              j = this.mVideoHeight * paramInt1 / this.mVideoWidth;
              i = paramInt1;
              break;
              paramInt2 = i;
            }
          }
          i = paramInt1;
        }
      }
      else
      {
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mSurface = new Surface(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onSurfaceTextureAvailable: openVideo");
    }
    pc();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    release(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i;
    if (this.mTargetState == 3)
    {
      i = 1;
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break label67;
      }
    }
    label67:
    for (paramInt1 = j;; paramInt1 = 0)
    {
      if ((this.jdField_a_of_type_Qmc != null) && (i != 0) && (paramInt1 != 0))
      {
        if (this.we != 0) {
          seekTo(this.we);
        }
        start();
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Qmc$i != null) {
      this.jdField_a_of_type_Qmc$i.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isInPlaybackState()) && (this.jdField_a_of_type_AndroidWidgetMediaController != null)) {
      pe();
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((isInPlaybackState()) && (this.jdField_a_of_type_AndroidWidgetMediaController != null)) {
      pe();
    }
    return false;
  }
  
  public void pause()
  {
    if ((isInPlaybackState()) && (this.jdField_a_of_type_Qmc.isPlaying()))
    {
      this.jdField_a_of_type_Qmc.pause();
      this.mCurrentState = 4;
    }
    this.mTargetState = 4;
  }
  
  public void seekTo(int paramInt)
  {
    if (isInPlaybackState())
    {
      this.jdField_a_of_type_Qmc.seekTo(paramInt);
      this.we = 0;
      return;
    }
    this.we = paramInt;
  }
  
  public void setCenterInside(boolean paramBoolean)
  {
    this.aDY = paramBoolean;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.mIsLooping = paramBoolean;
    if (this.jdField_a_of_type_Qmc != null) {
      this.jdField_a_of_type_Qmc.setLooping(paramBoolean);
    }
  }
  
  public void setOnCompletionListener(qmc.b paramb)
  {
    this.jdField_a_of_type_Qmc$b = paramb;
  }
  
  public void setOnErrorListener(qmc.c paramc)
  {
    this.jdField_a_of_type_Qmc$c = paramc;
  }
  
  public void setOnInfoListener(qmc.d paramd)
  {
    this.jdField_a_of_type_Qmc$d = paramd;
  }
  
  public void setOnPreparedListener(qmc.e parame)
  {
    this.jdField_a_of_type_Qmc$e = parame;
  }
  
  public void setOnSeekCompleteListener(qmc.f paramf)
  {
    this.jdField_a_of_type_Qmc$f = paramf;
    if (this.jdField_a_of_type_Qmc != null) {
      this.jdField_a_of_type_Qmc.setOnSeekCompleteListener(paramf);
    }
  }
  
  public void setVideoPath(String paramString)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = Uri.parse(paramString))
    {
      setVideoURI(paramString);
      return;
    }
  }
  
  public void setVideoURI(Uri paramUri)
  {
    setVideoURI(paramUri, null);
  }
  
  public void setVideoURI(Uri paramUri, Map<String, String> paramMap)
  {
    this.mUri = paramUri;
    this.mHeaders = paramMap;
    this.we = 0;
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "setVideoURI: openVideo");
    }
    pc();
    super.requestLayout();
    super.invalidate();
  }
  
  public void setmOnTextureUpdateListener(qmc.i parami)
  {
    this.jdField_a_of_type_Qmc$i = parami;
  }
  
  public void start()
  {
    if (isInPlaybackState())
    {
      this.jdField_a_of_type_Qmc.start();
      this.mCurrentState = 3;
    }
    this.mTargetState = 3;
  }
  
  public void stopPlayback()
  {
    if (this.jdField_a_of_type_Qmc != null)
    {
      this.jdField_a_of_type_Qmc.stop();
      this.jdField_a_of_type_Qmc.release();
      this.jdField_a_of_type_Qmc.setOnPreparedListener(null);
      this.jdField_a_of_type_Qmc.a(null);
      this.jdField_a_of_type_Qmc.setOnCompletionListener(null);
      this.jdField_a_of_type_Qmc.setOnErrorListener(null);
      this.jdField_a_of_type_Qmc.setOnInfoListener(null);
      this.jdField_a_of_type_Qmc.a(null);
      this.jdField_a_of_type_Qmc.setOnSeekCompleteListener(null);
      this.jdField_a_of_type_Qmc = null;
      this.mCurrentState = 0;
      this.mTargetState = 0;
      ((AudioManager)super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView
 * JD-Core Version:    0.7.0.1
 */