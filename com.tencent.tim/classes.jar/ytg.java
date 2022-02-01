import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class ytg
  implements DialogInterface.OnClickListener
{
  public ytg(SystemMsgListView paramSystemMsgListView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent(this.this$0.getContext(), BindNumberActivity.class);
      paramDialogInterface.putExtra("kSrouce", 17);
      this.this$0.startActivityForResult(paramDialogInterface, 230);
      anot.a(this.this$0.app, "dc00898", "", "", "0X80077C9", "0X80077C9", 0, 0, "", "", "", "");
    }
    while (paramInt != 0) {
      return;
    }
    anot.a(this.this$0.app, "dc00898", "", "", "0X80077CA", "0X80077CA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ytg
 * JD-Core Version:    0.7.0.1
 */