import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;

public class wqp
  extends wps
{
  public wqp(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, woz paramwoz)
  {
    return SubscribePersonalDetailFragment.a(this.a);
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(wpk paramwpk)
  {
    if ((paramwpk.c()) || (paramwpk.d()))
    {
      if ((SubscribePersonalDetailFragment.a(this.a) != null) && (SubscribePersonalDetailFragment.a(this.a).b() == 1))
      {
        SubDraftChangeEvent localSubDraftChangeEvent = new SubDraftChangeEvent();
        wpt.a().a(localSubDraftChangeEvent);
      }
      SubscribePersonalDetailFragment.a(this.a, paramwpk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqp
 * JD-Core Version:    0.7.0.1
 */