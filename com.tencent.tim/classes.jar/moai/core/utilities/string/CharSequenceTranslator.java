package moai.core.utilities.string;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

abstract class CharSequenceTranslator
{
  static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String hex(int paramInt)
  {
    return Integer.toHexString(paramInt).toUpperCase(Locale.ENGLISH);
  }
  
  public abstract int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException;
  
  public final String translate(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter(paramCharSequence.length() * 2);
      translate(paramCharSequence, localStringWriter);
      paramCharSequence = localStringWriter.toString();
      return paramCharSequence;
    }
    catch (IOException paramCharSequence)
    {
      throw new RuntimeException(paramCharSequence);
    }
  }
  
  public final void translate(CharSequence paramCharSequence, Writer paramWriter)
    throws IOException
  {
    if (paramWriter == null) {
      throw new IllegalArgumentException("The Writer must not be null");
    }
    if (paramCharSequence == null) {}
    for (;;)
    {
      return;
      int k = paramCharSequence.length();
      int i = 0;
      while (i < k)
      {
        int m = translate(paramCharSequence, i, paramWriter);
        int j;
        if (m == 0)
        {
          char c = paramCharSequence.charAt(i);
          paramWriter.write(c);
          j = i + 1;
          i = j;
          if (Character.isHighSurrogate(c))
          {
            i = j;
            if (j < k)
            {
              c = paramCharSequence.charAt(j);
              i = j;
              if (Character.isLowSurrogate(c))
              {
                paramWriter.write(c);
                i = j + 1;
              }
            }
          }
        }
        else
        {
          j = 0;
          while (j < m)
          {
            i += Character.charCount(Character.codePointAt(paramCharSequence, i));
            j += 1;
          }
        }
      }
    }
  }
  
  public final CharSequenceTranslator with(CharSequenceTranslator... paramVarArgs)
  {
    CharSequenceTranslator[] arrayOfCharSequenceTranslator = new CharSequenceTranslator[paramVarArgs.length + 1];
    arrayOfCharSequenceTranslator[0] = this;
    System.arraycopy(paramVarArgs, 0, arrayOfCharSequenceTranslator, 1, paramVarArgs.length);
    return new AggregateTranslator(arrayOfCharSequenceTranslator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.string.CharSequenceTranslator
 * JD-Core Version:    0.7.0.1
 */