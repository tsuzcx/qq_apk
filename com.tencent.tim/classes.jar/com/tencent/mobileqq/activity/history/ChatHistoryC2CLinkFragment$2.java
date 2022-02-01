package com.tencent.mobileqq.activity.history;

import abdy;
import agmy;
import ahcb;
import android.text.TextUtils;
import aqjb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import top;
import zjb;

class ChatHistoryC2CLinkFragment$2
  implements Runnable
{
  ChatHistoryC2CLinkFragment$2(ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    Object localObject2;
    int i;
    int k;
    label125:
    Object localObject3;
    label229:
    Object localObject4;
    if (this.aUh)
    {
      localObject1 = this.this$0.mApp.b();
      localObject2 = this.this$0.mUin;
      i = this.this$0.mUinType;
      k = ChatHistoryC2CLinkFragment.access$000();
      localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, new int[] { -2011, -1000, -1035, -1049, -5008 }, k);
      if (QLog.isColorLevel())
      {
        boolean bool = this.aUh;
        localObject2 = new StringBuilder().append(" msgList:");
        if (localObject1 == null) {
          break label706;
        }
        i = ((List)localObject1).size();
        QLog.d("ChatHistoryStruct", 2, new Object[] { "isInited:", Boolean.valueOf(bool), i });
      }
      if ((localObject1 != null) && (((List)localObject1).size() == 0)) {
        this.this$0.aUg = true;
      }
      localObject2 = new LinkedHashMap();
      ((LinkedHashMap)localObject2).putAll(ChatHistoryC2CLinkFragment.a(this.this$0));
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label927;
      }
      i = ((List)localObject1).size() - 1;
      if (i < 0) {
        break label927;
      }
      localObject3 = (MessageRecord)((List)localObject1).get(i);
      if (!abdy.U((MessageRecord)localObject3)) {
        break label771;
      }
      if (((MessageRecord)localObject3).shmsgseq < this.this$0.FI) {
        this.this$0.FI = ((MessageRecord)localObject3).shmsgseq;
      }
      if (((MessageRecord)localObject3).versionCode < this.this$0.bFx) {
        this.this$0.bFx = ((MessageRecord)localObject3).versionCode;
      }
      if ((((MessageRecord)localObject3).getId() > 0L) && (((MessageRecord)localObject3).getId() < this.this$0.FH)) {
        this.this$0.FH = ((MessageRecord)localObject3).getId();
      }
      if (((MessageRecord)localObject3).time < this.this$0.FJ) {
        this.this$0.FJ = ((MessageRecord)localObject3).time;
      }
      if (!(localObject3 instanceof MessageForStructing)) {
        break label711;
      }
      localObject4 = (MessageForStructing)localObject3;
      if ((((MessageForStructing)localObject4).structingMsg == null) || (!(((MessageForStructing)localObject4).structingMsg instanceof AbsShareMsg))) {
        break label711;
      }
      localObject4 = (AbsShareMsg)((MessageForStructing)localObject4).structingMsg;
      if ((((MessageRecord)localObject3).time < 1548460800L) || (!agmy.mt(((AbsShareMsg)localObject4).mMsgUrl))) {
        break label711;
      }
    }
    for (;;)
    {
      i -= 1;
      break label229;
      if (top.fs(this.this$0.mUinType))
      {
        localObject1 = this.this$0;
        ((ChatHistoryC2CLinkFragment)localObject1).FI -= 1L;
        localObject1 = this.this$0.mApp.b();
        localObject2 = this.this$0.mUin;
        i = this.this$0.mUinType;
        l1 = this.this$0.FH;
        k = this.this$0.bFx;
        l2 = this.this$0.FI;
        m = ChatHistoryC2CLinkFragment.access$000();
        localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, k, l2, new int[] { -2011, -1000, -1035, -1049, -5008 }, m);
        break;
      }
      localObject1 = this.this$0.mApp.b();
      localObject2 = this.this$0.mUin;
      i = this.this$0.mUinType;
      long l1 = this.this$0.FH;
      k = this.this$0.bFx;
      long l2 = this.this$0.FJ;
      int m = ChatHistoryC2CLinkFragment.access$000();
      localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, k, l2, new int[] { -2011, -1000, -1035, -1049, -5008 }, m);
      break;
      label706:
      i = 0;
      break label125;
      label711:
      localObject4 = ahcb.bt(((MessageRecord)localObject3).time * 1000L);
      if (!((LinkedHashMap)localObject2).containsKey(localObject4)) {
        ((LinkedHashMap)localObject2).put(localObject4, new ArrayList());
      }
      ((List)((LinkedHashMap)localObject2).get(localObject4)).add(localObject3);
      continue;
      label771:
      if ((((localObject3 instanceof MessageForText)) || ((localObject3 instanceof MessageForMixedMsg)) || ((localObject3 instanceof MessageForReplyText)) || ((localObject3 instanceof MessageForArkApp))) && (((MessageRecord)localObject3).time >= 1548460800L))
      {
        localObject4 = zjb.l((MessageRecord)localObject3);
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (aqjb.am.matcher((CharSequence)localObject4).find()) && (ChatHistoryC2CLinkFragment.J.matcher((CharSequence)localObject4).find()))
        {
          localObject4 = ahcb.bt(((MessageRecord)localObject3).time * 1000L);
          if (!((LinkedHashMap)localObject2).containsKey(localObject4)) {
            ((LinkedHashMap)localObject2).put(localObject4, new ArrayList());
          }
          localObject4 = (List)((LinkedHashMap)localObject2).get(localObject4);
          if (localObject4 != null) {
            ((List)localObject4).add(localObject3);
          }
        }
      }
    }
    label927:
    if (this.this$0.mData == null) {
      this.this$0.mData = new ArrayList();
    }
    this.this$0.mData.clear();
    Object localObject1 = ((LinkedHashMap)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      if (!this.this$0.mData.contains(localObject3)) {
        this.this$0.mData.add(localObject3);
      }
      this.this$0.mData.addAll((Collection)((LinkedHashMap)localObject2).get(localObject3));
    }
    ChatHistoryC2CLinkFragment.a(this.this$0, (LinkedHashMap)localObject2);
    this.this$0.uiHandler.sendEmptyMessage(1);
    if (QLog.isColorLevel())
    {
      k = this.this$0.mData.size();
      i = j;
      if (ChatHistoryC2CLinkFragment.a(this.this$0) != null) {
        i = ChatHistoryC2CLinkFragment.a(this.this$0).size();
      }
      QLog.d("ChatHistoryStruct", 2, new Object[] { "initEntity, size: ", Integer.valueOf(k), " dataMap:", Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment.2
 * JD-Core Version:    0.7.0.1
 */