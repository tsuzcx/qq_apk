import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class fgu
  implements Runnable
{
  public fgu(StartAppCheckHandler paramStartAppCheckHandler) {}
  
  public void run()
  {
    Object localObject = StartAppCheckHandler.a(this.a, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.a.jdField_a_of_type_Fgx.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      long l = new File(((PackageInfo)localObject).applicationInfo.sourceDir).lastModified();
      String str = SecUtil.b(localObject.signatures[0].toByteArray());
      this.a.jdField_a_of_type_Fgv.c = l;
      this.a.jdField_a_of_type_Fgx.d = str;
      this.a.jdField_a_of_type_Fgx.b = ((PackageInfo)localObject).versionName;
      this.a.jdField_a_of_type_Fgx.c = MD5Utils.a(((PackageInfo)localObject).applicationInfo.sourceDir);
    }
    this.a.jdField_a_of_type_Fgv.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Fgx.d;
    this.a.jdField_a_of_type_Fgv.b = this.a.jdField_a_of_type_Fgx.c;
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, " " + this.a.jdField_a_of_type_Fgx.jdField_a_of_type_Long + " " + this.a.jdField_a_of_type_Fgx.jdField_a_of_type_Int + " " + this.a.jdField_a_of_type_Fgx.jdField_a_of_type_JavaLangString + " " + this.a.jdField_a_of_type_Fgx.b + " " + this.a.jdField_a_of_type_Fgx.c + " " + this.a.jdField_a_of_type_Fgx.d);
    }
    if ((this.a.jdField_a_of_type_Fgx.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_Fgx.b != null) && (this.a.jdField_a_of_type_Fgx.c != null) && (this.a.jdField_a_of_type_Fgx.d != null))
    {
      this.a.jdField_a_of_type_Fgx.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u64_uin.set(this.a.jdField_a_of_type_Fgx.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_Fgx.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u32_client_type.set(this.a.jdField_a_of_type_Fgx.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_Fgx.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_packname.set(this.a.jdField_a_of_type_Fgx.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Fgx.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_version.set(this.a.jdField_a_of_type_Fgx.b);
      this.a.jdField_a_of_type_Fgx.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_md5.set(this.a.jdField_a_of_type_Fgx.c);
      this.a.jdField_a_of_type_Fgx.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_signature.set(this.a.jdField_a_of_type_Fgx.d);
      this.a.jdField_a_of_type_Fgx.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u32_protocol_version.set(2);
      localObject = new Message();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = this.a.jdField_a_of_type_Fgx;
      StartAppCheckHandler.a(this.a).sendMessage((Message)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "SendStartedAppInfo end..");
      }
    }
    this.a.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgu
 * JD-Core Version:    0.7.0.1
 */