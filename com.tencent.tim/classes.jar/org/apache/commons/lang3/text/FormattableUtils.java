package org.apache.commons.lang3.text;

import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

public class FormattableUtils
{
  private static final String SIMPLEST_FORMAT = "%s";
  
  public static Formatter append(CharSequence paramCharSequence, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3)
  {
    return append(paramCharSequence, paramFormatter, paramInt1, paramInt2, paramInt3, ' ', null);
  }
  
  public static Formatter append(CharSequence paramCharSequence, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3, char paramChar)
  {
    return append(paramCharSequence, paramFormatter, paramInt1, paramInt2, paramInt3, paramChar, null);
  }
  
  public static Formatter append(CharSequence paramCharSequence1, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3, char paramChar, CharSequence paramCharSequence2)
  {
    int i = 1;
    boolean bool;
    StringBuilder localStringBuilder;
    if ((paramCharSequence2 == null) || (paramInt3 < 0) || (paramCharSequence2.length() <= paramInt3))
    {
      bool = true;
      Validate.isTrue(bool, "Specified ellipsis '%1$s' exceeds precision of %2$s", new Object[] { paramCharSequence2, Integer.valueOf(paramInt3) });
      localStringBuilder = new StringBuilder(paramCharSequence1);
      if ((paramInt3 >= 0) && (paramInt3 < paramCharSequence1.length()))
      {
        paramCharSequence2 = (CharSequence)ObjectUtils.defaultIfNull(paramCharSequence2, "");
        localStringBuilder.replace(paramInt3 - paramCharSequence2.length(), paramCharSequence1.length(), paramCharSequence2.toString());
      }
      if ((paramInt1 & 0x1) != 1) {
        break label172;
      }
      paramInt3 = i;
      label130:
      paramInt1 = localStringBuilder.length();
      label136:
      if (paramInt1 >= paramInt2) {
        break label184;
      }
      if (paramInt3 == 0) {
        break label178;
      }
    }
    label172:
    label178:
    for (i = paramInt1;; i = 0)
    {
      localStringBuilder.insert(i, paramChar);
      paramInt1 += 1;
      break label136;
      bool = false;
      break;
      paramInt3 = 0;
      break label130;
    }
    label184:
    paramFormatter.format(localStringBuilder.toString(), new Object[0]);
    return paramFormatter;
  }
  
  public static Formatter append(CharSequence paramCharSequence1, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence2)
  {
    return append(paramCharSequence1, paramFormatter, paramInt1, paramInt2, paramInt3, ' ', paramCharSequence2);
  }
  
  public static String toString(Formattable paramFormattable)
  {
    return String.format("%s", new Object[] { paramFormattable });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.FormattableUtils
 * JD-Core Version:    0.7.0.1
 */