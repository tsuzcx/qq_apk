import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;

public class hzc
  extends hzg
{
  public hzc(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "DEVICE_BLUETOOTHHEADSET";
  }
  
  public void a()
  {
    try
    {
      Thread.sleep(5000L);
      label6:
      int j;
      int i;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a().indexOf("Gear") != -1)
      {
        j = 1;
        if (j == 0) {
          c();
        }
        i = 0;
      }
      for (;;)
      {
        int k;
        StringBuilder localStringBuilder;
        if (this.jdField_a_of_type_Boolean == true)
        {
          k = i + 1;
          if ((i < 10) && (j == 0)) {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder().append("bluetoothHeadsetSwitchThread i:").append(k).append(" sco:");
              if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) {
                break label222;
              }
            }
          }
        }
        label222:
        for (String str = "Y";; str = "N")
        {
          QLog.w("TRAE", 2, str + " :" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a());
          if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) {
            break label229;
          }
          e();
          if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn())
          {
            if ((QLog.isColorLevel()) && (j == 0)) {
              QLog.e("TRAE", 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
            }
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(a(), false);
            a(10);
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.d();
          }
          return;
          j = 0;
          break;
        }
        try
        {
          label229:
          Thread.sleep(1000L);
          i = k;
        }
        catch (InterruptedException localInterruptedException1)
        {
          i = k;
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      break label6;
    }
  }
  
  @TargetApi(8)
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) {
      return;
    }
    d();
  }
  
  @TargetApi(8)
  void c()
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(true);
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
    }
  }
  
  @TargetApi(8)
  void d()
  {
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzc
 * JD-Core Version:    0.7.0.1
 */