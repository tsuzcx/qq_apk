import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import java.util.List;

public class ktd
  implements ktr.c
{
  public ktd(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void onCommentStateError(int paramInt)
  {
    if (paramInt == 1002) {
      ReadInJoySecondCommentListFragment.a(this.c, true);
    }
    if (paramInt == 1003) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktd
 * JD-Core Version:    0.7.0.1
 */