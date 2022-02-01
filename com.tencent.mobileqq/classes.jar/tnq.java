import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class tnq
  implements ViewFactory.FoundClickableViewListener
{
  tnq(tnp paramtnp, BaseData paramBaseData, Context paramContext) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    paramViewBase.setOnClickListener(new tnr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tnq
 * JD-Core Version:    0.7.0.1
 */