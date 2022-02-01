package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

public class CgiTimer
{
  private static final String TAG = "CgiTimer";
  
  public static void report(String paramString, double paramDouble)
  {
    String str = QMUrlUtil.getPath(paramString);
    QMLog.log(4, "CgiTimer", "url " + paramString + " path " + str + " usedTime " + paramDouble);
    if (str.equals("/cgi-bin/readmail")) {
      KvHelper.cgiRttReadmail(new double[] { paramDouble });
    }
    do
    {
      return;
      if (str.equals("/cgi-bin/mobile_syn"))
      {
        KvHelper.cgiRttMobileSync(new double[] { paramDouble });
        return;
      }
      if (str.equals("/cgi-bin/mail_list"))
      {
        KvHelper.cgiRttMaillist(new double[] { paramDouble });
        return;
      }
      if (str.equals("/cgi-bin/compose_send"))
      {
        KvHelper.cgiRttComposeSend(new double[] { paramDouble });
        return;
      }
      if (str.equals("/Microsoft-Server-ActiveSync"))
      {
        KvHelper.cgiRttActivesync(new double[] { paramDouble });
        return;
      }
      if (str.equals("/cgi-bin/uma_photo_sync_content"))
      {
        KvHelper.cgiRttPhotoSync(new double[] { paramDouble });
        return;
      }
      if (str.equals("/cgi-bin/mail_mgr"))
      {
        KvHelper.cgiRttMailMgr(new double[] { paramDouble });
        return;
      }
      if (str.equals("/cgi-bin/oss_log"))
      {
        KvHelper.cgiRttOssLog(new double[] { paramDouble });
        return;
      }
      if (str.equals("/cgi-bin/uma_get_birthfriend_list"))
      {
        KvHelper.cgiRttBirthList(new double[] { paramDouble });
        return;
      }
    } while (!str.equals("/cgi-bin/uma_data_report"));
    KvHelper.cgiRttUmaDataReport(new double[] { paramDouble });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.CgiTimer
 * JD-Core Version:    0.7.0.1
 */