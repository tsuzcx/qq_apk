import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahsr
  implements View.OnClickListener
{
  public ahsr(QQGamePubAccountFragment paramQQGamePubAccountFragment, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    this.bK.removeView(QQGamePubAccountFragment.b(this.this$0));
    QQGamePubAccountFragment.a(this.this$0, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsr
 * JD-Core Version:    0.7.0.1
 */