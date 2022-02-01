import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.share.AVSchema;
import com.tencent.av.share.AVSchema.c;
import com.tencent.mobileqq.activity.ChatActivityUtils;

public class iva
  implements DialogInterface.OnClickListener
{
  public iva(AVSchema.c paramc, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b.this$0.g("checkQAVPermission.callback", this.kQ)) {
      return;
    }
    if (paramInt == 1)
    {
      this.b.this$0.t(this.kQ, this.b.QD);
      return;
    }
    ChatActivityUtils.a(this.b.this$0.getActivity(), true, new ivb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iva
 * JD-Core Version:    0.7.0.1
 */