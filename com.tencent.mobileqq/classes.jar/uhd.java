import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.SharedPreUtils;

class uhd
  implements Runnable
{
  uhd(uhc paramuhc, Card paramCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Uhc.a.isFinishing()) {}
    CardHandler localCardHandler;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          TroopRequestActivity.a(this.jdField_a_of_type_Uhc.a, this.jdField_a_of_type_ComTencentMobileqqDataCard);
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0));
      localCardHandler = (CardHandler)this.jdField_a_of_type_Uhc.a.app.a(2);
    } while (localCardHandler == null);
    byte b = (byte)SharedPreUtils.aj(this.jdField_a_of_type_Uhc.a.getApplication(), this.jdField_a_of_type_Uhc.a.app.getCurrentAccountUin());
    localCardHandler.a(this.jdField_a_of_type_Uhc.a.app.getCurrentAccountUin(), this.jdField_a_of_type_Uhc.a.b, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", 1L, 10004, new byte[] { 0 }, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uhd
 * JD-Core Version:    0.7.0.1
 */