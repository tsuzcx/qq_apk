import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;

public class wqs
  extends wpv
{
  public wqs(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, wpc paramwpc)
  {
    return SubscribePersonalDetailFragment.a(this.a);
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(wpn paramwpn)
  {
    if ((paramwpn.c()) || (paramwpn.d()))
    {
      if ((SubscribePersonalDetailFragment.a(this.a) != null) && (SubscribePersonalDetailFragment.a(this.a).b() == 1))
      {
        SubDraftChangeEvent localSubDraftChangeEvent = new SubDraftChangeEvent();
        wpw.a().a(localSubDraftChangeEvent);
      }
      SubscribePersonalDetailFragment.a(this.a, paramwpn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqs
 * JD-Core Version:    0.7.0.1
 */