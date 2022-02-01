import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMultiRcmdDisLike;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class yhs
  implements bkzq
{
  yhs(yhn paramyhn, bkzi parambkzi, QQUserUIItem paramQQUserUIItem, StoryVideoItem paramStoryVideoItem, HotRecommendFeedItem paramHotRecommendFeedItem) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.e();
    switch (paramInt)
    {
    default: 
      ykv.a("home_page", "multi_press_clk", 0, 5, new String[0]);
    case 0: 
    case 1: 
      Object localObject;
      do
      {
        return;
        localObject = yhn.a(this.jdField_a_of_type_Yhn);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {}
        for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid)
        {
          weg.a((Context)localObject, 4, paramView);
          ykv.a("home_page", "multi_press_clk", 0, 1, new String[0]);
          return;
        }
        if (!NetworkUtil.isNetworkAvailable(yhn.f(this.jdField_a_of_type_Yhn)))
        {
          QQToast.a(yhn.a(this.jdField_a_of_type_Yhn), 1, anvx.a(2131703929), 0).a();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
      int i = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe;
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        paramInt = 0;
        paramView.isSubscribe = paramInt;
        yhn.a(this.jdField_a_of_type_Yhn, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
        paramView = (vzu)wzk.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (i != 1) {
          break label256;
        }
        paramInt = 1;
        label221:
        paramView.a(1, (String)localObject, paramInt, 1);
        if (i != 1) {
          break label261;
        }
      }
      label256:
      label261:
      for (paramInt = 3;; paramInt = 2)
      {
        ykv.a("home_page", "multi_press_clk", 0, paramInt, new String[0]);
        return;
        paramInt = 1;
        break;
        paramInt = 0;
        break label221;
      }
    }
    if (!NetworkUtil.isNetworkAvailable(yhn.g(this.jdField_a_of_type_Yhn)))
    {
      QQToast.a(yhn.a(this.jdField_a_of_type_Yhn), 1, anvx.a(2131703932), 0).a();
      return;
    }
    paramView = new qqstory_service.ReqMultiRcmdDisLike();
    paramView.vid.set(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    ntb.a(wzk.a(), new yht(this), paramView.toByteArray(), weg.a("StorySvc.multi_rcmd_dis_like"));
    ykv.a("home_page", "multi_press_clk", 0, 4, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhs
 * JD-Core Version:    0.7.0.1
 */