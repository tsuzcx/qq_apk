import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;

public class com
  implements DialogInterface.OnClickListener
{
  public com(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new coq(this.a, null).execute(new Void[0]);
    this.a.setResult(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com
 * JD-Core Version:    0.7.0.1
 */