import android.view.View;
import android.view.View.OnLayoutChangeListener;

class trx
  implements View.OnLayoutChangeListener
{
  trx(trw paramtrw) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView.removeOnLayoutChangeListener(this);
    paramView.setTranslationX(trw.a(this.a)[0]);
    paramView.setTranslationY(trw.a(this.a)[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trx
 * JD-Core Version:    0.7.0.1
 */