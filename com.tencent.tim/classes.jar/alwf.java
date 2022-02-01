import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class alwf
  implements aolm.b
{
  alwf(alwd paramalwd, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "onResp url: " + this.d.resurl + " resultcode: " + paramaomh.dPy);
    }
    this.d.usable = this.this$0.a(this.d);
    if (this.d.usable) {}
    try
    {
      jqp.b(new File(alwd.aI, this.d.md5), alwd.mZ(this.d.md5));
      if (this.this$0.a != null) {
        this.this$0.a.dKk();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwf
 * JD-Core Version:    0.7.0.1
 */