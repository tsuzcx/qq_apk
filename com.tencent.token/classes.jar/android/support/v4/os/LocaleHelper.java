package android.support.v4.os;

import android.support.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
final class LocaleHelper
{
  static Locale forLanguageTag(String paramString)
  {
    if (paramString.contains("-"))
    {
      localObject = paramString.split("-");
      if (localObject.length > 2) {
        return new Locale(localObject[0], localObject[1], localObject[2]);
      }
      if (localObject.length > 1) {
        return new Locale(localObject[0], localObject[1]);
      }
      if (localObject.length == 1) {
        return new Locale(localObject[0]);
      }
    }
    else
    {
      if (!paramString.contains("_")) {
        break label192;
      }
      localObject = paramString.split("_");
      if (localObject.length > 2) {
        return new Locale(localObject[0], localObject[1], localObject[2]);
      }
      if (localObject.length > 1) {
        return new Locale(localObject[0], localObject[1]);
      }
      if (localObject.length == 1) {
        return new Locale(localObject[0]);
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Can not parse language tag: [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    label192:
    return new Locale(paramString);
  }
  
  static String toLanguageTag(Locale paramLocale)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocale.getLanguage());
    String str = paramLocale.getCountry();
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append("-");
      localStringBuilder.append(paramLocale.getCountry());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.LocaleHelper
 * JD-Core Version:    0.7.0.1
 */