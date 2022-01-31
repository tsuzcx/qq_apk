import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;

class zwy
  implements KeyingBase.UserInterface
{
  zwy(zwx paramzwx) {}
  
  public void a()
  {
    GLES20.glUniform1i(zwx.a(this.a), zwx.b(this.a));
  }
  
  public void a(int paramInt)
  {
    zwx.a(this.a, GLES20.glGetUniformLocation(paramInt, "uDisplayType"));
    ARVideoUtil.a("glGetUniformLocation uDisplayType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zwy
 * JD-Core Version:    0.7.0.1
 */