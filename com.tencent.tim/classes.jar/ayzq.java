import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.5;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.io.File;
import java.io.IOException;

public class ayzq
  implements aolm.b
{
  public ayzq(PtvTemplateManager.5 param5) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "onResp url: " + this.a.d.resurl + " resultcode: " + paramaomh.dPy);
    }
    this.a.d.usable = this.a.this$0.a(this.a.d);
    if (this.a.d.usable) {}
    try
    {
      jqp.b(new File(PtvTemplateManager.aH, this.a.d.name), PtvTemplateManager.bYM);
      return;
    }
    catch (IOException paramaomh)
    {
      while (!QLog.isColorLevel()) {}
      paramaomh.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzq
 * JD-Core Version:    0.7.0.1
 */