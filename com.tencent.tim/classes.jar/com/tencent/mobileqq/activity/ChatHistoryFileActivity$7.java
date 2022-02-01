package com.tencent.mobileqq.activity;

import aghw;
import ahao;
import ahau;
import aobh;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ChatHistoryFileActivity$7
  implements Runnable
{
  ChatHistoryFileActivity$7(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList1, List paramList2, boolean paramBoolean, List paramList3) {}
  
  public void run()
  {
    if (this.qw.size() == 1) {
      this.this$0.app.b().b((MessageRecord)this.qw.get(0), false);
    }
    Object localObject1;
    Object localObject2;
    while ((this.qv != null) && (this.qv.size() > 0))
    {
      localObject1 = this.qv.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        ((FileManagerEntity)localObject2).bDelInAio = true;
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatHistoryFIleActivity", 1, "ChatHistory entity[" + ((FileManagerEntity)localObject2).getId() + "] del File:" + ((FileManagerEntity)localObject2).nSessionId);
        }
        this.this$0.app.a().ca(((FileManagerEntity)localObject2).nSessionId);
      }
      if (this.qw.size() > 1) {
        this.this$0.app.b().V(this.qw, false);
      }
    }
    try
    {
      if (this.aTZ)
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONArray();
        ((JSONObject)localObject1).put("recent_file_list", localObject2);
        Iterator localIterator = this.qx.iterator();
        while (localIterator.hasNext()) {
          ((JSONArray)localObject2).put(((TencentDocData)localIterator.next()).translate2JsonObject());
        }
      }
      this.this$0.uiHandler.sendEmptyMessage(2);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryFIleActivity", 1, localJSONException.getMessage());
      }
    }
    for (;;)
    {
      return;
      localObject2 = ((aobh)this.this$0.app.getBusinessHandler(122)).r(localJSONException);
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryFIleActivity", 1, localJSONException.toString());
      }
      if (((JSONObject)localObject2).getInt("retcode") == 0) {
        ahau.JH("0X8009AA0");
      } else {
        ahao.JD(((JSONObject)localObject2).getString("msg"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.7
 * JD-Core Version:    0.7.0.1
 */