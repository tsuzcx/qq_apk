import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletPrivacyFragment;

public class zyj
  implements aagd.a
{
  public zyj(QWalletPrivacyFragment paramQWalletPrivacyFragment) {}
  
  public void zR(String paramString)
  {
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyj
 * JD-Core Version:    0.7.0.1
 */