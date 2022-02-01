import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class ahln
  implements DialogInterface.OnClickListener
{
  ahln(ahlj paramahlj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ahki.a(ahlj.a(this.this$0), false, "shareToQQ", ahlj.a(this.this$0));
      jqo.a(ahlj.a(this.this$0), 0, "", "");
      if (ahlj.a(this.this$0) != null) {
        ahlj.a(this.this$0).fV(1);
      }
      ahlj.a(this.this$0).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahln
 * JD-Core Version:    0.7.0.1
 */