import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;

public class xcd
  extends FriendListObserver
{
  public xcd(TransactionActivity paramTransactionActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    TransactionActivity.b(this.a, ContactUtils.c(this.a.app, TransactionActivity.c(this.a), false));
    paramString = QWalletTools.a(TransactionActivity.a(this.a), TransactionActivity.d(this.a), AIOUtils.a(TransactionActivity.c(this.a), TransactionActivity.a(this.a).getResources()), TransactionActivity.a(this.a).getPaint());
    TransactionActivity.a(this.a).setText(paramString + "(" + TransactionActivity.c(this.a) + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcd
 * JD-Core Version:    0.7.0.1
 */