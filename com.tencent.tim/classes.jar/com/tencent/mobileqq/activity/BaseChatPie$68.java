package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.RichStatus.a;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import xmj;

class BaseChatPie$68
  implements Runnable
{
  BaseChatPie$68(BaseChatPie paramBaseChatPie, RichStatus.a parama) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.app.b().a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, xmj.Jd);
    Object localObject;
    Message localMessage;
    if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForRichState)))
    {
      localObject = new HashMap();
      ((Map)localObject).put("chatMessage", localMessageRecord);
      ((Map)localObject).put("sigZanInfo", this.a);
      this.this$0.uiHandler.removeMessages(267387138);
      localMessage = this.this$0.uiHandler.obtainMessage(267387138);
      localMessage.obj = localObject;
    }
    try
    {
      localObject = new JSONObject(localMessageRecord.msg);
      ((JSONObject)localObject).put("count", this.a.count);
      ((JSONObject)localObject).put("zanfalg", this.a.zanFlag);
      this.this$0.app.b().b(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, localMessageRecord.uniseq, ((JSONObject)localObject).toString());
      label190:
      this.this$0.uiHandler.sendMessageDelayed(localMessage, 1000L);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label190;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.68
 * JD-Core Version:    0.7.0.1
 */