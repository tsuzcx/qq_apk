import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.3.2.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import org.json.JSONObject;

public class lub
  implements ViewBase.OnClickListener
{
  lub(ltz paramltz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    kvx.a(this.a.b, paramViewBase);
    kxm.aJ(lty.a(this.a.this$0).getContext(), paramViewBase.getEventAttachedData());
    paramViewBase = (String)this.a.b.getDataAttribute(paramViewBase.getViewId(), "topic_id");
    this.a.b.getData().remove("reddot_num");
    this.a.b.refreshData();
    lty.a(this.a.this$0, new RecycleViewAdapterHelper.3.2.1(this));
    lbz.a().mW(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lub
 * JD-Core Version:    0.7.0.1
 */