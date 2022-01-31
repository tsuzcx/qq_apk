import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.monitor.APIQuotaEntity;
import com.tencent.mobileqq.Doraemon.monitor.APIQuotaItem;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.1;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.3;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.4;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_0xb6f.Identity;
import tencent.im.oidb.oidb_0xb6f.ReportFreqReqBody;
import tencent.im.oidb.oidb_0xb6f.ReqBody;

public class zuj
  implements zuh
{
  zui a;
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("DoraemonOpenAPI.report", 1, "app is null");
      return;
    }
    oidb_0xb6f.ReqBody localReqBody = new oidb_0xb6f.ReqBody();
    localReqBody.report_freq_req.identity.apptype.set(paramInt1);
    try
    {
      localReqBody.report_freq_req.identity.appid.set(Integer.parseInt(paramString2));
      localReqBody.report_freq_req.identity.apiName.set(paramString3);
      localReqBody.report_freq_req.identity.setHasFlag(true);
      localReqBody.report_freq_req.invoke_times.set(paramInt2);
      localReqBody.report_freq_req.setHasFlag(true);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.report", 2, "send key=" + paramString1 + ", api=" + paramString3 + ", count=" + paramInt2);
      }
      mmj.a(localAppRuntime, new zuk(this, paramString1, paramString3, paramInt2), localReqBody.toByteArray(), "OidbSvc.0xb6f_1", 2927, 1, null, 0L);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("DoraemonOpenAPI.report", 1, "parse appid error appid=" + paramString2, paramString1);
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.report", 2, "updateFrequenceData key=" + paramString1 + ", api=" + paramString3 + ", remain=" + paramLong1 + ", exp=" + paramLong2);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      ThreadManager.post(new DoraemonAPIReporterMain.3(this, (QQAppInterface)localObject, paramInt, paramString2, paramString3, paramLong1, paramLong2), 5, null, true);
    }
    for (;;)
    {
      localObject = this.a;
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new DoraemonAPIReporterMain.4(this, (zui)localObject, paramString1, paramInt, paramString2, paramString3, paramLong1, paramLong2));
      }
      return;
      QLog.e("DoraemonOpenAPI.report", 1, "app is null");
    }
  }
  
  private void a(String paramString, List<APIQuotaEntity> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.report", 2, "updateFrequenceDataBatch key=" + paramString);
    }
    zui localzui = this.a;
    if (localzui != null)
    {
      HashMap localHashMap = new HashMap(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        APIQuotaEntity localAPIQuotaEntity = (APIQuotaEntity)paramList.next();
        APIQuotaItem localAPIQuotaItem = new APIQuotaItem();
        localAPIQuotaItem.remainTimes = localAPIQuotaEntity.remainTimes;
        localAPIQuotaItem.expireTimeMillis = localAPIQuotaEntity.expireTimeMillis;
        localHashMap.put(localAPIQuotaEntity.apiName, localAPIQuotaItem);
      }
      ThreadManager.getUIHandler().post(new DoraemonAPIReporterMain.5(this, localzui, paramString, localHashMap));
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      QLog.e("DoraemonOpenAPI.report", 1, "app is null");
      return;
    }
    ThreadManager.post(new DoraemonAPIReporterMain.1(this, (QQAppInterface)localAppRuntime, paramInt, paramString2, paramString1), 5, null, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, paramString2, paramString3, 1);
  }
  
  public void a(zui paramzui)
  {
    this.a = paramzui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zuj
 * JD-Core Version:    0.7.0.1
 */