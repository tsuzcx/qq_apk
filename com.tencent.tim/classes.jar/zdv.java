import com.tencent.mobileqq.startup.step.CheckPermission.a;
import com.tencent.qphone.base.util.QLog;

class zdv
  implements CheckPermission.a
{
  zdv(zdu paramzdu) {}
  
  public void bK()
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion show self dialog grant");
  }
  
  public void reject()
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion show self dialog denied");
    zdf.a(this.a.this$0, zdf.b(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdv
 * JD-Core Version:    0.7.0.1
 */