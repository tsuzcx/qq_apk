package com.tencent.qqmail.model.mail;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.thread.Threads;

class QMMailCGIManager$33
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$33(QMMailCGIManager paramQMMailCGIManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    Object localObject = (JSONObject)paramQMNetworkResponse.getResponseJson();
    paramQMNetworkRequest = ((JSONObject)localObject).getString("ret");
    localObject = ((JSONObject)localObject).getString("event_expired");
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if ((localActivity != null) && (TextUtils.equals("0", paramQMNetworkRequest))) {
      Threads.runOnMainThread(new QMMailCGIManager.33.1(this, (String)localObject, localActivity));
    }
    Log.i("QMMailCGIManager", "setMailReminder setOnSuccess " + paramQMNetworkResponse.getResponseJson());
    QMCalendarManager.getInstance().syncCalendarByAllAccount(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.33
 * JD-Core Version:    0.7.0.1
 */