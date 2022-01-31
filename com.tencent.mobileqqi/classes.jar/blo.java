import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.VcCamera;
import com.tencent.av.opengl.QQGlRender;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class blo
  implements Runnable
{
  public blo(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "resumeCamera begin.");
    }
    if ((this.a.jdField_a_of_type_Bly != null) && (this.a.b != null)) {
      if (this.a.jdField_a_of_type_Bly.a != 1) {
        break label118;
      }
    }
    label118:
    for (Object localObject = this.a.jdField_a_of_type_Bly.a();; localObject = this.a.b.a())
    {
      if (localObject != null) {
        ((QQGlRender)localObject).showBackground(true);
      }
      localObject = this.a.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration();
      while (((Configuration)localObject).orientation != 1)
      {
        try
        {
          Thread.sleep(50L);
        }
        catch (InterruptedException localInterruptedException) {}
        if (QLog.isColorLevel()) {
          QLog.d("VideoLayerUI", 2, "resumeCamera InterruptedException", localInterruptedException);
        }
      }
    }
    try
    {
      localObject = ((SurfaceView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131232281)).getHolder();
      if (!this.a.jdField_a_of_type_ComTencentAvCameraVcCamera.a((SurfaceHolder)localObject))
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, 0);
        this.a.jdField_a_of_type_ComTencentAvVideoController.c((String)localObject, 11);
        if (QLog.isColorLevel()) {
          QLog.d("VideoLayerUI", 2, "resumeCamera failed to start camera.");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoLayerUI", 2, "resumeCamera", localException);
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoLayerUI", 2, "resumeCamera end.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blo
 * JD-Core Version:    0.7.0.1
 */