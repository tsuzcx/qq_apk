import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMultiRcmdDisLike;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class yrm
  implements bliz
{
  yrm(yrh paramyrh, blir paramblir, QQUserUIItem paramQQUserUIItem, StoryVideoItem paramStoryVideoItem, HotRecommendFeedItem paramHotRecommendFeedItem) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Blir.e();
    switch (paramInt)
    {
    default: 
      yup.a("home_page", "multi_press_clk", 0, 5, new String[0]);
    case 0: 
    case 1: 
      Object localObject;
      do
      {
        return;
        localObject = yrh.a(this.jdField_a_of_type_Yrh);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {}
        for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid)
        {
          wnu.a((Context)localObject, 4, paramView);
          yup.a("home_page", "multi_press_clk", 0, 1, new String[0]);
          return;
        }
        if (!bhnv.g(yrh.f(this.jdField_a_of_type_Yrh)))
        {
          QQToast.a(yrh.a(this.jdField_a_of_type_Yrh), 1, anzj.a(2131703348), 0).a();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
      int i = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe;
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        paramInt = 0;
        paramView.isSubscribe = paramInt;
        yrh.a(this.jdField_a_of_type_Yrh, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
        paramView = (wja)xiz.a().a(98);
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
        yup.a("home_page", "multi_press_clk", 0, paramInt, new String[0]);
        return;
        paramInt = 1;
        break;
        label255:
        paramInt = 0;
        break label220;
      }
    }
    if (!bhnv.g(yrh.g(this.jdField_a_of_type_Yrh)))
    {
      QQToast.a(yrh.a(this.jdField_a_of_type_Yrh), 1, anzj.a(2131703351), 0).a();
      return;
    }
    paramView = new qqstory_service.ReqMultiRcmdDisLike();
    paramView.vid.set(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    nkm.a(xiz.a(), new yrn(this), paramView.toByteArray(), wnu.a("StorySvc.multi_rcmd_dis_like"));
    yup.a("home_page", "multi_press_clk", 0, 4, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrm
 * JD-Core Version:    0.7.0.1
 */