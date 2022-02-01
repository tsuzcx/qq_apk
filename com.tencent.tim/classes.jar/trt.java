public class trt
{
  private static int depthPastMaxDepth;
  private static String[] sections;
  private static long[] startTimeNs;
  private static int traceDepth;
  private static boolean traceEnabled;
  
  public static void beginSection(String paramString)
  {
    if (!traceEnabled) {
      return;
    }
    if (traceDepth == 20)
    {
      depthPastMaxDepth += 1;
      return;
    }
    sections[traceDepth] = paramString;
    startTimeNs[traceDepth] = System.nanoTime();
    traceDepth += 1;
  }
  
  public static float endSection(String paramString)
  {
    if (depthPastMaxDepth > 0) {
      depthPastMaxDepth -= 1;
    }
    while (!traceEnabled) {
      return 0.0F;
    }
    traceDepth -= 1;
    if (traceDepth == -1) {
      throw new IllegalStateException("Can't end trace section. There are none.");
    }
    if (!paramString.equals(sections[traceDepth])) {
      throw new IllegalStateException("Unbalanced trace call " + paramString + ". Expected " + sections[traceDepth] + ".");
    }
    return (float)(System.nanoTime() - startTimeNs[traceDepth]) / 1000000.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trt
 * JD-Core Version:    0.7.0.1
 */