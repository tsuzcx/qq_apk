package com.tencent.mobileqq.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RedTouchHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final String a = "RedTouchHandler";
  public static final int b = 1;
  public static final String b = "RedTouchSubCmd";
  public static final String c = "RedTouchPath";
  public static final String d = "SettingStatus";
  public static final String e = "SettingAppid";
  
  public RedTouchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return RedTouchObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!paramFromServiceMsg.getServiceCmd().equals("RedTouchSvc.EntranceSetting")) || (!paramFromServiceMsg.isSuccess())) {}
    do
    {
      for (;;)
      {
        return;
        paramToServiceMsg = new BusinessInfoCheckUpdate.ReportRspBody();
        try
        {
          paramFromServiceMsg = (BusinessInfoCheckUpdate.ReportRspBody)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = paramFromServiceMsg;
          if (paramToServiceMsg.code.get() == 0)
          {
            i = paramToServiceMsg.appid.get();
            paramToServiceMsg = paramToServiceMsg.buffer.get();
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          try
          {
            int i;
            paramToServiceMsg = new JSONObject(paramToServiceMsg);
            if (paramToServiceMsg.getInt("cmd") == 4)
            {
              boolean bool = paramToServiceMsg.getBoolean("setting");
              long l1 = paramToServiceMsg.getLong("modify_ts");
              long l2 = paramToServiceMsg.getLong("server_ts");
              if ((l1 != l2) && (l2 > 0L)) {
                LebaShowListManager.a().a(this.a, i, bool, l1, l2);
              }
              if (QLog.isDevelopLevel())
              {
                QLog.i("Q.lebatab.mgr", 4, "onReceiver, [" + i + "," + bool + "," + l1 + "," + l2 + "]");
                return;
              }
            }
          }
          catch (Exception paramToServiceMsg)
          {
            if (QLog.isColorLevel())
            {
              QLog.i("Q.lebatab.mgr", 2, paramToServiceMsg.toString());
              return;
              paramFromServiceMsg = paramFromServiceMsg;
              paramToServiceMsg.code.set(-1);
              paramToServiceMsg.errmsg.set("prb.mergeFrom exception");
              paramFromServiceMsg.printStackTrace();
            }
          }
          catch (Throwable paramToServiceMsg) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.lebatab.mgr", 2, paramToServiceMsg.toString());
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong)
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.a.a()));
    localReportReqBody.clientver.set("3.4.0.607");
    localReportReqBody.platid.set(109);
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.appid.set(RedTouchManager.a(paramString));
    paramString = new JSONObject();
    try
    {
      paramString.put("cmd", 4);
      paramString.put("setting", paramBoolean);
      paramString.put("modify_ts", paramLong);
      localReportReqBody.buffer.set(paramString.toString());
      paramString = a("RedTouchSvc.EntranceSetting");
      paramString.extraData.putInt("RedTouchSubCmd", 1);
      paramString.extraData.putInt("SettingAppid", localReportReqBody.appid.get());
      paramString.extraData.putBoolean("SettingStatus", paramBoolean);
      paramString.putWupBuffer(localReportReqBody.toByteArray());
      b(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.lebatab.mgr", 2, paramString.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RedTouchHandler
 * JD-Core Version:    0.7.0.1
 */