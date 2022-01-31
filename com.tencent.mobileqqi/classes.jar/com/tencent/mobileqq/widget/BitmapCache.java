package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;

class BitmapCache
  implements ImageViewTouchBase.Recycler
{
  private final BitmapCache.Entry[] a;
  
  public BitmapCache(int paramInt)
  {
    this.a = new BitmapCache.Entry[paramInt];
    paramInt = 0;
    while (paramInt < this.a.length)
    {
      this.a[paramInt] = new BitmapCache.Entry();
      paramInt += 1;
    }
  }
  
  private BitmapCache.Entry a(int paramInt)
  {
    BitmapCache.Entry[] arrayOfEntry = this.a;
    int j = arrayOfEntry.length;
    int i = 0;
    while (i < j)
    {
      BitmapCache.Entry localEntry = arrayOfEntry[i];
      if (paramInt == localEntry.jdField_a_of_type_Int) {
        return localEntry;
      }
      i += 1;
    }
    return null;
  }
  
  /* Error */
  public Bitmap a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 26	com/tencent/mobileqq/widget/BitmapCache:a	(I)Lcom/tencent/mobileqq/widget/BitmapCache$Entry;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull +12 -> 21
    //   12: aload_2
    //   13: getfield 29	com/tencent/mobileqq/widget/BitmapCache$Entry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: areturn
    //   21: aconst_null
    //   22: astore_2
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	BitmapCache
    //   0	31	1	paramInt	int
    //   7	16	2	localObject1	Object
    //   26	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	26	finally
    //   12	17	26	finally
  }
  
  public void a()
  {
    try
    {
      BitmapCache.Entry[] arrayOfEntry = this.a;
      int j = arrayOfEntry.length;
      int i = 0;
      while (i < j)
      {
        BitmapCache.Entry localEntry = arrayOfEntry[i];
        if (localEntry.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          localEntry.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        }
        localEntry.a();
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    for (;;)
    {
      Object localObject1;
      int j;
      int i;
      try
      {
        localObject1 = a(paramInt);
        if (localObject1 != null) {
          return;
        }
        localObject1 = null;
        BitmapCache.Entry[] arrayOfEntry = this.a;
        int m = arrayOfEntry.length;
        j = 0;
        i = -1;
        if (j >= m) {
          break label137;
        }
        localObject2 = arrayOfEntry[j];
        if (((BitmapCache.Entry)localObject2).jdField_a_of_type_Int == -1)
        {
          if (localObject2 == null) {
            continue;
          }
          if (((BitmapCache.Entry)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null) {
            ((BitmapCache.Entry)localObject2).jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          }
          ((BitmapCache.Entry)localObject2).jdField_a_of_type_Int = paramInt;
          ((BitmapCache.Entry)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          continue;
        }
        k = Math.abs(paramInt - ((BitmapCache.Entry)localObject2).jdField_a_of_type_Int);
      }
      finally {}
      int k;
      if (k > i)
      {
        localObject1 = localObject2;
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
      }
      label137:
      Object localObject2 = localObject1;
    }
  }
  
  /* Error */
  public void a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/tencent/mobileqq/widget/BitmapCache:a	[Lcom/tencent/mobileqq/widget/BitmapCache$Entry;
    //   6: astore 4
    //   8: aload 4
    //   10: arraylength
    //   11: istore_3
    //   12: iconst_0
    //   13: istore_2
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmpge +41 -> 57
    //   19: aload 4
    //   21: iload_2
    //   22: aaload
    //   23: astore 5
    //   25: aload 5
    //   27: getfield 23	com/tencent/mobileqq/widget/BitmapCache$Entry:jdField_a_of_type_Int	I
    //   30: iconst_m1
    //   31: if_icmpeq +19 -> 50
    //   34: aload 5
    //   36: getfield 29	com/tencent/mobileqq/widget/BitmapCache$Entry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   39: astore 5
    //   41: aload 5
    //   43: aload_1
    //   44: if_acmpne +6 -> 50
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: iload_2
    //   51: iconst_1
    //   52: iadd
    //   53: istore_2
    //   54: goto -40 -> 14
    //   57: aload_1
    //   58: invokevirtual 34	android/graphics/Bitmap:recycle	()V
    //   61: goto -14 -> 47
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	BitmapCache
    //   0	69	1	paramBitmap	Bitmap
    //   13	41	2	i	int
    //   11	6	3	j	int
    //   6	14	4	arrayOfEntry	BitmapCache.Entry[]
    //   23	19	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	64	finally
    //   25	41	64	finally
    //   57	61	64	finally
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 26	com/tencent/mobileqq/widget/BitmapCache:a	(I)Lcom/tencent/mobileqq/widget/BitmapCache$Entry;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	BitmapCache
    //   0	28	1	paramInt	int
    //   13	7	2	bool	boolean
    //   7	2	3	localEntry	BitmapCache.Entry
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	23	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BitmapCache
 * JD-Core Version:    0.7.0.1
 */