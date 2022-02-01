import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public class jyl
  extends tob
{
  public jyl(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  public ArrayList<MessageRecord> a(long paramLong, List<msg_comm.Msg> paramList)
  {
    paramList = b(paramLong, paramList);
    ArrayList localArrayList = new ArrayList();
    a(paramList, localArrayList, true);
    paramList.clear();
    return localArrayList;
  }
  
  public ArrayList<MessageRecord> b(long paramLong, List<msg_comm.Msg> paramList)
  {
    Object localObject1 = new ArrayList();
    a(paramList, (List)localObject1);
    paramList = new ArrayList();
    anax localanax = new anax(this.app.getLongAccountUin(), paramLong, true, true, false, false);
    localanax.cEH = true;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (msg_comm.Msg)((Iterator)localObject1).next();
      try
      {
        localObject2 = a((msg_comm.Msg)localObject2, localanax);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          continue;
        }
        paramList.addAll((Collection)localObject2);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.w("DynamicMsgProcessor", 2, "decodeSinglePBMsg_C2C error,", localException);
      }
    }
    return paramList;
  }
  
  public void b(long paramLong, List<msg_comm.Msg> paramList)
  {
    paramList = a(paramLong, paramList);
    kaw localkaw;
    long l2;
    long l1;
    String str;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localkaw = kaw.a();
      l2 = localkaw.a(this.app, String.valueOf(paramLong));
      l1 = l2;
      if (l2 == 0L) {
        l1 = 9223372036854775807L;
      }
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        str = ((MessageRecord)localIterator.next()).getExtInfoFromExtStr("pa_msgId");
        if (TextUtils.isEmpty(str)) {
          break label176;
        }
      }
    }
    label176:
    for (;;)
    {
      try
      {
        long l3 = Long.parseLong(str);
        l2 = l1;
        if (l3 < l1)
        {
          l2 = l1;
          if (l3 != 0L)
          {
            localkaw.a(this.app, String.valueOf(paramLong), l3);
            l2 = l3;
          }
        }
        l1 = l2;
      }
      catch (Exception localException)
      {
        continue;
      }
      this.app.b().c(paramList, this.app.getCurrentAccountUin(), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jyl
 * JD-Core Version:    0.7.0.1
 */