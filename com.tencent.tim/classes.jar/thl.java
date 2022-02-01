public final class thl
{
  private static volatile boolean initialized;
  
  public static int ew(int paramInt)
  {
    switch (paramInt)
    {
    case -5: 
    case -4: 
    case -3: 
    case -1: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      return 1;
    case 0: 
      return 0;
    case -2: 
      return 3;
    case -6: 
      return 6;
    case -7: 
      return 13;
    }
    return 207;
  }
  
  public static void init()
  {
    tkw.i("GdtArkUtil", String.format("init %b", new Object[] { Boolean.valueOf(initialized) }));
    if (initialized) {
      return;
    }
    try
    {
      if (initialized) {
        return;
      }
    }
    finally {}
    initialized = true;
    adta.GI(true);
    adta.cUm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thl
 * JD-Core Version:    0.7.0.1
 */