import com.tencent.av.camera.VcCamera;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class blp
  implements Runnable
{
  public blp(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "closeCamera begin.");
    }
    if (this.a.a != null) {
      this.a.a.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "closeCamera end.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blp
 * JD-Core Version:    0.7.0.1
 */