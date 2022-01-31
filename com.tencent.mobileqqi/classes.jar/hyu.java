import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import java.util.List;

@TargetApi(11)
public class hyu
  extends hyx
  implements BluetoothProfile.ServiceListener
{
  BluetoothAdapter jdField_a_of_type_AndroidBluetoothBluetoothAdapter = null;
  BluetoothProfile jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
  Context jdField_a_of_type_AndroidContentContext = null;
  TraeAudioManager.DeviceConfigManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = null;
  
  public hyu(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "BluetoohHeadsetCheck";
  }
  
  public void a()
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
    try
    {
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
      {
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {
          this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, " closeProfileProxy:e:" + localException.getMessage());
        }
      }
    }
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    int i;
    int j;
    if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
      j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
      paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + c(i));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + c(j));
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("    EXTRA_DEVICE ").append(paramIntent).append(" ");
        if (paramIntent != null)
        {
          paramContext = paramIntent.getName();
          QLog.w("TRAE", 2, paramContext);
        }
      }
      else
      {
        if (i != 2) {
          break label252;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "   dev:" + paramIntent.getName() + " connected,start sco...");
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", true);
        localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager;
        if (paramIntent == null) {
          break label246;
        }
        paramContext = paramIntent.getName();
        label233:
        ((TraeAudioManager.DeviceConfigManager)localObject).a(paramContext);
      }
    }
    label246:
    label252:
    do
    {
      do
      {
        do
        {
          return;
          paramContext = " ";
          break;
          paramContext = "unkown";
          break label233;
        } while (i != 0);
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", false);
        return;
      } while (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction()));
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
      paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + paramContext);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_STATE " + b(i));
      }
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + b(j));
  }
  
  void a(IntentFilter paramIntentFilter)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " " + a() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
  }
  
  public boolean a()
  {
    List localList;
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null)
    {
      localList = this.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectedDevices();
      if (localList != null) {
        break label23;
      }
    }
    label23:
    while (localList.size() <= 0) {
      return false;
    }
    return true;
  }
  
  @TargetApi(11)
  public boolean a(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramContext == null) || (paramDeviceConfigManager == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " err ctx==null||_devCfg==null");
      }
    }
    do
    {
      do
      {
        return false;
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = paramDeviceConfigManager;
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TRAE", 2, " err getDefaultAdapter fail!");
      return false;
      if ((!this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()) || (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) || (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.getProfileProxy(this.jdField_a_of_type_AndroidContentContext, this, 1))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
    return false;
    AudioDeviceInterface.LogTraceExit();
    return true;
  }
  
  @TargetApi(11)
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    int i = 0;
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile + " profile:" + paramInt + " proxy:" + paramBluetoothProfile);
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) && (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != paramBluetoothProfile))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
      this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = paramBluetoothProfile;
      paramBluetoothProfile = this.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectedDevices();
      if (paramBluetoothProfile != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager;
        if (paramBluetoothProfile.size() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((TraeAudioManager.DeviceConfigManager)localObject).a("DEVICE_BLUETOOTHHEADSET", bool);
          paramInt = i;
          if (QLog.isColorLevel())
          {
            QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + paramBluetoothProfile.size() + " _profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
            paramInt = i;
          }
          while (paramInt < paramBluetoothProfile.size())
          {
            localObject = (BluetoothDevice)paramBluetoothProfile.get(paramInt);
            i = this.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectionState((BluetoothDevice)localObject);
            if (i == 2) {
              this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(((BluetoothDevice)localObject).getName());
            }
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, "   " + paramInt + " " + ((BluetoothDevice)localObject).getName() + " ConnectionState:" + i);
            }
            paramInt += 1;
          }
        }
      }
      if (a()) {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", true);
      }
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  @TargetApi(11)
  public void onServiceDisconnected(int paramInt)
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile + " profile:" + paramInt);
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
      }
      if (a()) {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", false);
      }
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null)
      {
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
    }
    AudioDeviceInterface.LogTraceExit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hyu
 * JD-Core Version:    0.7.0.1
 */