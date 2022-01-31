import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCConfigInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class fga
  implements Runnable
{
  public fga(DeviceProfileManager paramDeviceProfileManager, PBRepeatField paramPBRepeatField) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceProfileManager.a, 4, "onDPCResponse is called");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatField == null) || (this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatField.size() == 0)) {}
    while (!DeviceProfileManager.a().compareAndSet(false, true)) {
      return;
    }
    int i = 0;
    label590:
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatField.size())
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a((String)this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatField.get(i)))
          {
            if (QLog.isColorLevel()) {
              QLog.e(DeviceProfileManager.a, 2, "onDPCResponse parseDPCXML error, so return");
            }
            DeviceProfileManager.a().set(false);
            return;
          }
          i += 1;
        }
        else
        {
          SharedPreferences.Editor localEditor2;
          synchronized (this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager)
          {
            Iterator localIterator = fgb.a.entrySet().iterator();
            localEditor2 = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig").edit();
            if (localIterator.hasNext())
            {
              Object localObject1 = (Map.Entry)localIterator.next();
              if (localObject1 == null) {
                continue;
              }
              String str = (String)((Map.Entry)localObject1).getKey();
              fgc localfgc = (fgc)((Map.Entry)localObject1).getValue();
              if (QLog.isColorLevel()) {
                QLog.d(DeviceProfileManager.a, 2, "onDPCResponse DPCXmlHandler.tempMap: key=" + str + ", value=" + localfgc.toString());
              }
              localObject1 = (DeviceProfileManager.DPCConfigInfo)DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager).get(str);
              if (localObject1 != null) {
                break label590;
              }
              localObject1 = (DeviceProfileManager.DPCConfigInfo)DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager).get(str);
              bool = true;
              if (localObject1 == null) {
                continue;
              }
              if (QLog.isDevelopLevel()) {
                QLog.d(DeviceProfileManager.a, 4, "onDPCResponse mFeatureMapLV2 old value: key=" + str + " " + localObject1 + ", isAddConfig=" + bool);
              }
              DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager, (DeviceProfileManager.DPCConfigInfo)localObject1, localfgc.b.toString().trim());
              if (bool) {
                DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager).put(str, localObject1);
              }
              if (QLog.isColorLevel()) {
                QLog.d(DeviceProfileManager.a, 2, "onDPCResponse mFeatureMapLV2 new value: key=" + str + " " + localObject1 + ", isAddConfig=" + bool);
              }
              localEditor2.putString(str, localfgc.b);
              localEditor2.putString(str + "_attachInfo", localfgc.c);
            }
          }
          SharedPreferences.Editor localEditor1;
          boolean bool = false;
        }
      }
      catch (Exception localException)
      {
        return;
        localEditor2.commit();
        fgb.a = null;
        localEditor1 = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        localEditor1.putLong("last_update_time", System.currentTimeMillis());
        localEditor1.commit();
        if (QLog.isColorLevel()) {
          QLog.d(DeviceProfileManager.a, 2, "onDPCResponse KEY_LAST_UPDATE_TIME=" + System.currentTimeMillis());
        }
        return;
      }
      finally
      {
        DeviceProfileManager.a().set(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fga
 * JD-Core Version:    0.7.0.1
 */