import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

class zaw
  extends ShapeDrawable.ShaderFactory
{
  zaw(zav paramzav, float paramFloat) {}
  
  public Shader resize(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1;
    paramInt1 = Color.parseColor("#00FFFFFF");
    paramInt2 = Color.parseColor("#FFFFFFFF");
    int i = Color.parseColor("#FFFFFFFF");
    float f2 = this.qU;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { paramInt1, paramInt2, i }, new float[] { 0.0F, f2, 1.0F }, localTileMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zaw
 * JD-Core Version:    0.7.0.1
 */