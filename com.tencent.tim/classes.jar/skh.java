import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.EditUniqueTitleActivity;

public class skh
  implements DialogInterface.OnClickListener
{
  public skh(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skh
 * JD-Core Version:    0.7.0.1
 */