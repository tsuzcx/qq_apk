import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.GeneralSettingActivity;

class vcd
  implements aogc.a
{
  vcd(vcc paramvcc, CompoundButton paramCompoundButton, boolean paramBoolean, int paramInt) {}
  
  public void onCancel()
  {
    this.a.this$0.a(this.val$buttonView, false);
  }
  
  public void onConfirm()
  {
    this.a.this$0.bPB();
    GeneralSettingActivity.a(this.a.this$0, this.val$buttonView, true, this.aXi, this.bHB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcd
 * JD-Core Version:    0.7.0.1
 */