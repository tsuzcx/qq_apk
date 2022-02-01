import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.12.1;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.12.2;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.12.3;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import java.util.ArrayList;

public class aowa
  implements DialogInterface.OnClickListener
{
  public aowa(TroopBarReplyActivity paramTroopBarReplyActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      return;
    }
    switch (this.val$type)
    {
    case 4: 
    default: 
      return;
    case 0: 
      this.this$0.cu.clear();
      this.this$0.b.removeAllItem();
      paramDialogInterface.dismiss();
      this.this$0.dXo();
      return;
    case 2: 
      paramDialogInterface.dismiss();
      this.this$0.mHandler.postDelayed(new TroopBarReplyActivity.12.1(this), 200L);
      return;
    case 3: 
      this.this$0.cu.clear();
      this.this$0.b.removeAllItem();
      paramDialogInterface.dismiss();
      this.this$0.Wo(4);
      return;
    case 1: 
      this.this$0.cu.clear();
      this.this$0.b.removeAllItem();
      paramDialogInterface.dismiss();
      this.this$0.dXn();
      return;
    case 6: 
      this.this$0.cu.clear();
      this.this$0.b.removeAllItem();
      paramDialogInterface.dismiss();
      TroopBarReplyActivity.a(this.this$0, this.this$0.aI, true);
      aurd.hide(this.this$0.a);
      this.this$0.mHandler.postDelayed(new TroopBarReplyActivity.12.2(this), 200L);
      return;
    case 7: 
      this.this$0.cu.clear();
      this.this$0.b.removeAllItem();
      paramDialogInterface.dismiss();
      this.this$0.Wo(3);
      return;
    }
    paramDialogInterface.dismiss();
    this.this$0.mHandler.postDelayed(new TroopBarReplyActivity.12.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aowa
 * JD-Core Version:    0.7.0.1
 */