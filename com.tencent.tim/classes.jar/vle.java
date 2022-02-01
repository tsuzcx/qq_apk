import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class vle
  extends aibn
{
  public vle(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void aR(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (!paramBoolean1)
    {
      this.this$0.cf(2131719890, 1);
      return;
    }
    PermisionPrivacyActivity.a(this.this$0, this.this$0.an.a(), paramBoolean2);
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (paramBoolean2) {
      i = 2;
    }
    anot.a(localQQAppInterface, "dc00898", "", "", "0X8009D11", "0X8009D11", 0, 0, String.valueOf(i), "", "", "");
  }
  
  protected void aS(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.this$0, this.this$0.an.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vle
 * JD-Core Version:    0.7.0.1
 */