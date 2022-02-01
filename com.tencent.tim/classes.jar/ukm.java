import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ukm
  implements DialogInterface.OnClickListener
{
  public ukm(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, String paramString, int paramInt3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.b(this.kQ, this.val$app, this.val$context, this.alP, this.alQ);
    this.b.onClick(paramDialogInterface, paramInt);
    anot.a(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, this.val$uin + "", this.bEY + "", "0", "");
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ukm
 * JD-Core Version:    0.7.0.1
 */