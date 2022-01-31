import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2.DiscussionListListener;

public class ynn
  implements View.OnClickListener
{
  public ynn(DiscussionListAdapter2 paramDiscussionListAdapter2) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof ynp)) {}
    do
    {
      return;
      paramView = (ynp)paramView;
    } while ((paramView.a == null) || (this.a.a == null));
    this.a.a.a(paramView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ynn
 * JD-Core Version:    0.7.0.1
 */