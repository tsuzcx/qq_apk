import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class ksn
  implements AbsListView.e
{
  public ksn(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ((ReadInJoyCommentListView)paramAbsListView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (!ReadInJoyCommentListFragment.a(this.this$0).a().a().AC()) {
      ((ReadInJoyCommentListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
    }
    for (;;)
    {
      if ((ReadInJoyCommentListFragment.a(this.this$0) != null) && (ReadInJoyCommentListFragment.a(this.this$0).a() != null)) {
        ReadInJoyCommentListFragment.a(this.this$0).a().cx(ReadInJoyCommentListFragment.a(this.this$0).getFirstVisiblePosition(), ReadInJoyCommentListFragment.a(this.this$0).getLastVisiblePosition());
      }
      return;
      ((ReadInJoyCommentListView)paramAbsListView).aGQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksn
 * JD-Core Version:    0.7.0.1
 */