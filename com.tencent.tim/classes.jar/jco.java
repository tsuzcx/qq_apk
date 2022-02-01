import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class jco
  implements DialogInterface.OnClickListener
{
  jco(jci paramjci) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    jci.a(this.b, false);
    if (paramInt == 1)
    {
      anot.a(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.b.atC();
      if (!jll.aj(jci.a(this.b))) {
        jci.a(this.b).ax(jci.a(this.b));
      }
    }
    while (paramInt != 0)
    {
      return;
      jci.a(this.b).ay(jci.a(this.b));
      return;
    }
    jci.a(this.b, jci.a(this.b).b().amX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jco
 * JD-Core Version:    0.7.0.1
 */