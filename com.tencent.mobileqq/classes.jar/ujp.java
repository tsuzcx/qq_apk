import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ujp
  implements Runnable
{
  public ujp(PokePanel paramPokePanel, String paramString, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel]start parsing config");
    }
    PokePanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel, this.jdField_a_of_type_JavaLangString);
    PokePanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel, this.jdField_a_of_type_JavaUtilArrayList);
    ArrayList localArrayList = PokeItemHelper.a(PokePanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel), this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel.a);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      ThreadManager.getUIHandler().post(new ujq(this));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel] parsing config end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujp
 * JD-Core Version:    0.7.0.1
 */