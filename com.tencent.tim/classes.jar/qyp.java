import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMultiRcmdDisLike;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class qyp
  implements ausj.a
{
  qyp(qyk paramqyk, ausj paramausj, QQUserUIItem paramQQUserUIItem, StoryVideoItem paramStoryVideoItem, HotRecommendFeedItem paramHotRecommendFeedItem) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.superDismiss();
    switch (paramInt)
    {
    default: 
      rar.a("home_page", "multi_press_clk", 0, 5, new String[0]);
    case 0: 
    case 1: 
      Object localObject;
      do
      {
        return;
        localObject = qyk.a(this.this$0);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {}
        for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramView = this.val$storyVideoItem.mOwnerUid)
        {
          ppf.f((Context)localObject, 4, paramView);
          rar.a("home_page", "multi_press_clk", 0, 1, new String[0]);
          return;
        }
        if (!aqiw.isNetworkAvailable(qyk.f(this.this$0)))
        {
          QQToast.a(qyk.a(this.this$0), 1, acfp.m(2131706172), 0).show();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
      int i = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe;
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        paramInt = 0;
        paramView.isSubscribe = paramInt;
        qyk.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
        paramView = (pma)qem.getQQAppInterface().getBusinessHandler(98);
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (i != 1) {
          break label255;
        }
        paramInt = 1;
        label220:
        paramView.b(1, (String)localObject, paramInt, 1);
        if (i != 1) {
          break label260;
        }
      }
      label260:
      for (paramInt = 3;; paramInt = 2)
      {
        rar.a("home_page", "multi_press_clk", 0, paramInt, new String[0]);
        return;
        paramInt = 1;
        break;
        label255:
        paramInt = 0;
        break label220;
      }
    }
    if (!aqiw.isNetworkAvailable(qyk.g(this.this$0)))
    {
      QQToast.a(qyk.a(this.this$0), 1, acfp.m(2131706175), 0).show();
      return;
    }
    paramView = new qqstory_service.ReqMultiRcmdDisLike();
    paramView.vid.set(this.val$storyVideoItem.mVid);
    jnm.a(qem.getQQAppInterface(), new qyq(this), paramView.toByteArray(), ppf.fQ("StorySvc.multi_rcmd_dis_like"));
    rar.a("home_page", "multi_press_clk", 0, 4, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qyp
 * JD-Core Version:    0.7.0.1
 */