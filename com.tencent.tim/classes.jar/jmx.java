import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class jmx
  implements aqnc.a<Integer>
{
  public jmx(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(aqnc<Integer> paramaqnc, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramaqnc = (FrameLayout.LayoutParams)this.this$0.iy.getLayoutParams();
    paramaqnc.bottomMargin = (this.this$0.aBT - paramInteger.intValue());
    this.this$0.iy.setLayoutParams(paramaqnc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmx
 * JD-Core Version:    0.7.0.1
 */