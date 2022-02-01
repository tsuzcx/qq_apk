import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.10.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ajyg
  implements AbsListView.OnScrollListener
{
  public ajyg(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramAbsListView = ShortVideoCommentsView.a(this.this$0).getChildAt(0);
      if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
      {
        ShortVideoCommentsView.a(this.this$0, true);
        return;
      }
      ShortVideoCommentsView.a(this.this$0, false);
      return;
    }
    ShortVideoCommentsView.a(this.this$0, false);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.this$0.a.commentList.size() > 0) && (!ShortVideoCommentsView.b(this.this$0)) && (!ShortVideoCommentsView.c(this.this$0))) {
        ShortVideoCommentsView.c(this.this$0);
      }
      if (ShortVideoCommentsView.a(this.this$0) == null) {
        break label277;
      }
      paramAbsListView = ShortVideoCommentsView.a(this.this$0).id;
      if (ShortVideoCommentsView.a(this.this$0) != null) {
        long l = ShortVideoCommentsView.a(this.this$0).ads;
      }
      paramInt = ShortVideoCommentsView.a(this.this$0);
      if ((paramInt < ShortVideoCommentsView.b(this.this$0)) || (paramInt < jll.dp2px(this.this$0.getContext(), 40.0F))) {
        break label280;
      }
      if (!ShortVideoCommentsView.d(this.this$0))
      {
        ShortVideoCommentsView.a(this.this$0, true);
        if (ShortVideoCommentsView.a(this.this$0).feedType != 4) {}
      }
      this.this$0.dAa();
    }
    for (;;)
    {
      ShortVideoCommentsView.a(this.this$0, paramInt);
      if ((ShortVideoCommentsView.a(this.this$0) != null) && (ShortVideoCommentsView.a(this.this$0).getChildCount() > 0) && (ShortVideoCommentsView.a(this.this$0).getChildAt(0).getTop() == 0) && (!ShortVideoCommentsView.e(this.this$0)))
      {
        ShortVideoCommentsView.b(this.this$0, true);
        this.this$0.postDelayed(new ShortVideoCommentsView.10.1(this), 100L);
      }
      return;
      label277:
      break;
      label280:
      if (!ShortVideoCommentsView.e(this.this$0))
      {
        this.this$0.dAe();
        ShortVideoCommentsView.a(this.this$0, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajyg
 * JD-Core Version:    0.7.0.1
 */