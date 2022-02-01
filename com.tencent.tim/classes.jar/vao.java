import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qphone.base.util.QLog;

public class vao
  implements DialogInterface.OnClickListener
{
  public vao(FriendProfileCardActivity paramFriendProfileCardActivity, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.this$0.b.dismiss();
      com.tencent.mobileqq.activity.AddFriendLogicActivity.aRh = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "qbShowShareResultDialog back");
      }
      if (this.this$0.getIntent().getIntExtra("source_id", 3999) == 3090) {}
      try
      {
        paramDialogInterface = this.this$0.getIntent().getStringExtra("extra");
        ahkr.a(this.this$0, true, "action_game_make_friend", Long.valueOf(paramDialogInterface).longValue(), -1, acfp.m(2131706616));
        if ((this.val$context == null) || (!(this.val$context instanceof Activity))) {
          continue;
        }
        ((Activity)this.val$context).moveTaskToBack(true);
      }
      catch (Exception paramDialogInterface)
      {
        for (;;)
        {
          QLog.e("FriendProfileCardActivity", 1, "feedBackToGameSDK error = " + paramDialogInterface);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "qbShowShareResultDialog stay");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vao
 * JD-Core Version:    0.7.0.1
 */