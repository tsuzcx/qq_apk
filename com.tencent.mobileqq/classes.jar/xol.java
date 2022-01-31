import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class xol
  implements Runnable
{
  public xol(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    this.a.startActivityForResult(NewFlowCameraActivity.a(this.a), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xol
 * JD-Core Version:    0.7.0.1
 */