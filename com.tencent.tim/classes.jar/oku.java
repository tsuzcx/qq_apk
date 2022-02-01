import cooperation.qzone.util.QZLog;

public class oku
{
  public static String accessToken;
  public static int appversion;
  public static String openId;
  public static String person_id = "1522415138827987";
  
  static
  {
    int j = rz();
    if (j == -1) {}
    for (int i = 760;; i = j)
    {
      appversion = i;
      QZLog.d("WeishiHeaderConst", 4, "appversion:" + j);
      appversion = 760;
      openId = "";
      accessToken = "";
      return;
    }
  }
  
  static int rz()
  {
    String str = avpq.getQUA3();
    int i = str.indexOf(".");
    int j = str.lastIndexOf(".");
    if ((j <= i) || (j - i != 2)) {}
    while (i <= 1) {
      return -1;
    }
    try
    {
      i = Integer.parseInt(str.substring(i - 1, j + 2).replace(".", ""));
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oku
 * JD-Core Version:    0.7.0.1
 */