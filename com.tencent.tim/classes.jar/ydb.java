import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.35.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class ydb
  implements DialogInterface.OnClickListener
{
  ydb(ycd paramycd, PublicAccountInfo paramPublicAccountInfo, acja paramacja) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.c.mIsAgreeSyncLbs = true;
    this.c.mIsSyncLbsSelected = true;
    this.b.c(this.c);
    this.this$0.a(1, null);
    paramDialogInterface = new PublicAccountChatPie.35.1(this);
    this.this$0.app.execute(paramDialogInterface);
    ycd.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydb
 * JD-Core Version:    0.7.0.1
 */