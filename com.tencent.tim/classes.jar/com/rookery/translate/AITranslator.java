package com.rookery.translate;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Pair;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.qphone.base.util.QLog;
import ien;
import iev;
import iew;
import iex;
import iez;
import ifc;
import ife;
import ifg;
import ifi;
import ifk;
import ifu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.rookery.translate.type.Language;>;
import java.util.Map.Entry;
import java.util.Set;
import xpc.a;

public class AITranslator
{
  private static AITranslator jdField_a_of_type_ComRookeryTranslateAITranslator;
  private boolean Os = true;
  private ife jdField_a_of_type_Ife = new ife();
  private ifi jdField_a_of_type_Ifi = new ifi();
  private List<String> eU = Collections.synchronizedList(new ArrayList());
  
  private long a(long paramLong, TranslatorType paramTranslatorType)
  {
    if (paramLong == 9223372036854775807L) {}
    do
    {
      return 9223372036854775807L;
      switch (iey.ct[paramTranslatorType.ordinal()])
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e("Translator", 2, "unknown type");
    return 9223372036854775807L;
    return 3L * paramLong;
    return 2L * paramLong;
  }
  
  private long a(Context paramContext, TranslatorType paramTranslatorType)
  {
    switch (iey.ct[paramTranslatorType.ordinal()])
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("Translator", 2, "unknown type");
      }
      return 0L;
    case 1: 
      return paramContext.getSharedPreferences("[Translate]pref", 0).getLong("pref_google_nice", 0L);
    }
    return paramContext.getSharedPreferences("[Translate]pref", 0).getLong("pref_ms_nice", 0L);
  }
  
  private TranslatorType a(Context paramContext)
  {
    long l1 = a(paramContext, TranslatorType.GOOGLE);
    long l2 = a(paramContext, TranslatorType.MS);
    if ((l1 == 9223372036854775807L) && (l2 == 9223372036854775807L))
    {
      a(paramContext, TranslatorType.MS, 0L);
      a(paramContext, TranslatorType.GOOGLE, 0L);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Translator", 2, "google: " + l1 + "\t MS:" + l2);
    }
    if (l2 <= l1) {
      return TranslatorType.MS;
    }
    return TranslatorType.GOOGLE;
  }
  
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
  
  private Language a(List<Language> paramList)
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
    paramList = (List<Language>)localObject1;
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
  
  private void a(long paramLong, Context paramContext, xpc.a parama, String paramString, Language paramLanguage, ifu paramifu, int paramInt, TranslatorType paramTranslatorType, List<Language> paramList, List<String> paramList1, List<Pair<String, String>> paramList2, Long paramLong1)
  {
    ArrayList localArrayList = new ArrayList();
    paramLanguage = paramList2.iterator();
    int i = 0;
    if (paramLanguage.hasNext())
    {
      paramList2 = (Pair)paramLanguage.next();
      if ((paramList2.second != null) && (((String)paramList2.second).length() > 0))
      {
        int j = i + 1;
        localArrayList.add(paramList1.get(i));
        i = j;
      }
      for (;;)
      {
        break;
        localArrayList.add(paramList2.first);
      }
    }
    paramList1 = Long.valueOf(System.currentTimeMillis() - paramLong1.longValue());
    paramLanguage = new String();
    paramList2 = localArrayList.iterator();
    while (paramList2.hasNext())
    {
      paramLong1 = (String)paramList2.next();
      paramLanguage = paramLanguage + paramLong1;
    }
    paramifu.a(paramLong, paramString, a(paramList), paramLanguage, parama);
    if (QLog.isColorLevel()) {
      QLog.d("Translator", 2, "onSuccess Translator type: " + paramTranslatorType.toString() + "\tTime: " + paramList1 + "\t recursion time:" + paramInt);
    }
    a(paramContext, paramTranslatorType, a(paramList1.longValue(), paramTranslatorType));
  }
  
  private void a(long paramLong, Context paramContext, xpc.a parama, String paramString, List<Pair<String, String>> paramList, List<String> paramList1, Language paramLanguage, ifu paramifu, int paramInt, TranslatorType paramTranslatorType, TranslateError paramTranslateError, Long paramLong1)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "AI[onFailed:] recursion_time:" + paramInt + "\tException:" + paramTranslateError);
    }
    if (paramInt >= TranslatorType.values().length - 1) {
      paramifu.a(paramLong, paramString, paramTranslateError, parama);
    }
    paramTranslateError = Long.valueOf(9223372036854775807L);
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "onFailed Translator type: " + paramTranslatorType.toString() + "\tTime: " + paramTranslateError);
    }
    paramTranslateError = Long.valueOf(a(paramTranslateError.longValue(), paramTranslatorType));
    a(paramContext, paramTranslatorType, paramTranslateError.longValue());
    if (paramTranslateError.longValue() == 9223372036854775807L) {
      a(paramLong, paramContext, parama, paramString, paramList, paramList1, paramLanguage, paramTranslateError, paramifu, paramInt + 1);
    }
  }
  
  private void a(long paramLong, Context paramContext, xpc.a parama, String paramString, List<Pair<String, String>> paramList, List<String> paramList1, Language paramLanguage, Long arg9, ifu paramifu, int paramInt)
  {
    if (paramInt >= TranslatorType.values().length) {
      return;
    }
    TranslatorType localTranslatorType = a(paramContext);
    Long localLong = Long.valueOf(System.currentTimeMillis());
    for (;;)
    {
      synchronized (this.eU)
      {
        switch (iey.ct[localTranslatorType.ordinal()])
        {
        case 1: 
          return;
        }
      }
      String str = paramString + paramLanguage.toString() + "G";
      if (!this.eU.contains(str))
      {
        this.eU.add(str);
        ifg.a().a(paramContext, paramList1, paramLanguage, this.jdField_a_of_type_Ife.gs(), localLong, new iev(this, str, paramLong, paramContext, parama, paramString, paramLanguage, paramifu, paramList, paramList1, paramInt, localTranslatorType));
        continue;
        str = paramString + paramLanguage.toString() + "M";
        if (!this.eU.contains(str))
        {
          this.eU.add(str);
          ifk.a().a(paramContext, paramList1, paramLanguage, localLong, this.jdField_a_of_type_Ifi.getClientId(), this.jdField_a_of_type_Ifi.getClientSecret(), new iew(this, str, paramLong, paramContext, parama, paramString, paramLanguage, paramifu, paramList, paramList1, paramInt, localTranslatorType));
        }
      }
    }
  }
  
  @TargetApi(9)
  private void a(Context paramContext, TranslatorType paramTranslatorType, long paramLong)
  {
    switch (iey.ct[paramTranslatorType.ordinal()])
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("Translator", 2, "unknow type");
      }
      return;
    case 1: 
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_google_nice", paramLong).apply();
        return;
      }
      paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_google_nice", paramLong).commit();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_ms_nice", paramLong).apply();
      return;
    }
    paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_ms_nice", paramLong).commit();
  }
  
  @TargetApi(9)
  private void a(Context paramContext, Boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putBoolean("pref_trans_service_status", paramBoolean.booleanValue()).apply();
      }
    }
    else {
      return;
    }
    paramContext.getSharedPreferences("[Translate]pref", 0).edit().putBoolean("pref_trans_service_status", paramBoolean.booleanValue()).commit();
  }
  
  @TargetApi(9)
  private void bo(Context paramContext)
  {
    Long localLong = Long.valueOf(paramContext.getSharedPreferences("[Translate]pref", 0).getLong("pref_policy_update_time", 0L));
    if ((localLong.longValue() == 0L) || (System.currentTimeMillis() - localLong.longValue() > 86400000L)) {
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_policy_update_time", System.currentTimeMillis()).apply();
        iez.a(paramContext, new iex(this, paramContext));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_policy_update_time", System.currentTimeMillis()).commit();
      }
    }
    QLog.i("Translator", 2, "needn't update policy");
  }
  
  public static boolean sh()
  {
    try
    {
      return jdField_a_of_type_ComRookeryTranslateAITranslator != null;
    }
    finally {}
  }
  
  public static List<Pair<String, String>> x(String paramString)
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
  
  public Boolean a(Context paramContext)
  {
    if (paramContext != null) {
      return Boolean.valueOf(paramContext.getSharedPreferences("[Translate]pref", 0).getBoolean("pref_trans_service_status", true));
    }
    return Boolean.valueOf(true);
  }
  
  public Boolean a(Context paramContext, xpc.a parama, String paramString, Language paramLanguage, ifu paramifu)
  {
    if (!a(paramContext).booleanValue()) {
      return Boolean.valueOf(false);
    }
    long l1 = System.currentTimeMillis();
    List localList = x(paramString + " ");
    long l2 = parama.uniseq;
    if (this.Os == true)
    {
      bo(paramContext);
      this.Os = false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair.second == null) || (((String)localPair.second).length() <= 0)) {
        break label218;
      }
      localArrayList.add(localPair.second);
      i += ((String)localPair.second).trim().length();
    }
    label218:
    for (;;)
    {
      break;
      if ((localArrayList.size() > 0) && (i > 0))
      {
        a(l2, paramContext, parama, paramString, localList, localArrayList, paramLanguage, Long.valueOf(l1), paramifu, 0);
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
  }
  
  public void n(Context paramContext, boolean paramBoolean)
  {
    if (ifc.si()) {
      ifc.a().n(paramContext, paramBoolean);
    }
    if (this.eU != null) {
      this.eU.clear();
    }
  }
  
  public static enum TranslatorType
  {
    GOOGLE,  MS;
    
    private TranslatorType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.rookery.translate.AITranslator
 * JD-Core Version:    0.7.0.1
 */