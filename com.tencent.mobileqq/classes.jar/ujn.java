import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class ujn
  implements tsn
{
  ujn(ujm paramujm) {}
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!paramStoryVideoItem.isBasicInfoOK()) || (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) || (paramStoryVideoItem.mVideoIndex == 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujn
 * JD-Core Version:    0.7.0.1
 */