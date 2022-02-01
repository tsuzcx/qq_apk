import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class ambj
  implements ambm.a, Manager
{
  private ambh a;
  private achq m;
  private QQAppInterface mApp;
  private HashMap<String, ambm> mJ = new HashMap();
  
  public ambj(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private ambh a()
  {
    if (this.a == null) {
      this.a = new ambh(this.mApp);
    }
    return this.a;
  }
  
  public static void k(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    ((ambj)paramQQAppInterface.getManager(326)).aH(paramString, paramLong);
  }
  
  public void Pw(String paramString)
  {
    ambm localambm = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      synchronized (this.mJ)
      {
        localambm = (ambm)this.mJ.remove(paramString);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)???).append("remove orderSession, suin = ").append(paramString).append(", addr = ");
          if (localambm != null)
          {
            paramString = localambm.toString();
            localStringBuilder.append(paramString);
            QLog.d("OrderMediaMsgManager", 2, ((StringBuilder)???).toString());
          }
        }
        else
        {
          return;
        }
      }
      paramString = Integer.valueOf(0);
    }
  }
  
  public ambm a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      synchronized (this.mJ)
      {
        if (this.mJ.containsKey(paramString))
        {
          paramString = (ambm)this.mJ.get(paramString);
          return paramString;
        }
      }
      ambm localambm = new ambm(paramString, a());
      localambm.a(this);
      this.mJ.put(paramString, localambm);
      paramString = localambm;
    }
  }
  
  public void a(String paramString1, MessageRecord paramMessageRecord, String paramString2)
  {
    ambm localambm = a(paramMessageRecord.frienduin);
    if (!localambm.h(paramMessageRecord.uniseq, paramString2)) {
      aG(paramString1, paramMessageRecord.uniseq);
    }
    localambm.a(paramMessageRecord, paramMessageRecord.uniseq, paramString2, false);
  }
  
  public boolean a(String paramString, long paramLong, View paramView, wla.a parama)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.mJ.containsKey(paramString))) {
      return false;
    }
    return a(paramString).a().a(this.mApp, paramLong, paramView, parama);
  }
  
  public void aG(String paramString, long paramLong)
  {
    a(paramString).aF(paramLong, "");
  }
  
  public void aH(String paramString, long paramLong)
  {
    a(paramString).a(paramLong);
  }
  
  public void b(MessageRecord paramMessageRecord, achq paramachq, ambj.a parama)
  {
    ambm localambm = a(paramMessageRecord.frienduin);
    String str = null;
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      str = ((MessageForShortVideo)paramMessageRecord).videoFileName;
    }
    while (localambm.h(paramMessageRecord.uniseq, str))
    {
      localambm.c(paramMessageRecord, paramachq, parama);
      return;
      if ((paramMessageRecord instanceof MessageForPic)) {
        str = ((MessageForPic)paramMessageRecord).path;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("OrderMediaMsgManager", 2, "sendOrderMsg but not in queue, uniseq:" + paramMessageRecord.uniseq);
    }
    a().a(paramMessageRecord, paramachq, parama);
  }
  
  public void d(MessageRecord paramMessageRecord, achq paramachq)
  {
    b(paramMessageRecord, paramachq, null);
  }
  
  public void d(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = a(paramMessageRecord.frienduin);
    if (((ambm)localObject).h(paramMessageRecord.uniseq, paramString))
    {
      ((ambm)localObject).a(paramMessageRecord, paramMessageRecord.uniseq, paramString, true);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addOrderMsg but not in queue, uniseq:").append(paramMessageRecord.uniseq).append(", path:").append(paramString);
      QLog.d("OrderMediaMsgManager", 2, ((StringBuilder)localObject).toString());
    }
    a().at(paramMessageRecord);
  }
  
  public void dMe()
  {
    if (this.m == null)
    {
      this.m = new ambk(this);
      this.mApp.addObserver(this.m);
    }
  }
  
  public void hi(String paramString1, String paramString2)
  {
    if (a().oC(paramString2)) {
      return;
    }
    a(paramString1).aF(0L, paramString2);
  }
  
  public boolean oD(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.mJ.containsKey(paramString))) {}
    while (a(paramString).avj()) {
      return false;
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (this.mJ != null)
    {
      Iterator localIterator = this.mJ.values().iterator();
      while (localIterator.hasNext()) {
        ((ambm)localIterator.next()).destroy();
      }
      this.mJ.clear();
    }
    if (this.m != null)
    {
      this.mApp.removeObserver(this.m);
      this.m = null;
    }
    this.mApp = null;
  }
  
  public void p(String paramString, long paramLong1, long paramLong2)
  {
    a(paramString).aI(paramLong1, paramLong2);
  }
  
  public boolean w(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.mJ.containsKey(paramString))) {}
    while (a(paramString).a().Y(paramLong) == 0) {
      return false;
    }
    return true;
  }
  
  public boolean x(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.mJ.containsKey(paramString))) {}
    while (a(paramString).a().Y(paramLong) != 2) {
      return false;
    }
    return true;
  }
  
  public void z(String paramString, ArrayList<ChatMessage> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      int k;
      for (int j = 0; paramArrayList.hasNext(); j = k)
      {
        ChatMessage localChatMessage = (ChatMessage)paramArrayList.next();
        k = j + 1;
        j = i;
        if (ambh.lc(localChatMessage.msgtype))
        {
          j = i + 1;
          a(paramString).h(localChatMessage.uniseq, "", a().aN(localChatMessage));
        }
        i = j;
      }
      ambl.ju(j, i);
    }
  }
  
  public static abstract interface a
  {
    public abstract void O(boolean paramBoolean, long paramLong);
    
    public abstract void au(MessageRecord paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambj
 * JD-Core Version:    0.7.0.1
 */