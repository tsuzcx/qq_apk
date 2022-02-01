import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.util.WeakReference;

public class aezu
  implements DialogInterface.OnClickListener
{
  public aezu(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (aqiw.isNetSupport(MessageForGrayTips.HightlightClickableSpan.access$100(this.this$0)))
    {
      paramDialogInterface.dismiss();
      MessageForGrayTips.HightlightClickableSpan.access$300(this.this$0, (QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(this.this$0).get(), MessageForGrayTips.HightlightClickableSpan.access$200(this.this$0).mMsgActionData);
      MessageForGrayTips.HightlightClickableSpan.access$300(this.this$0, (QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(this.this$0).get(), this.this$0.frienduin);
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, 2131692480, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aezu
 * JD-Core Version:    0.7.0.1
 */