package com.rookery.translate;

import android.content.Context;
import android.util.Pair;
import bgd;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.translate.tencent.TencentTranslator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateCallback;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AITranslator
{
  private static AITranslator jdField_a_of_type_ComRookeryTranslateAITranslator;
  public static final String a = "Translator";
  public static final String b = "[Translate]pref";
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  
  public static AITranslator a()
  {
    try
    {
      if (jdField_a_of_type_ComRookeryTranslateAITranslator == null) {
        jdField_a_of_type_ComRookeryTranslateAITranslator = new AITranslator();
      }
      AITranslator localAITranslator = jdField_a_of_type_ComRookeryTranslateAITranslator;
      return localAITranslator;
    }
    finally {}
  }
  
  private Language a(List paramList)
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Language localLanguage = (Language)paramList.next();
      if (!((HashMap)localObject2).containsKey(localLanguage)) {
        ((HashMap)localObject2).put(localLanguage, Integer.valueOf(1));
      } else {
        ((HashMap)localObject2).put(localLanguage, Integer.valueOf(((Integer)((HashMap)localObject2).get(localLanguage)).intValue() + 1));
      }
    }
    localObject2 = ((HashMap)localObject2).entrySet().iterator();
    paramList = (List)localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      if (((Integer)((Map.Entry)localObject1).getValue()).intValue() <= i) {
        break label183;
      }
      paramList = (Language)((Map.Entry)localObject1).getKey();
      i = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
    }
    label183:
    for (;;)
    {
      break;
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = Language.AUTO_DETECT;
      }
      return localObject1;
    }
  }
  
  public static List a(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int k;
    for (int m = 0; i < paramString.length() - 1; m = k)
    {
      int n = i;
      k = m;
      if (paramString.charAt(i) == '\024')
      {
        int j = m;
        if (m != i)
        {
          String str = paramString.substring(m, i);
          localArrayList.add(new Pair(str, str));
          j = i;
        }
        k = paramString.charAt(i + 1);
        m = k;
        if (k > 255) {
          m = 65535 - k + 127;
        }
        n = i;
        k = j;
        if (m < 143)
        {
          n = i + 1;
          localArrayList.add(new Pair(paramString.substring(j, n + 1), ""));
          k = n + 1;
        }
      }
      i = n + 1;
    }
    if ((m != i) || (m == 0))
    {
      paramString = paramString.substring(m);
      localArrayList.add(new Pair(paramString, paramString));
    }
    return localArrayList;
  }
  
  private void a(long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, Language paramLanguage, TranslateCallback paramTranslateCallback, int paramInt, List paramList1, List paramList2, List paramList3, Long paramLong1)
  {
    paramContext = new ArrayList();
    paramLanguage = paramList3.iterator();
    int i = 0;
    if (paramLanguage.hasNext())
    {
      paramList3 = (Pair)paramLanguage.next();
      if ((paramList3.second != null) && (((String)paramList3.second).length() > 0))
      {
        if ((paramList2 == null) || (i >= paramList2.size())) {
          break label122;
        }
        int j = i + 1;
        paramContext.add(paramList2.get(i));
        i = j;
      }
      label122:
      for (;;)
      {
        break;
        paramContext.add(paramList3.first);
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramLong1.longValue();
    paramLanguage = new StringBuilder();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      paramLanguage.append((String)paramContext.next());
    }
    paramTranslateCallback.a(paramLong, paramString, a(paramList1), paramLanguage.toString(), paramHolder);
    if (QLog.isColorLevel()) {
      QLog.d("Translator", 2, "onSuccess\tTime: " + Long.valueOf(l1 - l2) + "\t recursion time:" + paramInt);
    }
  }
  
  private void a(long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, List paramList1, List paramList2, Language paramLanguage, TranslateCallback paramTranslateCallback, int paramInt, TranslateError paramTranslateError, Long paramLong1)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "AI[onFailed:] recursion_time:" + paramInt + "\tException:" + paramTranslateError);
    }
    paramTranslateCallback.a(paramLong, paramString, paramTranslateError, paramHolder);
  }
  
  private void a(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, TextTranslationItemBuilder.Holder paramHolder, String paramString, List paramList1, List paramList2, Language paramLanguage, Long arg10, TranslateCallback paramTranslateCallback, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (paramLanguage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Translator", 2, "AI[_execute:] execute language is null.");
      }
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      String str = paramString + paramLanguage.toString() + "T";
      if (!this.jdField_a_of_type_JavaUtilList.contains(str))
      {
        this.jdField_a_of_type_JavaUtilList.add(str);
        TencentTranslator.a(paramQQAppInterface).a(paramContext, paramList2, paramLanguage, null, Long.valueOf(l), new bgd(this, str, paramLong, paramContext, paramHolder, paramString, paramLanguage, paramTranslateCallback, paramList1, paramList2, paramInt));
      }
      return;
    }
  }
  
  public Boolean a(Context paramContext, QQAppInterface paramQQAppInterface, TextTranslationItemBuilder.Holder paramHolder, String paramString, Language paramLanguage, TranslateCallback paramTranslateCallback)
  {
    long l1 = System.currentTimeMillis();
    List localList = a(paramString + " ");
    long l2 = paramHolder.a;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair.second == null) || (((String)localPair.second).length() <= 0)) {
        break label186;
      }
      localArrayList.add(localPair.second);
      i += ((String)localPair.second).trim().length();
    }
    label186:
    for (;;)
    {
      break;
      if ((localArrayList.size() > 0) && (i > 0))
      {
        a(l2, paramContext, paramQQAppInterface, paramHolder, paramString, localList, localArrayList, paramLanguage, Long.valueOf(l1), paramTranslateCallback, 0);
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (TranslateClient.a()) {
      TranslateClient.a().a(paramContext, paramBoolean);
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.rookery.translate.AITranslator
 * JD-Core Version:    0.7.0.1
 */