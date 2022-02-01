import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.dataline.activities.LiteActivity;

public class bh
  implements DialogInterface.OnDismissListener
{
  public bh(LiteActivity paramLiteActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (LiteActivity.b(this.this$0))
    {
      LiteActivity.a(this.this$0, false);
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bh
 * JD-Core Version:    0.7.0.1
 */