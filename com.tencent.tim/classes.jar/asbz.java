import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.wadl.WadlJsBridgeCallBack.2;

public class asbz
  implements DialogInterface.OnClickListener
{
  public asbz(WadlJsBridgeCallBack.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.d.eCh = 1;
    awok.a().h(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbz
 * JD-Core Version:    0.7.0.1
 */