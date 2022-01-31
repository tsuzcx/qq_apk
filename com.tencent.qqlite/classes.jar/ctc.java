import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCConfigInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ctc
  implements Runnable
{
  public ctc(DeviceProfileManager paramDeviceProfileManager, ConfigurationService.RespGetConfig paramRespGetConfig, String paramString) {}
  
  public void run()
  {
    ConfigurationService.Config localConfig = (ConfigurationService.Config)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$RespGetConfig.config_list.get(0);
    ??? = localConfig.content_list;
    if (QLog.isColorLevel()) {
      QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse is called, version=" + localConfig.version.get());
    }
    if (??? != null) {}
    boolean bool1;
    HashMap localHashMap1;
    int i;
    label107:
    Iterator localIterator;
    SharedPreferences.Editor localEditor2;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor3;
    HashMap localHashMap2;
    HashMap localHashMap3;
    break label632;
    label255:
    Object localObject8;
    cte localcte;
    Object localObject7;
    SharedPreferences.Editor localEditor1;
    Object localObject5;
    label418:
    boolean bool2;
    for (;;)
    {
      try
      {
        if (((PBRepeatField)???).size() != 0)
        {
          bool1 = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
          if (!bool1) {}
        }
        else
        {
          return;
        }
        localHashMap1 = new HashMap();
        i = 0;
        if (i < ((PBRepeatField)???).size())
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a((String)((PBRepeatField)???).get(i), localHashMap1))
          {
            if (QLog.isColorLevel()) {
              QLog.e(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse parseDPCXML error, so return");
            }
            return;
          }
          i += 1;
          break label107;
        }
        localIterator = localHashMap1.entrySet().iterator();
        localEditor2 = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig").edit();
        localSharedPreferences = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig_account");
        localEditor3 = localSharedPreferences.edit();
        localObject7 = DeviceProfileManager.a().b;
      }
      catch (Exception localException) {}finally
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a(4);
      }
      bool1 = true;
      ??? = DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a(), (String)localObject8);
      localEditor1 = localEditor3;
      localObject5 = localHashMap3;
      if (QLog.isColorLevel()) {
        QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse DPCXmlHandler.tempMap: key=" + (String)localObject8 + ", value=" + localcte.toString() + ", isAccountName=" + bool1);
      }
      DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)localObject5.get(???);
      bool1 = false;
      localObject8 = localDPCConfigInfo;
      if (localDPCConfigInfo == null)
      {
        bool1 = true;
        localObject7 = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject7).get(???);
        if (localObject7 != null) {
          localObject8 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject7).clone();
        }
      }
      else if (localObject8 != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 4, "onDPCResponse tempFeatureMap old value: key=" + (String)??? + " " + localObject8 + ", isAddConfig=" + bool1);
        }
        bool2 = DeviceProfileManager.a((DeviceProfileManager.DPCConfigInfo)localObject8, localcte.b.toString().trim());
        if (!bool1) {
          break label969;
        }
        localObject5.put(???, localObject8);
        break label969;
      }
    }
    for (;;)
    {
      localEditor1.putString((String)???, localcte.b);
      label632:
      if (!QLog.isColorLevel()) {
        break label255;
      }
      QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse tempFeatureMap new value: key=" + (String)??? + " " + localObject8 + ", isAddConfig=" + bool1 + ", hasUpdate=" + bool2);
      break label255;
      localObject7 = DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager);
      bool1 = false;
      localObject5 = localHashMap2;
      localEditor1 = localEditor2;
      ??? = localObject8;
      break label418;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager)
      {
        DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager, localHashMap2);
        if ((DeviceProfileManager.a() != null) && (DeviceProfileManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(DeviceProfileManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
          DeviceProfileManager.a().jdField_a_of_type_JavaUtilHashMap = localHashMap3;
        }
        localEditor3.putLong(DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "last_update_time"), System.currentTimeMillis());
        localEditor3.putInt(DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "server_version"), localConfig.version.get());
        i = localSharedPreferences.getInt("key_versioncode", 0);
        int j = ApkUtils.a(BaseApplicationImpl.getContext());
        if (i < j) {
          localEditor3.putInt("key_versioncode", j);
        }
        localEditor2.commit();
        localEditor3.commit();
        if (QLog.isColorLevel()) {
          QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse KEY_LAST_UPDATE_TIME=" + System.currentTimeMillis() + ", versioncode=" + j + ", keyVersionCode =" + i);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a(4);
        return;
      }
      label969:
      if (!bool1) {
        if (!bool2) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ctc
 * JD-Core Version:    0.7.0.1
 */