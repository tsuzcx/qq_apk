public class avpq
{
  private static String cMG;
  private static String cMH;
  
  public static String FZ()
  {
    return "V1_AND_SQ_8.3.9_344_TIM_D";
  }
  
  public static String Ga()
  {
    if (cMG == null) {
      cMG = Gb();
    }
    return cMG;
  }
  
  private static String Gb()
  {
    int i = "V1_AND_SQ_8.3.9_344_TIM_D".indexOf("_");
    int k = "V1_AND_SQ_8.3.9_344_TIM_D".lastIndexOf("_");
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (k < 0) {
        j = "V1_AND_SQ_8.3.9_344_TIM_D".length();
      }
      return "V1_AND_SQ_8.3.9_344_TIM_D".substring(i, j);
      i += 1;
    }
  }
  
  public static String getQUA3()
  {
    return "V1_AND_SQ_8.3.9_344_TIM_D";
  }
  
  public static String getVersionForHabo()
  {
    if (cMH == null) {
      cMH = Gb();
    }
    return cMH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avpq
 * JD-Core Version:    0.7.0.1
 */