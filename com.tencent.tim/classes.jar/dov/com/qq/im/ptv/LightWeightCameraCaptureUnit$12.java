package dov.com.qq.im.ptv;

import ayan;
import ayca;
import com.tencent.qphone.base.util.QLog;

public class LightWeightCameraCaptureUnit$12
  implements Runnable
{
  public LightWeightCameraCaptureUnit$12(ayan paramayan) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightWeightCameraCaptureUnit", 2, "IPC onIPCExitEvent finish ...");
    }
    if (this.this$0.a != null) {
      this.this$0.a.acX(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.12
 * JD-Core Version:    0.7.0.1
 */