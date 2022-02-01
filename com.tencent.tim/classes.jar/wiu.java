public class wiu
{
  private static wiu a;
  public int bNE = 0;
  private int bNF = -1;
  
  /* Error */
  public static wiu a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	wiu:a	Lwiu;
    //   6: ifnonnull +22 -> 28
    //   9: new 2	wiu
    //   12: dup
    //   13: invokespecial 22	wiu:<init>	()V
    //   16: putstatic 21	wiu:a	Lwiu;
    //   19: getstatic 21	wiu:a	Lwiu;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 21	wiu:a	Lwiu;
    //   31: iconst_1
    //   32: putfield 15	wiu:bNE	I
    //   35: goto -16 -> 19
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	localwiu	wiu
    //   38	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	38	finally
    //   19	23	38	finally
    //   28	35	38	finally
  }
  
  public int vH()
  {
    if (-1 == this.bNF)
    {
      if ((aqgz.getSystemTotalMemory() >>> 20 <= 1390L) || (aqgz.getCpuNumber() <= 3) || (aqgz.getCpuFrequency() <= 1433L)) {
        break label48;
      }
      this.bNF = 1;
    }
    for (;;)
    {
      return this.bNF;
      label48:
      if ((aqgz.getSystemTotalMemory() >>> 20 > 926L) && (aqgz.getCpuNumber() > 1) && (aqgz.getCpuFrequency() > 961L)) {
        this.bNF = 2;
      } else {
        this.bNF = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wiu
 * JD-Core Version:    0.7.0.1
 */