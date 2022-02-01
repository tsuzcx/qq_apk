import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.a;

class apjq
  implements DialogInterface.OnClickListener
{
  apjq(apjo paramapjo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.this$0.stopRecord();
    if (ReciteRecordLayout.a(this.a.this$0) != null) {
      ReciteRecordLayout.a(this.a.this$0).dZY();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apjq
 * JD-Core Version:    0.7.0.1
 */