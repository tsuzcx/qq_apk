import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class dfd
  implements IStatusListener
{
  public dfd(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void a(int paramInt, RichStatus paramRichStatus) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    PermisionPrivacyActivity.a(this.a, this.a.d.a(), paramBoolean);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      PermisionPrivacyActivity.a(this.a, 2131562080);
    }
    PermisionPrivacyActivity.a(this.a, this.a.d.a(), PermisionPrivacyActivity.a(this.a).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dfd
 * JD-Core Version:    0.7.0.1
 */