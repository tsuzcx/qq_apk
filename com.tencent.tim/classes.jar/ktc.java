import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class ktc
  implements AbsListView.e
{
  public ktc(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ((ReadInJoyCommentListView)paramAbsListView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    ((ReadInJoyCommentListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
    if ((ReadInJoySecondCommentListFragment.a(this.c) != null) && (ReadInJoySecondCommentListFragment.a(this.c).a() != null)) {
      ReadInJoySecondCommentListFragment.a(this.c).a().cx(ReadInJoySecondCommentListFragment.a(this.c).getFirstVisiblePosition(), ReadInJoySecondCommentListFragment.a(this.c).getLastVisiblePosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktc
 * JD-Core Version:    0.7.0.1
 */