import SummaryCard.CondFitUser;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class aefp
  implements accv.d
{
  public aefp(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void b(boolean paramBoolean1, List<CondFitUser> paramList, boolean paramBoolean2, int paramInt)
  {
    this.this$0.aqz();
    if (paramInt != 1) {
      return;
    }
    if (!paramBoolean1)
    {
      QQToast.a(this.this$0, 2131691951, 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QQToast.a(this.this$0, 2131691954, 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    SearchResultActivity.a(this.this$0, this.this$0.keyword, this.this$0.mAgeSelectIndex1, this.this$0.mAgeSelectIndex2, this.this$0.cMt, this.this$0.b.H(), this.this$0.b.I(), this.this$0.cMv, this.this$0.cMu, paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefp
 * JD-Core Version:    0.7.0.1
 */