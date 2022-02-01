import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class jcm
  implements DialogInterface.OnClickListener
{
  jcm(jck paramjck) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.b.atC();
    jci.a(this.a.b, false);
    if (paramInt == 1)
    {
      anot.a(null, "CliOper", "", "", "0X800A565", "0X800A565", 0, 0, "", "", "", "");
      jci.a(this.a.b);
    }
    while (paramInt != 0) {
      return;
    }
    jci.a(this.a.b, jci.a(this.a.b).b().amX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcm
 * JD-Core Version:    0.7.0.1
 */