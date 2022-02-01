import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class ahkc
  implements DialogInterface.OnClickListener
{
  ahkc(ahjz paramahjz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ahki.a(ahjz.a(this.this$0), false, "shareToQQ", ahjz.a(this.this$0));
      jqo.a(ahjz.a(this.this$0), 0, "", "");
      if (ahjz.a(this.this$0) != null) {
        ahjz.a(this.this$0).fV(1);
      }
      ahjz.a(this.this$0).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkc
 * JD-Core Version:    0.7.0.1
 */