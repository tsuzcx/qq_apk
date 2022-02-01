import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class atnd
{
  private static volatile atnd a;
  private String cHD = "";
  private String cHE = "";
  private boolean dil;
  
  public static atnd a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new atnd();
      }
      return a;
    }
    finally {}
  }
  
  public void eL(QQAppInterface paramQQAppInterface)
  {
    QLog.d("OfficeCenterConfigLoader", 1, "begin to get config, mbConfigGetting = " + this.dil);
    if (this.dil)
    {
      QLog.d("OfficeCenterConfigLoader", 4, "officecenter: get config is doing.");
      return;
    }
    this.dil = true;
    aevk.Y(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnd
 * JD-Core Version:    0.7.0.1
 */