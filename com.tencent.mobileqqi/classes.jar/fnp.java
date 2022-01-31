import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class fnp
  implements Runnable
{
  public fnp(MsgProxy paramMsgProxy, boolean paramBoolean) {}
  
  public void run()
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    String str = MsgProxy.f(this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy).a();
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "aio_break_point", bool, 0L, 0L, new HashMap(), "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fnp
 * JD-Core Version:    0.7.0.1
 */