package com.tencent.biz.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pcn;
import pcr;
import pcu;
import qqcircle.QQCircleReport.SingleDcData;

public final class QCircleLpReportDc05503$1
  implements Runnable
{
  public QCircleLpReportDc05503$1(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("login_time", String.valueOf(this.zy)), pcr.a("stay_time", String.valueOf(this.tI)), pcr.a("page_id", String.valueOf(this.zz)), pcr.a("ext1", this.arY), pcr.a("ext2", this.arZ), pcr.a("ext3", this.asa), pcr.a("ext4", this.asb), pcr.a("ext5", this.asc), pcr.a("ext6", this.asd) }));
    ((List)localObject).addAll(pcr.a().bz());
    localObject = pcr.a(pcn.access$000(), (List)localObject, null, pcr.a().z(this.val$scene));
    pcu.a().a((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05503.1
 * JD-Core Version:    0.7.0.1
 */