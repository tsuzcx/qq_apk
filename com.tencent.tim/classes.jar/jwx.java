import android.os.Handler;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.b;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;

public class jwx
  implements VerticalPagerView.b
{
  public jwx(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void J(boolean paramBoolean, int paramInt)
  {
    PublicAccountAdvertisementActivity.b(this.this$0, paramBoolean);
  }
  
  public void a(VerticalPagerView paramVerticalPagerView, View paramView, int paramInt)
  {
    paramVerticalPagerView = this.this$0;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      PublicAccountAdvertisementActivity.c(paramVerticalPagerView, bool);
      if (!PublicAccountAdvertisementActivity.c(this.this$0)) {
        break;
      }
      PublicAccountAdvertisementActivity.a(this.this$0).lC(true);
      PublicAccountAdvertisementActivity.a(this.this$0).onResume();
      PublicAccountAdvertisementActivity.e(this.this$0);
      PublicAccountAdvertisementActivity.a(this.this$0, System.currentTimeMillis());
      if (PublicAccountAdvertisementActivity.a(this.this$0) > PublicAccountAdvertisementActivity.b(this.this$0)) {
        PublicAccountAdvertisementActivity.b(this.this$0, PublicAccountAdvertisementActivity.c(this.this$0) + (PublicAccountAdvertisementActivity.a(this.this$0) - PublicAccountAdvertisementActivity.b(this.this$0)));
      }
      paramVerticalPagerView = PublicAccountAdvertisementActivity.a(this.this$0);
      PublicAccountAdvertisementActivity.a(this.this$0);
      paramVerticalPagerView.setMode(1);
      if (!PublicAccountAdvertisementActivity.a(this.this$0).yI())
      {
        PublicAccountAdvertisementActivity.a(this.this$0).setVisibility(8);
        PublicAccountAdvertisementActivity.a(this.this$0).lB(false);
      }
      return;
    }
    if (PublicAccountAdvertisementActivity.d(this.this$0))
    {
      PublicAccountAdvertisementActivity.d(this.this$0, false);
      if (this.this$0.yy()) {
        this.this$0.mUIHandler.sendEmptyMessage(5);
      }
    }
    PublicAccountAdvertisementActivity.c(this.this$0);
    PublicAccountAdvertisementActivity.a(this.this$0).lC(false);
    PublicAccountAdvertisementActivity.a(this.this$0).onPause();
    PublicAccountAdvertisementActivity.a(this.this$0).aBb();
    paramVerticalPagerView = PublicAccountAdvertisementActivity.a(this.this$0);
    PublicAccountAdvertisementActivity.a(this.this$0);
    paramVerticalPagerView.setMode(2);
    PublicAccountAdvertisementActivity.a(this.this$0).setVisibility(0);
    PublicAccountAdvertisementActivity.c(this.this$0, System.currentTimeMillis());
    anot.c(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.this$0).a.UD, "0X8008F68", "0X8008F68", 0, 0, PublicAccountAdvertisementActivity.a(this.this$0).a.hT, PublicAccountAdvertisementActivity.a(this.this$0) + "", "" + PublicAccountAdvertisementActivity.a(this.this$0).a.jumpType, PublicAccountAdvertisementActivity.a(this.this$0).a.mNickName);
    paramVerticalPagerView = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramVerticalPagerView instanceof ToolAppRuntime)) {
      aibd.a().a(PublicAccountAdvertisementActivity.a(this.this$0), this.this$0, (AppInterface)((ToolAppRuntime)paramVerticalPagerView).onGetSubRuntime("imax"));
    }
    PublicAccountAdvertisementActivity.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwx
 * JD-Core Version:    0.7.0.1
 */