import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class edq
  implements View.OnClickListener
{
  public edq(SearchResultDialog paramSearchResultDialog) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    SearchResultDialog.a(this.a).a(SearchResultDialog.b(this.a), paramView, i, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     edq
 * JD-Core Version:    0.7.0.1
 */