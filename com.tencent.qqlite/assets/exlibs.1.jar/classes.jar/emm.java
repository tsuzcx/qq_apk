import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class emm
  implements Runnable
{
  public emm(TroopAndDiscMsgProxy paramTroopAndDiscMsgProxy, boolean paramBoolean) {}
  
  public void run()
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    String str = TroopAndDiscMsgProxy.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy).a();
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "aio_break_point", bool, 0L, 0L, new HashMap(), "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     emm
 * JD-Core Version:    0.7.0.1
 */