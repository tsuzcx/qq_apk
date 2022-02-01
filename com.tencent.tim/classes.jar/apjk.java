import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.a;

public class apjk
  implements DialogInterface.OnClickListener
{
  public apjk(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.stopRecord();
    if (ReciteRecordLayout.a(this.this$0) != null) {
      ReciteRecordLayout.a(this.this$0).dZY();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apjk
 * JD-Core Version:    0.7.0.1
 */