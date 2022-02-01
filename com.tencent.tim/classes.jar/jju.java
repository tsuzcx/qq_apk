import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class jju
  implements DialogInterface.OnClickListener
{
  jju(jjt paramjjt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((aicu)this.a.val$app.getManager(236)).e(this.a.val$context, this.a.val$app.getCurrentAccountUin(), this.a.Sx, "4", "openRoom");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jju
 * JD-Core Version:    0.7.0.1
 */