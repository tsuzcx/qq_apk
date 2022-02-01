import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;

public class ablt
  implements DialogInterface.OnClickListener
{
  public ablt(ApolloWebGameActivity paramApolloWebGameActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ApolloWebGameActivity.a(this.this$0).dismiss();
    ApolloWebGameActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ablt
 * JD-Core Version:    0.7.0.1
 */