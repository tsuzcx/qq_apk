import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.2;
import com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.5;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;

@TargetApi(11)
public class addw
  implements adcy, SurfaceTexture.OnFrameAvailableListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  private boolean EV;
  private addy jdField_a_of_type_Addy;
  private adkd.a jdField_a_of_type_Adkd$a = new addx(this);
  private adkd jdField_a_of_type_Adkd;
  private adkf jdField_a_of_type_Adkf;
  private IntBuffer[] jdField_a_of_type_ArrayOfJavaNioIntBuffer = new IntBuffer[3];
  private boolean aIR;
  private adda jdField_b_of_type_Adda;
  private adkd jdField_b_of_type_Adkd;
  private boolean bMb;
  private boolean bMc;
  private final boolean bMe = false;
  private boolean bMf;
  private boolean bMg;
  private boolean bMh;
  private int bmm = 1;
  private Surface c;
  private int cDM;
  private int cDN;
  private int cDP = -1;
  private int cDQ = -1;
  private int cDR = -1;
  private volatile ISuperPlayer d;
  private ByteBuffer[] e = new ByteBuffer[3];
  private Runnable fW = new OnlineVideoARRenderable.2(this);
  private boolean isFirstDraw = true;
  private int[] ks = new int[3];
  private int mDecodeType = 0;
  private boolean mHasInit;
  private boolean mIsLooping;
  private boolean mIsPlaying;
  public float[] mMVPMatrix = new float[16];
  private int mRenderType = 0;
  private float[] mSTMatrix = new float[16];
  private SurfaceTexture mSurface;
  private int mTextureID;
  private long mVideoSize = -1L;
  private String mVideoUrl;
  
  public addw(adda paramadda, addy paramaddy)
  {
    this.jdField_b_of_type_Adda = paramadda;
    this.jdField_a_of_type_Addy = paramaddy;
    this.bmm = paramaddy.cra;
    this.mRenderType = paramaddy.cDO;
    this.jdField_a_of_type_Adkf = paramaddy.jdField_a_of_type_Adkf;
    this.mVideoUrl = paramaddy.mVideoUrl;
    this.mVideoSize = paramaddy.mVideoSize;
    boolean bool = aded.adL();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "Construction mSoftwarePlayConfig:false  isRubbishDevice:" + bool + "  isSoftPlay:" + this.jdField_a_of_type_Addy.bMi);
    }
  }
  
  private void Go(String paramString)
  {
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, arwv.toMD5(paramString));
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    this.d.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L, localSuperPlayerOption);
  }
  
  private int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws Exception
  {
    paramInt1 -= 1;
    if (this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[0] == null)
    {
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[0] = IntBuffer.allocate(1);
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[1] = IntBuffer.allocate(1);
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[2] = IntBuffer.allocate(1);
    }
    this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1].clear();
    GLES20.glGenTextures(1, this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1]);
    int i = this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1].get();
    GLES20.glBindTexture(3553, i);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    if ((this.e[paramInt1] == null) || (this.ks[paramInt1] != paramArrayOfByte.length)) {}
    try
    {
      this.e[paramInt1] = ByteBuffer.allocateDirect(paramArrayOfByte.length);
      this.e[paramInt1].order(ByteOrder.nativeOrder());
      this.ks[paramInt1] = paramArrayOfByte.length;
      this.e[paramInt1].put(paramArrayOfByte);
      this.e[paramInt1].position(0);
      GLES20.glTexImage2D(3553, 0, 6409, paramInt2, paramInt3, 0, 6409, 5121, this.e[paramInt1]);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_OnlineVideoARRenderable", 2, "textureYUV, exception=" + localThrowable.getMessage());
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  private void cQJ()
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl");
    Matrix.setIdentityM(this.mSTMatrix, 0);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.mTextureID = arrayOfInt[0];
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl, mTextureID=" + this.mTextureID);
    if (this.mTextureID == 0) {
      return;
    }
    FY(false);
  }
  
  public int Bx()
  {
    if (this.jdField_a_of_type_Addy != null) {
      return this.jdField_a_of_type_Addy.cCF;
    }
    return 0;
  }
  
  public void FY(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_Adkd == null)
      {
        this.jdField_b_of_type_Adkd = adke.a(this.jdField_a_of_type_Adkf, 3);
        this.jdField_b_of_type_Adkd.a(aded.bU, aded.c);
        this.jdField_b_of_type_Adkd.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_Adkd$a);
        this.jdField_b_of_type_Adkd.b(this.jdField_a_of_type_Addy.markerType, this.jdField_a_of_type_Addy.sY, this.jdField_a_of_type_Addy.sZ, this.jdField_a_of_type_Addy.ta);
      }
    }
    while (this.jdField_a_of_type_Adkd != null) {
      return;
    }
    this.jdField_a_of_type_Adkd = adke.a(this.jdField_a_of_type_Adkf, 1);
    this.jdField_a_of_type_Adkd.a(aded.bT, aded.c);
    this.jdField_a_of_type_Adkd.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_Adkd$a);
    this.jdField_a_of_type_Adkd.b(this.jdField_a_of_type_Addy.markerType, this.jdField_a_of_type_Addy.sY, this.jdField_a_of_type_Addy.sZ, this.jdField_a_of_type_Addy.ta);
  }
  
  public void a(addf.a parama)
  {
    a((float[])parama.r("TARGET_SIZE"), (float[])parama.r("POSE"), (float[])parama.r("CAMERA_MATRIX"), (float[])parama.r("CAMERA_POSITION"));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((!this.bMb) || (paramArrayOfFloat2 == null) || (this.jdField_a_of_type_Addy == null)) {
      return;
    }
    GLES20.glBlendFunc(770, 771);
    GLES20.glEnable(3042);
    label54:
    int i;
    if (this.jdField_a_of_type_Addy.cCF == 1)
    {
      paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat3, paramArrayOfFloat4);
      if (this.bMg) {
        break label167;
      }
      if (this.jdField_a_of_type_Adkd == null) {
        FY(this.bMg);
      }
      if (this.jdField_a_of_type_Adkd != null)
      {
        paramArrayOfFloat2 = this.jdField_a_of_type_Adkd;
        i = this.mTextureID;
        paramArrayOfFloat3 = this.jdField_a_of_type_Adkf;
        paramArrayOfFloat4 = this.mSTMatrix;
        paramArrayOfFloat2.a(new int[] { i }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
      }
    }
    for (;;)
    {
      GLES20.glDisable(3042);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      if (!this.isFirstDraw) {
        break;
      }
      this.isFirstDraw = false;
      return;
      paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat4);
      break label54;
      label167:
      if (this.jdField_b_of_type_Adkd == null) {
        FY(this.bMg);
      }
      Matrix.setIdentityM(this.mSTMatrix, 0);
      if (this.jdField_b_of_type_Adkd != null)
      {
        paramArrayOfFloat2 = this.jdField_b_of_type_Adkd;
        i = this.cDP;
        int j = this.cDQ;
        int k = this.cDR;
        paramArrayOfFloat3 = this.jdField_a_of_type_Adkf;
        paramArrayOfFloat4 = this.mSTMatrix;
        paramArrayOfFloat2.a(new int[] { i, j, k }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
      }
    }
  }
  
  public float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    if (Bx() == 2) {
      if (this.jdField_a_of_type_Addy.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a != null)
      {
        Matrix.scaleM(this.mMVPMatrix, 0, this.jdField_a_of_type_Addy.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.scaleX * paramArrayOfFloat1[0], this.jdField_a_of_type_Addy.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.scaleY * paramArrayOfFloat1[1], 1.0F);
        Matrix.translateM(this.mMVPMatrix, 0, this.jdField_a_of_type_Addy.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.uN, this.jdField_a_of_type_Addy.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.uO, this.jdField_a_of_type_Addy.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a.uP);
      }
    }
    for (;;)
    {
      return this.mMVPMatrix;
      if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat3 != null)) {
        break;
      }
      this.mMVPMatrix = new float[16];
    }
    if (this.jdField_a_of_type_Addy.markerType == 1) {}
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
    return (this.mHasInit) && (this.bMf) && (this.d != null) && ((this.bMc) || (this.mIsLooping) || (this.d.isPlaying()));
  }
  
  public int getType()
  {
    if (this.jdField_a_of_type_Addy != null) {
      return this.jdField_a_of_type_Addy.cCE;
    }
    return 4;
  }
  
  public String getUniqueKey()
  {
    return this.jdField_a_of_type_Addy.key;
  }
  
  @TargetApi(11)
  public void init()
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "init, mHasSDKInit=" + this.mHasInit);
    if (this.mHasInit) {
      return;
    }
    cQJ();
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initSDK");
    this.mSurface = new SurfaceTexture(this.mTextureID);
    this.mSurface.setOnFrameAvailableListener(this);
    this.c = new Surface(this.mSurface);
    this.d = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 108, null);
    this.d.setSurface(this.c);
    this.d.setOnVideoPreparedListener(this);
    this.d.setOnInfoListener(this);
    this.d.setOnErrorListener(this);
    this.d.setOnDefinitionInfoListener(this);
    this.d.setOnCompletionListener(this);
    this.d.setOnSeekCompleteListener(this);
    this.mHasInit = true;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onCompletion");
    }
    if (this.jdField_b_of_type_Adda != null) {
      this.jdField_b_of_type_Adda.hg(2, this.bmm - this.cDM);
    }
    if (this.cDM >= this.bmm)
    {
      this.bMc = true;
      this.mIsLooping = false;
    }
    do
    {
      return;
      paramISuperPlayer = new OnlineVideoARRenderable.5(this);
    } while (this.jdField_b_of_type_Adda == null);
    this.jdField_b_of_type_Adda.Z(paramISuperPlayer);
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onDestroy");
    }
    this.EV = false;
    this.bMf = false;
    this.EV = false;
    this.bMb = false;
    this.bMc = false;
    this.mIsLooping = false;
    this.bMg = false;
    this.cDM = 1;
    this.mIsPlaying = false;
    this.aIR = false;
    if (this.d != null) {}
    try
    {
      this.d.stop();
      this.d.release();
      if (this.jdField_a_of_type_Adkd != null)
      {
        this.jdField_a_of_type_Adkd.onDestroy();
        this.jdField_a_of_type_Adkd = null;
      }
      if (this.jdField_b_of_type_Adkd != null)
      {
        this.jdField_b_of_type_Adkd.onDestroy();
        this.jdField_b_of_type_Adkd = null;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("decode_type", String.valueOf(this.mDecodeType));
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "immersed_ar_decode_type", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onDestroy exception, msg=" + localException.getMessage());
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        if (this.jdField_b_of_type_Adda != null) {
          this.jdField_b_of_type_Adda.Gr(this.jdField_a_of_type_Addy.key);
        }
      }
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_b_of_type_Adda != null) {
      this.jdField_b_of_type_Adda.Gr(this.jdField_a_of_type_Addy.key);
    }
    onDestroy();
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.bMb = true;
    this.jdField_b_of_type_Adda.Z(this.fW);
    if (!this.bMh)
    {
      this.bMh = true;
      this.mDecodeType = 1;
    }
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "onSeekComplete");
    paramISuperPlayer.start();
  }
  
  public void onUpdate() {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onVideoPrepared. mCanPlay=" + this.EV);
    }
    if (!this.EV) {}
    for (;;)
    {
      return;
      if (this.aIR)
      {
        this.aIR = false;
        this.d.start();
        return;
      }
      this.bMf = true;
      try
      {
        this.d.start();
        this.mIsLooping = true;
        if (this.jdField_b_of_type_Adda != null)
        {
          this.jdField_b_of_type_Adda.hg(0, this.bmm);
          return;
        }
      }
      catch (Exception paramISuperPlayer)
      {
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onVideoPrepared, exception=" + paramISuperPlayer.getMessage());
        if (QLog.isColorLevel()) {
          paramISuperPlayer.printStackTrace();
        }
        onDestroy();
      }
    }
  }
  
  public void setWidthAndHeight(int paramInt1, int paramInt2) {}
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, arResourceInfo=" + this.jdField_a_of_type_Addy);
    }
    if ((this.mIsPlaying) || (this.d == null) || (this.d.isPlaying())) {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mMediaPlayer == null || mMediaPlayer.isPlaying()");
      }
    }
    do
    {
      return;
      if ((this.mVideoSize >= 0L) && (!TextUtils.isEmpty(this.mVideoUrl))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mVideoSize < 0 || TextUtils.isEmpty(mVideoUrl)");
    return;
    if (!this.mHasInit)
    {
      QLog.d("AREngine_OnlineVideoARRenderable", 1, "init failed");
      return;
    }
    this.bMf = false;
    this.bMb = false;
    this.bMc = false;
    this.mIsLooping = false;
    this.cDM = 1;
    this.mDecodeType = 0;
    this.bMh = false;
    this.EV = true;
    this.mIsPlaying = true;
    String str = adkz.jQ(this.mVideoUrl);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, video dir=" + str + ", mSoftwarePlayConfig=" + false);
    }
    Go(this.mVideoUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addw
 * JD-Core Version:    0.7.0.1
 */