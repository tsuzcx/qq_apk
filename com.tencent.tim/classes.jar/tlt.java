import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class tlt
  extends ShapeDrawable.ShaderFactory
{
  tlt(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfInt) {}
  
  public Shader resize(int paramInt1, int paramInt2)
  {
    return new LinearGradient(paramInt1 * this.oB, paramInt2 * this.oC, paramInt1 * this.oD, paramInt2 * this.oE, this.eF, null, Shader.TileMode.CLAMP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlt
 * JD-Core Version:    0.7.0.1
 */