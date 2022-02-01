import android.content.Context;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback;
import com.tencent.mobileqq.ar.ARRenderModel.GeneralAR3DRenderable.1;
import com.tencent.qphone.base.util.QLog;

public class addl
  implements adcy, ARNativeBridge.ActionCallback
{
  private addm a;
  private adbc jdField_b_of_type_Adbc;
  private ARNativeBridge jdField_b_of_type_ComTencentMobileqqArARNativeBridge;
  public boolean bLW = false;
  private adda c;
  private int cCK;
  private volatile int cCL = 1;
  private Context mContext;
  private volatile int mCurrentState = 1;
  private int mHeight;
  private int mWidth;
  
  public addl(adda paramadda, addm paramaddm)
  {
    this.c = paramadda;
    this.a = paramaddm;
    this.mContext = this.c.n();
    this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)this.c.m(paramaddm.cCE));
  }
  
  public int Bx()
  {
    if (this.a != null) {
      return this.a.cCF;
    }
    return 0;
  }
  
  public void a(addf.a parama)
  {
    a((float[])parama.r("TARGET_SIZE"), (float[])parama.r("POSE"), (float[])parama.r("CAMERA_MATRIX"), (float[])parama.r("CAMERA_POSITION"));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((this.a != null) && (this.a.cCF == 1))
    {
      this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.cCK, paramArrayOfFloat3, paramArrayOfFloat4);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.cCK, paramArrayOfFloat2, paramArrayOfFloat4);
  }
  
  public boolean adF()
  {
    return true;
  }
  
  public void callback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "fNativeDoActionCallback action=" + paramInt1 + ", params=" + paramString1 + ", callbackId=" + paramInt2 + ", result=" + paramString2);
    }
    if (this.c == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      this.c.hg(3, 0);
      return;
    }
    this.c.hg(2, 0);
  }
  
  public boolean canRender()
  {
    return (this.mCurrentState == 9) && (this.cCK != 0);
  }
  
  public int getType()
  {
    if (this.a != null) {
      return this.a.cCE;
    }
    return 0;
  }
  
  public String getUniqueKey()
  {
    return this.a.key;
  }
  
  public void init()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "init");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, " + this);
    }
    if (this.mCurrentState == 9)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, queueEvent, " + this);
      }
      if ((this.c != null) && (this.bLW == true))
      {
        this.c.hg(1, 0);
        this.bLW = false;
      }
      if (this.c != null)
      {
        this.c.Gr(this.a.key);
        QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, remove hsRender here, " + this);
      }
      if (this.mCurrentState == 9) {
        setState(10);
      }
    }
  }
  
  public void onUpdate()
  {
    if (this.mCurrentState == 11)
    {
      int i = this.cCL + 1;
      this.cCL = i;
      if (i >= 2) {
        setState(9);
      }
    }
  }
  
  public void setState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "setState, mCurState=" + this.mCurrentState + ", new State=" + paramInt + ", arTarget=");
    }
    this.mCurrentState = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 11: 
    default: 
      return;
    case 2: 
      this.cCK = this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
      this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.nativeCreateEngine(this.cCK, this.a.bsg, this.mContext, this.mContext.getAssets(), this.a.bsh, this.mWidth, this.mHeight);
      this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(this);
      setState(7);
      return;
    case 6: 
      this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.nativeonSurfaceChanged(this.cCK, this.mWidth, this.mHeight);
      return;
    case 7: 
      this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.cCK);
      this.cCL = 0;
      setState(11);
      return;
    case 9: 
      this.c.Z(new GeneralAR3DRenderable.1(this));
      return;
    case 8: 
      this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.cCK);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.cCK);
    this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
    this.cCK = 0;
    if (this.jdField_b_of_type_Adbc != null)
    {
      this.jdField_b_of_type_Adbc.cPE();
      this.jdField_b_of_type_Adbc.destroy();
    }
    this.mCurrentState = 1;
  }
  
  public void setWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "start");
    }
    if (1 == this.mCurrentState)
    {
      this.jdField_b_of_type_Adbc = new adbc(this.a.bsi, "");
      setState(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addl
 * JD-Core Version:    0.7.0.1
 */