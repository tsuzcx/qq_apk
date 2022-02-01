import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class ayyo
  extends ayyn
{
  private static String fragmentShaderCode = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230764);
  private float mBrightness;
  private int mBrightnessLocation;
  
  public ayyo()
  {
    this(0.5F);
  }
  
  public ayyo(float paramFloat)
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", fragmentShaderCode);
    this.mBrightness = paramFloat;
  }
  
  public void onDrawTexture()
  {
    super.onDrawTexture();
    GLES20.glUniform1f(this.mBrightnessLocation, this.mBrightness);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.mBrightnessLocation = GLES20.glGetUniformLocation(getProgram(), "brightness");
    setBrightness(this.mBrightness);
  }
  
  public void setBrightness(float paramFloat)
  {
    this.mBrightness = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyo
 * JD-Core Version:    0.7.0.1
 */