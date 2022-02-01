import android.view.View;
import android.view.View.OnLayoutChangeListener;

class nwx
  implements View.OnLayoutChangeListener
{
  nwx(nww paramnww) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView.removeOnLayoutChangeListener(this);
    paramView.setTranslationX(nww.a(this.this$0)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwx
 * JD-Core Version:    0.7.0.1
 */