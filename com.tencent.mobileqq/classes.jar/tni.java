import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class tni
  implements ViewFactory.FoundClickableViewListener
{
  tni(tnh paramtnh, BaseData paramBaseData, Context paramContext) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    paramViewBase.setOnClickListener(new tnj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tni
 * JD-Core Version:    0.7.0.1
 */