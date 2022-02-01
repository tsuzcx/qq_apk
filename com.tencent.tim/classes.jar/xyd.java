import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class xyd
  implements DialogInterface.OnClickListener
{
  xyd(xya paramxya) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    aqhq.deleteFile(this.a.mVideoPath);
    this.a.mVideoPath = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyd
 * JD-Core Version:    0.7.0.1
 */