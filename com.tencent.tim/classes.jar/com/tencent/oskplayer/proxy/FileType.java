package com.tencent.oskplayer.proxy;

import android.text.TextUtils;
import com.tencent.oskplayer.util.Base16;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class FileType
{
  public static final FileType OCTET_STREAM;
  public static final FileType UNKNOWN = new FileType("unknown");
  private static final byte[] UNKNOWN_UTF8_BYTES = { 117, 110, 107, 110, 111, 119, 110 };
  public static final FileType VIDEO_MP4;
  private static final String charset = "UTF-8";
  public static HashMap<String, FileType> sEncodeFileTypeCacheMap = new HashMap();
  String encodeBase16PlainType;
  String plainType;
  
  static
  {
    OCTET_STREAM = new FileType("application/octet-stream");
    VIDEO_MP4 = new FileType("video/mp4");
  }
  
  private FileType(String paramString)
  {
    this.plainType = paramString;
  }
  
  public static FileType decode(String paramString)
  {
    if (sEncodeFileTypeCacheMap.containsKey(paramString)) {
      return (FileType)sEncodeFileTypeCacheMap.get(paramString);
    }
    FileType localFileType = getFileType(decodeBase16(paramString));
    sEncodeFileTypeCacheMap.put(paramString, localFileType);
    return localFileType;
  }
  
  private static String decodeBase16(String paramString)
  {
    try
    {
      paramString = new String(Base16.decode(paramString), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return UNKNOWN.toString();
  }
  
  private static String encodeBase16(String paramString)
  {
    try
    {
      paramString = Base16.encode(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return Base16.encode(UNKNOWN_UTF8_BYTES);
  }
  
  public static FileType getFileType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return UNKNOWN;
    }
    if (paramString.equals("video/mp4")) {
      return VIDEO_MP4;
    }
    if (paramString.equals("unknown")) {
      return UNKNOWN;
    }
    return new FileType(paramString);
  }
  
  public String encode()
  {
    if (TextUtils.isEmpty(this.encodeBase16PlainType))
    {
      this.encodeBase16PlainType = encodeBase16(this.plainType);
      return this.encodeBase16PlainType;
    }
    return this.encodeBase16PlainType;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FileType)paramObject;
      if (this.plainType == null) {
        break;
      }
    } while (this.plainType.equals(paramObject.plainType));
    while (paramObject.plainType != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    if (this.plainType != null) {
      return this.plainType.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return this.plainType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.FileType
 * JD-Core Version:    0.7.0.1
 */