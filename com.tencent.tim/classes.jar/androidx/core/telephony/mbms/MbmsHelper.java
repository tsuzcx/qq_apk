package androidx.core.telephony.mbms;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public final class MbmsHelper
{
  @SuppressLint({"BanTargetApiAnnotation"})
  @TargetApi(28)
  @Nullable
  public static CharSequence getBestNameForService(@NonNull Context paramContext, @NonNull ServiceInfo paramServiceInfo)
  {
    if (Build.VERSION.SDK_INT < 28) {}
    do
    {
      return null;
      paramContext = paramContext.getResources().getConfiguration().getLocales();
      i = paramServiceInfo.getNamedContentLocales().size();
    } while (i == 0);
    String[] arrayOfString = new String[i];
    Iterator localIterator = paramServiceInfo.getNamedContentLocales().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfString[i] = ((Locale)localIterator.next()).toLanguageTag();
      i += 1;
    }
    paramContext = paramContext.getFirstMatch(arrayOfString);
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramServiceInfo.getNameForLocale(paramContext)) {
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.telephony.mbms.MbmsHelper
 * JD-Core Version:    0.7.0.1
 */