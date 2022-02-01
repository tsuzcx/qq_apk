import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;

public class aazx
  implements DialogInterface.OnClickListener
{
  public aazx(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.this$0.fa != null) && (this.this$0.fa.get() != null)) {
      ((ISuperPlayer)this.this$0.fa.get()).pauseDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazx
 * JD-Core Version:    0.7.0.1
 */