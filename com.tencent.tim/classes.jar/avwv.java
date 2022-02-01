import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.FloatBuffer;

public abstract class avwv
{
  protected float Ds = 360.0F;
  protected avwp a;
  protected avwv.a a;
  protected avwy b;
  protected float[] dR = new float[16];
  protected boolean dpj;
  protected int eyW;
  protected int eyX;
  protected int eyY;
  protected int eyZ = 1;
  protected int imageHeight;
  protected int imageWidth;
  protected float mQ;
  protected float mScale = 1.0F;
  protected float[] modelMatrix = new float[16];
  protected float rotateX;
  protected float rotateY;
  protected int showType;
  protected FloatBuffer textureBuffer;
  protected int textureId;
  protected FloatBuffer vertexBuffer;
  protected int vertexSize;
  
  public avwv(boolean paramBoolean)
  {
    this.dpj = paramBoolean;
  }
  
  public abstract int PK();
  
  public int PL()
  {
    return this.vertexSize;
  }
  
  public int PM()
  {
    return this.eyZ;
  }
  
  public void a(avwp paramavwp)
  {
    this.jdField_a_of_type_Avwp = paramavwp;
  }
  
  public void a(avwv.a parama)
  {
    this.jdField_a_of_type_Avwv$a = parama;
  }
  
  public void a(avwy paramavwy)
  {
    this.b = paramavwy;
  }
  
  public void ab(float paramFloat1, float paramFloat2)
  {
    this.rotateX += paramFloat1;
    this.rotateY += paramFloat2;
  }
  
  public void aca(int paramInt)
  {
    eCc();
    if ((this.vertexBuffer == null) || (this.textureBuffer == null)) {
      eCd();
    }
    acb(paramInt);
    eCg();
    eCh();
    initMatrix();
  }
  
  protected void acb(int paramInt)
  {
    this.eyW = GLES20.glGetAttribLocation(paramInt, "aPosition");
    this.eyX = GLES20.glGetUniformLocation(paramInt, "uProjectMatrix");
    this.eyY = GLES20.glGetAttribLocation(paramInt, "aTextureCoord");
  }
  
  public float bV()
  {
    return this.Ds;
  }
  
  public FloatBuffer c()
  {
    return this.vertexBuffer;
  }
  
  public FloatBuffer d()
  {
    return this.textureBuffer;
  }
  
  protected abstract void eCc();
  
  protected abstract void eCd();
  
  public abstract void eCe();
  
  public abstract void eCf();
  
  protected void eCg()
  {
    if (c() != null)
    {
      c().position(0);
      GLES20.glVertexAttribPointer(this.eyW, PK(), 5126, false, 0, c());
      GLES20.glEnableVertexAttribArray(this.eyW);
    }
  }
  
  protected void eCh()
  {
    if (d() != null)
    {
      d().position(0);
      GLES20.glVertexAttribPointer(this.eyY, getTextureType(), 5126, false, 0, d());
      GLES20.glEnableVertexAttribArray(this.eyY);
    }
  }
  
  public abstract int getTextureType();
  
  protected float[] h()
  {
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.multiplyMM(arrayOfFloat, 0, this.dR, 0, this.modelMatrix, 0);
    Matrix.setIdentityM(this.modelMatrix, 0);
    return arrayOfFloat;
  }
  
  protected void initMatrix()
  {
    Matrix.setIdentityM(this.modelMatrix, 0);
    Matrix.setIdentityM(this.dR, 0);
  }
  
  public void setImageSize(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
  }
  
  public void setScreenRatio(float paramFloat)
  {
    this.mQ = paramFloat;
    if (this.showType == 1)
    {
      if ((this instanceof avwu)) {
        this.mScale = 0.5228754F;
      }
    }
    else {
      return;
    }
    this.mScale = 0.4142652F;
  }
  
  public void setShowType(int paramInt)
  {
    this.showType = paramInt;
  }
  
  public void setTextureId(int paramInt)
  {
    this.textureId = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwv
 * JD-Core Version:    0.7.0.1
 */