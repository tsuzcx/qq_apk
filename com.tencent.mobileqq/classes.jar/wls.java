import com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class wls
  implements AbsListView.OnScrollListener
{
  public wls(MyVideoVisibleTroopPageView paramMyVideoVisibleTroopPageView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a = paramInt1;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wls
 * JD-Core Version:    0.7.0.1
 */