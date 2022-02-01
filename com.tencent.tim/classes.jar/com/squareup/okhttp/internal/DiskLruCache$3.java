package com.squareup.okhttp.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

class DiskLruCache$3
  implements Iterator<DiskLruCache.Snapshot>
{
  final Iterator<DiskLruCache.Entry> delegate = new ArrayList(DiskLruCache.access$2000(this.this$0).values()).iterator();
  DiskLruCache.Snapshot nextSnapshot;
  DiskLruCache.Snapshot removeSnapshot;
  
  DiskLruCache$3(DiskLruCache paramDiskLruCache) {}
  
  public boolean hasNext()
  {
    if (this.nextSnapshot != null) {
      return true;
    }
    synchronized (this.this$0)
    {
      if (DiskLruCache.access$100(this.this$0)) {
        return false;
      }
      while (this.delegate.hasNext())
      {
        DiskLruCache.Snapshot localSnapshot = ((DiskLruCache.Entry)this.delegate.next()).snapshot();
        if (localSnapshot != null)
        {
          this.nextSnapshot = localSnapshot;
          return true;
        }
      }
      return false;
    }
  }
  
  public DiskLruCache.Snapshot next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    this.removeSnapshot = this.nextSnapshot;
    this.nextSnapshot = null;
    return this.removeSnapshot;
  }
  
  /* Error */
  public void remove()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/squareup/okhttp/internal/DiskLruCache$3:removeSnapshot	Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    //   4: ifnonnull +13 -> 17
    //   7: new 79	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 81
    //   13: invokespecial 84	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 19	com/squareup/okhttp/internal/DiskLruCache$3:this$0	Lcom/squareup/okhttp/internal/DiskLruCache;
    //   21: aload_0
    //   22: getfield 72	com/squareup/okhttp/internal/DiskLruCache$3:removeSnapshot	Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    //   25: invokestatic 90	com/squareup/okhttp/internal/DiskLruCache$Snapshot:access$2100	(Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;)Ljava/lang/String;
    //   28: invokevirtual 93	com/squareup/okhttp/internal/DiskLruCache:remove	(Ljava/lang/String;)Z
    //   31: pop
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 72	com/squareup/okhttp/internal/DiskLruCache$3:removeSnapshot	Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 72	com/squareup/okhttp/internal/DiskLruCache$3:removeSnapshot	Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 72	com/squareup/okhttp/internal/DiskLruCache$3:removeSnapshot	Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	3
    //   38	1	1	localIOException	java.io.IOException
    //   45	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	32	38	java/io/IOException
    //   17	32	45	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.3
 * JD-Core Version:    0.7.0.1
 */