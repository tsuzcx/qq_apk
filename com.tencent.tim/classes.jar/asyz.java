import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class asyz
  implements asyj.a
{
  public asyz(QSecFramework paramQSecFramework) {}
  
  public void ess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QSecFramework", 2, "Something wrong when init native.");
    }
    asxt.report(1, 2);
  }
  
  public void run()
  {
    if ((!QSecFramework.access$000()) || (QSecFramework.a(this.this$0))) {}
    for (;;)
    {
      return;
      try
      {
        Object[] arrayOfObject = new Object[1];
        if ((QSecFramework.b(1L, 33751040L, asxv.NY(), 0L, QSecFramework.a(this.this$0), MobileQQ.sMobileQQ, null, arrayOfObject) == 0) && (arrayOfObject[0] != null) && ((arrayOfObject[0] instanceof Integer)))
        {
          QSecFramework.a(this.this$0, ((Integer)arrayOfObject[0]).intValue());
          asxv.QSEC_FRAMEWORK_NATIVER_VER = QSecFramework.a(this.this$0);
          QSecFramework.a(this.this$0, true);
        }
        if (QLog.isColorLevel())
        {
          QLog.d("QSecFramework", 2, String.format("Native ver: %d(%s)", new Object[] { Integer.valueOf(QSecFramework.a(this.this$0)), asxv.gz(QSecFramework.a(this.this$0)) }));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyz
 * JD-Core Version:    0.7.0.1
 */