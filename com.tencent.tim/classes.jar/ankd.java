public class ankd
{
  public static long getHeapAllocatedSizeInKb()
  {
    return getRuntimeTotalMemory(1) - getRuntimeFreeMemory(1);
  }
  
  private static long getRuntimeFreeMemory(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().freeMemory();
    case 0: 
      return Runtime.getRuntime().freeMemory();
    case 1: 
      return Runtime.getRuntime().freeMemory() / 1024L;
    }
    return Runtime.getRuntime().freeMemory() / 1024L / 1024L;
  }
  
  public static long getRuntimeRemainSize(int paramInt)
  {
    long l = Runtime.getRuntime().maxMemory() - getHeapAllocatedSizeInKb() * 1024L;
    switch (paramInt)
    {
    case 0: 
    default: 
      return l;
    case 1: 
      return l / 1024L;
    }
    return l / 1048576L;
  }
  
  private static long getRuntimeTotalMemory(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().totalMemory();
    case 0: 
      return Runtime.getRuntime().totalMemory();
    case 1: 
      return Runtime.getRuntime().totalMemory() / 1024L;
    }
    return Runtime.getRuntime().totalMemory() / 1024L / 1024L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankd
 * JD-Core Version:    0.7.0.1
 */