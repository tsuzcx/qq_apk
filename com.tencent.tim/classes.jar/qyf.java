import android.view.View;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class qyf
  implements AbsListView.e
{
  public qyf(MystoryListView paramMystoryListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    int k;
    int m;
    int i;
    if ((this.this$0.y != null) && (MystoryListView.a(this.this$0) != 1) && (paramAbsListView.getCount() != 0))
    {
      if (-MystoryListView.b(this.this$0) > rpq.getWindowScreenHeight(this.this$0.y) * 3) {
        this.this$0.a.te(true);
      }
      if ((paramInt3 == 0) || (!MystoryListView.a(this.this$0))) {
        return;
      }
      View localView = paramAbsListView.getChildAt(0);
      j = localView.getTop();
      k = localView.getBottom();
      m = localView.getHeight();
      if (paramInt1 <= MystoryListView.c(this.this$0)) {
        break label257;
      }
      MystoryListView.b(this.this$0, MystoryListView.d(this.this$0) + MystoryListView.e(this.this$0));
      i = j - MystoryListView.d(this.this$0);
    }
    for (;;)
    {
      MystoryListView.e(this.this$0, MystoryListView.g(this.this$0) + i);
      MystoryListView.f(this.this$0, i + MystoryListView.b(this.this$0));
      MystoryListView.b(this.this$0, j);
      MystoryListView.c(this.this$0, k);
      MystoryListView.d(this.this$0, m);
      MystoryListView.a(this.this$0, paramInt1);
      if (MystoryListView.a(this.this$0) == null) {
        break;
      }
      MystoryListView.a(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
      label257:
      if (paramInt1 < MystoryListView.c(this.this$0))
      {
        MystoryListView.c(this.this$0, MystoryListView.f(this.this$0) - MystoryListView.e(this.this$0));
        i = k - MystoryListView.f(this.this$0);
      }
      else
      {
        i = k - MystoryListView.f(this.this$0);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((MystoryListView.a(this.this$0) != 1) && (paramAbsListView.getCount() != 0)) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (MystoryListView.a(this.this$0) != null) {
        MystoryListView.a(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      MystoryListView.a(this.this$0, false);
      continue;
      View localView = paramAbsListView.getChildAt(0);
      MystoryListView.a(this.this$0, paramAbsListView.getFirstVisiblePosition());
      if (localView != null)
      {
        MystoryListView.b(this.this$0, localView.getTop());
        MystoryListView.c(this.this$0, localView.getBottom());
        MystoryListView.d(this.this$0, localView.getHeight());
      }
      MystoryListView.a(this.this$0, true);
      MystoryListView.e(this.this$0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qyf
 * JD-Core Version:    0.7.0.1
 */