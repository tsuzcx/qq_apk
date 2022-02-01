import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;

public class axxb
  implements DialogInterface.OnClickListener
{
  public axxb(MusicProviderView paramMusicProviderView, MusicItemInfo paramMusicItemInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    MusicProviderView.dwS = false;
    this.this$0.c.eNu();
    this.this$0.l(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxb
 * JD-Core Version:    0.7.0.1
 */