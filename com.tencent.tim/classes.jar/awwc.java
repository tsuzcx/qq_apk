import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraManager.8;

public class awwc
  implements anim.b
{
  public awwc(AECameraManager.8 param8) {}
  
  public void bm(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AECameraManager", 2, "onAutoFocusCallback single tap focus " + paramBoolean1 + ", camera2:" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      awwa.a(this.a.this$0, true);
      return;
    }
    awwa.a(this.a.this$0).dQq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwc
 * JD-Core Version:    0.7.0.1
 */