import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class qfd
  implements AbsListView.e
{
  public qfd(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.Hy = paramInt1;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfd
 * JD-Core Version:    0.7.0.1
 */