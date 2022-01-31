import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class bar
  implements IStatusListener
{
  public bar(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void a(int paramInt, RichStatus paramRichStatus) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    PermisionPrivacyActivity.a(this.a, this.a.e.a(), paramBoolean);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      PermisionPrivacyActivity.a(this.a, 2131364036);
    }
    PermisionPrivacyActivity.a(this.a, this.a.e.a(), PermisionPrivacyActivity.a(this.a).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bar
 * JD-Core Version:    0.7.0.1
 */