import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;

public class abls
  implements DialogInterface.OnClickListener
{
  public abls(ApolloWebGameActivity paramApolloWebGameActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.this$0, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", abxi.bjl);
    this.this$0.startActivity(paramDialogInterface);
    ApolloWebGameActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abls
 * JD-Core Version:    0.7.0.1
 */