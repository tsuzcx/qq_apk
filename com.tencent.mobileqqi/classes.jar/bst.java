import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.DeleteAccountActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.app.QQAppInterface;

public class bst
  implements View.OnClickListener
{
  public bst(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = PrivacyDeclareHelper.b(this.a.getApplicationContext(), "https://sqimg.qq.com/qq_product_operations/i18n/logoutApplication.html?uin=${uin}&language=${language}").replace("${uin}", this.a.b.a());
    Intent localIntent = new Intent(this.a, DeleteAccountActivity.class);
    localIntent.putExtra("reqType", 4);
    localIntent.putExtra("title", this.a.getString(2131563347));
    localIntent.putExtra("uin", this.a.b.a());
    this.a.startActivityForResult(localIntent.putExtra("url", paramView), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bst
 * JD-Core Version:    0.7.0.1
 */