import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class njy
  implements DialogInterface.OnDismissListener
{
  public njy(FastWebActivity paramFastWebActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Context localContext;
    if (!FastWebActivity.c(this.this$0))
    {
      localContext = this.this$0.getApplicationContext();
      if (!FastWebActivity.d(this.this$0)) {
        break label86;
      }
    }
    label86:
    for (paramDialogInterface = "0X8008994";; paramDialogInterface = "0X800898D")
    {
      nng.a(localContext, paramDialogInterface, 11, FastWebActivity.a(this.this$0));
      nns.a(this.this$0, this.this$0.getAppInterface(), FastWebActivity.a(this.this$0), -1, -1, true, FastWebActivity.e(this.this$0));
      FastWebActivity.c(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njy
 * JD-Core Version:    0.7.0.1
 */