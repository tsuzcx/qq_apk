import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class akqb
  extends amzq
{
  OlympicToolAppInterface b;
  Random random = new Random();
  
  public akqb(OlympicToolAppInterface paramOlympicToolAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicToolService", 2, "new OlympicToolService");
    }
    this.b = paramOlympicToolAppInterface;
    seq = Math.abs(this.random.nextInt());
  }
  
  protected void aTq()
  {
    try
    {
      super.aTq();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg)
  {
    super.a(paramToServiceMsg, null, akqc.class);
  }
  
  public AppInterface getAppInterface()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqb
 * JD-Core Version:    0.7.0.1
 */