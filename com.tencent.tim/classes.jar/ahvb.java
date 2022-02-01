import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

public class ahvb
  implements View.OnClickListener
{
  public ahvb(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    QQGameFeedWebFragment.a(this.this$0).setVisibility(8);
    if (QQGameFeedWebFragment.a(this.this$0) != null) {
      QQGameFeedWebFragment.a(this.this$0).setCurrentItem(0);
    }
    String str = (String)QQGameFeedWebFragment.a(this.this$0).getTag();
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1), str);
    localHashMap.put(Integer.valueOf(2), "");
    localHashMap.put(Integer.valueOf(4), "20");
    localHashMap.put(Integer.valueOf(24), "1");
    tbb.a(abmt.getAppInterface(), "769", "205031", "", "76901", "1", "160", localHashMap);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvb
 * JD-Core Version:    0.7.0.1
 */