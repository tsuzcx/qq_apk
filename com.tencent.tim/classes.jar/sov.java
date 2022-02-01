import com.tencent.biz.ui.TouchWebView;
import com.tencent.widget.ScrollView;

public class sov
{
  private static final String TAG = sov.class.getSimpleName();
  private ScrollView a;
  public boolean aMr;
  public auup b;
  private TouchWebView c;
  private float om;
  public int scrollY;
  
  public sov(ScrollView paramScrollView, TouchWebView paramTouchWebView)
  {
    this.c = paramTouchWebView;
    this.a = paramScrollView;
  }
  
  public void ak(float paramFloat)
  {
    this.om = paramFloat;
  }
  
  public void yL(int paramInt)
  {
    this.scrollY = paramInt;
    if ((this.a == null) || (this.c == null)) {}
    while ((this.om <= 0.0F) || (this.c.canScrollVertically(-1)) || (paramInt != 0) || (!this.a.canScrollVertically(-1))) {
      return;
    }
    this.a.fling((int)-this.om);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sov
 * JD-Core Version:    0.7.0.1
 */