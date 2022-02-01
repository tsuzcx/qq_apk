import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import java.util.List;

class wjy
  implements BluetoothProfile.ServiceListener
{
  wjy(wjx paramwjx, AudioPlayerBase paramAudioPlayerBase, String paramString, int paramInt, BluetoothAdapter paramBluetoothAdapter) {}
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramBluetoothProfile = (BluetoothHeadset)paramBluetoothProfile;
      localObject = paramBluetoothProfile.getConnectedDevices();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label86;
      }
      localObject = (BluetoothDevice)((List)localObject).get(0);
      if (localObject != null) {
        break label75;
      }
      paramInt = 0;
    }
    label75:
    label86:
    for (AudioPlayerBase.bNK = paramInt;; AudioPlayerBase.bNK = 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayerBase.seekPlay(this.val$sourcePath, this.val$offset);
      this.jdField_b_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, paramBluetoothProfile);
      return;
      paramInt = ((BluetoothDevice)localObject).getBluetoothClass().getDeviceClass();
      break;
    }
  }
  
  public void onServiceDisconnected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wjy
 * JD-Core Version:    0.7.0.1
 */