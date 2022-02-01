import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;

public class set
  extends ryh
{
  public set(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    return SubscribePersonalDetailFragment.a(this.this$0);
  }
  
  public void loadData(rxt paramrxt)
  {
    if ((paramrxt.Mg()) || (paramrxt.Mh()))
    {
      if ((SubscribePersonalDetailFragment.a(this.this$0) != null) && (SubscribePersonalDetailFragment.a(this.this$0).getCurrentIndex() == 1))
      {
        SubDraftChangeEvent localSubDraftChangeEvent = new SubDraftChangeEvent();
        rwv.a().a(localSubDraftChangeEvent);
      }
      SubscribePersonalDetailFragment.a(this.this$0, paramrxt);
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     set
 * JD-Core Version:    0.7.0.1
 */