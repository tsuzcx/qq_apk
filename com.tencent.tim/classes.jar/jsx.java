import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.data.EqqDetail;

public class jsx
  implements ausj.a
{
  public jsx(EqqAccountDetailActivity paramEqqAccountDetailActivity, ausj paramausj, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (this.this$0.b == null);
      jqs.a(EqqAccountDetailActivity.n(this.this$0), this.this$0, this.this$0.b.name, EqqAccountDetailActivity.m(this.this$0), "IvrEnterpriseDetailEngineFalse");
      return;
    }
    paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.val$phone));
    this.this$0.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsx
 * JD-Core Version:    0.7.0.1
 */