import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class faq
  implements View.OnClickListener
{
  public faq(GridListView paramGridListView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131298476)).intValue();
    this.a.a.a(this.a, paramView, i, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     faq
 * JD-Core Version:    0.7.0.1
 */