package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import java.util.ArrayList;

public class BitmapPool
{
  private static final String jdField_a_of_type_JavaLangString = "BitmapPool";
  private final int jdField_a_of_type_Int;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList;
  private final boolean jdField_a_of_type_Boolean;
  private final int b;
  private final int c;
  
  public BitmapPool(int paramInt)
  {
    this.b = -1;
    this.c = -1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public BitmapPool(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt3);
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public Bitmap a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/mobileqq/util/BitmapPool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 39	java/util/ArrayList:size	()I
    //   9: istore_1
    //   10: iload_1
    //   11: ifle +21 -> 32
    //   14: aload_0
    //   15: getfield 30	com/tencent/mobileqq/util/BitmapPool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: iload_1
    //   19: iconst_1
    //   20: isub
    //   21: invokevirtual 43	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   24: checkcast 45	android/graphics/Bitmap
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: areturn
    //   32: aconst_null
    //   33: astore_2
    //   34: goto -6 -> 28
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	BitmapPool
    //   9	12	1	i	int
    //   27	7	2	localBitmap	Bitmap
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	37	finally
    //   14	28	37	finally
  }
  
  /* Error */
  public Bitmap a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/mobileqq/util/BitmapPool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 39	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +59 -> 72
    //   16: aload_0
    //   17: getfield 30	com/tencent/mobileqq/util/BitmapPool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 49	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 45	android/graphics/Bitmap
    //   27: astore 4
    //   29: aload 4
    //   31: invokevirtual 52	android/graphics/Bitmap:getWidth	()I
    //   34: iload_1
    //   35: if_icmpne +30 -> 65
    //   38: aload 4
    //   40: invokevirtual 55	android/graphics/Bitmap:getHeight	()I
    //   43: iload_2
    //   44: if_icmpne +21 -> 65
    //   47: aload_0
    //   48: getfield 30	com/tencent/mobileqq/util/BitmapPool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   51: iload_3
    //   52: invokevirtual 43	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   55: checkcast 45	android/graphics/Bitmap
    //   58: astore 4
    //   60: aload_0
    //   61: monitorexit
    //   62: aload 4
    //   64: areturn
    //   65: iload_3
    //   66: iconst_1
    //   67: isub
    //   68: istore_3
    //   69: goto -57 -> 12
    //   72: aconst_null
    //   73: astore 4
    //   75: goto -15 -> 60
    //   78: astore 4
    //   80: aload_0
    //   81: monitorexit
    //   82: aload 4
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	BitmapPool
    //   0	85	1	paramInt1	int
    //   0	85	2	paramInt2	int
    //   11	58	3	i	int
    //   27	47	4	localBitmap	Bitmap
    //   78	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	78	finally
    //   16	60	78	finally
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && ((paramBitmap.getWidth() != this.b) || (paramBitmap.getHeight() != this.c)))
    {
      paramBitmap.recycle();
      return;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramBitmap)) {
        return;
      }
    }
    finally {}
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramBitmap);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.BitmapPool
 * JD-Core Version:    0.7.0.1
 */