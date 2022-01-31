import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.widget.QQToast;

public class zyh
  implements Runnable
{
  public zyh(ARVideoRecordUIControllerImpl paramARVideoRecordUIControllerImpl) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, "AR视频保存失败，请重新录制。", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyh
 * JD-Core Version:    0.7.0.1
 */