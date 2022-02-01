package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pcm;
import pcr;
import pcu;
import qqcircle.QQCircleFeedBase.StReportInfoForClient;
import qqcircle.QQCircleReport.SingleDcData;

public final class QCircleLpReportDc05502$1
  implements Runnable
{
  public QCircleLpReportDc05502$1(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, List paramList, FeedCloudMeta.StFeed paramStFeed, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("touin", this.Lw), pcr.a("index", String.valueOf(this.val$index + 1)), pcr.a("feedid", this.asf), pcr.a("feed_tag", this.asm), pcr.a("isreaded", "1"), pcr.a("page_id", String.valueOf(this.aKa)), pcr.a("fpage_id", String.valueOf(this.bhc)), pcr.a("begin_time", this.asp), pcr.a("end_time", this.asq), pcr.a("stay_time", this.asr), pcr.a("author_uin", this.aso) }));
    if (this.lv != null) {
      ((List)localObject).addAll(this.lv);
    }
    if (this.bhc > -1) {
      ((List)localObject).add(pcr.a("fpage_id", String.valueOf(this.bhc)));
    }
    QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient;
    if (this.c != null) {
      if (this.c.reportInfoForClient.has()) {
        localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
      }
    }
    for (;;)
    {
      try
      {
        localStReportInfoForClient.mergeFrom(this.c.reportInfoForClient.get().toByteArray());
        ((List)localObject).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("feedtype1", String.valueOf(localStReportInfoForClient.feedtype1.get())), pcr.a("feedtype2", String.valueOf(localStReportInfoForClient.feedtype2.get())), pcr.a("feedtype3", String.valueOf(localStReportInfoForClient.feedtype3.get())) }));
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        i = 0;
        continue;
      }
      if (i == 0) {
        ((List)localObject).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("feedtype1", String.valueOf(this.bhe)), pcr.a("feedtype2", String.valueOf(this.bhf)) }));
      }
      ((List)localObject).addAll(pcr.a().bz());
      localObject = pcr.a(pcm.access$000(), (List)localObject, null, pcr.a().a(this.aKa, this.c));
      pcu.a().a((QQCircleReport.SingleDcData)localObject, true);
      return;
      int i = 0;
      continue;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05502.1
 * JD-Core Version:    0.7.0.1
 */