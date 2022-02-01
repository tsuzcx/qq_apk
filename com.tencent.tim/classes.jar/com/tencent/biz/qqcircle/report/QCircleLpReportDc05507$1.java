package com.tencent.biz.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pcp;
import pcr;
import pcu;
import qqcircle.QQCircleReport.SingleDcData;

public final class QCircleLpReportDc05507$1
  implements Runnable
{
  public QCircleLpReportDc05507$1(List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, boolean paramBoolean, String paramString, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.lw != null) {
      localArrayList.addAll(this.lw);
    }
    FeedCloudCommon.Entry localEntry1 = pcr.a("actiontype", String.valueOf(this.bha));
    FeedCloudCommon.Entry localEntry2 = pcr.a("subactiontype", String.valueOf(this.bhb));
    FeedCloudCommon.Entry localEntry3 = pcr.a("play_scene", String.valueOf(this.bhg));
    FeedCloudCommon.Entry localEntry4 = pcr.a("page_id", String.valueOf(this.aKa));
    FeedCloudCommon.Entry localEntry5 = pcr.a("fpage_id", String.valueOf(this.bhc));
    FeedCloudCommon.Entry localEntry6 = pcr.a("position_id", String.valueOf(this.val$position + 1));
    FeedCloudCommon.Entry localEntry7 = pcr.a("video_play_time", String.valueOf(this.zC));
    FeedCloudCommon.Entry localEntry8 = pcr.a("video_solo_time", String.valueOf(this.zD));
    if (this.azl) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localArrayList.addAll(Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, localEntry8, pcr.a("is_auto_play", (String)localObject), pcr.a("errorcode", this.adA) }));
      localArrayList.addAll(pcr.a().bz());
      localObject = pcr.a(pcp.access$000(), localArrayList, null, pcr.a().a(this.aKa, this.c));
      pcu.a().a((QQCircleReport.SingleDcData)localObject, pcp.ak(this.bha, this.bhb));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05507.1
 * JD-Core Version:    0.7.0.1
 */