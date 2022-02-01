import android.view.View;
import android.view.View.OnLayoutChangeListener;

class ubr
  implements View.OnLayoutChangeListener
{
  ubr(ubq paramubq) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView.removeOnLayoutChangeListener(this);
    paramView.setTranslationX(ubq.a(this.a)[0]);
    paramView.setTranslationY(ubq.a(this.a)[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubr
 * JD-Core Version:    0.7.0.1
 */