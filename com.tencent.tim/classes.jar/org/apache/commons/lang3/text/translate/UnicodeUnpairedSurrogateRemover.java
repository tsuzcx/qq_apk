package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class UnicodeUnpairedSurrogateRemover
  extends CodePointTranslator
{
  public boolean translate(int paramInt, Writer paramWriter)
    throws IOException
  {
    return (paramInt >= 55296) && (paramInt <= 57343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover
 * JD-Core Version:    0.7.0.1
 */