import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

public class ltz
  implements ViewFactory.FoundClickableViewListener
{
  ltz(lty paramlty, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (lty.a(this.this$0) != null)
    {
      paramViewBase.setOnClickListener(new lua(this));
      return;
    }
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1038: 
      paramViewBase.setOnClickListener(new lud(this));
      return;
    case 1120: 
      paramViewBase.setOnClickListener(new lub(this));
      return;
    case 1040: 
      paramViewBase.setOnClickListener(new luc(this));
      return;
    }
    paramViewBase.setOnClickListener(new lue(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltz
 * JD-Core Version:    0.7.0.1
 */