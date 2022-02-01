import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils.3;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.UinType;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class top
{
  private static ConcurrentHashMap<String, String> cN = new ConcurrentHashMap();
  public static final String[] cf;
  public static final String[] cg;
  public static final String[] ch = { acbn.bkE, acbn.bkY };
  public static final int[] eG = { -1004, -1001, -1002, -2012, -2006, -4001, 193, 734, 230, -4002, -4003, -4004, -2015, -1014, -2061, -4008, -4009, -4012, -2021, -2018, -1040, -1039, -4005, -3009, -4020, -3010, -3011, -2019, -7006, -1041, -1043, -1044, -1045, -5000, -5006, -1017, 1018, -1042, 2024, -1026, -1027, -1028, -5005, -1046, -2027, -2037, -3013, -3014, -3015, -5007, -2030, -4021, -4022, -5011, -1013, -5020, -5022, -5023, -2060, -2023, -2065, -2064, -3016, -2063, -5041, -2073, -7007, -4024, -7010, -7009, -7011 };
  public static final int[] eH = { -2031, -2035, -2036, -2038, -2042, -2043, -5040, -5021 };
  public static final int[] eI = { -3006, -2035, -2036, -2038 };
  public static final int[] eJ = { -4004, -4003, -4009, -4020, -3010, -3011, -1044, -5005, -4021, -4022, -5011, -3014, -2064, -7005 };
  public static final int[] eK = { -1034, -1042, -2015, -2061, -2003, -2004, -2009, -1001, -2076, -2012, -1013, -2030, -1019, -1018, -1014, -1043, -1045, -5000, -5001, -1024, -1028, 2024, -2042, -5005, -1046, -2027, -2037, -5006, -4011, -4012, -2029, -2034, -2033, -2041, -2060, -2065, -2063, -2066, -3016, -7007, -7010, -7009, -7011 };
  public static final int[] eL = { -1004, -1012, -4002, -4003, -4004, -1047, -1013, -2030, -4009, -4012, -1016, -1017, -1050, -2021, -1041, -1043, -1044, -1045, -5000, -5001, 1018, -2016, 2024, -2042, -5005, -5006, -1046, -3013, -3014, -2029, -2034, -2033, -2043, -2041, -5011, -2049, -2063, -3016 };
  public static final int[] eM = { -4003, -4020, -4004, -4009, -5011 };
  public static final int[] eN = { -2006, -1034, -1042, -2015, -2061, -4002, -4003, -4004, -1001, -1047, -1013, -2030, -1019, -1018, -2012, -1014, -1004, -1016, -1017, -1050, -2021, -3011, -4020, -3009, -3010, -1041, -1043, -1044, -1045, -5000, -5001, -1024, -1028, 1018, 2024, -2042, -1012, -1046, -2027, -2029, -2043, -4021, -4022, -2049, -5021, -5023, -2065, -2060, -4023, -4024, -7007, -7010, -7009, -7011 };
  public static final int[] eO = new int[0];
  public static final int[] eP = new int[0];
  public static final int[] eQ = { 1008 };
  public static final int[] eR = { -1000, -2000, -2002, -2005, -1035, -1036, -1037, -20000, -2007, -2011, -2010, -1051 };
  public static final int[] eS = { -2000, -2002, -2007, -2058, -2011, -2020, -2022, -1051, -1035, -2057, -7001, -2071 };
  public static final int[] eT = { -1001, -2009, -2016, -4008 };
  public static final int[] eU = { -2030, -1047, -5040 };
  public static final int[] eV = { -5040, -5020, -5021, -5022, -5023 };
  public static final int[] eW;
  public static final int[] eX;
  public static final int[] eY;
  public static final int[] eZ;
  public static final int[] fa = { 1001, 10002, 1010 };
  public static final int[] fb = { 0, 1, 3000, 1025, 1024 };
  public static final int[] fc = { 0, 1, 3000 };
  static Comparator<MessageRecord> y = new toq();
  
  static
  {
    cf = new String[] { acbn.bkE, acbn.bkt, acbn.bkY, acbn.blg, acbn.blh, acbn.bkA, acbn.bkD, acbn.blK };
    cg = new String[] { acbn.blx };
    eW = new int[] { 0, 1000, 1004, 1020, 1006, 1001, 10002, 10004, 1009, 1003, 1005, 1008, 1023, 1021, 1022, 1024, 1025, 1010, 7400, 1037, 1044, 1045, 1032, 1033, 1034, 1036, 1038, 10007, 10008, 8001 };
    eX = new int[] { 1033, 1034 };
    eY = new int[] { 1000, 1004, 1020 };
    eZ = new int[] { 1, 3000, 1006, 7000, 9501, 10005, 1033, 1034, 1036 };
  }
  
  public static String P(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  public static boolean T(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if ((localMessageRecord.msgtype != -2006) || ((localMessageRecord instanceof MessageForFoldMsg))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean U(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if ((!s(localMessageRecord)) && (localMessageRecord.msgtype != -2006)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean V(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord != null) && (localMessageRecord.msgtype != -2006) && (localMessageRecord.msgtype != -2058)) {
        return false;
      }
    }
    return true;
  }
  
  public static int a(List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    int j;
    if ((paramList == null) || (paramList.isEmpty())) {
      j = 0;
    }
    HashSet localHashSet;
    int i;
    do
    {
      return j;
      localHashSet = new HashSet();
      paramList = paramList.iterator();
      i = 0;
      j = i;
    } while (!paramList.hasNext());
    MessageRecord localMessageRecord = (MessageRecord)paramList.next();
    if ((!localMessageRecord.isread) && (!localMessageRecord.isLongMsg())) {
      i += 1;
    }
    for (;;)
    {
      break;
      j = i;
      if (!localMessageRecord.isread)
      {
        j = i;
        if (localMessageRecord.isLongMsg())
        {
          if (paramQQAppInterface.a().aQ(localMessageRecord)) {
            break;
          }
          j = i;
          if (!localHashSet.contains(f(localMessageRecord)))
          {
            j = i + 1;
            localHashSet.add(f(localMessageRecord));
          }
        }
      }
      i = j;
    }
  }
  
  public static MessageRecord a(List<MessageRecord> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    int i = paramList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label82;
      }
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (!TextUtils.equals(localMessageRecord.frienduin, acbn.blx))
      {
        localObject = localMessageRecord;
        if (localMessageRecord.msgtype != -2006) {
          break;
        }
        localObject = localMessageRecord;
        if ((localMessageRecord instanceof MessageForFoldMsg)) {
          break;
        }
      }
      i -= 1;
    }
    label82:
    return null;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList, boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    if (paramBoolean) {
      Collections.sort(paramList, new tor());
    }
    long l = ((MessageRecord)paramList.get(paramList.size() - 1)).shmsgseq;
    int j = paramList.size() - 1;
    int i = 0;
    int k;
    while (j >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(j);
      if ((fM(localMessageRecord.msgtype)) && (localMessageRecord.shmsgseq == 0L))
      {
        localArrayList.add(0, paramList.get(j));
        k = i;
        j -= 1;
        i = k;
      }
      else if (l - localMessageRecord.shmsgseq <= 1L)
      {
        if ((l != localMessageRecord.shmsgseq) || (j >= paramList.size() - 1)) {
          break label224;
        }
      }
    }
    for (;;)
    {
      l = ((MessageRecord)paramList.get(j)).shmsgseq;
      localArrayList.add(0, paramList.get(j));
      k = i;
      if (i < paramInt) {
        break;
      }
      return localArrayList;
      label224:
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramQQAppInterface.b().k(paramString, paramInt1).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (paramInt2 == localMessageRecord.msgtype) {
        switch (paramInt2)
        {
        default: 
          paramQQAppInterface.b().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -3010: 
          paramQQAppInterface.b().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -4020: 
          paramQQAppInterface.b().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -4022: 
          paramQQAppInterface.b().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -4021: 
          paramQQAppInterface.b().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -3011: 
          if (!avho.aIv()) {
            paramQQAppInterface.b().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          }
          break;
        }
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramMessageRecord.extLong |= 0x1;
      paramMessageRecord.saveExtInfoToExtStr("one_way", "true");
      return;
    }
    paramMessageRecord.removeExtInfoToExtStr("one_way");
  }
  
  public static void a(String paramString, int paramInt, List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      Object localObject2 = new ArrayList();
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramQQAppInterface.a();
      Object localObject3 = paramList.iterator();
      int i = 0;
      int j = 0;
      Object localObject4;
      label166:
      int k;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        String str1;
        if (((MessageRecord)localObject4).isLongMsg())
        {
          str1 = f((MessageRecord)localObject4);
          if (localHashMap.containsKey(str1)) {
            if (Math.abs(((MessageRecord)((ArrayList)localHashMap.get(str1)).get(0)).time - ((MessageRecord)localObject4).time) <= 480L)
            {
              ((ArrayList)localHashMap.get(str1)).add(localObject4);
              ((List)localObject2).add(localObject4);
              k = i;
              i = j;
              j = k;
            }
          }
        }
        for (;;)
        {
          k = i;
          i = j;
          j = k;
          break;
          k = i + 1;
          String str2 = P(str1, k);
          localHashMap.put(str2, localHashMap.get(str1));
          paramQQAppInterface = null;
          i = 0;
          for (;;)
          {
            if (i < localArrayList.size())
            {
              paramQQAppInterface = (Pair)localArrayList.get(i);
              if (!((String)paramQQAppInterface.first).equals(str1)) {}
            }
            else
            {
              if (paramQQAppInterface != null)
              {
                localArrayList.remove(i);
                localArrayList.add(i, new Pair(str2, paramQQAppInterface.second));
              }
              paramQQAppInterface = new ArrayList();
              paramQQAppInterface.add(localObject4);
              localHashMap.put(str1, paramQQAppInterface);
              localArrayList.add(new Pair(str1, Integer.valueOf(j)));
              i = k;
              break;
            }
            i += 1;
          }
          paramQQAppInterface = new ArrayList();
          paramQQAppInterface.add(localObject4);
          localHashMap.put(str1, paramQQAppInterface);
          localArrayList.add(new Pair(str1, Integer.valueOf(j)));
          break label166;
          k = j + 1;
          j = i;
          i = k;
        }
      }
      paramList.removeAll((Collection)localObject2);
      if ((!localHashMap.isEmpty()) && (!localArrayList.isEmpty()))
      {
        if (((anaz)localObject1).a(paramString, paramInt) != null)
        {
          paramQQAppInterface = new ArrayList();
          localObject2 = localHashMap.keySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label766;
            }
            localObject3 = (String)((Iterator)localObject2).next();
            localObject4 = (ArrayList)localHashMap.get(localObject3);
            if (!((ArrayList)localObject4).isEmpty()) {
              if ((((MessageRecord)((ArrayList)localObject4).get(0)).longMsgCount <= ((ArrayList)localObject4).size()) || (((MessageRecord)((ArrayList)localObject4).get(0)).isSendFromLocal()))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: complete online msg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + (String)localObject3);
                }
                ((anaz)localObject1).Y(paramString, paramInt, (String)localObject3);
              }
              else if (((anaz)localObject1).m(paramString, paramInt, (String)localObject3))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: incomplete online msg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + (String)localObject3);
                }
                paramQQAppInterface.add(localObject3);
                localObject4 = localArrayList.iterator();
                if (((Iterator)localObject4).hasNext())
                {
                  if (!TextUtils.equals((CharSequence)((Pair)((Iterator)localObject4).next()).first, (CharSequence)localObject3)) {
                    break;
                  }
                  ((Iterator)localObject4).remove();
                }
              }
            }
          }
          label766:
          if (!paramQQAppInterface.isEmpty())
          {
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext()) {
              localHashMap.remove((String)paramQQAppInterface.next());
            }
          }
        }
        j = localArrayList.size() - 1;
        while (j >= 0)
        {
          paramQQAppInterface = (Pair)localArrayList.get(j);
          localObject2 = (ArrayList)localHashMap.get(paramQQAppInterface.first);
          try
          {
            Collections.sort((List)localObject2, y);
            localObject1 = new ArrayList();
            localObject2 = ((ArrayList)localObject2).iterator();
            i = 0;
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label1084;
              }
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if (!u((MessageRecord)localObject3)) {
                break;
              }
              ((ArrayList)localObject1).add(localObject3);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.MsgProxyUtils", 2, "sort long msg error", localException);
                continue;
                k = i;
                if (!localException.isEmpty())
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + f((MessageRecord)localException.get(0)));
                  }
                  paramList.add(i + ((Integer)paramQQAppInterface.second).intValue(), new MessageForLongMsg(localException));
                  localException.clear();
                  k = i + 1;
                }
                paramList.add(k + ((Integer)paramQQAppInterface.second).intValue(), localObject3);
                i = k + 1;
              }
            }
            label1084:
            if (!localException.isEmpty())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + f((MessageRecord)localException.get(0)));
              }
              paramList.add(((Integer)paramQQAppInterface.second).intValue() + i, new MessageForLongMsg(localException));
              localException.clear();
            }
            j -= 1;
          }
        }
      }
    }
  }
  
  public static void a(List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      String str;
      do
      {
        return;
        ArrayList localArrayList = new ArrayList(8);
        str = null;
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord == null)
          {
            localArrayList.add(localMessageRecord);
          }
          else
          {
            str = localMessageRecord.frienduin;
            if ((localMessageRecord.msgtype == -2006) || (!localMessageRecord.isValid)) {
              localArrayList.add(localMessageRecord);
            }
            for (;;)
            {
              break;
              if ((localMessageRecord.msgtype == -2015) && ((localMessageRecord instanceof MessageForQzoneFeed)))
              {
                ((MessageForQzoneFeed)localMessageRecord).parse();
                if (avpw.aLj())
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,空间下发配置屏蔽 aiofeeds，不再显示");
                  }
                  localArrayList.add(localMessageRecord);
                }
                else if (((MessageForQzoneFeed)localMessageRecord).isOldStructMsg)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,空间aio feeds格式不兼容，不再显示");
                  }
                  localArrayList.add(localMessageRecord);
                }
                else if (FeedsManager.isShowStatus(localMessageRecord.frienduin))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,当前会话列表中有新动态，先将aio中的feeds隐藏，避免aio中的feeds跳变");
                  }
                  localArrayList.add(localMessageRecord);
                }
              }
            }
          }
        }
        paramList.removeAll(localArrayList);
      } while ((str == null) || (!FeedsManager.isShowStatus(str)) || (paramQQAppInterface == null));
      paramQQAppInterface = (wkh)paramQQAppInterface.getManager(282);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.d(paramList, false);
  }
  
  public static void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1)) {
        c(paramList, paramMessageRecord, paramBoolean);
      }
    }
    else {
      return;
    }
    if (fv(paramMessageRecord.istroop))
    {
      b(paramList, paramMessageRecord, paramBoolean);
      return;
    }
    paramList.add(paramMessageRecord);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 1) {
      return !((HotChatManager)paramQQAppInterface.getManager(60)).kj(paramString);
    }
    paramQQAppInterface = fc;
    int j = paramQQAppInterface.length;
    int i = 0;
    while (i < j)
    {
      if (paramQQAppInterface[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    boolean bool = true;
    if (paramMessageRecord1.msgtype != paramMessageRecord2.msgtype) {
      bool = false;
    }
    String str;
    Object localObject;
    label513:
    label579:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return bool;
                          str = paramMessageRecord1.msg;
                          localObject = paramMessageRecord2.msg;
                          if (paramMessageRecord2.msgtype != -1000) {
                            break;
                          }
                        } while (TextUtils.equals(str, (CharSequence)localObject));
                        return false;
                        if (paramMessageRecord2.msgtype == -2002)
                        {
                          if (((paramMessageRecord2 instanceof MessageForPtt)) && ((paramMessageRecord1 instanceof MessageForPtt)) && (((MessageForPtt)paramMessageRecord1).urlAtServer != null) && (((MessageForPtt)paramMessageRecord1).urlAtServer.length() > 0) && (((MessageForPtt)paramMessageRecord2).urlAtServer != null) && (((MessageForPtt)paramMessageRecord2).urlAtServer.length() > 0)) {
                            return ((MessageForPtt)paramMessageRecord1).urlAtServer.equals(((MessageForPtt)paramMessageRecord2).urlAtServer);
                          }
                          return false;
                        }
                        if (paramMessageRecord2.msgtype == -2011)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("Debug", 2, "c2c" + Arrays.toString(paramMessageRecord1.msgData) + " : " + Arrays.toString(paramMessageRecord2.msgData));
                          }
                          return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                        }
                        if (paramMessageRecord2.msgtype != -2000) {
                          break label579;
                        }
                        if ((str == null) || (localObject == null) || (str.length() <= 0) || (((String)localObject).length() <= 0) || (str.charAt(0) != '\026') || (((String)localObject).charAt(0) != '\026')) {
                          break label513;
                        }
                        paramMessageRecord1 = h((String)localObject);
                        localObject = h(str);
                        if ((paramMessageRecord1 == null) || (localObject == null)) {
                          return false;
                        }
                        if ((!paramMessageRecord1[1].equals(localObject[1])) || (!paramMessageRecord1[2].equals(localObject[2]))) {
                          return false;
                        }
                        if ((paramMessageRecord2.issend != 2) && (!paramMessageRecord2.isSendFromLocal())) {
                          break;
                        }
                      } while (!QLog.isColorLevel());
                      QLog.d("Q.msg.MsgProxyUtils", 2, "-------->compMsgContent: samePic: picSize:" + paramMessageRecord1[1] + ",picType:" + paramMessageRecord1[2] + ",isSend == true");
                      return true;
                      if (!str.contains(acbn.SDCARD_PATH)) {
                        break;
                      }
                      paramMessageRecord2 = localObject[0].split("/");
                      paramMessageRecord2 = paramMessageRecord2[(paramMessageRecord2.length - 1)].split("\\.")[0];
                      str = MD5.toMD5(paramMessageRecord1[4]);
                      if (!str.equals(paramMessageRecord2)) {
                        break label1273;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d("Q.msg.MsgProxyUtils", 2, "-------->compMsgContent: samePic: picSize:" + paramMessageRecord1[1] + ",picType:" + paramMessageRecord1[2] + ",Path:" + str);
                    return true;
                    return localObject[0].equals(paramMessageRecord1[0]);
                    if ((((MessageForPic)paramMessageRecord1).uuid != null) && (((MessageForPic)paramMessageRecord1).uuid.length() > 0) && (((MessageForPic)paramMessageRecord2).uuid != null) && (((MessageForPic)paramMessageRecord2).uuid.length() > 0)) {
                      return ((MessageForPic)paramMessageRecord1).uuid.equals(((MessageForPic)paramMessageRecord2).uuid);
                    }
                    return false;
                    if ((paramMessageRecord2.msgtype == -2007) && (paramMessageRecord1.msgtype == -2007)) {
                      return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                    }
                    if ((paramMessageRecord2.msgtype == -2058) && (paramMessageRecord1.msgtype == -2058))
                    {
                      if (((!(paramMessageRecord2 instanceof MessageForMarketFace)) || (!(paramMessageRecord1 instanceof MessageForMarketFace))) && ((!(paramMessageRecord2 instanceof MessageForText)) || (!(paramMessageRecord1 instanceof MessageForText))) && ((!(paramMessageRecord2 instanceof MessageForPic)) || (!(paramMessageRecord1 instanceof MessageForPic)))) {
                        break label1273;
                      }
                      return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                    }
                    if ((paramMessageRecord2.msgtype == -1035) && (paramMessageRecord1.msgtype == -1035)) {
                      return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                    }
                    if ((paramMessageRecord2.msgtype != -1034) || (paramMessageRecord1.msgtype != -1034)) {
                      break;
                    }
                  } while ((paramMessageRecord2.time == paramMessageRecord1.time) && (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq));
                  return false;
                  if ((paramMessageRecord2.msgtype != -1042) || (paramMessageRecord1.msgtype != -1042)) {
                    break;
                  }
                } while (paramMessageRecord2.time == paramMessageRecord1.time);
                return false;
                if ((paramMessageRecord2.msgtype != -2015) || (paramMessageRecord1.msgtype != -2015)) {
                  break;
                }
              } while ((paramMessageRecord2.time == paramMessageRecord1.time) && (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq));
              return false;
              if ((paramMessageRecord2.msgtype != -7007) || (paramMessageRecord1.msgtype != -7007)) {
                break;
              }
            } while ((paramMessageRecord2.time == paramMessageRecord1.time) && (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq));
            return false;
            if ((paramMessageRecord2.msgtype == -2010) && (paramMessageRecord1.msgtype == -2010)) {
              return ((MessageForFunnyFace)paramMessageRecord2).msgEquals((MessageForFunnyFace)paramMessageRecord1);
            }
            if ((paramMessageRecord2.msgtype == -2060) && (paramMessageRecord1.msgtype == -2060)) {
              return ((MessageForPLNews)paramMessageRecord2).msgEquals((MessageForPLNews)paramMessageRecord1);
            }
            if ((paramMessageRecord2.msgtype != -2065) && (paramMessageRecord2.msgtype != -4023) && (paramMessageRecord2.msgtype != -2066) && (paramMessageRecord2.msgtype != -7009) && (paramMessageRecord2.msgtype != -7010) && (paramMessageRecord2.msgtype != -7011)) {
              break;
            }
          } while (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq);
          return false;
          if (paramMessageRecord2.msgtype != -2005) {
            break label1079;
          }
          if ((!(paramMessageRecord2 instanceof MessageForFile)) || (!(paramMessageRecord1 instanceof MessageForFile))) {
            break;
          }
        } while ((paramMessageRecord2.msgUid == paramMessageRecord1.msgUid) && (paramMessageRecord2.msgseq == paramMessageRecord1.msgseq));
        return false;
        return false;
        if (paramMessageRecord2.msgtype == -2017) {
          return false;
        }
        if (paramMessageRecord2.msgtype != -5008) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxyUtils", 2, new Object[] { "AAShare.compMsgContent recRecord.msgUid=", Long.valueOf(paramMessageRecord2.msgUid), ",cacheRecord.msgUid,", Long.valueOf(paramMessageRecord1.msgUid) });
        }
      } while (paramMessageRecord2.msgUid == paramMessageRecord1.msgUid);
      return false;
      if (paramMessageRecord2.msgtype == -2022)
      {
        if ((!TextUtils.isEmpty(((MessageForShortVideo)paramMessageRecord2).md5)) && (!TextUtils.isEmpty(((MessageForShortVideo)paramMessageRecord1).md5))) {
          return ((MessageForShortVideo)paramMessageRecord1).md5.equals(((MessageForShortVideo)paramMessageRecord2).md5);
        }
        if ((!TextUtils.isEmpty(((MessageForShortVideo)paramMessageRecord2).uuid)) && (!TextUtils.isEmpty(((MessageForShortVideo)paramMessageRecord1).uuid))) {
          return ((MessageForShortVideo)paramMessageRecord1).uuid.equals(((MessageForShortVideo)paramMessageRecord2).uuid);
        }
        return false;
      }
    } while (TextUtils.equals(str, (CharSequence)localObject));
    label1079:
    label1273:
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramMessageRecord1.msgtype == paramMessageRecord2.msgtype) {
      if (paramMessageRecord1.msgUid != 0L) {
        if (paramBoolean)
        {
          bool1 = bool2;
          if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
          {
            bool1 = bool2;
            if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
              bool1 = true;
            }
          }
          paramBoolean = bool1;
          if (!bool1) {
            if (paramMessageRecord1.msgtype != -2005)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.msgtype != -2002) {}
            }
            else if (paramMessageRecord2.istroop == 1008)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.msgtype != -2005) {}
            }
            else
            {
              paramBoolean = bool1;
              if (b(paramMessageRecord1, paramMessageRecord2)) {
                paramBoolean = true;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (QLog.isColorLevel())) {
        QLog.w("Q.msg.MsgProxyUtils", 2, "friend---------------msgFilter istroop: " + paramMessageRecord2.istroop + " friendUin: " + paramMessageRecord2.frienduin + " senderUin: " + paramMessageRecord2.senderuin + " LOC_shmsgseq: " + paramMessageRecord1.shmsgseq + " NEW_shmsgseq:" + paramMessageRecord1.shmsgseq + " LOC_msgType: " + paramMessageRecord1.msgtype + " NEW_msgType" + paramMessageRecord2.msgtype + " LOC_msgtime: " + paramMessageRecord1.time + " NEW_msgtime:" + paramMessageRecord2.time + " LOC_msgUid:" + paramMessageRecord1.msgUid + " NEW_msgUid:" + paramMessageRecord2.msgUid + " LOC_msgContent: " + paramMessageRecord1.getLogColorContent() + " NEW_msgContent:" + paramMessageRecord2.getLogColorContent());
      }
      return paramBoolean;
      paramBoolean = bool1;
      if (b(paramMessageRecord1, paramMessageRecord2))
      {
        paramBoolean = true;
        continue;
        paramBoolean = bool1;
        if (b(paramMessageRecord1, paramMessageRecord2))
        {
          paramBoolean = true;
          continue;
          if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2007))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -2001) && (paramMessageRecord2.msgtype == -2000))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.time == paramMessageRecord2.time)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2011))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2022))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2025))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if (ahwb.aB(paramMessageRecord1))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord2.msgtype == -1051) && ((paramMessageRecord1.msgtype == -1000) || (paramMessageRecord1.msgtype == -2011)))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -2011) && (paramMessageRecord2.msgtype == -1000))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1035) && (paramMessageRecord2.msgtype == -1051))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord2.msgtype == -1035) && (paramMessageRecord1.msgtype == -1051))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -5012))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgtype == -1000)
            {
              paramBoolean = bool1;
              if (paramMessageRecord2.msgtype == -2071)
              {
                paramBoolean = bool1;
                if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
                {
                  paramBoolean = bool1;
                  if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                    paramBoolean = true;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if ((paramMessageRecord1.frienduin == null) || (!paramMessageRecord1.frienduin.equals(paramMessageRecord2.frienduin))) {
      paramBoolean1 = false;
    }
    label68:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return paramBoolean1;
                                if (paramBoolean1) {
                                  break label285;
                                }
                                if (paramBoolean2) {
                                  break label68;
                                }
                                if (Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) >= 30L) {
                                  break;
                                }
                                paramBoolean1 = bool;
                              } while (a(paramMessageRecord1, paramMessageRecord2));
                              return false;
                              if (paramMessageRecord1.shmsgseq != paramMessageRecord2.shmsgseq) {
                                break;
                              }
                              paramBoolean1 = bool;
                            } while (paramMessageRecord1.msgtype == paramMessageRecord2.msgtype);
                            if (paramMessageRecord1.msgtype != -1000) {
                              break;
                            }
                            paramBoolean1 = bool;
                          } while (paramMessageRecord2.msgtype == -2007);
                          paramBoolean1 = bool;
                        } while (paramMessageRecord1.msgtype == -2006);
                        paramBoolean1 = bool;
                      } while (paramMessageRecord2.msgtype == -2006);
                      if (paramMessageRecord1.msgtype != -1000) {
                        break;
                      }
                      paramBoolean1 = bool;
                    } while (paramMessageRecord2.msgtype == -2011);
                    paramBoolean1 = bool;
                  } while (ahwb.aB(paramMessageRecord1));
                  if (paramMessageRecord2.msgtype != -1051) {
                    break;
                  }
                  paramBoolean1 = bool;
                } while (paramMessageRecord1.msgtype == -1000);
                paramBoolean1 = bool;
              } while (paramMessageRecord1.msgtype == -2011);
              if (paramMessageRecord1.msgtype != -2011) {
                break;
              }
              paramBoolean1 = bool;
            } while (paramMessageRecord2.msgtype == -1000);
            if (paramMessageRecord2.msgtype != -1051) {
              break;
            }
            paramBoolean1 = bool;
          } while (paramMessageRecord1.msgtype == -1035);
          if (paramMessageRecord1.msgtype != -1051) {
            break;
          }
          paramBoolean1 = bool;
        } while (paramMessageRecord2.msgtype == -1035);
        return false;
        return false;
        if (!paramMessageRecord1.isSendFromLocal()) {
          return false;
        }
        if ((paramMessageRecord1.extraflag != 32772) && (paramMessageRecord1.extraflag != 32768)) {
          if (paramMessageRecord1.msgtype == -1035)
          {
            if (paramMessageRecord1.extraflag != 32770) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        if (paramMessageRecord1.msgtype == -2006) {
          return false;
        }
        if ((paramMessageRecord1.senderuin == null) || (!paramMessageRecord1.senderuin.equals(paramMessageRecord2.senderuin))) {
          return false;
        }
        if ((paramMessageRecord1.msgUid == 0L) || (paramMessageRecord2.msgUid == 0L) || (paramMessageRecord1.msgUid != paramMessageRecord2.msgUid)) {
          break;
        }
        paramBoolean1 = bool;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MsgProxyUtils", 2, "compTroopMsgContent RewriteSeq: find msg by uid=" + paramMessageRecord1.msgUid);
      return true;
      if ((Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) >= 510L) && (Math.abs(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) >= 2L)) {
        break;
      }
      paramBoolean1 = bool;
    } while (a(paramMessageRecord1, paramMessageRecord2));
    label285:
    return false;
  }
  
  public static byte[] a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)anbi.d(-2017);
    MessageRecord.copyMessageRecordBaseField(localMessageForTroopFile, paramMessageRecord1);
    localMessageForTroopFile.doParse();
    paramMessageRecord1 = (MessageForTroopFile)anbi.d(-2017);
    MessageRecord.copyMessageRecordBaseField(paramMessageRecord1, paramMessageRecord2);
    paramMessageRecord1.doParse();
    localMessageForTroopFile.bisID = paramMessageRecord1.bisID;
    localMessageForTroopFile.dspFileName = paramMessageRecord1.dspFileName;
    localMessageForTroopFile.dspFileSize = paramMessageRecord1.dspFileSize;
    localMessageForTroopFile.fileSize = paramMessageRecord1.fileSize;
    localMessageForTroopFile.fileName = paramMessageRecord1.fileName;
    localMessageForTroopFile.url = paramMessageRecord1.url;
    if ((paramMessageRecord1.width != 0) && (paramMessageRecord1.height != 0))
    {
      localMessageForTroopFile.width = paramMessageRecord1.width;
      localMessageForTroopFile.height = paramMessageRecord1.height;
    }
    if (paramMessageRecord1.duration != 0) {
      localMessageForTroopFile.duration = paramMessageRecord1.duration;
    }
    localMessageForTroopFile.serial();
    return localMessageForTroopFile.msgData;
  }
  
  public static List<MessageRecord> aC(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((!fG(localMessageRecord.msgtype)) && (((localMessageRecord.istroop != 3000) && (localMessageRecord.istroop != 1)) || (localMessageRecord.shmsgseq > 0L))) {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  public static int ag(int paramInt1, int paramInt2)
  {
    return aegu.ag(paramInt1, paramInt2);
  }
  
  public static boolean ap(String paramString)
  {
    return acbn.blj.equals(paramString);
  }
  
  public static boolean as(int paramInt1, int paramInt2)
  {
    return ((eD(paramInt1) == 1001) || (eD(paramInt1) == 10002)) && (paramInt2 != -3001) && (paramInt2 != -3000) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != -1003);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MsgProxyUtils.3(paramQQAppInterface, paramString, paramInt1, paramInt2), 8, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    for (;;)
    {
      int j;
      try
      {
        if (!QLog.isColorLevel()) {
          break label452;
        }
        l = System.currentTimeMillis();
        j = 0;
        k = 0;
        List localList = paramQQAppInterface.a(1).i(paramString, 1);
        if (localList != null) {
          break label449;
        }
        localList = paramQQAppInterface.a(1).e(paramString, 1, 1L + paramLong, 2147483647L);
        if ((localList != null) && (localList.size() > 0))
        {
          m = localList.size() - 1;
          j = 0;
          i = 0;
          k = 0;
          if (m >= 0)
          {
            MessageRecord localMessageRecord = (MessageRecord)localList.get(m);
            if (localMessageRecord.shmsgseq > paramLong)
            {
              if ((!s(localMessageRecord)) && (localMessageRecord.msgtype != -2006)) {
                break label428;
              }
              paramQQAppInterface.b().t(paramString, 1, localMessageRecord.uniseq);
              if (QLog.isColorLevel())
              {
                QLog.d(".troop.del_abnormal_troop_local_msg", 2, "delAbnormalLocalTroopMsg: " + paramLong + ", " + localMessageRecord.getBaseInfoString());
                j += 1;
                i = localMessageRecord.msgtype;
                k = 1;
                break label458;
              }
              QLog.d(".troop.del_abnormal_troop_local_msg", 1, "delAbnormalLocalTroopMsg: " + paramLong + ", " + localMessageRecord.getUserLogString());
              continue;
            }
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.del_abnormal_troop_local_msg", 2, "delAbnormalLocalTroopMsg:" + paramQQAppInterface.toString());
        }
        return;
      }
      for (;;)
      {
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, "---delAbnormalLocalTroopMsg---:" + paramString + "," + paramLong + "," + (System.currentTimeMillis() - l));
        if (i == 0) {
          break;
        }
        anot.a(paramQQAppInterface, "dc00899", "BizTechReport", "", "Grp_msg", "del_abnormal_local_msg", 0, 0, paramString, j + "", k + "", "");
        return;
        label428:
        n = i;
        i = k;
        k = n;
        break label458;
        i = 0;
      }
      label449:
      continue;
      label452:
      long l = 0L;
      continue;
      label458:
      int n = m - 1;
      int m = k;
      int k = i;
      int i = m;
      m = n;
    }
  }
  
  public static void b(List<MessageRecord> paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int k = 0;
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxyUtils", 2, "insertToListByTime, list is null");
      }
      return;
    }
    Iterator localIterator = paramList.iterator();
    int j = 0;
    for (;;)
    {
      int i = k;
      MessageRecord localMessageRecord;
      if (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.time <= paramMessageRecord.time) {
          break label88;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label163;
        }
        paramList.add(paramMessageRecord);
        return;
        label88:
        if (localMessageRecord.time != paramMessageRecord.time) {
          break;
        }
        if (((localMessageRecord instanceof MessageForUniteGrayTip)) && ((paramMessageRecord instanceof MessageForUniteGrayTip)))
        {
          if (((MessageForUniteGrayTip)localMessageRecord).tipParam.dbL <= ((MessageForUniteGrayTip)paramMessageRecord).tipParam.dbL) {
            break;
          }
          i = 1;
        }
        else
        {
          if (paramBoolean) {
            break;
          }
          i = 1;
        }
      }
      j += 1;
    }
    label163:
    paramList.add(j, paramMessageRecord);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1)
    {
      if (((HotChatManager)paramQQAppInterface.getManager(60)).kj(paramMessageRecord.frienduin)) {
        return true;
      }
    }
    else if (paramMessageRecord.istroop == 1026) {
      return true;
    }
    return false;
  }
  
  private static boolean b(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    boolean bool = true;
    if (paramMessageRecord1.msgtype == -1034) {
      bool = a(paramMessageRecord1, paramMessageRecord2);
    }
    do
    {
      return bool;
      if (paramMessageRecord1.msgtype == -1042) {
        return a(paramMessageRecord1, paramMessageRecord2);
      }
      if ((paramMessageRecord1.msgtype != -2000) && (paramMessageRecord1.msgtype != -1000)) {
        break;
      }
    } while ((Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) < 30L) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) && (a(paramMessageRecord1, paramMessageRecord2)));
    do
    {
      do
      {
        return false;
        if (paramMessageRecord1.msgtype == -2002) {
          return a(paramMessageRecord1, paramMessageRecord2);
        }
        if (paramMessageRecord1.msgtype == -2005) {
          return a(paramMessageRecord1, paramMessageRecord2);
        }
        if (paramMessageRecord1.msgtype == -5007) {
          return a(paramMessageRecord1, paramMessageRecord2);
        }
      } while ((Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) >= 30L) || (paramMessageRecord1.shmsgseq != paramMessageRecord2.shmsgseq));
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MsgProxyUtils", 2, "other equal : mr.shmsgseq = " + paramMessageRecord1.shmsgseq);
      }
    } while (!a(paramMessageRecord1, paramMessageRecord2));
    return true;
  }
  
  public static boolean b(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject;
    do
    {
      while (!paramList.hasNext())
      {
        do
        {
          return false;
          paramString = new HashMap();
          paramList = paramList.iterator();
          paramInt = 0;
          if (paramList.hasNext())
          {
            localObject = (MessageRecord)paramList.next();
            String str;
            if (((MessageRecord)localObject).isLongMsg())
            {
              str = f((MessageRecord)localObject);
              if (paramString.containsKey(str)) {
                if (Math.abs(((MessageRecord)((ArrayList)paramString.get(str)).get(0)).time - ((MessageRecord)localObject).time) <= 480L) {
                  ((ArrayList)paramString.get(str)).add(localObject);
                }
              }
            }
            for (;;)
            {
              break;
              paramInt += 1;
              paramString.put(P(str, paramInt), paramString.get(str));
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localObject);
              paramString.put(str, localArrayList);
              continue;
              localArrayList = new ArrayList();
              localArrayList.add(localObject);
              paramString.put(str, localArrayList);
            }
          }
        } while (paramString.isEmpty());
        paramList = paramString.keySet().iterator();
      }
      localObject = (ArrayList)paramString.get((String)paramList.next());
    } while ((((ArrayList)localObject).isEmpty()) || (((MessageRecord)((ArrayList)localObject).get(0)).longMsgCount <= ((ArrayList)localObject).size()) || (((MessageRecord)((ArrayList)localObject).get(0)).isSendFromLocal()));
    return true;
  }
  
  public static int bA(String paramString)
  {
    if (paramString.startsWith("mr_discusssion")) {
      return 3000;
    }
    if (paramString.startsWith("mr_friend")) {
      return 0;
    }
    return 1;
  }
  
  public static void c(List<MessageRecord> paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int k = 0;
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxyUtils", 2, "insertToListBySeq, list is null");
      }
      return;
    }
    Iterator localIterator = paramList.iterator();
    int j = 0;
    for (;;)
    {
      int i = k;
      MessageRecord localMessageRecord;
      if (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.shmsgseq <= paramMessageRecord.shmsgseq) {
          break label88;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label163;
        }
        paramList.add(paramMessageRecord);
        return;
        label88:
        if (localMessageRecord.shmsgseq != paramMessageRecord.shmsgseq) {
          break;
        }
        if (((localMessageRecord instanceof MessageForUniteGrayTip)) && ((paramMessageRecord instanceof MessageForUniteGrayTip)))
        {
          if (((MessageForUniteGrayTip)localMessageRecord).tipParam.dbL <= ((MessageForUniteGrayTip)paramMessageRecord).tipParam.dbL) {
            break;
          }
          i = 1;
        }
        else
        {
          if (paramBoolean) {
            break;
          }
          i = 1;
        }
      }
      j += 1;
    }
    label163:
    paramList.add(j, paramMessageRecord);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isOpenTroopMessage) {
      return true;
    }
    if (paramMessageRecord.istroop == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.kz(paramMessageRecord.frienduin))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  public static boolean c(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (paramMessageRecord1.isLongMsg()) && (paramMessageRecord2.isLongMsg()) && (paramMessageRecord1.longMsgId == paramMessageRecord2.longMsgId) && (paramMessageRecord1.longMsgCount == paramMessageRecord2.longMsgCount) && (TextUtils.equals(paramMessageRecord1.senderuin, paramMessageRecord2.senderuin)) && (Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) <= 480L);
  }
  
  public static String co(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return acbn.bkE;
    case 1001: 
    case 10002: 
      return acbn.bkE;
    case 1010: 
      return acbn.bkY;
    }
    return acbn.bkt;
  }
  
  public static String cp(int paramInt)
  {
    String str = "c2c_processor";
    if (paramInt == 1) {
      str = "troop_processor";
    }
    do
    {
      return str;
      if (paramInt == 1026) {
        return "hctopic_processor";
      }
    } while (paramInt != 3000);
    return "disc_processor";
  }
  
  public static List<MessageRecord> d(List<MessageRecord> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, 15);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return (v(paramMessageRecord)) && (!x(paramMessageRecord.frienduin, paramMessageRecord.istroop)) && (paramQQAppInterface.a().gO(paramMessageRecord.frienduin));
  }
  
  public static String e(MessageRecord paramMessageRecord)
  {
    int i = 1033;
    if (paramMessageRecord.istroop == 1032)
    {
      if (paramMessageRecord.isSelfConfessor()) {}
      for (;;)
      {
        return aegu.g(paramMessageRecord.senderuin, i, paramMessageRecord.getConfessTopicId());
        i = 1034;
      }
    }
    if ((paramMessageRecord.istroop == 1033) || (paramMessageRecord.istroop == 1034)) {
      return aegu.g(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId());
    }
    return paramMessageRecord.senderuin;
  }
  
  public static List<MessageRecord> e(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList1 == null) || (paramList2 == null)) {
      return null;
    }
    paramList2 = paramList2.iterator();
    label191:
    for (;;)
    {
      MessageRecord localMessageRecord1;
      if (paramList2.hasNext())
      {
        localMessageRecord1 = (MessageRecord)paramList2.next();
        Iterator localIterator = paramList1.iterator();
        MessageRecord localMessageRecord2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localMessageRecord2 = (MessageRecord)localIterator.next();
        } while ((localMessageRecord1.getId() != localMessageRecord1.getId()) || (localMessageRecord1.shmsgseq != localMessageRecord2.shmsgseq) || (localMessageRecord1.msgtype != localMessageRecord2.msgtype) || (localMessageRecord1.time != localMessageRecord2.time) || (localMessageRecord1.msgUid != localMessageRecord2.msgUid) || (localMessageRecord1.longMsgIndex != localMessageRecord2.longMsgIndex) || (localMessageRecord1.longMsgId != localMessageRecord2.longMsgId));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label191;
        }
        localArrayList.add(localMessageRecord1);
        break;
        return localArrayList;
      }
    }
  }
  
  public static int eD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 1001: 
    case 10002: 
      return 1001;
    case 1010: 
      return 1010;
    case 1009: 
      return 1009;
    case 1032: 
    case 1033: 
    case 1034: 
      return 1032;
    }
    return 1044;
  }
  
  public static String f(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.longMsgId + "&" + paramMessageRecord.senderuin + "&" + paramMessageRecord.longMsgCount;
  }
  
  public static boolean fA(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eN;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fB(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eV;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fC(int paramInt)
  {
    boolean bool2 = fB(paramInt);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = anbk.ls(paramInt);
    }
    return bool1;
  }
  
  public static boolean fD(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eH;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fE(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eI;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fF(int paramInt)
  {
    if (eO.length == 0) {}
    for (;;)
    {
      return false;
      int[] arrayOfInt = eO;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean fG(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eJ;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fH(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eR;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fI(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eS;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fJ(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eT;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fK(int paramInt)
  {
    return paramInt == -2006;
  }
  
  public static boolean fL(int paramInt)
  {
    return (eD(paramInt) == 1001) || (eD(paramInt) == 10002) || (eD(paramInt) == 1009) || (eD(paramInt) == 1010) || (eD(paramInt) == 1032);
  }
  
  public static boolean fM(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eU;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fN(int paramInt)
  {
    return paramInt == 1025;
  }
  
  public static boolean fO(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 10002);
  }
  
  public static boolean fP(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = fb;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fs(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1) || (paramInt == 1026);
  }
  
  public static boolean ft(int paramInt)
  {
    if (eP.length == 0) {}
    for (;;)
    {
      return false;
      int[] arrayOfInt = eP;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean fu(int paramInt)
  {
    if (eQ.length == 0) {}
    for (;;)
    {
      return false;
      int[] arrayOfInt = eQ;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean fv(int paramInt)
  {
    boolean bool = false;
    Object localObject = eW;
    int j = localObject.length;
    int i = 0;
    if (i < j) {
      if (localObject[i] == paramInt) {
        bool = true;
      }
    }
    do
    {
      return bool;
      i += 1;
      break;
      localObject = UinType.valueOf(paramInt);
    } while (localObject == null);
    return ((UinType)localObject).isC2CConversation();
  }
  
  public static boolean fw(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eY;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fx(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eZ;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean fy(int paramInt)
  {
    int[] arrayOfInt = eK;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean fz(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eG;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String g(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1004))
    {
      if (paramMessageRecord.isSend()) {
        return paramMessageRecord.selfuin;
      }
      return paramMessageRecord.frienduin;
    }
    if ((paramMessageRecord.istroop == 1) && (jof.b(paramMessageRecord))) {
      return "80000000";
    }
    return paramMessageRecord.senderuin;
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 3000)
    {
      acdu localacdu = (acdu)paramQQAppInterface.getManager(53);
      DiscussionInfo localDiscussionInfo = localacdu.a(paramString, true);
      if ((localDiscussionInfo == null) || (localDiscussionInfo.isHidden())) {
        return true;
      }
      paramQQAppInterface = localacdu.a(paramString, paramQQAppInterface.getCurrentAccountUin());
      if (paramQQAppInterface != null) {
        return (paramQQAppInterface.flag & 0x1) == 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxyUtils", 2, String.format("isDiscussionFilter, discuss meminfo not find, uin:%s, uinType: %d ", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
    }
    return false;
  }
  
  public static boolean gP(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = cf;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean gQ(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (paramString.contains("&")))
    {
      bool1 = false;
      return bool1;
    }
    String[] arrayOfString = cf;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label57;
      }
      bool1 = bool2;
      if (paramString.equals(arrayOfString[i])) {
        break;
      }
      i += 1;
    }
    label57:
    arrayOfString = cg;
    j = arrayOfString.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label94;
      }
      bool1 = bool2;
      if (paramString.equals(arrayOfString[i])) {
        break;
      }
      i += 1;
    }
    label94:
    return false;
  }
  
  public static boolean gR(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!acbn.blg.equals(paramString)) && (!acbn.blh.equals(paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean gS(String paramString)
  {
    return (acbn.bli.equals(paramString)) || (acbn.blj.equals(paramString));
  }
  
  public static boolean gT(String paramString)
  {
    return acbn.blk.equals(paramString);
  }
  
  public static boolean gU(String paramString)
  {
    return acbn.bli.equals(paramString);
  }
  
  public static boolean gV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals("1822701914");
  }
  
  public static String gY(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    if (cN.containsKey(str)) {
      return (String)cN.get(str);
    }
    paramString = MD5.toMD5(str);
    if (cN.size() > 3000) {
      cN.clear();
    }
    cN.put(str, paramString);
    return paramString;
  }
  
  static String[] h(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0)
      {
        localObject1 = localObject2;
        if (paramString.charAt(0) == '\026') {
          localObject1 = paramString.split("\\|");
        }
      }
    }
    return localObject1;
  }
  
  public static boolean isSaveConversation(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((!fx(paramInt1)) && (!fx(paramInt2))) {
      return TextUtils.equals(paramString1, paramString2);
    }
    return (paramInt1 == paramInt2) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static String ow()
  {
    StringBuilder localStringBuilder = new StringBuilder(eG.length * 8);
    localStringBuilder.append("not in (");
    int i = 0;
    if (i < eG.length)
    {
      localStringBuilder.append(eG[i]);
      if (i == eG.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String ox()
  {
    StringBuilder localStringBuilder = new StringBuilder(eN.length * 8);
    localStringBuilder.append("not in (");
    int i = 0;
    if (i < eN.length)
    {
      localStringBuilder.append(eN[i]);
      if (i == eN.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String oy()
  {
    StringBuilder localStringBuilder = new StringBuilder(eK.length * 8);
    localStringBuilder.append("not in (");
    int i = 0;
    if (i < eK.length)
    {
      localStringBuilder.append(eK[i]);
      if (i == eK.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String oz()
  {
    if (eO.length == 0) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(eO.length * 8);
    localStringBuilder.append("not in (");
    int i = 0;
    if (i < eO.length)
    {
      localStringBuilder.append(eO[i]);
      if (i == eO.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean s(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eL;
    int j = arrayOfInt.length;
    int i = 0;
    boolean bool1;
    if (i < j) {
      if (arrayOfInt[i] == paramMessageRecord.msgtype) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          i += 1;
          break;
          bool1 = bool2;
        } while (!fB(paramMessageRecord.msgtype));
        bool1 = bool2;
      } while (!(paramMessageRecord instanceof MessageForUniteGrayTip));
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      bool1 = bool2;
    } while (paramMessageRecord.tipParam == null);
    return paramMessageRecord.tipParam.ciH;
  }
  
  public static boolean t(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    int[] arrayOfInt = eK;
    int j = arrayOfInt.length;
    int i = 0;
    boolean bool1;
    if (i < j) {
      if (arrayOfInt[i] == paramMessageRecord.msgtype) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          i += 1;
          break;
          bool1 = bool2;
        } while (!fB(paramMessageRecord.msgtype));
        bool1 = bool2;
      } while (!(paramMessageRecord instanceof MessageForUniteGrayTip));
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      bool1 = bool2;
    } while (paramMessageRecord.tipParam == null);
    return paramMessageRecord.tipParam.ciH;
  }
  
  public static String u(String paramString, int paramInt)
  {
    String str;
    if (fx(paramInt)) {
      str = paramString + "&" + paramInt;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString != null);
    return "0";
  }
  
  public static boolean u(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForReplyText));
  }
  
  public static boolean v(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord.extLong & 0x1) == 1) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("one_way")));
  }
  
  public static boolean w(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1)
    {
      paramMessageRecord = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(true).a(paramMessageRecord.frienduin);
      if ((paramMessageRecord != null) && (paramMessageRecord.isGameRoom)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean w(String paramString, int paramInt)
  {
    return (paramString != null) && (paramString.length() >= 6) && ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000));
  }
  
  public static boolean x(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype == -5008) && (paramMessageRecord.shmsgseq == 0L)) {
      return "1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_mini_app_sys"));
    }
    return false;
  }
  
  public static boolean x(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (((eD(paramInt) == 1001) || (eD(paramInt) == 10002)) && ((!acbn.bkE.equals(paramString)) && (((eD(paramInt) == 1001) || (eD(paramInt) == 10002)) && ((!acbn.bkF.equals(paramString)) && ((eD(paramInt) != 1009) || (!acbn.bkt.equals(paramString))) && ((eD(paramInt) != 1010) || (!acbn.bkY.equals(paramString))) && ((eD(paramInt) != 1001) || (!acbn.blg.equals(paramString))) && ((eD(paramInt) != 1010) || (!acbn.blh.equals(paramString))) && ((eD(paramInt) != 1010) || (!acbn.bkE.equals(paramString))) && ((eD(paramInt) != 1010) || (!acbn.blg.equals(paramString))) && ((eD(paramInt) != 1032) || (!acbn.blK.equals(paramString))) && ((eD(paramInt) != 1044) || (!acbn.blR.equals(paramString))))))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     top
 * JD-Core Version:    0.7.0.1
 */