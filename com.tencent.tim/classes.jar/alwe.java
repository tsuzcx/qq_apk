import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class alwe
  implements aolm.b
{
  alwe(alwd paramalwd, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager_PTV", 2, "onResp resultcode: " + paramaomh.dPy + " threadid=" + Thread.currentThread().getId());
    }
    File localFile = new File(alwd.aH, "temp_ptv_template_zip");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
      aarz.Gp(0);
      return;
    }
    Object localObject = "";
    try
    {
      paramaomh = aqhq.px(localFile.getPath());
      if ((TextUtils.isEmpty(this.bYR)) || (!this.bYR.equalsIgnoreCase(paramaomh))) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          jqp.b(localFile, this.bYS);
          paramaomh = new File(this.bwB);
          if (!paramaomh.exists()) {
            break label330;
          }
          paramaomh = alwd.p(paramaomh);
          localObject = alwd.a(null, paramaomh, this.this$0.a);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            break;
          }
          alwd.he(paramaomh, "ptv_template_new.cfg");
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip null == infos || infos.isEmpty()");
          }
          aarz.Gp(-4);
          return;
          localUnsatisfiedLinkError = localUnsatisfiedLinkError;
          paramaomh = (aomh)localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localUnsatisfiedLinkError.printStackTrace();
          paramaomh = (aomh)localObject;
        }
        catch (Exception paramaomh)
        {
          aarz.Gp(-3);
          aqmj.aA(this.val$app.getApp(), 0);
          if (!QLog.isColorLevel()) {
            continue;
          }
          paramaomh.printStackTrace();
          continue;
        }
        aarz.Gp(-2);
      }
      alwd.he(paramaomh, "ptv_template_new.cfg");
      this.this$0.Om(false);
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip finsh configContent=" + paramaomh);
      }
      aarz.Gp(1);
      this.val$app.getApp().sendBroadcast(new Intent("action_brocassreceiver_for_ptv"));
      return;
    }
    label330:
    if (QLog.isColorLevel()) {
      QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
    }
    aqmj.aA(this.val$app.getApp(), 0);
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwe
 * JD-Core Version:    0.7.0.1
 */