import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.beauty.BeautyView;

public class jfw
  implements DialogInterface.OnClickListener
{
  public jfw(BeautyView paramBeautyView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfw
 * JD-Core Version:    0.7.0.1
 */