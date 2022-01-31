import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class xuz
  implements View.OnClickListener
{
  public xuz(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.l();
    if (((!QLog.isColorLevel()) || (!FileUtils.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()))) || (FlowCameraConstant.a == 1))
    {
      FlowCameraMqqAction.b("", "0X8005F5B", "0");
      return;
    }
    FlowCameraMqqAction.b("", "0X8005F5B", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xuz
 * JD-Core Version:    0.7.0.1
 */