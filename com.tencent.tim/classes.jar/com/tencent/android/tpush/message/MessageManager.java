package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.CachedMessageIntent;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.e.a;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.INTENTSCHEMECHECK, com.jg.EType.INTENTCHECK, com.jg.EType.RECEIVERCHECK})
public class MessageManager
{
  public static final int MSG_CTRL_CMD_TYPE = 3;
  public static final int MSG_CTRL_CMD_TYPE_ACTION_CLEAR_PKG = 2;
  public static final int MSG_CTRL_CMD_TYPE_ACTION_CLEAR_PUSHID = 1;
  public static final int MSG_CTRL_CMD_TYPE_ACTION_LOG_ENABLED = 3;
  public static final String SHARED_PREFERENCES_CACHE_MSG_KEY = ".tpns.msg.id.cached";
  public static final String SHARED_PREFERENCES_KEY = ".tpns.msg.id";
  private static MessageManager a = new MessageManager();
  private static final byte[] b = new byte[0];
  
  private Object a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = d.a(Rijndael.decrypt(PushPreferences.getString(paramContext, paramString1 + paramString2, null)));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageManager", "getSettings", paramContext);
    }
    return null;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, ArrayList<?> paramArrayList)
  {
    try
    {
      if (paramArrayList.size() > 50) {
        paramArrayList.subList(0, 10).clear();
      }
      paramArrayList = Rijndael.encrypt(d.a(paramArrayList));
      PushPreferences.putString(paramContext, paramString1 + paramString2, paramArrayList);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageManager", "putSettings", paramContext);
    }
  }
  
  public static MessageManager getInstance()
  {
    return a;
  }
  
  public static String getNotifiedMsgIds(Context paramContext, long paramLong)
  {
    String str = "" + PushMd5Pref.getString(paramContext, new StringBuilder().append("tpush_msgId_").append(paramLong).toString(), true);
    paramContext = str;
    if (str != null)
    {
      paramContext = str;
      if (str.length() > 20480) {
        paramContext = str.substring(0, str.indexOf("@@", 5120));
      }
    }
    if (paramContext != null) {
      return paramContext;
    }
    return "";
  }
  
  public static boolean setNotifiedMsgIds(Context paramContext, long paramLong, String paramString1, String paramString2)
  {
    boolean bool = true;
    PushMd5Pref.putString(paramContext, "tpush_msgId_" + paramLong, paramString1 + paramString2, true);
    paramContext = PushMd5Pref.getString(paramContext, "tpush_msgId_" + paramLong, true);
    if ((paramContext == null) || (!paramContext.contains(paramString1)))
    {
      TLogger.e("MessageManager", paramString1 + " flag write failed");
      bool = false;
    }
    return bool;
  }
  
  public void addCachedMsgIntentByPkgName(Context paramContext, String paramString, Intent paramIntent)
  {
    byte[] arrayOfByte = b;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        CachedMessageIntent localCachedMessageIntent1;
        if ((!i.b(paramString)) && (paramIntent != null))
        {
          localCachedMessageIntent1 = new CachedMessageIntent();
          localCachedMessageIntent1.pkgName = paramString;
          localCachedMessageIntent1.msgId = paramIntent.getLongExtra("msgId", -1L);
          localCachedMessageIntent1.intent = Rijndael.encrypt(paramIntent.toUri(1));
          paramIntent = getCachedMsgIntentListByPkgName(paramContext, paramString);
          if (paramIntent == null)
          {
            paramIntent = new ArrayList();
            if ((paramIntent != null) && (paramIntent.size() > 45))
            {
              i = paramIntent.size() - 45;
              if (i >= 0)
              {
                TLogger.w("MessageManager", "too much cache msg, try to cut " + i + " list.size: " + paramIntent.size());
                paramIntent.subList(0, i).clear();
              }
            }
            paramIntent.add(localCachedMessageIntent1);
            updateCachedMsgIntentByPkgName(paramContext, paramString, paramIntent);
          }
        }
        else
        {
          return;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        if (i < paramIntent.size())
        {
          CachedMessageIntent localCachedMessageIntent2 = (CachedMessageIntent)paramIntent.get(i);
          if (localCachedMessageIntent2.equals(localCachedMessageIntent1)) {
            localArrayList.add(localCachedMessageIntent2);
          }
        }
        else
        {
          paramIntent.removeAll(localArrayList);
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public void addDonotCachedMsgId(Context paramContext, String paramString, ArrayList<Intent> paramArrayList)
  {
    byte[] arrayOfByte = b;
    if ((paramContext != null) && (paramArrayList != null)) {}
    try
    {
      a(paramContext, paramString, ".tpns.msg.id.cached", paramArrayList);
      return;
    }
    finally {}
  }
  
  public void addDonotSendCachedMsgIntentList(Context paramContext, Intent paramIntent)
  {
    if (paramContext != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramIntent);
      addDonotCachedMsgId(paramContext, paramContext.getPackageName(), localArrayList);
    }
  }
  
  public void addMsgId(Context paramContext, String paramString, MessageId paramMessageId)
  {
    byte[] arrayOfByte = b;
    if (paramContext != null) {}
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        if ((!i.b(paramString)) && (paramMessageId != null))
        {
          localArrayList = getMessageIdListByPkgName(paramContext, paramString);
          if (localArrayList != null) {
            break label115;
          }
          localArrayList = new ArrayList();
          localArrayList.add(paramMessageId);
          updateMsgId(paramContext, paramString, localArrayList);
        }
        return;
      }
      finally {}
      if (i < localArrayList.size())
      {
        if (((MessageId)localArrayList.get(i)).id == paramMessageId.id) {
          localArrayList.remove(i);
        }
      }
      else
      {
        continue;
        label115:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public void addNewCachedMsgIntent(Context paramContext, Intent paramIntent)
  {
    if (paramContext != null) {
      a.a(paramContext, paramIntent);
    }
  }
  
  public void clearAllLocalMsg(Context paramContext)
  {
    if (paramContext != null) {
      a.b(paramContext);
    }
  }
  
  public void clearLocalCachedMsgIntentList(Context paramContext)
  {
    ArrayList localArrayList1;
    String str1;
    ArrayList localArrayList2;
    int i;
    if (paramContext != null)
    {
      Object localObject = CacheManager.getRegisterInfos(paramContext);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localArrayList1 = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          localArrayList1.clear();
          localArrayList2 = getCachedMsgIntentListByPkgName(paramContext, str1);
          if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i < localArrayList2.size())
      {
        CachedMessageIntent localCachedMessageIntent = (CachedMessageIntent)localArrayList2.get(i);
        try
        {
          String str2 = Rijndael.decrypt(localCachedMessageIntent.intent);
          if ((i.b(str2)) || (Intent.parseUri(str2, 1).getLongExtra("msgId", 0L) == 0L)) {
            break label195;
          }
          localArrayList1.add(localCachedMessageIntent);
        }
        catch (Throwable localThrowable)
        {
          TLogger.e("MessageManager", "clearLocalCachedMsgIntentList", localThrowable);
        }
      }
      else
      {
        localArrayList2.removeAll(localArrayList1);
        updateCachedMsgIntentByPkgName(paramContext, str1, localArrayList2);
        break;
        return;
      }
      label195:
      i += 1;
    }
  }
  
  public void deleteAllCachedMsgIntent(Context paramContext)
  {
    if (paramContext != null) {
      a.a(paramContext);
    }
  }
  
  public void deleteAllCachedMsgIntentByPkgName(Context paramContext, String paramString)
  {
    byte[] arrayOfByte = b;
    if (paramContext != null) {}
    try
    {
      updateCachedMsgIntentByPkgName(paramContext, paramString, new ArrayList());
      return;
    }
    finally {}
  }
  
  public void deleteCachedMsgIntent(Context paramContext, long paramLong)
  {
    if (paramContext != null) {
      a.e(paramContext, paramLong);
    }
  }
  
  public void deleteCachedMsgIntent(Context paramContext, List<CachedMessageIntent> paramList, ArrayList<CachedMessageIntent> paramArrayList)
  {
    byte[] arrayOfByte = b;
    if ((paramContext != null) && (paramList != null)) {}
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      HashMap localHashMap;
      Object localObject2;
      try
      {
        i = paramList.size();
        if (i > 0) {
          try
          {
            localArrayList = new ArrayList();
            if ((paramArrayList != null) && (paramArrayList.size() > 0))
            {
              localHashMap = new HashMap();
              i = 0;
              if (i >= paramArrayList.size()) {
                continue;
              }
              CachedMessageIntent localCachedMessageIntent1 = (CachedMessageIntent)paramArrayList.get(i);
              Iterator localIterator = paramList.iterator();
              if (!localIterator.hasNext()) {
                continue;
              }
              CachedMessageIntent localCachedMessageIntent2 = (CachedMessageIntent)localIterator.next();
              if (!localCachedMessageIntent1.equals(localCachedMessageIntent2)) {
                continue;
              }
              localArrayList.add(localCachedMessageIntent1);
              localObject2 = (ArrayList)localHashMap.get(localCachedMessageIntent2.pkgName);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = new ArrayList();
              }
              localHashMap.put(localCachedMessageIntent2.pkgName, localObject1);
              continue;
            }
          }
          catch (Throwable paramContext)
          {
            TLogger.e("MessageManager", "deleteCachedMsgIntent", paramContext);
          }
        } else {
          return;
        }
      }
      finally {}
      i += 1;
      continue;
      paramArrayList.removeAll(localArrayList);
      Object localObject1 = paramArrayList.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CachedMessageIntent)((Iterator)localObject1).next();
        paramArrayList = (ArrayList)localHashMap.get(((CachedMessageIntent)localObject2).pkgName);
        paramList = paramArrayList;
        if (paramArrayList == null) {
          paramList = new ArrayList();
        }
        paramList.add(localObject2);
        localHashMap.put(((CachedMessageIntent)localObject2).pkgName, paramList);
      }
      else
      {
        paramList = localHashMap.entrySet().iterator();
        while (paramList.hasNext())
        {
          paramArrayList = (Map.Entry)paramList.next();
          updateCachedMsgIntentByPkgName(paramContext, (String)paramArrayList.getKey(), (ArrayList)paramArrayList.getValue());
        }
      }
    }
  }
  
  public void deleteCachedMsgIntentByBusiId(Context paramContext, long paramLong)
  {
    if (paramContext != null) {
      a.f(paramContext, paramLong);
    }
  }
  
  public void deleteCachedMsgIntentByPkgName(Context paramContext, String paramString, long paramLong)
  {
    byte[] arrayOfByte = b;
    if (paramContext != null) {}
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList1 = getCachedMsgIntentListByPkgName(paramContext, paramString);
        if ((localArrayList1 != null) && (localArrayList1.size() > 0))
        {
          ArrayList localArrayList2 = new ArrayList();
          i = 0;
          if (i < localArrayList1.size())
          {
            CachedMessageIntent localCachedMessageIntent = (CachedMessageIntent)localArrayList1.get(i);
            if (localCachedMessageIntent.msgId == paramLong) {
              localArrayList2.add(localCachedMessageIntent);
            }
          }
          else
          {
            if ((localArrayList2 != null) && (localArrayList2.size() == 0)) {
              TLogger.e("MessageManager", "deleteCachedMsgIntentByPkgName do not have MessageId = " + paramLong);
            }
            localArrayList1.removeAll(localArrayList2);
          }
        }
        else
        {
          updateCachedMsgIntentByPkgName(paramContext, paramString, localArrayList1);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void deleteCachedMsgIntentByPkgNameBusiId(Context paramContext, String paramString, long paramLong)
  {
    byte[] arrayOfByte = b;
    if (paramContext != null) {}
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList1 = getCachedMsgIntentListByPkgName(paramContext, paramString);
        if ((localArrayList1 != null) && (localArrayList1.size() > 0))
        {
          ArrayList localArrayList2 = new ArrayList();
          i = 0;
          if (i < localArrayList1.size())
          {
            CachedMessageIntent localCachedMessageIntent = (CachedMessageIntent)localArrayList1.get(i);
            if (paramLong == Intent.parseUri(Rijndael.decrypt(localCachedMessageIntent.intent), 1).getLongExtra("busiMsgId", -1L)) {
              localArrayList2.add(localCachedMessageIntent);
            }
          }
          else
          {
            localArrayList1.removeAll(localArrayList2);
          }
        }
        else
        {
          updateCachedMsgIntentByPkgName(paramContext, paramString, localArrayList1);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public ArrayList<CachedMessageIntent> getCachedMsgIntentList(Context paramContext)
  {
    Iterator localIterator = null;
    Object localObject1 = localIterator;
    if (paramContext != null)
    {
      Object localObject2 = CacheManager.getRegisterInfos(paramContext);
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localObject1 = localIterator;
        if (((List)localObject2).size() > 0)
        {
          localObject1 = new ArrayList();
          localIterator = ((List)localObject2).iterator();
          while (localIterator.hasNext())
          {
            localObject2 = getCachedMsgIntentListByPkgName(paramContext, (String)localIterator.next());
            if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
              ((ArrayList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public ArrayList<CachedMessageIntent> getCachedMsgIntentListByPkgName(Context paramContext, String paramString)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        if (!i.b(paramString))
        {
          paramContext = a(paramContext, paramString, ".tpns.msg.id.cached");
          if (paramContext != null)
          {
            paramContext = (ArrayList)paramContext;
            paramString = paramContext;
            if (paramContext == null) {
              paramString = new ArrayList();
            }
            return paramString;
          }
        }
      }
      catch (Throwable paramContext)
      {
        return new ArrayList();
      }
      paramContext = null;
    }
  }
  
  public ArrayList<Intent> getDonotCachedMsgId(Context paramContext, String paramString)
  {
    byte[] arrayOfByte = b;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        if (!i.b(paramString))
        {
          paramContext = a(paramContext, paramString, ".tpns.msg.id.cached");
          if (paramContext != null)
          {
            paramContext = (ArrayList)paramContext;
            if (paramContext == null)
            {
              paramContext = new ArrayList();
              return paramContext;
            }
            return paramContext;
          }
        }
      }
      finally {}
      paramContext = null;
    }
  }
  
  public ArrayList<Intent> getDonotSendCachedMsgIntentList(Context paramContext)
  {
    if (paramContext != null) {
      return getDonotCachedMsgId(paramContext, paramContext.getPackageName());
    }
    return null;
  }
  
  public ArrayList<MessageId> getMessageIdListByPkgName(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!i.b(paramString)))
    {
      paramContext = a(paramContext, paramString, ".tpns.msg.id");
      if (paramContext == null) {}
    }
    for (paramContext = (ArrayList)paramContext;; paramContext = null)
    {
      paramString = paramContext;
      if (paramContext == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
  }
  
  public MessageId getMsgId(Context paramContext, String paramString, long paramLong)
  {
    if ((paramContext != null) && (!i.b(paramString)) && (paramLong > 0L))
    {
      paramContext = getMessageIdListByPkgName(paramContext, paramString);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          paramString = (MessageId)paramContext.next();
          if (paramString.id == paramLong) {
            return paramString;
          }
        }
      }
    }
    return null;
  }
  
  public ArrayList<Intent> getNewCachedMsgIntentList(Context paramContext)
  {
    if (paramContext != null) {
      return a.c(paramContext);
    }
    return null;
  }
  
  public boolean isMsgAcked(Context paramContext, String paramString, long paramLong)
  {
    if ((paramContext != null) && (!i.b(paramString)) && (paramLong > 0L))
    {
      paramContext = getMessageIdListByPkgName(paramContext, paramString);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          paramString = (MessageId)paramContext.next();
          if (paramString.id == paramLong) {
            return paramString.isMsgAcked();
          }
        }
      }
    }
    return false;
  }
  
  public boolean isMsgCached(Context paramContext, long paramLong)
  {
    if (paramContext != null) {
      a.g(paramContext, paramLong);
    }
    return false;
  }
  
  public void onCrtlMsgHandle(Context paramContext, String paramString)
  {
    boolean bool = false;
    int i = 0;
    try
    {
      paramString = new JSONObject(paramString);
      switch (paramString.optInt("action", 2))
      {
      case 2: 
        deleteAllCachedMsgIntent(paramContext);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageManager", "onCrtlMsgHandle", paramContext);
      return;
    }
    paramString = paramString.optString("pushIdList", "").split(",");
    int j = paramString.length;
    while (i < j)
    {
      deleteCachedMsgIntentByBusiId(paramContext, Long.valueOf(paramString[i]).longValue());
      i += 1;
      continue;
      i = paramString.optInt("enabled", -1);
      TLogger.ii("MessageManager", "setLogToFile with cmd = " + i);
      if (i != -1)
      {
        if (i > 0) {
          bool = true;
        }
        TLogger.enableDebug(paramContext, bool);
        return;
      }
    }
  }
  
  public void updateCachedMsgIntentByPkgName(Context paramContext, String paramString, ArrayList<CachedMessageIntent> paramArrayList)
  {
    byte[] arrayOfByte = b;
    if ((paramContext != null) && (paramArrayList != null)) {}
    try
    {
      TLogger.v("MessageManager", "updateCachedMsgIntentByPkgName, size: " + paramArrayList.size());
      a(paramContext, paramString, ".tpns.msg.id.cached", paramArrayList);
      return;
    }
    finally {}
  }
  
  public void updateCachedMsgIntentToCancel(Context paramContext, long paramLong)
  {
    if (paramContext != null) {
      a.d(paramContext, paramLong);
    }
  }
  
  public void updateCachedMsgIntentToClick(Context paramContext, long paramLong)
  {
    if (paramContext != null) {
      a.c(paramContext, paramLong);
    }
  }
  
  public void updateCachedMsgIntentToShowed(Context paramContext, long paramLong)
  {
    if (paramContext != null) {
      a.a(paramContext, paramLong);
    }
  }
  
  public void updateCachedMsgIntentToVerifyErr(Context paramContext, long paramLong)
  {
    if (paramContext != null) {
      a.b(paramContext, paramLong);
    }
  }
  
  public void updateMsgId(Context paramContext, String paramString, ArrayList<MessageId> paramArrayList)
  {
    byte[] arrayOfByte = b;
    if ((paramContext != null) && (paramArrayList != null)) {}
    try
    {
      a(paramContext, paramString, ".tpns.msg.id", paramArrayList);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.MessageManager
 * JD-Core Version:    0.7.0.1
 */