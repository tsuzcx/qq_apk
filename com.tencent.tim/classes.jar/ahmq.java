import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.widget.Switch;

public class ahmq
  implements DialogInterface.OnClickListener
{
  public ahmq(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1)
    {
      paramDialogInterface = this.this$0;
      if (!AppletsSettingFragment.a(this.this$0))
      {
        AppletsSettingFragment.a(paramDialogInterface, bool);
        AppletsSettingFragment.a(this.this$0, AppletsSettingFragment.a(this.this$0));
        this.this$0.x.cancel();
      }
    }
    while (paramInt != 0) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    AppletsSettingFragment.a(this.this$0).setChecked(AppletsSettingFragment.a(this.this$0));
    this.this$0.x.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmq
 * JD-Core Version:    0.7.0.1
 */