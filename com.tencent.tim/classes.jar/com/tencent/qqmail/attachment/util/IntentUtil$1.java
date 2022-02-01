package com.tencent.qqmail.attachment.util;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.smtt.sdk.ValueCallback;

final class IntentUtil$1
  implements ValueCallback<String>
{
  public void onReceiveValue(String paramString)
  {
    QMLog.log(4, "IntentUtil", "onReceiveValue:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.IntentUtil.1
 * JD-Core Version:    0.7.0.1
 */