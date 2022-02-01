import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

class vvl
  implements Comparator<String>
{
  vvl(vvk paramvvk, String paramString) {}
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      String str2 = paramString1.substring(this.jdField_a_of_type_JavaLangString.length(), paramString1.indexOf(".jpg"));
      String str1 = paramString2.substring(this.jdField_a_of_type_JavaLangString.length(), paramString2.indexOf(".jpg"));
      paramString1 = str2;
      if (TextUtils.isEmpty(str2)) {
        paramString1 = "0";
      }
      paramString2 = str1;
      if (TextUtils.isEmpty(str1)) {
        paramString2 = "0";
      }
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (l1 - l2 < 0L) {
        return 1;
      }
      return -1;
    }
    catch (Exception paramString1)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "sort exception:" + paramString1.toString());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvl
 * JD-Core Version:    0.7.0.1
 */