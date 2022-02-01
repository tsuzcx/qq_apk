import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;

public class ure
{
  public static int a;
  public static String a;
  public static String b;
  public static String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "1522415138827987";
    int j = a();
    if (j == -1) {}
    for (int i = 760;; i = j)
    {
      jdField_a_of_type_Int = i;
      QZLog.d("WeishiHeaderConst", 4, "appversion:" + j);
      jdField_a_of_type_Int = 760;
      b = "";
      c = "";
      return;
    }
  }
  
  static int a()
  {
    String str = QUA.getQUA3();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ure
 * JD-Core Version:    0.7.0.1
 */