import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4;
import java.io.File;
import java.io.IOException;

public class ayzt
  implements aolm.b
{
  public ayzt(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.d.resurl + " resultcode: " + paramaomh.dPy);
    }
    this.a.d.usable = this.a.this$0.a(this.a.d);
    if (this.a.d.usable) {}
    try
    {
      jqp.b(new File(ayzs.m(), this.a.d.name), ayzs.bYM);
      if (this.a.this$0.a() != null) {
        this.a.this$0.a().notifyObservers(axrf.class, 3, true, null);
      }
      return;
    }
    catch (IOException paramaomh)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramaomh.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzt
 * JD-Core Version:    0.7.0.1
 */