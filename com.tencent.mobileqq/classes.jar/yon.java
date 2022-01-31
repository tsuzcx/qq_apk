import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate;

public class yon
  implements Runnable
{
  public yon(CmGameScreenRotate paramCmGameScreenRotate, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 8))
    {
      if ((CmGameScreenRotate.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate) != null) && (CmGameScreenRotate.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate).getVisibility() == 0)) {
        CmGameScreenRotate.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate).setRequestedOrientation(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return;
    }
    CmGameScreenRotate.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate).setRequestedOrientation(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameScreenRotate.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yon
 * JD-Core Version:    0.7.0.1
 */