import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMultiRcmdDisLike;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;

class vbi
  implements bfoq
{
  vbi(vbd paramvbd, bfol parambfol, QQUserUIItem paramQQUserUIItem, StoryVideoItem paramStoryVideoItem, HotRecommendFeedItem paramHotRecommendFeedItem) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfol.e();
    switch (paramInt)
    {
    default: 
      vel.a("home_page", "multi_press_clk", 0, 5, new String[0]);
    case 0: 
    case 1: 
      Object localObject;
      do
      {
        return;
        localObject = vbd.a(this.jdField_a_of_type_Vbd);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {}
        for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;; paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid)
        {
          sxp.a((Context)localObject, 4, paramView);
          vel.a("home_page", "multi_press_clk", 0, 1, new String[0]);
          return;
        }
        if (!bbev.g(vbd.f(this.jdField_a_of_type_Vbd)))
        {
          bcpw.a(vbd.a(this.jdField_a_of_type_Vbd), 1, ajyc.a(2131704449), 0).a();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
      int i = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe;
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        paramInt = 0;
        paramView.isSubscribe = paramInt;
        vbd.a(this.jdField_a_of_type_Vbd, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
        paramView = (ssv)tsu.a().a(98);
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
        vel.a("home_page", "multi_press_clk", 0, paramInt, new String[0]);
        return;
        paramInt = 1;
        break;
        label255:
        paramInt = 0;
        break label220;
      }
    }
    if (!bbev.g(vbd.g(this.jdField_a_of_type_Vbd)))
    {
      bcpw.a(vbd.a(this.jdField_a_of_type_Vbd), 1, ajyc.a(2131704452), 0).a();
      return;
    }
    paramView = new qqstory_service.ReqMultiRcmdDisLike();
    paramView.vid.set(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    mxi.a(tsu.a(), new vbj(this), paramView.toByteArray(), sxp.a("StorySvc.multi_rcmd_dis_like"));
    vel.a("home_page", "multi_press_clk", 0, 4, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbi
 * JD-Core Version:    0.7.0.1
 */