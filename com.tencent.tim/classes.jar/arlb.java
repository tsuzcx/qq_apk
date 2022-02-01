public class arlb
{
  private static int eK = 0;
  private static long mTimestamp;
  
  public static void YZ(int paramInt)
  {
    anot.a(null, "dc00898", "", "", "0X800A496", "0X800A496", paramInt, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void Za(int paramInt)
  {
    eK = paramInt;
    anot.a(null, "dc00898", "", "", "0X800A20B", "0X800A20B", paramInt, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void Zb(int paramInt)
  {
    anot.a(null, "dc00898", "", "", "0X800A87C", "0X800A87C", eK, 0, String.valueOf(paramInt / 1000), "", "", "");
  }
  
  public static void Zc(int paramInt)
  {
    if (mTimestamp == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = mTimestamp;
    mTimestamp = 0L;
    anot.a(null, "dc00898", "", "", "0X800A87D", "0X800A87D", paramInt, 0, String.valueOf((l1 - l2) / 1000L), "", "", "");
  }
  
  public static void Zd(int paramInt)
  {
    if (mTimestamp == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = mTimestamp;
    mTimestamp = 0L;
    anot.a(null, "dc00898", "", "", "0X800A87E", "0X800A87E", paramInt, 0, String.valueOf((l1 - l2) / 1000L), "", "", "");
  }
  
  public static void ejQ()
  {
    mTimestamp = System.currentTimeMillis();
  }
  
  public static void ejR()
  {
    anot.a(null, "dc00898", "", "", "0X800A494", "0X800A494", 0, 0, "", "", "", "");
  }
  
  public static void ejS()
  {
    anot.a(null, "dc00898", "", "", "0X800A495", "0X800A495", 0, 0, "", "", "", "");
  }
  
  public static void ejT()
  {
    anot.a(null, "dc00898", "", "", "0X800A20C", "0X800A20C", 0, 0, "", "", "", "");
    Zc(1);
  }
  
  public static void ejU()
  {
    anot.a(null, "dc00898", "", "", "0X800A20D", "0X800A20D", 0, 0, "", "", "", "");
    Zc(2);
    ejQ();
  }
  
  public static void ejV()
  {
    anot.a(null, "dc00898", "", "", "0X800A20E", "0X800A20E", 0, 0, "", "", "", "");
    Zd(2);
    ejQ();
  }
  
  public static void ejW()
  {
    anot.a(null, "dc00898", "", "", "0X800A20F", "0X800A20F", 0, 0, "", "", "", "");
    Zd(1);
  }
  
  public static void ejX()
  {
    anot.a(null, "dc00898", "", "", "0X800A210", "0X800A210", 0, 0, "", "", "", "");
  }
  
  public static void ejY()
  {
    anot.a(null, "dc00898", "", "", "0X800A87F", "0X800A87F", eK, 0, "", "", "", "");
  }
  
  public static void ejZ()
  {
    anot.a(null, "dc00898", "", "", "0X800A880", "0X800A880", eK, 0, "", "", "", "");
  }
  
  public static void eka()
  {
    anot.a(null, "dc00898", "", "", "0X800A881", "0X800A881", eK, 0, "", "", "", "");
    Zd(1);
  }
  
  public static int kG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      return 1;
    case 1: 
      return 2;
    case 3000: 
      return 4;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlb
 * JD-Core Version:    0.7.0.1
 */