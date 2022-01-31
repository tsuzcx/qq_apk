package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import eit;
import eiu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class PttInfoCollector
{
  public static final int a = 0;
  public static long a = 0L;
  private static final String jdField_a_of_type_JavaLangString = PttInfoCollector.class.getSimpleName();
  public static HashMap a;
  private static Random jdField_a_of_type_JavaUtilRandom;
  public static final int b = 1;
  public static HashMap b;
  public static final int c = 2;
  public static final int d = 3;
  public static int e = -1;
  public static int f = -1;
  public static int g = -1;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  public static int q;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    h = 0;
    i = 1;
    j = 2;
    k = 3;
    l = 4;
    m = 0;
    n = 1;
    o = 2;
    p = 3;
    q = 4;
    jdField_a_of_type_JavaUtilRandom = new Random();
    b = new HashMap();
    jdField_a_of_type_Long = 0L;
  }
  
  public static final int a(int paramInt1, int paramInt2)
  {
    return paramInt2 & 0xF | (paramInt1 & 0xF) << 4;
  }
  
  public static void a()
  {
    b.clear();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilRandom.nextInt() % 100 == 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttPlayCount", false, 0L, 0L, localHashMap, "");
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = b.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (eit)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if (l1 - ((eit)localObject2).jdField_a_of_type_Long > ((eit)localObject2).b * 4) {
        ((Iterator)localObject1).remove();
      }
    }
    localObject1 = (eit)b.get(paramString);
    if (localObject1 != null)
    {
      ((eit)localObject1).jdField_a_of_type_Int += 1;
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("pttFilePath", paramString);
      ((HashMap)localObject2).put("param_FailCode", String.valueOf(((eit)localObject1).jdField_a_of_type_Int));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttPlayMoreThanTwice", false, 0L, 0L, (HashMap)localObject2, "");
      return;
    }
    b.put(paramString, new eit(l1, paramInt));
  }
  
  public static void a(long paramLong, String paramString)
  {
    eiu localeiu = new eiu();
    localeiu.a();
    jdField_a_of_type_JavaUtilHashMap.put(paramString + paramLong, localeiu);
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    int i1;
    if ((paramLong >= 0L) && (paramLong < 50L)) {
      i1 = 1;
    }
    for (;;)
    {
      int i2 = i1;
      if (paramBoolean) {
        i2 = i1 + 10;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(i2));
      localStatisticCollector.a("", "offlinePttHandleCost", false, 0L, 0L, localHashMap, "");
      return;
      if ((paramLong >= 50L) && (paramLong < 150L)) {
        i1 = 2;
      } else if ((paramLong >= 150L) && (paramLong < 1000L)) {
        i1 = 3;
      } else if ((paramLong >= 1000L) && (paramLong < 3000L)) {
        i1 = 4;
      } else if (paramLong >= 3000L) {
        i1 = 5;
      } else {
        i1 = 0;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ReportController.a(paramQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", paramInt, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ChatMessage paramChatMessage)
  {
    int i1 = 1;
    if (!(paramChatMessage instanceof MessageForPtt)) {}
    for (;;)
    {
      return;
      if (paramChatMessage.getPttStreamFlag() != 10001)
      {
        if (!paramChatMessage.isSend()) {
          break;
        }
        if (((MessageForPtt)paramChatMessage).voiceChangeFlag == 1) {}
        while ((i1 != 0) && (paramInt == 1001))
        {
          a(paramQQAppInterface, q);
          return;
          i1 = 0;
        }
      }
    }
    switch (paramInt)
    {
    case 2004: 
    default: 
      return;
    case 2001: 
      a(paramQQAppInterface, o);
      return;
    case 2002: 
      a(paramQQAppInterface, n);
      return;
    case 2003: 
      a(paramQQAppInterface, m);
      return;
    }
    a(paramQQAppInterface, p);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaUtilRandom.nextInt() % 100 == 0)
    {
      HashMap localHashMap = new HashMap();
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttSoUpdate", paramBoolean, 0L, 0L, localHashMap, "");
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (!paramBoolean) {
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttLongPressFate", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == 1000L) || (paramLong1 == 1001L) || (paramLong1 == 1002L) || (paramLong1 == 1003L) || (paramLong1 == 1004L) || (paramLong1 == 1005L) || (paramLong1 == 1006L) || (paramLong1 == 1008L) || (paramLong1 == 1009L) || (paramLong1 == 1010L) || (paramLong1 == 1011L) || (paramLong1 == 1020L) || (paramLong1 == 1022L) || (paramLong1 == 1023L) || (paramLong1 == 1024L) || (paramLong1 == 1025L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramLong1));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actAllC2CPttUp", paramBoolean, paramLong2, paramLong3, localHashMap, "");
    }
  }
  
  public static void b(long paramLong, String paramString)
  {
    paramString = (eiu)jdField_a_of_type_JavaUtilHashMap.get(paramString + paramLong);
    if ((paramString != null) && (paramString.c == 0L)) {
      paramString.c();
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttDownloadStream2Offline", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void c(long paramLong, String paramString)
  {
    paramString = paramString + paramLong;
    eiu localeiu = (eiu)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localeiu != null)
    {
      localeiu.b();
      if (localeiu.a()) {
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttUserWaiting", true, localeiu.a() / 1000000L, localeiu.d, null, "");
      }
      jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PttInfoCollector
 * JD-Core Version:    0.7.0.1
 */