import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.open.applist.H5ConfirmDialog;
import com.tencent.open.applist.H5ConfirmDialog.Dialogcallback;

public class hlb
  implements View.OnClickListener
{
  public hlb(H5ConfirmDialog paramH5ConfirmDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dialogcallback.a(this.a.createIcon_cb.isChecked());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hlb
 * JD-Core Version:    0.7.0.1
 */