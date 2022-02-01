import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.util.Pair;

public class vwe
  implements DialogInterface.OnClickListener
{
  public vwe(SubAccountUgActivity paramSubAccountUgActivity, anxk paramanxk, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.v((String)this.f.first, ((Integer)this.f.second).intValue(), true);
    if (!anxk.bE(this.this$0.app))
    {
      this.this$0.setTitle("");
      anxj.j(this.this$0.app, this.this$0, null);
    }
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwe
 * JD-Core Version:    0.7.0.1
 */