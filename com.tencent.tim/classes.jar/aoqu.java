import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqu
{
  private static final JSONObject a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    Object localObject = paramQQAppInterface.a(1001).g(acbn.blg, 1001);
    if (localObject == null)
    {
      QLog.i("SayHiMessageHelper", 1, "getSayHiBoxInnerMessages, no tribe say hi info");
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if (localMessageRecord.istroop == 10002) {
        localArrayList.add(localMessageRecord);
      }
    }
    paramInt2 = Math.min(paramInt1 + paramInt2, localArrayList.size());
    for (;;)
    {
      if (paramInt1 < paramInt2) {}
      try
      {
        localJSONArray.put(a(paramContext, paramQQAppInterface, (MessageRecord)localArrayList.get(paramInt1)));
        paramInt1 += 1;
      }
      catch (JSONException paramContext)
      {
        QLog.e("SayHiMessageHelper", 1, "getSayHiBoxInnerMessages Exception:", paramContext);
      }
    }
    localJSONObject.put("msgArray", localJSONArray);
    if (paramInt2 < localArrayList.size()) {
      localJSONObject.put("isEnd", 0);
    }
    while (QLog.isColorLevel())
    {
      QLog.i("SayHiMessageHelper", 1, "getSayHiBoxInnerMessages, jsonResult = " + localJSONObject.toString());
      break;
      localJSONObject.put("isEnd", 1);
    }
    return localJSONObject;
  }
  
  public static final JSONObject a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 != 1) && (paramInt2 != 2)) || (paramInt1 < 0) || (paramInt3 < 1))
    {
      QLog.e("SayHiMessageHelper", 1, "getTribeSayHelloInfo, invalid parameters viewIndex =" + paramInt2 + " start = " + paramInt1 + " count = " + paramInt3);
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SayHiMessageHelper", 1, "getTribeSayHelloInfo, viewIndex =" + paramInt2 + " start = " + paramInt1 + " count = " + paramInt3);
    }
    switch (paramInt2)
    {
    default: 
      return null;
    case 1: 
      return b(paramContext, paramQQAppInterface, paramInt1, paramInt3);
    }
    return a(paramContext, paramQQAppInterface, paramInt1, paramInt3);
  }
  
  private static JSONObject a(Context paramContext, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    JSONObject localJSONObject = new JSONObject();
    paramMessageRecord = new RecentSayHelloListItem(paramMessageRecord);
    paramMessageRecord.c(paramQQAppInterface, paramContext);
    try
    {
      localJSONObject.put("uin", paramMessageRecord.qx());
      localJSONObject.put("content", paramMessageRecord.mLastMsg);
      localJSONObject.put("time", paramMessageRecord.mShowTime);
      localJSONObject.put("nickName", paramMessageRecord.mTitleName);
      localJSONObject.put("redPointCount", paramMessageRecord.wU());
      return localJSONObject;
    }
    catch (JSONException paramContext)
    {
      QLog.e("SayHiMessageHelper", 1, "getNormalTribeSayHiMsg Exception:", paramContext);
    }
    return localJSONObject;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    Object localObject = paramQQAppInterface.a(1001).g(acbn.blg, 1001);
    paramQQAppInterface = paramQQAppInterface.a();
    int i;
    int j;
    label47:
    int m;
    int k;
    if (localObject == null)
    {
      i = 0;
      if (i <= 0) {
        break label127;
      }
      localObject = ((List)localObject).iterator();
      j = 0;
      i = 0;
      m = j;
      k = i;
      if (!((Iterator)localObject).hasNext()) {
        break label133;
      }
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if (localMessageRecord.istroop != 10002) {
        break label167;
      }
      j = i + paramQQAppInterface.A(localMessageRecord.senderuin, localMessageRecord.istroop);
      i = 1;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break label47;
      i = ((List)localObject).size();
      break;
      label127:
      m = 0;
      k = 0;
      label133:
      if (m != 0) {}
      try
      {
        paramJSONObject.put("redPointCount", k);
        paramJSONObject.put("status", 1);
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        QLog.e("SayHiMessageHelper", 1, "handleTribeSayHiBox Exception:", paramQQAppInterface);
        return;
      }
      label167:
      k = i;
      i = j;
      j = k;
    }
  }
  
  private static final void aQ(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.b().ca(paramString, 1001);
  }
  
  private static final JSONObject b(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = paramQQAppInterface.a(1001).g(acbn.bkE, 1001);
    if (localObject == null)
    {
      QLog.i("SayHiMessageHelper", 1, "getNewSayHiMessages, no tribe say hi info");
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject2.put("redPointCount", 0);
      localJSONObject2.put("status", 0);
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (acbn.blg.equals(localMessageRecord.senderuin))
        {
          a(paramQQAppInterface, localJSONObject2);
          break label399;
        }
        if ((!acbn.bli.equals(localMessageRecord.senderuin)) && (!acbn.blj.equals(localMessageRecord.senderuin)) && (!acbn.blk.equals(localMessageRecord.senderuin)) && (!acbn.bll.equals(localMessageRecord.senderuin)) && (!acbn.blm.equals(localMessageRecord.senderuin)))
        {
          localArrayList.add(localMessageRecord);
          i = c(paramQQAppInterface, localMessageRecord) + i;
          break label399;
        }
      }
      paramInt2 = Math.min(paramInt1 + paramInt2, localArrayList.size());
      while (paramInt1 < paramInt2)
      {
        localJSONArray.put(a(paramContext, paramQQAppInterface, (MessageRecord)localArrayList.get(paramInt1)));
        paramInt1 += 1;
      }
      localJSONObject1.put("greetingNodeInfo", localJSONObject2);
      localJSONObject1.put("msgArray", localJSONArray);
      localJSONObject1.put("redPointCount", i);
      if (paramInt2 < localArrayList.size()) {
        localJSONObject1.put("isEnd", 0);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("SayHiMessageHelper", 1, "getNewSayHiMessages, jsonResult = " + localJSONObject1.toString());
        break;
        localJSONObject1.put("isEnd", 1);
      }
    }
    catch (JSONException paramContext)
    {
      label399:
      for (;;)
      {
        QLog.e("SayHiMessageHelper", 1, "getNewSayHiMessages Exception:", paramContext);
        break;
      }
    }
    return localJSONObject1;
  }
  
  private static int c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    int j = 0;
    Object localObject = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.b();
    tog localtog = paramQQAppInterface.a();
    paramQQAppInterface = localObject;
    if (localQQMessageFacade != null) {
      paramQQAppInterface = localQQMessageFacade.a(paramMessageRecord.senderuin, paramMessageRecord.istroop);
    }
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (localtog != null) {
        i = localtog.A(paramQQAppInterface.frienduin, paramQQAppInterface.istroop);
      }
    }
    return i;
  }
  
  private static final void el(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.a(1001).g(acbn.blg, 1001);
    if (localObject1 == null) {
      QLog.i("SayHiMessageHelper", 1, "deleteSayHiBox, no tribe say hi info");
    }
    for (;;)
    {
      return;
      Object localObject2 = new ArrayList();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.istroop == 10002) {
          ((ArrayList)localObject2).add(localMessageRecord.senderuin);
        }
      }
      if (((List)localObject1).size() == ((ArrayList)localObject2).size())
      {
        if (QLog.isColorLevel()) {
          QLog.i("SayHiMessageHelper", 1, "deleteSayHiBox, delete total box");
        }
        paramQQAppInterface.b().c(acbn.bkE, 1001, acbn.blg, paramQQAppInterface.getCurrentAccountUin());
        return;
      }
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.i("SayHiMessageHelper", 1, "deleteSayHiBox, delete uin = " + (String)localObject2);
        }
        paramQQAppInterface.b().c(acbn.blg, 1001, (String)localObject2, paramQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  public static final void h(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (((paramInt2 != 1) && (paramInt2 != 2) && (paramInt1 == 1)) || ((paramInt1 != 1) && (paramInt1 != 2))) {
      QLog.e("SayHiMessageHelper", 1, "clearTribeSayHiNodeUnread, invalid parameters viewIndex =" + paramInt2 + " clearType = " + paramInt1 + " clearUin = " + paramString);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("SayHiMessageHelper", 1, "clearTribeSayHiNodeUnread, viewIndex =" + paramInt2 + " clearUin = " + paramString + " clearType = " + paramInt1);
      }
    } while (paramInt1 != 1);
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
      aQ(paramQQAppInterface, paramString);
      return;
    }
    aQ(paramQQAppInterface, paramString);
  }
  
  public static final void i(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (((paramInt2 != 1) && (paramInt2 != 2) && (paramInt1 == 1)) || ((paramInt1 != 1) && (paramInt1 != 2)))
    {
      QLog.e("SayHiMessageHelper", 1, "deleteTribeSayHiNode, invalid parameters msgType =" + paramInt2 + " deleteType = " + paramInt1 + " deleteUin = " + paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SayHiMessageHelper", 1, "deleteTribeSayHiNode, msgType =" + paramInt2 + " deleteUin = " + paramString + " deleteType = " + paramInt1);
    }
    if (paramInt1 == 1)
    {
      switch (paramInt2)
      {
      default: 
        return;
      case 1: 
        r(paramQQAppInterface, paramString, acbn.bkE);
        return;
      }
      r(paramQQAppInterface, paramString, acbn.blg);
      return;
    }
    el(paramQQAppInterface);
  }
  
  private static final void r(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface.b().c(paramString2, 1001, paramString1, paramQQAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqu
 * JD-Core Version:    0.7.0.1
 */