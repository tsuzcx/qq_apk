import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class vtq
  implements DialogInterface.OnClickListener
{
  vtq(vtm paramvtm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.mPause = true;
    vtm.b(this.this$0);
    this.this$0.mActivity.setResult(-1);
    this.this$0.mActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vtq
 * JD-Core Version:    0.7.0.1
 */