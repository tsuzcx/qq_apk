import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class z
  implements DialogInterface.OnClickListener
{
  public z(LiteActivity paramLiteActivity, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.getIntent().getIntExtra("forward_type", -1) == 11) {
      arts.a().a(this.this$0.app.getAccount(), "", String.valueOf(this.Y), "1000", "52", "0", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i(LiteActivity.TAG, 2, "qbShowShareResultDialog stay");
    }
    if (this.this$0.getIntent().getBooleanExtra("MigSdkShareNotDone", false)) {
      this.this$0.getIntent().putExtra("MigSdkShareNotDone", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     z
 * JD-Core Version:    0.7.0.1
 */