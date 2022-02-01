import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.activity.phone.SettingActivity2.3;
import com.tencent.mobileqq.app.QQAppInterface;

public class zrh
  extends akwl
{
  public zrh(SettingActivity2.3 param3) {}
  
  protected void ao(boolean paramBoolean, int paramInt)
  {
    if (this.a.this$0.k != null)
    {
      this.a.this$0.app.unRegistObserver(this.a.this$0.k);
      this.a.this$0.k = null;
    }
    this.a.this$0.VI();
    if (paramBoolean)
    {
      if (this.a.this$0.k != null)
      {
        this.a.this$0.app.unRegistObserver(this.a.this$0.k);
        this.a.this$0.k = null;
      }
      this.a.this$0.crt();
      this.a.this$0.setResult(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrh
 * JD-Core Version:    0.7.0.1
 */