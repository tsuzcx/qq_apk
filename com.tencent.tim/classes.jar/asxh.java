import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.2;

public class asxh
  implements DialogInterface.OnClickListener
{
  public asxh(VideoJsProxyImpl.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    asxf.a(this.a.this$0, this.a.val$context, this.a.val$duration, this.a.val$compressed, this.a.val$isFront);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxh
 * JD-Core Version:    0.7.0.1
 */