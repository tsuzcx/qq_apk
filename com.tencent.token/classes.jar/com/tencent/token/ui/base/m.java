package com.tencent.token.ui.base;

import com.tencent.token.utils.UserTask;

final class m
  extends UserTask
{
  m(DualMsgShowDialog paramDualMsgShowDialog) {}
  
  /* Error */
  private static com.tencent.token.global.d f()
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 27	com/tencent/token/gl:a	(Ljava/lang/String;)V
    //   5: ldc 29
    //   7: invokestatic 27	com/tencent/token/gl:a	(Ljava/lang/String;)V
    //   10: aconst_null
    //   11: areturn
    //   12: astore_0
    //   13: new 31	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   20: ldc 34
    //   22: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 42	java/lang/Exception:toString	()Ljava/lang/String;
    //   29: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 48	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   38: goto -33 -> 5
    //   41: astore_0
    //   42: new 31	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   49: ldc 34
    //   51: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: invokevirtual 42	java/lang/Exception:toString	()Ljava/lang/String;
    //   58: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 48	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   67: goto -57 -> 10
    //   70: astore_0
    //   71: goto -61 -> 10
    //   74: astore_0
    //   75: goto -65 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	14	0	localException1	java.lang.Exception
    //   41	14	0	localException2	java.lang.Exception
    //   70	1	0	localError	java.lang.Error
    //   74	1	0	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	12	java/lang/Exception
    //   5	10	41	java/lang/Exception
    //   0	5	70	java/lang/Error
    //   5	10	70	java/lang/Error
    //   13	38	70	java/lang/Error
    //   42	67	70	java/lang/Error
    //   13	38	74	java/lang/Exception
    //   42	67	74	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.m
 * JD-Core Version:    0.7.0.1
 */