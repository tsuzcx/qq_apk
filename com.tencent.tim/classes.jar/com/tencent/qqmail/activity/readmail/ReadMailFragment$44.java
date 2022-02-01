package com.tencent.qqmail.activity.readmail;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class ReadMailFragment$44
  implements QMCallback.ISuccessCallback
{
  ReadMailFragment$44(ReadMailFragment paramReadMailFragment) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if (paramQMNetworkResponse == null) {}
    do
    {
      do
      {
        return;
        Log.i("ReadMailFragment", "queryReminderSetting " + paramQMNetworkResponse.getResponseJson());
        paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
      } while (paramQMNetworkResponse == null);
      paramQMNetworkRequest = paramQMNetworkResponse.getString("open");
      paramQMNetworkResponse = paramQMNetworkResponse.getString("head");
      ReadMailFragment.access$11102(this.this$0, true);
      ReadMailFragment.access$11202(this.this$0, TextUtils.equals("1", paramQMNetworkRequest));
    } while (!ReadMailFragment.access$11200(this.this$0));
    try
    {
      ReadMailFragment.access$11302(this.this$0, Integer.parseInt(paramQMNetworkResponse));
      return;
    }
    catch (NumberFormatException paramQMNetworkRequest)
    {
      paramQMNetworkRequest.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.44
 * JD-Core Version:    0.7.0.1
 */