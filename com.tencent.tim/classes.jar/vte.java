import android.view.View;
import com.tencent.mobileqq.activity.SearchMightKnowFragment;
import com.tencent.widget.SwipListView.a;

public class vte
  implements SwipListView.a
{
  public vte(SearchMightKnowFragment paramSearchMightKnowFragment) {}
  
  public void onRightIconMenuHide(View paramView)
  {
    SearchMightKnowFragment.a(this.a, true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    SearchMightKnowFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vte
 * JD-Core Version:    0.7.0.1
 */