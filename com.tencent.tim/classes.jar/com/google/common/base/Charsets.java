package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.nio.charset.Charset;

@GwtCompatible(emulated=true)
public final class Charsets
{
  @GwtIncompatible
  public static final Charset ISO_8859_1;
  @GwtIncompatible
  public static final Charset US_ASCII = Charset.forName("US-ASCII");
  @GwtIncompatible
  public static final Charset UTF_16 = Charset.forName("UTF-16");
  @GwtIncompatible
  public static final Charset UTF_16BE;
  @GwtIncompatible
  public static final Charset UTF_16LE;
  public static final Charset UTF_8;
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    UTF_8 = Charset.forName("UTF-8");
    UTF_16BE = Charset.forName("UTF-16BE");
    UTF_16LE = Charset.forName("UTF-16LE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Charsets
 * JD-Core Version:    0.7.0.1
 */