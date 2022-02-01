import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;

public class ayyn
  extends GPUBaseFilter
{
  private static String fragmentShaderCode = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230768);
  private boolean cBO = true;
  private boolean cBP = false;
  private int dBo;
  private int dBp;
  private int dBq;
  private float zl = 0.0F;
  
  public ayyn()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", fragmentShaderCode);
  }
  
  public ayyn(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.mFilterType = 0;
  }
  
  public void OJ(boolean paramBoolean)
  {
    this.cBO = paramBoolean;
  }
  
  public void d(boolean paramBoolean, float paramFloat)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    if (paramFloat > 1.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat < 0.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.cBP = paramBoolean;
        this.zl = paramFloat;
        return;
      }
    }
  }
  
  public void onDrawTexture()
  {
    float f2 = 1.0F;
    int i = this.dBp;
    if (this.cBP)
    {
      f1 = 1.0F;
      GLES20.glUniform1f(i, f1);
      GLES20.glUniform1f(this.dBo, this.zl);
      i = this.dBq;
      if (!this.cBO) {
        break label57;
      }
    }
    label57:
    for (float f1 = f2;; f1 = 2.0F)
    {
      GLES20.glUniform1f(i, f1);
      return;
      f1 = 2.0F;
      break;
    }
  }
  
  public void onInitialized()
  {
    this.dBo = GLES20.glGetUniformLocation(getProgram(), "percent");
    this.dBp = GLES20.glGetUniformLocation(getProgram(), "drawPart");
    this.dBq = GLES20.glGetUniformLocation(getProgram(), "cutX");
  }
  
  public String toString()
  {
    double d2 = 1.0D;
    int i = this.mFilterType;
    double d1;
    float f;
    if (this.cBP)
    {
      d1 = 1.0D;
      f = this.zl;
      if (!this.cBO) {
        break label77;
      }
    }
    for (;;)
    {
      return String.format("filter type=%s, draw left=%s, draw percent=%s, directionx=%s", new Object[] { Integer.valueOf(i), Double.valueOf(d1), Float.valueOf(f), Double.valueOf(d2) });
      d1 = 2.0D;
      break;
      label77:
      d2 = 2.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyn
 * JD-Core Version:    0.7.0.1
 */