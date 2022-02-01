package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;

class de
  implements da.a
{
  /* Error */
  protected static Typeface a(Context paramContext, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 26	com/tencent/token/df:a	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_0
    //   5: aload_0
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_0
    //   12: aload_1
    //   13: invokestatic 29	com/tencent/token/df:a	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +10 -> 28
    //   21: aload_0
    //   22: invokevirtual 35	java/io/File:delete	()Z
    //   25: pop
    //   26: aconst_null
    //   27: areturn
    //   28: aload_0
    //   29: invokevirtual 39	java/io/File:getPath	()Ljava/lang/String;
    //   32: invokestatic 45	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 35	java/io/File:delete	()Z
    //   40: pop
    //   41: aload_1
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: invokevirtual 35	java/io/File:delete	()Z
    //   48: pop
    //   49: aload_1
    //   50: athrow
    //   51: aload_0
    //   52: invokevirtual 35	java/io/File:delete	()Z
    //   55: pop
    //   56: aconst_null
    //   57: areturn
    //   58: astore_1
    //   59: goto -8 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramContext	Context
    //   0	62	1	paramInputStream	java.io.InputStream
    //   16	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	17	43	finally
    //   28	36	43	finally
    //   11	17	58	java/lang/RuntimeException
    //   28	36	58	java/lang/RuntimeException
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, a<T> parama)
  {
    int i;
    if ((paramInt & 0x1) == 0) {
      i = 400;
    } else {
      i = 700;
    }
    int i1;
    if ((paramInt & 0x2) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int n = paramArrayOfT.length;
    Object localObject = null;
    paramInt = 0;
    int k;
    for (int j = 2147483647; paramInt < n; j = k)
    {
      T ? = paramArrayOfT[paramInt];
      int m = Math.abs(parama.b(?) - i);
      if (parama.a(?) == i1) {
        k = 0;
      } else {
        k = 1;
      }
      m = m * 2 + k;
      if (localObject != null)
      {
        k = j;
        if (j <= m) {}
      }
      else
      {
        localObject = ?;
        k = m;
      }
      paramInt += 1;
    }
    return localObject;
  }
  
  /* Error */
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, java.lang.String paramString, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 26	com/tencent/token/df:a	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_1
    //   12: aload_2
    //   13: iload_3
    //   14: invokestatic 66	com/tencent/token/df:a	(Ljava/io/File;Landroid/content/res/Resources;I)Z
    //   17: istore 6
    //   19: iload 6
    //   21: ifne +10 -> 31
    //   24: aload_1
    //   25: invokevirtual 35	java/io/File:delete	()Z
    //   28: pop
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: invokevirtual 39	java/io/File:getPath	()Ljava/lang/String;
    //   35: invokestatic 45	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   38: astore_2
    //   39: aload_1
    //   40: invokevirtual 35	java/io/File:delete	()Z
    //   43: pop
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: aload_1
    //   48: invokevirtual 35	java/io/File:delete	()Z
    //   51: pop
    //   52: aload_2
    //   53: athrow
    //   54: aload_1
    //   55: invokevirtual 35	java/io/File:delete	()Z
    //   58: pop
    //   59: aconst_null
    //   60: areturn
    //   61: astore_2
    //   62: goto -8 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	de
    //   0	65	1	paramContext	Context
    //   0	65	2	paramResources	Resources
    //   0	65	3	paramInt1	int
    //   0	65	4	paramString	java.lang.String
    //   0	65	5	paramInt2	int
    //   17	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	19	46	finally
    //   31	39	46	finally
    //   11	19	61	java/lang/RuntimeException
    //   31	39	61	java/lang/RuntimeException
  }
  
  public Typeface a(Context paramContext, cv.b paramb, Resources paramResources, int paramInt)
  {
    paramb = (cv.c)a(paramb.a, paramInt, new a() {});
    if (paramb == null) {
      return null;
    }
    return da.a(paramContext, paramResources, paramb.d, paramb.a, paramInt);
  }
  
  /* Error */
  public Typeface a(Context paramContext, ds.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: istore 4
    //   4: aconst_null
    //   5: astore 5
    //   7: iload 4
    //   9: ifgt +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: aload_0
    //   15: aload_2
    //   16: iload_3
    //   17: invokevirtual 96	com/tencent/token/de:a	([Lcom/tencent/token/ds$b;I)Lcom/tencent/token/ds$b;
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 102	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   25: aload_2
    //   26: getfield 107	com/tencent/token/ds$b:a	Landroid/net/Uri;
    //   29: invokevirtual 113	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   32: astore_2
    //   33: aload_1
    //   34: aload_2
    //   35: invokestatic 115	com/tencent/token/de:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   38: astore_1
    //   39: aload_2
    //   40: invokestatic 118	com/tencent/token/df:a	(Ljava/io/Closeable;)V
    //   43: aload_1
    //   44: areturn
    //   45: astore 5
    //   47: aload_2
    //   48: astore_1
    //   49: aload 5
    //   51: astore_2
    //   52: goto +7 -> 59
    //   55: astore_2
    //   56: aload 5
    //   58: astore_1
    //   59: aload_1
    //   60: invokestatic 118	com/tencent/token/df:a	(Ljava/io/Closeable;)V
    //   63: aload_2
    //   64: athrow
    //   65: aconst_null
    //   66: astore_2
    //   67: aload_2
    //   68: invokestatic 118	com/tencent/token/df:a	(Ljava/io/Closeable;)V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_1
    //   74: goto -9 -> 65
    //   77: astore_1
    //   78: goto -11 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	de
    //   0	81	1	paramContext	Context
    //   0	81	2	paramArrayOfb	ds.b[]
    //   0	81	3	paramInt	int
    //   2	6	4	i	int
    //   5	1	5	localObject1	Object
    //   45	12	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	39	45	finally
    //   21	33	55	finally
    //   21	33	73	java/io/IOException
    //   33	39	77	java/io/IOException
  }
  
  protected final ds.b a(ds.b[] paramArrayOfb, int paramInt)
  {
    (ds.b)a(paramArrayOfb, paramInt, new a() {});
  }
  
  static abstract interface a<T>
  {
    public abstract boolean a(T paramT);
    
    public abstract int b(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.de
 * JD-Core Version:    0.7.0.1
 */