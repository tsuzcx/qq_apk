package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.EmailAccountInfo;
import com.tencent.qqmail.utilities.thread.Threads;

final class DeveloperActivity$1
  extends SimpleOnProtocolListener
{
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      EmailAccountInfo[] arrayOfEmailAccountInfo = paramCloudProtocolResult.account_list_;
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < arrayOfEmailAccountInfo.length)
      {
        localStringBuilder.append(arrayOfEmailAccountInfo[i].email).append("\n");
        i += 1;
      }
      Threads.runOnMainThread(new DeveloperActivity.1.1(this, localStringBuilder));
    }
    super.onCloudResult(paramCloudProtocolResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.DeveloperActivity.1
 * JD-Core Version:    0.7.0.1
 */