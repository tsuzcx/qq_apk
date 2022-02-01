import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.util.Size;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRenderModel.CameraRendererable.1;
import com.tencent.mobileqq.ar.DrawView2;
import com.tencent.qphone.base.util.QLog;
import java.nio.FloatBuffer;
import java.util.Random;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(14)
public class addk
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private static String TAG = "AREngine_CameraRendererable";
  private static int screenHeight;
  private static int screenWidth;
  private long Sq;
  private long Sr = -1L;
  addf jdField_a_of_type_Addf;
  addj jdField_a_of_type_Addj = new addj();
  private Size jdField_a_of_type_AndroidUtilSize;
  private ly jdField_a_of_type_Ly = new ly();
  private addk.a[] jdField_a_of_type_ArrayOfAddk$a = new addk.a[300];
  private adda b;
  private float[] bF = new float[16];
  private float[] bG = new float[16];
  private float[] bH = new float[600];
  private boolean bLT;
  public boolean bLU = true;
  private Paint by;
  private int cCY;
  private int cCZ;
  private int cDa;
  private int cDb;
  private int cDc;
  private int cDd;
  private int cDe;
  private int cDf;
  private int cDg;
  private int cDh;
  private int cDi;
  private int cDj;
  private int cDk;
  private int cDl;
  private int cDm;
  private int cDn;
  private int cDo;
  private int cDp = 1;
  private int cDq = 255;
  private int cDr;
  private Bitmap eR;
  Runnable fV = new CameraRendererable.1(this);
  private FloatBuffer h;
  private Canvas m;
  Handler mHandler = new Handler();
  private SurfaceTexture mSurfaceTexture;
  private Random random;
  private float tc = 1.0F;
  private float te;
  private int texture = -1;
  private float tf = 1.0F;
  private float tg;
  private float th;
  
  public addk(adda paramadda)
  {
    this.b = paramadda;
    this.jdField_a_of_type_Addf = paramadda.a();
  }
  
  public int Bz()
  {
    return this.jdField_a_of_type_Addj.getTextureId();
  }
  
  public void FX(boolean paramBoolean)
  {
    this.bLT = paramBoolean;
  }
  
  public void KJ(int paramInt)
  {
    this.cDp = 2;
    this.texture = paramInt;
    this.bLU = true;
  }
  
  public void M(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    screenWidth = paramInt3;
    screenHeight = paramInt4;
    float f4 = screenWidth / screenHeight;
    float f5 = paramInt2 / paramInt1;
    float f3 = 1.0F;
    float f2 = 1.0F;
    DrawView2.screenHeight = screenHeight;
    DrawView2.screenWidth = screenWidth;
    DrawView2.previewHeight = paramInt1 / 2;
    DrawView2.previewWidth = paramInt2 / 2;
    float f1;
    if (f4 < f5)
    {
      f1 = screenHeight * f5 / screenWidth;
      DrawView2.scaleX = f1;
      if (QLog.isColorLevel())
      {
        QLog.d(TAG, 2, "[debugRay] setPreviewFrameSize  height = " + paramInt1 + ",width = " + paramInt2 + ",screenWidth = " + screenWidth + ",screenHeight = " + screenHeight + ",scaleX = " + f1 + ",scaleY = " + f2);
        QLog.d(TAG, 2, "[debugRay] setPreviewFrameSize  DrawView2.scaleX = " + DrawView2.scaleX + ",DrawView2.scaleY = " + DrawView2.scaleY);
      }
      Matrix.setIdentityM(this.bF, 0);
      Matrix.scaleM(this.bF, 0, f1, f2, 1.0F);
      this.tc = f2;
      this.tg = paramInt2;
      this.th = paramInt1;
      if (paramInt2 <= paramInt1) {
        break label464;
      }
      paramInt3 = paramInt1;
      label252:
      if (paramInt2 <= paramInt1) {
        break label469;
      }
      paramInt1 = paramInt2;
    }
    label464:
    label469:
    for (;;)
    {
      if (paramInt3 > 0)
      {
        paramInt2 = paramInt1;
        if (paramInt1 > 0) {}
      }
      else
      {
        paramInt3 = 720;
        paramInt2 = 1280;
      }
      paramInt3 = (int)(paramInt3 * 0.42D);
      paramInt4 = (int)(paramInt2 * 0.6D * 0.25D * 0.42D);
      paramInt2 = paramInt4;
      paramInt1 = paramInt3;
      if (paramInt3 < 240)
      {
        f1 = paramInt4 * 1.0F / paramInt3;
        paramInt1 = 240;
        paramInt2 = (int)(f1 * 'ð');
      }
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(TAG, 2, new Object[] { "create noiseBmp width:", Integer.valueOf(paramInt1), " height:", Integer.valueOf(paramInt2) });
        }
        this.eR = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ALPHA_8);
        this.m = new Canvas(this.eR);
        this.by = new Paint();
        this.by.setColor(-1);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.eR = null;
        localOutOfMemoryError.printStackTrace();
        QLog.d(TAG, 1, "create noiseBmp error ", localOutOfMemoryError);
        return;
      }
      catch (Exception localException)
      {
        this.eR = null;
        localException.printStackTrace();
        QLog.d(TAG, 1, "create noiseBmp error2 ", localException);
      }
      f1 = f3;
      if (f4 <= f5) {
        break;
      }
      f2 = screenWidth / (screenHeight * f5);
      DrawView2.scaleY = f2;
      f1 = f3;
      break;
      paramInt3 = paramInt2;
      break label252;
    }
  }
  
  public void a(int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    this.cDp = 1;
    this.jdField_a_of_type_Addf.Sm = 0L;
    this.jdField_a_of_type_Addf.So = 0L;
    this.jdField_a_of_type_Addf.Sn = 0L;
    if ((this.mSurfaceTexture != null) && (this.mSurfaceTexture != paramSurfaceTexture))
    {
      this.mSurfaceTexture.setOnFrameAvailableListener(null);
      if (!Build.MODEL.equalsIgnoreCase("NX512J")) {
        this.mSurfaceTexture.release();
      }
      this.texture = 0;
      this.mSurfaceTexture = null;
    }
    this.texture = paramInt;
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.mSurfaceTexture != null) {
      this.mSurfaceTexture.setOnFrameAvailableListener(this);
    }
    this.bLU = true;
  }
  
  @TargetApi(21)
  public void a(FloatBuffer paramFloatBuffer, Size paramSize)
  {
    this.h = paramFloatBuffer;
    if ((this.jdField_a_of_type_AndroidUtilSize == null) && (this.jdField_a_of_type_Addj != null))
    {
      this.jdField_a_of_type_AndroidUtilSize = paramSize;
      this.jdField_a_of_type_Addj.L(paramSize.getHeight(), paramSize.getWidth(), adky.screenWidth, adky.screenHeight);
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, FloatBuffer paramFloatBuffer1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, FloatBuffer paramFloatBuffer2, int paramInt3)
  {
    if (this.bLT)
    {
      if (this.Sr == -1L) {
        this.Sr = System.currentTimeMillis();
      }
      long l = System.currentTimeMillis() - this.Sr;
      if ((float)l < 4000.0F)
      {
        float f = (float)l * 1.0F / 4000.0F;
        this.te = (f * (f * f));
        this.te *= 1.35F;
      }
    }
    for (this.cDr = 1;; this.cDr = 0)
    {
      GLES20.glUniform1f(this.cDe, this.tg);
      GLES20.glUniform1f(this.cDf, this.th);
      GLES20.glUniform1f(this.cDg, this.te);
      GLES20.glUniform1f(this.cDh, this.tf);
      GLES20.glUniformMatrix4fv(this.cDa, 1, false, paramArrayOfFloat1, 0);
      GLES20.glUniformMatrix4fv(this.cDb, 1, false, paramArrayOfFloat2, 0);
      GLES20.glEnableVertexAttribArray(this.cCZ);
      GLES20.glVertexAttribPointer(this.cCZ, paramInt1, 5126, false, paramInt2, paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(this.cDc);
      GLES20.glVertexAttribPointer(this.cDc, 2, 5126, false, paramInt3, paramFloatBuffer2);
      return;
      this.te = 0.0F;
      this.Sr = System.currentTimeMillis();
      break;
      this.te = 0.0F;
      this.Sr = -1L;
    }
  }
  
  public void aD(float paramFloat)
  {
    this.tf = paramFloat;
  }
  
  public boolean adH()
  {
    return this.bLT;
  }
  
  protected void bindTexture(int paramInt)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.cDm);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.cDn);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.cCY, 0);
    GLES20.glUniform1i(this.cDi, 1);
    GLES20.glUniform1i(this.cDj, 2);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.cDo);
    cQB();
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.cDk, 3);
    if (this.eR == null) {
      this.cDr = 0;
    }
    GLES20.glUniform1i(this.cDl, this.cDr);
  }
  
  protected void cQA()
  {
    this.cCY = GLES20.glGetUniformLocation(this.cDd, "uTexture");
    this.cCZ = GLES20.glGetAttribLocation(this.cDd, "aPosition");
    this.cDa = GLES20.glGetUniformLocation(this.cDd, "uMVPMatrix");
    this.cDb = GLES20.glGetUniformLocation(this.cDd, "uTexMatrix");
    this.cDc = GLES20.glGetAttribLocation(this.cDd, "aTextureCoord");
    this.cDe = GLES20.glGetUniformLocation(this.cDd, "cameraVideoWidth");
    this.cDf = GLES20.glGetUniformLocation(this.cDd, "cameraVideoHeight");
    this.cDg = GLES20.glGetUniformLocation(this.cDd, "cameraEdgeStart");
    this.cDh = GLES20.glGetUniformLocation(this.cDd, "cameraEdgeEnd");
    this.cDi = GLES20.glGetUniformLocation(this.cDd, "cameraScanLineTexture");
    this.cDj = GLES20.glGetUniformLocation(this.cDd, "cameraScanNetTexture");
    this.cDk = GLES20.glGetUniformLocation(this.cDd, "cameraScanNoiseTexture");
    this.cDl = GLES20.glGetUniformLocation(this.cDd, "noiseMode");
    Object localObject = new int[3];
    GLES20.glGenTextures(3, (int[])localObject, 0);
    this.cDm = localObject[0];
    this.cDn = localObject[1];
    this.cDo = localObject[2];
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "textureLightId:" + this.cDm + "   textureNetId:" + this.cDn + "   textureNoiseId:" + this.cDo);
    }
    GLES20.glBindTexture(3553, this.cDm);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      localObject = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130845783, (BitmapFactory.Options)localObject);
      if (localObject != null)
      {
        GLUtils.texImage2D(3553, 0, (Bitmap)localObject, 0);
        ((Bitmap)localObject).recycle();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        localOutOfMemoryError1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getGLSLValues", localOutOfMemoryError1);
        }
      }
    }
    GLES20.glBindTexture(3553, this.cDn);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      localObject = BitmapFactory.decodeResource(this.b.n().getResources(), 2130845784, (BitmapFactory.Options)localObject);
      if (localObject != null)
      {
        GLUtils.texImage2D(3553, 0, (Bitmap)localObject, 0);
        ((Bitmap)localObject).recycle();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      for (;;)
      {
        localOutOfMemoryError2.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getGLSLValues 2 ", localOutOfMemoryError2);
        }
      }
    }
    GLES20.glBindTexture(3553, this.cDo);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
  }
  
  public void cQB()
  {
    this.Sq += 1L;
    if ((this.eR == null) || (this.cDr == 0) || (this.Sq % 3L != 1L)) {
      return;
    }
    if (this.random == null) {
      this.random = new Random();
    }
    System.currentTimeMillis();
    int i1 = this.eR.getWidth();
    int i2 = this.eR.getHeight();
    int i3 = this.cDq;
    int j = 0;
    int i = 0;
    float f1 = 1.0F / i2;
    float f2 = 5.0F / i2;
    int n = 0;
    addk.a locala2;
    label184:
    addk.a locala1;
    int k;
    if (n < 300)
    {
      locala2 = this.jdField_a_of_type_ArrayOfAddk$a[n];
      if ((locala2 != null) && (!locala2.bLV))
      {
        if (this.random.nextFloat() > 0.7F - locala2.y * 0.35F - Math.abs(locala2.x * 0.3F - 0.15F)) {
          locala2.bLV = true;
        }
      }
      else
      {
        if (locala2 != null)
        {
          locala1 = locala2;
          k = j;
          if (!locala2.bLV) {
            break label370;
          }
        }
        if (j <= i3) {
          break label281;
        }
      }
    }
    for (;;)
    {
      n += 1;
      break;
      float f3 = this.random.nextFloat();
      float f4 = locala2.y;
      locala2.y = (f3 * 0.3F + 0.2F * locala2.y + f2 + f4);
      if (locala2.y <= 1.0D) {
        break label184;
      }
      locala2.bLV = true;
      break label184;
      label281:
      locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new addk.a();
        this.jdField_a_of_type_ArrayOfAddk$a[n] = locala1;
      }
      f3 = this.random.nextFloat();
      if (f3 < 0.4D) {
        locala1.x = (f3 * 2.35F + 0.02F);
      }
      for (;;)
      {
        locala1.y = (this.random.nextFloat() * 0.05F + f1);
        locala1.bLV = false;
        k = j + 1;
        label370:
        if ((locala1 == null) || (locala1.bLV) || (locala1.y >= 1.0D)) {
          break label542;
        }
        this.bH[(i * 2)] = (this.jdField_a_of_type_ArrayOfAddk$a[n].x * i1);
        this.bH[(i * 2 + 1)] = (this.jdField_a_of_type_ArrayOfAddk$a[n].y * i2);
        i += 1;
        j = k;
        break;
        if (f3 > 0.6F) {
          locala1.x = ((1.0F - f3) * 2.35F + 0.02F);
        }
      }
      this.m.drawColor(-16777216, PorterDuff.Mode.CLEAR);
      this.by.setStrokeWidth(1.0F);
      this.by.setColor(-1);
      this.m.drawPoints(this.bH, 0, i, this.by);
      GLUtils.texImage2D(3553, 0, this.eR, 0);
      return;
      label542:
      j = k;
    }
  }
  
  protected void cQC()
  {
    GLES20.glDisableVertexAttribArray(this.cCZ);
    GLES20.glDisableVertexAttribArray(this.cDc);
  }
  
  protected void cQD()
  {
    GLES20.glBindTexture(36197, 0);
  }
  
  protected void cQE()
  {
    GLES20.glUseProgram(0);
  }
  
  public void destroy()
  {
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.setOnFrameAvailableListener(null);
      this.mSurfaceTexture.release();
      this.texture = 0;
      this.mSurfaceTexture = null;
    }
    this.texture = -1;
    this.jdField_a_of_type_AndroidUtilSize = null;
    this.bLU = false;
  }
  
  protected void hh(int paramInt1, int paramInt2)
  {
    if ((this.tg <= 0.0F) || (this.th <= 0.0F)) {
      return;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glDrawArrays(5, paramInt1, paramInt2);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (((this.texture == -1) && (this.cDp == 1)) || (!this.bLU)) {
      return;
    }
    System.currentTimeMillis();
    if ((this.mSurfaceTexture == null) || (this.cDp != 1) || (Build.MODEL.equalsIgnoreCase("MI 5C"))) {}
    for (;;)
    {
      try
      {
        this.mSurfaceTexture.updateTexImage();
        if ((this.cDp != 1) || (this.mSurfaceTexture == null)) {
          break label318;
        }
        useProgram();
        bindTexture(this.texture);
        paramGL10 = new float[16];
        if (this.cDp != 1) {
          break label310;
        }
        this.mSurfaceTexture.getTransformMatrix(paramGL10);
        a(this.bF, this.jdField_a_of_type_Ly.a(), this.jdField_a_of_type_Ly.bh(), this.jdField_a_of_type_Ly.be(), paramGL10, this.jdField_a_of_type_Ly.b(), this.jdField_a_of_type_Ly.bg());
        hh(0, this.jdField_a_of_type_Ly.getVertexCount());
        cQC();
        cQD();
        cQE();
        this.mHandler.removeCallbacks(this.fV);
        this.mHandler.postDelayed(this.fV, 30L);
        return;
      }
      catch (Exception paramGL10)
      {
        paramGL10.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "onDrawFrame updateTexImage error", paramGL10);
        continue;
      }
      if (this.jdField_a_of_type_Addf.Sm == 0L) {
        break;
      }
      while (this.jdField_a_of_type_Addf.So > this.jdField_a_of_type_Addf.Sn)
      {
        paramGL10 = this.jdField_a_of_type_Addf;
        paramGL10.Sn += 1L;
        try
        {
          this.mSurfaceTexture.updateTexImage();
        }
        catch (Exception paramGL10)
        {
          paramGL10.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onDrawFrame updateTexImage error", paramGL10);
        }
      }
      continue;
      label310:
      Matrix.setIdentityM(paramGL10, 0);
      continue;
      label318:
      if ((this.jdField_a_of_type_Addj != null) && (this.cDp == 2)) {
        this.jdField_a_of_type_Addj.a(this.h);
      }
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.cDd = lz.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\n\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\n\nvarying vec2 vTextureCoord;\nvarying vec2 edgeTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n    edgeTextureCoord = vec2(aTextureCoord.x,1.0 - aTextureCoord.y);\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n\nvarying vec2 vTextureCoord;\nvarying vec2 edgeTextureCoord;\nuniform samplerExternalOES uTexture;\nuniform sampler2D cameraScanLineTexture;\nuniform sampler2D cameraScanNetTexture;\nuniform sampler2D cameraScanNoiseTexture;\nuniform int noiseMode;\nuniform float cameraVideoWidth;\nuniform float cameraVideoHeight;\nuniform float cameraEdgeStart;\nuniform float cameraEdgeEnd;\nvoid getEdgeRGBSobel(vec2 vTextureCoord){\n   float gadthis =  cameraEdgeStart - edgeTextureCoord.y;\n   vec4 cTemp4 = texture2D(uTexture, vTextureCoord);\n   const float gad = 0.6;\n   if(edgeTextureCoord.y > cameraEdgeEnd || gadthis < 0.0 || gadthis>gad){\n       gl_FragColor=cTemp4;\n    }else{\n        vec2 thistexcoord = vec2( edgeTextureCoord.x , 1.0 - gadthis / gad);\n        vec4 netColor = texture2D(cameraScanNetTexture, thistexcoord);\n        cTemp4.rgb = cTemp4.rgb * (1.0 - netColor.w) + vec3(1.0, 1.0, 1.0) * netColor.w;\n        vec2 offset0=vec2(-1.0/cameraVideoWidth,-1.0/cameraVideoHeight); vec2 offset1=vec2(0.0,-1.0/cameraVideoHeight); vec2 offset2=vec2(1.0/cameraVideoWidth,-1.0/cameraVideoHeight);\n        vec2 offset3=vec2(-1.0/cameraVideoWidth,0.0); vec2 offset5=vec2(1.0/cameraVideoWidth,0.0);\n        vec2 offset6=vec2(-1.0/cameraVideoWidth,1.0/cameraVideoHeight); vec2 offset7=vec2(0.0,1.0/cameraVideoHeight); vec2 offset8=vec2(1.0/cameraVideoWidth,1.0/cameraVideoHeight);\n        vec4 cTemp0,cTemp1,cTemp2,cTemp3,cTemp5,cTemp6,cTemp7,cTemp8;\n        cTemp0=texture2D(uTexture, vTextureCoord + offset0);\n        cTemp1=texture2D(uTexture, vTextureCoord + offset1);\n        cTemp2=texture2D(uTexture, vTextureCoord + offset2);\n        cTemp3=texture2D(uTexture, vTextureCoord + offset3);\n        cTemp5=texture2D(uTexture, vTextureCoord + offset5);\n        cTemp6=texture2D(uTexture, vTextureCoord + offset6);\n        cTemp7=texture2D(uTexture, vTextureCoord + offset7);\n        cTemp8=texture2D(uTexture, vTextureCoord + offset8);\n        vec4 sumx = -cTemp0 -  cTemp1 - cTemp2 + cTemp6.r +  cTemp7 + cTemp8;\n        vec4 sumy = -cTemp6 -  cTemp3 - cTemp0 + cTemp8 +  cTemp5 + cTemp2;\n        float sumxy = 0.3*sumx.r+0.59*sumx.g+0.11*sumx.b;\n        float sumyy = 0.3*sumy.r+0.59*sumy.g+0.11*sumy.b;\n        float sum  = length(vec2(sumxy, sumyy));\n        if(sum > 0.45){\n            sum+=0.2;\n            sum = min(sum,1.0);\n            float weightT = ((gad - gadthis)/gad *0.8);\n            sum = 0.8 * sum * weightT;\n            cTemp4 = vec4(0.0*weightT,0.9725*weightT,weightT*1.0,weightT) + cTemp4 * (1.0 - weightT - sum)+vec4(sum,sum,sum,1.0);\n        }\n        vec4 fugaicolor = texture2D(cameraScanLineTexture, thistexcoord);\n        float alphaW = fugaicolor.w * (gad - gadthis)/gad;\n        gl_FragColor = cTemp4 * (1.0 - alphaW) + fugaicolor * alphaW;\n        if(sum <= 0.45 && thistexcoord.y > 0.75 && noiseMode == 1){\n            float noiseAlpha = texture2D(cameraScanNoiseTexture, vec2(thistexcoord.x, (1.0-thistexcoord.y)/0.25)).a;\n            noiseAlpha = noiseAlpha*(4.0*thistexcoord.y-3.0);\n            if(noiseAlpha > 0.0626 && noiseAlpha<=1.0){\n                gl_FragColor.rgb = gl_FragColor.rgb * (1.0 - noiseAlpha) + vec3(0.753, 0.988, 1.0) * noiseAlpha;\n            }\n        }\n        gl_FragColor.a = 1.0;\n    }\n}\nvoid main() {\n   getEdgeRGBSobel(vTextureCoord);\n}");
    cQA();
    if (adgt.a() != null) {
      this.jdField_a_of_type_Addj.dY(BaseApplicationImpl.getContext());
    }
  }
  
  protected void useProgram()
  {
    GLES20.glUseProgram(this.cDd);
  }
  
  class a
  {
    boolean bLV = true;
    float x;
    float y;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addk
 * JD-Core Version:    0.7.0.1
 */