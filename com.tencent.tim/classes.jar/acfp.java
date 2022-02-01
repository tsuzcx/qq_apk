import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class acfp
{
  public static BaseApplicationImpl a = BaseApplicationImpl.sApplication;
  
  public static String aE(int paramInt)
  {
    String[] arrayOfString = d(paramInt);
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      return arrayOfString[0];
    }
    QLog.d("HardCodeUtil", 2, "qq arr first str， strArr is null");
    return "";
  }
  
  public static String[] d(int paramInt)
  {
    String str = Integer.toHexString(paramInt);
    String[] arrayOfString = a.getResources().getStringArray(paramInt);
    QLog.d("HardCodeUtil", 2, "hardcodeResId:" + paramInt + ", hexVal:" + str + ", retStr:" + Arrays.toString(arrayOfString));
    return arrayOfString;
  }
  
  public static String m(int paramInt)
  {
    try
    {
      String str = a.getResources().getString(paramInt);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acfp
 * JD-Core Version:    0.7.0.1
 */