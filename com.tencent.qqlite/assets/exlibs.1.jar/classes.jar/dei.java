import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.model.EmoticonManager;

public class dei
  implements Runnable
{
  public dei(BigEmoticonViewBinder paramBigEmoticonViewBinder) {}
  
  public void run()
  {
    ((EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dei
 * JD-Core Version:    0.7.0.1
 */