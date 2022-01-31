import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.widget.QQToast;

public class xpt
  implements Runnable
{
  public xpt(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getApplication(), "录制出现异常，请重试", 1).a();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpt
 * JD-Core Version:    0.7.0.1
 */