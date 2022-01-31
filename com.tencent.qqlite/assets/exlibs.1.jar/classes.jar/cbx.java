import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

public class cbx
  implements View.OnClickListener
{
  public cbx(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0);
    if ((this.a instanceof SearchContactsActivity))
    {
      this.a.l();
      return;
    }
    SearchBaseActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbx
 * JD-Core Version:    0.7.0.1
 */