import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class aazw
  implements DialogInterface.OnClickListener
{
  public aazw(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.fa != null)
    {
      if (this.this$0.mPlayState == 2) {
        this.this$0.resume();
      }
      this.this$0.play(this.this$0.fB);
    }
    anfr.cFn = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazw
 * JD-Core Version:    0.7.0.1
 */