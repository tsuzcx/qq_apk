import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2.DiscussionListListener;

public class ydx
  implements View.OnClickListener
{
  public ydx(DiscussionListAdapter2 paramDiscussionListAdapter2) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof ydz)) {}
    do
    {
      return;
      paramView = (ydz)paramView;
    } while ((paramView.a == null) || (this.a.a == null));
    this.a.a.a(paramView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ydx
 * JD-Core Version:    0.7.0.1
 */