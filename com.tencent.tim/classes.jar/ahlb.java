import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ahlb
  implements DialogInterface.OnClickListener
{
  ahlb(ahkr paramahkr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (ahkr.a(this.this$0))
      {
        this.this$0.bf.putString("uin", String.valueOf("-1010"));
        this.this$0.bf.putInt("uintype", -1);
        this.this$0.bf.putInt("key_forward_ability_type", ahgg.a.V.intValue());
        this.this$0.dnB();
      }
      anpc.a(BaseApplication.getContext()).a(this.this$0.app, this.this$0.app.getAccount(), "", "multi_account", "click_next", 0, 1, 0);
    }
    while (paramInt != 0) {
      return;
    }
    paramDialogInterface = this.this$0.mActivity;
    Activity localActivity = this.this$0.mActivity;
    paramDialogInterface.setResult(0);
    anpc.a(BaseApplication.getContext()).a(this.this$0.app, this.this$0.app.getAccount(), "", "multi_account", "click_cancel", 0, 1, 0);
    this.this$0.mActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlb
 * JD-Core Version:    0.7.0.1
 */