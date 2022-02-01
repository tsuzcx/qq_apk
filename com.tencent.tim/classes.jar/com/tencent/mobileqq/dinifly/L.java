package com.tencent.mobileqq.dinifly;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class L
{
  public static boolean DBG = false;
  private static final int MAX_DEPTH = 20;
  public static final String TAG = "LOTTIE";
  private static int depthPastMaxDepth = 0;
  private static final Set<String> loggedMessages = new HashSet();
  private static String[] sections;
  private static long[] startTimeNs;
  private static int traceDepth;
  private static boolean traceEnabled = false;
  
  static
  {
    traceDepth = 0;
  }
  
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
    TraceCompat.beginSection(paramString);
    traceDepth += 1;
  }
  
  public static void debug(String paramString)
  {
    if (DBG) {
      Log.d("LOTTIE", paramString);
    }
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
    TraceCompat.endSection();
    return (float)(System.nanoTime() - startTimeNs[traceDepth]) / 1000000.0F;
  }
  
  public static void setTraceEnabled(boolean paramBoolean)
  {
    if (traceEnabled == paramBoolean) {}
    do
    {
      return;
      traceEnabled = paramBoolean;
    } while (!traceEnabled);
    sections = new String[20];
    startTimeNs = new long[20];
  }
  
  public static void warn(String paramString)
  {
    if (loggedMessages.contains(paramString)) {
      return;
    }
    Log.w("LOTTIE", paramString);
    loggedMessages.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.L
 * JD-Core Version:    0.7.0.1
 */