import android.content.Intent;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class elt
  extends ContactBindObserver
{
  public elt(RebindActivity paramRebindActivity) {}
  
  protected void c(boolean paramBoolean)
  {
    this.a.d();
    if (paramBoolean)
    {
      Intent localIntent = new Intent(this.a, BindVerifyActivity.class);
      localIntent.putExtra("k_number", this.a.d);
      localIntent.putExtra("kBindType", RebindActivity.a(this.a));
      this.a.startActivityForResult(localIntent, 1);
      return;
    }
    this.a.b(2131562782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     elt
 * JD-Core Version:    0.7.0.1
 */