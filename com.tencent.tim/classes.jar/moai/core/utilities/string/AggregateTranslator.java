package moai.core.utilities.string;

import java.io.IOException;
import java.io.Writer;

class AggregateTranslator
  extends CharSequenceTranslator
{
  private final CharSequenceTranslator[] translators;
  
  public AggregateTranslator(CharSequenceTranslator... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      this.translators = null;
      return;
    }
    this.translators = ((CharSequenceTranslator[])paramVarArgs.clone());
  }
  
  public <T> T[] clone(T[] paramArrayOfT)
  {
    if (paramArrayOfT == null) {
      return null;
    }
    return (Object[])paramArrayOfT.clone();
  }
  
  public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException
  {
    CharSequenceTranslator[] arrayOfCharSequenceTranslator = this.translators;
    int j = arrayOfCharSequenceTranslator.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfCharSequenceTranslator[i].translate(paramCharSequence, paramInt, paramWriter);
      if (k != 0) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.string.AggregateTranslator
 * JD-Core Version:    0.7.0.1
 */