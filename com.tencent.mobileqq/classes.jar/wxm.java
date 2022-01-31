import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletPrivacyFragment;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.TextUrlClickListener;

public class wxm
  implements QWalletTools.TextUrlClickListener
{
  public wxm(QWalletPrivacyFragment paramQWalletPrivacyFragment) {}
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxm
 * JD-Core Version:    0.7.0.1
 */