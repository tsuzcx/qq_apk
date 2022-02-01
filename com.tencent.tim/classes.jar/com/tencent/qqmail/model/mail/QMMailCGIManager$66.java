package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.data.CalendarShareError;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

class QMMailCGIManager$66
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$66(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "shareCalendarFolder", paramQMNetworkResponse.toString());
    Object localObject1 = (JSONObject)paramQMNetworkResponse.getResponseJson();
    Object localObject2;
    String str1;
    int i;
    long l;
    int j;
    int k;
    int i1;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject2 = ((JSONObject)localObject1).getString("need_verifycode");
      str1 = ((JSONObject)localObject1).getString("verifykey");
      int n;
      label119:
      String str2;
      int m;
      int i2;
      int i3;
      if ((localObject2 != null) && (((String)localObject2).equals("1")))
      {
        i = 1;
        l = ((JSONObject)localObject1).getLong("invalid_email").longValue();
        j = 0;
        k = 0;
        i1 = 0;
        localObject2 = new ArrayList();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localJSONArray = ((JSONObject)localObject1).getJSONArray("list");
        n = 0;
        if (n >= localJSONArray.size()) {
          break label371;
        }
        localObject1 = localJSONArray.getJSONObject(n);
        str2 = ((JSONObject)localObject1).getString("touser");
        m = i1;
        i2 = k;
        i3 = j;
        switch (Integer.parseInt(((JSONObject)localObject1).getString("ret")))
        {
        default: 
          localArrayList1.add(str2);
          i3 = j;
          i2 = k;
          m = i1;
        }
      }
      for (;;)
      {
        n += 1;
        i1 = m;
        k = i2;
        j = i3;
        break label119;
        i = 0;
        break;
        i1 = 1;
        ((ArrayList)localObject2).add(str2);
        m = i1;
        i2 = k;
        i3 = j;
        if (l == 0L)
        {
          localArrayList2.add(str2);
          m = i1;
          i2 = k;
          i3 = j;
          continue;
          i2 = 1;
          localArrayList1.add(str2);
          localArrayList2.add(str2);
          m = i1;
          i3 = j;
          continue;
          i3 = 1;
          localArrayList1.add(str2);
          localArrayList2.add(str2);
          m = i1;
          i2 = k;
        }
      }
      label371:
      localObject1 = null;
      if (i == 0) {
        break label477;
      }
      i = -2;
      localObject1 = QMApplicationContext.sharedInstance().getString(2131691173);
    }
    for (;;)
    {
      if (i == 0) {
        if (this.val$callback != null) {
          this.val$callback.handleSuccess(paramQMNetworkRequest, paramQMNetworkResponse);
        }
      }
      for (;;)
      {
        QMLog.log(4, "shareCalendarFolder", "invalidCount " + l + " listSize " + localJSONArray.size() + " sharedToUserSize " + ((ArrayList)localObject2).size() + " errorToUserSize " + localArrayList1.size());
        return;
        label477:
        if (j != 0)
        {
          i = -502;
          localObject1 = QMApplicationContext.sharedInstance().getString(2131691177);
          break;
        }
        if (k != 0)
        {
          i = -501;
          localObject1 = QMApplicationContext.sharedInstance().getString(2131691175);
          break;
        }
        if ((i1 != 0) && (((ArrayList)localObject2).size() == localJSONArray.size()))
        {
          i = 1;
          localObject1 = QMApplicationContext.sharedInstance().getString(2131691176);
          break;
        }
        if (localArrayList1.size() <= 0) {
          break label688;
        }
        i = -1;
        localObject1 = QMApplicationContext.sharedInstance().getString(2131691174) + StringUtils.join(localArrayList1, ",");
        break;
        if (this.val$callback != null)
        {
          paramQMNetworkRequest = new QMVerify();
          paramQMNetworkRequest.setImageUrl(null);
          paramQMNetworkRequest.setVerifyCode(null);
          paramQMNetworkRequest.setVerifyKey(str1);
          paramQMNetworkRequest.setVerifySession(null);
          paramQMNetworkRequest.setAuthImagesId(null);
          paramQMNetworkResponse = new CalendarShareError(i, (String)localObject1);
          paramQMNetworkResponse.setShareVerify(paramQMNetworkRequest);
          paramQMNetworkResponse.setErrorEmails((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
          this.val$callback.handleError(paramQMNetworkResponse);
        }
      }
      label688:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.66
 * JD-Core Version:    0.7.0.1
 */