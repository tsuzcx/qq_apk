package com.tencent.mobileqq.remind;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import gfx;

public class RemindJavascriptInterface
  extends WebViewPlugin
{
  static final String a = "REMIND";
  static final String b = "createTimePicker";
  static final String c = "calendar";
  static final String d = "addEvent";
  static final String e = "remindSuccess";
  static final String f = "remindDelete";
  static final String g = "remindMsgReport";
  static final String h = "remindAioReport";
  private static String i = "remind";
  protected Activity a;
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "remindSuccess : " + paramString);
    }
    boolean bool1 = RemindHelper.a(RemindHelper.a(paramString, "isNew"));
    boolean bool2 = RemindHelper.a(RemindHelper.a(paramString, "isInsert"));
    RemindHelper.a(paramString, "title");
    RemindHelper.a(RemindHelper.a(paramString, "startDate")).longValue();
    RemindHelper.a(RemindHelper.a(paramString, "endDate")).longValue();
    if (bool1)
    {
      paramString = "0";
      if (!bool2) {
        break label180;
      }
    }
    label180:
    for (String str = "0";; str = "1")
    {
      if (QLog.isColorLevel()) {
        QLog.d(i, 2, "createAndAddReport  r2: " + str + " r3: " + paramString);
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Updata_clock", 0, 0, str, paramString, "", "");
      return;
      paramString = "1";
      break;
    }
  }
  
  public void a(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    long l = RemindHelper.a(RemindHelper.a(paramString, "currentDate")).longValue();
    RemindHelper.a(this.a, l * 1000L, new gfx(this), paramJsBridgeListener);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "createCalendar : " + paramString);
    }
    RemindHelper.a(RemindHelper.a(paramString, "isSend"));
    String str = RemindHelper.a(paramString, "title");
    long l1 = RemindHelper.a(RemindHelper.a(paramString, "startDate")).longValue();
    long l2 = RemindHelper.a(RemindHelper.a(paramString, "endDate")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "startTime : " + TimeHelper.a(l1 * 1000L) + " endTime : " + TimeHelper.a(l2 * 1000L));
    }
    if (RemindHelper.a(this.a, str, l1 * 1000L, l2 * 1000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(i, 2, "addByRecevierReport");
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Rec_ckl_add", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.a, this.a.getString(2131562074), 0).a();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("REMIND".equals(paramString2)) && ("createTimePicker".equals(paramString3)))
    {
      a(paramVarArgs[0], paramJsBridgeListener);
      return true;
    }
    if (("calendar".equals(paramString2)) && ("addEvent".equals(paramString3)))
    {
      b(paramVarArgs[0]);
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindSuccess".equals(paramString3)))
    {
      a(paramVarArgs[0]);
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindDelete".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(i, 2, "deleteRemindSuccess");
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Delete_clock", 0, 0, "", "", "", "");
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindMsgReport".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(i, 2, "remindMsgReport : " + paramVarArgs[0]);
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Obj_clock", 0, 0, RemindHelper.a(paramVarArgs[0], "entranceType"), RemindHelper.a(paramVarArgs[0], "role"), "", "");
      return true;
    }
    if (("calendar".equals(paramString2)) && ("remindAioReport".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(i, 2, "remindAioReport");
      }
      ReportController.b(null, "CliOper", "", "", "Time_reminder", "Clock_card_clk", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.remind.RemindJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */