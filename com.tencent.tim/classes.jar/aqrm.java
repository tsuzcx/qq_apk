public class aqrm
{
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    paramString6 = new StringBuilder();
    paramString6.append(paramString1).append("|");
    paramString6.append(paramString2).append("|");
    paramString6.append(paramString3).append("|");
    paramString6.append(paramString4).append("|");
    paramString6.append(paramString5).append("|");
    paramString6.append(paramString7).append("|");
    paramString6.append(paramString8).append("|");
    paramString6.append(paramString9).append("|");
    paramString6.append(paramString10);
    annx.b(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_errorcode_report", paramString6.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrm
 * JD-Core Version:    0.7.0.1
 */