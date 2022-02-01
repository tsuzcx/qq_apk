import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class tsg
  implements bitu
{
  public tsg(ViolaBaseView paramViolaBaseView, boolean paramBoolean) {}
  
  public void a(Exception paramException)
  {
    String str2;
    String str1;
    if ((paramException instanceof ConnectTimeoutException))
    {
      str2 = biuc.e;
      str1 = ViolaEnvironment.CHANGE_ERROR_CONNECT_TIMEOUT;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ViolaBaseView.a(), 2, "viola request cgi has error:" + str2 + ",e:" + paramException.getMessage());
      }
      if (this.jdField_a_of_type_Boolean) {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_CHANGE, str1);
      }
      ViolaBaseView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, this.jdField_a_of_type_Boolean);
      ViolaBaseView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, this.jdField_a_of_type_Boolean);
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        str2 = biuc.f;
        str1 = ViolaEnvironment.CHANGE_ERROR_CONNECT_TIMEOUT;
      }
      else if ((paramException instanceof MalformedURLException))
      {
        str2 = "访问url有误!";
        str1 = ViolaEnvironment.CHANGE_ERROR_URL;
      }
      else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
      {
        str2 = "Http返回码异常!";
        str1 = ViolaEnvironment.CHANGE_ERROR_HTTP_CODE;
      }
      else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
      {
        str2 = biuc.g;
        str1 = ViolaEnvironment.CHANGE_ERROR_CONNECT_UNAVALIABLE;
      }
      else if ((paramException instanceof JSONException))
      {
        str2 = biuc.b;
        str1 = ViolaEnvironment.CHANGE_ERROR_DATA;
      }
      else if ((paramException instanceof IOException))
      {
        str2 = biuc.a;
        str1 = ViolaEnvironment.CHANGE_ERROR_IO;
      }
      else
      {
        str2 = biuc.d;
        str1 = ViolaEnvironment.CHANGE_ERROR_UNKNOW;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ViolaBaseView.a(), 2, "change cgi result:" + paramJSONObject.toString());
    }
    try
    {
      if ((paramJSONObject.getInt("retCode") == 0) && (paramJSONObject.getString("retMsg").equals("success")) && (!TextUtils.isEmpty(paramJSONObject.getJSONObject("retObj").getString("fileUrl"))))
      {
        ViolaBaseView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, paramJSONObject.getJSONObject("retObj").getString("fileUrl"));
        if (this.jdField_a_of_type_Boolean) {
          ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_END);
        }
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, this.jdField_a_of_type_Boolean);
        ViolaBaseView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, this.jdField_a_of_type_Boolean);
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_ERROR_DATA);
      }
      ViolaBaseView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, this.jdField_a_of_type_Boolean);
      ViolaBaseView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, this.jdField_a_of_type_Boolean);
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_ERROR_UNKNOW);
      }
      ViolaBaseView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, this.jdField_a_of_type_Boolean);
      ViolaBaseView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, this.jdField_a_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.e(ViolaBaseView.a(), 2, "change cgi exception:" + paramJSONObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsg
 * JD-Core Version:    0.7.0.1
 */