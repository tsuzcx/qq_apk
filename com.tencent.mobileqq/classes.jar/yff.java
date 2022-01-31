import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;

public class yff
  extends yei
{
  public yff(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, ydp paramydp)
  {
    return SubscribePersonalDetailFragment.a(this.a);
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(yeb paramyeb)
  {
    if ((paramyeb.c()) || (paramyeb.d()))
    {
      if ((SubscribePersonalDetailFragment.a(this.a) != null) && (SubscribePersonalDetailFragment.a(this.a).b() == 1))
      {
        SubDraftChangeEvent localSubDraftChangeEvent = new SubDraftChangeEvent();
        yej.a().a(localSubDraftChangeEvent);
      }
      SubscribePersonalDetailFragment.a(this.a, paramyeb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yff
 * JD-Core Version:    0.7.0.1
 */