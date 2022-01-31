import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.plusPanel.AppItemHandler;
import com.tencent.mobileqq.apollo.plusPanel.data.PlusViewHolder;
import com.tencent.mobileqq.apollo.plusPanel.view.PlusRecyclerViewAdapter;
import com.tencent.widget.PopupMenuDialog;

public class ywg
  implements View.OnClickListener
{
  public ywg(PlusRecyclerViewAdapter paramPlusRecyclerViewAdapter) {}
  
  public void onClick(View paramView)
  {
    ((PlusViewHolder)((RecyclerView)paramView.getParent()).getChildViewHolder(paramView)).a.a();
    PlusRecyclerViewAdapter.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywg
 * JD-Core Version:    0.7.0.1
 */