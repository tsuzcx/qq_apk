import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class zdu
  implements QQPermissionCallback
{
  zdu(zdf paramzdf) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion denied sd grant");
    aqha.a(zdf.a(this.this$0), new zdv(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion user grant");
    zdf.a(this.this$0, zdf.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdu
 * JD-Core Version:    0.7.0.1
 */