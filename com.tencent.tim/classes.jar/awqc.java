public class awqc
  implements Cloneable
{
  public int failed;
  public int running;
  public int suspend;
  public int wait;
  
  /* Error */
  public awqc a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 24	java/lang/Object:clone	()Ljava/lang/Object;
    //   6: checkcast 2	awqc
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aconst_null
    //   16: astore_1
    //   17: goto -7 -> 10
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	awqc
    //   9	4	1	localawqc	awqc
    //   14	1	1	localCloneNotSupportedException	java.lang.CloneNotSupportedException
    //   16	1	1	localObject1	Object
    //   20	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	14	java/lang/CloneNotSupportedException
    //   2	10	20	finally
  }
  
  public awqc a(awqb paramawqb, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      switch (paramInt1)
      {
      case 4: 
      default: 
        switch (paramInt2)
        {
        }
        break;
      }
    }
    for (;;)
    {
      try
      {
        paramawqb = a();
        return paramawqb;
      }
      finally {}
      this.wait -= 1;
      break;
      this.running -= 1;
      break;
      this.suspend -= 1;
      break;
      this.failed -= 1;
      break;
      this.wait += 1;
      continue;
      this.running += 1;
      continue;
      this.suspend += 1;
      continue;
      this.failed += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqc
 * JD-Core Version:    0.7.0.1
 */