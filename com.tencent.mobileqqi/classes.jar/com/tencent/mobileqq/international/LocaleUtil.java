package com.tencent.mobileqq.international;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class LocaleUtil
{
  public static final String A = "es_US";
  private static final String B = "MicroMsg.LocaleUtil";
  public static final int a = 0;
  public static final String a = "language_key_string";
  public static List a;
  public static Locale a;
  public static Locale[] a;
  public static final int b = 1;
  public static final String b = "qq_language_string";
  public static final int c = 2;
  public static final String c = "system_language_string";
  public static final int d = 3;
  public static final String d = "pref_translate_language_key";
  public static final int e = 4;
  public static final String e = "auto";
  public static final int f = 5;
  public static final String f = "zh_TW";
  public static final int g = 6;
  public static final String g = "zh_HK";
  public static final int h = 7;
  public static final String h = "zh_CN_#Hans";
  public static final int i = 8;
  public static final String i = "zh_CN";
  public static final String j = "zh";
  public static final String k = "zh_TW_#Hant";
  public static final String l = "en";
  public static final String m = "en_CA";
  public static final String n = "en_US";
  public static final String o = "en_GB";
  public static final String p = "ja";
  public static final String q = "ja_JP";
  public static final String r = "ko";
  public static final String s = "ko_KR";
  public static final String t = "de";
  public static final String u = "de_DE";
  public static final String v = "fr";
  public static final String w = "fr_FR";
  public static final String x = "fr_CA";
  public static final String y = "es";
  public static final String z = "es_ES";
  
  static
  {
    jdField_a_of_type_JavaUtilLocale = new Locale("es");
    jdField_a_of_type_ArrayOfJavaUtilLocale = new Locale[] { Locale.ENGLISH, Locale.ENGLISH, Locale.CHINA, Locale.TAIWAN, Locale.JAPANESE, Locale.KOREAN, Locale.GERMAN, Locale.FRENCH, jdField_a_of_type_JavaUtilLocale };
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add("ar");
    jdField_a_of_type_JavaUtilList.add("zh_CN");
    jdField_a_of_type_JavaUtilList.add("zh_TW");
    jdField_a_of_type_JavaUtilList.add("en");
    jdField_a_of_type_JavaUtilList.add("fr");
    jdField_a_of_type_JavaUtilList.add("de");
    jdField_a_of_type_JavaUtilList.add("id");
    jdField_a_of_type_JavaUtilList.add("it");
    jdField_a_of_type_JavaUtilList.add("ja");
    jdField_a_of_type_JavaUtilList.add("ko");
    jdField_a_of_type_JavaUtilList.add("ms");
    jdField_a_of_type_JavaUtilList.add("fa");
    jdField_a_of_type_JavaUtilList.add("pt");
    jdField_a_of_type_JavaUtilList.add("ru");
    jdField_a_of_type_JavaUtilList.add("es");
    jdField_a_of_type_JavaUtilList.add("th");
    jdField_a_of_type_JavaUtilList.add("tr");
    jdField_a_of_type_JavaUtilList.add("ur");
    jdField_a_of_type_JavaUtilList.add("vi");
  }
  
  public static final int a()
  {
    String str = jdField_a_of_type_ArrayOfJavaUtilLocale[a(com.tencent.common.app.BaseApplicationImpl.getContext())].toString();
    if (str.equalsIgnoreCase("en")) {}
    do
    {
      return 1033;
      if (str.equalsIgnoreCase("zh_CN")) {
        return 2052;
      }
      if (str.equalsIgnoreCase("ja")) {
        return 1041;
      }
      if (str.equalsIgnoreCase("ko")) {
        return 1042;
      }
      if (str.equalsIgnoreCase("de")) {
        return 1031;
      }
      if (str.equalsIgnoreCase("fr")) {
        return 1036;
      }
      if (str.equalsIgnoreCase("es")) {
        return 3082;
      }
    } while (!str.equalsIgnoreCase("zh_TW"));
    return 1028;
  }
  
  public static int a(Context paramContext)
  {
    int i2 = 1;
    int i1 = b(paramContext);
    if (i1 == 0)
    {
      paramContext = a(Locale.getDefault().toString().trim());
      if (paramContext == Locale.TAIWAN) {
        i1 = 3;
      }
      do
      {
        do
        {
          return i1;
          if (paramContext == Locale.CHINA) {
            return 2;
          }
          i1 = i2;
        } while (paramContext == Locale.ENGLISH);
        if (paramContext == Locale.JAPANESE) {
          return 4;
        }
        if (paramContext == Locale.KOREAN) {
          return 5;
        }
        if (paramContext == Locale.GERMAN) {
          return 6;
        }
        if (paramContext == Locale.FRENCH) {
          return 7;
        }
        i1 = i2;
      } while (paramContext != jdField_a_of_type_JavaUtilLocale);
      return 8;
    }
    return i1;
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qq_language_string", 4).getString("system_language_string", Locale.ENGLISH.toString());
  }
  
  public static final String a(Context paramContext, String paramString)
  {
    Locale localLocale = b(Locale.getDefault().toString().trim());
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramString, 4);
    paramString = localLocale.getLanguage();
    paramContext = paramString;
    if (paramString.equalsIgnoreCase("zh")) {
      paramContext = localLocale.toString();
    }
    return localSharedPreferences.getString("pref_translate_language_key", paramContext);
  }
  
  public static final Locale a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= jdField_a_of_type_ArrayOfJavaUtilLocale.length)) {
      return null;
    }
    if (paramInt == 0) {
      return a(Locale.getDefault().toString().trim());
    }
    return jdField_a_of_type_ArrayOfJavaUtilLocale[paramInt];
  }
  
  public static Locale a(String paramString)
  {
    if ((paramString.equals("zh_TW")) || (paramString.equals("zh_HK")) || (paramString.equals("zh_TW_#Hant"))) {
      return Locale.TAIWAN;
    }
    if ((paramString.equals("zh_CN")) || (paramString.equals(Locale.CHINESE)) || (paramString.equals("zh_CN_#Hans"))) {
      return Locale.CHINA;
    }
    if ((paramString.equals("en")) || (paramString.equals("en_CA")) || (paramString.equals("en_US")) || (paramString.equals("en_GB"))) {
      return Locale.ENGLISH;
    }
    if ((paramString.equals("ja")) || (paramString.equals("ja_JP"))) {
      return Locale.JAPANESE;
    }
    if ((paramString.equals("ko")) || (paramString.equals("ko_KR"))) {
      return Locale.KOREAN;
    }
    if ((paramString.equals("de")) || (paramString.equals("de_DE"))) {
      return Locale.GERMAN;
    }
    if ((paramString.equals("fr")) || (paramString.equals("fr_FR")) || (paramString.equals("fr_CA"))) {
      return Locale.FRENCH;
    }
    if ((paramString.equals("es")) || (paramString.equals("es_ES")) || (paramString.equals("es_US"))) {
      return jdField_a_of_type_JavaUtilLocale;
    }
    QLog.e("MicroMsg.LocaleUtil", 2, "transLanguageToLocale country = " + paramString);
    return Locale.ENGLISH;
  }
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("qq_language_string", 4);
    Locale localLocale = Locale.getDefault();
    if (paramContext.edit().putString("system_language_string", localLocale.toString()).commit())
    {
      QLog.w("MicroMsg.LocaleUtil", 2, "save system lang as:" + localLocale.toString());
      return;
    }
    QLog.e("MicroMsg.LocaleUtil", 2, "saving system lang failed");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > jdField_a_of_type_ArrayOfJavaUtilLocale.length)) {
      return;
    }
    if (paramInt == 0) {}
    for (Locale localLocale = a(a(paramContext));; localLocale = jdField_a_of_type_ArrayOfJavaUtilLocale[paramInt])
    {
      paramContext = paramContext.getResources();
      Configuration localConfiguration = paramContext.getConfiguration();
      if (localConfiguration.locale.equals(localLocale)) {
        break;
      }
      DisplayMetrics localDisplayMetrics = paramContext.getDisplayMetrics();
      localConfiguration.locale = localLocale;
      paramContext.updateConfiguration(localConfiguration, localDisplayMetrics);
      Resources.getSystem().updateConfiguration(localConfiguration, localDisplayMetrics);
      return;
    }
  }
  
  public static void a(Context paramContext, Locale paramLocale)
  {
    paramContext = paramContext.getResources();
    Configuration localConfiguration = paramContext.getConfiguration();
    if (localConfiguration.locale.equals(paramLocale)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramContext.getDisplayMetrics();
    localConfiguration.locale = paramLocale;
    paramContext.updateConfiguration(localConfiguration, localDisplayMetrics);
    Resources.getSystem().updateConfiguration(localConfiguration, localDisplayMetrics);
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    while ((!paramString.equalsIgnoreCase("zh_TW")) && (!paramString.equalsIgnoreCase("zh_HK")) && (!paramString.equalsIgnoreCase("ja")) && (!paramString.equalsIgnoreCase("en")) && (!paramString.equalsIgnoreCase("ko")) && (!paramString.equalsIgnoreCase("de")) && (!paramString.equalsIgnoreCase("fr")) && (!paramString.equalsIgnoreCase("es")) && (!paramString.equalsIgnoreCase("zh_CN"))) {
      return false;
    }
    return true;
  }
  
  public static final boolean a(String paramString1, Context paramContext, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 4).edit().putString("pref_translate_language_key", paramString2).commit();
  }
  
  public static int b(Context paramContext)
  {
    int i1 = 4;
    paramContext = paramContext.getSharedPreferences("qq_language_string", 4).getString("language_key_string", "auto");
    if (paramContext.equals("en")) {
      i1 = 1;
    }
    do
    {
      return i1;
      if (paramContext.equals("zh_CN")) {
        return 2;
      }
      if (paramContext.equals("zh_TW")) {
        return 3;
      }
    } while (paramContext.equals("ja"));
    if (paramContext.equals("ko")) {
      return 5;
    }
    if (paramContext.equals("de")) {
      return 6;
    }
    if (paramContext.equals("fr")) {
      return 7;
    }
    if (paramContext.equals("es")) {
      return 8;
    }
    return 0;
  }
  
  public static Locale b(String paramString)
  {
    if ((paramString.equals("zh_TW")) || (paramString.equals("zh_HK"))) {
      return Locale.TAIWAN;
    }
    if ((paramString.equals("zh_CN")) || (paramString.equals("zh"))) {
      return Locale.CHINA;
    }
    if ((paramString.equals("en")) || (paramString.equals("en_CA")) || (paramString.equals("en_US")) || (paramString.equals("en_GB"))) {
      return Locale.ENGLISH;
    }
    if ((paramString.equals("ja")) || (paramString.equals("ja_JP"))) {
      return Locale.JAPANESE;
    }
    if ((paramString.equals("ko")) || (paramString.equals("ko_KR"))) {
      return Locale.KOREAN;
    }
    if ((paramString.equals("de")) || (paramString.equals("de_DE"))) {
      return Locale.GERMAN;
    }
    if ((paramString.equals("fr")) || (paramString.equals("fr_FR")) || (paramString.equals("fr_CA"))) {
      return Locale.FRENCH;
    }
    if ((paramString.equals("es")) || (paramString.equals("es_ES")) || (paramString.equals("es_US"))) {
      return jdField_a_of_type_JavaUtilLocale;
    }
    if (jdField_a_of_type_JavaUtilList.contains(paramString.toLowerCase())) {
      return new Locale(paramString);
    }
    QLog.e("MicroMsg.LocaleUtil", 2, "transLanguageToLocale country = " + paramString);
    return Locale.ENGLISH;
  }
  
  public static void b(Context paramContext, Locale paramLocale)
  {
    if (paramContext.getSharedPreferences("qq_language_string", 4).edit().putString("language_key_string", paramLocale.toString()).commit())
    {
      QLog.w("MicroMsg.LocaleUtil", 2, "save application lang as:" + paramLocale);
      return;
    }
    QLog.e("MicroMsg.LocaleUtil", 2, "saving application lang failed");
  }
  
  public static Locale c(String paramString)
  {
    if ((paramString.equals(Locale.TAIWAN.getCountry())) || (paramString.equals(Locale.TRADITIONAL_CHINESE.getCountry()))) {
      return Locale.TAIWAN;
    }
    if ((paramString.equals(Locale.CHINA.getCountry())) || (paramString.equals(Locale.CHINESE.getCountry()))) {
      return Locale.CHINA;
    }
    if ((paramString.equals(Locale.ENGLISH.getCountry())) || (paramString.equals(Locale.CANADA.getCountry())) || (paramString.equals(Locale.UK.getCountry())) || (paramString.equals(Locale.US.getCountry()))) {
      return Locale.ENGLISH;
    }
    if ((paramString.equals(Locale.JAPAN.getCountry())) || (paramString.equals(Locale.JAPANESE.getCountry()))) {
      return Locale.JAPANESE;
    }
    if ((paramString.equals(Locale.KOREA.getCountry())) || (paramString.equals(Locale.KOREAN.getCountry()))) {
      return Locale.KOREAN;
    }
    if ((paramString.equals(Locale.GERMAN.getCountry())) || (paramString.equals(Locale.GERMANY.getCountry()))) {
      return Locale.GERMAN;
    }
    if ((paramString.equals(Locale.FRANCE.getCountry())) || (paramString.equals(Locale.FRENCH.getCountry())) || (paramString.equals(Locale.CANADA_FRENCH.getCountry()))) {
      return Locale.FRENCH;
    }
    QLog.e("MicroMsg.LocaleUtil", 2, "transLanguageToLocale country = " + paramString);
    return Locale.ENGLISH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.international.LocaleUtil
 * JD-Core Version:    0.7.0.1
 */