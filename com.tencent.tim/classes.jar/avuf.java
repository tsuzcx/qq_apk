public class avuf
{
  private static String cNO;
  
  public static String GB()
  {
    if (cNO != null) {
      return cNO;
    }
    return "";
  }
  
  public static void aap(String paramString)
  {
    cNO = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avuf
 * JD-Core Version:    0.7.0.1
 */