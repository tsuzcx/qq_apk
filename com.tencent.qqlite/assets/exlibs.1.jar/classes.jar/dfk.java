import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.HorizonEmoticonTabs;
import com.tencent.mobileqq.model.EmoticonManager;

public class dfk
  implements Runnable
{
  public dfk(HorizonEmoticonTabs paramHorizonEmoticonTabs, QQAppInterface paramQQAppInterface, BigEmoticonViewBinder paramBigEmoticonViewBinder) {}
  
  public void run()
  {
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfk
 * JD-Core Version:    0.7.0.1
 */