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

public class zua
  implements Runnable
{
  public zua(StartAppCheckHandler paramStartAppCheckHandler) {}
  
  public void run()
  {
    try
    {
      Object localObject = StartAppCheckHandler.a(this.a, this.a.b.getApplication(), this.a.jdField_a_of_type_Zud.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        long l = new File(((PackageInfo)localObject).applicationInfo.sourceDir).lastModified();
        String str = SecUtil.getSignatureHash(localObject.signatures[0].toByteArray());
        this.a.jdField_a_of_type_Zub.c = l;
        this.a.jdField_a_of_type_Zud.d = str;
        this.a.jdField_a_of_type_Zud.b = ((PackageInfo)localObject).versionName;
        this.a.jdField_a_of_type_Zud.c = MD5Utils.a(((PackageInfo)localObject).applicationInfo.sourceDir);
      }
      this.a.jdField_a_of_type_Zub.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Zud.d;
      this.a.jdField_a_of_type_Zub.b = this.a.jdField_a_of_type_Zud.c;
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, " " + this.a.jdField_a_of_type_Zud.jdField_a_of_type_Long + " " + this.a.jdField_a_of_type_Zud.jdField_a_of_type_Int + " " + this.a.jdField_a_of_type_Zud.jdField_a_of_type_JavaLangString + " " + this.a.jdField_a_of_type_Zud.b + " " + this.a.jdField_a_of_type_Zud.c + " " + this.a.jdField_a_of_type_Zud.d);
      }
      if ((this.a.jdField_a_of_type_Zud.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_Zud.b != null) && (this.a.jdField_a_of_type_Zud.c != null) && (this.a.jdField_a_of_type_Zud.d != null))
      {
        this.a.jdField_a_of_type_Zud.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u64_uin.set(this.a.jdField_a_of_type_Zud.jdField_a_of_type_Long);
        this.a.jdField_a_of_type_Zud.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u32_client_type.set(this.a.jdField_a_of_type_Zud.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_Zud.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_packname.set(this.a.jdField_a_of_type_Zud.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Zud.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_version.set(this.a.jdField_a_of_type_Zud.b);
        this.a.jdField_a_of_type_Zud.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_md5.set(this.a.jdField_a_of_type_Zud.c);
        this.a.jdField_a_of_type_Zud.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_signature.set(this.a.jdField_a_of_type_Zud.d);
        this.a.jdField_a_of_type_Zud.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u32_protocol_version.set(2);
        localObject = new Message();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = this.a.jdField_a_of_type_Zud;
        StartAppCheckHandler.a(this.a).sendMessage((Message)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("AppStartedHandler", 2, "SendStartedAppInfo end..");
        }
      }
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zua
 * JD-Core Version:    0.7.0.1
 */