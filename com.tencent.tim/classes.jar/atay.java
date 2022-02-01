import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.tim.activity.profile.BaseProfileFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class atay
  implements Function1<atbi, Unit>
{
  public atay(BaseProfileFragment paramBaseProfileFragment) {}
  
  public Unit a(atbi paramatbi)
  {
    if (paramatbi != null)
    {
      this.this$0.Bm(paramatbi.signature);
      if (TextUtils.isEmpty(paramatbi.cGB)) {
        break label63;
      }
      this.this$0.Pa.setVisibility(0);
      this.this$0.Pa.setText(paramatbi.cGB);
    }
    for (;;)
    {
      this.this$0.YE(paramatbi.cGA);
      return null;
      label63:
      this.this$0.Pa.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atay
 * JD-Core Version:    0.7.0.1
 */