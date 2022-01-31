package com.tencent.mobileqq.pluginsdk;

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
  public static final String AUTO = "auto";
  public static final String CHINA = "zh_CN";
  public static final String CHINESE = "zh";
  public static final String ENGLISH = "en";
  public static final String ENGLISH_CANADA = "en_CA";
  public static final String ENGLISH_UK = "en_GB";
  public static final String ENGLISH_US = "en_US";
  public static Locale ES = new Locale("es");
  public static final String FRANCE = "fr_FR";
  public static final String FRENCH = "fr";
  public static final String FRENCH_CANADA = "fr_CA";
  public static final String GERMAN = "de";
  public static final String GERMANY = "de_DE";
  public static final String HONGKONG = "zh_HK";
  public static final int ID_INDEX_AUTO = 0;
  public static final int ID_INDEX_CN = 2;
  public static final int ID_INDEX_DE = 6;
  public static final int ID_INDEX_EN = 1;
  public static final int ID_INDEX_ES = 8;
  public static final int ID_INDEX_FR = 7;
  public static final int ID_INDEX_JA = 4;
  public static final int ID_INDEX_KO = 5;
  public static final int ID_INDEX_TW = 3;
  public static final String JAPAN = "ja_JP";
  public static final String JAPANESE = "ja";
  public static final String KOREA = "ko_KR";
  public static final String KOREAN = "ko";
  public static final String LANGUAGE_KEY = "language_key_string";
  public static final String PREFS_NAME = "qq_language_string";
  public static final String SPAN = "es_ES";
  public static final String SPANISH = "es";
  public static final String SPANISH_Unidos = "es_US";
  public static final String SYSTEM_LANGUAGE_KEY = "system_language_string";
  private static final String TAG = "MicroMsg.LocaleUtil";
  public static final String TAIWAN = "zh_TW";
  public static final String TRANSLATE_LANGUAGE_KEY = "pref_translate_language_key";
  public static Locale[] mlocales = { Locale.ENGLISH, Locale.ENGLISH, Locale.CHINA, Locale.TAIWAN, Locale.JAPANESE, Locale.KOREAN, Locale.GERMAN, Locale.FRENCH, ES };
  public static List<String> trans_support_lang_list = new ArrayList();
  
  static
  {
    trans_support_lang_list.add("ar");
    trans_support_lang_list.add("zh_CN");
    trans_support_lang_list.add("zh_TW");
    trans_support_lang_list.add("en");
    trans_support_lang_list.add("fr");
    trans_support_lang_list.add("de");
    trans_support_lang_list.add("id");
    trans_support_lang_list.add("it");
    trans_support_lang_list.add("ja");
    trans_support_lang_list.add("ko");
    trans_support_lang_list.add("ms");
    trans_support_lang_list.add("fa");
    trans_support_lang_list.add("pt");
    trans_support_lang_list.add("ru");
    trans_support_lang_list.add("es");
    trans_support_lang_list.add("th");
    trans_support_lang_list.add("tr");
    trans_support_lang_list.add("ur");
    trans_support_lang_list.add("vi");
  }
  
  public static int getApplicationLanguageSettings(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("qq_language_string", 4).getString("language_key_string", "auto");
    int i = 0;
    if (paramContext.equals("en")) {
      i = 1;
    }
    do
    {
      return i;
      if (paramContext.equals("zh_CN")) {
        return 2;
      }
      if (paramContext.equals("zh_TW")) {
        return 3;
      }
      if (paramContext.equals("ja")) {
        return 4;
      }
      if (paramContext.equals("ko")) {
        return 5;
      }
      if (paramContext.equals("de")) {
        return 6;
      }
      if (paramContext.equals("fr")) {
        return 7;
      }
    } while (!paramContext.equals("es"));
    return 8;
  }
  
  public static int getCurrentLanguageIndex(Context paramContext)
  {
    int j = getApplicationLanguageSettings(paramContext);
    int i = j;
    if (j == 0)
    {
      paramContext = transLanguageToLocale(Locale.getDefault().toString().trim());
      if (paramContext == Locale.TAIWAN) {
        i = 3;
      }
    }
    else
    {
      return i;
    }
    if (paramContext == Locale.CHINA) {
      return 2;
    }
    if (paramContext == Locale.ENGLISH) {
      return 1;
    }
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
    if (paramContext == ES) {
      return 8;
    }
    return 1;
  }
  
  public static String getLastSystemLocale(Context paramContext)
  {
    return paramContext.getSharedPreferences("qq_language_string", 4).getString("system_language_string", Locale.ENGLISH.toString());
  }
  
  public static final Locale getLocaleById(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= mlocales.length)) {
      return null;
    }
    if (paramInt == 0) {
      return transLanguageToLocale(Locale.getDefault().toString().trim());
    }
    return mlocales[paramInt];
  }
  
  public static final String getTranslateLanguage(Context paramContext, String paramString)
  {
    Locale localLocale = transLanguageToLocaleWithZh_CN(Locale.getDefault().toString().trim());
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramString, 4);
    paramString = localLocale.getLanguage();
    paramContext = paramString;
    if (paramString.equalsIgnoreCase("zh")) {
      paramContext = localLocale.toString();
    }
    return localSharedPreferences.getString("pref_translate_language_key", paramContext);
  }
  
  public static boolean isLanguageSupported(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    while ((!paramString.equalsIgnoreCase("zh_TW")) && (!paramString.equalsIgnoreCase("zh_HK")) && (!paramString.equalsIgnoreCase("ja")) && (!paramString.equalsIgnoreCase("en")) && (!paramString.equalsIgnoreCase("ko")) && (!paramString.equalsIgnoreCase("de")) && (!paramString.equalsIgnoreCase("fr")) && (!paramString.equalsIgnoreCase("es")) && (!paramString.equalsIgnoreCase("zh_CN"))) {
      return false;
    }
    return true;
  }
  
  public static void saveApplicationLanguage(Context paramContext, Locale paramLocale)
  {
    if (paramContext.getSharedPreferences("qq_language_string", 4).edit().putString("language_key_string", paramLocale.toString()).commit())
    {
      QLog.w("MicroMsg.LocaleUtil", 2, "save application lang as:" + paramLocale);
      return;
    }
    QLog.e("MicroMsg.LocaleUtil", 2, "saving application lang failed");
  }
  
  public static void saveSystemLanguage(Context paramContext)
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
  
  public static final boolean setTranslateLanguage(String paramString1, Context paramContext, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 4).edit().putString("pref_translate_language_key", paramString2).commit();
  }
  
  public static Locale transContryToLocale(String paramString)
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
  
  public static Locale transLanguageToLocale(String paramString)
  {
    if ((paramString.equals("zh_TW")) || (paramString.equals("zh_HK"))) {
      return Locale.TAIWAN;
    }
    if ((paramString.equals("zh_CN")) || (paramString.equals(Locale.CHINESE))) {
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
      return ES;
    }
    QLog.e("MicroMsg.LocaleUtil", 2, "transLanguageToLocale country = " + paramString);
    return Locale.ENGLISH;
  }
  
  public static Locale transLanguageToLocaleWithZh_CN(String paramString)
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
      return ES;
    }
    if (trans_support_lang_list.contains(paramString.toLowerCase())) {
      return new Locale(paramString);
    }
    QLog.e("MicroMsg.LocaleUtil", 2, "transLanguageToLocale country = " + paramString);
    return Locale.ENGLISH;
  }
  
  public static void updateApplicationResourceLocale(Context paramContext, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > mlocales.length)) {
      return;
    }
    if (paramInt == 0) {}
    for (Locale localLocale = getLocaleById(getCurrentLanguageIndex(paramContext));; localLocale = mlocales[paramInt])
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
  
  public static void updateApplicationResourceLocale(Context paramContext, Locale paramLocale)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.LocaleUtil
 * JD-Core Version:    0.7.0.1
 */