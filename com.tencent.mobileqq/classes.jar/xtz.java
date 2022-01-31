import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;

public class xtz
  implements Runnable
{
  public xtz(CameraFilterGLView paramCameraFilterGLView) {}
  
  public void run()
  {
    if ((!CameraFilterGLView.a(this.a).a) || (CameraFilterGLView.a(this.a).a == 0)) {
      return;
    }
    CameraFilterGLView.a(this.a).b = true;
    CameraFilterGLView.a(this.a).c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtz
 * JD-Core Version:    0.7.0.1
 */