import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResCallback;

public class usd
  implements Runnable
{
  public usd(DoodleResHelper paramDoodleResHelper, int paramInt1, int paramInt2, View paramView, ScribbleResMgr.ResCallback paramResCallback) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Int == 0) {
      ScribbleResMgr.a(localQQAppInterface).a(localQQAppInterface, 3, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResCallback);
    }
    while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {
      return;
    }
    ScribbleResMgr.a(localQQAppInterface).a(localQQAppInterface, 4, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     usd
 * JD-Core Version:    0.7.0.1
 */