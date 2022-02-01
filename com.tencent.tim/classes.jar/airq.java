import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.b;

final class airq
  implements DialogInterface.OnClickListener
{
  airq(BaseActivity paramBaseActivity, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.val$activity.app;
    aiqs.a(paramDialogInterface).a.G(3, this.alR, this.val$uin);
    LocationRoom.b localb = new LocationRoom.b(this.alR, this.val$uin);
    aiqs.a(paramDialogInterface).a(localb, false);
    anot.a(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     airq
 * JD-Core Version:    0.7.0.1
 */