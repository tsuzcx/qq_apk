import android.annotation.TargetApi;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class addf
{
  private static int MATRIX_SIZE = 16;
  public long Sm;
  public long Sn;
  public long So;
  private addf.a a = new addf.a();
  private float[] bA = new float[MATRIX_SIZE];
  private boolean bLD;
  private boolean bLE;
  private boolean bLF;
  private boolean bLG;
  private boolean bLH;
  private boolean bLI;
  private boolean bLJ;
  private boolean bLK;
  private float[] be = new float[2];
  private float[] bf = new float[MATRIX_SIZE];
  private float[] bg = new float[MATRIX_SIZE];
  private float[] bh = new float[2];
  private float[] bi = new float[MATRIX_SIZE];
  private float[] bj = new float[MATRIX_SIZE];
  private float[] bk = new float[MATRIX_SIZE];
  private float[] bl = new float[2];
  private float[] bm = new float[MATRIX_SIZE];
  private float[] bn = new float[MATRIX_SIZE];
  private float[] bo = new float[MATRIX_SIZE];
  float[] bp = new float[MATRIX_SIZE];
  float[] bq = new float[MATRIX_SIZE];
  float[] br = new float[MATRIX_SIZE];
  float[] bs = new float[MATRIX_SIZE];
  private float[] bt = new float[MATRIX_SIZE];
  private float[] bu = new float[MATRIX_SIZE];
  private float[] bv = new float[MATRIX_SIZE];
  private float[] bw = new float[MATRIX_SIZE];
  private float[] bx = { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
  public float[] by;
  float[] bz = new float[4];
  private int cCG = 0;
  private int cCH = -1;
  private boolean mIsStarted;
  private ReentrantLock mLock = new ReentrantLock();
  private float[] mMatrixProjection = new float[MATRIX_SIZE];
  
  public addf()
  {
    Matrix.setRotateM(this.bv, 0, -90.0F, 0.0F, 0.0F, 1.0F);
    Matrix.setRotateM(this.bw, 0, 90.0F, 0.0F, 0.0F, 1.0F);
    reset();
  }
  
  public static boolean adG()
  {
    return false;
  }
  
  private boolean b(float[] paramArrayOfFloat)
  {
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      if (paramArrayOfFloat[i] != 0.0F) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public addf.a a(int paramInt1, int paramInt2)
  {
    if (this.bLI)
    {
      localObject1 = new float[MATRIX_SIZE];
      arrayOfFloat1 = new float[MATRIX_SIZE];
      arrayOfFloat2 = new float[MATRIX_SIZE];
      Matrix.setIdentityM(arrayOfFloat1, 0);
      Matrix.setIdentityM(arrayOfFloat2, 0);
      Matrix.setIdentityM((float[])localObject1, 0);
      localObject2 = new addf.a();
      ((addf.a)localObject2).x("TARGET_SIZE", new float[] { 1.0F, 1.0F });
      ((addf.a)localObject2).x("CAMERA_MATRIX", arrayOfFloat2);
      ((addf.a)localObject2).x("CAMERA_POSITION", localObject1);
      ((addf.a)localObject2).x("POSE", arrayOfFloat1);
      return localObject2;
    }
    if (paramInt1 == 100)
    {
      this.cCG = 1;
      localObject1 = new float[MATRIX_SIZE];
      arrayOfFloat1 = new float[MATRIX_SIZE];
      arrayOfFloat2 = new float[MATRIX_SIZE];
      Matrix.setIdentityM(arrayOfFloat1, 0);
      Matrix.setIdentityM(arrayOfFloat2, 0);
      Matrix.setIdentityM((float[])localObject1, 0);
      localObject2 = new addf.a();
      ((addf.a)localObject2).x("TARGET_SIZE", new float[] { 1.0F, 1.0F });
      ((addf.a)localObject2).x("CAMERA_MATRIX", arrayOfFloat2);
      ((addf.a)localObject2).x("CAMERA_POSITION", localObject1);
      ((addf.a)localObject2).x("POSE", arrayOfFloat1);
      ((addf.a)localObject2).bB = this.by;
      return localObject2;
    }
    if (paramInt1 == 8)
    {
      localObject1 = new addf.a();
      this.cCG = 1;
      arrayOfFloat1 = new float[MATRIX_SIZE];
      arrayOfFloat2 = new float[MATRIX_SIZE];
      localObject2 = new float[MATRIX_SIZE];
      Matrix.setIdentityM(arrayOfFloat2, 0);
      Matrix.setIdentityM((float[])localObject2, 0);
      Matrix.setIdentityM(arrayOfFloat1, 0);
      ((addf.a)localObject1).x("TARGET_SIZE", new float[] { 1.0F, 1.0F });
      ((addf.a)localObject1).x("CAMERA_MATRIX", localObject2);
      ((addf.a)localObject1).x("CAMERA_POSITION", arrayOfFloat1);
      ((addf.a)localObject1).x("POSE", arrayOfFloat2);
      ((addf.a)localObject1).bB = this.by;
      return localObject1;
    }
    if (!this.mIsStarted) {
      return null;
    }
    if ((paramInt2 == 0) && (!this.bLD)) {
      return null;
    }
    this.bLH = true;
    this.cCG = paramInt2;
    addf.a locala;
    if ((this.bLJ) && (((paramInt2 == 0) && (!this.bLF)) || (paramInt2 == 2) || ((paramInt2 == 1) && (!this.bLG))))
    {
      localObject1 = new float[2];
      arrayOfFloat1 = new float[MATRIX_SIZE];
      arrayOfFloat2 = new float[MATRIX_SIZE];
      localObject2 = new float[MATRIX_SIZE];
      System.arraycopy(this.bl, 0, localObject1, 0, 2);
      System.arraycopy(this.bm, 0, arrayOfFloat1, 0, MATRIX_SIZE);
      System.arraycopy(this.bn, 0, arrayOfFloat2, 0, MATRIX_SIZE);
      System.arraycopy(this.bo, 0, localObject2, 0, MATRIX_SIZE);
      locala = new addf.a();
      locala.x("TARGET_SIZE", localObject1);
      locala.x("CAMERA_MATRIX", localObject2);
      locala.x("CAMERA_POSITION", arrayOfFloat1);
      locala.x("POSE", arrayOfFloat2);
      this.bLH = false;
      return locala;
    }
    this.bLF = false;
    this.bLG = false;
    Object localObject1 = new float[2];
    float[] arrayOfFloat1 = new float[MATRIX_SIZE];
    float[] arrayOfFloat2 = new float[MATRIX_SIZE];
    Object localObject2 = new float[MATRIX_SIZE];
    if (paramInt1 == 0) {
      if (b(this.bf))
      {
        System.arraycopy(this.be, 0, localObject1, 0, 2);
        System.arraycopy(this.mMatrixProjection, 0, arrayOfFloat1, 0, MATRIX_SIZE);
        System.arraycopy(this.bx, 0, arrayOfFloat2, 0, MATRIX_SIZE);
        System.arraycopy(this.bx, 0, localObject2, 0, MATRIX_SIZE);
      }
    }
    for (;;)
    {
      System.arraycopy(localObject1, 0, this.bl, 0, 2);
      System.arraycopy(arrayOfFloat1, 0, this.bm, 0, MATRIX_SIZE);
      System.arraycopy(arrayOfFloat2, 0, this.bn, 0, MATRIX_SIZE);
      System.arraycopy(localObject2, 0, this.bo, 0, MATRIX_SIZE);
      this.bLJ = true;
      locala = new addf.a();
      locala.x("TARGET_SIZE", localObject1);
      locala.x("CAMERA_MATRIX", localObject2);
      locala.x("CAMERA_POSITION", arrayOfFloat1);
      locala.x("POSE", arrayOfFloat2);
      this.bLH = false;
      return locala;
      if (paramInt2 == 0)
      {
        System.arraycopy(this.be, 0, localObject1, 0, 2);
        System.arraycopy(this.mMatrixProjection, 0, arrayOfFloat1, 0, MATRIX_SIZE);
        this.mLock.lock();
        Matrix.invertM(this.bq, 0, this.bf, 0);
        this.mLock.unlock();
        System.arraycopy(this.bq, 0, arrayOfFloat2, 0, MATRIX_SIZE);
        System.arraycopy(this.bq, 0, localObject2, 0, MATRIX_SIZE);
        System.arraycopy(localObject2, 0, this.bg, 0, MATRIX_SIZE);
      }
      else if (paramInt2 == 1)
      {
        System.arraycopy(this.bh, 0, this.be, 0, 2);
        System.arraycopy(this.bi, 0, this.mMatrixProjection, 0, MATRIX_SIZE);
        System.arraycopy(this.bj, 0, this.bf, 0, MATRIX_SIZE);
        System.arraycopy(this.bk, 0, this.bg, 0, MATRIX_SIZE);
        System.arraycopy(this.be, 0, localObject1, 0, 2);
        System.arraycopy(this.mMatrixProjection, 0, arrayOfFloat1, 0, MATRIX_SIZE);
        Matrix.invertM(this.bq, 0, this.bf, 0);
        System.arraycopy(this.bq, 0, arrayOfFloat2, 0, MATRIX_SIZE);
        Matrix.rotateM(this.bq, 0, 90.0F, 0.0F, 0.0F, 1.0F);
        Matrix.transposeM(this.bp, 0, this.bq, 0);
        this.mLock.lock();
        Matrix.multiplyMM(this.br, 0, this.bu, 0, this.bp, 0);
        this.mLock.unlock();
        Matrix.transposeM(this.bs, 0, this.br, 0);
        Matrix.rotateM(this.bs, 0, -90.0F, 0.0F, 0.0F, 1.0F);
        System.arraycopy(this.bs, 0, localObject2, 0, MATRIX_SIZE);
        System.arraycopy(localObject2, 0, this.bg, 0, MATRIX_SIZE);
      }
      else if (paramInt2 == 2)
      {
        System.arraycopy(this.bh, 0, this.be, 0, 2);
        System.arraycopy(this.bi, 0, this.mMatrixProjection, 0, MATRIX_SIZE);
        System.arraycopy(this.bj, 0, this.bf, 0, MATRIX_SIZE);
        System.arraycopy(this.bk, 0, this.bg, 0, MATRIX_SIZE);
        System.arraycopy(this.be, 0, localObject1, 0, 2);
        System.arraycopy(this.mMatrixProjection, 0, arrayOfFloat1, 0, MATRIX_SIZE);
        this.mLock.lock();
        Matrix.invertM(this.bq, 0, this.bf, 0);
        this.mLock.unlock();
        System.arraycopy(this.bq, 0, arrayOfFloat2, 0, MATRIX_SIZE);
        System.arraycopy(this.bq, 0, localObject2, 0, MATRIX_SIZE);
        System.arraycopy(localObject2, 0, this.bg, 0, MATRIX_SIZE);
        continue;
        if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4))
        {
          if (paramInt2 == 0)
          {
            System.arraycopy(this.be, 0, localObject1, 0, 2);
            System.arraycopy(this.mMatrixProjection, 0, arrayOfFloat1, 0, MATRIX_SIZE);
            this.mLock.lock();
            System.arraycopy(this.bf, 0, arrayOfFloat2, 0, MATRIX_SIZE);
            this.mLock.unlock();
            if (this.cCH == 1) {}
            for (;;)
            {
              System.arraycopy(arrayOfFloat2, 0, localObject2, 0, MATRIX_SIZE);
              System.arraycopy(localObject2, 0, this.bg, 0, MATRIX_SIZE);
              break;
              Matrix.translateM(arrayOfFloat2, 0, localObject1[0] / 2.0F, localObject1[1] / 2.0F, 0.0F);
            }
          }
          if (paramInt2 == 1)
          {
            System.arraycopy(this.bh, 0, this.be, 0, 2);
            System.arraycopy(this.bi, 0, this.mMatrixProjection, 0, MATRIX_SIZE);
            System.arraycopy(this.bj, 0, this.bf, 0, MATRIX_SIZE);
            System.arraycopy(this.bk, 0, this.bg, 0, MATRIX_SIZE);
            System.arraycopy(this.be, 0, localObject1, 0, 2);
            System.arraycopy(this.mMatrixProjection, 0, arrayOfFloat1, 0, MATRIX_SIZE);
            System.arraycopy(this.bf, 0, arrayOfFloat2, 0, MATRIX_SIZE);
            Matrix.translateM(arrayOfFloat2, 0, localObject1[0] / 2.0F, localObject1[1] / 2.0F, 0.0F);
            Matrix.multiplyMM((float[])localObject2, 0, this.bv, 0, arrayOfFloat2, 0);
            this.mLock.lock();
            Matrix.multiplyMM((float[])localObject2, 0, this.bu, 0, (float[])localObject2, 0);
            this.mLock.unlock();
            Matrix.multiplyMM((float[])localObject2, 0, this.bw, 0, (float[])localObject2, 0);
            System.arraycopy(localObject2, 0, this.bg, 0, MATRIX_SIZE);
          }
          else if (paramInt2 == 2)
          {
            Matrix.setIdentityM(arrayOfFloat2, 0);
            Matrix.setIdentityM((float[])localObject2, 0);
            Matrix.setIdentityM(arrayOfFloat1, 0);
            localObject1[0] = 1.0F;
            localObject1[1] = 1.0F;
          }
        }
        else
        {
          Matrix.setIdentityM(arrayOfFloat2, 0);
          Matrix.setIdentityM((float[])localObject2, 0);
          Matrix.setIdentityM(arrayOfFloat1, 0);
          localObject1[0] = 1.0F;
          localObject1[1] = 1.0F;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, ArCloudConfigInfo.a parama)
  {
    if (((paramInt1 != 1) && (paramInt1 != 2)) || ((paramInt2 != 0) && (paramInt2 != 2) && (paramInt2 != 3) && (paramInt2 != 4))) {
      return;
    }
    this.bh = new float[2];
    this.bi = new float[MATRIX_SIZE];
    this.bj = new float[MATRIX_SIZE];
    this.bk = new float[MATRIX_SIZE];
    float f1;
    label173:
    float f2;
    label195:
    float f3;
    if (paramInt2 == 0) {
      if ((parama.width == 0) || (parama.height == 0))
      {
        this.bh[0] = adky.screenWidth;
        this.bh[1] = adky.screenHeight;
        parama = new float[MATRIX_SIZE];
        Matrix.setIdentityM(parama, 0);
        Matrix.perspectiveM(parama, 0, 45.0F, 1.0F * adky.screenHeight / adky.screenWidth, 100.0F, 8000.0F);
        float[] arrayOfFloat = new float[16];
        Matrix.setRotateM(arrayOfFloat, 0, 270.0F, 0.0F, 0.0F, 1.0F);
        Matrix.multiplyMM(this.bi, 0, arrayOfFloat, 0, parama, 0);
        if (paramInt2 != 0) {
          break label660;
        }
        f1 = 1.25F;
        if (this.bh[0] <= adky.screenWidth) {
          break label666;
        }
        f2 = this.bh[0];
        if (this.bh[0] == 0.0F) {
          break label675;
        }
        f3 = this.bh[1] / this.bh[0] / (1.0F * adky.screenHeight / adky.screenWidth);
        label233:
        if ((f3 <= 1.0F) || (this.bh[1] <= adky.screenHeight)) {
          break label681;
        }
        f1 *= f3;
      }
    }
    label660:
    label666:
    label675:
    label681:
    for (;;)
    {
      QLog.i("AREngine_ARRenerArumentManager", 1, "genProjAndPose. mNoFeatureTrackModeTargetSize[0] = " + this.bh[0] + ", mNoFeatureTrackModeTargetSize[1] = " + this.bh[1] + ", scale = " + f1 + ", zSize = " + f2 + ", ratio = " + f3);
      parama = new float[MATRIX_SIZE];
      Matrix.setIdentityM(parama, 0);
      Matrix.translateM(parama, 0, this.bh[1] / 2.0F, -this.bh[0] / 2.0F, -f2 / 2.0F * 2.414214F * f1);
      Matrix.rotateM(parama, 0, 90.0F, 0.0F, 0.0F, 1.0F);
      System.arraycopy(parama, 0, this.bj, 0, MATRIX_SIZE);
      System.arraycopy(this.bj, 0, this.bk, 0, MATRIX_SIZE);
      System.arraycopy(this.bh, 0, this.be, 0, 2);
      System.arraycopy(this.bi, 0, this.mMatrixProjection, 0, MATRIX_SIZE);
      this.mLock.lock();
      System.arraycopy(this.bj, 0, this.bf, 0, MATRIX_SIZE);
      this.mLock.unlock();
      System.arraycopy(this.bk, 0, this.bg, 0, MATRIX_SIZE);
      return;
      this.bh[0] = parama.width;
      this.bh[1] = parama.height;
      break;
      if ((paramInt2 == 2) || (paramInt2 == 3))
      {
        if ((parama.width == 0) || (parama.height == 0))
        {
          this.bh[0] = adky.screenWidth;
          this.bh[1] = adky.screenHeight;
          break;
        }
        this.bh[0] = parama.width;
        this.bh[1] = parama.height;
        break;
      }
      if (paramInt2 != 4) {
        break;
      }
      if ((parama.width == 0) || (parama.height == 0))
      {
        this.bh[0] = adky.screenWidth;
        this.bh[1] = adky.screenHeight;
        break;
      }
      this.bh[0] = parama.width;
      this.bh[1] = parama.height;
      break;
      f1 = 1.0F;
      break label173;
      f2 = adky.screenWidth;
      break label195;
      f3 = 1.0F;
      break label233;
    }
  }
  
  public void a(addd paramaddd)
  {
    if (paramaddd == null) {
      return;
    }
    this.bLD = true;
    this.bLF = true;
    paramaddd = (addb)paramaddd;
    this.cCH = paramaddd.markerType;
    this.be[0] = paramaddd.sY;
    this.be[1] = paramaddd.sZ;
    System.arraycopy(paramaddd.projectionMatrix, 0, this.mMatrixProjection, 0, MATRIX_SIZE);
    this.mLock.lock();
    System.arraycopy(paramaddd.bd, 0, this.bf, 0, MATRIX_SIZE);
    this.mLock.unlock();
    System.arraycopy(paramaddd.bd, 0, this.bg, 0, MATRIX_SIZE);
  }
  
  public void a(boolean paramBoolean, addc paramaddc)
  {
    QLog.i("AREngine_ARRenerArumentManager", 1, "start. trackMode = " + paramaddc.cCF + ", arType = " + paramaddc.cCE + ", isObjectAnim = " + paramBoolean);
    this.bLI = paramBoolean;
    this.cCG = paramaddc.cCF;
    this.cCH = paramaddc.markerType;
    this.bLJ = false;
    if ((this.bLI) || (paramaddc.cCE == 100) || (paramaddc.cCE == 8))
    {
      this.mIsStarted = true;
      return;
    }
    Object localObject;
    if (paramaddc.cCE == 0)
    {
      localObject = (addm)paramaddc;
      a(this.cCG, paramaddc.cCE, ((addm)localObject).a);
    }
    for (;;)
    {
      this.mIsStarted = true;
      return;
      if ((paramaddc.cCE == 2) || (paramaddc.cCE == 3))
      {
        localObject = (addv)paramaddc;
        a(this.cCG, paramaddc.cCE, ((addv)localObject).a);
      }
      else if (paramaddc.cCE == 4)
      {
        localObject = (addy)paramaddc;
        a(this.cCG, paramaddc.cCE, ((addy)localObject).a);
      }
    }
  }
  
  @TargetApi(9)
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.bz[0] = paramArrayOfFloat2[1];
    this.bz[1] = paramArrayOfFloat2[2];
    this.bz[2] = paramArrayOfFloat2[3];
    this.bz[3] = paramArrayOfFloat2[0];
    SensorManager.getRotationMatrixFromVector(paramArrayOfFloat1, this.bz);
  }
  
  public void c(float[] paramArrayOfFloat)
  {
    for (;;)
    {
      try
      {
        if (this.cCG != 4)
        {
          int i = this.cCG;
          if (i != 1) {
            return;
          }
        }
        if (((this.cCG == 4) && (adG())) || (this.bLH)) {
          continue;
        }
        if (!this.bLK)
        {
          this.bLK = true;
          Matrix.setIdentityM(this.bt, 0);
          a(this.bA, paramArrayOfFloat);
          Matrix.invertM(this.bt, 0, this.bA, 0);
          this.bLE = false;
          this.bLG = false;
          continue;
        }
        this.by = paramArrayOfFloat;
      }
      finally {}
      this.bLE = true;
      this.bLG = true;
      a(this.bA, paramArrayOfFloat);
      this.mLock.lock();
      Matrix.multiplyMM(this.bu, 0, this.bA, 0, this.bt, 0);
      this.mLock.unlock();
    }
  }
  
  public void reset()
  {
    this.mLock.lock();
    this.be = new float[2];
    this.mMatrixProjection = new float[MATRIX_SIZE];
    this.bf = new float[MATRIX_SIZE];
    this.bg = new float[MATRIX_SIZE];
    this.bl = new float[2];
    this.bm = new float[MATRIX_SIZE];
    this.bn = new float[MATRIX_SIZE];
    this.bo = new float[MATRIX_SIZE];
    this.bLD = false;
    this.bLE = false;
    this.bLF = false;
    this.bLG = false;
    this.bLH = false;
    this.bLI = false;
    this.mIsStarted = false;
    this.bLJ = false;
    this.bp = new float[MATRIX_SIZE];
    this.bq = new float[MATRIX_SIZE];
    this.br = new float[MATRIX_SIZE];
    this.bs = new float[MATRIX_SIZE];
    this.bt = new float[MATRIX_SIZE];
    this.bu = new float[MATRIX_SIZE];
    this.bLK = false;
    float[] arrayOfFloat1 = new float[MATRIX_SIZE];
    float[] arrayOfFloat2 = new float[MATRIX_SIZE];
    float[] arrayOfFloat3 = new float[MATRIX_SIZE];
    Matrix.setIdentityM(arrayOfFloat1, 0);
    Matrix.setIdentityM(arrayOfFloat2, 0);
    Matrix.setIdentityM(arrayOfFloat3, 0);
    this.a.x("TARGET_SIZE", new float[] { 1.0F, 1.0F });
    this.a.x("POSE", arrayOfFloat1);
    this.a.x("CAMERA_MATRIX", arrayOfFloat2);
    this.a.x("CAMERA_POSITION", arrayOfFloat3);
    this.mLock.unlock();
  }
  
  public static class a
  {
    public float[] bB;
    private HashMap<String, Object> jt = new HashMap();
    
    public Object r(String paramString)
    {
      return this.jt.get(paramString);
    }
    
    public void x(String paramString, Object paramObject)
    {
      this.jt.put(paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addf
 * JD-Core Version:    0.7.0.1
 */