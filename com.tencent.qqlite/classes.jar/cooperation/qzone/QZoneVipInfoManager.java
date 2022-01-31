package cooperation.qzone;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QZoneVipInfoManager
{
  public static final int a = 2;
  private static QZoneVipInfoManager jdField_a_of_type_CooperationQzoneQZoneVipInfoManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "QZONE_VIP_INFO";
  public static final int b = 0;
  private static final String b = "key_vip_info_pre";
  public static final int c = 1;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  
  public static QZoneVipInfoManager a()
  {
    if (jdField_a_of_type_CooperationQzoneQZoneVipInfoManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneQZoneVipInfoManager == null) {
        jdField_a_of_type_CooperationQzoneQZoneVipInfoManager = new QZoneVipInfoManager();
      }
      return jdField_a_of_type_CooperationQzoneQZoneVipInfoManager;
    }
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  private String a(String paramString)
  {
    return "key_vip_info_pre" + paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneVipInfoManager", 4, "updateVipInfo--vipType:" + paramInt1 + " ,vipLevel:" + paramInt2);
      }
      Object localObject = ReflectedMethods.a(this.jdField_a_of_type_AndroidContentContext, "QZONE_VIP_INFO");
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(a(paramString), a(paramInt1, paramInt2));
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public int[] a(String paramString)
  {
    int[] arrayOfInt = new int[2];
    if (!TextUtils.isEmpty(paramString))
    {
      SharedPreferences localSharedPreferences = ReflectedMethods.a(this.jdField_a_of_type_AndroidContentContext, "QZONE_VIP_INFO");
      if (localSharedPreferences != null)
      {
        paramString = localSharedPreferences.getString(a(paramString), null);
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = paramString.split("&");
          if ((paramString == null) || (paramString.length != 2)) {}
        }
      }
    }
    try
    {
      arrayOfInt[0] = Integer.parseInt(paramString[0]);
      arrayOfInt[1] = Integer.parseInt(paramString[1]);
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneVipInfoManager", 4, "getVipInfos--vipType:" + arrayOfInt[0] + " ,vipLevel:" + arrayOfInt[1]);
      }
      return arrayOfInt;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneVipInfoManager
 * JD-Core Version:    0.7.0.1
 */