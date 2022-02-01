import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.Leba.41;
import com.tencent.mobileqq.activity.Leba.a;

public class vfn
  implements DialogInterface.OnClickListener
{
  public vfn(Leba.41 param41) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.val$sp.edit().putBoolean(this.a.aNQ, true).apply();
    this.a.a.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfn
 * JD-Core Version:    0.7.0.1
 */