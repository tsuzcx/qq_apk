package com.tencent.token;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

class hf
  extends ThreadLocal
{
  protected DateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
    localSimpleDateFormat.setLenient(false);
    localSimpleDateFormat.setTimeZone(gn.g);
    return localSimpleDateFormat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hf
 * JD-Core Version:    0.7.0.1
 */