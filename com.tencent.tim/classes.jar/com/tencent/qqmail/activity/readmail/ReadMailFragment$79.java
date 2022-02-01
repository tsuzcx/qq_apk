package com.tencent.qqmail.activity.readmail;

import android.util.Log;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class ReadMailFragment$79
  implements QMCallback.ISuccessCallback
{
  ReadMailFragment$79(ReadMailFragment paramReadMailFragment) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    Log.i("ReadMailFragment", "setOnSuccess " + paramQMNetworkResponse);
    try
    {
      paramQMNetworkRequest = (JSONObject)((JSONObject)paramQMNetworkResponse.getResponseJson()).getJSONArray("journeylist").get(0);
      ReadMailFragment.access$15402(this.this$0, paramQMNetworkRequest.getString("destination"));
      long l = Long.parseLong(paramQMNetworkRequest.getString("destination_time"));
      ReadMailFragment.access$15502(this.this$0, DateExtension.getIcsYMDFormat(l * 1000L));
      return;
    }
    catch (Exception paramQMNetworkRequest)
    {
      ReadMailFragment.access$15402(this.this$0, null);
      ReadMailFragment.access$15502(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.79
 * JD-Core Version:    0.7.0.1
 */