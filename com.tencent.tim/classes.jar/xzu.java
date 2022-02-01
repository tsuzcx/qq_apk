import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class xzu
  implements DialogInterface.OnClickListener
{
  xzu(xzp paramxzp, boolean paramBoolean, ared paramared) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.bkS = true;
    xzp.d(this.this$0, this.aTd);
    this.this$0.mIsBack = true;
    if ((this.a.isReady()) && (!this.a.isPlaying())) {
      anot.a(this.this$0.app, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzu
 * JD-Core Version:    0.7.0.1
 */