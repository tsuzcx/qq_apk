public class ainc
{
  private static int bjK;
  private static int cdN;
  public static int dea = 1;
  public static int deb = 2;
  
  public static void PT(int paramInt)
  {
    bjK = deb;
    anot.a(null, "dc00898", "", "", "0X80097F0", "0X80097F0", id(paramInt), 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void PU(int paramInt)
  {
    bjK = dea;
    cdN = 3;
    anot.a(null, "dc00898", "", "", "0X80097F1", "0X80097F1", id(paramInt), 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void PV(int paramInt)
  {
    anot.a(null, "dc00898", "", "", "0X80097F2", "0X80097F2", id(paramInt), 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void PW(int paramInt)
  {
    cdN = paramInt;
    anot.a(null, "dc00898", "", "", "0X8009C72", "0X8009C72", cdN, 0, String.valueOf(cdN), "", "", "");
  }
  
  public static void dsW()
  {
    anot.a(null, "dc00898", "", "", "0X80097F3", "0X80097F3", bjK, 0, String.valueOf(bjK), "", "", "");
    anot.a(null, "dc00898", "", "", "0X8009C74", "0X8009C74", cdN, 0, String.valueOf(cdN), "", "", "");
  }
  
  public static void dsX()
  {
    anot.a(null, "dc00898", "", "", "0X80097F4", "0X80097F4", bjK, 0, String.valueOf(bjK), "", "", "");
    anot.a(null, "dc00898", "", "", "0X8009C75", "0X8009C75", cdN, 0, String.valueOf(cdN), "", "", "");
  }
  
  public static void dsY()
  {
    anot.a(null, "dc00898", "", "", "0X8009C73", "0X8009C73", cdN, 0, String.valueOf(cdN), "", "", "");
  }
  
  private static int id(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if ((paramInt == 1) || (paramInt == 3000)) {
      return 2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ainc
 * JD-Core Version:    0.7.0.1
 */