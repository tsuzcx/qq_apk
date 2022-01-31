package android.support.v4.os;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;

class LocaleListCompat$LocaleListCompatBaseImpl
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
    if (this.mLocaleList != null) {
      return this.mLocaleList.getFirstMatch(paramArrayOfString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.LocaleListCompat.LocaleListCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */