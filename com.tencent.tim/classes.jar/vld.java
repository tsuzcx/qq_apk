import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class vld
  extends acfd
{
  public vld(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void onGetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.this$0, this.this$0.am.a(), paramBoolean2);
    }
  }
  
  protected void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.this$0.cf(2131719890, 1);
    }
    PermisionPrivacyActivity.a(this.this$0, this.this$0.am.a(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vld
 * JD-Core Version:    0.7.0.1
 */