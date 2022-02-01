import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.qphone.base.util.QLog;

public class aarm
  implements anim.b
{
  public aarm(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void bm(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "single tap focus " + paramBoolean1);
    }
    aarz.CU(paramBoolean1);
    if (paramBoolean1)
    {
      NewFlowCameraActivity.h(this.this$0, true);
      return;
    }
    this.this$0.mCamera.dQq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarm
 * JD-Core Version:    0.7.0.1
 */