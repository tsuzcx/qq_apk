package android.support.v4.os;

import android.os.Build.VERSION;
import android.support.annotation.GuardedBy;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.Size;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

@RequiresApi(14)
@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
final class LocaleListHelper
{
  private static final Locale EN_LATN;
  private static final Locale LOCALE_AR_XB;
  private static final Locale LOCALE_EN_XA;
  private static final int NUM_PSEUDO_LOCALES = 2;
  private static final String STRING_AR_XB = "ar-XB";
  private static final String STRING_EN_XA = "en-XA";
  @GuardedBy("sLock")
  private static LocaleListHelper sDefaultAdjustedLocaleList = null;
  @GuardedBy("sLock")
  private static LocaleListHelper sDefaultLocaleList;
  private static final Locale[] sEmptyList = new Locale[0];
  private static final LocaleListHelper sEmptyLocaleList = new LocaleListHelper(new Locale[0]);
  @GuardedBy("sLock")
  private static Locale sLastDefaultLocale = null;
  @GuardedBy("sLock")
  private static LocaleListHelper sLastExplicitlySetLocaleList;
  private static final Object sLock;
  private final Locale[] mList;
  @NonNull
  private final String mStringRepresentation;
  
  static
  {
    LOCALE_EN_XA = new Locale("en", "XA");
    LOCALE_AR_XB = new Locale("ar", "XB");
    EN_LATN = LocaleHelper.forLanguageTag("en-Latn");
    sLock = new Object();
    sLastExplicitlySetLocaleList = null;
    sDefaultLocaleList = null;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  LocaleListHelper(@NonNull Locale paramLocale, LocaleListHelper paramLocaleListHelper)
  {
    if (paramLocale != null)
    {
      int m = 0;
      int j;
      if (paramLocaleListHelper == null) {
        j = 0;
      } else {
        j = paramLocaleListHelper.mList.length;
      }
      int i = 0;
      while (i < j)
      {
        if (paramLocale.equals(paramLocaleListHelper.mList[i])) {
          break label61;
        }
        i += 1;
      }
      i = -1;
      label61:
      if (i == -1) {
        k = 1;
      } else {
        k = 0;
      }
      int i1 = k + j;
      Locale[] arrayOfLocale = new Locale[i1];
      arrayOfLocale[0] = ((Locale)paramLocale.clone());
      if (i == -1) {
        for (i = 0; i < j; i = k)
        {
          k = i + 1;
          arrayOfLocale[k] = ((Locale)paramLocaleListHelper.mList[i].clone());
        }
      }
      int n;
      for (int k = 0; k < i; k = n)
      {
        n = k + 1;
        arrayOfLocale[n] = ((Locale)paramLocaleListHelper.mList[k].clone());
      }
      i += 1;
      while (i < j)
      {
        arrayOfLocale[i] = ((Locale)paramLocaleListHelper.mList[i].clone());
        i += 1;
      }
      paramLocale = new StringBuilder();
      i = m;
      while (i < i1)
      {
        paramLocale.append(LocaleHelper.toLanguageTag(arrayOfLocale[i]));
        if (i < i1 - 1) {
          paramLocale.append(',');
        }
        i += 1;
      }
      this.mList = arrayOfLocale;
      this.mStringRepresentation = paramLocale.toString();
      return;
    }
    throw new NullPointerException("topLocale is null");
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  LocaleListHelper(@NonNull Locale... paramVarArgs)
  {
    if (paramVarArgs.length == 0)
    {
      this.mList = sEmptyList;
      this.mStringRepresentation = "";
      return;
    }
    Locale[] arrayOfLocale = new Locale[paramVarArgs.length];
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Locale localLocale = paramVarArgs[i];
      if (localLocale != null)
      {
        if (!localHashSet.contains(localLocale))
        {
          localLocale = (Locale)localLocale.clone();
          arrayOfLocale[i] = localLocale;
          localStringBuilder.append(LocaleHelper.toLanguageTag(localLocale));
          if (i < paramVarArgs.length - 1) {
            localStringBuilder.append(',');
          }
          localHashSet.add(localLocale);
          i += 1;
        }
        else
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("list[");
          paramVarArgs.append(i);
          paramVarArgs.append("] is a repetition");
          throw new IllegalArgumentException(paramVarArgs.toString());
        }
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("list[");
        paramVarArgs.append(i);
        paramVarArgs.append("] is null");
        throw new NullPointerException(paramVarArgs.toString());
      }
    }
    this.mList = arrayOfLocale;
    this.mStringRepresentation = localStringBuilder.toString();
  }
  
  private Locale computeFirstMatch(Collection<String> paramCollection, boolean paramBoolean)
  {
    int i = computeFirstMatchIndex(paramCollection, paramBoolean);
    if (i == -1) {
      return null;
    }
    return this.mList[i];
  }
  
  private int computeFirstMatchIndex(Collection<String> paramCollection, boolean paramBoolean)
  {
    Locale[] arrayOfLocale = this.mList;
    if (arrayOfLocale.length == 1) {
      return 0;
    }
    if (arrayOfLocale.length == 0) {
      return -1;
    }
    int i;
    if (paramBoolean)
    {
      i = findFirstMatchIndex(EN_LATN);
      if (i == 0) {
        return 0;
      }
      if (i < 2147483647) {}
    }
    else
    {
      i = 2147483647;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      int j = findFirstMatchIndex(LocaleHelper.forLanguageTag((String)paramCollection.next()));
      if (j == 0) {
        return 0;
      }
      if (j < i) {
        i = j;
      }
    }
    if (i == 2147483647) {
      return 0;
    }
    return i;
  }
  
