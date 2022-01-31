import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.VideoProcessListener;
import com.tencent.mobileqq.widget.QQToast;

public class xmx
  implements NewFlowCameraActivity.VideoProcessListener
{
  public xmx(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (this.a.r == 10011)
    {
      NewFlowCameraActivity.a(this.a, paramString1);
      return;
    }
    if (paramBoolean)
    {
      NewFlowCameraActivity.b(this.a, paramString1);
      return;
    }
    this.a.i(true);
    QQToast.a(this.a, "对不起，GIF处理异常...", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmx
 * JD-Core Version:    0.7.0.1
 */