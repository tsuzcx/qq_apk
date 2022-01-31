package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class LocaleUtil
{
  public static final String ARABIC = "ar";
  public static final String CHINA = "zh_CN";
  public static final String ENGLISH = "en";
  public static final String HEBREW = "iw";
  public static final String HINDI = "hi";
  public static final String HONGKONG = "zh_HK";
  public static final String INDONESIAN = "id";
  public static final String ITALIAN = "it";
  public static final String JAPANESE = "ja";
  public static final String KOREAN = "ko";
  public static final String LANGUAGE_DEFAULT = "language_default";
  public static final String LANGUAGE_KEY = "language_key";
  public static final String MALAY = "ms";
  public static final String POLISH = "pl";
  public static final String PORTUGUESE = "pt";
  public static final String RUSSIAN = "ru";
  public static final String SPANISH = "es";
  public static final String TAIWAN = "zh_TW";
  public static final String THAI = "th";
  public static final String TURKEY = "tr";
  public static final String VIETNAMESE = "vi";
  
  private static String d(String paramString)
  {
    String str = Locale.getDefault().getLanguage().trim();
    if (str.equals("en")) {
      paramString = str;
    }
    do
    {
      return paramString;
      str = Locale.getDefault().getLanguage().trim() + "_" + Locale.getDefault().getCountry().trim();
      if ((str.equals("zh_TW")) || (str.equals("zh_HK"))) {
        return "zh_TW";
      }
      if ((Locale.getDefault().getLanguage().trim() + "_" + Locale.getDefault().getCountry().trim()).equals("zh_CN")) {
        return "zh_CN";
      }
      if (Locale.getDefault().getLanguage().trim().equals("th")) {
        return "th";
      }
      if (Locale.getDefault().getLanguage().trim().equals("id")) {
        return "id";
      }
      if (Locale.getDefault().getLanguage().trim().equals("vi")) {
        return "vi";
      }
      if (Locale.getDefault().getLanguage().trim().equals("pt")) {
        return "pt";
      }
      if (Locale.getDefault().getLanguage().trim().equals("es")) {
        return "es";
      }
      if (Locale.getDefault().getLanguage().trim().equals("ru")) {
        return "ru";
      }
      if (Locale.getDefault().getLanguage().trim().equals("ar")) {
        return "ar";
      }
      if (Locale.getDefault().getLanguage().trim().equals("iw")) {
        return "iw";
      }
      if (Locale.getDefault().getLanguage().trim().equals("pl")) {
        return "pl";
      }
      if (Locale.getDefault().getLanguage().trim().equals("hi")) {
        return "hi";
      }
      if (Locale.getDefault().getLanguage().trim().equals("ja")) {
        return "ja";
      }
      if (Locale.getDefault().getLanguage().trim().equals("it")) {
        return "it";
      }
      if (Locale.getDefault().getLanguage().trim().equals("ko")) {
        return "ko";
      }
      if (Locale.getDefault().getLanguage().trim().equals("ms")) {
        return "ms";
      }
    } while (!Locale.getDefault().getLanguage().trim().equals("tr"));
    return "tr";
  }
  
  public static String getApplicationLanguage()
  {
    String str = Util.nullAsNil(SystemProperty.getProperty("language_key"));
    if ((str.length() > 0) && (!str.equals("language_default"))) {
      return str;
    }
    return d("en");
  }
  
  public static String getCurrentCountryCode()
  {
    return Locale.getDefault().getCountry().trim();
  }
  
  public static boolean isLanguageSupported(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {}
    while ((!paramString.equalsIgnoreCase("zh_TW")) && (!paramString.equalsIgnoreCase("zh_HK")) && (!paramString.equalsIgnoreCase("zh_CN")) && (!paramString.equalsIgnoreCase("en")) && (!paramString.equalsIgnoreCase("th")) && (!paramString.equals("id")) && (!paramString.equals("vi")) && (!paramString.equalsIgnoreCase("pt")) && (!paramString.equalsIgnoreCase("es")) && (!paramString.equalsIgnoreCase("ru")) && (!paramString.equalsIgnoreCase("ar")) && (!paramString.equalsIgnoreCase("iw")) && (!paramString.equalsIgnoreCase("pl")) && (!paramString.equalsIgnoreCase("hi")) && (!paramString.equalsIgnoreCase("ja")) && (!paramString.equalsIgnoreCase("it")) && (!paramString.equalsIgnoreCase("ko")) && (!paramString.equalsIgnoreCase("ms")) && (!paramString.equalsIgnoreCase("tr"))) {
      return false;
    }
    return true;
  }
  
  public static String loadApplicationLanguage(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    paramSharedPreferences = Util.nullAsNil(paramSharedPreferences.getString("language_key", null));
    if ((paramSharedPreferences.length() > 0) && (!paramSharedPreferences.equals("language_default")))
    {
      SystemProperty.setProperty("language_key", paramSharedPreferences);
      return paramSharedPreferences;
    }
    paramSharedPreferences = d("en");
    SystemProperty.setProperty("language_key", paramSharedPreferences);
    return paramSharedPreferences;
  }
  
  public static String loadApplicationLanguageSettings(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    paramSharedPreferences = Util.nullAsNil(paramSharedPreferences.getString("language_key", null));
    if (!Util.isNullOrNil(paramSharedPreferences)) {
      return paramSharedPreferences;
    }
    return "language_default";
  }
  
  public static void saveApplicationLanguage(SharedPreferences paramSharedPreferences, Context paramContext, String paramString)
  {
    if (paramSharedPreferences.edit().putString("language_key", paramString).commit())
    {
      SystemProperty.setProperty("language_key", paramString);
      Log.w("MicroMsg.LocaleUtil", "save application lang as:" + paramString);
      return;
    }
    Log.e("MicroMsg.LocaleUtil", "saving application lang failed");
  }
  
  public static Locale transLanguageToLocale(String paramString)
  {
    if ((paramString.equals("zh_TW")) || (paramString.equals("zh_HK"))) {
      return Locale.TAIWAN;
    }
    if (paramString.equals("en")) {
      return Locale.ENGLISH;
    }
    if (paramString.equals("zh_CN")) {
      return Locale.CHINA;
    }
    if (paramString.equalsIgnoreCase("th")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("id")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("vi")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("pt")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("es")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("ru")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("ar")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("iw")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("pl")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("hi")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("ja")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("it")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("ko")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("ms")) {
      return new Locale(paramString);
    }
    if (paramString.equalsIgnoreCase("tr")) {
      return new Locale(paramString);
    }
    Log.e("MicroMsg.LocaleUtil", "transLanguageToLocale country = " + paramString);
    return Locale.ENGLISH;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LocaleUtil
 * JD-Core Version:    0.7.0.1
 */