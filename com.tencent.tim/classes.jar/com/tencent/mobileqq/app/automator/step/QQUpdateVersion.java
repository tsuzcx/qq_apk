package com.tencent.mobileqq.app.automator.step;

import acbn;
import anbi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import toa;
import tog;
import top;

public class QQUpdateVersion
  extends AsyncStep
{
  private final String TAG = "QQUpdateVersion";
  private final String bqo = "qq_update_5.6";
  private final String bqp = "qq_update_6.5.5";
  private final String bqq = "qq_update_version";
  
  private void cNE()
  {
    int i = 0;
    String str;
    int j;
    Object localObject3;
    Object localObject1;
    if (i < top.ch.length)
    {
      str = top.ch[i];
      j = top.fa[i];
      localObject3 = this.a.app.b().k(str, j);
      localObject1 = acbn.blg;
      if ((top.eD(j) != 1001) && (top.eD(j) != 10002)) {
        break label85;
      }
      localObject1 = acbn.blg;
    }
    for (;;)
    {
      if ((localObject3 == null) || (((List)localObject3).isEmpty()))
      {
        return;
        label85:
        if (top.eD(j) == 1010) {
          localObject1 = acbn.blh;
        }
      }
      else
      {
        Object localObject2 = null;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject3).iterator();
        label123:
        while (localIterator.hasNext())
        {
          localObject3 = (MessageRecord)localIterator.next();
          if ((!((String)localObject1).equals(((MessageRecord)localObject3).senderuin)) && (top.v((MessageRecord)localObject3)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQUpdateVersion", 2, "doMergeSayHelloBox oneWay=" + ((MessageRecord)localObject3).getBaseInfoString());
            }
            if (localObject2 != null) {
              break label469;
            }
            localObject2 = localObject3;
          }
        }
        label469:
        for (;;)
        {
          this.a.app.b().a().a(str, j, ((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).selfuin, false);
          ((MessageRecord)localObject3).frienduin = ((String)localObject1);
          ((MessageRecord)localObject3).setStatus(1000);
          localArrayList.add(localObject3);
          break label123;
          if (localArrayList.size() > 0) {
            this.a.app.b().ft(localArrayList);
          }
          if (localObject2 != null)
          {
            this.a.app.b().c(str, j, localObject2.frienduin, localObject2.selfuin);
            localObject3 = anbi.d(localObject2.msgtype);
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject3, localObject2);
            ((MessageRecord)localObject3).senderuin = ((String)localObject1);
            ((MessageRecord)localObject3).frienduin = str;
            ((MessageRecord)localObject3).istroop = j;
            localObject1 = new ArrayList();
            ((List)localObject1).add(localObject3);
            this.a.app.b().ft((List)localObject1);
            this.a.app.a().bQ(str, j);
            this.a.app.b().a().a((MessageRecord)localObject3, true, 2);
            this.a.app.b().a().a(localObject2, true, 2);
            this.a.app.b().as(localObject3);
          }
          i += 1;
          break;
        }
      }
    }
  }
  
  private void cNF()
  {
    Object localObject = this.a.app.b().k(acbn.blh, 1010);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.a.app.b().a().c(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
    localObject = this.a.app.b().k(acbn.bkY, 1010);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.a.app.b().a().c(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
  }
  
  public int od()
  {
    localSharedPreferences = this.a.app.getApp().getSharedPreferences(this.a.app.getCurrentAccountUin(), 0);
    boolean bool1 = localSharedPreferences.getBoolean("qq_update_5.6", true);
    boolean bool2 = localSharedPreferences.getBoolean("qq_update_6.5.5", true);
    str = localSharedPreferences.getString("qq_update_version", "");
    if (bool1) {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, "do qq update 5.6");
      }
    }
    try
    {
      String[] arrayOfString = "3.4.4".split("\\.");
      if ((arrayOfString != null) && (arrayOfString.length >= 2))
      {
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[1]);
        if ((i >= 5) && (j >= 6)) {
          cNE();
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          cNF();
          localSharedPreferences.edit().putBoolean("qq_update_6.5.5", false).commit();
          if (!"3.4.4".equals(str))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQUpdateVersion", 2, String.format("version update, old=%s, new=%s", new Object[] { str, "3.4.4" }));
            }
            this.a.app.getApp().getSharedPreferences("loginwelcome_" + this.a.app.getCurrentAccountUin(), 0).edit().putBoolean("request_state", true).commit();
            localSharedPreferences.edit().putString("qq_update_version", "3.4.4").commit();
          }
          return 7;
          localException1 = localException1;
        } while (!QLog.isColorLevel());
        QLog.w("QQUpdateVersion", 2, localException1.getMessage(), localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQUpdateVersion 6.5.5", 2, localException2.getMessage(), localException2);
          }
        }
      }
    }
    localSharedPreferences.edit().putBoolean("qq_update_5.6", false).commit();
    if (bool2) {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, "do qq update 6.5.5");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QQUpdateVersion
 * JD-Core Version:    0.7.0.1
 */