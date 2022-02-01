package com.tencent.mobileqq.emosm.web;

import acfp;
import android.os.Bundle;
import android.text.TextUtils;
import aofk;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tog;

class MessengerService$IncomingHandler$31
  implements Runnable
{
  MessengerService$IncomingHandler$31(MessengerService.a parama, JSONArray paramJSONArray, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      JSONObject localJSONObject2;
      int j;
      MessageRecord localMessageRecord;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        int k = this.L.length();
        int i = 0;
        if (i >= k) {
          break label435;
        }
        localJSONObject1 = new JSONObject();
        Object localObject = this.L.getString(i);
        localJSONObject1.put("uin", localObject);
        localJSONObject1.put("unreadMsgCount", this.val$qqApp.a().A((String)localObject, 1036));
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("text", "");
        localJSONObject2.put("timestamp", 0);
        localObject = this.val$qqApp.b().a((String)localObject, 1036, null, 5);
        j = ((List)localObject).size() - 1;
        if (j >= 0)
        {
          localMessageRecord = (MessageRecord)((List)localObject).get(j);
          if ((!(localMessageRecord instanceof ChatMessage)) || ((localMessageRecord instanceof MessageForCmGameTips)) || ((localMessageRecord instanceof MessageForGrayTips)) || ((localMessageRecord instanceof MessageForUniteGrayTip))) {
            break label489;
          }
          if (localMessageRecord != null)
          {
            if (TextUtils.isEmpty(localMessageRecord.msg)) {
              ((ChatMessage)localMessageRecord).parse();
            }
            if (!(localMessageRecord instanceof MessageForApollo)) {
              continue;
            }
            localJSONObject2.put("text", ApolloUtil.a(this.val$qqApp, (MessageForApollo)localMessageRecord));
            localJSONObject2.put("timestamp", localMessageRecord.time);
          }
        }
        localJSONObject1.put("latestMsg", localJSONObject2);
        localJSONArray.put(localJSONObject1);
        i += 1;
        continue;
        if ((localMessageRecord instanceof MessageForPic))
        {
          localJSONObject2.put("text", acfp.m(2131708253));
          localJSONObject2.put("timestamp", localMessageRecord.time);
          continue;
        }
        if (TextUtils.isEmpty(localMessageRecord.msg)) {
          break label406;
        }
      }
      catch (Exception localException)
      {
        localBundle.putString("result", "");
        this.val$reqbundle.putBundle("response", localBundle);
        this.val$service.cp(this.val$reqbundle);
        return;
      }
      localJSONObject2.put("text", new aofk(localMessageRecord.msg, 3).AE());
      localJSONObject2.put("timestamp", localMessageRecord.time);
      continue;
      label406:
      localJSONObject2.put("text", acfp.m(2131708257));
      localJSONObject2.put("timestamp", localMessageRecord.time);
      continue;
      label435:
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("friendMsgList", localException);
      localBundle.putString("result", localJSONObject1.toString());
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.cp(this.val$reqbundle);
      return;
      label489:
      j -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.31
 * JD-Core Version:    0.7.0.1
 */