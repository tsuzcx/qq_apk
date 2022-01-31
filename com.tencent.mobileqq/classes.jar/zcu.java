import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCConfigInfo;
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

public class zcu
  implements Runnable
{
  public zcu(DeviceProfileManager paramDeviceProfileManager, ConfigurationService.RespGetConfig paramRespGetConfig, String paramString) {}
  
  public void run()
  {
    ConfigurationService.Config localConfig = (ConfigurationService.Config)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$RespGetConfig.config_list.get(0);
    Object localObject1 = localConfig.content_list;
    QLog.i("DeviceProfileManager", 1, "onDPCResponse is called, version=" + localConfig.version.get());
    boolean bool2 = false;
    if (localObject1 != null) {}
    boolean bool1;
    int i;
    Iterator localIterator;
    SharedPreferences.Editor localEditor2;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor3;
    HashMap localHashMap;
    label339:
    break label932;
    label340:
    Object localObject9;
    zcw localzcw;
    label430:
    Object localObject7;
    Object localObject8;
    SharedPreferences.Editor localEditor1;
    label713:
    do
    {
      do
      {
        do
        {
          try
          {
            if (((PBRepeatField)localObject1).size() != 0)
            {
              bool1 = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
              if (!bool1) {}
            }
            else
            {
              QLog.i("DeviceProfileManager", 1, "onDPCResponse finally， hasChanged=" + false);
              this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a(4);
              localObject1 = new Intent("com.tentcent.mobileqq.dpc.broadcast");
              ??? = new Bundle();
              ((Bundle)???).putSerializable("featureMapLV2", DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager));
              if (DeviceProfileManager.a() != null) {
                ((Bundle)???).putSerializable("featureAccountMapLV2", DeviceProfileManager.a().jdField_a_of_type_JavaUtilHashMap);
              }
              ((Intent)localObject1).putExtras((Bundle)???);
              BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
              DeviceProfileManager.a(false);
              return;
            }
            ??? = new HashMap();
            i = 0;
            if (i < ((PBRepeatField)localObject1).size())
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a((String)((PBRepeatField)localObject1).get(i), (HashMap)???)) {
                break label1386;
              }
              QLog.e("DeviceProfileManager", 1, "onDPCResponse parseDPCXML error, so return");
              break label1386;
            }
            localIterator = ((HashMap)???).entrySet().iterator();
            localEditor2 = ReflectedMethods.a(BaseApplicationImpl.getApplication(), "dpcConfig").edit();
            localSharedPreferences = ReflectedMethods.a(BaseApplicationImpl.getApplication(), "dpcConfig_account");
            localEditor3 = localSharedPreferences.edit();
            localObject1 = null;
            Intent localIntent1;
            QLog.i("DeviceProfileManager", 1, "onDPCResponse finally， hasChanged=" + bool1);
          }
          catch (Exception localException1) {}finally
          {
            bool1 = bool2;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a(4);
          ??? = new Intent("com.tentcent.mobileqq.dpc.broadcast");
          localObject7 = new Bundle();
          ((Bundle)localObject7).putSerializable("featureMapLV2", DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager));
          if (DeviceProfileManager.a() != null) {
            ((Bundle)localObject7).putSerializable("featureAccountMapLV2", DeviceProfileManager.a().jdField_a_of_type_JavaUtilHashMap);
          }
          ((Intent)???).putExtras((Bundle)localObject7);
          BaseApplicationImpl.getApplication().sendBroadcast((Intent)???, "com.tencent.msg.permission.pushnotify");
          DeviceProfileManager.a(bool1);
          throw localObject3;
          localObject8 = DeviceProfileManager.a().b;
          bool1 = true;
          ??? = DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a(), (String)localObject9);
          localEditor1 = localEditor3;
          localObject7 = localObject3;
          if (QLog.isColorLevel()) {
            QLog.d("DeviceProfileManager", 2, "onDPCResponse DPCXmlHandler.tempMap: key=" + (String)localObject9 + ", value=" + localzcw.toString() + ", isAccountName=" + bool1);
          }
        } while (localObject7 == null);
        DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject7).get(???);
        bool1 = false;
        localObject9 = localDPCConfigInfo;
        if (localDPCConfigInfo != null) {
          break label824;
        }
        bool1 = true;
        localObject8 = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject8).get(???);
      } while (localObject8 == null);
      localObject9 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject8).clone();
    } while (localObject9 == null);
    label824:
    if (QLog.isDevelopLevel()) {
      QLog.d("DeviceProfileManager", 4, "onDPCResponse tempFeatureMap old value: key=" + (String)??? + " " + localObject9 + ", isAddConfig=" + bool1);
    }
    boolean bool3 = DeviceProfileManager.a((DeviceProfileManager.DPCConfigInfo)localObject9, localzcw.b.toString().trim());
    if (bool1) {
      ((HashMap)localObject7).put(???, localObject9);
    }
    for (;;)
    {
      localEditor1.putString((String)???, localzcw.b);
      label932:
      if (!QLog.isColorLevel()) {
        break label340;
      }
      QLog.d("DeviceProfileManager", 2, "onDPCResponse tempFeatureMap new value: key=" + (String)??? + " " + localObject9 + ", isAddConfig=" + bool1 + ", hasUpdate=" + bool3);
      break label340;
      localObject8 = DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager);
      bool1 = false;
      localObject7 = localHashMap;
      localEditor1 = localEditor2;
      ??? = localObject9;
      break label713;
      int j;
      Intent localIntent2;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager)
      {
        DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager, localHashMap);
        if ((DeviceProfileManager.a() != null) && (DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))) {
          DeviceProfileManager.a().jdField_a_of_type_JavaUtilHashMap = localObject3;
        }
        if (DeviceProfileManager.a() != null)
        {
          localEditor3.putLong(DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface, "last_update_time"), System.currentTimeMillis());
          localEditor3.putInt(DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface, "server_version"), localConfig.version.get());
        }
        i = localSharedPreferences.getInt("key_versioncode", 0);
        j = ApkUtils.a(BaseApplicationImpl.getApplication());
        if (i < j) {
          localEditor3.putInt("key_versioncode", j);
        }
        localEditor2.commit();
        localEditor3.commit();
        bool1 = true;
        bool2 = true;
      }
      break label430;
      label1386:
      i += 1;
      break;
      if (!bool1) {
        if (!bool3) {
          break label339;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcu
 * JD-Core Version:    0.7.0.1
 */