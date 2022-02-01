package com.tencent.mobileqq.dating;

import acbn;
import afck;
import afda;
import ajqz;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import tog;

public class SayHelloMsgListActivity
  extends BaseMsgBoxActivity
{
  ajqz c = new afda(this);
  
  protected List<RecentBaseData> aW(List<MessageRecord> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    long l2;
    if (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      String str = paramList.senderuin;
      l2 = System.currentTimeMillis();
      if (this.jP.containsKey(str)) {
        paramList = (RecentBaseData)this.jP.get(str);
      }
      for (;;)
      {
        paramList.c(this.app, BaseApplication.getContext());
        localArrayList1.add(paramList);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("Q.msg_box", 4, "item update time cost = " + (System.currentTimeMillis() - l2));
        break;
        paramList = new RecentSayHelloListItem(paramList);
        this.jP.put(str, paramList);
        try
        {
          localArrayList2.add(Long.valueOf(paramList.qx()));
        }
        catch (Exception localException) {}
      }
    }
    if (!localArrayList2.isEmpty()) {
      ThreadManager.getFileThreadHandler().post(new SayHelloMsgListActivity.2(this, localArrayList2));
    }
    if (QLog.isDevelopLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 4, "makeRecetBaseData |start cost time:" + (l2 - l1));
    }
    return localArrayList1;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setTitle(2131701344);
    this.app.addObserver(this.c, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.c);
  }
  
  public void finish()
  {
    if ((this.cMA == 1001) && (acbn.blg.equals(this.bwL)))
    {
      this.app.getPreferences().edit().putLong("sp_key_say_hello_msg_clean_unread_time", NetConnInfoCenter.getServerTime()).commit();
      this.app.a().h(this.bwL, this.cMA, true);
    }
    super.finish();
  }
  
  protected void jM(List<MessageRecord> paramList)
  {
    Object localObject2 = null;
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (TextUtils.isEmpty(localMessageRecord.senderuin))
      {
        localIterator.remove();
      }
      else if (afck.m(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new ArrayList();
        }
        localIterator.remove();
        ((List)localObject3).add(localMessageRecord);
        localObject1 = localObject3;
      }
      else if (afck.l(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
      {
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = new ArrayList();
        }
        localIterator.remove();
        ((List)localObject3).add(localMessageRecord);
        localObject2 = localObject3;
      }
    }
    Object localObject3 = new ArrayList();
    if ((localObject2 != null) && (!localObject2.isEmpty())) {
      ((List)localObject3).addAll(localObject2);
    }
    if ((localObject1 != null) && (!localObject1.isEmpty())) {
      ((List)localObject3).addAll(localObject1);
    }
    paramList.addAll(0, (Collection)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.SayHelloMsgListActivity
 * JD-Core Version:    0.7.0.1
 */