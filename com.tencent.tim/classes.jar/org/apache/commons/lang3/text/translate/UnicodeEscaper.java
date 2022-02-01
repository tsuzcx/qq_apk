package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class UnicodeEscaper
  extends CodePointTranslator
{
  private final int above;
  private final int below;
  private final boolean between;
  
  public UnicodeEscaper()
  {
    this(0, 2147483647, true);
  }
  
  protected UnicodeEscaper(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.below = paramInt1;
    this.above = paramInt2;
    this.between = paramBoolean;
  }
  
  public static UnicodeEscaper above(int paramInt)
  {
    return outsideOf(0, paramInt);
  }
  
  public static UnicodeEscaper below(int paramInt)
  {
    return outsideOf(paramInt, 2147483647);
  }
  
  public static UnicodeEscaper between(int paramInt1, int paramInt2)
  {
    return new UnicodeEscaper(paramInt1, paramInt2, true);
  }
  
  public static UnicodeEscaper outsideOf(int paramInt1, int paramInt2)
  {
    return new UnicodeEscaper(paramInt1, paramInt2, false);
  }
  
  protected String toUtf16Escape(int paramInt)
  {
    return "\\u" + hex(paramInt);
  }
  
  public boolean translate(int paramInt, Writer paramWriter)
    throws IOException
  {
    if (this.between)
    {
      if ((paramInt >= this.below) && (paramInt <= this.above)) {}
    }
    else {
      while ((paramInt >= this.below) && (paramInt <= this.above)) {
        return false;
      }
    }
    if (paramInt > 65535) {
      paramWriter.write(toUtf16Escape(paramInt));
    }
    for (;;)
    {
      return true;
      paramWriter.write("\\u");
      paramWriter.write(HEX_DIGITS[(paramInt >> 12 & 0xF)]);
      paramWriter.write(HEX_DIGITS[(paramInt >> 8 & 0xF)]);
      paramWriter.write(HEX_DIGITS[(paramInt >> 4 & 0xF)]);
      paramWriter.write(HEX_DIGITS[(paramInt & 0xF)]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.translate.UnicodeEscaper
 * JD-Core Version:    0.7.0.1
 */