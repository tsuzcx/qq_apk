import android.view.View;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class jta
  implements ausj.a
{
  public jta(EqqAccountDetailActivity paramEqqAccountDetailActivity, jzs.a parama, ausj paramausj, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.this$0.abB) {}
    do
    {
      return;
      this.this$0.abB = true;
      this.this$0.b(this.a, paramInt + 1);
      this.u.dismiss();
    } while ((!((kdm)EqqAccountDetailActivity.o(this.this$0).getManager(88)).dr(EqqAccountDetailActivity.n(this.this$0))) || (this.val$index == paramInt));
    ((kec)EqqAccountDetailActivity.p(this.this$0).getBusinessHandler(88)).a(134243867, EqqAccountDetailActivity.o(this.this$0), null, null, null, paramInt + 1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jta
 * JD-Core Version:    0.7.0.1
 */