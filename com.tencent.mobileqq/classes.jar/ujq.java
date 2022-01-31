import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.PokePanelAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ujq
  implements Runnable
{
  ujq(ujp paramujp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel]update UI start");
    }
    ArrayList localArrayList = this.a.jdField_a_of_type_JavaUtilArrayList;
    PokePanel.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel).a(localArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel]update UI end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujq
 * JD-Core Version:    0.7.0.1
 */