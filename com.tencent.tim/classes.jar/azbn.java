import com.tencent.qphone.base.util.QLog;

public class azbn
{
  private static long[] aG = new long[20];
  private static long[] aH = new long[20];
  private static long[] aI = new long[20];
  private static long[] aJ = new long[20];
  private static volatile boolean cHr;
  private static volatile boolean cHt;
  private static int dIu;
  private static int dIv;
  private static int dIw;
  private static int dIx;
  
  public static void aBh()
  {
    if ((dIw == 20) && (!cHt))
    {
      if (!cHr) {}
      for (int i = 1;; i = 0)
      {
        cHr = true;
        cHt = true;
        l = 0L;
        j = 0;
        while (j < dIw)
        {
          l += aI[j];
          d = aI[j] / 1000.0D;
          if (QLog.isColorLevel()) {
            QLog.d("SVFilterPreprocessFpsTest", 4, "SVFilterPreprocessFpsTest[FrameBuffer]temp=" + d + "ms framefpsOnce=" + 1000.0D / d);
          }
          j += 1;
        }
      }
      double d = l / 1000.0D / 20.0D;
      if (QLog.isColorLevel()) {
        QLog.d("SVFilterPreprocessFpsTest", 2, "SVFilterPreprocessFpsTest[FrameBuffer]avg=" + d + "ms avgfps=" + 1000.0D / d);
      }
      if (i != 0) {
        azbl.aT("sv_preprocess_frame_buffer", d);
      }
      long l = 0L;
      int j = 0;
      while (j < dIx)
      {
        l += aJ[j];
        d = aJ[j] / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("SVFilterPreprocessFpsTest", 4, "SVFilterPreprocessFpsTest[ClipVideo]temp=" + d + "ms ClipVideoFpsOnce=" + 1000.0D / d);
        }
        j += 1;
      }
      d = l / 1000.0D / 20.0D;
      if (QLog.isColorLevel()) {
        QLog.d("SVFilterPreprocessFpsTest", 2, "SVFilterPreprocessFpsTest[ClipVideo]avg=" + d + "ms avgfps=" + 1000.0D / d);
      }
      if (i != 0) {
        azbl.aT("sv_preprocess_clip_video", d);
      }
      l = 0L;
      j = 0;
      while (j < 20)
      {
        d = (aH[j] - aG[j]) / 1000.0D;
        l = (l + d);
        QLog.d("SVFilterPreprocessFpsTest", 4, "SVFilterPreprocessFpsTest[TotalTime]temp=" + d + "ms InputfpsOnce=" + 1000.0D / d);
        j += 1;
      }
      d = l / 20L;
      QLog.d("SVFilterPreprocessFpsTest", 4, "SVFilterPreprocessFpsTest[TotalTime]avg=" + d + "ms avgInputfps_Process=" + 1000.0D / d);
      if (i != 0) {
        azbl.aT("sv_preprocess_total_time", d);
      }
      d = (aH[19] - aG[0]) / 1000.0D / 20.0D;
      if (QLog.isColorLevel()) {
        QLog.d("SVFilterPreprocessFpsTest", 2, "SVFilterPreprocessFpsTest[TotalTime]avg=" + d + "ms avgInputfps_Camera=" + 1000.0D / d);
      }
    }
  }
  
  public static void dQL()
  {
    dIu = 0;
    dIv = 0;
    dIw = 0;
    cHt = false;
  }
  
  public static void ls(long paramLong)
  {
    if (dIu < 20)
    {
      long[] arrayOfLong = aG;
      int i = dIu;
      dIu = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void lt(long paramLong)
  {
    if (dIv < 20)
    {
      long[] arrayOfLong = aH;
      int i = dIv;
      dIv = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void lu(long paramLong)
  {
    if (dIw < 20)
    {
      long[] arrayOfLong = aI;
      int i = dIw;
      dIw = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void lv(long paramLong)
  {
    if (dIx < 20)
    {
      long[] arrayOfLong = aJ;
      int i = dIx;
      dIx = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azbn
 * JD-Core Version:    0.7.0.1
 */