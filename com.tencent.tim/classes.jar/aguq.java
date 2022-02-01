import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class aguq
  implements DialogInterface.OnClickListener
{
  aguq(agum paramagum) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.removeObserver();
    this.a.mAppInterface.removeObserver(agum.a(this.a));
    Intent localIntent = new Intent(this.a.mAppInterface.getApplication(), LiteActivity.class);
    localIntent.addFlags(67108864);
    this.a.mAppInterface.getApplication().startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aguq
 * JD-Core Version:    0.7.0.1
 */