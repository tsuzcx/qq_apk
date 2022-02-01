import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

final class xjg
  implements bliz
{
  xjg(StoryVideoItem paramStoryVideoItem, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramView = "16384";
      QQUserUIItem localQQUserUIItem = ((wtt)wth.a(2)).b(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.qq))) {
        new xbd().a(localQQUserUIItem.qq, localQQUserUIItem.isFriend(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramView, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoUrl());
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      paramView = "2";
      break;
      paramView = "1";
      break;
      paramView = "4";
      break;
      yuk.d("Q.qqstory.player.PlayModeUtils", "report video error because evil uin is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjg
 * JD-Core Version:    0.7.0.1
 */