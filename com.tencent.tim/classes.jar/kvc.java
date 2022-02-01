import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class kvc
  implements ViewFactory.FoundClickableViewListener
{
  kvc(kva paramkva) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null)) {
      return;
    }
    paramViewBase.setOnClickListener(new kvd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvc
 * JD-Core Version:    0.7.0.1
 */