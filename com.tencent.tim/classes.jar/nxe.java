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

public class nxe
  implements arxh.a
{
  public nxe(ViolaBaseView paramViolaBaseView, boolean paramBoolean) {}
  
  public void ai(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ViolaBaseView.access$700(), 2, "change cgi result:" + paramJSONObject.toString());
    }
    try
    {
      if ((paramJSONObject.getInt("retCode") == 0) && (paramJSONObject.getString("retMsg").equals("success")) && (!TextUtils.isEmpty(paramJSONObject.getJSONObject("retObj").getString("fileUrl"))))
      {
        ViolaBaseView.b(this.this$0, paramJSONObject.getJSONObject("retObj").getString("fileUrl"));
        if (this.avr) {
          ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_END);
        }
        ViolaBaseView.a(this.this$0, this.avr);
        ViolaBaseView.b(this.this$0, this.avr);
        return;
      }
      if (this.avr) {
        ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_ERROR_DATA);
      }
      ViolaBaseView.c(this.this$0, this.avr);
      ViolaBaseView.b(this.this$0, this.avr);
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (this.avr) {
        ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_ERROR_UNKNOW);
      }
      ViolaBaseView.c(this.this$0, this.avr);
      ViolaBaseView.b(this.this$0, this.avr);
      if (QLog.isColorLevel()) {
        QLog.e(ViolaBaseView.access$700(), 2, "change cgi exception:" + paramJSONObject.getMessage());
      }
    }
  }
  
  public void onException(Exception paramException)
  {
    String str2;
    String str1;
    if ((paramException instanceof ConnectTimeoutException))
    {
      str2 = arxo.cCU;
      str1 = ViolaEnvironment.CHANGE_ERROR_CONNECT_TIMEOUT;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ViolaBaseView.access$700(), 2, "viola request cgi has error:" + str2 + ",e:" + paramException.getMessage());
      }
      if (this.avr) {
        ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.KEY_CHANGE, str1);
      }
      ViolaBaseView.c(this.this$0, this.avr);
      ViolaBaseView.b(this.this$0, this.avr);
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        str2 = arxo.cCV;
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
        str2 = arxo.cCW;
        str1 = ViolaEnvironment.CHANGE_ERROR_CONNECT_UNAVALIABLE;
      }
      else if ((paramException instanceof JSONException))
      {
        str2 = arxo.cCS;
        str1 = ViolaEnvironment.CHANGE_ERROR_DATA;
      }
      else if ((paramException instanceof IOException))
      {
        str2 = arxo.cCR;
        str1 = ViolaEnvironment.CHANGE_ERROR_IO;
      }
      else
      {
        str2 = arxo.cCT;
        str1 = ViolaEnvironment.CHANGE_ERROR_UNKNOW;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxe
 * JD-Core Version:    0.7.0.1
 */