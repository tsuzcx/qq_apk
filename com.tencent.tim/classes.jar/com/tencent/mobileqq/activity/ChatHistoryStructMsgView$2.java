package com.tencent.mobileqq.activity;

import abdy;
import agmy;
import ahcb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import top;
import uos;

public class ChatHistoryStructMsgView$2
  implements Runnable
{
  public ChatHistoryStructMsgView$2(uos paramuos, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2;
    int i;
    int j;
    label120:
    Object localObject3;
    Object localObject4;
    if (this.aUh)
    {
      localObject1 = this.this$0.mApp.b();
      localObject2 = this.this$0.mUin;
      i = this.this$0.mUinType;
      j = uos.access$000();
      localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, new int[] { -2011 }, j);
      if ((localObject1 != null) && (((List)localObject1).size() < uos.access$000())) {
        this.this$0.aUg = true;
      }
      localObject2 = new LinkedHashMap();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label605;
      }
      i = ((List)localObject1).size() - 1;
      if (i < 0) {
        break label605;
      }
      localObject3 = (MessageRecord)((List)localObject1).get(i);
      if (abdy.U((MessageRecord)localObject3))
      {
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
          break label545;
        }
        localObject4 = (MessageForStructing)localObject3;
        if ((((MessageForStructing)localObject4).structingMsg == null) || (!(((MessageForStructing)localObject4).structingMsg instanceof AbsShareMsg))) {
          break label545;
        }
        localObject4 = (AbsShareMsg)((MessageForStructing)localObject4).structingMsg;
        if ((((MessageRecord)localObject3).time < 1548460800L) || (!agmy.mt(((AbsShareMsg)localObject4).mMsgUrl))) {
          break label545;
        }
      }
    }
    for (;;)
    {
      i -= 1;
      break label120;
      if (top.fs(this.this$0.mUinType))
      {
        localObject1 = this.this$0;
        ((uos)localObject1).FI -= 1L;
        localObject1 = this.this$0.mApp.b();
        localObject2 = this.this$0.mUin;
        i = this.this$0.mUinType;
        l1 = this.this$0.FH;
        j = this.this$0.bFx;
        l2 = this.this$0.FI;
        k = uos.access$000();
        localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, j, l2, new int[] { -2011 }, k);
        break;
      }
      localObject1 = this.this$0.mApp.b();
      localObject2 = this.this$0.mUin;
      i = this.this$0.mUinType;
      long l1 = this.this$0.FH;
      j = this.this$0.bFx;
      long l2 = this.this$0.FJ;
      int k = uos.access$000();
      localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, j, l2, new int[] { -2011 }, k);
      break;
      label545:
      localObject4 = ahcb.bt(((MessageRecord)localObject3).time * 1000L);
      if (!((LinkedHashMap)localObject2).containsKey(localObject4)) {
        ((LinkedHashMap)localObject2).put(localObject4, new ArrayList());
      }
      ((List)((LinkedHashMap)localObject2).get(localObject4)).add(localObject3);
    }
    label605:
    if (this.this$0.mData == null) {
      this.this$0.mData = new ArrayList();
    }
    Object localObject1 = ((LinkedHashMap)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      if (!this.this$0.mData.contains(localObject3)) {
        this.this$0.mData.add(localObject3);
      }
      this.this$0.mData.addAll((Collection)((LinkedHashMap)localObject2).get(localObject3));
    }
    this.this$0.uiHandler.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "initEntity, size: " + this.this$0.mData.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryStructMsgView.2
 * JD-Core Version:    0.7.0.1
 */