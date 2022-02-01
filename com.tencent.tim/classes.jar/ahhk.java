import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class ahhk
  implements DialogInterface.OnClickListener
{
  ahhk(Intent paramIntent, int paramInt, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l = this.val$intent.getLongExtra("sdk_mult_share_source_app_id", 0L);
    int i = this.val$intent.getIntExtra("sdk_mult_share_msg_service_id", 0);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ForwardDialogMgr", 2, "-->showMultShareDialog--back");
        }
        if (this.val$resultCode == 2) {
          ahlj.a(this.val$activity, "shareToQQ", l, 0, ahlj.bKK);
        }
        while (this.val$resultCode == 1)
        {
          ForwardUtils.a(this.val$app, "0X800A740", new String[0]);
          return;
          ahlj.a(l, i, this.val$activity, null);
        }
        if (this.val$resultCode == 0)
        {
          ForwardUtils.a(this.val$app, "0X800A73C", new String[0]);
          return;
        }
      } while ((this.val$resultCode != 2) && (this.val$resultCode != 901503));
      ForwardUtils.a(this.val$app, "0X800A73E", new String[0]);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardDialogMgr", 2, "-->showMultShareDialog--stay");
      }
      if (this.val$resultCode == 901503) {
        ahlj.a(this.val$activity, "shareToQQ", l, 0, ahlj.bKK);
      }
      while (this.val$resultCode == 1)
      {
        ForwardUtils.a(this.val$app, "0X800A73F", new String[0]);
        return;
        if (this.val$resultCode == 3) {
          ahlj.a(l, i, this.val$activity, null);
        } else {
          ahlj.a(l, i, this.val$activity);
        }
      }
      if (this.val$resultCode == 0)
      {
        ForwardUtils.a(this.val$app, "0X800A73B", new String[0]);
        return;
      }
    } while ((this.val$resultCode != 2) && (this.val$resultCode != 901503));
    ForwardUtils.a(this.val$app, "0X800A73D", new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhk
 * JD-Core Version:    0.7.0.1
 */