package com.tencent.mobileqq.miniapp;

import ajcn;
import ajco;
import ajco.a;
import ajcp;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jnm;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0xb61.GetAppinfoReq;
import tencent.im.oidb.oidb_0xb61.GetPkgUrlReq;
import tencent.im.oidb.oidb_0xb61.ReqBody;

public class MiniAppInfoManager$1
  implements Runnable
{
  public MiniAppInfoManager$1(ajco paramajco, ajco.a parama, ajcn paramajcn, int paramInt) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      if ((this.a != null) && (this.a.bs != null)) {
        this.a.a(this.a.bs.get(), false, this.c);
      }
    }
    label247:
    do
    {
      return;
      for (;;)
      {
        int i;
        oidb_0xb61.ReqBody localReqBody;
        try
        {
          i = Integer.parseInt(this.c.appId);
          localReqBody = new oidb_0xb61.ReqBody();
          if (this.YA != 1) {
            break label247;
          }
          localReqBody.get_appinfo_req.setHasFlag(true);
          localReqBody.get_appinfo_req.appid.set(i);
          localReqBody.get_appinfo_req.app_type.set(this.c.appType);
          if (QLog.isColorLevel()) {
            QLog.i("MiniAppInfoManager", 2, "serviceType=" + this.YA + ", apptype=" + this.c.appType + ", appid=" + this.c.appId);
          }
          jnm.a(localAppRuntime, new ajcp(this), localReqBody.toByteArray(), "OidbSvc.0xb61", 2913, this.YA, null, 0L);
          return;
        }
        catch (NumberFormatException localNumberFormatException) {}
        if ((this.a == null) || (this.a.bs == null)) {
          break;
        }
        this.a.a(this.a.bs.get(), false, this.c);
        return;
        if (this.YA != 2) {
          break label350;
        }
        localReqBody.get_mqqapp_url_req.setHasFlag(true);
        localReqBody.get_mqqapp_url_req.appid.set(i);
        localReqBody.get_mqqapp_url_req.app_type.set(this.c.appType);
        localReqBody.get_mqqapp_url_req.app_version.set(this.c.appVersion);
        localReqBody.get_mqqapp_url_req.platform.set(4);
        localReqBody.get_mqqapp_url_req.sys_version.set(String.valueOf(Build.VERSION.SDK_INT));
        localReqBody.get_mqqapp_url_req.qq_version.set("3.4.4");
      }
    } while ((this.a == null) || (this.a.bs == null));
    label350:
    this.a.a(this.a.bs.get(), false, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfoManager.1
 * JD-Core Version:    0.7.0.1
 */