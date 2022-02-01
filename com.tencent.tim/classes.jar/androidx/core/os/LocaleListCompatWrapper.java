package androidx.core.os;

import android.os.Build.VERSION;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

final class LocaleListCompatWrapper
  implements LocaleListInterface
{
  private static final Locale EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
  private static final Locale LOCALE_AR_XB;
  private static final Locale LOCALE_EN_XA;
  private static final Locale[] sEmptyList = new Locale[0];
  private final Locale[] mList;
  @NonNull
  private final String mStringRepresentation;
  
  static
  {
    LOCALE_EN_XA = new Locale("en", "XA");
    LOCALE_AR_XB = new Locale("ar", "XB");
  }
  
  LocaleListCompatWrapper(@NonNull Locale... paramVarArgs)
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
      if (localLocale == null) {
        throw new NullPointerException("list[" + i + "] is null");
      }
      if (localHashSet.contains(localLocale)) {
        throw new IllegalArgumentException("list[" + i + "] is a repetition");
      }
      localLocale = (Locale)localLocale.clone();
      arrayOfLocale[i] = localLocale;
      toLanguageTag(localStringBuilder, localLocale);
      if (i < paramVarArgs.length - 1) {
        localStringBuilder.append(',');
      }
      localHashSet.add(localLocale);
      i += 1;
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
    int j;
    if (this.mList.length == 1)
    {
      j = 0;
      return j;
    }
    if (this.mList.length == 0) {
      return -1;
    }
    int i;
    if (paramBoolean)
    {
      i = findFirstMatchIndex(EN_LATN);
      if (i == 0) {
        return 0;
      }
      if (i >= 2147483647) {}
    }
    for (;;)
    {
      paramCollection = paramCollection.iterator();
      label56:
      if (paramCollection.hasNext())
      {
        j = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat((String)paramCollection.next()));
        if (j == 0) {
          return 0;
        }
        if (j >= i) {
          break label113;
        }
        i = j;
      }
      label113:
      for (;;)
      {
        break label56;
        j = i;
        if (i != 2147483647) {
          break;
        }
        return 0;
      }
      i = 2147483647;
    }
  }
  
  private int findFirstMatchIndex(Locale paramLocale)
  {
    int i = 0;
    while (i < this.mList.length)
    {
      if (matchScore(paramLocale, this.mList[i]) > 0) {
        return i;
      }
      i += 1;
    }
    return 2147483647;
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
  
  private static boolean isPseudoLocale(Locale paramLocale)
  {
    return (LOCALE_EN_XA.equals(paramLocale)) || (LOCALE_AR_XB.equals(paramLocale));
  }
  
  @IntRange(from=0L, to=1L)
  private static int matchScore(Locale paramLocale1, Locale paramLocale2)
  {
    int j = 1;
    int k = 0;
    if (paramLocale1.equals(paramLocale2)) {
      i = 1;
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            i = k;
          } while (!paramLocale1.getLanguage().equals(paramLocale2.getLanguage()));
          i = k;
        } while (isPseudoLocale(paramLocale1));
        i = k;
      } while (isPseudoLocale(paramLocale2));
      str = getLikelyScript(paramLocale1);
      if (!str.isEmpty()) {
        break label96;
      }
      paramLocale1 = paramLocale1.getCountry();
      if (paramLocale1.isEmpty()) {
        break;
      }
      i = k;
    } while (!paramLocale1.equals(paramLocale2.getCountry()));
    return 1;
    label96:
    if (str.equals(getLikelyScript(paramLocale2))) {}
    for (int i = j;; i = 0) {
      return i;
    }
  }
  
  @VisibleForTesting
  static void toLanguageTag(StringBuilder paramStringBuilder, Locale paramLocale)
  {
    paramStringBuilder.append(paramLocale.getLanguage());
    String str = paramLocale.getCountry();
    if ((str != null) && (!str.isEmpty()))
    {
      paramStringBuilder.append('-');
      paramStringBuilder.append(paramLocale.getCountry());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof LocaleListCompatWrapper));
      paramObject = ((LocaleListCompatWrapper)paramObject).mList;
      bool1 = bool2;
    } while (this.mList.length != paramObject.length);
    int i = 0;
    for (;;)
    {
      if (i >= this.mList.length) {
        break label79;
      }
      bool1 = bool2;
      if (!this.mList[i].equals(paramObject[i])) {
        break;
      }
      i += 1;
    }
    label79:
    return true;
  }
  
  public Locale get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mList.length)) {
      return this.mList[paramInt];
    }
    return null;
  }
  
  public Locale getFirstMatch(@NonNull String[] paramArrayOfString)
  {
    return computeFirstMatch(Arrays.asList(paramArrayOfString), false);
  }
  
  @Nullable
  public Object getLocaleList()
  {
    return null;
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.mList.length)
    {
      j = j * 31 + this.mList[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public int indexOf(Locale paramLocale)
  {
    int i = 0;
    while (i < this.mList.length)
    {
      if (this.mList[i].equals(paramLocale)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.mList.length == 0;
  }
  
  public int size()
  {
    return this.mList.length;
  }
  
  public String toLanguageTags()
  {
    return this.mStringRepresentation;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int i = 0;
    while (i < this.mList.length)
    {
      localStringBuilder.append(this.mList[i]);
      if (i < this.mList.length - 1) {
        localStringBuilder.append(',');
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.os.LocaleListCompatWrapper
 * JD-Core Version:    0.7.0.1
 */