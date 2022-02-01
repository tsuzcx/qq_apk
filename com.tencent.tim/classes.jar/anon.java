import com.tencent.av.app.VideoAppInterface;

public class anon
{
  static String RQ;
  private static String TAG = "MultiVideoRichActionReportCollection";
  static boolean YW;
  private static long amF;
  private static long amG;
  private static long amH;
  private static long amI;
  private static String cfv = "";
  private static String cfw = "";
  private static String cfx = "";
  private static String cfy = "";
  static int dKH;
  public static int dKI;
  public static int dKJ;
  public static int dKK;
  private static int dKL;
  
  static
  {
    RQ = "";
    dKI = 1;
    dKJ = 2;
    dKK = 3;
  }
  
  public static void QU(String paramString)
  {
    igd.aH(TAG, String.format("reportClickEvent key = %s, type = %s, roomid = %s", new Object[] { paramString, "", RQ }));
    anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", RQ, "");
  }
  
  public static void QV(String paramString)
  {
    cfv = paramString;
    amF = System.currentTimeMillis();
  }
  
  public static void QW(String paramString)
  {
    if (dKL == dKJ) {
      hx("0X8007F33", paramString);
    }
    for (;;)
    {
      cfw = paramString;
      amG = System.currentTimeMillis();
      return;
      if (dKL == dKK) {
        hx("0X8007F39", paramString);
      }
    }
  }
  
  public static void QX(String paramString)
  {
    if (dKL == dKJ) {
      hx("0X8007F35", paramString);
    }
    for (;;)
    {
      cfx = paramString;
      amH = System.currentTimeMillis();
      return;
      if (dKL == dKK) {
        hx("0X8007F3B", paramString);
      }
    }
  }
  
  public static void QY(String paramString)
  {
    if (dKL == dKJ) {
      hx("0X8007E6A", paramString);
    }
    for (;;)
    {
      cfy = paramString;
      amI = System.currentTimeMillis();
      return;
      if (dKL == dKK) {
        hx("0X8007E66", paramString);
      }
    }
  }
  
  public static void aj(int paramInt, String paramString)
  {
    igd.aH(TAG, String.format("onConnected sessionType = %s, roomid = %s", new Object[] { Integer.valueOf(paramInt), paramString }));
    YW = true;
    RQ = paramString;
    dKH = paramInt;
    RQ = paramString;
    if ((dKH == 4) || (dKH == 3)) {
      dKL = dKK;
    }
    while ((dKH != 2) && (dKH != 1)) {
      return;
    }
    dKL = dKJ;
  }
  
  public static void hx(String paramString1, String paramString2)
  {
    igd.aH(TAG, String.format("reportClickEvent id = %s, type = %s, roomid = %s", new Object[] { paramString1, paramString2, RQ }));
    anot.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", RQ, paramString2);
  }
  
  public static void v(VideoAppInterface paramVideoAppInterface)
  {
    int i = 0;
    if (paramVideoAppInterface != null) {
      i = paramVideoAppInterface.ak("BEAUTY_SKIN");
    }
    if (i > 0) {
      QX(i + "");
    }
    if (dKL == dKJ)
    {
      if (amF == 0L) {
        QU("0X8007F32");
      }
      if (amF == 0L) {
        QU("0X8007F34");
      }
      if (amH == 0L) {
        QU("0X8007F36");
      }
      if (amI == 0L) {
        QU("0X8007E69");
      }
    }
    do
    {
      do
      {
        return;
      } while (dKL != dKK);
      if (amF == 0L) {
        QU("0X8007F38");
      }
      if (amG == 0L) {
        QU("0X8007F3A");
      }
      if (amH == 0L) {
        QU("0X8007F3C");
      }
    } while (amI != 0L);
    QU("0X8007E65");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anon
 * JD-Core Version:    0.7.0.1
 */