import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import mqq.app.MobileQQ;

public class yjt
{
  public static boolean bmR = true;
  
  public static boolean A(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null) {
      if (!(paramChatMessage instanceof MessageForUniteGrayTip))
      {
        bool1 = bool2;
        if (!(paramChatMessage instanceof MessageForGrayTips)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean TK()
  {
    aeok localaeok = aeol.a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "getConfigSwitch = " + localaeok.bUz);
    }
    return localaeok.bUz;
  }
  
  private static int a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = paramContext.getResources();
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramContext.getDisplayMetrics().density;
    float f = paramContext.getDisplayMetrics().scaledDensity;
    int k = paramString.length();
    int i = 0;
    for (;;)
    {
      int j = i;
      if (i < k)
      {
        if (localTextPaint.measureText(paramString.substring(0, i)) * f > paramInt) {
          j = i - 1;
        }
      }
      else
      {
        log("getFitTextSize = fitSize = %d", new Object[] { Integer.valueOf(j) });
        return j;
      }
      i += 1;
    }
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, int[] paramArrayOfInt)
  {
    paramArrayOfInt = (ChatMessage)paramList.get(0);
    Object localObject1 = paramArrayOfInt.frienduin;
    Object localObject2 = paramQQAppInterface.getCurrentUin();
    long l = paramArrayOfInt.time;
    paramList = a(paramQQAppInterface, paramList);
    int i = paramList.length();
    localObject1 = new ahwa((String)localObject1, (String)localObject2, paramList, paramArrayOfInt.istroop, -5040, 2, l);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_action", 54);
    ((Bundle)localObject2).putString("key_action_DATA", String.valueOf(paramArrayOfInt.shmsgseq));
    ((ahwa)localObject1).addHightlightItem(i - 6, i, (Bundle)localObject2);
    paramArrayOfInt = new MessageForUniteGrayTip();
    paramArrayOfInt.initGrayTipMsg(paramQQAppInterface, (ahwa)localObject1);
    paramArrayOfInt.msg = paramList;
    return paramArrayOfInt;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    String str3 = paramQQAppInterface.getApplication().getBaseContext().getString(2131721352);
    String str2 = paramQQAppInterface.getApplication().getBaseContext().getString(2131721351);
    Context localContext = paramQQAppInterface.getApplication().getApplicationContext();
    int i = aqnm.getScreenWidth() - aqnm.dip2px(57.0F) - BaseChatItemLayout.bOg;
    paramList.size();
    Object localObject = (ChatMessage)paramList.get(0);
    String str5 = ((ChatMessage)localObject).frienduin;
    String str4 = ((MessageForText)localObject).msg;
    StringBuilder localStringBuilder = new StringBuilder();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      localObject = paramList.senderuin;
      String str1;
      if (jof.a(paramList))
      {
        str1 = jof.a(paramList).TG;
        paramList = str1;
        if (TextUtils.isEmpty(str1)) {
          paramList = (List<ChatMessage>)localObject;
        }
      }
      for (;;)
      {
        localObject = paramList;
        if (paramList.length() > 20) {
          localObject = paramList.substring(0, 20) + "...";
        }
        localLinkedHashSet.add(localObject);
        break;
        str1 = aqgv.h(paramQQAppInterface, str5, (String)localObject);
        if (!TextUtils.isEmpty(str1))
        {
          paramList = str1;
          if (!str1.equals(localObject)) {}
        }
        else
        {
          paramList = aqgv.s(paramQQAppInterface, (String)localObject);
        }
      }
    }
    paramQQAppInterface = localLinkedHashSet.iterator();
    label584:
    do
    {
      do
      {
        if (paramQQAppInterface.hasNext())
        {
          localStringBuilder.append((String)paramQQAppInterface.next());
          localStringBuilder.append("、");
          if (!a(localContext, i, 3, localStringBuilder.toString() + str2)) {
            continue;
          }
          paramQQAppInterface = localStringBuilder.toString() + "..." + str2;
          j = a(localContext, i * 3, paramQQAppInterface);
          k = j - 9;
          m = paramQQAppInterface.length() - 9;
          if ((k <= 0) || (m >= localStringBuilder.length() - 1)) {
            break label584;
          }
          localStringBuilder.delete(j - 9, paramQQAppInterface.length() - 9);
        }
        for (;;)
        {
          localStringBuilder.append("...");
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          paramList = String.format(str3, new Object[] { Integer.valueOf(localLinkedHashSet.size()), str4 });
          paramQQAppInterface = paramList;
          if (a(localContext, i, 1, paramList))
          {
            i = a(localContext, i, paramList) - 18;
            paramQQAppInterface = paramList;
            if (i > 0)
            {
              paramQQAppInterface = paramList;
              if (i < str4.length()) {
                paramQQAppInterface = String.format(str3, new Object[] { Integer.valueOf(localLinkedHashSet.size()), str4.substring(0, i) + "..." });
              }
            }
          }
          localStringBuilder.insert(0, paramQQAppInterface);
          localStringBuilder.append(str2);
          return localStringBuilder.toString();
          log("compute wording width exceed : delStart = %d,delEnd = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        }
      } while (!paramQQAppInterface.hasNext());
      paramList = localStringBuilder.toString() + "..." + str2;
    } while (!a(localContext, i, 3, paramList));
    int j = a(localContext, i * 3, paramList);
    int k = j - 9;
    int m = paramList.length() - 9;
    if ((k > 0) && (m < localStringBuilder.length() - 1)) {
      localStringBuilder.delete(j - 9, paramList.length() - 9);
    }
    for (;;)
    {
      localStringBuilder.append("...");
      break;
      log("compute wording width exceed : delStart = %d,delEnd = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
    }
  }
  
  public static List<ChatMessage> a(@NonNull QQAppInterface paramQQAppInterface, @NonNull List<ChatMessage> paramList, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "mOpenAIOFirstMsgShmsgseq =" + paramLong1 + ",mOpenAIOLastMsgShmsgseq =" + paramLong2 + ",minSameMsgCount = " + paramInt + ",srcMsgList.size = " + paramList.size());
    }
    int n = paramList.size();
    int j = n - 1;
    int k = 0;
    int i = 0;
    Object localObject;
    if (i < n)
    {
      localObject = (ChatMessage)paramList.get(i);
      if (((ChatMessage)localObject).shmsgseq == paramLong2)
      {
        j = k;
        k = i;
      }
    }
    for (;;)
    {
      i += 1;
      int m = k;
      k = j;
      j = m;
      break;
      if (((ChatMessage)localObject).shmsgseq == paramLong1)
      {
        k = i;
        m = j;
        j = k;
        k = m;
        continue;
        log("foldSameMsg.start = srcMsgList = " + n + ",ThreadName = " + Thread.currentThread().getName(), new Object[0]);
        if (QLog.isColorLevel()) {
          QLog.i("TroopMsgSameFold", 2, "openAIOFirstMsgIndex =" + k + ",openAIOLastMsgIndex =" + j);
        }
        if (j < n) {}
        for (localObject = paramList.subList(k, j + 1);; localObject = paramList)
        {
          int[][] arrayOfInt = a((List)localObject, paramInt, paramArrayOfLong);
          paramArrayOfLong = paramList;
          if (arrayOfInt != null)
          {
            log("findSameMsgArray = " + arrayOfInt.length, new Object[0]);
            paramArrayOfLong = new ArrayList();
            ArrayList localArrayList = new ArrayList();
            log("foldSameMsg.add before = ", new Object[0]);
            if (k > 0) {
              paramArrayOfLong.addAll(paramList.subList(0, k));
            }
            log("foldSameMsg.add fold msg = ", new Object[0]);
            i = ((List)localObject).size();
            paramInt = 0;
            if (paramInt < i)
            {
              ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(paramInt);
              int[] arrayOfInt1 = a(arrayOfInt, paramInt);
              if ((arrayOfInt1 == null) || (paramInt == 0))
              {
                log("foldSameMsg.not same piots ", new Object[0]);
                paramArrayOfLong.add(localChatMessage);
                localArrayList.clear();
              }
              for (;;)
              {
                paramInt += 1;
                break;
                if (b(arrayOfInt1, paramInt))
                {
                  log("inSame." + paramInt, new Object[0]);
                  if ((A(localChatMessage)) || (localChatMessage.isSend())) {
                    paramArrayOfLong.add(localChatMessage);
                  }
                  for (;;)
                  {
                    if (paramInt != arrayOfInt1[1]) {
                      break label595;
                    }
                    if (localArrayList.size() > 0)
                    {
                      paramArrayOfLong.add(a(paramQQAppInterface, localArrayList, arrayOfInt1));
                      a(paramQQAppInterface, localChatMessage, localArrayList.size(), paramBoolean);
                    }
                    localArrayList.clear();
                    break;
                    localArrayList.add(localChatMessage);
                  }
                }
                else
                {
                  label595:
                  paramArrayOfLong.add(localChatMessage);
                  localArrayList.clear();
                }
              }
            }
            log("foldSameMsg.add after msg = ", new Object[0]);
            if (j < n - 1) {
              paramArrayOfLong.addAll(paramList.subList(j + 1, n));
            }
          }
          return paramArrayOfLong;
        }
      }
      else
      {
        m = j;
        j = k;
        k = m;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt, boolean paramBoolean)
  {
    int i = 15;
    if (paramBoolean)
    {
      if (paramInt <= 15) {
        break label72;
      }
      paramInt = i;
    }
    label72:
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800ADF2", "0X800ADF2", paramInt, 1, paramChatMessage.frienduin, "" + paramChatMessage.shmsgseq, "", "");
      return;
    }
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    paramInt1 *= paramInt2;
    paramContext = paramContext.getResources();
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.setTextSize(12.0F);
    localTextPaint.density = paramContext.getDisplayMetrics().density;
    float f1 = paramContext.getDisplayMetrics().scaledDensity;
    float f2 = localTextPaint.measureText(paramString);
    if (f2 * f1 > paramInt1) {}
    for (;;)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("TroopMsgSameFold", 4, "desirwidtch = " + f2 + ",limitWidth = " + paramInt1 + ",isExceed = " + bool);
        QLog.d("TroopMsgSameFold", 4, "test.a = " + localTextPaint.measureText("a") + ",中 = " + localTextPaint.measureText("中") + ",screenW = " + aqnm.getScreenWidth());
        QLog.d("TroopMsgSameFold", 4, "test.density = " + localTextPaint.density + ",scaleDenisty = " + f1);
      }
      return bool;
      bool = false;
    }
  }
  
  public static int[] a(@NonNull int[][] paramArrayOfInt, int paramInt)
  {
    Object localObject2 = null;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        int k = paramArrayOfInt[i][0];
        int m = paramArrayOfInt[i][1];
        log("sameMsgArray.range start = %d,end = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        if ((paramInt >= k) && (paramInt <= m) && (m > k))
        {
          localObject1 = new int[2];
          localObject1[0] = k;
          localObject1[1] = m;
        }
      }
      else
      {
        return localObject1;
      }
      i += 1;
    }
  }
  
  public static int[][] a(@NonNull List<ChatMessage> paramList, int paramInt, long[] paramArrayOfLong)
  {
    if (paramInt == 0) {
      return (int[][])null;
    }
    int i1 = paramList.size();
    int i = Math.max(1, i1 / paramInt);
    int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i + 1, 2 });
    Object localObject1 = null;
    int k = 0;
    int j = 0;
    if (paramArrayOfLong != null) {}
    for (int[] arrayOfInt = new int[paramArrayOfLong.length]; arrayOfInt != null; arrayOfInt = null)
    {
      i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = -1;
        i += 1;
      }
    }
    int n = 0;
    i = k;
    ChatMessage localChatMessage;
    if (n < i1)
    {
      localChatMessage = (ChatMessage)paramList.get(n);
      if (y(localChatMessage)) {
        if (localObject1 == null) {
          if (localChatMessage.isSend())
          {
            k = j;
            j = i;
            i = k;
          }
        }
      }
    }
    label900:
    label906:
    for (;;)
    {
      n += 1;
      k = j;
      j = i;
      i = k;
      break;
      Object localObject2 = (ChatMessage)paramList.get(n);
      k = 0;
      j = i;
      label196:
      if (paramArrayOfLong != null)
      {
        long l = localChatMessage.shmsgseq;
        i = 0;
        if (k == 1) {
          i = 1;
        }
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          if (i < paramArrayOfLong.length)
          {
            if ((l == paramArrayOfLong[i]) && (arrayOfInt[i] == -1)) {
              arrayOfInt[i] = n;
            }
          }
          else
          {
            i = k;
            localObject1 = localObject2;
            break;
            if ((localObject1.msgtype == localChatMessage.msgtype) && (localChatMessage.msg != null) && (localChatMessage.msg.equals(localObject1.msg)))
            {
              m = j;
              if (!localChatMessage.isSend())
              {
                j += 1;
                m = j;
                if (j == 1)
                {
                  arrayOfInt1[i][0] = n;
                  m = j;
                }
              }
              k = m;
              j = i;
              localObject2 = localObject1;
              if (n != i1 - 1) {
                break label196;
              }
              if (m >= paramInt)
              {
                if (localChatMessage.isSend())
                {
                  arrayOfInt1[i][1] = (n - 1);
                  k = m;
                  j = i;
                  localObject2 = localObject1;
                  break label196;
                }
                arrayOfInt1[i][1] = n;
                k = m;
                j = i;
                localObject2 = localObject1;
                break label196;
              }
              j = i - 1;
              k = m;
              localObject2 = localObject1;
              break label196;
            }
            int m = i;
            if (j >= paramInt)
            {
              arrayOfInt1[i][1] = (n - 1);
              m = i + 1;
            }
            if (localChatMessage.isSend()) {}
            for (localObject1 = null;; localObject1 = localChatMessage)
            {
              k = 0;
              j = m;
              localObject2 = localObject1;
              break;
            }
          }
          i += 1;
        }
        if ((A(localChatMessage)) && (n < i1 - 1))
        {
          k = i;
          i = j;
          j = k;
        }
        else
        {
          if (j >= paramInt) {
            arrayOfInt1[i][1] = (n - 1);
          }
          for (j = i + 1;; j = i)
          {
            localObject1 = null;
            i = 0;
            break;
            paramList = (int[][])null;
            if (i >= 0)
            {
              paramList = (int[][])Array.newInstance(Integer.TYPE, new int[] { i + 1, 2 });
              System.arraycopy(arrayOfInt1, 0, paramList, 0, i + 1);
            }
            if ((arrayOfInt != null) && (paramList != null))
            {
              paramInt = 0;
              while (paramInt < arrayOfInt.length)
              {
                j = arrayOfInt[paramInt];
                log("final expanded index = " + j, new Object[0]);
                i = 0;
                while (i < paramList.length)
                {
                  if (paramList[i][0] == j) {
                    paramList[i][1] = 0;
                  }
                  i += 1;
                }
                paramInt += 1;
              }
            }
            if (bmR)
            {
              if (paramList == null) {
                log("find same msg result is null", new Object[0]);
              }
            }
            else if (QLog.isColorLevel())
            {
              if (paramList != null) {
                break label900;
              }
              paramInt = 0;
              label722:
              if (arrayOfInt != null) {
                break label906;
              }
            }
            for (i = 0;; i = arrayOfInt.length)
            {
              QLog.i("TroopMsgSameFold", 2, "find same msg result size = " + paramInt + ",expanded len = " + i);
              return paramList;
              i = paramList.length;
              paramArrayOfLong = new StringBuilder("find same msg result:size = %d,range : ");
              paramInt = 0;
              while (paramInt < i)
              {
                paramArrayOfLong.append(paramInt).append("same start = ").append(paramList[paramInt][0]).append(",");
                paramArrayOfLong.append(paramInt).append("same end = ").append(paramList[paramInt][1]);
                paramInt += 1;
              }
              if (arrayOfInt == null) {
                break;
              }
              i = arrayOfInt.length;
              paramInt = 0;
              while (paramInt < i)
              {
                paramArrayOfLong.append(paramInt).append("expandedIndex ={ ").append(arrayOfInt[paramInt]).append(",");
                paramInt += 1;
              }
              paramArrayOfLong.append("}");
              break;
              paramInt = paramList.length;
              break label722;
            }
          }
        }
      }
      else
      {
        i = k;
        localObject1 = localObject2;
      }
    }
  }
  
  public static boolean b(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt >= paramArrayOfInt[0]) && (paramInt <= paramArrayOfInt[1]);
  }
  
  public static void log(String paramString, Object... paramVarArgs)
  {
    if (!bmR) {}
    do
    {
      return;
      paramString = String.format(paramString, paramVarArgs);
    } while (!QLog.isColorLevel());
    QLog.i("TroopMsgSameFold", 2, paramString);
  }
  
  public static int wO()
  {
    aeok localaeok = aeol.a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "getConfigSwitch = " + localaeok.cOg);
    }
    return localaeok.cOg;
  }
  
  public static int wP()
  {
    aeok localaeok = aeol.a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "getConfigSwitch = " + localaeok.loadMoreCount);
    }
    return localaeok.loadMoreCount;
  }
  
  public static boolean y(@NonNull ChatMessage paramChatMessage)
  {
    switch (paramChatMessage.msgtype)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean z(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null)
    {
      bool1 = bool2;
      if ((paramChatMessage instanceof MessageForUniteGrayTip))
      {
        bool1 = bool2;
        if (((MessageForUniteGrayTip)paramChatMessage).tipParam.dbK == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjt
 * JD-Core Version:    0.7.0.1
 */