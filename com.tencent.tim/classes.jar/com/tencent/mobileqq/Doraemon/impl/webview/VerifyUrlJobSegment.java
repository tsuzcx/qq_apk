package com.tencent.mobileqq.Doraemon.impl.webview;

import ajcn;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import jnm;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0xb60.CheckUrlReq;
import tencent.im.oidb.oidb_0xb60.ReqBody;
import uav;

public class VerifyUrlJobSegment
  extends JobSegment<ajcn, ajcn>
{
  public static LruCache<String, Long> o = new LruCache(16);
  public String aKq;
  
  public VerifyUrlJobSegment(String paramString)
  {
    this.aKq = paramString;
  }
  
  protected void a(JobContext paramJobContext, ajcn paramajcn)
  {
    paramJobContext = paramajcn.cacheKey + '_' + this.aKq;
    Object localObject = (Long)o.get(paramJobContext);
    if ((localObject != null) && (((Long)localObject).longValue() > NetConnInfoCenter.getServerTimeMillis()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "cache hit");
      }
      notifyResult(paramajcn);
    }
    do
    {
      do
      {
        return;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null) {
          break;
        }
        notifyError(new AppInfoError(7, "jobVerifyUrl app is null"));
      } while (!QLog.isColorLevel());
      QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "app is null");
      return;
      try
      {
        int i = Integer.parseInt(paramajcn.appId);
        oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
        localReqBody.check_url_req.setHasFlag(true);
        localReqBody.check_url_req.url.set(this.aKq);
        localReqBody.check_url_req.appid.set(i);
        localReqBody.check_url_req.app_type.set(paramajcn.appType);
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "send type=" + paramajcn.appType + ", appid=" + paramajcn.appId + ", url=" + this.aKq);
        }
        jnm.a((AppRuntime)localObject, new uav(this, paramajcn, paramJobContext), localReqBody.toByteArray(), "OidbSvc.0xb60_2", 2912, 2, null, 0L);
        return;
      }
      catch (NumberFormatException paramJobContext)
      {
        notifyError(new AppInfoError(7, "jobVerifyUrl parse appid error"));
      }
    } while (!QLog.isColorLevel());
    QLog.i("DoraemonOpenAPI.jobVerifyUrl", 2, "parse appid error");
  }
  
  public static class UrlNotauthorizedError
    extends Error
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment
 * JD-Core Version:    0.7.0.1
 */