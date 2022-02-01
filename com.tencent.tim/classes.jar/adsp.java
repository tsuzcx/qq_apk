import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class adsp
  implements DialogInterface.OnClickListener
{
  adsp(adso paramadso, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = adso.a(this.this$0);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < adso.a(this.this$0).size())
        {
          adsr localadsr = (adsr)adso.a(this.this$0).get(i);
          if (localadsr == null) {
            break label269;
          }
          localadsr.I.onClick(adso.a(this.this$0), paramInt);
          break label269;
        }
      }
      finally {}
      try
      {
        adso.a(this.this$0, false);
        if ((adso.a(this.this$0) != null) && (adso.a(this.this$0).isShowing())) {
          adso.a(this.this$0).dismiss();
        }
        adso.a(this.this$0, this.val$arkAppName);
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", paramDialogInterface);
        continue;
        if (paramInt != 0) {
          continue;
        }
        anot.c(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(adso.a(this.this$0)), "", this.val$arkAppName, "");
        return;
      }
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [onClickListener] which=", Integer.valueOf(paramInt), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - adso.a(this.this$0))) });
      if (paramInt == 1)
      {
        anot.c(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(adso.a(this.this$0)), "", this.val$arkAppName, "");
        return;
      }
      label269:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsp
 * JD-Core Version:    0.7.0.1
 */