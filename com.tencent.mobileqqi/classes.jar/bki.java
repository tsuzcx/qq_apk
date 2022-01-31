import android.content.res.Resources;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.qphone.base.util.QLog;

public class bki
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  
  public bki(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int % 4;
    Object localObject2 = null;
    Object localObject1;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.e("MultiVideoCtrlLayerUI", 2, "WaitingTextChangeRunnable-->Wrong Type.Type =" + i);
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.c != null)) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.c.setText((CharSequence)localObject1);
      }
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 700L);
      return;
      localObject1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_AndroidContentResResources.getString(2131560270);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_AndroidContentResResources.getString(2131560271);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_AndroidContentResResources.getString(2131560272);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_AndroidContentResResources.getString(2131560273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bki
 * JD-Core Version:    0.7.0.1
 */