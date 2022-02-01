import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class aesp
  extends aeqp<aeso>
{
  @NonNull
  public aeso a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ku.eM();
    aqmj.q(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin(), "vas_font_switch_config", "reset");
    return new aeso();
  }
  
  @NonNull
  public aeso a(aeic[] paramArrayOfaeic)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ku.U(paramArrayOfaeic[0].content);
    aqmj.q(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin(), "vas_font_switch_config", paramArrayOfaeic[0].content);
    return new aeso();
  }
  
  @NonNull
  public aeso b()
  {
    return new aeso();
  }
  
  public Class<aeso> clazz()
  {
    return aeso.class;
  }
  
  public int type()
  {
    return 359;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesp
 * JD-Core Version:    0.7.0.1
 */