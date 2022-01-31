import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager.RoomInfoListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;
import java.util.Map;

public class yvk
  implements AVManager.RoomInfoListener
{
  public yvk(AVEngineWalper paramAVEngineWalper) {}
  
  public void a()
  {
    QLog.e("AVEngineWalper", 1, "onExitRoomComplete");
    if (this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
      this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("AVEngineWalper", 1, "onRoomDisconnect   result=" + paramInt + ", errinfo=" + paramString);
    if (this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
      this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.c(paramInt, paramString);
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString)
  {
    int k = paramArrayOfString.length;
    int j = 0;
    String str;
    if (j < k)
    {
      str = paramArrayOfString[j];
      QLog.i("AVEngineWalper", 1, String.format("onEndpointsUpdateInfo|eventid=%d, id=%s", new Object[] { Integer.valueOf(paramInt), str }));
      if (!this.a.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
        break label237;
      }
    }
    label237:
    for (int i = ((Integer)this.a.jdField_a_of_type_JavaUtilMap.get(str)).intValue();; i = 0)
    {
      switch (paramInt)
      {
      default: 
        label116:
        if (i != 0) {
          this.a.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(i));
        }
        break;
      }
      for (;;)
      {
        j += 1;
        break;
        i |= 0x20;
        break label116;
        i &= 0xFFFFFFDF;
        break label116;
        i |= 0x1;
        break label116;
        i &= 0xFFFFFFFE;
        break label116;
        if (this.a.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
          this.a.jdField_a_of_type_JavaUtilMap.remove(str);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
        this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.a(paramInt, paramArrayOfString);
      }
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    QLog.e("AVEngineWalper", 1, "onSemiAutoRecvCameraVideo");
    if (this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
      this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.a(paramArrayOfString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvk
 * JD-Core Version:    0.7.0.1
 */