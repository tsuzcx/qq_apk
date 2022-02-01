import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.widget.Switch;

class jvf
  implements DialogInterface.OnClickListener
{
  jvf(juk paramjuk, jzs.a parama, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.a.aGI) && (this.a.state == 0))
      {
        paramDialogInterface = this.b;
        locala = this.a;
        if (!this.val$isChecked) {
          paramDialogInterface.a(locala, bool);
        }
      }
      else
      {
        this.b.a(this.a, this.o);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        jzs.a locala;
        return;
        bool = false;
      }
    }
    this.b.a(this.a, this.val$isChecked);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvf
 * JD-Core Version:    0.7.0.1
 */