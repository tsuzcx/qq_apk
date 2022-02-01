import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aesc
  extends aeqp<aesb>
{
  @NonNull
  public aesb a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    accr localaccr = (accr)localQQAppInterface.getBusinessHandler(16);
    if (localaccr != null) {
      localaccr.dG(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new aesb();
  }
  
  @NonNull
  public aesb a(aeic[] paramArrayOfaeic)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    accr localaccr = (accr)localQQAppInterface.getBusinessHandler(16);
    if (localaccr != null) {
      localaccr.M(localQQAppInterface, paramArrayOfaeic[0].content);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfaeic[0]);
    }
    return new aesb();
  }
  
  @NonNull
  public aesb b()
  {
    return new aesb();
  }
  
  public Class<aesb> clazz()
  {
    return aesb.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesc
 * JD-Core Version:    0.7.0.1
 */