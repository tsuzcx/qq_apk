import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.ReportTrace.ExtParam;
import com.tencent.pb.ReportTrace.ReportAnnoReq;
import com.tencent.pb.ReportTrace.ReportHead;
import com.tencent.pb.ReportTrace.ReportTraceReq;
import com.tencent.pb.ReportTrace.ReportTraceRsp;
import com.tencent.pb.ReportTrace.SpanAnnoEntry;
import com.tencent.pb.ReportTrace.SpanEntry;
import com.tencent.pb.ReportTrace.TraceAnnoEntry;
import com.tencent.pb.ReportTrace.TraceEntry;
import com.tencent.pb.ReportTrace.reportStat;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class abwq
  implements abwt, BusinessObserver
{
  private WeakReference<abwu> fS;
  
  private ReportTrace.ReportHead a(abwi paramabwi, String paramString)
  {
    ReportTrace.ReportHead localReportHead = new ReportTrace.ReportHead();
    localReportHead.appid.set(paramabwi.getAppId());
    localReportHead.platform.set(109);
    paramabwi = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramabwi = "3.4.4";
    }
    localReportHead.ver.set(paramabwi);
    paramabwi = aqgz.getDeviceOSVersion();
    if (!TextUtils.isEmpty(paramabwi)) {
      localReportHead.os_ver.set(paramabwi);
    }
    paramabwi = aqgz.getModel();
    if (!TextUtils.isEmpty(paramabwi)) {
      localReportHead.model.set(paramabwi);
    }
    paramabwi = aqgz.getIMEI();
    if (!TextUtils.isEmpty(paramabwi)) {
      localReportHead.udid.set(paramabwi);
    }
    return localReportHead;
  }
  
  private ReportTrace.SpanEntry a(abxa paramabxa)
  {
    ReportTrace.SpanEntry localSpanEntry = new ReportTrace.SpanEntry();
    localSpanEntry.span_id.set(paramabxa.ctl);
    localSpanEntry.time_stamp.set(paramabxa.timestamp);
    if (paramabxa.result != null) {
      localSpanEntry.result.set(a(paramabxa.result));
    }
    if ((paramabxa.je != null) && (paramabxa.je.size() > 0))
    {
      paramabxa = paramabxa.je.entrySet().iterator();
      while (paramabxa.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramabxa.next();
        ReportTrace.ExtParam localExtParam = new ReportTrace.ExtParam();
        localExtParam.param_id.set(((Integer)localEntry.getKey()).intValue());
        localExtParam.value.set(((Long)localEntry.getValue()).longValue());
        localSpanEntry.param_list.add(localExtParam);
      }
    }
    return localSpanEntry;
  }
  
  private ReportTrace.TraceEntry a(TraceData paramTraceData, abwi paramabwi)
  {
    ReportTrace.TraceEntry localTraceEntry = new ReportTrace.TraceEntry();
    localTraceEntry.feature_id.set(paramTraceData.featureId);
    localTraceEntry.trace_id.set(paramTraceData.traceId);
    localTraceEntry.from_uid.set(paramabwi.mw());
    if (!TextUtils.isEmpty(paramTraceData.tUid)) {
      localTraceEntry.to_uid.set(paramTraceData.tUid);
    }
    localTraceEntry.time_stamp.set(paramTraceData.timestamp);
    localTraceEntry.server_timestamp.set(paramTraceData.serverTime);
    if (paramTraceData.result != null) {
      localTraceEntry.result.set(a(paramTraceData.result));
    }
    if (paramTraceData.mSpanQueue != null)
    {
      paramabwi = paramTraceData.mSpanQueue.iterator();
      while (paramabwi.hasNext())
      {
        abxa localabxa = (abxa)paramabwi.next();
        localTraceEntry.span_list.add(a(localabxa));
      }
    }
    localTraceEntry.extra1.set(paramTraceData.extra1);
    localTraceEntry.extra2.set(paramTraceData.extra2);
    localTraceEntry.extra3.set(paramTraceData.extra3);
    return localTraceEntry;
  }
  
  private ReportTrace.reportStat a(abwz paramabwz)
  {
    ReportTrace.reportStat localreportStat = new ReportTrace.reportStat();
    localreportStat.ret.set(paramabwz.errCode);
    localreportStat.cost.set(paramabwz.amq);
    localreportStat.net_type.set(paramabwz.netType);
    localreportStat.cpu.set(paramabwz.cti);
    localreportStat.memory.set(paramabwz.cth);
    localreportStat.java_heap.set(paramabwz.ctj);
    localreportStat.native_heap.set(paramabwz.ctk);
    return localreportStat;
  }
  
  private List<ReportTrace.SpanAnnoEntry> a(BlockingQueue<abxa> paramBlockingQueue)
  {
    if ((paramBlockingQueue == null) || (paramBlockingQueue.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBlockingQueue = paramBlockingQueue.iterator();
    while (paramBlockingQueue.hasNext())
    {
      abxa localabxa = (abxa)paramBlockingQueue.next();
      if ((localabxa.l != null) && (localabxa.l.size() > 0))
      {
        Iterator localIterator = localabxa.l.iterator();
        while (localIterator.hasNext())
        {
          abwx localabwx = (abwx)localIterator.next();
          ReportTrace.SpanAnnoEntry localSpanAnnoEntry = new ReportTrace.SpanAnnoEntry();
          localSpanAnnoEntry.span_id.set(localabxa.ctl);
          if (!TextUtils.isEmpty(localabwx.msg)) {
            localSpanAnnoEntry.anno_msg.set(localabwx.msg);
          }
          if (localabxa.result != null) {
            localSpanAnnoEntry.errCode.set(localabxa.result.errCode);
          }
          localSpanAnnoEntry.time_stamp.set(localabwx.timestamp);
          localArrayList.add(localSpanAnnoEntry);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(AppRuntime paramAppRuntime, abwi paramabwi, String paramString, List<ReportTrace.TraceEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramabwi == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportTraceReq localReportTraceReq = new ReportTrace.ReportTraceReq();
    localReportTraceReq.head.set(a(paramabwi, paramString));
    localReportTraceReq.trace_list.set(paramList);
    paramabwi = new NewIntent(paramAppRuntime.getApplication(), abww.class);
    paramabwi.putExtra("cmd", "apollo_monitor.report_trace");
    paramabwi.putExtra("data", localReportTraceReq.toByteArray());
    paramabwi.putExtra("timeout", 30000);
    paramabwi.setObserver(this);
    paramAppRuntime.startServlet(paramabwi);
  }
  
  private void b(AppRuntime paramAppRuntime, abwi paramabwi, String paramString, List<ReportTrace.TraceAnnoEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramabwi == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportAnnoReq localReportAnnoReq = new ReportTrace.ReportAnnoReq();
    localReportAnnoReq.head.set(a(paramabwi, paramString));
    localReportAnnoReq.anno_list.set(paramList);
    paramabwi = new NewIntent(paramAppRuntime.getApplication(), abww.class);
    paramabwi.putExtra("cmd", "apollo_monitor.report_anno");
    paramabwi.putExtra("data", localReportAnnoReq.toByteArray());
    paramabwi.putExtra("timeout", 30000);
    paramabwi.setObserver(this);
    paramAppRuntime.startServlet(paramabwi);
  }
  
  public void a(abwu paramabwu)
  {
    this.fS = new WeakReference(paramabwu);
  }
  
  public void ig(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    abwi localabwi = abwk.a().b();
    if ((localAppRuntime != null) && (paramList != null) && (localabwi != null) && (!TextUtils.isEmpty(localabwi.mw())))
    {
      ArrayList localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceEntry localTraceEntry = a(localTraceData, localabwi);
        if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("3.4.4")))
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localTraceEntry);
          a(localAppRuntime, localabwi, localTraceData.version, localArrayList2);
        }
        else
        {
          localArrayList1.add(a(localTraceData, localabwi));
        }
      }
      a(localAppRuntime, localabwi, null, localArrayList1);
    }
  }
  
  public void ih(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    abwi localabwi = abwk.a().b();
    if ((localAppRuntime != null) && (paramList != null) && (localabwi != null) && (!TextUtils.isEmpty(localabwi.mw())))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceAnnoEntry localTraceAnnoEntry = new ReportTrace.TraceAnnoEntry();
        localTraceAnnoEntry.uid.set(localabwi.mw());
        localTraceAnnoEntry.trace_id.set(localTraceData.traceId);
        localTraceAnnoEntry.feature_id.set(localTraceData.featureId);
        localTraceAnnoEntry.server_timestamp.set(localTraceData.serverTime);
        int j = i;
        if (localTraceData.result != null)
        {
          j = i;
          if (localTraceData.result.errCode != 0)
          {
            localTraceAnnoEntry.ret.set(localTraceData.result.errCode);
            Object localObject = a(localTraceData.mSpanQueue);
            if (localObject != null) {
              localTraceAnnoEntry.span_anno_list.addAll((Collection)localObject);
            }
            if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("3.4.4")))
            {
              localObject = new ArrayList();
              ((List)localObject).add(localTraceAnnoEntry);
              b(localAppRuntime, localabwi, localTraceData.version, (List)localObject);
              continue;
            }
            j = 1;
            localArrayList.add(localTraceAnnoEntry);
          }
        }
        i = j;
      }
      if (i != 0) {
        b(localAppRuntime, localabwi, null, localArrayList);
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("cmd");
    if (("apollo_monitor.report_trace".equals(str)) || ("apollo_monitor.report_anno".equals(str)))
    {
      if (paramBoolean) {
        break label318;
      }
      paramInt = paramBundle.getInt("retryTime");
      QLog.w("TraceReport", 1, "cmd:" + str + ",retryTime:" + paramInt);
    }
    for (;;)
    {
      Object localObject1;
      if (("apollo_monitor.report_trace".equals(str)) && (paramBoolean) && (this.fS != null)) {
        localObject1 = new ReportTrace.ReportTraceRsp();
      }
      for (;;)
      {
        try
        {
          localObject2 = (abwu)this.fS.get();
          if (localObject2 != null)
          {
            ((ReportTrace.ReportTraceRsp)localObject1).mergeFrom(paramBundle.getByteArray("data"));
            int i = ((ReportTrace.ReportTraceRsp)localObject1).report_interval.get();
            int j = ((ReportTrace.ReportTraceRsp)localObject1).report_num.get();
            if (((ReportTrace.ReportTraceRsp)localObject1).report_fail.get() != 1) {
              continue;
            }
            bool = true;
            ((abwu)localObject2).w(i, j, bool);
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          boolean bool;
          QLog.e("TraceReport", 1, localException, new Object[0]);
          continue;
        }
        localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
        if ((!paramBoolean) && (paramInt < 1) && (localObject1 != null))
        {
          localObject2 = new NewIntent(((AppRuntime)localObject1).getApplication(), abww.class);
          ((NewIntent)localObject2).putExtra("retryTime", paramInt + 1);
          ((NewIntent)localObject2).putExtra("cmd", str);
          ((NewIntent)localObject2).putExtra("data", paramBundle.getByteArray("request_data"));
          ((NewIntent)localObject2).putExtra("timeout", 30000);
          ((NewIntent)localObject2).setObserver(this);
          ((AppRuntime)localObject1).startServlet((NewIntent)localObject2);
        }
        return;
        bool = false;
      }
      label318:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwq
 * JD-Core Version:    0.7.0.1
 */