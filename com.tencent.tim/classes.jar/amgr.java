import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class amgr
  implements View.OnLayoutChangeListener
{
  public amgr(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt2 < paramInt6) && (this.this$0.GF != null))
    {
      paramInt1 = SignatureHistoryFragment.a(this.this$0, this.this$0.GF);
      paramInt3 = this.this$0.GF.getHeight();
      if (paramInt1 + paramInt3 > paramInt2) {
        SignatureHistoryFragment.a(this.this$0, paramInt1, paramInt3, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amgr
 * JD-Core Version:    0.7.0.1
 */