import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class bka
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  public bka(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "RefreshStatusTipsRunnale,type=" + this.jdField_a_of_type_Int + " flag=" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.a != null) {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.a.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bka
 * JD-Core Version:    0.7.0.1
 */