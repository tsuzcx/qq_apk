import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.support.annotation.FloatRange;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.bighead.BigHeadBuckler;
import com.tencent.mobileqq.shortvideo.bighead.GpuGaussianBlurFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.Color4f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class aybo
{
  private RenderBuffer k;
  private Color4f mColor = new Color4f(1.0F, 1.0F, 1.0F, 1.0F);
  private boolean mIsInitialized = false;
  private int mProgram;
  protected FloatBuffer o;
  private int[] ui = new int[1];
  
  private void c(int paramInt, float[] paramArrayOfFloat)
  {
    if (!this.mIsInitialized) {}
    do
    {
      return;
      int i = this.mProgram;
      float[] arrayOfFloat = paramArrayOfFloat;
      if (paramArrayOfFloat == null) {
        arrayOfFloat = BigHeadBuckler.sGIdentity;
      }
      int j = GLES20.glGetError();
      if ((j != 0) && (QLog.isColorLevel())) {
        QLog.d("LightWeightCircleCornerFilter", 2, "drawTextureFrame errorBegin:" + j);
      }
      GLES20.glUseProgram(i);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      j = GLES20.glGetAttribLocation(i, "a_position");
      int m = GLES20.glGetAttribLocation(i, "a_texCoord");
      int n = GLES20.glGetAttribLocation(i, "a_texCoordMask");
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, GpuGaussianBlurFilter.VERTEXT_BUF);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glVertexAttribPointer(m, 2, 5126, false, 0, GpuGaussianBlurFilter.TEXTURE_BUF);
      GLES20.glEnableVertexAttribArray(m);
      GLES20.glVertexAttribPointer(n, 2, 5126, false, 0, GpuGaussianBlurFilter.TEXTURE_BUF);
      GLES20.glEnableVertexAttribArray(n);
      j = GLES20.glGetAttribLocation(i, "a_color");
      GLES20.glVertexAttribPointer(j, 4, 5126, false, 0, this.o);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(i, "u_projectionMatrix"), 1, false, arrayOfFloat, 0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "u_texture"), 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.ui[0]);
      GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "u_texture_mask"), 1);
      GLES20.glDrawArrays(5, 0, 4);
      paramInt = GLES20.glGetError();
    } while (paramInt == 0);
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCircleCornerFilter", 2, "drawTextureFrame error:" + paramInt);
    }
    throw new RuntimeException("error =" + paramInt);
  }
  
  public boolean aQd()
  {
    return this.mIsInitialized;
  }
  
  public void destroy()
  {
    if (this.mIsInitialized)
    {
      this.mIsInitialized = false;
      GLES20.glDeleteProgram(this.mProgram);
      GLES20.glDeleteTextures(1, this.ui, 0);
      GLES20.glDeleteTextures(1, new int[] { this.k.getTexId() }, 0);
      this.k.destroy();
      this.mProgram = 0;
    }
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat)
  {
    this.k.bind();
    c(paramInt, paramArrayOfFloat);
    this.k.unbind();
  }
  
  public void f(Context paramContext, int paramInt1, int paramInt2)
  {
    if (this.mIsInitialized) {}
    for (;;)
    {
      return;
      this.mProgram = GlUtil.createProgram("precision mediump float;\nattribute vec4 a_position;\nattribute vec2 a_texCoord;\nattribute vec2 a_texCoordMask;\nattribute vec4 a_color;\nuniform mat4 u_projectionMatrix;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_Position = u_projectionMatrix * a_position;\n    v_texCoord = a_texCoord;\n    v_texCoord_mask = a_texCoordMask;\n    v_color = a_color;\n}", "precision mediump float;uniform sampler2D u_texture;\nuniform sampler2D u_texture_mask;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    vec4 mask = texture2D(u_texture_mask, v_texCoord_mask);\n    vec4 scan = texture2D(u_texture, v_texCoord);\n    if(mask.a < 0.5){\n       gl_FragColor = v_color * scan;\n    }else{\n       discard;\n    }\n}");
      if (this.mProgram == 0)
      {
        paramContext = new RuntimeException("failed creating program " + getClass().getSimpleName());
        if (QLog.isColorLevel()) {
          QLog.d("LightWeightCircleCornerFilter", 2, "LightWeightCircleCornerFilter ", paramContext);
        }
        this.mIsInitialized = false;
        return;
      }
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130845340);
      if (paramContext != null)
      {
        this.ui[0] = GlUtil.createTexture(3553, paramContext, 9729, 9729, 33071, 33071);
        paramContext.recycle();
        this.k = new RenderBuffer(paramInt1, paramInt2, 33984);
      }
      for (this.mIsInitialized = true; this.mIsInitialized; this.mIsInitialized = false)
      {
        this.o = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.o.position(0);
        setAlpha(1.0F);
        return;
        GLES20.glDeleteProgram(this.mProgram);
        this.mProgram = 0;
        this.k = null;
      }
    }
  }
  
  public int getOutTexture()
  {
    return this.k.getTexId();
  }
  
  public void setAlpha(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.mColor.setValue(1.0F, 1.0F, 1.0F, paramFloat);
    if ((this.mIsInitialized) && (this.o != null))
    {
      this.o.position(0);
      int i = 0;
      while (i < 4)
      {
        this.mColor.putValue(this.o);
        i += 1;
      }
      this.o.position(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybo
 * JD-Core Version:    0.7.0.1
 */