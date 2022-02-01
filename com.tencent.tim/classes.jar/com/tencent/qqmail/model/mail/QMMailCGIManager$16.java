package com.tencent.qqmail.model.mail;

import android.util.Pair;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.CheckMailCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class QMMailCGIManager$16
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$16(QMMailCGIManager paramQMMailCGIManager, Map paramMap, Account paramAccount, CheckMailCallback paramCheckMailCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkResponse = paramQMNetworkResponse.getResponseString();
    paramQMNetworkRequest = (JSONObject)JSONReader.parse(paramQMNetworkResponse);
    ArrayList localArrayList = new ArrayList();
    if (paramQMNetworkRequest != null)
    {
      JSONArray localJSONArray = paramQMNetworkRequest.getJSONArray("folders");
      if (localJSONArray != null)
      {
        int k = localJSONArray.size();
        int i = 0;
        if (i < k)
        {
          paramQMNetworkRequest = localJSONArray.getJSONObject(i);
          int j;
          String[] arrayOfString;
          HashSet localHashSet;
          if (paramQMNetworkRequest != null)
          {
            String str = paramQMNetworkRequest.getString("id");
            j = paramQMNetworkRequest.getIntValue("num");
            paramQMNetworkRequest = paramQMNetworkRequest.getJSONArray("mail");
            if ((j > 0) && (paramQMNetworkRequest != null))
            {
              arrayOfString = (String[])paramQMNetworkRequest.toArray(new String[paramQMNetworkRequest.size()]);
              localHashSet = new HashSet();
              paramQMNetworkRequest = this.val$map.keySet().iterator();
              while (paramQMNetworkRequest.hasNext())
              {
                QMFolder localQMFolder = (QMFolder)paramQMNetworkRequest.next();
                if (str.equals(localQMFolder.getRemoteId()))
                {
                  Iterator localIterator = ((List)this.val$map.get(localQMFolder)).iterator();
                  for (;;)
                  {
                    paramQMNetworkRequest = localQMFolder;
                    if (!localIterator.hasNext()) {
                      break;
                    }
                    localHashSet.add(((Pair)localIterator.next()).first);
                  }
                }
              }
              paramQMNetworkRequest = null;
              QMLog.log(3, "QMMailCGIManager", "checkMail result, account: " + this.val$account.getEmail() + ", folderId: " + str + ", oldMailIds: " + localHashSet + ", newMailIds: " + Arrays.toString(arrayOfString));
              if (arrayOfString.length <= localHashSet.size()) {
                break label323;
              }
              if (paramQMNetworkRequest != null) {
                localArrayList.add(paramQMNetworkRequest);
              }
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label323:
            int m = arrayOfString.length;
            j = 0;
            while (j < m)
            {
              if ((!localHashSet.contains(arrayOfString[j])) && (paramQMNetworkRequest != null)) {
                localArrayList.add(paramQMNetworkRequest);
              }
              j += 1;
            }
          }
        }
      }
    }
    if (paramQMNetworkResponse != null) {}
    for (paramQMNetworkRequest = paramQMNetworkResponse.replaceAll("\\s+", "");; paramQMNetworkRequest = paramQMNetworkResponse)
    {
      QMLog.log(4, "QMMailCGIManager", "checkMail onSuccess, account: " + this.val$account.getEmail() + ", syncFolders: " + localArrayList + ", result: " + paramQMNetworkRequest);
      if (localArrayList.size() > 0)
      {
        this.val$checkMailCallback.onSync((QMFolder[])localArrayList.toArray(new QMFolder[localArrayList.size()]));
        return;
      }
      this.val$checkMailCallback.notSync();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.16
 * JD-Core Version:    0.7.0.1
 */