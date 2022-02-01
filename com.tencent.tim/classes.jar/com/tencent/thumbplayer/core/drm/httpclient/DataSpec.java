package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class DataSpec
{
  public static final int FLAG_ALLOW_CACHE_FRAGMENTATION = 16;
  public static final int FLAG_ALLOW_GZIP = 1;
  public static final int FLAG_ALLOW_ICY_METADATA = 2;
  public static final int FLAG_DONT_CACHE_IF_LENGTH_UNKNOWN = 4;
  public static final int HTTP_METHOD_DELETE = 5;
  public static final int HTTP_METHOD_GET = 1;
  public static final int HTTP_METHOD_HEAD = 3;
  public static final int HTTP_METHOD_POST = 2;
  public static final int HTTP_METHOD_PUT = 4;
  public final long absoluteStreamPosition;
  public final int flags;
  @Nullable
  public final byte[] httpBody;
  public final int httpMethod;
  @Nullable
  public final String key;
  public final long length;
  public final long position;
  public final Uri uri;
  
  public DataSpec(Uri paramUri, int paramInt)
  {
    this(paramUri, paramInt, 0);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, int paramInt2)
  {
    this(paramUri, paramInt1, 0L, -1L, null, paramInt2);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, long paramLong1, long paramLong2, long paramLong3, @Nullable String paramString, int paramInt2)
  {
    this(paramUri, paramInt1, null, paramLong1, paramLong2, paramLong3, paramString, paramInt2);
  }
  
  public DataSpec(Uri paramUri, int paramInt, long paramLong1, long paramLong2, @Nullable String paramString)
  {
    this(paramUri, paramInt, paramLong1, paramLong1, paramLong2, paramString, 0);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, long paramLong1, long paramLong2, @Nullable String paramString, int paramInt2)
  {
    this(paramUri, paramInt1, paramLong1, paramLong1, paramLong2, paramString, paramInt2);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, @Nullable byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, @Nullable String paramString, int paramInt2)
  {
    boolean bool;
    if (paramLong1 >= 0L)
    {
      bool = true;
      Assertions.checkArgument(bool);
      if (paramLong2 < 0L) {
        break label119;
      }
      bool = true;
      label29:
      Assertions.checkArgument(bool);
      if ((paramLong3 <= 0L) && (paramLong3 != -1L)) {
        break label125;
      }
      bool = true;
      label53:
      Assertions.checkArgument(bool);
      this.uri = paramUri;
      this.httpMethod = paramInt1;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
        break label131;
      }
    }
    for (;;)
    {
      this.httpBody = paramArrayOfByte;
      this.absoluteStreamPosition = paramLong1;
      this.position = paramLong2;
      this.length = paramLong3;
      this.key = paramString;
      this.flags = paramInt2;
      return;
      bool = false;
      break;
      label119:
      bool = false;
      break label29;
      label125:
      bool = false;
      break label53;
      label131:
      paramArrayOfByte = null;
    }
  }
  
  public static String getStringForHttpMethod(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AssertionError(paramInt);
    case 1: 
      return "GET";
    case 2: 
      return "POST";
    case 3: 
      return "HEAD";
    case 4: 
      return "PUT";
    }
    return "DELETE";
  }
  
  public String getHttpMethodString()
  {
    return getStringForHttpMethod(this.httpMethod);
  }
  
  public boolean isFlagSet(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public DataSpec subrange(long paramLong)
  {
    long l = -1L;
    if (this.length == -1L) {}
    for (;;)
    {
      return subrange(paramLong, l);
      l = this.length - paramLong;
    }
  }
  
  public DataSpec subrange(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (this.length == paramLong2)) {
      return this;
    }
    return new DataSpec(this.uri, this.httpMethod, this.httpBody, this.absoluteStreamPosition + paramLong1, this.position + paramLong1, paramLong2, this.key, this.flags);
  }
  
  public String toString()
  {
    return "DataSpec[" + getHttpMethodString() + " " + this.uri + ", " + Arrays.toString(this.httpBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
  }
  
  public DataSpec withUri(Uri paramUri)
  {
    return new DataSpec(paramUri, this.httpMethod, this.httpBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags);
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Flags {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HttpMethod {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DataSpec
 * JD-Core Version:    0.7.0.1
 */