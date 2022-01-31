import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;

class zxb
  implements KeyingBase.UserInterface
{
  zxb(zxa paramzxa) {}
  
  public void a()
  {
    GLES20.glUniform1i(zxa.a(this.a), zxa.b(this.a));
  }
  
  public void a(int paramInt)
  {
    zxa.a(this.a, GLES20.glGetUniformLocation(paramInt, "uDisplayType"));
    ARVideoUtil.a("glGetUniformLocation uDisplayType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxb
 * JD-Core Version:    0.7.0.1
 */