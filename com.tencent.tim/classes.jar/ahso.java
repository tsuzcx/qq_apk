import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahso
  implements View.OnClickListener
{
  public ahso(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = "";
    if (this.this$0.a != null) {
      localObject = this.this$0.en(this.this$0.a.getCurrentItem());
    }
    tbb.a(abmt.getAppInterface(), "769", "205037", (String)localObject, "76901", "1", "160", new String[] { this.this$0.wC(), "", "20" });
    localObject = new Intent(BaseApplication.getContext(), GameCenterActivity.class);
    ((Intent)localObject).putExtra("url", "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393");
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_games");
    paramView.getContext().startActivity((Intent)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahso
 * JD-Core Version:    0.7.0.1
 */