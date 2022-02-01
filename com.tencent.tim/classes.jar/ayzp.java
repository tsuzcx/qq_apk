import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.13;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import java.io.File;
import java.io.IOException;

public class ayzp
  implements aolm.b
{
  public ayzp(PtvTemplateManager.13 param13) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.a.doodleUrl + " resultcode: " + paramaomh.dPy);
    }
    this.a.a.doodleUsable = this.a.this$0.a(this.a.a, false);
    if (this.a.a.doodleUsable) {}
    try
    {
      jqp.b(new File(PtvTemplateManager.aL, this.a.a.doodleName), PtvTemplateManager.cdu);
      if (paramaomh.mResult == 0)
      {
        aopo localaopo = (aopo)this.a.val$app.getManager(193);
        if (localaopo.isEnable()) {
          localaopo.be(this.a.a.doodleUrl, paramaomh.apU);
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzp
 * JD-Core Version:    0.7.0.1
 */