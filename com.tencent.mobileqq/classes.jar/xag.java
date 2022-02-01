import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class xag
  implements AbsListView.OnScrollListener
{
  public xag(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.b = paramInt1;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xag
 * JD-Core Version:    0.7.0.1
 */