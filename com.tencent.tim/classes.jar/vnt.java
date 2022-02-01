import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQIdentiferActivity;

class vnt
  implements DialogInterface.OnClickListener
{
  vnt(vns paramvns) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QQIdentiferActivity.a(this.a.this$0, 205, acfp.m(2131711776));
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnt
 * JD-Core Version:    0.7.0.1
 */