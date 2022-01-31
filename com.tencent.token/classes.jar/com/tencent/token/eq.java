package com.tencent.token;

import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.QQUser;
import java.util.ArrayList;

public class eq
{
  static eq d = null;
  public MbInfoResult a;
  String b;
  long c;
  
  public static eq a()
  {
    if (d == null)
    {
      d = new eq();
      return d;
    }
    return d;
  }
  
  public int a(int paramInt)
  {
    for (;;)
    {
      try
      {
        MbInfoResult localMbInfoResult = c();
        if (localMbInfoResult == null)
        {
          paramInt = -1;
          return paramInt;
        }
        int i;
        if (this.a.mMbInfoItems == null)
        {
          paramInt = -1;
          continue;
          if (i < this.a.mMbInfoItems.size())
          {
            int j = ((MbInfoResult.MbInfoItem)this.a.mMbInfoItems.get(i)).mId;
            if (j == paramInt) {
              paramInt = i;
            } else {
              i += 1;
            }
          }
          else
          {
            paramInt = -1;
          }
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
  }
  
  public void a(MbInfoResult paramMbInfoResult)
  {
    try
    {
      this.a = paramMbInfoResult;
      do.a();
      this.b = do.c;
      if (do.a().e() != null) {
        this.c = do.a().e().mUin;
      }
      return;
    }
    finally
    {
      paramMbInfoResult = finally;
      throw paramMbInfoResult;
    }
  }
  
  public void b()
  {
    try
    {
      this.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public MbInfoResult c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 56	com/tencent/token/do:a	()Lcom/tencent/token/do;
    //   7: invokevirtual 64	com/tencent/token/do:e	()Lcom/tencent/token/core/bean/QQUser;
    //   10: astore_3
    //   11: aload_2
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 60	com/tencent/token/eq:b	Ljava/lang/String;
    //   17: ifnull +20 -> 37
    //   20: aload_2
    //   21: astore_1
    //   22: aload_3
    //   23: ifnull +14 -> 37
    //   26: aload_0
    //   27: getfield 28	com/tencent/token/eq:a	Lcom/tencent/token/core/bean/MbInfoResult;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +9 -> 41
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aload_0
    //   42: getfield 60	com/tencent/token/eq:b	Ljava/lang/String;
    //   45: astore 4
    //   47: invokestatic 56	com/tencent/token/do:a	()Lcom/tencent/token/do;
    //   50: pop
    //   51: aload_2
    //   52: astore_1
    //   53: aload 4
    //   55: getstatic 58	com/tencent/token/do:c	Ljava/lang/String;
    //   58: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifeq -24 -> 37
    //   64: aload_2
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 71	com/tencent/token/eq:c	J
    //   70: aload_3
    //   71: getfield 69	com/tencent/token/core/bean/QQUser:mUin	J
    //   74: lcmp
    //   75: ifne -38 -> 37
    //   78: aload_0
    //   79: getfield 28	com/tencent/token/eq:a	Lcom/tencent/token/core/bean/MbInfoResult;
    //   82: astore_1
    //   83: goto -46 -> 37
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	eq
    //   12	71	1	localObject1	Object
    //   86	4	1	localObject2	Object
    //   1	64	2	localObject3	Object
    //   10	61	3	localQQUser	QQUser
    //   45	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	11	86	finally
    //   13	20	86	finally
    //   26	31	86	finally
    //   41	51	86	finally
    //   53	64	86	finally
    //   66	83	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eq
 * JD-Core Version:    0.7.0.1
 */