import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity.a;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class qfq
  implements AbsListView.e
{
  int Hy = 0;
  int blT = 0;
  int blU = 0;
  
  public qfq(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.Hy = paramInt1;
    this.blT = paramInt2;
    this.blU = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.Hy + this.blT >= this.blU))
    {
      if (this.this$0.aDf) {
        this.this$0.wi(3);
      }
    }
    else {
      return;
    }
    this.this$0.wi(1);
    QQStoryWatcherListActivity.a.a(this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfq
 * JD-Core Version:    0.7.0.1
 */