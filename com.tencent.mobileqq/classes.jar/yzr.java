import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Calendar;

public class yzr
  implements aoed
{
  private int jdField_a_of_type_Int;
  
  public yzr(NewerGuidePlugin paramNewerGuidePlugin, int paramInt)
  {
    if (paramInt < 1897)
    {
      paramNewerGuidePlugin = Calendar.getInstance();
      paramNewerGuidePlugin.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      this.jdField_a_of_type_Int = paramNewerGuidePlugin.get(1);
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.jdField_a_of_type_Int - 1897 + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, NewerGuidePlugin.b(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin) + 1897);
    localCalendar.set(2, NewerGuidePlugin.c(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin));
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return paramInt2 + 1897 + alpo.a(2131707812);
    case 1: 
      return paramInt2 + 1 + alpo.a(2131707813);
    }
    return paramInt2 + 1 + alpo.a(2131707807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzr
 * JD-Core Version:    0.7.0.1
 */