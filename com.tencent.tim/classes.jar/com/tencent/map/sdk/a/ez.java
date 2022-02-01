package com.tencent.map.sdk.a;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class ez
  extends ee<Date>
{
  public static final ef a = new ez.1();
  private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");
  
  private void a(fg paramfg, Date paramDate)
    throws IOException
  {
    if (paramDate == null) {}
    for (paramDate = null;; paramDate = this.b.format(paramDate)) {
      try
      {
        paramfg.b(paramDate);
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  private Date b(fe paramfe)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 53	com/tencent/map/sdk/a/fe:f	()Lcom/tencent/map/sdk/a/ff;
    //   6: getstatic 59	com/tencent/map/sdk/a/ff:i	Lcom/tencent/map/sdk/a/ff;
    //   9: if_acmpne +13 -> 22
    //   12: aload_1
    //   13: invokevirtual 62	com/tencent/map/sdk/a/fe:k	()V
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: new 64	java/sql/Date
    //   25: dup
    //   26: aload_0
    //   27: getfield 29	com/tencent/map/sdk/a/ez:b	Ljava/text/DateFormat;
    //   30: aload_1
    //   31: invokevirtual 67	com/tencent/map/sdk/a/fe:i	()Ljava/lang/String;
    //   34: invokevirtual 71	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   37: invokevirtual 77	java/util/Date:getTime	()J
    //   40: invokespecial 80	java/sql/Date:<init>	(J)V
    //   43: astore_1
    //   44: goto -26 -> 18
    //   47: astore_1
    //   48: new 82	com/tencent/map/sdk/a/eb
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 85	com/tencent/map/sdk/a/eb:<init>	(Ljava/lang/Throwable;)V
    //   56: athrow
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	ez
    //   0	62	1	paramfe	fe
    // Exception table:
    //   from	to	target	type
    //   22	44	47	java/text/ParseException
    //   2	16	57	finally
    //   22	44	57	finally
    //   48	57	57	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ez
 * JD-Core Version:    0.7.0.1
 */