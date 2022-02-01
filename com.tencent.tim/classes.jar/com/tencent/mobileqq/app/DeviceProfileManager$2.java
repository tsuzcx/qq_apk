package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import aqlw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class DeviceProfileManager$2
  implements Runnable
{
  DeviceProfileManager$2(DeviceProfileManager paramDeviceProfileManager, ConfigurationService.RespGetConfig paramRespGetConfig, String paramString) {}
  
  public void run()
  {
    ConfigurationService.Config localConfig = (ConfigurationService.Config)this.a.config_list.get(0);
    Object localObject1 = localConfig.content_list;
    QLog.i("DeviceProfileManager", 1, "onDPCResponse is called, version=" + localConfig.version.get());
    if (localObject1 != null) {}
    boolean bool1;
    int i;
    SharedPreferences.Editor localEditor1;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor2;
    HashMap localHashMap;
    label262:
    Object localObject9;
    DeviceProfileManager.b.a locala;
    Object localObject8;
    Object localObject7;
    Object localObject6;
    label465:
    boolean bool2;
    for (;;)
    {
      try
      {
        if (((PBRepeatField)localObject1).size() != 0)
        {
          bool1 = TextUtils.isEmpty(this.val$uin);
          if (!bool1) {}
        }
        else
        {
          return;
        }
        ??? = new HashMap();
        i = 0;
        if (i < ((PBRepeatField)localObject1).size())
        {
          if (this.this$0.b((String)((PBRepeatField)localObject1).get(i), (HashMap)???)) {
            break label843;
          }
          QLog.e("DeviceProfileManager", 1, "onDPCResponse parseDPCXML error, so return");
          break label843;
        }
        Iterator localIterator = ((HashMap)???).entrySet().iterator();
        localEditor1 = aqlw.b(BaseApplicationImpl.getApplication(), "dpcConfig").edit();
        localSharedPreferences = aqlw.b(BaseApplicationImpl.getApplication(), "dpcConfig_account");
        localEditor2 = localSharedPreferences.edit();
        localObject1 = null;
        localObject8 = DeviceProfileManager.a().iJ;
      }
      catch (Exception localException) {}finally
      {
        QLog.i("DeviceProfileManager", 1, "onDPCResponse finally， hasChanged=" + false);
        DeviceProfileManager.a(this.this$0, false);
      }
      localObject7 = DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a(), (String)localObject9);
      localObject6 = localObject3;
      bool1 = true;
      ??? = localEditor2;
      DeviceProfileManager.a(this.this$0, QLog.isColorLevel(), 1, new Object[] { localObject9, locala.toString(), Boolean.valueOf(bool1) });
      if (localObject6 != null)
      {
        DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject6).get(localObject7);
        bool1 = false;
        localObject9 = localDPCConfigInfo;
        if (localDPCConfigInfo == null)
        {
          bool1 = true;
          localObject8 = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject8).get(localObject7);
          if ((localObject8 != null) && (((DeviceProfileManager.DPCConfigInfo)localObject8).clone() != null)) {
            localObject9 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject8).clone();
          }
        }
        else
        {
          DeviceProfileManager.a(this.this$0, QLog.isColorLevel(), 3, new Object[] { localObject7, localObject9, Boolean.valueOf(bool1) });
          bool2 = DeviceProfileManager.b((DeviceProfileManager.DPCConfigInfo)localObject9, locala.value.toString().trim());
          if (!bool1) {
            break label850;
          }
          ((HashMap)localObject6).put(localObject7, localObject9);
          break label850;
        }
      }
    }
    for (;;)
    {
      label631:
      ((SharedPreferences.Editor)???).putString((String)localObject7, locala.value);
      label843:
      label850:
      do
      {
        DeviceProfileManager.a(this.this$0, QLog.isColorLevel(), 4, new Object[] { localObject7, localObject9, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        break label262;
        localObject8 = DeviceProfileManager.b(this.this$0);
        localObject6 = localHashMap;
        localObject7 = localObject9;
        bool1 = false;
        ??? = localEditor1;
        break label465;
        synchronized (this.this$0)
        {
          DeviceProfileManager.a(this.this$0, localHashMap);
          if ((DeviceProfileManager.a() != null) && (DeviceProfileManager.a().app != null) && (this.val$uin != null) && (this.val$uin.equals(DeviceProfileManager.a().app.getCurrentAccountUin()))) {
            DeviceProfileManager.a().iI = localObject3;
          }
          bool1 = DeviceProfileManager.a(this.this$0, localConfig, localEditor1, localSharedPreferences, localEditor2);
          QLog.i("DeviceProfileManager", 1, "onDPCResponse finally， hasChanged=" + bool1);
          DeviceProfileManager.a(this.this$0, bool1);
          return;
        }
        i += 1;
        break;
        if (bool1) {
          break label631;
        }
      } while (!bool2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceProfileManager.2
 * JD-Core Version:    0.7.0.1
 */