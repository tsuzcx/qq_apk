import android.view.animation.Transformation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class wgf
  implements aqnc.a<Integer>
{
  public wgf(VisitorsActivity paramVisitorsActivity) {}
  
  public void a(aqnc<Integer> paramaqnc, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    this.this$0.Hg.setText(paramInteger + "");
    if (paramInteger.intValue() > 9999)
    {
      this.this$0.Hg.setTextSize(36.0F);
      return;
    }
    this.this$0.Hg.setTextSize(44.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgf
 * JD-Core Version:    0.7.0.1
 */