import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class axyk
{
  private int aPositionHandle;
  private RectF bK = new RectF(-1.0F, 1.0F, 1.0F, -1.0F);
  private RectF bL = new RectF(-1.0F, 1.0F, 1.0F, -1.0F);
  private RectF bM = new RectF(-1.0F, 1.0F, 1.0F, -1.0F);
  private int cHQ;
  private int cHR;
  private final float[] eg = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private final float[] eh = new float[16];
  private final float[] mMVPMatrix = new float[16];
  private final float[] mProjectionMatrix = new float[16];
  private float[] mSTMatrix = new float[16];
  private FloatBuffer n;
  private int programId;
  private float scaleMax;
  private float scaleMin;
  private int screenHeight;
  private int screenWidth;
  private int textureId;
  private int uMatrixHandle;
  private int uTextureSamplerHandle;
  private FloatBuffer vertexBuffer = ByteBuffer.allocateDirect(this.vertexData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.vertexData);
  private final float[] vertexData = { 1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F };
  private int videoHeight;
  private int videoWidth;
  
  public axyk()
  {
    this.vertexBuffer.position(0);
    this.n = ByteBuffer.allocateDirect(this.eg.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.eg);
    this.n.position(0);
  }
  
  private void a(RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = (paramRectF.right - paramRectF.left) * (paramFloat1 - 1.0F);
    paramFloat2 = (paramRectF.bottom - paramRectF.top) * (paramFloat2 - 1.0F);
    paramRectF.top -= paramFloat2 / 2.0F;
    float f = paramRectF.bottom;
    paramRectF.bottom = (paramFloat2 / 2.0F + f);
    paramRectF.left -= paramFloat1 / 2.0F;
    paramFloat2 = paramRectF.right;
    paramRectF.right = (paramFloat1 / 2.0F + paramFloat2);
  }
  
  private void initMatrix()
  {
    Log.d("RenderFilter", "initMatrix videoWidth: " + this.videoWidth + ", videoHeight: " + this.videoHeight + ", screenWidth: " + this.screenWidth + ", screenHeight: " + this.screenHeight);
    float f4;
    if ((this.videoWidth > 0) && (this.videoHeight > 0) && (this.screenWidth > 0) && (this.screenHeight > 0))
    {
      Matrix.setIdentityM(this.mMVPMatrix, 0);
      Matrix.setIdentityM(this.eh, 0);
      Matrix.multiplyMM(this.mMVPMatrix, 0, this.eh, 0, this.mProjectionMatrix, 0);
      float f1 = this.videoWidth / this.videoHeight;
      float f2 = this.screenWidth / this.screenHeight;
      Matrix.orthoM(this.mProjectionMatrix, 0, -1.0F, 1.0F, -f1 / f2, f1 / f2, -1.0F, 1.0F);
      this.bM.set(-1.0F, f2 / f1, 1.0F, -f2 / f1);
      float f3 = this.bK.right / this.bK.top;
      f4 = this.scaleMax / this.scaleMin;
      if (f1 <= f3 * f2) {
        break label307;
      }
    }
    label307:
    for (this.scaleMin = (this.bK.top / this.bM.top);; this.scaleMin = (this.bK.right / this.bM.right))
    {
      this.scaleMax = (this.scaleMin * f4);
      scale(this.scaleMin, this.scaleMin, 1.0F);
      Log.d("RenderFilter", "initMatrix rectTexture: " + this.bM + ", rectTemp: " + this.bL);
      return;
    }
  }
  
  public int RA()
  {
    float f = this.eh[0] * this.screenWidth / this.videoWidth;
    return (int)(Math.abs(this.bK.bottom - this.bK.top) * this.screenHeight / 2.0F / f);
  }
  
  public int Rz()
  {
    float f = this.eh[0] * this.screenWidth / this.videoWidth;
    return (int)(Math.abs(this.bK.right - this.bK.left) * this.screenWidth / 2.0F / f);
  }
  
  public void aa(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d("RenderFilter", "setEdge left: " + paramInt1 + ", top: " + paramInt2 + ", right: " + paramInt3 + ", bottom: " + paramInt4);
    float f4 = this.screenWidth / 2;
    float f3 = this.screenHeight / 2;
    float f1 = paramInt1 / f4;
    float f2 = paramInt2 / f3;
    f4 = paramInt3 / f4;
    f3 = paramInt4 / f3;
    this.bK.set(f1 - 1.0F, 1.0F - f2, f4 - 1.0F, 1.0F - f3);
    Log.d("RenderFilter", "setEdge rectEdge: " + this.bK);
  }
  
  public void bA(float paramFloat)
  {
    this.scaleMax = paramFloat;
  }
  
  public void bz(float paramFloat)
  {
    this.scaleMin = paramFloat;
  }
  
  public void h(float[] paramArrayOfFloat)
  {
    this.mSTMatrix = paramArrayOfFloat;
  }
  
  public void initGL()
  {
    this.programId = aurm.createProgram("attribute vec4 aPosition;\nattribute vec4 aTexCoord;\nvarying vec2 vTexCoord;\nuniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nvoid main() {\n    vTexCoord = (uSTMatrix * aTexCoord).xy;\n    gl_Position = uMVPMatrix * aPosition;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTexCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTexCoord);\n}");
    this.aPositionHandle = GLES20.glGetAttribLocation(this.programId, "aPosition");
    this.cHQ = GLES20.glGetAttribLocation(this.programId, "aTexCoord");
    this.uMatrixHandle = GLES20.glGetUniformLocation(this.programId, "uMVPMatrix");
    this.cHR = GLES20.glGetUniformLocation(this.programId, "uSTMatrix");
    this.uTextureSamplerHandle = GLES20.glGetUniformLocation(this.programId, "sTexture");
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.textureId = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.textureId);
    aurm.checkGlError("glBindTexture mTextureID");
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
  }
  
  public void jo(int paramInt1, int paramInt2)
  {
    Log.d("RenderFilter", "updateProjection width: " + paramInt1 + ", height: " + paramInt2 + ", screenWidth: " + this.screenWidth + ", screenHeight: " + this.screenHeight);
    if ((this.videoWidth != paramInt1) || (this.videoHeight != paramInt2))
    {
      this.videoWidth = paramInt1;
      this.videoHeight = paramInt2;
      initMatrix();
    }
  }
  
  public void ly(int paramInt1, int paramInt2)
  {
    Log.d("RenderFilter", "adjustSize width: " + paramInt1 + ", height: " + paramInt2 + ", videoWidth: " + this.videoWidth + ", videoHeight: " + this.videoHeight);
    if ((this.screenWidth != paramInt1) || (this.screenHeight != paramInt2))
    {
      this.screenWidth = paramInt1;
      this.screenHeight = paramInt2;
      GLES20.glViewport(0, 0, this.screenWidth, this.screenHeight);
      initMatrix();
    }
  }
  
  public void onDrawFrame(int paramInt)
  {
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.programId);
    GLES20.glUniformMatrix4fv(this.uMatrixHandle, 1, false, this.mMVPMatrix, 0);
    GLES20.glUniformMatrix4fv(this.cHR, 1, false, this.mSTMatrix, 0);
    this.vertexBuffer.position(0);
    GLES20.glEnableVertexAttribArray(this.aPositionHandle);
    GLES20.glVertexAttribPointer(this.aPositionHandle, 3, 5126, false, 12, this.vertexBuffer);
    this.n.position(0);
    GLES20.glEnableVertexAttribArray(this.cHQ);
    GLES20.glVertexAttribPointer(this.cHQ, 2, 5126, false, 8, this.n);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt);
    GLES20.glUniform1i(this.uTextureSamplerHandle, 0);
    GLES20.glDrawArrays(5, 0, 4);
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.eh, 0, paramFloat1, paramFloat2, paramFloat3);
    if (this.eh[0] < this.scaleMin) {
      this.eh[0] = this.scaleMin;
    }
    if (this.eh[5] < this.scaleMin) {
      this.eh[5] = this.scaleMin;
    }
    if (this.eh[0] > this.scaleMax) {
      this.eh[0] = this.scaleMax;
    }
    if (this.eh[5] > this.scaleMax) {
      this.eh[5] = this.scaleMax;
    }
    Matrix.multiplyMM(this.mMVPMatrix, 0, this.eh, 0, this.mProjectionMatrix, 0);
    this.bL.set(this.bM);
    a(this.bL, this.eh[0], this.eh[5]);
    Log.d("RenderFilter", "scale rectTemp: " + this.bL);
  }
  
  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 /= this.screenWidth;
    paramFloat2 /= -this.screenHeight;
    Matrix.translateM(this.eh, 0, paramFloat1, paramFloat2, paramFloat3);
    if ((this.bL.left < this.bK.left) && (this.bL.right > this.bK.right)) {
      if (this.eh[12] > 0.0F)
      {
        if (this.eh[12] + this.bL.left > this.bK.left) {
          this.eh[12] = (this.bK.left - this.bL.left);
        }
        if ((this.bL.bottom >= this.bK.bottom) || (this.bL.top <= this.bK.top)) {
          break label639;
        }
        if (this.eh[13] <= 0.0F) {
          break label576;
        }
        if (this.eh[13] + this.bL.bottom > this.bK.bottom) {
          this.eh[13] = (this.bK.bottom - this.bL.bottom);
        }
      }
    }
    for (;;)
    {
      Matrix.multiplyMM(this.mMVPMatrix, 0, this.eh, 0, this.mProjectionMatrix, 0);
      Log.d("RenderFilter", "translate rectTemp: " + this.bL);
      return;
      if ((this.eh[12] >= 0.0F) || (this.eh[12] + this.bL.right >= this.bK.right)) {
        break;
      }
      this.eh[12] = (this.bK.right - this.bL.right);
      break;
      if (((this.bL.left < this.bK.left) && (this.bL.right < this.bK.right)) || ((this.bL.left > this.bK.left) && (this.bL.right > this.bK.right))) {
        break;
      }
      if ((this.bL.left > this.bK.left) && (this.bL.right < this.bK.right))
      {
        if (this.eh[12] > 0.0F)
        {
          if (this.eh[12] + this.bL.right <= this.bK.right) {
            break;
          }
          this.eh[12] = (this.bK.right - this.bL.right);
          break;
        }
        if ((this.eh[12] >= 0.0F) || (this.eh[12] + this.bL.left >= this.bK.left)) {
          break;
        }
        this.eh[12] = (this.bK.left - this.bL.left);
        break;
      }
      this.eh[12] = 0.0F;
      break;
      label576:
      if ((this.eh[13] < 0.0F) && (this.eh[13] + this.bL.top < this.bK.top))
      {
        this.eh[13] = (this.bK.top - this.bL.top);
        continue;
        label639:
        if (((this.bL.bottom >= this.bK.bottom) || (this.bL.top >= this.bK.top)) && ((this.bL.bottom <= this.bK.bottom) || (this.bL.top <= this.bK.top))) {
          if ((this.bL.bottom > this.bK.bottom) && (this.bL.top < this.bK.top))
          {
            if (this.eh[13] > 0.0F)
            {
              if (this.eh[13] + this.bL.top > this.bK.top) {
                this.eh[13] = (this.bK.top - this.bL.top);
              }
            }
            else if ((this.eh[13] < 0.0F) && (this.eh[13] + this.bL.bottom < this.bK.bottom)) {
              this.eh[13] = (this.bK.bottom - this.bL.bottom);
            }
          }
          else {
            this.eh[13] = 0.0F;
          }
        }
      }
    }
  }
  
  public Rect w()
  {
    float f1 = this.eh[0] * this.screenWidth / this.videoWidth;
    float f6 = this.bL.left;
    float f9 = this.eh[12];
    float f7 = this.bL.top;
    float f8 = this.eh[13];
    float f4 = this.bL.right;
    float f5 = this.eh[12];
    float f2 = this.bL.bottom;
    float f3 = this.eh[13];
    f6 = Math.abs(this.bK.left - (f6 + f9)) * this.screenWidth / 2.0F;
    f7 = Math.abs(this.bK.top - (f7 + f8)) * this.screenHeight / 2.0F;
    f4 = Math.abs(this.bK.right - (f4 + f5)) * this.screenWidth / 2.0F;
    f2 = Math.abs(this.bK.bottom - (f2 + f3)) * this.screenHeight / 2.0F;
    return new Rect((int)(f6 / f1), (int)(f7 / f1), (int)(f4 / f1), (int)(f2 / f1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyk
 * JD-Core Version:    0.7.0.1
 */