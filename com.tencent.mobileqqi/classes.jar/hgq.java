import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class hgq
  implements View.OnClickListener
{
  public hgq(GridListView paramGridListView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131233144)).intValue();
    this.a.a.a(this.a, paramView, i, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgq
 * JD-Core Version:    0.7.0.1
 */