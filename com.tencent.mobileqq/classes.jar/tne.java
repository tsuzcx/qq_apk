import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class tne
  implements ViewFactory.FoundClickableViewListener
{
  tne(tnd paramtnd, Context paramContext) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    paramViewBase.setOnClickListener(new tnf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tne
 * JD-Core Version:    0.7.0.1
 */