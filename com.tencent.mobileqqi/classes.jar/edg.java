import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class edg
  implements View.OnClickListener
{
  public edg(SearchResultDialog paramSearchResultDialog) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    SearchResultDialog.a(this.a).a(SearchResultDialog.a(this.a), paramView, i, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     edg
 * JD-Core Version:    0.7.0.1
 */