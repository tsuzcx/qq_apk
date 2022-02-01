package com.tencent.qqmail.model.mail;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.SQLException;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class QMMailCGIManager$2
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$2(QMMailCGIManager paramQMMailCGIManager, int paramInt, long paramLong) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    JSONObject localJSONObject = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if (localJSONObject == null)
    {
      QMLog.log(6, "QMMailCGIManager", "sync error : responseJson is null");
      return;
    }
    i = 0;
    int k;
    boolean bool1;
    try
    {
      k = ((CGIRequest)paramQMNetworkRequest).accountId;
      paramQMNetworkRequest = QMMailCGIManager.access$000(this.this$0).getReadableDatabase();
      bool1 = QMMailCGIManager.access$000(this.this$0).mail.isAccountMailEmpty(paramQMNetworkRequest, k);
      paramQMNetworkResponse = localJSONObject.getJSONObject("lock");
      if (paramQMNetworkResponse != null)
      {
        paramQMNetworkRequest = new HashMap();
        paramQMNetworkResponse = paramQMNetworkResponse.entrySet().iterator();
        while (paramQMNetworkResponse.hasNext())
        {
          localObject1 = (Map.Entry)paramQMNetworkResponse.next();
          paramQMNetworkRequest.put(((Map.Entry)localObject1).getKey(), (String)((Map.Entry)localObject1).getValue());
        }
        QMMailCGIManager.access$100(this.this$0, k, paramQMNetworkRequest);
      }
    }
    catch (SQLException paramQMNetworkRequest)
    {
      QMLog.log(6, "QMMailCGIManager", "sync json", paramQMNetworkRequest);
      QMWatcherCenter.triggerSyncEnd(this.val$accountId, false);
      return;
    }
    Object localObject1 = new HashSet();
    paramQMNetworkRequest = QMMailCGIManager.access$000(this.this$0).folder.getFoldersByAccountIdExcludeVipAndUnread(k).iterator();
    while (paramQMNetworkRequest.hasNext())
    {
      paramQMNetworkResponse = (QMFolder)paramQMNetworkRequest.next();
      ((HashSet)localObject1).add(paramQMNetworkResponse.getId() + "_" + paramQMNetworkResponse.getSvrCount() + "_" + paramQMNetworkResponse.getSvrUnreadCount());
    }
    QMMailCGIManager.access$200(this.this$0, k, localJSONObject);
    paramQMNetworkRequest = BottleManager.getInstance();
    if (paramQMNetworkRequest != null) {
      paramQMNetworkRequest.getBottleListController().parseMobileSyncToUpdateUnreadTime(k, localJSONObject);
    }
    QMWatcherCenter.triggerSyncEnd(k, false);
    QMSyncErrorManager.sharedInstance().removeSyncError(k);
    if (bool1) {
      QMMailCGIManager.access$300(this.this$0, k);
    }
    for (;;)
    {
      try
      {
        localObject2 = localJSONObject.getJSONObject("remind");
        if (localObject2 != null)
        {
          paramQMNetworkRequest = ((JSONObject)localObject2).getInteger("creditAgree");
          paramQMNetworkResponse = ((JSONObject)localObject2).getInteger("creditDialog");
          localObject1 = ((JSONObject)localObject2).getInteger("journeyAgree");
          localObject2 = ((JSONObject)localObject2).getInteger("journeyDialog");
          if ((paramQMNetworkRequest == null) || (paramQMNetworkRequest.intValue() != 1)) {
            continue;
          }
          bool1 = true;
          if ((paramQMNetworkResponse == null) || (paramQMNetworkResponse.intValue() != 1)) {
            continue;
          }
          bool2 = true;
          if ((localObject1 == null) || (((Integer)localObject1).intValue() != 1)) {
            continue;
          }
          bool3 = true;
          if ((localObject2 == null) || (((Integer)localObject2).intValue() != 1)) {
            continue;
          }
          bool4 = true;
          Log.i("QMMailCGIManager", "creditAgree " + bool1 + " creditDialog " + bool2 + " journeyAgree " + bool3 + " journeyDialog " + bool4);
          SharedPreferenceUtil.setCreditCardDialogShown(this.val$accountId, bool2);
          SharedPreferenceUtil.setCreditCardDialogAccept(this.val$accountId, bool1);
          SharedPreferenceUtil.setJourneyDialogShown(this.val$accountId, bool4);
          SharedPreferenceUtil.setJourneyDialogAccept(this.val$accountId, bool3);
        }
      }
      catch (Exception paramQMNetworkRequest)
      {
        Object localObject2;
        boolean bool2;
        boolean bool3;
        boolean bool4;
        paramQMNetworkRequest.printStackTrace();
        continue;
        continue;
        int j = 1;
        continue;
        i = 1;
        paramQMNetworkRequest = paramQMNetworkResponse;
        continue;
      }
      j = 0;
      i = j;
      if (localJSONObject.get("addrupdate") != null)
      {
        paramQMNetworkRequest = localJSONObject.getJSONObject("addrupdate");
        i = j;
        if (paramQMNetworkRequest != null)
        {
          i = j;
          if (paramQMNetworkRequest.get("st") != null)
          {
            i = j;
            if ("1".equals(paramQMNetworkRequest.get("st")))
            {
              i = 1;
              Threads.runInBackground(new QMMailCGIManager.2.1(this), 1000L);
            }
          }
        }
      }
      if (localJSONObject.get("addrvipcnt") != null)
      {
        QMLog.log(4, "QMMailCGIManager", "mobile_sync new feature vipcnt in, count: " + localJSONObject.get("addrvipcnt"));
        paramQMNetworkRequest = (String)localJSONObject.get("addrvipcnt");
        if (!StringExtention.isNullOrEmpty(paramQMNetworkRequest))
        {
          j = Integer.parseInt(paramQMNetworkRequest);
          QMSettingManager.sharedInstance().setAddrVipRemoteCount(this.val$accountId, j);
          if ((i == 0) && (this.val$vipContactUpdateTime == 0L)) {
            Threads.runInBackground(new QMMailCGIManager.2.2(this), 1000L);
          }
        }
      }
      if (localJSONObject.get("starattachcnt") != null)
      {
        QMLog.log(4, "QMMailCGIManager", "mobile_sync new feature attachcnt in, count: " + localJSONObject.get("starattachcnt"));
        paramQMNetworkRequest = (String)localJSONObject.get("starattachcnt");
        if (!StringExtention.isNullOrEmpty(paramQMNetworkRequest))
        {
          i = Integer.parseInt(paramQMNetworkRequest);
          QMSettingManager.sharedInstance().setStarAttachRemoteCount(this.val$accountId, i);
        }
      }
      paramQMNetworkRequest = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit();
      if (localJSONObject.get("remotelog") != null)
      {
        paramQMNetworkResponse = (String)localJSONObject.get("remotelog");
        if ((paramQMNetworkResponse != null) && (!"".equals(paramQMNetworkResponse))) {
          paramQMNetworkRequest.putString("isRemoteLog", paramQMNetworkResponse);
        }
      }
      if (localJSONObject.get("clickstream") != null)
      {
        paramQMNetworkResponse = (String)localJSONObject.get("clickstream");
        if ((paramQMNetworkResponse != null) && (!"".equals(paramQMNetworkResponse))) {
          paramQMNetworkRequest.putString("isClickStream", paramQMNetworkResponse);
        }
      }
      paramQMNetworkRequest.commit();
      paramQMNetworkRequest = localJSONObject.getJSONObject("set");
      QMMailCGIManager.access$500(this.this$0, paramQMNetworkRequest, this.val$accountId);
      QMMailCGIManager.access$600(this.this$0, paramQMNetworkRequest, this.val$accountId);
      paramQMNetworkRequest = (String)paramQMNetworkRequest.get("titpre");
      QMMailCGIManager.access$700(this.this$0, this.val$accountId, paramQMNetworkRequest);
      QMMailCGIManager.access$800(this.this$0, this.val$accountId, localJSONObject);
      QMMailCGIManager.access$900(this.this$0, localJSONObject);
      return;
      paramQMNetworkResponse = QMMailCGIManager.access$000(this.this$0).folder.getFoldersByAccountIdExcludeVipAndUnread(k);
      paramQMNetworkRequest = null;
      localObject2 = paramQMNetworkResponse.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        continue;
      }
      paramQMNetworkResponse = (QMFolder)((Iterator)localObject2).next();
      if (((HashSet)localObject1).contains(paramQMNetworkResponse.getId() + "_" + paramQMNetworkResponse.getSvrCount() + "_" + paramQMNetworkResponse.getSvrUnreadCount())) {
        continue;
      }
      i = 1;
      if (paramQMNetworkResponse.getType() == 1) {
        continue;
      }
      j = 0;
      if (i != 0) {
        if (j != 0)
        {
          this.this$0.updateList(paramQMNetworkRequest, true);
        }
        else
        {
          QMMailCGIManager.access$400(this.this$0, k);
          continue;
          bool1 = false;
          continue;
          bool2 = false;
          continue;
          bool3 = false;
          continue;
          bool4 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.2
 * JD-Core Version:    0.7.0.1
 */