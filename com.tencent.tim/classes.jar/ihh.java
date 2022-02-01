import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;

public class ihh
  implements DialogInterface.OnClickListener
{
  public ihh(VideoController paramVideoController, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.Pb)
    {
      paramInt = this.this$0.kB();
      this.this$0.a("onHowling_click", this.this$0.kJ, true, false, -1);
      this.this$0.f(-1L, paramInt, this.this$0.kB());
      if (this.this$0.mApp != null) {
        this.this$0.mApp.l(new Object[] { Integer.valueOf(108) });
      }
    }
    if (this.Pc) {
      this.this$0.a.axK();
    }
    anot.a(null, "CliOper", "", "", "0x8006993", "0x8006993", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihh
 * JD-Core Version:    0.7.0.1
 */