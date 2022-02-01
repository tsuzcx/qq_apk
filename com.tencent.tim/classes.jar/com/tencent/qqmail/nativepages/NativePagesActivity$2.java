package com.tencent.qqmail.nativepages;

import com.tencent.moai.nativepages.util.LogUtil.LogUtilsDelegate;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

class NativePagesActivity$2
  implements LogUtil.LogUtilsDelegate
{
  NativePagesActivity$2(NativePagesActivity paramNativePagesActivity) {}
  
  public void kvlog(String paramString)
  {
    QMLog.log(4, "NativePagesActivity", "Native kvlog event : " + paramString);
    if ("PARSE_XML_FAIL_EVENT".equals(paramString)) {
      KvHelper.nativeAdsParseXmlFail(new double[0]);
    }
  }
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    QMLog.log(paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.nativepages.NativePagesActivity.2
 * JD-Core Version:    0.7.0.1
 */