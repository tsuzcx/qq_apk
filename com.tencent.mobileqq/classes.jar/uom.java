import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMultiRcmdDisLike;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;

class uom
  implements begw
{
  uom(uoh paramuoh, begr parambegr, QQUserUIItem paramQQUserUIItem, StoryVideoItem paramStoryVideoItem, HotRecommendFeedItem paramHotRecommendFeedItem) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Begr.e();
    switch (paramInt)
    {
    default: 
      urp.a("home_page", "multi_press_clk", 0, 5, new String[0]);
    case 0: 
    case 1: 
      Object localObject;
      do
      {
        return;
        localObject = uoh.a(this.jdField_a_of_type_Uoh);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {}
        for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid)
        {
          skt.a((Context)localObject, 4, paramView);
          urp.a("home_page", "multi_press_clk", 0, 1, new String[0]);
          return;
        }
        if (!badq.g(uoh.f(this.jdField_a_of_type_Uoh)))
        {
          bbmy.a(uoh.a(this.jdField_a_of_type_Uoh), 1, ajjy.a(2131638664), 0).a();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
      int i = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe;
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        paramInt = 0;
        paramView.isSubscribe = paramInt;
        uoh.a(this.jdField_a_of_type_Uoh, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
        paramView = (sfz)tfy.a().a(98);
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (i != 1) {
          break label255;
        }
        paramInt = 1;
        label220:
        paramView.a(1, (String)localObject, paramInt, 1);
        if (i != 1) {
          break label260;
        }
      }
      label260:
      for (paramInt = 3;; paramInt = 2)
      {
        urp.a("home_page", "multi_press_clk", 0, paramInt, new String[0]);
        return;
        paramInt = 1;
        break;
        label255:
        paramInt = 0;
        break label220;
      }
    }
    if (!badq.g(uoh.g(this.jdField_a_of_type_Uoh)))
    {
      bbmy.a(uoh.a(this.jdField_a_of_type_Uoh), 1, ajjy.a(2131638667), 0).a();
      return;
    }
    paramView = new qqstory_service.ReqMultiRcmdDisLike();
    paramView.vid.set(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    mmj.a(tfy.a(), new uon(this), paramView.toByteArray(), skt.a("StorySvc.multi_rcmd_dis_like"));
    urp.a("home_page", "multi_press_clk", 0, 4, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uom
 * JD-Core Version:    0.7.0.1
 */