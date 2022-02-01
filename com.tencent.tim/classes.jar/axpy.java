import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;

public class axpy
  implements aolm.b
{
  public axpy(CaptureTemplateManager.2 param2) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.val$videoUrl + " resultcode: " + paramaomh.dPy);
    }
    boolean bool = false;
    if (paramaomh.mResult == 0)
    {
      bool = axpx.a(this.a.this$0, this.a.axN, this.a.val$md5);
      if (bool)
      {
        aopo localaopo = (aopo)this.a.this$0.a().getManager(193);
        if (localaopo.isEnable()) {
          localaopo.be(this.a.val$videoUrl, paramaomh.apU);
        }
      }
    }
    if (!bool) {
      axpx.a(this.a.this$0, this.a.axN);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaptureTemplateManager", 2, "onResp url: " + this.a.val$videoUrl + " downloadSuccess " + bool);
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axpy
 * JD-Core Version:    0.7.0.1
 */