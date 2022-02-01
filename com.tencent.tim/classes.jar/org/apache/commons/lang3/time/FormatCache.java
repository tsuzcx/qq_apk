package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

abstract class FormatCache<F extends Format>
{
  static final int NONE = -1;
  private static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
  private final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap(7);
  
  private F getDateTimeInstance(Integer paramInteger1, Integer paramInteger2, TimeZone paramTimeZone, Locale paramLocale)
  {
    Locale localLocale = paramLocale;
    if (paramLocale == null) {
      localLocale = Locale.getDefault();
    }
    return getInstance(getPatternForStyle(paramInteger1, paramInteger2, localLocale), paramTimeZone, localLocale);
  }
  
  static String getPatternForStyle(Integer paramInteger1, Integer paramInteger2, Locale paramLocale)
  {
    MultipartKey localMultipartKey = new MultipartKey(new Object[] { paramInteger1, paramInteger2, paramLocale });
    String str2 = (String)cDateTimeInstanceCache.get(localMultipartKey);
    String str1 = str2;
    if (str2 == null)
    {
      if (paramInteger1 == null) {}
      for (;;)
      {
        try
        {
          paramInteger1 = DateFormat.getTimeInstance(paramInteger2.intValue(), paramLocale);
          str1 = ((SimpleDateFormat)paramInteger1).toPattern();
          paramInteger1 = (String)cDateTimeInstanceCache.putIfAbsent(localMultipartKey, str1);
          if (paramInteger1 == null) {
            break;
          }
          return paramInteger1;
        }
        catch (ClassCastException paramInteger1)
        {
          throw new IllegalArgumentException("No date time pattern for locale: " + paramLocale);
        }
        if (paramInteger2 == null) {
          paramInteger1 = DateFormat.getDateInstance(paramInteger1.intValue(), paramLocale);
        } else {
          paramInteger1 = DateFormat.getDateTimeInstance(paramInteger1.intValue(), paramInteger2.intValue(), paramLocale);
        }
      }
    }
    return str1;
  }
  
  protected abstract F createInstance(String paramString, TimeZone paramTimeZone, Locale paramLocale);
  
  F getDateInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale)
  {
    return getDateTimeInstance(Integer.valueOf(paramInt), null, paramTimeZone, paramLocale);
  }
  
  F getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone, Locale paramLocale)
  {
    return getDateTimeInstance(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTimeZone, paramLocale);
  }
  
  public F getInstance()
  {
    return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
  }
  
  public F getInstance(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    if (paramString == null) {
      throw new NullPointerException("pattern must not be null");
    }
    TimeZone localTimeZone = paramTimeZone;
    if (paramTimeZone == null) {
      localTimeZone = TimeZone.getDefault();
    }
    paramTimeZone = paramLocale;
    if (paramLocale == null) {
      paramTimeZone = Locale.getDefault();
    }
    MultipartKey localMultipartKey = new MultipartKey(new Object[] { paramString, localTimeZone, paramTimeZone });
    Format localFormat = (Format)this.cInstanceCache.get(localMultipartKey);
    paramLocale = localFormat;
    if (localFormat == null)
    {
      paramString = createInstance(paramString, localTimeZone, paramTimeZone);
      paramLocale = (Format)this.cInstanceCache.putIfAbsent(localMultipartKey, paramString);
      if (paramLocale == null) {}
    }
    else
    {
      return paramLocale;
    }
    return paramString;
  }
  
  F getTimeInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale)
  {
    return getDateTimeInstance(null, Integer.valueOf(paramInt), paramTimeZone, paramLocale);
  }
  
  static class MultipartKey
  {
    private int hashCode;
    private final Object[] keys;
    
    public MultipartKey(Object... paramVarArgs)
    {
      this.keys = paramVarArgs;
    }
    
    public boolean equals(Object paramObject)
    {
      return Arrays.equals(this.keys, ((MultipartKey)paramObject).keys);
    }
    
    public int hashCode()
    {
      int j = 0;
      if (this.hashCode == 0)
      {
        Object[] arrayOfObject = this.keys;
        int m = arrayOfObject.length;
        int i = 0;
        while (i < m)
        {
          Object localObject = arrayOfObject[i];
          int k = j;
          if (localObject != null) {
            k = j * 7 + localObject.hashCode();
          }
          i += 1;
          j = k;
        }
        this.hashCode = j;
      }
      return this.hashCode;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.time.FormatCache
 * JD-Core Version:    0.7.0.1
 */