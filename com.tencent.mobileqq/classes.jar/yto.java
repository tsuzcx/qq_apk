import com.tencent.mobileqq.apollo.GLTextureView;
import com.tencent.qphone.base.util.QLog;

public class yto
  implements Runnable
{
  public yto(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    if ((GLTextureView.access$1600(this.a)) && (GLTextureView.access$1200(this.a)) && (GLTextureView.access$1700(this.a) != 1.0F)) {
      GLTextureView.access$1800(this.a, 1.0F);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, "TextureView mCheckSurfaceChangeTask, mSurfaceHadDraw:" + GLTextureView.access$1200(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yto
 * JD-Core Version:    0.7.0.1
 */