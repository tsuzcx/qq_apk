import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView.ScaleType;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.GLVideoView.2;
import com.tencent.av.ui.GLVideoView.3;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class izm
  extends iqt
{
  private final String TAG;
  boolean Uf = false;
  public boolean WC;
  protected boolean WD;
  private boolean WE = true;
  protected boolean WF = true;
  protected boolean WG = true;
  protected boolean WH;
  protected boolean WI;
  protected boolean WJ = true;
  boolean WK = true;
  protected boolean WL;
  protected boolean WM;
  protected boolean WN;
  private ipq jdField_a_of_type_Ipq;
  protected iql a;
  protected iqm a;
  protected iqp a;
  private iwm jdField_a_of_type_Iwm;
  izm.a jdField_a_of_type_Izm$a = null;
  private int avR = 0;
  protected int avS = -1;
  protected int avT = -1;
  protected int avU;
  protected int avV;
  protected int avW = -1;
  protected int avX = -1;
  protected int avY = -1;
  protected int avZ;
  protected int awa;
  int awb = 0;
  int awc = 0;
  int awd = 0;
  int awe = 70;
  int awf = 0;
  protected YUVTexture b;
  protected iql b;
  protected WeakReference<Context> bD;
  public Runnable bT = new GLVideoView.2(this);
  protected iqk c;
  protected iql c;
  protected iqk d;
  protected iqk e;
  private float hI = 1.0F;
  private float hJ = 5.0F;
  protected Context mContext;
  protected RectF mDstRectF;
  protected long mLastLoadingTime;
  protected boolean mLoading;
  protected int mLoadingAngle;
  private final float[] mMatrixValues = new float[9];
  protected int mMaxLength = 2147483647;
  protected boolean mMirror;
  private ImageView.ScaleType mScaleType;
  protected String mSelfUin = "";
  private boolean mShowText;
  protected String mText;
  protected int mTextAlpha = 255;
  protected int mTextColor = -1;
  protected float mTextSize = 20.0F;
  protected Matrix mTransformMatrix;
  protected long oy;
  long oz = 0L;
  private Matrix p;
  protected RectF t;
  protected RectF u;
  
  public izm(Context paramContext, VideoAppInterface paramVideoAppInterface, String paramString, long paramLong)
  {
    this(paramContext, paramVideoAppInterface, paramString, paramLong, true);
  }
  
  public izm(Context paramContext, VideoAppInterface paramVideoAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    super(paramContext);
    this.TAG = ("GLVideoView_" + paramString);
    QLog.w(this.TAG, 1, "create GLVideoView");
    this.mContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Ipq = new ipq();
    this.avZ = wja.dp2px(6.0F, paramContext.getResources());
    this.awa = wja.dp2px(10.0F, paramContext.getResources());
    if (paramBoolean)
    {
      this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture = new iqr(this.mContext, this, paramString, paramLong);
      this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.a(new izn(this, paramVideoAppInterface));
    }
    this.mScaleType = ImageView.ScaleType.CENTER_INSIDE;
    this.p = new Matrix();
    this.mTransformMatrix = new Matrix();
    this.t = new RectF();
    this.u = new RectF();
    this.mDstRectF = new RectF();
  }
  
  static Pair<Integer, Integer> a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 1) {
      paramInt1 = paramInt3 - paramInt1;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      if (paramInt5 == 2)
      {
        paramInt2 = paramInt4 - paramInt2;
        paramInt3 -= paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = paramInt3;
      }
      else if (paramInt5 == 3)
      {
        paramInt2 = paramInt4 - paramInt2;
      }
      else
      {
        paramInt3 = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = paramInt3;
      }
    }
  }
  
  private void a(ipm paramipm, int paramInt)
  {
    if (this.mMirror)
    {
      if (paramInt % 2 == 0) {
        paramipm.scale(-1.0F, 1.0F, 1.0F);
      }
    }
    else {
      return;
    }
    paramipm.scale(1.0F, -1.0F, 1.0F);
  }
  
  public static int[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
    {
      QLog.d("GLVideoView", 1, "I420toARGB is null nWidth=" + paramInt1 + ", nHeight=" + paramInt2);
      return null;
    }
    int n;
    int m;
    if (paramInt2 < 0)
    {
      n = -paramInt2;
      m = 1;
    }
    for (;;)
    {
      int i2 = 0;
      int i1 = paramInt1;
      if (paramInt1 < 0)
      {
        i1 = -paramInt1;
        i2 = 1;
      }
      int i4 = i1 * n;
      label386:
      for (;;)
      {
        int[] arrayOfInt;
        int j;
        int i;
        int k;
        try
        {
          arrayOfInt = new int[i4];
          paramInt1 = 0;
          if (paramInt1 >= i4) {
            break label371;
          }
          paramInt2 = paramInt1 / i1 / 2 * (i1 / 2) + paramInt1 % i1 / 2;
          j = paramArrayOfByte[paramInt1] & 0xFF;
          i = paramArrayOfByte[(i4 + paramInt2)] & 0xFF;
          k = paramArrayOfByte[(paramInt2 + (i4 / 4 + i4))] & 0xFF;
          paramInt2 = (int)(j + 1.8556D * (i - 128));
          i = (int)(j - (0.4681D * (k - 128) + 0.1872D * (i - 128)));
          j = (int)(j + 1.5748D * (k - 128));
          if (paramInt2 > 255)
          {
            paramInt2 = 255;
            if (i <= 255) {
              break label351;
            }
            i = 255;
            if (j <= 255) {
              break label360;
            }
            j = 255;
            if (m == 0) {
              break label374;
            }
            k = (n - 1 - paramInt1 / i1) * i1 + paramInt1 % i1;
            int i3 = k;
            if (i2 != 0) {
              i3 = k / i1 * i1 + (i1 - 1) - k % i1;
            }
            arrayOfInt[i3] = (j << 16 & 0xFF0000 | 0xFF000000 | i << 8 & 0xFF00 | paramInt2 & 0xFF);
            paramInt1 += 1;
            continue;
          }
          if (paramInt2 >= 0) {
            break label386;
          }
        }
        catch (OutOfMemoryError paramArrayOfByte)
        {
          return null;
        }
        paramInt2 = 0;
        continue;
        label351:
        if (i < 0)
        {
          i = 0;
          continue;
          label360:
          if (j < 0)
          {
            j = 0;
            continue;
            label371:
            return arrayOfInt;
            label374:
            k = paramInt1;
          }
          else {}
        }
        else {}
      }
      m = 0;
      n = paramInt2;
    }
  }
  
  private boolean cv(int paramInt)
  {
    int i = getVideoSrcType();
    if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
      if (!this.WC) {}
    }
    do
    {
      do
      {
        return true;
      } while ((paramInt % 2 == 0) && (!this.WN));
      do
      {
        return false;
      } while (this.mScaleType != ImageView.ScaleType.CENTER_CROP);
    } while (i == 2);
    return false;
  }
  
  static int cx(int paramInt)
  {
    switch (paramInt % 360)
    {
    default: 
      return 0;
    case 270: 
      return 1;
    case 180: 
      return 2;
    }
    return 3;
  }
  
  private void mu(int paramInt)
  {
    if ((this.bD == null) || (this.bD.get() == null)) {}
    for (;;)
    {
      return;
      StringBuilder localStringBuilder = null;
      Object localObject = localStringBuilder;
      if (this.bD.get() != null)
      {
        localObject = localStringBuilder;
        if ((this.bD.get() instanceof AVActivity)) {
          localObject = (AVActivity)this.bD.get();
        }
      }
      if ((localObject != null) && (((AVActivity)localObject).mControlUI != null) && ((((AVActivity)localObject).mControlUI instanceof MultiVideoCtrlLayerUIBase)))
      {
        localObject = (MultiVideoCtrlLayerUIBase)((AVActivity)localObject).mControlUI;
        localStringBuilder = new StringBuilder();
        String str = getUin();
        try
        {
          localStringBuilder.append(paramInt).append(';');
          paramInt = aqiw.getNetworkType(BaseApplicationImpl.getApplication());
          if (paramInt == 1)
          {
            paramInt = 1;
            localStringBuilder.append(paramInt).append(';');
            if (((MultiVideoCtrlLayerUIBase)localObject).aqx != 1) {
              break label290;
            }
          }
          label290:
          for (long l = 0L;; l = 1L)
          {
            localStringBuilder.append(l).append(';');
            localStringBuilder.append(((MultiVideoCtrlLayerUIBase)localObject).md).append(';');
            localStringBuilder.append(((MultiVideoCtrlLayerUIBase)localObject).a.bw());
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "doBlackScreenDataReport questionUin:= " + str + ",rommInfo:=" + localStringBuilder.toString());
            }
            ThreadManager.getSubThreadHandler().post(new GLVideoView.3(this, str, localStringBuilder));
            return;
            if (paramInt == 0)
            {
              paramInt = 0;
              break;
            }
            paramInt = 2;
            break;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception localException) {}
      }
    }
    QLog.d(this.TAG, 2, "doBlackScreenDataReport Exception" + localException.getMessage());
  }
  
  public void G(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 <= 0) || (paramInt3 <= 0))
    {
      if (this.jdField_a_of_type_Iwm != null)
      {
        this.jdField_a_of_type_Iwm.recycle();
        this.jdField_a_of_type_Iwm = null;
      }
      return;
    }
    if (this.jdField_a_of_type_Iwm == null)
    {
      this.jdField_a_of_type_Iwm = new iwm();
      int i = getWidth();
      int j = getHeight();
      this.jdField_a_of_type_Iwm.lr(i);
      this.jdField_a_of_type_Iwm.setViewHeight(j);
    }
    this.jdField_a_of_type_Iwm.E(paramInt1, paramInt2, paramInt3);
  }
  
  public void J(long paramLong, boolean paramBoolean)
  {
    if (this.mMirror != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "setMirror, mMirror[" + this.mMirror + "->" + paramBoolean + "], seq[" + paramLong + "]");
      }
      this.mMirror = paramBoolean;
      super.invalidate();
    }
  }
  
  public Bitmap K()
  {
    Bitmap localBitmap2 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject4 = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.z();
    if (localObject4 == null)
    {
      QLog.d(this.TAG, 2, "getFrameBitmap  get last frame failed");
      return null;
    }
    int i = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.ls();
    int j = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.lt();
    int k = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.lw();
    Bitmap localBitmap1;
    YuvImage localYuvImage;
    if (k == 0)
    {
      localObject1 = a((byte[])localObject4, i, j);
      if (localObject1 == null)
      {
        QLog.d(this.TAG, 2, "getFrameBitmap  I420toARGB failed, type=" + k);
        return null;
      }
      try
      {
        localObject1 = Bitmap.createBitmap((int[])localObject1, i, j, Bitmap.Config.ARGB_8888);
        if (localObject1 != null) {
          break label403;
        }
        QLog.d(this.TAG, 2, "getFrameBitmap createBitmap failed");
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          QLog.d(this.TAG, 2, "getFrameBitmap OOM exception e.stack " + localOutOfMemoryError1.getStackTrace());
          Object localObject2 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d(this.TAG, 2, "getFrameBitmap exception e.stack " + localException.getStackTrace());
          localBitmap1 = null;
        }
      }
    }
    else
    {
      localYuvImage = new YuvImage((byte[])localObject4, 17, i, j, null);
      if (localYuvImage != null)
      {
        localBitmap1 = localBitmap2;
        localObject4 = localObject5;
      }
    }
    label403:
    for (;;)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap1 = localBitmap2;
        localObject4 = localObject5;
        localYuvImage.compressToJpeg(new Rect(0, 0, i, j), 100, localByteArrayOutputStream);
        localBitmap1 = localBitmap2;
        localObject4 = localObject5;
        localBitmap2 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
        localBitmap1 = localBitmap2;
        localObject4 = localBitmap2;
        localByteArrayOutputStream.close();
        localBitmap1 = localBitmap2;
      }
      catch (IOException localIOException)
      {
        QLog.d(this.TAG, 1, "getFrameBitmap YuvImage close failed");
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QLog.d(this.TAG, 1, "getFrameBitmap YuvImage close failed OOM");
        Object localObject3 = localIOException;
        continue;
      }
      QLog.d(this.TAG, 2, "getFrameBitmap nWidth=" + i + ", nHeight=" + j);
      return localBitmap1;
    }
  }
  
  public YUVTexture a()
  {
    return this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture;
  }
  
  public izp a(ipm paramipm)
  {
    int j = 1;
    cv(System.currentTimeMillis());
    int i;
    if (this.WF) {
      if (this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture != null)
      {
        i = 1;
        if (((i & this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.updateCurFrame()) == 0) || (!this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.canRender()) || (this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth() == 0) || (this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight() == 0)) {
          break label139;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.oz = System.currentTimeMillis();
        enableLoading(false);
        if (this.jdField_a_of_type_Iql != null)
        {
          paramipm = this.jdField_a_of_type_Iql.a(paramipm);
          i = this.jdField_a_of_type_Iql.getTextureWidth();
          j = this.jdField_a_of_type_Iql.getTextureHeight();
          this.jdField_a_of_type_Izp.H(paramipm[0], i, j);
          return this.jdField_a_of_type_Izp;
          i = 0;
          break;
          label139:
          i = 0;
          continue;
        }
        int k = paramipm.getWidth();
        int m = paramipm.getHeight();
        i = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
        int i2 = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
        int n = Math.min(i, i2);
        int i1 = Math.max(i, i2);
        if ((!vh()) && (QLog.isDebugVersion())) {
          QLog.d(this.TAG, 1, "read peer ImgWidth:=" + i + ",textureHeight:=" + i2);
        }
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.lr((int)this.mDstRectF.width());
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.setViewHeight((int)this.mDstRectF.height());
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.i(0, 0, i, i2);
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.setTextureSize(i, i2);
        if ((this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || ((this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) && ((this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth() != n) || (this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight() != i1))))
        {
          if (this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
            this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
          }
          this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(true, n, i1, 33984);
        }
        this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        paramipm.save();
        paramipm.setSize(n, i1);
        paramipm.translate(n / 2, i1 / 2, 0.0F);
        paramipm.save();
        i2 = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.lv();
        if (!vh())
        {
          i = 0;
          i2 = (i2 + i + 4) % 4;
          if (i2 % 2 != 0) {
            break label548;
          }
          label449:
          a(paramipm, i);
          paramipm.rotate(i2 * 90, 0.0F, 0.0F, 1.0F);
          if (j == 0) {
            break label553;
          }
          this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramipm, 0, 0, n, i1);
        }
        for (;;)
        {
          paramipm.restore();
          paramipm.restore();
          paramipm.bH(k, m);
          this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Izp.H(this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), n, i1);
          return this.jdField_a_of_type_Izp;
          i = this.avR;
          break;
          label548:
          j = 0;
          break label449;
          label553:
          this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramipm, 0, 0, i1, n);
        }
      }
    }
    if ((this.mLoading) && (this.jdField_c_of_type_Iqk != null))
    {
      paramipm = this.jdField_c_of_type_Iqk.a(paramipm);
      i = this.jdField_c_of_type_Iqk.getSourceWidth();
      j = this.jdField_c_of_type_Iqk.getSourceHeight();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "huanxxiao test you have call this mLoadingTexture width:=" + i);
      }
      this.jdField_a_of_type_Izp.H(paramipm[0], i, j);
      return this.jdField_a_of_type_Izp;
    }
    this.jdField_a_of_type_Izp.H(-1, 0, 0);
    return this.jdField_a_of_type_Izp;
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    Pair localPair = a(paramInt1, paramInt2, super.getWidth(), super.getHeight(), this.avR);
    this.p.set(this.mTransformMatrix);
    this.p.postScale(paramFloat, paramFloat, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    this.p.getValues(this.mMatrixValues);
    float f1 = this.mMatrixValues[0];
    float f2 = this.hI * 1.0F / 1.111111F;
    float f3 = this.hJ;
    if ((f1 <= f2) || (f1 >= f3 * 1.111111F)) {
      return;
    }
    this.mMatrixValues[0] = f1;
    this.mMatrixValues[4] = f1;
    this.mTransformMatrix.setValues(this.mMatrixValues);
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "setScale, scale[" + paramFloat + "->" + f1 + "], x[" + paramInt1 + "->" + localPair.first + "], y[" + paramInt2 + "->" + localPair.second + "], mRotation[" + this.avR + "]");
    }
    super.invalidate();
  }
  
  public float ab()
  {
    return this.hI;
  }
  
  public float ac()
  {
    return this.hJ;
  }
  
  public void an(String paramString, int paramInt)
  {
    setTag(0, paramString);
    setTag(1, Integer.valueOf(paramInt));
  }
  
  protected void apx()
  {
    this.jdField_d_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
  }
  
  public void asT()
  {
    if (this.jdField_a_of_type_Iql != null)
    {
      this.jdField_a_of_type_Iql.recycle();
      this.jdField_a_of_type_Iql = null;
    }
  }
  
  public void asU()
  {
    this.WI = true;
    super.invalidate();
  }
  
  public long bM()
  {
    if ((vh()) && (getVideoSrcType() == 2)) {
      return System.currentTimeMillis();
    }
    return this.oz;
  }
  
  public void bU(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Iql != null)
    {
      this.jdField_c_of_type_Iql.recycle();
      this.jdField_c_of_type_Iql = null;
    }
    this.jdField_c_of_type_Iql = new iql(jll.b(this.mContext, paramInt1));
    this.jdField_c_of_type_Iql.setOpaque(false);
    if (this.jdField_b_of_type_Iql != null)
    {
      this.jdField_b_of_type_Iql.recycle();
      this.jdField_b_of_type_Iql = null;
    }
    this.jdField_b_of_type_Iql = new iql(jll.b(this.mContext, paramInt2));
    this.jdField_b_of_type_Iql.setOpaque(false);
  }
  
  protected void e(ipm paramipm)
  {
    if (!this.WF) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "renderTexture, mNeedRenderVideo is false");
      }
    }
    for (;;)
    {
      k(paramipm);
      m(paramipm);
      l(paramipm);
      n(paramipm);
      return;
      if (this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(this.TAG, 1, "renderTexture, mYuvTexture is null");
        }
      }
      else if (!this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.updateCurFrame())
      {
        QLog.w(this.TAG, 1, "renderTexture, updateCurFrame fail");
      }
      else if (!this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.canRender())
      {
        QLog.w(this.TAG, 1, "renderTexture, can not Render");
      }
      else
      {
        enableLoading(false);
        if ((this.WC) && (this.WM)) {
          j(paramipm);
        } else {
          i(paramipm);
        }
      }
    }
  }
  
  public void enableLoading(boolean paramBoolean)
  {
    if (this.mLoading != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "enableLoading loading: " + paramBoolean + ", mLoading: " + this.mLoading);
      }
      this.mLoading = paramBoolean;
      if (!paramBoolean) {
        break label108;
      }
      if (this.jdField_c_of_type_Iqk == null) {
        this.jdField_c_of_type_Iqk = new iqo(this.mContext, 2130843151);
      }
      localGLRootView = a();
      if (localGLRootView != null) {
        localGLRootView.post(this.bT);
      }
    }
    return;
    label108:
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.removeCallbacks(this.bT);
    }
    this.mLastLoadingTime = 0L;
    this.oy = 0L;
    this.avU = 0;
  }
  
  protected void f(ipm paramipm)
  {
    this.WE = true;
    if (!this.WF) {
      this.WF = false;
    }
    int i = super.getWidth();
    int j = super.getHeight();
    Rect localRect = super.getPaddings();
    int k = i - localRect.left - localRect.right;
    int m = j - localRect.top - localRect.bottom;
    paramipm.translate(-i / 2, -j / 2);
    if (this.WE)
    {
      this.jdField_a_of_type_Ipq.setColor(-9013642);
      if (localRect.left > 0)
      {
        this.jdField_a_of_type_Ipq.setLineWidth(localRect.left);
        paramipm.a(localRect.left / 2, 0.0F, localRect.left / 2, j, this.jdField_a_of_type_Ipq);
      }
      if (localRect.top > 0)
      {
        this.jdField_a_of_type_Ipq.setLineWidth(localRect.top);
        paramipm.a(0.0F, localRect.top / 2, i, localRect.top / 2, this.jdField_a_of_type_Ipq);
      }
      if (localRect.right > 0)
      {
        this.jdField_a_of_type_Ipq.setLineWidth(localRect.right);
        paramipm.a(i - localRect.right / 2, 0.0F, i - localRect.right / 2, j, this.jdField_a_of_type_Ipq);
      }
      if (localRect.bottom > 0)
      {
        this.jdField_a_of_type_Ipq.setLineWidth(localRect.bottom);
        paramipm.a(0.0F, j - localRect.bottom / 2, i, j - localRect.bottom / 2, this.jdField_a_of_type_Ipq);
      }
    }
    paramipm.translate(i / 2, j / 2);
    if (this.WE) {
      if (((!hasVideo()) || (!this.WF)) && (this.jdField_a_of_type_Iqk != null)) {
        this.jdField_a_of_type_Iqk.a(paramipm, 0, 0, k, m);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.WM);
      paramipm.fillRect(0, 0, k, m, this.mBackgroundColor);
      return;
      if (((!hasVideo()) || (!this.WF)) && (this.jdField_a_of_type_Iqk != null))
      {
        this.jdField_a_of_type_Iqk.a(paramipm, 0, 0, i, j);
        return;
      }
    } while (this.WM);
    paramipm.fillRect(0.0F, 0.0F, i, j, this.mBackgroundColor);
  }
  
  public void f(Boolean paramBoolean)
  {
    this.WE = paramBoolean.booleanValue();
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.jdField_d_of_type_Iqk != null)
      {
        this.jdField_d_of_type_Iqk.recycle();
        this.jdField_d_of_type_Iqk = null;
      }
      if (this.jdField_a_of_type_Iqp != null)
      {
        this.jdField_a_of_type_Iqp.recycle();
        this.jdField_a_of_type_Iqp = null;
      }
      if (this.jdField_c_of_type_Iqk != null)
      {
        this.jdField_c_of_type_Iqk.recycle();
        this.jdField_c_of_type_Iqk = null;
      }
      if (this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture != null)
      {
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.recycle();
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture = null;
      }
      if (this.jdField_a_of_type_Iql != null)
      {
        this.jdField_a_of_type_Iql.recycle();
        this.jdField_a_of_type_Iql = null;
      }
      if (this.jdField_a_of_type_Iwm != null)
      {
        this.jdField_a_of_type_Iwm.recycle();
        this.jdField_a_of_type_Iwm = null;
      }
      if (this.e != null)
      {
        this.e.recycle();
        this.e = null;
      }
      this.bT = null;
      this.mLoading = false;
      this.mShowText = false;
      this.mText = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void flush(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture != null) {}
    try
    {
      this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.flush(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void g(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = a(paramInt1, paramInt2, 0, 0, this.avR);
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "setTranslation, isEnd[" + paramBoolean + "], x[" + paramInt1 + "->" + ((Pair)localObject).first + "], y[" + paramInt2 + "->" + ((Pair)localObject).second + "], mRotation[" + this.avR + "]");
    }
    this.mTransformMatrix.getValues(this.mMatrixValues);
    float f1 = this.mMatrixValues[2] + ((Integer)((Pair)localObject).first).intValue();
    float f2 = this.mMatrixValues[5] + ((Integer)((Pair)localObject).second).intValue();
    this.mMatrixValues[2] = f1;
    this.mMatrixValues[5] = f2;
    this.mTransformMatrix.setValues(this.mMatrixValues);
    if (paramBoolean)
    {
      localObject = new RectF();
      this.mTransformMatrix.mapRect((RectF)localObject, this.u);
      if ((((RectF)localObject).left >= this.t.left) || (((RectF)localObject).right >= this.t.right)) {
        break label406;
      }
      if (((RectF)localObject).width() <= this.t.width()) {
        break label385;
      }
      f1 = this.t.right - ((RectF)localObject).right + f1;
    }
    label385:
    label406:
    label716:
    for (;;)
    {
      if ((((RectF)localObject).top < this.t.top) && (((RectF)localObject).bottom < this.t.bottom)) {
        if (((RectF)localObject).height() > this.t.height()) {
          f2 = this.t.bottom - ((RectF)localObject).bottom + f2;
        }
      }
      for (;;)
      {
        this.mMatrixValues[2] = f1;
        this.mMatrixValues[5] = f2;
        this.mTransformMatrix.setValues(this.mMatrixValues);
        super.invalidate();
        return;
        f1 = this.t.centerX() - ((RectF)localObject).centerX() + f1;
        break;
        if ((((RectF)localObject).left > this.t.left) && (((RectF)localObject).right > this.t.right))
        {
          if (((RectF)localObject).width() > this.t.width())
          {
            f1 = this.t.left - ((RectF)localObject).left + f1;
            break;
          }
          f1 = this.t.centerX() - ((RectF)localObject).centerX() + f1;
          break;
        }
        if ((((RectF)localObject).left <= this.t.left) || (((RectF)localObject).right >= this.t.right)) {
          break label716;
        }
        f1 = this.t.centerX() - ((RectF)localObject).centerX() + f1;
        break;
        f2 = this.t.centerY() - ((RectF)localObject).centerY() + f2;
        continue;
        if ((((RectF)localObject).top > this.t.top) && (((RectF)localObject).bottom > this.t.bottom))
        {
          if (((RectF)localObject).height() > this.t.height()) {
            f2 = this.t.top - ((RectF)localObject).top + f2;
          } else {
            f2 = this.t.centerY() - ((RectF)localObject).centerY() + f2;
          }
        }
        else if ((((RectF)localObject).top > this.t.top) && (((RectF)localObject).bottom < this.t.bottom)) {
          f2 = this.t.centerY() - ((RectF)localObject).centerY() + f2;
        }
      }
    }
  }
  
  public int getMaxLength()
  {
    return this.mMaxLength;
  }
  
  public int getRotation()
  {
    return this.avR;
  }
  
  public float getScale()
  {
    this.mTransformMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[0];
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.mScaleType;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public int getTextColor()
  {
    return this.mTextColor;
  }
  
  public float getTextSize()
  {
    return this.mTextSize;
  }
  
  public String getUin()
  {
    return (String)getTag(0);
  }
  
  public int getVideoSrcType()
  {
    Integer localInteger = (Integer)getTag(1);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public boolean hasVideo()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture != null) {
        bool = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.canRender();
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public String hl()
  {
    return "TAG[" + this.TAG + "], uin[" + getUin() + "], VST[" + getVideoSrcType() + "], LRT[" + bM() + "], Drc[" + (int)this.mDstRectF.width() + ", " + (int)this.mDstRectF.height() + "], Src[" + (int)this.u.width() + ", " + (int)this.u.height() + "], " + this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.hb();
  }
  
  protected void i(ipm paramipm)
  {
    if (this.oy != 0L)
    {
      this.oy = 0L;
      this.avU = 0;
    }
    Object localObject = super.getPaddings();
    this.oz = System.currentTimeMillis();
    int n = super.getWidth();
    int i1 = super.getHeight();
    int k = n - ((Rect)localObject).left - ((Rect)localObject).right;
    int j = i1 - ((Rect)localObject).top - ((Rect)localObject).bottom;
    boolean bool3 = vh();
    int i2 = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.lv();
    int i;
    int i3;
    float f2;
    float f5;
    float f6;
    int m;
    float f3;
    float f4;
    if ((this.WM) && (!bool3))
    {
      i = 0;
      i3 = (i2 + i + 4) % 4;
      f2 = ((Rect)localObject).left;
      f1 = ((Rect)localObject).top;
      f5 = k;
      f6 = j;
      if (i3 % 2 == 0) {
        break label1174;
      }
      m = (int)k;
      k = j;
      j = m;
      f3 = f1;
      f4 = f6;
    }
    for (float f1 = f5;; f1 = f6)
    {
      this.t.set(f3, f2, k + f3, j + f2);
      float f10 = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
      float f11 = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
      float f12 = f10 / f11;
      f5 = f4 / f1;
      boolean bool1;
      label245:
      int i4;
      label307:
      int i5;
      label400:
      label601:
      String str;
      boolean bool4;
      if ((!this.WM) && (cv(i3)))
      {
        bool1 = true;
        float f9 = f1;
        float f8 = f4;
        float f7 = f2;
        f6 = f3;
        if (bool1)
        {
          if (i3 % 2 != 0) {
            break label949;
          }
          f5 = f4 / f12;
          if (f5 <= f1) {
            break label934;
          }
          f5 = f1 * f12;
          f3 += (f4 - f5) / 2.0F;
          f4 = f5;
          f5 = f4 / f1;
          f6 = f3;
          f7 = f2;
          f8 = f4;
          f9 = f1;
        }
        this.u.set(f6, f7, f8 + f6, f9 + f7);
        this.mTransformMatrix.mapRect(this.mDstRectF, this.u);
        if (f12 <= f5) {
          break label1004;
        }
        f1 = f11 * f5;
        f2 = (f10 - f1) / 2.0F;
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.i((int)f2, 0, (int)f1, (int)f11);
        if (!this.WK) {
          this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.i(0, 0, (int)f10, (int)f11);
        }
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.setTextureSize((int)f10, (int)f11);
        paramipm.save(2);
        a(paramipm, i);
        paramipm.rotate(i3 * 90, 0.0F, 0.0F, 1.0F);
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.lr((int)this.mDstRectF.width());
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.setViewHeight((int)this.mDstRectF.height());
        i4 = (int)(this.mDstRectF.left - (this.u.width() - this.mDstRectF.width()) / 2.0F - this.u.left);
        i5 = (int)(this.mDstRectF.top - (this.u.height() - this.mDstRectF.height()) / 2.0F - this.u.top);
        if (this.jdField_a_of_type_Iql == null) {
          break label1035;
        }
        this.jdField_a_of_type_Iql.a(paramipm, i4, i5, (int)this.mDstRectF.width(), (int)this.mDstRectF.height());
        if ((this.WC) && (this.WD))
        {
          this.WD = false;
          QLog.d(this.TAG, 1, "PC ScreenShare FirstFrameInfo:=<ImgWidth:=" + f10 + ",ImgHeight:=" + f11 + ",YUVImgAngle:=" + i2 + ",mAVSDKNotifyRotationType:=" + this.avS + ",phoneRotateAngle:=" + this.avT + ",renderRotation:=" + i3 + ",mDstRectF.width():=" + this.mDstRectF.width() + ",mDstRectF.height():=" + this.mDstRectF.height() + ",uiWidth:=" + n + ",uiHeight:=" + i1 + ">");
        }
        if (QLog.isColorLevel())
        {
          if (this.jdField_a_of_type_Izm$a == null) {
            this.jdField_a_of_type_Izm$a = new izm.a();
          }
          localObject = this.jdField_a_of_type_Izm$a;
          str = this.TAG;
          bool4 = this.mMirror;
          if (this.jdField_a_of_type_Iql == null) {
            break label1168;
          }
        }
      }
      label1035:
      label1168:
      for (boolean bool2 = true;; bool2 = false)
      {
        ((izm.a)localObject).a(str, bool3, bool4, bool2, bool1, i4, i5, (int)this.mDstRectF.width(), (int)this.mDstRectF.width(), (int)this.u.width(), (int)this.u.width(), (int)f10, (int)f11, this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getSourceWidth(), this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getSourceHeight(), f12, f5, i, i2, this.avR, i3, this.mScaleType.ordinal());
        paramipm.restore();
        return;
        i = this.avR;
        break;
        bool1 = false;
        break label245;
        label934:
        f2 += (f1 - f5) / 2.0F;
        f1 = f5;
        break label307;
        label949:
        f5 = f1 * f12;
        if (f5 > f4)
        {
          f5 = f4 / f12;
          f2 += (f1 - f5) / 2.0F;
          f1 = f5;
          break label307;
        }
        f3 += (f4 - f5) / 2.0F;
        f4 = f5;
        break label307;
        label1004:
        f1 = f10 / f5;
        f2 = (f11 - f1) / 2.0F;
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.i(0, (int)f2, (int)f10, (int)f1);
        break label400;
        if ((this.jdField_a_of_type_Iwm != null) && (this.jdField_a_of_type_Iwm.vP()))
        {
          paramipm.rotate((4 - i2) * 90, 0.0F, 0.0F, 1.0F);
          j = (int)this.mDstRectF.width();
          k = (int)this.mDstRectF.height();
          if (i2 % 2 == 0) {}
          for (;;)
          {
            this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.apw();
            this.jdField_a_of_type_Iwm.a(paramipm, i4, i5, j, k);
            break;
            m = j;
            j = k;
            k = m;
          }
        }
        this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramipm, i4, i5, (int)this.mDstRectF.width(), (int)this.mDstRectF.height());
        break label601;
      }
      label1174:
      f4 = f5;
      f3 = f2;
      f2 = f1;
    }
  }
  
  public boolean isMirror()
  {
    return this.mMirror;
  }
  
  public void j(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (this.jdField_a_of_type_Iql != null)
    {
      this.jdField_a_of_type_Iql.recycle();
      this.jdField_a_of_type_Iql = null;
    }
    this.jdField_a_of_type_Iql = new iql(paramBitmap);
  }
  
  protected void j(ipm paramipm)
  {
    int i = 0;
    int j = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
    int k = this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
    Rect localRect = super.getPaddings();
    int m = super.getWidth();
    int n = super.getHeight();
    int i1 = jdm.cB(k) / 2;
    int i2 = (j - i1) / 2;
    this.u.set(i2, 0, i1 + i2, 0 + k);
    this.mDstRectF.set(0.0F, localRect.top, m - localRect.right, n - localRect.bottom);
    this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.i((int)this.u.left, (int)this.u.top, (int)this.u.width(), (int)this.u.height());
    this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.setTextureSize(j, k);
    this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.lr((int)this.mDstRectF.width());
    this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.setViewHeight((int)this.mDstRectF.height());
    paramipm.save(2);
    if (this.WM)
    {
      a(paramipm, i);
      if ((this.jdField_a_of_type_Iwm == null) || (!this.jdField_a_of_type_Iwm.vP())) {
        break label398;
      }
      this.jdField_a_of_type_Iwm.a(paramipm, (int)this.mDstRectF.left, (int)this.mDstRectF.top, (int)this.mDstRectF.width(), (int)this.mDstRectF.height());
    }
    for (;;)
    {
      paramipm.restore();
      igd.aJ(this.TAG, "renderDoubleScreenOfPC:|" + getUin() + "|" + getVideoSrcType() + "|" + j + "|" + k + "|" + m + "|" + n + "|" + this.u.toString() + "|" + this.mDstRectF.toString());
      return;
      i = this.avR;
      break;
      label398:
      this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramipm, (int)this.mDstRectF.left, (int)this.mDstRectF.top, (int)this.mDstRectF.width(), (int)this.mDstRectF.height());
    }
  }
  
  public void jH(boolean paramBoolean)
  {
    if (this.WL != paramBoolean) {
      this.WL = paramBoolean;
    }
  }
  
  public void jI(boolean paramBoolean)
  {
    this.WM = paramBoolean;
  }
  
  public void jJ(boolean paramBoolean)
  {
    this.WN = paramBoolean;
  }
  
  public void jK(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "setIsPC, isPC[" + this.WC + "->" + paramBoolean + "]");
    }
    this.WC = paramBoolean;
    if (this.WC) {
      this.WD = true;
    }
    this.mTransformMatrix.reset();
    super.invalidate();
  }
  
  public void jL(boolean paramBoolean)
  {
    if (this.WG != paramBoolean)
    {
      this.WG = paramBoolean;
      super.invalidate();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setTextInBottom inBottom: " + paramBoolean);
      }
    }
  }
  
  public void jM(boolean paramBoolean)
  {
    if (this.WH != paramBoolean)
    {
      this.WH = paramBoolean;
      super.invalidate();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setTextInBottomCenter inBottom: " + paramBoolean);
      }
    }
  }
  
  public void jN(boolean paramBoolean)
  {
    if (this.mShowText != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "showText, show[" + this.mShowText + "->" + paramBoolean + "]");
      }
      this.mShowText = paramBoolean;
      super.invalidate();
    }
  }
  
  public void jO(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setNeedRenderVideo bRender: " + paramBoolean + ", mNeedRenderVideo: " + this.WF);
    }
    this.WF = paramBoolean;
    super.invalidate();
  }
  
  public void jP(boolean paramBoolean)
  {
    this.Uf = paramBoolean;
    if (paramBoolean) {
      this.awf = this.mContext.getResources().getDimensionPixelSize(2131298331);
    }
  }
  
  public void jQ(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "setCameraIsBindData, uin[" + getUin() + "], VideoSrcType[" + getVideoSrcType() + "], isBind[" + paramBoolean + "]");
      }
      this.jdField_b_of_type_ComTencentAvOpenglTextureYUVTexture.iG(paramBoolean);
    }
  }
  
  protected void k(ipm paramipm)
  {
    int i;
    int j;
    int m;
    int k;
    if ((this.mLoading) && (this.jdField_c_of_type_Iqk != null))
    {
      this.mLoadingAngle %= 360;
      i = super.getWidth();
      j = super.getHeight();
      m = this.jdField_c_of_type_Iqk.getSourceWidth();
      k = this.jdField_c_of_type_Iqk.getSourceHeight();
      if (m <= i) {
        break label201;
      }
    }
    for (;;)
    {
      if (k > j) {}
      for (;;)
      {
        paramipm.save(2);
        this.jdField_c_of_type_Iqk.a(paramipm, 0, 0, i, j);
        paramipm.restore();
        long l = System.currentTimeMillis();
        if (l - this.mLastLoadingTime >= 80L)
        {
          this.mLastLoadingTime = l;
          this.mLoadingAngle += 8;
        }
        if (this.oy == 0L)
        {
          this.oy = l;
          this.avU = 0;
        }
        while ((l - this.oy < 5000L) || (this.avU >= 2)) {
          return;
        }
        this.oy = l;
        mu(this.avU);
        this.avU += 1;
        return;
        j = k;
      }
      label201:
      i = m;
    }
  }
  
  public void kc(String paramString)
  {
    this.mSelfUin = paramString;
  }
  
  protected void l(ipm paramipm)
  {
    int i;
    int j;
    int k;
    int m;
    int i1;
    int n;
    if (this.mShowText)
    {
      Rect localRect = super.getPaddings();
      if (this.jdField_d_of_type_Iqk != null)
      {
        i = super.getWidth();
        super.getHeight();
        j = localRect.left;
        k = localRect.right;
        m = localRect.left;
        m = localRect.bottom;
        this.jdField_d_of_type_Iqk.a(paramipm, 0, 0, i - j - k, 36);
      }
      if (this.WI)
      {
        if (this.jdField_a_of_type_Iqp == null) {
          this.jdField_a_of_type_Iqp = new iqp();
        }
        this.jdField_a_of_type_Iqp.recycle();
        this.jdField_a_of_type_Iqp.setText(this.mText);
        this.jdField_a_of_type_Iqp.setTextSize(this.mTextSize);
        this.jdField_a_of_type_Iqp.setTextColor(this.mTextColor);
        this.jdField_a_of_type_Iqp.setMaxLength(this.mMaxLength);
        this.jdField_a_of_type_Iqp.setMaxWidth(super.getWidth() - this.awa);
        this.jdField_a_of_type_Iqp.apv();
        this.WI = false;
      }
      if ((this.jdField_a_of_type_Iqp != null) && (!TextUtils.isEmpty(this.mText)))
      {
        i1 = super.getWidth();
        n = super.getHeight();
        k = this.jdField_a_of_type_Iqp.getSourceWidth();
        m = this.jdField_a_of_type_Iqp.getSourceHeight();
        if (!this.WG) {
          break label312;
        }
        i = this.awa;
        j = n - this.jdField_a_of_type_Iqp.getMeasureHeight() - this.avZ;
      }
    }
    for (;;)
    {
      paramipm.save(2);
      i1 = (k - i1) / 2;
      n = (m - n) / 2;
      paramipm.translate(i1, n);
      this.jdField_a_of_type_Iqp.a(paramipm, i, j, k, m);
      paramipm.restore();
      return;
      label312:
      if (this.Uf)
      {
        i = this.awf;
        j = this.awf;
      }
      else if (this.WH)
      {
        i = (i1 - k) / 2;
        j = (n - m) / 2;
      }
      else
      {
        i = wja.dp2px(16.0F, this.mContext.getResources());
        j = this.awe;
      }
    }
  }
  
  protected void m(ipm paramipm)
  {
    if ((this.WL) && (this.jdField_a_of_type_Iqm != null)) {
      this.jdField_a_of_type_Iqm.a(paramipm, 0, 0, getWidth(), getHeight());
    }
  }
  
  public void mr(int paramInt)
  {
    if (this.avV != paramInt) {
      this.jdField_a_of_type_Iqm = new iqm(paramInt);
    }
  }
  
  public void ms(int paramInt)
  {
    if ((this.avW == paramInt) || ((this.avW == 2) && (paramInt == 0))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 1, "refreshMicState, uin[" + getUin() + ", state[" + this.avW + "->" + paramInt + "]");
    }
    this.avW = paramInt;
    invalidate();
  }
  
  public void mt(int paramInt)
  {
    this.awe = paramInt;
  }
  
  protected void n(ipm paramipm)
  {
    iql localiql;
    int k;
    int m;
    int n;
    int i1;
    int i;
    if ((this.mShowText) && (this.jdField_a_of_type_Iqp != null))
    {
      localiql = null;
      if (this.avW != 2) {
        break label168;
      }
      localiql = this.jdField_c_of_type_Iql;
      if (localiql != null)
      {
        k = super.getWidth();
        m = super.getHeight();
        n = localiql.getSourceWidth();
        i1 = localiql.getSourceHeight();
        if (!this.WG) {
          break label185;
        }
        i = k - n - this.avZ;
      }
    }
    for (int j = m - this.jdField_a_of_type_Iqp.getMeasureHeight() - this.avZ + this.jdField_a_of_type_Iqp.lu() - i1 + (i1 - this.jdField_a_of_type_Iqp.lu()) / 2;; j = this.awe + this.jdField_a_of_type_Iqp.lu() - i1 + Math.abs((i1 - this.jdField_a_of_type_Iqp.lu()) / 2))
    {
      paramipm.save(3);
      paramipm.translate((n - k) / 2, (i1 - m) / 2);
      localiql.a(paramipm, i, j, n, i1);
      paramipm.restore();
      return;
      label168:
      if (this.avW != 1) {
        break;
      }
      localiql = this.jdField_b_of_type_Iql;
      break;
      label185:
      i = wja.dp2px(16.0F, this.mContext.getResources()) + this.jdField_a_of_type_Iqp.getSourceWidth() + this.awa;
    }
  }
  
  protected void onDetachFromRoot()
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.removeCallbacks(this.bT);
    }
    super.onDetachFromRoot();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    try
    {
      if (this.jdField_a_of_type_Iwm != null)
      {
        this.jdField_a_of_type_Iwm.lr(paramInt1);
        this.jdField_a_of_type_Iwm.setViewHeight(paramInt2);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, "onLayout e = " + localException);
    }
  }
  
  /* Error */
  Bitmap q(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_1
    //   8: ifnull +69 -> 77
    //   11: aload_1
    //   12: aload_1
    //   13: invokevirtual 1135	android/graphics/Bitmap:getWidth	()I
    //   16: iconst_4
    //   17: idiv
    //   18: aload_1
    //   19: invokevirtual 1136	android/graphics/Bitmap:getHeight	()I
    //   22: iconst_4
    //   23: idiv
    //   24: iconst_1
    //   25: invokestatic 1140	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   28: astore_2
    //   29: new 1142	android/graphics/Canvas
    //   32: dup
    //   33: invokespecial 1143	android/graphics/Canvas:<init>	()V
    //   36: astore_3
    //   37: aload_3
    //   38: aload_2
    //   39: invokevirtual 1146	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   42: aload_3
    //   43: ldc_w 1148
    //   46: invokestatic 1154	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   49: getstatic 1160	android/graphics/PorterDuff$Mode:LIGHTEN	Landroid/graphics/PorterDuff$Mode;
    //   52: invokevirtual 1164	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   55: aload_2
    //   56: bipush 20
    //   58: invokestatic 1170	aqmp:fastblur	(Landroid/graphics/Bitmap;I)V
    //   61: aload_2
    //   62: aload_1
    //   63: invokevirtual 1135	android/graphics/Bitmap:getWidth	()I
    //   66: aload_1
    //   67: invokevirtual 1136	android/graphics/Bitmap:getHeight	()I
    //   70: iconst_1
    //   71: invokestatic 1140	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   74: astore_1
    //   75: aload_1
    //   76: astore_2
    //   77: aload_2
    //   78: areturn
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 178	izm:TAG	Ljava/lang/String;
    //   86: iconst_2
    //   87: new 163	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 1172
    //   97: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_2
    //   101: invokevirtual 491	java/lang/OutOfMemoryError:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   104: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_1
    //   114: areturn
    //   115: astore_2
    //   116: aload 4
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 178	izm:TAG	Ljava/lang/String;
    //   123: iconst_2
    //   124: new 163	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 1174
    //   134: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_2
    //   138: invokevirtual 497	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   141: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_1
    //   151: areturn
    //   152: astore_3
    //   153: aload_2
    //   154: astore_1
    //   155: aload_3
    //   156: astore_2
    //   157: goto -38 -> 119
    //   160: astore_3
    //   161: aload_2
    //   162: astore_1
    //   163: aload_3
    //   164: astore_2
    //   165: goto -83 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	izm
    //   0	168	1	paramBitmap	Bitmap
    //   6	72	2	localBitmap	Bitmap
    //   79	22	2	localOutOfMemoryError1	OutOfMemoryError
    //   115	39	2	localException1	Exception
    //   156	9	2	localObject1	Object
    //   1	80	3	localCanvas	android.graphics.Canvas
    //   152	4	3	localException2	Exception
    //   160	4	3	localOutOfMemoryError2	OutOfMemoryError
    //   3	114	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	29	79	java/lang/OutOfMemoryError
    //   11	29	115	java/lang/Exception
    //   29	75	152	java/lang/Exception
    //   29	75	160	java/lang/OutOfMemoryError
  }
  
  public void setActivityContext(Context paramContext)
  {
    this.bD = new WeakReference(paramContext);
  }
  
  public void setMaxLength(int paramInt)
  {
    if ((paramInt > 0) && (this.mMaxLength != paramInt))
    {
      this.mMaxLength = paramInt;
      this.WI = true;
      super.invalidate();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setMaxLength maxLength: " + paramInt);
      }
    }
  }
  
  public void setRotation(int paramInt)
  {
    int i = cx(paramInt);
    this.avT = paramInt;
    if ((this.avR != i) && (!vh()))
    {
      this.avR = i;
      this.mTransformMatrix.reset();
      if (getVisibility() == 0) {
        super.invalidate();
      }
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setScaleType scaleType: " + paramScaleType);
    }
    ImageView.ScaleType localScaleType = paramScaleType;
    if (paramScaleType == null) {
      localScaleType = ImageView.ScaleType.CENTER_INSIDE;
    }
    if (this.mScaleType != localScaleType)
    {
      this.mScaleType = localScaleType;
      super.invalidate();
    }
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.equals(paramString, this.mText))
    {
      this.mText = paramString;
      this.WI = true;
      super.invalidate();
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "setText, text[" + this.mText + "->" + paramString + "]");
      }
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mTextColor != paramInt)
    {
      this.mTextColor = paramInt;
      this.WI = true;
      super.invalidate();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setTextColor textColor: 0x" + Integer.toHexString(paramInt).toUpperCase());
      }
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    if (this.mTextSize != paramFloat)
    {
      this.mTextSize = paramFloat;
      this.WI = true;
      super.invalidate();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setTextSize textSize: " + paramFloat);
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 1)
    {
      this.mLastLoadingTime = 0L;
      this.oy = 0L;
      this.avU = 0;
    }
  }
  
  public boolean vh()
  {
    return this.mSelfUin.equals(getUin());
  }
  
  public boolean we()
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      if (this.jdField_a_of_type_Iql != null) {
        return false;
      }
      Bitmap localBitmap = K();
      bool1 = bool2;
      if (localBitmap != null)
      {
        localBitmap = q(localBitmap);
        if (localBitmap == null)
        {
          QLog.d(this.TAG, 2, "doStartRenderFouceGround BlurBitmap failed");
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 2, "doStartRenderFouceGround exception e.stack " + localException.getStackTrace());
        return false;
        j(localException);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean wf()
  {
    return this.WC;
  }
  
  public boolean wg()
  {
    return this.WG;
  }
  
  public boolean wh()
  {
    return this.mShowText;
  }
  
  public boolean wi()
  {
    return this.WF;
  }
  
  public boolean wj()
  {
    return this.Uf;
  }
  
  static class a
  {
    boolean WO = false;
    boolean WP = false;
    boolean WQ = false;
    int awg = 0;
    int awh = 0;
    int awi = 0;
    int awj = 0;
    int awk = 0;
    int awl = 0;
    int awm = 0;
    int awn = 0;
    int awo;
    int awp;
    int awq = 0;
    boolean mirror = false;
    int px = 0;
    int py = 0;
    int rotation = 0;
    int scaleType = 0;
    
    void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat1, float paramFloat2, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15)
    {
      if (!QLog.isColorLevel()) {}
      while ((this.WP == paramBoolean3) && (this.WQ == paramBoolean4) && (this.WO == paramBoolean1) && (this.mirror == paramBoolean2) && (this.px == paramInt1) && (this.py == paramInt2) && (this.awg == paramInt3) && (this.awh == paramInt4) && (this.awi == paramInt5) && (this.awj == paramInt6) && (this.awk == paramInt7) && (this.awl == paramInt8) && (this.awm == paramInt9) && (this.awn == paramInt10) && (this.awo == paramInt11) && (this.awp == paramInt12) && (this.awq == paramInt13) && (this.rotation == paramInt14)) {
        return;
      }
      this.WO = paramBoolean1;
      this.mirror = paramBoolean2;
      this.WP = paramBoolean3;
      this.WQ = paramBoolean4;
      this.px = paramInt1;
      this.py = paramInt2;
      this.awg = paramInt3;
      this.awh = paramInt4;
      this.awi = paramInt5;
      this.awj = paramInt6;
      this.awk = paramInt7;
      this.awl = paramInt8;
      this.awm = paramInt9;
      this.awn = paramInt10;
      this.awo = paramInt11;
      this.awp = paramInt12;
      this.awq = paramInt13;
      this.rotation = paramInt14;
      this.scaleType = paramInt15;
      QLog.w(paramString, 1, "rendView, self[" + paramBoolean1 + "], mirror[" + paramBoolean2 + "], bForceGround[" + paramBoolean3 + "], pt[" + paramInt1 + ", " + paramInt2 + "], dst[" + paramInt3 + ", " + paramInt4 + "], src[" + paramInt5 + ", " + paramInt6 + "], t1[" + paramInt7 + ", " + paramInt8 + "], t2[" + paramInt9 + ", " + paramInt10 + "], sR[" + paramFloat1 + "], tR[" + paramFloat2 + "], border[" + paramBoolean4 + "], sAngle[" + paramInt11 + "], yuvAngle[" + paramInt12 + "], mRotation[" + paramInt13 + "], rotation[" + paramInt14 + "], scaleType[" + paramInt15 + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izm
 * JD-Core Version:    0.7.0.1
 */