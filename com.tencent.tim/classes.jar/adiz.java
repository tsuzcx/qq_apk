import android.annotation.TargetApi;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class adiz
{
  public static String a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    return paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bup + File.separator;
  }
  
  @TargetApi(18)
  public static boolean adY()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String b(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        return "";
      }
      String str = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
      paramArCloudConfigInfo = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf + str + File.separator;
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      QLog.i("AREngine_ARResouceDir", 2, "get3DModelUnzipDir error " + paramArCloudConfigInfo.getMessage());
    }
    return "";
  }
  
  public static String c(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        return "";
      }
      String str1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
      String str2 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bup;
      paramArCloudConfigInfo = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf + str1 + File.separator + str2;
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      QLog.i("AREngine_ARResouceDir", 2, "get3DModelLuaFilePath error " + paramArCloudConfigInfo.getMessage());
    }
    return "";
  }
  
  public static String d(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        return "";
      }
      String str = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.bum;
      if (TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.buo)) {
        return "";
      }
      paramArCloudConfigInfo = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf + str + File.separator + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.buo;
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      QLog.i("AREngine_ARResouceDir", 2, "get3DModelMusicFilePath error " + paramArCloudConfigInfo.getMessage());
    }
    return "";
  }
  
  public static String e(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      paramArCloudConfigInfo = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf + ((ArVideoResourceInfo)paramArCloudConfigInfo.uk.get(0)).videoMd5 + "_model.zip";
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      QLog.i("AREngine_ARResouceDir", 2, "getVideoFilePath error " + paramArCloudConfigInfo.getMessage());
    }
    return "";
  }
  
  public static String jN(String paramString)
  {
    return sl() + "ar_cloud_transfer/" + paramString + File.separator;
  }
  
  public static String sC()
  {
    return sl() + "ar_relationship/";
  }
  
  public static String sl()
  {
    if (adY()) {
      return aqul.getSDKPrivatePath(acbn.SDCARD_PATH);
    }
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ARResouceDir", 2, "no_sdcard");
    }
    float f = aqhq.getAvailableInnernalMemorySize();
    if ((f < 15728640.0F) && (QLog.isColorLevel())) {
      QLog.i("AREngine_ARResouceDir", 2, "inner memory avail may not enough : " + f);
    }
    return BaseApplicationImpl.sApplication.getFilesDir().getAbsolutePath() + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adiz
 * JD-Core Version:    0.7.0.1
 */