import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.DiscussionView;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;

public class cqf
  implements View.OnClickListener
{
  public cqf(DiscussionListAdapter2 paramDiscussionListAdapter2) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof cqg)) {}
    do
    {
      return;
      paramView = (cqg)paramView;
    } while (paramView.a == null);
    this.a.a.a(paramView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqf
 * JD-Core Version:    0.7.0.1
 */