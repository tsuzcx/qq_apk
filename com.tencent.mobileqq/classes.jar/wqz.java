import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;

public class wqz
  implements Runnable
{
  public wqz(TroopActivity paramTroopActivity, BaseTroopView paramBaseTroopView) {}
  
  public void run()
  {
    boolean bool = ((RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(21)).b();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.runOnUiThread(new wra(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqz
 * JD-Core Version:    0.7.0.1
 */