import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.report.BaseData;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDatabaseHelper;
import com.tencent.open.base.APNUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class fep
  implements Runnable
{
  public fep(ReportCenter paramReportCenter, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 1;
    for (;;)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = this.jdField_a_of_type_Long;
        localObject1 = new Bundle();
        Object localObject3 = APNUtil.a(CommonDataAdapter.a().a());
        ((Bundle)localObject1).putString("apn", (String)localObject3);
        ((Bundle)localObject1).putString("appid", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putString("commandid", this.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putString("detail", this.jdField_c_of_type_JavaLangString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("network=").append((String)localObject3).append('&');
        localObject3 = localStringBuilder.append("sdcard=");
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          i = 1;
          ((StringBuilder)localObject3).append(i).append('&');
          localStringBuilder.append("wifi=").append(APNUtil.e(CommonDataAdapter.a().a()));
          ((Bundle)localObject1).putString("deviceInfo", localStringBuilder.toString());
          i = 100 / this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a(this.jdField_a_of_type_Int);
          if (i > 0) {
            continue;
          }
          i = j;
          ((Bundle)localObject1).putString("frequency", i + "");
          ((Bundle)localObject1).putString("reqSize", this.jdField_b_of_type_Long + "");
          ((Bundle)localObject1).putString("resultCode", this.jdField_a_of_type_Int + "");
          ((Bundle)localObject1).putString("rspSize", this.jdField_c_of_type_Long + "");
          ((Bundle)localObject1).putString("timeCost", l1 - l2 + "");
          ((Bundle)localObject1).putString("uin", this.d + "");
          localObject1 = new BaseData((Bundle)localObject1);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        int k;
        int m;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReportCenter", 2, "-->reportCgi, exception in sub thread.", localException);
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a.add(localObject1);
        k = this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a.size();
        m = ReportDatabaseHelper.a().a("report_cgi");
        j = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Agent_ReportTimeInterval");
        i = j;
        if (j == 0) {
          i = 10000;
        }
        if ((!this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a("report_cgi", m + k)) && (!this.jdField_a_of_type_Boolean)) {
          break label523;
        }
        this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a();
        this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.b.removeMessages(1000);
        return;
      }
      finally {}
      int i = 0;
      continue;
      if (i > 100)
      {
        i = 100;
        continue;
        label523:
        if (!this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.b.hasMessages(1000))
        {
          Message localMessage = Message.obtain();
          localMessage.what = 1000;
          this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.b.sendMessageDelayed(localMessage, i);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fep
 * JD-Core Version:    0.7.0.1
 */