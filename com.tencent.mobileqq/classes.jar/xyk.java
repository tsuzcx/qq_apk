import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;

public class xyk
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  public xyk(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramNewFlowCameraActivity.a.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.I();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.J();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.K();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.L();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyk
 * JD-Core Version:    0.7.0.1
 */