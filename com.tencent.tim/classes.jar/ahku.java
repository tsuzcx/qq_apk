import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class ahku
  implements DialogInterface.OnClickListener
{
  ahku(ahkr paramahkr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.isSdkShare) {
      arts.a().a(this.this$0.app.getAccount(), "", String.valueOf(this.this$0.appid), "1000", "51", "0", false, true);
    }
    ahki.a(this.this$0.mActivity, true, "addToQQFavorites", this.this$0.mShareAppId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahku
 * JD-Core Version:    0.7.0.1
 */