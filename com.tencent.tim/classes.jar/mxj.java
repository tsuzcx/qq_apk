import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView.a;

class mxj
  implements KandianUrlImageView.a
{
  mxj(mxi parammxi, mtg.l paraml) {}
  
  public void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if ((paramInt == 0) && (this.e.bx.getVisibility() == 0)) {
      mxi.a(this.b).resumeAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxj
 * JD-Core Version:    0.7.0.1
 */