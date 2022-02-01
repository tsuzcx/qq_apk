import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.widget.AdapterView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;

public class axwz
  implements DialogInterface.OnClickListener
{
  public axwz(MusicProviderView paramMusicProviderView, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    MusicProviderView.dwS = false;
    this.this$0.c.eNu();
    this.this$0.onItemClick(this.a, this.val$view, this.val$position, this.val$id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwz
 * JD-Core Version:    0.7.0.1
 */