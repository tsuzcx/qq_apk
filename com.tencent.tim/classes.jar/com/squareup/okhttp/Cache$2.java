package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Cache$2
  implements Iterator<String>
{
  boolean canRemove;
  final Iterator<DiskLruCache.Snapshot> delegate = Cache.access$600(this.this$0).snapshots();
  String nextUrl;
  
  Cache$2(Cache paramCache)
    throws IOException
  {}
  
  /* Error */
  public boolean hasNext()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/squareup/okhttp/Cache$2:nextUrl	Ljava/lang/String;
    //   4: ifnull +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 47	com/squareup/okhttp/Cache$2:canRemove	Z
    //   14: aload_0
    //   15: getfield 39	com/squareup/okhttp/Cache$2:delegate	Ljava/util/Iterator;
    //   18: invokeinterface 49 1 0
    //   23: ifeq +54 -> 77
    //   26: aload_0
    //   27: getfield 39	com/squareup/okhttp/Cache$2:delegate	Ljava/util/Iterator;
    //   30: invokeinterface 53 1 0
    //   35: checkcast 55	com/squareup/okhttp/internal/DiskLruCache$Snapshot
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_0
    //   42: invokevirtual 59	com/squareup/okhttp/internal/DiskLruCache$Snapshot:getSource	(I)Lokio/Source;
    //   45: invokestatic 65	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   48: invokeinterface 71 1 0
    //   53: putfield 45	com/squareup/okhttp/Cache$2:nextUrl	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 74	com/squareup/okhttp/internal/DiskLruCache$Snapshot:close	()V
    //   60: iconst_1
    //   61: ireturn
    //   62: astore_2
    //   63: aload_1
    //   64: invokevirtual 74	com/squareup/okhttp/internal/DiskLruCache$Snapshot:close	()V
    //   67: goto -53 -> 14
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 74	com/squareup/okhttp/internal/DiskLruCache$Snapshot:close	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.Cache.2
 * JD-Core Version:    0.7.0.1
 */