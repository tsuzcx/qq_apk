import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.qphone.base.util.QLog;

public class jwt
  implements ausj.a
{
  public jwt(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    PublicAccountAdvertisementActivity.a(this.this$0).dismiss();
    if (paramView != null)
    {
      paramView = PublicAccountAdvertisementActivity.a(this.this$0).getContent(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountAdvertisementActivity", 2, "action" + paramView);
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(this.this$0.getResources().getString(2131693966))) {
          break label91;
        }
        PublicAccountAdvertisementActivity.d(this.this$0);
      }
    }
    label91:
    while (!paramView.equals(this.this$0.getResources().getString(2131694736))) {
      return;
    }
    aibd.a().a(PublicAccountAdvertisementActivity.a(this.this$0), null, 3, 2);
    anot.c(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.this$0).a.UD, "0X80090FC", "0X80090FC", 0, 0, PublicAccountAdvertisementActivity.a(this.this$0).a.hT, "", "", PublicAccountAdvertisementActivity.a(this.this$0).a.mNickName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwt
 * JD-Core Version:    0.7.0.1
 */