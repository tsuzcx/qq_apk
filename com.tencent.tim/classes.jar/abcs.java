import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;

class abcs
  implements DialogInterface.OnClickListener
{
  abcs(abcr paramabcr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    anot.a(null, "dc00898", "", "", "0X800A0C7", "0X800A0C7", 0, 0, String.valueOf(SessionClearFragment.b(this.a.a)), String.valueOf(SessionClearFragment.c(this.a.a)), "", "");
    SessionClearFragment.a(this.a.a);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("extra_delete_total_file_size", SessionClearFragment.a(this.a.a).eY());
    Activity localActivity = SessionClearFragment.a(this.a.a);
    SessionClearFragment.a(this.a.a);
    localActivity.setResult(-1, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcs
 * JD-Core Version:    0.7.0.1
 */