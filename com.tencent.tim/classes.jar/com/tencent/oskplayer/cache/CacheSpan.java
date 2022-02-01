package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.proxy.FileType;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CacheSpan
  implements Comparable<CacheSpan>
{
  private static final String SUFFIX = ".v6.dat";
  private static final String SUFFIX_ESCAPED = "\\.v6\\.dat";
  private static final Pattern cacheFilePattern = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v6\\.dat)$");
  public final File file;
  public final FileType fileType;
  public final boolean isCached;
  public final String key;
  public final long lastAccessTimestamp;
  public final long length;
  public final long position;
  public final long totalLength;
  
  CacheSpan(String paramString, long paramLong1, long paramLong2, long paramLong3, FileType paramFileType, boolean paramBoolean, long paramLong4, File paramFile)
  {
    this.key = paramString;
    this.position = paramLong1;
    this.length = paramLong2;
    this.totalLength = paramLong3;
    this.fileType = paramFileType;
    this.isCached = paramBoolean;
    this.file = paramFile;
    this.lastAccessTimestamp = paramLong4;
  }
  
  public static CacheSpan createCacheEntry(File paramFile)
  {
    Matcher localMatcher = cacheFilePattern.matcher(paramFile.getName());
    if (!localMatcher.matches()) {
      return null;
    }
    return createCacheEntry(localMatcher.group(1), Long.parseLong(localMatcher.group(2)), Long.parseLong(localMatcher.group(3)), FileType.decode(localMatcher.group(4)), Long.parseLong(localMatcher.group(5)), paramFile);
  }
  
  private static CacheSpan createCacheEntry(String paramString, long paramLong1, long paramLong2, FileType paramFileType, long paramLong3, File paramFile)
  {
    return new CacheSpan(paramString, paramLong1, paramFile.length(), paramLong2, paramFileType, true, paramLong3, paramFile);
  }
  
  public static CacheSpan createClosedHole(String paramString, long paramLong1, long paramLong2)
  {
    return new CacheSpan(paramString, paramLong1, paramLong2, -1L, FileType.UNKNOWN, false, -1L, null);
  }
  
  public static CacheSpan createLookup(String paramString, long paramLong)
  {
    return new CacheSpan(paramString, paramLong, -1L, -1L, FileType.UNKNOWN, false, -1L, null);
  }
  
  public static CacheSpan createOpenHole(String paramString, long paramLong)
  {
    return new CacheSpan(paramString, paramLong, -1L, -1L, FileType.UNKNOWN, false, -1L, null);
  }
  
  public static File getCacheFileName(File paramFile, String paramString, long paramLong1, long paramLong2, FileType paramFileType, long paramLong3)
  {
    return new File(paramFile, paramString + "." + paramLong1 + "." + paramLong2 + "." + paramFileType.encode() + "." + paramLong3 + ".v6.dat");
  }
  
  public int compareTo(CacheSpan paramCacheSpan)
  {
    if (!this.key.equals(paramCacheSpan.key)) {
      return this.key.compareTo(paramCacheSpan.key);
    }
    long l = this.position - paramCacheSpan.position;
    if (l == 0L) {
      return 0;
    }
    if (l < 0L) {
      return -1;
    }
    return 1;
  }
  
  public boolean isOpenEnded()
  {
    return this.length == -1L;
  }
  
  public CacheSpan touch()
  {
    long l = System.currentTimeMillis();
    File localFile = getCacheFileName(this.file.getParentFile(), this.key, this.position, this.totalLength, this.fileType, l);
    this.file.renameTo(localFile);
    return createCacheEntry(this.key, this.position, this.totalLength, this.fileType, l, localFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.cache.CacheSpan
 * JD-Core Version:    0.7.0.1
 */