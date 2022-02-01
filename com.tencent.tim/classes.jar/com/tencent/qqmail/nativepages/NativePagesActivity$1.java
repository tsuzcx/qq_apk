package com.tencent.qqmail.nativepages;

import com.tencent.moai.nativepages.util.DataUtil.DataCollectionDelegate;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.OssHelper;

class NativePagesActivity$1
  implements DataUtil.DataCollectionDelegate
{
  NativePagesActivity$1(NativePagesActivity paramNativePagesActivity) {}
  
  public void collect(String paramString)
  {
    paramString = NativePagesActivity.access$000(this.this$0).getServerId() + "," + paramString;
    QMLog.log(4, "NativePagesActivity", "collect detail = " + paramString);
    OssHelper.nativeAdsDetail(new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.nativepages.NativePagesActivity.1
 * JD-Core Version:    0.7.0.1
 */