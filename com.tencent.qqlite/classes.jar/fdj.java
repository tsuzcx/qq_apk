import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.cgireport.ReportDataModal;
import com.tencent.open.business.cgireport.ReportManager;
import java.net.SocketTimeoutException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;

public class fdj
  implements Runnable
{
  public fdj(ReportManager paramReportManager, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    LogUtility.b("cgi_report_debug", "ReportManager doUploadItems Thread start, url = " + this.jdField_a_of_type_JavaLangString);
    LogUtility.b("cgi_report_debug", "report bundle=" + this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager.jdField_a_of_type_Int = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_HttpRetryCount");
    Object localObject = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager;
    if (this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager.jdField_a_of_type_Int == 0) {
      i = 3;
    }
    for (;;)
    {
      ((ReportManager)localObject).jdField_a_of_type_Int = i;
      i = 0;
      int k = 0;
      int m = k + 1;
      LogUtility.b("cgi_report_debug", "ReportManager doUploadItems Thread request count = " + m);
      try
      {
        localObject = HttpBaseUtil.a(null, this.jdField_a_of_type_JavaLangString);
        HttpPost localHttpPost = new HttpPost(MsfSdkUtils.insertMtype("yingyongbao", this.jdField_a_of_type_JavaLangString));
        localHttpPost.addHeader("Accept-Encoding", "gzip");
        localHttpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        localHttpPost.setEntity(new ByteArrayEntity(HttpBaseUtil.a(this.jdField_a_of_type_AndroidOsBundle).getBytes()));
        if (((HttpClient)localObject).execute(localHttpPost).getStatusLine().getStatusCode() != 200)
        {
          LogUtility.e("cgi_report_debug", "ReportManager doUploadItems : HttpStatuscode != 200");
          this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager.jdField_a_of_type_Boolean = false;
          LogUtility.b("cgi_report_debug", "ReportManager doUploadItems Thread end, url = " + this.jdField_a_of_type_JavaLangString);
          if (i != 1) {
            break label372;
          }
          LogUtility.b("cgi_report_debug", "ReportManager doUploadItems Thread request success");
          return;
          i = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager.jdField_a_of_type_Int;
        }
      }
      catch (ConnectTimeoutException localConnectTimeoutException1)
      {
        for (;;)
        {
          try
          {
            LogUtility.b("cgi_report_debug", "ReportManager doUploadItems Thread success");
            i = 1;
          }
          catch (Exception localException2)
          {
            int j;
            i = 1;
            continue;
          }
          catch (SocketTimeoutException localSocketTimeoutException2)
          {
            i = 1;
            continue;
          }
          catch (ConnectTimeoutException localConnectTimeoutException2)
          {
            i = 1;
            continue;
          }
          localConnectTimeoutException1 = localConnectTimeoutException1;
          LogUtility.c(ReportManager.jdField_a_of_type_JavaLangString, "ReportManager doUploadItems : ConnectTimeoutException", localConnectTimeoutException1);
          j = i;
          i = j;
          k = m;
          if (m < this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager.jdField_a_of_type_Int) {
            break;
          }
          i = j;
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException1)
      {
        for (;;)
        {
          LogUtility.c(ReportManager.jdField_a_of_type_JavaLangString, "doUploadItems>>>", localSocketTimeoutException1);
          j = i;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          LogUtility.c("cgi_report_debug", "ReportManager doUploadItems : Exception", localException1);
        }
        label372:
        LogUtility.e("cgi_report_debug", "ReportManager doUploadItems Thread request failed");
        this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.a(this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fdj
 * JD-Core Version:    0.7.0.1
 */