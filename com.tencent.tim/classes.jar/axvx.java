import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class axvx
  implements aolm.b
{
  axvx(axvw paramaxvw, String paramString1, String paramString2, axvw.b paramb, String paramString3, String paramString4, axvw.a parama) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + paramaomh.dPy + " threadid=" + Thread.currentThread().getId());
    }
    File localFile = new File(this.alk, this.val$zipFileName);
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
    }
    label249:
    do
    {
      for (;;)
      {
        return;
        paramaomh = "";
        try
        {
          String str = aqhq.px(localFile.getPath());
          paramaomh = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_Axvw$b.cWs)) || (!this.jdField_a_of_type_Axvw$b.cWs.equalsIgnoreCase(paramaomh))) {}
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
                break label249;
              }
              paramaomh = ayzs.p(paramaomh);
              if ((this.jdField_a_of_type_Axvw$a == null) || (paramaomh == null)) {
                break;
              }
              this.jdField_a_of_type_Axvw$a.Hr(paramaomh);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException paramaomh)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", paramaomh);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_Axvw$b.cWs, " ", paramaomh });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvx
 * JD-Core Version:    0.7.0.1
 */