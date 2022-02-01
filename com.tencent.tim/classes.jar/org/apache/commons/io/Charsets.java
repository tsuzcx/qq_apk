package org.apache.commons.io;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Charsets
{
  @Deprecated
  public static final Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
  @Deprecated
  public static final Charset US_ASCII = StandardCharsets.US_ASCII;
  @Deprecated
  public static final Charset UTF_16 = StandardCharsets.UTF_16;
  @Deprecated
  public static final Charset UTF_16BE = StandardCharsets.UTF_16BE;
  @Deprecated
  public static final Charset UTF_16LE = StandardCharsets.UTF_16LE;
  @Deprecated
  public static final Charset UTF_8 = StandardCharsets.UTF_8;
  
  public static SortedMap<String, Charset> requiredCharsets()
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    localTreeMap.put(StandardCharsets.ISO_8859_1.name(), StandardCharsets.ISO_8859_1);
    localTreeMap.put(StandardCharsets.US_ASCII.name(), StandardCharsets.US_ASCII);
    localTreeMap.put(StandardCharsets.UTF_16.name(), StandardCharsets.UTF_16);
    localTreeMap.put(StandardCharsets.UTF_16BE.name(), StandardCharsets.UTF_16BE);
    localTreeMap.put(StandardCharsets.UTF_16LE.name(), StandardCharsets.UTF_16LE);
    localTreeMap.put(StandardCharsets.UTF_8.name(), StandardCharsets.UTF_8);
    return Collections.unmodifiableSortedMap(localTreeMap);
  }
  
  public static Charset toCharset(String paramString)
  {
    if (paramString == null) {
      return Charset.defaultCharset();
    }
    return Charset.forName(paramString);
  }
  
  public static Charset toCharset(Charset paramCharset)
  {
    Charset localCharset = paramCharset;
    if (paramCharset == null) {
      localCharset = Charset.defaultCharset();
    }
    return localCharset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.Charsets
 * JD-Core Version:    0.7.0.1
 */