package kotlin.text;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"equals", "", "", "other", "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/CharsKt")
class CharsKt__CharKt
  extends CharsKt__CharJVMKt
{
  public static final boolean equals(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    if (paramChar1 == paramChar2) {}
    do
    {
      return true;
      if (!paramBoolean) {
        return false;
      }
    } while ((Character.toUpperCase(paramChar1) == Character.toUpperCase(paramChar2)) || (Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2)));
    return false;
  }
  
  public static final boolean isSurrogate(char paramChar)
  {
    if (55296 > paramChar) {}
    while (57343 < paramChar) {
      return false;
    }
    return true;
  }
  
  @InlineOnly
  private static final String plus(char paramChar, String paramString)
  {
    return String.valueOf(paramChar) + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.CharsKt__CharKt
 * JD-Core Version:    0.7.0.1
 */