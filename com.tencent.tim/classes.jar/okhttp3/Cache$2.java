package okhttp3;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Snapshot;

class Cache$2
  implements Iterator<String>
{
  boolean canRemove;
  final Iterator<DiskLruCache.Snapshot> delegate = this.this$0.cache.snapshots();
  @Nullable
  String nextUrl;
  
  Cache$2(Cache paramCache)
    throws IOException
  {}
  
  /* Error */
  public boolean hasNext()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
    //   4: ifnull +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 48	okhttp3/Cache$2:canRemove	Z
    //   14: aload_0
    //   15: getfield 40	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
    //   18: invokeinterface 50 1 0
    //   23: ifeq +54 -> 77
    //   26: aload_0
    //   27: getfield 40	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
    //   30: invokeinterface 54 1 0
    //   35: checkcast 56	okhttp3/internal/cache/DiskLruCache$Snapshot
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_0
    //   42: invokevirtual 60	okhttp3/internal/cache/DiskLruCache$Snapshot:getSource	(I)Lokio/Source;
    //   45: invokestatic 66	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   48: invokeinterface 72 1 0
    //   53: putfield 46	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 75	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
    //   60: iconst_1
    //   61: ireturn
    //   62: astore_2
    //   63: aload_1
    //   64: invokevirtual 75	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
    //   67: goto -53 -> 14
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 75	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
    //   75: aload_2
    //   76: athrow
    //   77: iconst_0
    //   78: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	2
    //   38	34	1	localSnapshot	DiskLruCache.Snapshot
    //   62	1	2	localIOException	IOException
    //   70	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	56	62	java/io/IOException
    //   39	56	70	finally
  }
  
  public String next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    String str = this.nextUrl;
    this.nextUrl = null;
    this.canRemove = true;
    return str;
  }
  
  public void remove()
  {
    if (!this.canRemove) {
      throw new IllegalStateException("remove() before next()");
    }
    this.delegate.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Cache.2
 * JD-Core Version:    0.7.0.1
 */