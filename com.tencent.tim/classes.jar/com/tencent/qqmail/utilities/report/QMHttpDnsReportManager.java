package com.tencent.qqmail.utilities.report;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils.NetworkType;
import moai.oss.OssHelper;

public class QMHttpDnsReportManager
{
  public static void testIp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l;
    Object localObject;
    if (QMReportManager.ReportType.HTTPDNS_OSS_WATCH.enable())
    {
      l = System.currentTimeMillis() / 1000L;
      localObject = QMNetworkUtils.getActiveNetworkType();
      if (localObject != QMNetworkUtils.NetworkType.WIFI) {
        break label97;
      }
      localObject = "4";
    }
    for (;;)
    {
      OssHelper.httpDns(new Object[] { "1", String.valueOf(l), "", localObject, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
      return;
      label97:
      if ((localObject == QMNetworkUtils.NetworkType.MOBILE_2G) || (localObject == QMNetworkUtils.NetworkType.MOBILE_2G_WAP)) {
        localObject = "1";
      } else if ((localObject == QMNetworkUtils.NetworkType.MOBILE_3G) || (localObject == QMNetworkUtils.NetworkType.MOBILE_3G_WAP)) {
        localObject = "3";
      } else if ((localObject == QMNetworkUtils.NetworkType.MOBILE_4G) || (localObject == QMNetworkUtils.NetworkType.MOBILE_4G_WAP)) {
        localObject = "5";
      } else {
        localObject = "2";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.report.QMHttpDnsReportManager
 * JD-Core Version:    0.7.0.1
 */