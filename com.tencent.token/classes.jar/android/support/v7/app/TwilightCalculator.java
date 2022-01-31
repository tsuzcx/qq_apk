package android.support.v7.app;

class TwilightCalculator
{
  private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.1047198F;
  private static final float C1 = 0.0334196F;
  private static final float C2 = 0.000349066F;
  private static final float C3 = 5.236E-006F;
  public static final int DAY = 0;
  private static final float DEGREES_TO_RADIANS = 0.01745329F;
  private static final float J0 = 0.0009F;
  public static final int NIGHT = 1;
  private static final float OBLIQUITY = 0.40928F;
  private static final long UTC_2000 = 946728000000L;
  private static TwilightCalculator sInstance;
  public int state;
  public long sunrise;
  public long sunset;
  
  static TwilightCalculator getInstance()
  {
    if (sInstance == null) {
      sInstance = new TwilightCalculator();
    }
    return sInstance;
  }
  
  public void calculateTwilight(long paramLong, double paramDouble1, double paramDouble2)
  {
    float f1 = (float)(paramLong - 946728000000L) / 86400000.0F;
    float f2 = 6.24006F + 0.01720197F * f1;
    double d1 = f2 + 0.03341960161924362D * Math.sin(f2) + 0.0003490659873933D * Math.sin(2.0F * f2) + 5.236000106378924E-006D * Math.sin(3.0F * f2) + 1.796593063D + 3.141592653589793D;
    paramDouble2 = -paramDouble2 / 360.0D;
    double d2 = (float)Math.round(f1 - 0.0009F - paramDouble2) + 0.0009F;
    paramDouble2 = Math.sin(f2) * 0.0053D + (paramDouble2 + d2) + -0.0069D * Math.sin(2.0D * d1);
    d1 = Math.asin(Math.sin(d1) * Math.sin(0.4092797040939331D));
    double d4 = 0.0174532923847437D * paramDouble1;
    paramDouble1 = Math.sin(-0.1047197580337524D);
    d2 = Math.sin(d4);
    double d3 = Math.sin(d1);
    d4 = Math.cos(d4);
    paramDouble1 = (paramDouble1 - d2 * d3) / (Math.cos(d1) * d4);
    if (paramDouble1 >= 1.0D)
    {
      this.state = 1;
      this.sunset = -1L;
      this.sunrise = -1L;
      return;
    }
    if (paramDouble1 <= -1.0D)
    {
      this.state = 0;
      this.sunset = -1L;
      this.sunrise = -1L;
      return;
    }
    f1 = (float)(Math.acos(paramDouble1) / 6.283185307179586D);
    this.sunset = (Math.round((f1 + paramDouble2) * 86400000.0D) + 946728000000L);
    this.sunrise = (Math.round((paramDouble2 - f1) * 86400000.0D) + 946728000000L);
    if ((this.sunrise < paramLong) && (this.sunset > paramLong))
    {
      this.state = 0;
      return;
    }
    this.state = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.TwilightCalculator
 * JD-Core Version:    0.7.0.1
 */