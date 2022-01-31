import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

public class cdl
  implements View.OnClickListener
{
  cdl(SearchContactsActivity paramSearchContactsActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof cdm)))
    {
      paramView = (cdm)paramView;
      this.a.a(paramView.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cdl
 * JD-Core Version:    0.7.0.1
 */