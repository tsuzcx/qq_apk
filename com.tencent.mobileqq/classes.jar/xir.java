import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class xir
  implements xiv
{
  xir(xiq paramxiq) {}
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true)) || (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) || (paramStoryVideoItem.mVideoIndex == 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xir
 * JD-Core Version:    0.7.0.1
 */