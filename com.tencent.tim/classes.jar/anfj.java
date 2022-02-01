import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.15;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class anfj
  implements aolm.b
{
  public anfj(PtvTemplateManager.15 param15) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.a.doodleUrl + " resultcode: " + paramaomh.dPy);
    }
    this.a.a.doodleUsable = this.a.this$0.a(this.a.a, false);
    if (this.a.a.doodleUsable) {}
    try
    {
      jqp.b(new File(PtvTemplateManager.aL, this.a.a.doodleName), PtvTemplateManager.cdu);
      if (paramaomh.mResult == 0)
      {
        Object localObject = this.a.this$0.getQQAppInterface();
        if (localObject != null)
        {
          localObject = (aopo)((QQAppInterface)localObject).getManager(193);
          if (((aopo)localObject).isEnable()) {
            ((aopo)localObject).be(this.a.a.doodleUrl, paramaomh.apU);
          }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfj
 * JD-Core Version:    0.7.0.1
 */