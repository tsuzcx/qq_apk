package net.openid.appauth;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

final class AsciiStringListUtil
{
  @Nullable
  public static String iterableToString(@Nullable Iterable<String> paramIterable)
  {
    if (paramIterable == null) {
      return null;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      String str = (String)paramIterable.next();
      if (!TextUtils.isEmpty(str)) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "individual scopes cannot be null or empty");
        localLinkedHashSet.add(str);
        break;
      }
    }
    if (localLinkedHashSet.isEmpty()) {
      return null;
    }
    return TextUtils.join(" ", localLinkedHashSet);
  }
  
  @Nullable
  public static Set<String> stringToSet(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = Arrays.asList(TextUtils.split(paramString, " "));
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramString.size());
    localLinkedHashSet.addAll(paramString);
    return localLinkedHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AsciiStringListUtil
 * JD-Core Version:    0.7.0.1
 */