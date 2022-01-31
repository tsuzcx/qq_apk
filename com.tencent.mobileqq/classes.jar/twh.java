import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

class twh
  implements Callback
{
  twh(twe paramtwe, tvy paramtvy, boolean paramBoolean, String paramString) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.d(twe.jdField_a_of_type_JavaLangString, 1, "checkResource onFailure");
    this.jdField_a_of_type_Tvy.a(false, this.jdField_a_of_type_Boolean, false, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = paramResponse.headers().get("X-COS-META-MD5");
      if ((TextUtils.isEmpty(paramCall)) || (this.jdField_a_of_type_JavaLangString.equals(paramCall)))
      {
        QLog.d(twe.jdField_a_of_type_JavaLangString, 1, "checkResource is up to date");
        this.jdField_a_of_type_Tvy.a(true, this.jdField_a_of_type_Boolean, false, paramCall);
        return;
      }
      QLog.d(twe.jdField_a_of_type_JavaLangString, 1, "checkResource need update");
      this.jdField_a_of_type_Tvy.a(true, this.jdField_a_of_type_Boolean, true, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twh
 * JD-Core Version:    0.7.0.1
 */