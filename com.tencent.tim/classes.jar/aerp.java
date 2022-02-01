import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aerp
  extends aeqp<aero>
{
  @NonNull
  public aero a()
  {
    return new aero();
  }
  
  @NonNull
  public aero a(aeic[] paramArrayOfaeic)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    aquv.a().ak(localQQAppInterface.getApplication(), paramArrayOfaeic, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfaeic);
    }
    return new aero();
  }
  
  @NonNull
  public aero b()
  {
    return new aero();
  }
  
  public Class<aero> clazz()
  {
    return aero.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 76;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerp
 * JD-Core Version:    0.7.0.1
 */