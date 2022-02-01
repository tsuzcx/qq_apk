package com.tencent.mobileqq.redtouch;

import altq;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import org.json.JSONObject;

public class RedTouchManager$4
  implements Runnable
{
  public RedTouchManager$4(altq paramaltq, BusinessInfoCheckUpdate.AppInfo paramAppInfo, long paramLong) {}
  
  public void run()
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.this$0.g.getCurrentAccountUin()));
    localReportReqBody.clientver.set("3.4.4.3058");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(altq.dP(this.w.path.get()));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(18);
    localReportReqBody.extend.set(this.w.extend.get());
    if (this.w.missions.has()) {
      localReportReqBody.missionid.set(this.w.missions.get());
    }
    Object localObject1 = new JSONObject();
    try
    {
      localJSONObject = new JSONObject();
    }
    catch (Exception localException2)
    {
      JSONObject localJSONObject;
      label179:
      break label179;
    }
    try
    {
      localJSONObject.put("time_on_page", this.val$time);
      localObject1 = localJSONObject;
    }
    catch (Exception localException1)
    {
      Object localObject2 = localException2;
      break label179;
    }
    localReportReqBody.buffer.set(((JSONObject)localObject1).toString());
    localObject1 = altq.a(this.this$0, "RedTouchSvc.ClientReport");
    ((ToServiceMsg)localObject1).putWupBuffer(localReportReqBody.toByteArray());
    altq.a(this.this$0, (ToServiceMsg)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager.4
 * JD-Core Version:    0.7.0.1
 */