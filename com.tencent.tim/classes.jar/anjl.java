import com.tencent.qphone.base.util.QLog;

public class anjl
{
  private static long[] aA = new long[20];
  private static long[] aB = new long[20];
  private static long[] aD = new long[20];
  private static long[] aE = new long[20];
  private static long[] aF = new long[20];
  private static long[] az = new long[20];
  private static volatile boolean bSG;
  private static boolean cHr;
  public static boolean cHs;
  public static String cem = "";
  private static int dIm;
  private static int dIn;
  private static int dIo;
  private static int dIp;
  private static int dIq;
  private static int dIr;
  public static int dIs;
  public static int dIt;
  
  public static void aBh()
  {
    long l2 = 0L;
    int j = 0;
    if ((dIq > 5) && (!cHr))
    {
      cHr = true;
      int i;
      long l1;
      double d;
      if (dIm > 0)
      {
        i = 0;
        l1 = 0L;
        while (i < dIm)
        {
          l1 += aA[i];
          i += 1;
        }
        d = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[FaceTotalTime=" + d + "ms] avg=" + d / dIm);
        }
        anjk.aT("sv_filter_face_track", d / dIm);
      }
      if (dIn > 0)
      {
        i = 0;
        l1 = 0L;
        while (i < dIn)
        {
          l1 += aB[i];
          i += 1;
        }
        d = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[FilterTotalTime=" + d + "ms] avg=" + d / dIn);
        }
        anjk.aT("sv_filter_draw_frame", d / dIn);
      }
      if (dIo > 0)
      {
        i = 0;
        l1 = 0L;
        while (i < dIo)
        {
          l1 += aD[i];
          i += 1;
        }
        d = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowTotalDrawTime=" + d + "ms] avg=" + d / dIo);
        }
        anjk.aT("sv_filter_total_draw", d / dIo);
      }
      if (dIp > 0)
      {
        i = 0;
        l1 = 0L;
        while (i < dIp)
        {
          l1 += aE[i];
          i += 1;
        }
        d = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowNoFilterTotalDrawTime=" + d + "ms] avg=" + d / dIp);
        }
        anjk.aT("sv_filter_no_filter_total_draw", d / dIp);
      }
      if (dIq > 0)
      {
        l1 = l2;
        i = j;
        while (i < dIq)
        {
          l1 += aF[i];
          i += 1;
        }
        d = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowTotalTime=" + d + "ms] avg=" + d / dIq);
        }
        anjk.aT("sv_filter_total_process_frame", d / dIq);
      }
      if (dIt == 0) {
        dIt = 1;
      }
      anjk.aT("sv_filter_track_ratio", dIs * 1000 / dIt);
    }
  }
  
  public static void aU(String paramString, long paramLong)
  {
    if (!cem.equals(paramString))
    {
      dIo = 0;
      cem = paramString;
    }
    if ((bSG) && (dIo < 20))
    {
      paramString = aD;
      int i = dIo;
      dIo = i + 1;
      paramString[i] = paramLong;
    }
  }
  
  public static void dQK()
  {
    if (!bSG) {
      dIr += 1;
    }
    if (dIr >= 5) {
      bSG = true;
    }
  }
  
  public static void lp(long paramLong)
  {
    if ((bSG) && (dIn < 20))
    {
      long[] arrayOfLong = aB;
      int i = dIn;
      dIn = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void lq(long paramLong)
  {
    if ((bSG) && (dIp < 20))
    {
      long[] arrayOfLong = aE;
      int i = dIp;
      dIp = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
  
  public static void lr(long paramLong)
  {
    if ((bSG) && (dIq < 20))
    {
      long[] arrayOfLong = aF;
      int i = dIq;
      dIq = i + 1;
      arrayOfLong[i] = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjl
 * JD-Core Version:    0.7.0.1
 */