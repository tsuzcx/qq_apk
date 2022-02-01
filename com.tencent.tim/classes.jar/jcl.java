import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class jcl
  implements DialogInterface.OnClickListener
{
  jcl(jck paramjck) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    jci.a(this.a.b, false);
    if (paramInt == 1)
    {
      anot.a(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.b.atC();
      if (!jll.aj(jci.a(this.a.b))) {
        jci.a(this.a.b).ax(jci.a(this.a.b));
      }
    }
    while (paramInt != 0)
    {
      return;
      jci.a(this.a.b).ay(jci.a(this.a.b));
      return;
    }
    jci.a(this.a.b, jci.a(this.a.b).b().amX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcl
 * JD-Core Version:    0.7.0.1
 */