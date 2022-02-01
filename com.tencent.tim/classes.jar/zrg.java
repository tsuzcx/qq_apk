import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class zrg
  extends akwl
{
  zrg(zrf paramzrf) {}
  
  protected void BT(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SettingActivity2", 2, "onDisableMobileMatch suc[" + paramBoolean + "]");
    }
    this.a.a.this$0.VI();
    this.a.a.this$0.app.unRegistObserver(this);
    if (paramBoolean)
    {
      this.a.a.this$0.crt();
      this.a.a.this$0.setResult(-1);
      return;
    }
    this.a.a.this$0.aL(1, acfp.m(2131714330));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrg
 * JD-Core Version:    0.7.0.1
 */