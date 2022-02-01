import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class jmz
  implements aqnc.a<Integer>
{
  public jmz(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(aqnc<Integer> paramaqnc, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramaqnc = (FrameLayout.LayoutParams)PoiMapActivity.c(this.this$0).getLayoutParams();
    paramaqnc.bottomMargin = (this.this$0.aBV + this.this$0.aBY);
    PoiMapActivity.c(this.this$0).setLayoutParams(paramaqnc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmz
 * JD-Core Version:    0.7.0.1
 */