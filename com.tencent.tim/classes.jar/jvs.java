import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.util.ProfileParams;

public class jvs
  implements DialogInterface.OnClickListener
{
  public jvs(AccountDetailActivity paramAccountDetailActivity, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.this$0.abY = true;
      this.this$0.doOnBackPressed();
      ahkr.a(this.val$activity, true, "shareToQQ", Long.valueOf(this.this$0.a.la()).longValue());
      return;
    }
    this.this$0.azt();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvs
 * JD-Core Version:    0.7.0.1
 */