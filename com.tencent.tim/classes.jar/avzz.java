import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;

public class avzz
  implements DialogInterface.OnClickListener
{
  public avzz(QZoneShareActivity paramQZoneShareActivity, Activity paramActivity, QZoneShareData paramQZoneShareData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QZoneShareActivity.a(this.this$0, this.val$activity, this.b, false);
    this.val$activity.setResult(0, this.this$0.getIntent());
    this.val$activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzz
 * JD-Core Version:    0.7.0.1
 */