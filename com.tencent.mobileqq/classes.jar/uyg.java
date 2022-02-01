import UserGrowth.stNotificationRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uyg
  implements View.OnClickListener
{
  public uyg(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    if (WSRecommendFragment.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = WSRecommendFragment.a(this.a).a();
      String str1 = WSRecommendFragment.a(this.a, WSRecommendFragment.a(this.a));
      String str2 = WSRecommendFragment.a(this.a).h5Url;
      vmp.c("WSRecommendFragment", "schemeUrl:" + str1 + ", h5Url:" + str2);
      vnd.a(this.a.jdField_a_of_type_AndroidContentContext, str1, str2, "", i, this.a.jdField_a_of_type_Vnn);
      vkf.a(112, i, WSRecommendFragment.a(this.a).cid);
      vmp.a("weishi-808", "notification jumpUrl" + WSRecommendFragment.a(this.a).jump_url);
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyg
 * JD-Core Version:    0.7.0.1
 */