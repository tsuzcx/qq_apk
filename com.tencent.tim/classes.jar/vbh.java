import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;

class vbh
  extends acfd
{
  vbh(vbg paramvbg) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (!this.this$0.toUin.equals(paramSetting.uin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Avatar", 2, "onGetHeadInfo: uin=" + paramSetting.uin);
      }
    } while ((!this.this$0.aWM) || (paramSetting.url == null) || (paramSetting.url.length() <= 0));
    this.this$0.a(paramSetting.uin, paramSetting.bFaceFlags, paramSetting.url);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (!this.this$0.toUin.equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, "onUpdateCustomHead: uin=" + paramString);
    }
    this.this$0.f(this.this$0.c);
    if (paramBoolean)
    {
      this.this$0.a(this.this$0.c, false);
      this.this$0.g(this.this$0.c);
      return;
    }
    this.this$0.c.state = 2;
    this.this$0.g(this.this$0.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbh
 * JD-Core Version:    0.7.0.1
 */