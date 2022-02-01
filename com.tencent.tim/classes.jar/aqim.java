import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class aqim
{
  private static boolean cUj;
  public static boolean needReport;
  aqhv a = null;
  private String action = "-1";
  private boolean cUk;
  private String ctB = "-1";
  private String ctC = "-1";
  String ctD = "-1";
  private String dataString = "-1";
  private String scheme = "-1";
  private String type = "-1";
  
  public aqim()
  {
    if (cUj) {}
    label200:
    for (;;)
    {
      return;
      cUj = true;
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("JumpReportCtr_SP", 0);
      long l = localSharedPreferences.getLong("lastShotTime", 0L);
      if (Math.abs(System.currentTimeMillis() - l) >= 43200000L) {
        if (0.01F >= Math.random())
        {
          needReport = bool;
          localSharedPreferences.edit().putLong("lastShotTime", System.currentTimeMillis()).putBoolean("lastShotResult", needReport).apply();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label200;
        }
        QLog.d("JumpActivity.Report", 2, "JumpReportCtr init needReport= " + needReport);
        return;
        bool = false;
        break;
        needReport = localSharedPreferences.getBoolean("lastShotResult", false);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent)
  {
    if (paramIntent == null) {}
    label4:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label4;
              break label4;
              break label4;
              do
              {
                return;
              } while (!needReport);
              Object localObject = aqij.a(paramActivity);
              StringBuilder localStringBuilder = new StringBuilder();
              if ((localObject != null) && (!((HashSet)localObject).isEmpty()))
              {
                localObject = ((HashSet)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  String str = (String)((Iterator)localObject).next();
                  if (localStringBuilder.length() > 0) {
                    localStringBuilder.append("|");
                  }
                  localStringBuilder.append(str);
                }
              }
              this.ctB = localStringBuilder.toString();
              this.cUk = ad(paramIntent);
              this.action = paramIntent.getAction();
              this.scheme = paramIntent.getScheme();
              this.type = paramIntent.getType();
              this.dataString = paramIntent.getDataString();
              if (!this.cUk) {
                break;
              }
            } while ((!this.action.equals("android.intent.action.SEND")) && (!this.action.equals("android.intent.action.SEND_MULTIPLE")));
            paramQQAppInterface = paramIntent.getExtras();
          } while (paramQQAppInterface == null);
          if (!TextUtils.isEmpty(paramQQAppInterface.getString("android.intent.extra.TEXT")))
          {
            this.ctD = paramQQAppInterface.getString("android.intent.extra.TEXT");
            return;
          }
          paramQQAppInterface = paramQQAppInterface.get("android.intent.extra.STREAM");
        } while (paramQQAppInterface == null);
        if ((paramQQAppInterface instanceof Uri))
        {
          this.ctD = ((Uri)paramQQAppInterface).toString();
          return;
        }
        if ((paramQQAppInterface instanceof String))
        {
          this.ctD = ((String)paramQQAppInterface);
          return;
        }
      } while (!(paramQQAppInterface instanceof ArrayList));
      this.ctD = "MULTIPLE_SHARE";
      return;
    } while ((TextUtils.isEmpty(this.dataString)) || (paramQQAppInterface == null));
    this.a = aqik.c(paramQQAppInterface, paramActivity, this.dataString);
  }
  
  public boolean ad(Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return false;
        str = paramIntent.getAction();
      } while (TextUtils.isEmpty(str));
      if ((str.equals("android.intent.action.SEND")) || (str.equals("android.intent.action.SEND_MULTIPLE"))) {
        return true;
      }
      paramIntent = paramIntent.getScheme();
    } while ((!str.equals("android.intent.action.VIEW")) || (TextUtils.isEmpty(paramIntent)) || ((!paramIntent.equals("file")) && (!paramIntent.equals("content"))));
    return true;
  }
  
  public void dP(Intent paramIntent)
  {
    if (!needReport) {}
    do
    {
      return;
      if (paramIntent != null) {
        this.ctC = paramIntent.getComponent().getClassName();
      }
      if (!this.cUk) {
        break;
      }
      paramIntent = new HashMap(5);
      paramIntent.put("action", this.action);
      paramIntent.put("scheme", this.scheme);
      paramIntent.put("type", this.type);
      paramIntent.put("data", this.dataString);
      paramIntent.put("fromPkg", this.ctB);
      paramIntent.put("jumpToAct", this.ctC);
      paramIntent.put("shareContext", this.ctD);
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "jump_act_system_report", true, 0L, 0L, paramIntent, null);
      paramIntent = new StringBuilder(256);
      paramIntent.append("action=").append(this.action).append(", pkgName=").append(this.ctB).append(", jumpToAct=").append(this.ctC).append(", scheme=").append(this.scheme).append(", type=").append(this.type).append(", shareContext=").append(this.ctD).append("\n data=").append(this.dataString);
    } while (!QLog.isColorLevel());
    QLog.d("JumpActivity.Report", 2, "systemShare|report : \n" + paramIntent.toString());
    return;
    String str;
    if (this.a != null)
    {
      str = this.a.cti;
      paramIntent = this.a.ctj;
    }
    for (;;)
    {
      Object localObject = new HashMap(8);
      ((HashMap)localObject).put("action", this.action);
      ((HashMap)localObject).put("scheme", this.scheme);
      ((HashMap)localObject).put("type", this.type);
      ((HashMap)localObject).put("data", this.dataString);
      ((HashMap)localObject).put("fromPkg", this.ctB);
      ((HashMap)localObject).put("jumpToAct", this.ctC);
      ((HashMap)localObject).put("server_name", str);
      ((HashMap)localObject).put("action_name", paramIntent);
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "jump_act_business_report", true, 0L, 0L, (HashMap)localObject, null);
      localObject = new StringBuilder(256);
      ((StringBuilder)localObject).append("action=").append(this.action).append(", type=").append(this.type).append(", pkgName=").append(this.ctB).append(", jumpToAct=").append(this.ctC).append(", scheme=").append(this.scheme).append(", server_name=").append(str).append(", action_name=").append(paramIntent).append("\n data=").append(this.dataString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("JumpActivity.Report", 2, "business share |report params: \n" + ((StringBuilder)localObject).toString());
      return;
      paramIntent = "-1";
      str = "-1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqim
 * JD-Core Version:    0.7.0.1
 */