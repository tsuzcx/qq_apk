package com.tencent.biz.qqcircle.report;

import android.os.Build;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pck;
import pcr;
import pcu;
import qqcircle.QQCircleReport.SingleDcData;

public final class QCircleLpReportDc05494$1
  implements Runnable
{
  public QCircleLpReportDc05494$1(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, int paramInt4, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString10, String paramString11, long paramLong3, String paramString12) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("up_source", String.valueOf(this.bgU)), pcr.a("up_type", String.valueOf(this.bgV)), pcr.a("is_video", String.valueOf(this.bgW)), pcr.a("txtinfo", this.ase), pcr.a("lloc", this.ER), pcr.a("vid", this.val$vid), pcr.a("photocubage", String.valueOf(this.zv)), pcr.a("feedid", this.asf), pcr.a("total_upload_num", String.valueOf(this.bgX)), pcr.a("device_maker", Build.BRAND), pcr.a("device_model", Build.MODEL), pcr.a("shooting_time", this.asg), pcr.a("orig_photocubage", String.valueOf(this.zw)), pcr.a("place", this.ash), pcr.a("up_place", this.asi), pcr.a("shoot_product", this.asj), pcr.a("shoot_model", this.ask), pcr.a("width", String.valueOf(this.val$width)), pcr.a("height", String.valueOf(this.val$height)), pcr.a("orig_width", String.valueOf(this.bgY)), pcr.a("orig_height", String.valueOf(this.bgZ)), pcr.a("picture_format", this.asl), pcr.a("feed_tag", this.asm), pcr.a("author_uin", String.valueOf(this.zx)), pcr.a("shoot_place", this.asn) }));
    ((List)localObject).addAll(pcr.a().bz());
    localObject = pcr.a(pck.access$000(), (List)localObject, null, pcr.a().z(pck.access$100()));
    pcu.a().a((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05494.1
 * JD-Core Version:    0.7.0.1
 */