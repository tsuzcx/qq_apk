import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

public class jwb
  implements ausj.a
{
  public jwb(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.this$0.aci) {
      return;
    }
    this.this$0.aci = true;
    switch (paramInt)
    {
    }
    label273:
    label277:
    for (;;)
    {
      this.this$0.v.dismiss();
      return;
      this.this$0.abZ = false;
      this.this$0.aAh();
      if (((kdm)this.this$0.app.getManager(88)).dr(this.this$0.uin)) {
        ((kec)this.this$0.app.getBusinessHandler(88)).a(134243868, this.this$0.uin, null, null, null, 2L, false);
      }
      wja.bcO = false;
      if ("2290230341".equals(this.this$0.uin))
      {
        anot.a(this.this$0.app, "CliOper", "", "", "0X80090E7", "0X80090E7", 0, 0, "", "", "", "");
        label177:
        if (this.this$0.a == null) {
          break label273;
        }
      }
      for (paramView = this.this$0.a.name;; paramView = "")
      {
        if (this.this$0.a == null) {
          break label277;
        }
        aakp.f(this.this$0.app, this.this$0.uin, paramView);
        break;
        if (!TextUtils.equals(String.valueOf(2062433139L), this.this$0.uin)) {
          break label177;
        }
        kbp.a(null, null, "0X800929F", "0X800929F", 0, 0, "", "", "", kct.d(null), false);
        break label177;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwb
 * JD-Core Version:    0.7.0.1
 */