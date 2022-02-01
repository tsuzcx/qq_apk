import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.filemanager.activity.FMActivity;

public class atnv
  implements DialogInterface.OnClickListener
{
  public atnv(FMActivity paramFMActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.setResult(8001);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnv
 * JD-Core Version:    0.7.0.1
 */