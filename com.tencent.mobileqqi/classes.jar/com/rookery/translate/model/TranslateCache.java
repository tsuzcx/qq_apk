package com.rookery.translate.model;

import android.content.Context;

public class TranslateCache
{
  private static final int jdField_a_of_type_Int = 1;
  private static TransDiskCache jdField_a_of_type_ComRookeryTranslateModelTransDiskCache;
  private static TransMemCache jdField_a_of_type_ComRookeryTranslateModelTransMemCache;
  
  /* Error */
  public static TransDiskCache a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	com/rookery/translate/model/TranslateCache:jdField_a_of_type_ComRookeryTranslateModelTransDiskCache	Lcom/rookery/translate/model/TransDiskCache;
    //   6: ifnonnull +67 -> 73
    //   9: aload_0
    //   10: ldc 21
    //   12: invokevirtual 27	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 29	android/app/ActivityManager
    //   18: invokevirtual 33	android/app/ActivityManager:getMemoryClass	()I
    //   21: ldc 34
    //   23: imul
    //   24: bipush 8
    //   26: idiv
    //   27: istore_1
    //   28: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +28 -> 59
    //   34: ldc 42
    //   36: iconst_2
    //   37: new 44	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   44: ldc 47
    //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: new 64	com/rookery/translate/model/TransDiskCache
    //   62: dup
    //   63: aload_0
    //   64: iconst_1
    //   65: iload_1
    //   66: i2l
    //   67: invokespecial 67	com/rookery/translate/model/TransDiskCache:<init>	(Landroid/content/Context;IJ)V
    //   70: putstatic 19	com/rookery/translate/model/TranslateCache:jdField_a_of_type_ComRookeryTranslateModelTransDiskCache	Lcom/rookery/translate/model/TransDiskCache;
    //   73: ldc 2
    //   75: monitorexit
    //   76: getstatic 19	com/rookery/translate/model/TranslateCache:jdField_a_of_type_ComRookeryTranslateModelTransDiskCache	Lcom/rookery/translate/model/TransDiskCache;
    //   79: areturn
    //   80: astore_0
    //   81: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq -11 -> 73
    //   87: ldc 42
    //   89: iconst_2
    //   90: new 44	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   97: ldc 69
    //   99: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: goto -39 -> 73
    //   115: astore_0
    //   116: ldc 2
    //   118: monitorexit
    //   119: aload_0
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	Context
    //   27	39	1	i	int
    // Exception table:
    //   from	to	target	type
    //   59	73	80	java/io/IOException
    //   3	59	115	finally
    //   59	73	115	finally
    //   73	76	115	finally
    //   81	112	115	finally
    //   116	119	115	finally
  }
  
  public static TransMemCache a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_ComRookeryTranslateModelTransMemCache == null) {
        jdField_a_of_type_ComRookeryTranslateModelTransMemCache = new TransMemCache(65536);
      }
      return jdField_a_of_type_ComRookeryTranslateModelTransMemCache;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.rookery.translate.model.TranslateCache
 * JD-Core Version:    0.7.0.1
 */