  private int findFirstMatchIndex(Locale paramLocale)
  {
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      if (matchScore(paramLocale, arrayOfLocale[i]) > 0) {
        return i;
      }
      i += 1;
    }
    return 2147483647;
  }
  
  @NonNull
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  static LocaleListHelper forLanguageTags(@Nullable String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.split(",");
      Locale[] arrayOfLocale = new Locale[paramString.length];
      int i = 0;
      while (i < arrayOfLocale.length)
      {
        arrayOfLocale[i] = LocaleHelper.forLanguageTag(paramString[i]);
        i += 1;
      }
      return new LocaleListHelper(arrayOfLocale);
    }
    return getEmptyLocaleList();
  }
  
  @NonNull
  @Size(min=1L)
  static LocaleListHelper getAdjustedDefault()
  {
    getDefault();
    synchronized (sLock)
    {
      LocaleListHelper localLocaleListHelper = sDefaultAdjustedLocaleList;
      return localLocaleListHelper;
    }
  }
  
  @NonNull
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  @Size(min=1L)
  static LocaleListHelper getDefault()
  {
    Object localObject2 = Locale.getDefault();
    synchronized (sLock)
    {
      if (!((Locale)localObject2).equals(sLastDefaultLocale))
      {
        sLastDefaultLocale = (Locale)localObject2;
        if ((sDefaultLocaleList != null) && (((Locale)localObject2).equals(sDefaultLocaleList.get(0))))
        {
          localObject2 = sDefaultLocaleList;
          return localObject2;
        }
        sDefaultLocaleList = new LocaleListHelper((Locale)localObject2, sLastExplicitlySetLocaleList);
        sDefaultAdjustedLocaleList = sDefaultLocaleList;
      }
      localObject2 = sDefaultLocaleList;
      return localObject2;
    }
  }
  
  @NonNull
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  static LocaleListHelper getEmptyLocaleList()
  {
    return sEmptyLocaleList;
  }
  
  private static String getLikelyScript(Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramLocale = paramLocale.getScript();
      if (!paramLocale.isEmpty()) {
        return paramLocale;
      }
      return "";
    }
    return "";
  }
  
  private static boolean isPseudoLocale(String paramString)
  {
    return ("en-XA".equals(paramString)) || ("ar-XB".equals(paramString));
  }
  
  private static boolean isPseudoLocale(Locale paramLocale)
  {
    return (LOCALE_EN_XA.equals(paramLocale)) || (LOCALE_AR_XB.equals(paramLocale));
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  static boolean isPseudoLocalesOnly(@Nullable String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return true;
    }
    if (paramArrayOfString.length > 3) {
      return false;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if ((!str.isEmpty()) && (!isPseudoLocale(str))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @IntRange(from=0L, to=1L)
  private static int matchScore(Locale paramLocale1, Locale paramLocale2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  static void setDefault(@NonNull @Size(min=1L) LocaleListHelper paramLocaleListHelper)
  {
    setDefault(paramLocaleListHelper, 0);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  static void setDefault(@NonNull @Size(min=1L) LocaleListHelper paramLocaleListHelper, int paramInt)
  {
    if (paramLocaleListHelper != null)
    {
      if (!paramLocaleListHelper.isEmpty()) {
        synchronized (sLock)
        {
          sLastDefaultLocale = paramLocaleListHelper.get(paramInt);
          Locale.setDefault(sLastDefaultLocale);
          sLastExplicitlySetLocaleList = paramLocaleListHelper;
          sDefaultLocaleList = paramLocaleListHelper;
          if (paramInt == 0) {
            sDefaultAdjustedLocaleList = sDefaultLocaleList;
          } else {
            sDefaultAdjustedLocaleList = new LocaleListHelper(sLastDefaultLocale, sDefaultLocaleList);
          }
          return;
        }
      }
      throw new IllegalArgumentException("locales is empty");
    }
    throw new NullPointerException("locales is null");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof LocaleListHelper)) {
      return false;
    }
    paramObject = ((LocaleListHelper)paramObject).mList;
    if (this.mList.length != paramObject.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      if (!arrayOfLocale[i].equals(paramObject[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  Locale get(int paramInt)
  {
    if (paramInt >= 0)
    {
      Locale[] arrayOfLocale = this.mList;
      if (paramInt < arrayOfLocale.length) {
        return arrayOfLocale[paramInt];
      }
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  Locale getFirstMatch(String[] paramArrayOfString)
  {
    return computeFirstMatch(Arrays.asList(paramArrayOfString), false);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int getFirstMatchIndex(String[] paramArrayOfString)
  {
    return computeFirstMatchIndex(Arrays.asList(paramArrayOfString), false);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int getFirstMatchIndexWithEnglishSupported(Collection<String> paramCollection)
  {
    return computeFirstMatchIndex(paramCollection, true);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int getFirstMatchIndexWithEnglishSupported(String[] paramArrayOfString)
  {
    return getFirstMatchIndexWithEnglishSupported(Arrays.asList(paramArrayOfString));
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  Locale getFirstMatchWithEnglishSupported(String[] paramArrayOfString)
  {
    return computeFirstMatch(Arrays.asList(paramArrayOfString), true);
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      j = j * 31 + arrayOfLocale[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  @IntRange(from=-1L)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int indexOf(Locale paramLocale)
  {
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      if (arrayOfLocale[i].equals(paramLocale)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  boolean isEmpty()
  {
    return this.mList.length == 0;
  }
  
  @IntRange(from=0L)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int size()
  {
    return this.mList.length;
  }
  
  @NonNull
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  String toLanguageTags()
  {
    return this.mStringRepresentation;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      localStringBuilder.append(arrayOfLocale[i]);
      if (i < this.mList.length - 1) {
        localStringBuilder.append(',');
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.LocaleListHelper
 * JD-Core Version:    0.7.0.1
 */