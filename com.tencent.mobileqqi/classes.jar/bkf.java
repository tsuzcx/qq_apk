import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.av.ui.MultiVideoMembersHolderUI;
import com.tencent.qphone.base.util.QLog;

public class bkf
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  
  public bkf(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "SetSelectedItemRunnable,uin=" + this.jdField_a_of_type_Long + " type=" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.a.setSelectedItem(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkf
 * JD-Core Version:    0.7.0.1
 */