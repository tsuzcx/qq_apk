package com.tencent.biz.qqcircle.report;

import com.tencent.TMG.utils.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pco;
import pcr;
import pcu;
import qqcircle.QQCircleReport.SingleDcData;

public final class QCircleLpReportDc05504$1
  implements Runnable
{
  public QCircleLpReportDc05504$1(String paramString1, int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("touin", this.Lw), pcr.a("actiontype", String.valueOf(this.bha)), pcr.a("subactiontype", String.valueOf(this.zA)), pcr.a("thr_action", String.valueOf(this.zB)), pcr.a("page_id", String.valueOf(this.aKa)), pcr.a("fpage_id", String.valueOf(this.bhc)), pcr.a("ext1", this.arY), pcr.a("ext2", this.arZ), pcr.a("ext6", this.asd), pcr.a("ext7", this.ass), pcr.a("vid", this.val$vid) }));
    ((List)localObject).addAll(pcr.a().bz());
    localObject = pcr.a(pco.access$000(), (List)localObject, null, pcr.a().z(this.aKa));
    if (pcr.a().HM())
    {
      pcu.a().a((QQCircleReport.SingleDcData)localObject, false);
      return;
    }
    QLog.w("QCircleReporter", 1, "QCircleLpReportDc05504 report miss Session: actiontype:" + this.bha + ",subActionType:" + this.zA + ",add Miss Session report cache list");
    pcu.a().b((QQCircleReport.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05504.1
 * JD-Core Version:    0.7.0.1
 */