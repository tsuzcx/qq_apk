import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMultiRcmdDisLike;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class wpx
  implements bhqd
{
  wpx(wps paramwps, bhpy parambhpy, QQUserUIItem paramQQUserUIItem, StoryVideoItem paramStoryVideoItem, HotRecommendFeedItem paramHotRecommendFeedItem) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhpy.e();
    switch (paramInt)
    {
    default: 
      wta.a("home_page", "multi_press_clk", 0, 5, new String[0]);
    case 0: 
    case 1: 
      Object localObject;
      do
      {
        return;
        localObject = wps.a(this.jdField_a_of_type_Wps);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {}
        for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid)
        {
          ume.a((Context)localObject, 4, paramView);
          wta.a("home_page", "multi_press_clk", 0, 1, new String[0]);
          return;
        }
        if (!bdee.g(wps.f(this.jdField_a_of_type_Wps)))
        {
          QQToast.a(wps.a(this.jdField_a_of_type_Wps), 1, alpo.a(2131704832), 0).a();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
      int i = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe;
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        paramInt = 0;
        paramView.isSubscribe = paramInt;
        wps.a(this.jdField_a_of_type_Wps, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
        paramView = (uhk)vhj.a().a(98);
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
        wta.a("home_page", "multi_press_clk", 0, paramInt, new String[0]);
        return;
        paramInt = 1;
        break;
        label255:
        paramInt = 0;
        break label220;
      }
    }
    if (!bdee.g(wps.g(this.jdField_a_of_type_Wps)))
    {
      QQToast.a(wps.a(this.jdField_a_of_type_Wps), 1, alpo.a(2131704835), 0).a();
      return;
    }
    paramView = new qqstory_service.ReqMultiRcmdDisLike();
    paramView.vid.set(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    mzy.a(vhj.a(), new wpy(this), paramView.toByteArray(), ume.a("StorySvc.multi_rcmd_dis_like"));
    wta.a("home_page", "multi_press_clk", 0, 4, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpx
 * JD-Core Version:    0.7.0.1
 */