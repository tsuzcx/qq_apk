import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;

public class ymn
  implements DialogInterface.OnClickListener
{
  public ymn(ApolloWebGameActivity paramApolloWebGameActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", ApolloConstant.O);
    this.a.startActivity(paramDialogInterface);
    ApolloWebGameActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymn
 * JD-Core Version:    0.7.0.1
 */