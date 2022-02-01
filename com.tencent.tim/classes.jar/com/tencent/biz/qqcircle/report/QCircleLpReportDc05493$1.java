package com.tencent.biz.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pcj;
import pcr;
import pcu;
import qqcircle.QQCircleReport.SingleDcData;

public final class QCircleLpReportDc05493$1
  implements Runnable
{
  public QCircleLpReportDc05493$1(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("touin", this.Lw), pcr.a("login_time", String.valueOf(this.zr)), pcr.a("login_entrance", String.valueOf(this.zs)), pcr.a("sub_entrance", String.valueOf(this.zt)), pcr.a("thr_entrance", String.valueOf(this.zu)), pcr.a("report_from", "1"), pcr.a("ext1", this.arY), pcr.a("ext2", this.arZ), pcr.a("ext3", this.asa), pcr.a("ext4", this.asb), pcr.a("ext5", this.asc), pcr.a("ext6", this.asd) }));
    ((List)localObject).addAll(pcr.a().bz());
    localObject = pcr.a(pcj.access$000(), (List)localObject, null, pcr.a().z(this.val$scene));
    pcu.a().a((QQCircleReport.SingleDcData)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05493.1
 * JD-Core Version:    0.7.0.1
 */