import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class auaf
  implements DialogInterface.OnClickListener
{
  auaf(auaa paramauaa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.removeObserver();
    this.a.mAppInterface.removeObserver(auaa.a(this.a));
    Intent localIntent = new Intent(this.a.mAppInterface.getApplication(), LiteActivity.class);
    localIntent.addFlags(67108864);
    this.a.mAppInterface.getApplication().startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auaf
 * JD-Core Version:    0.7.0.1
 */