import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class afle
  implements ajdq<EmoticonPackage>
{
  afle(aflb paramaflb, afpu paramafpu) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.d.imageType = paramEmoticonPackage.type;
      afpu localafpu = this.d;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localafpu.isAPNG = bool;
      }
    }
    for (;;)
    {
      aflb.a(this.this$0).a(this.d);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.d.imageType);
      }
      return;
      bool = false;
      break;
      this.d.imageType = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afle
 * JD-Core Version:    0.7.0.1
 */