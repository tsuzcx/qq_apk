import android.view.View;
import android.view.View.OnLayoutChangeListener;

class jcd
  implements View.OnLayoutChangeListener
{
  jcd(jcc paramjcc) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt4 - paramInt2 != paramInt8 - paramInt6) {
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcd
 * JD-Core Version:    0.7.0.1
 */