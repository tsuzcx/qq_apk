import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.DownloadGftData;
import com.tencent.qphone.base.util.QLog;

class vhg
  implements Runnable
{
  vhg(vhf paramvhf, AIOAnimationControlManager.DownloadGftData paramDownloadGftData) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$DownloadGftData.a)
    {
      this.jdField_a_of_type_Vhf.a.isLoading = false;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "GONE uniseq = " + this.jdField_a_of_type_Vhf.a.uniseq);
      }
      ((AIOAnimationControlManager)vhf.a(this.jdField_a_of_type_Vhf).getManager(222)).b(this.jdField_a_of_type_Vhf);
      this.jdField_a_of_type_Vhf.c.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "VISIBLE uniseq = " + this.jdField_a_of_type_Vhf.a.uniseq);
    }
    this.jdField_a_of_type_Vhf.a.isLoading = true;
    this.jdField_a_of_type_Vhf.c.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vhg
 * JD-Core Version:    0.7.0.1
 */