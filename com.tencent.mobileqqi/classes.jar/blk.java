import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.VcCamera;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.statistics.ReportController;

public class blk
  implements Runnable
{
  public blk(VideoLayerUI paramVideoLayerUI, Handler.Callback paramCallback) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvCameraVcCamera != null)
    {
      bool = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a();
      localSurfaceHolder = ((SurfaceView)this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewView.findViewById(2131232281)).getHolder();
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvCameraVcCamera.b(localSurfaceHolder);
      if (this.jdField_a_of_type_AndroidOsHandler$Callback != null) {
        new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback).sendEmptyMessage(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().a == 4)
      {
        if (!bool) {
          break label121;
        }
        ReportController.b(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
      }
    }
    label121:
    while (this.jdField_a_of_type_AndroidOsHandler$Callback == null)
    {
      boolean bool;
      SurfaceHolder localSurfaceHolder;
      return;
      ReportController.b(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
      return;
    }
    new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback).sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blk
 * JD-Core Version:    0.7.0.1
 */