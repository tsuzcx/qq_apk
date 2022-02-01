import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class aehp
{
  private static aehr jdField_a_of_type_Aehr;
  public static aevv a;
  private static HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  static aevq[] jdField_a_of_type_ArrayOfAevq;
  static aevv b;
  public static byte bh = 3;
  public static byte bi = 1;
  private static ArrayList<aehq> listeners;
  private boolean bTY = true;
  
  public aehp(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramQQAppInterface.getHttpCommunicatort();
    jdField_a_of_type_Aehr = new aehr(paramQQAppInterface.getApp(), paramString);
    listeners = new ArrayList();
    jdField_a_of_type_Aevv = new aevv((short)24, (byte)0);
    b = new aevv((short)12, (byte)1);
    jdField_a_of_type_ArrayOfAevq = new aevq[] { jdField_a_of_type_Aevv, b };
    jdField_a_of_type_Aehr.initConfig();
  }
  
  public static aehr a()
  {
    return jdField_a_of_type_Aehr;
  }
  
  public static HttpCommunicator a()
  {
    return jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  }
  
  public static ArrayList<aehq> cP()
  {
    return listeners;
  }
  
  public static void destroy()
  {
    jdField_a_of_type_Aehr = null;
    if (jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null) {
      jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.close();
    }
    jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = null;
  }
  
  public static String getUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public static String h(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new StringBuffer(aehr.ah(paramString1, paramInt).trim());
    if (paramString2 != null)
    {
      paramString2 = paramString2.trim();
      if (paramString2.length() > 0)
      {
        if (paramString2.charAt(0) != '&') {
          paramString1.append('&');
        }
        paramString1.append(paramString2);
      }
    }
    return paramString1.toString();
  }
  
  public String D(int paramInt1, int paramInt2)
  {
    return ((aevv)jdField_a_of_type_ArrayOfAevq[paramInt1]).dW(paramInt2);
  }
  
  public String E(int paramInt1, int paramInt2)
  {
    return ((aevv)jdField_a_of_type_ArrayOfAevq[paramInt1]).dU(paramInt2);
  }
  
  public String F(int paramInt1, int paramInt2)
  {
    return ((aevv)jdField_a_of_type_ArrayOfAevq[paramInt1]).dV(paramInt2);
  }
  
  public short a(int paramInt1, int paramInt2)
  {
    return ((aevv)jdField_a_of_type_ArrayOfAevq[paramInt1]).b(paramInt2);
  }
  
  public Bitmap g(int paramInt1, int paramInt2)
  {
    return ((aevv)jdField_a_of_type_ArrayOfAevq[paramInt1]).l(paramInt2);
  }
  
  public long h(int paramInt1, int paramInt2)
  {
    return ((aevv)jdField_a_of_type_ArrayOfAevq[paramInt1]).E(paramInt2);
  }
  
  public int hc(int paramInt)
  {
    return jdField_a_of_type_ArrayOfAevq[paramInt].CD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aehp
 * JD-Core Version:    0.7.0.1
 */