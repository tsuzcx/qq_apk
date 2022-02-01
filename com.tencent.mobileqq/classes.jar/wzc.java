import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class wzc
  implements wzg
{
  wzc(wzb paramwzb) {}
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true)) || (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) || (paramStoryVideoItem.mVideoIndex == 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzc
 * JD-Core Version:    0.7.0.1
 */