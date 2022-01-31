import KQQ.HttpUploadReq;
import KQQ.UploadInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public final class fdc
  extends Thread
{
  public fdc(byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    try
    {
      Object localObject1 = new UploadInfo();
      bool2 = bool3;
      ((UploadInfo)localObject1).lAppID = AppSetting.a;
      bool2 = bool3;
      ((UploadInfo)localObject1).lFromMID = 9901L;
      bool2 = bool3;
      ((UploadInfo)localObject1).lToMID = 0L;
      bool2 = bool3;
      ((UploadInfo)localObject1).shType = 2;
      bool2 = bool3;
      ((UploadInfo)localObject1).vSignature = "NoSignature".getBytes();
      bool2 = bool3;
      localObject1 = ((UploadInfo)localObject1).toByteArray();
      bool2 = bool3;
      Object localObject2 = new Cryptor().encrypt((byte[])localObject1, this.jdField_a_of_type_ArrayOfByte);
      bool2 = bool3;
      localObject1 = new HttpUploadReq();
      bool2 = bool3;
      ((HttpUploadReq)localObject1).vEncryptUploadInfo = ((byte[])localObject2);
      bool2 = bool3;
      ((HttpUploadReq)localObject1).vFileData = this.jdField_a_of_type_JavaLangString.getBytes();
      int i = 0;
      for (;;)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        bool2 = bool1;
        if (i >= 3) {
          break;
        }
        bool2 = bool1;
        localObject2 = new HttpPost("http://bugtrace.3g.qq.com/upload/1/0");
        bool2 = bool1;
        ((HttpPost)localObject2).setEntity(new ByteArrayEntity(((HttpUploadReq)localObject1).toByteArray()));
        bool2 = bool1;
        localObject2 = new DefaultHttpClient().execute((HttpUriRequest)localObject2);
        bool3 = bool1;
        bool2 = bool1;
        if (((HttpResponse)localObject2).getStatusLine().getStatusCode() == 200)
        {
          bool2 = bool1;
          localObject2 = ((HttpResponse)localObject2).getEntity();
          bool3 = bool1;
          if (localObject2 != null)
          {
            bool2 = bool1;
            localObject2 = EntityUtils.toString((HttpEntity)localObject2);
            bool2 = bool1;
            bool3 = Pattern.compile("ret\\s*=\\s*0", 2).matcher((CharSequence)localObject2).find();
          }
        }
        i += 1;
        bool1 = bool3;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DexLoad", 2, "upload result: " + bool2 + ", " + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdc
 * JD-Core Version:    0.7.0.1
 */