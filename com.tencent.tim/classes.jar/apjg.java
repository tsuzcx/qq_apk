import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.a;

public class apjg
  implements DialogInterface.OnClickListener
{
  public apjg(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.aD.isShowing()) {
      this.this$0.aD.dismiss();
    }
    if (!aqiw.isNetworkAvailable(this.this$0.mContext)) {
      this.this$0.aD.show();
    }
    do
    {
      return;
      this.this$0.a(this.this$0.mActivity);
    } while (ReciteRecordLayout.a(this.this$0) == null);
    ReciteRecordLayout.a(this.this$0).dZZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apjg
 * JD-Core Version:    0.7.0.1
 */