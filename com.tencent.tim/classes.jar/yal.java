import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class yal
  implements DialogInterface.OnClickListener
{
  yal(xzp paramxzp, ared paramared) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.bkS = true;
    this.this$0.mIsBack = true;
    xzp.b(this.this$0, false);
    if ((this.a.isReady()) && (!this.a.isPlaying())) {
      anot.a(this.this$0.app, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yal
 * JD-Core Version:    0.7.0.1
 */