import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class jmw
  implements ViewTreeObserver.OnPreDrawListener
{
  public jmw(PoiMapActivity paramPoiMapActivity) {}
  
  public boolean onPreDraw()
  {
    this.this$0.aBT = PoiMapActivity.e(this.this$0).getMeasuredHeight();
    PoiMapActivity.a(this.this$0, PoiMapActivity.a(this.this$0).getMeasuredHeight());
    if ((this.this$0.aBT > 0) && (PoiMapActivity.a(this.this$0) > 0))
    {
      this.this$0.P((this.this$0.aBT - PoiMapActivity.b(this.this$0)) / 2 + this.this$0.aBZ, false);
      PoiMapActivity.f(this.this$0).getViewTreeObserver().removeOnPreDrawListener(this);
      PoiMapActivity.b(this.this$0).getViewTreeObserver().removeOnPreDrawListener(this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmw
 * JD-Core Version:    0.7.0.1
 */