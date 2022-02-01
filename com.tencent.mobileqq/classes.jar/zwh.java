import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

class zwh
  implements Callback
{
  zwh(zwe paramzwe, zwa paramzwa, boolean paramBoolean, String paramString) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.d("RFWDownloader", 1, "checkResource onFailure");
    this.jdField_a_of_type_Zwa.a(false, this.jdField_a_of_type_Boolean, false, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = paramResponse.headers().get("X-COS-META-MD5");
      if ((TextUtils.isEmpty(paramCall)) || (this.jdField_a_of_type_JavaLangString.equals(paramCall)))
      {
        QLog.d("RFWDownloader", 1, "checkResource is up to date");
        this.jdField_a_of_type_Zwa.a(true, this.jdField_a_of_type_Boolean, false, paramCall);
        return;
      }
      QLog.d("RFWDownloader", 1, "checkResource need update");
      this.jdField_a_of_type_Zwa.a(true, this.jdField_a_of_type_Boolean, true, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwh
 * JD-Core Version:    0.7.0.1
 */