import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;

public class zxo
  extends zpo
{
  public zxo(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zou paramzou)
  {
    return SubscribePersonalDetailFragment.a(this.a);
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(zoz paramzoz)
  {
    if ((paramzoz.c()) || (paramzoz.d()))
    {
      if ((SubscribePersonalDetailFragment.a(this.a) != null) && (SubscribePersonalDetailFragment.a(this.a).c() == 1))
      {
        SubDraftChangeEvent localSubDraftChangeEvent = new SubDraftChangeEvent();
        SimpleEventBus.getInstance().dispatchEvent(localSubDraftChangeEvent);
      }
      SubscribePersonalDetailFragment.a(this.a, paramzoz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxo
 * JD-Core Version:    0.7.0.1
 */