import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import cooperation.qzone.contentbox.QZoneMsgFragment;

public class avtm
  implements AbsListView.e
{
  public avtm(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QZoneMsgFragment.a(this.this$0) != null) {
      QZoneMsgFragment.a(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QZoneMsgFragment.a(this.this$0) != null) {
        QZoneMsgFragment.a(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      QZoneMsgFragment.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtm
 * JD-Core Version:    0.7.0.1
 */