import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;

public class jbj
  implements DialogInterface.OnClickListener
{
  public jbj(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.this$0.a != null) && (this.this$0.wk()))
    {
      MultiVideoCtrlLayerUIBase.a(this.this$0, true);
      this.this$0.vF();
      this.this$0.O(this.kQ, 65535);
      this.this$0.a.b().Rb = true;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbj
 * JD-Core Version:    0.7.0.1
 */