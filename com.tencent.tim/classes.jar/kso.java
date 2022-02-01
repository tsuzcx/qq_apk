import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import java.util.List;

public class kso
  implements ktr.c
{
  boolean ahy = false;
  
  public kso(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyCommentListFragment", 1, "onCommentListLoad anchor");
    if (!paramBoolean1) {}
    do
    {
      return;
      paramList = ReadInJoyCommentListFragment.a(this.this$0).a().a();
    } while (paramList == null);
    if (!TextUtils.isEmpty(paramList.acs))
    {
      this.this$0.aGK();
      this.this$0.g(true, paramList.acr, paramList.acs);
    }
    for (;;)
    {
      paramList.mM(false);
      return;
      this.this$0.aGK();
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.ahy) {}
    do
    {
      return;
      this.ahy = true;
    } while ((paramInt == 1001) && (paramInt != 1003));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kso
 * JD-Core Version:    0.7.0.1
 */