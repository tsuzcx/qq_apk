import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahsq
  implements View.OnClickListener
{
  public ahsq(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void onClick(View paramView)
  {
    if (QQGamePubAccountFragment.a(this.this$0) != null)
    {
      QQGamePubAccountFragment.a(this.this$0).scrollToPosition(0);
      QQGamePubAccountFragment.a(this.this$0).setVisibility(8);
      if (this.this$0.a != null) {
        this.this$0.a.setCurrentItem(0);
      }
    }
    String str = (String)QQGamePubAccountFragment.a(this.this$0).getTag();
    tbb.a(abmt.getAppInterface(), "769", "205031", "", "76901", "1", "160", new String[] { str, "", "20" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsq
 * JD-Core Version:    0.7.0.1
 */