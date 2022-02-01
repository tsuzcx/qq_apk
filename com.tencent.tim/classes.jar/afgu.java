public class afgu
{
  public static int cQP = 300;
  
  public static String aV(String paramString1, String paramString2)
  {
    if ((aqmr.isEmpty(paramString1)) || (aqmr.isEmpty(paramString2))) {
      return "";
    }
    paramString2 = arwu.toMD5(paramString2);
    return acbn.bme + paramString2 + paramString1;
  }
  
  public static String kz(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("_");
    if (paramString.length > 2) {
      return paramString[1];
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgu
 * JD-Core Version:    0.7.0.1
 */