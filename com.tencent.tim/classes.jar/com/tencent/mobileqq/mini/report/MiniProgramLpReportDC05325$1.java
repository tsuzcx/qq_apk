package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import android.text.TextUtils;
import aqgz;
import aroi;
import avpp;
import avpq;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.RangeDownloadReport;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class MiniProgramLpReportDC05325$1
  implements Runnable
{
  MiniProgramLpReportDC05325$1(DownloadResult paramDownloadResult, MiniAppConfig paramMiniAppConfig, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject6;
      try
      {
        if (MiniProgramLpReportDC05325.access$000().containsKey(Long.valueOf(this.val$downloadResult.getProcess().startTimestamp)))
        {
          QLog.w("MiniProgramLpReportDC05325", 1, "It has been reported! url=" + this.val$downloadResult.getUrl());
          return;
        }
        MiniProgramLpReportDC05325.access$000().put(Long.valueOf(this.val$downloadResult.getProcess().startTimestamp), Boolean.valueOf(true));
        Object localObject1 = MiniProgramReportHelper.launchIdForMiniAppConfig(this.val$miniAppConfig);
        localObject3 = MiniProgramReportHelper.newEntry("uid", String.valueOf(aroi.a().getUin()));
        Object localObject4 = MiniProgramReportHelper.newEntry("launchid", (String)localObject1);
        Object localObject5 = MiniProgramReportHelper.newEntry("timestamp", "" + this.val$downloadResult.getProcess().startTimestamp);
        localObject6 = MiniProgramReportHelper.newEntry("qua", avpq.getQUA3());
        Object localObject7 = MiniProgramReportHelper.newEntry("deviceinfo", avpp.a().getDeviceInfor());
        COMM.Entry localEntry1 = MiniProgramReportHelper.newEntry("network_type", MiniProgramLpReportDC05325.getNetworkType());
        COMM.Entry localEntry2 = MiniProgramReportHelper.newEntry("userip", this.val$downloadResult.getContent().clientip);
        if (this.val$miniAppConfig != null)
        {
          localObject1 = this.val$miniAppConfig.config.appId;
          COMM.Entry localEntry3 = MiniProgramReportHelper.newEntry("appid", (String)localObject1);
          if (this.val$miniAppConfig == null) {
            break label1551;
          }
          localObject1 = "" + this.val$miniAppConfig.config.getReportType();
          COMM.Entry localEntry4 = MiniProgramReportHelper.newEntry("app_type", (String)localObject1);
          COMM.Entry localEntry5 = MiniProgramReportHelper.newEntry("resource_type", "" + this.val$resourceType);
          COMM.Entry localEntry6 = MiniProgramReportHelper.newEntry("download_url", this.val$downloadResult.getUrl());
          COMM.Entry localEntry7 = MiniProgramReportHelper.newEntry("ret_code", "" + MiniProgramLpReportDC05325.getRetCode(this.val$downloadResult));
          COMM.Entry localEntry8 = MiniProgramReportHelper.newEntry("download_channel", MiniProgramLpReportDC05325.getProtocol(this.val$downloadResult));
          if (this.val$downloadResult.getReport() == null) {
            break label1557;
          }
          localObject1 = this.val$downloadResult.getReport().remoteAddress;
          COMM.Entry localEntry9 = MiniProgramReportHelper.newEntry("download_ip", (String)localObject1);
          if (this.val$downloadResult.getReport() == null) {
            break label1563;
          }
          localObject1 = this.val$downloadResult.getReport().content_type;
          COMM.Entry localEntry10 = MiniProgramReportHelper.newEntry("download_ip_type", (String)localObject1);
          if (this.val$downloadResult.getReport() == null) {
            break label1569;
          }
          localObject1 = "" + this.val$downloadResult.getReport().currAttempCount;
          COMM.Entry localEntry11 = MiniProgramReportHelper.newEntry("retry_count", (String)localObject1);
          if (!TextUtils.isEmpty(this.val$downloadResult.getContent().redirectUrl)) {
            break label1575;
          }
          localObject1 = "0";
          COMM.Entry localEntry12 = MiniProgramReportHelper.newEntry("redirect_count", (String)localObject1);
          COMM.Entry localEntry13 = MiniProgramReportHelper.newEntry("direct_out_ip_count", "-1");
          COMM.Entry localEntry14 = MiniProgramReportHelper.newEntry("x_nws_log_uuid", MiniProgramLpReportDC05325.getHeader(this.val$downloadResult, "X-NWS-LOG-UUID"));
          if (this.val$downloadResult.getReport() == null) {
            break label1582;
          }
          localObject1 = this.val$downloadResult.getReport().content_type;
          COMM.Entry localEntry15 = MiniProgramReportHelper.newEntry("content_type", (String)localObject1);
          COMM.Entry localEntry16 = MiniProgramReportHelper.newEntry("content_length", "" + this.val$downloadResult.getContent().length);
          COMM.Entry localEntry17 = MiniProgramReportHelper.newEntry("content_encoding", this.val$downloadResult.getContent().encoding);
          COMM.Entry localEntry18 = MiniProgramReportHelper.newEntry("time_cost", "" + this.val$downloadResult.getProcess().duration);
          COMM.Entry localEntry19 = MiniProgramReportHelper.newEntry("time_cost_queue", "" + this.val$downloadResult.getProcess().totalDuration);
          if (this.val$downloadResult.getReport() == null) {
            break label1588;
          }
          localObject1 = "" + this.val$downloadResult.getReport().t_recvrsp;
          COMM.Entry localEntry20 = MiniProgramReportHelper.newEntry("time_cost_header", (String)localObject1);
          if (this.val$downloadResult.getReport() == null) {
            break label1594;
          }
          localObject1 = "" + this.val$downloadResult.getReport().t_recvdata;
          localObject3 = new ArrayList(Arrays.asList(new COMM.Entry[] { localObject3, localObject4, localObject5, localObject6, localObject7, localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, localEntry8, localEntry9, localEntry10, localEntry11, localEntry12, localEntry13, localEntry14, localEntry15, localEntry16, localEntry17, localEntry18, localEntry19, localEntry20, MiniProgramReportHelper.newEntry("time_cost_data", (String)localObject1), MiniProgramReportHelper.newEntry("download_mode", String.valueOf(this.val$downloadResult.getReport().downloadMode)), MiniProgramReportHelper.newEntry("time_cost_range_receive", String.valueOf(this.val$downloadResult.getReport().timeCostForRangeReceivePhase)), MiniProgramReportHelper.newEntry("time_cost_range_merge", String.valueOf(this.val$downloadResult.getReport().timeCostForRangeMergePhase)), MiniProgramReportHelper.newEntry("protocol", this.val$downloadResult.getReport().protocol), MiniProgramReportHelper.newEntry("perf_level", String.valueOf(aqgz.getPerfLevel())), MiniProgramReportHelper.newEntry("range_number", String.valueOf(this.val$downloadResult.getReport().rangeNumber)), MiniProgramReportHelper.newEntry("range_type", "0"), MiniProgramReportHelper.newEntry("download_id", String.valueOf(aroi.a().getUin()) + this.val$downloadResult.getProcess().startTimestamp), MiniProgramReportHelper.newEntry("range_id", "0") }));
          localObject1 = new ArrayList();
          ((List)localObject1).add(localObject3);
          if ((this.val$downloadResult.getReport().downloadMode != Downloader.DownloadMode.RangeMode.ordinal()) || (this.val$downloadResult.getReport().rangeDownloadReports == null)) {
            break label1494;
          }
          localObject4 = this.val$downloadResult.getReport().rangeDownloadReports.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label1494;
          }
          localObject5 = (RangeDownloadReport)((Iterator)localObject4).next();
          localObject6 = new ArrayList();
          localObject7 = ((ArrayList)localObject3).iterator();
          if (!((Iterator)localObject7).hasNext()) {
            break label1482;
          }
          localEntry1 = (COMM.Entry)((Iterator)localObject7).next();
          localEntry1 = (COMM.Entry)new COMM.Entry().mergeFrom(localEntry1.toByteArray());
          if ("content_length".equals(localEntry1.key.get())) {
            localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject5).getContentLength()));
          }
          if ("time_cost".equals(localEntry1.key.get())) {
            localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject5).getTimeCost()));
          }
          if ("time_cost_header".equals(localEntry1.key.get())) {
            localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject5).getTimeCostHeader()));
          }
          if ("time_cost_data".equals(localEntry1.key.get())) {
            localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject5).getTimeCostData()));
          }
          if ("range_type".equals(localEntry1.key.get())) {
            localEntry1.value.set("1");
          }
          if ("range_id".equals(localEntry1.key.get())) {
            localEntry1.value.set(String.valueOf(((RangeDownloadReport)localObject5).getRangeId()));
          }
          ((List)localObject6).add(localEntry1);
          continue;
        }
        localObject2 = "";
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniProgramLpReportDC05325", 1, "", localThrowable);
        return;
      }
      continue;
      label1482:
      ((List)localObject2).add(localObject6);
      continue;
      label1494:
      Object localObject3 = new ArrayList();
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject3).add(MiniProgramReportHelper.newSingleReportData(10, (List)((Iterator)localObject2).next(), null));
      }
      MiniProgramReporter.getInstance().batchAddAll((List)localObject3);
      return;
      label1551:
      localObject2 = "";
      continue;
      label1557:
      localObject2 = "";
      continue;
      label1563:
      localObject2 = "";
      continue;
      label1569:
      localObject2 = "";
      continue;
      label1575:
      localObject2 = "1";
      continue;
      label1582:
      localObject2 = "";
      continue;
      label1588:
      localObject2 = "";
      continue;
      label1594:
      localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325.1
 * JD-Core Version:    0.7.0.1
 */