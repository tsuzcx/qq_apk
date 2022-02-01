import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zbb
  implements View.OnClickListener
{
  public zbb(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void onClick(View paramView)
  {
    vnj.x(PublicAccountFragment.a(this.this$0), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbb
 * JD-Core Version:    0.7.0.1
 */