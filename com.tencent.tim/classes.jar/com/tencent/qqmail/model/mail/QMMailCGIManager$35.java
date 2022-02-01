package com.tencent.qqmail.model.mail;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.calendar.fragment.CalendarMainFragment.CreditCardDetailCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$35
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$35(QMMailCGIManager paramQMMailCGIManager, CalendarMainFragment.CreditCardDetailCallback paramCreditCardDetailCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    Object localObject1 = null;
    Object localObject2 = new StringBuilder().append("getMailReminderCreditDetail setOnSuccess ");
    if (paramQMNetworkResponse == null)
    {
      paramQMNetworkRequest = null;
      Log.i("QMMailCGIManager", paramQMNetworkRequest);
      if (!TextUtils.equals("0", ((JSONObject)paramQMNetworkResponse.getResponseJson()).getString("ret"))) {
        break label97;
      }
      localObject2 = this.val$creditCardDetailCallback;
      if (paramQMNetworkResponse != null) {
        break label86;
      }
    }
    label86:
    for (paramQMNetworkRequest = localObject1;; paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson())
    {
      ((CalendarMainFragment.CreditCardDetailCallback)localObject2).callback(paramQMNetworkRequest);
      return;
      paramQMNetworkRequest = paramQMNetworkResponse.getResponseJson();
      break;
    }
    label97:
    this.val$creditCardDetailCallback.callback(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.35
 * JD-Core Version:    0.7.0.1
 */