import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

final class qet
  implements ausj.a
{
  qet(StoryVideoItem paramStoryVideoItem, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramView = "16384";
      QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).b(this.h.mOwnerUid);
      if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.qq))) {
        new pxx().a(localQQUserUIItem.qq, localQQUserUIItem.isFriend(), this.h.mVid, paramView, this.h.getVideoUrl());
      }
      break;
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      paramView = "2";
      break;
      paramView = "1";
      break;
      paramView = "4";
      break;
      ram.w("Q.qqstory.player.PlayModeUtils", "report video error because evil uin is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qet
 * JD-Core Version:    0.7.0.1
 */