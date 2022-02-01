import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment;
import com.tencent.biz.richframework.part.BasePartFragment;

public class vnh
  extends RecyclerView.OnScrollListener
{
  public vnh(QCirclePersonalBaseBottomFragment paramQCirclePersonalBaseBottomFragment) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.a.a().a().a("personal_page_action_title_bar_hide_follow_animation", Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnh
 * JD-Core Version:    0.7.0.1
 */