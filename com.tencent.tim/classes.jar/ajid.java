import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class ajid
  implements AbsListView.e
{
  private boolean coM;
  
  public ajid(MultiAIOItemFragment paramMultiAIOItemFragment, AbsListView.e parame) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.r.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.r.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      paramAbsListView = MultiAIOItemFragment.a(this.this$0);
      if ((paramAbsListView != null) && (paramAbsListView.getCurrentItem() == MultiAIOItemFragment.a(this.this$0)) && (!this.coM))
      {
        MultiAIOFragment.cN("0X8009F80", 0);
        this.coM = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajid
 * JD-Core Version:    0.7.0.1
 */