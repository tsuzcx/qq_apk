import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;

public class uni
  implements DialogInterface.OnDismissListener
{
  public uni(ChatHistory paramChatHistory, View paramView1, int paramInt, View paramView2, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.val$rootView.offsetTopAndBottom(-this.dS);
    this.rP.setVisibility(0);
    this.val$rootView.startAnimation(this.c);
    paramDialogInterface = (zme)paramDialogInterface;
    int i = paramDialogInterface.getRecordCount();
    boolean bool = paramDialogInterface.Vv();
    ChatHistory.a(this.this$0, i);
    if (bool)
    {
      this.this$0.leftView.setText(this.this$0.getString(2131691039));
      return;
    }
    paramDialogInterface = this.this$0.getIntent().getExtras().getString("leftViewText");
    this.this$0.leftView.setText(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uni
 * JD-Core Version:    0.7.0.1
 */