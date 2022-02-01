import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARRenderable.3;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

@TargetApi(14)
public class addt
  implements adcy, SurfaceTexture.OnFrameAvailableListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener
{
  public long St;
  private boolean TL;
  addv jdField_a_of_type_Addv;
  private adkd.a jdField_a_of_type_Adkd$a = new addu(this);
  private adkd jdField_a_of_type_Adkd;
  private adkf jdField_a_of_type_Adkf;
  private Runnable aI = new NormalVideoARRenderable.3(this);
  public adda b;
  private boolean bMa;
  private boolean bMb;
  private boolean bMc;
  boolean bMd = false;
  private int bmm = 1;
  private int cDM;
  private int cDN;
  private boolean isFirstDraw = true;
  public long lastFrameUpdateTime;
  private boolean mHasInited;
  private boolean mIsLooping;
  private boolean mIsPlaying;
  public float[] mMVPMatrix = new float[16];
  private MediaPlayer mMediaPlayer;
  private int mRenderType;
  private float[] mSTMatrix = new float[16];
  private SurfaceTexture mSurface;
  private int mTextureID;
  private String mVideoPath;
  
  public addt(adda paramadda, addv paramaddv)
  {
    this.b = paramadda;
    this.jdField_a_of_type_Addv = paramaddv;
    this.mVideoPath = paramaddv.mVideoPath;
    this.bmm = paramaddv.cra;
    this.mRenderType = paramaddv.cDO;
    this.jdField_a_of_type_Adkf = paramaddv.jdField_a_of_type_Adkf;
    paramadda = Build.MODEL.toLowerCase();
    if ((Build.MANUFACTURER.toLowerCase().contains("meizu")) && (paramadda.contains("m040"))) {
      this.bMd = true;
    }
  }
  
  private void cQI()
  {
    QLog.d("AREngine_ARVideoRenderable", 1, "initMedia, mHasMediaInit=" + this.bMa);
    if (this.bMa) {}
    do
    {
      return;
      this.bMa = true;
      if (TextUtils.isEmpty(this.mVideoPath))
      {
        QLog.d("AREngine_ARVideoRenderable", 1, "initMedia failed, mVideoPath is empty");
        return;
      }
      if (!new File(this.mVideoPath).exists())
      {
        QLog.d("AREngine_ARVideoRenderable", 1, "initMedia failed, file not exist");
        return;
      }
      try
      {
        this.mMediaPlayer = new MediaPlayer();
        this.mMediaPlayer.setOnCompletionListener(this);
        this.mMediaPlayer.setOnErrorListener(this);
        this.mMediaPlayer.setOnBufferingUpdateListener(this);
        this.mMediaPlayer.setOnPreparedListener(this);
        this.mMediaPlayer.setOnInfoListener(this);
        this.mMediaPlayer.setLooping(false);
        this.mSurface = new SurfaceTexture(this.mTextureID);
        this.mSurface.setOnFrameAvailableListener(this);
        Surface localSurface = new Surface(this.mSurface);
        this.mMediaPlayer.setSurface(localSurface);
        localSurface.release();
        this.bMa = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("AREngine_ARVideoRenderable", 1, "init, throwable t = " + localThrowable.getMessage());
      }
    } while (!QLog.isColorLevel());
    localThrowable.printStackTrace();
  }
  
  private void cQJ()
  {
    QLog.d("AREngine_ARVideoRenderable", 1, "initGl, mHasMediaInit=" + this.bMa);
    Matrix.setIdentityM(this.mSTMatrix, 0);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.mTextureID = arrayOfInt[0];
    QLog.d("AREngine_ARVideoRenderable", 1, "initGl, mTextureID=" + this.mTextureID);
    if (this.mTextureID == 0) {
      return;
    }
    cQK();
  }
  
  private void cQK()
  {
    if (this.jdField_a_of_type_Adkd == null)
    {
      this.jdField_a_of_type_Adkd = adke.a(this.jdField_a_of_type_Adkf, 1);
      this.jdField_a_of_type_Adkd.a(aded.bT, aded.c);
      this.jdField_a_of_type_Adkd.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_Adkd$a);
      this.jdField_a_of_type_Adkd.b(this.jdField_a_of_type_Addv.markerType, this.jdField_a_of_type_Addv.sY, this.jdField_a_of_type_Addv.sZ, this.jdField_a_of_type_Addv.ta);
    }
  }
  
  private void cQL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "isColorLevel, mLoopCount=" + this.bmm + ", mCurPlayCount=" + this.cDM);
    }
  }
  
  public int Bx()
  {
    if (this.jdField_a_of_type_Addv != null) {
      return this.jdField_a_of_type_Addv.cCF;
    }
    return 0;
  }
  
  public void a(addf.a parama)
  {
    a((float[])parama.r("TARGET_SIZE"), (float[])parama.r("POSE"), (float[])parama.r("CAMERA_MATRIX"), (float[])parama.r("CAMERA_POSITION"));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((!this.bMb) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat3 == null) || (paramArrayOfFloat4 == null) || (this.jdField_a_of_type_Addv == null)) {
      return;
    }
    GLES20.glBlendFunc(770, 771);
    GLES20.glEnable(3042);
    if (this.jdField_a_of_type_Adkd == null) {
      cQK();
    }
    int i;
    adkf localadkf;
    if ((this.jdField_a_of_type_Addv != null) && (this.jdField_a_of_type_Addv.cCF == 1)) {
      if (this.jdField_a_of_type_Adkd != null)
      {
        paramArrayOfFloat2 = this.jdField_a_of_type_Adkd;
        i = this.mTextureID;
        localadkf = this.jdField_a_of_type_Adkf;
        paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat3, paramArrayOfFloat4);
        paramArrayOfFloat3 = this.mSTMatrix;
        paramArrayOfFloat2.a(new int[] { i }, localadkf, paramArrayOfFloat1, paramArrayOfFloat3);
      }
    }
    for (;;)
    {
      GLES20.glDisable(3042);
      GLES20.glBindTexture(36197, 0);
      if (!this.isFirstDraw) {
        break;
      }
      this.isFirstDraw = false;
      return;
      if (this.jdField_a_of_type_Adkd != null)
      {
        paramArrayOfFloat3 = this.jdField_a_of_type_Adkd;
        i = this.mTextureID;
        localadkf = this.jdField_a_of_type_Adkf;
        paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat4);
        paramArrayOfFloat2 = this.mSTMatrix;
        paramArrayOfFloat3.a(new int[] { i }, localadkf, paramArrayOfFloat1, paramArrayOfFloat2);
      }
    }
  }
  
  public float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    if (Bx() == 2)
    {
      if (this.jdField_a_of_type_Addv.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a != null)
      {
        Matrix.scaleM(this.mMVPMatrix, 0, this.jdField_a_of_type_Addv.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.scaleX * paramArrayOfFloat1[0], this.jdField_a_of_type_Addv.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.scaleY * paramArrayOfFloat1[1], 1.0F);
        Matrix.translateM(this.mMVPMatrix, 0, this.jdField_a_of_type_Addv.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.uN, this.jdField_a_of_type_Addv.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.uO, this.jdField_a_of_type_Addv.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.uP);
      }
      return this.mMVPMatrix;
    }
    if (this.jdField_a_of_type_Addv.markerType == 1) {}
    for (;;)
    {
      Matrix.multiplyMM(this.mMVPMatrix, 0, paramArrayOfFloat2, 0, this.mMVPMatrix, 0);
      Matrix.multiplyMM(this.mMVPMatrix, 0, paramArrayOfFloat3, 0, this.mMVPMatrix, 0);
      break;
      Matrix.scaleM(this.mMVPMatrix, 0, paramArrayOfFloat1[0], paramArrayOfFloat1[1], 1.0F);
    }
  }
  
  public boolean adF()
  {
    return this.bMb;
  }
  
  public boolean canRender()
  {
    return (!this.bMd) && (this.bMa) && (this.mMediaPlayer != null) && ((this.bMc) || (this.mIsPlaying) || (this.mIsLooping));
  }
  
  public int getType()
  {
    if (this.jdField_a_of_type_Addv != null) {
      return this.jdField_a_of_type_Addv.cCE;
    }
    return 2;
  }
  
  public String getUniqueKey()
  {
    return this.jdField_a_of_type_Addv.key;
  }
  
  public void init()
  {
    if (this.mHasInited) {
      return;
    }
    this.mHasInited = true;
    QLog.d("AREngine_ARVideoRenderable", 1, "init");
    cQJ();
    cQI();
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "onBufferingUpdate, percent=" + paramInt);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "onCompletion");
    }
    if (this.b != null) {
      this.b.hg(2, this.bmm - this.cDM);
    }
    if (this.cDM >= this.bmm)
    {
      this.bMc = true;
      this.mIsLooping = false;
      return;
    }
    try
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.prepare();
      this.mMediaPlayer.start();
      this.cDM += 1;
      cQL();
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      if (QLog.isColorLevel()) {
        paramMediaPlayer.printStackTrace();
      }
      QLog.d("AREngine_ARVideoRenderable", 1, "onCompletion, exception=" + paramMediaPlayer + ", msg=" + paramMediaPlayer.getMessage());
      onDestroy();
    }
  }
  
  public void onDestroy()
  {
    QLog.d("AREngine_ARVideoRenderable", 1, "onDestroy");
    if (this.mMediaPlayer != null) {}
    try
    {
      boolean bool = this.mMediaPlayer.isPlaying();
      if (QLog.isColorLevel()) {
        QLog.d("HSRender", 2, "onDestroy, isPlaying=" + bool + ", isLooping=" + this.mMediaPlayer.isLooping());
      }
      if (bool) {
        this.mMediaPlayer.stop();
      }
      this.mMediaPlayer.reset();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        QLog.d("AREngine_ARVideoRenderable", 1, "onDestroy, exception, e=" + localException.getMessage());
      }
    }
    this.bMb = false;
    if (this.jdField_a_of_type_Adkd != null)
    {
      this.jdField_a_of_type_Adkd.onDestroy();
      this.jdField_a_of_type_Adkd = null;
    }
    this.cDM = 0;
    this.mIsLooping = false;
    this.bMc = false;
    this.mIsPlaying = false;
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.d("AREngine_ARVideoRenderable", 1, "onError, what=" + paramInt1 + ", extra" + paramInt2);
    if (this.b != null) {
      this.b.Gr(this.jdField_a_of_type_Addv.key);
    }
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    paramMediaPlayer = new HashMap();
    paramMediaPlayer.put("param_FailCode", String.valueOf(paramInt1));
    paramMediaPlayer.put("extra", String.valueOf(paramInt2));
    paramMediaPlayer.put("url", this.jdField_a_of_type_Addv.key);
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "immersed_ar_on_error", true, 0L, 0L, paramMediaPlayer, "", false);
    onDestroy();
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.TL) {
      this.bMb = true;
    }
    while ((!this.mIsLooping) && (Build.MODEL.equalsIgnoreCase("MI 6")))
    {
      QLog.d("AREngine_ARVideoRenderable", 1, "onFrameAvailable mIsLooping ");
      return;
      this.TL = true;
    }
    this.b.Z(this.aI);
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "onInfo, what=" + paramInt1 + ", extra=" + paramInt2);
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "onPrepared");
    }
  }
  
  public void onUpdate() {}
  
  public void setWidthAndHeight(int paramInt1, int paramInt2) {}
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 142
    //   4: iconst_1
    //   5: ldc_w 550
    //   8: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +29 -> 43
    //   17: ldc 142
    //   19: iconst_2
    //   20: new 144	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 552
    //   30: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 404	addt:mIsPlaying	Z
    //   47: ifne +20 -> 67
    //   50: aload_0
    //   51: getfield 188	addt:mMediaPlayer	Landroid/media/MediaPlayer;
    //   54: ifnull +13 -> 67
    //   57: aload_0
    //   58: getfield 188	addt:mMediaPlayer	Landroid/media/MediaPlayer;
    //   61: invokevirtual 463	android/media/MediaPlayer:isPlaying	()Z
    //   64: ifeq +52 -> 116
    //   67: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +45 -> 115
    //   73: ldc 142
    //   75: iconst_2
    //   76: new 144	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 554
    //   86: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 404	addt:mIsPlaying	Z
    //   93: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: ldc_w 556
    //   99: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 188	addt:mMediaPlayer	Landroid/media/MediaPlayer;
    //   106: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: return
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 527	addt:TL	Z
    //   121: aload_0
    //   122: iconst_0
    //   123: putfield 345	addt:bMb	Z
    //   126: new 558	java/io/FileInputStream
    //   129: dup
    //   130: new 174	java/io/File
    //   133: dup
    //   134: aload_0
    //   135: getfield 94	addt:mVideoPath	Ljava/lang/String;
    //   138: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: invokespecial 561	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   144: astore_3
    //   145: aload_3
    //   146: astore_2
    //   147: aload_3
    //   148: invokevirtual 565	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   151: astore 4
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 188	addt:mMediaPlayer	Landroid/media/MediaPlayer;
    //   159: aload 4
    //   161: invokevirtual 569	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   164: aload_3
    //   165: astore_2
    //   166: aload_0
    //   167: iconst_1
    //   168: putfield 319	addt:cDM	I
    //   171: aload_3
    //   172: astore_2
    //   173: aload_0
    //   174: getfield 188	addt:mMediaPlayer	Landroid/media/MediaPlayer;
    //   177: astore 4
    //   179: aload_3
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 65	addt:bmm	I
    //   185: ifne +96 -> 281
    //   188: aload_3
    //   189: astore_2
    //   190: aload 4
    //   192: iload_1
    //   193: invokevirtual 212	android/media/MediaPlayer:setLooping	(Z)V
    //   196: aload_3
    //   197: astore_2
    //   198: aload_0
    //   199: iconst_1
    //   200: putfield 406	addt:mIsLooping	Z
    //   203: aload_3
    //   204: astore_2
    //   205: aload_0
    //   206: getfield 188	addt:mMediaPlayer	Landroid/media/MediaPlayer;
    //   209: invokevirtual 442	android/media/MediaPlayer:prepare	()V
    //   212: aload_3
    //   213: astore_2
    //   214: aload_0
    //   215: iconst_0
    //   216: putfield 402	addt:bMc	Z
    //   219: aload_3
    //   220: astore_2
    //   221: aload_0
    //   222: getfield 188	addt:mMediaPlayer	Landroid/media/MediaPlayer;
    //   225: invokevirtual 445	android/media/MediaPlayer:start	()V
    //   228: aload_3
    //   229: astore_2
    //   230: aload_0
    //   231: iconst_1
    //   232: putfield 404	addt:mIsPlaying	Z
    //   235: aload_3
    //   236: astore_2
    //   237: aload_0
    //   238: getfield 87	addt:b	Ladda;
    //   241: ifnull +19 -> 260
    //   244: aload_3
    //   245: astore_2
    //   246: aload_0
    //   247: getfield 87	addt:b	Ladda;
    //   250: iconst_0
    //   251: aload_0
    //   252: getfield 65	addt:bmm	I
    //   255: invokeinterface 436 3 0
    //   260: aload_3
    //   261: ifnull -146 -> 115
    //   264: aload_3
    //   265: invokevirtual 572	java/io/FileInputStream:close	()V
    //   268: return
    //   269: astore_2
    //   270: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq -158 -> 115
    //   276: aload_2
    //   277: invokevirtual 246	java/lang/Throwable:printStackTrace	()V
    //   280: return
    //   281: iconst_0
    //   282: istore_1
    //   283: goto -95 -> 188
    //   286: astore 4
    //   288: aconst_null
    //   289: astore_3
    //   290: aload_3
    //   291: astore_2
    //   292: ldc 142
    //   294: iconst_2
    //   295: new 144	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 574
    //   305: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 4
    //   310: invokevirtual 575	java/io/IOException:getMessage	()Ljava/lang/String;
    //   313: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: aload_3
    //   323: astore_2
    //   324: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq +10 -> 337
    //   330: aload_3
    //   331: astore_2
    //   332: aload 4
    //   334: invokevirtual 576	java/io/IOException:printStackTrace	()V
    //   337: aload_3
    //   338: astore_2
    //   339: aload_0
    //   340: invokevirtual 459	addt:onDestroy	()V
    //   343: aload_3
    //   344: ifnull -229 -> 115
    //   347: aload_3
    //   348: invokevirtual 572	java/io/FileInputStream:close	()V
    //   351: return
    //   352: astore_2
    //   353: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -241 -> 115
    //   359: aload_2
    //   360: invokevirtual 246	java/lang/Throwable:printStackTrace	()V
    //   363: return
    //   364: astore 4
    //   366: aconst_null
    //   367: astore_3
    //   368: aload_3
    //   369: astore_2
    //   370: ldc 142
    //   372: iconst_2
    //   373: new 144	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 578
    //   383: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 4
    //   388: invokevirtual 240	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   391: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: aload_3
    //   401: astore_2
    //   402: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +10 -> 415
    //   408: aload_3
    //   409: astore_2
    //   410: aload 4
    //   412: invokevirtual 246	java/lang/Throwable:printStackTrace	()V
    //   415: aload_3
    //   416: astore_2
    //   417: aload_0
    //   418: invokevirtual 459	addt:onDestroy	()V
    //   421: aload_3
    //   422: ifnull -307 -> 115
    //   425: aload_3
    //   426: invokevirtual 572	java/io/FileInputStream:close	()V
    //   429: return
    //   430: astore_2
    //   431: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq -319 -> 115
    //   437: aload_2
    //   438: invokevirtual 246	java/lang/Throwable:printStackTrace	()V
    //   441: return
    //   442: astore_3
    //   443: aconst_null
    //   444: astore_2
    //   445: aload_2
    //   446: ifnull +7 -> 453
    //   449: aload_2
    //   450: invokevirtual 572	java/io/FileInputStream:close	()V
    //   453: aload_3
    //   454: athrow
    //   455: astore_2
    //   456: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq -6 -> 453
    //   462: aload_2
    //   463: invokevirtual 246	java/lang/Throwable:printStackTrace	()V
    //   466: goto -13 -> 453
    //   469: astore_3
    //   470: goto -25 -> 445
    //   473: astore 4
    //   475: goto -107 -> 368
    //   478: astore 4
    //   480: goto -190 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	addt
    //   1	282	1	bool	boolean
    //   146	100	2	localFileInputStream1	java.io.FileInputStream
    //   269	8	2	localThrowable1	Throwable
    //   291	48	2	localFileInputStream2	java.io.FileInputStream
    //   352	8	2	localThrowable2	Throwable
    //   369	48	2	localFileInputStream3	java.io.FileInputStream
    //   430	8	2	localThrowable3	Throwable
    //   444	6	2	localObject1	Object
    //   455	8	2	localThrowable4	Throwable
    //   144	282	3	localFileInputStream4	java.io.FileInputStream
    //   442	12	3	localObject2	Object
    //   469	1	3	localObject3	Object
    //   151	40	4	localObject4	Object
    //   286	47	4	localIOException1	java.io.IOException
    //   364	47	4	localThrowable5	Throwable
    //   473	1	4	localThrowable6	Throwable
    //   478	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   264	268	269	java/lang/Throwable
    //   126	145	286	java/io/IOException
    //   347	351	352	java/lang/Throwable
    //   126	145	364	java/lang/Throwable
    //   425	429	430	java/lang/Throwable
    //   126	145	442	finally
    //   449	453	455	java/lang/Throwable
    //   147	153	469	finally
    //   155	164	469	finally
    //   166	171	469	finally
    //   173	179	469	finally
    //   181	188	469	finally
    //   190	196	469	finally
    //   198	203	469	finally
    //   205	212	469	finally
    //   214	219	469	finally
    //   221	228	469	finally
    //   230	235	469	finally
    //   237	244	469	finally
    //   246	260	469	finally
    //   292	322	469	finally
    //   324	330	469	finally
    //   332	337	469	finally
    //   339	343	469	finally
    //   370	400	469	finally
    //   402	408	469	finally
    //   410	415	469	finally
    //   417	421	469	finally
    //   147	153	473	java/lang/Throwable
    //   155	164	473	java/lang/Throwable
    //   166	171	473	java/lang/Throwable
    //   173	179	473	java/lang/Throwable
    //   181	188	473	java/lang/Throwable
    //   190	196	473	java/lang/Throwable
    //   198	203	473	java/lang/Throwable
    //   205	212	473	java/lang/Throwable
    //   214	219	473	java/lang/Throwable
    //   221	228	473	java/lang/Throwable
    //   230	235	473	java/lang/Throwable
    //   237	244	473	java/lang/Throwable
    //   246	260	473	java/lang/Throwable
    //   147	153	478	java/io/IOException
    //   155	164	478	java/io/IOException
    //   166	171	478	java/io/IOException
    //   173	179	478	java/io/IOException
    //   181	188	478	java/io/IOException
    //   190	196	478	java/io/IOException
    //   198	203	478	java/io/IOException
    //   205	212	478	java/io/IOException
    //   214	219	478	java/io/IOException
    //   221	228	478	java/io/IOException
    //   230	235	478	java/io/IOException
    //   237	244	478	java/io/IOException
    //   246	260	478	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addt
 * JD-Core Version:    0.7.0.1
 */