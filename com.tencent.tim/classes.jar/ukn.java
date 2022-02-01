import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ukn
  implements DialogInterface.OnClickListener
{
  public ukn(ChatActivityUtils.c paramc, String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.onCancel();
    }
    anot.a(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, this.val$uin + "", this.bEY + "", "1", "");
    aqjl.a(this.val$app, Long.valueOf(this.val$uin).longValue(), null);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ukn
 * JD-Core Version:    0.7.0.1
 */