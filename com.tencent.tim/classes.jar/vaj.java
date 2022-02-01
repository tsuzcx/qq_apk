import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.VipUtils;

public class vaj
  implements DialogInterface.OnClickListener
{
  public vaj(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.bGY == 1) {
      VipUtils.b(this.this$0, 1, aqep.gb(3));
    }
    for (;;)
    {
      this.this$0.bFU();
      return;
      if (this.this$0.bGY == 2) {
        VipUtils.c(this.this$0, 1, aqep.gb(6));
      } else if (this.this$0.bGY == 3) {
        VipUtils.a(this.this$0, true, 12, false, aqep.gb(6));
      } else if (this.this$0.bGY == 4) {
        aqrf.a(this.this$0, aqep.gb(6), "SVHHZLH", 0, false, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vaj
 * JD-Core Version:    0.7.0.1
 */