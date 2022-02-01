import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.a;
import com.tencent.mobileqq.widget.QQToast;

public class acba
  implements DialogInterface.OnClickListener
{
  public acba(ApolloPanel.a parama, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QQToast.a(this.val$context, this.val$context.getString(2131690378), 0).show(0);
    if (ApolloPanel.a.a(this.b))
    {
      ApolloPanel.a.a(this.b, 1);
      ApolloPanel.a.b(this.b);
      this.b.this$0.cGN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acba
 * JD-Core Version:    0.7.0.1
 */