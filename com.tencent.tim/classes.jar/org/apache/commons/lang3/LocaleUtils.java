package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LocaleUtils
{
  private static final ConcurrentMap<String, List<Locale>> cCountriesByLanguage = new ConcurrentHashMap();
  private static final ConcurrentMap<String, List<Locale>> cLanguagesByCountry = new ConcurrentHashMap();
  
  public static List<Locale> availableLocaleList()
  {
    return SyncAvoid.AVAILABLE_LOCALE_LIST;
  }
  
  public static Set<Locale> availableLocaleSet()
  {
    return SyncAvoid.AVAILABLE_LOCALE_SET;
  }
  
  public static List<Locale> countriesByLanguage(String paramString)
  {
    if (paramString == null) {
      localObject = Collections.emptyList();
    }
    do
    {
      return localObject;
      localList = (List)cCountriesByLanguage.get(paramString);
      localObject = localList;
    } while (localList != null);
    Object localObject = new ArrayList();
    List localList = availableLocaleList();
    int i = 0;
    while (i < localList.size())
    {
      Locale localLocale = (Locale)localList.get(i);
      if ((paramString.equals(localLocale.getLanguage())) && (localLocale.getCountry().length() != 0) && (localLocale.getVariant().isEmpty())) {
        ((List)localObject).add(localLocale);
      }
      i += 1;
    }
    localObject = Collections.unmodifiableList((List)localObject);
    cCountriesByLanguage.putIfAbsent(paramString, localObject);
    return (List)cCountriesByLanguage.get(paramString);
  }
  
  public static boolean isAvailableLocale(Locale paramLocale)
  {
    return availableLocaleList().contains(paramLocale);
  }
  
  public static List<Locale> languagesByCountry(String paramString)
  {
    if (paramString == null) {
      localObject = Collections.emptyList();
    }
    do
    {
      return localObject;
      localList = (List)cLanguagesByCountry.get(paramString);
      localObject = localList;
    } while (localList != null);
    Object localObject = new ArrayList();
    List localList = availableLocaleList();
    int i = 0;
    while (i < localList.size())
    {
      Locale localLocale = (Locale)localList.get(i);
      if ((paramString.equals(localLocale.getCountry())) && (localLocale.getVariant().isEmpty())) {
        ((List)localObject).add(localLocale);
      }
      i += 1;
    }
    localObject = Collections.unmodifiableList((List)localObject);
    cLanguagesByCountry.putIfAbsent(paramString, localObject);
    return (List)cLanguagesByCountry.get(paramString);
  }
  
  public static List<Locale> localeLookupList(Locale paramLocale)
  {
    return localeLookupList(paramLocale, paramLocale);
  }
  
  public static List<Locale> localeLookupList(Locale paramLocale1, Locale paramLocale2)
  {
    ArrayList localArrayList = new ArrayList(4);
    if (paramLocale1 != null)
    {
      localArrayList.add(paramLocale1);
      if (paramLocale1.getVariant().length() > 0) {
        localArrayList.add(new Locale(paramLocale1.getLanguage(), paramLocale1.getCountry()));
      }
      if (paramLocale1.getCountry().length() > 0) {
        localArrayList.add(new Locale(paramLocale1.getLanguage(), ""));
      }
      if (!localArrayList.contains(paramLocale2)) {
        localArrayList.add(paramLocale2);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public static Locale toLocale(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.isEmpty()) {
      return new Locale("", "");
    }
    if (paramString.contains("#")) {
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
    }
    int i = paramString.length();
    if (i < 2) {
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
    }
    if (paramString.charAt(0) == '_')
    {
      if (i < 3) {
        throw new IllegalArgumentException("Invalid locale format: " + paramString);
      }
      char c1 = paramString.charAt(1);
      char c2 = paramString.charAt(2);
      if ((!Character.isUpperCase(c1)) || (!Character.isUpperCase(c2))) {
        throw new IllegalArgumentException("Invalid locale format: " + paramString);
      }
      if (i == 3) {
        return new Locale("", paramString.substring(1, 3));
      }
      if (i < 5) {
        throw new IllegalArgumentException("Invalid locale format: " + paramString);
      }
      if (paramString.charAt(3) != '_') {
        throw new IllegalArgumentException("Invalid locale format: " + paramString);
      }
      return new Locale("", paramString.substring(1, 3), paramString.substring(4));
    }
    String[] arrayOfString = paramString.split("_", -1);
    switch (arrayOfString.length - 1)
    {
    }
    do
    {
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
      if ((StringUtils.isAllLowerCase(paramString)) && ((i == 2) || (i == 3))) {
        return new Locale(paramString);
      }
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
      if ((StringUtils.isAllLowerCase(arrayOfString[0])) && ((arrayOfString[0].length() == 2) || (arrayOfString[0].length() == 3)) && (arrayOfString[1].length() == 2) && (StringUtils.isAllUpperCase(arrayOfString[1]))) {
        return new Locale(arrayOfString[0], arrayOfString[1]);
      }
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
    } while ((!StringUtils.isAllLowerCase(arrayOfString[0])) || ((arrayOfString[0].length() != 2) && (arrayOfString[0].length() != 3)) || ((arrayOfString[1].length() != 0) && ((arrayOfString[1].length() != 2) || (!StringUtils.isAllUpperCase(arrayOfString[1])))) || (arrayOfString[2].length() <= 0));
    return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
  }
  
  static class SyncAvoid
  {
    private static final List<Locale> AVAILABLE_LOCALE_LIST;
    private static final Set<Locale> AVAILABLE_LOCALE_SET;
    
    static
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(Locale.getAvailableLocales()));
      AVAILABLE_LOCALE_LIST = Collections.unmodifiableList(localArrayList);
      AVAILABLE_LOCALE_SET = Collections.unmodifiableSet(new HashSet(localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.LocaleUtils
 * JD-Core Version:    0.7.0.1
 */