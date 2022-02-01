import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.widget.Switch;

public class kiw
  implements DialogInterface.OnKeyListener
{
  public kiw(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt == 4)
    {
      ReadInJoySettingActivity.a(this.this$0, true);
      paramDialogInterface = ReadInJoySettingActivity.a(this.this$0);
      if (ReadInJoySettingActivity.a(this.this$0)) {
        break label53;
      }
    }
    for (;;)
    {
      paramDialogInterface.setChecked(bool);
      ReadInJoySettingActivity.a(this.this$0).cancel();
      return false;
      label53:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kiw
 * JD-Core Version:    0.7.0.1
 */