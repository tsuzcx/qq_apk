package com.tencent.biz.qqcircle.report;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pcp;
import pcr;
import pcu;
import qqcircle.QQCircleFeedBase.StReportInfoForClient;
import qqcircle.QQCircleReport.SingleDcData;

public final class QCircleLpReportDc05507$2
  implements Runnable
{
  public QCircleLpReportDc05507$2(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, List paramList, FeedCloudMeta.StFeed paramStFeed, int paramInt7, int paramInt8) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("touin", this.Lw), pcr.a("actiontype", String.valueOf(this.bha)), pcr.a("subactiontype", String.valueOf(this.bhb)), pcr.a("feedid", this.dL), pcr.a("author_uin", this.ast), pcr.a("play_scene", String.valueOf(this.bhg)), pcr.a("page_id", String.valueOf(this.aKa)), pcr.a("fpage_id", String.valueOf(this.bhc)), pcr.a("position_id", String.valueOf(this.val$position + 1)), pcr.a("feed_tag", this.asm), pcr.a("video_tag", this.asu), pcr.a("pic_info", this.asv), pcr.a("item_detail", this.asw), pcr.a("acttime", String.valueOf(System.currentTimeMillis())), pcr.a("lloc", this.ER) }));
    if (this.lv != null) {
      ((List)localObject).addAll(this.lv);
    }
    QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient;
    if (this.c != null) {
      if (this.c.reportInfoForClient.has()) {
        localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
      }
    }
    for (;;)
    {
      int i;
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
      localObject = pcr.a(pcp.access$000(), (List)localObject, null, pcr.a().a(this.aKa, this.c));
      if (pcr.a().HM())
      {
        pcu.a().a((QQCircleReport.SingleDcData)localObject, pcp.ak(this.bha, this.bhb));
        return;
        i = 0;
      }
      else
      {
        QLog.w("QCircleReporter", 1, "QCircleLpReportDc05507 report miss Session: actiontype:" + this.bha + ",subActionType:" + this.bhb + ",add Miss Session report cache list");
        pcu.a().b((QQCircleReport.SingleDcData)localObject);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05507.2
 * JD-Core Version:    0.7.0.1
 */