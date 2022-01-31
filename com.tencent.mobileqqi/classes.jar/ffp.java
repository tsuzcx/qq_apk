import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

public class ffp
  implements SosoInterface.OnLocationListener
{
  public ffp(QQAppInterface paramQQAppInterface) {}
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo, byte[] paramArrayOfByte, SosoInterface paramSosoInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBS", 2, "onLocationFinish result:" + paramInt);
    }
    com.tencent.mobileqq.app.LBSHandler.v = paramInt;
    paramSosoInterface = QQAppInterface.a(this.a);
    if (paramInt == 0) {}
    try
    {
      QQAppInterface.a(this.a, paramArrayOfByte);
      QQAppInterface.a(this.a, paramSosoLbsInfo);
      QQAppInterface.a(this.a, QQAppInterface.a(paramSosoLbsInfo));
      QQAppInterface.a(this.a).notifyAll();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffp
 * JD-Core Version:    0.7.0.1
 */