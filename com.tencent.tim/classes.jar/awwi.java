import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.d;

public abstract class awwi
{
  protected awwg.a a;
  private AECameraGLSurfaceView.d a;
  private long ahV;
  protected volatile boolean cAv;
  protected int cameraHeight;
  protected int cameraWidth;
  protected float[] dV = new float[16];
  protected double dn;
  private boolean dtk;
  private boolean dtl;
  protected int eDr;
  protected int eDs;
  protected int eDt;
  protected int eDu;
  protected int eDv;
  protected final int eDw = 1080;
  protected SurfaceTexture h;
  protected final float[] mTransformMatrix = new float[16];
  protected double mViewAspectRatio;
  protected int orientation = 90;
  protected int previewHeight;
  protected int previewWidth;
  private long py = ((Long)spp.a().getValue("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
  protected int[] textures = new int[2];
  protected int videoHeight;
  protected int videoWidth;
  
  public abstract void XP(boolean paramBoolean);
  
  public SurfaceTexture a()
  {
    if (this.dtk) {
      return this.h;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.eDv = arrayOfInt[0];
    this.h = new SurfaceTexture(this.eDv);
    this.dtk = true;
    return this.h;
  }
  
  public void a(boolean paramBoolean, int paramInt, awwg.a parama)
  {
    this.cAv = paramBoolean;
    this.orientation = paramInt;
    this.jdField_a_of_type_Awwg$a = parama;
  }
  
  public void adu(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$d != null)
    {
      long l = System.currentTimeMillis();
      if (l - this.ahV >= this.py)
      {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$d.w(GlUtil.captureFrame(paramInt, this.previewWidth, this.previewHeight, 0));
        this.ahV = l;
      }
    }
  }
  
  public abstract int[] b(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void br(float paramFloat);
  
  public void clear()
  {
    if (this.dtk)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.eDv;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.h.release();
      this.h = null;
      this.dtk = false;
    }
    if (this.dtl)
    {
      eGU();
      this.dtl = false;
    }
  }
  
  protected abstract void eGP();
  
  protected abstract void eGU();
  
  public abstract void eGW();
  
  public void g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mViewAspectRatio = (paramInt1 / paramInt2);
    if ((paramInt3 > 0) && (paramInt4 > 0))
    {
      this.cameraWidth = paramInt3;
      this.cameraHeight = paramInt4;
      this.dn = (this.cameraWidth / this.cameraHeight);
    }
    this.previewWidth = paramInt5;
    this.previewHeight = ((int)(this.previewWidth / this.mViewAspectRatio));
    this.eDt = paramInt5;
    this.eDu = ((int)(this.eDt / this.mViewAspectRatio));
    this.eDr = 1080;
    this.eDs = ((int)(this.eDr / this.mViewAspectRatio));
  }
  
  public void g(float[] paramArrayOfFloat)
  {
    try
    {
      if (this.h != null)
      {
        this.h.updateTexImage();
        this.h.getTransformMatrix(this.mTransformMatrix);
        System.arraycopy(paramArrayOfFloat, 0, this.dV, 0, 16);
      }
      return;
    }
    catch (Exception paramArrayOfFloat)
    {
      paramArrayOfFloat.printStackTrace();
    }
  }
  
  public void initFilters()
  {
    if (!this.dtl)
    {
      eGP();
      this.dtl = true;
    }
  }
  
  public boolean isInited()
  {
    return (this.dtk) && (this.dtl);
  }
  
  public void setCaptureRequest(AECameraGLSurfaceView.d paramd)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$d = paramd;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwi
 * JD-Core Version:    0.7.0.1
 */