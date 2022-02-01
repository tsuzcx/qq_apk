import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class anqo
{
  public static String R(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.size() > 0))
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        anqp localanqp = (anqp)localHashMap.get(str);
        if ((localanqp.Kn() == paramInt1) && (localanqp.Km() == paramInt2)) {
          return str;
        }
      }
    }
    return null;
  }
  
  public static void Rl(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null)
      {
        int i = paramString.go().size();
        paramString.h((short)i);
        if (i >= 1) {
          ((anqn)paramString.go().get(paramString.go().size() - 1)).Qq(true);
        }
      }
    }
  }
  
  public static void Rm(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.dTt();
      }
    }
  }
  
  public static int a(String paramString, short paramShort)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null)
      {
        if (paramShort <= paramString.go().size()) {
          return ((anqn)paramString.go().get(paramShort - 1)).Kl();
        }
        QLog.w("StreamDataManager", 2, "getRecordedSize error shPackSeq: " + paramShort + "sfi.getStreamData().size(): " + paramString.go().size());
      }
    }
    return 0;
  }
  
  public static Map.Entry<String, anqp> a(long paramLong1, long paramLong2)
  {
    Object localObject = anqq.Y();
    if (QLog.isColorLevel()) {
      QLog.d("StreamDataManager", 2, "getStreamFileInfoEntryByMsg  try get random is:" + paramLong1 + ",msgSeq is:" + paramLong2);
    }
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        anqp localanqp = (anqp)localEntry.getValue();
        if (QLog.isColorLevel()) {
          QLog.d("StreamDataManager", 2, "getStreamFileInfoEntryByMsg  random is:" + anbk.I((int)localanqp.random) + ",msgSeq is:" + localanqp.msgSeq);
        }
        if ((anbk.I((int)localanqp.random) == paramLong1) && (paramLong2 == localanqp.msgSeq)) {
          return localEntry;
        }
      }
    }
    return null;
  }
  
  public static short a(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.j();
      }
    }
    return -1;
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong1, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    a(paramString1, paramQQAppInterface, paramString2, paramLong1, false, paramInt1, paramInt2, paramLong2, paramBundle);
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong1, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    short s1 = -1;
    Object localObject = anqq.Y();
    paramInt1 = aqlv.f(paramInt1);
    short s2;
    anqn localanqn;
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString1)))
    {
      localObject = (anqp)((HashMap)localObject).get(paramString1);
      ((anqp)localObject).Lh = paramBoolean;
      if (localObject != null)
      {
        s2 = s1;
        if (((anqp)localObject).Km() == 0)
        {
          localObject = ((anqp)localObject).go();
          s2 = s1;
          if (localObject != null)
          {
            s2 = s1;
            if (((List)localObject).size() > 0)
            {
              localObject = ((List)localObject).iterator();
              s2 = s1;
              if (((Iterator)localObject).hasNext())
              {
                localanqn = (anqn)((Iterator)localObject).next();
                if ((localanqn.Kl() == localanqn.ap().length) && (!localanqn.ayO()))
                {
                  s1 = localanqn.g();
                  localanqn.Qr(true);
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      if ((!localanqn.ayO()) && (localanqn.ayN()))
      {
        s1 = localanqn.g();
        localanqn.Qr(true);
        continue;
        if ((s2 != -1) && (paramLong1 != 0L)) {
          paramQQAppInterface.a().a(paramString2, paramString1, paramLong1, s2, paramInt1, paramInt2, paramLong2, paramBundle);
        }
        return;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (!localHashMap.containsKey(paramString)))
    {
      paramQQAppInterface = new anqp(paramQQAppInterface, paramInt1, paramString, paramInt2);
      paramQQAppInterface.Vq(paramInt3);
      try
      {
        localHashMap.put(paramString, paramQQAppInterface);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static boolean a(String paramString, short paramShort)
  {
    HashMap localHashMap = anqq.Y();
    return (localHashMap == null) || (!localHashMap.containsKey(paramString)) || (((anqp)localHashMap.get(paramString)).i() != paramShort);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    return a(paramString, paramArrayOfByte, paramInt, paramShort, false);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort, boolean paramBoolean)
  {
    Object localObject1 = anqq.Y();
    if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramString)))
    {
      anqp localanqp = (anqp)((HashMap)localObject1).get(paramString);
      if (!paramBoolean) {}
      try
      {
        localanqp.r(paramArrayOfByte, paramInt);
        if (localanqp.Km() == 0)
        {
          paramString = localanqp.go();
          if (paramString.size() == 0)
          {
            localObject1 = new anqn(localanqp.dLW);
            System.arraycopy(paramArrayOfByte, 0, ((anqn)localObject1).ap(), 0, paramInt);
            ((anqn)localObject1).Vp(paramInt);
            paramShort = localanqp.i();
            s = (short)(paramShort + 1);
            ((anqn)localObject1).g(paramShort);
            paramString.add(localObject1);
            localanqp.i(s);
            return true;
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          short s;
          if (QLog.isColorLevel())
          {
            QLog.d("StreamDataManager", 2, "write fail", paramString);
            continue;
            localObject1 = (anqn)paramString.get(paramString.size() - 1);
            Object localObject2 = ((anqn)localObject1).ap();
            int i;
            if (((anqn)localObject1).Kl() < localObject2.length)
            {
              i = localObject2.length - ((anqn)localObject1).Kl();
              if (i >= paramInt)
              {
                System.arraycopy(paramArrayOfByte, 0, ((anqn)localObject1).ap(), ((anqn)localObject1).Kl(), paramInt);
                ((anqn)localObject1).Vp(((anqn)localObject1).Kl() + paramInt);
              }
              else
              {
                if (paramInt <= i)
                {
                  System.arraycopy(paramArrayOfByte, 0, ((anqn)localObject1).ap(), ((anqn)localObject1).Kl(), paramInt);
                  ((anqn)localObject1).Vp(((anqn)localObject1).Kl() + paramInt);
                  return true;
                }
                System.arraycopy(paramArrayOfByte, 0, ((anqn)localObject1).ap(), ((anqn)localObject1).Kl(), i);
                ((anqn)localObject1).Vp(((anqn)localObject1).ap().length);
                paramInt -= i;
                localObject1 = new anqn(localanqp.dLW);
                System.arraycopy(paramArrayOfByte, i, ((anqn)localObject1).ap(), 0, paramInt);
                ((anqn)localObject1).Vp(paramInt);
                paramShort = localanqp.i();
                s = (short)(paramShort + 1);
                ((anqn)localObject1).g(paramShort);
                paramString.add(localObject1);
                localanqp.i(s);
              }
            }
            else
            {
              localObject1 = new anqn(localanqp.dLW);
              System.arraycopy(paramArrayOfByte, 0, ((anqn)localObject1).ap(), 0, paramInt);
              ((anqn)localObject1).Vp(paramInt);
              paramShort = localanqp.i();
              s = (short)(paramShort + 1);
              ((anqn)localObject1).g(paramShort);
              paramString.add(localObject1);
              localanqp.i(s);
              continue;
              if (localanqp.Km() == 1)
              {
                localObject2 = localanqp.go();
                paramInt = paramArrayOfByte.length;
                i = 0;
                if (paramInt > 0)
                {
                  if (((List)localObject2).size() == 0)
                  {
                    paramString = new anqn(localanqp.dLW);
                    ((List)localObject2).add(paramString);
                  }
                  for (;;)
                  {
                    int k = paramString.ap().length - paramString.Kl();
                    int j = k;
                    if (k >= paramInt) {
                      j = paramInt;
                    }
                    System.arraycopy(paramArrayOfByte, i, paramString.ap(), paramString.Kl(), j);
                    i += j;
                    paramInt -= j;
                    paramString.Vp(j + paramString.Kl());
                    paramString.g(paramShort);
                    break;
                    localObject1 = (anqn)((List)localObject2).get(((List)localObject2).size() - 1);
                    paramString = (String)localObject1;
                    if (((anqn)localObject1).ap().length - ((anqn)localObject1).Kl() <= 0)
                    {
                      paramString = new anqn(localanqp.dLW);
                      ((List)localObject2).add(paramString);
                    }
                  }
                }
                localanqp.i((short)(paramShort + 1));
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public static byte[] a(String paramString, short paramShort)
  {
    Object localObject = anqq.Y();
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString)))
    {
      paramString = (anqp)((HashMap)localObject).get(paramString);
      if (paramString != null)
      {
        localObject = (anqn)paramString.go().get(paramShort - 1);
        paramString = ((anqn)localObject).ap();
        paramShort = ((anqn)localObject).Kl();
        if (paramShort != paramString.length)
        {
          localObject = new byte[paramShort];
          System.arraycopy(paramString, 0, localObject, 0, paramShort);
          return localObject;
        }
        return paramString;
      }
    }
    return null;
  }
  
  public static void aV(String paramString, long paramLong)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.msgSeq = paramLong;
      }
    }
  }
  
  public static void aW(String paramString, long paramLong)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.random = paramLong;
      }
    }
  }
  
  public static void aX(String paramString, long paramLong)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.lA(paramLong);
      }
    }
  }
  
  public static short b(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.h();
      }
    }
    return 0;
  }
  
  public static void b(String paramString, short paramShort)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.j(paramShort);
      }
    }
  }
  
  public static short c(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.i();
      }
    }
    return 0;
  }
  
  public static void cU(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.Qs(paramBoolean);
      }
    }
  }
  
  public static int et(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.go().size();
      }
    }
    return 0;
  }
  
  public static int eu(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.Kn();
      }
    }
    return -1;
  }
  
  public static int ev(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    int i;
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null)
      {
        i = paramString.go().size();
        if ((i < 1) || (((anqn)paramString.go().get(i - 1)).ayO())) {
          return i;
        }
        return i - 1;
      }
    }
    return 0;
    return i;
  }
  
  public static File getFile(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.getFile();
      }
    }
    return null;
  }
  
  public static boolean pA(String paramString)
  {
    List localList = anqq.gp();
    if ((localList != null) && (!localList.contains(paramString)))
    {
      localList.add(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean pB(String paramString)
  {
    List localList = anqq.gp();
    if ((localList != null) && (localList.contains(paramString)))
    {
      localList.remove(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean pC(String paramString)
  {
    List localList = anqq.gp();
    return (localList != null) && (localList.contains(paramString));
  }
  
  public static boolean py(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
      try
      {
        localHashMap.remove(paramString);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static boolean pz(String paramString)
  {
    HashMap localHashMap = anqq.Y();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (anqp)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.Lh;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqo
 * JD-Core Version:    0.7.0.1
 */