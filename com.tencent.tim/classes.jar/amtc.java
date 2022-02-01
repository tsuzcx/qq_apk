import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class amtc
  implements amsq<ampv, amxx>
{
  public void a(ampv paramampv, amxx paramamxx)
  {
    paramamxx = (amze)paramamxx;
    if ((paramampv instanceof ampg))
    {
      paramampv = (ampg)paramampv;
      if (TextUtils.isEmpty(paramampv.cbj)) {
        break label81;
      }
      paramamxx.kC.setVisibility(0);
      paramamxx.Zq.setText(paramampv.cbj);
    }
    for (;;)
    {
      paramamxx.kC.setOnClickListener(new amtd(this, paramampv));
      if (TextUtils.isEmpty(paramampv.cbk)) {
        paramamxx.kC.setEnabled(false);
      }
      return;
      label81:
      paramamxx.kC.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtc
 * JD-Core Version:    0.7.0.1
 */