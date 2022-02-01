package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.LocaleList;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.Size;
import java.util.Locale;

public final class LocaleListCompat
{
  static final LocaleListInterface IMPL = new LocaleListCompatBaseImpl();
  private static final LocaleListCompat sEmptyLocaleList = new LocaleListCompat();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      IMPL = new LocaleListCompatApi24Impl();
      return;
    }
  }
  
  public static LocaleListCompat create(@NonNull Locale... paramVarArgs)
  {
    LocaleListCompat localLocaleListCompat = new LocaleListCompat();
    localLocaleListCompat.setLocaleListArray(paramVarArgs);
    return localLocaleListCompat;
  }
  
  @NonNull
  public static LocaleListCompat forLanguageTags(@Nullable String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      String[] arrayOfString = paramString.split(",");
      Locale[] arrayOfLocale = new Locale[arrayOfString.length];
      int i = 0;
      while (i < arrayOfLocale.length)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramString = Locale.forLanguageTag(arrayOfString[i]);
        } else {
          paramString = LocaleHelper.forLanguageTag(arrayOfString[i]);
        }
        arrayOfLocale[i] = paramString;
        i += 1;
      }
      paramString = new LocaleListCompat();
      paramString.setLocaleListArray(arrayOfLocale);
      return paramString;
    }
    return getEmptyLocaleList();
  }
  
  @NonNull
  @Size(min=1L)
  public static LocaleListCompat getAdjustedDefault()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return wrap(LocaleList.getAdjustedDefault());
    }
    return create(new Locale[] { Locale.getDefault() });
  }
  
  @NonNull
  @Size(min=1L)
  public static LocaleListCompat getDefault()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return wrap(LocaleList.getDefault());
    }
    return create(new Locale[] { Locale.getDefault() });
  }
  
  @NonNull
  public static LocaleListCompat getEmptyLocaleList()
  {
    return sEmptyLocaleList;
  }
  
  @RequiresApi(24)
  private void setLocaleList(LocaleList paramLocaleList)
  {
    int j = paramLocaleList.size();
    if (j > 0)
    {
      Locale[] arrayOfLocale = new Locale[j];
      int i = 0;
      while (i < j)
      {
        arrayOfLocale[i] = paramLocaleList.get(i);
        i += 1;
      }
      IMPL.setLocaleList(arrayOfLocale);
    }
  }
  
  private void setLocaleListArray(Locale... paramVarArgs)
  {
    IMPL.setLocaleList(paramVarArgs);
  }
  
  @RequiresApi(24)
  public static LocaleListCompat wrap(Object paramObject)
  {
    LocaleListCompat localLocaleListCompat = new LocaleListCompat();
    if ((paramObject instanceof LocaleList)) {
      localLocaleListCompat.setLocaleList((LocaleList)paramObject);
    }
    return localLocaleListCompat;
  }
  
  public boolean equals(Object paramObject)
  {
    return IMPL.equals(paramObject);
  }
  
  public Locale get(int paramInt)
  {
    return IMPL.get(paramInt);
  }
  
  public Locale getFirstMatch(String[] paramArrayOfString)
  {
    return IMPL.getFirstMatch(paramArrayOfString);
  }
  
  public int hashCode()
  {
    return IMPL.hashCode();
  }
  
  @IntRange(from=-1L)
  public int indexOf(Locale paramLocale)
  {
    return IMPL.indexOf(paramLocale);
  }
  
  public boolean isEmpty()
  {
    return IMPL.isEmpty();
  }
  
  @IntRange(from=0L)
  public int size()
  {
    return IMPL.size();
  }
  
  @NonNull
  public String toLanguageTags()
  {
    return IMPL.toLanguageTags();
  }
  
  public String toString()
  {
    return IMPL.toString();
  }
  
  @Nullable
  public Object unwrap()
  {
    return IMPL.getLocaleList();
  }
  
  @RequiresApi(24)
  static class LocaleListCompatApi24Impl
    implements LocaleListInterface
  {
    private LocaleList mLocaleList = new LocaleList(new Locale[0]);
    
    public boolean equals(Object paramObject)
    {
      return this.mLocaleList.equals(((LocaleListCompat)paramObject).unwrap());
    }
    
    public Locale get(int paramInt)
    {
      return this.mLocaleList.get(paramInt);
    }
    
    @Nullable
    public Locale getFirstMatch(String[] paramArrayOfString)
    {
      LocaleList localLocaleList = this.mLocaleList;
      if (localLocaleList != null) {
        return localLocaleList.getFirstMatch(paramArrayOfString);
      }
      return null;
    }
    
    public Object getLocaleList()
    {
      return this.mLocaleList;
    }
    
    public int hashCode()
    {
      return this.mLocaleList.hashCode();
    }
    
    @IntRange(from=-1L)
    public int indexOf(Locale paramLocale)
    {
      return this.mLocaleList.indexOf(paramLocale);
    }
    
    public boolean isEmpty()
    {
      return this.mLocaleList.isEmpty();
    }
    
    public void setLocaleList(@NonNull Locale... paramVarArgs)
    {
      this.mLocaleList = new LocaleList(paramVarArgs);
    }
    
    @IntRange(from=0L)
    public int size()
    {
      return this.mLocaleList.size();
    }
    
    public String toLanguageTags()
    {
      return this.mLocaleList.toLanguageTags();
    }
    
    public String toString()
    {
      return this.mLocaleList.toString();
    }
  }
  
  static class LocaleListCompatBaseImpl
    implements LocaleListInterface
  {
    private LocaleListHelper mLocaleList = new LocaleListHelper(new Locale[0]);
    
    public boolean equals(Object paramObject)
    {
      return this.mLocaleList.equals(((LocaleListCompat)paramObject).unwrap());
    }
    
    public Locale get(int paramInt)
    {
      return this.mLocaleList.get(paramInt);
    }
    
    @Nullable
    public Locale getFirstMatch(String[] paramArrayOfString)
    {
      LocaleListHelper localLocaleListHelper = this.mLocaleList;
      if (localLocaleListHelper != null) {
        return localLocaleListHelper.getFirstMatch(paramArrayOfString);
      }
      return null;
    }
    
    public Object getLocaleList()
    {
      return this.mLocaleList;
    }
    
    public int hashCode()
    {
      return this.mLocaleList.hashCode();
    }
    
    @IntRange(from=-1L)
    public int indexOf(Locale paramLocale)
    {
      return this.mLocaleList.indexOf(paramLocale);
    }
    
    public boolean isEmpty()
    {
      return this.mLocaleList.isEmpty();
    }
    
    public void setLocaleList(@NonNull Locale... paramVarArgs)
    {
      this.mLocaleList = new LocaleListHelper(paramVarArgs);
    }
    
    @IntRange(from=0L)
    public int size()
    {
      return this.mLocaleList.size();
    }
    
    public String toLanguageTags()
    {
      return this.mLocaleList.toLanguageTags();
    }
    
    public String toString()
    {
      return this.mLocaleList.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.LocaleListCompat
 * JD-Core Version:    0.7.0.1
 */