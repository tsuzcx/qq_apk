import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;

public class aqo
  implements DialogInterface.OnClickListener
{
  public aqo(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GroupManagerActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aqo
 * JD-Core Version:    0.7.0.1
 */