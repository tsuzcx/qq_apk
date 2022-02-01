import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.11;
import com.tencent.mobileqq.location.ui.LocationShareFragment;

public class airn
  implements DialogInterface.OnClickListener
{
  public airn(LocationDialogUtil.11 param11) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = aiqs.a((QQAppInterface)this.a.val$activity.getAppInterface());
    paramDialogInterface.e(new LocationRoom.b(this.a.alR, this.a.val$uin));
    paramDialogInterface.Lt(true);
    paramDialogInterface.dk(this.a.alR, this.a.val$uin);
    LocationShareFragment.d(this.a.val$activity, this.a.alR, this.a.val$uin, this.a.val$from);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     airn
 * JD-Core Version:    0.7.0.1
 */